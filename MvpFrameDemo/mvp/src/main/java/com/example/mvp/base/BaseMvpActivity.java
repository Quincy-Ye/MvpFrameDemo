package com.example.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.mvp.util.ReflectUtil;

/**
 * @author Quincy
 * @Date 2020/2/16
 * @Description 继承BaseActivity 将M层和V层捆绑起来，并在生命周期结束时解绑，避免内存泄漏
 * 并且添加一个loadData()方法。不放在BaseActivity是因为并非所有Activity都要加载数据
 */

public abstract class BaseMvpActivity
        <T extends BasePresenter, M extends BaseModel> extends BaseActivity {
    protected T mPresenter;
    protected M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = ReflectUtil.getT(this, 0);
        mModel = ReflectUtil.getT(this, 1);
        mPresenter.onAttach(mModel, this); //将m层和v层捆绑起来
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData();
    }

    protected abstract void loadData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }
}