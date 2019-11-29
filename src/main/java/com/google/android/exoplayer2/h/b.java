package com.google.android.exoplayer2.h;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.ac;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.c.c;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.d.d;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.i;
import com.google.android.exoplayer2.n.r;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b extends y {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f9907b = t.h("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
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
    protected d f9908a;

    /* renamed from: c  reason: collision with root package name */
    private final c f9909c;

    /* renamed from: d  reason: collision with root package name */
    private final c<e> f9910d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f9911e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.exoplayer2.d.e f9912f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.d.e f9913g;
    private final ah h;
    private final List<Long> i;
    private final MediaCodec.BufferInfo j;
    private j k;
    private MediaCodec l;
    private com.google.android.exoplayer2.c.b<e> m;
    private com.google.android.exoplayer2.c.b<e> n;
    private boolean o;
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
    public abstract int a(c cVar, j jVar) throws d.b;

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ac {
    }

    /* access modifiers changed from: protected */
    public void a(com.google.android.exoplayer2.d.e eVar) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(a aVar, MediaCodec mediaCodec, j jVar, MediaCrypto mediaCrypto) throws d.b;

    /* access modifiers changed from: protected */
    public void a(String str, long j2, long j3) {
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z2) throws ac;

    /* access modifiers changed from: protected */
    public boolean a(MediaCodec mediaCodec, boolean z2, j jVar, j jVar2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void c(long j2) {
    }

    public final int m() throws ac {
        return 4;
    }

    /* access modifiers changed from: protected */
    public void n() {
    }

    /* access modifiers changed from: protected */
    public void o() {
    }

    /* access modifiers changed from: protected */
    public void y() throws ac {
    }

    public static class a extends Exception {
        public final String decoderName;
        public final String diagnosticInfo;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public a(j jVar, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + jVar, th);
            this.mimeType = jVar.f10427f;
            this.secureDecoderRequired = z;
            this.decoderName = null;
            this.diagnosticInfo = a(i);
        }

        public a(j jVar, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + jVar, th);
            this.mimeType = jVar.f10427f;
            this.secureDecoderRequired = z;
            this.decoderName = str;
            this.diagnosticInfo = t.f10975a >= 21 ? a(th) : null;
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

    public b(int i2, c cVar, c<e> cVar2, boolean z2) {
        super(i2);
        com.google.android.exoplayer2.n.a.b(t.f10975a >= 16);
        this.f9909c = (c) com.google.android.exoplayer2.n.a.a(cVar);
        this.f9910d = cVar2;
        this.f9911e = z2;
        this.f9912f = new com.google.android.exoplayer2.d.e(0);
        this.f9913g = com.google.android.exoplayer2.d.e.e();
        this.h = new ah();
        this.i = new ArrayList();
        this.j = new MediaCodec.BufferInfo();
        this.F = 0;
        this.G = 0;
    }

    public final int b(j jVar) throws ac {
        try {
            return a(this.f9909c, jVar);
        } catch (d.b e2) {
            throw ac.a(e2, r());
        }
    }

    /* access modifiers changed from: protected */
    public a a(c cVar, j jVar, boolean z2) throws d.b {
        return cVar.a(jVar.f10427f, z2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z() throws com.google.android.exoplayer2.ac {
        /*
            r14 = this;
            boolean r0 = r14.A()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            com.google.android.exoplayer2.c.b<com.google.android.exoplayer2.c.e> r0 = r14.n
            r14.m = r0
            com.google.android.exoplayer2.j r0 = r14.k
            java.lang.String r0 = r0.f10427f
            com.google.android.exoplayer2.c.b<com.google.android.exoplayer2.c.e> r1 = r14.m
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x0045
            int r1 = r1.a()
            if (r1 == 0) goto L_0x0036
            r4 = 3
            if (r1 == r4) goto L_0x0023
            r4 = 4
            if (r1 != r4) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            return
        L_0x0023:
            com.google.android.exoplayer2.c.b<com.google.android.exoplayer2.c.e> r1 = r14.m
            com.google.android.exoplayer2.c.d r1 = r1.b()
            com.google.android.exoplayer2.c.e r1 = (com.google.android.exoplayer2.c.e) r1
            android.media.MediaCrypto r1 = r1.a()
            com.google.android.exoplayer2.c.b<com.google.android.exoplayer2.c.e> r4 = r14.m
            boolean r4 = r4.a(r0)
            goto L_0x0047
        L_0x0036:
            com.google.android.exoplayer2.c.b<com.google.android.exoplayer2.c.e> r0 = r14.m
            com.google.android.exoplayer2.c.b$a r0 = r0.c()
            int r1 = r14.r()
            com.google.android.exoplayer2.ac r0 = com.google.android.exoplayer2.ac.a(r0, r1)
            throw r0
        L_0x0045:
            r1 = r3
            r4 = 0
        L_0x0047:
            com.google.android.exoplayer2.h.c r5 = r14.f9909c     // Catch:{ b -> 0x008a }
            com.google.android.exoplayer2.j r6 = r14.k     // Catch:{ b -> 0x008a }
            com.google.android.exoplayer2.h.a r5 = r14.a((com.google.android.exoplayer2.h.c) r5, (com.google.android.exoplayer2.j) r6, (boolean) r4)     // Catch:{ b -> 0x008a }
            if (r5 != 0) goto L_0x0099
            if (r4 == 0) goto L_0x0099
            com.google.android.exoplayer2.h.c r6 = r14.f9909c     // Catch:{ b -> 0x0088 }
            com.google.android.exoplayer2.j r7 = r14.k     // Catch:{ b -> 0x0088 }
            com.google.android.exoplayer2.h.a r5 = r14.a((com.google.android.exoplayer2.h.c) r6, (com.google.android.exoplayer2.j) r7, (boolean) r2)     // Catch:{ b -> 0x0088 }
            if (r5 == 0) goto L_0x0099
            java.lang.String r6 = "MediaCodecRenderer"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ b -> 0x0088 }
            r7.<init>()     // Catch:{ b -> 0x0088 }
            java.lang.String r8 = "Drm session requires secure decoder for "
            r7.append(r8)     // Catch:{ b -> 0x0088 }
            r7.append(r0)     // Catch:{ b -> 0x0088 }
            java.lang.String r0 = ", but "
            r7.append(r0)     // Catch:{ b -> 0x0088 }
            java.lang.String r0 = "no secure decoder available. Trying to proceed with "
            r7.append(r0)     // Catch:{ b -> 0x0088 }
            java.lang.String r0 = r5.f9902a     // Catch:{ b -> 0x0088 }
            r7.append(r0)     // Catch:{ b -> 0x0088 }
            java.lang.String r0 = "."
            r7.append(r0)     // Catch:{ b -> 0x0088 }
            java.lang.String r0 = r7.toString()     // Catch:{ b -> 0x0088 }
            android.util.Log.w(r6, r0)     // Catch:{ b -> 0x0088 }
            goto L_0x0099
        L_0x0088:
            r0 = move-exception
            goto L_0x008c
        L_0x008a:
            r0 = move-exception
            r5 = r3
        L_0x008c:
            com.google.android.exoplayer2.h.b$a r6 = new com.google.android.exoplayer2.h.b$a
            com.google.android.exoplayer2.j r7 = r14.k
            r8 = -49998(0xffffffffffff3cb2, float:NaN)
            r6.<init>((com.google.android.exoplayer2.j) r7, (java.lang.Throwable) r0, (boolean) r4, (int) r8)
            r14.a((com.google.android.exoplayer2.h.b.a) r6)
        L_0x0099:
            if (r5 != 0) goto L_0x00a8
            com.google.android.exoplayer2.h.b$a r0 = new com.google.android.exoplayer2.h.b$a
            com.google.android.exoplayer2.j r6 = r14.k
            r7 = -49999(0xffffffffffff3cb1, float:NaN)
            r0.<init>((com.google.android.exoplayer2.j) r6, (java.lang.Throwable) r3, (boolean) r4, (int) r7)
            r14.a((com.google.android.exoplayer2.h.b.a) r0)
        L_0x00a8:
            java.lang.String r0 = r5.f9902a
            boolean r3 = r5.f9903b
            r6 = 1
            if (r3 == 0) goto L_0x00b6
            boolean r3 = f(r0)
            if (r3 != 0) goto L_0x00b6
            r2 = 1
        L_0x00b6:
            r14.o = r2
            com.google.android.exoplayer2.j r2 = r14.k
            boolean r2 = a((java.lang.String) r0, (com.google.android.exoplayer2.j) r2)
            r14.p = r2
            boolean r2 = a((java.lang.String) r0)
            r14.q = r2
            boolean r2 = b((java.lang.String) r0)
            r14.r = r2
            boolean r2 = c((java.lang.String) r0)
            r14.s = r2
            boolean r2 = d((java.lang.String) r0)
            r14.t = r2
            boolean r2 = e(r0)
            r14.u = r2
            com.google.android.exoplayer2.j r2 = r14.k
            boolean r2 = b((java.lang.String) r0, (com.google.android.exoplayer2.j) r2)
            r14.v = r2
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x013f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013f }
            r7.<init>()     // Catch:{ Exception -> 0x013f }
            java.lang.String r8 = "createCodec:"
            r7.append(r8)     // Catch:{ Exception -> 0x013f }
            r7.append(r0)     // Catch:{ Exception -> 0x013f }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x013f }
            com.google.android.exoplayer2.n.r.a(r7)     // Catch:{ Exception -> 0x013f }
            android.media.MediaCodec r7 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x013f }
            r14.l = r7     // Catch:{ Exception -> 0x013f }
            com.google.android.exoplayer2.n.r.a()     // Catch:{ Exception -> 0x013f }
            java.lang.String r7 = "configureCodec"
            com.google.android.exoplayer2.n.r.a(r7)     // Catch:{ Exception -> 0x013f }
            android.media.MediaCodec r7 = r14.l     // Catch:{ Exception -> 0x013f }
            com.google.android.exoplayer2.j r8 = r14.k     // Catch:{ Exception -> 0x013f }
            r14.a((com.google.android.exoplayer2.h.a) r5, (android.media.MediaCodec) r7, (com.google.android.exoplayer2.j) r8, (android.media.MediaCrypto) r1)     // Catch:{ Exception -> 0x013f }
            com.google.android.exoplayer2.n.r.a()     // Catch:{ Exception -> 0x013f }
            java.lang.String r1 = "startCodec"
            com.google.android.exoplayer2.n.r.a(r1)     // Catch:{ Exception -> 0x013f }
            android.media.MediaCodec r1 = r14.l     // Catch:{ Exception -> 0x013f }
            r1.start()     // Catch:{ Exception -> 0x013f }
            com.google.android.exoplayer2.n.r.a()     // Catch:{ Exception -> 0x013f }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x013f }
            long r12 = r10 - r2
            r8 = r14
            r9 = r0
            r8.a((java.lang.String) r9, (long) r10, (long) r12)     // Catch:{ Exception -> 0x013f }
            android.media.MediaCodec r1 = r14.l     // Catch:{ Exception -> 0x013f }
            java.nio.ByteBuffer[] r1 = r1.getInputBuffers()     // Catch:{ Exception -> 0x013f }
            r14.y = r1     // Catch:{ Exception -> 0x013f }
            android.media.MediaCodec r1 = r14.l     // Catch:{ Exception -> 0x013f }
            java.nio.ByteBuffer[] r1 = r1.getOutputBuffers()     // Catch:{ Exception -> 0x013f }
            r14.z = r1     // Catch:{ Exception -> 0x013f }
            goto L_0x014a
        L_0x013f:
            r1 = move-exception
            com.google.android.exoplayer2.h.b$a r2 = new com.google.android.exoplayer2.h.b$a
            com.google.android.exoplayer2.j r3 = r14.k
            r2.<init>((com.google.android.exoplayer2.j) r3, (java.lang.Throwable) r1, (boolean) r4, (java.lang.String) r0)
            r14.a((com.google.android.exoplayer2.h.b.a) r2)
        L_0x014a:
            int r0 = r14.d()
            r1 = 2
            if (r0 != r1) goto L_0x0159
            long r0 = android.os.SystemClock.elapsedRealtime()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r2
            goto L_0x015e
        L_0x0159:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x015e:
            r14.A = r0
            r0 = -1
            r14.B = r0
            r14.C = r0
            r14.M = r6
            com.google.android.exoplayer2.d.d r0 = r14.f9908a
            int r1 = r0.f9272a
            int r1 = r1 + r6
            r0.f9272a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.b.z():void");
    }

    private void a(a aVar) throws ac {
        throw ac.a(aVar, r());
    }

    /* access modifiers changed from: protected */
    public boolean A() {
        return this.l == null && this.k != null;
    }

    /* access modifiers changed from: protected */
    public final MediaCodec B() {
        return this.l;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) throws ac {
        this.f9908a = new com.google.android.exoplayer2.d.d();
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z2) throws ac {
        this.J = false;
        this.K = false;
        if (this.l != null) {
            D();
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        this.k = null;
        try {
            C();
            try {
                if (this.m != null) {
                    this.f9910d.a(this.m);
                }
                try {
                    if (!(this.n == null || this.n == this.m)) {
                        this.f9910d.a(this.n);
                    }
                } finally {
                    this.m = null;
                    this.n = null;
                }
            } catch (Throwable th) {
                if (!(this.n == null || this.n == this.m)) {
                    this.f9910d.a(this.n);
                }
                throw th;
            } finally {
                this.m = null;
                this.n = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.n == null || this.n == this.m)) {
                    this.f9910d.a(this.n);
                }
                throw th2;
            } finally {
                this.m = null;
                this.n = null;
            }
        } finally {
        }
    }

    /* access modifiers changed from: protected */
    public void C() {
        if (this.l != null) {
            this.A = -9223372036854775807L;
            this.B = -1;
            this.C = -1;
            this.L = false;
            this.D = false;
            this.i.clear();
            this.y = null;
            this.z = null;
            this.E = false;
            this.H = false;
            this.o = false;
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
            this.f9908a.f9273b++;
            this.f9912f.f9280b = null;
            try {
                this.l.stop();
                try {
                    this.l.release();
                    this.l = null;
                    com.google.android.exoplayer2.c.b<e> bVar = this.m;
                    if (bVar != null && this.n != bVar) {
                        try {
                            this.f9910d.a(bVar);
                        } finally {
                            this.m = null;
                        }
                    }
                } catch (Throwable th) {
                    this.l = null;
                    com.google.android.exoplayer2.c.b<e> bVar2 = this.m;
                    if (!(bVar2 == null || this.n == bVar2)) {
                        this.f9910d.a(bVar2);
                    }
                    throw th;
                } finally {
                    this.m = null;
                }
            } catch (Throwable th2) {
                this.l = null;
                com.google.android.exoplayer2.c.b<e> bVar3 = this.m;
                if (!(bVar3 == null || this.n == bVar3)) {
                    try {
                        this.f9910d.a(bVar3);
                    } finally {
                        this.m = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    public void a(long j2, long j3) throws ac {
        if (this.K) {
            y();
            return;
        }
        if (this.k == null) {
            this.f9913g.a();
            int a2 = a(this.h, this.f9913g, true);
            if (a2 == -5) {
                a(this.h.f9107a);
            } else if (a2 == -4) {
                com.google.android.exoplayer2.n.a.b(this.f9913g.c());
                this.J = true;
                F();
                return;
            } else {
                return;
            }
        }
        z();
        if (this.l != null) {
            r.a("drainAndFeed");
            do {
            } while (b(j2, j3));
            do {
            } while (t());
            r.a();
        } else {
            b(j2);
            this.f9913g.a();
            int a3 = a(this.h, this.f9913g, false);
            if (a3 == -5) {
                a(this.h.f9107a);
            } else if (a3 == -4) {
                com.google.android.exoplayer2.n.a.b(this.f9913g.c());
                this.J = true;
                F();
            }
        }
        this.f9908a.a();
    }

    /* access modifiers changed from: protected */
    public void D() throws ac {
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
            this.l.flush();
            this.H = false;
        }
        if (this.E && this.k != null) {
            this.F = 1;
        }
    }

    private boolean t() throws ac {
        int i2;
        int i3;
        MediaCodec mediaCodec = this.l;
        if (mediaCodec == null || this.G == 2 || this.J) {
            return false;
        }
        if (this.B < 0) {
            this.B = mediaCodec.dequeueInputBuffer(0);
            int i4 = this.B;
            if (i4 < 0) {
                return false;
            }
            com.google.android.exoplayer2.d.e eVar = this.f9912f;
            eVar.f9280b = this.y[i4];
            eVar.a();
        }
        if (this.G == 1) {
            if (!this.s) {
                this.I = true;
                this.l.queueInputBuffer(this.B, 0, 0, 0, 4);
                this.B = -1;
            }
            this.G = 2;
            return false;
        } else if (this.w) {
            this.w = false;
            this.f9912f.f9280b.put(f9907b);
            this.l.queueInputBuffer(this.B, 0, f9907b.length, 0, 0);
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
                        this.f9912f.f9280b.put(this.k.h.get(i5));
                    }
                    this.F = 2;
                }
                i2 = this.f9912f.f9280b.position();
                i3 = a(this.h, this.f9912f, false);
            }
            if (i3 == -3) {
                return false;
            }
            if (i3 == -5) {
                if (this.F == 2) {
                    this.f9912f.a();
                    this.F = 1;
                }
                a(this.h.f9107a);
                return true;
            } else if (this.f9912f.c()) {
                if (this.F == 2) {
                    this.f9912f.a();
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
                        this.l.queueInputBuffer(this.B, 0, 0, 0, 4);
                        this.B = -1;
                    }
                    return false;
                } catch (MediaCodec.CryptoException e2) {
                    throw ac.a(e2, r());
                }
            } else if (!this.M || this.f9912f.d()) {
                this.M = false;
                boolean g2 = this.f9912f.g();
                this.L = b(g2);
                if (this.L) {
                    return false;
                }
                if (this.p && !g2) {
                    i.a(this.f9912f.f9280b);
                    if (this.f9912f.f9280b.position() == 0) {
                        return true;
                    }
                    this.p = false;
                }
                try {
                    long j2 = this.f9912f.f9281c;
                    if (this.f9912f.b()) {
                        this.i.add(Long.valueOf(j2));
                    }
                    this.f9912f.h();
                    a(this.f9912f);
                    if (g2) {
                        this.l.queueSecureInputBuffer(this.B, 0, a(this.f9912f, i2), j2, 0);
                    } else {
                        this.l.queueInputBuffer(this.B, 0, this.f9912f.f9280b.limit(), j2, 0);
                    }
                    this.B = -1;
                    this.H = true;
                    this.F = 0;
                    this.f9908a.f9274c++;
                    return true;
                } catch (MediaCodec.CryptoException e3) {
                    throw ac.a(e3, r());
                }
            } else {
                this.f9912f.a();
                if (this.F == 2) {
                    this.F = 1;
                }
                return true;
            }
        }
    }

    private static MediaCodec.CryptoInfo a(com.google.android.exoplayer2.d.e eVar, int i2) {
        MediaCodec.CryptoInfo a2 = eVar.f9279a.a();
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

    private boolean b(boolean z2) throws ac {
        com.google.android.exoplayer2.c.b<e> bVar = this.m;
        if (bVar == null) {
            return false;
        }
        int a2 = bVar.a();
        if (a2 == 0) {
            throw ac.a(this.m.c(), r());
        } else if (a2 == 4) {
            return false;
        } else {
            if (z2 || !this.f9911e) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void a(j jVar) throws ac {
        j jVar2 = this.k;
        this.k = jVar;
        boolean z2 = true;
        if (!t.a((Object) this.k.i, (Object) jVar2 == null ? null : jVar2.i)) {
            if (this.k.i != null) {
                c<e> cVar = this.f9910d;
                if (cVar != null) {
                    this.n = cVar.a(Looper.myLooper(), this.k.i);
                    com.google.android.exoplayer2.c.b<e> bVar = this.n;
                    if (bVar == this.m) {
                        this.f9910d.a(bVar);
                    }
                } else {
                    throw ac.a(new IllegalStateException("Media requires a DrmSessionManager"), r());
                }
            } else {
                this.n = null;
            }
        }
        if (this.n == this.m) {
            MediaCodec mediaCodec = this.l;
            if (mediaCodec != null && a(mediaCodec, this.o, jVar2, this.k)) {
                this.E = true;
                this.F = 1;
                if (!(this.r && this.k.j == jVar2.j && this.k.k == jVar2.k)) {
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

    public boolean v() {
        return this.k != null && !this.L && (s() || this.C >= 0 || (this.A != -9223372036854775807L && SystemClock.elapsedRealtime() < this.A));
    }

    private boolean b(long j2, long j3) throws ac {
        boolean z2;
        if (this.C < 0) {
            if (!this.u || !this.I) {
                this.C = this.l.dequeueOutputBuffer(this.j, E());
            } else {
                try {
                    this.C = this.l.dequeueOutputBuffer(this.j, E());
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
                    this.l.releaseOutputBuffer(i2, false);
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
            MediaCodec mediaCodec = this.l;
            ByteBuffer[] byteBufferArr = this.z;
            int i3 = this.C;
            z2 = a(j2, j3, mediaCodec, byteBufferArr[i3], i3, this.j.flags, this.j.presentationTimeUs, this.D);
        } else {
            try {
                z2 = a(j2, j3, this.l, this.z[this.C], this.C, this.j.flags, this.j.presentationTimeUs, this.D);
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

    private void w() throws ac {
        MediaFormat outputFormat = this.l.getOutputFormat();
        if (this.r && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.x = true;
            return;
        }
        if (this.v) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.l, outputFormat);
    }

    private void x() {
        this.z = this.l.getOutputBuffers();
    }

    private void F() throws ac {
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

    private static boolean a(String str) {
        return t.f10975a < 18 || (t.f10975a == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (t.f10975a == 19 && t.f10978d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean b(String str) {
        return t.f10975a < 24 && ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(t.f10976b) || "flounder_lte".equals(t.f10976b) || "grouper".equals(t.f10976b) || "tilapia".equals(t.f10976b));
    }

    private static boolean a(String str, j jVar) {
        return t.f10975a < 21 && jVar.h.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean c(String str) {
        return t.f10975a <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private static boolean d(String str) {
        return (t.f10975a <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (t.f10975a <= 19 && "hb2000".equals(t.f10976b) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean e(String str) {
        return t.f10975a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean b(String str, j jVar) {
        if (t.f10975a > 18 || jVar.r != 1 || !"OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return false;
        }
        return true;
    }

    private static boolean f(String str) {
        return t.f10975a <= 19 && t.f10978d.equals("ODROID-XU3") && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str));
    }
}
