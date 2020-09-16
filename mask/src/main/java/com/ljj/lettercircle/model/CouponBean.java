package com.ljj.lettercircle.model;

public class CouponBean {
    private String id;
    private String type;
    private String title;
    private String img_url;
    private int money;
    private String expire_time;
    private String status;
    private String type_str;
    private int preferential;
    private Boolean canotUse;

    public Boolean getCanotUse() {
        return canotUse == null ? false : canotUse;
    }

    public void setCanotUse(Boolean canotUse) {
        this.canotUse = canotUse;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPreferential() {
        return preferential;
    }

    public void setPreferential(int preferential) {
        this.preferential = preferential;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type == null ? "" : type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_url() {
        return img_url == null ? "" : img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }


    public String getExpire_time() {
        return expire_time == null ? "" : expire_time;
    }

    public void setExpire_time(String expire_time) {
        this.expire_time = expire_time;
    }

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType_str() {
        return type_str == null ? "" : type_str;
    }

    public void setType_str(String type_str) {
        this.type_str = type_str;
    }


}
