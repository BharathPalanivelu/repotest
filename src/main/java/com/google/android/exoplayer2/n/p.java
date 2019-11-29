package com.google.android.exoplayer2.n;

import android.os.SystemClock;
import com.google.android.exoplayer2.al;
import com.google.android.exoplayer2.z;

public final class p implements g {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10968a;

    /* renamed from: b  reason: collision with root package name */
    private long f10969b;

    /* renamed from: c  reason: collision with root package name */
    private long f10970c;

    /* renamed from: d  reason: collision with root package name */
    private al f10971d = al.f9108a;

    public void a() {
        if (!this.f10968a) {
            this.f10970c = SystemClock.elapsedRealtime();
            this.f10968a = true;
        }
    }

    public void b() {
        if (this.f10968a) {
            a(w());
            this.f10968a = false;
        }
    }

    public void a(long j) {
        this.f10969b = j;
        if (this.f10968a) {
            this.f10970c = SystemClock.elapsedRealtime();
        }
    }

    public void a(g gVar) {
        a(gVar.w());
        this.f10971d = gVar.x();
    }

    public long w() {
        long j;
        long j2 = this.f10969b;
        if (!this.f10968a) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f10970c;
        if (this.f10971d.f9109b == 1.0f) {
            j = z.b(elapsedRealtime);
        } else {
            j = this.f10971d.a(elapsedRealtime);
        }
        return j2 + j;
    }

    public al a(al alVar) {
        if (this.f10968a) {
            a(w());
        }
        this.f10971d = alVar;
        return alVar;
    }

    public al x() {
        return this.f10971d;
    }
}
