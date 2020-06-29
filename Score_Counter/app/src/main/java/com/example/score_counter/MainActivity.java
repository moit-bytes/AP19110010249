package com.example.score_counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_A, tv_B;
    int a = 0, b = 0;
    Button a1, a2, a3;
    Button b1, b2, b3;
    Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_A = findViewById(R.id.Team_A);
        tv_B = findViewById(R.id.Team_B);

        a1 = findViewById(R.id.Team_A_1);
        a2 = findViewById(R.id.Team_A_2);
        a3 = findViewById(R.id.Team_A_3);
        b1 = findViewById(R.id.Team_B_1);
        b2 = findViewById(R.id.Team_B_2);
        b3 = findViewById(R.id.Team_B_3);

        sub = findViewById(R.id.submit);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                tv_A.setText(""+a);
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a+=2;
                tv_A.setText(""+a);
            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a+=3;
                tv_A.setText(""+a);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                tv_B.setText(""+b);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b+=2;
                tv_B.setText(""+b);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b+=3;
                tv_B.setText(""+b);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a>b)
                {
                    Toast.makeText(MainActivity.this, "Team A wins !", Toast.LENGTH_SHORT).show();
                }
                else if(a<b)
                {
                    Toast.makeText(MainActivity.this, "Team B wins !", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Match Tied", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(savedInstanceState != null)
        {
            String s1 = savedInstanceState.getString("team_A");
            String s2 = savedInstanceState.getString("team_B");

            a = Integer.parseInt(s1);
            b = Integer.parseInt(s2);

            tv_A.setText(""+a);
            tv_B.setText(""+b);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("team_A", tv_A.getText().toString());
        outState.putString("team_B", tv_B.getText().toString());
    }
}