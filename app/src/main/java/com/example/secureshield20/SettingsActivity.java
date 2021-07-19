package com.example.secureshield20;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**Activity that allows to change the data to access to the app. If the new username or password
 * fulfills the requirements, it rewrites the .txt file of SharedPreferences and creates an intent
 * to go back to the Vault screen.
 */

public class SettingsActivity extends AppCompatActivity {

    EditText settingsUsername, settingsNewPassword, settingsConfirmPassword, settingsID;
    TextView passwordError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settingsUsername = findViewById(R.id.settingsMasterUsername);
        //User inputs new password
        settingsNewPassword = findViewById(R.id.settingsNewPassword);
        //user inputs password again to confirm
        settingsConfirmPassword = findViewById(R.id.settingsConfirmPassword);
        //error message to display if password does not match, or is left blank.
        passwordError = findViewById(R.id.settingsConfirmPassword);

        SharedPreferences sharedPref = getSharedPreferences("securityShield.txt", Context.MODE_PRIVATE);

        String usernameLoaded = sharedPref.getString("USERNAME","");
        String passwordLoaded = sharedPref.getString("PASSWORD","");

        settingsUsername.setText(usernameLoaded);
        settingsNewPassword.setText(passwordLoaded);
    }

    //Method called when Save button is clicked. It takes the inputs from the EditText fields,
    //stores them into variables and saves them in SharedPreferences.
    public void changePassword(View view){
        String inputUsername = settingsUsername.getText().toString();
        String inputPassword = settingsNewPassword.getText().toString();
        String confirmPasswordInput = settingsConfirmPassword.getText().toString();

        if(inputPassword.isEmpty()){
            // error message if the field is left blank
            Toast.makeText(this, "Field cannot be empty", Toast.LENGTH_SHORT).show();
        } if (inputPassword.length() < 5){
            //error message if the password length is less than 5 characters
            Toast.makeText(this, "Password must be more than 5 characters", Toast.LENGTH_SHORT).show();
        } if (!inputPassword.equals(confirmPasswordInput)){
            // error message if the confirm password does not match the new password
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences sharedPref = getSharedPreferences("securityShield.txt", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();

            editor.putString("USERNAME", inputUsername);
            editor.putString("PASSWORD", inputPassword);
            editor.apply();

            Intent intent = new Intent(this, VaultActivity.class);
            startActivity(intent);

            Toast.makeText(this, "Login changed successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}
