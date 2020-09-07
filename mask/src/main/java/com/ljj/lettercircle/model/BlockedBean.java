package com.ljj.lettercircle.model;

/**
 * Created by 一锅子鱼 on 2019/3/6.
 */
public class BlockedBean {

    /**
     * msg : 您因：因违规被多人举报，进行封号处理，现已被封号
     * can_representation : 1
     * token : bd085749196293a97cab94015c6a966e
     */

    private String msg;
    private int can_representation;
    private String token;
    private String im_token;
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCan_representation() {
        return can_representation;
    }

    public void setCan_representation(int can_representation) {
        this.can_representation = can_representation;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIm_token() {
        return im_token == null ? "" : im_token;
    }

    public void setIm_token(String im_token) {
        this.im_token = im_token;
    }
}
