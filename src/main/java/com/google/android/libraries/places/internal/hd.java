package com.google.android.libraries.places.internal;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class hd<K, V> implements Serializable, Map<K, V> {
    @RetainedWith
    @LazyInit

    /* renamed from: a  reason: collision with root package name */
    private transient hg<Map.Entry<K, V>> f6714a;
    @RetainedWith
    @LazyInit

    /* renamed from: b  reason: collision with root package name */
    private transient hg<K> f6715b;
    @RetainedWith
    @LazyInit

    /* renamed from: c  reason: collision with root package name */
    private transient gz<V> f6716c;

    hd() {
    }

    /* access modifiers changed from: package-private */
    public abstract hg<Map.Entry<K, V>> a();

    /* access modifiers changed from: package-private */
    public abstract hg<K> b();

    /* access modifiers changed from: package-private */
    public abstract gz<V> c();

    public abstract V get(@NullableDecl Object obj);

    @CanIgnoreReturnValue
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((gz) values()).contains(obj);
    }

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean equals(@NullableDecl Object obj) {
        return go.a((Map<?, ?>) this, obj);
    }

    public int hashCode() {
        return go.a((Set<?>) (hg) entrySet());
    }

    public String toString() {
        return go.a((Map<?, ?>) this);
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new hf(this);
    }

    public /* synthetic */ Set entrySet() {
        hg<Map.Entry<K, V>> hgVar = this.f6714a;
        if (hgVar != null) {
            return hgVar;
        }
        hg<Map.Entry<K, V>> a2 = a();
        this.f6714a = a2;
        return a2;
    }

    public /* synthetic */ Collection values() {
        gz<V> gzVar = this.f6716c;
        if (gzVar != null) {
            return gzVar;
        }
        gz<V> c2 = c();
        this.f6716c = c2;
        return c2;
    }

    public /* synthetic */ Set keySet() {
        hg<K> hgVar = this.f6715b;
        if (hgVar != null) {
            return hgVar;
        }
        hg<K> b2 = b();
        this.f6715b = b2;
        return b2;
    }
}
