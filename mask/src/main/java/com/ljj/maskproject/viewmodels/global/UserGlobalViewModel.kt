package com.ljj.maskproject.viewmodels.global


import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel

object UserGlobalViewModel : GlobalViewModel() {


    const val KEY_DYNAMIC_PAGE = "dynamic_page"
    const val KEY_USER_PAGE = "user_page"

    const val KEY_PERSON_DETAIL_PAGE = "person_detail_page"

    const val KEY_PERSON_DETAIL_WX = "person_detail_wx"

    const val KEY_ADD_BLACK_LIST = "add_black_list"



    //刷新动态页面接口
    fun getDynamicLiveData() = LiveDataBus.with<Boolean>(KEY_DYNAMIC_PAGE)

    //刷新我的页面接口
    fun getUserLiveData() = LiveDataBus.with<Boolean>(KEY_USER_PAGE)


    //请求用户详情页是否可访问接口
    fun getPersonDetailPageLiveData() = LiveDataBus.with<String>(KEY_PERSON_DETAIL_PAGE)


    //微信查看成功
    fun getPersonDetailWxLiveData() = LiveDataBus.with<Boolean>(KEY_PERSON_DETAIL_WX)

    //拉黑
    fun getAddBlackListLiveData()=LiveDataBus.with<String>(KEY_ADD_BLACK_LIST)
}
