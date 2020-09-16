package com.ljj.lettercircle.model;



import com.ljj.lannotation.Persistence;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2018/11/30.
 */
@Persistence
public class EngagentFiltrateBean implements Serializable {

    private String city;
    private int sex;
    private String province;
    private int cityPostion;
    private int provincePostion;


    public String getCity() {
        return city == null ? "不限地区" : city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province == null ? "不限地区" : province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getCityPostion() {
        return cityPostion;
    }

    public void setCityPostion(int cityPostion) {
        this.cityPostion = cityPostion;
    }

    public int getProvincePostion() {
        return provincePostion;
    }

    public void setProvincePostion(int provincePostion) {
        this.provincePostion = provincePostion;
    }
}
