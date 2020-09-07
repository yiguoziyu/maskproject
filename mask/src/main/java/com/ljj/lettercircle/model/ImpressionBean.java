package com.ljj.lettercircle.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ImpressionBean implements Parcelable {

    private int id;
    private String title;
    private String color;
    private int times;
    private Boolean mSelect;

    public ImpressionBean(String title, String color, int times) {
        this.title = title;
        this.color = color;
        this.times = times;
    }

    public ImpressionBean(int id, String title, String color, int times, Boolean mSelect) {
        this.id = id;
        this.title = title;
        this.color = color;
        this.times = times;
        this.mSelect = mSelect;
    }

    protected ImpressionBean(Parcel in) {
        id = in.readInt();
        title = in.readString();
        color = in.readString();
        times = in.readInt();
        byte tmpMSelect = in.readByte();
        mSelect = tmpMSelect == 0 ? null : tmpMSelect == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(color);
        dest.writeInt(times);
        dest.writeByte((byte) (mSelect == null ? 0 : mSelect ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ImpressionBean> CREATOR = new Creator<ImpressionBean>() {
        @Override
        public ImpressionBean createFromParcel(Parcel in) {
            return new ImpressionBean(in);
        }

        @Override
        public ImpressionBean[] newArray(int size) {
            return new ImpressionBean[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color == null ? "" : color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getmSelect() {
        return mSelect == null ? false : mSelect;
    }

    public void setmSelect(Boolean mSelect) {
        this.mSelect = mSelect;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
