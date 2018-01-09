package com.example.shikh.apphw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ibtn_album, ibtn_posts,ibtn_users,ibtn_todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibtn_album = findViewById(R.id.ibtn_album);
        ibtn_posts = findViewById(R.id.ibtn_posts);
        ibtn_todo = findViewById(R.id.ibtn_todo);
        ibtn_users = findViewById(R.id.ibtn_users);

        ibtn_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , AlbumActivity.class);
                startActivity(i);
            }
        });

        ibtn_posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , PostsActivity.class);
                startActivity(i);
            }
        });

        ibtn_users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , UserActivity.class);
                startActivity(i);
            }
        });

        ibtn_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , TodoActivity.class);
                startActivity(i);
            }
        });

    }
}
