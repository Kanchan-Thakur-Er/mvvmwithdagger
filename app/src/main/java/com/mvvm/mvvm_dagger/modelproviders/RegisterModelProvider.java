package com.mvvm.mvvm_dagger.modelproviders;

import android.app.Application;

import com.mvvm.mvvm_dagger.apirequests.ApiRegisterRequest;
import com.mvvm.mvvm_dagger.viewmodel.RegisterViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import retrofit2.Retrofit;

public class RegisterModelProvider implements ViewModelProvider.Factory {
    ApiRegisterRequest apiRegisterRequest;
    private Application mApplication;
    private Retrofit retrofit;


    public RegisterModelProvider(Application application, Retrofit param, ApiRegisterRequest apiRegisterRequest) {
        this.mApplication = application;
        this.retrofit = param;
        this.apiRegisterRequest = apiRegisterRequest;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new RegisterViewModel(mApplication, retrofit, apiRegisterRequest);
    }
}
