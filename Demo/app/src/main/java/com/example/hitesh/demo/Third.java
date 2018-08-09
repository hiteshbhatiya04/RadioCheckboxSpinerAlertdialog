package com.example.hitesh.demo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Third extends AppCompatActivity {

    Button progress,alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        final Bundle first = getIntent().getExtras();
        if(first == null)
        {
            return;
        }


        progress = (Button) findViewById(R.id.btnprogress);
        alert = (Button) findViewById(R.id.btnalert);


        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog pd;
                pd=new ProgressDialog(Third.this);
                pd.setTitle("Loading");
                pd.setMessage("Please wait some time while loading..");
                pd.show();

            }
        });

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(Third.this);
                builder.setTitle("Alert Dialog");
                builder.setMessage("Are you sure want to send ??");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Bundle first = getIntent().getExtras();


                        Intent j=new Intent(Third.this,Display.class);
                        j.putExtras(first);


                        startActivity(j);
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                builder.show();

            }
        });
    }
}
