package com.google.android.exoplayer2.p.a;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.p.e;
import com.google.android.exoplayer2.p.f;
import com.google.android.exoplayer2.p.g;
import com.google.android.exoplayer2.p.i;
import com.google.android.exoplayer2.p.j;
import com.google.android.exoplayer2.s.a;
import java.util.LinkedList;
import java.util.TreeSet;

abstract class d implements f {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList<i> f11061a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    private final LinkedList<j> f11062b;

    /* renamed from: c  reason: collision with root package name */
    private final TreeSet<i> f11063c;

    /* renamed from: d  reason: collision with root package name */
    private i f11064d;

    /* renamed from: e  reason: collision with root package name */
    private long f11065e;

    /* access modifiers changed from: protected */
    public abstract void a(i iVar);

    public void d() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean e();

    /* access modifiers changed from: protected */
    public abstract e f();

    public d() {
        for (int i = 0; i < 10; i++) {
            this.f11061a.add(new i());
        }
        this.f11062b = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.f11062b.add(new e(this));
        }
        this.f11063c = new TreeSet<>();
    }

    public void a(long j) {
        this.f11065e = j;
    }

    /* renamed from: h */
    public i a() throws g {
        a.b(this.f11064d == null);
        if (this.f11061a.isEmpty()) {
            return null;
        }
        this.f11064d = this.f11061a.pollFirst();
        return this.f11064d;
    }

    /* renamed from: b */
    public void a(i iVar) throws g {
        boolean z = true;
        a.a(iVar != null);
        if (iVar != this.f11064d) {
            z = false;
        }
        a.a(z);
        if (iVar.l_()) {
            c(iVar);
        } else {
            this.f11063c.add(iVar);
        }
        this.f11064d = null;
    }

    /* renamed from: g */
    public j b() throws g {
        if (this.f11062b.isEmpty()) {
            return null;
        }
        while (!this.f11063c.isEmpty() && this.f11063c.first().f9882c <= this.f11065e) {
            i pollFirst = this.f11063c.pollFirst();
            if (pollFirst.c()) {
                j pollFirst2 = this.f11062b.pollFirst();
                pollFirst2.b(4);
                c(pollFirst);
                return pollFirst2;
            }
            a(pollFirst);
            if (e()) {
                e f2 = f();
                if (!pollFirst.l_()) {
                    j pollFirst3 = this.f11062b.pollFirst();
                    pollFirst3.a(pollFirst.f9882c, f2, Clock.MAX_TIME);
                    c(pollFirst);
                    return pollFirst3;
                }
            }
            c(pollFirst);
        }
        return null;
    }

    private void c(i iVar) {
        iVar.a();
        this.f11061a.add(iVar);
    }

    /* access modifiers changed from: protected */
    public void a(j jVar) {
        jVar.a();
        this.f11062b.add(jVar);
    }

    public void c() {
        this.f11065e = 0;
        while (!this.f11063c.isEmpty()) {
            c(this.f11063c.pollFirst());
        }
        i iVar = this.f11064d;
        if (iVar != null) {
            c(iVar);
            this.f11064d = null;
        }
    }
}
