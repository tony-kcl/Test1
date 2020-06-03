package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;

import com.androidnetworking.interfaces.JSONObjectRequestListener;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private JSONArray mRecords, mData;
    private boolean firstLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("isFirstUse", MODE_PRIVATE);
        firstLogin = preferences.getBoolean("isFirstUse", true);

        if (!firstLogin) {
            Toast.makeText(this, "歡迎回來", Toast.LENGTH_LONG).show();
        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstUse", false);
            editor.commit();
        }

        recyclerView = findViewById(R.id.mRecyclerView);
        recyclerView.setHasFixedSize(true);

        AndroidNetworking.initialize(getApplicationContext());

        AndroidNetworking.get("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-53747528-A602-46D9-A92C-BD78E26069D2")
                .addQueryParameter("q", "comedy")
                .build()

                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            mRecords = response.getJSONObject("records").getJSONArray("location");
                            goAdapter();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println(anError);
                    }
                });


    }

    private void goAdapter() {
        ArrayList<Post> data = new ArrayList<>();
        for (int i = 0; i < mRecords.length(); i++) {
            try {
                mData = mRecords.getJSONObject(i).getJSONArray("weatherElement").getJSONObject(2).getJSONArray("time");
                String firstStartTime = mData.getJSONObject(0).getString("startTime");
                String firstEndTime = mData.getJSONObject(0).getString("endTime");
                String temperature = mData.getJSONObject(0).getJSONObject("parameter").getString("parameterName") +
                        mData.getJSONObject(0).getJSONObject("parameter").getString("parameterUnit");
                String secondStartTime = mData.getJSONObject(1).getString("startTime");
                String secondEndTime = mData.getJSONObject(1).getString("endTime");
                String temperature2 = mData.getJSONObject(1).getJSONObject("parameter").getString("parameterName") +
                        mData.getJSONObject(1).getJSONObject("parameter").getString("parameterUnit");
                String thirdStartTime = mData.getJSONObject(2).getString("startTime");
                String thirdEndTime = mData.getJSONObject(2).getString("endTime");
                String temperature3 = mData.getJSONObject(2).getJSONObject("parameter").getString("parameterName") +
                        mData.getJSONObject(2).getJSONObject("parameter").getString("parameterUnit");
                data.add(new Post(firstStartTime, firstEndTime, temperature, secondStartTime, secondEndTime, temperature2,
                        thirdStartTime, thirdEndTime, temperature3));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        MyAdapter adapter = new MyAdapter(this, data);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}

