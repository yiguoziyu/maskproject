package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.lettercircle.model.DynamicsBean
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.lettercircle.model.LoginAccountBean
import com.ljj.lettercircle.model.PersonBean
import com.ljj.lettercircle.model.PersonDetailBean
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.maskproject.http.manager.ApiRepository
import retrofit2.http.Query

class LoginRequestViewModel : BaseViewModel() {

    private val _visitorHome by lazy { MutableLiveData<MutableList<PersonBean>>() }
    val visitorHome get() = _visitorHome

    private val _visitorHomePage by lazy { MutableLiveData<PersonDetailBean>() }
    val visitorHomePage get() = _visitorHomePage

    private val _visitorDynamics by lazy { MutableLiveData<MutableList<DynamicsBean>>() }
    val visitorDynamics get() = _visitorDynamics
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

    private val _updateUserProperty by lazy { MutableLiveData<Any>() }
    val updateUserProperty get() = _updateUserProperty

    private val _supplementaryUserInfo by lazy { MutableLiveData<Any>() }
    val supplementaryUserInfo get() = _supplementaryUserInfo


    fun visitorHome(
        @Query("sex") sex: Int,
        @Query("page") currentPage: Int
    ) {
        launchWithStateView({
            ApiRepository().visitorHome(sex, currentPage)
        }, liveData = _visitorHome)
    }

    fun visitorHomePage(@Query("h_user_id") uId: String?) {
        launchWithStateView({
            ApiRepository().visitorHomePage(uId)
        }, liveData = _visitorHomePage)
    }

    fun visitorDynamics(
        @Query("h_user_id") uId: String,
        @Query("page") currentPage: Int
    ) {
        launchWithStateView({
            ApiRepository().visitorDynamics(uId, currentPage)
        },liveData = _visitorDynamics)
    }

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

    fun registerUserData(
        birthday: String? = null,
        location: String? = null,
        province: String? = null,
        annual_income: String? = null,
        type: String? = null
    ) {
        launchWithLoading({
            ApiRepository().perfectUserInfo(birthday, location, province, annual_income, type)
        }, {
            _registerUserDataLiveData.value = it
        })
    }


    fun updateUserProperty(property: String) {
        launchWithLoading({
            ApiRepository().updateUserProperty(property)
        }, liveData = _updateUserProperty)
    }

    fun supplementaryUserInfo(
        @Query("avatar") avatar: String,
        @Query("nick") nick: String?,
        @Query("height") height: String?,
        @Query("wechat") wechat: String?
    ) {
        launchWithLoading({
            ApiRepository().supplementaryUserInfo(avatar, nick, height, wechat)
        }, liveData = _supplementaryUserInfo)
    }
}