package com.c.a.c.b;

import android.util.Log;
import com.c.a.c.a;
import com.c.a.c.a.b;
import com.c.a.c.b.d;
import com.c.a.c.c.n;
import com.c.a.c.h;
import java.util.Collections;
import java.util.List;

class w implements b.a<Object>, d, d.a {

    /* renamed from: a  reason: collision with root package name */
    private final e<?> f5883a;

    /* renamed from: b  reason: collision with root package name */
    private final d.a f5884b;

    /* renamed from: c  reason: collision with root package name */
    private int f5885c;

    /* renamed from: d  reason: collision with root package name */
    private a f5886d;

    /* renamed from: e  reason: collision with root package name */
    private Object f5887e;

    /* renamed from: f  reason: collision with root package name */
    private volatile n.a<?> f5888f;

    /* renamed from: g  reason: collision with root package name */
    private b f5889g;

    public w(e<?> eVar, d.a aVar) {
        this.f5883a = eVar;
        this.f5884b = aVar;
    }

    public boolean a() {
        Object obj = this.f5887e;
        if (obj != null) {
            this.f5887e = null;
            b(obj);
        }
        a aVar = this.f5886d;
        if (aVar != null && aVar.a()) {
            return true;
        }
        this.f5886d = null;
        this.f5888f = null;
        boolean z = false;
        while (!z && d()) {
            List<n.a<?>> k = this.f5883a.k();
            int i = this.f5885c;
            this.f5885c = i + 1;
            this.f5888f = k.get(i);
            if (this.f5888f != null && (this.f5883a.c().a(this.f5888f.f5951c.c()) || this.f5883a.a((Class<?>) this.f5888f.f5951c.d()))) {
                this.f5888f.f5951c.a(this.f5883a.d(), this);
                z = true;
            }
        }
        return z;
    }

    private boolean d() {
        return this.f5885c < this.f5883a.k().size();
    }

    /* JADX INFO: finally extract failed */
    private void b(Object obj) {
        long a2 = com.c.a.i.d.a();
        try {
            com.c.a.c.d<X> a3 = this.f5883a.a(obj);
            c cVar = new c(a3, obj, this.f5883a.e());
            this.f5889g = new b(this.f5888f.f5949a, this.f5883a.f());
            this.f5883a.b().a(this.f5889g, cVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f5889g + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.c.a.i.d.a(a2));
            }
            this.f5888f.f5951c.a();
            this.f5886d = new a(Collections.singletonList(this.f5888f.f5949a), this.f5883a, this);
        } catch (Throwable th) {
            this.f5888f.f5951c.a();
            throw th;
        }
    }

    public void b() {
        n.a<?> aVar = this.f5888f;
        if (aVar != null) {
            aVar.f5951c.b();
        }
    }

    public void a(Object obj) {
        h c2 = this.f5883a.c();
        if (obj == null || !c2.a(this.f5888f.f5951c.c())) {
            this.f5884b.a(this.f5888f.f5949a, obj, this.f5888f.f5951c, this.f5888f.f5951c.c(), this.f5889g);
            return;
        }
        this.f5887e = obj;
        this.f5884b.c();
    }

    public void a(Exception exc) {
        this.f5884b.a(this.f5889g, exc, this.f5888f.f5951c, this.f5888f.f5951c.c());
    }

    public void c() {
        throw new UnsupportedOperationException();
    }

    public void a(h hVar, Object obj, b<?> bVar, a aVar, h hVar2) {
        this.f5884b.a(hVar, obj, bVar, this.f5888f.f5951c.c(), hVar);
    }

    public void a(h hVar, Exception exc, b<?> bVar, a aVar) {
        this.f5884b.a(hVar, exc, bVar, this.f5888f.f5951c.c());
    }
}
