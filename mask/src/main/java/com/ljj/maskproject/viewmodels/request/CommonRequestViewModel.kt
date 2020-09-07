package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.maskproject.http.manager.ApiRepository
import com.ljj.model.*

class CommonRequestViewModel : BaseViewModel() {

    private val _getBannerList by lazy { MutableLiveData<MutableList<BannerBean>>() }
    val getBannerList get() = _getBannerList

    private val _getBaseConfig by lazy { MutableLiveData<BaseConfig>() }
    val getBaseConfig get() = _getBaseConfig

    private val _searchCondition by lazy { MutableLiveData<Any>() }
    val searchCondition get() = _searchCondition

    private val _getUserSimpleInfo by lazy { MutableLiveData<SimpleUserBean>() }
    val getUserSimpleInfo get() = _getUserSimpleInfo

    private val _careUser by lazy { MutableLiveData<Any>() }
    val careUser get() = _careUser

    private val _careUserDelete by lazy { MutableLiveData<Any>() }
    val careUserDelete get() = _careUserDelete

    private val _userWechat by lazy { MutableLiveData<WxNumberBean>() }
    val userWechat get() = _userWechat


    private val _getMyCareList by lazy { MutableLiveData<MutableList<PersonBean>>() }
    val getMyCareList get() = _getMyCareList

    private val _getCareMeList by lazy { MutableLiveData<MutableList<PersonBean>>() }
    val getCareMeList get() = _getCareMeList

    private val _logout by lazy { MutableLiveData<Any>() }
    val logout get() = _logout
    private val _uploadLogFile by lazy { MutableLiveData<Any>() }
    val uploadLogFile get() = _uploadLogFile

    private val _blackHouse by lazy { MutableLiveData<MutableList<BlackInfoBean>>() }
    val blackHouse get() = _blackHouse

    private val _punishmentBanner by lazy { MutableLiveData<MutableList<BannerBean>>() }
    val punishmentBanner get() = _punishmentBanner

    private val _logOff by lazy { MutableLiveData<Any>() }
    val logOff get() = _logOff

    private val _setDistanceShow by lazy { MutableLiveData<Any>() }
    val setDistanceShow get() = _setDistanceShow

    fun getBannerList() {
        launch({
            ApiRepository().getBannerList()
        }, liveData = _getBannerList)
    }

    fun getBaseConfig() {
        launch({
            ApiRepository().getBaseConfig()
        }, liveData = _getBaseConfig)
    }


    fun searchCondition() {
        launch({
            ApiRepository().searchCondition()
        }, liveData = _searchCondition)
    }

    fun getUserSimpleInfo(targetId: String) {
        launch({
            ApiRepository().getUserSimpleInfo(targetId)
        }, liveData = _getUserSimpleInfo)
    }

    fun careUser(userId: String) {
        launchWithLoading({
            ApiRepository().careUser(userId)
        }, liveData = _careUser)
    }

    fun careUserDelete(userId: String) {
        launchWithLoading({
            ApiRepository().careUserDelete(userId)
        }, liveData = _careUserDelete)
    }

    fun userWechat(to_user_id: String) {
        launchWithLoading({
            ApiRepository().userWechat(to_user_id)
        }, liveData = _userWechat)
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


    fun logout(is_normal: String) {
        launchWithLoading({
            ApiRepository().logout(is_normal)
        }, liveData = _logout)
    }

    fun uploadLogFile(fileUrl: String) {
        launchWithLoading({
            ApiRepository().uploadLogFile(fileUrl)
        }, liveData = _uploadLogFile)
    }

    fun blackHouse(currentPage: Int) {
        launchWithStateView({
            ApiRepository().blackHouse(currentPage)
        }, liveData = _blackHouse)
    }

    fun punishmentBanner() {
        launch({
            ApiRepository().punishmentBanner()
        }, liveData = _punishmentBanner)
    }

    fun logOff(content: String = "注销账号") {
        launchWithLoading({
            ApiRepository().logOff(content)
        }, liveData = _logOff)
    }

    fun setDistanceShow(status: String?) {
        launchWithLoading({
            ApiRepository().setDistanceShow(status)
        }, liveData = _setDistanceShow)
    }

}