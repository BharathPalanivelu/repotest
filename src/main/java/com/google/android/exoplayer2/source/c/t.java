package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.m.b;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.source.ab;
import com.google.android.exoplayer2.source.c.a.b;
import com.google.android.exoplayer2.source.c.a.e;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y;
import java.io.IOException;
import java.util.List;

public final class t implements e.c, y {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f11751a;

    /* renamed from: b  reason: collision with root package name */
    private final p f11752b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11753c;

    /* renamed from: d  reason: collision with root package name */
    private final r.a f11754d;

    /* renamed from: e  reason: collision with root package name */
    private e f11755e;

    /* renamed from: f  reason: collision with root package name */
    private y.a f11756f;

    public t(Uri uri, f.a aVar, Handler handler, r rVar) {
        this(uri, aVar, 3, handler, rVar);
    }

    public t(Uri uri, f.a aVar, int i, Handler handler, r rVar) {
        this(uri, (p) new n(aVar), i, handler, rVar);
    }

    public t(Uri uri, p pVar, int i, Handler handler, r rVar) {
        this.f11751a = uri;
        this.f11752b = pVar;
        this.f11753c = i;
        this.f11754d = new r.a(handler, rVar);
    }

    public void a(ad adVar, boolean z, y.a aVar) {
        a.b(this.f11755e == null);
        this.f11755e = new e(this.f11751a, this.f11752b, this.f11754d, this.f11753c, this);
        this.f11756f = aVar;
        this.f11755e.a();
    }

    public void a() throws IOException {
        this.f11755e.d();
    }

    public x a(int i, b bVar, long j) {
        a.a(i == 0);
        return new s(this.f11755e, this.f11752b, this.f11753c, this.f11754d, bVar, j);
    }

    public void a(x xVar) {
        ((s) xVar).g();
    }

    public void b() {
        e eVar = this.f11755e;
        if (eVar != null) {
            eVar.c();
            this.f11755e = null;
        }
        this.f11756f = null;
    }

    public void a(com.google.android.exoplayer2.source.c.a.b bVar) {
        ab abVar;
        com.google.android.exoplayer2.source.c.a.b bVar2 = bVar;
        long j = bVar2.f11599b;
        if (this.f11755e.e()) {
            long j2 = bVar2.i ? bVar2.f11600c + bVar2.n : -9223372036854775807L;
            List<b.a> list = bVar2.l;
            if (j == -9223372036854775807L) {
                if (list.isEmpty()) {
                    j = 0;
                } else {
                    j = list.get(Math.max(0, list.size() - 3)).f11608d;
                }
            }
            abVar = new ab(j2, bVar2.n, bVar2.f11600c, j, true, !bVar2.i);
        } else {
            abVar = new ab(bVar2.f11600c + bVar2.n, bVar2.n, bVar2.f11600c, j == -9223372036854775807L ? 0 : j, true, false);
        }
        this.f11756f.a(abVar, new q(this.f11755e.b(), bVar2));
    }
}
