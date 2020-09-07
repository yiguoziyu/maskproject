package com.ljj.lettercircle.model;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2018/12/24.
 */
public class BannedStatusBean implements Serializable {

    /**
     * tip : 距离您重新使用消息聊天功能还有
     * type : 色情淫秽
     * second : 86393
     */

    private String tip;
    private String type;
    private long second;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSecond() {
        return second;
    }

    public void setSecond(long second) {
        this.second = second;
    }
}
