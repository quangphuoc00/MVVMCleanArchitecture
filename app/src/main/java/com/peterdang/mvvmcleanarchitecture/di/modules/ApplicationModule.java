/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.peterdang.mvvmcleanarchitecture.di.modules;

import android.content.Context;

import com.peterdang.data.datasource.UserDataSource;
import com.peterdang.data.datasource.remote.RemoteDataSource;
import com.peterdang.data.datasource.remote.RemotingDataAPI;
import com.peterdang.data.datasource.repository.UserRepositoryImp;
import com.example.repositories.UserRepository;
import com.peterdang.mvvmcleanarchitecture.MyApplication;
import com.peterdang.mvvmcleanarchitecture.properties.ApplicationProperties;
import com.peterdang.mvvmcleanarchitecture.properties.ApplicationPropertiesImp;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final MyApplication application;

    public ApplicationModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ApplicationProperties provideProperties(Context context){
        return new ApplicationPropertiesImp(context);
    }


    @Provides
    @Singleton
    @Named("remote")
    public UserDataSource provideRemoteCurrencyDataSource(final RemotingDataAPI remoteDataAPI){
        return new RemoteDataSource(remoteDataAPI);
    }
}
