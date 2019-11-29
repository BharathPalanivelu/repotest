package com.google.android.exoplayer2.i.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.l;
import java.util.Collections;
import java.util.List;

public final class g implements h {

    /* renamed from: a  reason: collision with root package name */
    private final List<v.a> f10261a;

    /* renamed from: b  reason: collision with root package name */
    private final m[] f10262b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10263c;

    /* renamed from: d  reason: collision with root package name */
    private int f10264d;

    /* renamed from: e  reason: collision with root package name */
    private int f10265e;

    /* renamed from: f  reason: collision with root package name */
    private long f10266f;

    public g(List<v.a> list) {
        this.f10261a = list;
        this.f10262b = new m[list.size()];
    }

    public void a() {
        this.f10263c = false;
    }

    public void a(com.google.android.exoplayer2.i.g gVar, v.d dVar) {
        for (int i = 0; i < this.f10262b.length; i++) {
            v.a aVar = this.f10261a.get(i);
            dVar.a();
            m a2 = gVar.a(dVar.b(), 3);
            a2.a(Format.a(dVar.c(), "application/dvbsubs", (String) null, -1, (List<byte[]>) Collections.singletonList(aVar.f10380c), aVar.f10378a, (DrmInitData) null));
            this.f10262b[i] = a2;
        }
    }

    public void a(long j, boolean z) {
        if (z) {
            this.f10263c = true;
            this.f10266f = j;
            this.f10265e = 0;
            this.f10264d = 2;
        }
    }

    public void b() {
        if (this.f10263c) {
            for (m a2 : this.f10262b) {
                a2.a(this.f10266f, 1, this.f10265e, 0, (m.a) null);
            }
            this.f10263c = false;
        }
    }

    public void a(l lVar) {
        if (!this.f10263c) {
            return;
        }
        if (this.f10264d != 2 || a(lVar, 32)) {
            if (this.f10264d != 1 || a(lVar, 0)) {
                int d2 = lVar.d();
                int b2 = lVar.b();
                for (m a2 : this.f10262b) {
                    lVar.c(d2);
                    a2.a(lVar, b2);
                }
                this.f10265e += b2;
            }
        }
    }

    private boolean a(l lVar, int i) {
        if (lVar.b() == 0) {
            return false;
        }
        if (lVar.g() != i) {
            this.f10263c = false;
        }
        this.f10264d--;
        return this.f10263c;
    }
}
