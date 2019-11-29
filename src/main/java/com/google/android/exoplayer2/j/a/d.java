package com.google.android.exoplayer2.j.a;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.j.e;
import com.google.android.exoplayer2.j.f;
import com.google.android.exoplayer2.j.h;
import com.google.android.exoplayer2.j.i;
import com.google.android.exoplayer2.n.a;
import java.util.LinkedList;
import java.util.TreeSet;

abstract class d implements e {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList<h> f10471a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    private final LinkedList<i> f10472b;

    /* renamed from: c  reason: collision with root package name */
    private final TreeSet<h> f10473c;

    /* renamed from: d  reason: collision with root package name */
    private h f10474d;

    /* renamed from: e  reason: collision with root package name */
    private long f10475e;

    /* access modifiers changed from: protected */
    public abstract void a(h hVar);

    public void d() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean e();

    /* access modifiers changed from: protected */
    public abstract com.google.android.exoplayer2.j.d f();

    public d() {
        for (int i = 0; i < 10; i++) {
            this.f10471a.add(new h());
        }
        this.f10472b = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.f10472b.add(new e(this));
        }
        this.f10473c = new TreeSet<>();
    }

    public void a(long j) {
        this.f10475e = j;
    }

    /* renamed from: h */
    public h a() throws f {
        a.b(this.f10474d == null);
        if (this.f10471a.isEmpty()) {
            return null;
        }
        this.f10474d = this.f10471a.pollFirst();
        return this.f10474d;
    }

    /* renamed from: b */
    public void a(h hVar) throws f {
        boolean z = true;
        a.a(hVar != null);
        if (hVar != this.f10474d) {
            z = false;
        }
        a.a(z);
        if (hVar.b()) {
            c(hVar);
        } else {
            this.f10473c.add(hVar);
        }
        this.f10474d = null;
    }

    /* renamed from: g */
    public i b() throws f {
        if (this.f10472b.isEmpty()) {
            return null;
        }
        while (!this.f10473c.isEmpty() && this.f10473c.first().f9281c <= this.f10475e) {
            h pollFirst = this.f10473c.pollFirst();
            if (pollFirst.c()) {
                i pollFirst2 = this.f10472b.pollFirst();
                pollFirst2.b(4);
                c(pollFirst);
                return pollFirst2;
            }
            a(pollFirst);
            if (e()) {
                com.google.android.exoplayer2.j.d f2 = f();
                if (!pollFirst.b()) {
                    i pollFirst3 = this.f10472b.pollFirst();
                    pollFirst3.a(pollFirst.f9281c, f2, Clock.MAX_TIME);
                    c(pollFirst);
                    return pollFirst3;
                }
            }
            c(pollFirst);
        }
        return null;
    }

    private void c(h hVar) {
        hVar.a();
        this.f10471a.add(hVar);
    }

    /* access modifiers changed from: protected */
    public void a(i iVar) {
        iVar.a();
        this.f10472b.add(iVar);
    }

    public void c() {
        this.f10475e = 0;
        while (!this.f10473c.isEmpty()) {
            c(this.f10473c.pollFirst());
        }
        h hVar = this.f10474d;
        if (hVar != null) {
            c(hVar);
            this.f10474d = null;
        }
    }
}
