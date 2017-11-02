package com.peterdang.mvvmcleanarchitecture.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.peterdang.mvvmcleanarchitecture.base.BaseDisposableViewModel;
import com.peterdang.mvvmcleanarchitecture.base.BaseViewModel;
import com.peterdang.mvvmcleanarchitecture.navigator.Navigator;

import javax.inject.Inject;

/**
 * Created by phuoc on 2017-10-22.
 */

public class MainViewModel extends BaseDisposableViewModel implements BaseViewModel {

    @Inject
    Navigator mNavigator;
    @Inject
    Activity activity;

    @Inject
    public MainViewModel(Navigator navigator, Activity activity) {
        this.mNavigator = navigator;
        this.activity = activity;
    }

    @Override
    public void onLoad(Bundle bundle) {

    }

    public void onLoginClick(View view){
        mNavigator.navigateToLogin(activity);
    }
}
