package com.zxl.zhaodemo.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.zxl.zhaodemo.BaseActivity1;
import com.zxl.zhaodemo.R;
import com.zxl.zhaodemo.glide.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author: zhaoxiaolei
 * @date: 2017/7/3
 * @time: 14:53
 * @description:
 */

public class ViewPagerActivity extends BaseActivity1 {
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    List<ViewPagerFragment> list;
    @InjectView(R.id.banner)
    Banner banner;
    @InjectView(R.id.image)
    ImageView image;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_viewpager;
    }

    @Override
    protected void initView() {
GlideUtil.getInstance().loadCornerImage(this,image,"https://www.google.com.hk/imgres?imgurl=http%3A%2F%2Fimgs.iaweg.com%2Fpic%2F2NkbnEuZHVpdGFuZy5jb20vdXBsb2Fkcy9pdGVtLzIwMTQxMS8wOS8yMDE0MTEwOTA3MzQyNl9SYUNBVy5qcGVn.jpg&imgrefurl=http%3A%2F%2Fwww.iaweg.com%2Ftupian%2Ff0vxttsllr&docid=ZMlFeckG-aMQFM&tbnid=1_gOL1ZONQu7kM%3A&vet=10ahUKEwiglPXQme_UAhWCE7wKHa9sAJwQMwg8KBEwEQ..i&w=500&h=323&safe=strict&bih=974&biw=1920&q=%E5%9B%BE%E7%89%87&ved=0ahUKEwiglPXQme_UAhWCE7wKHa9sAJwQMwg8KBEwEQ&iact=mrc&uact=8");
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new ViewPagerFragment());
        }
        // 1. viewPager添加parallax效果，使用PageTransformer就足够了
        viewpager.setPageTransformer(false, new CustPagerTransformer(this));
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public Fragment getItem(int position) {
                return list.get(position % 5);
            }


        });
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        List<String> strings = new ArrayList<>();
        strings.add("https://www.google.com.hk/imgres?imgurl=http%3A%2F%2Fimgs.iaweg.com%2Fpic%2F2NkbnEuZHVpdGFuZy5jb20vdXBsb2Fkcy9pdGVtLzIwMTQxMS8wOS8yMDE0MTEwOTA3MzQyNl9SYUNBVy5qcGVn.jpg&imgrefurl=http%3A%2F%2Fwww.iaweg.com%2Ftupian%2Ff0vxttsllr&docid=ZMlFeckG-aMQFM&tbnid=1_gOL1ZONQu7kM%3A&vet=10ahUKEwiglPXQme_UAhWCE7wKHa9sAJwQMwg8KBEwEQ..i&w=500&h=323&safe=strict&bih=974&biw=1920&q=%E5%9B%BE%E7%89%87&ved=0ahUKEwiglPXQme_UAhWCE7wKHa9sAJwQMwg8KBEwEQ&iact=mrc&uact=8");
        strings.add("https://www.google.com.hk/imgres?imgurl=http%3A%2F%2Fimgs.iaweg.com%2Fpic%2F2NkbnEuZHVpdGFuZy5jb20vdXBsb2Fkcy9pdGVtLzIwMTQxMS8wOS8yMDE0MTEwOTA3MzQyNl9SYUNBVy5qcGVn.jpg&imgrefurl=http%3A%2F%2Fwww.iaweg.com%2Ftupian%2Ff0vxttsllr&docid=ZMlFeckG-aMQFM&tbnid=1_gOL1ZONQu7kM%3A&vet=10ahUKEwiglPXQme_UAhWCE7wKHa9sAJwQMwg8KBEwEQ..i&w=500&h=323&safe=strict&bih=974&biw=1920&q=%E5%9B%BE%E7%89%87&ved=0ahUKEwiglPXQme_UAhWCE7wKHa9sAJwQMwg8KBEwEQ&iact=mrc&uact=8");
        strings.add("https://www.google.com.hk/imgres?imgurl=http%3A%2F%2Fimgs.iaweg.com%2Fpic%2F2NkbnEuZHVpdGFuZy5jb20vdXBsb2Fkcy9pdGVtLzIwMTQxMS8wOS8yMDE0MTEwOTA3MzQyNl9SYUNBVy5qcGVn.jpg&imgrefurl=http%3A%2F%2Fwww.iaweg.com%2Ftupian%2Ff0vxttsllr&docid=ZMlFeckG-aMQFM&tbnid=1_gOL1ZONQu7kM%3A&vet=10ahUKEwiglPXQme_UAhWCE7wKHa9sAJwQMwg8KBEwEQ..i&w=500&h=323&safe=strict&bih=974&biw=1920&q=%E5%9B%BE%E7%89%87&ved=0ahUKEwiglPXQme_UAhWCE7wKHa9sAJwQMwg8KBEwEQ&iact=mrc&uact=8");
        strings.add("https://www.google.com.hk/imgres?imgurl=http%3A%2F%2Fimgs.iaweg.com%2Fpic%2F2NkbnEuZHVpdGFuZy5jb20vdXBsb2Fkcy9pdGVtLzIwMTQxMS8wOS8yMDE0MTEwOTA3MzQyNl9SYUNBVy5qcGVn.jpg&imgrefurl=http%3A%2F%2Fwww.iaweg.com%2Ftupian%2Ff0vxttsllr&docid=ZMlFeckG-aMQFM&tbnid=1_gOL1ZONQu7kM%3A&vet=10ahUKEwiglPXQme_UAhWCE7wKHa9sAJwQMwg8KBEwEQ..i&w=500&h=323&safe=strict&bih=974&biw=1920&q=%E5%9B%BE%E7%89%87&ved=0ahUKEwiglPXQme_UAhWCE7wKHa9sAJwQMwg8KBEwEQ&iact=mrc&uact=8");
        banner.isAutoPlay(true);
        banner.setImageUrls(strings);

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void widgetClick(View v) {

    }


}
