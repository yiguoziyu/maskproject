package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.lettercircle.model.AccountBean
import com.ljj.lettercircle.model.LabelBean
import com.ljj.lettercircle.model.PersonBean
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.maskproject.http.manager.ApiRepository
import retrofit2.http.Field
import retrofit2.http.Query
import retrofit2.http.QueryMap

class UserRequestViewModel : BaseViewModel() {
    private var _userLiveData = MutableLiveData<AccountBean>()
    val userLiveData get() = _userLiveData

    private val _setResidentCityLiveData = MutableLiveData<Any>()
    val setResidentCityLiveData get() = _setResidentCityLiveData

    private val _updateUserInfoLiveData = MutableLiveData<Any>()
    val updateUserInfo get() = _updateUserInfoLiveData


    private val _getMyCareList by lazy { MutableLiveData<MutableList<PersonBean>>() }
    val getMyCareList get() = _getMyCareList

    private val _getCareMeList by lazy { MutableLiveData<MutableList<PersonBean>>() }
    val getCareMeList get() = _getCareMeList
    private val _getRecentVisitor by lazy { MutableLiveData<MutableList<PersonBean>>() }
    val getRecentVisitor get() = _getRecentVisitor

    private val _getLabel by lazy { MutableLiveData<MutableList<LabelBean>>() }
    val getLabel get() = _getLabel

    private val _updateUserPhoto by lazy { MutableLiveData<Any>() }
    val updateUserPhoto get() = _updateUserPhoto

    private val _updateLabel by lazy { MutableLiveData<Any>() }
    val updateLabel get() = _updateLabel
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
        }, {
            _updateUserInfoLiveData.value = it
        })
    }


    fun updateSignture(signature: String) {
        updateUserInfo(signature = signature)
    }

    fun getRecentVisitor(currentPage: Int) {
        launchWithStateView({
            ApiRepository().getRecentVisitor(currentPage)
        }, liveData = _getRecentVisitor)
    }

    fun getMyCareList(currentPage: Int) {
        launchWithStateView({
            ApiRepository().getMyCareList(currentPage)
        }, liveData = _getMyCareList)
    }

    fun getCareMeList(currentPage: Int) {
        launchWithStateView({
            ApiRepository().getCareMeList(currentPage)
        }, liveData = _getCareMeList)
    }


     fun updateUserPhoto(photos: MutableList<String>?){
         launchWithLoading({
             ApiRepository().updateUserPhoto(photos)
         },liveData = _updateUserPhoto)
     }

     fun getLabel(){
         launchWithStateView({
             ApiRepository().getLabel()
         },liveData = _getLabel)
     }

     fun updateLabel(labelList: HashMap<String, String>){
         launchWithLoading({
             ApiRepository().updateLabel(labelList)
         },liveData = _updateLabel)
     }

}