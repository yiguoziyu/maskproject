package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.maskproject.ex.launchWithStateView
import com.ljj.maskproject.http.manager.ApiRepository
import com.ljj.lettercircle.model.PersonBean
import com.ljj.lettercircle.model.PersonDetailBean

/**
 * 首页
 */
class HomeRequestViewModel : BaseViewModel() {

    private val _getHomePageData by lazy { MutableLiveData<MutableList<PersonBean>>() }
    val getHomePageData get() = _getHomePageData
    private val _getPersionDeatil by lazy { MutableLiveData<PersonDetailBean>() }
    val getPersionDeatil get() = _getPersionDeatil

    fun getHomePageData(
        action: String,
        currentPage: Int,
        age: String?,
        sex: String?,
        annual_income: String?,
        city: String?,
        sort: String?
    ) {
        launchWithStateView({
            ApiRepository().getHomePageData(
                action,
                currentPage,
                age,
                sex,
                annual_income,
                city,
                sort
            )
        }, liveData = _getHomePageData)
    }

    fun getPersionDeatil(userId: String) {
        launchWithStateView({
            ApiRepository().getPersionDeatil(userId)
        }, liveData = _getPersionDeatil)
    }


}