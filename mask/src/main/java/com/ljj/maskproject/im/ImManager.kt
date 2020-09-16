package com.ljj.maskproject.im

import android.app.ActivityManager
import android.content.Context
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import com.ljj.commonlib.util.TimeUtil
import com.ljj.lettercircle.model.AccountBean
import com.ljj.lettercircle.model.SimpleUserBean
import com.ljj.maskproject.helper.ToastHelper
import io.rong.imkit.RongIM
import io.rong.imkit.manager.IUnReadMessageObserver
import io.rong.imlib.IRongCallback
import io.rong.imlib.MessageTag
import io.rong.imlib.RongIMClient
import io.rong.imlib.model.Conversation
import io.rong.imlib.model.Message
import io.rong.imlib.model.SearchConversationResult
import io.rong.imlib.model.UserInfo
import io.rong.imlib.typingmessage.TypingStatus
import io.rong.message.InformationNotificationMessage
import io.rong.message.TextMessage
import io.rong.message.VoiceMessage


/**
 * IM管理类
 * Created by 一锅子鱼 on 2018/10/26.
 */
object ImManager {
    private val CONVERSATIONS_TYPES = Conversation.ConversationType.PRIVATE
    private val TAG = "ImManager"

    fun getCurProcessName(applicationContext: Context): String? {
        val activityManager =
            applicationContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val runningApps = activityManager.runningAppProcesses ?: return null
        val pid = android.os.Process.myPid()
        for (procInfo in runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName
            }
        }
        return null
    }

    /**
     *
     * 如果调用此接口遇到连接失败，SDK 会自动启动重连机制进行最多10次重连，分别是1, 2, 4, 8, 16, 32, 64, 128, 256, 512秒后。
     * 在这之后如果仍没有连接成功，还会在当检测到设备网络状态变化时再次进行重连。
     *
     * @param token    从服务端获取的用户身份令牌（Token）。
     * @return RongIM  客户端核心类的实例。
     */
    fun connect(
        token: String,
        mContext: Context,
        onTokenIncorrect: () -> Unit = {},
        onSuccess: () -> Unit = {}, onError: (error: String) -> Unit = {}
    ) {

        if (mContext.applicationInfo.packageName == getCurProcessName(mContext)) {
            Log.e(TAG, "token=$token")
            RongIM.connect(token, object : RongIMClient.ConnectCallback() {
                /**
                 * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
                 * 2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
                 */
                override fun onTokenIncorrect() {
                    Log.e(TAG, "onTokenIncorrect")
                    onTokenIncorrect()
                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token 对应的用户 id
                 */
                override fun onSuccess(userid: String) {
                    Log.e(TAG, "连接融云成功" + userid)
                    onSuccess()
                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                override fun onError(errorCode: RongIMClient.ErrorCode) {
                    Log.e(TAG, "连接融云失败" + errorCode)
                    //被封禁了让他进去
                    if (errorCode == RongIMClient.ErrorCode.RC_CONN_USER_BLOCKED) {
                        onSuccess()
                    } else {
                        onError("Im error:$errorCode")
                    }
                }
            })
        }
    }


    /***发送单聊消息***/
    fun sendTextMessage(content: String, targetId: String) {
        // 构造 TextMessage 实例
        var myTextMessage = TextMessage.obtain(content)
        var myMessage =
            Message.obtain(targetId, Conversation.ConversationType.PRIVATE, myTextMessage)
        RongIM.getInstance()
            .sendMessage(myMessage, null, null, object : IRongCallback.ISendMessageCallback {
                override fun onAttached(p0: Message?) {
                }

                override fun onSuccess(p0: Message?) {
                }

                override fun onError(p0: Message?, p1: RongIMClient.ErrorCode?) {
                    Log.e(TAG, "发送失败" + p0.toString())
                }

            });

    }

    /**
     *
     * 如果调用此接口遇到连接失败，SDK 会自动启动重连机制进行最多10次重连，分别是1, 2, 4, 8, 16, 32, 64, 128, 256, 512秒后。
     * 在这之后如果仍没有连接成功，还会在当检测到设备网络状态变化时再次进行重连。
     *
     * @param token    从服务端获取的用户身份令牌（Token）。
     * @return RongIM  客户端核心类的实例。
     */
    fun connect(
        token: String,
        mContext: Context,
        onSuc: () -> Unit = {},
        onError: (error: String) -> Unit = {}
    ) {

        if (mContext.applicationInfo.packageName == getCurProcessName(mContext)) {
            Log.e(TAG, "token=$token")
            RongIM.connect(token, object : RongIMClient.ConnectCallback() {
                /**
                 * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
                 * 2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
                 */
                override fun onTokenIncorrect() {
                    Log.e(TAG, "onTokenIncorrect")
                    onError("token错误")
                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token 对应的用户 id
                 */
                override fun onSuccess(userid: String) {
                    Log.e(TAG, "连接融云成功$userid")
                    onSuc()
                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                override fun onError(errorCode: RongIMClient.ErrorCode) {
                    Log.e(TAG, "连接融云失败$errorCode")
                    //被封禁了让他进去
                    if (errorCode == RongIMClient.ErrorCode.RC_CONN_USER_BLOCKED) {
                        onSuc()
                    } else {
                        onError("Im error:$errorCode")
                    }
                }
            })
        }
    }


    /****拉黑***/
    fun addBlackList(
        targetId: String,
        onSuccess: () -> Unit = {},
        onError: (error: String) -> Unit = {}
    ) {
        RongIM.getInstance().addToBlacklist(targetId, object : RongIMClient.OperationCallback() {
            override fun onSuccess() {
                onSuccess()
                ToastHelper.showToast("拉黑成功")
            }

            override fun onError(coe: RongIMClient.ErrorCode?) {
                onError(coe.toString())
                ToastHelper.showToast("拉黑失败")
            }

        })

    }

    /****获取黑名单***/
    fun getBlackList(onSuc: (ids: Array<out String>?) -> Unit, onError: (error: String) -> Unit) {
        RongIM.getInstance().getBlacklist(object : RongIMClient.GetBlacklistCallback() {
            override fun onSuccess(ids: Array<out String>?) {
                onSuc(ids)
            }

            override fun onError(code: RongIMClient.ErrorCode?) {
                onError(code.toString())
            }
        })

    }

    /***获取通知屏蔽***/
    fun getDisturb(func: (isChecked: Boolean) -> Unit) {
        RongIM.getInstance()
            .getNotificationQuietHours(object : RongIMClient.GetNotificationQuietHoursCallback() {
                override fun onSuccess(startTime: String?, spanMins: Int) {
                    func(startTime.isNullOrEmpty())
                }

                override fun onError(errorCode: RongIMClient.ErrorCode?) {
                }

            })
    }

    /***设置通知屏蔽***/
    fun setDisturb(isCheck: Boolean, func: (flag: Boolean) -> Unit = {}) {
        if (isCheck) {
            RongIM.getInstance()
                .removeNotificationQuietHours(object : RongIMClient.OperationCallback() {
                    override fun onSuccess() {
                        func(true)
                    }

                    override fun onError(p0: RongIMClient.ErrorCode?) {
                        func(false)
                    }
                })
        } else {
            var startTime = TimeUtil.getTime(System.currentTimeMillis(), "HH:mm:ss")
            RongIM.getInstance().setNotificationQuietHours(
                startTime,
                1200,
                object : RongIMClient.OperationCallback() {
                    override fun onSuccess() {
                        func(true)
                    }

                    override fun onError(p0: RongIMClient.ErrorCode?) {
                        func(false)
                    }

                })
        }
    }

    /***获得会话屏蔽***/
    fun getConversationDisturb(
        targetId: String,
        onSuc: (isChecked: Boolean) -> Unit = {},
        onError: (error: String) -> Unit = {}
    ) {
        RongIM.getInstance().getConversationNotificationStatus(
            Conversation.ConversationType.PRIVATE,
            targetId,
            object : RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus>() {
                override fun onSuccess(p0: Conversation.ConversationNotificationStatus?) {
                    onSuc(p0?.value.toString() != "1")
                }

                override fun onError(p0: RongIMClient.ErrorCode?) {
                    onError(p0?.message.toString())
                }
            })
    }


    /***设置置顶***/
    fun setConversationTop(targetId: String, state: Boolean) {
        if (!TextUtils.isEmpty(targetId) && RongIM.getInstance() != null) {
            RongIM.getInstance().setConversationToTop(
                Conversation.ConversationType.PRIVATE,
                targetId,
                state,
                object : RongIMClient.ResultCallback<Boolean>() {
                    override fun onSuccess(aBoolean: Boolean?) {

                    }

                    override fun onError(errorCode: RongIMClient.ErrorCode) {

                    }
                })
        }
    }

    /***设置黑名单***/
    fun setConversationDisturb(
        targetId: String,
        isCheck: Boolean,
        onSuc: (data: String) -> Unit = {},
        onError: (error: String) -> Unit = {}
    ) {
        val state = if (isCheck) {
            Conversation.ConversationNotificationStatus.DO_NOT_DISTURB
        } else {
            Conversation.ConversationNotificationStatus.NOTIFY
        }
        RongIM.getInstance().setConversationNotificationStatus(
            Conversation.ConversationType.PRIVATE,
            targetId,
            state,
            object : RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus>() {
                override fun onSuccess(p0: Conversation.ConversationNotificationStatus?) {
                    onSuc(p0?.value.toString())
                }

                override fun onError(p0: RongIMClient.ErrorCode?) {
                    onError(p0.toString())
                }

            })
    }

    /***取消黑名单***/
    fun removeFromBlacklist(
        tagerId: String,
        onSuc: () -> Unit = {},
        onError: (error: String) -> Unit = {}
    ) {
        RongIM.getInstance()
            .removeFromBlacklist(tagerId, object : RongIMClient.OperationCallback() {
                override fun onSuccess() {
                    onSuc()
                }

                override fun onError(errorCode: RongIMClient.ErrorCode) {
                    onError(errorCode.message.toString())
                }
            })
    }


    fun clearUnreadCount() {
        RongIM.getInstance().getRongIMClient().getConversationList()
    }

    /***清除聊天***/
    fun clearChatMessage(
        targetId: String,
        onSuc: () -> Unit = {},
        onError: (error: String) -> Unit = {}
    ) {
        RongIM.getInstance().clearMessages(
            Conversation.ConversationType.PRIVATE,
            targetId,
            object : RongIMClient.ResultCallback<Boolean>() {
                override fun onSuccess(aBoolean: Boolean?) {
                    onSuc()
                    ToastHelper.showToast("删除成功")
                }

                override fun onError(errorCode: RongIMClient.ErrorCode) {
                    onError(errorCode.message.toString())
                    ToastHelper.showToast("删除失败")
                }
            })
        RongIMClient.getInstance().cleanRemoteHistoryMessages(
            Conversation.ConversationType.PRIVATE,
            targetId,
            System.currentTimeMillis(),
            null
        )
    }


    /***接受消息***/
    fun receiveMessage(targetId: String, onSuc: () -> Unit = {}) {
        RongIM.setOnReceiveMessageListener { message, i ->
            if (message.senderUserId.equals(targetId)) {
                onSuc()
            }
            false
        }
    }


    /***发送单聊消息***/
    fun sendTextMessage(content: String, targetId: String, func: TextMessage.() -> Unit) {
        // 构造 TextMessage 实例
        val myTextMessage = TextMessage.obtain(content)
        myTextMessage.func()
        val myMessage =
            Message.obtain(targetId, Conversation.ConversationType.PRIVATE, myTextMessage)
        RongIM.getInstance()
            .sendMessage(myMessage, null, null, object : IRongCallback.ISendMessageCallback {
                override fun onAttached(p0: Message?) {
                }

                override fun onSuccess(p0: Message?) {
                }

                override fun onError(p0: Message?, p1: RongIMClient.ErrorCode?) {
                }
            })
    }

    /**
     * 获取是否拉黑
     */
    fun getBlackState(targetId: String, func: (status: Boolean) -> Unit = {}) {
        RongIM.getInstance().getBlacklistStatus(
            targetId,
            object : RongIMClient.ResultCallback<RongIMClient.BlacklistStatus>() {
                override fun onSuccess(status: RongIMClient.BlacklistStatus?) {
                    func(status == RongIMClient.BlacklistStatus.IN_BLACK_LIST)
                }

                override fun onError(p0: RongIMClient.ErrorCode?) {
                }

            })
    }

    /**
     * 发送本地文明通知
     */
    fun sendLocaNotifyMessage(targetId: String) {
        val content = InformationNotificationMessage.obtain("文明聊天，互相尊重")
        RongIM.getInstance().insertIncomingMessage(Conversation.ConversationType.PRIVATE,
            targetId,
            "${AccountBean.getInstance().user_id}",
            Message.ReceivedStatus(1),
            content,
            object : RongIMClient.ResultCallback<Message>() {
                override fun onSuccess(message: Message) {
                    RongIM.getInstance().deleteMessages(
                        intArrayOf(message.messageId),
                        object : RongIMClient.ResultCallback<Boolean>() {
                            override fun onSuccess(p0: Boolean?) {
                            }

                            override fun onError(p0: RongIMClient.ErrorCode?) {
                            }

                        })
                }

                override fun onError(errorCode: RongIMClient.ErrorCode) {

                }
            }
        )
    }


    /***启动会话界面***/
    fun startConversation(mContext: Context?, targetUserId: String, title: String) {
        RongIM.getInstance()
            .startConversation(mContext, Conversation.ConversationType.PRIVATE, targetUserId, title)
    }


    /***断开连接，有新消息时，仍然能够收到推送通知***/
    fun disconnect() {
        RongIM.getInstance().disconnect()
    }


    /***退出登陆，不想收到任何推送通知***/
    fun logout() {
        RongIM.getInstance().logout()
    }

    /***进入单聊界面***/
    fun startPrivateChat(mContext: Context?, targetUserId: String, title: String) {
        RongIM.getInstance().startPrivateChat(mContext, targetUserId, title)
    }

    /***
     * 设置连接状态的监听
     * 推荐在 Application 中设置。
     * ***/
    fun setConnectionStatusListener(listener: RongIMClient.ConnectionStatusListener) {
        RongIMClient.setConnectionStatusListener(listener)
    }


    /**
     * 会话列表操作监听
     * 在会话列表 Activity 中调用，也可在 Application 中设置
     * onConversationPortraitClick--->点击头像执行
     * onConversationPortraitLongClick--->长按头像执行
     * onConversationLongClick--->长按会话列表中的 item 时执行。
     * onConversationClick--->点击会话列表中的 item 时执行。
     * 如果在 Activity 里设置，需要在 Activity 销毁时，将监听设置为 null，防止内存泄露。
     */
    fun setConversationListBehaviorListener(listener: RongIM.ConversationListBehaviorListener) {
        RongIM.setConversationListBehaviorListener(listener)
    }

    /**
     * 会话操作监听
     * 在会话 Activity 中调用，也可在 Application 中设置。
     * onUserPortraitClick---->接收到消息
     * onUserPortraitLongClick---->长按头像执行
     * onMessageClick----->点击消息时执行
     * onMessageLinkClick---->点击消息连接时执行
     * onMessageLongClick------>长按消息时执行
     * 如果在 Activity 里设置，需要在 Activity 销毁时，将监听设置为 null，防止内存泄露。
     */
    fun setConversationClickListener(listener: RongIM.ConversationClickListener) {
        RongIM.setConversationClickListener(listener)
    }

    /***
     * 消息接收监听
     * 建议在 Application 中调用。
     */
    fun setOnReceiveMessageListener(listener: RongIMClient.OnReceiveMessageListener) {
        RongIM.setOnReceiveMessageListener(listener)
    }

    /**
     * 消息发送监听
     * onSend---->消息发送前监听器处理接口
     * onSent---->消息发送后回调接口。
     * 如果在 Activity 里设置，需要在 Activity 销毁时，将监听设置为 null，防止内存泄露。
     */
    fun setSendMessageListener(listener: RongIM.OnSendMessageListener) {
        RongIM.getInstance().setSendMessageListener(listener)
    }

    /***
     * 接收消息的拦截器监听
     * 建议在 Application 设置。
     */
    fun setMessageInterceptor(listener: RongIM.MessageInterceptor) {
        RongIM.getInstance().setMessageInterceptor(listener)
    }

    /**
     * 未读消息数监听
     * 如果在Activity中调用，需在Activity销毁时移除监听：removeUnReadMessageCountChangedObserver
     */
    fun addUnReadMessageCountChangedObserver(observer: IUnReadMessageObserver) {
        RongIM.getInstance()
            .addUnReadMessageCountChangedObserver(observer, Conversation.ConversationType.PRIVATE)
    }

    /**
     * 未读消息数监听销毁
     */
    fun removeUnReadMessageCountChangedObserver(observer: IUnReadMessageObserver) {
        RongIM.getInstance().removeUnReadMessageCountChangedObserver(observer)
    }


    fun setUserInfoProvider() {

    }

    /**
     * 刷新用户信息
     */
    fun refreshUserInfoCache(bean: SimpleUserBean) {
//        if ("${bean.user_id}" == "${AppConfig.STSTEM_ID}") {
//            RongIM.getInstance().refreshUserInfoCache(UserInfo("${AppConfig.STSTEM_ID}", "系统消息", Uri.parse(AppConfig.SYSTEM_ICON)))
//        } else {
        RongIM.getInstance().refreshUserInfoCache(
            UserInfo(
                bean.user_id.toString(),
                bean.nick_name,
                Uri.parse(bean.avatar)
            )
        )
//        }
    }

    /**
     * 根据ID获取会话
     */
    fun getConversationById(targetId: String, callback: RongIMClient.ResultCallback<Conversation>) {
        RongIM.getInstance()
            .getConversation(Conversation.ConversationType.PRIVATE, targetId, callback)
    }

    /**
     * 根据ID删除会话
     */
    fun removeConversationById(targetId: String, callback: RongIMClient.ResultCallback<Boolean>) {
        RongIM.getInstance()
            .removeConversation(Conversation.ConversationType.PRIVATE, targetId, callback)
    }


    /**
     * 获取会话列表集合
     */
    fun getConversationList(callBack: RongIMClient.ResultCallback<List<Conversation>>) {
        RongIM.getInstance().getConversationList(callBack, CONVERSATIONS_TYPES)
    }


    /**
     * 置顶
     */
    fun setConversationTop(
        targetId: String,
        state: Boolean,
        callback: RongIMClient.ResultCallback<Boolean>
    ) {
        RongIM.getInstance().setConversationToTop(CONVERSATIONS_TYPES, targetId, state, callback)
    }


    /**
     * 清除未读
     */
    fun clearAllMessagesUnreadStatus() {
        RongIM.getInstance()
            .getConversationList(object : RongIMClient.ResultCallback<List<Conversation>>() {
                override fun onSuccess(conversations: List<Conversation>?) {
                    if (conversations != null && conversations.isNotEmpty()) {
                        for (c in conversations) {
                            clearMessagesUnreadStatus(c.targetId)
                        }
                    }
                }

                override fun onError(e: RongIMClient.ErrorCode) {

                }
            }, CONVERSATIONS_TYPES)
    }

    /**
     * 清除单条未读
     */
    fun clearMessagesUnreadStatus(
        targetId: String,
        onSuc: () -> Unit = {},
        onError: (error: String) -> Unit = {}
    ) {
        RongIM.getInstance().clearMessagesUnreadStatus(
            Conversation.ConversationType.PRIVATE,
            targetId,
            object : RongIMClient.ResultCallback<Boolean>() {
                override fun onSuccess(p0: Boolean?) {
                    onSuc()
                }

                override fun onError(p0: RongIMClient.ErrorCode?) {
                    onError(p0.toString())
                }

            })
    }


    /**
     * 搜索关键字查找会话
     */
    fun searchConversations(
        keys: String,
        callback: RongIMClient.ResultCallback<List<SearchConversationResult>>
    ) {
        RongIMClient.getInstance()
            .searchConversations(keys, arrayOf(CONVERSATIONS_TYPES), arrayOf("RC:TxtMsg"), callback)
    }


    /***
     * 输入中回调
     */
    fun setTypingStatusListener(
        userId: String,
        textAction: () -> Unit = {},
        voiceAction: () -> Unit,
        normalActon: () -> Unit
    ) {
        RongIMClient.setTypingStatusListener { _, targetId, typingStatusSet ->
            if (targetId == userId) {
                val count = typingStatusSet.size
                if (count > 0) {
                    val iterator = typingStatusSet.iterator()
                    val status = iterator.next() as TypingStatus
                    val objectName = status.typingContentType
                    val textTag = TextMessage::class.java.getAnnotation(MessageTag::class.java)
                    val voiceTag = VoiceMessage::class.java.getAnnotation(MessageTag::class.java)
                    //匹配对方正在输入的是文本消息还是语音消息
                    if (objectName == textTag?.value) {
                        //显示“对方正在输入”
                        textAction()
                    } else if (objectName == voiceTag?.value) {
                        //显示"对方正在讲话"
                        voiceAction()
                    }
                } else {
                    normalActon()
                }
            }

        }
    }
}