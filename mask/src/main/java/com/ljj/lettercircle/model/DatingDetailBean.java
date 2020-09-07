package com.ljj.lettercircle.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 一锅子鱼 on 2019/1/22.
 */
public class DatingDetailBean {

    /**
     * id : 2669
     * photo_list : []
     * enroll_number : 0
     * place : 苏州
     * target : 萌妹子
     * date : 随时
     * activity_type : 出去玩
     * cost_type : 我请客
     * wechat :
     * content :
     * status : 4
     * create_time : 1小时前
     * user_id : 21361
     * avatar : https://dating-1256663796.file.myqcloud.com/avatar/21361201901221828571397-800x804.jpg
     * age : 33
     * nick_name : 小白
     * location : 苏州
     * is_video_authentication : 0
     * sex : 1
     * is_pzp : 1
     * icon : https://dating-1256663796.file.myqcloud.com/dating/4.png
     * can_enrolls : 1
     * enrolls_str : 我要报名
     * detail : [[{"icon":"location","title":"旅行地点：  ","desc":"苏州"},{"icon":"target","title":"邀约对象：  ","desc":"萌妹子"},{"icon":"activity","title":"活动类型：  ","desc":"出去玩"}],[{"icon":"cost","title":"旅行花费：  ","desc":"我请客"},{"icon":"time","title":"旅行时间：  ","desc":"随时"}]]
     */

    private int id;
    private int enroll_number;
    private String place;
    private String target;
    private String date;
    private String activity_type;
    private String cost_type;
    private String wechat;
    private String content;
    private int status;
    private String create_time;
    private int user_id;
    private String avatar;
    private int age;
    private String nick_name;
    private String location;
    private int is_video_authentication;
    private int sex;
    private int is_pzp;
    private String icon;
    private int can_enrolls;
    private String enrolls_str;
    private List<PhotoListBean> photo_list;
    private List<List<DetailBean>> detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnroll_number() {
        return enroll_number;
    }

    public void setEnroll_number(int enroll_number) {
        this.enroll_number = enroll_number;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    public String getCost_type() {
        return cost_type;
    }

    public void setCost_type(String cost_type) {
        this.cost_type = cost_type;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreate_time() {
        return create_time;
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
        return avatar;
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
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getLocation() {
        return location;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getIs_pzp() {
        return is_pzp;
    }

    public void setIs_pzp(int is_pzp) {
        this.is_pzp = is_pzp;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getCan_enrolls() {
        return can_enrolls;
    }

    public void setCan_enrolls(int can_enrolls) {
        this.can_enrolls = can_enrolls;
    }

    public String getEnrolls_str() {
        return enrolls_str;
    }

    public void setEnrolls_str(String enrolls_str) {
        this.enrolls_str = enrolls_str;
    }

    public List<PhotoListBean> getPhoto_list() {
        if (photo_list == null) {
            return new ArrayList<>();
        }
        return photo_list;
    }

    public void setPhoto_list(List<PhotoListBean> photo_list) {
        this.photo_list = photo_list;
    }

    public List<List<DetailBean>> getDetail() {
        return detail;
    }

    public void setDetail(List<List<DetailBean>> detail) {
        this.detail = detail;
    }

    public static class DetailBean {
        /**
         * icon : location
         * title : 旅行地点：
         * desc : 苏州
         */

        private String icon;
        private String title;
        private String desc;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
