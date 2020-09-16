package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.lettercircle.model.PayBean
import com.ljj.lettercircle.model.PayTypeBean
import com.ljj.maskproject.http.manager.ApiRepository


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

    fun getPayTypeNew(type: String) {
        launchWithStateView({
            ApiRepository().getPayTypeNew(type)
        }, liveData = _getPayType)
    }

    fun recharge(
            goodId: Int, pay_way: String
    ) {
        launchWithLoading({
            ApiRepository().recharge(goodId, pay_way)
        }, liveData = _recharge)
    }

    fun recgWithCoupon(recg_id: String, pyed_way: String, coupon_id: String?) {
        launchWithLoading({
            ApiRepository().recgWithCoupon(recg_id, pyed_way, coupon_id)
        }, liveData = _recharge)
    }

}