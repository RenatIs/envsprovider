package com.envs.oapi.messages;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Optional;

public class LimitsResponseData {
    @SerializedName("gameGroup")
    private String gameGroup;

    @SerializedName("coinSizes")
    private List<Integer> coinSizes;

    @SerializedName("rouletteLimits")
    private List rouletteLimits;

    @SerializedName("minBet")
    private long minBet;

    @SerializedName("maxBet")
    private long maxBet;

    @SerializedName("minPosBet")
    private long minPosBet;

    @SerializedName("maxPosBet")
    private long maxPosBet;

    public boolean hasLimits() {
        if (getCoinSizes() != null && getCoinSizes().size() > 0) return true;
        else return getRouletteLimits() != null && getRouletteLimits().size() > 0;
    }

    public List getLimits() {
        return Optional.ofNullable(getCoinSizes()).orElse(getRouletteLimits());
    }

    private List<Integer> getCoinSizes() {
        return coinSizes;
    }

    private List getRouletteLimits() {
        return rouletteLimits;
    }

    public String getGameGroup() {
        return gameGroup;
    }

    public long getMinBet() {
        return minBet;
    }

    public long getMaxBet() {
        return maxBet;
    }

    public long getMinPosBet() {
        return minPosBet;
    }

    public long getMaxPosBet() {
        return maxPosBet;
    }
}
