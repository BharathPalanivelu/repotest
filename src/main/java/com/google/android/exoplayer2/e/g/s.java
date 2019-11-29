package com.google.android.exoplayer2.e.g;

import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.j.a.g;
import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.n.k;
import java.util.List;

final class s {

    /* renamed from: a  reason: collision with root package name */
    private final List<j> f9724a;

    /* renamed from: b  reason: collision with root package name */
    private final n[] f9725b;

    public s(List<j> list) {
        this.f9724a = list;
        this.f9725b = new n[list.size()];
    }

    public void a(h hVar, v.d dVar) {
        for (int i = 0; i < this.f9725b.length; i++) {
            dVar.a();
            n a2 = hVar.a(dVar.b(), 3);
            j jVar = this.f9724a.get(i);
            String str = jVar.f10427f;
            boolean z = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            a.a(z, "Invalid closed caption mime type provided: " + str);
            a2.a(j.a(dVar.c(), str, (String) null, -1, jVar.x, jVar.y, jVar.z, (com.google.android.exoplayer2.c.a) null));
            this.f9725b[i] = a2;
        }
    }

    public void a(long j, k kVar) {
        g.a(j, kVar, this.f9725b);
    }
}
