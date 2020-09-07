package com.ljj.maskproject.http.manager

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.ljj.commonlib.base.BaseApplication
import com.ljj.maskproject.http.api.HttpApi
import com.ljj.maskproject.http.config.HeaderInterceptor
import com.ljj.maskproject.http.config.IGsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.net.Proxy
import java.util.concurrent.TimeUnit

/***Retrofit管理器***/
object RetrofitSuspendManager {
    ///初始化配置
    fun getService(): ApiSuspendService =
        initRetrofit(
            initOkHttpClient(),
            BaseApplication.baseUrl
        ).create(ApiSuspendService::class.java)

    ///初始化okhttp
    private fun initOkHttpClient(): OkHttpClient {
//        var cacheDirectory =
//            File(BaseApplication.application.cacheDir?.absolutePath + "responses")//新建一个文件用来缓存网络请求
        return OkHttpClient.Builder()
            .connectTimeout(HttpApi.timeout, TimeUnit.SECONDS)//设置连接超时
            .readTimeout(HttpApi.timeout, TimeUnit.SECONDS)//设置从主机读信息超时
            .writeTimeout(HttpApi.timeout, TimeUnit.SECONDS)//设置写信息超时
            .addInterceptor(HeaderInterceptor().getLogInterceptor())
            .proxy(Proxy.NO_PROXY)
//                .cache(Cache(cacheDirectory, 10 * 1024 * 1024))//会造成file rename
            .build()
    }

    ///初始化Retrofit
    private fun initRetrofit(client: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(ScalarsConverterFactory.create())//如果网络访问返回的字符串，而不是json数据格式，要使用下面的转换器
            .addConverterFactory(IGsonConverterFactory.create())//如果网络访问返回的是json字符串，使用gson转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//此处顺序不能和上面对调，否则不能同时兼容普通字符串和Json格式字符串  为了支持rxjava,需要添加下面这个把 Retrofit 转成RxJava可用的适配类
            .baseUrl(baseUrl)
            .build()
    }

}