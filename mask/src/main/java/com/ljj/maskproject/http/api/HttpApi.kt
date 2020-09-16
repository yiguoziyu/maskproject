package com.ljj.maskproject.http.api


/**
 * Created by 一锅子鱼 on 2018/10/22.
 */
class HttpApi {
    companion object {
        const val timeout: Long = 30

        //-----------------------------------------home---------------------------------------------//
        /***获取首页信息接口***/
        const val homePageUrl = "index/userList"

        /***首页搜索条件接口***/
        const val searchConditionUrl = "index/search_condition"

        /***首页轮播图接口***/
        const val bannerListUrl = "index/banner_list"

        /***判断是否可以查看指定用户的微信号***/
        const val userWechatUrl = "user/userWechat"

        /***获取用户主页***/
        const val userHomePageUrl = "user/homepageV"
        //----------------------------------account------------------------------------------//
        /***逛一逛用户信息***/
        const val visitorHomeUrl = "visitor/home"

        /***逛一逛用户主页***/
        const val visitorHomePageUrl = "visitor/homepage"

        /***用户动态列表***/
        const val vistorDynamicsUrl = "visitor/dynamics_list"

        /***关注***/
        const val careUserUrl = "user/careUser"

        /***取消关注***/
        const val cancelCareUserUrl = "user/cancelCareUser"

        /***获取关注我的用户***/
        const val careMeListUrl = "user/careMeList"

        /***获取我关注的用户***/
        const val myCareListUrl = "user/myCareList"

        /***获取访者信息***/
        const val getRecentVisitorUrl = "user/getRecentVisitor"
        //------------------------------------动态-----------------------------------------//
        /***发布动态***/
        const val dynamicsPublishUrl = "dynamics/publish"

        /***动态点赞取消点赞***/
        const val dynamicsPraiseUrl = "dynamics/praise"

        /***删除动态***/
        const val dynamicsDeleteUrl = "dynamics"

        /***动态列表***/
        const val dynamicsListUrl = "dynamics/all_list"

        /***心动用户动态列表接口***/
        const val dynamicsCareListUrl = "dynamics/care_list"

        /***我的动态列表接口***/
        const val dynamicsMyListUrl = "dynamics/my_list"

        /***发布视频动态***/
        const val dynamicsVideoPublish = "dynamics/video_publish"
        //-------------------------------------login--------------------------------------//
        /***检查手机号是否可用***/
        const val checkPhoneUrl = "register/isFreePhone"

        /***发送手机验证码***/
        const val sendSmsCodeUrl = "register/sendSmsCode"

        /***注册用户***/
        const val registerUrl = "register/createAccountBySmsCode"

        /***微信认证登入***/
        const val loginByWxUrl = "user/loginByWeiXin"


        /***一键登录***/
        const val loginByFastUrl = "user/loginByFastG3"

        /***手机号码 验证码登陆***/
        const val loginBySmsCodeUrl = "user/loginBySmsCode"

        /***获取用户信息***/
        const val getUserInfoUrl = "user/getUserInfo"

        /***完善用户注册的基本资料***/
        const val perfectUserInfoUrl = "user/perfectUserInfo"

        /***补充用户资料***/
        const val supplementaryUserInfoUrl = "user/supplementaryUserInfo"

        /***设置用户性别***/
        const val updateUserSexUrl = "user/updateUserSex"

        /***修改用户信息***/
        const val updateUserInfoUrl = "user/updateUserBaseInfo"

        /***上传相册***/
        const val updateUserPhotoUrl = "user/photos"

        /***修改用户属性接口***/
        const val updateUserPropertyUrl = "user/updateUserProperty"


        //-----------------------------------------report---------------------------------------------//
        /***用户反馈接口***/
        const val feedbackUrl = "user/feedback"

        /***封禁反馈接口***/
        const val complainUrl = "user/complain"

        /***用户举报***/
        const val reportedUrl = "user/reported"

        /***认证反馈***/
        const val suggestionUrl = "user/suggestion"


        //-----------------------------------------message---------------------------------------------//
        /***检测用户是否还可以发起聊天***/
        const val checkCanInitiateChatUrl = "user/checkCanInitiateChat"
//        const val checkCanInitiateChatUrl =  "user/checkCanInitiateChatNew"

        /***电台信息***/
        const val broadcastList = "dating/broadcast_list"

        //-------------------------------------语音--------------------------------------//
        /***发布语音***/
        const val voicePublishUrl = "voice/publish"

        /***获取语音列表***/
        const val voiceListUrl = "voice/voiceList"

        /***获取我的语音***/
        const val voiceMyListUrl = "voice/myVoiceList"

        /***删除语音***/
        const val voiceDeteteListUrl = "voice"

        /***播放语音***/
        const val voicePlayUrl = "voice/play"

        //--------------------------------------约会--------------------------------------//
        /***约会列表***/
        const val datingListUrl = "dating/dating_list"

        /***获取我的约会列表***/
        const val datingMyListUrl = "dating/my_dating_list"

        /***约会详情，修改约会状态***/
        const val datingUrl = "dating"

        /***发布约会***/
        const val datingPublishUrl = "dating/publish"

        /***报名约会，审核约会报名***/
        const val datingEnrollsUrl = "dating/enrolls"

        /***获取约玩报名列表***/
        const val datingEnrollsListUrl = "dating/dating_enrolls_list"

        /***获取我报名的约玩***/
        const val datingUserEnrollsListUrl = "dating/user_enrolls_list"

        /***判断是否可以发布约玩***/
        const val datingCheckCanPublishUrl = "dating/checkCanPublish"

        /***获取统计的约玩数据***/
        const val datingStatisticsUrl = "dating/datingStatistics"


        //-----------------------------------------share---------------------------------------------//
        /***分享相关信息接口****/
        const val shareInfo = "user/shareInfo"

        /***邀请相关信息获取***/
        const val invite = "user/invite"

        /***修改提现账号***/
        const val withdrawAccount = "user/withdrawAccount"

        /***获取提现相关信息***/
        const val withdrawInfo = "user/withdrawInfo"

        /****用户提现列表***/
        const val withdrawList = "user/withdrawList"

        /***用户提现***/
        const val withdraw = "user/withdraw"

        /***邀请收入列表***/
        const val inviteIncomeList = "user/inviteIncomeList"

        /***获取我所有的优惠券***/
        const val getCouponList = "coupon/getCouponList"

        /****获取商品可用优惠券****/
        const val getCanUseCouponList = "coupon/getCanUseCouponList"

        //-----------------------------------------pay---------------------------------------------//
        /***获取支付方式和商品列表***/
        const val payTypeUrl = "pyed/type"

        /***充值***/
        const val payRecharge = "pyed/recg"

        /***充值***/
        const val rechargeUrl = "pyed/recg"

        /*** 充值--- 可使用优惠券版本***/
        const val recgWithCouponUrl = "pyed/recgWithCoupon"

        const val payTypeNewUrl = "pyed/info"
        //-----------------------------------------auth---------------------------------------------//
        /***获取腾讯云临时密钥***/
        const val getCAMTokenUrl = "user/getCAMToken"

        /***视频认证***/
        const val videoAuthenticationUrl = "user/videoAuthentication"

        /***获取认证基本信息***/
        const val authenticationInfoUrl = "user/authenticationInfo"

        /***获取认证基本信息G2***/
        const val authenticationInfoG2Url = "user/authenticationInfoG2"

        /***视频认证G2***/
        const val videoAuthenticationG2Url = "user/videoAuthenticationG2"

        /***视频认证new***/
        const val videoAuthenticationNew = "user/videoAuthenticationNew"

        /**视频认证结果***/
        const val authenticationAuditStatus = "user/authenticationAuditStatus"
        //-----------------------------------------common---------------------------------------------//

        /***base config***/
        const val baseConfig = "config/app"

        /***加入黑名单***/
        const val addToBlacklist = "user/addToBlacklist"

        /***移出黑名单***/
        const val removeFromBlacklist = "user/removeFromBlacklist"


        /***上传日志***/
        const val uploadLogFileUrl = "pay/log"

        /***小黑屋***/
        const val blackHouseUrl = "user/blackHouse"

        /***小黑屋轮播图接口***/
        const val punishmentBannerUrl = "user/punishmentBanner"

        /***注销账号***/
        const val logOffUrl = "user/logOff"

        /***修改定位距离是否显示***/
        const val setDistanceShow = "user/setDistanceShow"

        /***判断动态次数***/
        const val canPublish = "dynamics/can_publish"

        /***动态详情***/
        const val dynamicDetail = "dynamics/info"

        /***修改用户备注***/
        const val updateNotesUrl = "user/updateNotes"

        /***获取指定用户的简要数据***/
        const val userSimpleInfoUrl = "user/userSimpleInfo"

        /***用户登出***/
        const val logoutUrl = "user/logout"


        /***获取个性标签接口,更新个性标签接口***/
        const val labelUrl = "user/label"


        /***自动发放优惠券***/
        const val autoGift = "coupon/autoGift"


        /***隐身设置***/
        const val cloaking = "user/setPrivacyAccess"

        /***获取设置印象***/
        const val impression = "user/impression"

        /***设置常驻城市***/
        const val setResidentCity = "user/setResidentCity"

    }

}