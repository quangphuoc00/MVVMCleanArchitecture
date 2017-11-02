package com.peterdang.mvvmcleanarchitecture.di.components;

import android.app.Application;

import com.peterdang.mvvmcleanarchitecture.di.modules.ActivityModule;
import com.peterdang.mvvmcleanarchitecture.di.modules.UserModule;
import com.peterdang.mvvmcleanarchitecture.di.scopes.PerActivity;
import com.peterdang.mvvmcleanarchitecture.ui.login.LoginActivity;
import com.peterdang.mvvmcleanarchitecture.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by phuoc on 2017-10-17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {
    void inject(LoginActivity loginActivity);
    void inject(MainActivity mainActivity);
}