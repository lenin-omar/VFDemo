package com.android.lofm.voxfeeddemo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.lofm.voxfeeddemo.R;
import com.android.lofm.voxfeeddemo.model.Publication;

import java.util.List;

/**
 * Created by Omar F Martinez on 1/13/17.
 */

public class PublicationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Publication> publications;

    public PublicationAdapter(Context context) {
        this.context = context;
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
    }

    @Override
    public int getItemCount() {
        return publications.size();
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public class PublicationViewHolder extends RecyclerView.ViewHolder {

        protected TextView textView;
        protected RelativeLayout publicationContainer;
        protected CardView publicationCardView;

        public PublicationViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.testText);
            publicationContainer = (RelativeLayout) itemView.findViewById(R.id.publicationContainer);
            publicationCardView = (CardView) publicationContainer.getParent();
        }

    }

}
