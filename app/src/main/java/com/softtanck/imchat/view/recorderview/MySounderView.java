package com.softtanck.imchat.view.recorderview;


import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import com.softtanck.imchat.utils.SoundMeter;

/**
 * Create By Tanck. 2015/7/15
 */
public class MySounderView extends TextView {

    /**
     * 是否按下
     */
    private boolean isPressed;

    /**
     * 是否取消[包含手指移除视图外部]
     */
    private boolean isCancled;

    /**
     * 是否双击
     */
    private boolean isDoubleClicked;

    private boolean isClicked;

    /**
     * 默认延时
     */
    private int DEFALUT_TIME = 500;

    private int mHeight;
    private int mWidth;

    /**
     * 上一次按下的时间
     */
    private long oldTime;

    /**
     * 当前的时间
     */
    private long currentTime;

    /**
     * 录音
     */
    private SoundMeter msounder;

    /**
     * 接口
     */
    private OnRecordListener listener;

    public void setOnRecordListener(OnRecordListener listener) {
        this.listener = listener;
    }

    private String fileSrc;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (0x1 == msg.what && !isDoubleClicked && !isClicked) {
                Log.d("Tanck", "开始录音");
                fileSrc = String.valueOf(System.currentTimeMillis());
                if (null != listener)
                    listener.onStartRecord(fileSrc);
                msounder.start(fileSrc);
            }
            isClicked = false;
        }

        ;
    };

    public MySounderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    public MySounderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MySounderView(Context context) {
        this(context, null);
    }

    private void initView() {
        msounder = new SoundMeter(getContext());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mHeight = getMeasuredHeight();
        mWidth = getMeasuredWidth();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        if (isCancled && action == MotionEvent.ACTION_MOVE) {
            msounder.stop();
            return false;
        }

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (isPressed) {
                    currentTime = System.currentTimeMillis();
                    if (DEFALUT_TIME > (currentTime - oldTime)) {
                        Log.d("Tanck", "click");
                        isDoubleClicked = true;
                        msounder.stop();
                        oldTime = currentTime;
                        return false;
                    }
                }
                oldTime = System.currentTimeMillis();
                isCancled = false;
                isPressed = true;
                isDoubleClicked = false;
                Log.d("Tanck", "DOWN");
                mHandler.sendEmptyMessageDelayed(0x1, 1000);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("Tanck", "MOVE");
                if (event.getY() < 0) {
                    Log.d("Tanck", "Over");
                    msounder.stop();
                    isCancled = true;
                    if (null != listener)
                        listener.onEndRecord(fileSrc);
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (1000 > (System.currentTimeMillis() - oldTime))
                    isClicked = true;
                else
                    isClicked = false;
                if (!isCancled) {
                    Log.d("Tanck", "UP");
                    if (null != listener)
                        listener.onEndRecord(fileSrc);
                    msounder.stop();
                }
                break;
        }
        return true;
    }

    /**
     * 录音接口
     *
     * @author Administrator
     */
    public interface OnRecordListener {

        /**
         * 开始录音的时候
         */
        public void onStartRecord(String fileSrc);

        /**
         * 结束录音的时候
         */
        public void onEndRecord(String fileSrc);
//
//        /**
//         * 快速点击的时候
//         */
//        public void onQuickClik();

    }

}
