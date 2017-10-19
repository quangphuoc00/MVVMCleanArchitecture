package com.peterdang.mvvmcleanarchitecture.properties;

import android.content.Context;
import android.content.res.AssetManager;

import com.peterdang.mvvmcleanarchitecture.R;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertiesImp implements ApplicationProperties {

    private final Context mContext;
    private Properties properties;

    public ApplicationPropertiesImp(Context context){
        mContext = context;
        properties = new Properties();
        properties = getMyProperties("config.properties");
    }

    public Properties getMyProperties(String file){
        try{
            AssetManager assetManager = mContext.getAssets();
            InputStream inputStream = assetManager.open(file);
            properties.load(inputStream);
        }catch (Exception e){
            System.out.print(e.getMessage());
        }

        return properties;
    }

    @Override
    public String sharedPreferencesName() {
        return properties.getProperty("sharedPreferencesName");
    }

    @Override
    public String baseUrl() {
        return properties.getProperty("baseUrl");
    }
}
