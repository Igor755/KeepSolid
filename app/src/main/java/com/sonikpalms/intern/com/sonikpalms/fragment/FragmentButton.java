package com.sonikpalms.intern.com.sonikpalms.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.*;
import com.sonikpalms.intern.Base.Database;
import com.sonikpalms.intern.InternetConnection.InternetConnection;
import com.sonikpalms.intern.Link.Link;
import com.sonikpalms.intern.Link.RetroClient;
import com.sonikpalms.intern.Listeners.OnItemsClickListener;
import com.sonikpalms.intern.R;
import com.sonikpalms.intern.Receiver;
import com.sonikpalms.intern.MainActivity;
import com.sonikpalms.intern.adapters.MyAdapter;
import com.sonikpalms.intern.modelclass.MyItems;
import com.sonikpalms.intern.modelclass.MyItemsGson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentButton extends Fragment {

    private final String URL = "https://newsapi.org";
    private final String KEY = "f95725ad56c04956b0f37a5a4e1d36b1";


    private RecyclerView tasksListView;
    private MyAdapter adapter;
    private List<MyItems> items;
    private Gson gson = new GsonBuilder().create();
    private ImageView imageViewSpecial;
    private ProgressBar progressBar;


    private Database database;

    private void showProgressBlock() {
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }

    }

    private void hideProgressBlock() {
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void makeErrorToast(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_button, container, false);

        items = new ArrayList<>();
        // adapter = new MyAdapter(items,getContext());

        //database = new Database(getContext());
        //database.open();
        //database.clearData();


        tasksListView = (RecyclerView) v.findViewById(R.id.list_item);
        imageViewSpecial = (ImageView) v.findViewById(R.id.imageViewUrlToImage);


        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        assert fab != null;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Link link = RetroClient.getApiService();
                Call<MyItemsGson> call = link.getMyJson();

                if (InternetConnection.checkConnection(getActivity())) {
                    final ProgressDialog dialog;
                    dialog = new ProgressDialog(getContext());
                    dialog.setTitle(getString(R.string.wait));
                    dialog.setMessage(getString(R.string.connect));
                    dialog.show();


                    call.enqueue(new Callback<MyItemsGson>() {

                        @Override
                        public void onResponse(Call<MyItemsGson> call, Response<MyItemsGson> response) {
                            if (response.isSuccessful()) {

                                dialog.dismiss();

                                //// TODO: 15.08.2017 write onResponse

                                System.out.println("2222222222222222222222222222222222222222222222222222222222222222222222");
                                items = response.body().getArticles();


                                adapter = new MyAdapter((ArrayList<MyItems>) items, getActivity(), new OnItemsClickListener() {


                                    @Override
                                    public void onItemClick(View v, int position) {

                                        Intent intent = new Intent(getContext(), Receiver.class);


                                        // intent.putExtra("Username", items.get(position).getTitle());
                                        intent.putExtra("urlNews", items.get(position).getUrl());
                                        //   intent.putExtra("UserStatus", items.get(position).getDescription());
                                        //   intent.putExtra("UserAddress", items.get(position).getPublishedAt());
                                        //   intent.putExtra("UserCategory", items.get(position).getUrlToImage());
                                        startActivityForResult(intent, 1);


                                    }
                                });
                                tasksListView.setLayoutManager(new LinearLayoutManager(getActivity()));
                                tasksListView.setAdapter(adapter);
                            }
                            else {
                                Snackbar.make(null, null, Snackbar.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<MyItemsGson> call, Throwable t) {
                            dialog.dismiss();


                            t.printStackTrace();
                            makeErrorToast("Error:" + t);
                            hideProgressBlock();


                        }


                    });
                } else {
                    Snackbar.make(null, null, Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        return v;


    }


}

