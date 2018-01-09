package com.example.shikh.apphw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.shikh.apphw.JsonPlaceHolder.Client;
import com.example.shikh.apphw.R;
import com.example.shikh.apphw.adapters.TodoAdapter;
import com.example.shikh.apphw.models.todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoActivity extends AppCompatActivity {

    TodoAdapter adapter;
    public static final String TAG = "Todo";
    RecyclerView rvTodoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        Log.d(TAG, "onCreate: ");
        rvTodoList = (RecyclerView) findViewById(R.id.rvTodoList);
        adapter = new TodoAdapter(new ArrayList<todo>());
        Log.d(TAG, "onCreate: ");
        rvTodoList.setLayoutManager(new LinearLayoutManager(this));
        rvTodoList.setAdapter(adapter);

        Client.getInstance().getapi().getTodo().enqueue(new Callback<ArrayList<todo>>() {
            @Override
            public void onResponse(Call<ArrayList<todo>> call, Response<ArrayList<todo>> response) {
                adapter.setTasks(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<todo>> call, Throwable t) {

            }
        });
    }
}
