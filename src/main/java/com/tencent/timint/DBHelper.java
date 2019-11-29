package com.tencent.timint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;
import java.util.Map;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String str) {
        this(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    private DBHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final Map<String, byte[]> a() {
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            HashMap hashMap = new HashMap();
            Cursor rawQuery = readableDatabase.rawQuery("select * from report", (String[]) null);
            while (rawQuery.moveToNext()) {
                hashMap.put(String.valueOf(rawQuery.getInt(0)), rawQuery.getBlob(1));
            }
            rawQuery.close();
            readableDatabase.close();
            return hashMap;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final boolean a(int i) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            long delete = (long) writableDatabase.delete("report", "id=?", new String[]{String.valueOf(i)});
            writableDatabase.close();
            return delete == 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean a(byte[] bArr) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", bArr);
            long insert = writableDatabase.insert("report", (String) null, contentValues);
            writableDatabase.close();
            return insert > 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists report(id integer primary key asc autoincrement,data blob)");
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
