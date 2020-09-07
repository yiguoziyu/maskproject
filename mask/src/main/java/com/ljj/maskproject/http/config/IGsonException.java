package com.ljj.maskproject.http.config;

import java.io.IOException;

/**
 * Created by 一锅子鱼 on 2018/11/19.
 */
public class IGsonException extends IOException {
    // 提供无参数的构造方法
    public IGsonException() {
    }

    // 提供一个有参数的构造方法，可自动生成
    public IGsonException(String message) {
        super(message);// 把参数传递给Throwable的带String参数的构造方法
    }

    public IGsonException(int code,String message){

    }
}
