package com.ljj.maskproject.viewmodels.global

import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel
import com.ljj.lettercircle.model.ImpressionBean

object HomeGlobalViewModel : GlobalViewModel() {
    const val KEY_PERSON_DETAIL_IMPRESSION = "person_detail_impression"
    const val KEY_PERSON_DETAIL_IMPRESSION_SUC = "person_detail_impression_suc"
    const val KEY_PERSON_DETAIL_WX = "person_detail_wx"
    const val KEY_WXCHAT = "person_wechat"

    const val KEY_HOME_MODE_SMALL = "home_mode_small"
    const val KEY_HOME_MODE_BIG = "home_mode_big"

    const val KEY_HOME_TOP = "home_top"

    const val KEY_HOME_FILTER = "home_filter"

    //热门印象
    fun getPersonDetailImpressionLiveData() = LiveDataBus.with<ImpressionBean>(KEY_PERSON_DETAIL_IMPRESSION)

    //热门印象成功
    fun getPersonDetailImpressionSucLiveData() = LiveDataBus.with<Any>(KEY_PERSON_DETAIL_IMPRESSION_SUC)

    //微信查看成功
    fun getPersonDetailWxLiveData() = LiveDataBus.with<Boolean>(KEY_PERSON_DETAIL_WX)

    //微信
    fun getWeChatLiveData() = LiveDataBus.with<String>(KEY_WXCHAT)

    //小图模式
    fun getHomeModeSmallLiveData() = LiveDataBus.with<Boolean>(KEY_HOME_MODE_SMALL)

    //大图模式
    fun getHomeModeBigLiveData() = LiveDataBus.with<Boolean>(KEY_HOME_MODE_BIG)

    //返回顶部
    fun getHomeTopLiveData() = LiveDataBus.with<Any>(KEY_HOME_TOP)

    //筛选
    fun getHomeFilterLiveData() = LiveDataBus.with<Any>(KEY_HOME_FILTER)

}