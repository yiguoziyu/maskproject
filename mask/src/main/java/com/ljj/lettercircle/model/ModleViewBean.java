package com.ljj.lettercircle.model;


import com.ljj.lannotation.Persistence;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2018/11/30.
 */
@Persistence
public class ModleViewBean implements Serializable {

    private int modelType;


    public int getModelType() {
        return modelType;
    }

    public void setModelType(int modelType) {
        this.modelType = modelType;
    }
}
