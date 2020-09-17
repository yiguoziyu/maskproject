package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.lettercircle.model.CouponAutoGifBean
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.lettercircle.model.CouponBean
import com.ljj.maskproject.http.manager.ApiRepository

/**
 * 优惠卷
 */
class CouponRequestViewModel : BaseViewModel() {
    private val _getCouponList by lazy { MutableLiveData<MutableList<CouponBean>>() }
    val getCouponList get() = _getCouponList
    private val _autoGift by lazy { MutableLiveData<CouponAutoGifBean>() }
    val autoGift get() = _autoGift
    fun getCouponList(status: Int = -1) {
        launchWithStateView({
            ApiRepository().getCouponList("$status")
        }, {
            _getCouponList.value = it
        })
    }

    fun autoGift() {
        launchWithStateView({
            ApiRepository().autoGift()
        }, {
            _autoGift.value = it
        })
    }

}