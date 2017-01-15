package com.android.lofm.voxfeeddemo.adapter;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.lofm.voxfeeddemo.R;
import com.android.lofm.voxfeeddemo.model.Publication;
import com.android.lofm.voxfeeddemo.rest.VolleySingleton;
import com.android.lofm.voxfeeddemo.util.VFUtil;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by Omar F Martinez on 1/13/17.
 */

public class PublicationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Publication> publications;
    private ImageLoader imageLoader;

    public PublicationAdapter(Context context) {
        this.context = context;
        imageLoader = VolleySingleton.getInstance(context).getImageLoader();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.publication_card, parent, false);
        viewHolder = new PublicationViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PublicationViewHolder publicationViewHolder = ((PublicationViewHolder) holder);
        publicationViewHolder.textView.setText(publications.get(position).getPost().getText());
        publicationViewHolder.postImage.setImageUrl(publications.get(position).getPost().getImage(), imageLoader);
        publicationViewHolder.postImage.setAdjustViewBounds(true);
        publicationViewHolder.circleImage.setImageUrl(publications.get(position).getUser().getProfileImage(), imageLoader);
        publicationViewHolder.userNameText.setText(publications.get(position).getUser().getUsername());
        publicationViewHolder.socialNetworkText.setText(publications.get(position).getSocialNetwork());
        VFUtil.setTextColor(publications.get(position).getSocialNetwork(), publicationViewHolder.socialNetworkText, context);
        publicationViewHolder.fechaText.setText(VFUtil.getFormattedDate(publications.get(position).getDate()));
    }



    @Override
    public int getItemCount() {
        return publications.size();
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public class PublicationViewHolder extends RecyclerView.ViewHolder {

        protected TextView textView, userNameText, socialNetworkText, fechaText;
        protected NetworkImageView postImage, circleImage;
        protected RelativeLayout publicationContainer;
        protected CardView publicationCardView;

        public PublicationViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.postText);
            userNameText = (TextView) itemView.findViewById(R.id.userNameText);
            socialNetworkText = (TextView) itemView.findViewById(R.id.socialNetworkText);
            fechaText = (TextView) itemView.findViewById(R.id.fechaText);
            postImage = (NetworkImageView) itemView.findViewById(R.id.postImage);
            circleImage = (NetworkImageView) itemView.findViewById(R.id.circleImage);
            publicationContainer = (RelativeLayout) itemView.findViewById(R.id.publicationContainer);
            publicationCardView = (CardView) publicationContainer.getParent();
        }

    }

}
