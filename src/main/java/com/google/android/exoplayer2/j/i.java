package com.google.android.exoplayer2.j;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.d.f;
import java.util.List;

public abstract class i extends f implements d {

    /* renamed from: c  reason: collision with root package name */
    private d f10622c;

    /* renamed from: d  reason: collision with root package name */
    private long f10623d;

    public abstract void e();

    public void a(long j, d dVar, long j2) {
        this.f9283a = j;
        this.f10622c = dVar;
        if (j2 == Clock.MAX_TIME) {
            j2 = this.f9283a;
        }
        this.f10623d = j2;
    }

    public int i_() {
        return this.f10622c.i_();
    }

    public long a(int i) {
        return this.f10622c.a(i) + this.f10623d;
    }

    public int a(long j) {
        return this.f10622c.a(j - this.f10623d);
    }

    public List<a> b(long j) {
        return this.f10622c.b(j - this.f10623d);
    }

    public void a() {
        super.a();
        this.f10622c = null;
    }
}
