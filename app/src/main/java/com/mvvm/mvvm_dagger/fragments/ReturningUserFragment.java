package com.mvvm.mvvm_dagger.fragments;


import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.activities.WelcomeActivity;
import com.mvvm.mvvm_dagger.apiinterface.Api;
import com.mvvm.mvvm_dagger.apirequests.ApiLoginRequest;
import com.mvvm.mvvm_dagger.apirequests.ApiLoginRequestArgs;
import com.mvvm.mvvm_dagger.apiresponse.ApiLoginResponse;
import com.mvvm.mvvm_dagger.modelproviders.LoginModelProvider;
import com.mvvm.mvvm_dagger.viewmodel.LoginViewModel;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;

public class ReturningUserFragment extends Fragment {
    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etPassword)
    EditText etPassword;
    Application application;
    Retrofit retrofit;
    private View rootView;

    public ReturningUserFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_returning_user, container, false);
        ButterKnife.bind(this, rootView);
        init();
        return rootView;
    }

    private void init() {
        application = ((WelcomeActivity) getActivity()).application;
        retrofit = ((WelcomeActivity) getActivity()).retrofit;
    }

    @OnClick(R.id.tvForgotPassword)
    public void forgotPassword() {
        getFragmentManager().beginTransaction().replace(R.id.container, new ForgotPassword()).addToBackStack("").commit();

    }

    @OnClick(R.id.btnSignInViaEmail)
    public void signInViaEmail() {
        ApiLoginRequest apiLoginRequest = new ApiLoginRequest();
        apiLoginRequest.setWsfunction(Api.LOGIN);
        ApiLoginRequestArgs apiLoginRequestArgs = new ApiLoginRequestArgs();
        apiLoginRequestArgs.setUser_name(etUserName.getText().toString().trim());
        apiLoginRequestArgs.setPassword(etPassword.getText().toString().trim());
        apiLoginRequest.setArgs(apiLoginRequestArgs);

        LoginViewModel loginViewModel = ViewModelProviders.of(this, new LoginModelProvider(application, retrofit, apiLoginRequest)).get(LoginViewModel.class);
        loginViewModel.login().observe(this, new Observer<ApiLoginResponse>() {
            @Override
            public void onChanged(@Nullable ApiLoginResponse apiLoginResponse) {
                Toast.makeText(getActivity(), apiLoginResponse.getMsg() + "", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.container, new MyProfileAddFragment()).addToBackStack("").commit();

            }
        });

    }

    @OnClick(R.id.btnSignInViaFacebook)
    public void signInViaFacebook() {
        getFragmentManager().beginTransaction().replace(R.id.container, new MyProfileAddFragment()).addToBackStack("").commit();

    }

    @OnClick(R.id.tvCreateAccount)
    public void createAccount() {
        getFragmentManager().beginTransaction().replace(R.id.container, new NewUserFragment()).addToBackStack("").commit();

    }
}
