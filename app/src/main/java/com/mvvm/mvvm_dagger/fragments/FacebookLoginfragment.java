package com.mvvm.mvvm_dagger.fragments;


import androidx.fragment.app.Fragment;

import android.os.Bundle;

import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ember.ember.R;

public class FacebookLoginfragment extends Fragment {
    private View rootView;

    public FacebookLoginfragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_facebook_loginfragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

}
