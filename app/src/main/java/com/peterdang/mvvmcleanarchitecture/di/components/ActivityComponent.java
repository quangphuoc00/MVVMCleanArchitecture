package com.peterdang.mvvmcleanarchitecture.di.components;

import android.app.Activity;

import com.peterdang.mvvmcleanarchitecture.di.modules.ActivityModule;
import com.peterdang.mvvmcleanarchitecture.di.scopes.PerActivity;

import dagger.Component;

/**
 * Created by phuoc on 2017-10-24.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
