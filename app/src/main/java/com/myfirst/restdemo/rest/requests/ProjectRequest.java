package com.myfirst.restdemo.rest.requests;

import com.google.gson.annotations.SerializedName;

public class ProjectRequest {

    @SerializedName("name")
    public String name;

    @SerializedName("body")
    public String body;

    public ProjectRequest(String name, String body) {
        this.name = name;
        this.body = body;
    }
}
