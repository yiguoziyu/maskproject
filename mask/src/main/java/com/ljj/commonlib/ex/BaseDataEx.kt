package com.ljj.commonlib.ex

/**
 *基本数据 扩展包
 * **/

fun String?.isEmptyOrNull(func: (String) -> Unit) {
    if (!isNullOrEmpty()) {
        func(this!!)
    }
}

fun <T> T?.isNotNull(func: (T) -> Unit) {
    if (this != null) {
        func(this)
    }
}

