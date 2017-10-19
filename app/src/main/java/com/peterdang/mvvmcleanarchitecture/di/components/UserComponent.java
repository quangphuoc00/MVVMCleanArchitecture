package com.peterdang.mvvmcleanarchitecture.di.components;

import com.peterdang.mvvmcleanarchitecture.di.modules.UserModule;
import com.peterdang.mvvmcleanarchitecture.di.scopes.UserScope;
import com.peterdang.mvvmcleanarchitecture.ui.login.LoginActivity;

import dagger.Subcomponent;

/**
 * Created by phuoc on 2017-10-17.
 */
@UserScope
@Subcomponent(modules={UserModule.class})
public interface UserComponent {
    void inject(LoginActivity loginActivity);
}
