package com.crashlytics.android.a;

import android.content.Context;
import io.a.a.a.a.b.i;
import io.a.a.a.a.b.p;
import java.util.Map;
import java.util.UUID;

class ag {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6304a;

    /* renamed from: b  reason: collision with root package name */
    private final p f6305b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6306c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6307d;

    public ag(Context context, p pVar, String str, String str2) {
        this.f6304a = context;
        this.f6305b = pVar;
        this.f6306c = str;
        this.f6307d = str2;
    }

    public ae a() {
        Map<p.a, String> h = this.f6305b.h();
        String m = i.m(this.f6304a);
        String d2 = this.f6305b.d();
        String g2 = this.f6305b.g();
        return new ae(this.f6305b.c(), UUID.randomUUID().toString(), this.f6305b.b(), h.get(p.a.ANDROID_ID), h.get(p.a.ANDROID_ADVERTISING_ID), this.f6305b.j(), h.get(p.a.FONT_TOKEN), m, d2, g2, this.f6306c, this.f6307d);
    }
}
