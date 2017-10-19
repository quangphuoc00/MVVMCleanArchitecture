package com.peterdang.mvvmcleanarchitecture.di.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by phuoc on 2017-10-17.
 */

@Scope
@Retention(RUNTIME)
public @interface UserScope {
}
