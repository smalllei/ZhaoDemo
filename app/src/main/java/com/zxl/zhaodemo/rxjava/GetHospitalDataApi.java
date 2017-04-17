package com.zxl.zhaodemo.rxjava;




import com.zxl.zhaodemo.rxjava.rxhelper.BaseModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * @author： zhaoxiaolei
 * @date: 2017/1/22 0022
 * @time: 10:32
 * @description:
 */

public interface GetHospitalDataApi {
    @GET("CustomerApp/Api/hospital/GetHospital")
    Observable<BaseModel<GetHospitalEntity>> getHospital(@Query("hospitalID") int hospitalID);
}
