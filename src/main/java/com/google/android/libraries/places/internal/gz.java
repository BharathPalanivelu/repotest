package com.google.android.libraries.places.internal;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class gz<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object[] f6712a = new Object[0];

    gz() {
    }

    /* renamed from: a */
    public abstract hu<E> iterator();

    /* access modifiers changed from: package-private */
    public Object[] b() {
        return null;
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    public abstract boolean f();

    public final Object[] toArray() {
        return toArray(f6712a);
    }

    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        go.a(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] b2 = b();
            if (b2 != null) {
                return Arrays.copyOfRange(b2, c(), d(), tArr.getClass());
            }
            tArr = go.a(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        a(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int d() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ha<E> e() {
        return isEmpty() ? ha.g() : ha.b(toArray());
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int a(Object[] objArr, int i) {
        hu huVar = (hu) iterator();
        while (huVar.hasNext()) {
            objArr[i] = huVar.next();
            i++;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new hb(toArray());
    }
}
