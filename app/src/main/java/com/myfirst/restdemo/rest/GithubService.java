package com.myfirst.restdemo.rest;

import com.myfirst.restdemo.rest.models.Repo;
import com.myfirst.restdemo.rest.requests.ProjectRequest;
import com.myfirst.restdemo.rest.responses.ProjectResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.myfirst.restdemo.rest.GithubConfig.GITHUB_API_CREATE_PROJECT;
import static com.myfirst.restdemo.rest.GithubConfig.GITHUB_API_REPOS;

public interface GithubService {

//    @GET(GITHUB_API_REPOS)
//    Call<ResponseBody> listReposTest(@Path("user") String user);

    @GET(GITHUB_API_REPOS)
    Call<ArrayList<Repo>> listRepos(@Path("user") String user);

    @POST(GITHUB_API_CREATE_PROJECT)
//    Call<ProjectResponse> createProject(@Header("Accept") String accept, @Header("Authorization") String authorization, @Body ProjectRequest request);
    Call<ProjectResponse> createProject(@Body ProjectRequest request); // add headers using interceptors

    //todo add one function for each request method: POST, PUT, DELETE from https://docs.github.com/en/rest/overview/endpoints-available-for-github-apps

}
