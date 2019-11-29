package com.shopee.live.livestreaming.sztracking.base.db;

import android.content.Context;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.SQLiteHelper;
import com.litesuits.orm.db.model.ConflictAlgorithm;
import java.util.ArrayList;
import java.util.Collection;

public class SZTrackingDBHelper {
    private static final String DB_NAME = "live_streaming_sz_tracking.db";
    private static final int DB_VERSION = 1;
    private static final boolean DEBUG = false;
    private static LiteOrm mLiteOrm;

    private SZTrackingDBHelper(Context context, SQLiteHelper.OnUpdateListener onUpdateListener, boolean z) {
        if (mLiteOrm == null) {
            DataBaseConfig dataBaseConfig = new DataBaseConfig(context.getApplicationContext(), DB_NAME);
            dataBaseConfig.dbVersion = 1;
            dataBaseConfig.onUpdateListener = onUpdateListener;
            mLiteOrm = z ? LiteOrm.newCascadeInstance(dataBaseConfig) : LiteOrm.newSingleInstance(dataBaseConfig);
            mLiteOrm.setDebugged(false);
        }
    }

    public static SZTrackingDBHelper singleInstance(Context context) {
        return new SZTrackingDBHelper(context, (SQLiteHelper.OnUpdateListener) null, false);
    }

    public static SZTrackingDBHelper casCadeInstance(Context context) {
        return new SZTrackingDBHelper(context, (SQLiteHelper.OnUpdateListener) null, true);
    }

    public static SZTrackingDBHelper singleInstance(Context context, SQLiteHelper.OnUpdateListener onUpdateListener) {
        return new SZTrackingDBHelper(context, onUpdateListener, false);
    }

    public static SZTrackingDBHelper casCadeInstance(Context context, SQLiteHelper.OnUpdateListener onUpdateListener) {
        return new SZTrackingDBHelper(context, onUpdateListener, true);
    }

    public <T> long insert(T t) {
        return mLiteOrm.insert((Object) t, ConflictAlgorithm.Abort);
    }

    public <T> long insertOrUpdate(T t) {
        return mLiteOrm.save((Object) t);
    }

    public <T> int insert(Collection<T> collection) {
        return mLiteOrm.insert(collection, ConflictAlgorithm.Abort);
    }

    public <T> int insertOrUpdate(Collection<T> collection) {
        return mLiteOrm.save(collection);
    }

    public <T> int delete(T t) {
        return mLiteOrm.delete((Object) t);
    }

    public <T> int delete(Class<T> cls) {
        return mLiteOrm.delete(cls);
    }

    public <T> int deleteList(Collection<T> collection) {
        return mLiteOrm.delete(collection);
    }

    public <T> int deleteAll(Class<T> cls) {
        return mLiteOrm.delete(cls);
    }

    public <T> int update(T t) {
        return mLiteOrm.update((Object) t);
    }

    public <T> ArrayList<T> query(Class<T> cls) {
        return mLiteOrm.query(cls);
    }

    public <T> T queryById(long j, Class<T> cls) {
        return mLiteOrm.queryById(j, cls);
    }

    public <T> ArrayList<T> query(QueryBuilder<T> queryBuilder) {
        return mLiteOrm.query(queryBuilder);
    }

    public <T> long queryCount(Class<T> cls) {
        return mLiteOrm.queryCount(cls);
    }

    public void deleteDatabase() {
        mLiteOrm.deleteDatabase();
    }

    public synchronized void openOrCreateDatabase() {
        mLiteOrm.openOrCreateDatabase();
    }

    public synchronized void close() {
        if (!isClosed()) {
            close();
        }
    }

    public static synchronized boolean isClosed() {
        boolean z;
        synchronized (SZTrackingDBHelper.class) {
            z = mLiteOrm == null;
        }
        return z;
    }
}
