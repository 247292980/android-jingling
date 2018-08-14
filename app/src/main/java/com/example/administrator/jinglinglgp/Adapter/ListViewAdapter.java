package com.example.administrator.jinglinglgp.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.jinglinglgp.Bean.ChongZhiInfo;
import com.example.administrator.jinglinglgp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/2.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private List<ChongZhiInfo> data;

    public ListViewAdapter(Context context, ArrayList<ChongZhiInfo> data) {
        this.context = context;
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_lv_chongzhi, null);
        }
        //取出数据
        // ChongZhiInfo bean = data.get(position);
        //出取单元格布局中的控件
        //TextView tv_youhui = (TextView) convertView.findViewById(R.id.tv_youhui);
        //一个一个赋值
        //tv_youhui.setText(bean)
        return convertView;
    }
}
