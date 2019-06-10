package com.envs.oapi.messages;

import com.google.gson.annotations.SerializedName;

public class BasicResponse {
    @SerializedName("ID")
    private int id;

    public int getID() {
        return id;
    }
}
