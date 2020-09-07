package com.ljj.lettercircle.model;

/**
 * Created by 一锅子鱼 on 2018/11/22.
 */
public class BannerBean {

    /**
     * banner_id : 6
     * img_url : http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/banner/153320749175136101.jpg
     * jump_model : 1
     * jump_value : http://bdsmapi.bdsmchat.top/tendencies/test
     */

    private int banner_id;
    private String img_url;
    private int jump_model;
    private String jump_value;

    public int getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(int banner_id) {
        this.banner_id = banner_id;
    }

    public String getImg_url() {
        return img_url == null ? "" : img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getJump_model() {
        return jump_model;
    }

    public void setJump_model(int jump_model) {
        this.jump_model = jump_model;
    }

    public String getJump_value() {
        return jump_value == null ? "" : jump_value;
    }

    public void setJump_value(String jump_value) {
        this.jump_value = jump_value;
    }
}
