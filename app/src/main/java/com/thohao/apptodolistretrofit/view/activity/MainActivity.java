package com.thohao.apptodolistretrofit.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.thohao.apptodolistretrofit.R;
import com.thohao.apptodolistretrofit.api.RetrofitInit;
import com.thohao.apptodolistretrofit.model.Response;
import com.thohao.apptodolistretrofit.model.Sinhvien;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Flowable<Response<List<Sinhvien>>>sinhvienRequest= RetrofitInit
                .getInStance()
                .getlistSinhvien();
        sinhvienRequest
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<List<Sinhvien>>>() {
                    @Override
                    public void accept(Response<List<Sinhvien>> listResponse) throws Exception {
                        Log.d("CCC", listResponse.getData().size()+"");
                    }
                });
    }
}
