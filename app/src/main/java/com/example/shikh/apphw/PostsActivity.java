package com.example.shikh.apphw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shikh.apphw.JsonPlaceHolder.Client;
import com.example.shikh.apphw.R;
import com.example.shikh.apphw.adapters.AlbumAdapter;
import com.example.shikh.apphw.adapters.PostsAdapter;
import com.example.shikh.apphw.models.album;
import com.example.shikh.apphw.models.posts;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {

    RecyclerView rvPostsList;
    PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        rvPostsList =(RecyclerView) findViewById(R.id.rvPostsList);
        postsAdapter = new PostsAdapter(new ArrayList<posts>());
        rvPostsList.setLayoutManager(new LinearLayoutManager(this));
        rvPostsList.setAdapter(postsAdapter);

        Client.getInstance().getapi().getPosts().enqueue(new Callback<ArrayList<posts>>() {
            @Override
            public void onResponse(Call<ArrayList<posts>> call, Response<ArrayList<posts>> response) {
                postsAdapter.setPosts(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<posts>> call, Throwable t) {

            }
        });


    }
}
