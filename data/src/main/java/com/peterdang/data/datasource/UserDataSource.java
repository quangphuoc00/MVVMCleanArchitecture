package com.peterdang.data.datasource;

import com.example.entities.response.BaseResponse;
import com.example.entities.response.LoginModel;

import io.reactivex.Observable;

public interface UserDataSource {
    Observable<BaseResponse<LoginModel>> login(String name, String pass);
}
