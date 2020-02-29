package com.example.quincy.mvpframedemo;

import com.example.mvp.base.MvpListener;

import java.util.List;

/**
 * @author Quincy
 * @Date 2020/2/17
 * @Description DailyP层的具体实现
 */

public class DailyPresenterImpl extends DailyContract.DailyPresenter {
    //loadData 来源于
    @Override
    public void loadData(String url) {
        final DailyContract.DailyView mView = getView();
        if (mView == null) {
            return;
        }

        mView.showLoading();
        //当调用loadDaily的时候，先去子层(DailyModelImpl)
        // 找具体实现(如果没有重写就往上一层找一直找到具体实现)
        mModel.loadDaily(url, new MvpListener<List<DailyBean.StoriesBean>>() {
            //成功拿到M层传上来的数据，通过mView体现到V层
            @Override
            public void onSuccess(List<DailyBean.StoriesBean> result) {
                mView.hideLoading();
                mView.setData(result);
            }

            @Override
            public void onError(String errorMsg) {
                mView.hideLoading();
                mView.showError();
            }
        });
    }
}
