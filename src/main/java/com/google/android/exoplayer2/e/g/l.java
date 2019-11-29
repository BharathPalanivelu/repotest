package com.google.android.exoplayer2.e.g;

import android.util.Log;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;

public final class l implements h {

    /* renamed from: a  reason: collision with root package name */
    private final k f9679a = new k(10);

    /* renamed from: b  reason: collision with root package name */
    private n f9680b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9681c;

    /* renamed from: d  reason: collision with root package name */
    private long f9682d;

    /* renamed from: e  reason: collision with root package name */
    private int f9683e;

    /* renamed from: f  reason: collision with root package name */
    private int f9684f;

    public void a() {
        this.f9681c = false;
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.f9680b = hVar.a(dVar.b(), 4);
        this.f9680b.a(j.a(dVar.c(), "application/id3", (String) null, -1, (a) null));
    }

    public void a(long j, boolean z) {
        if (z) {
            this.f9681c = true;
            this.f9682d = j;
            this.f9683e = 0;
            this.f9684f = 0;
        }
    }

    public void a(k kVar) {
        if (this.f9681c) {
            int b2 = kVar.b();
            int i = this.f9684f;
            if (i < 10) {
                int min = Math.min(b2, 10 - i);
                System.arraycopy(kVar.f10948a, kVar.d(), this.f9679a.f10948a, this.f9684f, min);
                if (this.f9684f + min == 10) {
                    this.f9679a.c(0);
                    if (73 == this.f9679a.g() && 68 == this.f9679a.g() && 51 == this.f9679a.g()) {
                        this.f9679a.d(3);
                        this.f9683e = this.f9679a.s() + 10;
                    } else {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.f9681c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(b2, this.f9683e - this.f9684f);
            this.f9680b.a(kVar, min2);
            this.f9684f += min2;
        }
    }

    public void b() {
        if (this.f9681c) {
            int i = this.f9683e;
            if (i != 0 && this.f9684f == i) {
                this.f9680b.a(this.f9682d, 1, i, 0, (byte[]) null);
                this.f9681c = false;
            }
        }
    }
}
