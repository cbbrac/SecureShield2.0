package com.example.secureshield20;

/** This is the launcher activity of the app. It allows the user to input the username and password
 * data of the app. If the data is already stored, it will create an intent to go to the
 * VaultActivity. If the data doesn't exist, the user will have to create an account. *
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    private EditText eUsername;
    private EditText ePassword;
    private String Username;
    private String Password;
    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eUsername = findViewById(R.id.userId);
        ePassword = findViewById(R.id.passwordId);
    }

    // Gets the inputs from the user and set them in variables that will be stored
    // in SharedPreferences.
    public void createAccount(View view) {
        String inputUsername = eUsername.getText().toString();
        String inputPass = ePassword.getText().toString();
        Username = inputUsername;
        Password = inputPass;
        String secShield = "securityShield";
        String txtName = secShield+".txt";

        SharedPreferences sharedPreferences = getSharedPreferences(txtName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("USERNAME", Username);
        editor.putString("PASSWORD", Password);
        editor.apply();
        Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show();
    }

    // Calls the authentication method taking 2 arguments.
    // If the authentication is correct, creates the intent to the vault.
    // If don't it will display a toast
    public void logIn(View view) {

        String inputUsername = eUsername.getText().toString();
        String inputPass = ePassword.getText().toString();

        isValid = authentication(inputUsername, inputPass);
        if (!isValid) {                                            // TODO this should be if(!isValid){
            Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, VaultActivity.class);
            startActivity(intent);
        }
    }

    // Method to compare the input of the editText to the data stored in SharedPreferences.
    public boolean authentication(String name, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("securityShield.txt", Context.MODE_PRIVATE);
        if (name.equals(sharedPreferences.getString("USERNAME","")) && password.equals(sharedPreferences.getString("PASSWORD",""))) {
            return true;
        }
        return false;
    }

}

