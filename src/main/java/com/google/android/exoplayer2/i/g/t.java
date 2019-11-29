package com.google.android.exoplayer2.i.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.s;

public final class t implements q {

    /* renamed from: a  reason: collision with root package name */
    private s f10361a;

    /* renamed from: b  reason: collision with root package name */
    private m f10362b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10363c;

    public void a(s sVar, g gVar, v.d dVar) {
        this.f10361a = sVar;
        dVar.a();
        this.f10362b = gVar.a(dVar.b(), 4);
        this.f10362b.a(Format.a(dVar.c(), "application/x-scte35", (String) null, -1, (DrmInitData) null));
    }

    public void a(l lVar) {
        if (!this.f10363c) {
            if (this.f10361a.c() != -9223372036854775807L) {
                this.f10362b.a(Format.a((String) null, "application/x-scte35", this.f10361a.c()));
                this.f10363c = true;
            } else {
                return;
            }
        }
        int b2 = lVar.b();
        this.f10362b.a(lVar, b2);
        this.f10362b.a(this.f10361a.b(), 1, b2, 0, (m.a) null);
    }
}
