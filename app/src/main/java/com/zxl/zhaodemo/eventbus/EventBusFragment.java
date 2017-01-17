package com.zxl.zhaodemo.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zxl.zhaodemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author： zhaoxiaolei
 * @date: 2017/1/16 0016
 * @time: 9:00
 * @description: 测试eventbus
 */

public class EventBusFragment extends Fragment {
    @InjectView(R.id.eventbus_fl_tv)
    TextView eventbusFlTv;
    @InjectView(R.id.eventbus_fl_btn)
    Button eventbusFlBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eventbus, container, false);
        ButterKnife.inject(this, view);
        EventBus.getDefault().register(this);
        initView();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    private void initView() {
        eventbusFlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (getArguments().getInt("tag")) {
                    case 1:
                        EventBus.getDefault().post(new EventBusMessage("年会！！！！！！！"));
                        break;
                    case 2:
                        EventBus.getDefault().post(new EventBusMessage("合唱！！！！！！！"));
                        break;
                    case 3:
                        EventBus.getDefault().post(new EventBusMessage("春节！！！！！！！"));
                        break;
                    case 4:
                        EventBus.getDefault().post(new EventBusMessage("工作！！！！！！！"));
                        break;
                }
            }
        });

    }

    /**
     * 准备订阅
     * @param message
     */
    @Subscribe
    public void onEvent(EventBusMessage message){
        eventbusFlTv.setText(message.test);

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
