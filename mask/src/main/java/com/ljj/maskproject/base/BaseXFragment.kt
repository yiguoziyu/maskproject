package com.ljj.maskproject.base

import com.ljj.commonlib.base.BaseFragment
import com.ljj.lannotation.PageConfig
import com.ljj.maskproject.dialog.LoadDialog


/**
 * Fragment基类
 */
abstract class BaseXFragment : BaseFragment() {
    private var mLoadDialog: LoadDialog? = null

    private var pageConfig: PageConfig? = null
    private fun getPageConfig() {
        pageConfig = javaClass.getAnnotation(PageConfig::class.java)
    }

    override fun getLayoutId(): Int {
        getPageConfig()
        return pageConfig?.layoutId ?: 0
    }


    open fun showLoadDialog() {
        if (mLoadDialog == null) mLoadDialog = LoadDialog()
        mLoadDialog?.showDialog(requireActivity())
    }

    open fun dismissLoadDialog() {
        mLoadDialog?.dismissDialog()
    }

}