package com.zxl.zhaodemo.updataimage;

import java.io.Serializable;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/6
 * @time: 14:11
 * @description:
 */

public class Model implements Serializable{

    /**
     * code : 1
     * message : 成功
     * data : {"id":1,"drivername":"333","password":"123456","name":"12","sex":1,"bank":"213425321","image":"uploads/20170531/aa0c19bb3f29ab68bf5a48da4dff66fc.jpg","state":0,"addtime":"1324321","carnum":"冀B88888","phonenum":"12323456789","company":"百度","managerphone":"12","allmoney":"0.00","allorder":107,"goodrate":1,"good":112,"carstate":1,"comment":"6","api_key":"f2c6596eaa4fb0","last_login":"1496728402","d_reputation":80,"balance":"1312","longitude":114.199095,"latitude":38.129643}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * drivername : 333
         * password : 123456
         * name : 12
         * sex : 1
         * bank : 213425321
         * image : uploads/20170531/aa0c19bb3f29ab68bf5a48da4dff66fc.jpg
         * state : 0
         * addtime : 1324321
         * carnum : 冀B88888
         * phonenum : 12323456789
         * company : 百度
         * managerphone : 12
         * allmoney : 0.00
         * allorder : 107
         * goodrate : 1
         * good : 112
         * carstate : 1
         * comment : 6
         * api_key : f2c6596eaa4fb0
         * last_login : 1496728402
         * d_reputation : 80
         * balance : 1312
         * longitude : 114.199095
         * latitude : 38.129643
         */

        private int id;
        private String drivername;
        private String password;
        private String name;
        private int sex;
        private String bank;
        private String image;
        private int state;
        private String addtime;
        private String carnum;
        private String phonenum;
        private String company;
        private String managerphone;
        private String allmoney;
        private int allorder;
        private int goodrate;
        private int good;
        private int carstate;
        private String comment;
        private String api_key;
        private String last_login;
        private int d_reputation;
        private String balance;
        private double longitude;
        private double latitude;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDrivername() {
            return drivername;
        }

        public void setDrivername(String drivername) {
            this.drivername = drivername;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getCarnum() {
            return carnum;
        }

        public void setCarnum(String carnum) {
            this.carnum = carnum;
        }

        public String getPhonenum() {
            return phonenum;
        }

        public void setPhonenum(String phonenum) {
            this.phonenum = phonenum;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getManagerphone() {
            return managerphone;
        }

        public void setManagerphone(String managerphone) {
            this.managerphone = managerphone;
        }

        public String getAllmoney() {
            return allmoney;
        }

        public void setAllmoney(String allmoney) {
            this.allmoney = allmoney;
        }

        public int getAllorder() {
            return allorder;
        }

        public void setAllorder(int allorder) {
            this.allorder = allorder;
        }

        public int getGoodrate() {
            return goodrate;
        }

        public void setGoodrate(int goodrate) {
            this.goodrate = goodrate;
        }

        public int getGood() {
            return good;
        }

        public void setGood(int good) {
            this.good = good;
        }

        public int getCarstate() {
            return carstate;
        }

        public void setCarstate(int carstate) {
            this.carstate = carstate;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getApi_key() {
            return api_key;
        }

        public void setApi_key(String api_key) {
            this.api_key = api_key;
        }

        public String getLast_login() {
            return last_login;
        }

        public void setLast_login(String last_login) {
            this.last_login = last_login;
        }

        public int getD_reputation() {
            return d_reputation;
        }

        public void setD_reputation(int d_reputation) {
            this.d_reputation = d_reputation;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }
    }
}
