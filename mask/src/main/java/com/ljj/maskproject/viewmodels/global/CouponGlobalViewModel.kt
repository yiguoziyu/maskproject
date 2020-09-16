package com.ljj.maskproject.viewmodels.global

import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel
import com.ljj.lettercircle.model.CouponBean

object CouponGlobalViewModel : GlobalViewModel() {
    const val KEY_COUPON_RECHARGE = "coupon_recharge"
    fun getCouponRechargeLiveData() = LiveDataBus.with<CouponBean>(KEY_COUPON_RECHARGE)
}