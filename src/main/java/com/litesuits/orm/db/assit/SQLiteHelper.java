package com.litesuits.orm.db.assit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    private OnUpdateListener onUpdateListener;

    public interface OnUpdateListener {
        void onUpdate(SQLiteDatabase sQLiteDatabase, int i, int i2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public SQLiteHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, OnUpdateListener onUpdateListener2) {
        super(context, str, cursorFactory, i);
        this.onUpdateListener = onUpdateListener2;
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        OnUpdateListener onUpdateListener2 = this.onUpdateListener;
        if (onUpdateListener2 != null) {
            onUpdateListener2.onUpdate(sQLiteDatabase, i, i2);
        }
    }
}
