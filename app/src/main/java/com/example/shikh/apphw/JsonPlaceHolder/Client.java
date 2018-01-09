package com.example.shikh.apphw.JsonPlaceHolder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shikh on 09-01-2018.
 */

public class Client {   //this is a singleton class

    private final Retrofit r = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final JSONPlaceHolder api = r.create(JSONPlaceHolder.class);

    public Retrofit getRetrofit(){
        return r;
    }

    public JSONPlaceHolder getapi(){
        return api;
    }

    private static final Client ourInstance = new Client();
    private Client() {}

    public static Client getInstance(){
        return ourInstance;
    }
}
