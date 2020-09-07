package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.maskproject.http.manager.ApiRepository
import com.ljj.model.PayBean
import com.ljj.model.PayTypeBean


/**
 * 支付
 */
class PayRequesrViewModel : BaseViewModel() {
    private val _getPayType by lazy { MutableLiveData<PayTypeBean>() }
    val getPayType get() = _getPayType

    private val _recharge by lazy { MutableLiveData<PayBean>() }
    val recharge get() = _recharge

    fun getPayType(type: String) {
        launchWithStateView({
            ApiRepository().getPayType(type)
        }, liveData = _getPayType)
    }

    fun recharge(
        goodId: Int, pay_way: Int, platform: String
    ) {
        launchWithStateView({
            ApiRepository().recharge(goodId, pay_way, platform)
        },liveData = _recharge)
    }


}