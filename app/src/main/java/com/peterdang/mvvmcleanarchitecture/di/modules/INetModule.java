package com.peterdang.mvvmcleanarchitecture.di.modules;

import com.google.gson.Gson;
import com.peterdang.data.datasource.remote.RemotingDataAPI;
import com.peterdang.mvvmcleanarchitecture.properties.ApplicationProperties;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

interface INetModule {
    Gson provideGson();

    OkHttpClient provideOkHttpClient(ApplicationProperties propertiesManager);

    Retrofit provideRetrofit(Gson gson, ApplicationProperties propertiesManager, OkHttpClient client);

    RemotingDataAPI provideRemotingDataAPI(Retrofit retrofit);
}
