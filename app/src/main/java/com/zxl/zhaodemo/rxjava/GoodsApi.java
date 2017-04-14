package com.zxl.zhaodemo.rxjava;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ${zxl} on 2017/4/13.
 * D:
 * C:
 */

public interface GoodsApi {
//    @GET("CustomerApp/Api/Community/GetGoodss")
//    Observable<GoodsInfo> getGoods(@Query("orderByPrice") int orderByPrice,
//                                           @Query("orderByNew") int orderByNew,
//                                           @Query("goodsTypeID") int goodsTypeID,
//                                           @Query("pageIndex") int pageIndex,
//                                           @Query("pageSize") int pageSize,
//                                           @Query("keyWord") String keyWord);
    @GET("CustomerApp/Api/Community/GetGoodss")
    Observable<Goods> getGoods();
}
