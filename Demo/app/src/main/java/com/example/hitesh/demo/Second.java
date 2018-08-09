package com.example.hitesh.demo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class Second extends AppCompatActivity {

    CheckBox play,listen,travell,read;
    EditText date,time;
    Button send;
    int year,month,adate,hour,minutes;

    ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Bundle first = getIntent().getExtras();
        if (first ==null)
        {
            return;
        }

        play = (CheckBox)findViewById(R.id.chkplay);
        listen = (CheckBox)findViewById(R.id.chkplistening);
        travell = (CheckBox)findViewById(R.id.chktrav);
        read = (CheckBox)findViewById(R.id.chkread);
        date = (EditText) findViewById(R.id.editdate);
        time = (EditText) findViewById(R.id.edittime);
        send = (Button) findViewById(R.id.btnsend);
        tb = (ToggleButton) findViewById(R.id.toggle);
        tb.setTextOn("on");
        tb.setTextOff("off");
        /*tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                }

            else
                {
                    return;
                }
            }
        });*/

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                year=calendar.get(calendar.YEAR);
                month=calendar.get(calendar.MONTH);
                adate=calendar.get(calendar.DATE);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Second.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        int i3 = i1+1;
                        date.setText(i+"/"+i3+"/"+i2);
                    }
                },year,month,adate);
                datePickerDialog.show();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar c=Calendar.getInstance();
                hour=c.get(Calendar.HOUR);
                minutes=c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(Second.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        time.setText(i+":"+i1);
                    }
                },hour,minutes,true);
                timePickerDialog.show();

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle first = getIntent().getExtras();
                /*String fn = first.getString("firstname");
                String ln = first.getString("lastname");
                String em = first.getString("email");
                String mob = first.getString("mo.number");
                String gen = first.getString("gender");*/
                String dt = date.getText().toString();
                String tm = time.getText().toString();
                String tob = tb.getText().toString();


                StringBuffer hobby = new StringBuffer();
                if(play.isChecked()){
                    hobby.append(" " + play.getText().toString());
                }
                if(listen.isChecked()){
                    hobby.append(" " + listen.getText().toString());
                }
                if(read.isChecked()){
                    hobby.append(" " + read.getText().toString());
                }
                if(travell.isChecked()){
                    hobby.append(" " + travell.getText().toString());
                }

                /*if (hobby.isEmpty())
                {
                    Toast.makeText(Second.this, "please Select any one", Toast.LENGTH_SHORT).show();
                    return;
                }*/
                if (dt.isEmpty())
                {
                    Toast.makeText(Second.this, "please select date", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (tm.isEmpty())
                {
                    Toast.makeText(Second.this, "please select time", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (tob == "off")
                {
                    return;
                }
                if (tob == "on") {


                    Intent j = new Intent(Second.this, Third.class);
                    first.putString("hobby", String.valueOf(hobby));
                    first.putString("Date",dt);
                    first.putString("Time",tm);
                    j.putExtras(first);
                    /*j.putExtra("shobby", hobby);
                    j.putExtra("Date", dt);
                    j.putExtra("Time", tm);
                    j.putExtra("bundle", first);
                    j.putExtra("firstname", fn);
                    j.putExtra("lastname", ln);
                    j.putExtra("email", em);
                    j.putExtra("mo.number", mob);
                    j.putExtra("gender", gen);*/
                    startActivity(j);
                }
            }
        });
    }
}
