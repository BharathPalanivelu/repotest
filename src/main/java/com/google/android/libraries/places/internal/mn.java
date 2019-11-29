package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.List;

public final class mn<E> extends jy<E> {

    /* renamed from: b  reason: collision with root package name */
    public static final mn<Object> f12974b;

    /* renamed from: c  reason: collision with root package name */
    private final List<E> f12975c;

    mn() {
        this(new ArrayList(10));
    }

    private mn(List<E> list) {
        this.f12975c = list;
    }

    public final void add(int i, E e2) {
        c();
        this.f12975c.add(i, e2);
        this.modCount++;
    }

    public final E get(int i) {
        return this.f12975c.get(i);
    }

    public final E remove(int i) {
        c();
        E remove = this.f12975c.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e2) {
        c();
        E e3 = this.f12975c.set(i, e2);
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.f12975c.size();
    }

    public final /* synthetic */ lc b(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f12975c);
            return new mn(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        mn<Object> mnVar = new mn<>(new ArrayList(0));
        f12974b = mnVar;
        mnVar.f12858a = false;
    }
}
