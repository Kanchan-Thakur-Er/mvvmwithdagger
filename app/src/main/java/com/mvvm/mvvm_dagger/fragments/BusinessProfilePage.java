package com.mvvm.mvvm_dagger.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ember.ember.R;

import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BusinessProfilePage extends Fragment {
    private View rootView;

    public BusinessProfilePage() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_business_profile_page, container, false);
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
