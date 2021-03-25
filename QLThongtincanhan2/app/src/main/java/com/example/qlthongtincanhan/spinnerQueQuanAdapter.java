package com.example.qlthongtincanhan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class spinnerQueQuanAdapter extends BaseAdapter {
    Context context;
    int LayoutResource;
    String arraysource[];

    public spinnerQueQuanAdapter(Context context, int layoutResource, String[] arraysource) {
        this.context = context;
        LayoutResource = layoutResource;
        this.arraysource = arraysource;
    }

    @Override
    public int getCount() {
        return arraysource.length;
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(LayoutResource,null);

        TextView tvquequan = convertView.findViewById(R.id.tvquequansp);
        tvquequan.setText(arraysource[position]);
        return convertView;
    }
}
