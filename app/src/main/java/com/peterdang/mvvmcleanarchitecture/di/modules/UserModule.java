package com.peterdang.mvvmcleanarchitecture.di.modules;

import android.app.Activity;

import com.example.repositories.UserRepository;
import com.peterdang.data.datasource.remote.RemoteDataSource;
import com.peterdang.data.datasource.repository.UserRepositoryImp;
import com.peterdang.domain.usecases.LoginUsecase;
import com.peterdang.mvvmcleanarchitecture.di.scopes.PerActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by phuoc on 2017-10-17.
 */
@Module
public class UserModule implements IUserModule {
    @Provides
    @Override
    @PerActivity
    public LoginUsecase provideLoginUserCase(final UserRepository mRepository) {
        return new LoginUsecase(Schedulers.io(), AndroidSchedulers.mainThread(), mRepository);
    }

    @Provides
    @PerActivity
    public UserRepository provideUserRepository(final RemoteDataSource remoteSource) {
        return new UserRepositoryImp(remoteSource);
    }
}
