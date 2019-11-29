package com.google.android.libraries.places.internal;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class hq<K> extends hg<K> {

    /* renamed from: a  reason: collision with root package name */
    private final transient hd<K, ?> f6726a;

    /* renamed from: b  reason: collision with root package name */
    private final transient ha<K> f6727b;

    hq(hd<K, ?> hdVar, ha<K> haVar) {
        this.f6726a = hdVar;
        this.f6727b = haVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return true;
    }

    public final hu<K> a() {
        return (hu) e().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int a(Object[] objArr, int i) {
        return e().a(objArr, i);
    }

    public final ha<K> e() {
        return this.f6727b;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.f6726a.get(obj) != null;
    }

    public final int size() {
        return this.f6726a.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
