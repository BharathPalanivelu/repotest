package com.google.android.exoplayer2;

import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.l.g;
import com.google.android.exoplayer2.m.b;
import com.google.android.exoplayer2.m.j;
import com.google.android.exoplayer2.n.n;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.source.ad;

public final class aa implements aj {

    /* renamed from: a  reason: collision with root package name */
    private final j f9060a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9061b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9062c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9063d;

    /* renamed from: e  reason: collision with root package name */
    private final long f9064e;

    /* renamed from: f  reason: collision with root package name */
    private final n f9065f;

    /* renamed from: g  reason: collision with root package name */
    private int f9066g;
    private boolean h;

    public aa() {
        this(new j(true, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    public aa(j jVar) {
        this(jVar, 15000, 30000, 2500, 5000);
    }

    public aa(j jVar, int i, int i2, long j, long j2) {
        this(jVar, i, i2, j, j2, (n) null);
    }

    public aa(j jVar, int i, int i2, long j, long j2, n nVar) {
        this.f9060a = jVar;
        this.f9061b = ((long) i) * 1000;
        this.f9062c = ((long) i2) * 1000;
        this.f9063d = j * 1000;
        this.f9064e = j2 * 1000;
        this.f9065f = nVar;
    }

    public void a() {
        a(false);
    }

    public void a(am[] amVarArr, ad adVar, g gVar) {
        this.f9066g = 0;
        for (int i = 0; i < amVarArr.length; i++) {
            if (gVar.a(i) != null) {
                this.f9066g += t.c(amVarArr[i].a());
            }
        }
        this.f9060a.a(this.f9066g);
    }

    public void b() {
        a(true);
    }

    public void c() {
        a(true);
    }

    public b d() {
        return this.f9060a;
    }

    public boolean a(long j, boolean z) {
        long j2 = z ? this.f9064e : this.f9063d;
        return j2 <= 0 || j >= j2;
    }

    public boolean a(long j) {
        int b2 = b(j);
        boolean z = true;
        boolean z2 = this.f9060a.e() >= this.f9066g;
        boolean z3 = this.h;
        if (b2 != 2 && (b2 != 1 || !z3 || z2)) {
            z = false;
        }
        this.h = z;
        n nVar = this.f9065f;
        if (nVar != null) {
            boolean z4 = this.h;
            if (z4 != z3) {
                if (z4) {
                    nVar.a(0);
                } else {
                    nVar.b(0);
                }
            }
        }
        return this.h;
    }

    private int b(long j) {
        if (j > this.f9062c) {
            return 0;
        }
        return j < this.f9061b ? 2 : 1;
    }

    private void a(boolean z) {
        this.f9066g = 0;
        n nVar = this.f9065f;
        if (nVar != null && this.h) {
            nVar.b(0);
        }
        this.h = false;
        if (z) {
            this.f9060a.d();
        }
    }
}
