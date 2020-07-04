package com.example.twoactivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView t_message;
    Button reply;
    EditText mReply;
    String r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        String message = i.getStringExtra("message");
        t_message = findViewById(R.id.text_message);
        t_message.setText(message);
        reply = findViewById(R.id.button_second);
        mReply = findViewById(R.id.editText_second);

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r  = mReply.getText().toString();
                Intent ij = new Intent();
                ij.putExtra("reply", r);
                setResult(RESULT_OK, ij);
                finish();

            }
        });

        if(savedInstanceState != null)
        {
            r = savedInstanceState.getString("replies");
            mReply.setText(r);
        }


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("replies", mReply.getText().toString());
    }
}