package com.example.secureshield20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class newItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
    }

    public void saveItem(View view){

        Intent intent = new Intent(this, VaultActivity.class);
        startActivity(intent);
    }

    public void goBack(View view){

        Intent intent = new Intent(this, VaultActivity.class);
        startActivity(intent);
    }
}