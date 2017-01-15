package com.android.lofm.voxfeeddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.lofm.voxfeeddemo.fragment.PublicationFragment;
import com.android.lofm.voxfeeddemo.util.VFUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VFUtil.addFragmentToContent(this, PublicationFragment.TAG, null);
    }

}
