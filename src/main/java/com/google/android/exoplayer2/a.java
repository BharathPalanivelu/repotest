package com.google.android.exoplayer2;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.s.h;
import com.google.android.exoplayer2.source.l;
import java.io.IOException;

public abstract class a implements s, t {

    /* renamed from: a  reason: collision with root package name */
    private final int f8960a;

    /* renamed from: b  reason: collision with root package name */
    private u f8961b;

    /* renamed from: c  reason: collision with root package name */
    private int f8962c;

    /* renamed from: d  reason: collision with root package name */
    private int f8963d;

    /* renamed from: e  reason: collision with root package name */
    private l f8964e;

    /* renamed from: f  reason: collision with root package name */
    private long f8965f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8966g = true;
    private boolean h;

    public void a(int i, Object obj) throws e {
    }

    /* access modifiers changed from: protected */
    public void a(long j, boolean z) throws e {
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) throws e {
    }

    /* access modifiers changed from: protected */
    public void a(Format[] formatArr, long j) throws e {
    }

    public final t b() {
        return this;
    }

    public h c() {
        return null;
    }

    public int m() throws e {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void n() throws e {
    }

    /* access modifiers changed from: protected */
    public void o() throws e {
    }

    /* access modifiers changed from: protected */
    public void p() {
    }

    public a(int i) {
        this.f8960a = i;
    }

    public final int a() {
        return this.f8960a;
    }

    public final void a(int i) {
        this.f8962c = i;
    }

    public final int d() {
        return this.f8963d;
    }

    public final void a(u uVar, Format[] formatArr, l lVar, long j, boolean z, long j2) throws e {
        com.google.android.exoplayer2.s.a.b(this.f8963d == 0);
        this.f8961b = uVar;
        this.f8963d = 1;
        a(z);
        a(formatArr, lVar, j2);
        a(j, z);
    }

    public final void e() throws e {
        boolean z = true;
        if (this.f8963d != 1) {
            z = false;
        }
        com.google.android.exoplayer2.s.a.b(z);
        this.f8963d = 2;
        n();
    }

    public final void a(Format[] formatArr, l lVar, long j) throws e {
        com.google.android.exoplayer2.s.a.b(!this.h);
        this.f8964e = lVar;
        this.f8966g = false;
        this.f8965f = j;
        a(formatArr, j);
    }

    public final l f() {
        return this.f8964e;
    }

    public final boolean g() {
        return this.f8966g;
    }

    public final void h() {
        this.h = true;
    }

    public final boolean i() {
        return this.h;
    }

    public final void j() throws IOException {
        this.f8964e.k_();
    }

    public final void a(long j) throws e {
        this.h = false;
        this.f8966g = false;
        a(j, false);
    }

    public final void k() throws e {
        com.google.android.exoplayer2.s.a.b(this.f8963d == 2);
        this.f8963d = 1;
        o();
    }

    public final void l() {
        boolean z = true;
        if (this.f8963d != 1) {
            z = false;
        }
        com.google.android.exoplayer2.s.a.b(z);
        this.f8963d = 0;
        this.f8964e = null;
        this.h = false;
        p();
    }

    /* access modifiers changed from: protected */
    public final u q() {
        return this.f8961b;
    }

    /* access modifiers changed from: protected */
    public final int r() {
        return this.f8962c;
    }

    /* access modifiers changed from: protected */
    public final int a(l lVar, e eVar, boolean z) {
        int a2 = this.f8964e.a(lVar, eVar, z);
        if (a2 == -4) {
            if (eVar.c()) {
                this.f8966g = true;
                if (this.h) {
                    return -4;
                }
                return -3;
            }
            eVar.f9882c += this.f8965f;
        } else if (a2 == -5) {
            Format format = lVar.f10690a;
            if (format.w != Clock.MAX_TIME) {
                lVar.f10690a = format.a(format.w + this.f8965f);
            }
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public void b(long j) {
        this.f8964e.a(j - this.f8965f);
    }

    /* access modifiers changed from: protected */
    public final boolean s() {
        return this.f8966g ? this.h : this.f8964e.c();
    }
}
