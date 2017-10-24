package com.peterdang.mvvmcleanarchitecture.navigator;

import android.content.Context;
import android.content.Intent;

import com.peterdang.mvvmcleanarchitecture.ui.login.LoginActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by phuoc on 2017-10-07.
 */

@Singleton
public class Navigator {
    private Context mContext;

    @Inject
    public Navigator(Context mContext) {
        this.mContext = mContext;
    }

    public void navigateToLogin() {
        Intent intentToLaunch = LoginActivity.getCallingIntent(mContext);
        mContext.startActivity(intentToLaunch);
    }
}
