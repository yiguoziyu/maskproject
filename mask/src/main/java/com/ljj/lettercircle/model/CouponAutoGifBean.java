package com.ljj.lettercircle.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CouponAutoGifBean implements Parcelable {
    private int coupon_num;
    private String sum;
    private String title;
    private String tip;

    protected CouponAutoGifBean(Parcel in) {
        coupon_num = in.readInt();
        sum = in.readString();
        title = in.readString();
        tip = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(coupon_num);
        dest.writeString(sum);
        dest.writeString(title);
        dest.writeString(tip);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CouponAutoGifBean> CREATOR = new Creator<CouponAutoGifBean>() {
        @Override
        public CouponAutoGifBean createFromParcel(Parcel in) {
            return new CouponAutoGifBean(in);
        }

        @Override
        public CouponAutoGifBean[] newArray(int size) {
            return new CouponAutoGifBean[size];
        }
    };

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
