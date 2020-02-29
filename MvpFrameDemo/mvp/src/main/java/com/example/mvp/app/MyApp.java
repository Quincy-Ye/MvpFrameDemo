package com.example.mvp.app;

import android.app.Application;

/**
 * @author Quincy
 * @Date 2020/1/31
 * @Description
 * 整个应用的入口，完成一些希望在应用一启动就立刻完成的工作，
 * 比如初始化一些第三方库，包括SDK
 * 获取应用全局的上下文
 */

public class MyApp extends Application {
    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
