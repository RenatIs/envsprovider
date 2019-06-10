package com.envs.oapi.messages;

import com.google.gson.annotations.SerializedName;

public class LimitsResponse extends BasicResponse {
    @SerializedName("data")
    private LimitsResponseData data;

    public LimitsResponseData getData() {
        return data;
    }
}
