package com.mvvm.mvvm_dagger.viewmodel;

import android.app.Application;

import com.mvvm.mvvm_dagger.apiinterface.Api;
import com.mvvm.mvvm_dagger.apirequests.ApiLoginRequest;
import com.mvvm.mvvm_dagger.apiresponse.ApiLoginResponse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginViewModel extends ViewModel {
    Application application;
    Retrofit retrofit;
    ApiLoginRequest apiLoginRequest;
    private MutableLiveData<ApiLoginResponse> loginResponse;

    public LoginViewModel(Application application, Retrofit retrofit, ApiLoginRequest apiLoginRequest) {
        this.application = application;
        this.retrofit = retrofit;
        this.apiLoginRequest = apiLoginRequest;
    }


    public LiveData<ApiLoginResponse> login() {

        if (loginResponse == null) {
            loginResponse = new MutableLiveData<ApiLoginResponse>();

            createRegister();
        }


        return loginResponse;
    }

    private void createRegister() {
        Api api = retrofit.create(Api.class);

        Call<ApiLoginResponse> call = api.login(apiLoginRequest);
        call.enqueue(new Callback<ApiLoginResponse>() {
            @Override
            public void onResponse(Call<ApiLoginResponse> call, Response<ApiLoginResponse> response) {
                loginResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ApiLoginResponse> call, Throwable t) {

            }
        });
    }
}