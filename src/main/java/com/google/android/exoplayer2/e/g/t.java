package com.google.android.exoplayer2.e.g;

import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.q;

public final class t implements q {

    /* renamed from: a  reason: collision with root package name */
    private q f9726a;

    /* renamed from: b  reason: collision with root package name */
    private n f9727b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9728c;

    public void a(q qVar, h hVar, v.d dVar) {
        this.f9726a = qVar;
        dVar.a();
        this.f9727b = hVar.a(dVar.b(), 4);
        this.f9727b.a(j.a(dVar.c(), "application/x-scte35", (String) null, -1, (a) null));
    }

    public void a(k kVar) {
        if (!this.f9728c) {
            if (this.f9726a.c() != -9223372036854775807L) {
                this.f9727b.a(j.a((String) null, "application/x-scte35", this.f9726a.c()));
                this.f9728c = true;
            } else {
                return;
            }
        }
        int b2 = kVar.b();
        this.f9727b.a(kVar, b2);
        this.f9727b.a(this.f9726a.b(), 1, b2, 0, (byte[]) null);
    }
}
