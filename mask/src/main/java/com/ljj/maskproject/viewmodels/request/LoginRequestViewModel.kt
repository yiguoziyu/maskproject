package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.maskproject.http.manager.ApiRepository
import com.ljj.lettercircle.model.LoginAccountBean
import com.ljj.lettercircle.model.PersonBean
import com.ljj.lettercircle.model.PersonDetailBean

/**
 * 登录
 */
class LoginRequestViewModel : BaseViewModel() {

    private val _visitorHome by lazy { MutableLiveData<MutableList<PersonBean>>() }
    val visitorHome get() = _visitorHome
    private val _visitorHomePage by lazy { MutableLiveData<MutableList<PersonDetailBean>>() }
    val visitorHomePage get() = _visitorHomePage
    private val _visitorDynamics by lazy { MutableLiveData<Any>() }
    val visitorDynamics get() = _visitorDynamics
    private val _checkPhone by lazy { MutableLiveData<Any>() }
    val checkPhone get() = _checkPhone
    private val _sendSmsCode by lazy { MutableLiveData<Any>() }
    val sendSmsCode get() = _sendSmsCode
    private val _register by lazy { MutableLiveData<LoginAccountBean>() }
    val register get() = _register
    private val _loginByWx by lazy { MutableLiveData<LoginAccountBean>() }
    val loginByWx get() = _loginByWx
    private val _loginByFast by lazy { MutableLiveData<LoginAccountBean>() }
    val loginByFast get() = _loginByFast
    private val _loginBySmsCode by lazy { MutableLiveData<LoginAccountBean>() }
    val loginBySmsCode get() = _loginBySmsCode
    private val _updateUserProperty by lazy { MutableLiveData<Any>() }
    val updateUserProperty get() = _updateUserProperty
    private val _perfectUserInfo by lazy { MutableLiveData<LoginAccountBean>() }
    val perfectUserInfo get() = _perfectUserInfo
    private val _supplementaryUserInfo by lazy { MutableLiveData<Any>() }
    val supplementaryUserInfo get() = _supplementaryUserInfo


    fun visitorHome(
        sex: Int,
        currentPage: Int
    ) {
        launchWithStateView({
            ApiRepository().visitorHome(sex, currentPage)
        }, liveData = _visitorHome)
    }

    fun visitorHomePage(uId: String) {
        launchWithStateView({
            ApiRepository().visitorHomePage(uId)
        }, liveData = _visitorHomePage)
    }

    fun visitorDynamics(
        uId: String,
        currentPage: Int
    ) {
        launchWithStateView({
            ApiRepository().visitorDynamics(uId, currentPage)
        }, liveData = _visitorDynamics)
    }

    fun checkPhone(phone: String) {
        launchWithLoading({
            ApiRepository().checkPhone(phone)
        }, liveData = _checkPhone)
    }

    fun sendSmsCode(
        phone: String,
        action: String
    ) {
        launchWithLoading({
            ApiRepository().sendSmsCode(phone, action)
        }, liveData = _sendSmsCode)
    }

    fun register(
        phone: String,
        smsCode: String,
        platform: String,
        password: String
    ) {
        launchWithLoading({
            ApiRepository().register(phone, smsCode, platform, password)
        }, liveData = _register)
    }


    fun loginByWx(
        platform: String,
        unionid: String,
        openid: String,
        access_token: String
    ) {
        launchWithLoading({
            ApiRepository().loginByWx(platform, unionid, openid, access_token)
        }, liveData = _loginByWx)
    }

    fun loginByFast(accessToken: String?) {
        launchWithLoading({
            ApiRepository().loginByFast(accessToken)
        }, liveData = _loginByFast)
    }

    fun loginBySmsCode(
        phone: String,
        smsCode: String
    ) {
        launchWithLoading({
            ApiRepository().loginBySmsCode(phone, smsCode)
        }, liveData = _loginBySmsCode)
    }

    fun updateUserProperty(property: String) {
        launchWithLoading({
            ApiRepository().updateUserProperty(property)
        }, liveData = _updateUserProperty)
    }

    fun perfectUserInfo(
        birthday: String?,
        location: String?,
        province: String?,
        annual_income: String?,
        type: String?
    ) {
        launchWithLoading({
            ApiRepository().perfectUserInfo(birthday, location, province, annual_income, type)
        }, liveData = _perfectUserInfo)
    }

    fun supplementaryUserInfo(
        avatar: String,
        nick: String?,
        height: String?,
        wechat: String?
    ) {
        launchWithLoading({
            ApiRepository().supplementaryUserInfo(avatar, nick, height, wechat)
        }, liveData = _supplementaryUserInfo)
    }

}