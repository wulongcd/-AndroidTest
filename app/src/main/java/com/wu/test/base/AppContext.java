package com.wu.test.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;


import com.wu.test.di.component.AppComponent;
import com.wu.test.di.component.DaggerAppContextComponent;
import com.wu.test.utils.LogUtils;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import okhttp3.OkHttpClient;

public class AppContext extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;
    public static AppComponent appComponent;
    private static AppContext instance;
    OkHttpClient okHttpClient = new OkHttpClient();

    @Override
    public void onCreate() {
        super.onCreate();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);

        DaggerAppContextComponent.create().inject(this);

        instance = this;
        //打印测试设备码
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }

//    public static String[] getTestDeviceInfo(Context context){
//        String[] deviceInfo = new String[2];
//        try {
//            if(context != null){
//                deviceInfo[0] = DeviceConfig.getDeviceIdForGeneral(context);
//                deviceInfo[1] = DeviceConfig.getMac(context);
//            }
//        } catch (Exception e){
//        }
//        LogUtils.d("{\"device_id\": \""+ deviceInfo[0] +"\", \"mac\": \""+ deviceInfo[1] + "\"}");
//        return deviceInfo;
//    }

    public static Context getContext() {
        return instance;
    }

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
//            appComponent = DaggerAppComponent.builder()
//                    .appModule(new AppModule(instance))
//                    .build();
        }
        return appComponent;
    }

    public static int getColor_(int resId) {
        return getContext().getResources().getColor(resId);
    }
}
