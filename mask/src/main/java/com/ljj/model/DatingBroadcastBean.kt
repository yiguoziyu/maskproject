package com.ljj.model

data class DatingBroadcastBean(val id: String,
                               val create_time: String,
                               val user_id: String,
                               val avatar: String,
                               val nick_name: String="",
                               val pre_tip: String = "",
                               val end_tip: String = "",
                               val type: Int)