package com.example.shikh.apphw.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shikh.apphw.R;
import com.example.shikh.apphw.models.album;

import java.util.ArrayList;

/**
 * Created by shikh on 09-01-2018.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    ArrayList<album> albums;

    public AlbumAdapter(ArrayList<album> arr_Albums) {
        this.albums = arr_Albums;
    }

    public void setAlbums(ArrayList<album> arr_Albums){
        this.albums = arr_Albums ;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView = li.inflate(R.layout.list_item_album, parent, false);
        return new AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        holder.bindView(albums.get(position));
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    static class AlbumViewHolder extends RecyclerView.ViewHolder {

        TextView album_tv_title;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            album_tv_title = itemView.findViewById(R.id.album_tv_title);
        }

        public void bindView(album album) {
            album_tv_title.setText(album.getTitle());
        }
    }
}
