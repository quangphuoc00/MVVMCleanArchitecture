package com.peterdang.mvvmcleanarchitecture.models;

/**
 * Created by phuoc on 2017-10-16.
 */

public class UserModel {
    private final String username;
    private final String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
