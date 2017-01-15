package com.android.lofm.voxfeeddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Map;

/**
 * Created by Omar F Martinez on 1/13/17.
 */

public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private Map<String, String> postDetails;

    public DetailAdapter(Context context) {
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
        return postDetails.size();
    }

    public void setSelectedPublication(Map<String, String> postDetails) {
        this.postDetails = postDetails;
    }
}
