package com.example.login_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Welcome_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__screen);

        String s = getIntent().getStringExtra("name");

        TextView tv = findViewById(R.id.display);

        tv.setText("Welcome : "+s);
    }
}