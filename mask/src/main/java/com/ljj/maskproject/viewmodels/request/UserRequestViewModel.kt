package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.lettercircle.model.AccountBean
import com.ljj.maskproject.http.manager.ApiRepository

class UserRequestViewModel : BaseViewModel() {
    private var _userLiveData = MutableLiveData<AccountBean>()
    val userLiveData get() = _userLiveData

    private val _setResidentCityLiveData = MutableLiveData<Any>()
    val setResidentCityLiveData get() = _setResidentCityLiveData

    private val _updateUserInfoLiveData = MutableLiveData<Any>()
    val updateUserInfo get() = _updateUserInfoLiveData

    /***获取用户信息***/
    fun getUserInfo() {
        launch({
            ApiRepository().getUserInfo()
        }, {
            _userLiveData.value = it
        })
    }

    fun setResidentCity(citys: MutableList<String>) {
        launch({
            ApiRepository().setResidentCity(citys)
        }, {
            _setResidentCityLiveData.value = it
        })
    }


    fun updateUserInfo(nick: String? = null, avatar: String? = null, sex: Int? = null, birthday: String? = null, location: String? = null, signature: String? = null, photo: Int? = null, photos: MutableList<String>? = null, height: String? = null, profession: String? = null, annual_income: String? = null, wechat: String? = null) {
        launchWithLoading({
            ApiRepository().updateUserInfo(nick, avatar, sex, birthday, location, signature, photo, photos, height, profession, annual_income, wechat)
        }, {
            _updateUserInfoLiveData.value = it
        })
    }


    fun updateSignture(signature: String) {
        updateUserInfo(signature = signature)
    }

}