package com.ljj.maskproject.viewmodels.global

import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel


object IdentificationGlobalVideModel : GlobalViewModel() {
    private const val KEY_IMG = "identification_img"
    private const val KEY_VIDEO = "identification_video"
    private const val KEY_TYPE = "identification_type"

    fun getIdentificationImageLiveData() = LiveDataBus.with<String>(KEY_IMG)
    fun getIdentificationVideoLiveData() = LiveDataBus.with<String>(KEY_VIDEO)
    fun getIdentificationTypeLiveData() = LiveDataBus.with<Int>(KEY_TYPE)
}