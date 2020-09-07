package com.ljj.maskproject.dialog

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import com.ljj.maskproject.R


/**
 * Created by 一锅子鱼 on 2018/8/21.
 */
class LoadDialog : DialogFragment() {
    var isShow = false

    companion object {
        fun getInstance() = LoadDialog()
    }


    fun showDialog(mActivity: Activity?) {
        try {
            if (!isShow) {
                isShow = true
                show(mActivity?.fragmentManager, "loaddialog")
            }
        } catch (e: Exception) {

        }
    }
    override fun show(manager: android.app.FragmentManager?, tag: String?) {
        try {
            //在每个add事务前增加一个remove事务，防止连续的add
            manager?.beginTransaction()?.remove(this)?.commitAllowingStateLoss()
            super.show(manager, tag)
        } catch (e: Exception) {
            //同一实例使用不同的tag会异常,这里捕获一下
            e.printStackTrace()
        }
    }
    fun dismissDialog() {
        if (isShow) {
            isShow = false
            dismissAllowingStateLoss()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var mView = LayoutInflater.from(activity).inflate(R.layout.dialog_progress, null)
        var mDialog = AlertDialog.Builder(activity).setView(mView)
        return mDialog.create()
    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.setOnKeyListener { dialogInterface, keyCode, keyEvent ->
            keyCode == KeyEvent.KEYCODE_BACK
        }
    }
}