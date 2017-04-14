package com.zxl.zhaodemo.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;
import com.zxl.zhaodemo.BaseActivity;
import com.zxl.zhaodemo.R;


import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

import okhttp3.OkHttpClient;

import retrofit2.Converter;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * @author： zhaoxiaolei
 * @date: 2017/1/18 0018
 * @time: 10:33
 * @description: rxDemo
 */

public class RxMainActivity extends BaseActivity {
    @InjectView(R.id.rx_main_lv)
    ListView rxMainLv;


    private Converter.Factory conver = GsonConverterFactory.create();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_main);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        List<String> strings = new ArrayList<>();
        strings.add("基础测试");
        strings.add("数据测试");
        rxMainLv.setAdapter(new CommonAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, strings) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(android.R.id.text1, item);
            }
        });
        rxMainLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("aaa", "aaaa");
                testRx1();
            }
        });
    }


    private void testRx1() {
        Observer<HospitalBean> observer = new Observer<HospitalBean>() {
            @Override
            public void onCompleted() {
                Log.e("aaa", "aaaa");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("aaa", e.toString());
            }

            @Override
            public void onNext(HospitalBean hospitalBean) {
                Gson gson=new Gson();

                Log.e("aaasu",  gson.toJson(hospitalBean));
            }


        };
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://121.28.144.94:2222/")
//                .client(new OkHttpClient())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        GetHospitalDataApi hospitalData = retrofit.create(GetHospitalDataApi.class);
//        hospitalData.getHospital(1).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
        Network.init().getHospitalDataApi().getHospital(1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
