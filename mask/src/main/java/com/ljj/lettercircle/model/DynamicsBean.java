package com.ljj.lettercircle.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 一锅子鱼 on 2018/11/20.
 */
public class DynamicsBean implements Serializable {

    /**
     * id : 46339
     * photo_list : [{"url":"https://bdsm-1256663796.file.myqcloud.com/dynamic/97825201811210249217306-674x896.jpg","width":674,"height":896}]
     * create_time : 7分钟前
     * user_id : 97825
     * avatar : https://bdsm-1256663796.file.myqcloud.com/avatar/97825201810192217424253-800x805.jpg
     * age : 26
     * property : S
     * location : 西安市
     * is_vip : 1
     * nick_name : Autusm
     * content : 接上一条
     * photo_num : 1
     * is_praise : 0
     */

    private int id;
    private String create_time;
    private int user_id;
    private String avatar;
    private int age;
    private String property;
    private String location;
    private int is_vip;
    private String nick_name;
    private String content;
    private int photo_num;
    private int is_praise;
    private int type;
    private List<PhotoListBean> photo_list;

    private boolean content_state;//是否展开
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreate_time() {
        return create_time == null ? "" : create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAvatar() {
        return avatar == null ? "" : avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProperty() {
        return property == null ? "" : property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getLocation() {
        return location == null ? "" : location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIs_vip() {
        return is_vip;
    }

    public void setIs_vip(int is_vip) {
        this.is_vip = is_vip;
    }

    public String getNick_name() {
        return nick_name == null ? "" : nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPhoto_num() {
        return photo_num;
    }

    public void setPhoto_num(int photo_num) {
        this.photo_num = photo_num;
    }

    public int getIs_praise() {
        return is_praise;
    }

    public void setIs_praise(int is_praise) {
        this.is_praise = is_praise;
    }

    public List<PhotoListBean> getPhoto_list() {
        if (photo_list == null) {
            return new ArrayList<>();
        }
        return photo_list;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPhoto_list(List<PhotoListBean> photo_list) {
        this.photo_list = photo_list;
    }

    public boolean getContent_state() {
        return content_state;
    }

    public void setContent_state(boolean content_state) {
        this.content_state = content_state;
    }
}
