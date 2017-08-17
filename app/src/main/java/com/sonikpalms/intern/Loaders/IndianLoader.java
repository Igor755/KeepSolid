package com.sonikpalms.intern.Loaders;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;

import com.sonikpalms.intern.Base.Database;
import com.sonikpalms.intern.InternetConnection.InternetConnection;
import com.sonikpalms.intern.Link.Link;
import com.sonikpalms.intern.Link.RetroClient;
import com.sonikpalms.intern.modelclass.MyItems;
import com.sonikpalms.intern.modelclass.MyItemsGson;

import java.io.IOException;
import java.util.List;

import okhttp3.internal.Util;

/**
 * Created by i.metlin on 17.08.2017.
 */

public class IndianLoader extends CursorLoader {

    private Database db;
    private static Link newsService;
    private MyItemsGson getArticlesResponse;
    private List<MyItems> articleList;

    public IndianLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public Cursor loadInBackground() {

       //newsService = (RetroClient) RetroClient.getApiService();
        db = new Database(getContext());
        db.open();
        Cursor cursor = null;

        try {
              if (InternetConnection.checkConnection(getContext())) {
                db.clearData();
                getArticlesResponse = newsService.getMyJson().execute().body();
                if (getArticlesResponse != null) {
                    articleList = getArticlesResponse.getArticles();
                    db.addApiData(articleList);
                }
            }
            cursor = db.getAllData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cursor;
    }
}

