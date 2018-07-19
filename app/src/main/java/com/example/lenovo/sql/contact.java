package com.example.lenovo.sql;

import android.provider.ContactsContract;

public class contact {
    int id;
    String name;
    String Phone_number;
    public contact(){}
    public contact(int id,String name,String Phone_number)
    {
        this.id=id;
        this.name=name;
        this.Phone_number=Phone_number;
    }
    public contact(String name,String Phone_number)
    {
        this.name=name;
        this.Phone_number= Phone_number;
    }
 public int getId()
 { return this.id; }
 public void setId(int id)
 { this.id=id; }
 public String getName()
 {return this.name;}
 public void setName(String name)
 {this.name=name;}
 public String getPhone()
 {return this.Phone_number;}
public void setPhone(String Phone_number)
{ this.Phone_number=Phone_number;}
}
