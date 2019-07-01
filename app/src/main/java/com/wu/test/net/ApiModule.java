package com.wu.test.net;

import com.wu.test.net.converter.CustomerGsonConverterFactory;
import com.wu.test.net.retrofit.ApiService;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    /**
     * base url
     */
    private static final String HOST = "https://api.leancloud.cn";

    @Singleton
    @Provides
    ApiService provideApiService(OkHttpClient httpClient) {
        // Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .addConverterFactory(CustomerGsonConverterFactory.create()) // gson
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // rxjava
                .client(httpClient)
                .build();

        return retrofit.create(ApiService.class);
    }

    @Provides
    OkHttpClient provideOkHttpClient() {
        // OkHttpClient
        OkHttpClient okHttpClient = new OkHttpClient();

        // 统一添加的Header
        okHttpClient.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build();
                return chain.proceed(request);
            }
        });

        // log
//        LoggingInterceptor interceptor = new LoggingInterceptor.Builder()
//                .loggable(BuildConfig.DEBUG)
//                .setLevel(com.ihsanbal.logging.Level.BASIC)
//                .log(Platform.INFO)
//                .addHeader("version", BuildConfig.VERSION_NAME)
//                .build();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.interceptors().add(interceptor);

        return okHttpClient;
    }

}
