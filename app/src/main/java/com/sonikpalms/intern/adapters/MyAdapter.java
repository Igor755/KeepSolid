package com.sonikpalms.intern.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sonikpalms.intern.R;
import com.sonikpalms.intern.modelclass.MyItems;

import java.util.ArrayList;

/**
 * Created by i.metlin on 27.07.2017.
 */

public class MyAdapter extends BaseAdapter {


    private ArrayList<MyItems> items;
    private Context ctx;

    public MyAdapter(ArrayList<MyItems> items, Context ctx) {
        this.items = items;
        this.ctx = ctx;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public MyItems getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;
        View view = convertView;

        if (view == null) {
            Log.e("TaskAdapter", "inflatingView!");
            LayoutInflater inflater = LayoutInflater.from(ctx);
            view = inflater.inflate(R.layout.list_one_item, viewGroup, false);

            holder = new ViewHolder();

            holder.isOnline = view.findViewById(R.id.isOnline);
            holder.userName = (TextView) view.findViewById(R.id.userName);

           // holder.userId = (TextView) view.findViewById(R.id.userId);
            //holder.userAddress = (TextView) view.findViewById(R.id.email_item);
            //holder.taskCategory = (TextView) view.findViewById(R.id.category_item);
            //holder.userName = (TextView) view.findViewById(R.id.userName);


            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.userName.setText(getItem(position).getUserName());

        if(getItem(position).isOnline()){
            holder.isOnline.setChecked(true);
        } else {
            holder.isOnline.setChecked(false);
        }

       // holder.isOnline.setChecked(getItem(position).isOnline());
        //holder.userName.setText(getItem(position).getUserName());
      //  holder.userId.setText(getItem(position).getUserName());
      //  holder.userAddress.setText(getItem(position).getUserName());
       // holder.taskCategory.setText(getItem(position).getUserName());
       // holder.userName.setText(getItem(position).getUserName());


        /*

        holder.userName.setText(getItem(position).getUserName());

        if(getItem(position).isOnline()){
            holder.isOnline.setBackground(ContextCompat.getDrawable(ctx, R.drawable.accept2));
        } else {
            holder.isOnline.setBackground(ContextCompat.getDrawable(ctx, R.drawable.accept3));
        }
*/

        return view;
    }

    public ArrayList<MyItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<MyItems> items) {
        this.items = items;
    }


    private static class ViewHolder{

        RadioButton isOnline;
        TextView userName;
        //TextView userId;
        //TextView userAddress;
        //TextView taskCategory;



    }
}
