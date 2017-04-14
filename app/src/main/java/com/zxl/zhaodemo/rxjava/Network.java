package com.zxl.zhaodemo.rxjava;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ${zxl} on 2017/4/13.
 * D:
 * C:
 */

public class Network {
    private static Retrofit sRetrofit = null;
    private static OkHttpClient sOkHttpClient = null;
    private static Network network;
     public static Network init(){
         if (network==null||sRetrofit==null||sOkHttpClient==null) {
             network=new Network();
         }
         return network;
     }
     public Network(){
         initOkHttp();
     }
    private static void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        File cacheFile = new File("cacheFile");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //   request=request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                Response response = chain.proceed(request);
                Response.Builder newBuilder = response.newBuilder();
                int maxAge = 0;
                // 有网络时 设置缓存超时时间0个小时
                newBuilder.header("Cache-Control", "public, max-age=" + maxAge);
                // 无网络时，设置超时为4周
                // int maxStale = 60 * 60 * 24 * 28;
                // newBuilder.header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale);

                return newBuilder.build();
            }
        };
        builder.cache(cache).addInterceptor(interceptor);
        //设置超时
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //设置重连
        builder.retryOnConnectionFailure(true);
        sOkHttpClient = builder.build();
        sRetrofit=  new Retrofit.Builder()
                .baseUrl("http://121.28.144.94:2222/")
                .client(sOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    private static void initRetrofit() {

    }
    private static GoodsApi goodsApi;
    public  GoodsApi getGoodsApi(){
        return sRetrofit.create(GoodsApi.class);
    }
    public GetHospitalDataApi getHospitalDataApi(){
        return sRetrofit.create(GetHospitalDataApi.class);
    }
}
