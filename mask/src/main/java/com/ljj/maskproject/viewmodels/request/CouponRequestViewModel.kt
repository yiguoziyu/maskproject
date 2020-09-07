package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.http.manager.ApiRepository

/**
 * 优惠卷
 */
class CouponRequestViewModel : BaseViewModel() {

    private val _getCouponList by lazy { MutableLiveData<Any>() }
    val getCouponList get() = _getCouponList

    private val _getCanUseCouponList by lazy { MutableLiveData<Any>() }
    val getCanUseCouponList get() = _getCanUseCouponList

    /***获取我所有的优惠券***/
    fun getCouponList(status: String) {
        launch({
            ApiRepository().getCouponList(status)
        }, liveData = _getCouponList)
    }

    /****获取商品可用优惠券****/
    fun getCanUseCouponList(product_id: String) {
        launch({
            ApiRepository().getCanUseCouponList(product_id)
        }, liveData = getCanUseCouponList)
    }
}