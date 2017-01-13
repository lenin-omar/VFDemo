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
import com.android.lofm.voxfeeddemo.adapter.PublicationAdapter;
import com.android.lofm.voxfeeddemo.model.Publication;
import com.android.lofm.voxfeeddemo.presenter.PublicationPresenter;
import com.android.lofm.voxfeeddemo.util.RecyclerItemTouchListener;

import java.util.ArrayList;

public class PublicationFragment extends Fragment implements RecyclerItemTouchListener.OnItemClickListener, PublicationPresenter.PublicationListener {

    public static final String TAG = PublicationFragment.class.getName();
    private RecyclerView publicationsRecyclerView;
    private LinearLayoutManager llm;
    private PublicationAdapter adapter;
    private PublicationPresenter presenter;
    private ArrayList<Publication> publications;
    private ViewFlipper root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = (ViewFlipper) inflater.inflate(R.layout.fragment_publication, container, false);
        //Setup recycler view
        publicationsRecyclerView = (RecyclerView) root.findViewById(R.id.publicationsRecyclerView);
        llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        publicationsRecyclerView.setLayoutManager(llm);
        //Setup presenter, adapter and listener
        presenter = new PublicationPresenter(getContext());
        publications = presenter.getPublications();
        adapter = new PublicationAdapter(getContext());
        adapter.setPublications(publications);
        publicationsRecyclerView.setAdapter(adapter);
        publicationsRecyclerView.addOnItemTouchListener(new RecyclerItemTouchListener(getContext(), this));
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.registerListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unRegisterListener();
    }

    @Override
    public void onItemClick(View view, int position) {
        //TODO: Go to next fragment FragmentUtil.replaceFragmentToContent()
    }

    @Override
    public void onSuccess(ArrayList<Publication> publications) {
        this.publications = publications;
        adapter.setPublications(publications);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

}
