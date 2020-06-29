package com.example.login_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button log, reg;
    String users[] = {"mohit", "nitesh"};
    String passwords[] = {"mk1234", "nb1234"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);

        log = findViewById(R.id.login);
        reg = findViewById(R.id.register);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = user.getText().toString();
                String password = pass.getText().toString();
                if(name.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter your Username", Toast.LENGTH_SHORT).show();
                }
                else if(password.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter your password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean flag = true;
                    for(int i= 0; i < users.length; i++)
                    {
                        if(name.equals(users[i]) && password.equals(passwords[i]))
                        {
                            Intent LogIn = new Intent(MainActivity.this, Welcome_Screen.class);
                            LogIn.putExtra("name", name);
                            startActivity(LogIn);
                            Toast.makeText(MainActivity.this, "Login Successful !", Toast.LENGTH_SHORT).show();
                            flag = false;
                        }

                    }
                    if(flag)
                    {
                        Toast.makeText(MainActivity.this, "Invalid Credentials... Please Try Again", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regUp = new Intent(MainActivity.this, Register_Screen.class);
                startActivity(regUp);
            }
        });


    }
}