package com.google.a;

import com.google.a.b.a;
import com.google.a.b.a.l;
import com.google.a.b.a.n;
import com.google.a.b.d;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private d f8925a = d.f8856a;

    /* renamed from: b  reason: collision with root package name */
    private v f8926b = v.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    private e f8927c = d.IDENTITY;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Type, h<?>> f8928d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final List<x> f8929e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<x> f8930f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f8931g = false;
    private String h;
    private int i = 2;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    public g a() {
        this.f8931g = true;
        return this;
    }

    public g a(d dVar) {
        this.f8927c = dVar;
        return this;
    }

    public g b() {
        this.n = true;
        return this;
    }

    public g a(String str) {
        this.h = str;
        return this;
    }

    public g a(Type type, Object obj) {
        boolean z = obj instanceof t;
        a.a(z || (obj instanceof k) || (obj instanceof h) || (obj instanceof w));
        if (obj instanceof h) {
            this.f8928d.put(type, (h) obj);
        }
        if (z || (obj instanceof k)) {
            this.f8929e.add(l.a(com.google.a.c.a.get(type), obj));
        }
        if (obj instanceof w) {
            this.f8929e.add(n.a(com.google.a.c.a.get(type), (w) obj));
        }
        return this;
    }

    public g a(x xVar) {
        this.f8929e.add(xVar);
        return this;
    }

    public g a(Class<?> cls, Object obj) {
        boolean z = obj instanceof t;
        a.a(z || (obj instanceof k) || (obj instanceof w));
        if ((obj instanceof k) || z) {
            this.f8930f.add(l.a(cls, obj));
        }
        if (obj instanceof w) {
            this.f8929e.add(n.b(cls, (w) obj));
        }
        return this;
    }

    public g c() {
        this.l = true;
        return this;
    }

    public f d() {
        ArrayList arrayList = r1;
        ArrayList arrayList2 = new ArrayList(this.f8929e.size() + this.f8930f.size() + 3);
        arrayList2.addAll(this.f8929e);
        Collections.reverse(arrayList2);
        ArrayList arrayList3 = new ArrayList(this.f8930f);
        Collections.reverse(arrayList3);
        arrayList2.addAll(arrayList3);
        a(this.h, this.i, this.j, arrayList2);
        return new f(this.f8925a, this.f8927c, this.f8928d, this.f8931g, this.k, this.o, this.m, this.n, this.p, this.l, this.f8926b, this.h, this.i, this.j, this.f8929e, this.f8930f, arrayList);
    }

    private void a(String str, int i2, int i3, List<x> list) {
        a aVar;
        a aVar2;
        a aVar3;
        if (str != null && !"".equals(str.trim())) {
            a aVar4 = new a(Date.class, str);
            aVar = new a(Timestamp.class, str);
            aVar3 = new a(java.sql.Date.class, str);
            aVar2 = aVar4;
        } else if (i2 != 2 && i3 != 2) {
            aVar2 = new a(Date.class, i2, i3);
            a aVar5 = new a(Timestamp.class, i2, i3);
            a aVar6 = new a(java.sql.Date.class, i2, i3);
            aVar = aVar5;
            aVar3 = aVar6;
        } else {
            return;
        }
        list.add(n.a(Date.class, aVar2));
        list.add(n.a(Timestamp.class, aVar));
        list.add(n.a(java.sql.Date.class, aVar3));
    }
}
