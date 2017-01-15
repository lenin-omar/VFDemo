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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VFUtil.addFragmentToContent(this, PublicationFragment.TAG, null);
    }

}
