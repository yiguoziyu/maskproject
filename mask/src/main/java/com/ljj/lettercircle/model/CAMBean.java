package com.ljj.lettercircle.model;

import com.ljj.lannotation.Persistence;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2018/11/29.
 */
@Persistence
public class CAMBean implements Serializable {

    /**
     * credentials : {"sessionToken":"037762f1f976fde0d3fecbc41957cbbe8af20bd530001","tmpSecretId":"AKIDc5xJhV9urt1x4Tc8NU1IwzwRPms86nqy","tmpSecretKey":"qxN0b07eztwN5syvD4RGx10wZFwaLHk7"}
     * expiredTime : 1543483123
     */

    private CredentialsBean credentials;
    private long expiredTime;
    private long beginTime;
    public CredentialsBean getCredentials() {
        return credentials;
    }

    public void setCredentials(CredentialsBean credentials) {
        this.credentials = credentials;
    }

    public long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public static class CredentialsBean implements Serializable {
        /**
         * sessionToken : 037762f1f976fde0d3fecbc41957cbbe8af20bd530001
         * tmpSecretId : AKIDc5xJhV9urt1x4Tc8NU1IwzwRPms86nqy
         * tmpSecretKey : qxN0b07eztwN5syvD4RGx10wZFwaLHk7
         */

        private String sessionToken;
        private String tmpSecretId;
        private String tmpSecretKey;

        public String getSessionToken() {
            return sessionToken;
        }

        public void setSessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
        }

        public String getTmpSecretId() {
            return tmpSecretId;
        }

        public void setTmpSecretId(String tmpSecretId) {
            this.tmpSecretId = tmpSecretId;
        }

        public String getTmpSecretKey() {
            return tmpSecretKey;
        }

        public void setTmpSecretKey(String tmpSecretKey) {
            this.tmpSecretKey = tmpSecretKey;
        }
    }
}
