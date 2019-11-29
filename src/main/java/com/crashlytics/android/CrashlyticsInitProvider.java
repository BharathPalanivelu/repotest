package com.crashlytics.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.a.a.a.a.b.o;
import io.a.a.a.c;

public class CrashlyticsInitProvider extends ContentProvider {

    interface a {
        boolean a(Context context);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        Context context = getContext();
        if (a(context, new o(), new b())) {
            try {
                c.a(context, new a());
                c.h().c("CrashlyticsInitProvider", "CrashlyticsInitProvider initialization successful");
            } catch (IllegalStateException unused) {
                c.h().c("CrashlyticsInitProvider", "CrashlyticsInitProvider initialization unsuccessful");
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(Context context, o oVar, a aVar) {
        return oVar.b(context) && aVar.a(context);
    }
}
