package qalsdk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class aj extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static int f34095a = 6;

    /* renamed from: b  reason: collision with root package name */
    private static String f34096b = "create table conntime(_id INTEGER PRIMARY KEY,timestamp INTEGER NOT NULL,cost_time INTEGER NOT NULL,result CHAR NOT NULL,os CHAR(20) ,os_version CHAR(20) ,sdk_version INTEGER NOT NULL,process_status INTEGER NOT NULL,server_ip_port CHAR(100) ,gateway_ip CHAR(20) ,errcode INTEGER DEFAULT 0 ,net_info VAECHAR(500) )";

    public aj(Context context) {
        super(context, "qal_monitor.db", (SQLiteDatabase.CursorFactory) null, f34095a);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f34096b);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("drop table conntime");
        sQLiteDatabase.execSQL(f34096b);
    }
}
