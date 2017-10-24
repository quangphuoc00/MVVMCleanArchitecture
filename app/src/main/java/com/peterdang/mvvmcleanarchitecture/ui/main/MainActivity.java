package com.peterdang.mvvmcleanarchitecture.ui.main;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.peterdang.mvvmcleanarchitecture.BR;
import com.peterdang.mvvmcleanarchitecture.MyApplication;
import com.peterdang.mvvmcleanarchitecture.R;
import com.peterdang.mvvmcleanarchitecture.base.BaseActivity;
import com.peterdang.mvvmcleanarchitecture.di.components.UserComponent;
import com.peterdang.mvvmcleanarchitecture.di.modules.UserModule;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<UserComponent> {

    @Inject
    MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVariable(BR.model, mViewModel);
    }

    @Override
    protected void injectDependencies(UserComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected UserComponent newComponent() {
        return ((MyApplication) getApplication())
                .getApplicationComponent()
                .newUserComponent(new UserModule(this));
    }
}
