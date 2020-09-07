package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.maskproject.http.manager.ApiRepository
import com.ljj.lettercircle.model.ChatStatusBean
import com.ljj.lettercircle.model.DatingBroadcastBean

/**
 * 消息
 */
class MessageViewModel : BaseViewModel() {
    private val _checkCanInitiateChat by lazy { MutableLiveData<ChatStatusBean>() }
    val checkCanInitiateChat get() = _checkCanInitiateChat
    private val _broadcastList by lazy { MutableLiveData<MutableList<DatingBroadcastBean>>() }
    val broadcastList get() = _broadcastList


    fun checkCanInitiateChat(targetId: String?) {
        launch({
            ApiRepository().checkCanInitiateChat(targetId)
        }, liveData = _checkCanInitiateChat)
    }

    fun broadcastList(currentPage: Int) {
        launchWithStateView({
            ApiRepository().broadcastList(currentPage)
        }, liveData = _broadcastList)
    }
}