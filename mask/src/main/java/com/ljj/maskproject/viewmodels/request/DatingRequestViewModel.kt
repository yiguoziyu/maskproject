package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.lettercircle.model.*
import com.ljj.maskproject.http.manager.ApiRepository

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


    private val _datingCheckCanPublish by lazy { MutableLiveData<DatingPublishStatusBean>() }
    val datingCheckCanPublish get() = _datingCheckCanPublish
    fun broadcastList(currentPage: Int) {
        launchWithStateView({
            ApiRepository().broadcastList(currentPage)
        }, {
            _broadcastListLiveData.value = it
        })
    }

    fun datingStatistics() {
        launch({
            ApiRepository().datingStatistics()
        }, {
            _datingStatistics.value = it
        })
    }



    fun datingMyList(currentPage: Int) {
        launchWithStateView({
            ApiRepository().datingMyList(currentPage)
        }, {

        })
    }

    fun datingDetail(dating_id: Int) {
        launch({
            ApiRepository().datingDetail(dating_id)
        }, {
            _datingDetail.value = it
        })
    }

    fun datingUpdate(dating_id: Int, action: String) {
        launch({
            ApiRepository().datingUpdate(dating_id, action)
        }, {

        })
    }

//    fun datingPublish(place: String?, target: String?, date: String?, activity_type: String?, cost_type: String?, wechat: String?, content: String?, dating_photo: MutableList<String>?) {
//        launch({
//            ApiRepository().datingPublish(place, target, date, activity_type, cost_type, wechat, content, dating_photo)
//        }, {
//
//        })
//    }


    fun datingEnrolls(dating_id: String) {
        launch({
            ApiRepository().datingEnrolls(dating_id)
        }, {

        })
    }

    fun datingAudit(dating_id: Int, id: Int, action: String) {
        launch({
            ApiRepository().datingAudit(dating_id, id, action)
        }, {

        })
    }

    fun datingEnrollsList(currentPage: Int, dating_id: Int) {
        launch({
            ApiRepository().datingEnrollsList(currentPage, dating_id)
        }, {

        })
    }

    fun datingUserEnrollsList(currentPage: Int) {
        launch({
            ApiRepository().datingUserEnrollsList(currentPage)
        }, {

        })
    }

    fun datingCheckCanPublish() {
        launch({
            ApiRepository().datingCheckCanPublish()
        }, {
            datingCheckCanPublish.value = it
        })
    }
}