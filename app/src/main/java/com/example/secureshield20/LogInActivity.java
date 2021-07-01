package com.example.secureshield20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class LogInActivity extends AppCompatActivity {
    private  EditText eUsername;
    private  EditText ePassword;
    private String Username = "";
    private String Pass = "";
    boolean isValid = false;
    Map<String, String> map = new HashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eUsername = findViewById(R.id.userId);
        ePassword = findViewById(R.id.passwordId);
    }
    // Gets the inputs from the user and stores them in variables.
    public void createAccount(View view) {
        String inputUsername = eUsername.getText().toString();
        String inputPass = ePassword.getText().toString();
        Username = inputUsername;
        map.put(Username, inputPass);
    }

    // Calls the authentication method taking 2 arguments.
    // If the authentication is correct, creates the intent to the vault.
    // If don't it SHOULD display a toast (which is not working)
    public void logIn(View view){

        String inputUsername = eUsername.getText().toString();
        String inputPass = ePassword.getText().toString();

        isValid = authentication(inputUsername, inputPass);
        if(!isValid){                                       // TODO this should be if (!isValid){
            Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, VaultActivity.class);
            startActivity(intent);}
    }

    // Method to compare the input of the editText to the data stored.
    public boolean authentication(String name, String password){
        if (name.equals(Username) && password.equals(map.get(Username))){
            return true;
        } return false;
    }
}