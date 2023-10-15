package com.example.shopnxtgen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

public class SignInActivity extends AppCompatActivity {
    AppCompatEditText loginEmail, loginPass;
    AppCompatButton loginBTN, loginWithGoogleBTN, signUpBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        loginEmail = findViewById(R.id.email); // Replace with the appropriate ID
        loginPass = findViewById(R.id.password); // Replace with the appropriate ID
        loginBTN = findViewById(R.id.btnLOGIN); // Replace with the appropriate ID
        loginWithGoogleBTN = findViewById(R.id.btnLoginWithGoogle); // Replace with the appropriate ID
        signUpBTN = findViewById(R.id.btnSignUp); // Replace with the appropriate ID

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString();
                String password = loginPass.getText().toString();

                if (isValidCredentials(email, password)) {
                    navigateToMainActivity();
                } else {
                    Toast.makeText(SignInActivity.this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Implement click listener for login with Google button (if applicable).

        signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });
    }

    private boolean isValidCredentials(String email, String password) {
        // Implement your login validation logic here (e.g., using Firebase).
        return !email.isEmpty() && !password.isEmpty();
    }

    private void navigateToMainActivity() {
        startActivity(new Intent(SignInActivity.this, MainActivity.class));
        finish();
    }
}
