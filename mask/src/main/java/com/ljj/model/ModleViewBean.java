package com.ljj.model;

import com.ljj.commonlib.base.BaseApplication;
import com.ljj.commonlib.kit.cache.ACache;

import java.io.Serializable;

/**
 * Created by 一锅子鱼 on 2018/11/30.
 */
public class ModleViewBean implements Serializable {

    private int modelType;

    public static String cacheKey = ModleViewBean.class.getSimpleName();
    private static ModleViewBean ourInstance;

    public static ModleViewBean getInstance() {
        if (IsNull()) {
            ourInstance = new ModleViewBean().getFromCache();
            if (IsNull()) {
                ourInstance = new ModleViewBean();
            }
        }
        return ourInstance;
    }

    ModleViewBean getFromCache() {
        ourInstance = (ModleViewBean) ACache.get(BaseApplication.application).getAsObject(cacheKey);
        return ourInstance;
    }

    public static boolean IsNull() {
        return ourInstance == null;
    }

    public static void writeToCache(ModleViewBean obj) {
        ourInstance = obj;
        ACache.get(BaseApplication.application).put(cacheKey, obj);
    }

    public static void cleanCache() {
        ACache.get(BaseApplication.application).remove(cacheKey);
        ourInstance = null;
    }

    public int getModelType() {
        return modelType;
    }

    public void setModelType(int modelType) {
        this.modelType = modelType;
    }
}
