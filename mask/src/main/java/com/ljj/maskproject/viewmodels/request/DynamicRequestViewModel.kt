package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.lettercircle.model.DynamicsBean
import com.ljj.maskproject.http.manager.ApiRepository
import com.ljj.maskproject.viewmodels.global.DynamicGlobalViewModel
import retrofit2.http.Query


/**
 * 动态
 */
class DynamicRequestViewModel : BaseViewModel() {
    companion object {
        private const val TAG = "DynamicRequestViewModel"
    }

    private val _getDynamicsList by lazy { MutableLiveData<MutableList<DynamicsBean>>() }
    val getDynamicsList get() = _getDynamicsList

    //    private val _getDynamicsCareList by lazy { MutableLiveData<MutableList<DynamicsBean>>() }
//    val getDynamicsCareList get() = _getDynamicsCareList
    private val _dynamicsPraise by lazy { MutableLiveData<String>() }
    val dynamicsPraise get() = _dynamicsPraise
    private val _dynamicsPraiseDel by lazy { MutableLiveData<String>() }
    val dynamicsPraiseDel get() = _dynamicsPraiseDel

    //    private val _dynamicsPublish by lazy { MutableLiveData<Any>() }
//    val dynamicsPublish get() = _dynamicsPublish
    private val _dynamicsDelete by lazy { MutableLiveData<String>() }
    val dynamicsDelete get() = _dynamicsDelete

    //    private val _dynamicsMyList by lazy { MutableLiveData<MutableList<DynamicsBean>>() }
//    val dynamicsMyList get() = _dynamicsMyList
//    private val _dynamicsVideoPublish by lazy { MutableLiveData<Any>() }
//    val dynamicsVideoPublish get() = _dynamicsVideoPublish
    private val _dynamicDetail by lazy { MutableLiveData<DynamicsBean>() }
    val dynamicDetail get() = _dynamicDetail
    private val _canPublish by lazy { MutableLiveData<Any>() }
    val canPublish get() = _canPublish

    fun getDynamicsList(
        @Query("page") currentPage: Int,
        @Query("other_user_id") userId: String?,
        @Query("type") type: Int?
    ) {
        launchWithStateView({
            ApiRepository().getDynamicsList(currentPage, userId, type)
        }, liveData = _getDynamicsList)
    }

    fun getDynamicsCareList(@Query("page") currentPage: Int) {
        launchWithStateView({
            ApiRepository().getDynamicsCareList(currentPage)
        }, liveData = _getDynamicsList)
    }

    fun dynamicsPraise(@Query("dynamics_id") dynamics_id: String) {
        launch({
            ApiRepository().dynamicsPraise(dynamics_id)
        }, {
            DynamicGlobalViewModel.getDyanmicPraiseLiveData().postValue(dynamics_id)
        })
    }

    fun dynamicsPraiseDel(@Query("dynamics_id") dynamics_id: String) {
        launch({
            ApiRepository().dynamicsPraiseDel(dynamics_id)
        }, {
            DynamicGlobalViewModel.getDyanmicPraiseUnLiveData().postValue(dynamics_id)
        })
    }
    //带有活跃城市
    fun dynamicsPublish(
        dynamics_content: String,
        dynamics_photo: MutableList<String>,
        city: String?
    ) {
        launchWithLoading({
            ApiRepository().dynamicsPublish(dynamics_content, dynamics_photo, city)
        }, {
            DynamicGlobalViewModel.getDyanmicPublishLiveData().postValue("")
        })
    }


    fun dynamicsPublish(
        dynamics_content: String,
        dynamics_photo: MutableList<String>
    ) {
        launchWithLoading({
            ApiRepository().dynamicsPublish(dynamics_content, dynamics_photo)
        }, {
            DynamicGlobalViewModel.getDyanmicPublishLiveData().postValue("")
        })
    }

    fun dynamicsDelete(@Query("dynamics_id") dynamics_id: String) {
        launchWithLoading({
            ApiRepository().dynamicsDelete(dynamics_id)
        }, {
            DynamicGlobalViewModel.getDyanmicDeleteLiveData().postValue(dynamics_id)
        })
    }

    fun dynamicsMyList(@Query("page") currentPage: Int) {
        launchWithStateView({
            ApiRepository().dynamicsMyList(currentPage)
        }, liveData = _getDynamicsList)
    }


    fun dynamicsVideoPublish(
        content: String?,
        cover_url: String?,
        video_url: String?,
        city: String?
    ) {
        launchWithLoading({
            ApiRepository().dynamicsVideoPublish(content, cover_url, video_url, city)
        }, {
            DynamicGlobalViewModel.getDyanmicPublishLiveData().postValue("")
        })
    }

    fun canPublish() {
        launchWithLoading({
            ApiRepository().canPublish()
        }, liveData = _canPublish)
    }

    fun dynamicDetail(dynamicId: String) {
        launchWithStateView({
            ApiRepository().dynamicDetail(dynamicId)
        }, {
            _dynamicDetail.value = it
        })
    }


}