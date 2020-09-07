package com.ljj.lettercircle.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 支付方式
 * Created by 一锅子鱼 on 2018/11/9.
 */
public class PayTypeBean {
    private List<PayListBean> pyed_list;
    private List<RechargeListBean> recg_list;

    public List<PayListBean> getPay_list() {
        if (pyed_list == null) {
            return new ArrayList<>();
        }
        return pyed_list;
    }

    public void setPay_list(List<PayListBean> pay_list) {
        this.pyed_list = pay_list;
    }

    public List<RechargeListBean> getRecharge_list() {
        if (recg_list == null) {
            return new ArrayList<>();
        }
        return recg_list;
    }

    public void setRecharge_list(List<RechargeListBean> recharge_list) {
        this.recg_list = recharge_list;
    }

    public static class PayListBean {
        /**
         * pay_type : 2
         * pay_name : 支付宝
         */

        private int pay_type;
        private String name;
        private String icon;
        public int getPay_type() {
            return pay_type;
        }

        public void setPay_type(int pay_type) {
            this.pay_type = pay_type;
        }

        public String getPay_name() {
            return name == null ? "" : name;
        }

        public void setPay_name(String pay_name) {
            this.name = pay_name;
        }

        public String getIcon() {
            return icon == null ? "" : icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class RechargeListBean {
        /**
         * recg_id : 17
         * recg_name : 一个月
         * value : 29.00
         * default_value : 68.00
         * effective_days : 30
         * recg_description : 会员期+30天
         * expected_expiration_time : 永久有效
         */

        private int recg_id;
        private String recg_name;
        private String value;
        private String default_value;
        private int effective_days;
        private String recg_description;
        private String expected_expiration_time;
        /**
         * product_id : 5
         * product_name : 认证费用
         * price : 16.80
         * cost_price : 20.00
         * effective_days : 0
         */

//        private int recg_id;
//        private String recg_name;
//        private String price;
//        private String cost_price;
//        private int effective_days;
//        private String product_description;
//        private String expected_expiration_time;




        public int getProduct_id() {
            return recg_id;
        }

        public void setProduct_id(int product_id) {
            this.recg_id = product_id;
        }

        public String getProduct_name() {
            return recg_name == null ? "" : recg_name;
        }

        public void setProduct_name(String product_name) {
            this.recg_name = product_name;
        }

        public String getPrice() {
            return value == null ? "" : value;
        }

        public void setPrice(String price) {
            this.value = price;
        }

        public String getCost_price() {
            return default_value == null ? "" : default_value;
        }

        public void setCost_price(String cost_price) {
            this.default_value = cost_price;
        }


        public String getProduct_description() {
            return recg_description == null ? "" : recg_description;
        }

        public void setProduct_description(String product_description) {
            this.recg_description = product_description;
        }

        public int getRecg_id() {
            return recg_id;
        }

        public void setRecg_id(int recg_id) {
            this.recg_id = recg_id;
        }

        public String getRecg_name() {
            return recg_name;
        }

        public void setRecg_name(String recg_name) {
            this.recg_name = recg_name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDefault_value() {
            return default_value;
        }

        public void setDefault_value(String default_value) {
            this.default_value = default_value;
        }

        public int getEffective_days() {
            return effective_days;
        }

        public void setEffective_days(int effective_days) {
            this.effective_days = effective_days;
        }

        public String getRecg_description() {
            return recg_description;
        }

        public void setRecg_description(String recg_description) {
            this.recg_description = recg_description;
        }

        public String getExpected_expiration_time() {
            return expected_expiration_time;
        }

        public void setExpected_expiration_time(String expected_expiration_time) {
            this.expected_expiration_time = expected_expiration_time;
        }
    }
}
