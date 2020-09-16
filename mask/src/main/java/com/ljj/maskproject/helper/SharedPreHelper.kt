package com.ljj.maskproject.helper

import android.content.Context
import com.ljj.commonlib.util.SharedPreUtils
import com.ljj.maskproject.config.SharedConfig

object SharedPreHelper {
    fun getToken(context: Context): String {
        return "${SharedPreUtils.get(context, SharedConfig.TOKEN, "")}"
    }

    fun saveToken(context: Context, token: String) {
        SharedPreUtils.put(context, SharedConfig.TOKEN, token)
    }


    fun saveThresholdImState(context: Context, state: Boolean) {
        SharedPreUtils.put(context, SharedConfig.SAVE_THRESHOLD_IMSTATE, state)
    }

    fun getThresholdImState(context: Context): Boolean {
        return SharedPreUtils.get(context, SharedConfig.SAVE_THRESHOLD_IMSTATE, false) as Boolean
    }

}