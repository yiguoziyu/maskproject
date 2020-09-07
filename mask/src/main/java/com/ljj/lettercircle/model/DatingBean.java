package com.ljj.lettercircle.model;

/**
 * Created by 一锅子鱼 on 2019/1/21.
 */
public class DatingBean {

    /**
     * id : 2643
     * is_recommend : 0
     * create_time : 55分钟前
     * user_id : 20062
     * avatar : https://dating-1256663796.file.myqcloud.com/avatar/20062201901172241276415-800x802.jpg
     * place : 深圳
     * nick_name : 新柔_3659醉
     * target : 萌妹子
     * activity_type : 出去玩
     * location : 上海
     * sex : 1
     * is_video_authentication : 0
     * photo : []
     * icon :
     * is_pzp : 1
     */

    private int id;
    private int is_recommend;
    private String create_time;
    private int user_id;
    private String avatar;
    private String place;
    private String nick_name;
    private String target;
    private String activity_type;
    private String location;
    private int sex;
    private int is_video_authentication;
    private String icon;
    private int is_pzp;
    private PhotoListBean photo;
    private int recent_enrolls_number;
    private int enrolls_status;
    private int enroll_number;
    private String date;
    private String cost_type;
    private String wechat;
    private String content;
    private String status;

    public int getEnrolls_status() {
        return enrolls_status;
    }

    public void setEnrolls_status(int enrolls_status) {
        this.enrolls_status = enrolls_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIs_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(int is_recommend) {
        this.is_recommend = is_recommend;
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

    public String getPlace() {
        return place == null ? "" : place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNick_name() {
        return nick_name == null ? "" : nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getTarget() {
        return target == null ? "" : target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getActivity_type() {
        return activity_type == null ? "" : activity_type;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    public String getLocation() {
        return location == null ? "" : location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getIs_video_authentication() {
        return is_video_authentication;
    }

    public void setIs_video_authentication(int is_video_authentication) {
        this.is_video_authentication = is_video_authentication;
    }

    public String getIcon() {
        return icon == null ? "" : icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getIs_pzp() {
        return is_pzp;
    }

    public void setIs_pzp(int is_pzp) {
        this.is_pzp = is_pzp;
    }

    public PhotoListBean getPhoto() {
        return photo == null ? new PhotoListBean() : photo;
    }

    public void setPhoto(PhotoListBean photo) {
        this.photo = photo;
    }

    public int getRecent_enrolls_number() {
        return recent_enrolls_number;
    }

    public void setRecent_enrolls_number(int recent_enrolls_number) {
        this.recent_enrolls_number = recent_enrolls_number;
    }

    public int getEnroll_number() {
        return enroll_number;
    }

    public void setEnroll_number(int enroll_number) {
        this.enroll_number = enroll_number;
    }
}
