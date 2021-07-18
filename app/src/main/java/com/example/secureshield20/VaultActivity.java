package com.example.secureshield20;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
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
    List<String> accountList = new ArrayList<>();


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Switch mySwitch;        // here for debugging purposes
    TextView nameItem;
    TextView userItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vault);

        accountList = myApplication.getAccountList();
//        SharedPreferences sharedPref = getSharedPreferences("Netflix.txt", Context.MODE_PRIVATE);
//        String name = sharedPref.getString("NAME", "");
//        String username = sharedPref.getString("USERNAME", "");
//
//        nameItem.setText(name);
//        userItem.setText(username);


//        SharedPreferences sharedPref1 = getSharedPreferences("Twitter.txt", Context.MODE_PRIVATE);
//        String name1 = sharedPref1.getString("name", "");
//        String username1 = sharedPref1.getString("username", "");
//
//        SharedPreferences sharedPref2 = getSharedPreferences("Theran.txt", Context.MODE_PRIVATE);
//        String name2 = sharedPref2.getString("name", "");
//        String username2 = sharedPref2.getString("username", "");
//
//        SharedPreferences sharedPref3 = getSharedPreferences("Instagram.txt", Context.MODE_PRIVATE);
//        String name3 = sharedPref3.getString("name", "");
//        String username3 = sharedPref3.getString("username", "");
//
//        SharedPreferences sharedPref4 = getSharedPreferences("Netflix.txt", Context.MODE_PRIVATE);
//        String name4 = sharedPref4.getString("name", "");
//        String username4 = sharedPref4.getString("username", "");
//
//        SharedPreferences sharedPref5 = getSharedPreferences("DisneyPlus.txt", Context.MODE_PRIVATE);
//        String name5 = sharedPref5.getString("name", "");
//        String username5 = sharedPref5.getString("username", "");
//
//        SharedPreferences sharedPref6 = getSharedPreferences("Spotify.txt", Context.MODE_PRIVATE);
//        String name6 = sharedPref6.getString("name", "");
//        String username56 = sharedPref6.getString("username", "");

        mySwitch = findViewById(R.id.switch1);

        Log.d(TAG, "onCreate: " + accountList.toString());
        Toast.makeText(this, "Accounts here: " + accountList.size(), Toast.LENGTH_LONG).show();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void goToSettings(View view) {
        Intent intent = new Intent(VaultActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void addItem(View view) {
        Intent intent = new Intent(VaultActivity.this, NewAccountActivity.class);
        startActivity(intent);
    }

//    public void switchClick(View view) {
//        if (view.getId()==R.id.switch1) {
//            if (mySwitch.isChecked()) {
//                Collections.sort(accountList, Account.AccountsSortById);
//                Toast.makeText(this, "Sorted by ID", Toast.LENGTH_SHORT).show();
//            } else {
//                Collections.sort(accountList, Account.AccountsSortAZ);
//                Toast.makeText(this, "Sorted by name", Toast.LENGTH_SHORT).show();
//            }
//            mAdapter.notifyDataSetChanged();
//        }
//    }

    public void clipboardButton(View view) {
        // TODO this function should copy the password of the selected account
    }
}