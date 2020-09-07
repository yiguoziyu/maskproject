package com.ljj.lettercircle.model;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by 一锅子鱼 on 2019/3/4.
 */
public class CustomizeSystemBean implements Parcelable {

    /**
     * content : 测试
     */

    private String content;

    public CustomizeSystemBean(String content) {
        this.content = content;
    }

    protected CustomizeSystemBean(Parcel in) {
        content = in.readString();
    }

    public static final Creator<CustomizeSystemBean> CREATOR = new Creator<CustomizeSystemBean>() {
        @Override
        public CustomizeSystemBean createFromParcel(Parcel in) {
            return new CustomizeSystemBean(in);
        }

        @Override
        public CustomizeSystemBean[] newArray(int size) {
            return new CustomizeSystemBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(content);
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
