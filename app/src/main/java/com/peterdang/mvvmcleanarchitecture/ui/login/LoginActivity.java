package com.peterdang.mvvmcleanarchitecture.ui.login;

import android.content.Context;
import android.content.Intent;
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

public class LoginActivity extends BaseActivity {

    @Inject
    LoginViewModel mViewModel;

    UserComponent userComponent;

    public static Intent getCallingIntent(Context context) {
        Intent callingIntent = new Intent(context, LoginActivity.class);
        return callingIntent;
    }


    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setVariable(BR.user, mViewModel);

        initializeInjector();
        userComponent.inject(this);
    }

    @Override
    protected void onDestroy() {
        if(!isChangingConfigurations()) {
            mViewModel.dispose();
        }
        super.onDestroy();
    }
}
