package com.mvvm.mvvm_dagger.fragments;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.activities.WelcomeActivity;
import com.mvvm.mvvm_dagger.apiinterface.Api;
import com.mvvm.mvvm_dagger.apirequests.ApiRegisterRequest;
import com.mvvm.mvvm_dagger.apirequests.ApiRegisterRequestAgrs;
import com.mvvm.mvvm_dagger.apiresponse.ApiResponseRegister;
import com.mvvm.mvvm_dagger.modelproviders.RegisterModelProvider;
import com.mvvm.mvvm_dagger.viewmodel.RegisterViewModel;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewUserFragment extends Fragment {
    Application application;
    Retrofit retrofit;
    @BindView(R.id.tvPrivacyPolicy)
    TextView tvPrivacyPolicy;
    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.etConfirmPassword)
    EditText etConfirmPassword;
    @BindView(R.id.etEmail)
    EditText etEmail;
    private View rootView;

    public NewUserFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_new_user_fragment, container, false);
        ButterKnife.bind(this, rootView);
        init();
       // rootView = DataBindingUtil.inflate(inflater, R.layout.fragment_new_user_fragment, container, false).getRoot();
        return rootView;
    }

    private void init() {
        application = ((WelcomeActivity) getActivity()).application;
        retrofit = ((WelcomeActivity) getActivity()).retrofit;
    }

    @OnClick(R.id.btnFacebook)
    public void facebookfragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, new FacebookLoginfragment()).addToBackStack("").commit();

    }

    @OnClick(R.id.txtLogIn)
    public void setTxtLogIn() {
        getFragmentManager().beginTransaction().replace(R.id.container, new ReturningUserFragment()).addToBackStack("").commit();

    }

    @OnClick(R.id.btnCreateAccount)
    public void createAccount() {
        ApiRegisterRequest apiRegisterRequest = new ApiRegisterRequest();
        apiRegisterRequest.setWsfunction(Api.REGISTER);
        ApiRegisterRequestAgrs apiRegisterRequestAgrs = new ApiRegisterRequestAgrs();
        apiRegisterRequestAgrs.setEmail(etEmail.getText().toString().trim());
        apiRegisterRequestAgrs.setPassword(etPassword.getText().toString().trim());
        apiRegisterRequestAgrs.setUsername(etUserName.getText().toString().trim());
        apiRegisterRequest.setArgs(apiRegisterRequestAgrs);
        RegisterViewModel registerViewModel = ViewModelProviders.of(this, new RegisterModelProvider(application, retrofit, apiRegisterRequest)).get(RegisterViewModel.class);
        registerViewModel.createregister().observe(this, new Observer<ApiResponseRegister>() {
            @Override
            public void onChanged(@Nullable ApiResponseRegister apiResponseRegister) {
                Toast.makeText(getActivity(), apiResponseRegister.getMsg() + "", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.container, new MyProfileAddFragment()).addToBackStack("").commit();

            }
        });

    }
}
