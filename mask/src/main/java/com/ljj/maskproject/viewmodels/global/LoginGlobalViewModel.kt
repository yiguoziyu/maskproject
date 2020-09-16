package com.ljj.maskproject.viewmodels.global

import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.lettercircle.model.SmsVerAuthBean

object LoginGlobalViewModel {
    private const val LOGIN_SMS_AUTH = "login_sms_auth"
    fun getSmsAuthLiveData() = LiveDataBus.with<SmsVerAuthBean>(LOGIN_SMS_AUTH)
}