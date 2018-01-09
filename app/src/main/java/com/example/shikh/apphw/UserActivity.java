package com.example.shikh.apphw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.shikh.apphw.JsonPlaceHolder.Client;
import com.example.shikh.apphw.R;
import com.example.shikh.apphw.adapters.UserAdapter;
import com.example.shikh.apphw.models.posts;
import com.example.shikh.apphw.models.users;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    public static final String TAG ="User";

    RecyclerView rvUsersList;
    UserAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        rvUsersList =(RecyclerView) findViewById(R.id.rvUsersList);
        rvUsersList.setLayoutManager(new LinearLayoutManager(this));
        usersAdapter = new UserAdapter(new ArrayList<users>());
        rvUsersList.setAdapter(usersAdapter);

        Client.getInstance().getapi().getUsers().enqueue(new Callback<ArrayList<users>>() {
            @Override
            public void onResponse(Call<ArrayList<users>> call, Response<ArrayList<users>> response) {
                usersAdapter.setUser(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<users>> call, Throwable t) {

            }
        });


    }
}
