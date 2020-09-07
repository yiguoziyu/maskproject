package com.ljj.lettercircle.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 一锅子鱼 on 2018/11/19.
 */
public class LabelBean {

    /**
     * id : 41
     * name : 我   是
     * icon_url : https://bdsm-1256663796.file.myqcloud.com/icon/153111049137507104.png
     * color : e9c07e
     * child : [{"id":42,"name":"萝莉","is_select":0},{"id":81,"name":"FtoM","is_select":0},{"id":80,"name":"MtoF","is_select":0},{"id":79,"name":"CD","is_select":0},{"id":77,"name":"抖M","is_select":0},{"id":76,"name":"抖S","is_select":0},{"id":75,"name":"傻白甜","is_select":0},{"id":74,"name":"夜猫子","is_select":0},{"id":73,"name":"霸道总裁","is_select":0},{"id":72,"name":"已领养","is_select":0},{"id":71,"name":"话痨","is_select":0},{"id":70,"name":"老司机","is_select":0},{"id":69,"name":"女汉子","is_select":0},{"id":68,"name":"肌肉控","is_select":0},{"id":43,"name":"大叔","is_select":0},{"id":84,"name":"TS","is_select":0}]
     */

    private int id;
    private String name;
    private String icon_url;
    private String color;
    private List<ChildBean> child;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon_url() {
        return icon_url == null ? "" : icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getColor() {
        return color == null ? "" : color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<ChildBean> getChild() {
        if (child == null) {
            return new ArrayList<>();
        }
        return child;
    }

    public void setChild(List<ChildBean> child) {
        this.child = child;
    }

}
