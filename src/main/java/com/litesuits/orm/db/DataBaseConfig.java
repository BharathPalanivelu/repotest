package com.litesuits.orm.db;

import android.content.Context;
import com.litesuits.orm.db.assit.Checker;
import com.litesuits.orm.db.assit.SQLiteHelper;

public class DataBaseConfig {
    public static final String DEFAULT_DB_NAME = "liteorm.db";
    public static final int DEFAULT_DB_VERSION = 1;
    public Context context;
    public String dbName;
    public int dbVersion;
    public boolean debugged;
    public SQLiteHelper.OnUpdateListener onUpdateListener;

    public DataBaseConfig(Context context2) {
        this(context2, DEFAULT_DB_NAME);
    }

    public DataBaseConfig(Context context2, String str) {
        this(context2, str, false, 1, (SQLiteHelper.OnUpdateListener) null);
    }

    public DataBaseConfig(Context context2, String str, boolean z, int i, SQLiteHelper.OnUpdateListener onUpdateListener2) {
        this.debugged = false;
        this.dbName = DEFAULT_DB_NAME;
        this.dbVersion = 1;
        this.context = context2.getApplicationContext();
        if (!Checker.isEmpty((CharSequence) str)) {
            this.dbName = str;
        }
        if (i > 1) {
            this.dbVersion = i;
        }
        this.debugged = z;
        this.onUpdateListener = onUpdateListener2;
    }

    public String toString() {
        return "DataBaseConfig [mContext=" + this.context + ", mDbName=" + this.dbName + ", mDbVersion=" + this.dbVersion + ", mOnUpdateListener=" + this.onUpdateListener + "]";
    }
}
