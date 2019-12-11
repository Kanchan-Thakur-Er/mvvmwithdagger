package com.mvvm.mvvm_dagger.fragments;


import androidx.fragment.app.Fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.adapter.SavedIdeasSeeAllAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedIdeasSeeAll extends Fragment {
    private View rootView;
    @BindView(R.id.rvSeeAllSavedIdeas)
    RecyclerView rvSeeAllSavedIdeas;
    @BindView(R.id.llFilter)
    LinearLayout llFilter;
    private SavedIdeasSeeAllAdapter savedIdeasSeeAllAdapter;

    public SavedIdeasSeeAll() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_saved_ideas_see_all, container, false);
        ButterKnife.bind(this, rootView);
        init();

        return rootView;
    }

    private void init() {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        rvSeeAllSavedIdeas.setLayoutManager(manager);
        savedIdeasSeeAllAdapter = new SavedIdeasSeeAllAdapter(getActivity(), SavedIdeasSeeAll.this);
        rvSeeAllSavedIdeas.setAdapter(savedIdeasSeeAllAdapter);
    }

    @OnClick(R.id.imgBack)
    public void back() {
        getFragmentManager().popBackStackImmediate();
    }

    private boolean ShowView = false;

    @OnClick(R.id.img_Filterbtn)
    public void filter() {
        if (ShowView) {
            llFilter.setVisibility(View.VISIBLE);
            ShowView = false;
        } else {
            llFilter.setVisibility(View.GONE);
            ShowView = true;
        }
    }
}
