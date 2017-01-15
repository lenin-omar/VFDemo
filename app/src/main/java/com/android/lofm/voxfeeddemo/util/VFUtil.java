package com.android.lofm.voxfeeddemo.util;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.android.lofm.voxfeeddemo.R;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Omar F Martinez on 1/7/17.
 */

public class VFUtil {

    public static Fragment addFragmentToContent(FragmentActivity activity, String tag, Bundle extras) { //Used to add fragment to screen when app is launched
        FragmentManager fm = activity.getSupportFragmentManager();
        Fragment fragment = null;
        if (fm.findFragmentByTag(tag) == null) {
            fragment = Fragment.instantiate(activity, tag, extras);
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragmentHolder, fragment, tag);
            ft.commit();
        }
        return fragment;
    }

    public static Fragment replaceFragmentToContent(FragmentActivity activity, String tag, Bundle extras) {
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = Fragment.instantiate(activity, tag, extras);
        ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        ft.replace(R.id.fragmentHolder, fragment, tag);
        ft.addToBackStack(null);
        ft.commit();
        return fragment;
    }

    public static String getFormattedDate(String rawDate) {
        String formatted = "";
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        try {
            Date date = new SimpleDateFormat(pattern, Locale.US).parse(rawDate);
            formatted = new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return rawDate;
        }
        return formatted;
    }

    public static String getFormattedMoney(double rawQty) {
        String formatted = "";
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        try {
            formatted = formatter.format(rawQty);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            formatted = String.valueOf(rawQty);
        }
        return formatted;
    }

    public static String getFormattedNumber(double rawQty) {
        String formatted = "";
        NumberFormat formatter = NumberFormat.getNumberInstance();
        try {
            formatted = formatter.format(rawQty);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            formatted = String.valueOf(rawQty);
        }
        return formatted;
    }

    public static void setTextColor(String socialNetwork, TextView socialNetworkText, Context context) {
        if (socialNetwork.equalsIgnoreCase("facebook")) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                socialNetworkText.setTextColor(context.getColor(R.color.colorFacebook));
            } else {
                socialNetworkText.setTextColor(context.getResources().getColor(R.color.colorFacebook));
            }
        }
        if (socialNetwork.equalsIgnoreCase("twitter")) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                socialNetworkText.setTextColor(context.getColor(R.color.colorTwitter));
            } else {
                socialNetworkText.setTextColor(context.getResources().getColor(R.color.colorTwitter));
            }
        }
        if (socialNetwork.equalsIgnoreCase("instagram")) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                socialNetworkText.setTextColor(context.getColor(R.color.colorInstagram));
            } else {
                socialNetworkText.setTextColor(context.getResources().getColor(R.color.colorInstagram));
            }
        }
    }

}
