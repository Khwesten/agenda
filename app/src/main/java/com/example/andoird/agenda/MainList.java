package com.example.andoird.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonWriter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by NoteSamsung on 19/03/2016.
 */
public class MainList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);

        ListView listView = (ListView) findViewById(R.id.contact_list);

        Intent intent = getIntent();
        String contactsJson = intent.getStringExtra("contacts");

        JSONArray contacts = null;
        ArrayList<String> list = new ArrayList<>();

        try {
            contacts = new JSONArray(contactsJson);

            for(int i = 0; i < contacts.length(); i++){
                String phoneNumber = contacts.getJSONObject(i).getString("phoneNumber");
                String name = contacts.getJSONObject(i).getString("name");

                list.add("Name: " + name + " - phone: " + phoneNumber);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                list
        );


        // Assign adapter to ListView
        listView.setAdapter(adapter);
    }

}
