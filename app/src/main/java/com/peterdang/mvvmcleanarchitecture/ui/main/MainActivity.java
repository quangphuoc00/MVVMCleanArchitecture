package com.peterdang.mvvmcleanarchitecture.ui.main;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.peterdang.mvvmcleanarchitecture.BR;
import com.peterdang.mvvmcleanarchitecture.MyApplication;
import com.peterdang.mvvmcleanarchitecture.R;
import com.peterdang.mvvmcleanarchitecture.base.BaseActivity;
import com.peterdang.mvvmcleanarchitecture.di.components.DaggerUserComponent;
import com.peterdang.mvvmcleanarchitecture.di.components.UserComponent;
import com.peterdang.mvvmcleanarchitecture.di.modules.UserModule;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    MainViewModel mViewModel;

    private UserComponent userComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.initializeInjector();
        userComponent.inject(this);

        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVariable(BR.mainViewModel, mViewModel);
    }

    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }
}
