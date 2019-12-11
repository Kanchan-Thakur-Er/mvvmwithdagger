package com.mvvm.mvvm_dagger.activities;

import android.app.Application;
import android.os.Bundle;
import android.view.WindowManager;

import com.mvvm.mvvm_dagger.MyApplication;
import com.ember.ember.R;
import com.mvvm.mvvm_dagger.fragments.WelcomeFragment;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import retrofit2.Retrofit;


public class WelcomeActivity extends AppCompatActivity {

    @Inject
    public Retrofit retrofit;
    @Inject
    public Application application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).getNetComponent().inject(this);

        init();
    }

    private void init() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new WelcomeFragment()).commit();

    }
}
