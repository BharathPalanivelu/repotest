package com.c.a.c.b;

import com.c.a.c.b.b.a;
import com.c.a.c.b.f;
import com.c.a.c.c.n;
import com.c.a.c.d;
import com.c.a.c.d.b;
import com.c.a.c.h;
import com.c.a.c.j;
import com.c.a.c.l;
import com.c.a.c.m;
import com.c.a.g;
import com.c.a.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class e<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n.a<?>> f5778a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<h> f5779b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private com.c.a.e f5780c;

    /* renamed from: d  reason: collision with root package name */
    private Object f5781d;

    /* renamed from: e  reason: collision with root package name */
    private int f5782e;

    /* renamed from: f  reason: collision with root package name */
    private int f5783f;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f5784g;
    private f.d h;
    private j i;
    private Map<Class<?>, m<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private h n;
    private g o;
    private h p;
    private boolean q;
    private boolean r;

    e() {
    }

    /* access modifiers changed from: package-private */
    public <R> e<R> a(com.c.a.e eVar, Object obj, h hVar, int i2, int i3, h hVar2, Class<?> cls, Class<R> cls2, g gVar, j jVar, Map<Class<?>, m<?>> map, boolean z, boolean z2, f.d dVar) {
        this.f5780c = eVar;
        this.f5781d = obj;
        this.n = hVar;
        this.f5782e = i2;
        this.f5783f = i3;
        this.p = hVar2;
        this.f5784g = cls;
        this.h = dVar;
        this.k = cls2;
        this.o = gVar;
        this.i = jVar;
        this.j = map;
        this.q = z;
        this.r = z2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f5780c = null;
        this.f5781d = null;
        this.n = null;
        this.f5784g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f5778a.clear();
        this.l = false;
        this.f5779b.clear();
        this.m = false;
    }

    /* access modifiers changed from: package-private */
    public a b() {
        return this.h.a();
    }

    /* access modifiers changed from: package-private */
    public h c() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public g d() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public j e() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public h f() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f5782e;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f5783f;
    }

    /* access modifiers changed from: package-private */
    public List<Class<?>> i() {
        return this.f5780c.d().b(this.f5781d.getClass(), this.f5784g, this.k);
    }

    /* access modifiers changed from: package-private */
    public boolean a(Class<?> cls) {
        return b(cls) != null;
    }

    /* access modifiers changed from: package-private */
    public <Data> q<Data, ?, Transcode> b(Class<Data> cls) {
        return this.f5780c.d().a(cls, this.f5784g, this.k);
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public <Z> m<Z> c(Class<Z> cls) {
        m<Z> mVar = this.j.get(cls);
        if (mVar == null) {
            Iterator<Map.Entry<Class<?>, m<?>>> it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    mVar = (m) next.getValue();
                    break;
                }
            }
        }
        if (mVar != null) {
            return mVar;
        }
        if (!this.j.isEmpty() || !this.q) {
            return b.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* access modifiers changed from: package-private */
    public boolean a(s<?> sVar) {
        return this.f5780c.d().a(sVar);
    }

    /* access modifiers changed from: package-private */
    public <Z> l<Z> b(s<Z> sVar) {
        return this.f5780c.d().b(sVar);
    }

    /* access modifiers changed from: package-private */
    public List<n<File, ?>> a(File file) throws h.c {
        return this.f5780c.d().c(file);
    }

    /* access modifiers changed from: package-private */
    public boolean a(com.c.a.c.h hVar) {
        List<n.a<?>> k2 = k();
        int size = k2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (k2.get(i2).f5949a.equals(hVar)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public List<n.a<?>> k() {
        if (!this.l) {
            this.l = true;
            this.f5778a.clear();
            List c2 = this.f5780c.d().c(this.f5781d);
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a a2 = ((n) c2.get(i2)).a(this.f5781d, this.f5782e, this.f5783f, this.i);
                if (a2 != null) {
                    this.f5778a.add(a2);
                }
            }
        }
        return this.f5778a;
    }

    /* access modifiers changed from: package-private */
    public List<com.c.a.c.h> l() {
        if (!this.m) {
            this.m = true;
            this.f5779b.clear();
            List<n.a<?>> k2 = k();
            int size = k2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a aVar = k2.get(i2);
                if (!this.f5779b.contains(aVar.f5949a)) {
                    this.f5779b.add(aVar.f5949a);
                }
                for (int i3 = 0; i3 < aVar.f5950b.size(); i3++) {
                    if (!this.f5779b.contains(aVar.f5950b.get(i3))) {
                        this.f5779b.add(aVar.f5950b.get(i3));
                    }
                }
            }
        }
        return this.f5779b;
    }

    /* access modifiers changed from: package-private */
    public <X> d<X> a(X x) throws h.e {
        return this.f5780c.d().a(x);
    }
}
