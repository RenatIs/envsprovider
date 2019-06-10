package com.envs.oapi;

import com.envs.middle.Environment;
import com.envs.middle.User;
import com.envs.oapi.messages.*;
import com.google.gson.Gson;

public class RFabric {
    Gson gson;
    private Environment environment;
    private User user;

    private BasicResponse loginResponse;
    private BasicResponse userInfo;
    private LimitsResponse limitsResponse;

    private BasicRequest someBasicRequest;
    private LoginRequest loginRequest;
    private LimitsRequest limitsRequest;


    public RFabric(Environment environment, User user) {
        this.environment = environment;
        this.user = user;

        gson = new Gson();
    }
    //--------------REQUESTS as STRING

    public String getRequestAsMessage(BasicRequest request) {
        return gson.toJson(request);
    }

    //--------------REQUESTS

    public LoginRequest getLoginRequest(String token) {
        loginRequest = new LoginRequest();
        loginRequest.setCasinoName(environment.getCasinoName());
        loginRequest.setUserName(user.getUserName());
        loginRequest.setSessionToken(token);
        loginRequest.setClientPlatform("mobile");
        loginRequest.setClienttype("casino");
        loginRequest.setLang("EN");
        loginRequest.setMode("REAL_MONEY");
        loginRequest.setVersion("87");
        loginRequest.setId(10001);
        return loginRequest;
    }

    //--------------RESPONSES

    public BasicResponse getResponse(String message) {
        return gson.fromJson(message, BasicResponse.class);
    }

    public BasicResponse getLoginResponse(String message) {
        return getResponse(message);
    }
}
