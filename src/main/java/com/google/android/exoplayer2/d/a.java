package com.google.android.exoplayer2.d;

import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private int f9262a;

    public void a() {
        this.f9262a = 0;
    }

    public final boolean b() {
        return d(RNCartPanelDataEntity.NULL_VALUE);
    }

    public final boolean c() {
        return d(4);
    }

    public final boolean d() {
        return d(1);
    }

    public final void a_(int i) {
        this.f9262a = i;
    }

    public final void b(int i) {
        this.f9262a = i | this.f9262a;
    }

    public final void c(int i) {
        this.f9262a = (i ^ -1) & this.f9262a;
    }

    /* access modifiers changed from: protected */
    public final boolean d(int i) {
        return (this.f9262a & i) == i;
    }
}
