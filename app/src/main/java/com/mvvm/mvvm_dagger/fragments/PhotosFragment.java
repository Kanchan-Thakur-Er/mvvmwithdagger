package com.mvvm.mvvm_dagger.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.adapter.PhotosPagerAdapter;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotosFragment extends Fragment {


    @BindView(R.id.viewPagerPics)
    ViewPager viewPagerPics;
    private View rootView;
    private PhotosPagerAdapter photosPagerAdapter;

    public PhotosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_photos, container, false);
        ButterKnife.bind(this, rootView);
        init();
        return rootView;
    }

    private void init() {
        photosPagerAdapter = new PhotosPagerAdapter(getActivity());
        viewPagerPics.setAdapter(photosPagerAdapter);
    }

    @OnClick(R.id.imgBack)
    public void back() {
        getFragmentManager().popBackStackImmediate();

    }
}
