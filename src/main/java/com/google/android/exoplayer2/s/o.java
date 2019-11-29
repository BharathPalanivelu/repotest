package com.google.android.exoplayer2.s;

import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.PriorityQueue;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private final Object f11429a;

    /* renamed from: b  reason: collision with root package name */
    private final PriorityQueue<Integer> f11430b;

    /* renamed from: c  reason: collision with root package name */
    private int f11431c;

    public void a(int i) {
        synchronized (this.f11429a) {
            this.f11430b.add(Integer.valueOf(i));
            this.f11431c = Math.max(this.f11431c, i);
        }
    }

    public void b(int i) {
        synchronized (this.f11429a) {
            this.f11430b.remove(Integer.valueOf(i));
            this.f11431c = this.f11430b.isEmpty() ? RNCartPanelDataEntity.NULL_VALUE : this.f11430b.peek().intValue();
            this.f11429a.notifyAll();
        }
    }
}
