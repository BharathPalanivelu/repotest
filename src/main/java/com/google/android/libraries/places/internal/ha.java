package com.google.android.libraries.places.internal;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ha<E> extends gz<E> implements List<E>, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    private static final hv<Object> f6713a = new gt(hm.f12653a, 0);

    public static <E> ha<E> g() {
        return hm.f12653a;
    }

    public final ha<E> e() {
        return this;
    }

    public static <E> ha<E> a(E e2) {
        Object[] a2 = go.a(e2);
        return b(a2, a2.length);
    }

    public static <E> ha<E> a(Collection<? extends E> collection) {
        if (collection instanceof gz) {
            ha<E> e2 = ((gz) collection).e();
            if (!e2.f()) {
                return e2;
            }
            Object[] array = e2.toArray();
            return b(array, array.length);
        }
        Object[] a2 = go.a(collection.toArray());
        return b(a2, a2.length);
    }

    public static <E> ha<E> a(E[] eArr) {
        if (eArr.length == 0) {
            return hm.f12653a;
        }
        Object[] a2 = go.a((Object[]) eArr.clone());
        return b(a2, a2.length);
    }

    static <E> ha<E> b(Object[] objArr) {
        return b(objArr, objArr.length);
    }

    static <E> ha<E> b(Object[] objArr, int i) {
        if (i == 0) {
            return hm.f12653a;
        }
        return new hm(objArr, i);
    }

    ha() {
    }

    public final hu<E> a() {
        return (hv) listIterator();
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        return go.b((List<?>) this, obj);
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        return go.d(this, obj);
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    /* renamed from: a */
    public ha<E> subList(int i, int i2) {
        go.a(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return hm.f12653a;
        }
        return new hc(this, i, i3);
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public boolean equals(@NullableDecl Object obj) {
        return go.a((List<?>) this, obj);
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ -1) ^ -1;
        }
        return i;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new hb(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        go.b(i, size());
        if (isEmpty()) {
            return f6713a;
        }
        return new gt(this, i);
    }

    public /* synthetic */ ListIterator listIterator() {
        return (hv) listIterator(0);
    }
}
