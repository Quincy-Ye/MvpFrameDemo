package com.example.quincy.mvpframedemo;

import com.example.mvp.base.BaseModel;
import com.example.mvp.base.BasePresenter;
import com.example.mvp.base.BaseView;
import com.example.mvp.base.MvpListener;

import java.util.List;

/**
 * @author Quincy
 * @Date 2020/2/17
 * @Description 类爆炸解决方案，便于查找和管理接口。添加每一层具体需要什么方法。
 */

public interface DailyContract {
    interface DailyModel extends BaseModel {
        void loadDaily(String url, MvpListener<List<DailyBean.StoriesBean>> listener);
    }

    interface DailyView extends BaseView {
        void setData(List<DailyBean.StoriesBean> beanList);
    }

    abstract class DailyPresenter extends BasePresenter<DailyModel, DailyView> {
        protected abstract void loadData(String url);
    }
}

