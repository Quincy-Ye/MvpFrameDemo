package com.example.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.example.mvp.util.ToastUtil;

/**
 * @author Quincy
 * @Date 2020/2/16
 * @Description
 * 定义两个抽象方法 getLayoutId()和initView()方法
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());  //设置页面
        initView();
    }

    protected abstract int getLayoutId();
    protected abstract void initView();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override//按返回键
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return checkBackAction() || super.onKeyDown(keyCode, event);
    }
    //双击退出相关
    private boolean mFlag = false;
    private long mTimeout = -1;
    private boolean checkBackAction() {
        long time = 3000L;//判定时间设为3秒
        boolean flag = mFlag;
        mFlag = true;
        boolean timeout = (mTimeout == -1 || (System.currentTimeMillis() - mTimeout) > time);
        if (mFlag && (mFlag != flag || timeout)) {
            mTimeout = System.currentTimeMillis();
            ToastUtil.showToast("再点击一次回到桌面");
            return true;
        }
        return !mFlag;
    }
}