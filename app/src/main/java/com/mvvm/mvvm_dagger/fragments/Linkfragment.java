package com.mvvm.mvvm_dagger.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ember.ember.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Linkfragment extends Fragment {
    private View rootView;

    public Linkfragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_linkfragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.btnLinkInvite)

    public void linkInvite() {
        getFragmentManager().beginTransaction().replace(R.id.container, new SendLinkInviteFragment()).addToBackStack("").commit();

    }
}
