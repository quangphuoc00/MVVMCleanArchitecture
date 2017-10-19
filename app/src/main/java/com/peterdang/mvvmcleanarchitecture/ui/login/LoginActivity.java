package com.peterdang.mvvmcleanarchitecture.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.peterdang.mvvmcleanarchitecture.BR;
import com.peterdang.mvvmcleanarchitecture.R;
import com.peterdang.mvvmcleanarchitecture.base.BaseActivity;
import com.peterdang.mvvmcleanarchitecture.models.UserModel;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<> {

    @Inject
    LoginViewModel mViewModel;

    public static Intent getCallingIntent(Context context) {
        Intent callingIntent = new Intent(context, LoginActivity.class);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setVariable(BR.user, mViewModel);
        if (!isRetained(savedInstanceState)) {
            final String currencyCode = getIntent().getStringExtra(INTENT_EXTRA_PARAM_CURRENCY_CODE);
            Bundle bundle = new Bundle();
            bundle.putString(CurrencyDetailsViewModel.KEY_CURRENCY_CODE, currencyCode);
            mViewModel.onLoad(bundle);
        }
    }

    @Override
    protected void onDestroy() {
        if(!isChangingConfigurations()) {
            mViewModel.dispose();
        }
        super.onDestroy();
    }

    @Override
    protected void injectDependencies(final CurrencyDetailsActivitySubComponent activityComponent) {
        activityComponent.inject(this);
    }

    protected CurrencyDetailsActivitySubComponent newComponent() {
        return ((ExchangeRatesApplication) getApplication())
                .getApplicationComponent()
                .newCurrencyDetailsActivitySubComponent(new CurrencyDetailsActivityModule(this));
    }

}
