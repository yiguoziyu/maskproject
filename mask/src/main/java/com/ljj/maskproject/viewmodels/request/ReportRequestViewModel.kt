package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.maskproject.http.manager.ApiRepository

/**
 * 举报
 */
class ReportRequestViewModel : BaseViewModel() {
    private val _feedback by lazy { MutableLiveData<Any>() }
    val feedback get() = _feedback
    private val _complain by lazy { MutableLiveData<Any>() }
    val complain get() = _complain
    private val _reported by lazy { MutableLiveData<Any>() }
    val reported get() = _reported
    private val _suggestion by lazy { MutableLiveData<Any>() }
    val suggestion get() = _suggestion
     fun feedback(
        feedback_content: String,
        phone: String,
        feedback_photo: MutableList<String>
    ) {
        launchWithLoading({
            ApiRepository().feedback(feedback_content, phone, feedback_photo)
        }, liveData = _feedback)
    }

     fun complain(
        feedback_content: String,
        phone: String,
        feedback_photo: MutableList<String>
    ) {
        launchWithLoading({
            ApiRepository().complain(feedback_content, phone, feedback_photo)
        }, liveData = _complain)
    }

     fun reported(
         userId: String,
         content: String?,
         type: String?,
         photos: MutableList<String>?
    ){
        launchWithLoading({
            ApiRepository().reported(userId, content, type,photos)
        }, liveData = _reported)
    }

     fun suggestion(
         feedback_content: String,
         phone: String,
        feedback_photo: MutableList<String>
    ){
        launchWithLoading({
            ApiRepository().suggestion(feedback_content, phone, feedback_photo)
        }, liveData = _suggestion)
    }
}