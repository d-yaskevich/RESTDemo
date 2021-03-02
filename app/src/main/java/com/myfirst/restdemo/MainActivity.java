package com.myfirst.restdemo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myfirst.restdemo.adapters.ReposAdapter;
import com.myfirst.restdemo.rest.API;
import com.myfirst.restdemo.rest.GithubService;
import com.myfirst.restdemo.rest.models.Repo;
import com.myfirst.restdemo.rest.responses.GithubResponse;
import com.myfirst.restdemo.rest.requests.ProjectRequest;
import com.myfirst.restdemo.rest.responses.ProjectResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.myfirst.restdemo.rest.GithubConfig.GITHUB_API_BASE_URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView tvResponse;
    private EditText etUserName;
    private EditText et_delete_user;
    private GithubService githubService;

    private ReposAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResponse = (TextView) findViewById(R.id.tv_response);
        etUserName = findViewById(R.id.et_user_name);
        et_delete_user = findViewById(R.id.et_delete_user);

        adapter = new ReposAdapter(this);

        RecyclerView rvReps = findViewById(R.id.rv_repos);
        rvReps.setLayoutManager(new LinearLayoutManager(this));
        rvReps.setAdapter(adapter);

        Gson gson = new GsonBuilder().serializeNulls().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GITHUB_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        githubService = retrofit.create(GithubService.class);

    }

    public void onGetClick(View view) {
        AsyncTask.execute(() -> {
            String response = getDataFrom(GITHUB_API_BASE_URL);
            Log.d(TAG, "response" + response);
            //todo add convert String to GithubResponse model using JSON (Gson)
            GithubResponse githubResponse = fromGson(response);

            new Handler(Looper.getMainLooper()).post(() ->
                    //todo show 'nice' (formatted) contents GithubResponse model
                    //tvResponse.setText(response)
                    tvResponse.setText(githubResponse.toString())
            );
        });
    }

    public static GithubResponse fromGson(String response) {
        GsonBuilder builder = new GsonBuilder();

        Gson gson = builder.create();
        return gson.fromJson(response, GithubResponse.class);
    }

    private String getDataFrom(String urlString) {
        Context context = getApplicationContext();
        StringBuilder stringBuilder = new StringBuilder();

        HttpsURLConnection connection = null;
        try {
            URL url = new URL(urlString);

            connection = (HttpsURLConnection) url.openConnection();

            try (InputStream responseBody = connection.getInputStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(responseBody, StandardCharsets.UTF_8);
                 BufferedReader reader = new BufferedReader(inputStreamReader)) {

                String line = reader.readLine();
                while (line != null) {
                    stringBuilder.append(line).append("\n");
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                return stringBuilder.toString();
            } else {
                Toast.makeText(context, "Error - " + responseCode, Toast.LENGTH_LONG).show();
            }

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return stringBuilder.toString();
    }

    public void onGetReposClick(View view) {
        String userName = etUserName.getText().toString();

        if (userName.isEmpty()) return;

//        API.github().listReposTest(userName).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    String jsonString = response.body().string();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });

        API.github().listRepos(userName).enqueue(new Callback<ArrayList<Repo>>() {
            @Override
            public void onResponse(Call<ArrayList<Repo>> call, Response<ArrayList<Repo>> response) {
                ArrayList repos = response.body();
                adapter.resetRepos(repos);

                Log.i(TAG, "<-- " + response.code() + " " + call.request().method() + " " + call.request().url());
                if (repos != null) Log.i(TAG, repos.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Repo>> call, Throwable t) {
                Log.e(TAG, t.toString());
                Snackbar snackbar = Snackbar.make(tvResponse, t.toString(), Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction(android.R.string.ok, v -> snackbar.dismiss());
                snackbar.show();
            }
        });
    }


    public void onDeleteClick(View view) {
        String userName = et_delete_user.getText().toString();
        Call<Void> call = githubService.deleteRepo(userName);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                tvResponse.setText("Code: " + response.code());
                Log.d("DELETE", "Code: " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                tvResponse.setText(t.getMessage());
                Log.d("DELETE", "onFailure: " + t.getMessage());
            }
        });
    }


    public void onCreateProjectClick(View view) {
        ProjectRequest request = new ProjectRequest("Some name", null);
        API.github().createProject(request).enqueue(new Callback<ProjectResponse>() {
            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {
                ProjectResponse project = response.body();
                // some actions

                Log.i(TAG, "<-- " + response.code() + " " + call.request().method() + " " + call.request().url());
                if (project != null) Log.i(TAG, project.toString());
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
                Snackbar snackbar = Snackbar.make(tvResponse, t.toString(), Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction(android.R.string.ok, v -> snackbar.dismiss());
                snackbar.show();
            }
        });
    }
}