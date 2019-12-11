package com.mvvm.mvvm_dagger.fragments;


import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.activities.WelcomeActivity;
import com.mvvm.mvvm_dagger.listener.OnSwipeTouchListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {

    @BindView(R.id.imgBussiness)
    public ImageView imgBussiness;
    Application application;
    Retrofit retrofit;
    private View rootView;
    private SupportMapFragment map;
    private GoogleMap mMap;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);
        init();
        savedIdeasfragment();
        return rootView;
    }

    private void init() {
        application = ((WelcomeActivity) getActivity()).application;
        retrofit = ((WelcomeActivity) getActivity()).retrofit;
setMapInView();
    }

    public void setMapInView() {
        map = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        map.getMapAsync(googleMap -> {
            mMap = googleMap;

                mMap.clear();
                double latitudeDouble = 28.5503;
                double longitudeDouble =77.2502;
                LatLng currentPosition = new LatLng(latitudeDouble, longitudeDouble);
                mMap.addMarker(new MarkerOptions().position(currentPosition).title("Nehru place"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(currentPosition));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(6));

        });
    }


    public void savedIdeasfragment() {
        imgBussiness.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {

            @Override
            public void onClick() {
                super.onClick();
                getFragmentManager().beginTransaction().replace(R.id.container, new PhotosFragment()).addToBackStack("").commit();
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                // your on onDoubleClick here
            }

            @Override
            public void onLongClick() {
                super.onLongClick();
                // your on onLongClick here
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                // your swipe up here
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                // your swipe down here.
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                // your swipe left here.
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                getFragmentManager().beginTransaction().replace(R.id.container, new SaveIdeasFragment()).addToBackStack("").commit();

            }
        });

    }

    @OnClick(R.id.rlImageView)
    public void photos() {
        getFragmentManager().beginTransaction().replace(R.id.container, new PhotosFragment()).addToBackStack("").commit();

    }

    @OnClick(R.id.lnrPhotos)
    public void photosMore() {
        getFragmentManager().beginTransaction().replace(R.id.container, new PhotosFragment()).addToBackStack("").commit();

    }

    @OnClick(R.id.imgBulb)
    public void bulb() {
        getFragmentManager().beginTransaction().replace(R.id.container, new SaveIdeasFragment()).addToBackStack("").commit();

    }

    @OnClick(R.id.imgProfile)
    public void profile() {
        getFragmentManager().beginTransaction().replace(R.id.container, new ChoosePhotoFragment()).addToBackStack("").commit();

    }
}
