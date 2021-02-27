package com.myfirst.restdemo.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    private static <T> T builder(Class<T> service, String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(service);
    }

    public static GithubService github() {
        return builder(GithubService.class, GithubConfig.GITHUB_API_BASE_URL);
    }

}
