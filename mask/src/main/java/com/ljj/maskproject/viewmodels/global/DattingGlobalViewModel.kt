package com.ljj.maskproject.viewmodels.global

import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel


object DattingGlobalViewModel : GlobalViewModel() {

    const val KEY_DATTING_STATISTICS = "datingStatistics"

    //刷新接口
    fun getDatingStatisticsLiveData() = LiveDataBus.with<Boolean>(KEY_DATTING_STATISTICS)

}