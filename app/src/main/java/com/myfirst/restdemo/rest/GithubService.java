package com.myfirst.restdemo.rest;

import com.myfirst.restdemo.rest.models.Repo;
import com.myfirst.restdemo.rest.requests.ProjectRequest;
import com.myfirst.restdemo.rest.responses.ProjectResponse;

import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import static com.myfirst.restdemo.rest.GithubConfig.GITHUB_API_ADD_WRITER;
import static com.myfirst.restdemo.rest.GithubConfig.GITHUB_API_CREATE_PROJECT;
import static com.myfirst.restdemo.rest.GithubConfig.GITHUB_API_DELETE_OWNER;
import static com.myfirst.restdemo.rest.GithubConfig.GITHUB_API_PROJECT_TOPICS;
import static com.myfirst.restdemo.rest.GithubConfig.GITHUB_API_REPOS;

public interface GithubService {

    @GET(GITHUB_API_REPOS)
    Call<ArrayList<Repo>> listRepos(@Path("user") String user);

    @POST(GITHUB_API_CREATE_PROJECT)
//    Call<ProjectResponse> createProject(@Header("Accept") String accept, @Header("Authorization") String authorization, @Body ProjectRequest request);
    Call<ProjectResponse> createProject(@Body ProjectRequest request); // add headers using interceptors

    //todo add one function for each request method: POST, PUT, DELETE from https://docs.github.com/en/rest/overview/endpoints-available-for-github-apps

    @DELETE(GITHUB_API_DELETE_OWNER)
    Call<Void> deleteRepo(@Path("owner") String owner, @Path("repo") String repo );

    @PUT(GITHUB_API_ADD_WRITER)
    Call<ResponseBody> putWriter(@Header("Accept") String accept, @Path("project_id") int id, @Path("username") String username, @Body String permission);

    @PUT(GITHUB_API_PROJECT_TOPICS)
    Call<Void> putTopic(@Path("owner") String owner, @Path("repo") String repo, @Body JSONObject request);

    @PUT("/repos/{owner}/{repo}/vulnerability-alerts")
    Call<ResponseBody> putAlert(@Path("owner") String owner, @Path("repo") String repo);

}
