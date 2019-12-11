package com.mvvm.mvvm_dagger.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.adapter.DateDiaryAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DateDiaryFragment extends Fragment {

    public boolean isFilterOptionVisible = false;
    @BindView(R.id.llFilter)
    LinearLayout llFilter;
    @BindView(R.id.llSearch)
    LinearLayout llSearch;
    @BindView(R.id.edit_search)
    EditText edit_search;

    @BindView(R.id.rv_headline)
    RecyclerView rv_headline;
    DateDiaryAdapter dateDiaryAdapter;
    private View rootView;

    public DateDiaryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_date_diary, container, false);
        ButterKnife.bind(this, rootView);
        init();
        return rootView;
    }

    private void init() {
        rv_headline.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        dateDiaryAdapter = new DateDiaryAdapter(getActivity(), DateDiaryFragment.this);
        rv_headline.setAdapter(dateDiaryAdapter);
    }

    @OnClick(R.id.imgPlus)
    public void plus() {
        getFragmentManager().beginTransaction().replace(R.id.container, new AddLogDate()).addToBackStack("").commit();

    }

    @OnClick(R.id.img_Filterbtn)
    public void filter() {
        if (isFilterOptionVisible) {
            edit_search.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.search_icon, 0);
            llSearch.setBackgroundColor(getResources().getColor(R.color.colorGreyblack));
            llFilter.setVisibility(View.VISIBLE);
            isFilterOptionVisible = false;
        } else {
            edit_search.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            llSearch.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            llFilter.setVisibility(View.GONE);
            isFilterOptionVisible = true;

        }
    }
}
