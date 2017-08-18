package com.sonikpalms.intern.adapters;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sonikpalms.intern.Base.Const;
import com.sonikpalms.intern.Listeners.OnItemsClickListener;
import com.sonikpalms.intern.R;
import com.sonikpalms.intern.modelclass.MyItems;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.sonikpalms.intern.R.id.imageViewUrlToImage;

//import static com.sonikpalms.intern.modelclass.MyItems.Category.Family;

/**
 * Created by i.metlin on 27.07.2017.
 */

public class MyAdapter extends DataAdapter<MyAdapter.ViewHolder> {


    private ArrayList<MyItems> items;
    private Context ctx;
    private OnItemsClickListener listener;

    public MyAdapter(Cursor cursor, Context context) {
        super(context, cursor);
    }



    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_one_item, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (listener != null) {
                    listener.onItemClick(view, null, viewHolder.getAdapterPosition());
                    //view.setBackgroundColor(Color.rgb(150, 156, 255));



                }
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, Cursor cursor) {

        holder.textViewTitle.setText(cursor.getString(cursor.getColumnIndex(Const.DB_COL_NAME)));
        Picasso.with(ctx).load(cursor.getString(cursor.getColumnIndex(Const.DB_COL_URL_TO_IMAGE))).into(holder.imageViewUrlToImage);




    }
    public MyItems getNews(int position) {
        Cursor cursor = getCursor();
        MyItems news = new MyItems();

        if (cursor.moveToPosition(position)) {
            news.setTitle(cursor.getString(cursor.getColumnIndex(Const.DB_COL_NAME)));
            news.setUrl(cursor.getString(cursor.getColumnIndex(Const.DB_COL_URL)));
            news.setUrlToImage(cursor.getString(cursor.getColumnIndex(Const.DB_COL_URL_TO_IMAGE)));
        }

        return news;
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




    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageViewUrlToImage;


        TextView textViewPublishedAt;
        TextView textViewUrl;
        TextView textViewDescription;
        TextView textViewTitle;
        TextView textViewAuthor;



        public ViewHolder(View itemView) {
            super(itemView);

            imageViewUrlToImage = (ImageView) itemView.findViewById(R.id.imageViewUrlToImage);
            textViewPublishedAt = (TextView) itemView.findViewById(R.id.textViewPublishedAt);
            textViewUrl = (TextView) itemView.findViewById(R.id.textViewUrl);
            textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewAuthor = (TextView) itemView.findViewById(R.id.textViewAuthor);





        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getNews(getAdapterPosition()).getUrl(), getAdapterPosition());
        }
    }


}

