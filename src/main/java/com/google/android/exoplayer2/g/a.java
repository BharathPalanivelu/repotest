package com.google.android.exoplayer2.g;

import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private int f9863a;

    public void a() {
        this.f9863a = 0;
    }

    public final boolean l_() {
        return d(RNCartPanelDataEntity.NULL_VALUE);
    }

    public final boolean c() {
        return d(4);
    }

    public final boolean d() {
        return d(1);
    }

    public final void b_(int i) {
        this.f9863a = i;
    }

    public final void b(int i) {
        this.f9863a = i | this.f9863a;
    }

    public final void c(int i) {
        this.f9863a = (i ^ -1) & this.f9863a;
    }

    /* access modifiers changed from: protected */
    public final boolean d(int i) {
        return (this.f9863a & i) == i;
    }
}
