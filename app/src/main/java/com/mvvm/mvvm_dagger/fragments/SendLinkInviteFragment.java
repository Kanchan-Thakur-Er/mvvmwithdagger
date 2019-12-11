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
public class SendLinkInviteFragment extends Fragment {
    private View rootView;

    public SendLinkInviteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_send_link_invite, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.btnProceedWithInvite)
    public void btnProceedWithInvite() {
        getFragmentManager().beginTransaction().replace(R.id.container, new PendingInvite()).addToBackStack("").commit();
    }

    @OnClick(R.id.txtCancelInvite)
    public void txtCancelInvite() {
        getFragmentManager().beginTransaction().replace(R.id.container, new Linkfragment()).addToBackStack("").commit();
    }
}
