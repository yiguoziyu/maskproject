package com.ljj.lettercircle.model;

import com.ljj.commonlib.base.BaseApplication;
import com.ljj.commonlib.kit.cache.ACache;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2018/11/30.
 */
public class EngagentFiltrateBean implements Serializable {

    private String city;
    private int sex;
    private String province;
    private int cityPostion;
    private int provincePostion;

    public static String cacheKey = EngagentFiltrateBean.class.getSimpleName();
    private static EngagentFiltrateBean ourInstance;

    public static EngagentFiltrateBean getInstance() {
        if (IsNull()) {
            ourInstance = new EngagentFiltrateBean().getFromCache();
            if (IsNull()) {
                ourInstance = new EngagentFiltrateBean();
            }
        }
        return ourInstance;
    }

    EngagentFiltrateBean getFromCache() {
        ourInstance = (EngagentFiltrateBean) ACache.get(BaseApplication.application).getAsObject(cacheKey);
        return ourInstance;
    }

    public static boolean IsNull() {
        return ourInstance == null;
    }

    public static void writeToCache(EngagentFiltrateBean obj) {
        ourInstance = obj;
        ACache.get(BaseApplication.application).put(cacheKey, obj);
    }

    public static void cleanCache() {
        ACache.get(BaseApplication.application).remove(cacheKey);
        ourInstance = null;
    }

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
