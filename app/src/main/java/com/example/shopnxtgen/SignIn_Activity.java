package com.example.shopnxtgen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mrreco.SignupActivity; // Import the appropriate activity.

public class SignIn_Activity extends AppCompatActivity {
    AppCompatEditText loginEmail, loginPass;
    AppCompatButton loginBTN, loginWithGoogleBTN, signUpBTN; // Include buttons for login, Google login, and sign up.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        loginEmail = findViewById(R.id.loginEmail);
        loginPass = findViewById(R.id.loginPass);
        loginBTN = findViewById(R.id.btnLOGIN);
        loginWithGoogleBTN = findViewById(R.id.btnLoginWithGoogle);
        signUpBTN = findViewById(R.id.btnSignUp); // Add a button for sign-up.

        // Add a click listener for the login button.
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString();
                String password = loginPass.getText().toString();

                // Implement the login logic here.
                if (isValidCredentials(email, password)) {
                    // You can use Firebase or another authentication method to handle login.
                    // If login is successful, navigate to the main activity.
                    navigateToMainActivity();
                } else {
                    // Handle login failure.
                    Toast.makeText(SignIn_Activity.this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Add a click listener for the Google login button (if applicable).

        // Add a click listener for the sign-up button.
        signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to the sign-up activity.
                startActivity(new Intent(SignIn_Activity.this, SignupActivity.class));
            }
        });
    }

    // Validate user credentials (you can modify this method).
    private boolean isValidCredentials(String email, String password) {
        // Add your validation logic here, e.g., check against a database or use Firebase.
        return !email.isEmpty() && !password.isEmpty();
    }

    // Navigate to the main activity (you can modify this method).
    private void navigateToMainActivity() {
        // Implement the navigation logic to your main activity.
        startActivity(new Intent(SignIn_Activity.this, MainActivity.class));
        finish();
    }
}
