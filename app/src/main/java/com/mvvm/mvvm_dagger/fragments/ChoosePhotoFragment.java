package com.mvvm.mvvm_dagger.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ember.ember.R;

import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChoosePhotoFragment extends Fragment {

    private View rootView;

    public ChoosePhotoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_choose_photo, container, false);
        ButterKnife.bind(this, rootView);
        init();

        return rootView;
    }

    private void init() {

    }

    @OnClick(R.id.imgBack)
    public void back() {
        getFragmentManager().popBackStackImmediate();
    }
}
