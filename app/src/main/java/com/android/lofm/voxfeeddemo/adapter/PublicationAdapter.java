package com.android.lofm.voxfeeddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.android.lofm.voxfeeddemo.model.Publication;

import java.util.ArrayList;

/**
 * Created by Omar F Martinez on 1/13/17.
 */

public class PublicationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Publication> publications;

    public PublicationAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return publications.size();
    }

    public void setPublications(ArrayList<Publication> publications) {
        this.publications = publications;
    }
}
