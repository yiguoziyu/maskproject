package com.ljj.model;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2019/1/4.
 */
public class VoiceBean implements Serializable {

    /**
     * voice_id : 2
     * voice_url : http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/voice/12821915468319238753494.amr
     * create_time : 2小时前
     * voice_time : 7
     * user_id : 128219
     * avatar : https://bdsm-1256663796.file.myqcloud.com/avatar/default.jpg
     * age : 29
     * property : M
     * location : 北京市
     * is_vip : 0
     * nick_name : 白夕若_9200
     * content :
     */

    private int voice_id;
    private String voice_url;
    private String create_time;
    private int voice_time;
    private int user_id;
    private String avatar;
    private int age;
    private String property;
    private String location;
    private int is_vip;
    private String nick_name;
    private String content;
    private boolean content_state;//是否展开
    public int getVoice_id() {
        return voice_id;
    }

    public void setVoice_id(int voice_id) {
        this.voice_id = voice_id;
    }

    public String getVoice_url() {
        return voice_url == null ? "" : voice_url;
    }

    public void setVoice_url(String voice_url) {
        this.voice_url = voice_url;
    }

    public String getCreate_time() {
        return create_time == null ? "" : create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getVoice_time() {
        return voice_time;
    }

    public void setVoice_time(int voice_time) {
        this.voice_time = voice_time;
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

    public boolean getContent_state() {
        return content_state;
    }

    public void setContent_state(boolean content_state) {
        this.content_state = content_state;
    }



}
