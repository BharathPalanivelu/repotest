package com.shopee.shopeetracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    private static final String DATA_BASE_NAME = "event.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE event ( ID INTEGER PRIMARY KEY, CREATED_AT INTEGER , TYPE INTEGER , VALUE TEXT )";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS event";

    public SQLiteHelper(Context context) {
        super(context, DATA_BASE_NAME, (SQLiteDatabase.CursorFactory) null, 3);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sQLiteDatabase);
    }
}
