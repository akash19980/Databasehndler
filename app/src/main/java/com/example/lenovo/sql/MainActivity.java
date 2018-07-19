package com.example.lenovo.sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);

    databaseHandler.addContact(new contact("Shubham","8528450489"));
    databaseHandler.addContact(new contact("Salman bhai","9146 agge appe lalin"));
    databaseHandler.addContact(new contact("Salman","98190 na lagge na labbe"));
        Toast.makeText(this, "Inserting", Toast.LENGTH_SHORT).show();
        Log.d("Reading","menu sab padhna anda hai im not illetrate");
        List<contact> contacts=databaseHandler.getcontact();
        for(contact cn : contacts)
        {
            String log="id"+cn.getId()+",Name:"+cn.getName()+"Phone Number "+cn.getPhone();
            Log.d("NAME",log);
        }
    }
}
