package com.example.secureshield20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class editActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    Intent editIntent = getIntent();

    public void saveItem(View view){

        Intent intent = new Intent(this, VaultActivity.class);
        startActivity(intent);
    }

    public void deleteItem(View view) {

    }
}