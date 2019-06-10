package com.envs.oapi.messages;

public class LoginRequest extends BasicRequest {
    private String userName;
    private String sessionToken;
    private String casinoName;
    private String mode;
    private String clienttype;
    private String clientPlatform;
    private String lang;
    private String version;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public void setCasinoName(String casinoName) {
        this.casinoName = casinoName;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setClienttype(String clienttype) {
        this.clienttype = clienttype;
    }

    public void setClientPlatform(String clientPlatform) {
        this.clientPlatform = clientPlatform;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
