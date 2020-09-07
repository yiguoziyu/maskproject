package com.ljj.maskproject.viewmodels.global

import com.ljj.commonlib.jectpack.livedata.LiveDataBus
import com.ljj.commonlib.jectpack.viewmodel.GlobalViewModel


object DynamicGlobalViewModel : GlobalViewModel() {

    private const val KEY_DYNAMIC_PRAISE = "dynamic_praise"
    private const val KEY_DYNAMIC_PRAISE_UN = "dynamic_praise_un"
    private const val KEY_DYNAMIC_LOCATION = "dynamic_location"
    private const val KEY_DYNAMIC_PUBLISH = "dynamic_publish"
    private const val KEY_DYNAMIC_DELETE = "dynamic_delete"
    private const val KEY_DYNAMIC_LIKE_NUMBER = "dynamic_like_number"
    private const val KEY_DYNAMIC_REFRESH = "dynamic_refresh"
    private const val KEY_DYNAMIC_LIKE = "dynamic_like"

    //动态点赞
    fun getDyanmicPraiseLiveData() = LiveDataBus.with<String>(KEY_DYNAMIC_PRAISE)

    //动态取消点赞
    fun getDyanmicPraiseUnLiveData() = LiveDataBus.with<String>(KEY_DYNAMIC_PRAISE_UN)

    //动态位置
    fun getDyanmicocationLiveData() = LiveDataBus.with<String>(KEY_DYNAMIC_LOCATION)

    //动态发布
    fun getDyanmicPublishLiveData() = LiveDataBus.with<Any>(KEY_DYNAMIC_PUBLISH)

    //动态删除
    fun getDyanmicDeleteLiveData() = LiveDataBus.with<String>(KEY_DYNAMIC_DELETE)

    //动态喜欢数
    fun getDynamicLikeNumberLiveData() = LiveDataBus.with<String>(KEY_DYNAMIC_LIKE_NUMBER)

    //动态刷新
    fun getDynamicRefreshLiveData() = LiveDataBus.with<Any>(KEY_DYNAMIC_REFRESH)

    //动态点赞
    fun getDynamicLikeLiveData() = LiveDataBus.with<String>(KEY_DYNAMIC_LIKE)
}