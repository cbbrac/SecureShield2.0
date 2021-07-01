package com.example.secureshield20;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VaultActivity extends AppCompatActivity {

    private static final String TAG = "Accounts List";

    MyApplication myApplication = new MyApplication();
    List<Account> accountList = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Switch mySwitch;

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
        
        recyclerView = findViewById(R.id.rv_accountsList);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerViewAdapter(accountList, this);
        recyclerView.setAdapter(mAdapter);
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
}