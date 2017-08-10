package com.sonikpalms.intern.com.sonikpalms.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sonikpalms.intern.InternetConnection.InternetConnection;
import com.sonikpalms.intern.Link.Link;
import com.sonikpalms.intern.Link.RetroClient;
import com.sonikpalms.intern.Listeners.OnItemsClickListener;
import com.sonikpalms.intern.R;
import com.sonikpalms.intern.Receiver;
import com.sonikpalms.intern.MainActivity;
import com.sonikpalms.intern.adapters.MyAdapter;
import com.sonikpalms.intern.modelclass.MyItems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragmentButton extends Fragment {

    private final String URL = "https://newsapi.org";
    private final String KEY = "f95725ad56c04956b0f37a5a4e1d36b1";




    private RecyclerView tasksListView;
    private MyAdapter adapter;
    private ArrayList<Object> items;
   // private Gson gson = new GsonBuilder().create();


 //   private Retrofit retrofit = new Retrofit.Builder()
    //        .addConverterFactory(GsonConverterFactory.create(gson))
    //        .baseUrl(URL)
     //       .build();

 //   private Link inter = retrofit.create(Link.class);




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_button, container, false);

        items = new ArrayList<>();

        tasksListView = (RecyclerView) v.findViewById(R.id.list_item);

        Link link = RetroClient.getApiService();
        Call<MyItems> call = link.getMyJson();


        call.enqueue(new Callback<MyItems>() {
            @Override
            public void onResponse(Call<MyItems> call, Response<MyItems> response) {
                if(response.isSuccessful()){
                  // items = response.body().MyItemsGson;
                    tasksListView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    tasksListView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<MyItems> call, Throwable t) {

            }
        });




        if(InternetConnection.checkConnection(getActivity())){
           // final ProgressDialog dialog;
        }


/*
        items = new ArrayList<>();

        items.add(new MyItems(false, "alexandr", MyItems.Category.Another, 1, "alexandr@gmail.com"));
        items.add(new MyItems(true, "dieznote", MyItems.Category.Family, 2, "dieznote@gmail.com"));
        items.add(new MyItems(true, "jonny", MyItems.Category.Friend, 3, "jonny@gmail.com"));
        items.add(new MyItems(false, "vsibi", MyItems.Category.Work, 4, "vsibi@gmail.com"));
        items.add(new MyItems(true, "artur.romasiuk", MyItems.Category.Work, 5, "artur.romasiuk@gmail.com"));
        items.add(new MyItems(true, "catlerina", MyItems.Category.Work, 6, "catlerina@gmail.com"));
        items.add(new MyItems(false, "cherepinina98", MyItems.Category.Another, 7, "cherepinina98@gmail.com"));
        items.add(new MyItems(true, "d.shevtsov ", MyItems.Category.Friend, 8, "d.shevtsov@gmail.com"));
        items.add(new MyItems(false, "dima_pd", MyItems.Category.Another, 9, "dima_pd@gmail.com"));
        items.add(new MyItems(true, "dmitriiserdun", MyItems.Category.Family, 10, "dmitriiserdun@gmail.com"));
        items.add(new MyItems(true, "eugene", MyItems.Category.Family, 11, "eugene@gmail.com"));
        items.add(new MyItems(false, "nedomovnyvlad", MyItems.Category.Friend, 12, "nedomovnyvlad@gmail.com"));
        items.add(new MyItems(true, "oleg", MyItems.Category.Another, 13, "oleg@gmail.com"));
        items.add(new MyItems(false, "levil13", MyItems.Category.Friend, 14, "levil13@gmail.com"));
        items.add(new MyItems(true, "qbikkx", MyItems.Category.Friend, 15, "qbikkx@gmail.com"));
        items.add(new MyItems(true, "vadimprov", MyItems.Category.Work, 16, "vadimprov@gmail.com"));
        items.add(new MyItems(false, "vladimir", MyItems.Category.Another, 17, "vladimir@gmail.com"));
        items.add(new MyItems(true, "vliubchenko", MyItems.Category.Work, 18, "vliubchenko@gmail.com"));


        Collections.sort(items, new Comparator<MyItems> () {
            @Override
            public int compare(MyItems element1, MyItems element2) {
                if (element1.isOnline() == true) return -1;
                else return 0;
            }
        });


        tasksListView = (RecyclerView) v.findViewById(R.id.list_item);


        System.out.println("luna");



        adapter = new MyAdapter(items, getActivity(), new OnItemsClickListener() {


            @Override
            public void onItemClick(View v, int position) {


               Intent intent = new Intent(getContext(), Receiver.class);


                intent.putExtra("Username", items.get(position).getUserName());
                intent.putExtra("UserID", items.get(position).getUserId());
                intent.putExtra("UserStatus", items.get(position).isOnline());
                intent.putExtra("UserAddress", items.get(position).getUserAddress());
                intent.putExtra("UserCategory", items.get(position).getTaskCategory());
                startActivityForResult(intent, 1);


            }
        });
        tasksListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        tasksListView.setAdapter(adapter);


*/
        return v;


    }

}