package com.android.lofm.voxfeeddemo;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.android.lofm.voxfeeddemo.ui.OpenGLRenderer;

public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //OpenGL view. Go fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        GLSurfaceView view = new GLSurfaceView(this);
        view.setEGLConfigChooser(8, 8, 8, 8, 16, 0);    //Transparent background
        view.getHolder().setFormat(PixelFormat.TRANSLUCENT);    //Transparent background
        view.setRenderer(new OpenGLRenderer(this));
        setContentView(view);
        //Transition to Landing screen
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This app main activity
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        setContentView(R.layout.activity_splash);
//        new Handler().postDelayed(new Runnable() {
//
//            /*
//             * Showing splash screen with a timer.
//             * This will be useful when you want to show case your app/company logo
//             */
//
//            @Override
//            public void run() {
//                // This method will be executed once the timer is over
//                // Start your app main activity
//                Intent i = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(i);
//                finish();
//            }
//        }, SPLASH_TIME_OUT);
//    }

}
