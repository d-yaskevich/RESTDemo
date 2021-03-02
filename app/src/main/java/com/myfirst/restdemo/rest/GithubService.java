package com.myfirst.restdemo.rest;

import com.myfirst.restdemo.rest.models.Repo;
import com.myfirst.restdemo.rest.responses.GithubResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import static com.myfirst.restdemo.rest.GithubConfig.GITHUB_API_BASE_URL;
import static com.myfirst.restdemo.rest.GithubConfig.GITHUB_API_REPOS;

public interface GithubService {

    @GET(GITHUB_API_REPOS)
    Call<ArrayList<Repo>> listRepos(@Path("user") String user);

    //todo add one function for each request method: POST, PUT, DELETE from https://docs.github.com/en/rest/overview/endpoints-available-for-github-apps


    /*@PUT("users/{name}")
    Call<Repo> putRepo(@Path("name") String name, @Body Repo post);

    @POST(GITHUB_API_REPOS)
    Call<Repo> createRepo(@Body Repo repo);
     */

    @DELETE("GITHUB_API_REPOS")
    Call<Void> deleteRepo(@Path("user") String user);



}
