package com.example.myapplication.Model;

public class Users {
    private  String name ,email;
    private  int id;

    public boolean isShow ( ) {
        return show;
    }


    public Users ( boolean show ) {
        this.show = show;
    }

    private boolean show;

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public int getId ( ) {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public Users ( String name , String email , int id , boolean show) {
        this.show = show;
        this.name = name;
        this.email = email;
        this.id = id;
    }
}
