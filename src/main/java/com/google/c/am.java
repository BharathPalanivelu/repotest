package com.google.c;

import com.google.c.a;
import com.google.c.a.C0223a;
import com.google.c.ag;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class am<MType extends a, BType extends a.C0223a, IType extends ag> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private a.b f13621a;

    /* renamed from: b  reason: collision with root package name */
    private List<MType> f13622b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13623c;

    /* renamed from: d  reason: collision with root package name */
    private List<an<MType, BType, IType>> f13624d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13625e;

    /* renamed from: f  reason: collision with root package name */
    private b<MType, BType, IType> f13626f;

    /* renamed from: g  reason: collision with root package name */
    private a<MType, BType, IType> f13627g;
    private c<MType, BType, IType> h;

    public am(List<MType> list, boolean z, a.b bVar, boolean z2) {
        this.f13622b = list;
        this.f13623c = z;
        this.f13621a = bVar;
        this.f13625e = z2;
    }

    public void b() {
        this.f13621a = null;
    }

    private void f() {
        if (!this.f13623c) {
            this.f13622b = new ArrayList(this.f13622b);
            this.f13623c = true;
        }
    }

    private void g() {
        if (this.f13624d == null) {
            this.f13624d = new ArrayList(this.f13622b.size());
            for (int i = 0; i < this.f13622b.size(); i++) {
                this.f13624d.add((Object) null);
            }
        }
    }

    public int c() {
        return this.f13622b.size();
    }

    public boolean d() {
        return this.f13622b.isEmpty();
    }

    public MType a(int i) {
        return a(i, false);
    }

    private MType a(int i, boolean z) {
        List<an<MType, BType, IType>> list = this.f13624d;
        if (list == null) {
            return (a) this.f13622b.get(i);
        }
        an anVar = list.get(i);
        if (anVar == null) {
            return (a) this.f13622b.get(i);
        }
        return z ? anVar.c() : anVar.b();
    }

    public BType b(int i) {
        g();
        an anVar = this.f13624d.get(i);
        if (anVar == null) {
            an anVar2 = new an((a) this.f13622b.get(i), this, this.f13625e);
            this.f13624d.set(i, anVar2);
            anVar = anVar2;
        }
        return anVar.d();
    }

    public IType c(int i) {
        List<an<MType, BType, IType>> list = this.f13624d;
        if (list == null) {
            return (ag) this.f13622b.get(i);
        }
        an anVar = list.get(i);
        if (anVar == null) {
            return (ag) this.f13622b.get(i);
        }
        return anVar.e();
    }

    public am<MType, BType, IType> a(MType mtype) {
        if (mtype != null) {
            f();
            this.f13622b.add(mtype);
            List<an<MType, BType, IType>> list = this.f13624d;
            if (list != null) {
                list.add((Object) null);
            }
            h();
            i();
            return this;
        }
        throw new NullPointerException();
    }

    public am<MType, BType, IType> a(Iterable<? extends MType> iterable) {
        Iterator<? extends MType> it = iterable.iterator();
        while (it.hasNext()) {
            if (((a) it.next()) == null) {
                throw new NullPointerException();
            }
        }
        int i = -1;
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() == 0) {
                return this;
            }
            i = collection.size();
        }
        f();
        if (i >= 0) {
            List<MType> list = this.f13622b;
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + i);
            }
        }
        Iterator<? extends MType> it2 = iterable.iterator();
        while (it2.hasNext()) {
            a((a) it2.next());
        }
        h();
        i();
        return this;
    }

    public List<MType> e() {
        boolean z;
        this.f13625e = true;
        if (!this.f13623c && this.f13624d == null) {
            return this.f13622b;
        }
        if (!this.f13623c) {
            int i = 0;
            while (true) {
                if (i >= this.f13622b.size()) {
                    z = true;
                    break;
                }
                ac acVar = (ac) this.f13622b.get(i);
                an anVar = this.f13624d.get(i);
                if (anVar != null && anVar.c() != acVar) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                return this.f13622b;
            }
        }
        f();
        for (int i2 = 0; i2 < this.f13622b.size(); i2++) {
            this.f13622b.set(i2, a(i2, true));
        }
        this.f13622b = Collections.unmodifiableList(this.f13622b);
        this.f13623c = false;
        return this.f13622b;
    }

    private void h() {
        if (this.f13625e) {
            a.b bVar = this.f13621a;
            if (bVar != null) {
                bVar.a();
                this.f13625e = false;
            }
        }
    }

    public void a() {
        h();
    }

    private void i() {
        b<MType, BType, IType> bVar = this.f13626f;
        if (bVar != null) {
            bVar.a();
        }
        a<MType, BType, IType> aVar = this.f13627g;
        if (aVar != null) {
            aVar.a();
        }
        c<MType, BType, IType> cVar = this.h;
        if (cVar != null) {
            cVar.a();
        }
    }

    private static class b<MType extends a, BType extends a.C0223a, IType extends ag> extends AbstractList<MType> implements List<MType> {

        /* renamed from: a  reason: collision with root package name */
        am<MType, BType, IType> f13629a;

        public int size() {
            return this.f13629a.c();
        }

        /* renamed from: a */
        public MType get(int i) {
            return this.f13629a.a(i);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.modCount++;
        }
    }

    private static class a<MType extends a, BType extends a.C0223a, IType extends ag> extends AbstractList<BType> implements List<BType> {

        /* renamed from: a  reason: collision with root package name */
        am<MType, BType, IType> f13628a;

        public int size() {
            return this.f13628a.c();
        }

        /* renamed from: a */
        public BType get(int i) {
            return this.f13628a.b(i);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.modCount++;
        }
    }

    private static class c<MType extends a, BType extends a.C0223a, IType extends ag> extends AbstractList<IType> implements List<IType> {

        /* renamed from: a  reason: collision with root package name */
        am<MType, BType, IType> f13630a;

        public int size() {
            return this.f13630a.c();
        }

        /* renamed from: a */
        public IType get(int i) {
            return this.f13630a.c(i);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.modCount++;
        }
    }
}
