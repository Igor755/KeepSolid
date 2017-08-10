package com.sonikpalms.intern.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sonikpalms.intern.Listeners.OnItemsClickListener;
import com.sonikpalms.intern.R;
import com.sonikpalms.intern.modelclass.MyItems;

import java.util.ArrayList;
import java.util.List;

//import static com.sonikpalms.intern.modelclass.MyItems.Category.Family;

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
    public ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_one_item, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (listener != null) {
                    listener.onItemClick(view, viewHolder.getAdapterPosition());
                    view.setBackgroundColor(Color.rgb(150, 156, 255));



                }
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.imageViewUrlToImage.setImageDrawable(Drawable.createFromPath(items.get(position).getUrlToImage()));
        holder.textViewPublishedAt.setText(items.get(position).getPublishedAt());
        holder.textViewUrl.setText(items.get(position).getUrl());
        holder.textViewDescription.setText(items.get(position).getDescription());
        holder.textViewTitle.setText(items.get(position).getTitle());
        holder.textViewAuthor.setText(items.get(position).getAuthor());




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

        ImageView imageViewUrlToImage;


        TextView textViewPublishedAt;
        TextView textViewUrl;
        TextView textViewDescription;
        TextView textViewTitle;
        TextView textViewAuthor;



        public ViewHolder(View itemView) {
            super(itemView);

            imageViewUrlToImage = (ImageView)itemView.findViewById(R.id.imageViewUrlToImage);
            textViewPublishedAt = (TextView) itemView.findViewById(R.id.textViewPublishedAt);
            textViewUrl = (TextView) itemView.findViewById(R.id.textViewUrl);
            textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewAuthor = (TextView) itemView.findViewById(R.id.textViewAuthor);




        }
    }


}

