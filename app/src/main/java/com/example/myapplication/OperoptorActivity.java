package com.example.myapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Model.List_Users;
import com.example.myapplication.Model.Users;
import com.example.myapplication.adapter.PostAdapter;
import com.example.myapplication.api.Client;
import com.example.myapplication.api.apiconnect;
import com.example.myapplication.api.model;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;

public class OperoptorActivity extends AppCompatActivity {

    CompositeDisposable compositeDisposable =new CompositeDisposable (  );
    apiconnect request;

    PostAdapter postAdapter;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        request = Client.getclient ().create ( apiconnect.class );
        RecyclerView  recyclerView=findViewById ( R.id.recyclerview );
        recyclerView.setHasFixedSize ( true );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );


        compositeDisposable.add ( request.getjava ()
                .observeOn ( AndroidSchedulers.mainThread ())
                .subscribeOn ( Schedulers.io () ).subscribe ( new Consumer< List< model > > ( ) {
                    @Override
                    public void accept ( List< model > models ) throws Throwable {
                        postAdapter = new PostAdapter ( getApplicationContext () , models );
                        recyclerView.setAdapter ( postAdapter );


                    }
                } )


        );


    }

    @Override
    protected void onDestroy ( ) {
        super.onDestroy ( );
        compositeDisposable.clear ();
    }
}