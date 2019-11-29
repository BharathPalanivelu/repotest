package com.google.android.exoplayer2.e.g;

import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import java.util.Collections;
import java.util.List;

public final class g implements h {

    /* renamed from: a  reason: collision with root package name */
    private final List<v.a> f9627a;

    /* renamed from: b  reason: collision with root package name */
    private final n[] f9628b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9629c;

    /* renamed from: d  reason: collision with root package name */
    private int f9630d;

    /* renamed from: e  reason: collision with root package name */
    private int f9631e;

    /* renamed from: f  reason: collision with root package name */
    private long f9632f;

    public g(List<v.a> list) {
        this.f9627a = list;
        this.f9628b = new n[list.size()];
    }

    public void a() {
        this.f9629c = false;
    }

    public void a(h hVar, v.d dVar) {
        for (int i = 0; i < this.f9628b.length; i++) {
            v.a aVar = this.f9627a.get(i);
            dVar.a();
            n a2 = hVar.a(dVar.b(), 3);
            a2.a(j.a(dVar.c(), "application/dvbsubs", (String) null, -1, (List<byte[]>) Collections.singletonList(aVar.f9743c), aVar.f9741a, (a) null));
            this.f9628b[i] = a2;
        }
    }

    public void a(long j, boolean z) {
        if (z) {
            this.f9629c = true;
            this.f9632f = j;
            this.f9631e = 0;
            this.f9630d = 2;
        }
    }

    public void b() {
        if (this.f9629c) {
            for (n a2 : this.f9628b) {
                a2.a(this.f9632f, 1, this.f9631e, 0, (byte[]) null);
            }
            this.f9629c = false;
        }
    }

    public void a(k kVar) {
        if (!this.f9629c) {
            return;
        }
        if (this.f9630d != 2 || a(kVar, 32)) {
            if (this.f9630d != 1 || a(kVar, 0)) {
                int d2 = kVar.d();
                int b2 = kVar.b();
                for (n a2 : this.f9628b) {
                    kVar.c(d2);
                    a2.a(kVar, b2);
                }
                this.f9631e += b2;
            }
        }
    }

    private boolean a(k kVar, int i) {
        if (kVar.b() == 0) {
            return false;
        }
        if (kVar.g() != i) {
            this.f9629c = false;
        }
        this.f9630d--;
        return this.f9629c;
    }
}
