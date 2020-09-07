package com.ljj.maskproject.viewmodels.request


import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.maskproject.http.manager.ApiRepository
import com.ljj.lettercircle.model.AccountBean
import com.ljj.lettercircle.model.LabelBean
import com.ljj.lettercircle.model.PersonBean


/**
 * 用户ViewModel
 */
class UserRequestViewModel : BaseViewModel() {

    private val _getUserInfo by lazy { MutableLiveData<AccountBean>() }
    val getUserInfo get() = _getUserInfo
    private val _updateUserSex by lazy { MutableLiveData<Any>() }
    val updateUserSex get() = _updateUserSex
    private val _updateUserInfo by lazy { MutableLiveData<Any>() }
    val updateUserInfo get() = _updateUserInfo
    private val _updateUserPhoto by lazy { MutableLiveData<Any>() }
    val updateUserPhoto get() = _updateUserPhoto
    private val _getRecentVisitor by lazy { MutableLiveData<MutableList<PersonBean>>() }
    val getRecentVisitor get() = _getRecentVisitor
    private val _getLabel by lazy { MutableLiveData<MutableList<LabelBean>>() }
    val getLabel get() = _getLabel
    private val _updateLabel by lazy { MutableLiveData<Any>() }
    val updateLabel get() = _updateLabel

    fun getUserInfo() {
        launch({
            ApiRepository().getUserInfo()
        }, liveData = _getUserInfo)
    }

    fun updateUserSex(sex: String) {
        launchWithLoading({
            ApiRepository().updateUserSex(sex)
        }, liveData = _updateUserSex)
    }

    fun updateUserInfo(
        nick: String? = null,
        avatar: String? = null,
        sex: Int? = null,
        birthday: String? = null,
        location: String? = null,
        signature: String? = null,
        photo: Int? = null,
        photos: MutableList<String>? = null,
        height: String? = null,
        profession: String? = null,
        annual_income: String? = null,
        wechat: String? = null
    ) {
        launchWithLoading({
            ApiRepository().updateUserInfo(
                nick,
                avatar,
                sex,
                birthday,
                location,
                signature,
                photo,
                photos,
                height,
                profession,
                annual_income,
                wechat
            )
        }, liveData = _updateUserInfo)
    }

    fun updateUserPhoto(photos: MutableList<String>?) {
        launchWithLoading({
            ApiRepository().updateUserPhoto(photos)
        }, liveData = _updateUserPhoto)
    }

    fun getRecentVisitor(currentPage: Int) {
        launchWithStateView({
            ApiRepository().getRecentVisitor(currentPage)
        }, liveData = _getRecentVisitor)
    }

    fun getLabel() {
        launchWithStateView({
            ApiRepository().getLabel()
        }, liveData = _getLabel)
    }

    fun updateLabel(labelList: HashMap<String, String>) {
        launchWithLoading({
            ApiRepository().updateLabel(labelList)
        }, liveData = _updateLabel)
    }


}