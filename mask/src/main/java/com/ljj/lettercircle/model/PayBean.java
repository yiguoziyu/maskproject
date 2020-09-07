package com.ljj.lettercircle.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 一锅子鱼 on 2018/11/9.
 */
public class PayBean {
    /**
     * order_id : 105709
     * pay_way : 1
     * order_sn : 2018110915493506042017120180
     * pay_data : {"appid":"wxb94a510b66345977","timestamp":"1541749776","noncestr":"valhbzghh2zm190uch1fw02w154akhvy","package":"Sign=WXPay","partnerid":"1494168522","prepayid":"wx091549362517231295b411582928248900","sign":"8518359E0CA557AC740D520717E964B1"}
     */

    private int order_id;
    private String pyed_way;
    private String order_sn;
    private PayDataBean pyed_data;
    private String pyed_url;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getPay_way() {
        return pyed_way == null ? "" : pyed_way;
    }

    public void setPay_way(String pay_way) {
        this.pyed_way = pay_way;
    }

    public String getOrder_sn() {
        return order_sn == null ? "" : order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public PayDataBean getPay_data() {
        return pyed_data;
    }

    public void setPay_data(PayDataBean pay_data) {
        this.pyed_data = pay_data;
    }

    public String getPay_url() {
        return pyed_url == null ? "" : pyed_url;
    }

    public void setPay_url(String pay_url) {
        this.pyed_url = pay_url;
    }

    public static class PayDataBean {
        /**
         * appid : wxb94a510b66345977
         * timestamp : 1541749776
         * noncestr : valhbzghh2zm190uch1fw02w154akhvy
         * package : Sign=WXPay
         * partnerid : 1494168522
         * prepayid : wx091549362517231295b411582928248900
         * sign : 8518359E0CA557AC740D520717E964B1
         */

        private String appid;
        private String timestamp;
        private String noncestr;
        @SerializedName("package")
        private String packageX;
        private String partnerid;
        private String prepayid;
        private String sign;
        private String extData;

        public String getExtData() {
            return extData == null ? "" : extData;
        }

        public void setExtData(String extData) {
            this.extData = extData;
        }

        public String getAppid() {
            return appid == null ? "" : appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getTimestamp() {
            return timestamp == null ? "" : timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getNoncestr() {
            return noncestr == null ? "" : noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getPackageX() {
            return packageX == null ? "" : packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getPartnerid() {
            return partnerid == null ? "" : partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid == null ? "" : prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getSign() {
            return sign == null ? "" : sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        @Override
        public String toString() {
            return "PayDataBean{" +
                    "appid='" + appid + '\'' +
                    ", timestamp='" + timestamp + '\'' +
                    ", noncestr='" + noncestr + '\'' +
                    ", packageX='" + packageX + '\'' +
                    ", partnerid='" + partnerid + '\'' +
                    ", prepayid='" + prepayid + '\'' +
                    ", sign='" + sign + '\'' +
                    '}';
        }
    }


}
