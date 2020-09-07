package com.ljj.maskproject.viewmodels.global


import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel

object ImGlobalViewModel : GlobalViewModel() {
    private const val KEY_IM_CONNECTION_SUC="im_connection_suc"
    private const val KEY_IM_UNREAD_CLEAR="im_unread_clear"
    //Im链接成功
    fun getImConnectionSucLiveData()=LiveDataBus.with<Boolean>(KEY_IM_CONNECTION_SUC)
    //未读消息清除红点
    fun getImUnReadSucLiveData()=LiveDataBus.with<Boolean>(KEY_IM_UNREAD_CLEAR)

}