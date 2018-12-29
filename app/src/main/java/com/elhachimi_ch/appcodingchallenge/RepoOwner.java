package com.elhachimi_ch.appcodingchallenge;

import com.google.gson.annotations.SerializedName;

class RepoOwner {
    @SerializedName("login")
    private String ownerName;
    @SerializedName("avatar_url")
    private String ownerImageUrl;

    public RepoOwner(String ownerName, String ownerImageUrl) {
        this.ownerName = ownerName;
        this.ownerImageUrl = ownerImageUrl;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerImageUrl() {
        return ownerImageUrl;
    }

    public void setOwnerImageUrl(String ownerImageUrl) {
        this.ownerImageUrl = ownerImageUrl;
    }
}
