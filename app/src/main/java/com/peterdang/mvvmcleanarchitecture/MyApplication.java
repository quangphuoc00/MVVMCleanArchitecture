package com.peterdang.mvvmcleanarchitecture;

import android.app.Application;

import com.peterdang.mvvmcleanarchitecture.di.components.ApplicationComponent;
import com.peterdang.mvvmcleanarchitecture.di.components.DaggerApplicationComponent;
import com.peterdang.mvvmcleanarchitecture.di.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by phuoc on 2017-10-07.
 */

public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}
