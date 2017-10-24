package com.peterdang.mvvmcleanarchitecture.di.modules;

import android.app.Activity;
import android.content.Context;

import com.example.repositories.UserRepository;
import com.peterdang.data.datasource.UserDataSource;
import com.peterdang.data.datasource.repository.UserRepositoryImp;
import com.peterdang.domain.usecases.LoginUsecase;
import com.peterdang.mvvmcleanarchitecture.di.scopes.UserScope;
import com.peterdang.mvvmcleanarchitecture.navigator.Navigator;

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
    private final Context mContext;

    public UserModule(final Context context) {
        mContext = context;
    }

    @Provides
    @UserScope
    @Override
    public Context provideActivity() {
        return mContext;
    }

    @Provides
    @UserScope
    @Override
    public LoginUsecase provideLoginUserCase(final UserRepository mRepository) {
        return new LoginUsecase(Schedulers.io(), AndroidSchedulers.mainThread(), mRepository);
    }

    @Provides
    @Singleton
    public UserRepository provideUserRepository(final UserDataSource remoteSource){
        return new UserRepositoryImp(remoteSource);
    }

    @Provides
    public Navigator provideNavigator(){
        return new Navigator(mContext);
    }
}
