package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.lettercircle.model.AuthBean
import com.ljj.lettercircle.model.AuthStateBean
import com.ljj.maskproject.http.manager.ApiRepository
import com.ljj.maskproject.ex.launch

/**
 * 认证ViewModel
 */
class IdentificationRequestViewModel : BaseViewModel() {

    companion object {
        private const val TAG = "IdentificationRequest"
    }

    private var _authLiveData = MutableLiveData<AuthBean>()
    val authLiveData get() = _authLiveData
    val authUplaodStateLiveData = MutableLiveData<Boolean>()

    val authStateLiveData = MutableLiveData<AuthStateBean>()
    /***认证信息***/
    fun authenticationInfoG2() {
        launch({
            ApiRepository().authenticationInfoG2()
        }, {
            _authLiveData.value = it
        })
    }

    /***上传认证信息***/
    fun videoAuthenticationNew(auth_vod_url: String?, avatar: String?, auth_img_url: MutableList<String?>? = null) {
        launch({
            ApiRepository().videoAuthenticationNew(avatar, auth_vod_url, auth_img_url)
        }, {
            authUplaodStateLiveData.value = true
        })
    }

    /***获取认证进度信息***/
    fun authenticationAuditStatus() {
        launch({
            ApiRepository().authenticationAuditStatus()
        }, {
            authStateLiveData.value = it
        })
    }
}