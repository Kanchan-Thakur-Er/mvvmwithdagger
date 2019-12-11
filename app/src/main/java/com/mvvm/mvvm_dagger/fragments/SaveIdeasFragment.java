package com.mvvm.mvvm_dagger.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.adapter.FavoritedMessagedAdapter;
import com.mvvm.mvvm_dagger.adapter.SavedIdeasAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaveIdeasFragment extends Fragment {

    public boolean isFilterOptionVisible = false;
    @BindView(R.id.rvSavedIdeas)
    RecyclerView rvSavedIdeas;
    @BindView(R.id.rvBusinessType)
    RecyclerView rvBusinessType;
    @BindView(R.id.img_Filterbtn)
    ImageView img_Filterbtn;
    @BindView(R.id.llFilter)
    LinearLayout llFilter;
    private View rootView;
    private FavoritedMessagedAdapter favoritedMessageAdapter;
    private SavedIdeasAdapter savedIdeadsAdapter;

    public SaveIdeasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_save_ideas, container, false);
        ButterKnife.bind(this, rootView);
        init();
        return rootView;
    }

    private void init() {
        rvSavedIdeas.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
        rvBusinessType.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));

        savedIdeadsAdapter = new SavedIdeasAdapter(getActivity(), SaveIdeasFragment.this);
        rvSavedIdeas.setAdapter(savedIdeadsAdapter);
        favoritedMessageAdapter = new FavoritedMessagedAdapter(getActivity(), SaveIdeasFragment.this);
        rvBusinessType.setAdapter(favoritedMessageAdapter);
    }

    @OnClick(R.id.img_Filterbtn)
    public void filter() {
        if (isFilterOptionVisible) {
            llFilter.setVisibility(View.VISIBLE);
            isFilterOptionVisible = false;
        } else {
            llFilter.setVisibility(View.GONE);
            isFilterOptionVisible = true;

        }
    }

    @OnClick(R.id.tvSeeAll)
    public void sellAllSavedIdeas() {
        getFragmentManager().beginTransaction().replace(R.id.container, new SavedIdeasSeeAll()).addToBackStack("").commit();

    }

    @OnClick(R.id.imgFire)
    public void imgFire() {
        getFragmentManager().beginTransaction().replace(R.id.container, new UserProfileFragment()).addToBackStack("").commit();

    }

    @OnClick(R.id.imgBook)
    public void imgBook() {
        getFragmentManager().beginTransaction().replace(R.id.container, new DateDiaryFragment()).addToBackStack("").commit();

    }
}
