package com.google.android.exoplayer2.source.c;

import android.util.SparseArray;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.n.q;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<q> f11767a = new SparseArray<>();

    public q a(int i) {
        q qVar = this.f11767a.get(i);
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = new q(Clock.MAX_TIME);
        this.f11767a.put(i, qVar2);
        return qVar2;
    }

    public void a() {
        this.f11767a.clear();
    }
}
