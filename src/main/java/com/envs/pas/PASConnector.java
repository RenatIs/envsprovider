package com.envs.pas;

import com.envs.middle.Environment;
import com.envs.middle.User;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PASConnector {
    private String queryParams;
    private String token;


    public String loginAndGetToken(Environment e, User user) {
        System.out.println("Log in to PAS...");

        baseURI = e.getPasAddress() + "/Login.php?";
        queryParams = "casinoname=" + e.getCasinoName() +
                "&clientType=casino" + "&clientVersion=87" + "&languageCode=EN" + "&clientPlatform=mobile" +
                "&realMode=1" + "&responseType=json" + "&deliveryPlatform=Native";

        this.token = given()
                .param("username", user.getUserName())
                .param("password", user.getPassword())
                .post(baseURI + queryParams)
                .getCookies()
                .get("pas[" + e.getCasinoName() + "][real][token]");
        return token;
    }

    public String getToken() {
        return token;
    }
}
