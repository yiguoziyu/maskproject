package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.maskproject.http.manager.ApiRepository
import com.ljj.model.DynamicsBean
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
    private val _getDynamicsCareList by lazy { MutableLiveData<MutableList<DynamicsBean>>() }
    val getDynamicsCareList get() = _getDynamicsCareList
    private val _dynamicsPraise by lazy { MutableLiveData<String>() }
    val dynamicsPraise get() = _dynamicsPraise
    private val _dynamicsPraiseDel by lazy { MutableLiveData<String>() }
    val dynamicsPraiseDel get() = _dynamicsPraiseDel
    private val _dynamicsPublish by lazy { MutableLiveData<Any>() }
    val dynamicsPublish get() = _dynamicsPublish
    private val _dynamicsDelete by lazy { MutableLiveData<String>() }
    val dynamicsDelete get() = _dynamicsDelete
    private val _dynamicsMyList by lazy { MutableLiveData<MutableList<DynamicsBean>>() }
    val dynamicsMyList get() = _dynamicsMyList
    private val _dynamicsVideoPublish by lazy { MutableLiveData<Any>() }
    val dynamicsVideoPublish get() = _dynamicsVideoPublish
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
        }, liveData = _getDynamicsCareList)
    }

    fun dynamicsPraise(@Query("dynamics_id") dynamics_id: String) {
        launch({
            ApiRepository().dynamicsPraise(dynamics_id)
        }, {
            _dynamicsPraise.value = dynamics_id
        })
    }

    fun dynamicsPraiseDel(@Query("dynamics_id") dynamics_id: String) {
        launch({
            ApiRepository().dynamicsPraiseDel(dynamics_id)
        }, {
            _dynamicsPraiseDel.value = dynamics_id
        })
    }

    fun dynamicsPublish(
        dynamics_content: String,
        dynamics_photo: MutableList<String>
    ) {
        launchWithLoading({
            ApiRepository().dynamicsPublish(dynamics_content, dynamics_photo)
        }, liveData = _dynamicsPublish)
    }

    fun dynamicsDelete(@Query("dynamics_id") dynamics_id: String) {
        launchWithLoading({
            ApiRepository().dynamicsDelete(dynamics_id)
        }, {
            _dynamicsDelete.value = dynamics_id
        })
    }

    fun dynamicsMyList(@Query("page") currentPage: Int) {
        launchWithStateView({
            ApiRepository().dynamicsMyList(currentPage)
        }, liveData = _dynamicsMyList)
    }


    fun dynamicsVideoPublish(
        content: String?,
        cover_url: String?,
        video_url: String?
    ) {
        launchWithLoading({
            ApiRepository().dynamicsVideoPublish(content, cover_url, video_url)
        }, liveData = _dynamicsVideoPublish)
    }

    fun canPublish() {
        launchWithLoading({
            ApiRepository().canPublish()
        }, liveData = _canPublish)
    }

}