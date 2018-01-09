package com.example.shikh.apphw.JsonPlaceHolder;

import com.example.shikh.apphw.models.album;
import com.example.shikh.apphw.models.posts;
import com.example.shikh.apphw.models.todo;
import com.example.shikh.apphw.models.users;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shikh on 09-01-2018.
 */

public interface JSONPlaceHolder {
    @GET("posts")
    Call<ArrayList<posts>> getPosts();

    @GET("users")
    Call<ArrayList<users>> getUsers();

    @GET("todos")
    Call<ArrayList<todo>> getTodo();

    @GET("albums")
    Call<ArrayList<album>> getAlbum();
}
