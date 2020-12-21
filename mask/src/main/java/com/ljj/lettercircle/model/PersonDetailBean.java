package com.ljj.lettercircle.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 一锅子鱼 on 2018/11/14.
 */
public class PersonDetailBean {
    /**
     * user_id : 74
     * nick_name : 不潮不酷不帅气
     * is_vip : 0
     * is_video_authentication : 0
     * video_authentication_url :
     * sex : 2
     * avatar : https://bdsm-1256663796.file.myqcloud.com/avatar/9.jpg
     * age : 23
     * photo_list : []
     * is_black : 0
     * location : 贵阳市
     * property : M
     * signature : 趁你现在还有时间
     * interest_label : [{"id":41,"icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/153111049137507104.png","color":"e9c07e","name":"我   是","listorder":1,"child":["肌肉控","已领养","傻白甜"]},{"id":44,"icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/153111056556236106.png","color":"b4884d","name":"我爱玩","listorder":2,"child":["吃鸡"]},{"id":48,"icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/15311106106783699.png","color":"655b4d","name":"我拒绝","listorder":3,"child":["约束","装高冷"]}]
     * is_follow : 0
     * dynamics_list : []
     */
    private int online_state;
    private int user_id;
    private String nick_name;
    private int is_pzp;
    private int is_video_authentication;
    private String video_authentication_url;
    private int sex;
    private String avatar;
    private int age;
    private int is_black;
    private String location;
    private String signature;
    private int is_follow;
    private List<String> photo_list;
    private List<InterestLabelBean> interest_label;
    private List<PhotoListBean> dynamics_list;
    /**
     * is_pzp : 0
     * photo_list : []
     * province :
     * annual_income : 30-50W
     * height : 180
     * profession : 教育/科研
     * interest_label : [{"id":1,"icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/153111049137507104.png","color":"E2B360","name":"对旅行的要求","is_show_to_mjh":1,"listorder":1,"child":["不抽烟","负责吃"]},{"id":2,"icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/153111056556236106.png","color":"E2B360","name":"关于我","is_show_to_mjh":1,"listorder":2,"child":["拖延症","逗比"]},{"id":3,"icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/15311106106783699.png","color":"E2B360","name":"对爱的看法","is_show_to_mjh":1,"listorder":3,"child":["跟着感觉走"]}]
     * dynamics_list : []
     */
    private String province;
    private String annual_income;
    private int height;
    private String profession;
    private int show_wechat;
    private String wechat;
    private String distance;
    private String unit;

    private int is_risk_warning;
    private String risk_warning_tip;
    private List<String> resident_city;
    private int can_impression;
    private List<ImpressionBean> impression_list;
    private String login_time;

    public String getLogin_time() {
        return login_time == null ? "" : login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public int getOnline_state() {
        return online_state;
    }

    public void setOnline_state(int online_state) {
        this.online_state = online_state;
    }

    public List<ImpressionBean> getImpression_list() {
        if (impression_list == null) {
            return new ArrayList<>();
        }
        return impression_list;
    }

    public void setImpression_list(List<ImpressionBean> impression_list) {
        this.impression_list = impression_list;
    }

    public int getIs_risk_warning() {
        return is_risk_warning;
    }

    public void setIs_risk_warning(int is_risk_warning) {
        this.is_risk_warning = is_risk_warning;
    }

    public String getRisk_warning_tip() {
        return risk_warning_tip == null ? "" : risk_warning_tip;
    }

    public void setRisk_warning_tip(String risk_warning_tip) {
        this.risk_warning_tip = risk_warning_tip;
    }

    public List<String> getResident_city() {
        if (resident_city == null) {
            return new ArrayList<>();
        }
        return resident_city;
    }

    public void setResident_city(List<String> resident_city) {
        this.resident_city = resident_city;
    }

    public int getCan_impression() {
        return can_impression;
    }

    public void setCan_impression(int can_impression) {
        this.can_impression = can_impression;
    }

    public String getDistance() {
        return distance == null ? "" : distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getUnit() {
        return unit == null ? "" : unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWechat() {
        return wechat == null ? "" : wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNick_name() {
        return nick_name == null ? "" : nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public int getIs_vip() {
        return is_pzp;
    }

    public void setIs_vip(int is_vip) {
        this.is_pzp = is_vip;
    }

    public int getIs_video_authentication() {
        return is_video_authentication;
    }

    public void setIs_video_authentication(int is_video_authentication) {
        this.is_video_authentication = is_video_authentication;
    }

    public String getVideo_authentication_url() {
        return video_authentication_url == null ? "" : video_authentication_url;
    }

    public void setVideo_authentication_url(String video_authentication_url) {
        this.video_authentication_url = video_authentication_url;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
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

    public int getIs_black() {
        return is_black;
    }

    public void setIs_black(int is_black) {
        this.is_black = is_black;
    }

    public String getLocation() {
        return location == null ? "" : location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSignature() {
        return signature == null ? "" : signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getIs_follow() {
        return is_follow;
    }

    public void setIs_follow(int is_follow) {
        this.is_follow = is_follow;
    }

    public String getProvince() {
        return province == null ? "" : province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAnnual_income() {
        return annual_income == null ? "" : annual_income;
    }

    public void setAnnual_income(String annual_income) {
        this.annual_income = annual_income;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getProfession() {
        return profession == null ? "" : profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<String> getPhoto_list() {
        if (photo_list == null) {
            return new ArrayList<>();
        }
        return photo_list;
    }

    public void setPhoto_list(List<String> photo_list) {
        this.photo_list = photo_list;
    }

    public List<InterestLabelBean> getInterest_label() {
        if (interest_label == null) {
            return new ArrayList<>();
        }
        return interest_label;
    }

    public void setInterest_label(List<InterestLabelBean> interest_label) {
        this.interest_label = interest_label;
    }

    public List<PhotoListBean> getDynamics_list() {
        if (dynamics_list == null) {
            return new ArrayList<>();
        }
        return dynamics_list;
    }

    public void setDynamics_list(List<PhotoListBean> dynamics_list) {
        this.dynamics_list = dynamics_list;
    }

    public int getShow_wechat() {
        return show_wechat;
    }

    public void setShow_wechat(int show_wechat) {
        this.show_wechat = show_wechat;
    }
}
