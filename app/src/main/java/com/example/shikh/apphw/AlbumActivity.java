package com.example.shikh.apphw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shikh.apphw.JsonPlaceHolder.Client;
import com.example.shikh.apphw.JsonPlaceHolder.JSONPlaceHolder;
import com.example.shikh.apphw.R;
import com.example.shikh.apphw.adapters.AlbumAdapter;
import com.example.shikh.apphw.models.album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumActivity extends AppCompatActivity {

    RecyclerView rvAlbumList;
    AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        rvAlbumList =(RecyclerView) findViewById(R.id.rvAlbumList);
        albumAdapter = new AlbumAdapter(new ArrayList<album>());
        rvAlbumList.setLayoutManager(new LinearLayoutManager(this));
        rvAlbumList.setAdapter(albumAdapter);

        Client.getInstance().getapi().getAlbum().enqueue(new Callback<ArrayList<album>>() {
            @Override
            public void onResponse(Call<ArrayList<album>> call, Response<ArrayList<album>> response) {
                albumAdapter.setAlbums(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<album>> call, Throwable t) {

            }
        });


    }
}
