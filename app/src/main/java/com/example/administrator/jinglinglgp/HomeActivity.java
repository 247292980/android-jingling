package com.example.administrator.jinglinglgp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.administrator.jinglinglgp.Adapter.ViewPagerAdapter;
import com.example.administrator.jinglinglgp.Utils.AnimUtil;
import com.example.administrator.jinglinglgp.View.BeiBaoView;
import com.example.administrator.jinglinglgp.View.HomeView;
import com.example.administrator.jinglinglgp.View.ShopView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private ImageView iv_message;
    private ImageView iv_home;
    private ImageView iv_shop;
    private FrameLayout fl_beibao;
    private FrameLayout fl_fold;
    private LinearLayout ll_sub_btns;
    private ViewPager vp_content;
    private RelativeLayout rl_root;

    private ProgressBar pb_timer_l;

    private List<View> viewList;

    private ShopView shopView;
    private BeiBaoView beiBaoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initUI();
        updateTimer();
        initViewPagerAdapter();
    }

    private void initViewPagerAdapter() {
        viewList = new ArrayList<View>();
        HomeView homeView = new HomeView(this);
        shopView = new ShopView(this);

        viewList.add(homeView.getView());
        viewList.add(shopView.getView());

        ViewPagerAdapter adapter = new ViewPagerAdapter(this, viewList);
        vp_content.setAdapter(adapter);
    }

    private void updateTimer() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    int progress = pb_timer_l.getProgress();
                    if (progress == 100) {
                        progress = -10;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pb_timer_l.setProgress(progress + 10);
                }

            }
        }.start();
    }

    private void initUI() {

        rl_root = (RelativeLayout) findViewById(R.id.rl_root);
        vp_content = (ViewPager) findViewById(R.id.vp_content);

        //禁止滑动
        vp_content.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        iv_message = (ImageView) findViewById(R.id.iv_message);
        AnimUtil.addOnTouchListener(iv_message, 0f, 0f, null);

        iv_home = (ImageView) findViewById(R.id.iv_home);
        AnimUtil.addOnTouchListener(iv_home, 0.5f, 1f, animListener);

        fl_beibao = (FrameLayout) findViewById(R.id.fl_beibao);
        AnimUtil.addOnTouchListener(fl_beibao, 0.5f, 1f, animListener);

        fl_fold = (FrameLayout) findViewById(R.id.fl_fold);
        String[] proNames = new String[]{AnimUtil.PROPERTY_SCALEX, AnimUtil.PROPERTY_SCALEY};
        AnimUtil.addOnTouchListener(fl_fold, proNames,
                new float[]{1f, 0.75f}, new float[]{0.75f, 1f}, animListener);

        ll_sub_btns = (LinearLayout) findViewById(R.id.ll_sub_btns);

        pb_timer_l = (ProgressBar) findViewById(R.id.pb_timer_l);

        iv_shop = (ImageView) findViewById(R.id.iv_shop);
        AnimUtil.addOnTouchListener(iv_shop, 0.5f, 1f, animListener);

        beiBaoView = new BeiBaoView(this);
    }

    private AnimUtil.AnimListener animListener = new AnimUtil.AnimListener() {
        boolean isDown;

        @Override
        public void down(View v) {
        }

        @Override
        public void move(View v) {
        }

        @Override
        public void up(View v) {
            switch (v.getId()) {
                case R.id.iv_home:
                    Log.i("HomeActivity", "home");
                    addAnimationListener(iv_home);
                    break;
                case R.id.fl_fold:
                    int subHeight = ll_sub_btns.getHeight() - 52;
                    if (isDown) {
                        AnimUtil.addObjectAnimation(v, new String[]{AnimUtil.PROPERTY_TRANSLATIONY, AnimUtil.PROPERTY_ROTATIONX,
                                AnimUtil.PROPERTY_ROTATIONY}, 0f);
//                        这是动画的实现下面是直接换背景
                        AnimUtil.addObjectAnimation(v, new String[]{AnimUtil.PROPERTY_ROTATIONX,
                                AnimUtil.PROPERTY_ROTATIONY}, 180f, 0f);
//                        fl_fold.setBackgroundResource(R.mipmap.btn_expand);
                        AnimUtil.addObjectAnimation(ll_sub_btns, new String[]{AnimUtil.PROPERTY_TRANSLATIONY}, 0f);
                    } else {
                        AnimUtil.addObjectAnimation(v, new String[]{AnimUtil.PROPERTY_TRANSLATIONY, AnimUtil.PROPERTY_ROTATIONX,
                                AnimUtil.PROPERTY_ROTATIONY}, subHeight);
                        AnimUtil.addObjectAnimation(v, new String[]{AnimUtil.PROPERTY_ROTATIONX,
                                AnimUtil.PROPERTY_ROTATIONY}, 0f, 180f);
//                        fl_fold.setBackgroundResource(R.mipmap.btn_fold);
                        AnimUtil.addObjectAnimation(ll_sub_btns, new String[]{AnimUtil.PROPERTY_TRANSLATIONY}, subHeight);
                    }
                    isDown = !isDown;
                    break;
                case R.id.iv_shop:
                    Log.i("HomeActivity", "shop");
                    if (vp_content.getCurrentItem() != 1) {
                        shopView.show();
                    }
                    vp_content.setCurrentItem(1);
                    rl_root.setBackgroundResource(R.mipmap.bg_shop);
                    break;
                case R.id.fl_beibao:
                    beiBaoView.show();
                    break;
            }
        }
    };

    public void addAnimationListener(final View v) {
        shopView.hideFigure(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                switch (v.getId()) {
                    case R.id.iv_home:
                        vp_content.setCurrentItem(0);
                        rl_root.setBackgroundResource(R.mipmap.background);
                        break;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
