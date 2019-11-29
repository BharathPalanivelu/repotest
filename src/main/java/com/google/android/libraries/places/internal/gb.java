package com.google.android.libraries.places.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.d;
import com.android.b.m;

public class gb implements ny {

    /* renamed from: a  reason: collision with root package name */
    public Context f12606a;

    /* renamed from: b  reason: collision with root package name */
    public aw f12607b;

    /* renamed from: c  reason: collision with root package name */
    public dw f12608c;

    public static synchronized fz a(d dVar, Bundle bundle) {
        fz a2;
        synchronized (gb.class) {
            a2 = fz.c().a(dVar).a(bundle).a();
        }
        return a2;
    }

    public static m a(Context context) {
        return (m) lt.a(fw.a(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    public /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public fx a() {
        lt.a(this.f12606a, Context.class);
        lt.a(this.f12607b, aw.class);
        lt.a(this.f12608c, dw.class);
        return new fx(this.f12606a, this.f12607b, this.f12608c, (byte) 0);
    }

    public gb() {
    }

    /* renamed from: c */
    public gb b(Context context) {
        this.f12606a = (Context) lt.b(context);
        return this;
    }

    /* renamed from: b */
    public gb a(aw awVar) {
        this.f12607b = (aw) lt.b(awVar);
        return this;
    }

    /* renamed from: b */
    public gb a(dw dwVar) {
        this.f12608c = (dw) lt.b(dwVar);
        return this;
    }

    public /* synthetic */ gb(byte b2) {
        this();
    }
}
