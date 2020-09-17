package com.ljj.lettercircle.model;

public class CouponAutoGifBean {
    private int coupon_num;
    private String sum;
    private String title;
    private String tip;

    public int getCoupon_num() {
        return coupon_num;
    }

    public void setCoupon_num(int coupon_num) {
        this.coupon_num = coupon_num;
    }

    public String getSum() {
        return sum == null ? "" : sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTip() {
        return tip == null ? "" : tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
