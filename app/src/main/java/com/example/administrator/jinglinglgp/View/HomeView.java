package com.example.administrator.jinglinglgp.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.jinglinglgp.R;

/**
 * Created by Administrator on 17/7/1.
 */

public class HomeView {
    private View view;
    private Context context;

    public HomeView(Context context){
        view = LayoutInflater.from(context).inflate(R.layout.view_home, null);//将布局文件转换为View对象

        initUI();
    }


    private void initUI(){
    }

    private View findViewById(int id){
        return view.findViewById(id);
    }

    public View getView(){
        return view;
    }
}
