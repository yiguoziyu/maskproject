package com.ljj.maskproject.dialog

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.ljj.commonlib.base.BaseDialog
import com.ljj.maskproject.R

/**
 * Created by 一锅子鱼 on 2018/12/10.
 */
class VipTipDialog : BaseDialog() {
    private var mDialogButtonClick: DialogButtonClick? = null
    private var mContent: String? = null

    fun initConfig(content: String?, mDialogButtonClick: DialogButtonClick?): VipTipDialog {
        this.mContent = content
        this.mDialogButtonClick = mDialogButtonClick
        return this
    }

    override fun getLayoutId(): Int {
        return R.layout.dialog_tip
    }

    override fun initViewData(mView: View) {
        mView.findViewById<Button>(R.id.dialog_cancel).setOnClickListener { dismiss() }
        mView.findViewById<TextView>(R.id.dialog_tip).apply {
            text = mContent ?: ""
        }
        mView.findViewById<Button>(R.id.dialog_sure)
            .setOnClickListener { mDialogButtonClick?.positiveButtonClick();dismiss() }
    }

}