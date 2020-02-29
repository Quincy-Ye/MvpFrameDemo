package com.example.quincy.mvpframedemo;

import com.example.mvp.base.MvpListener;
import com.example.mvp.network.MyListener;
import com.example.mvp.network.RequestManager;

import java.util.List;

/**
 * @author Quincy
 * @Date 2020/2/17
 * @Description DailyModel的具体实现，实现网络请求。loadDaily()方法实现监听
 */

public class DailyModelImpl implements DailyContract.DailyModel {

    @Override
    public void loadDaily(String url, final MvpListener<List<DailyBean.StoriesBean>> listener) {
        RequestManager.getInstance().sendGet(url, DailyBean.class, new MyListener<DailyBean>() {
            @Override
            public void onSuccess(DailyBean result) {
                //成功向P层返回数据
                listener.onSuccess(result.getStories());
            }

            @Override
            public void onError(String errorMsg) {
                //失败向P层返回失败信息
                listener.onError(errorMsg);
            }
        });
    }


}
