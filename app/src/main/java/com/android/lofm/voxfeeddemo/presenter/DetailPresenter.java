package com.android.lofm.voxfeeddemo.presenter;

import com.android.lofm.voxfeeddemo.model.Publication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Omar F Martinez on 1/14/17.
 */

public class DetailPresenter {

    public List<String> getDetailsHashMap(Publication publication) {
        ArrayList<String> postDetails = new ArrayList<>();
        postDetails.add(String.valueOf(publication.getStats().getClicks()));
        postDetails.add(String.valueOf(publication.getStats().getShares()));
        postDetails.add(String.valueOf(publication.getStats().getLikes()));
        postDetails.add(String.valueOf(publication.getStats().getComments()));
        postDetails.add(String.valueOf(publication.getStats().getAudience()));
        return postDetails;
    }

}
