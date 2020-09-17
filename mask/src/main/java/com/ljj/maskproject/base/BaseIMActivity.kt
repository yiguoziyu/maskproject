package com.ljj.maskproject.base

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.ljj.commonlib.base.BaseNetActivity
import com.ljj.lettercircle.model.AccountBean
import com.ljj.maskproject.ex.handlerAll
import com.ljj.maskproject.helper.ToastHelper
import com.ljj.maskproject.im.ImManager
import com.ljj.maskproject.viewmodels.request.SimpleUserViewModel

import io.rong.imkit.RongIM
import io.rong.imkit.manager.IUnReadMessageObserver
import io.rong.imlib.RongIMClient
import io.rong.imlib.model.Conversation
import io.rong.imlib.model.UserInfo

abstract class BaseIMActivity : BaseNetActivity(), RongIMClient.ConnectionStatusListener,
    IUnReadMessageObserver,RongIM.UserInfoProvider {
    companion object{
        private const val TAG="BaseIMXActivity"
    }
    private val mSimpleUserViewModel by viewModels<SimpleUserViewModel>()
    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
//        RongIM.setLocationProvider(this)//设置地理位置提供者,不用位置的同学可以注掉此行代码
        RongIM.setConnectionStatusListener(this)
        val conversationTypes = arrayOf(Conversation.ConversationType.PRIVATE, Conversation.ConversationType.GROUP, Conversation.ConversationType.SYSTEM, Conversation.ConversationType.PUBLIC_SERVICE, Conversation.ConversationType.APP_PUBLIC_SERVICE)
        RongIM.getInstance().addUnReadMessageCountChangedObserver(this, *conversationTypes)
        RongIM.setUserInfoProvider(this, true)
        mSimpleUserViewModel.apply {
            user.observe(this@BaseIMActivity, Observer { bean ->
                ImManager.refreshUserInfoCache(bean)
            })
        }.handlerAll(this)
    }

    override fun onChanged(connectionStatus: RongIMClient.ConnectionStatusListener.ConnectionStatus?) {
        when (connectionStatus) {
            RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED -> {
                //连接成功。
               Log.e(TAG,"连接成功")
            }
            RongIMClient.ConnectionStatusListener.ConnectionStatus.DISCONNECTED -> {
                //断开连接。
               Log.e(TAG,"断开连接")
            }
            RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTING -> {
                //连接中
               Log.e(TAG,"连接中")
            }
            RongIMClient.ConnectionStatusListener.ConnectionStatus.NETWORK_UNAVAILABLE -> {
                //网络不可用
               Log.e(TAG,"网络不可用")
            }
            RongIMClient.ConnectionStatusListener.ConnectionStatus.KICKED_OFFLINE_BY_OTHER_CLIENT -> {
                //用户账户在其他设备登录，本机会被踢掉线
                quit()
            }
            RongIMClient.ConnectionStatusListener.ConnectionStatus.CONN_USER_BLOCKED -> {
                //拉黑状态
            }
        }


    }

    fun quit() {
        runOnUiThread {
            ToastHelper.showToast("您的账号在别的设备上登录，您被迫下线!")
            if (application is BaseXApplication){
                (application as BaseXApplication).loginOut(this)
            }
        }
    }

    override fun onDestroy() {
        RongIM.getInstance().removeUnReadMessageCountChangedObserver(this)
        super.onDestroy()
    }

    override fun onCountChanged(p0: Int) {

    }

    override fun getUserInfo(it: String): UserInfo {
        mSimpleUserViewModel.getSimpleUser(it)
        return UserInfo(AccountBean.getInstance().user_id.toString(), AccountBean.getInstance().nick_name, Uri.parse(AccountBean.getInstance().avatar))
    }
}

