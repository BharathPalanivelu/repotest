package com.google.android.exoplayer2.k;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.ac;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.h.c;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.k.f;
import com.google.android.exoplayer2.n.h;
import com.google.android.exoplayer2.n.r;
import com.google.android.exoplayer2.n.t;
import com.tencent.imsdk.BaseConstants;
import com.tencent.liteav.audio.TXEAudioDef;
import java.nio.ByteBuffer;

@TargetApi(16)
public class d extends com.google.android.exoplayer2.h.b {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f10645c = {1920, 1600, 1440, 1280, TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 854, 640, 540, 480};
    private float A;
    private boolean B;
    private int C;

    /* renamed from: b  reason: collision with root package name */
    b f10646b;

    /* renamed from: d  reason: collision with root package name */
    private final e f10647d;

    /* renamed from: e  reason: collision with root package name */
    private final f.a f10648e;

    /* renamed from: f  reason: collision with root package name */
    private final long f10649f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10650g;
    private final boolean h = K();
    private j[] i;
    private a j;
    private Surface k;
    private int l = 1;
    private boolean m;
    private long n = -9223372036854775807L;
    private long o;
    private int p;
    private int q;
    private int r;
    private float s = -1.0f;
    private int t = -1;
    private int u = -1;
    private int v;
    private float w = -1.0f;
    private int x;
    private int y;
    private int z;

    /* access modifiers changed from: protected */
    public boolean b(long j2, long j3) {
        return j2 < -30000;
    }

    public d(Context context, c cVar, long j2, com.google.android.exoplayer2.c.c<e> cVar2, boolean z2, Handler handler, f fVar, int i2) {
        super(2, cVar, cVar2, z2);
        this.f10649f = j2;
        this.f10650g = i2;
        this.f10647d = new e(context);
        this.f10648e = new f.a(handler, fVar);
        G();
    }

    /* access modifiers changed from: protected */
    public int a(c cVar, j jVar) throws d.b {
        boolean z2;
        String str = jVar.f10427f;
        int i2 = 0;
        if (!h.b(str)) {
            return 0;
        }
        com.google.android.exoplayer2.c.a aVar = jVar.i;
        if (aVar != null) {
            z2 = false;
            for (int i3 = 0; i3 < aVar.f9249a; i3++) {
                z2 |= aVar.a(i3).f9254c;
            }
        } else {
            z2 = false;
        }
        com.google.android.exoplayer2.h.a a2 = cVar.a(str, z2);
        if (a2 == null) {
            return 1;
        }
        boolean b2 = a2.b(jVar.f10424c);
        if (b2 && jVar.j > 0 && jVar.k > 0) {
            if (t.f10975a >= 21) {
                b2 = a2.a(jVar.j, jVar.k, (double) jVar.l);
            } else {
                b2 = jVar.j * jVar.k <= com.google.android.exoplayer2.h.d.b();
                if (!b2) {
                    Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + jVar.j + "x" + jVar.k + "] [" + t.f10979e + "]");
                }
            }
        }
        int i4 = a2.f9903b ? 8 : 4;
        if (a2.f9904c) {
            i2 = 16;
        }
        return (b2 ? 3 : 2) | i4 | i2;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) throws ac {
        super.a(z2);
        this.C = q().f9113b;
        this.B = this.C != 0;
        this.f10648e.a(this.f9908a);
        this.f10647d.a();
    }

    /* access modifiers changed from: protected */
    public void a(j[] jVarArr) throws ac {
        this.i = jVarArr;
        super.a(jVarArr);
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z2) throws ac {
        super.a(j2, z2);
        x();
        this.q = 0;
        if (z2) {
            w();
        } else {
            this.n = -9223372036854775807L;
        }
    }

    public boolean v() {
        if ((this.m || super.A()) && super.v()) {
            this.n = -9223372036854775807L;
            return true;
        } else if (this.n == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.n) {
                return true;
            }
            this.n = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
        super.n();
        this.p = 0;
        this.o = SystemClock.elapsedRealtime();
        this.n = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public void o() {
        J();
        super.o();
    }

    /* access modifiers changed from: protected */
    public void p() {
        this.t = -1;
        this.u = -1;
        this.w = -1.0f;
        this.s = -1.0f;
        G();
        x();
        this.f10647d.b();
        this.f10646b = null;
        try {
            super.p();
        } finally {
            this.f9908a.a();
            this.f10648e.b(this.f9908a);
        }
    }

    public void a(int i2, Object obj) throws ac {
        if (i2 == 1) {
            a((Surface) obj);
        } else if (i2 == 4) {
            this.l = ((Integer) obj).intValue();
            MediaCodec B2 = B();
            if (B2 != null) {
                d(B2, this.l);
            }
        } else {
            super.a(i2, obj);
        }
    }

    private void a(Surface surface) throws ac {
        if (this.k != surface) {
            this.k = surface;
            int d2 = d();
            if (d2 == 1 || d2 == 2) {
                MediaCodec B2 = B();
                if (t.f10975a < 23 || B2 == null || surface == null) {
                    C();
                    z();
                } else {
                    a(B2, surface);
                }
            }
            if (surface != null) {
                I();
                x();
                if (d2 == 2) {
                    w();
                    return;
                }
                return;
            }
            G();
            x();
        } else if (surface != null) {
            I();
            F();
        }
    }

    /* access modifiers changed from: protected */
    public boolean A() {
        if (super.A()) {
            Surface surface = this.k;
            return surface != null && surface.isValid();
        }
    }

    /* access modifiers changed from: protected */
    public void a(com.google.android.exoplayer2.h.a aVar, MediaCodec mediaCodec, j jVar, MediaCrypto mediaCrypto) throws d.b {
        this.j = a(aVar, jVar, this.i);
        mediaCodec.configure(a(jVar, this.j, this.h, this.C), this.k, mediaCrypto, 0);
        if (t.f10975a >= 23 && this.B) {
            this.f10646b = new b(mediaCodec);
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str, long j2, long j3) {
        this.f10648e.a(str, j2, j3);
    }

    /* access modifiers changed from: protected */
    public void a(j jVar) throws ac {
        super.a(jVar);
        this.f10648e.a(jVar);
        this.s = d(jVar);
        this.r = e(jVar);
    }

    /* access modifiers changed from: protected */
    public void a(com.google.android.exoplayer2.d.e eVar) {
        if (t.f10975a < 23 && this.B) {
            t();
        }
    }

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i2;
        int i3;
        boolean z2 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z2) {
            i2 = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i2 = mediaFormat.getInteger("width");
        }
        this.t = i2;
        if (z2) {
            i3 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i3 = mediaFormat.getInteger("height");
        }
        this.u = i3;
        this.w = this.s;
        if (t.f10975a >= 21) {
            int i4 = this.r;
            if (i4 == 90 || i4 == 270) {
                int i5 = this.t;
                this.t = this.u;
                this.u = i5;
                this.w = 1.0f / this.w;
            }
        } else {
            this.v = this.r;
        }
        d(mediaCodec, this.l);
    }

    /* access modifiers changed from: protected */
    public boolean a(MediaCodec mediaCodec, boolean z2, j jVar, j jVar2) {
        return a(z2, jVar, jVar2) && jVar2.j <= this.j.f10651a && jVar2.k <= this.j.f10652b && jVar2.f10428g <= this.j.f10653c;
    }

    /* access modifiers changed from: protected */
    public boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z2) {
        long j5 = j3;
        MediaCodec mediaCodec2 = mediaCodec;
        int i4 = i2;
        long j6 = j4;
        if (z2) {
            a(mediaCodec2, i4);
            return true;
        } else if (!this.m) {
            if (t.f10975a >= 21) {
                a(mediaCodec2, i4, System.nanoTime());
            } else {
                c(mediaCodec2, i4);
            }
            return true;
        } else if (d() != 2) {
            return false;
        } else {
            long elapsedRealtime = (j6 - j2) - ((SystemClock.elapsedRealtime() * 1000) - j5);
            long nanoTime = System.nanoTime();
            long a2 = this.f10647d.a(j6, nanoTime + (elapsedRealtime * 1000));
            long j7 = (a2 - nanoTime) / 1000;
            if (b(j7, j5)) {
                b(mediaCodec2, i4);
                return true;
            }
            if (t.f10975a >= 21) {
                if (j7 < 50000) {
                    a(mediaCodec2, i4, a2);
                    return true;
                }
            } else if (j7 < BaseConstants.DEFAULT_MSG_TIMEOUT) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep((j7 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                c(mediaCodec2, i4);
                return true;
            }
            return false;
        }
    }

    private void a(MediaCodec mediaCodec, int i2) {
        r.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        r.a();
        this.f9908a.f9276e++;
    }

    private void b(MediaCodec mediaCodec, int i2) {
        r.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        r.a();
        this.f9908a.f9277f++;
        this.p++;
        this.q++;
        this.f9908a.f9278g = Math.max(this.q, this.f9908a.f9278g);
        if (this.p == this.f10650g) {
            J();
        }
    }

    private void c(MediaCodec mediaCodec, int i2) {
        H();
        r.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, true);
        r.a();
        this.f9908a.f9275d++;
        this.q = 0;
        t();
    }

    @TargetApi(21)
    private void a(MediaCodec mediaCodec, int i2, long j2) {
        H();
        r.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, j2);
        r.a();
        this.f9908a.f9275d++;
        this.q = 0;
        t();
    }

    private void w() {
        this.n = this.f10649f > 0 ? SystemClock.elapsedRealtime() + this.f10649f : -9223372036854775807L;
    }

    private void x() {
        this.m = false;
        if (t.f10975a >= 23 && this.B) {
            MediaCodec B2 = B();
            if (B2 != null) {
                this.f10646b = new b(B2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        if (!this.m) {
            this.m = true;
            this.f10648e.a(this.k);
        }
    }

    private void F() {
        if (this.m) {
            this.f10648e.a(this.k);
        }
    }

    private void G() {
        this.x = -1;
        this.y = -1;
        this.A = -1.0f;
        this.z = -1;
    }

    private void H() {
        if (this.x != this.t || this.y != this.u || this.z != this.v || this.A != this.w) {
            this.f10648e.a(this.t, this.u, this.v, this.w);
            this.x = this.t;
            this.y = this.u;
            this.z = this.v;
            this.A = this.w;
        }
    }

    private void I() {
        if (this.x != -1 || this.y != -1) {
            this.f10648e.a(this.t, this.u, this.v, this.w);
        }
    }

    private void J() {
        if (this.p > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f10648e.a(this.p, elapsedRealtime - this.o);
            this.p = 0;
            this.o = elapsedRealtime;
        }
    }

    @SuppressLint({"InlinedApi"})
    private static MediaFormat a(j jVar, a aVar, boolean z2, int i2) {
        MediaFormat b2 = jVar.b();
        b2.setInteger("max-width", aVar.f10651a);
        b2.setInteger("max-height", aVar.f10652b);
        if (aVar.f10653c != -1) {
            b2.setInteger("max-input-size", aVar.f10653c);
        }
        if (z2) {
            b2.setInteger("auto-frc", 0);
        }
        if (i2 != 0) {
            a(b2, i2);
        }
        return b2;
    }

    @TargetApi(23)
    private static void a(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    @TargetApi(21)
    private static void a(MediaFormat mediaFormat, int i2) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i2);
    }

    private static a a(com.google.android.exoplayer2.h.a aVar, j jVar, j[] jVarArr) throws d.b {
        int i2 = jVar.j;
        int i3 = jVar.k;
        int c2 = c(jVar);
        if (jVarArr.length == 1) {
            return new a(i2, i3, c2);
        }
        int i4 = i3;
        int i5 = c2;
        boolean z2 = false;
        int i6 = i2;
        for (j jVar2 : jVarArr) {
            if (a(aVar.f9903b, jVar, jVar2)) {
                z2 |= jVar2.j == -1 || jVar2.k == -1;
                i6 = Math.max(i6, jVar2.j);
                i4 = Math.max(i4, jVar2.k);
                i5 = Math.max(i5, c(jVar2));
            }
        }
        if (z2) {
            Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i6 + "x" + i4);
            Point a2 = a(aVar, jVar);
            if (a2 != null) {
                i6 = Math.max(i6, a2.x);
                i4 = Math.max(i4, a2.y);
                i5 = Math.max(i5, a(jVar.f10427f, i6, i4));
                Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i6 + "x" + i4);
            }
        }
        return new a(i6, i4, i5);
    }

    private static Point a(com.google.android.exoplayer2.h.a aVar, j jVar) throws d.b {
        boolean z2 = jVar.k > jVar.j;
        int i2 = z2 ? jVar.k : jVar.j;
        int i3 = z2 ? jVar.j : jVar.k;
        float f2 = ((float) i3) / ((float) i2);
        for (int i4 : f10645c) {
            int i5 = (int) (((float) i4) * f2);
            if (i4 <= i2 || i5 <= i3) {
                break;
            }
            if (t.f10975a >= 21) {
                int i6 = z2 ? i5 : i4;
                if (!z2) {
                    i4 = i5;
                }
                Point a2 = aVar.a(i6, i4);
                if (aVar.a(a2.x, a2.y, (double) jVar.l)) {
                    return a2;
                }
            } else {
                int a3 = t.a(i4, 16) * 16;
                int a4 = t.a(i5, 16) * 16;
                if (a3 * a4 <= com.google.android.exoplayer2.h.d.b()) {
                    int i7 = z2 ? a4 : a3;
                    if (z2) {
                        a4 = a3;
                    }
                    return new Point(i7, a4);
                }
            }
        }
        return null;
    }

    private static int c(j jVar) {
        if (jVar.f10428g != -1) {
            return jVar.f10428g;
        }
        return a(jVar.f10427f, jVar.j, jVar.k);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.String r7, int r8, int r9) {
        /*
            r0 = -1
            if (r8 == r0) goto L_0x0086
            if (r9 != r0) goto L_0x0007
            goto L_0x0086
        L_0x0007:
            int r1 = r7.hashCode()
            r2 = 5
            r3 = 1
            r4 = 4
            r5 = 3
            r6 = 2
            switch(r1) {
                case -1664118616: goto L_0x0046;
                case -1662541442: goto L_0x003c;
                case 1187890754: goto L_0x0032;
                case 1331836730: goto L_0x0028;
                case 1599127256: goto L_0x001e;
                case 1599127257: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0050
        L_0x0014:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 5
            goto L_0x0051
        L_0x001e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 3
            goto L_0x0051
        L_0x0028:
            java.lang.String r1 = "video/avc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 2
            goto L_0x0051
        L_0x0032:
            java.lang.String r1 = "video/mp4v-es"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 1
            goto L_0x0051
        L_0x003c:
            java.lang.String r1 = "video/hevc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 4
            goto L_0x0051
        L_0x0046:
            java.lang.String r1 = "video/3gpp"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 0
            goto L_0x0051
        L_0x0050:
            r7 = -1
        L_0x0051:
            if (r7 == 0) goto L_0x007d
            if (r7 == r3) goto L_0x007d
            if (r7 == r6) goto L_0x0061
            if (r7 == r5) goto L_0x007d
            if (r7 == r4) goto L_0x005e
            if (r7 == r2) goto L_0x005e
            return r0
        L_0x005e:
            int r8 = r8 * r9
            goto L_0x0080
        L_0x0061:
            java.lang.String r7 = com.google.android.exoplayer2.n.t.f10978d
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x006c
            return r0
        L_0x006c:
            r7 = 16
            int r8 = com.google.android.exoplayer2.n.t.a((int) r8, (int) r7)
            int r9 = com.google.android.exoplayer2.n.t.a((int) r9, (int) r7)
            int r8 = r8 * r9
            int r8 = r8 * 16
            int r8 = r8 * 16
            goto L_0x007f
        L_0x007d:
            int r8 = r8 * r9
        L_0x007f:
            r4 = 2
        L_0x0080:
            int r8 = r8 * 3
            int r4 = r4 * 2
            int r8 = r8 / r4
            return r8
        L_0x0086:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.k.d.a(java.lang.String, int, int):int");
    }

    private static void d(MediaCodec mediaCodec, int i2) {
        mediaCodec.setVideoScalingMode(i2);
    }

    private static boolean K() {
        return t.f10975a <= 22 && "foster".equals(t.f10976b) && "NVIDIA".equals(t.f10977c);
    }

    private static boolean a(boolean z2, j jVar, j jVar2) {
        return jVar.f10427f.equals(jVar2.f10427f) && e(jVar) == e(jVar2) && (z2 || (jVar.j == jVar2.j && jVar.k == jVar2.k));
    }

    private static float d(j jVar) {
        if (jVar.n == -1.0f) {
            return 1.0f;
        }
        return jVar.n;
    }

    private static int e(j jVar) {
        if (jVar.m == -1) {
            return 0;
        }
        return jVar.m;
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10651a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10652b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10653c;

        public a(int i, int i2, int i3) {
            this.f10651a = i;
            this.f10652b = i2;
            this.f10653c = i3;
        }
    }

    @TargetApi(23)
    private final class b implements MediaCodec.OnFrameRenderedListener {
        private b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (this == d.this.f10646b) {
                d.this.t();
            }
        }
    }
}
