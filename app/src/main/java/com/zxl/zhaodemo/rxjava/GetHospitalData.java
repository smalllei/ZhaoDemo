package com.zxl.zhaodemo.rxjava;




import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * @author： zhaoxiaolei
 * @date: 2017/1/22 0022
 * @time: 10:32
 * @description:
 */

public interface GetHospitalData {
    @GET("CustomerApp/Api/hospital/GetHospital")
    Observable<HospitalBean> getHospital(@Query("hospitalID") int hospitalID);
}
