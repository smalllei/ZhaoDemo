package com.zxl.zhaodemo.rxjava;

import java.io.Serializable;
import java.util.List;

/**
 * 创建人：赵小磊
 * 创建时间：2016/12/6 0006 13:20
 * 描述：商品详情
 */

public class GoodsInfo implements Serializable {

    /**
     * ReState : true
     * ReResult : {"Goodss":[{"GoodsID":1,"GoodsName":"SNP海洋燕窝补水精华面膜10片","ImgUrl":"/FileUpLaod/f1a30a0d-315c-4929-b01f-180a23818004.jpg","price":84,"oldPrice":84,"hospitalName":"华美医疗美容医院美容医院"},{"GoodsID":3,"GoodsName":"雪花秀雨润睡眠修复面膜120m","ImgUrl":"/FileUpLaod/ed8e799f-fe67-4fa0-81b2-f96ade7978f0.jpg","price":299,"oldPrice":299,"hospitalName":"华美医疗美容医院美容医院"},{"GoodsID":15,"GoodsName":"双眼皮贴","ImgUrl":"/FileUpLaod/ee234902-452d-4041-9f89-50e0f0036869.jpg","price":20,"oldPrice":30,"hospitalName":"华美医疗美容医院美容医院"},{"GoodsID":16,"GoodsName":"唇部护理膏[一只120ml超级好用的单品]","ImgUrl":"/FileUpLaod/c00ac7dc-d8a9-4e58-af00-9a4a344fa8c9.png","price":300,"oldPrice":0,"hospitalName":"三秒美容整形医疗机构"},{"GoodsID":17,"GoodsName":"双眼皮治疗首选商品","ImgUrl":"/FileUpLaod/e052d3be-7e60-4a0f-a1ac-869f89009035.jpg","price":999,"oldPrice":1000,"hospitalName":"三秒美容整形医疗机构"},{"GoodsID":18,"GoodsName":"唇膏","ImgUrl":"/FileUpLaod/084689d5-acea-4e50-b0d2-f96d076d5050.jpg","price":50,"oldPrice":70,"hospitalName":"DB整形医院"},{"GoodsID":8,"GoodsName":" 在线预约使用说明 【水光针】【热销项目】特价499元 限时2天！","ImgUrl":"/FileUpLaod/c769d36d-80e6-4964-b7c6-35d32e443262.jpg","price":499,"oldPrice":499,"hospitalName":"世熙医疗美容医院"},{"GoodsID":9,"GoodsName":"【爱芙莱玻尿酸】无痛玻尿酸，晒日记返现100元","ImgUrl":"/FileUpLaod/abb92474-8f89-412a-b059-00d6b3da2f12.jpg","price":880,"oldPrice":0,"hospitalName":"星源医疗美容医院"},{"GoodsID":10,"GoodsName":"【润百颜玻尿酸】1ml/支打造精致面孔","ImgUrl":"/FileUpLaod/35ab33a5-3fab-41a6-b900-e92dbf83a8b7.jpg","price":1299,"oldPrice":0,"hospitalName":"星源医疗美容医院"},{"GoodsID":11,"GoodsName":"【美白嫩肤】光子嫩肤/超冰脱毛/白瓷娃娃 3选2","ImgUrl":"/FileUpLaod/1b6675ff-95d6-4f1a-9f13-e98017b1f845.png","price":199,"oldPrice":0,"hospitalName":"星源医疗美容医院"}]}
     * ReMessage : 请求成功
     * ReToken : 1492075529
     * ErrorCode : 100
     */

    private boolean ReState;
    private ReResultBean ReResult;
    private String ReMessage;
    private String ReToken;
    private String ErrorCode;

    public boolean isReState() {
        return ReState;
    }

    public void setReState(boolean ReState) {
        this.ReState = ReState;
    }

    public ReResultBean getReResult() {
        return ReResult;
    }

    public void setReResult(ReResultBean ReResult) {
        this.ReResult = ReResult;
    }

    public String getReMessage() {
        return ReMessage;
    }

    public void setReMessage(String ReMessage) {
        this.ReMessage = ReMessage;
    }

    public String getReToken() {
        return ReToken;
    }

    public void setReToken(String ReToken) {
        this.ReToken = ReToken;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public static class ReResultBean {
        private List<GoodssBean> Goodss;

        public List<GoodssBean> getGoodss() {
            return Goodss;
        }

        public void setGoodss(List<GoodssBean> Goodss) {
            this.Goodss = Goodss;
        }

        public static class GoodssBean {
            /**
             * GoodsID : 1
             * GoodsName : SNP海洋燕窝补水精华面膜10片
             * ImgUrl : /FileUpLaod/f1a30a0d-315c-4929-b01f-180a23818004.jpg
             * price : 84
             * oldPrice : 84
             * hospitalName : 华美医疗美容医院美容医院
             */

            private int GoodsID;
            private String GoodsName;
            private String ImgUrl;
            private int price;
            private int oldPrice;
            private String hospitalName;

            public int getGoodsID() {
                return GoodsID;
            }

            public void setGoodsID(int GoodsID) {
                this.GoodsID = GoodsID;
            }

            public String getGoodsName() {
                return GoodsName;
            }

            public void setGoodsName(String GoodsName) {
                this.GoodsName = GoodsName;
            }

            public String getImgUrl() {
                return ImgUrl;
            }

            public void setImgUrl(String ImgUrl) {
                this.ImgUrl = ImgUrl;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getOldPrice() {
                return oldPrice;
            }

            public void setOldPrice(int oldPrice) {
                this.oldPrice = oldPrice;
            }

            public String getHospitalName() {
                return hospitalName;
            }

            public void setHospitalName(String hospitalName) {
                this.hospitalName = hospitalName;
            }
        }
    }
}
