package com.ljj.maskproject.http.config;

import com.google.gson.Gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by 一锅子鱼 on 2018/11/19.
 */
public class IGsonConverterFactory extends Converter.Factory{
    public static IGsonConverterFactory create() {
        return create(new Gson());
    }


    public static IGsonConverterFactory create(Gson gson) {
        return new IGsonConverterFactory(gson);
    }

    private final Gson gson;

    private IGsonConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        //返回我们自定义的Gson响应体变换器
        return new GsonResponseBodyConverter<>(gson, type);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        //返回我们自定义的Gson响应体变换器
        return new GsonResponseBodyConverter<>(gson,type);
    }


}
