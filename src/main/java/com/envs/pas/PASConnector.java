package com.envs.pas;

import com.envs.middle.Environment;

public class PASConnector {
    private Environment e;
    private String token;

    public PASConnector(Environment e) {
        this.e = e;
    }

    public String loginAndGetToken() {
        System.out.println(e.getPasAddress() + "/Login.php");
        return token;
    }
}
