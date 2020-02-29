package com.example.mvp.network;

/**
 * @author Quincy
 * @Date 2020/2/1
 * @Description 用于数据从 M 到 V 的层间传递。
 */

public interface MyListener<T> {
    void onSuccess(T result);
    void onError(String errorMsg);
}
