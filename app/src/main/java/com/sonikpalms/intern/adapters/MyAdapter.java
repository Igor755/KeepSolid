package com.sonikpalms.intern.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sonikpalms.intern.Listeners.OnItemsClickListener;
import com.sonikpalms.intern.R;
import com.sonikpalms.intern.modelclass.MyItems;

import java.util.ArrayList;
import java.util.List;

import static com.sonikpalms.intern.modelclass.MyItems.Category.Family;

/**
 * Created by i.metlin on 27.07.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private ArrayList<MyItems> items;
    private Context ctx;
    OnItemsClickListener listener;

    public MyAdapter(ArrayList<MyItems> items, Context ctx) {
        this.items = items;
        this.ctx = ctx;

    }

    public MyAdapter(ArrayList<MyItems> items, Context ctx, OnItemsClickListener listener) {
        this.items = items;
        this.ctx = ctx;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_one_item, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getResources().getColor(R.color.orange);
                if (listener != null) {
                    listener.onItemClick(view, viewHolder.getAdapterPosition());


                }
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.isOnline.setChecked(items.get(position).isOnline());
        holder.userName.setText(items.get(position).getUserName());



        if (items.get(position).getTaskCategory().equals(MyItems.Category.Another))
        {
            holder.category_item.setText("Another");
        } else if (items.get(position).getTaskCategory().equals(Family)) {
            holder.category_item.setText("Family");
        } else if (items.get(position).getTaskCategory().equals(MyItems.Category.Friend)) {
            holder.category_item.setText("Friend");
        } else {
            holder.category_item.setText("Work");
        }

        if (items.get(position).isOnline()) {
            holder.isOnline.setChecked(true);
        } else {
            holder.isOnline.setChecked(false);
        }

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public ArrayList<MyItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<MyItems> items) {
        this.items = items;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        RadioButton isOnline;
        TextView userName;
        TextView category_item;
        TextView email_item;



        public ViewHolder(View itemView) {
            super(itemView);
            //itemView.getResources().getColor(R.color.orange);
            isOnline = (RadioButton) itemView.findViewById(R.id.isOnline);
            userName = (TextView) itemView.findViewById(R.id.userName);
            category_item = (TextView) itemView.findViewById(R.id.category_item);
            email_item = (TextView) itemView.findViewById(R.id.email_item);




        }
    }


}

