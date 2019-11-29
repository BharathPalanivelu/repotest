package com.shopee.b;

import android.content.Context;
import com.shopee.b.a.b;
import com.shopee.b.a.c;
import com.shopee.b.a.d;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f27077a;

    public a(Context context) {
        j.b(context, "context");
        this.f27077a = context.getApplicationContext();
    }

    public final c a() {
        Context context = this.f27077a;
        j.a((Object) context, "applicationContext");
        return new c(context);
    }

    public final d b() {
        Context context = this.f27077a;
        j.a((Object) context, "applicationContext");
        return new d(context);
    }

    public final b c() {
        Context context = this.f27077a;
        j.a((Object) context, "applicationContext");
        return new b(context);
    }

    public final com.shopee.b.c.b d() {
        Context context = this.f27077a;
        j.a((Object) context, "applicationContext");
        return new com.shopee.b.c.b(context);
    }
}
