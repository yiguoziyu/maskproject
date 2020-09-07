package com.ljj.maskproject.viewmodels.global

import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel


object CommonGlobalViewModel : GlobalViewModel() {


    const val KEY_APP_REMARK = "app_remark"
    const val KEY_APP_PERSON_BALCK = "app_black"
    const val KEY_VIP = "app_vip"
    const val KEY_LOGOUT = "app_logout"
    const val KEY_MAIN_TIP_CITY = "main_tip_city"
    const val KEY_MAIN_TIP_LOCATION = "main_tip_location"
    const val KEY_PERSON_SHIELD = "app_shield"

    fun getRemarkLiveData() = LiveDataBus.with<String>(KEY_APP_REMARK)

    fun getPersonBlackLiveData() = LiveDataBus.with<String>(KEY_APP_REMARK)

    fun getVipLiveData() = LiveDataBus.with<Boolean>(KEY_VIP)

    fun getLogOutLiveData() = LiveDataBus.with<Boolean>(KEY_LOGOUT)

    fun getMainTipCityLiveData() = LiveDataBus.with<Boolean>(KEY_MAIN_TIP_CITY)

    fun getMainTipLocationLiveData() = LiveDataBus.with<Boolean>(KEY_MAIN_TIP_LOCATION)

    //屏蔽动态
    fun getDynamicShieldLiveData() = LiveDataBus.with<String>(KEY_PERSON_SHIELD)
}