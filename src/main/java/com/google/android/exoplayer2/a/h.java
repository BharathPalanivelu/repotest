package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.a.d;
import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.ac;
import com.google.android.exoplayer2.al;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.c;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.g;
import com.google.android.exoplayer2.n.t;
import com.tencent.ijk.media.player.misc.IMediaFormat;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h extends b implements g {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d.a f9034b;

    /* renamed from: c  reason: collision with root package name */
    private final e f9035c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9036d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9037e;

    /* renamed from: f  reason: collision with root package name */
    private MediaFormat f9038f;

    /* renamed from: g  reason: collision with root package name */
    private int f9039g;
    private int h;
    private long i;
    /* access modifiers changed from: private */
    public boolean j;

    /* access modifiers changed from: protected */
    public void a(int i2, long j2, long j3) {
    }

    /* access modifiers changed from: protected */
    public void b(int i2) {
    }

    public g c() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void t() {
    }

    public h(c cVar, com.google.android.exoplayer2.c.c<e> cVar2, boolean z, Handler handler, d dVar, b bVar, c... cVarArr) {
        super(1, cVar, cVar2, z);
        this.f9035c = new e(bVar, cVarArr, new a());
        this.f9034b = new d.a(handler, dVar);
    }

    /* access modifiers changed from: protected */
    public int a(c cVar, j jVar) throws d.b {
        String str = jVar.f10427f;
        if (!com.google.android.exoplayer2.n.h.a(str)) {
            return 0;
        }
        int i2 = t.f10975a >= 21 ? 16 : 0;
        int i3 = 3;
        if (a(str) && cVar.a() != null) {
            return i2 | 4 | 3;
        }
        com.google.android.exoplayer2.h.a a2 = cVar.a(str, false);
        boolean z = true;
        if (a2 == null) {
            return 1;
        }
        if (t.f10975a >= 21 && ((jVar.s != -1 && !a2.a(jVar.s)) || (jVar.r != -1 && !a2.b(jVar.r)))) {
            z = false;
        }
        if (!z) {
            i3 = 2;
        }
        return i2 | 4 | i3;
    }

    /* access modifiers changed from: protected */
    public com.google.android.exoplayer2.h.a a(c cVar, j jVar, boolean z) throws d.b {
        if (a(jVar.f10427f)) {
            com.google.android.exoplayer2.h.a a2 = cVar.a();
            if (a2 != null) {
                this.f9036d = true;
                return a2;
            }
        }
        this.f9036d = false;
        return super.a(cVar, jVar, z);
    }

    /* access modifiers changed from: protected */
    public boolean a(String str) {
        return this.f9035c.a(str);
    }

    /* access modifiers changed from: protected */
    public void a(com.google.android.exoplayer2.h.a aVar, MediaCodec mediaCodec, j jVar, MediaCrypto mediaCrypto) {
        this.f9037e = b(aVar.f9902a);
        if (this.f9036d) {
            this.f9038f = jVar.b();
            this.f9038f.setString(IMediaFormat.KEY_MIME, "audio/raw");
            mediaCodec.configure(this.f9038f, (Surface) null, mediaCrypto, 0);
            this.f9038f.setString(IMediaFormat.KEY_MIME, jVar.f10427f);
            return;
        }
        mediaCodec.configure(jVar.b(), (Surface) null, mediaCrypto, 0);
        this.f9038f = null;
    }

    /* access modifiers changed from: protected */
    public void a(String str, long j2, long j3) {
        this.f9034b.a(str, j2, j3);
    }

    /* access modifiers changed from: protected */
    public void a(j jVar) throws ac {
        super.a(jVar);
        this.f9034b.a(jVar);
        this.f9039g = "audio/raw".equals(jVar.f10427f) ? jVar.t : 2;
        this.h = jVar.r;
    }

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ac {
        int[] iArr;
        boolean z = this.f9038f != null;
        String string = z ? this.f9038f.getString(IMediaFormat.KEY_MIME) : "audio/raw";
        if (z) {
            mediaFormat = this.f9038f;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.f9037e && integer == 6) {
            int i2 = this.h;
            if (i2 < 6) {
                iArr = new int[i2];
                for (int i3 = 0; i3 < this.h; i3++) {
                    iArr[i3] = i3;
                }
                this.f9035c.a(string, integer, integer2, this.f9039g, 0, iArr);
            }
        }
        iArr = null;
        try {
            this.f9035c.a(string, integer, integer2, this.f9039g, 0, iArr);
        } catch (e.c e2) {
            throw ac.a(e2, r());
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) throws ac {
        super.a(z);
        this.f9034b.a(this.f9908a);
        int i2 = q().f9113b;
        if (i2 != 0) {
            this.f9035c.b(i2);
        } else {
            this.f9035c.g();
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z) throws ac {
        super.a(j2, z);
        this.f9035c.i();
        this.i = j2;
        this.j = true;
    }

    /* access modifiers changed from: protected */
    public void n() {
        super.n();
        this.f9035c.a();
    }

    /* access modifiers changed from: protected */
    public void o() {
        this.f9035c.h();
        super.o();
    }

    /* access modifiers changed from: protected */
    public void p() {
        try {
            this.f9035c.j();
            try {
                super.p();
            } finally {
                this.f9908a.a();
                this.f9034b.b(this.f9908a);
            }
        } catch (Throwable th) {
            super.p();
            throw th;
        } finally {
            this.f9908a.a();
            this.f9034b.b(this.f9908a);
        }
    }

    public boolean u() {
        return super.u() && this.f9035c.d();
    }

    public boolean v() {
        return this.f9035c.e() || super.v();
    }

    public long w() {
        long a2 = this.f9035c.a(u());
        if (a2 != Long.MIN_VALUE) {
            if (!this.j) {
                a2 = Math.max(this.i, a2);
            }
            this.i = a2;
            this.j = false;
        }
        return this.i;
    }

    public al a(al alVar) {
        return this.f9035c.a(alVar);
    }

    public al x() {
        return this.f9035c.f();
    }

    /* access modifiers changed from: protected */
    public boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) throws ac {
        if (this.f9036d && (i3 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i2, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i2, false);
            this.f9908a.f9276e++;
            this.f9035c.b();
            return true;
        } else {
            try {
                if (!this.f9035c.a(byteBuffer, j4)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i2, false);
                this.f9908a.f9275d++;
                return true;
            } catch (e.d | e.h e2) {
                throw ac.a(e2, r());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void y() throws ac {
        try {
            this.f9035c.c();
        } catch (e.h e2) {
            throw ac.a(e2, r());
        }
    }

    public void a(int i2, Object obj) throws ac {
        if (i2 == 2) {
            this.f9035c.a(((Float) obj).floatValue());
        } else if (i2 != 3) {
            super.a(i2, obj);
        } else {
            this.f9035c.a(((Integer) obj).intValue());
        }
    }

    private static boolean b(String str) {
        return t.f10975a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(t.f10977c) && (t.f10976b.startsWith("zeroflte") || t.f10976b.startsWith("herolte") || t.f10976b.startsWith("heroqlte"));
    }

    private final class a implements e.f {
        private a() {
        }

        public void a(int i) {
            h.this.f9034b.a(i);
            h.this.b(i);
        }

        public void a() {
            h.this.t();
            boolean unused = h.this.j = true;
        }

        public void a(int i, long j, long j2) {
            h.this.f9034b.a(i, j, j2);
            h.this.a(i, j, j2);
        }
    }
}
