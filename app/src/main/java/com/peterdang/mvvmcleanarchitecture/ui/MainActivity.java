package com.peterdang.mvvmcleanarchitecture.ui;

import android.os.Bundle;

import com.peterdang.mvvmcleanarchitecture.R;
import com.peterdang.mvvmcleanarchitecture.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
