package com.example.secureshield20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class NewAndEditAccountActivity extends AppCompatActivity {

    MyApplication myApplication = new MyApplication();
    List<Account> accountList = new ArrayList<>();
    FloatingActionButton clipboard;

    EditText name, username, password, website, uri;
    public String passEncrypt, copyPassword;
    int id;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_and_edit_item);

        accountList = myApplication.getAccountList();

        name = findViewById(R.id.accountName);
        username = findViewById(R.id.accountUsername);
        password = findViewById(R.id.accountPassword);
        website = findViewById(R.id.accountWebsite);
        uri = findViewById(R.id.accountUri);

        clipboard = findViewById(R.id.button4);
        ClipboardManager myClipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copyPassword = password.getText().toString();
                ClipData clip = ClipData.newPlainText("Pass", password.getText().toString());
                myClipboard.setPrimaryClip(clip);

                Toast.makeText(NewAndEditAccountActivity.this, "Password copied!", Toast.LENGTH_SHORT).show();
            }
        });


        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        //Toast.makeText(this, "Sent ID #" + String.valueOf(id), Toast.LENGTH_SHORT).show();

        Account account = null;

        if (id >= 0) {
            for (Account acc : accountList) {
                if (acc.getId() == id) {
                    account = acc;
                }
            }
            name.setText(account.getName());
            username.setText(account.getUsername());
            password.setText(account.getPassword());
            website.setText(account.getWebsite());
            uri.setText(account.getUri());
        } else {}
    }

    public void goBack(View view){
        Intent intent = new Intent(NewAndEditAccountActivity.this, VaultActivity.class);
        startActivity(intent);
    }

    public void encryptionPass(View view) {
        PasswordGenerator pass = new PasswordGenerator();
        pass.generatePassword(20);
        passEncrypt = pass.getPasswordStr();
        password.setText(passEncrypt);
        try {
            //Toast.makeText(this, "Password created successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            //Toast.makeText(this, "Password not created", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveItem(View view){

        String nameString = name.getText().toString();
        String usernameString = username.getText().toString();
        passEncrypt = password.getText().toString();
        String websiteString = website.getText().toString();
        String uriString = uri.getText().toString();

        if (id >= 0) {
            // Update
            Account updatedAccount = new Account(id, nameString, usernameString, passEncrypt,
                    websiteString, uriString);
            accountList.set(id, updatedAccount);
            myApplication.setNextId(id);

            //Toast.makeText(this, "Account's ID is: " + String.valueOf(id), Toast.LENGTH_SHORT)
            // .show();
        } else {
            // Add
            int nextId = myApplication.getNextId();

            Account newAccount = new Account(nextId, nameString, usernameString, passEncrypt,
                    websiteString, uriString);

            accountList.add(newAccount);
            //Toast.makeText(this, "Element's ID: " + String.valueOf(nextId), Toast.LENGTH_SHORT)
            // .show();
            myApplication.setNextId(nextId++);

            Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "Next ID is: " + String.valueOf(myApplication.getNextId()),
            // Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(NewAndEditAccountActivity.this, VaultActivity.class);
        startActivity(intent);
    }

    public void deleteItem(View view) {
        // TODO code function logic, this is executed when the red button is pressed
        //Toast.makeText(this, "Account Deleted Successfully", Toast.LENGTH_SHORT).show();
    }
}