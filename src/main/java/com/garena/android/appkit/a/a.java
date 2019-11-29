package com.garena.android.appkit.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.HashMap;

public abstract class a extends OrmLiteSqliteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private final b f7604a;

    /* access modifiers changed from: protected */
    public abstract c a(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public a(Context context, String str, b bVar, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f7604a = bVar;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            b();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a("%s %s %s", a.class.getName(), "can't create database", e2);
            throw new RuntimeException(e2);
        }
    }

    public void a() {
        getReadableDatabase();
    }

    private void b() throws SQLException {
        HashMap<String, com.garena.android.appkit.a.a.a> b2 = this.f7604a.b();
        for (String str : b2.keySet()) {
            TableUtils.createTableIfNotExists((ConnectionSource) this.connectionSource, b2.get(str).c());
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        com.garena.android.appkit.d.a.e("Database upgrade call back", new Object[0]);
        if (i2 > i) {
            a(sQLiteDatabase, i, i2).c();
        }
    }
}
