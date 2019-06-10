package com.envs.oapi;

import com.envs.Context;
import com.envs.middle.User;
import com.envs.oapi.messages.BasicRequest;
import com.envs.oapi.messages.BasicResponse;
import com.envs.pas.PASConnector;
import com.google.gson.Gson;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OAPIController {
    OAPINetwork network;
    RFabric fabric;
    private Context context;
    private String token;
    private int shouldBeDeletedIterator = 0;

    public OAPIController(Context context) {
        this.context = context;

        network = new OAPINetwork(this.context.getEnvironment());
        fabric = new RFabric(context.getEnvironment(), context.getUsers().get(shouldBeDeletedIterator));
    }

    public boolean verifyThatUserIsAvailable(User user) {
        return login(user);
    }

    public boolean createUser() {
        return false;
    }

    private boolean login(User user) {
        PASConnector pas = new PASConnector();
        token = pas.loginAndGetToken(context.getEnvironment(), user);

        network.sendMessage(fabric.getRequestAsMessage(fabric.getLoginRequest(token)));

        List<BasicResponse> responses = IntStream.rangeClosed(0, 14)
                .mapToObj(i -> fabric.getResponse(checkMessage(network.getMessage())))
                .collect(Collectors.toList());
        return responses.stream()
                .anyMatch(r -> 10002 == r.getID());
    }


    private String checkMessage(String message) {
        if (message != null) {
            BasicResponse r = new Gson().fromJson(message, BasicResponse.class);
            if (17 == r.getID()) {
                BasicRequest pingPongResponseButAsRequest = new BasicRequest();
                pingPongResponseButAsRequest.setId(16);
                network.sendMessage(fabric.getRequestAsMessage(pingPongResponseButAsRequest));
                return "";
            }
        }
        return message;
    }
}
