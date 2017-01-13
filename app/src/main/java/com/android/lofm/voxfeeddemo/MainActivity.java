package com.android.lofm.voxfeeddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.lofm.voxfeeddemo.util.FragmentUtil;
import com.android.lofm.voxfeeddemo.fragment.PublicationFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentUtil.addFragmentToContent(this, PublicationFragment.TAG, null);
    }
}
