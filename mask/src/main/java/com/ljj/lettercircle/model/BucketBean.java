package com.ljj.lettercircle.model;

import com.ljj.commonlib.base.BaseApplication;
import com.ljj.commonlib.kit.cache.ACache;

import java.io.Serializable;

public class BucketBean implements Serializable {

    public static String cacheKey = BucketBean.class.getSimpleName();
    private static BucketBean ourInstance;

    public static BucketBean getInstance() {
        if (IsNull()) {
            ourInstance = new BucketBean().getFromCache();
            if (IsNull()) {
                ourInstance = new BucketBean();
            }
        }
        return ourInstance;
    }

    BucketBean getFromCache() {
        ourInstance = (BucketBean) ACache.get(BaseApplication.application).getAsObject(cacheKey);
        return ourInstance;
    }

    public static boolean IsNull() {
        return ourInstance == null;
    }

    public static void writeToCache(BucketBean obj) {
        ourInstance = obj;
        ACache.get(BaseApplication.application).put(cacheKey, obj);
    }

    public static void cleanCache() {
        ACache.get(BaseApplication.application).remove(cacheKey);
        ourInstance = null;
    }

    /**
     * credentials : {"sessionToken":"a01056b1e547ba1b0ee93d98be3c1db55244651030001","tmpSecretId":"AKIDJa3OKKhjnYo75apL25q6XN3erWqGBVMG","tmpSecretKey":"j5jJKxKjkHtqpixds733JTc7MH7oMFKb"}
     * expiredTime : 1583224896
     */

    private CredentialsBean credentials;
    private long expiredTime;
    private long startTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

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


    public static class CredentialsBean implements Serializable {
        /**
         * sessionToken : a01056b1e547ba1b0ee93d98be3c1db55244651030001
         * tmpSecretId : AKIDJa3OKKhjnYo75apL25q6XN3erWqGBVMG
         * tmpSecretKey : j5jJKxKjkHtqpixds733JTc7MH7oMFKb
         */

        private String sessionToken;
        private String tmpSecretId;
        private String tmpSecretKey;

        public String getSessionToken() {
            return sessionToken == null ? "" : sessionToken;
        }

        public void setSessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
        }

        public String getTmpSecretId() {
            return tmpSecretId == null ? "" : tmpSecretId;
        }

        public void setTmpSecretId(String tmpSecretId) {
            this.tmpSecretId = tmpSecretId;
        }

        public String getTmpSecretKey() {
            return tmpSecretKey == null ? "" : tmpSecretKey;
        }

        public void setTmpSecretKey(String tmpSecretKey) {
            this.tmpSecretKey = tmpSecretKey;
        }
    }
}
