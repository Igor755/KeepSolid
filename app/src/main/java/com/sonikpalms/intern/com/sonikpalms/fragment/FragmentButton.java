package com.sonikpalms.intern.com.sonikpalms.fragment;

import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
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
import com.sonikpalms.intern.Base.Const;
import com.sonikpalms.intern.Base.Database;
import com.sonikpalms.intern.InternetConnection.InternetConnection;
import com.sonikpalms.intern.Link.Link;
import com.sonikpalms.intern.Link.RetroClient;
import com.sonikpalms.intern.Listeners.OnItemsClickListener;
import com.sonikpalms.intern.Listeners.OnRecyclerClickListener;
import com.sonikpalms.intern.Loaders.IndianLoader;
import com.sonikpalms.intern.MainActivity;
import com.sonikpalms.intern.R;
import com.sonikpalms.intern.Receiver;
import com.sonikpalms.intern.adapters.DataAdapter;
import com.sonikpalms.intern.adapters.MyAdapter;
import com.sonikpalms.intern.modelclass.MyItems;
import com.sonikpalms.intern.modelclass.MyItemsGson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentButton extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {


    private RecyclerView tasksListView;
    private MyAdapter adapter;
    private DataAdapter Dapter;
    private List<MyItems> items;
    private Gson gson = new GsonBuilder().create();
    private ImageView imageViewSpecial;
    private ProgressBar progressBar;
    private OnRecyclerClickListener listener;
    private SwipeRefreshLayout reload;


    private Database database;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_button, container, false);

        items = new ArrayList<>();

        // adapter = new MyAdapter(items,getContext());

        database = new Database(getActivity());
        database.open();
        database.clearData();
        getActivity().getLoaderManager().initLoader(Const.LOADER_ID, null, this);


        tasksListView = (RecyclerView) v.findViewById(R.id.list_item);
        imageViewSpecial = (ImageView) v.findViewById(R.id.imageViewUrlToImage);
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        assert fab != null;

        //showProgressBlock();

        initAdapter();


        /*
        This is standart divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(tasksListView.getContext(), 1);
        tasksListView.addItemDecoration(dividerItemDecoration);
        */

        DividerItemDecoration divider = new DividerItemDecoration(tasksListView.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.reject1));
        tasksListView.addItemDecoration(divider);




        adapter = new MyAdapter(database.getAllData(), getActivity(), new OnRecyclerClickListener() {


            @Override
            public void onItemClick(View v, int position, String uri) {
                Intent intent = new Intent(getContext(), Receiver.class);
                intent.putExtra("newsURL", uri);
                startActivityForResult(intent, 1);



            }
        });
        tasksListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        tasksListView.setAdapter(adapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initAdapter();

            }
        });

        return v;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        listener = null;
        database.close();
    }



    private void makeErrorToast(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }


    public void initAdapter() {

        if (InternetConnection.checkConnection(getActivity())) {
            final ProgressDialog dialog;
            dialog = new ProgressDialog(getContext());
            dialog.setTitle(getString(R.string.wait));
            dialog.setMessage(getString(R.string.update));
            dialog.show();


            Link link = RetroClient.getApiService();
            Call<MyItemsGson> call = link.getMyJson();


            call.enqueue(new Callback<MyItemsGson>() {

                @Override
                public void onResponse(Call<MyItemsGson> call, Response<MyItemsGson> response) {
                    if (response.isSuccessful()) {


                        database.addApiData(response.body().getArticles());

                        adapter.swapCursor(database.getAllData());
                        tasksListView.getAdapter().notifyDataSetChanged();
                        dialog.dismiss();


                    }
                }

                @Override
                public void onFailure(Call<MyItemsGson> call, Throwable t) {

                    dialog.dismiss();
                    t.printStackTrace();
                    makeErrorToast("Error:" + t);


                }


            });


        }


    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new MyCursorLoader(getContext(), database);
    }


    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        adapter.swapCursor(cursor);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    static class MyCursorLoader extends CursorLoader {

        Database db;

        public MyCursorLoader(Context context, Database db) {
            super(context);
            this.db = db;
        }

        @Override
        public Cursor loadInBackground() {
            return db.getAllData();
        }

    }
}




