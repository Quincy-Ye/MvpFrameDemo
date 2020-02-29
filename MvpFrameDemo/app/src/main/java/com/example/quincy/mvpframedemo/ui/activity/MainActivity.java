package com.example.quincy.mvpframedemo.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvp.base.BaseMvpActivity;
import com.example.quincy.mvpframedemo.Api;
import com.example.quincy.mvpframedemo.DailyBean;
import com.example.quincy.mvpframedemo.DailyContract;
import com.example.quincy.mvpframedemo.DailyModelImpl;
import com.example.quincy.mvpframedemo.DailyPresenterImpl;
import com.example.quincy.mvpframedemo.R;
import com.example.quincy.mvpframedemo.ui.adapter.DailyAdapter;

import java.util.List;

/**
 * @author Quincy
 * @Date 2020/2/17
 * @Description
 * V层，实现上层的抽象方法。
 */

public class MainActivity extends BaseMvpActivity<DailyPresenterImpl, DailyModelImpl>
        implements DailyContract.DailyView {
    private DailyAdapter adapter;

    //获得layout
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    //初始化界面，主要是找到控件
    @Override
    protected void initView() {
        adapter = new DailyAdapter(this);
        RecyclerView rcv = findViewById(R.id.ac_main_rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setHasFixedSize(true);
        rcv.setAdapter(adapter);
    }

    //重写BaseMvpActivity中的方法loadData(),调用DailyPresentImpl中的loadData()
    @Override
    protected void loadData() {
        mPresenter.loadData(Api.DAILY_LATEST);
    }

    @Override
    public void setData(List<DailyBean.StoriesBean> beanList) {
        adapter.setBeanList(beanList);
    }
}
