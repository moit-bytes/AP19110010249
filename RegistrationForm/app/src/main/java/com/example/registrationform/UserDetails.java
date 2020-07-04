package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetails extends AppCompatActivity {

    String name, roll, phone, email, password, gender, branch;
    TextView n,r,p,e,pass,gen,br, reg_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        roll = i.getStringExtra("roll");
        phone = i.getStringExtra("phone");
        email = i.getStringExtra("email");
        password = i.getStringExtra("password");
        gender = i.getStringExtra("gender");
        branch = i.getStringExtra("branch");

        n = findViewById(R.id.display_name);
        r = findViewById(R.id.display_roll);
        p = findViewById(R.id.display_phone);
        e = findViewById(R.id.display_email);
        pass = findViewById(R.id.display_password);
        gen = findViewById(R.id.display_gender);
        br = findViewById(R.id.display_branch);
        reg_status = findViewById(R.id.reg_status);

        n.setText("Name : "+name);
        r.setText("Roll Number: "+roll);
        p.setText("Phone Number : "+phone);
        e.setText("Email : "+email);
        pass.setText("Password : "+password);
        gen.setText("Gender : "+gender);
        br.setText("Branch : "+branch);
        reg_status.setText("Registration Status : Successful");

    }
}