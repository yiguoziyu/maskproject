package com.ljj.model;

/**
 * Created by 一锅子鱼 on 2019/1/23.
 */
public class DatingEnrollsBean {

    /**
     * id : 3047
     * status : 0
     * create_time : 28分钟前
     * user_id : 19643
     * avatar : https://dating-1256663796.file.myqcloud.com/avatar/default.png
     * age : 26
     * nick_name : 宫冰夜_5810
     * location : 北京
     * is_video_authentication : 0
     * is_pzp : 1
     */

    private int id;
    private int status;
    private String create_time;
    private int user_id;
    private String avatar;
    private int age;
    private String nick_name;
    private String location;
    private int is_video_authentication;
    private int is_pzp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getNick_name() {
        return nick_name == null ? "" : nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getLocation() {
        return location == null ? "" : location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIs_video_authentication() {
        return is_video_authentication;
    }

    public void setIs_video_authentication(int is_video_authentication) {
        this.is_video_authentication = is_video_authentication;
    }

    public int getIs_pzp() {
        return is_pzp;
    }

    public void setIs_pzp(int is_pzp) {
        this.is_pzp = is_pzp;
    }
}
