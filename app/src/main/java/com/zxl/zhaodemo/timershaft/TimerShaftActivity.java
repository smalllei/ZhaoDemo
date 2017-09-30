package com.zxl.zhaodemo.timershaft;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zxl.zhaodemo.BaseActivity1;
import com.zxl.zhaodemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author: zhaoxiaolei
 * @date: 2017/9/26
 * @time: 13:48
 * @description: 时间轴
 */

public class TimerShaftActivity extends BaseActivity1 {
    @InjectView(R.id.earning_recycler)
    RecyclerView lv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_earning;
    }

    @Override
    protected void initView() {
        String a="隔壁老王通过了一个朋友的加微信申请，收获5元（新手引导奖鼓励）";
        List<String>  strings=new ArrayList<>();
        strings.add("隔壁老王通过了一个朋友的加微信申请，收获5元（新手引导奖鼓励）");
        strings.add("隔壁老王通过了一个朋友的加微信申请，收获5元（新手引导奖鼓励）,隔壁老王通过了一个朋友的加微信申请，收获5元（新手引导奖鼓励）");
        strings.add(a+a+a);
        strings.add(a+a);
        strings.add(a);
        strings.add(a+a+a);
        strings.add(a+a);
        strings.add(a);
        strings.add(a+a+a);
        strings.add(a+a);
        strings.add(a);
        View view= LayoutInflater.from(this).inflate(R.layout.item_earning_head,null);
        View view1= LayoutInflater.from(this).inflate(R.layout.item_earning_head,null);
        lv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter=new MyAdapter(strings);
       lv.setAdapter(adapter);
        adapter.setmHeaderView(view);
        adapter.setmFooterView(view1);


    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void widgetClick(View v) {

    }



class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    public static final int TYPE_HEADER = 0;  //说明是带有Header的
    public static final int TYPE_FOOTER = 1;  //说明是带有Footer的
    public static final int TYPE_NORMAL = 2;  //说明是不带有header和footer的
    private List<String> strings;

    public MyAdapter(List<String>  strings){
        this.strings=strings;
    }

    public View getmHeaderView() {
        return mHeaderView;
    }

    public void setmHeaderView(View mHeaderView) {
        this.mHeaderView = mHeaderView;
        notifyItemInserted(0);
    }

    public View getmFooterView() {
        return mFooterView;
    }

    public void setmFooterView(View mFooterView) {
        this.mFooterView = mFooterView;
        notifyItemInserted(getItemCount()-1);
    }

    private View mHeaderView;
    private View mFooterView;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView !=null && viewType==TYPE_HEADER)
            return new ViewHolder(mHeaderView);
        if (mFooterView!=null&& viewType==TYPE_FOOTER)
            return new ViewHolder(mFooterView);
        return new ViewHolder(LayoutInflater.from(TimerShaftActivity.this).inflate(R.layout.item_earning,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (getItemViewType(position)==TYPE_NORMAL){
            if (holder instanceof ViewHolder){
                //这里加载数据的时候要注意，是从position-1开始，因为position==0已经被header占用了
                holder.tv.setText(strings.get(position-1));
            }
            return;
        }else {
            return;
        }

    }

    @Override
    public int getItemCount() {
        if (mFooterView==null&&mHeaderView==null)
        return strings.size();
        else if (mHeaderView==null&&mFooterView!=null)
            return strings.size()+1;
        else if (mHeaderView!=null&&mFooterView==null)
            return strings.size()+1;
        else
            return strings.size()+2;
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView==null&&mFooterView==null)
            return TYPE_NORMAL;
        if (position==0)
            return TYPE_HEADER;
        if (position==getItemCount()-1)
            return TYPE_FOOTER;
        return TYPE_NORMAL;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            if (itemView==mFooterView)
                return;
            if (itemView==mHeaderView)
                return;
            tv= (TextView) itemView.findViewById(R.id.time_tv);
        }
    }
}

}
