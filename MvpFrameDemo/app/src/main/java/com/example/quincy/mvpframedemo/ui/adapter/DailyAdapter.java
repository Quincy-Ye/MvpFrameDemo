package com.example.quincy.mvpframedemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.mvp.util.ImageUtil;
import com.example.quincy.mvpframedemo.DailyBean;
import com.example.quincy.mvpframedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quincy
 * @Date 2020/2/17
 * @Description
 */

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyHolder> {
    private Context context;
    private List<DailyBean.StoriesBean> beanList;

    public DailyAdapter(Context context) {
        this.context = context;
        beanList = new ArrayList<>();
    }

    public void setBeanList(List<DailyBean.StoriesBean> list) {
        this.beanList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public DailyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DailyHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_daily, parent, false));
    }

    @Override
    public void onBindViewHolder(DailyHolder holder, int position) {
        DailyBean.StoriesBean bean = beanList.get(position);
        holder.tv.setText(bean.getTitle());
        ImageUtil.loadImage(bean.getImages().get(0), holder.iv,
                R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    static class DailyHolder extends RecyclerView.ViewHolder {
        TextView tv;
        NetworkImageView iv;

        DailyHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_daily_tv);
            iv = (NetworkImageView) itemView.findViewById(R.id.item_daily_iv);
        }
    }
}
