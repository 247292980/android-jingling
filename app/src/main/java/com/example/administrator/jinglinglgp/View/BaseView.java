package com.example.administrator.jinglinglgp.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Administrator on  17/7/1.
 */

public class BaseView {
    protected View view;
    protected Context ctx;

    public BaseView(Context context){
        this.ctx = context;
    }


    protected void initUI(){
    }

    protected void setContentView(int layout){
        view = LayoutInflater.from(ctx).inflate(layout, null);//将布局文件转换为View对象
    }

    protected View findViewById(int id){
        return view.findViewById(id);
    }

    public View getView(){
        return view;
    }
}
