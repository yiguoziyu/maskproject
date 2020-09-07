package com.ljj.lettercircle.model;


import com.ljj.commonlib.base.BaseApplication;
import com.ljj.commonlib.kit.cache.ACache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 一锅子鱼 on 2018/11/5.
 */
public class AccountBean implements Serializable {

    /**
     * user_id : 106042
     * nick_name : 裴佑冀_3064
     * is_pay_authentication_fee : 0
     * is_video_authentication : 0
     * video_authentication_url :
     * online_state : 1
     * photo_list : []
     * sex : 0
     * avatar : https://bdsm-1256663796.file.myqcloud.com/avatar/default.jpg
     * location :
     * age : 0
     * is_vip : 0
     * property :
     * interest_label : null
     * signature : 你不主动，我们之间怎么有故事
     * status : 2
     * vip_expire_time : 0
     * follow : 0
     * visitor : 0
     * follower : 0
     * is_fill : 0
     * is_mjh : 1
     * birthday : 0
     * data_integrity : 35
     * im_token : e+eLDXSVfwzC6S2infokYjP42r/pYQi0gPYSAYybdjJn1U54HEEmHNhbozVZHPmLQUvGRIRQvrlXa3UONiMHsA==
     * has_new_visit : 0
     * has_new_follower : 0
     * able_to_set_sex : 0
     * photo_num_limit : 25
     * background_img : https://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/background/background.png
     * vip_expire_time_str : 去开通
     */
    public static String cacheKey = AccountBean.class.getSimpleName();
    private static AccountBean ourInstance;

    /**
     * interest_label : [{"id":1,"name":"对旅行的要求","icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/153111049137507104.png","color":"E2B360","child":[]},{"id":2,"name":"关于我","icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/153111056556236106.png","color":"E2B360","child":[]},{"id":3,"name":"对性的看法","icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/15311106106783699.png","color":"E2B360","child":[]}]
     * profession : null
     * birthday : 638899200
     * action :
     * list : [{"id":"crown","title":"会员中心","icon":"dating_icon_mine_crown","action":"PzpViewController","des":"永久会员，终身有效"},{"id":"circle","title":"我的动态","icon":"dating_icon_mine_circle","action":"MyCirclesViewController","des":""},{"id":"feedback","title":"意见反馈","icon":"dating_icon_mine_feedback","action":"FeedbackViewController","des":""},{"id":"setting","title":"设置","icon":"dating_icon_mine_setting","action":"SettingViewController","des":""}]
     */


    public static AccountBean getInstance() {
        if (IsNull()) {
            ourInstance = new AccountBean().getFromCache();
            if (IsNull()) {
                ourInstance = new AccountBean();
            }
        }
        return ourInstance;
    }

    AccountBean getFromCache() {
        ourInstance = (AccountBean) ACache.get(BaseApplication.application).getAsObject(cacheKey);
        return ourInstance;
    }

    public static boolean IsNull() {
        return ourInstance == null;
    }

    public static void writeToCache(AccountBean obj) {
        ourInstance = obj;
        ACache.get(BaseApplication.application).put(cacheKey, obj);
    }

    public static void cleanCache() {
        ACache.get(BaseApplication.application).remove(cacheKey);
        ourInstance = null;
    }

    private int user_id;
    private String nick_name;
    private int verf_step;
    private int is_video_authentication;
    private String video_authentication_url;
    private int online_state;
    private int sex;
    private String avatar;
    private String location;
    private int age;
    private int is_pzp;
    private String property;
    private List<InterestLabelBean> interest_label;
    private String signature;
    private int status;
    private int vip_expire_time;
    private int follow;
    private int visitor;
    private int follower;
    private int is_fill;
    private int is_mjh;
    private long birthday;
    private int data_integrity;
    private String im_token;
    private int has_new_visit;
    private int has_new_follower;
    private int able_to_set_sex;
    private String photo_num_limit;
    private String background_img;
    private String pzp_time;
    private List<String> photo_list;
    private int vip_days;
    private String view_wechat_times;
    private String dating_publish_times;
    /**
     * photo_list : []
     * height : 0
     * interest_label : [{"id":1,"name":"对旅行的要求","icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/153111049137507104.png","color":"E2B360","child":[]},{"id":2,"name":"关于我","icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/153111056556236106.png","color":"E2B360","child":[]},{"id":3,"name":"对性的看法","icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/15311106106783699.png","color":"E2B360","child":[]}]
     * province : 江西省
     * annual_income : 30-50W
     * profession : null
     * birthday : 638899200
     * wechat :
     * is_complete : 0
     * action :
     * list : [{"id":"crown","title":"会员中心","icon":"dating_icon_mine_crown","action":"PzpViewController","des":"您尚未开通会员"},{"id":"circle","title":"我的动态","icon":"dating_icon_mine_circle","action":"MyCirclesViewController","des":""},{"id":"feedback","title":"意见反馈","icon":"dating_icon_mine_feedback","action":"FeedbackViewController","des":""},{"id":"setting","title":"设置","icon":"dating_icon_mine_setting","action":"SettingViewController","des":""}]
     */

    private int height;
    private String province;
    private String annual_income;
    private String profession;
    private String wechat;
    private int is_complete;
    private int is_show_distance;

    private int is_privacy_access;

    private int coupon_num;
    private Long balance;
    private int has_new_coupon;

    public int getHas_new_coupon() {
        return has_new_coupon;
    }

    public void setHas_new_coupon(int has_new_coupon) {
        this.has_new_coupon = has_new_coupon;
    }

    public int getIs_privacy_access() {
        return is_privacy_access;
    }

    public void setIs_privacy_access(int is_privacy_access) {
        this.is_privacy_access = is_privacy_access;
    }

    public int getIs_show_distance() {
        return is_show_distance;
    }

    public void setIs_show_distance(int is_show_distance) {
        this.is_show_distance = is_show_distance;
    }

    public int getVip_days() {
        return vip_days;
    }

    public void setVip_days(int vip_days) {
        this.vip_days = vip_days;
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
        return verf_step;
    }

    public void setIs_pay_authentication_fee(int is_pay_authentication_fee) {
        this.verf_step = is_pay_authentication_fee;
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

    public String getProfession() {
        return profession == null ? "" : profession;
    }

    public String getSignature() {
        return signature == null ? "" : signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getVip_expire_time() {
        return vip_expire_time;
    }

    public void setVip_expire_time(int vip_expire_time) {
        this.vip_expire_time = vip_expire_time;
    }

    public int getFollow() {
        return follow;
    }

    public void setFollow(int follow) {
        this.follow = follow;
    }

    public int getVisitor() {
        return visitor;
    }

    public void setVisitor(int visitor) {
        this.visitor = visitor;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getIs_fill() {
        return is_fill;
    }

    public void setIs_fill(int is_fill) {
        this.is_fill = is_fill;
    }

    public int getIs_mjh() {
        return is_mjh;
    }

    public void setIs_mjh(int is_mjh) {
        this.is_mjh = is_mjh;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public int getData_integrity() {
        return data_integrity;
    }

    public void setData_integrity(int data_integrity) {
        this.data_integrity = data_integrity;
    }

    public String getIm_token() {
        return im_token == null ? "" : im_token;
    }

    public void setIm_token(String im_token) {
        this.im_token = im_token;
    }

    public int getHas_new_visit() {
        return has_new_visit;
    }

    public void setHas_new_visit(int has_new_visit) {
        this.has_new_visit = has_new_visit;
    }

    public int getHas_new_follower() {
        return has_new_follower;
    }

    public void setHas_new_follower(int has_new_follower) {
        this.has_new_follower = has_new_follower;
    }

    public int getAble_to_set_sex() {
        return able_to_set_sex;
    }

    public void setAble_to_set_sex(int able_to_set_sex) {
        this.able_to_set_sex = able_to_set_sex;
    }

    public String getPhoto_num_limit() {
        return photo_num_limit == null ? "" : photo_num_limit;
    }

    public void setPhoto_num_limit(String photo_num_limit) {
        this.photo_num_limit = photo_num_limit;
    }

    public String getBackground_img() {
        return background_img == null ? "" : background_img;
    }

    public void setBackground_img(String background_img) {
        this.background_img = background_img;
    }

    public String getVip_expire_time_str() {
        return pzp_time == null ? "" : pzp_time;
    }

    public void setVip_expire_time_str(String vip_expire_time_str) {
        this.pzp_time = vip_expire_time_str;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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


    public String getWechat() {
        return wechat == null ? "" : wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public int getIs_complete() {
        return is_complete;
    }

    public void setIs_complete(int is_complete) {
        this.is_complete = is_complete;
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

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getView_wechat_times() {
        return view_wechat_times == null ? "" : view_wechat_times;
    }

    public void setView_wechat_times(String view_wechat_times) {
        this.view_wechat_times = view_wechat_times;
    }

    public String getDating_publish_times() {
        return dating_publish_times == null ? "" : dating_publish_times;
    }

    public void setDating_publish_times(String dating_publish_times) {
        this.dating_publish_times = dating_publish_times;
    }

    public int getCoupon_num() {
        return coupon_num;
    }

    public void setCoupon_num(int coupon_num) {
        this.coupon_num = coupon_num;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
