package com.ljj.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 一锅子鱼 on 2018/11/14.
 */
public class InterestLabelBean implements Serializable {
    private int id;
    private String icon_url;
    private String color;
    private String name;
    private int listorder;
    private List<String> child;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getListorder() {
        return listorder;
    }

    public void setListorder(int listorder) {
        this.listorder = listorder;
    }

    public List<String> getChild() {
        if (child == null) {
            return new ArrayList<>();
        }
        return child;
    }

    public void setChild(List<String> child) {
        this.child = child;
    }
}
