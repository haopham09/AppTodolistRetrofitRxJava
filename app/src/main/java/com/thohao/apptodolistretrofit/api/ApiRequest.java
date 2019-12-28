package com.thohao.apptodolistretrofit.api;

import com.thohao.apptodolistretrofit.model.Response;
import com.thohao.apptodolistretrofit.model.Sinhvien;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("sinhvien.php")
    Flowable<Response<List<Sinhvien>>>getlistSinhvien();
}
