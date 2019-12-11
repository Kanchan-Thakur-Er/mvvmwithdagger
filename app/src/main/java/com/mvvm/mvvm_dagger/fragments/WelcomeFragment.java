package com.mvvm.mvvm_dagger.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ember.ember.R;

import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeFragment extends Fragment {

    @BindView(R.id.tvNewUser)
    TextView tvNewUser;
    private View rootView;

    public WelcomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_welcome, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;


    }

    @OnClick(R.id.tvNewUser)
    public void newUserFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, new NewUserFragment()).addToBackStack("").commit();

    }

    @OnClick(R.id.tvReturningUser)
    public void returningUserFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, new ReturningUserFragment()).addToBackStack("").commit();

    }

    @OnClick(R.id.tvInvitedViaEmail)

    public void invitedEmailFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, new InvitedUsersFragment()).addToBackStack("").commit();

    }
}
