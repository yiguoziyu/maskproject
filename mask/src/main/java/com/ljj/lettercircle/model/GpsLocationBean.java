package com.ljj.lettercircle.model;


import com.ljj.commonlib.base.BaseApplication;
import com.ljj.commonlib.kit.cache.ACache;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2019/1/28.
 */
public class GpsLocationBean implements Serializable {



    public static String cacheKey = GpsLocationBean.class.getSimpleName();
    private static GpsLocationBean ourInstance;

    public static GpsLocationBean getInstance() {
        if (IsNull()) {
            ourInstance = new GpsLocationBean().getFromCache();
            if (IsNull()) {
                ourInstance = new GpsLocationBean();
            }
        }
        return ourInstance;
    }
    GpsLocationBean getFromCache() {
        ourInstance = (GpsLocationBean) ACache.get(BaseApplication.application).getAsObject(cacheKey);
        return ourInstance;
    }
    public static boolean IsNull() {
        return ourInstance == null;
    }

    public static void writeToCache(GpsLocationBean obj) {
        ourInstance = obj;
        ACache.get(BaseApplication.application).put(cacheKey, obj);
    }

    public static void cleanCache() {
        ACache.get(BaseApplication.application).remove(cacheKey);
        ourInstance = null;
    }


    private Double longitude;
    private Double latitude;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
