package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
 RadioButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.rb1);
        b2=findViewById(R.id.rb2);
    }
    public void statusChange(View v)
    {
        String s=v.getTag().toString();
        if(s.equals("1"))
        {
            b1.setTextColor(Color.WHITE);
            b2.setTextColor(Color.BLACK);
            Intent i=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(i);
        }
        else if(s.equals("2"))
        {
            b1.setTextColor(Color.BLACK);
            b2.setTextColor(Color.WHITE);
            Intent i=new Intent(MainActivity.this,MainActivity3.class);
            startActivity(i);
        }
    }
}