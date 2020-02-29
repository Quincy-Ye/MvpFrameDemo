package com.example.mvp.base;

import java.lang.ref.WeakReference;

/**
 * @author Quincy
 * @Date 2020/1/31
 * @Description
 */

public abstract class BasePresenter<M,V> {
    //可以被同一包中的所有类和不同包中的子类访问
    protected M mModel;
    protected WeakReference<V> mViewRef;//这里采用弱引用，避免内存泄漏


    protected void onAttach(M model, V view) {
        mModel = model;
        mViewRef = new WeakReference<>(view);
    }
    //检查mViewRef是否创建成功，为在具体的P层提供getView接口，m不用是，因为v是活动有生命周期，可能会被销毁
    protected V getView() {
        return isViewAttached() ? mViewRef.get() : null;
    }

    protected boolean isViewAttached() {
        return null != mViewRef && null != mViewRef.get();
    }

    //解绑，避免内存泄漏
    protected void onDetach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
