package com.android.lofm.voxfeeddemo.presenter;

import com.android.lofm.voxfeeddemo.model.Publication;
import com.android.lofm.voxfeeddemo.util.VFUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Omar F Martinez on 1/14/17.
 */

public class DetailPresenter {

    public Map<String, String> getDetailsHashMap(Publication publication) {
        Map<String, String> postDetails = new HashMap<>();
//        postDetails.put("campaignName", publication.getCampaign().getName());
//        postDetails.put("campaignImage", publication.getCampaign().getCoverImage());
//        postDetails.put("brandName", publication.getBrand().getName());
//        postDetails.put("brandLogo", publication.getBrand().getLogo());
//        postDetails.put("earnings", VFUtil.getFormattedMoney(publication.getEarnings()));
        postDetails.put("clicks", String.valueOf(publication.getStats().getClicks()));
        postDetails.put("shares", String.valueOf(publication.getStats().getShares()));
        postDetails.put("likes", String.valueOf(publication.getStats().getLikes()));
        postDetails.put("comments", String.valueOf(publication.getStats().getComments()));
        postDetails.put("audience", String.valueOf(publication.getStats().getAudience()));
        postDetails.put("link", String.valueOf(publication.getPost().getLink()));
        return postDetails;
    }

}
