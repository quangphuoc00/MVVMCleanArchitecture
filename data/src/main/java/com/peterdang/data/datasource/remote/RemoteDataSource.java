package com.peterdang.data.datasource.remote;

import com.example.entities.response.BaseResponse;
import com.example.entities.response.LoginModel;
import com.peterdang.data.datasource.UserDataSource;

import io.reactivex.Observable;

/**
 * Created by phuoc on 2017-10-18.
 */

public class RemoteDataSource implements UserDataSource {
    private RemotingDataAPI mDataApi;

    public RemoteDataSource(RemotingDataAPI mDataApi) {
        this.mDataApi = mDataApi;
    }

    @Override
    public Observable<BaseResponse<LoginModel>> login(String name, String pass) {
        return mDataApi.login(name, pass);
    }


}
