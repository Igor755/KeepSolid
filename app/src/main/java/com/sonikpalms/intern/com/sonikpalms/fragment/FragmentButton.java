package com.sonikpalms.intern.com.sonikpalms.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.sonikpalms.intern.Listeners.OnItemsClickListener;
import com.sonikpalms.intern.R;
import com.sonikpalms.intern.Receiver;
import com.sonikpalms.intern.MainActivity;
import com.sonikpalms.intern.adapters.MyAdapter;
import com.sonikpalms.intern.modelclass.MyItems;

import java.util.ArrayList;


public class FragmentButton extends Fragment {

    private ListView tasksListView;
    private MyAdapter adapter;
    private ArrayList<MyItems> items;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_button, container, false);


        tasksListView = (ListView) v.findViewById(R.id.list_item);

        items = new ArrayList<>();

        items.add(new MyItems(false, "alexandr", MyItems.Category.Another, 1, "alexandr@gmail.com"));
        items.add(new MyItems(true, "dieznote", MyItems.Category.Another, 2, "dieznotegmail.com"));
        items.add(new MyItems(true, "jonny", MyItems.Category.Another, 3, "jonnygmail.com"));
        items.add(new MyItems(false, "vsibi", MyItems.Category.Another, 4, "vsibigmail.com"));
        items.add(new MyItems(true, "artur.romasiuk", MyItems.Category.Another, 5, "artur.romasiuk@gmail.com"));
        items.add(new MyItems(true, "catlerina", MyItems.Category.Another, 6, "catlerina@gmail.com"));
        items.add(new MyItems(false, "cherepinina98", MyItems.Category.Another, 7, "cherepinina98@gmail.com"));
        items.add(new MyItems(true, "d.shevtsov ", MyItems.Category.Another, 8, "d.shevtsov@gmail.com"));
        items.add(new MyItems(false, "dima_pd", MyItems.Category.Another, 9, "dima_pd@gmail.com"));
        items.add(new MyItems(true, "dmitriiserdun", MyItems.Category.Another, 10, "dmitriiserdun@gmail.com"));
        items.add(new MyItems(true, "eugene", MyItems.Category.Another, 11, "eugene@gmail.com"));
        items.add(new MyItems(false, "nedomovnyvlad", MyItems.Category.Another, 12, "nedomovnyvlad@gmail.com"));
        items.add(new MyItems(true, "oleg", MyItems.Category.Another, 13, "oleg@gmail.com"));
        items.add(new MyItems(false, "levil13", MyItems.Category.Another, 14, "levil13@gmail.com"));
        items.add(new MyItems(true, "qbikkx", MyItems.Category.Another, 15, "qbikkx@gmail.com"));
        items.add(new MyItems(true, "vadimprov", MyItems.Category.Another, 16, "vadimprov@gmail.com"));
        items.add(new MyItems(false, "vladimir", MyItems.Category.Another, 17, "vladimir@gmail.com"));
        items.add(new MyItems(true, "vliubchenko", MyItems.Category.Another, 18, "vliubchenko@gmail.com"));


        System.out.println("luna");

        //tasksListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new MyAdapter(items,getContext());
        tasksListView.setAdapter(adapter);


        /*
        adapter = new MyAdapter(items, getActivity(), new OnItemsClickListener() {


            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), Receiver.class);
                intent.putExtra("Username", items.get(position).getUserName());
                intent.putExtra("UserID", items.get(position).getUserId());
                intent.putExtra("UserStatus", items.get(position).isOnline());
                intent.putExtra("UserAddress", items.get(position).getUserAddress());
                intent.putExtra("UserCategory", items.get(position).getTaskCategory());
                startActivityForResult(intent, 1);


            }
        });*/
        // MyItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        // MyItems.setAdapter(adapter);


        //System.out.println(ListView);


        //adapter = new MyAdapter(MyItems,getActivity().g);

        //final ListView listView = (ListView) v.findViewById(R.id.list_item);

        return v;


    }

}