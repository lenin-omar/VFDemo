package com.android.lofm.voxfeeddemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.lofm.voxfeeddemo.adapter.DetailAdapter;
import com.android.lofm.voxfeeddemo.model.Publication;
import com.android.lofm.voxfeeddemo.presenter.DetailPresenter;
import com.android.lofm.voxfeeddemo.rest.VolleySingleton;
import com.android.lofm.voxfeeddemo.util.RecyclerItemTouchListener;
import com.android.lofm.voxfeeddemo.util.VFUtil;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.Map;

public class DetailActivity extends AppCompatActivity implements RecyclerItemTouchListener.OnItemClickListener {

    private AppBarLayout appBar;
    private NetworkImageView coordinatorImage, brandCircleImage;
    private ImageLoader imageLoader;
    private TextView brandName, campaignName, earningsText;
    private FrameLayout earningsContainer;
    private Publication publication;
    private RecyclerView postsRecyclerView;
    private LinearLayoutManager llm;
    private DetailAdapter adapter;
    private DetailPresenter detailPresenter;
    private Map<String, String> postDetails;

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

    private void initViews(){
        appBar = (AppBarLayout) findViewById(R.id.app_bar);
        earningsContainer = (FrameLayout) findViewById(R.id.earningsContainer);
        coordinatorImage = (NetworkImageView) findViewById(R.id.coordinatorImage);
        brandCircleImage = (NetworkImageView) findViewById(R.id.brandCircleImage);
        brandName = (TextView) findViewById(R.id.brandName);
        campaignName = (TextView) findViewById(R.id.campaignName);
        earningsText = (TextView) findViewById(R.id.earningsText);
        postsRecyclerView = (RecyclerView) findViewById(R.id.postsRecyclerView);
    }

    private void setValuesToViews() {
        coordinatorImage.setImageUrl(publication.getCampaign().getCoverImage(), imageLoader);
        coordinatorImage.setAdjustViewBounds(true);
        brandCircleImage.setImageUrl(publication.getBrand().getLogo(), imageLoader);
        brandName.setText(publication.getBrand().getName());
        campaignName.setText(publication.getCampaign().getName());
        earningsText.setText(VFUtil.getFormattedMoney(publication.getEarnings()));
    }

    private void setRecyclerView() {
        //Setup recycler view
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        postsRecyclerView.setLayoutManager(llm);
        postsRecyclerView.addOnItemTouchListener(new RecyclerItemTouchListener(this, this));
        adapter = new DetailAdapter(this);
        detailPresenter = new DetailPresenter();
        postDetails = detailPresenter.getDetailsHashMap(publication);
        adapter.setSelectedPublication(postDetails);
    }

    @Override
    public void onItemClick(View view, int position) {
    }
}
