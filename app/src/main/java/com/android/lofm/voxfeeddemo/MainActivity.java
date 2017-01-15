package com.android.lofm.voxfeeddemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.lofm.voxfeeddemo.fragment.PublicationFragment;
import com.android.lofm.voxfeeddemo.rest.VolleySingleton;
import com.android.lofm.voxfeeddemo.ui.AppBarCustomizer;
import com.android.lofm.voxfeeddemo.util.VFUtil;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements AppBarCustomizer {

    private AppBarLayout appBar;
    private NetworkImageView coordinatorImage, brandCircleImage;
    private ImageLoader imageLoader;
    private TextView brandName, campaignName, earningsText;
    private FrameLayout earningsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageLoader = VolleySingleton.getInstance(this).getImageLoader();
        VFUtil.addFragmentToContent(this, PublicationFragment.TAG, null);
        appBar = (AppBarLayout) findViewById(R.id.app_bar);
        earningsContainer = (FrameLayout) findViewById(R.id.earningsContainer);
        coordinatorImage = (NetworkImageView) findViewById(R.id.coordinatorImage);
        brandCircleImage = (NetworkImageView) findViewById(R.id.brandCircleImage);
        brandName = (TextView) findViewById(R.id.brandName);
        campaignName = (TextView) findViewById(R.id.campaignName);
        earningsText = (TextView) findViewById(R.id.earningsText);
    }

    @Override
    public void setScrollabelAppBarVisible(boolean visible, Map<String, String> values) {
        if (visible) {
            getSupportActionBar().hide();
            appBar.setVisibility(View.VISIBLE);
            earningsContainer.setVisibility(View.VISIBLE);
            coordinatorImage.setImageUrl(values.get("campaignImage"), imageLoader);
            coordinatorImage.setAdjustViewBounds(true);
            brandCircleImage.setImageUrl(values.get("brandLogo"), imageLoader);
            brandName.setText(values.get("brandName"));
            campaignName.setText(values.get("campaignName"));
            earningsText.setText(values.get("earnings"));
        } else {
            appBar.setVisibility(View.GONE);
            earningsContainer.setVisibility(View.GONE);
            getSupportActionBar().show();
        }
    }

}
