package com.android.lofm.voxfeeddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.lofm.voxfeeddemo.adapter.DetailAdapter;
import com.android.lofm.voxfeeddemo.model.Publication;
import com.android.lofm.voxfeeddemo.presenter.DetailPresenter;
import com.android.lofm.voxfeeddemo.rest.VolleySingleton;
import com.android.lofm.voxfeeddemo.util.VFUtil;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private NetworkImageView coordinatorImage, brandCircleImage;
    private ImageLoader imageLoader;
    private TextView brandName, campaignName, earningsText, seePublicationLink;
    private Publication publication;
    private RecyclerView postsRecyclerView;
    private LinearLayoutManager llm;
    private DetailAdapter adapter;
    private DetailPresenter detailPresenter;
    private List<String> postDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageLoader = VolleySingleton.getInstance(this).getImageLoader();
        getSupportActionBar().hide();
        initViews();
        Bundle bundle = getIntent().getExtras();
        publication = bundle.getParcelable("com.android.lofm.voxfeeddemo.model.selectedPublicationKey");
        setValuesToViews();
        setRecyclerView();
    }

    private void initViews() {
        coordinatorImage = (NetworkImageView) findViewById(R.id.coordinatorImage);
        brandCircleImage = (NetworkImageView) findViewById(R.id.brandCircleImage);
        brandName = (TextView) findViewById(R.id.brandName);
        campaignName = (TextView) findViewById(R.id.campaignName);
        earningsText = (TextView) findViewById(R.id.earningsText);
        seePublicationLink = (TextView) findViewById(R.id.seePublicationLink);
        postsRecyclerView = (RecyclerView) findViewById(R.id.postsRecyclerView);
    }

    private void setValuesToViews() {
        coordinatorImage.setImageUrl(publication.getCampaign().getCoverImage(), imageLoader);
        coordinatorImage.setAdjustViewBounds(true);
        brandCircleImage.setImageUrl(publication.getBrand().getLogo(), imageLoader);
        brandName.setText(publication.getBrand().getName());
        campaignName.setText(publication.getCampaign().getName());
        earningsText.setText(VFUtil.getFormattedMoney(publication.getEarnings()));
        seePublicationLink.setText(getString(R.string.publication_in_social_network) + " " + publication.getSocialNetwork().toUpperCase());
        VFUtil.setTextColor(publication.getSocialNetwork(), seePublicationLink, this);
        seePublicationLink.setOnClickListener(this);
    }

    private void setRecyclerView() {
        //Setup recycler view
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        postsRecyclerView.setLayoutManager(llm);
        adapter = new DetailAdapter(this);
        detailPresenter = new DetailPresenter();
        postDetails = detailPresenter.getDetailsHashMap(publication);
        adapter.setSelectedPublication(postDetails);
        postsRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("com.android.lofm.voxfeeddemo.model.post.link", publication.getPost().getLink());
        startActivity(intent);
    }
}
