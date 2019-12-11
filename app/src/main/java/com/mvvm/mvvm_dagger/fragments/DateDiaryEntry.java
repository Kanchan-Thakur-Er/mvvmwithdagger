package com.mvvm.mvvm_dagger.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ember.ember.R;

import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DateDiaryEntry extends Fragment {


    public DateDiaryEntry() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date_diary_entry, container, false);
    }

    @OnClick(R.id.img_BckArrowKey)
    public void back() {
        getFragmentManager().popBackStackImmediate();
    }

}
