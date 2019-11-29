package com.litesuits.orm.db.assit;

import android.database.sqlite.SQLiteDatabase;
import com.litesuits.orm.log.OrmLog;

public class Transaction {
    private static final String TAG = "Transaction";

    public interface Worker<T> {
        T doTransaction(SQLiteDatabase sQLiteDatabase) throws Exception;
    }

    public static <T> T execute(SQLiteDatabase sQLiteDatabase, Worker<T> worker) {
        T t;
        sQLiteDatabase.beginTransaction();
        OrmLog.i(TAG, "----> BeginTransaction");
        try {
            t = worker.doTransaction(sQLiteDatabase);
            try {
                sQLiteDatabase.setTransactionSuccessful();
                if (OrmLog.isPrint) {
                    OrmLog.i(TAG, "----> Transaction Successful");
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    sQLiteDatabase.endTransaction();
                    return t;
                } catch (Throwable th) {
                    sQLiteDatabase.endTransaction();
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            t = null;
            e.printStackTrace();
            sQLiteDatabase.endTransaction();
            return t;
        }
        sQLiteDatabase.endTransaction();
        return t;
    }
}
