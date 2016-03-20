package com.example.andoird.agenda;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Add contact to list
     * @param view
     */
    public void addContact(View view) {
        Contact contact = new Contact();

        EditText fieldName = (EditText) findViewById(R.id.contact_name);
        EditText fieldPhoneNumber = (EditText) findViewById(R.id.contact_phonenumber);

        contact.setName(fieldName.getText().toString());
        contact.setPhoneNumber(fieldPhoneNumber.getText().toString());

        // 1. Instantiate an AlertDialog.Builder with its constructor
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
//        builder.setMessage("Contato " + contact.getName()  + " adicionado com sucesso")
//                .setTitle("Adição de contato");

        // 3. Get the AlertDialog from create()
//        AlertDialog dialog = builder.create();

        // Show Alert
        Toast.makeText(
                getApplicationContext(),
                "Contato " + contact.getName()  + " adicionado com sucesso",
                Toast.LENGTH_LONG
        ).show();

        //TextView message = (TextView) findViewById(R.id.message);
        //message.setText("Contato " + contact.getName()  + " adicionado com sucesso");

        contacts.add(contact);
    }

    /**
     * Change view to list contacts
     * @param view
     */
    public void listContacts(View view) {
        Intent viewList = new Intent(this, MainList.class);

        JSONArray json = new JSONArray();

        for (Contact contact : contacts) {
            json.put(contact.toJson());
        }

        System.out.println(json);

        viewList.putExtra("contacts", json.toString());

        if (viewList.resolveActivity(getPackageManager()) != null) {
            startActivity(viewList);
        }

    }
}
