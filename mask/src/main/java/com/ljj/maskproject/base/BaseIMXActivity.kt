package com.ljj.maskproject.base

import android.os.Bundle
import android.util.Log
import com.ljj.commonlib.base.BaseNetActivity
import com.ljj.maskproject.helper.ToastHelper
import io.rong.imkit.RongIM
import io.rong.imkit.manager.IUnReadMessageObserver
import io.rong.imlib.RongIMClient
import io.rong.imlib.model.Conversation

abstract class BaseIMXActivity : BaseNetActivity(), RongIMClient.ConnectionStatusListener,
    IUnReadMessageObserver {
    companion object {
        private const val TAG = "BaseIMXActivity"
    }

    //    private val mSimpleUserViewModel by viewModels<SimpleUserViewModel>()
    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
//        RongIM.setLocationProvider(this)//设置地理位置提供者,不用位置的同学可以注掉此行代码
        RongIM.setConnectionStatusListener(this)
        val conversationTypes = arrayOf(
            Conversation.ConversationType.PRIVATE,
            Conversation.ConversationType.GROUP,
            Conversation.ConversationType.SYSTEM,
            Conversation.ConversationType.PUBLIC_SERVICE,
            Conversation.ConversationType.APP_PUBLIC_SERVICE
        )
        RongIM.getInstance().addUnReadMessageCountChangedObserver(this, *conversationTypes)
    }

    override fun onChanged(connectionStatus: RongIMClient.ConnectionStatusListener.ConnectionStatus?) {
        when (connectionStatus) {
            RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED -> {
                //连接成功。
                Log.e(TAG, "连接成功")
            }
            RongIMClient.ConnectionStatusListener.ConnectionStatus.DISCONNECTED -> {
                //断开连接。
                Log.e(TAG, "断开连接")
            }
            RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTING -> {
                //连接中
                Log.e(TAG, "连接中")
            }
            RongIMClient.ConnectionStatusListener.ConnectionStatus.NETWORK_UNAVAILABLE -> {
                //网络不可用
                Log.e(TAG, "网络不可用")
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
//            PageHelper.loginOutReady()
        }
    }

    override fun onDestroy() {
        RongIM.setConnectionStatusListener(null)
        RongIM.getInstance().removeUnReadMessageCountChangedObserver(this)
        super.onDestroy()
    }

    override fun onCountChanged(p0: Int) {

    }


}