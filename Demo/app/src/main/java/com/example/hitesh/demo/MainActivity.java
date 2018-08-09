package com.example.hitesh.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fname,lname,mobile,email;
    RadioGroup Gender;
    RadioButton rad_gen;
    Button submit;
    String gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = (EditText) findViewById(R.id.editfname);
        email = (EditText) findViewById(R.id.editemail);
        lname = (EditText) findViewById(R.id.editlname);
        mobile = (EditText)findViewById(R.id.editnumber);
        rad_gen = (RadioButton) findViewById(R.id.radmale);
        submit = (Button) findViewById(R.id.btnsubmit);
        Gender = (RadioGroup) findViewById(R.id.rad_gender);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fn = fname.getText().toString();
                String ln = lname.getText().toString();
                String mob = mobile.getText().toString();
                String em = email.getText().toString();


                /*int selectedId = Gender.getCheckedRadioButtonId();
                rad_gen = (RadioButton) findViewById(selectedId);*/
                String gen = rad_gen.getText().toString();



                if (fn.trim().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter First Name", Toast.LENGTH_SHORT).show();
                    return;

                }

                    /*fname.setError("Please enter First Name");
                    return;
                }*/
                if (ln.trim().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter Last Name", Toast.LENGTH_SHORT).show();
                    return;

                    /*lname.setError("Please enter Last Name");
                    return;*/

                }
                if (mob.trim().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter Mobile No", Toast.LENGTH_SHORT).show();
                    return;

                    /*mobile.setError("Please enter Mobile Number");
                    return;*/
                }
                if ( mob.length()<10)
                {
                    Toast.makeText(MainActivity.this, "Please Enter Valid Mobile No", Toast.LENGTH_SHORT).show();
                    return;

                    /*mobile.setError("Please enter Mobile Number");
                    return;*/
                }
                if (em.trim().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                    /*email.setError("Please enter valid email");
                    return;*/
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(em).matches()) {
                    Toast.makeText(MainActivity.this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    Intent i = new Intent(MainActivity.this,Second.class);
                    Bundle first = new Bundle();
                    first.putString("firstname" , fn);
                    first.putString("lastname" , ln);
                    first.putString("email" , em);
                    first.putString("mo.number" , mob);
                    first.putString("gender" ,gen);
                    i.putExtras(first);
                    startActivity(i);
                }

            }
        });
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        /*switch(view.getId()) {
            case R.id.radmale:*/
                if (checked)
                   rad_gen.setText("Male");
                    /*break;*/
            /*case R.id.radfemale:
                if (checked)*/
            else
                    rad_gen.setText("Female");
                    /*break;*/
        }

    }




