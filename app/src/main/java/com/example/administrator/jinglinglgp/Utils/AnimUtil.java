package com.example.administrator.jinglinglgp.Utils;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/**
 * Created by Administrator on 2017/6/30.
 */

public class AnimUtil {
    public static final String PROPERTY_TRANSLATIONY = "translationY";//垂直位移
    public static final String PROPERTY_TRANSLATIONX = "translationX";//水平位移
    public static final String PROPERTY_ALPHA = "alpha";//透明度
    public static final String PROPERTY_SCALEX = "scaleX";//水平缩放比
    public static final String PROPERTY_SCALEY = "scaleY";//垂直缩放比
    public static final String PROPERTY_ROTATIONX = "rotationX";//水平旋转
    public static final String PROPERTY_ROTATIONY = "rotationY";//垂直旋转
    public static final String PROPERTY_BACKGROUNDCOLOR = "backgroundColor";

    public interface AnimListener {
        void down(View v);

        void move(View v);

        void up(View v);
    }

    //创建属性动画
    public static void addObjectAnimation(View v, String[] proName, float... values) {
        final int len = proName.length;
        //PropertyValuesHolder 多属性的动画同时工作管理类。
        PropertyValuesHolder[] holders = new PropertyValuesHolder[len];

        PropertyValuesHolder holder = null;
        for (int i = 0; i < len; i++) {
            //ofFloat就是说里面的数可以是浮点型
            holder = PropertyValuesHolder.ofFloat(proName[i], values);
            holders[i] = holder;
        }

        ObjectAnimator.ofPropertyValuesHolder(v, holders).setDuration(200).start();
    }

    //    overload addOnTouchListener
    public static void addOnTouchListener(View v, final String[] proName, final float[] downValues, final float[] upValues, final AnimListener listener) {
        if (proName == null) {
            return;
        }

        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //获取当前事件的状态
                int action = event.getAction();
                switch (action) {
//                    初次触摸
                    case MotionEvent.ACTION_DOWN:
                        Log.i("HomeActivity", "down");
                        addObjectAnimation(v, proName, downValues);

                        if (listener != null) {
                            listener.down(v);
                        }
                        break;
//                    普通移动
                    case MotionEvent.ACTION_MOVE:
                        Log.i("HomeActivity", "move");
                        if (listener != null) {
                            listener.move(v);
                        }
                        break;
//                    抬起移走
                    case MotionEvent.ACTION_UP:
                        Log.i("HomeActivity", "up");
                        addObjectAnimation(v, proName, upValues);

                        if (listener != null) {
                            listener.up(v);
                        }
                        break;
                }
                //false只响应一次,true响应所有状态，按下，按住移动，松开，多个手指
                return true;
            }
        });
    }

    /*
    * android中提供了4中动画：
        AlphaAnimation 透明度动画效果
        ScaleAnimation 缩放动画效果
        TranslateAnimation 位移动画效果
        RotateAnimation 旋转动画效果
    * */

    //    添加缩放动画
    public static void addScaleAnimation(View v, float fromX, float toX, float fromY, float toY, final float pvalueX, final float pvalueY) {
        ScaleAnimation scale = new ScaleAnimation(fromX, toX, fromY, toY,
                Animation.RELATIVE_TO_SELF, pvalueX, Animation.RELATIVE_TO_SELF, pvalueY);
        scale.setDuration(200);//设置持续时间
        scale.setFillAfter(true);//保持动画执行完的状态
        v.startAnimation(scale);
    }

    //overload addOnTouchListener
    public static void addOnTouchListener(View v, final float pvalueX, final float pvalueY, final AnimListener listener) {
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //获取当前事件的状态
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("HomeActivity", "down");
                        addScaleAnimation(v, 1f, 0.75f, 1f, 0.75f, pvalueX, pvalueY);

                        if (listener != null) {
                            listener.down(v);
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.i("HomeActivity", "move");
                        if (listener != null) {
                            listener.move(v);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i("HomeActivity", "up");
                        addScaleAnimation(v, 0.75f, 1f, 0.75f, 1f, pvalueX, pvalueY);

                        if (listener != null) {
                            listener.up(v);
                        }
                        break;
                }

                return true;//false只响应一次,true响应所有状态，按下，按住移动，松开，多个手指
            }
        });
    }
}
