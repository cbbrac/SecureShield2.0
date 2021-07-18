package com.example.secureshield20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.security.ProviderException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.security.NoSuchAlgorithmException;
import java.security.ProviderException;
import java.security.SecureRandom;
import java.util.*;

public class NewAccountActivity extends AppCompatActivity {

    MyApplication myApplication = new MyApplication();
    List<String> accountList = new ArrayList<>();

    EditText name, username, password, website, uri;
    //TextView password;
    public String sName,sUsername, sWeb, sUri, nameT, passEncrypt;
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

    public void encryptionPass(View view) {
        PasswordGenerator pass = new PasswordGenerator();
        pass.generatePassword(20);
        passEncrypt = pass.getPasswordStr();
        password.setText(passEncrypt);
        try {
            Toast.makeText(this, "Password created successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Password not created", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveItem(View view){

        nextId = myApplication.getNextId();
        sName = name.getText().toString();
        sUsername= username.getText().toString();
        passEncrypt = password.getText().toString();
        sWeb = website.getText().toString();
        sUri= uri.getText().toString();
        nameT = myApplication.setNameTxt(sName);
        accountList.add(nameT);

        //String txt = ".txt";

        SharedPreferences sharedPreferences = getSharedPreferences(nameT+".txt", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME", sName);
        editor.putString("USERNAME", sUsername);
        editor.putString("PASSWORD", passEncrypt);
        editor.putString("WEBSITE", sWeb);
        editor.putString("URI", sUri);
        editor.apply();

//        Account newAccount = new Account(nextId, nameString, usernameString, passwordString,
//                websiteString, uriString);
//
//        accountList.add(newAccount);
//        Toast.makeText(this, "Element's ID: " + String.valueOf(nextId), Toast.LENGTH_SHORT).show();
//        myApplication.setNextId(nextId++);

        Intent intent = new Intent(NewAccountActivity.this, VaultActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Next ID is: " + String.valueOf(nextId), Toast.LENGTH_SHORT).show();
    }
}