package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class showprofile extends AppCompatActivity {
TextView tv1,tv2,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showprofile);
        /*tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        String a=getIntent().getStringExtra("user");
        String b=getIntent().getStringExtra("email");
        String c=getIntent().getStringExtra("phone");
        String d=getIntent().getStringExtra("password");
        tv1.setText(a);tv2.setText(b);tv3.setText(c);tv4.setText(d);*/
    }
}