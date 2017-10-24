package com.peterdang.mvvmcleanarchitecture.utils;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * Created by phuoc on 2017-10-24.
 */

public class ToastUtil {
    private Context context;

    @Inject
    public ToastUtil(Context context) {
        this.context = context;
    }

    public void show(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
