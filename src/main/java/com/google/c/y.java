package com.google.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class y extends d<String> implements z, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    public static final z f14071a = f14072b;

    /* renamed from: b  reason: collision with root package name */
    private static final y f14072b = new y();

    /* renamed from: c  reason: collision with root package name */
    private final List<Object> f14073c;

    public /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    static {
        f14072b.b();
    }

    public y() {
        this(10);
    }

    public y(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    public y(z zVar) {
        this.f14073c = new ArrayList(zVar.size());
        addAll(zVar);
    }

    private y(ArrayList<Object> arrayList) {
        this.f14073c = arrayList;
    }

    /* renamed from: a */
    public String get(int i) {
        Object obj = this.f14073c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.f14073c.set(i, d2);
            }
            return d2;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = u.b(bArr);
        if (u.a(bArr)) {
            this.f14073c.set(i, b2);
        }
        return b2;
    }

    public int size() {
        return this.f14073c.size();
    }

    /* renamed from: a */
    public String set(int i, String str) {
        c();
        return a(this.f14073c.set(i, str));
    }

    /* renamed from: b */
    public void add(int i, String str) {
        c();
        this.f14073c.add(i, str);
        this.modCount++;
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public boolean addAll(int i, Collection<? extends String> collection) {
        c();
        if (collection instanceof z) {
            collection = ((z) collection).d();
        }
        boolean addAll = this.f14073c.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    /* renamed from: b */
    public String remove(int i) {
        c();
        Object remove = this.f14073c.remove(i);
        this.modCount++;
        return a(remove);
    }

    public void clear() {
        c();
        this.f14073c.clear();
        this.modCount++;
    }

    public void a(f fVar) {
        c();
        this.f14073c.add(fVar);
        this.modCount++;
    }

    public Object c(int i) {
        return this.f14073c.get(i);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof f) {
            return ((f) obj).d();
        }
        return u.b((byte[]) obj);
    }

    public List<?> d() {
        return Collections.unmodifiableList(this.f14073c);
    }

    public z e() {
        return a() ? new av(this) : this;
    }
}
