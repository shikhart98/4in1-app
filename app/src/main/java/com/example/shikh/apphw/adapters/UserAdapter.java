package com.example.shikh.apphw.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shikh.apphw.R;
import com.example.shikh.apphw.models.users;

import java.util.ArrayList;

/**
 * Created by shikh on 09-01-2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    ArrayList<users> User;

    public UserAdapter(ArrayList<users> user) {
        this.User = user;
    }

    public void setUser(ArrayList<users> user) {
        this.User = user;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        return new UserViewHolder(li.inflate(R.layout.list_item_users, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bindView(User.get(position));
    }

    @Override
    public int getItemCount() {
        return User.size();
    }


    static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView users_tv_username, users_tv_name, users_tv_email, users_tv_phone;

        public UserViewHolder(View itemView) {
            super(itemView);
            users_tv_email = itemView.findViewById(R.id.users_tv_email);
            users_tv_phone = itemView.findViewById(R.id.users_tv_phone);
            users_tv_name = itemView.findViewById(R.id.users_tv_name);
            users_tv_username = itemView.findViewById(R.id.users_tv_username);
        }

        public void bindView(users user) {
            users_tv_email.setText(user.getEmail());
            users_tv_name.setText(user.getName());
            users_tv_phone.setText(user.getPhone());
            users_tv_username.setText(user.getUsername());
        }
    }
}
