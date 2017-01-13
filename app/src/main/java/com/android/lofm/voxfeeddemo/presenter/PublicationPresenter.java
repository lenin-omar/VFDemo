package com.android.lofm.voxfeeddemo.presenter;

import android.content.Context;

import com.android.lofm.voxfeeddemo.model.Publication;

import java.util.ArrayList;

/**
 * Created by Omar F Martinez on 1/13/17.
 */

public class PublicationPresenter {

    private Context context;
    private PublicationListener listener;

    public PublicationPresenter(Context context) {
        this.context = context;
    }

    public void registerListener(PublicationListener listener) {
        this.listener = listener;
    }

    public void unRegisterListener() {
        listener = null;
    }

    public ArrayList<Publication> getPublications() {
        return null;
    }

    public interface PublicationListener {

        void onSuccess(ArrayList<Publication> publications);

        void onError(String errorMessage);
    }

}
