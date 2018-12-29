package com.elhachimi_ch.appcodingchallenge;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.sql.StatementEvent;

public class MainActivity extends AppCompatActivity {

    private ListView reposListView;
    private TextView title;
    private ReposAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        reposListView= findViewById(R.id.reposListView);
        title= findViewById(R.id.header);
        title.setText("Trending Repos");
        adapter= new ReposAdapter(this);
        //reposListView.setAdapter(adapter);
        // Instantiate the RequestQueue.

        //avoir la date actuel - 30jr sous la forme année-mois-jours
        Date date= new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        Date newDate= c.getTime();
        SimpleDateFormat dateFormater= new SimpleDateFormat("yyyy-MM-dd");
        String dateString= dateFormater.format(newDate);

        String url ="https://api.github.com/search/repositories?q=created:%3E"+dateString+"&sort=stars&order=desc";

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        ReposAdapter repos = gson.fromJson(response, ReposAdapter.class);
                        adapter.setData(repos.getData());
                        reposListView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }



}
