package com.moitbytes.roomdatabasetask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder>
{
    Context ct;
    List<Student> list;

    public MyAdapter(MainActivity mainActivity, List<Student> studentList)
    {
        ct = mainActivity;
        list = studentList;
    }

    @NonNull
    @Override
    public MyAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(ct).inflate(R.layout.row_design, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.Holder holder, int position)
    {
        final Student student = list.get(position);
        holder.rName.setText(student.getName());
        holder.rMail.setText(student.getMailId());
        holder.rMobile.setText(student.getPhoneNumber());
        holder.rlang.setText(student.getLanguages());
        holder.rgender.setText(student.getGender());
        holder.rAdd.setText(student.getAddress());
        holder.rDep.setText(student.getDepartment());

        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.myViewModel.delete(student);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder
    {
        TextView rName, rAdd, rMail, rMobile, rgender, rlang, rDep;
        ImageView del, edit;
        public Holder(@NonNull View itemView)
        {
            super(itemView);
            rName = itemView.findViewById(R.id.dispName);
            rMail = itemView.findViewById(R.id.dispMail);
            rMobile = itemView.findViewById(R.id.dispPhone);
            rAdd = itemView.findViewById(R.id.dispAddress);
            rgender = itemView.findViewById(R.id.dispGender);
            rlang = itemView.findViewById(R.id.dispLang);
            rDep = itemView.findViewById(R.id.dispDepart);
            del = itemView.findViewById(R.id.delete);
            edit = itemView.findViewById(R.id.edit);

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Access Data for text views*/

                    final String name = rName.getText().toString();
                    final String mail = rMail.getText().toString();
                    final String phone = rMobile.getText().toString();
                    final String add = rAdd.getText().toString();
                    final String gender = rgender.getText().toString();

                    ViewGroup viewGroup = v.findViewById(android.R.id.content);
                    View view =  LayoutInflater.from(ct).inflate(R.layout.update_data, viewGroup, false);
                    final EditText uname = view.findViewById(R.id.update_name);
                    final EditText umail = view.findViewById(R.id.update_mailid);
                    final EditText uAdd = view.findViewById(R.id.update_address);
                    final EditText uphone = view.findViewById(R.id.update_phone);
                    final RadioButton umale = view.findViewById(R.id.update_male);
                    final RadioButton ufemale = view.findViewById(R.id.update_female);
                    final CheckBox utelugu = view.findViewById(R.id.update_telugu);
                    final CheckBox uenglish = view.findViewById(R.id.update_english);
                    final CheckBox uhindi = view.findViewById(R.id.update_hindi);
                    final Spinner dep = view.findViewById(R.id.update_department);


                    Button update = view.findViewById(R.id.buttonUpdate);
                    Button cancel = view.findViewById(R.id.buttonCancel);

                    final BottomSheetDialog dialog = new BottomSheetDialog(ct);
                    dialog.setContentView(view);
                    dialog.setCancelable(false);
                    uname.setText(name);
                    uphone.setText(phone);
                    umail.setText(mail);
                    uAdd.setText(add);
                    if(gender.equals("Male"))
                    {
                        umale.setChecked(true);
                    }
                    else
                    {
                        ufemale.setChecked(false);
                    }


                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            Student student = new Student();
                            student.setName(uname.getText().toString());
                            student.setMailId(umail.getText().toString());
                            student.setPhoneNumber(uphone.getText().toString());
                            student.setAddress(uAdd.getText().toString());
                            if(umale.isChecked()){
                                String gender = umale.getText().toString();
                            }
                            if(ufemale.isChecked()){
                                String gender = ufemale.getText().toString();
                            }
                            StringBuilder builder = new StringBuilder();
                            if(utelugu.isChecked()){
                                builder.append(utelugu.getText().toString()+",");
                            }
                            if(uenglish.isChecked()){
                                builder.append(uenglish.getText().toString()+",");
                            }
                            if(uhindi.isChecked()){
                                builder.append(uhindi.getText().toString());
                            }
                            ArrayAdapter<CharSequence> department_adapter = ArrayAdapter.createFromResource(ct,
                                    R.array.department, android.R.layout.simple_spinner_item);
                            dep.setAdapter(department_adapter);
                            String selectedDepart = dep.getSelectedItem().toString();

                            student.setLanguages(builder.toString());
                            student.setGender(gender);
                            student.setDepartment(selectedDepart);
                            MainActivity.myViewModel.update(student);

                            Toast.makeText(ct, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });

                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
            });
        }
    }
}

