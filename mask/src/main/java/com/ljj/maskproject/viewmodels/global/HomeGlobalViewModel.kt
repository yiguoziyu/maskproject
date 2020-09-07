package com.ljj.maskproject.viewmodels.global


import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel

object HomeGlobalViewModel : GlobalViewModel() {

    private const val HOME_FILTER_HOME = "filter_home"
    fun getHomeFilterLiveData() = LiveDataBus.with<Boolean>(HOME_FILTER_HOME)
}