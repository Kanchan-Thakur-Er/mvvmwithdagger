package com.mvvm.mvvm_dagger.component;

import com.mvvm.mvvm_dagger.activities.WelcomeActivity;
import com.mvvm.mvvm_dagger.module.ApiModule;
import com.mvvm.mvvm_dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(WelcomeActivity activity);
}