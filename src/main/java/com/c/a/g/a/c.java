package com.c.a.g.a;

import com.c.a.i.i;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public abstract class c<Z> extends a<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final int f6183a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6184b;

    public void b(d dVar) {
    }

    public c() {
        this(RNCartPanelDataEntity.NULL_VALUE, RNCartPanelDataEntity.NULL_VALUE);
    }

    public c(int i, int i2) {
        this.f6183a = i;
        this.f6184b = i2;
    }

    public final void a(d dVar) {
        if (i.a(this.f6183a, this.f6184b)) {
            dVar.a(this.f6183a, this.f6184b);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f6183a + " and height: " + this.f6184b + ", either provide dimensions in the constructor or call override()");
    }
}
