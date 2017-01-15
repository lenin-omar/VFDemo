package com.android.lofm.voxfeeddemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    private String stringURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_web);
        WebView postLinkOnBrowser = (WebView) findViewById(R.id.postLinkOnBrowser);
        WebSettings settings = postLinkOnBrowser.getSettings();
        settings.setJavaScriptEnabled(true);
        postLinkOnBrowser.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        postLinkOnBrowser.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Toast.makeText(getApplicationContext(), error.getDescription(), Toast.LENGTH_LONG).show();
                }
            }
        });
        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("com.android.lofm.voxfeeddemo.model.post.link");
        postLinkOnBrowser.loadUrl(url);
    }

}
