package com.peterdang.data.datasource.remote;

import com.example.entities.response.BaseResponse;
import com.example.entities.response.LoginModel;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import io.reactivex.Observable;

public interface RemotingDataAPI {

    @POST("/login/{date}.json")
    Observable<BaseResponse<LoginModel>> login(@Path("date") String date,
                                               @Query("app_id") String appId);
}
