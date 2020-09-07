package com.ljj.maskproject.viewmodels.global

import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel


object AuthGlobalVideModel : GlobalViewModel() {
    private const val KEY_IMG = "Auth_img"
    private const val KEY_VIDEO = "Auth_video"
    private const val KEY_TYPE = "Auth_type"

    fun getAuthImageLiveData() = LiveDataBus.with<String>(KEY_IMG)
    fun getAuthVideoLiveData() = LiveDataBus.with<String>(KEY_VIDEO)
    fun getAuthTypeLiveData() = LiveDataBus.with<Int>(KEY_TYPE)
}