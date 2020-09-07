package com.ljj.model;

/**
 * Created by 一锅子鱼 on 2018/12/4.
 */
public class SimpleAccountBean {

    /**
     * user_id : 106042
     * nick_name : 撒死给
     * avatar : https://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/avatar/10604215439135455554447-634x634.jpg
     */

    private String user_id;
    private String nick_name;
    private String avatar;

    public String getUser_id() {
        return user_id == null ? "" : user_id;
    }

    public SimpleAccountBean() {
    }

    public SimpleAccountBean(String user_id, String nick_name, String avatar) {
        this.user_id = user_id;
        this.nick_name = nick_name;
        this.avatar = avatar;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNick_name() {
        return nick_name == null ? "" : nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getAvatar() {
        return avatar == null ? "" : avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
