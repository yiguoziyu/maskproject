package com.ljj.maskproject.dialog

abstract class DialogButtonClick {
    open fun positiveButtonClick() {}
    open fun negativeButtonClick() {}
}
abstract class DialogOptionClick{
    open fun dialogOptionClick(postion:Int){}
}