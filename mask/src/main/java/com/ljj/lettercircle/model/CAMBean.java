package com.ljj.lettercircle.model;



import com.ljj.commonlib.base.BaseApplication;
import com.ljj.commonlib.kit.cache.ACache;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2018/11/29.
 */
public class CAMBean implements Serializable {
    public static String cacheKey = CAMBean.class.getSimpleName();
    private static CAMBean ourInstance;

    public static CAMBean getInstance() {
        if (IsNull()) {
            ourInstance = new CAMBean().getFromCache();
            if (IsNull()) {
                ourInstance = new CAMBean();
            }
        }
        return ourInstance;
    }

    CAMBean getFromCache() {
        ourInstance = (CAMBean) ACache.get(BaseApplication.application).getAsObject(cacheKey);
        return ourInstance;
    }

    public static boolean IsNull() {
        return ourInstance == null;
    }

    public static void writeToCache(CAMBean obj) {
        ourInstance = obj;
        ACache.get(BaseApplication.application).put(cacheKey, obj);
    }

    public static void cleanCache() {
        ACache.get(BaseApplication.application).remove(cacheKey);
        ourInstance = null;
    }

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
