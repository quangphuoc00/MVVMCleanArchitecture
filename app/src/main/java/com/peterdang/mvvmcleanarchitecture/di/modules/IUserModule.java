package com.peterdang.mvvmcleanarchitecture.di.modules;

import android.app.Activity;
import android.content.Context;

import com.example.repositories.UserRepository;
import com.peterdang.domain.usecases.LoginUsecase;

/**
 * Created by phuoc on 2017-10-17.
 */

public interface IUserModule {
    LoginUsecase provideLoginUserCase(final UserRepository mRepository);
}
