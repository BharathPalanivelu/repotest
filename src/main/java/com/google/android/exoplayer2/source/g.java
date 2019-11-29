package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.facebook.common.util.ByteConstants;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.r.b;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.x;
import java.io.IOException;

public final class g implements f.c, i {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f12075a;

    /* renamed from: b  reason: collision with root package name */
    private final f.a f12076b;

    /* renamed from: c  reason: collision with root package name */
    private final h f12077c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12078d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f12079e;

    /* renamed from: f  reason: collision with root package name */
    private final a f12080f;

    /* renamed from: g  reason: collision with root package name */
    private final x.a f12081g;
    private final String h;
    private final int i;
    private i.a j;
    private long k;
    private boolean l;

    public interface a {
        void a(IOException iOException);
    }

    public void a() throws IOException {
    }

    public g(Uri uri, f.a aVar, h hVar, Handler handler, a aVar2) {
        this(uri, aVar, hVar, handler, aVar2, (String) null);
    }

    public g(Uri uri, f.a aVar, h hVar, Handler handler, a aVar2, String str) {
        this(uri, aVar, hVar, -1, handler, aVar2, str, ByteConstants.MB);
    }

    public g(Uri uri, f.a aVar, h hVar, int i2, Handler handler, a aVar2, String str, int i3) {
        this.f12075a = uri;
        this.f12076b = aVar;
        this.f12077c = hVar;
        this.f12078d = i2;
        this.f12079e = handler;
        this.f12080f = aVar2;
        this.h = str;
        this.i = i3;
        this.f12081g = new x.a();
    }

    public void a(com.google.android.exoplayer2.f fVar, boolean z, i.a aVar) {
        this.j = aVar;
        b(-9223372036854775807L, false);
    }

    public h a(i.b bVar, b bVar2) {
        com.google.android.exoplayer2.s.a.a(bVar.f12083b == 0);
        return new f(this.f12075a, this.f12076b.a(), this.f12077c.a(), this.f12078d, this.f12079e, this.f12080f, this, bVar2, this.h, this.i);
    }

    public void a(h hVar) {
        ((f) hVar).f();
    }

    public void b() {
        this.j = null;
    }

    public void a(long j2, boolean z) {
        if (j2 == -9223372036854775807L) {
            j2 = this.k;
        }
        if (this.k != j2 || this.l != z) {
            if (this.k == -9223372036854775807L || j2 != -9223372036854775807L) {
                b(j2, z);
            }
        }
    }

    private void b(long j2, boolean z) {
        this.k = j2;
        this.l = z;
        this.j.a(new n(this.k, this.l), (Object) null);
    }
}
