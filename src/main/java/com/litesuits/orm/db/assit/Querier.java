package com.litesuits.orm.db.assit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.litesuits.orm.log.OrmLog;

public class Querier {
    private static final String TAG = "Querier";

    public static <T> T doQuery(SQLiteDatabase sQLiteDatabase, SQLStatement sQLStatement, CursorParser<T> cursorParser) {
        if (OrmLog.isPrint) {
            String str = TAG;
            OrmLog.d(str, "----> Query Start: " + sQLStatement.toString());
        }
        Cursor rawQuery = sQLiteDatabase.rawQuery(sQLStatement.sql, (String[]) sQLStatement.bindArgs);
        if (rawQuery != null) {
            cursorParser.process(sQLiteDatabase, rawQuery);
            if (OrmLog.isPrint) {
                String str2 = TAG;
                OrmLog.d(str2, "<---- Query End , cursor size : " + rawQuery.getCount());
            }
        } else if (OrmLog.isPrint) {
            OrmLog.e(TAG, "<---- Query End : cursor is null");
        }
        return cursorParser.returnResult();
    }

    public static abstract class CursorParser<T> {
        private boolean parse = true;

        public abstract void parseEachCursor(SQLiteDatabase sQLiteDatabase, Cursor cursor) throws Exception;

        public T returnResult() {
            return null;
        }

        public final void process(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
            try {
                cursor.moveToFirst();
                while (this.parse && !cursor.isAfterLast()) {
                    parseEachCursor(sQLiteDatabase, cursor);
                    cursor.moveToNext();
                }
                if (cursor == null) {
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursor == null) {
                    return;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            cursor.close();
        }

        public final void stopParse() {
            this.parse = false;
        }
    }
}
