package com.sonikpalms.intern.Base;

/**
 * Created by Sonikpalms on 13.08.2017.
 */

public class Const {

    public final static int LOADER_ID = 0;



    public final static String DB_NAME = "news_db";
    public final static String DB_TABLE_NAME = "news";
    public final static String DB_COL_ID_PRIMARY = "_id";
    public final static String DB_COL_ID = "newsId";
    public final static String DB_COL_NAME = "newsName";
    public final static String DB_COL_URL = "newsURL";
    public final static String DB_COL_URL_TO_IMAGE = "imageURL";
    public final static String DB_COL_AUTHOR = "newsAuthor";
    public final static String DB_COL_DESCRIPTION = "newsDescription";
    public final static String DB_COL_PUBLISHEDAT = "newsPublishedat";
    public final static int DB_VERSION = 1;

    public static final String DB_CREATE = "create table " + DB_TABLE_NAME +
            "(" + DB_COL_ID_PRIMARY + " integer primary key autoincrement, " +
            DB_COL_ID + " integer, " + DB_COL_NAME + " text, " +
            DB_COL_URL + " text, " + DB_COL_URL_TO_IMAGE + " text," + DB_COL_AUTHOR + " text," + DB_COL_DESCRIPTION + " text," + DB_COL_PUBLISHEDAT + " text," +
            " UNIQUE ( " + DB_COL_ID + " ) ON CONFLICT IGNORE" + ");";

    public static final String DB_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DB_TABLE_NAME;
}

