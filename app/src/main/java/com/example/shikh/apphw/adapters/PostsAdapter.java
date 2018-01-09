package com.example.shikh.apphw.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.shikh.apphw.R;
import com.example.shikh.apphw.models.posts;

import java.util.ArrayList;

/**
 * Created by shikh on 09-01-2018.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    ArrayList<posts> Posts;

    public PostsAdapter(ArrayList<posts> Posts) {
        this.Posts = Posts;
    }

    public void setPosts(ArrayList<posts> posts_1) {
        this.Posts = posts_1;
        notifyDataSetChanged();
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView = li.inflate(R.layout.list_item_posts,parent,false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bindView(Posts.get(position));
    }

    @Override
    public int getItemCount() {
        return Posts.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView post_tv_title , post_tv_body;

        public PostViewHolder(View itemView) {
            super(itemView);
            post_tv_body = itemView.findViewById(R.id.post_tv_body);
            post_tv_title = itemView.findViewById(R.id.post_tv_title);
        }

        public void bindView(posts post){
            post_tv_body.setText(post.getBody());
            post_tv_title.setText(post.getTitle());
        }
    }
}
