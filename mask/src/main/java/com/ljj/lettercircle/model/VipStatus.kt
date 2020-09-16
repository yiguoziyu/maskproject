package com.ljj.lettercircle.model

sealed class VipStatus(val msg:String) {
    class SUCCESS(msg: String=""):VipStatus(msg)
    class FAILED(msg: String=""):VipStatus(msg)
    class CANCEL(msg: String=""):VipStatus(msg)
}