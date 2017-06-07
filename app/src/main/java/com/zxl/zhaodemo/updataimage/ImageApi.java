package com.zxl.zhaodemo.updataimage;

import com.zxl.zhaodemo.rxjava.rxhelper.BaseModel;


import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/6
 * @time: 11:02
 * @description:
 */

public interface ImageApi {

    @POST("Authentication/driver_info")
    Call<ResponseBody> upData(@Body RequestBody body);



    @Multipart
    @POST("Authentication/driver_info")
    Call<ResponseBody> uploadFile(@Part() RequestBody file1,
                                  @Part() RequestBody file2,
                                  @Part() RequestBody file3,
                                  @Part() RequestBody file4,
                                  @Part() RequestBody file5,
                                  @Part() RequestBody file6,
                                  @Query("name") String name,
                                  @Query("sex") String sex,
                                  @Query("managerphone") String managerphone,
                                  @Query("jianducardstart") String jianducardstart,
                                  @Query("jianducardend") String jianducardend
                                  );


    @POST("login/login")
    Call<ResponseBody> login(@Query("phonenum") String phonenum,
                         @Query("password") String password);

}
