package com.ljj.maskproject.http.manager


import retrofit2.http.*


private const val PLATFORM = "android"

open class ApiRepository() {
    private fun http(): ApiSuspendService = RetrofitSuspendManager.getService()

    //-----------------------------------------Coupon---------------------------------------------//
    suspend fun autoGift() = http().autoGift()

    /***获取我所有的优惠券***/
    suspend fun getCouponList(@Query("status") status: String) = http().getCouponList(status)
    //-----------------------------------------share---------------------------------------------//
    /***获取提现相关信息***/
    suspend fun withdrawInfo() = http().withdrawInfo()

    /***修改提现账号***/
    suspend fun withdrawAccount(
        @Query("account") account: String?,
        @Query("real_name") real_name: String?
    ) = http().withdrawAccount(account, real_name)

    /***分享相关信息接口***/
    suspend fun shareInfo() = http().shareInfo()

    /***邀请相关信息获取***/
    suspend fun invite() = http().invite()

    /***用户提现***/
    suspend fun withdraw(@Query("amount") amount: String) = http().withdraw(amount)

    /****用户提现列表***/
    suspend fun withdrawList(@Query("page") currentPage: Int) = http().withdrawList(currentPage)

    /***邀请收入列表***/
    suspend fun inviteIncomeList(@Query("page") currentPage: Int) =
        http().inviteIncomeList(currentPage)

    //-----------------------------------------common---------------------------------------------//
    suspend fun getBannerList() = http().getBannerList()

    suspend fun getBaseConfig() = http().getBaseConfig()

    suspend fun searchCondition() = http().searchCondition()

    suspend fun getUserSimpleInfo(@Query("search_user_id") targetId: String) =
        http().getUserSimpleInfo(targetId)

    suspend fun careUser(@Query("care_user_id") userId: String) = http().careUser(userId)

    suspend fun careUserDelete(@Query("care_user_id") userId: String) =
        http().careUserDelete(userId)

    suspend fun userWechat(@Query("to_user_id") to_user_id: String) = http().userWechat(to_user_id)


    suspend fun getMyCareList(@Query("page") currentPage: Int) = http().getMyCareList(currentPage)

    suspend fun getCareMeList(@Query("page") currentPage: Int) = http().getCareMeList(currentPage)


    suspend fun logout(@Query("is_normal") is_normal: String) = http().logout(is_normal)

    suspend fun uploadLogFile(@Query("log") fileUrl: String) = http().uploadLogFile(fileUrl)

    suspend fun blackHouse(@Query("page") currentPage: Int) = http().blackHouse(currentPage)

    suspend fun punishmentBanner() = http().punishmentBanner()

    suspend fun logOff(remark: String?) = http().logOff("注销账号", remark)

    suspend fun setDistanceShow(@Query("status") status: String?) = http().setDistanceShow(status)

    suspend fun addToBlacklist(userId: String) = http().addToBlacklist(userId)

    suspend fun removeFromBlacklist(userId: String) = http().removeFromBlacklist(userId)
    //-----------------------------------------report---------------------------------------------//

    suspend fun feedback(
        @Query("content") feedback_content: String,
        @Query("contact_way") phone: String,
        @Field("photo_list[]") feedback_photo: MutableList<String>
    ) = http().feedback(feedback_content, phone, feedback_photo)

    suspend fun complain(
        @Query("content") feedback_content: String,
        @Query("contact_way") phone: String,
        @Field("photo_list[]") feedback_photo: MutableList<String>
    ) = http().complain(feedback_content, phone, feedback_photo)

    suspend fun reported(
        @Query("target_user_id") userId: String,
        @Query("content") content: String?,
        @Query("type") type: String?,
        @Field("photo_list[]") photos: MutableList<String>?
    ) = http().reported(userId, content, type, photos)

    suspend fun suggestion(
        @Query("content") feedback_content: String,
        @Query("contact_way") phone: String,
        @Field("photo_list[]") feedback_photo: MutableList<String>
    ) = http().suggestion(feedback_content, phone, feedback_photo)


    //-----------------------------------------auth---------------------------------------------//
    suspend fun getBucketConfig() = http().getBucketConfig()

    suspend fun authenticationInfoG2() = http().authenticationInfoG2()


    suspend fun videoAuthenticationG2(
        @Query("auth_vod_url") auth_vod_url: String?,
        @Query("avatar") avatar: String?,
        @Query("auth_img_url") auth_img_url: String?
    ) = http().videoAuthenticationG2(auth_vod_url, avatar, auth_img_url)


    suspend fun videoAuthentication(@Query("auth_vod_url") authVodUrl: String) =
        http().videoAuthentication(authVodUrl)

    suspend fun authenticationAuditStatus() = http().authenticationAuditStatus()

    suspend fun videoAuthenticationNew(
        @Query("avatar") avatar: String?,
        @Query("auth_vod_url") auth_vod_url: String?,
        @Field("auth_img_url[]") auth_img_url: MutableList<String?>? = null
    ) = http().videoAuthenticationNew(avatar, auth_vod_url, auth_img_url)

    suspend fun authenticationInfo() = http().authenticationInfo()


    //-----------------------------------------pay---------------------------------------------//

    suspend fun getPayType(@Query("type") type: String) = http().getPayType(type)

    suspend fun recharge(
        @Query("recg_id") goodId: Int,
        @Query("pyed_way") pay_way: String,
        @Query("platform") platform: String
    ) = http().recharge(goodId, pay_way, platform)

    suspend fun recgWithCoupon(recg_id: String, pyed_way: String, coupon_id: String?) = http().recgWithCoupon(recg_id, pyed_way, PLATFORM, coupon_id)


    suspend fun getPayTypeNew(type: String) = http().getPayTypeNew(type)

    suspend fun recharge(goodId: Int, pay_way: String) = http().recharge(goodId, pay_way, PLATFORM)
    //-----------------------------------------login-------------------------------------------- -//
    suspend fun visitorHome(
        @Query("sex") sex: Int,
        @Query("page") currentPage: Int
    ) = http().visitorHome(sex, currentPage)

    suspend fun visitorHomePage(@Query("h_user_id") uId: String?) = http().visitorHomePage(uId)

    suspend fun visitorDynamics(
        @Query("h_user_id") uId: String,
        @Query("page") currentPage: Int
    ) = http().visitorDynamics(uId, currentPage)

    suspend fun checkPhone(@Query("phone") phone: String) = http().checkPhone(phone)

    suspend fun sendSmsCode(
        @Query("phone") phone: String,
        @Query("action") action: String, ticket: String?, randStr: String?
    ) = http().sendSmsCode(phone, action, ticket, randStr)

    suspend fun register(
        @Query("phone") phone: String,
        @Query("sms_code") smsCode: String,
        @Query("platform") platform: String,
        @Query("password") password: String
    ) = http().register(phone, smsCode, platform, password)

    suspend fun register(phone: String, smsCode: String) = http().register(phone, smsCode, PLATFORM, phone)
    suspend fun loginByWx(
        @Query("unionid") unionid: String,
        @Query("openid") openid: String,
        @Query("access_token") access_token: String
    ) = http().loginByWx(PLATFORM, unionid, openid, access_token)

    suspend fun loginByFast(@Query("accessToken") accessToken: String?) =
        http().loginByFast(accessToken)

    suspend fun loginBySmsCode(
        @Query("phone") phone: String,
        @Query("sms_code") smsCode: String
    ) = http().loginBySmsCode(phone, smsCode)

    suspend fun updateUserProperty(@Query("property") property: String) =
        http().updateUserProperty(property)

    suspend fun perfectUserInfo(
        @Query("birthday") birthday: String?,
        @Query("location") location: String?,
        @Query("province") province: String?,
        @Query("annual_income") annual_income: String?,
        @Query("type") type: String?
    ) = http().perfectUserInfo(birthday, location, province, annual_income, type)

    suspend fun supplementaryUserInfo(
        @Query("avatar") avatar: String,
        @Query("nick") nick: String?,
        @Query("height") height: String?,
        @Query("wechat") wechat: String?
    ) = http().supplementaryUserInfo(avatar, nick, height, wechat)


    //-----------------------------------------account---------------------------------------------//
    suspend fun getUserInfo() = http().getUserInfo()

    suspend fun setResidentCity(citys: MutableList<String>) = http().setResidentCity(citys)

    suspend fun updateUserSex(@Query("sex") sex: String) = http().updateUserSex(sex)

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
    ) = http().updateUserInfo(
        nick,
        avatar,
        sex,
        birthday,
        location,
        signature,
        photo,
        photos,
        height,
        profession,
        annual_income,
        wechat
    )

    suspend fun updateUserPhoto(@Field("photos[]") photos: MutableList<String>?) =
        http().updateUserPhoto(photos)

    suspend fun getRecentVisitor(@Query("page") currentPage: Int) =
        http().getRecentVisitor(currentPage)

    suspend fun getLabel() = http().getLabel()

    suspend fun updateLabel(@QueryMap labelList: HashMap<String, String>) =
        http().updateLabel(labelList)

    suspend fun cloaking(state: Int) = http().cloaking(state)
    //-----------------------------------------home---------------------------------------------//

    suspend fun getHomePageData(
        @Query("name") action: String,
        @Query("page") currentPage: Int,
        @Query("age") age: String?,
        @Query("sex") sex: String?,
        @Query("annual_income") annual_income: String?,
        @Query("city") city: String?,
        @Query("sort") sort: String?
    ) = http().getHomePageData(action, currentPage, age, sex, annual_income, city, sort)

    suspend fun getPersionDeatil(@Query("h_user_id") userId: String?) =
        http().getPersionDeatil(userId)

    suspend fun impression(userId: String?) = http().impression(userId)

    suspend fun setImpression(userId: String?, id: Int) = http().setImpression(userId, id)
    //-----------------------------------------message---------------------------------------------//

    suspend fun checkCanInitiateChat(@Query("to_user_id") targetId: String?) =
        http().checkCanInitiateChat(targetId)

    suspend fun broadcastList(currentPage: Int) = http().broadcastList(currentPage)
    //-----------------------------------------dynamic---------------------------------------------//

    suspend fun getDynamicsList(
        @Query("page") currentPage: Int,
        @Query("other_user_id") userId: String?,
        @Query("type") type: Int?
    ) = http().getDynamicsList(currentPage, userId, type)

    suspend fun getDynamicsCareList(@Query("page") currentPage: Int) =
        http().getDynamicsCareList(currentPage)

    suspend fun dynamicsPraise(@Query("dynamics_id") dynamics_id: String) =
        http().dynamicsPraise(dynamics_id)

    suspend fun dynamicsPraiseDel(@Query("dynamics_id") dynamics_id: String) =
        http().dynamicsPraiseDel(dynamics_id)

    suspend fun dynamicsPublish(
        @Query("content") dynamics_content: String,
        @Field("photo_list[]") dynamics_photo: MutableList<String>
    ) = http().dynamicsPublish(dynamics_content, dynamics_photo)

    suspend fun dynamicsDelete(@Query("dynamics_id") dynamics_id: String) =
        http().dynamicsDelete(dynamics_id)

    suspend fun dynamicsMyList(@Query("page") currentPage: Int) = http().dynamicsMyList(currentPage)
    suspend fun dynamicsPublish(
        @Query("content") dynamics_content: String,
        @Field("photo_list[]") dynamics_photo: MutableList<String>,
        @Query("publish_city") city: String?
    ) = http().dynamicsPublish(dynamics_content, dynamics_photo, city)

    suspend fun dynamicsVideoPublish(
        @Query("content") content: String?,
        @Query("cover_url") cover_url: String?,
        @Query("video_url") video_url: String?,
        @Query("publish_city") city: String?

    ) = http().dynamicsVideoPublish(content, cover_url, video_url,city)

    suspend fun canPublish() = http().canPublish()

    suspend fun dynamicDetail(dynamicId: String) = http().dynamicDetail(dynamicId)


    //-----------------------------------------dating---------------------------------------------//
    suspend fun datingList(
        @Query("page") currentPage: Int,
        @Query("sex") mSex: Int,
        @Query("activity_type_id") activity_type_id: String?,
        @Query("place") place: String?
    ) = http().datingList(currentPage, mSex, activity_type_id, place)

    suspend fun datingMyList(@Query("page") currentPage: Int) = http().datingMyList(currentPage)

    suspend fun datingDetail(@Query("dating_id") dating_id: Int) = http().datingDetail(dating_id)

    suspend fun datingUpdate(
        @Query("dating_id") dating_id: Int,
        @Query("action") action: String
    ) = http().datingUpdate(dating_id, action)

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
    ) = http().datingPublish(
        place,
        target,
        date,
        start_date,
        activity_type,
        activity_type_id,
        cost_type,
        wechat,
        content,
        dating_photo
    )

    suspend fun datingEnrolls(dating_id: String) = http().datingEnrolls(dating_id)

    suspend fun datingAudit(
        @Query("dating_id") dating_id: Int,
        @Query("id") id: Int,
        @Query("action") action: String
    ) = http().datingAudit(dating_id, id, action)

    suspend fun datingEnrollsList(
        @Query("page") currentPage: Int,
        @Query("dating_id") dating_id: Int
    ) = http().datingEnrollsList(currentPage, dating_id)

    suspend fun datingUserEnrollsList(@Query("page") currentPage: Int) =
        http().datingUserEnrollsList(currentPage)

    suspend fun datingCheckCanPublish() = http().datingCheckCanPublish()

    suspend fun datingStatistics() = http().datingStatistics()
}