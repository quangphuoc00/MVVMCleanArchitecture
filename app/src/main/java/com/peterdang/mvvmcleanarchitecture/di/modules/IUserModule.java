package com.peterdang.mvvmcleanarchitecture.di.modules;

import android.app.Activity;
import android.content.Context;

import com.example.repositories.UserRepository;
import com.peterdang.domain.usecases.LoginUsecase;
import com.peterdang.mvvmcleanarchitecture.navigator.Navigator;

/**
 * Created by phuoc on 2017-10-17.
 */

public interface IUserModule {
    Context provideActivity();

    LoginUsecase provideLoginUserCase(final UserRepository mRepository);
    Navigator provideNavigator();
//    Navigator provideNavigator(final Activity activity);
}
