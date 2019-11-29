package com.shopee.app.d.c.a;

import com.garena.android.appkit.f.e;
import com.shopee.app.d.c.a.a.C0253a;
import com.shopee.app.util.n;
import com.shopee.app.util.n.b;
import java.util.concurrent.ConcurrentHashMap;
import org.a.a.a;

public abstract class a<T extends C0253a> {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static ConcurrentHashMap<String, C0253a> f16404d = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    protected n f16405a;

    /* renamed from: b  reason: collision with root package name */
    protected b f16406b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f16407c = true;

    /* access modifiers changed from: protected */
    public abstract void a(T t);

    protected a(n nVar) {
        this.f16405a = nVar;
        this.f16406b = new b();
    }

    public void b(final T t) {
        int i = this.f16407c ? 0 : t.h;
        this.f16407c = false;
        final T t2 = t;
        final AnonymousClass1 r2 = new a.C0532a(t.f16413e, 0, t.f16414f) {
            public void execute() {
                a.this.c(t2);
            }
        };
        if (!t.f16415g || i <= 0) {
            org.a.a.a.a((a.C0532a) r2);
        } else if (f16404d.get(t.f16413e) == null) {
            f16404d.put(t.f16413e, t);
            e.a().a(new Runnable() {
                public void run() {
                    a.f16404d.remove(t.f16413e);
                    org.a.a.a.a(r2);
                }
            }, t.h);
        }
    }

    /* access modifiers changed from: private */
    public void c(T t) {
        this.f16406b.a(t.f16413e);
        this.f16406b.a();
        try {
            this.f16406b.b();
            a(t);
            this.f16406b.c();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            this.f16406b.a(e2);
        }
    }

    /* renamed from: com.shopee.app.d.c.a.a$a  reason: collision with other inner class name */
    public static class C0253a {

        /* renamed from: e  reason: collision with root package name */
        public String f16413e;

        /* renamed from: f  reason: collision with root package name */
        public String f16414f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f16415g;
        public int h;

        public C0253a(String str, String str2, int i, boolean z) {
            this.f16413e = str;
            this.f16414f = str2;
            this.h = i;
            this.f16415g = z;
        }
    }
}
