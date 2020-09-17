package com.ljj.maskproject.base

import androidx.fragment.app.FragmentActivity
import com.ljj.commonlib.base.BaseApplication
import com.ljj.commonlib.model.BaseResponse

abstract class BaseXApplication: BaseApplication() {
    //非100值统一处理
    fun <T> handleSpecial(response: BaseResponse<T>, activity: FragmentActivity) {

    }
    fun loginOut(activity: FragmentActivity){

    }
}