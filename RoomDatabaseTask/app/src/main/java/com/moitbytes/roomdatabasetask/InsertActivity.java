package com.moitbytes.roomdatabasetask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    EditText address, mail_id, name_user, phone;
    RadioButton r_male,r_female;
    Spinner department;
    CheckBox ch_telugu, ch_english, ch_hindi;
    String gender1;
    String depart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        mail_id = findViewById(R.id.input_mailid);
        name_user = findViewById(R.id.input_name);
        phone = findViewById(R.id.input_phone);
        address = findViewById(R.id.input_address);
        r_male = findViewById(R.id.male);
        r_female = findViewById(R.id.female);
        department = findViewById(R.id.department);
        ch_telugu = findViewById(R.id.telugu);
        ch_english = findViewById(R.id.english);
        ch_hindi = findViewById(R.id.hindi);

        ArrayAdapter<CharSequence> department_adapter = ArrayAdapter.createFromResource(this,
                R.array.department, android.R.layout.simple_spinner_item);
        department.setAdapter(department_adapter);

        department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(InsertActivity.this, "Please selcet department", Toast.LENGTH_SHORT).show();
                        depart = null;
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void save(View view) {
        String name = name_user.getText().toString();
        String mail = mail_id.getText().toString();
        String mobile = phone.getText().toString();
        String add = address.getText().toString();

        if(r_male.isChecked()){
            gender1 = r_male.getText().toString();
        }
        if(r_female.isChecked()){
            gender1 = r_female.getText().toString();
        }
        StringBuilder builder = new StringBuilder();
        if(ch_telugu.isChecked()){
            builder.append(ch_telugu.getText().toString()+",");
        }
        if(ch_english.isChecked()){
            builder.append(ch_english.getText().toString()+",");
        }
        if(ch_hindi.isChecked()){
            builder.append(ch_hindi.getText().toString());
        }
        String selectedDepart = department.getSelectedItem().toString();


        Student student = new Student();
        student.setName(name);
        student.setMailId(mail);
        student.setPhoneNumber(mobile);
        student.setAddress(add);
        student.setDepartment(selectedDepart);
        student.setGender(gender1);
        student.setLanguages(builder.toString());

        MainActivity.myViewModel.insert(student);

        Toast.makeText(this, "Data Saved sucessfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}