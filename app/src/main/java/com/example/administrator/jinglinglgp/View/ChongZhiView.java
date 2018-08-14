package com.example.administrator.jinglinglgp.View;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.jinglinglgp.Adapter.ListViewAdapter;
import com.example.administrator.jinglinglgp.Bean.ChongZhiInfo;
import com.example.administrator.jinglinglgp.R;
import com.example.administrator.jinglinglgp.Utils.AnimUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/2.
 */

public class ChongZhiView extends BaseView {
    private Dialog dialog;
    private ImageView iv_close;
    private FrameLayout fl_chongzhi;
    private ListView lv_chongzhi;

    public ChongZhiView(Context context) {
        super(context);
        setContentView(R.layout.view_chongzhi);

        initUI();
        initLvAdapter();
    }

    private void initLvAdapter() {
        ListViewAdapter lvAdapter = new ListViewAdapter(ctx, new ArrayList<ChongZhiInfo>());
        lv_chongzhi.setAdapter(lvAdapter);
    }

    @Override
    protected void initUI() {
        iv_close = (ImageView) findViewById(R.id.iv_close);
        AnimUtil.addOnTouchListener(iv_close, 0.5f, 0.5f, new AnimUtil.AnimListener() {

            @Override
            public void down(View v) {

            }

            @Override
            public void move(View v) {

            }

            @Override
            public void up(View v) {
                dialog.dismiss();
            }

        });
        fl_chongzhi= (FrameLayout) findViewById(R.id.fl_chongzhi);
        AnimUtil.addOnTouchListener(fl_chongzhi,0.5f,0.5f,null);
        lv_chongzhi= (ListView) findViewById(R.id.lv_chongzhi);

    }

    public void show() {
        if (dialog == null) {
            dialog = new Dialog(ctx, R.style.MyDialog);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
            dialog.setContentView(view, params);
        }
        dialog.show();
    }
}
