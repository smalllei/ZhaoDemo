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
 * @date: 2017/7/18
 * @time: 9:27
 * @description:
 */

public class DrawImageView extends View {

    private Paint paint;
    private Context context;
    private static final int RED = 226, GREEN = 135, BLUE = 5; //基础颜色，这里是橙红色
    private float width; //自定义view的宽度
    private float height; //自定义view的高度
    private float raduis; //自定义view的最大半径

    public double getAngel() {
        return angel;
    }

    public void setAngel(double angel) {
        this.angel = angel;
        postInvalidate();
    }

    private double angel=270;

    //圆环颜色
    private static int[] doughnutColors = new int[]{
            Color.argb(255, RED, GREEN, BLUE),
            Color.argb(120, RED, GREEN, BLUE),
            Color.argb(120, RED, GREEN, BLUE)};

    public DrawImageView(Context context) {
        super(context);
        paint = new Paint();
        this.context = context;

    }

    public DrawImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        this.context = context;

    }

    public DrawImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        resetParams();

        //将画布中心设为原点(0,0), 方便后面计算坐标
        canvas.translate(width / 2, height / 2);

        //画灰色圆环
        float doughnutWidth = raduis * 0.10f;//圆环宽度
        RectF rectF1 = new RectF(-raduis*0.8f  , -raduis*0.8f , raduis*0.8f , raduis*0.8f);
        initPaint();
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.argb(255, 193, 193, 193));
        // paint.setShader(new SweepGradient(0, 0, doughnutColors, null));
        canvas.drawArc(rectF1, 0, 360, false, paint);
        //圆环外接矩形

        RectF rectF = new RectF(-raduis*0.8f  , -raduis*0.8f , raduis*0.8f , raduis*0.8f);
        initPaint();
        paint.setStrokeWidth(doughnutWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.argb(255, RED, GREEN, BLUE));
       // paint.setShader(new SweepGradient(0, 0, doughnutColors, null));
        canvas.drawArc(rectF, -90, 270, false, paint);
        //画旋起点圆
        initPaint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.argb(255, RED, GREEN, BLUE));
        canvas.drawCircle((float) (raduis*0.8*Math.sin(0.0)),(float) (-raduis*0.8*Math.cos(0.0)), doughnutWidth / 2, paint);
        //画终点圆
        initPaint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.argb(255, RED, GREEN, BLUE));
        canvas.drawCircle((float) (raduis*0.8*Math.sin(2*Math.PI/360*angel)),(float) (-raduis*0.8*Math.cos(2*Math.PI/360*angel)), doughnutWidth / 2, paint);
       // canvas.rotate(-90, 0, 0);   //旋转画布
        super.onDraw(canvas);

    }
    private void resetParams() {
        width = getWidth();
        height = getHeight();
        raduis = Math.min(width, height)/2;
    }
    private void initPaint() {
        paint.reset();
        paint.setAntiAlias(true);
    }

    /* 根据手机的分辨率从 dp 的单位 转成为 px(像素) */
    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
