package com.example.shopnxtgen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    AppCompatEditText loginEmail, loginPass;
    AppCompatButton loginBTN, loginWithGoogleBTN, signUpBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        loginEmail = findViewById(R.id.loginEmail);
        loginPass = findViewById(R.id.loginPass);
        loginBTN = findViewById(R.id.btnLOGIN);
        loginWithGoogleBTN = findViewById(R.id.btnLoginWithGoogle);
        signUpBTN = findViewById(R.id.btnSignUp);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString();
                String password = loginPass.getText().toString();

                // Implement the login logic here (e.g., using Firebase).
                if (isValidCredentials(email, password)) {
                    // If login is successful, navigate to the main activity.
                    navigateToMainActivity();
                } else {
                    // Handle login failure.
                    Toast.makeText(SignInActivity.this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Add a click listener for the Google login button (if applicable).

        signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to the sign-up activity.
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });
    }

    private boolean isValidCredentials(String email, String password) {
        // Add your validation logic here, e.g., check against a database or use Firebase.
        // For a simplified example, you can check if email and password are not empty.
        return !email.isEmpty() && !password.isEmpty();
    }

    private void navigateToMainActivity() {
        // Implement the navigation logic to your main activity.
        startActivity(new Intent(SignInActivity.this, MainActivity.class));
        finish();
    }
}
