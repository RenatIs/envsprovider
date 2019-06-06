package com.envs.oapi;

import com.envs.middle.Environment;
import com.envs.pas.PASConnector;

public class SocketConnector {
    private Environment e;
    private String token;

    public SocketConnector(Environment e) {
        this.e = e;
    }

    public void connect() {
        PASConnector pas = new PASConnector(e);
        token = pas.loginAndGetToken();

        System.out.println(token
                + e.getCasinoName()
                + e.getOapiAddress()
                + e.getPort()
        );
    }
}
