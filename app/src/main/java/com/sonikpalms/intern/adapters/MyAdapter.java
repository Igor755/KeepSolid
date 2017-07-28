package com.sonikpalms.intern.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sonikpalms.intern.R;
import com.sonikpalms.intern.modelclass.MyItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i.metlin on 27.07.2017.
 */

public class MyAdapter extends ArrayAdapter<MyItems> {



    private LayoutInflater inflater;
    private int layout;
    private List<MyItems> myItemses;

    public MyAdapter(Context context, int resource, List<MyItems> myItemses) {
        super(context, resource, myItemses);
        this.myItemses = myItemses;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MyItems state = myItemses.get(position);


        //viewHolder.isOnlineView.(state.isOnline());
        viewHolder.userNameView.setText(state.getUserName());

        return convertView;
    }
    private class ViewHolder {
        final TextView isOnlineView;
        final TextView userNameView;
        ViewHolder(View view){

            isOnlineView = (TextView) view.findViewById(R.id.isOnline);
            userNameView = (TextView) view.findViewById(R.id.userName);
        }
    }
}