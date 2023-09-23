package com.example.myapplication.Model;

import java.util.ArrayList;
import java.util.List;

public class List_Users {
    public  static List<Users> getlist (){
        List<Users> users = new ArrayList<> (  );
        users.add ( new Users ( "amir","adad@sdasd.com",1 ,true) );
        users.add ( new Users ( "amir","adad@sdasd.com",1 ,true) );
        users.add ( new Users ( "hosein","amir@sdasd.com",2 ,true) );
        users.add ( new Users ( "fati","fati@sdasd.com",3 ,false) );


        return users;
    }


}
