package com.example.repositories;

import com.example.entities.response.BaseResponse;
import com.example.entities.response.LoginModel;

import io.reactivex.Observable;

/**
 * Created by phuoc on 2017-10-17.
 */

public interface UserRepository {
    Observable<BaseResponse<LoginModel>> login(String username, String password);
}
