package com.google.android.libraries.places.internal;

import java.util.NoSuchElementException;

final class kd extends kf {

    /* renamed from: a  reason: collision with root package name */
    private int f12865a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f12866b = this.f12867c.a();

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ kc f12867c;

    kd(kc kcVar) {
        this.f12867c = kcVar;
    }

    public final boolean hasNext() {
        return this.f12865a < this.f12866b;
    }

    public final byte a() {
        int i = this.f12865a;
        if (i < this.f12866b) {
            this.f12865a = i + 1;
            return this.f12867c.b(i);
        }
        throw new NoSuchElementException();
    }
}
