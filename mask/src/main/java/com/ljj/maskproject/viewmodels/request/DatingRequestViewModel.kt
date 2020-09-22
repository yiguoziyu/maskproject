package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.lettercircle.model.*
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.maskproject.http.manager.ApiRepository
import retrofit2.http.Field
import retrofit2.http.Query

/**
 * 约玩
 */
class DatingRequestViewModel : BaseViewModel() {
    private val _broadcastListLiveData by lazy { MutableLiveData<MutableList<DatingBroadcastBean>>() }
    val roadcastListLiveData get() = _broadcastListLiveData
    private val _datingStatistics by lazy { MutableLiveData<DatingStaticticsBean>() }
    val datingStatistics get() = _datingStatistics

    private val _datingDetail by lazy { MutableLiveData<DatingDetailBean>() }
    val datingDetail get() = _datingDetail

    private val _datingList by lazy { MutableLiveData<MutableList<DatingBean>>() }
    val datingList get() = _datingList
    private val _datingMyList by lazy { MutableLiveData<MutableList<DatingBean>>() }
    val datingMyList get() = _datingMyList

    private val _datingCheckCanPublish by lazy { MutableLiveData<DatingPublishStatusBean>() }
    val datingCheckCanPublish get() = _datingCheckCanPublish

    private val _datingUpdate by lazy { MutableLiveData<Any>() }
    val datingUpdate get() = _datingUpdate

    private val _datingPublish by lazy { MutableLiveData<Any>() }
    val datingPublish get() = _datingPublish

    private val _datingEnrolls by lazy { MutableLiveData<Any>() }
    val datingEnrolls get() = _datingEnrolls

    private val _datingAudit by lazy { MutableLiveData<Any>() }
    val datingAudit get() = _datingAudit

    private val _datingEnrollsList by lazy { MutableLiveData<MutableList<DatingEnrollsBean>>() }
    val datingEnrollsList get() = _datingEnrollsList

    private val _datingUserEnrollsList by lazy { MutableLiveData< MutableList<DatingBean>>() }
    val datingUserEnrollsList get() = _datingUserEnrollsList
    fun broadcastList(currentPage: Int) {
        launchWithStateView({
            ApiRepository().broadcastList(currentPage)
        }, liveData = _broadcastListLiveData)
    }

    fun datingStatistics() {
        launch({
            ApiRepository().datingStatistics()
        }, liveData = _datingStatistics)
    }

    fun datingList(
        currentPage: Int,
        mSex: Int,
        activity_type_id: String?,
        place: String?
    ) {
        launchWithStateView({
            ApiRepository().datingList(currentPage, mSex, activity_type_id, place)
        }, liveData = _datingList)
    }


    fun datingMyList(currentPage: Int) {
        launchWithStateView({
            ApiRepository().datingMyList(currentPage)
        }, liveData = _datingMyList)
    }

    fun datingDetail(dating_id: Int) {
        launchWithStateView({
            ApiRepository().datingDetail(dating_id)
        }, liveData = _datingDetail)
    }

    fun datingUpdate(dating_id: Int, action: String) {
        launch({
            ApiRepository().datingUpdate(dating_id, action)
        }, liveData = _datingUpdate)
    }

    fun datingPublish(
        @Query("place") place: String?,
        @Query("target") target: String?,
        @Query("date") date: String?,
        @Query("start_date") start_date: String?,
        @Query("activity_type") activity_type: String?,
        @Query("activity_type_id") activity_type_id: String?,
        @Query("cost_type") cost_type: String?,
        @Query("wechat") wechat: String?,
        @Query("content") content: String?,
        @Field("photo_list[]") dating_photo: MutableList<String>?
    ) {
        launchWithLoading({
            ApiRepository().datingPublish(
                place,
                target,
                date,
                start_date,
                activity_type,
                activity_type_id,
                cost_type,
                wechat,
                content,
                dating_photo
            )
        }, liveData = _datingPublish)
    }


    fun datingEnrolls(dating_id: String) {
        launch({
            ApiRepository().datingEnrolls(dating_id)
        },liveData = _datingEnrolls)
    }

    fun datingAudit(dating_id: Int, id: Int, action: String) {
        launch({
            ApiRepository().datingAudit(dating_id, id, action)
        }, liveData = _datingAudit)
    }

    fun datingEnrollsList(currentPage: Int, dating_id: Int) {
        launchWithStateView({
            ApiRepository().datingEnrollsList(currentPage, dating_id)
        }, liveData = _datingEnrollsList)
    }

    fun datingUserEnrollsList(currentPage: Int) {
        launch({
            ApiRepository().datingUserEnrollsList(currentPage)
        }, liveData = _datingUserEnrollsList)
    }

    fun datingCheckCanPublish() {
        launch({
            ApiRepository().datingCheckCanPublish()
        },liveData = _datingCheckCanPublish)
    }
}