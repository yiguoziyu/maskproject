package com.ljj.model;

import com.ljj.commonlib.base.BaseApplication;

import com.ljj.commonlib.kit.cache.ACache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 一锅子鱼 on 2018/11/6.
 */
public class BaseConfig implements Serializable{

    /**
     * index_label : [{"name":"recommend","title":"推荐"},{"name":"circle","title":"圈子"},{"name":"new","title":"新人"}]
     * authentication_fee_1 : 1
     * authentication_content : 1、“字母圈”致力于打造100%真实健康交友平台，通过收取基本的认证费用，筛选掉大部分酒饭托、微商广告等虚假用户及保证交友安全。
     2、 进行严格的身份认证需要耗费大量的人力成本，收取基本的认证费用可以保证“字母圈”持续稳定运营。
     * authentication_detail : http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/config/153146976477521105.png
     * member_detail : http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/config/153146580339324111.jpg
     * authentication_title : 为什么要缴纳费用？
     * authentication_fee_2 : 1
     * member_h5_detail : http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/config/154079776589585102.jpg
     * service_wx : fb14
     * update_info : {"is_mandatory":0,"tips_number":"3","update_addr":"","new_version":"1.1.5","update_info":"有新版本，前往更新","need_update":1}
     */
    public static String cacheKey = BaseConfig.class.getSimpleName();
    private static BaseConfig ourInstance;
    /**
     * open_member_tip : 【看的更多】每天不限次数查看女士（非会员每天限制查看女性15名）
     【看的更省】每天可查看两人微信号
     【发布活动】每月可发布三次，永久会员最高五次
     * dating_guide_image : https://dating-1256663796.file.myqcloud.com/resource/dating_guide.png?1
     * dating_cost_type : ["AA","我请客","你买单"]
     * dating_target : ["高富帅","白富美","萌妹子","霸道总裁","文艺青年","大叔","小鲜肉",""]
     * dating_activity_type : ["看电影","约饭","出去玩","溜冰","游乐场","旅行"]
     * annual_income : ["10W以下","10-20W","20-30W","30-50W","50-100W","100W以上"]
     * profession : ["企业创始人","IT/互联网","学生","文化/艺术","影视/娱乐","金融","医药/健康","工业/制造业","媒体/公关","零售","教育/科研","其他"]
     * height : [150,180]
     */

    private String open_member_tip;
    private String dating_guide_image;
    private List<Object> dating_cost_type;
    private List<Object> dating_target;
    private List<Object> dating_activity_type;
    private List<Object> annual_income;
    private List<Object> profession;
    private List<Integer> height;

    public static BaseConfig getInstance() {
        if (IsNull()) {
            ourInstance = new BaseConfig().getFromCache();
            if (IsNull()) {
                ourInstance = new BaseConfig();
            }
        }
        return ourInstance;
    }
    BaseConfig getFromCache() {
        ourInstance = (BaseConfig) ACache.get(BaseApplication.application).getAsObject(cacheKey);
        return ourInstance;
    }
    public static boolean IsNull() {
        return ourInstance == null;
    }

    public static void writeToCache(BaseConfig obj) {
        ourInstance = obj;
        ACache.get(BaseApplication.application).put(cacheKey, obj);
    }

    public static void cleanCache() {
        ACache.get(BaseApplication.application).remove(cacheKey);
        ourInstance = null;
    }




    private String authentication_fee_1;
    private String authentication_content;
    private String authentication_detail;
    private String member_detail;
    private String authentication_title;
    private String authentication_fee_2;
    private String member_h5_detail;
    private String service_wx;
    private UpdateInfoBean update_info;
    private List<IndexLabelBean> index_label;
    private String index_show_tip;


    public String getAuthentication_fee_1() {
        return authentication_fee_1 == null ? "" : authentication_fee_1;
    }

    public void setAuthentication_fee_1(String authentication_fee_1) {
        this.authentication_fee_1 = authentication_fee_1;
    }

    public String getAuthentication_content() {
        return authentication_content == null ? "" : authentication_content;
    }

    public void setAuthentication_content(String authentication_content) {
        this.authentication_content = authentication_content;
    }

    public String getAuthentication_detail() {
        return authentication_detail == null ? "" : authentication_detail;
    }

    public void setAuthentication_detail(String authentication_detail) {
        this.authentication_detail = authentication_detail;
    }

    public String getMember_detail() {
        return member_detail == null ? "" : member_detail;
    }

    public void setMember_detail(String member_detail) {
        this.member_detail = member_detail;
    }

    public String getAuthentication_title() {
        return authentication_title == null ? "" : authentication_title;
    }

    public void setAuthentication_title(String authentication_title) {
        this.authentication_title = authentication_title;
    }

    public String getAuthentication_fee_2() {
        return authentication_fee_2 == null ? "" : authentication_fee_2;
    }

    public void setAuthentication_fee_2(String authentication_fee_2) {
        this.authentication_fee_2 = authentication_fee_2;
    }

    public String getMember_h5_detail() {
        return member_h5_detail == null ? "" : member_h5_detail;
    }

    public void setMember_h5_detail(String member_h5_detail) {
        this.member_h5_detail = member_h5_detail;
    }

    public String getService_wx() {
        return service_wx == null ? "" : service_wx;
    }

    public void setService_wx(String service_wx) {
        this.service_wx = service_wx;
    }

    public UpdateInfoBean getUpdate_info() {
        return update_info;
    }

    public void setUpdate_info(UpdateInfoBean update_info) {
        this.update_info = update_info;
    }

    public List<IndexLabelBean> getIndex_label() {
        if (index_label == null) {
            return new ArrayList<>();
        }
        return index_label;
    }

    public String getIndex_show_tip() {
        return index_show_tip == null ? "" : index_show_tip;
    }

    public String getOpen_member_tip() {
        return open_member_tip == null ? "" : open_member_tip;
    }

    public void setOpen_member_tip(String open_member_tip) {
        this.open_member_tip = open_member_tip;
    }

    public String getDating_guide_image() {
        return dating_guide_image == null ? "" : dating_guide_image;
    }

    public void setDating_guide_image(String dating_guide_image) {
        this.dating_guide_image = dating_guide_image;
    }

    public List<Object> getDating_cost_type() {
        if (dating_cost_type == null) {
            return new ArrayList<>();
        }
        return dating_cost_type;
    }

    public List<Object> getDating_target() {
        if (dating_target == null) {
            return new ArrayList<>();
        }
        return dating_target;
    }

    public List<Object> getDating_activity_type() {
        if (dating_activity_type == null) {
            return new ArrayList<>();
        }
        return dating_activity_type;
    }

    public void setDating_cost_type(List<Object> dating_cost_type) {
        this.dating_cost_type = dating_cost_type;
    }


    public void setDating_target(List<Object> dating_target) {
        this.dating_target = dating_target;
    }



    public void setDating_activity_type(List<Object> dating_activity_type) {
        this.dating_activity_type = dating_activity_type;
    }

    public List<Object> getAnnual_income() {
        if (annual_income == null) {
            return new ArrayList<>();
        }
        return annual_income;
    }

    public void setAnnual_income(List<Object> annual_income) {
        this.annual_income = annual_income;
    }

    public List<Object> getProfession() {
        if (profession == null) {
            return new ArrayList<>();
        }
        return profession;
    }

    public void setProfession(List<Object> profession) {
        this.profession = profession;
    }

    public List<Integer> getHeight() {
        if (height == null) {
            return new ArrayList<>();
        }
        return height;
    }

    public void setHeight(List<Integer> height) {
        this.height = height;
    }

    public void setIndex_label(List<IndexLabelBean> index_label) {
        this.index_label = index_label;
    }

    public void setIndex_show_tip(String index_show_tip) {
        this.index_show_tip = index_show_tip;
    }

    public static class UpdateInfoBean implements Serializable{
        /**
         * is_mandatory : 0
         * tips_number : 3
         * update_addr :
         * new_version : 1.1.5
         * update_info : 有新版本，前往更新
         * need_update : 1
         */

        private int is_mandatory;
        private String tips_number;
        private String update_addr;
        private String new_version;
        private String update_info;
        private int need_update;

        public int getIs_mandatory() {
            return is_mandatory;
        }

        public void setIs_mandatory(int is_mandatory) {
            this.is_mandatory = is_mandatory;
        }

        public String getTips_number() {
            return tips_number == null ? "" : tips_number;
        }

        public void setTips_number(String tips_number) {
            this.tips_number = tips_number;
        }

        public String getUpdate_addr() {
            return update_addr == null ? "" : update_addr;
        }

        public void setUpdate_addr(String update_addr) {
            this.update_addr = update_addr;
        }

        public String getNew_version() {
            return new_version == null ? "" : new_version;
        }

        public void setNew_version(String new_version) {
            this.new_version = new_version;
        }

        public String getUpdate_info() {
            return update_info == null ? "" : update_info;
        }

        public void setUpdate_info(String update_info) {
            this.update_info = update_info;
        }

        public int getNeed_update() {
            return need_update;
        }

        public void setNeed_update(int need_update) {
            this.need_update = need_update;
        }
    }

    public static class IndexLabelBean implements Serializable{
        /**
         * name : recommend
         * title : 推荐
         */

        private String name;
        private String title;

        public IndexLabelBean() {
        }

        public IndexLabelBean(String name, String title) {
            this.name = name;
            this.title = title;
        }

        public String getName() {
            return name == null ? "" : name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title == null ? "" : title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
