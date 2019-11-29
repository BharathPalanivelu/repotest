package com.google.android.exoplayer2.source.c;

import android.util.SparseArray;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.s.s;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<s> f11718a = new SparseArray<>();

    public s a(int i) {
        s sVar = this.f11718a.get(i);
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(Clock.MAX_TIME);
        this.f11718a.put(i, sVar2);
        return sVar2;
    }

    public void a() {
        this.f11718a.clear();
    }
}
