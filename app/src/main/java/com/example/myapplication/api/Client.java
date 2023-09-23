package com.example.myapplication.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    public  static String url = "http://192.168.1.6/javarx/";
    public static Retrofit retrofit = null;

    public  static Retrofit getclient (){

        if ( retrofit==null ){

            retrofit = new Retrofit.Builder ( )
                    .baseUrl ( url )
                    .addConverterFactory ( GsonConverterFactory.create () )
                    .addCallAdapterFactory ( RxJava3CallAdapterFactory.create() )
                    .build ();

        }

        return retrofit;
    }



}
