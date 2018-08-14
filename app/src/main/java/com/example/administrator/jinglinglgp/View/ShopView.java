package com.example.administrator.jinglinglgp.View;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.administrator.jinglinglgp.R;
import com.example.administrator.jinglinglgp.Utils.AnimUtil;

/**
 * Created by Administrator on 17/7/1.
 */

public class ShopView extends BaseView {
    private ImageView iv_chongzhi;
    private ImageView iv_figure;
    private FrameLayout fl_btns;
    private FrameLayout fl_ad;
    private AnimationSet figureAnimSet;

    private ChongZhiView chongZhiView;

    public ShopView(Context context) {
        super(context);
        setContentView(R.layout.view_shop);

        initUI();
        figureScaleAnimation();
    }

    private void figureScaleAnimation() {
        figureAnimSet = new AnimationSet(false);//单独的设置了动画的Interpolator动画变化速率
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 0.9f, 1f, 0.9f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);
        scaleAnimation.setDuration(800);
        scaleAnimation.setRepeatCount(Animation.INFINITE);//无限重复
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        figureAnimSet.addAnimation(scaleAnimation);

        TranslateAnimation tranX = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
        tranX.setDuration(300);
        figureAnimSet.addAnimation(tranX);
    }

    @Override
    protected void initUI() {
        chongZhiView = new ChongZhiView(ctx);

        iv_chongzhi = (ImageView) findViewById(R.id.iv_chongzhi);
        AnimUtil.addOnTouchListener(iv_chongzhi, 0.5f, 0.5f, new AnimUtil.AnimListener() {

            @Override
            public void down(View v) {

            }

            @Override
            public void move(View v) {

            }

            @Override
            public void up(View v) {
                chongZhiView.show();
            }
        });

        iv_figure = (ImageView) findViewById(R.id.iv_figure);

        fl_btns = (FrameLayout) findViewById(R.id.fl_btns);
        fl_ad = (FrameLayout) findViewById(R.id.fl_ad);

    }

    public void show() {
//        fromX,toX,fromY,toY
        TranslateAnimation tranUp = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f);
        tranUp.setDuration(300);//设置时间
        fl_ad.startAnimation(tranUp);

        TranslateAnimation tranY = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1f, Animation.RELATIVE_TO_SELF, 0f);
        tranY.setDuration(300);//设置时间
        fl_btns.startAnimation(tranY);
        tranY.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
//                iv_figure.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv_figure.setVisibility(View.VISIBLE);
                iv_figure.startAnimation(figureAnimSet);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void hideFigure(Animation.AnimationListener listener) {
        TranslateAnimation tranY = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1f);
        tranY.setDuration(300);
        fl_btns.startAnimation(tranY);

        TranslateAnimation tranX = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
        tranX.setDuration(300);
        iv_figure.startAnimation(tranX);
        if (listener != null) {
            tranX.setAnimationListener(listener);
        }
        iv_figure.setVisibility(View.INVISIBLE);
    }

}
