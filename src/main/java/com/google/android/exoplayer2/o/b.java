package com.google.android.exoplayer2.o;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.a;
import com.google.android.exoplayer2.g.d;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.o.d;
import com.google.android.exoplayer2.s.j;
import com.google.android.exoplayer2.s.t;
import com.google.android.exoplayer2.s.v;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b extends com.google.android.exoplayer2.a {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f11000b = v.h("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private long A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;

    /* renamed from: a  reason: collision with root package name */
    protected d f11001a;

    /* renamed from: c  reason: collision with root package name */
    private final c f11002c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> f11003d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11004e;

    /* renamed from: f  reason: collision with root package name */
    private final e f11005f;

    /* renamed from: g  reason: collision with root package name */
    private final e f11006g;
    private final l h;
    private final List<Long> i;
    private final MediaCodec.BufferInfo j;
    private Format k;
    private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> l;
    private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> m;
    private MediaCodec n;
    private a o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private ByteBuffer[] y;
    private ByteBuffer[] z;

    /* access modifiers changed from: protected */
    public long E() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract int a(c cVar, Format format) throws d.b;

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.google.android.exoplayer2.e {
    }

    /* access modifiers changed from: protected */
    public void a(e eVar) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws d.b;

    /* access modifiers changed from: protected */
    public void a(String str, long j2, long j3) {
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z2) throws com.google.android.exoplayer2.e;

    /* access modifiers changed from: protected */
    public boolean a(MediaCodec mediaCodec, boolean z2, Format format, Format format2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean a(a aVar) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void c(long j2) {
    }

    public final int m() {
        return 8;
    }

    /* access modifiers changed from: protected */
    public void n() {
    }

    /* access modifiers changed from: protected */
    public void o() {
    }

    /* access modifiers changed from: protected */
    public void y() throws com.google.android.exoplayer2.e {
    }

    public static class a extends Exception {
        public final String decoderName;
        public final String diagnosticInfo;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public a(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            this.mimeType = format.f8958f;
            this.secureDecoderRequired = z;
            this.decoderName = null;
            this.diagnosticInfo = a(i);
        }

        public a(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            this.mimeType = format.f8958f;
            this.secureDecoderRequired = z;
            this.decoderName = str;
            this.diagnosticInfo = v.f11449a >= 21 ? a(th) : null;
        }

        @TargetApi(21)
        private static String a(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String a(int i) {
            String str = i < 0 ? "neg_" : "";
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(i);
        }
    }

    public b(int i2, c cVar, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> bVar, boolean z2) {
        super(i2);
        com.google.android.exoplayer2.s.a.b(v.f11449a >= 16);
        this.f11002c = (c) com.google.android.exoplayer2.s.a.a(cVar);
        this.f11003d = bVar;
        this.f11004e = z2;
        this.f11005f = new e(0);
        this.f11006g = e.e();
        this.h = new l();
        this.i = new ArrayList();
        this.j = new MediaCodec.BufferInfo();
        this.F = 0;
        this.G = 0;
    }

    public final int a(Format format) throws com.google.android.exoplayer2.e {
        try {
            int a2 = a(this.f11002c, format);
            return ((a2 & 7) <= 2 || a((com.google.android.exoplayer2.drm.b) this.f11003d, format.i)) ? a2 : (a2 & -8) | 2;
        } catch (d.b e2) {
            throw com.google.android.exoplayer2.e.a(e2, r());
        }
    }

    /* access modifiers changed from: protected */
    public a a(c cVar, Format format, boolean z2) throws d.b {
        return cVar.a(format.f8958f, z2);
    }

    /* access modifiers changed from: protected */
    public final void z() throws com.google.android.exoplayer2.e {
        MediaCrypto mediaCrypto;
        boolean z2;
        if (this.n == null) {
            Format format = this.k;
            if (format != null) {
                this.l = this.m;
                String str = format.f8958f;
                com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> aVar = this.l;
                if (aVar != null) {
                    com.google.android.exoplayer2.drm.d c2 = aVar.c();
                    if (c2 == null) {
                        a.C0160a b2 = this.l.b();
                        if (b2 != null) {
                            throw com.google.android.exoplayer2.e.a(b2, r());
                        }
                        return;
                    }
                    mediaCrypto = c2.a();
                    z2 = c2.a(str);
                } else {
                    mediaCrypto = null;
                    z2 = false;
                }
                if (this.o == null) {
                    try {
                        this.o = a(this.f11002c, this.k, z2);
                        if (this.o == null && z2) {
                            this.o = a(this.f11002c, this.k, false);
                            if (this.o != null) {
                                Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str + ", but " + "no secure decoder available. Trying to proceed with " + this.o.f10994a + ".");
                            }
                        }
                    } catch (d.b e2) {
                        a(new a(this.k, (Throwable) e2, z2, -49998));
                    }
                    if (this.o == null) {
                        a(new a(this.k, (Throwable) null, z2, -49999));
                    }
                }
                if (a(this.o)) {
                    String str2 = this.o.f10994a;
                    this.p = a(str2, this.k);
                    this.q = a(str2);
                    this.r = b(str2);
                    this.s = c(str2);
                    this.t = d(str2);
                    this.u = e(str2);
                    this.v = b(str2, this.k);
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        t.a("createCodec:" + str2);
                        this.n = MediaCodec.createByCodecName(str2);
                        t.a();
                        t.a("configureCodec");
                        a(this.o, this.n, this.k, mediaCrypto);
                        t.a();
                        t.a("startCodec");
                        this.n.start();
                        t.a();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        a(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.y = this.n.getInputBuffers();
                        this.z = this.n.getOutputBuffers();
                    } catch (Exception e3) {
                        a(new a(this.k, (Throwable) e3, z2, str2));
                    }
                    this.A = d() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.B = -1;
                    this.C = -1;
                    this.M = true;
                    this.f11001a.f9873a++;
                }
            }
        }
    }

    private void a(a aVar) throws com.google.android.exoplayer2.e {
        throw com.google.android.exoplayer2.e.a(aVar, r());
    }

    /* access modifiers changed from: protected */
    public final MediaCodec A() {
        return this.n;
    }

    /* access modifiers changed from: protected */
    public final a B() {
        return this.o;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) throws com.google.android.exoplayer2.e {
        this.f11001a = new com.google.android.exoplayer2.g.d();
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z2) throws com.google.android.exoplayer2.e {
        this.J = false;
        this.K = false;
        if (this.n != null) {
            D();
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        this.k = null;
        try {
            C();
            try {
                if (this.l != null) {
                    this.f11003d.a(this.l);
                }
                try {
                    if (!(this.m == null || this.m == this.l)) {
                        this.f11003d.a(this.m);
                    }
                } finally {
                    this.l = null;
                    this.m = null;
                }
            } catch (Throwable th) {
                if (!(this.m == null || this.m == this.l)) {
                    this.f11003d.a(this.m);
                }
                throw th;
            } finally {
                this.l = null;
                this.m = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.m == null || this.m == this.l)) {
                    this.f11003d.a(this.m);
                }
                throw th2;
            } finally {
                this.l = null;
                this.m = null;
            }
        } finally {
        }
    }

    /* access modifiers changed from: protected */
    public void C() {
        this.A = -9223372036854775807L;
        this.B = -1;
        this.C = -1;
        this.L = false;
        this.D = false;
        this.i.clear();
        this.y = null;
        this.z = null;
        this.o = null;
        this.E = false;
        this.H = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.I = false;
        this.F = 0;
        this.G = 0;
        this.f11005f.f9881b = null;
        if (this.n != null) {
            this.f11001a.f9874b++;
            try {
                this.n.stop();
                try {
                    this.n.release();
                    this.n = null;
                    com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> aVar = this.l;
                    if (aVar != null && this.m != aVar) {
                        try {
                            this.f11003d.a(aVar);
                        } finally {
                            this.l = null;
                        }
                    }
                } catch (Throwable th) {
                    this.n = null;
                    com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> aVar2 = this.l;
                    if (!(aVar2 == null || this.m == aVar2)) {
                        this.f11003d.a(aVar2);
                    }
                    throw th;
                } finally {
                    this.l = null;
                }
            } catch (Throwable th2) {
                this.n = null;
                com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> aVar3 = this.l;
                if (!(aVar3 == null || this.m == aVar3)) {
                    try {
                        this.f11003d.a(aVar3);
                    } finally {
                        this.l = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    public void a(long j2, long j3) throws com.google.android.exoplayer2.e {
        if (this.K) {
            y();
            return;
        }
        if (this.k == null) {
            this.f11006g.a();
            int a2 = a(this.h, this.f11006g, true);
            if (a2 == -5) {
                b(this.h.f10690a);
            } else if (a2 == -4) {
                com.google.android.exoplayer2.s.a.b(this.f11006g.c());
                this.J = true;
                F();
                return;
            } else {
                return;
            }
        }
        z();
        if (this.n != null) {
            t.a("drainAndFeed");
            do {
            } while (b(j2, j3));
            do {
            } while (v());
            t.a();
        } else {
            b(j2);
            this.f11006g.a();
            int a3 = a(this.h, this.f11006g, false);
            if (a3 == -5) {
                b(this.h.f10690a);
            } else if (a3 == -4) {
                com.google.android.exoplayer2.s.a.b(this.f11006g.c());
                this.J = true;
                F();
            }
        }
        this.f11001a.a();
    }

    /* access modifiers changed from: protected */
    public void D() throws com.google.android.exoplayer2.e {
        this.A = -9223372036854775807L;
        this.B = -1;
        this.C = -1;
        this.M = true;
        this.L = false;
        this.D = false;
        this.i.clear();
        this.w = false;
        this.x = false;
        if (this.q || (this.t && this.I)) {
            C();
            z();
        } else if (this.G != 0) {
            C();
            z();
        } else {
            this.n.flush();
            this.H = false;
        }
        if (this.E && this.k != null) {
            this.F = 1;
        }
    }

    private boolean v() throws com.google.android.exoplayer2.e {
        int i2;
        int i3;
        MediaCodec mediaCodec = this.n;
        if (mediaCodec == null || this.G == 2 || this.J) {
            return false;
        }
        if (this.B < 0) {
            this.B = mediaCodec.dequeueInputBuffer(0);
            int i4 = this.B;
            if (i4 < 0) {
                return false;
            }
            e eVar = this.f11005f;
            eVar.f9881b = this.y[i4];
            eVar.a();
        }
        if (this.G == 1) {
            if (!this.s) {
                this.I = true;
                this.n.queueInputBuffer(this.B, 0, 0, 0, 4);
                this.B = -1;
            }
            this.G = 2;
            return false;
        } else if (this.w) {
            this.w = false;
            this.f11005f.f9881b.put(f11000b);
            this.n.queueInputBuffer(this.B, 0, f11000b.length, 0, 0);
            this.B = -1;
            this.H = true;
            return true;
        } else {
            if (this.L) {
                i3 = -4;
                i2 = 0;
            } else {
                if (this.F == 1) {
                    for (int i5 = 0; i5 < this.k.h.size(); i5++) {
                        this.f11005f.f9881b.put(this.k.h.get(i5));
                    }
                    this.F = 2;
                }
                i2 = this.f11005f.f9881b.position();
                i3 = a(this.h, this.f11005f, false);
            }
            if (i3 == -3) {
                return false;
            }
            if (i3 == -5) {
                if (this.F == 2) {
                    this.f11005f.a();
                    this.F = 1;
                }
                b(this.h.f10690a);
                return true;
            } else if (this.f11005f.c()) {
                if (this.F == 2) {
                    this.f11005f.a();
                    this.F = 1;
                }
                this.J = true;
                if (!this.H) {
                    F();
                    return false;
                }
                try {
                    if (!this.s) {
                        this.I = true;
                        this.n.queueInputBuffer(this.B, 0, 0, 0, 4);
                        this.B = -1;
                    }
                    return false;
                } catch (MediaCodec.CryptoException e2) {
                    throw com.google.android.exoplayer2.e.a(e2, r());
                }
            } else if (!this.M || this.f11005f.d()) {
                this.M = false;
                boolean g2 = this.f11005f.g();
                this.L = b(g2);
                if (this.L) {
                    return false;
                }
                if (this.p && !g2) {
                    j.a(this.f11005f.f9881b);
                    if (this.f11005f.f9881b.position() == 0) {
                        return true;
                    }
                    this.p = false;
                }
                try {
                    long j2 = this.f11005f.f9882c;
                    if (this.f11005f.l_()) {
                        this.i.add(Long.valueOf(j2));
                    }
                    this.f11005f.h();
                    a(this.f11005f);
                    if (g2) {
                        this.n.queueSecureInputBuffer(this.B, 0, a(this.f11005f, i2), j2, 0);
                    } else {
                        this.n.queueInputBuffer(this.B, 0, this.f11005f.f9881b.limit(), j2, 0);
                    }
                    this.B = -1;
                    this.H = true;
                    this.F = 0;
                    this.f11001a.f9875c++;
                    return true;
                } catch (MediaCodec.CryptoException e3) {
                    throw com.google.android.exoplayer2.e.a(e3, r());
                }
            } else {
                this.f11005f.a();
                if (this.F == 2) {
                    this.F = 1;
                }
                return true;
            }
        }
    }

    private static MediaCodec.CryptoInfo a(e eVar, int i2) {
        MediaCodec.CryptoInfo a2 = eVar.f9880a.a();
        if (i2 == 0) {
            return a2;
        }
        if (a2.numBytesOfClearData == null) {
            a2.numBytesOfClearData = new int[1];
        }
        int[] iArr = a2.numBytesOfClearData;
        iArr[0] = iArr[0] + i2;
        return a2;
    }

    private boolean b(boolean z2) throws com.google.android.exoplayer2.e {
        if (this.l == null || (!z2 && this.f11004e)) {
            return false;
        }
        int a2 = this.l.a();
        if (a2 != 1) {
            return a2 != 4;
        }
        throw com.google.android.exoplayer2.e.a(this.l.b(), r());
    }

    /* access modifiers changed from: protected */
    public void b(Format format) throws com.google.android.exoplayer2.e {
        Format format2 = this.k;
        this.k = format;
        boolean z2 = true;
        if (!v.a((Object) this.k.i, (Object) format2 == null ? null : format2.i)) {
            if (this.k.i != null) {
                com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> bVar = this.f11003d;
                if (bVar != null) {
                    this.m = bVar.a(Looper.myLooper(), this.k.i);
                    com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> aVar = this.m;
                    if (aVar == this.l) {
                        this.f11003d.a(aVar);
                    }
                } else {
                    throw com.google.android.exoplayer2.e.a(new IllegalStateException("Media requires a DrmSessionManager"), r());
                }
            } else {
                this.m = null;
            }
        }
        if (this.m == this.l) {
            MediaCodec mediaCodec = this.n;
            if (mediaCodec != null && a(mediaCodec, this.o.f10995b, format2, this.k)) {
                this.E = true;
                this.F = 1;
                if (!(this.r && this.k.j == format2.j && this.k.k == format2.k)) {
                    z2 = false;
                }
                this.w = z2;
                return;
            }
        }
        if (this.H) {
            this.G = 1;
            return;
        }
        C();
        z();
    }

    public boolean u() {
        return this.K;
    }

    public boolean t() {
        return this.k != null && !this.L && (s() || this.C >= 0 || (this.A != -9223372036854775807L && SystemClock.elapsedRealtime() < this.A));
    }

    private boolean b(long j2, long j3) throws com.google.android.exoplayer2.e {
        boolean z2;
        if (this.C < 0) {
            if (!this.u || !this.I) {
                this.C = this.n.dequeueOutputBuffer(this.j, E());
            } else {
                try {
                    this.C = this.n.dequeueOutputBuffer(this.j, E());
                } catch (IllegalStateException unused) {
                    F();
                    if (this.K) {
                        C();
                    }
                    return false;
                }
            }
            int i2 = this.C;
            if (i2 >= 0) {
                if (this.x) {
                    this.x = false;
                    this.n.releaseOutputBuffer(i2, false);
                    this.C = -1;
                    return true;
                } else if ((this.j.flags & 4) != 0) {
                    F();
                    this.C = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.z[this.C];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.j.offset);
                        byteBuffer.limit(this.j.offset + this.j.size);
                    }
                    this.D = d(this.j.presentationTimeUs);
                }
            } else if (i2 == -2) {
                w();
                return true;
            } else if (i2 == -3) {
                x();
                return true;
            } else {
                if (this.s && (this.J || this.G == 2)) {
                    F();
                }
                return false;
            }
        }
        if (!this.u || !this.I) {
            MediaCodec mediaCodec = this.n;
            ByteBuffer[] byteBufferArr = this.z;
            int i3 = this.C;
            z2 = a(j2, j3, mediaCodec, byteBufferArr[i3], i3, this.j.flags, this.j.presentationTimeUs, this.D);
        } else {
            try {
                z2 = a(j2, j3, this.n, this.z[this.C], this.C, this.j.flags, this.j.presentationTimeUs, this.D);
            } catch (IllegalStateException unused2) {
                F();
                if (this.K) {
                    C();
                }
                return false;
            }
        }
        if (!z2) {
            return false;
        }
        c(this.j.presentationTimeUs);
        this.C = -1;
        return true;
    }

    private void w() throws com.google.android.exoplayer2.e {
        MediaFormat outputFormat = this.n.getOutputFormat();
        if (this.r && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.x = true;
            return;
        }
        if (this.v) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.n, outputFormat);
    }

    private void x() {
        this.z = this.n.getOutputBuffers();
    }

    private void F() throws com.google.android.exoplayer2.e {
        if (this.G == 2) {
            C();
            z();
            return;
        }
        this.K = true;
        y();
    }

    private boolean d(long j2) {
        int size = this.i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.i.get(i2).longValue() == j2) {
                this.i.remove(i2);
                return true;
            }
        }
        return false;
    }

    private static boolean a(com.google.android.exoplayer2.drm.b bVar, DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (bVar == null) {
            return false;
        }
        return bVar.a(drmInitData);
    }

    private static boolean a(String str) {
        return v.f11449a < 18 || (v.f11449a == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (v.f11449a == 19 && v.f11452d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean b(String str) {
        return v.f11449a < 24 && ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(v.f11450b) || "flounder_lte".equals(v.f11450b) || "grouper".equals(v.f11450b) || "tilapia".equals(v.f11450b));
    }

    private static boolean a(String str, Format format) {
        return v.f11449a < 21 && format.h.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean c(String str) {
        return v.f11449a <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private static boolean d(String str) {
        return (v.f11449a <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (v.f11449a <= 19 && "hb2000".equals(v.f11450b) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean e(String str) {
        return v.f11449a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean b(String str, Format format) {
        if (v.f11449a > 18 || format.r != 1 || !"OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return false;
        }
        return true;
    }
}
