package com.ljj.maskproject.viewmodels.request

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ljj.commonlib.constants.HTTP_SUC
import com.ljj.commonlib.jectpack.state.ResponseState
import com.ljj.commonlib.jectpack.state.ViewState

import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.commonlib.model.BaseResponse
import com.ljj.commonlib.model.createErrorResponse
import com.ljj.maskproject.ex.launch
import com.ljj.lettercircle.model.SimpleUserBean
import com.ljj.maskproject.http.manager.ApiRepository
import com.ljj.maskproject.im.ImManager
import com.ljj.maskproject.ex.getErrorTip
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SimpleUserViewModel : BaseViewModel() {

    companion object {
        const val TAG = "SimpleUserViewModel"
    }

    //用户数据
    private val _user: MutableLiveData<SimpleUserBean> by lazy {
        MutableLiveData<SimpleUserBean>()
    }
    val user: MutableLiveData<SimpleUserBean>
        get() = _user


    private val _userList by lazy { MutableLiveData<MutableList<SimpleUserBean>>() }
    val userList get() = _userList
    fun getSimpleUser(targetId: String, tag: Int? = null) {
        launch({
            ApiRepository().getUserSimpleInfo(targetId)
        }, {
            it.tag = tag?:0
            _user.value = it
        })
    }

    fun getSimpleUserSaveIm(targetId: String) {
        launch({
            ApiRepository().getUserSimpleInfo(targetId)
        }, {
            ImManager.refreshUserInfoCache(it)
        })
    }

    fun getSimpleUsers(targetIds: MutableList<String>) {
        viewModelScope.launch {
            try {
                val mDeferreds = mutableListOf<Deferred<BaseResponse<SimpleUserBean>>>()
                targetIds.forEach {
                    mDeferreds.add(async { ApiRepository().getUserSimpleInfo(it) })
                }
                val dataList = mutableListOf<SimpleUserBean>()
                mDeferreds.forEach {
                    val response = it.await()
                    if (response.Flag == HTTP_SUC) {
                        responseState.value = ResponseState.HttpSuccess(response)
                        viewState.value = ViewState.ViewContent()
                        dataList.add(response.data)
                    } else {
                        viewState.value = ViewState.ViewFail()
                        responseState.value = ResponseState.HttpSpecial(response)
                    }
                }
                _userList.postValue(dataList)
            } catch (e: Exception) {
                viewState.value = ViewState.ViewFail()
                responseState.value = ResponseState.HttpFail(createErrorResponse(getErrorTip(e)))
            } finally {
            }
        }
    }

//    fun refreshUserInfoCache(bean: SimpleUserBean) {
//        when {
//            "${bean.user_id}" == AppConfig.CHAT_SYSTEM_ID -> {
//                ImManager.refreshUserInfoCache(UserInfo(AppConfig.CHAT_SYSTEM_ID, AppConfig.CHAT_SYSTEM_TITLE, Uri.parse(AppConfig.CHAT_SYSTEM_ICON)))
//            }
//            "${bean.user_id}" == AppConfig.CHAT_SERVICE_ID -> {
//                ImManager.refreshUserInfoCache(UserInfo(AppConfig.CHAT_SERVICE_ID, AppConfig.CHAT_SERVICE_TITLE, Uri.parse(AppConfig.CHAT_SERVICE_ICON)))
//            }
//            else -> {
//                ImManager.refreshUserInfoCache(UserInfo(bean.user_id.toString(), bean.nick_name, Uri.parse(ModleUtil.getRealData(bean))))
//            }
//        }
//    }
}

