package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.o.b;
import com.google.android.exoplayer2.o.c;
import com.google.android.exoplayer2.o.d;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.s.h;
import com.google.android.exoplayer2.s.v;
import com.tencent.ijk.media.player.misc.IMediaFormat;
import java.nio.ByteBuffer;

@TargetApi(16)
public class i extends b implements h {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final e.a f9216b;

    /* renamed from: c  reason: collision with root package name */
    private final f f9217c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9218d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9219e;

    /* renamed from: f  reason: collision with root package name */
    private MediaFormat f9220f;

    /* renamed from: g  reason: collision with root package name */
    private int f9221g;
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

    public h c() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void v() {
    }

    public i(c cVar, com.google.android.exoplayer2.drm.b<d> bVar, boolean z, Handler handler, e eVar, c cVar2, d... dVarArr) {
        super(1, cVar, bVar, z);
        this.f9217c = new f(cVar2, dVarArr, new a());
        this.f9216b = new e.a(handler, eVar);
    }

    /* access modifiers changed from: protected */
    public int a(c cVar, Format format) throws d.b {
        String str = format.f8958f;
        if (!com.google.android.exoplayer2.s.i.a(str)) {
            return 0;
        }
        int i2 = v.f11449a >= 21 ? 32 : 0;
        int i3 = 4;
        if (a(str) && cVar.a() != null) {
            return i2 | 8 | 4;
        }
        com.google.android.exoplayer2.o.a a2 = cVar.a(str, false);
        boolean z = true;
        if (a2 == null) {
            return 1;
        }
        if (v.f11449a >= 21 && ((format.s != -1 && !a2.a(format.s)) || (format.r != -1 && !a2.b(format.r)))) {
            z = false;
        }
        if (!z) {
            i3 = 3;
        }
        return i2 | 8 | i3;
    }

    /* access modifiers changed from: protected */
    public com.google.android.exoplayer2.o.a a(c cVar, Format format, boolean z) throws d.b {
        if (a(format.f8958f)) {
            com.google.android.exoplayer2.o.a a2 = cVar.a();
            if (a2 != null) {
                this.f9218d = true;
                return a2;
            }
        }
        this.f9218d = false;
        return super.a(cVar, format, z);
    }

    /* access modifiers changed from: protected */
    public boolean a(String str) {
        return this.f9217c.a(str);
    }

    /* access modifiers changed from: protected */
    public void a(com.google.android.exoplayer2.o.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.f9219e = b(aVar.f10994a);
        if (this.f9218d) {
            this.f9220f = format.b();
            this.f9220f.setString(IMediaFormat.KEY_MIME, "audio/raw");
            mediaCodec.configure(this.f9220f, (Surface) null, mediaCrypto, 0);
            this.f9220f.setString(IMediaFormat.KEY_MIME, format.f8958f);
            return;
        }
        mediaCodec.configure(format.b(), (Surface) null, mediaCrypto, 0);
        this.f9220f = null;
    }

    /* access modifiers changed from: protected */
    public void a(String str, long j2, long j3) {
        this.f9216b.a(str, j2, j3);
    }

    /* access modifiers changed from: protected */
    public void b(Format format) throws com.google.android.exoplayer2.e {
        super.b(format);
        this.f9216b.a(format);
        this.f9221g = "audio/raw".equals(format.f8958f) ? format.t : 2;
        this.h = format.r;
    }

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.google.android.exoplayer2.e {
        int[] iArr;
        boolean z = this.f9220f != null;
        String string = z ? this.f9220f.getString(IMediaFormat.KEY_MIME) : "audio/raw";
        if (z) {
            mediaFormat = this.f9220f;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.f9219e && integer == 6) {
            int i2 = this.h;
            if (i2 < 6) {
                iArr = new int[i2];
                for (int i3 = 0; i3 < this.h; i3++) {
                    iArr[i3] = i3;
                }
                this.f9217c.a(string, integer, integer2, this.f9221g, 0, iArr);
            }
        }
        iArr = null;
        try {
            this.f9217c.a(string, integer, integer2, this.f9221g, 0, iArr);
        } catch (f.c e2) {
            throw com.google.android.exoplayer2.e.a(e2, r());
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) throws com.google.android.exoplayer2.e {
        super.a(z);
        this.f9216b.a(this.f11001a);
        int i2 = q().f12192b;
        if (i2 != 0) {
            this.f9217c.a(i2);
        } else {
            this.f9217c.g();
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z) throws com.google.android.exoplayer2.e {
        super.a(j2, z);
        this.f9217c.i();
        this.i = j2;
        this.j = true;
    }

    /* access modifiers changed from: protected */
    public void n() {
        super.n();
        this.f9217c.a();
    }

    /* access modifiers changed from: protected */
    public void o() {
        this.f9217c.h();
        super.o();
    }

    /* access modifiers changed from: protected */
    public void p() {
        try {
            this.f9217c.j();
            try {
                super.p();
            } finally {
                this.f11001a.a();
                this.f9216b.b(this.f11001a);
            }
        } catch (Throwable th) {
            super.p();
            throw th;
        } finally {
            this.f11001a.a();
            this.f9216b.b(this.f11001a);
        }
    }

    public boolean u() {
        return super.u() && this.f9217c.d();
    }

    public boolean t() {
        return this.f9217c.e() || super.t();
    }

    public long w() {
        long a2 = this.f9217c.a(u());
        if (a2 != Long.MIN_VALUE) {
            if (!this.j) {
                a2 = Math.max(this.i, a2);
            }
            this.i = a2;
            this.j = false;
        }
        return this.i;
    }

    public q a(q qVar) {
        return this.f9217c.a(qVar);
    }

    public q x() {
        return this.f9217c.f();
    }

    /* access modifiers changed from: protected */
    public boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) throws com.google.android.exoplayer2.e {
        if (this.f9218d && (i3 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i2, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i2, false);
            this.f11001a.f9877e++;
            this.f9217c.b();
            return true;
        } else {
            try {
                if (!this.f9217c.a(byteBuffer, j4)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i2, false);
                this.f11001a.f9876d++;
                return true;
            } catch (f.d | f.h e2) {
                throw com.google.android.exoplayer2.e.a(e2, r());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void y() throws com.google.android.exoplayer2.e {
        try {
            this.f9217c.c();
        } catch (f.h e2) {
            throw com.google.android.exoplayer2.e.a(e2, r());
        }
    }

    public void a(int i2, Object obj) throws com.google.android.exoplayer2.e {
        if (i2 == 2) {
            this.f9217c.a(((Float) obj).floatValue());
        } else if (i2 != 3) {
            super.a(i2, obj);
        } else {
            this.f9217c.a((b) obj);
        }
    }

    private static boolean b(String str) {
        return v.f11449a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(v.f11451c) && (v.f11450b.startsWith("zeroflte") || v.f11450b.startsWith("herolte") || v.f11450b.startsWith("heroqlte"));
    }

    private final class a implements f.C0158f {
        private a() {
        }

        public void a(int i) {
            i.this.f9216b.a(i);
            i.this.b(i);
        }

        public void a() {
            i.this.v();
            boolean unused = i.this.j = true;
        }

        public void a(int i, long j, long j2) {
            i.this.f9216b.a(i, j, j2);
            i.this.a(i, j, j2);
        }
    }
}
