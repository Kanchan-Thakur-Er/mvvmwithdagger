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
public class UserProfileFragment extends Fragment {
    private View rootView;

    public UserProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_user_profile, container, false);
        ButterKnife.bind(this, rootView);
        init();
        return rootView;
    }

    private void init() {

    }

    @OnClick(R.id.imgSetting)
    public void facebookfragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, new Setting()).addToBackStack("").commit();
    }

    @OnClick(R.id.imgBook)

    public void diaryFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, new DateDiaryFragment()).addToBackStack("").commit();

    }

    @OnClick(R.id.imgNotification)
    public void notifications() {
        getFragmentManager().beginTransaction().replace(R.id.container, new Notifications()).addToBackStack("").commit();

    }

    @OnClick(R.id.imgFilter)
    public void filtericon() {
        getFragmentManager().beginTransaction().replace(R.id.container, new SearchPreferences()).addToBackStack("").commit();

    }

    @OnClick(R.id.imgReviewPartner)
    public void reviewPartner() {
        getFragmentManager().beginTransaction().replace(R.id.container, new Linkfragment()).addToBackStack("").commit();

    }
}
