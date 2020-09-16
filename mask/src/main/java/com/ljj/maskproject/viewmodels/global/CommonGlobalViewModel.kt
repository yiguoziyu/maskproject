package com.ljj.maskproject.viewmodels.global

import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel


object CommonGlobalViewModel : GlobalViewModel() {

    const val KEY_APP_REMARK = "app_remark"
    const val KEY_VIP = "app_vip"
    const val KEY_THRESHOLD = "app_threshold"
    const val KEY_LOGOUT = "app_logout"
    const val KEY_MAIN_TIP_CITY = "main_tip_city"
    const val KEY_MAIN_TIP_LOCATION = "main_tip_location"
    const val KEY_PERSON_SHIELD = "app_shield"

    const val KEY_ADD_BLACK = "add_black"
    const val KEY_REMOVE_BLACK = "remove_black"

    const val KEY_PERSON_LIKE = "like"
    const val KEY_PERSON_LIKE_UN = "un_like"
    fun getRemarkLiveData() = LiveDataBus.with<String>(KEY_APP_REMARK)
    fun getVipLiveData() = LiveDataBus.with<Boolean>(KEY_VIP)
    fun getThresholdLiveData() = LiveDataBus.with<Boolean>(KEY_THRESHOLD)
    fun getLogOutLiveData() = LiveDataBus.with<Boolean>(KEY_LOGOUT)
    fun getMainTipCityLiveData() = LiveDataBus.with<Boolean>(KEY_MAIN_TIP_CITY)
    fun getMainTipLocationLiveData() = LiveDataBus.with<Boolean>(KEY_MAIN_TIP_LOCATION)
    //屏蔽动态
    fun getDynamicShieldLiveData() = LiveDataBus.with<String>(KEY_PERSON_SHIELD)
    fun getBlackAddLiveData() = LiveDataBus.with<String>(KEY_ADD_BLACK)
    fun getBlackRemoveLiveData() = LiveDataBus.with<String>(KEY_REMOVE_BLACK)
    fun getPersonLikeLiveData() = LiveDataBus.with<String>(KEY_PERSON_LIKE)
    fun getPersonLikeUnLiveData() = LiveDataBus.with<String>(KEY_PERSON_LIKE_UN)

}