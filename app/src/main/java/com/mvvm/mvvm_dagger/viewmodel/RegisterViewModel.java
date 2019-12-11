package com.mvvm.mvvm_dagger.viewmodel;

import android.app.Application;

import com.mvvm.mvvm_dagger.apiinterface.Api;
import com.mvvm.mvvm_dagger.apirequests.ApiRegisterRequest;
import com.mvvm.mvvm_dagger.apiresponse.ApiResponseRegister;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterViewModel extends ViewModel {
    Application application;
    Retrofit retrofit;
    ApiRegisterRequest apiRegisterRequest;
    //this is the data that we will fetch asynchronously
    private MutableLiveData<ApiResponseRegister> registerResponse;

    public RegisterViewModel(Application application, Retrofit retrofit, ApiRegisterRequest apiRegisterRequest) {
        this.application = application;
        this.retrofit = retrofit;
        this.apiRegisterRequest = apiRegisterRequest;
    }

    //we will call this method to get the data
    public LiveData<ApiResponseRegister> createregister() {
        //if the list is null
        if (registerResponse == null) {
            registerResponse = new MutableLiveData<ApiResponseRegister>();
            //we will load it asynchronously from server in this method
            createRegister();
        }

        //finally we will return the list
        return registerResponse;
    }

    //This method is using Retrofit to get the JSON data from URL
    private void createRegister() {
        Api api = retrofit.create(Api.class);

        Call<ApiResponseRegister> call = api.register(apiRegisterRequest);
        call.enqueue(new Callback<ApiResponseRegister>() {
            @Override
            public void onResponse(Call<ApiResponseRegister> call, Response<ApiResponseRegister> response) {
                //finally we are setting the list to our MutableLiveData
               // Toast.makeText(application,response.body()+"",Toast.LENGTH_SHORT).show();
                registerResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ApiResponseRegister> call, Throwable t) {

            }
        });
    }
}