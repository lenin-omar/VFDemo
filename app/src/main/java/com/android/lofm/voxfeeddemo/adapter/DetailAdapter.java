package com.android.lofm.voxfeeddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.android.lofm.voxfeeddemo.model.Publication;
import com.android.lofm.voxfeeddemo.rest.VolleySingleton;
import com.android.volley.toolbox.ImageLoader;

import java.util.List;
import java.util.Map;

/**
 * Created by Omar F Martinez on 1/13/17.
 */

public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private Map<String, String> postDetails;
    private ImageLoader imageLoader;

    public DetailAdapter(Context context) {
        this.context = context;
        imageLoader = VolleySingleton.getInstance(context).getImageLoader();
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
