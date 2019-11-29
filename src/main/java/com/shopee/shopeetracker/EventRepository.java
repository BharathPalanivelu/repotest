package com.shopee.shopeetracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.shopeetracker.model.UserAction;
import com.shopee.shopeetracker.utils.Clock;
import com.shopee.shopeetracker.utils.Logger;
import com.shopee.shopeetracker.utils.SystemClock;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EventRepository {
    /* access modifiers changed from: private */
    public static final String[] PROJECTION = {"ID", EventEntry.COL_CREATED_AT, EventEntry.COL_VALUE, EventEntry.COL_TYPE};
    public static final String TABLE = "event";
    /* access modifiers changed from: private */
    public Converter<UserAction, Cursor> cursorToEvent;
    /* access modifiers changed from: private */
    public Converter<ContentValues, UserAction> eventToValues;
    private ExecutorService mService = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */
    public SQLiteOpenHelper sqLiteOpenHelper;

    interface Converter<T, R> {
        T convert(R r);
    }

    public static class EventEntry {
        public static final String COL_CREATED_AT = "CREATED_AT";
        public static final String COL_ID = "ID";
        public static final String COL_TYPE = "TYPE";
        public static final String COL_VALUE = "VALUE";
    }

    public EventRepository(SQLiteOpenHelper sQLiteOpenHelper) {
        this.sqLiteOpenHelper = sQLiteOpenHelper;
        this.eventToValues = new EventToValues(new SystemClock());
        this.cursorToEvent = new CursorToEvent();
    }

    public void add(final UserAction userAction) {
        this.mService.submit(new Runnable() {
            public void run() {
                EventRepository.this.sqLiteOpenHelper.getWritableDatabase().insert(EventRepository.TABLE, (String) null, (ContentValues) EventRepository.this.eventToValues.convert(userAction));
            }
        });
    }

    private void remove(UserAction userAction) {
        this.sqLiteOpenHelper.getWritableDatabase().delete(TABLE, "ID = ?", new String[]{String.valueOf(userAction.getId())});
    }

    /* access modifiers changed from: package-private */
    public Future<List<UserAction>> queryAll(final int i, final int i2) {
        return this.mService.submit(new Callable<List<UserAction>>() {
            public List<UserAction> call() throws Exception {
                ArrayList arrayList = new ArrayList();
                Cursor query = EventRepository.this.sqLiteOpenHelper.getReadableDatabase().query(EventRepository.TABLE, EventRepository.PROJECTION, "TYPE = ? ", new String[]{String.valueOf(i2)}, (String) null, (String) null, "ID ASC", String.valueOf(i));
                try {
                    int count = query.getCount();
                    for (int i = 0; i < count; i++) {
                        query.moveToPosition(i);
                        arrayList.add(EventRepository.this.cursorToEvent.convert(query));
                    }
                } catch (Exception e2) {
                    Logger.debug(e2.getMessage());
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
                query.close();
                return arrayList;
            }
        });
    }

    public void remove(final List<UserAction> list) {
        this.mService.submit(new Runnable() {
            public void run() {
                SQLiteDatabase writableDatabase = EventRepository.this.sqLiteOpenHelper.getWritableDatabase();
                ArrayList arrayList = new ArrayList();
                for (UserAction id : list) {
                    arrayList.add(Long.valueOf(id.getId()));
                }
                if (!arrayList.isEmpty()) {
                    writableDatabase.delete(EventRepository.TABLE, "ID IN (?)", new String[]{TextUtils.join(", ", arrayList)});
                }
            }
        });
    }

    public Future<Integer> removeByIds(final Set<Long> set) {
        return this.mService.submit(new Callable<Integer>() {
            public Integer call() {
                Set set = set;
                if (set == null || set.isEmpty()) {
                    return 0;
                }
                SQLiteDatabase writableDatabase = EventRepository.this.sqLiteOpenHelper.getWritableDatabase();
                String join = TextUtils.join(", ", set);
                int delete = writableDatabase.delete(EventRepository.TABLE, "ID IN (" + join + SQLBuilder.PARENTHESES_RIGHT, (String[]) null);
                StringBuilder sb = new StringBuilder();
                sb.append("[Tracker]delete record:");
                sb.append(delete);
                Logger.debug(sb.toString());
                return Integer.valueOf(delete);
            }
        });
    }

    private static class EventToValues implements Converter<ContentValues, UserAction> {
        private Clock clock;

        EventToValues(Clock clock2) {
            this.clock = clock2;
        }

        public ContentValues convert(UserAction userAction) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(EventEntry.COL_CREATED_AT, Long.valueOf(this.clock.currentTime()));
            contentValues.put(EventEntry.COL_TYPE, Integer.valueOf(userAction.getType()));
            contentValues.put(EventEntry.COL_VALUE, userAction.getActionData());
            return contentValues;
        }
    }

    private static class CursorToEvent implements Converter<UserAction, Cursor> {
        private CursorToEvent() {
        }

        public UserAction convert(Cursor cursor) {
            return UserAction.from(cursor.getLong(cursor.getColumnIndex("ID")), cursor.getInt(cursor.getColumnIndex(EventEntry.COL_TYPE)), cursor.getString(cursor.getColumnIndex(EventEntry.COL_VALUE)));
        }
    }
}
