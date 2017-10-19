package com.peterdang.mvvmcleanarchitecture.di.scopes;

/**
 * Created by phuoc on 2017-10-08.
 */
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
