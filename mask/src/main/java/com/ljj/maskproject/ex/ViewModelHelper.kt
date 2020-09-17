package com.ljj.maskproject.ex

import android.util.Log
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.ljj.commonlib.constants.HTTP_SUC
import com.ljj.commonlib.jectpack.state.RefreshState
import com.ljj.commonlib.jectpack.state.ResponseState
import com.ljj.commonlib.jectpack.state.ViewState
import com.ljj.commonlib.jectpack.viewmodel.BaseAndroidViewModel
import com.ljj.commonlib.jectpack.viewmodel.BaseViewModel
import com.ljj.commonlib.model.BaseResponse
import com.ljj.commonlib.model.createErrorResponse
import com.ljj.maskproject.base.BaseViewActivity
import com.ljj.maskproject.base.BaseXApplication
import com.ljj.maskproject.helper.ToastHelper
import com.ljj.maskproject.http.config.IGsonException
import com.ljj.maskproject.view.StateLayout
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

const val TAG_HTTP = "http"

fun <T> BaseViewModel.launch(
    block: suspend CoroutineScope.() -> BaseResponse<T>,
    onSuccess: (data: T) -> Unit = {},
    onSpecial: (response: BaseResponse<out Any?>) -> Unit = {},
    onError: (e: BaseResponse<String>) -> Unit = {},
    onComplete: () -> Unit = {},
    liveData: MutableLiveData<*>? = null
) {
    viewModelScope.launch {
        try {
            val response = block.invoke(this)
            if (response.Flag == HTTP_SUC) {
                responseState.value = ResponseState.HttpSuccess(response)
                onSuccess(response.data)
                liveData?.value = response.data
            } else {
                onSpecial(response)
                responseState.value = ResponseState.HttpSpecial(response)
            }
        } catch (e: Exception) {
            val errorResponse = createErrorResponse(getErrorTip(e))
            onError(errorResponse)
            responseState.value = ResponseState.HttpFail(errorResponse)
        } finally {
            onComplete()
        }
    }
}

fun <T> BaseViewModel.launchList(
    block: suspend CoroutineScope.() -> BaseResponse<T>,
    onSuccess: (data: T) -> Unit = {},
    onError: (e: Exception) -> Unit = {},
    onComplete: () -> Unit = {}
) {
    viewModelScope.launch {
        try {
            val response = block.invoke(this)
            if (response.Flag == HTTP_SUC) {
                responseState.value = ResponseState.HttpSuccess(response)
                onSuccess(response.data)
            } else {
                responseState.value = ResponseState.HttpSpecial(response)
            }
        } catch (e: Exception) {
            onError(e)
            Log.e(TAG_HTTP, "e${e.message}")
            responseState.value = ResponseState.HttpFail(createErrorResponse(getErrorTip(e)))
            viewState.value = ViewState.ViewFail()
        } finally {
            onComplete()
        }
    }
}


fun <T> BaseViewModel.launchWithLoading(
    block: suspend CoroutineScope.() -> BaseResponse<T>,
    onSuccess: (data: T) -> Unit = {},
    onError: (e: Exception) -> Unit = {},
    onSpecial: (BaseResponse<T>) -> Unit = {},
    onComplete: () -> Unit = {},
    liveData: MutableLiveData<*>? = null
) {
    viewModelScope.launch {
        try {
            viewState.value = ViewState.LoadingShow()
            val response = block.invoke(this)
            if (response.Flag == HTTP_SUC) {
                responseState.value = ResponseState.HttpSuccess(response)
                onSuccess(response.data)
                liveData?.value = response.data
            } else {
                responseState.value = ResponseState.HttpSpecial(response)
                onSpecial(response)
            }
        } catch (e: Exception) {
            Log.e(TAG_HTTP, "e==>${e.message}")
            Log.e(TAG_HTTP, "e==>${e}")
            e.printStackTrace();

            responseState.value = ResponseState.HttpFail(createErrorResponse(getErrorTip(e)))
            onError(e)
        } finally {
            onComplete()
            viewState.value = ViewState.LoadingDismiss()
        }
    }
}

fun <T> BaseViewModel.launchWithStateView(
    block: suspend CoroutineScope.() -> BaseResponse<T>,
    onSuccess: (data: T) -> Unit = {},
    onError: (e: Exception) -> Unit = {},
    onComplete: () -> Unit = {},
    liveData: MutableLiveData<*>? = null
) {
    viewModelScope.launch {
        try {
            val response = block.invoke(this)
            if (response.Flag == HTTP_SUC) {
                responseState.value = ResponseState.HttpSuccess(response)
                viewState.value = ViewState.ViewContent()
                onSuccess(response.data)
                liveData?.value = response.data
            } else {
                viewState.value = ViewState.ViewFail()
                responseState.value = ResponseState.HttpSpecial(response)
            }
        } catch (e: Exception) {
            Log.e(TAG_HTTP, "e${e.message}")
            viewState.value = ViewState.ViewFail()
            responseState.value = ResponseState.HttpFail(createErrorResponse(getErrorTip(e)))
            onError(e)
        } finally {
            onComplete()
            viewState.value = ViewState.LoadingDismiss()
        }
    }
}


fun <T> BaseAndroidViewModel.launch(
    block: suspend CoroutineScope.() -> BaseResponse<T>,
    onSuccess: (data: T) -> Unit = {},
    onError: (e: Exception) -> Unit = {},
    onComplete: () -> Unit = {}
) {
    viewModelScope.launch {
        try {
            val response = block.invoke(this)
            if (response.Flag == HTTP_SUC) {
                responseState.value = ResponseState.HttpSuccess(response)
                onSuccess(response.data)
            } else {
                responseState.value = ResponseState.HttpSpecial(response)
            }
        } catch (e: Exception) {
            onError(e)
            Log.e(TAG_HTTP, "e${e.message}")
            responseState.value = ResponseState.HttpFail(createErrorResponse(getErrorTip(e)))
        } finally {
            onComplete()
        }
    }
}

fun <T> BaseAndroidViewModel.launchWithLoading(
    block: suspend CoroutineScope.() -> BaseResponse<T>,
    onSuccess: (data: T) -> Unit = {},
    onError: (e: Exception) -> Unit = {},
    onSpecial: (BaseResponse<T>) -> Unit = {},
    onComplete: () -> Unit = {}
) {
    viewModelScope.launch {
        try {
            viewState.value = ViewState.LoadingShow()
            val response = block.invoke(this)
            if (response.Flag == HTTP_SUC) {
                responseState.value = ResponseState.HttpSuccess(response)
                onSuccess(response.data)
            } else {
                responseState.value = ResponseState.HttpSpecial(response)
                onSpecial(response)
            }
        } catch (e: Exception) {
            Log.e(TAG_HTTP, "e${e.message}")
            responseState.value = ResponseState.HttpFail(createErrorResponse(getErrorTip(e)))
            onError(e)
        } finally {
            onComplete()
            viewState.value = ViewState.LoadingDismiss()
        }
    }
}


fun getErrorTip(e: Exception): String {
    return when (e) {
        is UnknownHostException -> "您的网络不稳定，请稍后重试[code:01]"
        is SocketTimeoutException -> "您的网络不稳定，请稍后重试[code:02]"
        is ConnectException -> "您的网络不稳定，请稍后重试[code:03]"
        is TimeoutException -> "您的网络不稳定，请稍后重试[code:04]"
        is IGsonException -> "${e.message}"
        else -> "您的网络不稳定，请稍后重试[code:05]"
    }
}


//非100值统一处理
fun <T> handleSpecial(response: BaseResponse<T>, activity: FragmentActivity) {
    if (activity.application is BaseXApplication){
        (activity.application as BaseXApplication).handleSpecial(response,activity)
    }
}


fun <T> handleHttpResult(
    response: BaseResponse<T>,
    activity: FragmentActivity,
    onSuccess: (response: BaseResponse<T>) -> Unit = {},
    onSpecial: (response: BaseResponse<T>) -> Unit = {}
) {
    if (response.Flag == HTTP_SUC) {
        onSuccess(response)
    } else {
        handleSpecial(response, activity)
        onSpecial(response)
    }
}


fun BaseViewModel.handleView(
    @NonNull activity: BaseViewActivity,
    statelayout: StateLayout?,
    refresh: SmartRefreshLayout? = null
) {
    return this.viewState.observe(activity, Observer {
        when (it) {
            is ViewState.LoadingShow -> activity.showLoadDialog()
            is ViewState.LoadingDismiss -> activity.dismissLoadDialog()
            is ViewState.ViewContent -> statelayout?.showContentView()
            is ViewState.ViewEmpty -> statelayout?.showEmptyView()
            is ViewState.ViewFail -> {
                statelayout?.showErrorView()
                refresh?.finishRefresh()
                refresh?.finishLoadMore()
            }
            is ViewState.ViewProgress -> statelayout?.showProgressView()
        }
    })
}



fun BaseViewModel.handlerResponse(
    @NonNull activity: FragmentActivity,
    onSuccess: (response: BaseResponse<out Any?>) -> Unit = {},
    onSpecial: (response: BaseResponse<out Any?>) -> Unit = {},
    onFail: (response: BaseResponse<out Any?>) -> Unit = {}
) {
    return this.responseState.observe(activity, Observer {
        when (it) {
            is ResponseState.HttpSuccess -> {
                onSuccess(it.response)
            }
            is ResponseState.HttpSpecial -> {
                Log.e(TAG_HTTP, "HttpSpecial" + it.response)
                onSpecial(it.response)
                handleSpecial(it.response, activity)
            }
            is ResponseState.HttpFail -> {
                onFail(it.response)
                ToastHelper.showToast(it.response.FlagString)
            }
        }
    })
}


fun <T> T.init(block: T.() -> Unit): T {
    block()
    return this
}


fun BaseViewModel.handlerAll(
    @NonNull activity: FragmentActivity,
    onSuccess: (response: BaseResponse<out Any?>) -> Unit = {},
    onSpecial: (response: BaseResponse<out Any?>) -> Unit = {},
    onFail: (response: BaseResponse<out Any?>) -> Unit = {},
    statelayout: StateLayout? = null,
    refresh: SmartRefreshLayout? = null
) {
    if (activity is BaseViewActivity) {
        handleView(activity, statelayout, refresh)
    }
    handlerResponse(activity, onSuccess, onSpecial, onFail)
}


fun BaseAndroidViewModel.handleToast(@NonNull activity: FragmentActivity) {
    return this.toastState.observe(activity, Observer {
        ToastHelper.showToast(it)
    })
}

fun BaseAndroidViewModel.handleView(@NonNull activity: FragmentActivity, statelayout: StateLayout) {
    return this.viewState.observe(activity, Observer {
        when (it) {
            is ViewState.ViewContent -> statelayout.showContentView()
            is ViewState.ViewEmpty -> statelayout.showEmptyView()
            is ViewState.ViewFail -> statelayout.showErrorView()
            is ViewState.ViewProgress -> statelayout.showProgressView()
        }
    })
}

fun BaseAndroidViewModel.handleRefresh(
    @NonNull activity: BaseViewActivity,
    refresh: SmartRefreshLayout
) {
    return this.refreshState.observe(activity, Observer {
        when (it) {
            is RefreshState.RefreshFinish -> refresh.finishRefresh()
            is RefreshState.LoadFinish -> refresh.finishLoadMore()
            is RefreshState.LoadNoMoreData -> refresh.finishLoadMoreWithNoMoreData()
        }
    })
}

fun BaseAndroidViewModel.handlerResponse(
    @NonNull activity: BaseViewActivity,
    onSuccess: (response: BaseResponse<out Any?>) -> Unit = {},
    onSpecial: (response: BaseResponse<out Any?>) -> Unit = {},
    onFail: (response: BaseResponse<out Any?>) -> Unit = {}
) {
    return this.responseState.observe(activity, Observer {
        when (it) {
            is ResponseState.HttpSuccess -> onSuccess(it.response)
            is ResponseState.HttpSpecial -> {
                onSpecial(it.response)
                handleSpecial(it.response, activity)
            }
            is ResponseState.HttpFail -> {
                onFail(it.response)
                ToastHelper.showToast(it.response.FlagString)
            }
        }
    })
}

fun BaseAndroidViewModel.handlerAll(
    @NonNull activity: BaseViewActivity,
    statelayout: StateLayout?,
    refresh: SmartRefreshLayout?
) {
    statelayout?.let {
        handleView(activity, statelayout)
    }
    refresh?.let {
        handleRefresh(activity, it)
    }
    handlerResponse(activity)
    handleToast(activity)
}