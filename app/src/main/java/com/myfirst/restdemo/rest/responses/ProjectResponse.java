package com.myfirst.restdemo.rest.responses;

import com.google.gson.annotations.SerializedName;
import com.myfirst.restdemo.rest.models.Creator;

public class ProjectResponse {

    @SerializedName("owner_url")
    public String ownerUrl;
    @SerializedName("url")
    public String url;
    @SerializedName("html_url")
    public String htmlUrl;
    @SerializedName("columns_url")
    public String columnsUrl;
    @SerializedName("id")
    public int id;
    @SerializedName("node_id")
    public String nodeId;
    @SerializedName("name")
    public String name;
    @SerializedName("body")
    public Object body;
    @SerializedName("number")
    public int number;
    @SerializedName("state")
    public String state;
    @SerializedName("creator")
    public Creator creator;
    @SerializedName("created_at")
    public String createdAt;
    @SerializedName("updated_at")
    public String updatedAt;

    @Override
    public String toString() {
        return "ProjectResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
