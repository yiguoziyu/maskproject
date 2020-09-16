package com.ljj.maskproject.viewmodels.global

import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel

object ShareGlobalViewModel : GlobalViewModel() {
    private val KEY_WITHDRAW_BINDER_ACCOUNT = "withdraw_binder_account"

    fun getWithdrawAccountLiveData() = LiveDataBus.with<Any>(KEY_WITHDRAW_BINDER_ACCOUNT)
}