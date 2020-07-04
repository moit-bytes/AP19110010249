package com.example.registrationform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, roll, phone, email, pass;
    RadioButton male, female, trans;
    Spinner branch;
    Button sub;
    String n,r,p,e,password;
    String branch_selected;
    String gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        roll = findViewById(R.id.roll_number);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        branch  = findViewById(R.id.branch);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        trans = findViewById(R.id.trans);
        sub = findViewById(R.id.submit);


        ArrayAdapter<CharSequence> branches = ArrayAdapter.createFromResource(MainActivity.this, R.array.branches, android.R.layout.simple_spinner_item);
        branch.setAdapter(branches);

        branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0:
                        branch_selected = null;
                        break;
                    default:
                        branch_selected = branch.getSelectedItem().toString();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        if(savedInstanceState != null)
        {
            n = savedInstanceState.getString("name");
            p = savedInstanceState.getString("phone");
            r = savedInstanceState.getString("roll");
            e = savedInstanceState.getString("email");
            password = savedInstanceState.getString("password");

            name.setText(n);
            roll.setText(r);
            phone.setText(p);
            email.setText(e);
            pass.setText(password);

        }

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = name.getText().toString();
                p = phone.getText().toString();
                r = roll.getText().toString();
                e = email.getText().toString();
                password = pass.getText().toString();
                branch_selected = branch.getSelectedItem().toString();
                if(branch_selected.equals("Select your branch"))
                {
                    branch_selected = null;
                }

                if(male.isChecked())
                {
                    gen = male.getText().toString();
                }
                else if(female.isChecked())
                {
                    gen = female.getText().toString();
                }
                else if(trans.isChecked())
                {
                    gen = trans.getText().toString();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please select your gender", Toast.LENGTH_SHORT).show();
                }
                if(n.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter your name", Toast.LENGTH_SHORT).show();
                }
                else if(p.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
                }
                else if(r.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter your roll number", Toast.LENGTH_SHORT).show();
                }
                else if(e.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }
                else if(password.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }
                else if(branch_selected == null)
                {
                    Toast.makeText(MainActivity.this, "Please select your branch", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, UserDetails.class);
                    i.putExtra("name", n);
                    i.putExtra("roll", r);
                    i.putExtra("email", e);
                    i.putExtra("phone", p);
                    i.putExtra("password", password);
                    i.putExtra("branch", branch_selected);
                    i.putExtra("gender", gen);
                    startActivity(i);

                }

            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name", name.getText().toString());
        outState.putString("roll", roll.getText().toString());
        outState.putString("phone", phone.getText().toString());
        outState.putString("email", email.getText().toString());
        outState.putString("pass", pass.getText().toString());
    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Exit");
        dialog.setMessage("Are you Sure you want to exit");
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();

            }
        });

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }
}