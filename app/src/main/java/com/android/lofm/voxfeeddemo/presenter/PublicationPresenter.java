package com.android.lofm.voxfeeddemo.presenter;

import android.content.Context;

import com.android.lofm.voxfeeddemo.model.Publication;
import com.android.lofm.voxfeeddemo.rest.GsonRequest;
import com.android.lofm.voxfeeddemo.rest.VolleySingleton;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Omar F Martinez on 1/13/17.
 */

public class PublicationPresenter implements Response.Listener<Object>, Response.ErrorListener {

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

    public void getPublications() {
        final String url = "https://api.voxfeed.com/public/promoted_messages";  //TODO: Change to string resource
        GsonRequest request = new GsonRequest(Request.Method.GET, url, Publication[].class, null, this, this);
        VolleySingleton.getInstance(context).getRequestQueue().add(request);
    }

    @Override
    public void onResponse(Object response) {
        Publication[] publications = (Publication[]) response;
        List<Publication> publicationsArray = Arrays.asList(publications);
        listener.onSuccess(publicationsArray);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
        getLocalJson();
        listener.onError("No es posible conectarse con el servidor");   //TODO: Change to string resource
    }

    public void getLocalJson() {
        ArrayList<Publication> publications = null;
        try {
            InputStream is = context.getAssets().open("json/localResponse.json");
            publications = new Gson().fromJson(new InputStreamReader(is), new TypeToken<ArrayList<Publication>>() {

            }.getType());
            listener.onSuccess(publications);
        } catch (IOException e) {
            e.printStackTrace();
            listener.onError("No es posible obtener el JSON local");   //TODO: Change to string resource
        }
    }

    public interface PublicationListener {

        void onSuccess(List<Publication> publications);

        void onError(String errorMessage);
    }

}
