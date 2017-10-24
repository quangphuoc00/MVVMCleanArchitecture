package com.peterdang.mvvmcleanarchitecture.ui.login;

import android.databinding.Bindable;
import android.os.Bundle;
import android.view.View;

import com.peterdang.domain.exceptions.DataEntityException;
import com.peterdang.domain.usecases.LoginUsecase;
import com.peterdang.mvvmcleanarchitecture.BR;
import com.peterdang.mvvmcleanarchitecture.base.BaseDisposableViewModel;
import com.peterdang.mvvmcleanarchitecture.base.BaseViewModel;
import com.peterdang.mvvmcleanarchitecture.utils.ToastUtil;

import javax.inject.Inject;

/**
 * Created by phuoc on 2017-10-16.
 */

public class LoginViewModel extends BaseDisposableViewModel implements BaseViewModel {

    private String username;
    private String password;

    LoginUsecase loginUsecase;
    ToastUtil toastUtil;

    @Inject
    public LoginViewModel(LoginUsecase loginUsecase, ToastUtil toastUtil) {
        this.loginUsecase = loginUsecase;
        this.toastUtil = toastUtil;
    }

    @Override
    public void onLoad(Bundle bundle) {

    }

    @Bindable
    public String getUsername() {
        return username;
    }

    @Bindable
    public String getPassword() {
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

    public void onLoginClicked(View view) {
        LoginUsecase.LoginParam loginParam = new LoginUsecase.LoginParam(username, password);
        try {
            loginParam.isValid();
            addDisposable(
                    loginUsecase.run(loginParam)
                            .subscribe(loginModelBaseResponse -> {

                            })
            );
        } catch (DataEntityException e) {
            toastUtil.show(e.getMessage());
        }
    }
}
