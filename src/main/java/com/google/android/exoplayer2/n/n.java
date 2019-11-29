package com.google.android.exoplayer2.n;

import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.PriorityQueue;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final Object f10955a;

    /* renamed from: b  reason: collision with root package name */
    private final PriorityQueue<Integer> f10956b;

    /* renamed from: c  reason: collision with root package name */
    private int f10957c;

    public void a(int i) {
        synchronized (this.f10955a) {
            this.f10956b.add(Integer.valueOf(i));
            this.f10957c = Math.max(this.f10957c, i);
        }
    }

    public void b(int i) {
        synchronized (this.f10955a) {
            this.f10956b.remove(Integer.valueOf(i));
            this.f10957c = this.f10956b.isEmpty() ? RNCartPanelDataEntity.NULL_VALUE : this.f10956b.peek().intValue();
            this.f10955a.notifyAll();
        }
    }
}
