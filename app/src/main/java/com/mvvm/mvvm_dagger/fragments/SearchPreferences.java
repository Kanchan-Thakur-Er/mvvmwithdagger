package com.mvvm.mvvm_dagger.fragments;


import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.ember.ember.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchPreferences extends Fragment {


    private View rootView;

    public SearchPreferences() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search_preferences, container, false);
        ButterKnife.bind(this, rootView);
        init();
        return rootView;
    }

    private void init() {

    }

    @OnClick(R.id.btnSave)

    public void btnSave() {
        final Dialog dialgLogTrack = new Dialog(getActivity());
        //   dialgLogTrack.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialgLogTrack.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialgLogTrack.setCancelable(false);
        dialgLogTrack.setContentView(R.layout.dialogconfirmsearchpreferences);
        TextView tvCancel = dialgLogTrack.findViewById(R.id.tvCancel);
        Button btnContinue=dialgLogTrack.findViewById(R.id.btnContinue);

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialgLogTrack.dismiss();
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 getFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).addToBackStack("").commit();
            }
        });

        dialgLogTrack.show();

    }





}
