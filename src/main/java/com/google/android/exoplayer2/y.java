package com.google.android.exoplayer2;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.d.e;
import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.n.g;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;

public abstract class y implements am, an {

    /* renamed from: a  reason: collision with root package name */
    private final int f12308a;

    /* renamed from: b  reason: collision with root package name */
    private ao f12309b;

    /* renamed from: c  reason: collision with root package name */
    private int f12310c;

    /* renamed from: d  reason: collision with root package name */
    private int f12311d;

    /* renamed from: e  reason: collision with root package name */
    private z f12312e;

    /* renamed from: f  reason: collision with root package name */
    private long f12313f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12314g = true;
    private boolean h;

    public void a(int i, Object obj) throws ac {
    }

    /* access modifiers changed from: protected */
    public void a(long j, boolean z) throws ac {
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) throws ac {
    }

    /* access modifiers changed from: protected */
    public void a(j[] jVarArr) throws ac {
    }

    public final an b() {
        return this;
    }

    public g c() {
        return null;
    }

    public int m() throws ac {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void n() throws ac {
    }

    /* access modifiers changed from: protected */
    public void o() throws ac {
    }

    /* access modifiers changed from: protected */
    public void p() {
    }

    public y(int i) {
        this.f12308a = i;
    }

    public final int a() {
        return this.f12308a;
    }

    public final void a(int i) {
        this.f12310c = i;
    }

    public final int d() {
        return this.f12311d;
    }

    public final void a(ao aoVar, j[] jVarArr, z zVar, long j, boolean z, long j2) throws ac {
        a.b(this.f12311d == 0);
        this.f12309b = aoVar;
        this.f12311d = 1;
        a(z);
        a(jVarArr, zVar, j2);
        a(j, z);
    }

    public final void e() throws ac {
        boolean z = true;
        if (this.f12311d != 1) {
            z = false;
        }
        a.b(z);
        this.f12311d = 2;
        n();
    }

    public final void a(j[] jVarArr, z zVar, long j) throws ac {
        a.b(!this.h);
        this.f12312e = zVar;
        this.f12314g = false;
        this.f12313f = j;
        a(jVarArr);
    }

    public final z f() {
        return this.f12312e;
    }

    public final boolean g() {
        return this.f12314g;
    }

    public final void h() {
        this.h = true;
    }

    public final boolean i() {
        return this.h;
    }

    public final void j() throws IOException {
        this.f12312e.e();
    }

    public final void a(long j) throws ac {
        this.h = false;
        this.f12314g = false;
        a(j, false);
    }

    public final void k() throws ac {
        a.b(this.f12311d == 2);
        this.f12311d = 1;
        o();
    }

    public final void l() {
        boolean z = true;
        if (this.f12311d != 1) {
            z = false;
        }
        a.b(z);
        this.f12311d = 0;
        this.f12312e = null;
        this.h = false;
        p();
    }

    /* access modifiers changed from: protected */
    public final ao q() {
        return this.f12309b;
    }

    /* access modifiers changed from: protected */
    public final int r() {
        return this.f12310c;
    }

    /* access modifiers changed from: protected */
    public final int a(ah ahVar, e eVar, boolean z) {
        int a2 = this.f12312e.a(ahVar, eVar, z);
        if (a2 == -4) {
            if (eVar.c()) {
                this.f12314g = true;
                if (this.h) {
                    return -4;
                }
                return -3;
            }
            eVar.f9281c += this.f12313f;
        } else if (a2 == -5) {
            j jVar = ahVar.f9107a;
            if (jVar.w != Clock.MAX_TIME) {
                ahVar.f9107a = jVar.a(jVar.w + this.f12313f);
            }
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public void b(long j) {
        this.f12312e.c(j - this.f12313f);
    }

    /* access modifiers changed from: protected */
    public final boolean s() {
        return this.f12314g ? this.h : this.f12312e.d();
    }
}
