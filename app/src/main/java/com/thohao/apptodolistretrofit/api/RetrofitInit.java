package com.thohao.apptodolistretrofit.api;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInit {
    private static Retrofit retrofit =null;

    public RetrofitInit() {
    }

    public static ApiRequest getInStance() {
        if (retrofit == null) {
            retrofit = initRetro();
        }
        return retrofit.create(ApiRequest.class);
    }

    private static Retrofit initRetro() {
        Gson gson=new Gson();
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:8080/apiSinhvien/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}
