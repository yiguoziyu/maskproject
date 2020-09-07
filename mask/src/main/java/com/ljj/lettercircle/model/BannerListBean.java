package com.ljj.lettercircle.model;

import java.util.ArrayList;
import java.util.List;

public class BannerListBean {
    private List<BannerBean> beanList;

    public BannerListBean(List<BannerBean> beanList) {
        this.beanList = beanList;
    }

    public List<BannerBean> getBeanList() {
        if (beanList == null) {
            return new ArrayList<>();
        }
        return beanList;
    }

    public void setBeanList(List<BannerBean> beanList) {
        this.beanList = beanList;
    }
}
