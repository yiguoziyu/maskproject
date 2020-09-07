package com.ljj.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 一锅子鱼 on 2019/6/20.
 */
public class BlackInfoBean {

    /**
     * user_id : 106042
     * avatar : https://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/avatar/10604215439135455554447-634x634.jpg
     * nick_name : 撒死给
     * reason : 测试
     * evidence : [{"url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/blackHouse/155539596242956105.jpeg","width":632,"height":1160}]
     * type : 1
     * create_time : 1分钟前
     */

    private int user_id;
    private String avatar;
    private String nick_name;
    private String reason;
    private int type;
    private String create_time;
    private List<PhotoListBean> evidence;
    private boolean content_state;

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

    public String getNick_name() {
        return nick_name == null ? "" : nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getReason() {
        return reason == null ? "" : reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreate_time() {
        return create_time == null ? "" : create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public List<PhotoListBean> getEvidence() {
        if (evidence == null) {
            return new ArrayList<>();
        }
        return evidence;
    }

    public void setEvidence(List<PhotoListBean> evidence) {
        this.evidence = evidence;
    }

    public boolean getContent_state() {
        return content_state;
    }

    public void setContent_state(boolean content_state) {
        this.content_state = content_state;
    }
}
