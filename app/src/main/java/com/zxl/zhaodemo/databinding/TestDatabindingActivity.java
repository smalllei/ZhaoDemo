package com.zxl.zhaodemo.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;

import com.zxl.zhaodemo.R;


/**
 * @author: zhaoxiaolei
 * @date: 2017/6/7
 * @time: 10:25
 * @description:
 */

public class TestDatabindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText editText=new EditText(this);

        final TestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_test_data);
        binding.setTest(new TestData("Jack", "Tom", true));
        binding.setEvent(new TestEvent(this));
        binding.setIsZxl(true);
        final ObservableArrayMap<String, String> user = new ObservableArrayMap<>();
        user.put("firstName", "Connor");
        user.put("lastName", "Lin");
        user.put("age", "28");
        binding.setUser(user);
        binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                IncludeBinding includeBinding = DataBindingUtil.bind(inflated);
                includeBinding.setTest(new TestData("Doctor", "James", false));
            }
        });
       // binding.viewStub.getViewStub().inflate();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    binding.setIsZxl(false);
                    user.put("firstName", "Tom");
                    user.put("lastName", "Jack");
                    user.put("age", "18");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
