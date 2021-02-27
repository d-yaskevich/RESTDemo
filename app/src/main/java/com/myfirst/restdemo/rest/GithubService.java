package com.myfirst.restdemo.rest;

import com.myfirst.restdemo.rest.models.Repo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.myfirst.restdemo.rest.GithubConfig.GITHUB_API_REPOS;

public interface GithubService {

    @GET(GITHUB_API_REPOS)
    Call<ArrayList<Repo>> listRepos(@Path("user") String user);

    //todo add one function for each request method: POST, PUT, DELETE from https://docs.github.com/en/rest/overview/endpoints-available-for-github-apps

}
