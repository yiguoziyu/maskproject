package com.ljj.lettercircle.model;

/**
 * Created by 一锅子鱼 on 2018/11/6.
 */
public class PersonBean {
    /**
     * user_id : 74
     * nick_name : 不潮不酷不帅气
     * is_pay_authentication_fee : 1
     * is_video_authentication : 0
     * video_authentication_url :
     * online_state : 4
     * photo_list : []
     * sex : 2
     * avatar : https://bdsm-1256663796.file.myqcloud.com/avatar/9.jpg
     * location : 贵阳市
     * age : 23
     * is_vip : 1
     * property : M
     * signature : 趁你现在还有时间
     * weight : 2.5
     * is_follow : 0
     */

    private int user_id;
    private String nick_name;
    private int is_pay_authentication_fee;
    private int is_video_authentication;
    private String video_authentication_url;
    private int online_state;
    private String photo_list;
    private int sex;
    private String avatar;
    private String location;
    private int age;
    private int is_pzp;
    private String property;
    private String signature;
    private double weight;
    private int is_follow;
    private String create_time;
    /**
     * province :
     * annual_income : 100W以上
     * height : 160
     * profession : 学生
     * is_pzp : 0
     */

    private String province;
    private String annual_income;
    private String height;
    private String profession;
    private String distance;
    private String unit;

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

    public int getIs_pay_authentication_fee() {
        return is_pay_authentication_fee;
    }

    public void setIs_pay_authentication_fee(int is_pay_authentication_fee) {
        this.is_pay_authentication_fee = is_pay_authentication_fee;
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

    public int getOnline_state() {
        return online_state;
    }

    public void setOnline_state(int online_state) {
        this.online_state = online_state;
    }

    public String getPhoto_list() {
        return photo_list == null ? "" : photo_list;
    }

    public void setPhoto_list(String photo_list) {
        this.photo_list = photo_list;
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

    public String getLocation() {
        return location == null ? "" : location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIs_vip() {
        return is_pzp;
    }

    public void setIs_vip(int is_vip) {
        this.is_pzp = is_vip;
    }

    public String getProperty() {
        return property == null ? "" : property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getSignature() {
        return signature == null ? "" : signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getIs_follow() {
        return is_follow;
    }

    public void setIs_follow(int is_follow) {
        this.is_follow = is_follow;
    }

    public String getCreate_time() {
        return create_time == null ? "" : create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
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

    public String getHeight() {
        return height == null ? "" : height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getProfession() {
        return profession == null ? "" : profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

}
