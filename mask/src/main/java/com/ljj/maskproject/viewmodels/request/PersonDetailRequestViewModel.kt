package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithLoading
import com.ljj.lettercircle.model.ImpressionBean
import com.ljj.lettercircle.model.PersonDetailBean
import com.ljj.lettercircle.model.WxNumberBean
import com.ljj.maskproject.http.manager.ApiRepository

class PersonDetailRequestViewModel : BaseViewModel() {
    private val _perosn = MutableLiveData<PersonDetailBean>()
    val perosn: MutableLiveData<PersonDetailBean>
        get() = _perosn

    private val _wxNumber = MutableLiveData<WxNumberBean>()
    val wxNumber: MutableLiveData<WxNumberBean>
        get() = _wxNumber


    private val _impression = MutableLiveData<MutableList<ImpressionBean>>()
    val impression: MutableLiveData<MutableList<ImpressionBean>>
        get() = _impression

    private val _setImpression = MutableLiveData<Any>()
    val setImpression: MutableLiveData<Any>
        get() = _setImpression

    fun getPersionDeatil(userId: String?) {
        launch<PersonDetailBean>({
            ApiRepository().getPersionDeatil(userId)
        }, {
            _perosn.value = it
        })
    }

    fun userWechat(user_id: String) {
        launchWithLoading({
            ApiRepository().userWechat(user_id)
        }, {
            _wxNumber.value = it
        })
    }


    fun visitorHomePage(userId: String?) {
        launchWithLoading<PersonDetailBean>({
            ApiRepository().visitorHomePage(userId)
        }, {
            _perosn.value = it
        })
    }

    fun careUser(userId: String) {
        launchWithLoading({
            ApiRepository().careUser(userId)
        }, {
        })
    }

    fun careUserDelete(userId: String) {
        launchWithLoading({
            ApiRepository().careUserDelete(userId)
        }, {

        })
    }

    fun impression(userId: String) {
        launch({
            ApiRepository().impression(userId)
        }, {
            _impression.value = it
        })
    }

    fun setImpression(userId: String?, id: Int) {
        launch({
            ApiRepository().setImpression(userId, id)
        }, {
            _setImpression.value = it
        })
    }
}