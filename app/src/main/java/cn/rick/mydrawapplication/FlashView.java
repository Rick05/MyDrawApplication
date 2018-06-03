package cn.rick.mydrawapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: 嘿嘿抛物线
 * Date  : 2018/6/2
 * Email : easygoingrickking@gmail.com
 * Desc  : 一道闪电
 */
public class FlashView extends View {
    private static final String TAG = "FirstView";

    private Paint mPaint;
    private Path mPath;

    private float mWidth;
    private float mHeight;

    public FlashView(Context context) {
        this(context, null);
    }

    public FlashView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlashView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.moveTo(mWidth / 2, 0);
        mPath.lineTo(mWidth / 4, mHeight / 2 + mWidth / 12);
        mPath.lineTo(mWidth / 2, mHeight / 2 + mWidth / 12);
        mPath.lineTo(mWidth / 2, mHeight);
        mPath.lineTo(mWidth * 3 / 4, mHeight / 2 - mWidth / 12);
        mPath.lineTo(mWidth / 2, mHeight / 2 - mWidth / 12);
        mPath.lineTo(mWidth / 2, 0);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
