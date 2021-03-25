package com.example.qlthongtincanhan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class listview_Adapter_custom extends BaseAdapter {
    Context context;
    int ResourceLayout;
    ArrayList<Person> arrayList;

    public listview_Adapter_custom(Context context, int resourceLayout, ArrayList<Person> arrayList) {
        this.context = context;
        ResourceLayout = resourceLayout;
        this.arrayList = arrayList;
    }
    public void capNhapThongTing(ArrayList<Person> newlist)
    {
        this.arrayList.clear();
        this.arrayList.addAll(newlist);
        this.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return arrayList.size();
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
        convertView = inflater.inflate(ResourceLayout,null);
        TextView tvten = (TextView) convertView.findViewById(R.id.tvten_listview);
        TextView tvsdt = (TextView) convertView.findViewById(R.id.tvsdt_listview);
        TextView tvdiachi = (TextView) convertView.findViewById(R.id.tvdiachi_listview);

        tvten.setText(arrayList.get(position).getName().toString());
        tvsdt.setText(arrayList.get(position).getPhoneNumber().toString());
        tvdiachi.setText(arrayList.get(position).getAddress().toString());

        return convertView;
    }

    public void notifyDataSetChanged(ArrayList<Person> listPerson) {
    }
}
