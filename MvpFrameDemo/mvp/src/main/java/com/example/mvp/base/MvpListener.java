package com.example.mvp.base;

/**
 * @author Quincy
 * @Date 2020/2/16
 * @Description
 */

public interface MvpListener<T> {
    void onSuccess(T result);
    void onError(String errorMsg);
}
