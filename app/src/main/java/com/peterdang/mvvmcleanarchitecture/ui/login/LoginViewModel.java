package com.peterdang.mvvmcleanarchitecture.ui.login;

import android.databinding.Bindable;
import android.os.Bundle;

import com.peterdang.mvvmcleanarchitecture.BR;
import com.peterdang.mvvmcleanarchitecture.base.BaseDisposableViewModel;
import com.peterdang.mvvmcleanarchitecture.base.BaseViewModel;

import javax.inject.Inject;

/**
 * Created by phuoc on 2017-10-16.
 */

public class LoginViewModel extends BaseDisposableViewModel implements BaseViewModel {

    private String username;
    private String password;

    @Inject
    public LoginViewModel() {
    }

    @Override
    public void onLoad(Bundle bundle) {

    }

    @Bindable
    public String getUsername(){
        return username;
    }

    @Bindable
    public String getPassword(){
        return password;
    }

    public void setUsername(final String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    public void setPassword(final String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
