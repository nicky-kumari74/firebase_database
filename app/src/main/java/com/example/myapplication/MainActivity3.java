package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {
TextInputEditText t1,t2;
TextView reg;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t1=findViewById(R.id.user);
        t2=findViewById(R.id.paswrd);
        btn=findViewById(R.id.btn1);
        reg=findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(it);
            }
        });
        FirebaseApp.initializeApp(this);
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=t1.getText().toString().trim();
                String b=t2.getText().toString().trim();
                Query qry=reference.orderByChild("username").equalTo(a);
                qry.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            String ps=snapshot.child(a).child("password").getValue(String.class);
                            if(ps.equals(b)){
                                String u=snapshot.child(a).child("username").getValue(String.class);
                                String e=snapshot.child(a).child("email").getValue(String.class);
                                String ph=snapshot.child(a).child("phone").getValue(String.class);
                                Intent i=new Intent(MainActivity3.this,showprofile.class);
                                i.putExtra("user",u);
                                i.putExtra("email",e);
                                i.putExtra("phone",ph);
                                i.putExtra("password",ps);
                                Dialog dialog=new Dialog(MainActivity3.this);
                                dialog.setContentView(R.layout.popup);
                                dialog.show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        startActivity(i);
                                        t1.setText("");
                                        t2.setText("");
                                        dialog.dismiss();

                                    }
                                },3000);

                            }
                            else{
                                t2.setError("wrong password");
                                t2.requestFocus();

                            }
                        }
                        else{
                            t1.setError("No such user exist");
                            t1.requestFocus();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


    }
}