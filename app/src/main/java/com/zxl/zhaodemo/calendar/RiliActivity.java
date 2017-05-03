package com.zxl.zhaodemo.calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zxl.zhaodemo.BaseActivity;
import com.zxl.zhaodemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * @author: zhaoxiaolei
 * @date: 2017/4/25
 * @time: 12:05
 * @description: 日历
 */

public class RiliActivity extends BaseActivity {
    @InjectView(R.id.rili_toolbar)
    Toolbar riliToolbar;
    @InjectView(R.id.txt_select_month)
    TextView txtSelectMonth;
    @InjectView(R.id.img_select_last_month)
    ImageButton imgSelectLastMonth;
    @InjectView(R.id.img_select_next_month)
    ImageButton imgSelectNextMonth;
    @InjectView(R.id.rili_calendarView)
    CalendarView riliCalendarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rili);
        ButterKnife.inject(this);
        riliToolbar.setTitle("日历");
        List<String> kexuan = new ArrayList<>();
        kexuan.add("20170425");
        kexuan.add("20170426");
        kexuan.add("20170427");
        kexuan.add("20170428");
        final List<String> yixuan = new ArrayList<>();
        yixuan.add("20170420");
        yixuan.add("20170421");
        yixuan.add("20170422");
        yixuan.add("20170423");
        riliCalendarView.setSelectedDates(yixuan);
        riliCalendarView.setOptionalDate(kexuan);
        txtSelectMonth.setText(riliCalendarView.getDate());
        riliCalendarView.setOnClickDate(new CalendarView.OnClickListener() {
            @Override
            public void onClickDateListener(int year, int month, int day) {
                String s;
                if (month < 10) {
                    s = year + "0" + month + "" + day + "";
                } else {
                    s = year + "" + month + "" + day + "";
                }

                if (yixuan.contains(s)) {
                    showToastShort(s);
                } else {
                    showToastShort("暂无事件");
                }
            }
        });
    }

    @OnClick({R.id.img_select_last_month, R.id.img_select_next_month})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_select_last_month:
                riliCalendarView.setLastMonth();
                txtSelectMonth.setText(riliCalendarView.getDate());
                break;
            case R.id.img_select_next_month:
                riliCalendarView.setNextMonth();
                txtSelectMonth.setText(riliCalendarView.getDate());
                break;
        }
    }
}
