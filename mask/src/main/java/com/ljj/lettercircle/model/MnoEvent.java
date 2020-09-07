package com.ljj.lettercircle.model;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2018/11/19.
 */
public class MnoEvent {
    private Serializable ather;
    private String name;
    private String content;
    private int state = -1;
    private boolean scroll = false;
    public static String PAYTYPE = "authentication";
    public static String PAY_CANCEL="pay_cancel";
    public static String VIP = "vip";
    public static String FILTRATE = "filtrate";
    public static String FILTRATE_VOICE = "filtrate_voice";
    public static String REFRESH = "refresh";
    public static String REFRESH_VOICE = "refresh_voice";
    public static String CLEAR_UNREAD = "clear_unread";
    public static String CARE = "care";
    public static String HOME_REF = "home_refresh";
    public static String DYNAMIC_REF = "dynamic_refresh";
    public static String DYNAMIC_REF_TYPE = "dynamic_refresh_type";
    public static String UPDATE = "update";
    public static String BANNED = "banned";
    public static String GALLERY = "gallery";
    public static String LICK = "like";
    public static String SCROLL = "scroll";
    public static String EDIT_REF="edit_refresh";
    public static String DATING_ENROLL="dating_enroll";
    public static String DATING_REMOVE="dating_remove";
    public static String DATING_PUBLISH="dating_publish";
    public static String DATING_REF="dating_refresh";
    public static String SHOW_HOME_TIP="show_home_tip";
    public static String MSG_DATING_NUMBER="message_dating_number";
    public static String SUGGEST="suggest";
    public static String MODE_TYPE="mode_type";
    public static String VIDEO_TYPE="video_type";
    public MnoEvent() {
    }

    public MnoEvent(String name) {
        this.name = name;
    }

    public MnoEvent(String name, int state) {
        this.name = name;
        this.state = state;
    }

    public MnoEvent(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public MnoEvent(String name, Serializable ather) {
        this.name = name;
        this.ather = ather;
    }

    public MnoEvent(String name, String content, int state) {
        this.name = name;
        this.content = content;
        this.state = state;
    }

    public MnoEvent(String name, boolean scroll) {
        this.name = name;
        this.scroll = scroll;
    }

    public boolean isScroll() {
        return scroll;
    }

    public void setScroll(boolean scroll) {
        this.scroll = scroll;
    }

    public Serializable getAther() {
        return ather;
    }

    public void setAther(Serializable ather) {
        this.ather = ather;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
