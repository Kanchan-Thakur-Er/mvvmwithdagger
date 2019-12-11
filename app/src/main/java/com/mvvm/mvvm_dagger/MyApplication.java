package com.mvvm.mvvm_dagger;

import android.app.Application;

import com.mvvm.mvvm_dagger.component.ApiComponent;
import com.mvvm.mvvm_dagger.component.DaggerApiComponent;
import com.mvvm.mvvm_dagger.module.ApiModule;
import com.mvvm.mvvm_dagger.module.AppModule;


public class MyApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("your base url"))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }
}