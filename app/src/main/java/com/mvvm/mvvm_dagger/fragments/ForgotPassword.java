package com.mvvm.mvvm_dagger.fragments;


import androidx.fragment.app.Fragment;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ember.ember.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgotPassword extends Fragment {
    public ForgotPassword() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_password, container, false);
    }
}
