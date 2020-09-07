package com.ljj.model;

/**
 * Created by 一锅子鱼 on 2019/5/6.
 */
public class ThresholdBean {
    private boolean firstLogout;

    public boolean isFirstLogout() {
        return firstLogout;
    }

    public void setFirstLogout(boolean firstLogout) {
        this.firstLogout = firstLogout;
    }

    public static ThresholdBean getInstance() {
        return Helper.helper;
    }

    private static final class Helper {
        private final static ThresholdBean helper = new ThresholdBean();
    }
}
