package com.ljj.lettercircle.model;

/**
 * Created by 一锅子鱼 on 2018/12/17.
 */
public class GalleryBean {
    private int postion;
    private String mUrl;

    public GalleryBean(int postion, String mUrl) {
        this.postion = postion;
        this.mUrl = mUrl;
    }

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    public String getmUrl() {
        return mUrl == null ? "" : mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
