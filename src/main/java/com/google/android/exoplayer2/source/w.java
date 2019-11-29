package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.ar;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.m.b;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.source.y;
import java.io.IOException;

public final class w implements y, y.a {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f12184a;

    /* renamed from: b  reason: collision with root package name */
    private final f.a f12185b;

    /* renamed from: c  reason: collision with root package name */
    private final i f12186c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12187d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f12188e;

    /* renamed from: f  reason: collision with root package name */
    private final a f12189f;

    /* renamed from: g  reason: collision with root package name */
    private final ar.a f12190g;
    private final String h;
    private y.a i;
    private ar j;
    private boolean k;

    public interface a {
        void onLoadError(IOException iOException);
    }

    public void a() throws IOException {
    }

    public w(Uri uri, f.a aVar, i iVar, Handler handler, a aVar2) {
        this(uri, aVar, iVar, -1, handler, aVar2, (String) null);
    }

    public w(Uri uri, f.a aVar, i iVar, int i2, Handler handler, a aVar2, String str) {
        this.f12184a = uri;
        this.f12185b = aVar;
        this.f12186c = iVar;
        this.f12187d = i2;
        this.f12188e = handler;
        this.f12189f = aVar2;
        this.h = str;
        this.f12190g = new ar.a();
    }

    public void a(ad adVar, boolean z, y.a aVar) {
        this.i = aVar;
        this.j = new ab(-9223372036854775807L, false);
        aVar.a(this.j, (Object) null);
    }

    public x a(int i2, b bVar, long j2) {
        com.google.android.exoplayer2.n.a.a(i2 == 0);
        return new v(this.f12184a, this.f12185b.a(), this.f12186c.a(), this.f12187d, this.f12188e, this.f12189f, this, bVar, this.h);
    }

    public void a(x xVar) {
        ((v) xVar).g();
    }

    public void b() {
        this.i = null;
    }

    public void a(ar arVar, Object obj) {
        boolean z = false;
        if (arVar.a(0, this.f12190g).b() != -9223372036854775807L) {
            z = true;
        }
        if (!this.k || z) {
            this.j = arVar;
            this.k = z;
            this.i.a(this.j, (Object) null);
        }
    }
}
