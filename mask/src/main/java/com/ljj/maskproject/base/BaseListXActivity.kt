package com.ljj.maskproject.base

import androidx.recyclerview.widget.RecyclerView
import com.ljj.commonlib.jectpack.paging.BaseListInterface
import com.ljj.commonlib.jectpack.paging.PAGE_FIRST
import com.ljj.commonlib.ui.recyclerview.adapter.BaseListAdpater
import com.ljj.maskproject.R
import com.ljj.maskproject.view.StateLayout
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener
import kotlinx.android.synthetic.main.base_listx.*

abstract class BaseListXActivity : BaseViewActivity(), BaseListInterface {
    companion object {
        private const val TAG = "BaseListXActivity"
    }

    var mPage = PAGE_FIRST
    private var rvRefreshlayout: SmartRefreshLayout? = null
    private var rvStatelayout: StateLayout? = null

    //是否支持刷新
    private var mEnableRefresh = true

    //是否支持加载更多
    private var mEnableLoad = true

    override fun getLayoutId(): Int {
        return R.layout.base_listx
    }

    open fun bindRefreshLayout(): SmartRefreshLayout? = rv_refreshlayout
    open fun bindStateLayout(): StateLayout? = rv_statelayout
    override fun initData() {
        rvRefreshlayout = bindRefreshLayout()
        rvStatelayout = bindStateLayout()
        rvRefreshlayout?.setOnMultiPurposeListener(object : SimpleMultiPurposeListener() {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                super.onRefresh(refreshLayout)
                onRefresh(mEnableRefresh, mEnableLoad)
            }

            override fun onLoadMore(refreshLayout: RefreshLayout) {
                super.onLoadMore(refreshLayout)
                onLoad()
            }
        })
    }

    /**
     * 新增数据
     */
    override fun <T> addData(adpater: BaseListAdpater<T>, index: Int, data: T) {
        adpater.addData(index, data)
        checkDataEmpty(adpater.dataList)
    }

    /**
     * 新增数据
     */
    override fun <T> addData(adpater: BaseListAdpater<T>, data: T) {
        adpater.addData(data)
        checkDataEmpty(adpater.dataList)
    }

    /**
     * 删除数据
     */
    override fun <T> removeData(adpater: BaseListAdpater<T>, data: T) {
        val index = adpater.dataList.indexOf(data)
        if (index >= 0) {
            adpater.removeData(data)
        }
        checkDataEmpty(adpater.dataList)
    }


    /**
     * 根据集合设置View
     */
    override fun <T> checkDataEmpty(dataList: MutableList<T>) {
        if (dataList.size == 0) {
            rvStatelayout?.showEmptyView()
        } else {
            rvStatelayout?.showContentView()
        }
    }

    /**
     * 刷新所有数据
     */
    override fun <T> setDataNotify(adpater: BaseListAdpater<T>, dataList: MutableList<T>) {
        checkDataEmpty(dataList)
        adpater.setData(dataList)
    }

    /**
     * 设置数据不需要分页数据
     */
    fun <T> setDataNoUsePage(adpater: BaseListAdpater<T>, dataList: MutableList<T>) {
        rvRefreshlayout?.finishRefresh()
        if (dataList.size == 0) {
            rvStatelayout?.showEmptyView()
        } else {
            adpater.setData(dataList)
            rvStatelayout?.showContentView()
        }
        rvRefreshlayout?.finishLoadMoreWithNoMoreData()
    }

    /**
     * 设置数据
     */
    override fun <T> setData(
        adpater: BaseListAdpater<T>,
        dataList: MutableList<T>,
        rv: RecyclerView?
    ) {
        if (mPage == PAGE_FIRST) {
            rvRefreshlayout?.finishRefresh()
            if (dataList.size == 0) {
                rvStatelayout?.showEmptyView()
                rvRefreshlayout?.finishLoadMoreWithNoMoreData()
            } else {
                adpater.setData(dataList)
                rv?.scrollToPosition(0)
                rvStatelayout?.showContentView()
            }
        } else {
            if (dataList.size != 0) {
                adpater.addData(dataList)
                rvRefreshlayout?.finishLoadMore()
            } else {
                rvRefreshlayout?.finishLoadMoreWithNoMoreData()
            }
        }
    }

    /**
     * 设置嵌套的数据
     */
    override fun <T> setMultipleData(adpater: BaseListAdpater<T>, dataList: MutableList<T>) {
        if (mPage == PAGE_FIRST) {
            if (dataList.size == 0) {
                rvStatelayout?.showEmptyView()
                rvRefreshlayout?.finishLoadMoreWithNoMoreData()
            } else {
                adpater.setMultipleData(dataList)
                rvStatelayout?.showContentView()
            }
            rvRefreshlayout?.finishRefresh()
        } else {
            if (dataList.size != 0) {
                adpater.addData(dataList)
                rvRefreshlayout?.finishLoadMore()
            } else {
                rvRefreshlayout?.finishLoadMoreWithNoMoreData()
            }
        }
    }

    private fun onLoad() {
        mPage++
        onLoadData()
    }

    override fun onRefresh(enableRefresh: Boolean, enableLoad: Boolean) {
        mPage = PAGE_FIRST
        mEnableRefresh = enableRefresh
        mEnableLoad = enableLoad
        rvRefreshlayout?.scrollTo(0, 0)
        if (mEnableLoad) {
            rvRefreshlayout?.setEnableLoadMore(true)
        }
        if (mEnableRefresh) {
            rvRefreshlayout?.setEnableRefresh(true)
        }
        onLoadData()
    }

    override fun onLoadData() {

    }


    override fun onRefreshWithAnimator() {
        rvRefreshlayout?.autoRefresh()
    }


}