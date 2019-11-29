package com.google.android.libraries.places.internal;

import java.util.AbstractMap;
import java.util.Map;

final class hp extends ha<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ho f12660a;

    hp(ho hoVar) {
        this.f12660a = hoVar;
    }

    public final boolean f() {
        return true;
    }

    public final int size() {
        return this.f12660a.f12658c;
    }

    public final /* synthetic */ Object get(int i) {
        go.a(i, this.f12660a.f12658c);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.f12660a.f12656a[this.f12660a.f12657b + i2], this.f12660a.f12656a[i2 + (this.f12660a.f12657b ^ 1)]);
    }
}
