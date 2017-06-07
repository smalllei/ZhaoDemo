package com.zxl.zhaodemo.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zxl.zhaodemo.R;


/**
 * @author: zhaoxiaolei
 * @date: 2017/6/7
 * @time: 10:25
 * @description:
 */

public class TestDatabindingActivity  extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final TestBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_test_data);
        binding.setTest(new TestData("Jack","Tom",true));
        binding.setEvent(new TestEvent(this));
        binding.setIsZxl(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    binding.setTest(new TestData(null,"Jack",false));
                    binding.setIsZxl(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
