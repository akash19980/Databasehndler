package com.example.lenovo.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper
{
    private static final int Database_version=2;
    private static final String Database_name="Khaate";
    private static final String Table_name="hisaab";
    private static final String key_id="id";
    private static final String key_Name="name";
    private static final String key_phonenumber="phone";

    public DatabaseHandler(Context context) {
        super(context,Database_name,null,Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createtable="Create table "+Table_name+"( "+key_id+" Integer Primary key, "+key_Name+" Text,"+key_phonenumber+" Text"+")";
        sqLiteDatabase.execSQL(createtable);
Log.d("Create table",createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("Drop table if exists "+ Table_name);
onCreate(sqLiteDatabase);
    }

void addContact(contact contact)
{
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(key_Name,contact.getName());
    values.put(key_phonenumber,contact.getPhone());
    db.insert(Table_name,null,values);
    db.close();
}
public List<contact>getcontact()
{
    List<contact> contactlist=new ArrayList<contact>();
    String selectquery="Select* from "+Table_name;
    SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
    Cursor cursor = sqLiteDatabase.rawQuery(selectquery,null);
    if(cursor.moveToFirst())
    {
        do {
        contact contact=new contact();
        contact.setId(Integer.parseInt(cursor.getString(0)));
            contact.setName(cursor.getString(1));
            contact.setPhone(cursor.getString(2));
        contactlist.add(contact);
        }
        while(cursor.moveToNext());
    }
    return contactlist;
}
}
