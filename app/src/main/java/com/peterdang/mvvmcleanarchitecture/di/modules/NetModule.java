package com.peterdang.mvvmcleanarchitecture.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.peterdang.data.datasource.remote.RemoteDataSource;
import com.peterdang.data.datasource.remote.RemotingDataAPI;
import com.peterdang.mvvmcleanarchitecture.BuildConfig;
import com.peterdang.mvvmcleanarchitecture.properties.ApplicationProperties;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule implements INetModule{

    @Override
    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
    }

    @Override
    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(ApplicationProperties propertiesManager) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Override
    @Provides
    @Singleton
    public Retrofit provideRetrofit(Gson gson, ApplicationProperties propertiesManager, OkHttpClient client) {
        return new Retrofit.Builder()
        .baseUrl("http://test-test.domainname.com")
//                .baseUrl(propertiesManager.baseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }

    @Override
    @Provides
    @Singleton
    public RemotingDataAPI provideRemotingDataAPI(Retrofit retrofit){
        return retrofit.create(RemotingDataAPI.class);
    }

    @Provides
    @Singleton
    public RemoteDataSource provideRemoteCurrencyDataSource(final RemotingDataAPI remoteDataAPI){
        return new RemoteDataSource(remoteDataAPI);
    }
}
