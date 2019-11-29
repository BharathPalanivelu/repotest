package com.google.android.libraries.places.internal;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;

public final class he<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f12645a;

    /* renamed from: b  reason: collision with root package name */
    private int f12646b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12647c;

    public he() {
        this(4);
    }

    he(int i) {
        this.f12645a = new Object[(i * 2)];
        this.f12646b = 0;
        this.f12647c = false;
    }

    @CanIgnoreReturnValue
    public final he<K, V> a(K k, V v) {
        int i = (this.f12646b + 1) << 1;
        Object[] objArr = this.f12645a;
        if (i > objArr.length) {
            this.f12645a = Arrays.copyOf(objArr, go.c(objArr.length, i));
            this.f12647c = false;
        }
        go.b((Object) k, (Object) v);
        Object[] objArr2 = this.f12645a;
        int i2 = this.f12646b;
        objArr2[i2 * 2] = k;
        objArr2[(i2 * 2) + 1] = v;
        this.f12646b = i2 + 1;
        return this;
    }

    public final hd<K, V> a() {
        this.f12647c = true;
        return hn.a(this.f12646b, this.f12645a);
    }
}
