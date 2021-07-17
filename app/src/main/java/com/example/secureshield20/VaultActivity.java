package com.example.secureshield20;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VaultActivity extends AppCompatActivity {

    private static final String TAG = "Accounts List";

    MyApplication myApplication = new MyApplication();
    List<Account> accountList = new ArrayList<>();


    private RecyclerView recyclerView;
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> usernameList = new ArrayList<>();
    ArrayList<String> passList = new ArrayList<>();
    ArrayList<String> webList = new ArrayList<>();
    ArrayList<String> uriList = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Switch mySwitch;        // here for debugging purposes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vault);

        accountList = myApplication.getAccountList();

        Collections.sort(accountList, Account.AccountsSortAZ);
        //mAdapter.notifyDataSetChanged();

        mySwitch = findViewById(R.id.switch1);

        Log.d(TAG, "onCreate: " + accountList.toString());
        Toast.makeText(this, "Accounts here: " + accountList.size(), Toast.LENGTH_LONG).show();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        try {
            JSONObject obj = new JSONObject(loadJSONfromAssets());

            JSONArray accountsArray = obj.getJSONArray("account");
            for (int i = 0; i < accountsArray.length(); i++) {
                JSONObject accounts = accountsArray.getJSONObject(i);
                nameList.add(accounts.getString("name"));
                usernameList.add(accounts.getString("username"));
                passList.add(accounts.getString("password"));
                webList.add(accounts.getString("website"));
                uriList.add(accounts.getString("uri"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(VaultActivity.this, nameList, usernameList, passList, webList, uriList);
        recyclerView.setAdapter(adapter);
    }

    private String loadJSONfromAssets() {
        String json = null;
        try{
            InputStream is = getAssets().open("securityShield.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8" );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } return json;
    }

    public void goToSettings(View view) {
        Intent intent = new Intent(VaultActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void addItem(View view) {
        Intent intent = new Intent(VaultActivity.this, NewAccountActivity.class);
        startActivity(intent);
    }

    public void switchClick(View view) {
        if (view.getId()==R.id.switch1) {
            if (mySwitch.isChecked()) {
                Collections.sort(accountList, Account.AccountsSortById);
                Toast.makeText(this, "Sorted by ID", Toast.LENGTH_SHORT).show();
            } else {
                Collections.sort(accountList, Account.AccountsSortAZ);
                Toast.makeText(this, "Sorted by name", Toast.LENGTH_SHORT).show();
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    public void clipboardButton(View view) {
        // TODO this function should copy the password of the selected account
    }
}