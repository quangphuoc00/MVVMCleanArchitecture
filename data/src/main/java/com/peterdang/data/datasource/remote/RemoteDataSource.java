package com.peterdang.data.datasource.remote;

import com.example.entities.response.BaseResponse;
import com.example.entities.response.LoginModel;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by phuoc on 2017-10-18.
 */

public class RemoteDataSource{
    private RemotingDataAPI mDataApi;

    @Inject
    public RemoteDataSource(RemotingDataAPI mDataApi) {
        this.mDataApi = mDataApi;
    }

    public Observable<BaseResponse<LoginModel>> login(String name, String pass) {
        return mDataApi.login(name, pass);
    }
}
