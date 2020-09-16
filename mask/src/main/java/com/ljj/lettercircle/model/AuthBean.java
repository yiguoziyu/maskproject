package com.ljj.lettercircle.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 一锅子鱼 on 2019/4/30.
 */
public class AuthBean {

    /**
     * user_id : 98254
     * avatar_check_status : 0
     * avatar : https://dating-1256663796.file.myqcloud.com/avatar/default_girl.png
     * is_default_avatar : 1
     * auth_state : 9
     * auth_url : http://dating-1256663796.cos.ap-shanghai.myqcloud.com/auth/015564351235166340-1080x1920.jpg
     * tip : ["1.仅女性用户可进行认证，认证通过后即可免认证费用，并赠送终身会员","2.认证信息仅作为身份审核,不对外展示，将在24小时内完成审核"]
     * digital_code : 948018
     * background : https://dating-1256663796.file.myqcloud.com/resource/authentication.png
     */

    private int user_id;
    private int avatar_check_status;
    private String avatar;
    private int is_default_avatar;
    private int auth_state;
    private String auth_url;
    private int digital_code;
    private String background;
    private List<String> tip;

    private static class Helper {
        public static final AuthBean bean = new AuthBean();
    }

    public static AuthBean getInstance() {
        return Helper.bean;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAvatar_check_status() {
        return avatar_check_status;
    }

    public void setAvatar_check_status(int avatar_check_status) {
        this.avatar_check_status = avatar_check_status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getIs_default_avatar() {
        return is_default_avatar;
    }

    public void setIs_default_avatar(int is_default_avatar) {
        this.is_default_avatar = is_default_avatar;
    }

    public int getAuth_state() {
        return auth_state;
    }

    public void setAuth_state(int auth_state) {
        this.auth_state = auth_state;
    }

    public String getAuth_url() {
        return auth_url;
    }

    public void setAuth_url(String auth_url) {
        this.auth_url = auth_url;
    }

    public int getDigital_code() {
        return digital_code;
    }

    public void setDigital_code(int digital_code) {
        this.digital_code = digital_code;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<String> getTip() {
        return tip;
    }

    public void setTip(List<String> tip) {
        this.tip = tip;
    }
}
