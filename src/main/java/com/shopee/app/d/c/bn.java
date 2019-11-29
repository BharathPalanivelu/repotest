package com.shopee.app.d.c;

import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.c;
import com.shopee.app.database.orm.bean.DBActionContent;
import com.shopee.app.util.n;

public class bn extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final c f16604d;

    /* renamed from: e  reason: collision with root package name */
    private final com.shopee.app.data.store.b f16605e;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f16606a;

        /* renamed from: b  reason: collision with root package name */
        public String f16607b;

        /* renamed from: c  reason: collision with root package name */
        public String f16608c;

        /* renamed from: d  reason: collision with root package name */
        public String f16609d;

        /* renamed from: e  reason: collision with root package name */
        public String f16610e;

        /* renamed from: f  reason: collision with root package name */
        public String f16611f;

        /* renamed from: g  reason: collision with root package name */
        public String f16612g;
        public String h;
        public String i;
        public String j;
    }

    protected bn(n nVar, com.shopee.app.data.store.b bVar, c cVar) {
        super(nVar);
        this.f16604d = cVar;
        this.f16605e = bVar;
    }

    public void a() {
        b(new a());
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        b bVar = new b();
        long a2 = this.f16605e.a(1);
        if (a2 != -1) {
            DBActionContent a3 = this.f16604d.a(a2);
            if (a3 != null) {
                bVar.f16606a = new String(a3.c());
            }
        }
        long a4 = this.f16605e.a(2);
        if (a4 != -1) {
            DBActionContent a5 = this.f16604d.a(a4);
            if (a5 != null) {
                bVar.f16607b = new String(a5.c());
            }
        }
        long a6 = this.f16605e.a(6);
        if (a6 != -1) {
            DBActionContent a7 = this.f16604d.a(a6);
            if (a7 != null) {
                bVar.f16608c = new String(a7.c());
            }
        }
        long a8 = this.f16605e.a(8);
        if (a8 != -1) {
            DBActionContent a9 = this.f16604d.a(a8);
            if (a9 != null) {
                bVar.f16609d = new String(a9.c());
            }
        }
        long a10 = this.f16605e.a(7);
        if (a10 != -1) {
            DBActionContent a11 = this.f16604d.a(a10);
            if (a11 != null) {
                bVar.f16610e = new String(a11.c());
            }
        }
        long a12 = this.f16605e.a(9);
        if (a12 != -1) {
            DBActionContent a13 = this.f16604d.a(a12);
            if (a13 != null) {
                bVar.f16611f = new String(a13.c());
            }
        }
        long a14 = this.f16605e.a(10);
        if (a14 != -1) {
            DBActionContent a15 = this.f16604d.a(a14);
            if (a15 != null) {
                bVar.f16612g = new String(a15.c());
            }
        }
        long a16 = this.f16605e.a(11);
        if (a16 != -1) {
            DBActionContent a17 = this.f16604d.a(a16);
            if (a17 != null) {
                bVar.h = new String(a17.c());
            }
        }
        long a18 = this.f16605e.a(12);
        if (a18 != -1) {
            DBActionContent a19 = this.f16604d.a(a18);
            if (a19 != null) {
                bVar.i = new String(a19.c());
            }
        }
        long a20 = this.f16605e.a(13);
        if (a20 != -1) {
            DBActionContent a21 = this.f16604d.a(a20);
            if (a21 != null) {
                bVar.j = new String(a21.c());
            }
        }
        this.f16405a.a().bP.a(bVar).a();
    }

    public static class a extends a.C0253a {
        public a() {
            super("GetProbeActionInteractor", "use_case", 500, true);
        }
    }
}
