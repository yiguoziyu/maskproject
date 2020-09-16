package com.ljj.lettercircle.model

import com.ljj.lettercircle.util.bucket.BucketFile

data class BucketUpLoadBean( var state: BucketFile,var url: String, var postion: Int?=null)