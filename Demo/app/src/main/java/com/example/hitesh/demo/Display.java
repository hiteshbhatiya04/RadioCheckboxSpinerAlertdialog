package com.example.hitesh.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Display extends AppCompatActivity {


    EditText edname,edemail,edmob,edgen,edhobby,eddob,edtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        edname = (EditText)findViewById(R.id.edit_name);
        edemail = (EditText)findViewById(R.id.edit_email);
        edmob = (EditText)findViewById(R.id.edit_number);
        edgen = (EditText)findViewById(R.id.edit_gender);
        edhobby = (EditText)findViewById(R.id.edit_hobby);
        eddob = (EditText)findViewById(R.id.edit_dob);
        edtime = (EditText)findViewById(R.id.edit_time);

        Bundle first = getIntent().getExtras();
        if(first == null)
        {
            return;
        }
        String fn = first.getString("firstname");
        String ln = first.getString("lastname");
        String em = first.getString("email");
        String mob = first.getString("mo.number");
        String gen = first.getString("gender");
        String hobby = first.getString("hobby");
        String dt = first.getString("Date");
        String tm = first.getString("Time");

        edname.setText(fn+ " "+ln);
        edemail.setText(em);
        edmob.setText(mob);
        edgen.setText(gen);
        edhobby.setText(hobby);
        eddob.setText(dt);
        edtime.setText(tm);
    }
}
