package com.mvvm.mvvm_dagger.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.adapter.LogStatAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LinkedPartnerFragment extends Fragment {
    private View rootView;
    private LogStatAdapter logStatAdapter;
    private boolean isFilterOptionVisible = false;

    public LinkedPartnerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_linked_partner, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.tvRemovePartner)
    public void removePartner() {
        final Dialog dialgLogTrack = new Dialog(getActivity());
        //   dialgLogTrack.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialgLogTrack.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialgLogTrack.setCancelable(false);
        dialgLogTrack.setContentView(R.layout.dialogconfirmremovepartner);
        TextView tvCancel = dialgLogTrack.findViewById(R.id.tvCancel);
        Button btnContinue = dialgLogTrack.findViewById(R.id.btnContinue);

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


    @OnClick(R.id.txt_LoggedDate)
    public void loggedDateFragment() {
        final Dialog dialgLogTrack = new Dialog(getActivity());
        dialgLogTrack.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialgLogTrack.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialgLogTrack.setCancelable(false);
        dialgLogTrack.setContentView(R.layout.dialoglogstats);
        ImageView tvCancel = dialgLogTrack.findViewById(R.id.imgCancel);
        RecyclerView rvlogstat = dialgLogTrack.findViewById(R.id.rvlogstat);
        TextView tvFilter = dialgLogTrack.findViewById(R.id.tvFilter);
        LinearLayout lnrFilterView = dialgLogTrack.findViewById(R.id.lnrFilterView);
        tvFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFilterOptionVisible) {
                    lnrFilterView.setVisibility(View.VISIBLE);
                    isFilterOptionVisible = false;
                } else {
                    lnrFilterView.setVisibility(View.GONE);
                    isFilterOptionVisible = true;
                }
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialgLogTrack.dismiss();
            }
        });

        rvlogstat.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        logStatAdapter = new LogStatAdapter(getActivity(), LinkedPartnerFragment.this);
        rvlogstat.setAdapter(logStatAdapter);
        dialgLogTrack.show();
    }
}