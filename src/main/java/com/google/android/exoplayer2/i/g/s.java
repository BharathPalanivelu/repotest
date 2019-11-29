package com.google.android.exoplayer2.i.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.l;
import java.util.List;

final class s {

    /* renamed from: a  reason: collision with root package name */
    private final List<Format> f10359a;

    /* renamed from: b  reason: collision with root package name */
    private final m[] f10360b;

    public s(List<Format> list) {
        this.f10359a = list;
        this.f10360b = new m[list.size()];
    }

    public void a(g gVar, v.d dVar) {
        for (int i = 0; i < this.f10360b.length; i++) {
            dVar.a();
            m a2 = gVar.a(dVar.b(), 3);
            Format format = this.f10359a.get(i);
            String str = format.f8958f;
            boolean z = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            a.a(z, "Invalid closed caption mime type provided: " + str);
            a2.a(Format.a(format.f8953a != null ? format.f8953a : dVar.c(), str, (String) null, -1, format.x, format.y, format.z, (DrmInitData) null));
            this.f10360b[i] = a2;
        }
    }

    public void a(long j, l lVar) {
        com.google.android.exoplayer2.p.a.g.a(j, lVar, this.f10360b);
    }
}
