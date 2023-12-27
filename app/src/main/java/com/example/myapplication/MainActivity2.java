package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {
    EditText t1,t2,t3,t4,t5;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.et1);
        t2=findViewById(R.id.et2);
        t3=findViewById(R.id.et3);
        t4=findViewById(R.id.et4);
        btn=findViewById(R.id.btn);
        FirebaseApp.initializeApp(this);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference root=db.getReference().child("users");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=t1.getText().toString();
                String m=t2.getText().toString();
                String p=t3.getText().toString();
                String q=t4.getText().toString();
                HashMap<String,String> usermap=new HashMap<>();
                usermap.put("username",n);
                usermap.put("email",m);
                usermap.put("phone",p);
                usermap.put("password",q);

                root.child(n).setValue(usermap);
                Dialog dialog=new Dialog(MainActivity2.this);
                dialog.setContentView(R.layout.popup);
                dialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(MainActivity2.this,MainActivity3.class);
                        startActivity(i);
                        finish();
                    }
                },3000);
            }
        });
    }
}