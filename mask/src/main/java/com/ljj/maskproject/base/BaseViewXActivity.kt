package com.ljj.maskproject.base


import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.ljj.commonlib.util.StatusBarUtil
import com.ljj.lannotation.PageConfig
import com.ljj.maskproject.R
//import com.ljj.lettercircel.viewmodels.persistences.FiltrateBeanPersistenceViewModel
//import com.ljj.lettercircle.R
//import com.ljj.lettercircle.helper.PageHelper
//import com.ljj.lettercircle.helper.handlerAll
//import com.ljj.lettercircle.persistence.helper.Injection
import com.ljj.maskproject.dialog.LoadDialog
//import com.ljj.lettercircle.ui.viewmodels.global.AppGlobalViewModel
//import com.ljj.maskproject.viewmodels.persistence.AccountPersistenceViewModel
//import com.ljj.lettercircle.ui.viewmodels.persistence.LoginBeanPersistenceViewModel
//import com.ljj.maskproject.viewmodels.request.ConfigViewModel
import com.umeng.analytics.MobclickAgent

abstract class BaseViewXActivity : BaseIMXActivity() {
    private var mLoadDialog: LoadDialog? = null
    private val rightTvId = R.id.toolbar_right_tv
    private val titleId = R.id.toolbar_title
    private val toolbarId = R.id.base_toolbar
    private val rightImgId = R.id.toolbar_right_img
    private val leftImgId = R.id.toolbar_back

    private var pageConfig: PageConfig? = null
//    val mFiltrateBeanPersistenceViewModel by viewModels<FiltrateBeanPersistenceViewModel>()
//    val mAccountPersistenceViewModel by viewModels<AccountPersistenceViewModel> { Injection.provideViewModelFactory(this) }
//    val mLoginBeanPersistenceViewModel by viewModels<LoginBeanPersistenceViewModel> { Injection.provideLoginViewModelFactory(this) }
//    val mConfigViewModel by viewModels<ConfigViewModel>()
    private var mUserId = ""
    private var mUserName = ""
    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        initSystemBarTinit()
        prepareData(savedInstanceState)
        pageConfig?.let {
            if (it.title.isNotEmpty()) {
                initTitle(it.title)
            }
        }
        initBaseViewModel()
        startListModel()

    }

    fun openPersonDetailPage(userId: String?) {
//        userId?.let {
//            mUserId = it
//            mConfigViewModel.checkCanView(it)
//        }

    }


    private fun initBaseViewModel() {
//        mConfigViewModel.apply {
//            checkCanViewLiveData.observe(this@BaseViewXActivity, Observer {
//                PageHelper.openPersonDetailPage(this@BaseViewXActivity, it)
//            })
//
//            logOffLiveData.observe(this@BaseViewXActivity, Observer {
//                PageHelper.loginOffReady()
//            })
//        }.handlerAll(this)
//        AppGlobalViewModel.apply {
//            getLogOutLiveData().observe(this@BaseViewXActivity, Observer {
//                mAccountPersistenceViewModel.deleteAllAccounts()
//                mFiltrateBeanPersistenceViewModel.remove()
//                PageHelper.loginOut(this@BaseViewXActivity)
//            })
//            getLogOffLiveData().observe(this@BaseViewXActivity, Observer {
//                mLoginBeanPersistenceViewModel.deleteAllLoginBeans()
//                mFiltrateBeanPersistenceViewModel.remove()
//                PageHelper.loginOff(this@BaseViewXActivity)
//            })
//
//        }

    }

    override fun onResume() {
        super.onResume()
        MobclickAgent.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        MobclickAgent.onPause(this)
    }

    private fun getPageConfig() {
        pageConfig = javaClass.getAnnotation(PageConfig::class.java)
    }

    override fun getLayoutId(): Int {
        getPageConfig()
        return pageConfig?.layoutId ?: 0
    }

    open fun showLoadDialog() {
        if (mLoadDialog == null) mLoadDialog = LoadDialog()
        mLoadDialog?.showDialog(this)
    }

    open fun dismissLoadDialog() {
        mLoadDialog?.dismissDialog()
    }

    open fun initEmptyTitle(): BaseViewXActivity {
        initToolbar()
        return this
    }

    open fun initSimpleTitle(mTitle: String? = null): BaseViewXActivity {
        initToolbar().initCenterTitle { mTitle?.let { text = it } }
        return this
    }

    open fun initTitle(mTitle: String? = null,
                       isFirstInit: Boolean? = null): BaseViewXActivity {
        initToolbar(isFirstInit = isFirstInit)
                .initLeftBack { setOnClickListener { finish() } }
                .initCenterTitle { mTitle?.let { text = it } }
        return this
    }

    open fun initToolBarStatusBar(baseToolbar: Toolbar) {
        StatusBarUtil.immersiveStatusBar(this)
        StatusBarUtil.addHeightAndPadding(this, baseToolbar)
        StatusBarUtil.setStatusBarDarkMode(this)
    }

    /***设置中心Title***/
    open fun initCenterTitle(func: TextView.() -> Unit): BaseViewXActivity {
        findViewById<TextView>(titleId).func()
        return this
    }

    /***设置BaseToolbar***/
    open fun initToolbar(isFirstInit: Boolean? = null): BaseViewXActivity {
        if (isFirstInit == null) {
            initToolbar {
                title = ""
                setSupportActionBar(this)
                supportActionBar?.setDisplayShowTitleEnabled(false)
            }
        }
        return this
    }

    /***设置Toolbar***/
    open fun initToolbar(func: Toolbar.() -> Unit): BaseViewXActivity {
        val toolBar = findViewById<Toolbar>(toolbarId)
        toolBar.func()
        initToolBarStatusBar(toolBar)
        return this
    }

    /***设置右侧Text按钮***/
    open fun initRightTvBack(rightTvFunc: TextView.() -> Unit): BaseViewXActivity {
        val tv = findViewById<TextView>(rightTvId)
        tv.visibility = View.VISIBLE
        tv.rightTvFunc()
        findViewById<ImageView>(rightImgId).visibility = View.GONE
        return this
    }

    /***设置右侧Image按钮***/
    open fun initRightImgBack(rightImgFunc: ImageView.() -> Unit): BaseViewXActivity {
        val img = findViewById<ImageView>(rightImgId)
        img.visibility = View.VISIBLE
        img.rightImgFunc()
        findViewById<TextView>(rightTvId).visibility = View.GONE
        return this
    }

    /***设置左侧Image按钮***/
    open fun initLeftBack(leftImgFunc: ImageView.() -> Unit): BaseViewXActivity {
        findViewById<ImageView>(leftImgId).leftImgFunc()
        return this
    }


    open fun prepareData(savedInstanceState: Bundle?) {

    }

    open fun startListModel() {

    }


}