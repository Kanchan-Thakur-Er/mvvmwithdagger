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
public class Setting extends Fragment {
    private View rootView;

    public Setting() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.bind(this, rootView);
        init();
        return rootView;
    }

    private void init() {

    }

    @OnClick(R.id.tvChangePassword)
    public void changePassword() {
        getFragmentManager().beginTransaction().replace(R.id.container, new ChangePassword()).addToBackStack("").commit();

    }

    @OnClick(R.id.tvPush)
    public void pushnotifications() {
        getFragmentManager().beginTransaction().replace(R.id.container, new PushNotificationFragment()).addToBackStack("").commit();

    }

}
