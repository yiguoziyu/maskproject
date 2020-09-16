package com.ljj.lettercircle.model;



import com.ljj.lannotation.Persistence;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2019/1/28.
 */
@Persistence
public class GpsLocationBean implements Serializable {

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
