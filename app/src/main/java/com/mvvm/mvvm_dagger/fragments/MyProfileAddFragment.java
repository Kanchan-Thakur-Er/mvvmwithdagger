package com.mvvm.mvvm_dagger.fragments;


import androidx.fragment.app.Fragment;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ember.ember.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileAddFragment extends Fragment {


    private View rootView;
    public MyProfileAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_my_profile, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.btnSubmit)
    public void submit() {
        getFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).addToBackStack("").commit();

    }
}
