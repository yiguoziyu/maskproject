package com.ljj.maskproject.viewmodels.global

import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel

object PayGlobalViewModel: GlobalViewModel() {
    const val KEY_PAY_SUC = "pay_suc"
    const val KEY_PAY_CANCEL= "pay_cancel"
    const val KEY_PAY_ERRO= "pay_error"
    fun getPaySucLiveData() = LiveDataBus.with<String>(KEY_PAY_SUC)
    fun getPayCancelLiveData() = LiveDataBus.with<String>(KEY_PAY_CANCEL)
    fun getPayErrorLiveData() = LiveDataBus.with<String>(KEY_PAY_ERRO)
}