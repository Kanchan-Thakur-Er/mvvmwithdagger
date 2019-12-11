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
public class InvitedUsersFragment extends Fragment {
    private View rootView;

    public InvitedUsersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_invited_users, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.btnSubmit)
    public void submit() {
        getFragmentManager().beginTransaction().replace(R.id.container, new NewUserFragment()).addToBackStack("").commit();
    }
}
