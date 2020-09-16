package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launch
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.lettercircle.model.FiltrateBean
import com.ljj.lettercircle.model.ImpressionBean
import com.ljj.lettercircle.model.PersonBean
import com.ljj.lettercircle.model.PersonDetailBean
import com.ljj.maskproject.http.manager.ApiRepository

/**
 * 首页
 */
class HomeRequestViewModel : BaseViewModel() {

    private val _getHomePageData by lazy { MutableLiveData<MutableList<PersonBean>>() }
    val getHomePageData get() = _getHomePageData
    private val _getPersionDeatil by lazy { MutableLiveData<PersonDetailBean>() }
    val getPersionDeatil get() = _getPersionDeatil

    private val _impression = MutableLiveData<MutableList<ImpressionBean>>()
    val impression: MutableLiveData<MutableList<ImpressionBean>>
        get() = _impression

    private val _setImpression = MutableLiveData<Any>()
    val setImpression: MutableLiveData<Any>
        get() = _setImpression
    fun getHomePageData(
            action: String,
            currentPage: Int,
            mFiltrateBean: FiltrateBean
    ) {
        launchWithStateView({
            ApiRepository().getHomePageData(
                    action,
                    currentPage,
                    mFiltrateBean.age,
                    mFiltrateBean.sex,
                    mFiltrateBean.income,
                    mFiltrateBean.city,
                    "${mFiltrateBean.sort}"
            )
        }, liveData = _getHomePageData)
    }

    fun getPersionDeatil(userId: String) {
        launchWithStateView({
            ApiRepository().getPersionDeatil(userId)
        }, liveData = _getPersionDeatil)
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