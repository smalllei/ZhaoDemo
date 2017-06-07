package com.zxl.zhaodemo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * @author: zhaoxiaolei
 * @date: 2017/5/9
 * @time: 14:07
 * @description:
 */

public class CustomView extends View {

    private Paint mCirclePaint;
    private Paint mTextPaint;
    private Paint mArcPaint;
    private int mCircleX;
    private int mCircleY;
    private RectF mArcRectF;
    private float mStartSweepValue;

    private int mRadius = 50;
    private int mCircleBackground = Color.rgb(255, 0, 0);
    private int mRingColor = Color.rgb(0, 255, 0);
    private int mTextSize = 14;
    private int mTextColor = Color.rgb(255, 255, 255);

    public CustomView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        //圆环开始角度 -90° 正北方向
        mStartSweepValue = -90;

        //设置中心园的画笔
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(mCircleBackground);
        mCirclePaint.setStyle(Paint.Style.FILL);
        //设置文字的画笔
        mTextPaint = new Paint();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setStrokeWidth((float) (0.025 * mRadius));
        mTextPaint.setTextSize(mRadius / 2);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        //设置外圆环的画笔
        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth((float) (0.15 * mRadius));
        //获得文字的字号 因为要设置文字在圆的中心位置
        mTextSize = (int) mTextPaint.getTextSize();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画中间圆
        canvas.drawCircle(mCircleX, mCircleY, mRadius, mCirclePaint);
        //画圆环

//
//        for (int i = 0; i < 255; i++) {
//            mArcPaint.setColor( Color.argb(i,0, 255, 0));
//            canvas.drawArc(mArcRectF, mStartSweepValue +i, i, false, mArcPaint);
//        }

        mArcPaint.setColor(Color.rgb(0, 255, 0));
        canvas.drawArc(mArcRectF, mStartSweepValue, 255, false, mArcPaint);
        mArcPaint.setColor(mTextColor);
        canvas.drawArc(mArcRectF, mStartSweepValue + 255, 105, false, mArcPaint);
        //画文字
        //canvas.drawText(String.valueOf("00") + "%", mCircleX, mCircleY + mTextSize / 4, mTextPaint);
        //判断当前百分比是否小于设置目标的百分比
        if (mStartSweepValue == 270) {
            mStartSweepValue = -90;

        }
        mStartSweepValue += 50;
        postInvalidateDelayed(10);
    }

    //主要是测量wrap_content时候的宽和高，因为宽高一样，只需要测量一次宽即可，高等于宽
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measure(widthMeasureSpec), measure(widthMeasureSpec));
        //设置圆心坐标
        mCircleX = getMeasuredWidth() / 2;
        mCircleY = getMeasuredHeight() / 2;
        //如果半径大于圆心横坐标，需要手动缩小半径的值，否则就画到外面去了
        if (mRadius > mCircleX) {
            //设置半径大小为圆心横坐标到原点的距离
            mRadius = mCircleX;
            mRadius = (int) (mCircleX - 0.15 * mRadius);
            //因为半径改变了，所以要重新设置一下字体宽度
            mTextPaint.setStrokeWidth((float) (0.025 * mRadius));
            //重新设置字号
            mTextPaint.setTextSize(mRadius / 2);
            //重新设置外圆环宽度
            mArcPaint.setStrokeWidth((float) (0.15 * mRadius));
            //重新获得字号大小
            mTextSize = (int) mTextPaint.getTextSize();
        }
        //画中心园的外接矩形，用来画圆环用
        mArcRectF = new RectF(mCircleX - mRadius, mCircleY - mRadius, mCircleX + mRadius, mCircleY + mRadius);
    }

    //当wrap_content的时候，view的大小根据半径大小改变，但最大不会超过屏幕
    private int measure(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = (int) (1.15 * mRadius * 2);
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;

    }
}
