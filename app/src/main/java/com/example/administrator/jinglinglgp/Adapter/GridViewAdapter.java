package com.example.administrator.jinglinglgp.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.jinglinglgp.Bean.BeiBaoInfo;
import com.example.administrator.jinglinglgp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/2.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<BeiBaoInfo> data;

    public GridViewAdapter(Context context, ArrayList<BeiBaoInfo> data) {
        this.context = context;
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }
    @Override
    public int getCount() {
        return 50;
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
            convertView = View.inflate(context, R.layout.item_gv_beibao, null);
        }
        return convertView;
    }
}
