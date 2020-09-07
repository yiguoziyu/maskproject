package com.ljj.lettercircle.model

data class UpdateInfo(
        val is_mandatory: Int,
        val tips_number: String,
        val update_addr: String,
        val new_version: String,
        val update_info: String,
        val need_update: Int
)