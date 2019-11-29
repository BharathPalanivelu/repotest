package com.shopee.app.pushnotification;

import android.content.Context;
import android.net.Uri;
import com.appsflyer.share.Constants;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f18538a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18539b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18540c;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (j.a((Object) this.f18538a, (Object) eVar.f18538a)) {
                    if (this.f18539b == eVar.f18539b) {
                        if (this.f18540c == eVar.f18540c) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f18538a;
        return ((((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.f18539b).hashCode()) * 31) + Integer.valueOf(this.f18540c).hashCode();
    }

    public String toString() {
        return "ShopeeNotificationSound(id=" + this.f18538a + ", nameId=" + this.f18539b + ", soundRawId=" + this.f18540c + SQLBuilder.PARENTHESES_RIGHT;
    }

    public e(String str, int i, int i2) {
        j.b(str, "id");
        this.f18538a = str;
        this.f18539b = i;
        this.f18540c = i2;
    }

    public final String a() {
        return this.f18538a;
    }

    public final int b() {
        return this.f18539b;
    }

    public final int c() {
        return this.f18540c;
    }

    public final Uri a(Context context) {
        if (context == null) {
            return null;
        }
        return Uri.parse("android.resource://" + context.getPackageName() + Constants.URL_PATH_DELIMITER + this.f18540c);
    }
}
