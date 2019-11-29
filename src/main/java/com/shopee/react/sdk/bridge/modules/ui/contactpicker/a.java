package com.shopee.react.sdk.bridge.modules.ui.contactpicker;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.react.bridge.Promise;
import com.google.a.o;
import com.shopee.react.sdk.bridge.modules.base.d;
import com.shopee.react.sdk.bridge.protocol.ContactPickerResult;

public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private Promise f30194a;

    a() {
    }

    /* access modifiers changed from: package-private */
    public void a(Activity activity, Promise promise) {
        this.f30194a = promise;
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(Uri.parse("content://contacts"), "vnd.android.cursor.dir/phone_v2");
        activity.startActivityForResult(intent, 3);
    }

    /* access modifiers changed from: package-private */
    public void a(o oVar) {
        if (this.f30194a != null) {
            String str = "";
            String c2 = oVar.b("phone") ? oVar.c("phone").c() : str;
            if (oVar.b("name")) {
                str = oVar.c("name").c();
            }
            if (!TextUtils.isEmpty(c2) || !TextUtils.isEmpty(str)) {
                this.f30194a.resolve(com.shopee.react.sdk.a.a.f30143a.b((Object) new ContactPickerResult.Builder().data(new ContactPickerResult.ContactData(str, c2)).error(0).build()));
                this.f30194a = null;
                return;
            }
            a(1);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        if (this.f30194a != null) {
            this.f30194a.resolve(com.shopee.react.sdk.a.a.f30143a.b((Object) new ContactPickerResult.Builder().error(i).build()));
            this.f30194a = null;
        }
    }

    static o a(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = null;
        try {
            int i = 0;
            Cursor query = contentResolver.query(uri, new String[]{"data1", "display_name"}, (String) null, (String[]) null, (String) null);
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
        } catch (Exception unused) {
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
