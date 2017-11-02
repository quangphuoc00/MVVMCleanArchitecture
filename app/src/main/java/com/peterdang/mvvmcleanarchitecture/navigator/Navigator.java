package com.peterdang.mvvmcleanarchitecture.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.peterdang.mvvmcleanarchitecture.ui.login.LoginActivity;

import javax.inject.Inject;

/**
 * Created by phuoc on 2017-10-07.
 */

public class Navigator {

    @Inject
    public Navigator() {
    }

    public void navigateToLogin(Activity activity) {
        Intent intentToLaunch = LoginActivity.getCallingIntent(activity);
        activity.startActivity(intentToLaunch);
    }
}
