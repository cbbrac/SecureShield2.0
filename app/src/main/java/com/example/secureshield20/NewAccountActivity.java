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
    public String sName,sUsername, sPass, sWeb, sUri, nameT, passEncrypt, encrypt;
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

    public String encryptionPass() {
            try {
                // creating the object of SecureRandom and getting instance
                // By using getInstance() method
                SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

                // Declaring the byte Array & converting the string into byte
                byte[] b = sPass.getBytes();

                // generating user-specified number of random bytes using nextBytes() method
                sr.nextBytes(b);
                String encrypt = Arrays.toString(b);
            }

            catch (NoSuchAlgorithmException e) {
                //("Exception thrown : " + e);
            }
            catch (ProviderException e) {

                //("Exception thrown : " + e);
            }
        }



    public void saveItem(View view){

        nextId = myApplication.getNextId();
        sName = name.getText().toString();
        sUsername= username.getText().toString();
        sPass = password.getText().toString();
        sWeb = website.getText().toString();
        sUri= uri.getText().toString();
        nameT = myApplication.setNameTxt(sName);
        accountList.add(nameT);

        //String txt = ".txt";

        SharedPreferences sharedPreferences = getSharedPreferences(nameT+".txt", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        encryptionPass();
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