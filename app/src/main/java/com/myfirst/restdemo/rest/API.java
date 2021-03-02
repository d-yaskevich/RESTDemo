package com.myfirst.restdemo.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    private static <T> T builder(Class<T> service, String baseUrl, OkHttpClient client) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson));

        if (client != null) {
            retrofitBuilder.client(client);
        }

        return retrofitBuilder.build().create(service);
    }

    public static GithubService github() {
        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Accept", GithubConfig.GITHUB_ACCEPT)
                    .header("Authorization", GithubConfig.GITHUB_AUTH_TOKEN)
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        }).build();

        return builder(GithubService.class, GithubConfig.GITHUB_API_BASE_URL, client);
    }

}
