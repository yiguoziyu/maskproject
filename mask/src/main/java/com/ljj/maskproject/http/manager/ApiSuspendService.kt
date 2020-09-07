package com.ljj.maskproject.http.manager

import com.ljj.commonlib.model.BaseResponse
import com.ljj.maskproject.http.api.HttpApi
import com.ljj.model.*
import retrofit2.http.*

interface ApiSuspendService {

    //-----------------------------------------share---------------------------------------------//
    /***获取提现相关信息***/
    @GET(HttpApi.withdrawInfo)
    suspend fun withdrawInfo(): BaseResponse<InviteWithdrawBean>

    /***修改提现账号***/
    @PUT(HttpApi.withdrawAccount)
    suspend fun withdrawAccount(
        @Query("account") account: String?,
        @Query("real_name") real_name: String?
    ): BaseResponse<Any>

    /***分享相关信息接口***/
    @GET(HttpApi.shareInfo)
    suspend fun shareInfo(): BaseResponse<ShareBean>

    /***邀请相关信息获取***/
    @GET(HttpApi.invite)
    suspend fun invite(): BaseResponse<InviteBean>

    /***用户提现***/
    @POST(HttpApi.withdraw)
    suspend fun withdraw(@Query("amount") amount: String): BaseResponse<Any>

    /****用户提现列表***/
    @GET(HttpApi.withdrawList)
    suspend fun withdrawList(@Query("page") currentPage: Int): BaseResponse<Any>

    /***邀请收入列表***/
    @GET(HttpApi.inviteIncomeList)
    suspend fun inviteIncomeList(@Query("page") currentPage: Int): BaseResponse<Any>

    /***获取我所有的优惠券***/
    @GET(HttpApi.getCouponList)
    suspend fun getCouponList(@Query("status") status: String): BaseResponse<Any>

    /****获取商品可用优惠券****/
    @GET(HttpApi.getCanUseCouponList)
    suspend fun getCanUseCouponList(@Query("product_id") product_id: String): BaseResponse<Any>



    //-----------------------------------------report---------------------------------------------//

    @FormUrlEncoded
    @POST(HttpApi.feedbackUrl)
    suspend fun feedback(
        @Query("content") feedback_content: String,
        @Query("contact_way") phone: String,
        @Field("photo_list[]") feedback_photo: MutableList<String>
    ): BaseResponse<Any>

    @FormUrlEncoded
    @POST(HttpApi.complainUrl)
    suspend fun complain(
        @Query("content") feedback_content: String,
        @Query("contact_way") phone: String,
        @Field("photo_list[]") feedback_photo: MutableList<String>
    ): BaseResponse<Any>

    @FormUrlEncoded
    @POST(HttpApi.reportedUrl)
    suspend fun reported(
        @Query("target_user_id") userId: String,
        @Query("content") content: String?,
        @Query("type") type: String?,
        @Field("photo_list[]") photos: MutableList<String>?
    ): BaseResponse<Any>

    @FormUrlEncoded
    @POST(HttpApi.suggestionUrl)
    suspend fun suggestion(
        @Query("content") feedback_content: String,
        @Query("contact_way") phone: String,
        @Field("photo_list[]") feedback_photo: MutableList<String>
    ): BaseResponse<Any>

    //-----------------------------------------common---------------------------------------------//
    @GET(HttpApi.bannerListUrl)
    suspend fun getBannerList(): BaseResponse<MutableList<BannerBean>>

    @GET(HttpApi.baseConfig)
    suspend fun getBaseConfig(): BaseResponse<BaseConfig>

    @GET(HttpApi.searchConditionUrl)
    suspend fun searchCondition(): BaseResponse<Any>

    @GET(HttpApi.userSimpleInfoUrl)
    suspend fun getUserSimpleInfo(@Query("search_user_id") targetId: String): BaseResponse<SimpleUserBean>

    @POST(HttpApi.careUserUrl)
    suspend fun careUser(@Query("care_user_id") userId: String): BaseResponse<Any>

    @DELETE(HttpApi.cancelCareUserUrl)
    suspend fun careUserDelete(@Query("care_user_id") userId: String): BaseResponse<Any>

    @GET(HttpApi.userWechatUrl)
    suspend fun userWechat(@Query("to_user_id") to_user_id: String): BaseResponse<WxNumberBean>


    @GET(HttpApi.myCareListUrl)
    suspend fun getMyCareList(@Query("page") currentPage: Int): BaseResponse<MutableList<PersonBean>>

    @GET(HttpApi.careMeListUrl)
    suspend fun getCareMeList(@Query("page") currentPage: Int): BaseResponse<MutableList<PersonBean>>


    @POST(HttpApi.logoutUrl)
    suspend fun logout(@Query("is_normal") is_normal: String): BaseResponse<Any>

    @POST(HttpApi.uploadLogFileUrl)
    suspend fun uploadLogFile(@Query("log") fileUrl: String): BaseResponse<Any>

    @GET(HttpApi.blackHouseUrl)
    suspend fun blackHouse(@Query("page") currentPage: Int): BaseResponse<MutableList<BlackInfoBean>>

    @GET(HttpApi.punishmentBannerUrl)
    suspend fun punishmentBanner(): BaseResponse<MutableList<BannerBean>>

    @PUT(HttpApi.logOffUrl)
    suspend fun logOff(@Query("content") content: String = "注销账号"): BaseResponse<Any>

    @POST(HttpApi.setDistanceShow)
    suspend fun setDistanceShow(@Query("status") status: String?): BaseResponse<Any>

    //-----------------------------------------auth---------------------------------------------//
    @POST(HttpApi.getCAMTokenUrl)
    suspend fun getBucketConfig(): BaseResponse<BucketBean>

    @GET(HttpApi.authenticationInfoG2Url)
    suspend fun authenticationInfoG2(): BaseResponse<AuthBean>


    @POST(HttpApi.videoAuthenticationG2Url)
    suspend fun videoAuthenticationG2(
        @Query("auth_vod_url") auth_vod_url: String?,
        @Query("avatar") avatar: String?,
        @Query("auth_img_url") auth_img_url: String?
    ): BaseResponse<Any>


    @POST(HttpApi.videoAuthenticationUrl)
    suspend fun videoAuthentication(@Query("auth_vod_url") authVodUrl: String): BaseResponse<Any>

    @GET(HttpApi.authenticationAuditStatus)
    suspend fun authenticationAuditStatus(): BaseResponse<AuthStateBean>

    @FormUrlEncoded
    @POST(HttpApi.videoAuthenticationNew)
    suspend fun videoAuthenticationNew(
        @Query("avatar") avatar: String?,
        @Query("auth_vod_url") auth_vod_url: String?,
        @Field("auth_img_url[]") auth_img_url: MutableList<String?>? = null
    ): BaseResponse<Any>

    @GET(HttpApi.authenticationInfoUrl)
    suspend fun authenticationInfo(): BaseResponse<IdentityAuthBean>



    //-----------------------------------------pay---------------------------------------------//

    @GET(HttpApi.payTypeUrl)
    suspend fun getPayType(@Query("type") type: String): BaseResponse<PayTypeBean>

    @POST(HttpApi.rechargeUrl)
    suspend fun recharge(
        @Query("recg_id") goodId: Int,
        @Query("pyed_way") pay_way: Int,
        @Query("platform") platform: String
    ): BaseResponse<PayBean>



    //-----------------------------------------login-------------------------------------------- -//
    @GET(HttpApi.visitorHomeUrl)
    suspend fun visitorHome(
        @Query("sex") sex: Int,
        @Query("page") currentPage: Int
    ): BaseResponse<MutableList<PersonBean>>

    @GET(HttpApi.visitorHomePageUrl)
    suspend fun visitorHomePage(@Query("h_user_id") uId: String): BaseResponse<PersonDetailBean>

    @GET(HttpApi.vistorDynamicsUrl)
    suspend fun visitorDynamics(
        @Query("h_user_id") uId: String,
        @Query("page") currentPage: Int
    ): BaseResponse<Any>

    @POST(HttpApi.checkPhoneUrl)
    suspend fun checkPhone(@Query("phone") phone: String): BaseResponse<Any>

    @POST(HttpApi.sendSmsCodeUrl)
    suspend fun sendSmsCode(
        @Query("phone") phone: String,
        @Query("action") action: String
    ): BaseResponse<Any>

    @POST(HttpApi.registerUrl)
    suspend fun register(
        @Query("phone") phone: String,
        @Query("sms_code") smsCode: String,
        @Query("platform") platform: String,
        @Query("password") password: String
    ): BaseResponse<LoginAccountBean>


    @POST(HttpApi.loginByWxUrl)
    suspend fun loginByWx(
        @Query("platform") platform: String,
        @Query("unionid") unionid: String,
        @Query("openid") openid: String,
        @Query("access_token") access_token: String
    ): BaseResponse<LoginAccountBean>

    @POST(HttpApi.loginByFastUrl)
    suspend fun loginByFast(@Query("accessToken") accessToken: String?): BaseResponse<LoginAccountBean>

    @POST(HttpApi.loginBySmsCodeUrl)
    suspend fun loginBySmsCode(
        @Query("phone") phone: String,
        @Query("sms_code") smsCode: String
    ): BaseResponse<LoginAccountBean>

    @PUT(HttpApi.updateUserPropertyUrl)
    suspend fun updateUserProperty(@Query("property") property: String): BaseResponse<Any>

    @PUT(HttpApi.perfectUserInfoUrl)
    suspend fun perfectUserInfo(
        @Query("birthday") birthday: String?,
        @Query("location") location: String?,
        @Query("province") province: String?,
        @Query("annual_income") annual_income: String?,
        @Query("type") type: String?
    ): BaseResponse<LoginAccountBean>

    @PUT(HttpApi.supplementaryUserInfoUrl)
    suspend fun supplementaryUserInfo(
        @Query("avatar") avatar: String,
        @Query("nick") nick: String?,
        @Query("height") height: String?,
        @Query("wechat") wechat: String?
    ): BaseResponse<Any>


    //-----------------------------------------account---------------------------------------------//
    @GET(HttpApi.getUserInfoUrl)
    suspend fun getUserInfo(): BaseResponse<AccountBean>

    @PUT(HttpApi.updateUserSexUrl)
    suspend fun updateUserSex(@Query("sex") sex: String): BaseResponse<Any>

    @FormUrlEncoded
    @PUT(HttpApi.updateUserInfoUrl)
    suspend fun updateUserInfo(
        @Query("nick") nick: String? = null,
        @Query("avatar") avatar: String? = null,
        @Query("sex") sex: Int? = null,
        @Query("birthday") birthday: String? = null,
        @Query("location") location: String? = null,
        @Query("signature") signature: String? = null,
        @Query("photos") photo: Int? = null,
        @Field("photos[]") photos: MutableList<String>? = null,
        @Query("height") height: String? = null,
        @Query("profession") profession: String? = null,
        @Query("annual_income") annual_income: String? = null,
        @Query("wechat") wechat: String? = null
    ): BaseResponse<Any>

    @FormUrlEncoded
    @PUT(HttpApi.updateUserPhotoUrl)
    suspend fun updateUserPhoto(@Field("photos[]") photos: MutableList<String>?): BaseResponse<Any>

    @GET(HttpApi.getRecentVisitorUrl)
    suspend fun getRecentVisitor(@Query("page") currentPage: Int): BaseResponse<MutableList<PersonBean>>

    @GET(HttpApi.labelUrl)
    suspend fun getLabel(): BaseResponse<List<LabelBean>>

    @PUT(HttpApi.labelUrl)
    suspend fun updateLabel(@QueryMap labelList: HashMap<String, String>): BaseResponse<Any>
    //-----------------------------------------home---------------------------------------------//

    @GET(HttpApi.homePageUrl)
    suspend fun getHomePageData(
        @Query("name") action: String,
        @Query("page") currentPage: Int,
        @Query("age") age: String?,
        @Query("sex") sex: String?,
        @Query("annual_income") annual_income: String?,
        @Query("city") city: String?,
        @Query("sort") sort: String?
    ): BaseResponse<List<PersonBean>>

    @GET(HttpApi.userHomePageUrl)
    suspend fun getPersionDeatil(@Query("h_user_id") userId: String): BaseResponse<PersonDetailBean>


    //-----------------------------------------message---------------------------------------------//

    @GET(HttpApi.checkCanInitiateChatUrl)
    suspend fun checkCanInitiateChat(@Query("to_user_id") targetId: String?): BaseResponse<ChatStatusBean>

    @GET(HttpApi.broadcastList)
    suspend fun broadcastList(@Query("page") currentPage: Int): BaseResponse<MutableList<DatingBroadcastBean>>
    //-----------------------------------------dynamic---------------------------------------------//

    @GET(HttpApi.dynamicsListUrl)
    suspend fun getDynamicsList(
        @Query("page") currentPage: Int,
        @Query("other_user_id") userId: String?,
        @Query("type") type: Int?
    ): BaseResponse<MutableList<DynamicsBean>>

    @GET(HttpApi.dynamicsCareListUrl)
    suspend fun getDynamicsCareList(@Query("page") currentPage: Int): BaseResponse<MutableList<DynamicsBean>>

    @POST(HttpApi.dynamicsPraiseUrl)
    suspend fun dynamicsPraise(@Query("dynamics_id") dynamics_id: String): BaseResponse<Any>

    @DELETE(HttpApi.dynamicsPraiseUrl)
    suspend fun dynamicsPraiseDel(@Query("dynamics_id") dynamics_id: String): BaseResponse<Any>

    @FormUrlEncoded
    @POST(HttpApi.dynamicsPublishUrl)
    suspend fun dynamicsPublish(
        @Query("content") dynamics_content: String,
        @Field("photo_list[]") dynamics_photo: MutableList<String>
    ): BaseResponse<Any>

    @DELETE(HttpApi.dynamicsDeleteUrl)
    suspend fun dynamicsDelete(@Query("dynamics_id") dynamics_id: String): BaseResponse<Any>

    @GET(HttpApi.dynamicsMyListUrl)
    suspend fun dynamicsMyList(@Query("page") currentPage: Int): BaseResponse<MutableList<DynamicsBean>>


    @POST(HttpApi.dynamicsVideoPublish)
    suspend fun dynamicsVideoPublish(
        @Query("content") content: String?,
        @Query("cover_url") cover_url: String?,
        @Query("video_url") video_url: String?
    ): BaseResponse<Any>

    @GET(HttpApi.canPublish)
    suspend fun canPublish(): BaseResponse<Any>

    //-----------------------------------------dating---------------------------------------------//
    @GET(HttpApi.datingListUrl)
    suspend fun datingList(
        @Query("page") currentPage: Int,
        @Query("sex") mSex: Int,
        @Query("activity_type_id") activity_type_id: String?,
        @Query("place") place: String?
    ): BaseResponse<MutableList<DatingBean>>

    @GET(HttpApi.datingMyListUrl)
    suspend fun datingMyList(@Query("page") currentPage: Int): BaseResponse<MutableList<DatingBean>>

    @GET(HttpApi.datingUrl)
    suspend fun datingDetail(@Query("dating_id") dating_id: Int): BaseResponse<DatingDetailBean>

    @PUT(HttpApi.datingUrl)
    suspend fun datingUpdate(
        @Query("dating_id") dating_id: Int,
        @Query("action") action: String
    ): BaseResponse<Any>

    @FormUrlEncoded
    @POST(HttpApi.datingPublishUrl)
    suspend fun datingPublish(
        @Query("place") place: String?,
        @Query("target") target: String?,
        @Query("date") date: String?,
        @Query("start_date") start_date: String?,
        @Query("activity_type") activity_type: String?,
        @Query("activity_type_id") activity_type_id: String?,
        @Query("cost_type") cost_type: String?,
        @Query("wechat") wechat: String?,
        @Query("content") content: String?,
        @Field("photo_list[]") dating_photo: MutableList<String>?
    ): BaseResponse<Any>

    @POST(HttpApi.datingEnrollsUrl)
    suspend fun datingEnrolls(@Query("dating_id") dating_id: String): BaseResponse<Any>

    @PUT(HttpApi.datingEnrollsUrl)
    suspend fun datingAudit(
        @Query("dating_id") dating_id: Int,
        @Query("id") id: Int,
        @Query("action") action: String
    ): BaseResponse<Any>

    @GET(HttpApi.datingEnrollsListUrl)
    suspend fun datingEnrollsList(
        @Query("page") currentPage: Int,
        @Query("dating_id") dating_id: Int
    ): BaseResponse<MutableList<DatingEnrollsBean>>

    @GET(HttpApi.datingUserEnrollsListUrl)
    suspend fun datingUserEnrollsList(@Query("page") currentPage: Int): BaseResponse<MutableList<DatingBean>>

    @GET(HttpApi.datingCheckCanPublishUrl)
    suspend fun datingCheckCanPublish(): BaseResponse<DatingPublishStatusBean>

    @GET(HttpApi.datingStatisticsUrl)
    suspend fun datingStatistics(): BaseResponse<DatingStaticticsBean>


}