package com.peterdang.data.datasource.repository;

import com.example.entities.response.BaseResponse;
import com.example.entities.response.LoginModel;
import com.example.repositories.UserRepository;
import com.peterdang.data.datasource.UserDataSource;

import io.reactivex.Observable;

public class UserRepositoryImp implements UserRepository {
    private UserDataSource mRemoteSource;

    public UserRepositoryImp(final UserDataSource remoteSource) {
        mRemoteSource = remoteSource;
    }

    @Override
    public Observable<BaseResponse<LoginModel>> login(String username, String password) {
        return mRemoteSource.login(username, password);
    }
}