package com.ljj.maskproject.http.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ljj.commonlib.model.BaseResponse;
import com.ljj.model.BannedStatusBean;
import com.ljj.model.BlockedBean;
import com.ljj.model.IdentityAvatarResultBean;
import com.ljj.model.PublishDyanmicBean;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

import static com.ljj.commonlib.constants.HttpConfigKt.HTTP_SUC;
import static com.ljj.maskproject.http.api.HttpCodeKt.HTTP_205;
import static com.ljj.maskproject.http.api.HttpCodeKt.HTTP_33;
import static com.ljj.maskproject.http.api.HttpCodeKt.HTTP_40001;
import static com.ljj.maskproject.http.api.HttpCodeKt.HTTP_40002;
import static com.ljj.maskproject.http.api.HttpCodeKt.HTTP_42;
import static com.ljj.maskproject.http.api.HttpCodeKt.HTTP_43;
import static com.ljj.maskproject.http.api.HttpCodeKt.HTTP_45;
import static com.ljj.maskproject.http.api.HttpCodeKt.HTTP_5;
import static com.ljj.maskproject.http.api.HttpCodeKt.HTTP_7;


/**
 * 特殊处理类
 * Created by 一锅子鱼 on 2018/11/19.
 */
public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;
    public GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        //先将返回的json数据解析到Response中，如果code==100，则解析到我们的实体基类中，否则抛异常
        BaseResponse httpResult = gson.fromJson(response, BaseResponse.class);
        //100的时候就直接解析，不可能出现解析异常。因为我们实体基类中传入的泛型，就是数据成功时候的格式
        if (httpResult.getFlag() == HTTP_SUC) {
            //100的时候就直接解析，不可能出现解析异常。因为我们实体基类中传入的泛型，就是数据成功时候的格式
            return gson.fromJson(response, type);
        } else if (httpResult.getFlag() == HTTP_7 ||
                httpResult.getFlag() == HTTP_42 ||
                httpResult.getFlag() == HTTP_43 ||
                httpResult.getFlag() == HTTP_45 ||
                httpResult.getFlag() == HTTP_40001) {
            return gson.fromJson(response, new TypeToken<BaseResponse<Object>>() {
            }.getType());
        } else if (httpResult.getFlag() == HTTP_40002) {
            return gson.fromJson(response, new TypeToken<BaseResponse<BannedStatusBean>>() {
            }.getType());
        } else if (httpResult.getFlag() == HTTP_5) {
            return gson.fromJson(response, new TypeToken<BaseResponse<BlockedBean>>() {
            }.getType());
        } else if (httpResult.getFlag() == HTTP_205) {
            return gson.fromJson(response, new TypeToken<BaseResponse<PublishDyanmicBean>>() {
            }.getType());
        } else if (httpResult.getFlag() == HTTP_33) {
            return gson.fromJson(response, new TypeToken<BaseResponse<IdentityAvatarResultBean>>() {
            }.getType());
        } else {
            //抛一个自定义ResultException 传入失败时候的状态码，和信息
            throw new IGsonException(httpResult.getFlagString());
        }
    }
}
