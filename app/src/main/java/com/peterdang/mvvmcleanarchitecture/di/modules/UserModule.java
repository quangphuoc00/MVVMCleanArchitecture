package com.peterdang.mvvmcleanarchitecture.di.modules;

import android.app.Activity;

import com.example.repositories.UserRepository;
import com.peterdang.domain.usecases.LoginUsecase;
import com.peterdang.mvvmcleanarchitecture.di.scopes.UserScope;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by phuoc on 2017-10-17.
 */
@Module
public class UserModule implements IUserModule {
    private final Activity mContext;

    public UserModule(final Activity context) {
        mContext = context;
    }

    @Provides
    @UserScope
    @Override
    public LoginUsecase provideLoginUserCase(final UserRepository mRepository) {
        return new LoginUsecase(Schedulers.io(), AndroidSchedulers.mainThread(),
                mRepository);
    }
}