package com.example.administrator.jinglinglgp.View;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.administrator.jinglinglgp.Adapter.GridViewAdapter;
import com.example.administrator.jinglinglgp.Bean.BeiBaoInfo;
import com.example.administrator.jinglinglgp.R;
import com.example.administrator.jinglinglgp.Utils.AnimUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/2.
 */

public class BeiBaoView extends BaseView {
    private Dialog dialog;
    private GridView gv_beibao;
    private ImageView iv_close_beibao;

    public BeiBaoView(Context context) {
        super(context);
        setContentView(R.layout.view_beibao);

        initUI();
        initGvAdapter();
    }

    @Override
    protected void initUI() {
        iv_close_beibao = (ImageView) findViewById(R.id.iv_close_beibao);
        AnimUtil.addOnTouchListener(iv_close_beibao, 0.5f, 0.5f, new AnimUtil.AnimListener() {

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
        gv_beibao = (GridView) findViewById(R.id.gv_beibao);

    }

    private void initGvAdapter() {
        GridViewAdapter gvAdapter = new GridViewAdapter(ctx, new ArrayList<BeiBaoInfo>());
        gv_beibao.setAdapter(gvAdapter);
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
