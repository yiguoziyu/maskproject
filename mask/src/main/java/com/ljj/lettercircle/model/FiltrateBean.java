package com.ljj.lettercircle.model;


import com.ljj.lannotation.Persistence;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2018/11/30.
 */
@Persistence
public class FiltrateBean implements Serializable {

    private String age;
    private String income;
    private String city;
    private int sort;
    private String sex;
    private String voice_sex;
    private String voice_type;


    public String getAge() {
        return age == null ? "全部" : age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getIncome() {
        return income == null ? "0" : income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getCity() {
        return city == null ? "全部" : city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex == null ? "全部" : sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getVoice_sex() {
        return voice_sex == null ? "全部" : voice_sex;
    }

    public void setVoice_sex(String voice_sex) {
        this.voice_sex = voice_sex;
    }

    public String getVoice_type() {
        return voice_type == null ? "全部" : voice_type;
    }

    public void setVoice_type(String voice_type) {
        this.voice_type = voice_type;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
