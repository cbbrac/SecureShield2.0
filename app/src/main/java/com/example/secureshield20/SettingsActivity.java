package com.example.secureshield20;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    Button saveButton;
    EditText settingsNewPassword, settingsConfirmPassword, settingsID;
    TextView passwordError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //User inputs new password
        settingsNewPassword = findViewById(R.id.settingsNewPassword);
        //user inputs password again to confirm
        settingsConfirmPassword = findViewById(R.id.settingsConfirmPassword);
        //error message to display if password does not match, or is left blank.
        passwordError = findViewById(R.id.settingsConfirmPassword);
    }

    private boolean validatePassword(){
        String inputPassword = settingsNewPassword.getText().toString();
        String confirmPasswordInput = settingsConfirmPassword.getText().toString();

        if(inputPassword.isEmpty()){
            // error message if the field is left blank
            passwordError.setText("Field cannot be empty.");
            return false;
        } if (inputPassword.length() < 5){
            //error message if the password length is less than 5 characters
            passwordError.setText("Password must be more than 5 characters");
            return false;
        } if (!inputPassword.equals(confirmPasswordInput)){
            // error message if the confirm password does not match the new password
            passwordError.setText("Passwords do not match.");
            return false;
        } else {
            passwordError.setText("Passwords match!");
            return true;
        }
    }
}
