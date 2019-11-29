package com.modiface.mfemakeupkit.video;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.Message;
import com.modiface.mfemakeupkit.aa;
import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import com.modiface.mfemakeupkit.utils.x;
import com.modiface.mfemakeupkit.video.MFEVideoRecordingError;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.b.b;

public class j implements x.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f15429a = 51;

    /* renamed from: b  reason: collision with root package name */
    private static final int f15430b = 52;

    /* renamed from: c  reason: collision with root package name */
    private static final l f15431c = new l();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final x f15432d = new x("MFEMakeupRecord");

    /* renamed from: e  reason: collision with root package name */
    private final aa f15433e = new e(this, true);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final n f15434f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final a f15435g;
    private final b h;
    /* access modifiers changed from: private */
    public final k i;
    /* access modifiers changed from: private */
    public AtomicBoolean j = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public long k = System.nanoTime();
    /* access modifiers changed from: private */
    public Long l = null;
    public final File m;
    public m n = new m();
    /* access modifiers changed from: private */
    public final boolean o;
    /* access modifiers changed from: private */
    public final List<MFEVideoRecordingError> p = Collections.synchronizedList(new ArrayList());

    public j(File file, boolean z) {
        if (file == null || !file.exists() || b.c(file.getAbsolutePath()).equalsIgnoreCase(".mp4")) {
            throw new IllegalArgumentException("invalid video file path");
        }
        this.m = file;
        this.f15434f = new n(f15431c);
        this.f15435g = new a(f15431c);
        this.i = new k(f15431c);
        this.h = new b(f15431c);
        this.o = z;
        this.f15432d.a((x.a) this);
        this.f15432d.a((Runnable) new f(this));
        this.f15432d.b().sendEmptyMessage(51);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0078, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r4 = r9.p;
        r7 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r7.append("failed to configure width, height: ");
        r7.append(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r7.append("x");
        r7.append(r10);
        r4.add(new com.modiface.mfemakeupkit.video.MFEVideoRecordingError(new java.lang.Throwable(r7.toString(), r2), new com.modiface.mfemakeupkit.video.MFEVideoRecordingError.Consequence[0]));
        r9.f15434f.f();
        r9.f15434f.a(480, 360);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L_0x0104
            int r1 = r10.what
            r2 = 51
            r3 = 1
            if (r1 == r2) goto L_0x00cf
            r2 = 52
            if (r1 == r2) goto L_0x0010
            goto L_0x0104
        L_0x0010:
            java.util.concurrent.atomic.AtomicBoolean r1 = r9.j
            boolean r1 = r1.get()
            if (r1 != 0) goto L_0x00ce
            com.modiface.mfemakeupkit.video.n r1 = r9.f15434f
            boolean r1 = r1.d()
            if (r1 == 0) goto L_0x00ce
            com.modiface.mfemakeupkit.video.n r1 = r9.f15434f
            boolean r1 = r1.e()
            if (r1 != 0) goto L_0x00ce
            int r1 = r10.arg1
            if (r1 <= 0) goto L_0x00ce
            int r10 = r10.arg2
            if (r10 <= 0) goto L_0x00ce
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r2 < r4) goto L_0x0070
            com.modiface.mfemakeupkit.video.n r2 = r9.f15434f
            android.media.MediaCodecInfo$CodecCapabilities r2 = r2.f15458g
            if (r2 == 0) goto L_0x0070
            android.media.MediaCodecInfo$VideoCapabilities r2 = r2.getVideoCapabilities()
            if (r2 == 0) goto L_0x0070
            android.util.Range r4 = r2.getSupportedWidths()
            if (r4 == 0) goto L_0x0070
            android.util.Range r2 = r2.getSupportedHeights()
            if (r2 == 0) goto L_0x0070
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            java.lang.Comparable r4 = r4.clamp(r5)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 <= 0) goto L_0x0070
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
            java.lang.Comparable r2 = r2.clamp(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 <= 0) goto L_0x0070
            r10 = r2
            r1 = r4
        L_0x0070:
            com.modiface.mfemakeupkit.video.n r2 = r9.f15434f     // Catch:{ IllegalStateException -> 0x0078, CryptoException -> 0x0076 }
            r2.a(r1, r10)     // Catch:{ IllegalStateException -> 0x0078, CryptoException -> 0x0076 }
            goto L_0x00b1
        L_0x0076:
            r10 = move-exception
            goto L_0x00be
        L_0x0078:
            r2 = move-exception
            java.util.List<com.modiface.mfemakeupkit.video.MFEVideoRecordingError> r4 = r9.p     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            com.modiface.mfemakeupkit.video.MFEVideoRecordingError r5 = new com.modiface.mfemakeupkit.video.MFEVideoRecordingError     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            java.lang.Throwable r6 = new java.lang.Throwable     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            r7.<init>()     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            java.lang.String r8 = "failed to configure width, height: "
            r7.append(r8)     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            r7.append(r1)     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            java.lang.String r8 = "x"
            r7.append(r8)     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            r7.append(r10)     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            java.lang.String r7 = r7.toString()     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            r6.<init>(r7, r2)     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            com.modiface.mfemakeupkit.video.MFEVideoRecordingError$Consequence[] r2 = new com.modiface.mfemakeupkit.video.MFEVideoRecordingError.Consequence[r0]     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            r5.<init>(r6, r2)     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            r4.add(r5)     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            com.modiface.mfemakeupkit.video.n r2 = r9.f15434f     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            r2.f()     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            com.modiface.mfemakeupkit.video.n r2 = r9.f15434f     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            r4 = 480(0x1e0, float:6.73E-43)
            r5 = 360(0x168, float:5.04E-43)
            r2.a(r4, r5)     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
        L_0x00b1:
            com.modiface.mfemakeupkit.aa r2 = r9.f15433e     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            com.modiface.mfemakeupkit.video.n r4 = r9.f15434f     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            android.view.Surface r4 = r4.b()     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            r2.a(r4, r1, r10)     // Catch:{ IllegalStateException -> 0x00bd, CryptoException -> 0x0076 }
            goto L_0x00ce
        L_0x00bd:
            r10 = move-exception
        L_0x00be:
            java.util.List<com.modiface.mfemakeupkit.video.MFEVideoRecordingError> r1 = r9.p
            com.modiface.mfemakeupkit.video.MFEVideoRecordingError r2 = new com.modiface.mfemakeupkit.video.MFEVideoRecordingError
            com.modiface.mfemakeupkit.video.MFEVideoRecordingError$Consequence[] r4 = new com.modiface.mfemakeupkit.video.MFEVideoRecordingError.Consequence[r3]
            com.modiface.mfemakeupkit.video.MFEVideoRecordingError$Consequence r5 = com.modiface.mfemakeupkit.video.MFEVideoRecordingError.Consequence.RecordingFailed
            r4[r0] = r5
            r2.<init>(r10, r4)
            r1.add(r2)
        L_0x00ce:
            return r3
        L_0x00cf:
            java.util.concurrent.atomic.AtomicBoolean r10 = r9.j
            boolean r10 = r10.get()
            if (r10 != 0) goto L_0x0103
            r9.i()
            r9.j()
            com.modiface.mfemakeupkit.video.l r10 = f15431c
            int r0 = r10.x
            int r0 = r0 * 8
            int r0 = r0 / 16
            long r0 = (long) r0
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r4
            int r6 = r10.v
            long r6 = (long) r6
            long r0 = r0 / r6
            int r10 = r10.p
            long r6 = (long) r10
            long r4 = r4 / r6
            boolean r10 = r9.o
            if (r10 == 0) goto L_0x00fa
            long r4 = java.lang.Math.min(r4, r0)
        L_0x00fa:
            com.modiface.mfemakeupkit.utils.x r10 = r9.f15432d
            android.os.Handler r10 = r10.b()
            r10.sendEmptyMessageDelayed(r2, r4)
        L_0x0103:
            return r3
        L_0x0104:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.video.j.handleMessage(android.os.Message):boolean");
    }

    /* access modifiers changed from: private */
    public void g() {
        h();
        try {
            this.f15434f.i();
        } catch (IOException e2) {
            this.p.add(new MFEVideoRecordingError(e2, MFEVideoRecordingError.Consequence.RecordingFailed));
        }
        if (!this.o) {
            return;
        }
        if (this.h.a()) {
            try {
                this.f15435g.j();
                this.f15435g.k();
            } catch (MediaCodec.CryptoException | IOException | IllegalStateException e3) {
                this.p.add(new MFEVideoRecordingError(e3, MFEVideoRecordingError.Consequence.NoAudio));
            }
        } else {
            this.p.add(new MFEVideoRecordingError(new Throwable("audio recording failed to start"), MFEVideoRecordingError.Consequence.NoAudio));
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        this.h.b();
        this.f15434f.f();
        this.f15435g.f();
    }

    private void i() {
        if (this.o) {
            try {
                d i2 = this.f15435g.i();
                if (i2 != null && i2.a()) {
                    int a2 = this.h.a(i2);
                    if (a2 >= 0) {
                        this.f15435g.a(i2, 0, a2, b() / 1000);
                    }
                }
            } catch (MediaCodec.CryptoException | IllegalStateException e2) {
                this.p.add(new MFEVideoRecordingError(e2, MFEVideoRecordingError.Consequence.NoAudio));
            }
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        d dVar;
        while (true) {
            d dVar2 = null;
            try {
                dVar = this.f15434f.h();
            } catch (IllegalStateException e2) {
                this.p.add(new MFEVideoRecordingError(e2, MFEVideoRecordingError.Consequence.RecordingFailed));
                dVar = null;
            }
            try {
                dVar2 = this.f15435g.h();
            } catch (IllegalStateException e3) {
                this.p.add(new MFEVideoRecordingError(e3, MFEVideoRecordingError.Consequence.NoAudio));
            }
            if (dVar != null && dVar.f15423a == -2) {
                try {
                    if (this.i.b(this.f15434f.c())) {
                        dVar = this.f15434f.h();
                    }
                } catch (IllegalArgumentException | IllegalStateException e4) {
                    this.p.add(new MFEVideoRecordingError(e4, MFEVideoRecordingError.Consequence.RecordingFailed));
                }
            }
            if (dVar2 != null && dVar2.f15423a == -2) {
                try {
                    if (this.i.a(this.f15435g.c())) {
                        dVar2 = this.f15435g.h();
                    }
                } catch (IllegalArgumentException | IllegalStateException e5) {
                    this.p.add(new MFEVideoRecordingError(e5, MFEVideoRecordingError.Consequence.NoAudio));
                }
            }
            if (dVar != null && dVar.a()) {
                try {
                    this.i.b(dVar, this.f15434f.a());
                } catch (IllegalArgumentException | IllegalStateException e6) {
                    this.p.add(new MFEVideoRecordingError(e6, MFEVideoRecordingError.Consequence.SkippedVideoFrame));
                }
                try {
                    this.f15434f.a(dVar);
                } catch (IllegalStateException e7) {
                    this.p.add(new MFEVideoRecordingError(e7, new MFEVideoRecordingError.Consequence[0]));
                }
            }
            if (dVar2 != null && dVar2.a()) {
                try {
                    this.i.a(dVar2, this.f15435g.a());
                } catch (IllegalArgumentException | IllegalStateException e8) {
                    this.p.add(new MFEVideoRecordingError(e8, MFEVideoRecordingError.Consequence.SkippedAudioFrame));
                }
                try {
                    this.f15435g.a(dVar2);
                } catch (IllegalStateException e9) {
                    this.p.add(new MFEVideoRecordingError(e9, new MFEVideoRecordingError.Consequence[0]));
                }
            }
            if ((dVar == null || !dVar.a()) && (dVar2 == null || !dVar2.a())) {
                return;
            }
        }
    }

    public long b() {
        return System.nanoTime() - this.k;
    }

    public aa c() {
        return this.f15433e;
    }

    public void d() {
        this.j.set(true);
        this.f15432d.b(new g(this));
    }

    public void e() {
        this.f15432d.a((Runnable) new h(this));
    }

    public void f() {
        this.f15432d.b(new i(this));
        this.f15432d.a();
    }

    public List<MFEVideoRecordingError> a() {
        ArrayList arrayList;
        synchronized (this.p) {
            arrayList = new ArrayList(this.p);
            this.p.clear();
        }
        return arrayList;
    }

    public void a(MFEGLFramebuffer mFEGLFramebuffer) {
        int i2;
        int i3 = 0;
        if (mFEGLFramebuffer == null || !mFEGLFramebuffer.isValid()) {
            i2 = 0;
        } else {
            i3 = mFEGLFramebuffer.getWidth();
            i2 = mFEGLFramebuffer.getHeight();
        }
        Handler b2 = this.f15432d.b();
        if (b2 != null) {
            b2.sendMessage(Message.obtain(b2, 52, i3, i2));
        }
    }
}
