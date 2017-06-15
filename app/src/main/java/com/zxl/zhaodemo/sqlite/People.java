package com.zxl.zhaodemo.sqlite;

import java.io.Serializable;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/8
 * @time: 15:20
 * @description:
 */



public class People implements Serializable{

    private  int id;
    private String name;
    private String country;
    private int age;
    private int sex;

    public People(int id ,String name,String country,int age,int sex){
        this.id=id;
        this.age=age;
        this.country=country;
        this.name=name;
        this.sex=sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
