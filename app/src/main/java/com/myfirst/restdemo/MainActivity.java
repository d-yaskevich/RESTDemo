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
import com.myfirst.restdemo.adapters.ReposAdapter;
import com.myfirst.restdemo.rest.API;
import com.myfirst.restdemo.rest.GithubConfig;
import com.myfirst.restdemo.rest.models.Repo;

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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView tvResponse;
    private EditText etUserName;

    private ReposAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResponse = (TextView) findViewById(R.id.tv_response);
        etUserName = findViewById(R.id.et_user_name);

        adapter = new ReposAdapter(this);

        RecyclerView rvReps = findViewById(R.id.rv_repos);
        rvReps.setLayoutManager(new LinearLayoutManager(this));
        rvReps.setAdapter(adapter);
    }

    public void onGetClick(View view) {
        AsyncTask.execute(() -> {
            String response = getDataFrom(GithubConfig.GITHUB_API_BASE_URL);

            //todo add convert String to GithubResponse model using JSON (Gson)

            new Handler(Looper.getMainLooper()).post(() ->
                    //todo show 'nice' (formatted) contents GithubResponse model
                    tvResponse.setText(response)
            );
        });
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

        API.github().listRepos(userName).enqueue(new Callback<ArrayList<Repo>>() {
            @Override
            public void onResponse(Call<ArrayList<Repo>> call, Response<ArrayList<Repo>> response) {
                ArrayList repos = response.body();
                adapter.resetRepos(repos);

                Log.i(TAG, "<-- " + call.request().method() + " " + call.request().url());
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
}