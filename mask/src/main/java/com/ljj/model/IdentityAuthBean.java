package com.ljj.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 一锅子鱼 on 2019/1/24.
 */
public class IdentityAuthBean {

    /**
     * data_integrity : 90
     * tip : ["1.认证后将赠送您一个月尊贵会员","2.认证后,首页展示将显示已认证"]
     * digital_code : 893048
     * background : https://dating-1256663796.file.myqcloud.com/resource/authentication.png
     */

    private int data_integrity;
    private String digital_code;
    private String background;
    private List<String> tip;

    public int getData_integrity() {
        return data_integrity;
    }

    public void setData_integrity(int data_integrity) {
        this.data_integrity = data_integrity;
    }

    public String getDigital_code() {
        return digital_code == null ? "" : digital_code;
    }

    public void setDigital_code(String digital_code) {
        this.digital_code = digital_code;
    }

    public String getBackground() {
        return background == null ? "" : background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<String> getTip() {
        if (tip == null) {
            return new ArrayList<>();
        }
        return tip;
    }

    public void setTip(List<String> tip) {
        this.tip = tip;
    }
}
