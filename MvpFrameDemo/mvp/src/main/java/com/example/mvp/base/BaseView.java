package com.example.mvp.base;

/**
 * @author Quincy
 * @Date 2020/1/31
 * @Description  interface 里的变量和方法都是默认为public abstract
 * 定义三个抽象方法  showLoading();hideLoading();showError();
 */

public interface BaseView {
    void showLoading();
    void hideLoading();
    void showError();

}
