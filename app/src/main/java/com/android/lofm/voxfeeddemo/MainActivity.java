package com.android.lofm.voxfeeddemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.android.lofm.voxfeeddemo.fragment.PublicationFragment;
import com.android.lofm.voxfeeddemo.rest.VolleySingleton;
import com.android.lofm.voxfeeddemo.ui.AppBarCustomizer;
import com.android.lofm.voxfeeddemo.util.FragmentUtil;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AppBarCustomizer {

    private AppBarLayout appBar;
    private NetworkImageView coordinatorImage;
    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageLoader = VolleySingleton.getInstance(this).getImageLoader();
        FragmentUtil.addFragmentToContent(this, PublicationFragment.TAG, null);
        appBar = (AppBarLayout) findViewById(R.id.app_bar);
        coordinatorImage = (NetworkImageView) findViewById(R.id.coordinatorImage);
    }

    @Override
    public void setScrollabelAppBarVisible(boolean visible, List<String> values) {
        if (visible) {
            getSupportActionBar().hide();
            appBar.setVisibility(View.VISIBLE);
            //TODO: Set url form values
            coordinatorImage.setImageUrl("https://s3.amazonaws.com/voxfeed.assets/apps-development-test/campaign-cover3.jpg", imageLoader);
        } else {
            appBar.setVisibility(View.GONE);
            getSupportActionBar().show();
        }
    }

}
