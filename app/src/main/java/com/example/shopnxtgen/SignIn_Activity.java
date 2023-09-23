package com.example.shopnxtgen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignIn_Activity extends AppCompatActivity {
    AppCompatButton loginBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        loginBTN = findViewById(R.id.btnLOGIN);

        // write Your Code here For the Login Page







        // this code i've created for checking purpose u can do Your code here or simply modify it
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn_Activity.this, MainActivity.class));
            }
        });
    }
}