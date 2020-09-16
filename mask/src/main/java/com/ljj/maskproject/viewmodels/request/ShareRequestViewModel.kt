package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.lettercircle.model.InviteBean
import com.ljj.lettercircle.model.InviteRecordBean
import com.ljj.lettercircle.model.InviteWithdrawBean
import com.ljj.lettercircle.model.ShareBean
import com.ljj.maskproject.http.manager.ApiRepository
import com.ljj.maskproject.viewmodels.global.ShareGlobalViewModel


/**
 * 分享ViewModel
 */
class ShareRequestViewModel : BaseViewModel() {
    private val _withdrawInfo by lazy { MutableLiveData<InviteWithdrawBean>() }
    val withdrawInfo get() = _withdrawInfo
    private val _withdrawAccount by lazy { MutableLiveData<Any>() }
    val withdrawAccount get() = _withdrawAccount
    private val _invite by lazy { MutableLiveData<InviteBean>() }
    val invite get() = _invite
    private val _shareInfo by lazy { MutableLiveData<ShareBean>() }
    val shareInfo get() = _shareInfo
    private val _withdraw by lazy { MutableLiveData<Any>() }
    val withdraw get() = _withdraw
    private val _withdrawList by lazy { MutableLiveData<Any>() }
    val withdrawList get() = _withdrawList
    private val _inviteIncomeList by lazy { MutableLiveData<MutableList<InviteRecordBean>>() }
    val inviteIncomeList get() = _inviteIncomeList


    fun withdrawInfo() {
        launch({
            ApiRepository().withdrawInfo()
        }, {
            _withdrawInfo.value = it
        })
    }

    fun withdrawAccount(account: String?, real_name: String?) {
        launch({
            ApiRepository().withdrawAccount(account, real_name)
        }, {
            ShareGlobalViewModel.getWithdrawAccountLiveData().postValue("")
        })
    }

    fun invite() {
        launch({
            ApiRepository().invite()
        }, {
            _invite.value = it
        })
    }

    fun shareInfo() {
        launch({
            ApiRepository().shareInfo()
        }, {
            _shareInfo.value = it
        })
    }

    fun withdraw(amount: String) {
        launch({
            ApiRepository().withdraw(amount)
        }, {
            _withdraw.value = it
        })
    }

    fun withdrawList(currentPage: Int) {
        launchWithStateView({
            ApiRepository().withdrawList(currentPage)
        }, {
            _withdrawList.value = it
        })
    }

    fun inviteIncomeList(currentPage: Int) {
        launchWithStateView({
            ApiRepository().inviteIncomeList(currentPage)
        }, {
            _inviteIncomeList.value = it
        })
    }


}