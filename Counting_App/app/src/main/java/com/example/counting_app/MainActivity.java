package com.example.counting_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button pl, mi, zero, t;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.countText);
        pl = findViewById(R.id.plus);
        mi = findViewById(R.id.minus);
        zero = findViewById(R.id.zero);
        t = findViewById(R.id.toast);

        pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                tv.setText(""+a);
            }
        });

        mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a--;
                tv.setText(""+a);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = 0;
                tv.setText(""+a);
            }
        });

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Your count is : "+ a, Toast.LENGTH_SHORT).show();
            }
        });

        if(savedInstanceState != null)
        {
            String s = savedInstanceState.getString("data");
            a = Integer.parseInt(s);
            tv.setText(""+a);

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("data", tv.getText().toString());
    }
}