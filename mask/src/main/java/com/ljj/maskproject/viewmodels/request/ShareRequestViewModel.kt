package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.http.manager.ApiRepository

/**
 * 分享模块
 */
class ShareRequestViewModel : BaseViewModel() {

    private val _withdrawInfo by lazy { MutableLiveData<Any>() }
    val withdrawInfo get() = _withdrawInfo


    private val _withdrawAccount by lazy { MutableLiveData<Any>() }
    val withdrawAccount get() = _withdrawAccount

    private val _shareInfo by lazy { MutableLiveData<Any>() }
    val shareInfo get() = _shareInfo

    private val _invite by lazy { MutableLiveData<Any>() }
    val invite get() = _invite

    private val _withdraw by lazy { MutableLiveData<Any>() }
    val withdraw get() = _withdraw


    private val _withdrawList by lazy { MutableLiveData<Any>() }
    val withdrawList get() = _withdrawList

    private val _inviteIncomeList by lazy { MutableLiveData<Any>() }
    val inviteIncomeList get() = _inviteIncomeList


    /***获取提现相关信息***/
    fun withdrawInfo() {
        launch({
            ApiRepository().withdrawInfo()
        }, liveData = _withdrawInfo)
    }

    /***修改提现账号***/
    fun withdrawAccount(account: String?, real_name: String?) {
        launch({
            ApiRepository().withdrawAccount(account, real_name)
        }, liveData = _withdrawAccount)
    }

    /***分享相关信息接口***/
    fun shareInfo() {
        launch({
            ApiRepository().shareInfo()
        }, liveData = _shareInfo)
    }

    /***邀请相关信息获取***/
    fun invite() {
        launch({
            ApiRepository().invite()
        }, liveData = _invite)
    }

    /***用户提现***/
    fun withdraw(amount: String) {
        launch({
            ApiRepository().withdraw(amount)
        }, liveData = _withdraw)
    }

    /****用户提现列表***/
    fun withdrawList(currentPage: Int) {
        launch({
            ApiRepository().withdrawList(currentPage)
        }, liveData = withdrawList)
    }

    /***邀请收入列表***/
    fun inviteIncomeList(currentPage: Int) {
        launch({
            ApiRepository().inviteIncomeList(currentPage)
        }, liveData = _inviteIncomeList)
    }



}