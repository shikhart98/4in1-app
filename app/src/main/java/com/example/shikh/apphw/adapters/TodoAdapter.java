package com.example.shikh.apphw.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.shikh.apphw.R;
import com.example.shikh.apphw.models.album;
import com.example.shikh.apphw.models.todo;

import java.util.ArrayList;

/**
 * Created by shikh on 09-01-2018.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    ArrayList<todo> tasks;

    public TodoAdapter(ArrayList<todo> Tasks) {
        this.tasks = Tasks;
    }

    public void setTasks(ArrayList<todo> Tasks) {
        this.tasks = Tasks;
        notifyDataSetChanged();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView = li.inflate(R.layout.activity_todo,parent,false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
            holder.bindView(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    static class TodoViewHolder extends RecyclerView.ViewHolder{
        CheckBox checkBox;

        public TodoViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.todo_cb_title);
        }
        public void bindView(todo Todo) {
            checkBox.setText(Todo.getTitle());
            checkBox.setChecked(Todo.getCompleted());
        }
    }
}
