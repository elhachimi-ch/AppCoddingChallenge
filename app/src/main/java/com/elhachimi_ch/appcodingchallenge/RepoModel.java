package com.elhachimi_ch.appcodingchallenge;

import com.google.gson.annotations.SerializedName;



public class RepoModel {


    @SerializedName("owner")
    private RepoOwner owner;
    @SerializedName("name")
    private String repoName;
    @SerializedName("description")
    private String repoDescription;
    @SerializedName("stargazers_count")
    private int starsNumber;

    public RepoModel(String repoName, String repoDescription, RepoOwner owner, int starsNumber) {
        this.repoName = repoName;
        this.repoDescription = repoDescription;
        this.starsNumber = starsNumber;
        this.owner = owner;
    }

    public RepoOwner getOwner() {
        return owner;
    }

    public void setOwner(RepoOwner owner) {
        this.owner = owner;
    }

    public String getRepoDescription() {
        return repoDescription;
    }

    public String getRepoName() {
        return repoName;
    }


    public int getStarsNumber() {
        return starsNumber;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public void setRepoDescription(String repoDescription) {
        this.repoDescription = repoDescription;
    }

    public void setStarsNumber(int starsNumber) {
        this.starsNumber = starsNumber;
    }


}
