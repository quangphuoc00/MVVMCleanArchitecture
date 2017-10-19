package com.peterdang.mvvmcleanarchitecture.ui.splash;

import android.app.Activity;
import android.os.Bundle;

import com.peterdang.mvvmcleanarchitecture.base.BaseActivity;
import com.peterdang.mvvmcleanarchitecture.presentation.R;

public class SplashActivity extends BaseActivity<> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
