package com.shopee.app.g;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.garena.android.appkit.d.a;
import com.google.a.o;
import io.b.d.g;

public class n implements g<Void, o> {

    /* renamed from: a  reason: collision with root package name */
    private ContentResolver f17572a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f17573b;

    public n(ContentResolver contentResolver, Uri uri) {
        this.f17572a = contentResolver;
        this.f17573b = uri;
    }

    /* renamed from: a */
    public o apply(Void voidR) {
        Cursor cursor = null;
        try {
            int i = 0;
            Cursor query = this.f17572a.query(this.f17573b, new String[]{"data1", "display_name"}, (String) null, (String[]) null, (String) null);
            if (query != null) {
                query.moveToFirst();
            }
            int columnIndex = query.getColumnIndex("data1");
            int columnIndex2 = query.getColumnIndex("display_name");
            String string = query.getString(columnIndex);
            String string2 = query.getString(columnIndex2);
            if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string)) {
                i = 1;
            }
            o oVar = new o();
            oVar.a("status", (Number) Integer.valueOf(i));
            oVar.a("name", string2);
            oVar.a("phone", string);
            if (query != null) {
                query.close();
            }
            return oVar;
        } catch (Exception e2) {
            a.a(e2);
            if (cursor != null) {
                cursor.close();
            }
            o oVar2 = new o();
            oVar2.a("status", (Number) 1);
            return oVar2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
