package com.c.a;

import android.content.Context;
import androidx.b.a;
import com.c.a.c.b.a.b;
import com.c.a.c.b.a.e;
import com.c.a.c.b.a.j;
import com.c.a.c.b.a.k;
import com.c.a.c.b.b.a;
import com.c.a.c.b.b.h;
import com.c.a.c.b.b.i;
import com.c.a.c.b.i;
import com.c.a.d.f;
import com.c.a.d.l;
import com.c.a.g.g;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f6114a = new a();

    /* renamed from: b  reason: collision with root package name */
    private i f6115b;

    /* renamed from: c  reason: collision with root package name */
    private e f6116c;

    /* renamed from: d  reason: collision with root package name */
    private b f6117d;

    /* renamed from: e  reason: collision with root package name */
    private h f6118e;

    /* renamed from: f  reason: collision with root package name */
    private com.c.a.c.b.c.a f6119f;

    /* renamed from: g  reason: collision with root package name */
    private com.c.a.c.b.c.a f6120g;
    private a.C0099a h;
    private com.c.a.c.b.b.i i;
    private com.c.a.d.d j;
    private int k = 4;
    private g l = new g();
    private l.a m;

    /* access modifiers changed from: package-private */
    public d a(l.a aVar) {
        this.m = aVar;
        return this;
    }

    public c a(Context context) {
        if (this.f6119f == null) {
            this.f6119f = com.c.a.c.b.c.a.b();
        }
        if (this.f6120g == null) {
            this.f6120g = com.c.a.c.b.c.a.a();
        }
        if (this.i == null) {
            this.i = new i.a(context).a();
        }
        if (this.j == null) {
            this.j = new f();
        }
        if (this.f6116c == null) {
            int b2 = this.i.b();
            if (b2 > 0) {
                this.f6116c = new k(b2);
            } else {
                this.f6116c = new com.c.a.c.b.a.f();
            }
        }
        if (this.f6117d == null) {
            this.f6117d = new j(this.i.c());
        }
        if (this.f6118e == null) {
            this.f6118e = new com.c.a.c.b.b.g(this.i.a());
        }
        if (this.h == null) {
            this.h = new com.c.a.c.b.b.f(context);
        }
        if (this.f6115b == null) {
            this.f6115b = new com.c.a.c.b.i(this.f6118e, this.h, this.f6120g, this.f6119f, com.c.a.c.b.c.a.c(), com.c.a.c.b.c.a.d());
        }
        return new c(context, this.f6115b, this.f6118e, this.f6116c, this.f6117d, new l(this.m), this.j, this.k, this.l.b(), this.f6114a);
    }
}
