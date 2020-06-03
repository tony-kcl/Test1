package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondLayout extends AppCompatActivity {

    private TextView mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layout);
        mEditText = findViewById(R.id.dTextView);

        Bundle bundle = getIntent().getExtras();
        String startTime = bundle.getString("startTime");
        String endTime = bundle.getString("endTime");
        String temperature = bundle.getString("temperature");
        mEditText.setText(startTime + "\n" + endTime + "\n" + temperature);
    }
}
