package com.mvvm.mvvm_dagger.apiinterface;

import com.mvvm.mvvm_dagger.apirequests.ApiLoginRequest;
import com.mvvm.mvvm_dagger.apirequests.ApiRegisterRequest;
import com.mvvm.mvvm_dagger.apiresponse.ApiLoginResponse;
import com.mvvm.mvvm_dagger.apiresponse.ApiResponseRegister;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    public  static  final String REGISTER="register_url";
    public  static  final String LOGIN="login_url";



    @POST("api/")
    Call<ApiResponseRegister> register(@Body ApiRegisterRequest registration);

    @POST("api/")
    Call<ApiLoginResponse> login(@Body ApiLoginRequest loginRequest);
}
