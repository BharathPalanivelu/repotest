package com.google.android.exoplayer2.p;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.g.f;
import java.util.List;

public abstract class j extends f implements e {

    /* renamed from: c  reason: collision with root package name */
    private e f11227c;

    /* renamed from: d  reason: collision with root package name */
    private long f11228d;

    public abstract void e();

    public void a(long j, e eVar, long j2) {
        this.f9884a = j;
        this.f11227c = eVar;
        if (j2 == Clock.MAX_TIME) {
            j2 = this.f9884a;
        }
        this.f11228d = j2;
    }

    public int b() {
        return this.f11227c.b();
    }

    public long a(int i) {
        return this.f11227c.a(i) + this.f11228d;
    }

    public int a(long j) {
        return this.f11227c.a(j - this.f11228d);
    }

    public List<b> b(long j) {
        return this.f11227c.b(j - this.f11228d);
    }

    public void a() {
        super.a();
        this.f11227c = null;
    }
}
