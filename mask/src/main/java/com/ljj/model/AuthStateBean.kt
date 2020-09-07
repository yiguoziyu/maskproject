package com.ljj.model

data class AuthStateBean(
        var apply_time: String,
        var auth_state: Int,
        var is_pay_authentication_fee: Int,
        var is_video_authentication: Int
)