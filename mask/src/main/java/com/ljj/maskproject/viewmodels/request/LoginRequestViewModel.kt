package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.lettercircle.model.LoginAccountBean
import com.ljj.maskproject.http.manager.ApiRepository

class LoginRequestViewModel : BaseViewModel() {
    //手机登录
    //微信登录
    private val _loginLiveData = MutableLiveData<LoginAccountBean>()
    val loginLiveData get() = _loginLiveData

    private val _wxloginLiveData = MutableLiveData<LoginAccountBean>()
    val wxloginLiveData get() = _wxloginLiveData
    //一键登录
    private val _loginByFastLiveData = MutableLiveData<LoginAccountBean>()
    val loginByFastLiveData get() = _loginByFastLiveData


    private val _sendSmsCodeLiveData = MutableLiveData<Boolean>()
    val sendSmsCodeLiveData get() = _sendSmsCodeLiveData
    val sendSmsCodeState = MutableLiveData<Boolean>()


    private val _checkPhoneLiveData = MutableLiveData<Boolean>()
    val checkPhoneLiveData get() = _checkPhoneLiveData



    private val _registerLiveData = MutableLiveData<LoginAccountBean>()
    val registerLiveData get() = _registerLiveData
    private val _registerSexLiveData = MutableLiveData<Any>()
    val registerSexLiveData get() = _registerSexLiveData
    private val _registerUserDataLiveData = MutableLiveData<LoginAccountBean>()
    val registerUserDataLiveData get() = _registerUserDataLiveData

    fun checkPhone(phone: String) {
        launchWithLoading({
            ApiRepository().checkPhone(phone)
        }, {
            _checkPhoneLiveData.value = true
        }, onError = {
            sendSmsCodeState.value = false
        })
    }

    fun sendSmsCode(phone: String, action: String, ticket: String?, randStr: String?) {
        launchWithLoading({
            ApiRepository().sendSmsCode(phone, action, ticket, randStr)
        }, {
            _sendSmsCodeLiveData.value = true
        }, onError = {
            sendSmsCodeState.value = false
        }, onSpecial = {
        })
    }

    fun loginByFast(accessToken: String?) {
        launchWithLoading({
            ApiRepository().loginByFast(accessToken)
        }, {
            _loginByFastLiveData.value = it
        })
    }


    fun loginByWx(unionid: String, openid: String, access_token: String) {
        launchWithLoading({
            ApiRepository().loginByWx(unionid, openid, access_token)
        }, {
            _wxloginLiveData.value = it
        })
    }

    fun loginBySmsCode(phone: String, smsCode: String) {
        launchWithLoading({
            ApiRepository().loginBySmsCode(phone, smsCode)
        }, {
            _loginLiveData.value = it
        })
    }


    fun register(phoneNumber: String, sms_code: String) {
        launchWithLoading({
            ApiRepository().register(phoneNumber, sms_code)
        }, {
            _registerLiveData.value = it
        })
    }

    fun registerSex(mSex: Int) {
        launchWithLoading({
            ApiRepository().updateUserSex("$mSex")
        }, {
            _registerSexLiveData.value = it
        })
    }

    fun registerUserData(birthday: String? = null, location: String? = null, province: String? = null, annual_income: String? = null, type: String? = null) {
        launchWithLoading({
            ApiRepository().perfectUserInfo(birthday, location, province, annual_income, type)
        }, {
            _registerUserDataLiveData.value = it
        })
    }
}