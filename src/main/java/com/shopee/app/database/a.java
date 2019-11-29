package com.shopee.app.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.garena.android.appkit.a.b;
import com.garena.android.appkit.a.c;

public class a extends com.garena.android.appkit.a.a {
    public a(Context context, String str, b bVar) {
        super(context, str, bVar, 31);
    }

    /* access modifiers changed from: protected */
    public c a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        return new c(sQLiteDatabase, i, i2);
    }
}
