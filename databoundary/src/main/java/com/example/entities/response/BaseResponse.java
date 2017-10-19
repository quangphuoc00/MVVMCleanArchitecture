package com.example.entities.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phuoc on 2017-10-08.
 */

public class BaseResponse<T>{
    @SerializedName("status_code")
    private int statusCode;
    private T data;
    private String message;

    public BaseResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
