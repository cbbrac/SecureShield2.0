package com.example.secureshield20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class VaultActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vault);

        listView = findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Facebook");
        arrayList.add("Instagram");
        arrayList.add("GMail");
        arrayList.add("YouTube");
        arrayList.add("Netflix");
        arrayList.add("Disney+");
        arrayList.add("Spotify");
        arrayList.add("Github");
        arrayList.add("StackOverflow");
        arrayList.add("Reddit");
        arrayList.add("Target");
        arrayList.add("Amazon");
        arrayList.add("U.S. Bank");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(VaultActivity.this, "You will edit: " + arrayList.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
}