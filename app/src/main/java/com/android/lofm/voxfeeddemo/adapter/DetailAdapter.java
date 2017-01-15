package com.android.lofm.voxfeeddemo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.lofm.voxfeeddemo.R;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;
import java.util.Map;

/**
 * Created by Omar F Martinez on 1/13/17.
 */

public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> postDetails;

    public DetailAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_card, parent, false);
        viewHolder = new DetailViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DetailViewHolder detailViewHolder = ((DetailAdapter.DetailViewHolder) holder);
        switch (position) {
            case 0:
                detailViewHolder.statsIcon.setImageResource(R.mipmap.ic_icon_likes);
                detailViewHolder.statsText.setText(R.string.i_like_it);
                detailViewHolder.statsNumber.setText(postDetails.get(position));
                break;
            case 1:
                detailViewHolder.statsIcon.setImageResource(R.mipmap.ic_icon_clicks);
                detailViewHolder.statsText.setText(R.string.clicks);
                detailViewHolder.statsNumber.setText(postDetails.get(position));
                break;
            case 2:
                detailViewHolder.statsIcon.setImageResource(R.mipmap.ic_icon_comments);
                detailViewHolder.statsText.setText(R.string.comments);
                detailViewHolder.statsNumber.setText(postDetails.get(position));
                break;
            case 3:
                detailViewHolder.statsIcon.setImageResource(R.mipmap.ic_icon_share);
                detailViewHolder.statsText.setText(R.string.chare);
                detailViewHolder.statsNumber.setText(postDetails.get(position));
                break;
            case 4:
                detailViewHolder.statsIcon.setImageResource(R.mipmap.ic_icon_reach);
                detailViewHolder.statsText.setText(R.string.reach);
                detailViewHolder.statsNumber.setText(postDetails.get(position));
                break;
            default:
                detailViewHolder.statsIcon.setImageResource(R.mipmap.ic_launcher);
                detailViewHolder.statsText.setText(R.string.app_name);
                detailViewHolder.statsNumber.setText("0");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return postDetails.size();
    }

    public void setSelectedPublication(List<String> postDetails) {
        this.postDetails = postDetails;
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder {

        protected TextView statsText, statsNumber;
        protected ImageView statsIcon;
        protected RelativeLayout detailContainer;
        protected CardView detailCardView;

        public DetailViewHolder(View itemView) {
            super(itemView);
            statsText = (TextView) itemView.findViewById(R.id.statsText);
            statsNumber = (TextView) itemView.findViewById(R.id.statsNumber);
            statsIcon = (ImageView) itemView.findViewById(R.id.statsIcon);
            detailContainer = (RelativeLayout) itemView.findViewById(R.id.detailContainer);
            detailCardView = (CardView) detailContainer.getParent();
        }

    }
}
