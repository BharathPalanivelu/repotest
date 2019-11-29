package com.google.android.exoplayer2.s;

import android.os.SystemClock;
import com.google.android.exoplayer2.b;

public final class q implements h {

    /* renamed from: a  reason: collision with root package name */
    private boolean f11442a;

    /* renamed from: b  reason: collision with root package name */
    private long f11443b;

    /* renamed from: c  reason: collision with root package name */
    private long f11444c;

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.exoplayer2.q f11445d = com.google.android.exoplayer2.q.f11236a;

    public void a() {
        if (!this.f11442a) {
            this.f11444c = SystemClock.elapsedRealtime();
            this.f11442a = true;
        }
    }

    public void b() {
        if (this.f11442a) {
            a(w());
            this.f11442a = false;
        }
    }

    public void a(long j) {
        this.f11443b = j;
        if (this.f11442a) {
            this.f11444c = SystemClock.elapsedRealtime();
        }
    }

    public void a(h hVar) {
        a(hVar.w());
        this.f11445d = hVar.x();
    }

    public long w() {
        long j;
        long j2 = this.f11443b;
        if (!this.f11442a) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f11444c;
        if (this.f11445d.f11237b == 1.0f) {
            j = b.b(elapsedRealtime);
        } else {
            j = this.f11445d.a(elapsedRealtime);
        }
        return j2 + j;
    }

    public com.google.android.exoplayer2.q a(com.google.android.exoplayer2.q qVar) {
        if (this.f11442a) {
            a(w());
        }
        this.f11445d = qVar;
        return qVar;
    }

    public com.google.android.exoplayer2.q x() {
        return this.f11445d;
    }
}
