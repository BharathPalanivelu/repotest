package com.google.android.exoplayer2;

import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.q.g;
import com.google.android.exoplayer2.r.b;
import com.google.android.exoplayer2.r.j;
import com.google.android.exoplayer2.s.o;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.p;

public final class c implements n {

    /* renamed from: a  reason: collision with root package name */
    private final j f9242a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9243b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9244c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9245d;

    /* renamed from: e  reason: collision with root package name */
    private final long f9246e;

    /* renamed from: f  reason: collision with root package name */
    private final o f9247f;

    /* renamed from: g  reason: collision with root package name */
    private int f9248g;
    private boolean h;

    public c() {
        this(new j(true, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    public c(j jVar) {
        this(jVar, 15000, 30000, 2500, 5000);
    }

    public c(j jVar, int i, int i2, long j, long j2) {
        this(jVar, i, i2, j, j2, (o) null);
    }

    public c(j jVar, int i, int i2, long j, long j2, o oVar) {
        this.f9242a = jVar;
        this.f9243b = ((long) i) * 1000;
        this.f9244c = ((long) i2) * 1000;
        this.f9245d = j * 1000;
        this.f9246e = j2 * 1000;
        this.f9247f = oVar;
    }

    public void a() {
        a(false);
    }

    public void a(s[] sVarArr, p pVar, g gVar) {
        this.f9248g = 0;
        for (int i = 0; i < sVarArr.length; i++) {
            if (gVar.a(i) != null) {
                this.f9248g += v.d(sVarArr[i].a());
            }
        }
        this.f9242a.a(this.f9248g);
    }

    public void b() {
        a(true);
    }

    public void c() {
        a(true);
    }

    public b d() {
        return this.f9242a;
    }

    public boolean a(long j, boolean z) {
        long j2 = z ? this.f9246e : this.f9245d;
        return j2 <= 0 || j >= j2;
    }

    public boolean a(long j) {
        int b2 = b(j);
        boolean z = true;
        boolean z2 = this.f9242a.e() >= this.f9248g;
        boolean z3 = this.h;
        if (b2 != 2 && (b2 != 1 || !z3 || z2)) {
            z = false;
        }
        this.h = z;
        o oVar = this.f9247f;
        if (oVar != null) {
            boolean z4 = this.h;
            if (z4 != z3) {
                if (z4) {
                    oVar.a(0);
                } else {
                    oVar.b(0);
                }
            }
        }
        return this.h;
    }

    private int b(long j) {
        if (j > this.f9244c) {
            return 0;
        }
        return j < this.f9243b ? 2 : 1;
    }

    private void a(boolean z) {
        this.f9248g = 0;
        o oVar = this.f9247f;
        if (oVar != null && this.h) {
            oVar.b(0);
        }
        this.h = false;
        if (z) {
            this.f9242a.d();
        }
    }
}
