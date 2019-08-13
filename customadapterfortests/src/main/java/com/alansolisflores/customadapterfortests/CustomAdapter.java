package com.alansolisflores.customadapterfortests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomAdapter extends BaseAdapter {

    private int layout;

    private Context context;

    private Map<String,String> map;

    public CustomAdapter(int layout, Context context, LinkedHashMap<String,String> map) {
        this.layout = layout;
        this.context = context;
        this.map = map;
    }

    @Override
    public int getCount() {
        return this.map.size();
    }

    @Override
    public Object getItem(int position) {
        return this.map.values().toArray()[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout,null);

            holder = new ViewHolder();

            holder.titleTextView = convertView.findViewById(R.id.titleTextView);
            holder.descriptionTextView = convertView.findViewById(R.id.descriptionTextView);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.descriptionTextView.setText(this.map.values().toArray()[position].toString());
        holder.titleTextView.setText(this.map.keySet().toArray()[position].toString());

        return convertView;
    }

    public static class ViewHolder{
        private TextView titleTextView;
        private TextView descriptionTextView;
    }
}
