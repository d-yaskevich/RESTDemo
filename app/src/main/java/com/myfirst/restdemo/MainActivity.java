package com.myfirst.restdemo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResponse = (TextView) findViewById(R.id.tv_response);
    }

    public void onGetClick(View view) {
        AsyncTask.execute(() -> {
            String response = getDataFrom("https://api.github.com/");
            new Handler(Looper.getMainLooper()).post(() -> tvResponse.setText(response));
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
}