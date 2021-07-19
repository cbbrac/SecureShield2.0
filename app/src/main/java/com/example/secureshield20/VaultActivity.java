package com.example.secureshield20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**Activity that will take the data from the RecyclerViewAdapter and will display it to the user.
 * It contains methods to create intents to the Settings and the New and Edit Activities.
 */

public class VaultActivity extends AppCompatActivity {

    private static final String TAG = "Accounts List";

    MyApplication myApplication = new MyApplication();
    List<Account> accountList = new ArrayList<>();


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vault);

        accountList = myApplication.getAccountList();
        Collections.sort(accountList, Account.AccountsSortAZ);

        Log.d(TAG, "onCreate: " + accountList.toString());
        Toast.makeText(this, "Saved Accounts: " + accountList.size(), Toast.LENGTH_LONG).show();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerViewAdapter(accountList, this);
        recyclerView.setAdapter(mAdapter);
    }

    //Method to create an intent to the SettingsActivity when the settings' button is pressed.
    public void goToSettings(View view) {
        Intent intent = new Intent(VaultActivity.this, SettingsActivity.class);
        startActivity(intent);
    }
    //Method to create an intent to the NewAndEditActivity when the add button is pressed.
    public void addItem(View view) {
        Intent intent = new Intent(VaultActivity.this, NewAndEditAccountActivity.class);
        startActivity(intent);
    }
}