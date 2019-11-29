package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class lk extends jy<String> implements ll, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final lk f12935b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Object> f12936c;

    public lk() {
        this(10);
    }

    public lk(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private lk(ArrayList<Object> arrayList) {
        this.f12936c = arrayList;
    }

    public final int size() {
        return this.f12936c.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        c();
        if (collection instanceof ll) {
            collection = ((ll) collection).d();
        }
        boolean addAll = this.f12936c.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        c();
        this.f12936c.clear();
        this.modCount++;
    }

    public final void a(kc kcVar) {
        c();
        this.f12936c.add(kcVar);
        this.modCount++;
    }

    public final Object a(int i) {
        return this.f12936c.get(i);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof kc) {
            return ((kc) obj).c();
        }
        return kx.b((byte[]) obj);
    }

    public final List<?> d() {
        return Collections.unmodifiableList(this.f12936c);
    }

    public final ll e() {
        return a() ? new nh(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        c();
        return a(this.f12936c.set(i, (String) obj));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* synthetic */ Object remove(int i) {
        c();
        Object remove = this.f12936c.remove(i);
        this.modCount++;
        return a(remove);
    }

    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        c();
        this.f12936c.add(i, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ lc b(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f12936c);
            return new lk((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.f12936c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof kc) {
            kc kcVar = (kc) obj;
            String c2 = kcVar.c();
            if (kcVar.d()) {
                this.f12936c.set(i, c2);
            }
            return c2;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = kx.b(bArr);
        if (kx.a(bArr)) {
            this.f12936c.set(i, b2);
        }
        return b2;
    }

    static {
        lk lkVar = new lk();
        f12935b = lkVar;
        lkVar.f12858a = false;
    }
}
