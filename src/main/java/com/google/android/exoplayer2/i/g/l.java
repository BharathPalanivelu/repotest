package com.google.android.exoplayer2.i.g;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.m;

public final class l implements h {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.s.l f10314a = new com.google.android.exoplayer2.s.l(10);

    /* renamed from: b  reason: collision with root package name */
    private m f10315b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10316c;

    /* renamed from: d  reason: collision with root package name */
    private long f10317d;

    /* renamed from: e  reason: collision with root package name */
    private int f10318e;

    /* renamed from: f  reason: collision with root package name */
    private int f10319f;

    public void a() {
        this.f10316c = false;
    }

    public void a(g gVar, v.d dVar) {
        dVar.a();
        this.f10315b = gVar.a(dVar.b(), 4);
        this.f10315b.a(Format.a(dVar.c(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    public void a(long j, boolean z) {
        if (z) {
            this.f10316c = true;
            this.f10317d = j;
            this.f10318e = 0;
            this.f10319f = 0;
        }
    }

    public void a(com.google.android.exoplayer2.s.l lVar) {
        if (this.f10316c) {
            int b2 = lVar.b();
            int i = this.f10319f;
            if (i < 10) {
                int min = Math.min(b2, 10 - i);
                System.arraycopy(lVar.f11422a, lVar.d(), this.f10314a.f11422a, this.f10319f, min);
                if (this.f10319f + min == 10) {
                    this.f10314a.c(0);
                    if (73 == this.f10314a.g() && 68 == this.f10314a.g() && 51 == this.f10314a.g()) {
                        this.f10314a.d(3);
                        this.f10318e = this.f10314a.s() + 10;
                    } else {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.f10316c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(b2, this.f10318e - this.f10319f);
            this.f10315b.a(lVar, min2);
            this.f10319f += min2;
        }
    }

    public void b() {
        if (this.f10316c) {
            int i = this.f10318e;
            if (i != 0 && this.f10319f == i) {
                this.f10315b.a(this.f10317d, 1, i, 0, (m.a) null);
                this.f10316c = false;
            }
        }
    }
}
