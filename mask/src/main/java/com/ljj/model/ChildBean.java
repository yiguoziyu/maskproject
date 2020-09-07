package com.ljj.model;

/**
 * Created by 一锅子鱼 on 2018/12/5.
 */
public class ChildBean {
    /**
     * id : 42
     * name : 萝莉
     * is_select : 0
     */

    private int id;
    private String name;
    private int is_select;

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

    public int getIs_select() {
        return is_select;
    }

    public void setIs_select(int is_select) {
        this.is_select = is_select;
    }
}
