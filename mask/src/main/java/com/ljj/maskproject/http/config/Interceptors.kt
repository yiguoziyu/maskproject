package com.ljj.maskproject.http.config

import android.util.Log
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.ljj.commonlib.base.BaseApplication
import com.ljj.commonlib.net.network.NetUtil
import com.ljj.commonlib.util.CommonUtil
import com.ljj.lettercircle.model.GpsLocationBean
import com.ljj.lettercircle.model.LoginAccountBean



class HeaderInterceptor {
    companion object {
        private const val TAG = "HeaderInterceptor"
    }

    fun getLogInterceptor(): LoggingInterceptor {
        val loginInterceptorBuilder = LoggingInterceptor.Builder()
                .setLevel(Level.BASIC)
                .log(Log.VERBOSE)
//        SharedPreHelper.getToken(App.getApp()).isEmptyOrNull { loginInterceptorBuilder.addHeader("Token", it) }
        if (!LoginAccountBean.getInstance().token.isNullOrEmpty()) {
            loginInterceptorBuilder.addHeader("Token", LoginAccountBean.getInstance().token)
        }
        loginInterceptorBuilder.addHeader("Network-State", "${NetUtil.getNetWorkState(BaseApplication.application)}")
        loginInterceptorBuilder.addHeader("User-Agent", CommonUtil.getUserAgent(BaseApplication.application))
        loginInterceptorBuilder.addHeader("uuid", CommonUtil.getUniqueId(BaseApplication.application))
        if (GpsLocationBean.getInstance().longitude != null || GpsLocationBean.getInstance().latitude != null) {
            loginInterceptorBuilder.addHeader("Location", "${GpsLocationBean.getInstance().longitude}&${GpsLocationBean.getInstance().latitude}")
        }

        return loginInterceptorBuilder.build()
    }

}
