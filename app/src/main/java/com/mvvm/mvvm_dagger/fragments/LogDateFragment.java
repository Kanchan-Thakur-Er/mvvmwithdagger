package com.mvvm.mvvm_dagger.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.adapter.EmojisAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogDateFragment extends Fragment {
    @BindView(R.id.rvEmojis)
    RecyclerView rvEmojis;
    private View rootView;
    private GridLayoutManager mGridLayoutManager;
    private EmojisAdapter emojisAdapter;

    public LogDateFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_log_date, container, false);
        ButterKnife.bind(this, rootView);
        init();
        return rootView;

    }

    private void init() {
        int mNoOfColumns = calculateNoOfColumns(getContext(), 40);

        mGridLayoutManager = new GridLayoutManager(getActivity(), mNoOfColumns);
        rvEmojis.setLayoutManager(mGridLayoutManager);
        emojisAdapter = new EmojisAdapter(getActivity(), LogDateFragment.this);
        rvEmojis.setAdapter(emojisAdapter);
    }

    public static int calculateNoOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }
}
