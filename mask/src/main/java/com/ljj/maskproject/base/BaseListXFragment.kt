package com.ljj.maskproject.base

import androidx.recyclerview.widget.RecyclerView
import com.ljj.commonlib.jectpack.paging.PAGE_FIRST
import com.ljj.commonlib.ui.recyclerview.adapter.BaseListAdpater
import com.ljj.maskproject.R
import com.ljj.maskproject.view.StateLayout
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener
import kotlinx.android.synthetic.main.base_listx.*

abstract class BaseListXFragment : BaseXFragment() {
    var mPage = PAGE_FIRST
    private var rvRefreshlayout: SmartRefreshLayout? = null
    private var rvStatelayout: StateLayout? = null

    open fun bindRefreshLayout(): SmartRefreshLayout? = rv_refreshlayout
    open fun bindStateLayout(): StateLayout? = rv_statelayout


    override fun getLayoutId(): Int {
        return R.layout.base_listx
    }
    override fun initData() {
        rvRefreshlayout = bindRefreshLayout()
        rvStatelayout = bindStateLayout()
        rvRefreshlayout?.setOnMultiPurposeListener(object : SimpleMultiPurposeListener() {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                super.onRefresh(refreshLayout)
                onRefresh()
            }

            override fun onLoadMore(refreshLayout: RefreshLayout) {
                super.onLoadMore(refreshLayout)
                onLoad()
            }
        })
    }

    /**
     * 处理拉黑回调
     */
    open fun handlerViewModel(addFunc: () -> Unit = {}, removeFunc: () -> Unit = {}) {
//        mConfigViewModel.apply {
//            addToBlacklist.observe(viewLifecycleOwner, Observer {
//                ToastHelper.showToast("拉黑成功")
//                addFunc()
//            })
//            removeFromBlacklist.observe(viewLifecycleOwner, Observer {
//                ToastHelper.showToast("取消成功")
//                removeFunc()
//            })
//
//        }.handlerAll(requireActivity())
    }

    /**
     * 新增数据
     */
    fun <T> addData(adpater: BaseListAdpater<T>, index: Int, data: T) {
        adpater.addData(index, data)
        checkDataEmpty(adpater.dataList)
    }

    /**
     * 新增数据
     */
    fun <T> addData(adpater: BaseListAdpater<T>, data: T) {
        adpater.addData(data)
        checkDataEmpty(adpater.dataList)
    }

    /**
     * 删除数据
     */
    fun <T> removeData(adpater: BaseListAdpater<T>, data: T) {
        val index = adpater.dataList.indexOf(data)
        if (index >= 0) {
            adpater.removeData(data)
        }
        checkDataEmpty(adpater.dataList)
    }


    /**
     * 根据集合设置View
     */
    fun <T> checkDataEmpty(dataList: MutableList<T>) {
        if (dataList.size == 0) {
            rvStatelayout?.showEmptyView()
        } else {
            rvStatelayout?.showContentView()
        }
    }

    /**
     * 刷新所有数据
     */
    fun <T> setDataNotify(adpater: BaseListAdpater<T>, dataList: MutableList<T>) {
        checkDataEmpty(dataList)
        adpater.setData(dataList)
    }

    /**
     * 设置数据
     */
    fun <T> setData(adpater: BaseListAdpater<T>, dataList: MutableList<T>, rv: RecyclerView? = null) {
        if (mPage == PAGE_FIRST) {
            if (dataList.size == 0) {
                rvStatelayout?.showEmptyView()
            } else {
                adpater.setData(dataList)
                rv?.scrollToPosition(0)
                rvStatelayout?.showContentView()
            }
            rvRefreshlayout?.finishRefresh()
        } else {
            if (dataList.size != 0) {
                adpater.addData(dataList)
            }
            rvRefreshlayout?.finishLoadMore()
        }
    }

    /**
     * 设置嵌套的数据
     */
    fun <T> setMultipleData(adpater: BaseListAdpater<T>, dataList: MutableList<T>) {
        if (mPage == PAGE_FIRST) {
            if (dataList.size == 0) {
                rvStatelayout?.showEmptyView()
            } else {
                adpater.setMultipleData(dataList)
                rvStatelayout?.showContentView()
            }
            rvRefreshlayout?.finishRefresh()
        } else {
            if (dataList.size != 0) {
                adpater.addData(dataList)
            }
            rvRefreshlayout?.finishLoadMore()
        }
    }

    private fun onLoad() {
        mPage++
        onLoadData()
    }

    fun onRefresh() {
        mPage = PAGE_FIRST
        rvRefreshlayout?.scrollTo(0, 0)
        onLoadData()
    }

    fun onRefreshWithAnimator() {
        rvRefreshlayout?.autoRefresh()
    }

    open fun onLoadData() {

    }


}