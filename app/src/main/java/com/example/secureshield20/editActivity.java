package com.example.secureshield20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class editActivity extends AppCompatActivity {

    private static final String TAG = "EDIT ACTIVITY";
    MyApplication myApplication = new MyApplication();
    List<String> accountList = new ArrayList<>();

    EditText name, username, password, website, uri;
    int id;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Log.d(TAG, "ID of element accessed: " + String.valueOf(id));
        accountList = myApplication.getAccountList();

        name = findViewById(R.id.edit_accountName);
        username = findViewById(R.id.edit_accountUsername);
        password = findViewById(R.id.edit_accountPassword);
        website = findViewById(R.id.edit_accountWebsite);
        uri = findViewById(R.id.edit_accountUri);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        Toast.makeText(this, "Sent ID #" + String.valueOf(id), Toast.LENGTH_SHORT).show();

        Account account = null;

//        if (id >= 0) {
//            for (Account acc : accountList) {
//                if (acc.getId() == id) {
//                    account = acc;
//                }
//            }
//            name.setText(account.getName());
//            username.setText(account.getUsername());
//            password.setText(account.getPassword());
//            website.setText(account.getWebsite());
//            uri.setText(account.getUri());
//        }
    }

    public void saveItem(View view){
        String stringName = name.getText().toString();
        String stringUsername = username.getText().toString();
        String stringPassword = password.getText().toString();
        String stringWebsite = website.getText().toString();
        String stringUri = uri.getText().toString();
//
//        Account updatedAccount = new Account(id, stringName, stringUsername, stringPassword,
//                stringWebsite, stringUri);
//        accountList.set(id, updatedAccount);

        Intent intent = new Intent(this, VaultActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Account Modified Successfully", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Element's ID: " + String.valueOf(id), Toast.LENGTH_SHORT).show();
    }

    public void deleteItem(View view) {
        // TODO code function logic, this is executed when the red button is pressed
        //Toast.makeText(this, "Account Deleted Successfully", Toast.LENGTH_SHORT).show();
    }
}