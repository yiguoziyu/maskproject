package com.ljj.lettercircle.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 一锅子鱼 on 2019/6/5.
 */
public class CustomizeIgnoreBean implements Parcelable {
    private String content;

    public CustomizeIgnoreBean() {
    }

    public CustomizeIgnoreBean(String content) {
        this.content = content;
    }

    protected CustomizeIgnoreBean(Parcel in) {
        content = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(content);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CustomizeIgnoreBean> CREATOR = new Creator<CustomizeIgnoreBean>() {
        @Override
        public CustomizeIgnoreBean createFromParcel(Parcel in) {
            return new CustomizeIgnoreBean(in);
        }

        @Override
        public CustomizeIgnoreBean[] newArray(int size) {
            return new CustomizeIgnoreBean[size];
        }
    };

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
