package com.peterdang.mvvmcleanarchitecture.ui.main;

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
    public MainViewModel(Navigator navigator) {
        this.mNavigator = navigator;
    }

    @Override
    public void onLoad(Bundle bundle) {

    }

    public void onLoginClick(View view){
        mNavigator.navigateToLogin();
    }
}
