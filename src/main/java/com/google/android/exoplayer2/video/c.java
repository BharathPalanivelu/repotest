package com.google.android.exoplayer2.video;

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
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.o.d;
import com.google.android.exoplayer2.s.i;
import com.google.android.exoplayer2.s.t;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.video.e;
import com.tencent.imsdk.BaseConstants;
import com.tencent.liteav.audio.TXEAudioDef;
import java.nio.ByteBuffer;

@TargetApi(16)
public class c extends com.google.android.exoplayer2.o.b {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f12240c = {1920, 1600, 1440, 1280, TXEAudioDef.TXE_OPUS_SAMPLE_NUM, 854, 640, 540, 480};
    private int A;
    private int B;
    private int C;
    private float D;
    private boolean E;
    private int F;
    private long G = -9223372036854775807L;
    private int H;

    /* renamed from: b  reason: collision with root package name */
    b f12241b;

    /* renamed from: d  reason: collision with root package name */
    private final Context f12242d;

    /* renamed from: e  reason: collision with root package name */
    private final d f12243e;

    /* renamed from: f  reason: collision with root package name */
    private final e.a f12244f;

    /* renamed from: g  reason: collision with root package name */
    private final long f12245g;
    private final int h;
    private final boolean i = K();
    private final long[] j = new long[10];
    private Format[] k;
    private a l;
    private Surface m;
    private Surface n;
    private int o = 1;
    private boolean p;
    private long q = -9223372036854775807L;
    private long r;
    private int s;
    private int t;
    private int u;
    private float v = -1.0f;
    private int w = -1;
    private int x = -1;
    private int y;
    private float z = -1.0f;

    private static boolean d(long j2) {
        return j2 < -30000;
    }

    public c(Context context, com.google.android.exoplayer2.o.c cVar, long j2, com.google.android.exoplayer2.drm.b<d> bVar, boolean z2, Handler handler, e eVar, int i2) {
        super(2, cVar, bVar, z2);
        this.f12245g = j2;
        this.h = i2;
        this.f12242d = context.getApplicationContext();
        this.f12243e = new d(context);
        this.f12244f = new e.a(handler, eVar);
        G();
    }

    /* access modifiers changed from: protected */
    public int a(com.google.android.exoplayer2.o.c cVar, Format format) throws d.b {
        boolean z2;
        String str = format.f8958f;
        int i2 = 0;
        if (!i.b(str)) {
            return 0;
        }
        DrmInitData drmInitData = format.i;
        if (drmInitData != null) {
            z2 = false;
            for (int i3 = 0; i3 < drmInitData.f9293a; i3++) {
                z2 |= drmInitData.a(i3).f9299d;
            }
        } else {
            z2 = false;
        }
        com.google.android.exoplayer2.o.a a2 = cVar.a(str, z2);
        if (a2 == null) {
            return 1;
        }
        boolean b2 = a2.b(format.f8955c);
        if (b2 && format.j > 0 && format.k > 0) {
            if (v.f11449a >= 21) {
                b2 = a2.a(format.j, format.k, (double) format.l);
            } else {
                b2 = format.j * format.k <= com.google.android.exoplayer2.o.d.b();
                if (!b2) {
                    Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.j + "x" + format.k + "] [" + v.f11453e + "]");
                }
            }
        }
        int i4 = a2.f10995b ? 16 : 8;
        if (a2.f10996c) {
            i2 = 32;
        }
        return (b2 ? 4 : 3) | i4 | i2;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) throws com.google.android.exoplayer2.e {
        super.a(z2);
        this.F = q().f12192b;
        this.E = this.F != 0;
        this.f12244f.a(this.f11001a);
        this.f12243e.a();
    }

    /* access modifiers changed from: protected */
    public void a(Format[] formatArr, long j2) throws com.google.android.exoplayer2.e {
        this.k = formatArr;
        if (this.G == -9223372036854775807L) {
            this.G = j2;
        } else {
            int i2 = this.H;
            if (i2 == this.j.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.j[this.H - 1]);
            } else {
                this.H = i2 + 1;
            }
            this.j[this.H - 1] = j2;
        }
        super.a(formatArr, j2);
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z2) throws com.google.android.exoplayer2.e {
        super.a(j2, z2);
        x();
        this.t = 0;
        int i2 = this.H;
        if (i2 != 0) {
            this.G = this.j[i2 - 1];
            this.H = 0;
        }
        if (z2) {
            w();
        } else {
            this.q = -9223372036854775807L;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r9.E != false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r9.m == r0) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean t() {
        /*
            r9 = this;
            boolean r0 = super.t()
            r1 = 1
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x0025
            boolean r0 = r9.p
            if (r0 != 0) goto L_0x0022
            android.view.Surface r0 = r9.n
            if (r0 == 0) goto L_0x0018
            android.view.Surface r4 = r9.m
            if (r4 == r0) goto L_0x0022
        L_0x0018:
            android.media.MediaCodec r0 = r9.A()
            if (r0 == 0) goto L_0x0022
            boolean r0 = r9.E
            if (r0 == 0) goto L_0x0025
        L_0x0022:
            r9.q = r2
            return r1
        L_0x0025:
            long r4 = r9.q
            r0 = 0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x002d
            return r0
        L_0x002d:
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r9.q
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0038
            return r1
        L_0x0038:
            r9.q = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.c.t():boolean");
    }

    /* access modifiers changed from: protected */
    public void n() {
        super.n();
        this.s = 0;
        this.r = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: protected */
    public void o() {
        this.q = -9223372036854775807L;
        J();
        super.o();
    }

    /* access modifiers changed from: protected */
    public void p() {
        this.w = -1;
        this.x = -1;
        this.z = -1.0f;
        this.v = -1.0f;
        this.G = -9223372036854775807L;
        this.H = 0;
        G();
        x();
        this.f12243e.b();
        this.f12241b = null;
        this.E = false;
        try {
            super.p();
        } finally {
            this.f11001a.a();
            this.f12244f.b(this.f11001a);
        }
    }

    public void a(int i2, Object obj) throws com.google.android.exoplayer2.e {
        if (i2 == 1) {
            a((Surface) obj);
        } else if (i2 == 4) {
            this.o = ((Integer) obj).intValue();
            MediaCodec A2 = A();
            if (A2 != null) {
                a(A2, this.o);
            }
        } else {
            super.a(i2, obj);
        }
    }

    private void a(Surface surface) throws com.google.android.exoplayer2.e {
        if (surface == null) {
            Surface surface2 = this.n;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.google.android.exoplayer2.o.a B2 = B();
                if (B2 != null && b(B2.f10997d)) {
                    this.n = DummySurface.a(this.f12242d, B2.f10997d);
                    surface = this.n;
                }
            }
        }
        if (this.m != surface) {
            this.m = surface;
            int d2 = d();
            if (d2 == 1 || d2 == 2) {
                MediaCodec A2 = A();
                if (v.f11449a < 23 || A2 == null || surface == null) {
                    C();
                    z();
                } else {
                    a(A2, surface);
                }
            }
            if (surface == null || surface == this.n) {
                G();
                x();
                return;
            }
            I();
            x();
            if (d2 == 2) {
                w();
            }
        } else if (surface != null && surface != this.n) {
            I();
            F();
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(com.google.android.exoplayer2.o.a aVar) {
        return this.m != null || b(aVar.f10997d);
    }

    /* access modifiers changed from: protected */
    public void a(com.google.android.exoplayer2.o.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws d.b {
        this.l = a(aVar, format, this.k);
        MediaFormat a2 = a(format, this.l, this.i, this.F);
        if (this.m == null) {
            com.google.android.exoplayer2.s.a.b(b(aVar.f10997d));
            if (this.n == null) {
                this.n = DummySurface.a(this.f12242d, aVar.f10997d);
            }
            this.m = this.n;
        }
        mediaCodec.configure(a2, this.m, mediaCrypto, 0);
        if (v.f11449a >= 23 && this.E) {
            this.f12241b = new b(mediaCodec);
        }
    }

    /* access modifiers changed from: protected */
    public void C() {
        try {
            super.C();
        } finally {
            Surface surface = this.n;
            if (surface != null) {
                if (this.m == surface) {
                    this.m = null;
                }
                this.n.release();
                this.n = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str, long j2, long j3) {
        this.f12244f.a(str, j2, j3);
    }

    /* access modifiers changed from: protected */
    public void b(Format format) throws com.google.android.exoplayer2.e {
        super.b(format);
        this.f12244f.a(format);
        this.v = d(format);
        this.u = e(format);
    }

    /* access modifiers changed from: protected */
    public void a(com.google.android.exoplayer2.g.e eVar) {
        if (v.f11449a < 23 && this.E) {
            v();
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
        this.w = i2;
        if (z2) {
            i3 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i3 = mediaFormat.getInteger("height");
        }
        this.x = i3;
        this.z = this.v;
        if (v.f11449a >= 21) {
            int i4 = this.u;
            if (i4 == 90 || i4 == 270) {
                int i5 = this.w;
                this.w = this.x;
                this.x = i5;
                this.z = 1.0f / this.z;
            }
        } else {
            this.y = this.u;
        }
        a(mediaCodec, this.o);
    }

    /* access modifiers changed from: protected */
    public boolean a(MediaCodec mediaCodec, boolean z2, Format format, Format format2) {
        return a(z2, format, format2) && format2.j <= this.l.f12246a && format2.k <= this.l.f12247b && c(format2) <= this.l.f12248c;
    }

    /* access modifiers changed from: protected */
    public boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z2) {
        long j5 = j3;
        MediaCodec mediaCodec2 = mediaCodec;
        int i4 = i2;
        long j6 = j4;
        while (true) {
            int i5 = this.H;
            if (i5 == 0) {
                break;
            }
            long[] jArr = this.j;
            if (j6 < jArr[0]) {
                break;
            }
            this.G = jArr[0];
            this.H = i5 - 1;
            System.arraycopy(jArr, 1, jArr, 0, this.H);
        }
        long j7 = j6 - this.G;
        if (z2) {
            a(mediaCodec2, i4, j7);
            return true;
        }
        long j8 = j6 - j2;
        if (this.m == this.n) {
            if (!d(j8)) {
                return false;
            }
            a(mediaCodec2, i4, j7);
            return true;
        } else if (!this.p) {
            if (v.f11449a >= 21) {
                a(mediaCodec, i2, j7, System.nanoTime());
            } else {
                c(mediaCodec2, i4, j7);
            }
            return true;
        } else if (d() != 2) {
            return false;
        } else {
            long elapsedRealtime = j8 - ((SystemClock.elapsedRealtime() * 1000) - j5);
            long nanoTime = System.nanoTime();
            long a2 = this.f12243e.a(j6, (elapsedRealtime * 1000) + nanoTime);
            long j9 = (a2 - nanoTime) / 1000;
            if (b(j9, j5)) {
                b(mediaCodec2, i4, j7);
                return true;
            }
            if (v.f11449a >= 21) {
                if (j9 < 50000) {
                    a(mediaCodec, i2, j7, a2);
                    return true;
                }
            } else if (j9 < BaseConstants.DEFAULT_MSG_TIMEOUT) {
                if (j9 > 11000) {
                    try {
                        Thread.sleep((j9 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                c(mediaCodec2, i4, j7);
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean b(long j2, long j3) {
        return d(j2);
    }

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, int i2, long j2) {
        t.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        t.a();
        this.f11001a.f9877e++;
    }

    /* access modifiers changed from: protected */
    public void b(MediaCodec mediaCodec, int i2, long j2) {
        t.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        t.a();
        this.f11001a.f9878f++;
        this.s++;
        this.t++;
        this.f11001a.f9879g = Math.max(this.t, this.f11001a.f9879g);
        if (this.s == this.h) {
            J();
        }
    }

    /* access modifiers changed from: protected */
    public void c(MediaCodec mediaCodec, int i2, long j2) {
        H();
        t.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, true);
        t.a();
        this.f11001a.f9876d++;
        this.t = 0;
        v();
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void a(MediaCodec mediaCodec, int i2, long j2, long j3) {
        H();
        t.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, j3);
        t.a();
        this.f11001a.f9876d++;
        this.t = 0;
        v();
    }

    private boolean b(boolean z2) {
        return v.f11449a >= 23 && !this.E && (!z2 || DummySurface.a(this.f12242d));
    }

    private void w() {
        this.q = this.f12245g > 0 ? SystemClock.elapsedRealtime() + this.f12245g : -9223372036854775807L;
    }

    private void x() {
        this.p = false;
        if (v.f11449a >= 23 && this.E) {
            MediaCodec A2 = A();
            if (A2 != null) {
                this.f12241b = new b(A2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v() {
        if (!this.p) {
            this.p = true;
            this.f12244f.a(this.m);
        }
    }

    private void F() {
        if (this.p) {
            this.f12244f.a(this.m);
        }
    }

    private void G() {
        this.A = -1;
        this.B = -1;
        this.D = -1.0f;
        this.C = -1;
    }

    private void H() {
        if (this.w != -1 || this.x != -1) {
            if (this.A != this.w || this.B != this.x || this.C != this.y || this.D != this.z) {
                this.f12244f.a(this.w, this.x, this.y, this.z);
                this.A = this.w;
                this.B = this.x;
                this.C = this.y;
                this.D = this.z;
            }
        }
    }

    private void I() {
        if (this.A != -1 || this.B != -1) {
            this.f12244f.a(this.A, this.B, this.C, this.D);
        }
    }

    private void J() {
        if (this.s > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f12244f.a(this.s, elapsedRealtime - this.r);
            this.s = 0;
            this.r = elapsedRealtime;
        }
    }

    @SuppressLint({"InlinedApi"})
    private static MediaFormat a(Format format, a aVar, boolean z2, int i2) {
        MediaFormat b2 = format.b();
        b2.setInteger("max-width", aVar.f12246a);
        b2.setInteger("max-height", aVar.f12247b);
        if (aVar.f12248c != -1) {
            b2.setInteger("max-input-size", aVar.f12248c);
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

    /* access modifiers changed from: protected */
    public a a(com.google.android.exoplayer2.o.a aVar, Format format, Format[] formatArr) throws d.b {
        int i2 = format.j;
        int i3 = format.k;
        int c2 = c(format);
        if (formatArr.length == 1) {
            return new a(i2, i3, c2);
        }
        int i4 = i3;
        int i5 = c2;
        boolean z2 = false;
        int i6 = i2;
        for (Format format2 : formatArr) {
            if (a(aVar.f10995b, format, format2)) {
                z2 |= format2.j == -1 || format2.k == -1;
                i6 = Math.max(i6, format2.j);
                i4 = Math.max(i4, format2.k);
                i5 = Math.max(i5, c(format2));
            }
        }
        if (z2) {
            Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i6 + "x" + i4);
            Point a2 = a(aVar, format);
            if (a2 != null) {
                i6 = Math.max(i6, a2.x);
                i4 = Math.max(i4, a2.y);
                i5 = Math.max(i5, a(format.f8958f, i6, i4));
                Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i6 + "x" + i4);
            }
        }
        return new a(i6, i4, i5);
    }

    private static Point a(com.google.android.exoplayer2.o.a aVar, Format format) throws d.b {
        boolean z2 = format.k > format.j;
        int i2 = z2 ? format.k : format.j;
        int i3 = z2 ? format.j : format.k;
        float f2 = ((float) i3) / ((float) i2);
        for (int i4 : f12240c) {
            int i5 = (int) (((float) i4) * f2);
            if (i4 <= i2 || i5 <= i3) {
                break;
            }
            if (v.f11449a >= 21) {
                int i6 = z2 ? i5 : i4;
                if (!z2) {
                    i4 = i5;
                }
                Point a2 = aVar.a(i6, i4);
                if (aVar.a(a2.x, a2.y, (double) format.l)) {
                    return a2;
                }
            } else {
                int a3 = v.a(i4, 16) * 16;
                int a4 = v.a(i5, 16) * 16;
                if (a3 * a4 <= com.google.android.exoplayer2.o.d.b()) {
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

    private static int c(Format format) {
        if (format.f8959g == -1) {
            return a(format.f8958f, format.j, format.k);
        }
        int size = format.h.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += format.h.get(i3).length;
        }
        return format.f8959g + i2;
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
            java.lang.String r7 = com.google.android.exoplayer2.s.v.f11452d
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x006c
            return r0
        L_0x006c:
            r7 = 16
            int r8 = com.google.android.exoplayer2.s.v.a((int) r8, (int) r7)
            int r9 = com.google.android.exoplayer2.s.v.a((int) r9, (int) r7)
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.c.a(java.lang.String, int, int):int");
    }

    private static void a(MediaCodec mediaCodec, int i2) {
        mediaCodec.setVideoScalingMode(i2);
    }

    private static boolean K() {
        return v.f11449a <= 22 && "foster".equals(v.f11450b) && "NVIDIA".equals(v.f11451c);
    }

    private static boolean a(boolean z2, Format format, Format format2) {
        return format.f8958f.equals(format2.f8958f) && e(format) == e(format2) && (z2 || (format.j == format2.j && format.k == format2.k));
    }

    private static float d(Format format) {
        if (format.n == -1.0f) {
            return 1.0f;
        }
        return format.n;
    }

    private static int e(Format format) {
        if (format.m == -1) {
            return 0;
        }
        return format.m;
    }

    protected static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f12246a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12247b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12248c;

        public a(int i, int i2, int i3) {
            this.f12246a = i;
            this.f12247b = i2;
            this.f12248c = i3;
        }
    }

    @TargetApi(23)
    private final class b implements MediaCodec.OnFrameRenderedListener {
        private b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (this == c.this.f12241b) {
                c.this.v();
            }
        }
    }
}
