package com.zxl.zhaodemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.common.base.Preconditions;
import com.zxl.zhaodemo.calendar.RiliActivity;
import com.zxl.zhaodemo.callsmsobserver.CallActivity;
import com.zxl.zhaodemo.databinding.TestDatabindingActivity;
import com.zxl.zhaodemo.design.DesginCeActivity;
import com.zxl.zhaodemo.design.StickyNavLayoutActivity;
import com.zxl.zhaodemo.dialog.DialogActivity;
import com.zxl.zhaodemo.eventbus.EventBusActivity;
import com.zxl.zhaodemo.permissions.PermissionsManager;
import com.zxl.zhaodemo.permissions.PermissionsResultAction;
import com.zxl.zhaodemo.recyclerview.RvActivity;
import com.zxl.zhaodemo.rxjava.RxMainActivity;
import com.zxl.zhaodemo.updataimage.UpDataImageActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.main_lv)
    ListView mainLv;
    @InjectView(R.id.activity_main)
    RelativeLayout activityMain;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(this, new PermissionsResultAction() {
            @Override
            public void onGranted() {

            }

            @Override
            public void onDenied(String permission) {

            }
        });
        ButterKnife.inject(this);
        initView();

    }

    private void initView() {

        List<String> title = new ArrayList<>();
        title.add("eventbus");
        title.add("stickyNavLayout");
        title.add("desgin侧滑");
        title.add("rxDemo");
        title.add("recycleview");
        title.add("可标记日历");
        title.add("图片上传");
        title.add("DataBinding");
        title.add("call");
        title.add("dialog");
        final List<Class> activities = new ArrayList<>();
        activities.add(EventBusActivity.class);
        activities.add(StickyNavLayoutActivity.class);
        activities.add(DesginCeActivity.class);
        activities.add(RxMainActivity.class);
        activities.add(RvActivity.class);
        activities.add(RiliActivity.class);
        activities.add(UpDataImageActivity.class);
        activities.add(TestDatabindingActivity.class);
        activities.add(CallActivity.class);
        activities.add(DialogActivity.class);

        mainLv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, title));
        mainLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,activities.get(position));
                startActivity(intent);

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionsManager.getInstance().notifyPermissionsChange(permissions,grantResults);
    }
}
