package com.sonikpalms.intern.Base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentButton;
import com.sonikpalms.intern.modelclass.MyItems;
import com.sonikpalms.intern.modelclass.MyItemsGson;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Sonikpalms on 13.08.2017.
 */

public class Database {

    private final Context ctx;

    private DBHelper dbHelper;

    private SQLiteDatabase mDB;

    public Database(Context ctx) {
        this.ctx = ctx;
    }



    public void open() {
        dbHelper = new DBHelper(ctx, Const.DB_NAME, null, Const.DB_VERSION);
        mDB = dbHelper.getWritableDatabase();
    }

    public void close() {
        if (dbHelper != null) {
            dbHelper.close();
        }
    }

    public Cursor getAllData() {
        return mDB.query(Const.DB_TABLE_NAME, null, null, null, null, null, Const.DB_COL_ID_PRIMARY + " DESC");
    }

    public void clearData() {
        mDB.delete(Const.DB_TABLE_NAME, null, null);
    }

    private void addNews(MyItems item) {
        ContentValues cv = new ContentValues();
        //cv.put(Const.DB_COL_ID, item.getId());
        cv.put(Const.DB_COL_NAME, item.getTitle());
        //cv.put(Const.DB_COL_URL, item.getUrl());
        cv.put(Const.DB_COL_URL_TO_IMAGE, item.getUrlToImage());
       // cv.put(Const.DB_COL_AUTHOR, item.getAuthor());
        //cv.put(Const.DB_COL_DESCRIPTION, item.getDescription());



       cv.put(Const.DB_COL_PUBLISHEAT, item.getPublishedAt());

        mDB.insert(Const.DB_TABLE_NAME, null, cv);
    }

    public void addApiData(List<MyItems> news) {
        if (news.size() != 0) {
            for (int i = news.size() - 1; i >= 0; i--) {
                addNews(news.get(i));
            }
        }
    }

    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(Const.DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(Const.DB_DELETE_ENTRIES);
            onCreate(sqLiteDatabase);
        }
    }
}


