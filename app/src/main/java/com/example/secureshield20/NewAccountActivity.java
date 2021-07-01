package com.example.secureshield20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewAccountActivity extends AppCompatActivity {

    MyApplication myApplication = new MyApplication();
    List<Account> accountList = new ArrayList<>();

    EditText name, username, password, website, uri;
    int nextId;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        accountList = myApplication.getAccountList();

        name = findViewById(R.id.accountName);
        username = findViewById(R.id.accountUsername);
        password = findViewById(R.id.accountPassword);
        website = findViewById(R.id.accountWebsite);
        uri = findViewById(R.id.accountUri);
    }

    public void goBack(View view){
        Intent intent = new Intent(NewAccountActivity.this, VaultActivity.class);
        startActivity(intent);
    }

    public void saveItem(View view){

        nextId = myApplication.getNextId();
        String nameString = name.getText().toString();
        String usernameString = username.getText().toString();
        String passwordString = password.getText().toString();
        String websiteString = website.getText().toString();
        String uriString = uri.getText().toString();

        Account newAccount = new Account(nextId, nameString, usernameString, passwordString,
                websiteString, uriString);

        accountList.add(newAccount);
        Toast.makeText(this, "Element's ID: " + String.valueOf(nextId), Toast.LENGTH_SHORT).show();
        myApplication.setNextId(nextId++);

        Intent intent = new Intent(NewAccountActivity.this, VaultActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Next ID is: " + String.valueOf(nextId), Toast.LENGTH_SHORT).show();
    }
}