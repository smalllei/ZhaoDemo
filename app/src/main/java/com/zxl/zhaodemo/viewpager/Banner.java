package com.zxl.zhaodemo.viewpager;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zxl.zhaodemo.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaoxiaolei
 * @date: 2017/7/4
 * @time: 10:38
 * @description:
 */

public class Banner extends FrameLayout implements ViewPager.OnPageChangeListener {
    public String tag = "banner";
    private Context context;
    private BannerViewPager bannerViewPager;
    private LinearLayout indicator;
    private int mIndicatorWidth;   //指示器圆点大小
    private int mIndicatorHeight;   //
    private int mIndicatorMargin = BannerConfig.PADDING_SIZE;   //  指示器间距
    private int delayTime = BannerConfig.TIME;
    private int scrollTime = BannerConfig.DURATION;
    private boolean isAutoPlay = BannerConfig.IS_AUTO_PLAY;
    private boolean isScroll = BannerConfig.IS_SCROLL;
    private List<String> imageUrls;
    private List<View> imageViews;
    private List<ImageView> indicatorViews;
    private int count;
    private int currentItem;
    private int gravity = -1;
    private OnBannerListener listener;
    private BannerPagerAdapter adapter;
    private WeakHandler handler = new WeakHandler();
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int lastPosition = 1;
    private BannerScroller mScroller;
    private DisplayMetrics dm;
    public Banner(@NonNull Context context) {
        this(context, null);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        imageUrls = new ArrayList<>();
        imageViews = new ArrayList<>();
        indicatorViews = new ArrayList<>();
        initView();
    }

    private void initView() {
        imageViews.clear();
        indicatorViews.clear();
        View view = LayoutInflater.from(context).inflate(R.layout.banner, null, false);
        bannerViewPager = (BannerViewPager) view.findViewById(R.id.bannerViewPager);
        indicator = (LinearLayout) view.findViewById(R.id.indicator);
        dm = context.getResources().getDisplayMetrics();
        mIndicatorHeight = 20;
        mIndicatorWidth = 20;
      //  bannerViewPager.setPageTransformer(true,new CustPagerTransformer(context));
        initViewPagerScroll();
    }
    private void initViewPagerScroll() {
        try {
            Field mField = ViewPager.class.getDeclaredField("mScroller");
            mField.setAccessible(true);
            mScroller = new BannerScroller(bannerViewPager.getContext());
            mScroller.setDuration(scrollTime);
            mField.set(bannerViewPager, mScroller);
        } catch (Exception e) {
            Log.e(tag, e.getMessage());
        }
    }
    public Banner isAutoPlay(boolean isAutoPlay) {
        this.isAutoPlay = isAutoPlay;
        return this;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
        this.count = imageUrls.size();
        start();
    }

    public void update(List<String> imageUrls) {
        this.imageUrls.clear();
        this.imageUrls.addAll(imageUrls);
        this.count = this.imageUrls.size();
        start();
    }

    public Banner start() {
        setImageList(imageUrls);
        setData();
        return this;
    }


    private void setImageList(List<String> imageUrls) {
        if (imageUrls == null || imageUrls.size() <= 0) {
            Log.e(tag, "Please set the images data.");
            return;
        }
        imageViews.clear();
        createIndicator();
        for (int i = 0; i <= count + 1; i++) {
            ImageView imageView = null;

            if (imageView == null) {
                imageView = new ImageView(context);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            String url = null;
            if (i == 0) {
                url = imageUrls.get(count - 1);
            } else if (i == count + 1) {
                url = imageUrls.get(0);
            } else {
                url = imageUrls.get(i - 1);
            }
            imageViews.add(imageView);
            imageView.setImageResource(R.color.colorPrimary);
            //GlideUtil.getInstance().loadCornerImage(context, imageView, url);
        }
    }

    /**
     * 创建指示器
     */
    private void createIndicator() {
        indicatorViews.clear();
        indicator.removeAllViews();
        for (int i = 0; i < count; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(mIndicatorWidth, mIndicatorHeight);
            parms.leftMargin = mIndicatorMargin;
            parms.rightMargin = mIndicatorMargin;
            if (i == 0) {
                imageView.setImageResource(R.drawable.gray_radius);
            } else {
                imageView.setImageResource(R.drawable.white_radius);
            }
            indicatorViews.add(imageView);
            indicator.addView(imageView, parms);

        }
    }

    private void setData() {
        currentItem = 1;
        if (adapter == null) {
            adapter = new BannerPagerAdapter();
            bannerViewPager.addOnPageChangeListener(this);
        }
        bannerViewPager.setAdapter(adapter);
        bannerViewPager.setFocusable(true);
        bannerViewPager.setCurrentItem(1);

        if (isScroll && count > 1) {
            bannerViewPager.setScrollable(true);
        } else {
            bannerViewPager.setScrollable(false);
        }
        if (isAutoPlay)
            startAutoPlay();

    }

    public void startAutoPlay() {
        handler.removeCallbacks(task);
        handler.postDelayed(task, delayTime);
    }

    public void stopAutoPlay() {
        handler.removeCallbacks(task);
    }

    private final Runnable task = new Runnable() {
        @Override
        public void run() {
            if (count > 1 && isAutoPlay) {
                currentItem = currentItem % (count + 1) + 1;
//                Log.i(tag, "curr:" + currentItem + " count:" + count);
                if (currentItem == 1) {
                    bannerViewPager.setCurrentItem(currentItem, false);
                    handler.post(task);
                } else {
                    bannerViewPager.setCurrentItem(currentItem);
                    handler.postDelayed(task, delayTime);
                }
            }
        }
    };


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (isAutoPlay) {
            int action = ev.getAction();
            if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL
                    || action == MotionEvent.ACTION_OUTSIDE) {
                startAutoPlay();
            } else if (action == MotionEvent.ACTION_DOWN) {
                stopAutoPlay();
            }
        }
        return super.dispatchTouchEvent(ev);
    }


    class BannerPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            container.addView(imageViews.get(position));
            View view = imageViews.get(position);

            if (listener != null) {
                view.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.OnBannerClick(toRealPosition(position));
                    }
                });
            }
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    /**
     * 返回真实的位置
     *
     * @param position
     * @return 下标从0开始
     */
    public int toRealPosition(int position) {
        int realPosition = (position - 1) % count;
        if (realPosition < 0)
            realPosition += count;
        return realPosition;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    @Override
    public void onPageSelected(int position) {
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageSelected(position);
        }
        indicatorViews.get((lastPosition-1+count)%count).setImageResource(R.drawable.white_radius);
        indicatorViews.get((position-1+count)%count).setImageResource(R.drawable.gray_radius);
        lastPosition=position;
        if (position==0){
            position=count;
        }
        if (position>count){
            position=1;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageScrollStateChanged(state);
        }
        currentItem = bannerViewPager.getCurrentItem();
        switch (state) {
            case 0:  //没有动作
                if (currentItem == 0) {
                    //不显示切换
                    bannerViewPager.setCurrentItem(count, false);
                } else if (currentItem == count + 1) {
                    bannerViewPager.setCurrentItem(1, false);
                }
                break;
            case 1:  //开始滑动
                if (currentItem == count + 1) {
                    bannerViewPager.setCurrentItem(1, false);
                } else if (currentItem == 0) {
                    bannerViewPager.setCurrentItem(count, false);
                }
                break;
            case 2://滑动结束

                break;
        }

    }
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        mOnPageChangeListener = onPageChangeListener;
    }
    /**
     * 废弃了旧版接口，新版的接口下标是从1开始，同时解决下标越界问题
     *
     * @param listener
     * @return
     */
    public Banner setOnBannerListener(OnBannerListener listener) {
        this.listener = listener;
        return this;
    }
    public void releaseBanner() {
        handler.removeCallbacksAndMessages(null);
    }
}
