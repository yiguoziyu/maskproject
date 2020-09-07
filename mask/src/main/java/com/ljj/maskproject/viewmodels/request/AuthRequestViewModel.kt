package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.maskproject.http.manager.ApiRepository
import com.ljj.lettercircle.model.AuthBean
import com.ljj.lettercircle.model.AuthStateBean
import com.ljj.lettercircle.model.BucketBean
import com.ljj.lettercircle.model.IdentityAuthBean

class AuthRequestViewModel : BaseViewModel() {



    private val _getBucketConfig by lazy { MutableLiveData<BucketBean>() }
    val getBucketConfig get() = _getBucketConfig

    private val _authenticationInfoG2 by lazy { MutableLiveData<AuthBean>() }
    val authenticationInfoG2 get() = _authenticationInfoG2

    private val _videoAuthenticationG2 by lazy { MutableLiveData<Any>() }
    val videoAuthenticationG2 get() = _videoAuthenticationG2


    private val _videoAuthentication by lazy { MutableLiveData<Any>() }
    val videoAuthentication get() = _videoAuthentication

    private val _authenticationAuditStatus by lazy { MutableLiveData<AuthStateBean>() }
    val authenticationAuditStatus get() = _authenticationAuditStatus


    private val _videoAuthenticationNew by lazy { MutableLiveData<Any>() }
    val videoAuthenticationNew get() = _videoAuthenticationNew

    private val _authenticationInfo by lazy { MutableLiveData<IdentityAuthBean>() }
    val authenticationInfo get() = _authenticationInfo
    fun getBucketConfig() {

    }

    fun authenticationInfoG2() {
        launchWithLoading({
            ApiRepository().authenticationInfoG2()
        }, liveData = _authenticationInfoG2)
    }


    fun videoAuthenticationG2(
        auth_vod_url: String?,
        avatar: String?,
        auth_img_url: String?
    ) {
        launchWithLoading({
            ApiRepository().videoAuthenticationG2(auth_vod_url, avatar, auth_img_url)
        }, liveData = _videoAuthenticationG2)
    }


    fun videoAuthentication(authVodUrl: String) {
        launchWithLoading({
            ApiRepository().videoAuthentication(authVodUrl)
        },liveData = _videoAuthentication)
    }

    fun authenticationAuditStatus(){
        launch({
            ApiRepository().authenticationAuditStatus()
        },liveData = _authenticationAuditStatus)
    }

    fun videoAuthenticationNew(
        avatar: String?,
         auth_vod_url: String?,
       auth_img_url: MutableList<String?>? = null
    ){
        launchWithLoading({
            ApiRepository().videoAuthenticationNew(avatar, auth_vod_url, auth_img_url)
        },liveData = _videoAuthenticationNew)
    }

    fun authenticationInfo(){
        launch({
            ApiRepository().authenticationInfo()
        },liveData = _authenticationInfo)
    }




}