package com.mvvm.mvvm_dagger.modelproviders;

import android.app.Application;

import com.mvvm.mvvm_dagger.apirequests.ApiLoginRequest;
import com.mvvm.mvvm_dagger.viewmodel.LoginViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import retrofit2.Retrofit;

public class LoginModelProvider implements ViewModelProvider.Factory {
    ApiLoginRequest apiLoginRequest;
    private Application mApplication;
    private Retrofit retrofit;


    public LoginModelProvider(Application application, Retrofit param, ApiLoginRequest apiLoginRequest) {
        this.mApplication = application;
        this.retrofit = param;
        this.apiLoginRequest = apiLoginRequest;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new LoginViewModel(mApplication, retrofit, apiLoginRequest);
    }
}
