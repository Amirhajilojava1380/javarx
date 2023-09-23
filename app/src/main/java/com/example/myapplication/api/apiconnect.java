package com.example.myapplication.api;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;


public interface apiconnect {

    @GET("getPost.php")
    Observable< List<model> > getjava( );



}
