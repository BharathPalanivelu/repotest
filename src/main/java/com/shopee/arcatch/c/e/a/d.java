package com.shopee.arcatch.c.e.a;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.display.VirtualDisplay;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.shopee.arcatch.c.e.b.f;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class d extends Thread implements b {
    private static String q = "video/avc";
    /* access modifiers changed from: private */
    public static int r = 2000000;
    private static int s = 30;
    private static int t = 10;
    /* access modifiers changed from: private */
    public static int u = 30;
    private static int v = 10000;

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<c> f26800a;

    /* renamed from: b  reason: collision with root package name */
    MediaCodec.BufferInfo f26801b = new MediaCodec.BufferInfo();

    /* renamed from: c  reason: collision with root package name */
    protected boolean f26802c;

    /* renamed from: d  reason: collision with root package name */
    private final String f26803d = "MediaVideoEncoder";

    /* renamed from: e  reason: collision with root package name */
    private MediaCodec f26804e;

    /* renamed from: f  reason: collision with root package name */
    private int f26805f;

    /* renamed from: g  reason: collision with root package name */
    private f f26806g;
    private Surface h;
    /* access modifiers changed from: private */
    public MediaProjection i;
    private VirtualDisplay j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public Rect p;
    private boolean w;
    private ByteBuffer[] x;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private MediaProjection f26808a;

        /* renamed from: b  reason: collision with root package name */
        private c f26809b;

        /* renamed from: c  reason: collision with root package name */
        private int f26810c;

        /* renamed from: d  reason: collision with root package name */
        private int f26811d;

        /* renamed from: e  reason: collision with root package name */
        private int f26812e;

        /* renamed from: f  reason: collision with root package name */
        private int f26813f;

        /* renamed from: g  reason: collision with root package name */
        private Rect f26814g;
        private int h;
        private int i;
        private int j;

        public a a(MediaProjection mediaProjection) {
            this.f26808a = mediaProjection;
            return this;
        }

        public a a(c cVar) {
            this.f26809b = cVar;
            return this;
        }

        public a a(int i2) {
            this.f26810c = i2;
            return this;
        }

        public a b(int i2) {
            this.f26811d = i2;
            return this;
        }

        public a c(int i2) {
            this.f26812e = i2;
            return this;
        }

        public a d(int i2) {
            this.f26813f = i2;
            return this;
        }

        public a a(Rect rect) {
            this.f26814g = rect;
            return this;
        }

        public a e(int i2) {
            this.h = i2;
            return this;
        }

        public a f(int i2) {
            this.i = i2;
            return this;
        }

        public a g(int i2) {
            this.j = i2;
            return this;
        }

        public d a() {
            d dVar = new d();
            MediaProjection unused = dVar.i = this.f26808a;
            int unused2 = dVar.k = this.f26810c;
            int unused3 = dVar.l = this.f26811d;
            int unused4 = dVar.m = this.h;
            int unused5 = dVar.n = this.f26812e;
            int unused6 = dVar.o = this.f26813f;
            Rect unused7 = dVar.p = this.f26814g;
            dVar.f26800a = new WeakReference<>(this.f26809b);
            int unused8 = d.r = this.i;
            int unused9 = d.u = this.j;
            this.f26809b.a(dVar);
            return dVar;
        }
    }

    @TargetApi(21)
    public void run() {
        super.run();
        try {
            e();
            if (this.f26806g != null) {
                this.f26806g.g();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            com.garena.android.appkit.d.a.a(e2);
        }
        try {
            f();
        } catch (Exception e3) {
            e3.printStackTrace();
            com.garena.android.appkit.d.a.a(e3);
        }
    }

    @TargetApi(21)
    public void e() throws IOException {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(q, this.n, this.o);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, r);
        createVideoFormat.setInteger("frame-rate", s);
        createVideoFormat.setInteger("i-frame-interval", t);
        this.f26804e = MediaCodec.createEncoderByType(q);
        this.f26804e.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.h = this.f26804e.createInputSurface();
        this.f26806g = new f.a().a(this.h).a(this.k).b(this.l).c(this.n).d(this.o).a(this.p).e(u).a();
        this.f26806g.a((f.b) new f.b() {
            public void a() {
                d.this.g();
            }
        });
        this.f26804e.start();
        this.f26805f = -1;
        MediaProjection mediaProjection = this.i;
        if (mediaProjection != null) {
            this.j = mediaProjection.createVirtualDisplay("screen", this.k, this.l, this.m, 1, this.f26806g.b(), (VirtualDisplay.Callback) null, (Handler) null);
        }
        this.f26802c = false;
    }

    @TargetApi(21)
    public ByteBuffer a(int i2) {
        MediaCodec mediaCodec = this.f26804e;
        if (mediaCodec == null || this.x == null) {
            return null;
        }
        return mediaCodec.getOutputBuffer(i2);
    }

    public void b(int i2) {
        MediaCodec mediaCodec = this.f26804e;
        if (mediaCodec != null) {
            mediaCodec.releaseOutputBuffer(i2, false);
        }
    }

    public void b() {
        start();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0060 */
    @android.annotation.TargetApi(21)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
            r10 = this;
            boolean r0 = r10.w
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.ref.WeakReference<com.shopee.arcatch.c.e.a.c> r0 = r10.f26800a
            java.lang.Object r0 = r0.get()
            com.shopee.arcatch.c.e.a.c r0 = (com.shopee.arcatch.c.e.a.c) r0
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            android.media.MediaCodec r1 = r10.f26804e
            java.nio.ByteBuffer[] r1 = r1.getOutputBuffers()
            r10.x = r1
            android.media.MediaCodec r1 = r10.f26804e
            android.media.MediaCodec$BufferInfo r2 = r10.f26801b
            int r3 = v
            long r3 = (long) r3
            int r1 = r1.dequeueOutputBuffer(r2, r3)
            r2 = -1
            if (r1 != r2) goto L_0x0028
            goto L_0x00ba
        L_0x0028:
            r2 = -3
            if (r1 != r2) goto L_0x0035
            android.media.MediaCodec r0 = r10.f26804e
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()
            r10.x = r0
            goto L_0x00ba
        L_0x0035:
            r2 = -2
            r3 = 1
            if (r1 != r2) goto L_0x006d
            boolean r1 = r10.f26802c
            if (r1 != 0) goto L_0x0065
            android.media.MediaCodec r1 = r10.f26804e
            android.media.MediaFormat r1 = r1.getOutputFormat()
            com.shopee.arcatch.c.e.a.c$a r2 = com.shopee.arcatch.c.e.a.c.a.VIDEO
            int r1 = r0.a((android.media.MediaFormat) r1, (com.shopee.arcatch.c.e.a.c.a) r2)
            r10.f26805f = r1
            r10.f26802c = r3
            boolean r1 = r0.f()
            if (r1 != 0) goto L_0x00ba
            monitor-enter(r0)
        L_0x0054:
            boolean r1 = r0.e()     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0060
            r1 = 100
            r0.wait(r1)     // Catch:{ InterruptedException -> 0x0060 }
            goto L_0x0054
        L_0x0060:
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            goto L_0x00ba
        L_0x0062:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            throw r1
        L_0x0065:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "format changed twice"
            r0.<init>(r1)
            throw r0
        L_0x006d:
            if (r1 >= 0) goto L_0x0070
            goto L_0x00ba
        L_0x0070:
            java.nio.ByteBuffer[] r2 = r10.x
            r2 = r2[r1]
            if (r2 == 0) goto L_0x00bb
            android.media.MediaCodec$BufferInfo r4 = r10.f26801b
            int r4 = r4.flags
            r4 = r4 & 2
            if (r4 == 0) goto L_0x0083
            android.media.MediaCodec$BufferInfo r4 = r10.f26801b
            r5 = 0
            r4.size = r5
        L_0x0083:
            android.media.MediaCodec$BufferInfo r4 = r10.f26801b
            int r4 = r4.size
            if (r4 == 0) goto L_0x00a5
            boolean r4 = r10.f26802c
            if (r4 == 0) goto L_0x00a5
            android.media.MediaCodec$BufferInfo r4 = r10.f26801b
            int r4 = r4.offset
            r2.position(r4)
            android.media.MediaCodec$BufferInfo r4 = r10.f26801b
            int r4 = r4.offset
            android.media.MediaCodec$BufferInfo r5 = r10.f26801b
            int r5 = r5.size
            int r4 = r4 + r5
            r2.limit(r4)
            android.media.MediaCodec$BufferInfo r2 = r10.f26801b
            r0.b(r1, r2)
        L_0x00a5:
            android.media.MediaCodec$BufferInfo r0 = r10.f26801b
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x00ba
            r10.w = r3
            android.media.MediaCodec$BufferInfo r4 = r10.f26801b
            r5 = 0
            r6 = 0
            r7 = 0
            int r9 = r4.flags
            r4.set(r5, r6, r7, r9)
        L_0x00ba:
            return
        L_0x00bb:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "encoder video-outputBuffer"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " was null"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            goto L_0x00d8
        L_0x00d7:
            throw r0
        L_0x00d8:
            goto L_0x00d7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.arcatch.c.e.a.d.g():void");
    }

    public void a() {
        f fVar = this.f26806g;
        if (fVar != null) {
            fVar.j();
        }
    }

    public void d() {
        f fVar = this.f26806g;
        if (fVar != null) {
            fVar.h();
        }
    }

    public void c() {
        f fVar = this.f26806g;
        if (fVar != null) {
            fVar.i();
        }
    }

    @TargetApi(21)
    public void f() {
        f fVar = this.f26806g;
        if (fVar != null) {
            fVar.k();
            this.f26806g = null;
        }
        MediaCodec mediaCodec = this.f26804e;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f26804e.release();
            this.f26804e = null;
        }
        VirtualDisplay virtualDisplay = this.j;
        if (virtualDisplay != null) {
            virtualDisplay.release();
        }
        if (this.f26802c) {
            c cVar = (c) this.f26800a.get();
            if (cVar != null) {
                try {
                    cVar.g();
                } catch (Exception e2) {
                    Log.e("MediaVideoEncoder", "failed stopping muxer", e2);
                }
            }
        }
    }
}
