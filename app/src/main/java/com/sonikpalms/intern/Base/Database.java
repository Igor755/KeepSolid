package com.sonikpalms.intern.Base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentButton;
import com.sonikpalms.intern.modelclass.MyItems;
import com.sonikpalms.intern.modelclass.MyItemsGson;

import java.util.List;

/**
 * Created by Sonikpalms on 13.08.2017.
 */
//// TODO: 14.08.2017 write class
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

    private void addRec(MyItems item) {
        ContentValues cv = new ContentValues();
        cv.put(Const.DB_COL_DESCRIPTION, item.getTitle());
        cv.put(Const.DB_COL_ID, item.getUrlToImage());
       // cv.put(Const.DB_COL_NAME, item.getRepoName());
        //cv.put(Const.DB_COL_URL, item.getWebUrl().toString());

        mDB.insert(Const.DB_TABLE_NAME, null, cv);
    }

    public void addApiData(List<MyItems> items) {
        if(items.size() != 0) {
            for(int i = items.size()-1; i>=0; i--) {
                addRec(items.get(i));
            }
        }
    }

    /**
     * Subclass of {@link android.database.sqlite.SQLiteOpenHelper} which provides custom database helper.
     */
    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Const.DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(Const.DB_DELETE_ENTRIES);
            onCreate(db);
        }
    }

}

