package com.ljj.model;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2018/11/15.
 */
public class PhotoListBean implements Serializable{

    /**
     * url : https://bdsm-1256663796.file.myqcloud.com/dynamic/153796697624223100.jpeg
     * width : 800
     * height : 800
     */

    private String url;
    private int width;
    private int height;

    public String getUrl() {
        return url == null ? "" : url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
