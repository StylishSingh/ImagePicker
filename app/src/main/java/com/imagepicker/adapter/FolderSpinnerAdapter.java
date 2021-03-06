package com.imagepicker.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.imagepicker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anuj Sharma on 8/18/2017.
 */

public class FolderSpinnerAdapter extends ArrayAdapter<String> {
    private Context context;
    List<String> mList;

    public FolderSpinnerAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.mList = objects;
    }

    @Override
    public int getCount() {
        if (mList != null)
            return mList.size();
        else
            return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(convertView, position, Color.WHITE, 10);
    }

    private View initView(View convertView, int position, int color, int padding) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item, null);
            holder.tableNumber = (TextView) convertView.findViewById(R.id.category_name);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.tableNumber.setText(mList.get(position).toString());
        holder.tableNumber.setTextColor(color);
        holder.tableNumber.setPadding(padding, padding, padding, padding);

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return initView(convertView, position, Color.WHITE, 30);
    }

    public void updateList(Context mContext, List<String> mList) {
        this.context = mContext;
        this.mList = new ArrayList<>();
        this.mList.addAll(mList);
        notifyDataSetChanged();
    }

    class Holder {
        TextView tableNumber;
    }
}