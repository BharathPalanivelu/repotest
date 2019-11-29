package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;

final class ho<K, V> extends hg<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    public final transient Object[] f12656a;

    /* renamed from: b  reason: collision with root package name */
    public final transient int f12657b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final transient int f12658c;

    /* renamed from: d  reason: collision with root package name */
    private final transient hd<K, V> f12659d;

    ho(hd<K, V> hdVar, Object[] objArr, int i, int i2) {
        this.f12659d = hdVar;
        this.f12656a = objArr;
        this.f12658c = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return true;
    }

    public final hu<Map.Entry<K, V>> a() {
        return (hu) e().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int a(Object[] objArr, int i) {
        return e().a(objArr, i);
    }

    /* access modifiers changed from: package-private */
    public final ha<Map.Entry<K, V>> h() {
        return new hp(this);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.f12659d.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int size() {
        return this.f12658c;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
