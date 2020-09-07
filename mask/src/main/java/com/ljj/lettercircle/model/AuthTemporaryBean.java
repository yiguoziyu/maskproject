package com.ljj.lettercircle.model;

/**
 * Created by 一锅子鱼 on 2019/5/5.
 */
public class AuthTemporaryBean {

    private String authUrl;
    private String avarUrl;

    public String getAuthUrl() {
        return authUrl == null ? "" : authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public String getAvarUrl() {
        return avarUrl == null ? "" : avarUrl;
    }

    public void setAvarUrl(String avarUrl) {
        this.avarUrl = avarUrl;
    }


    public static AuthTemporaryBean getInstance() {
        return Helper.helper;
    }

    private static final class Helper {
        private final static AuthTemporaryBean helper = new AuthTemporaryBean();
    }
}
