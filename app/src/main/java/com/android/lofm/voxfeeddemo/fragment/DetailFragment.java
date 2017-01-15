package com.android.lofm.voxfeeddemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.lofm.voxfeeddemo.R;
import com.android.lofm.voxfeeddemo.adapter.DetailAdapter;
import com.android.lofm.voxfeeddemo.model.Publication;
import com.android.lofm.voxfeeddemo.presenter.DetailPresenter;
import com.android.lofm.voxfeeddemo.ui.AppBarCustomizer;
import com.android.lofm.voxfeeddemo.util.RecyclerItemTouchListener;

import java.util.Map;

public class DetailFragment extends Fragment implements RecyclerItemTouchListener.OnItemClickListener {

    public static final String TAG = DetailFragment.class.getName();
    private RecyclerView postsRecyclerView;
    private LinearLayoutManager llm;
    private DetailAdapter adapter;
    private Publication publication;
    private Map<String, String> postDetails;
    private ViewFlipper root;
    private DetailPresenter detailPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = (ViewFlipper) inflater.inflate(R.layout.fragment_detail, container, false);
        //Setup recycler view
        postsRecyclerView = (RecyclerView) root.findViewById(R.id.postsRecyclerView);
        llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        postsRecyclerView.setLayoutManager(llm);
        postsRecyclerView.addOnItemTouchListener(new RecyclerItemTouchListener(getContext(), this));
        adapter = new DetailAdapter(getContext());
        detailPresenter = new DetailPresenter();
        publication = getArguments().getParcelable("selectedPublicationKey");
        postDetails = detailPresenter.getDetailsHashMap(publication);
        adapter.setSelectedPublication(postDetails);
        ((AppBarCustomizer)getActivity()).setScrollabelAppBarVisible(true, null);
        return root;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), publication.getBrand().getName() + " - " + publication.getCampaign().getName() + " - " + publication.getSocialNetwork(), Toast.LENGTH_LONG).show();
    }
}
