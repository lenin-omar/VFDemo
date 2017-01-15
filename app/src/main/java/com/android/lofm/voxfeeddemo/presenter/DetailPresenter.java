package com.android.lofm.voxfeeddemo.presenter;

import com.android.lofm.voxfeeddemo.model.Publication;
import com.android.lofm.voxfeeddemo.util.VFUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Omar F Martinez on 1/14/17.
 */

public class DetailPresenter {

    public List<String> getDetailsHashMap(Publication publication) {
        ArrayList<String> postDetails = new ArrayList<>();
//        postDetails.put("campaignName", publication.getCampaign().getName());
//        postDetails.put("campaignImage", publication.getCampaign().getCoverImage());
//        postDetails.put("brandName", publication.getBrand().getName());
//        postDetails.put("brandLogo", publication.getBrand().getLogo());
//        postDetails.put("earnings", VFUtil.getFormattedMoney(publication.getEarnings()));
        postDetails.add(String.valueOf(publication.getStats().getClicks()));
        postDetails.add(String.valueOf(publication.getStats().getShares()));
        postDetails.add(String.valueOf(publication.getStats().getLikes()));
        postDetails.add(String.valueOf(publication.getStats().getComments()));
        postDetails.add(String.valueOf(publication.getStats().getAudience()));
//        postDetails.put("link", String.valueOf(publication.getPost().getLink()));
        return postDetails;
    }

}
