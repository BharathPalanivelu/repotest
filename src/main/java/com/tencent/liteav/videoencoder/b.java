package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import android.os.Bundle;
import android.view.Surface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.c;
import com.tencent.liteav.beauty.b.k;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

public class b extends com.tencent.liteav.basic.module.a {
    private static Integer r = 1;
    private static final String u = b.class.getSimpleName();
    private static int v = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public c f32118a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public d f32119b = null;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<com.tencent.liteav.basic.c.a> f32120c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f32121d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f32122e = 2;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f32123f = 1;

    /* renamed from: g  reason: collision with root package name */
    private Timer f32124g = null;
    private TimerTask h = null;
    /* access modifiers changed from: private */
    public LinkedList<Runnable> i = new LinkedList<>();
    /* access modifiers changed from: private */
    public TXSVideoEncoderParam j;
    /* access modifiers changed from: private */
    public float k = BitmapDescriptorFactory.HUE_RED;
    /* access modifiers changed from: private */
    public float l = BitmapDescriptorFactory.HUE_RED;
    /* access modifiers changed from: private */
    public float m = BitmapDescriptorFactory.HUE_RED;
    /* access modifiers changed from: private */
    public int n = 0;
    /* access modifiers changed from: private */
    public int o = 0;
    /* access modifiers changed from: private */
    public com.tencent.liteav.basic.d.b p;
    private c q;
    private boolean s;
    /* access modifiers changed from: private */
    public k t;

    static /* synthetic */ int k(b bVar) {
        int i2 = bVar.n + 1;
        bVar.n = i2;
        return i2;
    }

    public b(int i2) {
        this.f32122e = i2;
    }

    public int a(TXSVideoEncoderParam tXSVideoEncoderParam) {
        int i2;
        this.j = tXSVideoEncoderParam;
        int c2 = tXSVideoEncoderParam.enableBlackList ? com.tencent.liteav.basic.e.b.a().c() : 2;
        if (this.f32122e == 1 && c2 != 0) {
            this.f32118a = new a();
            this.f32123f = 1;
            a(1008, "启动硬编", 1);
        } else if (this.f32122e == 3 && tXSVideoEncoderParam.width == 720 && tXSVideoEncoderParam.height == 1280 && c2 != 0) {
            this.f32118a = new a();
            this.f32123f = 1;
            a(1008, "启动硬编", 1);
        } else {
            this.f32118a = new TXCSWVideoEncoder();
            this.f32123f = 2;
            a(1008, "启动软编", 2);
        }
        setStatusValue(4007, Long.valueOf((long) this.f32123f));
        c cVar = this.f32118a;
        if (cVar != null) {
            d dVar = this.f32119b;
            if (dVar != null) {
                cVar.setListener(dVar);
            }
            int i3 = this.f32121d;
            if (i3 != 0) {
                this.f32118a.setBitrate(i3);
            }
            this.f32118a.setID(getID());
            i2 = this.f32118a.start(tXSVideoEncoderParam);
            if (i2 != 0) {
                String str = this.f32123f == 1 ? "hw" : "sw";
                String str2 = u;
                TXCLog.d(str2, "start video encode " + str);
                return i2;
            }
        } else {
            i2 = 10000002;
        }
        if (this.f32122e == 3) {
            this.k = BitmapDescriptorFactory.HUE_RED;
            this.l = BitmapDescriptorFactory.HUE_RED;
            this.m = BitmapDescriptorFactory.HUE_RED;
            this.n = 0;
            this.o = com.tencent.liteav.basic.e.b.a().f();
            c();
        }
        return i2;
    }

    public void setID(String str) {
        super.setID(str);
        c cVar = this.f32118a;
        if (cVar != null) {
            cVar.setID(str);
        }
        setStatusValue(4007, Long.valueOf((long) this.f32123f));
    }

    public EGLContext a(final int i2, final int i3) {
        if (!this.s) {
            this.s = true;
            synchronized (r) {
                StringBuilder sb = new StringBuilder();
                sb.append("CVGLThread");
                Integer num = r;
                r = Integer.valueOf(r.intValue() + 1);
                sb.append(num);
                this.q = new c(sb.toString());
            }
            final boolean[] zArr = new boolean[1];
            this.q.a((Runnable) new Runnable() {
                public void run() {
                    com.tencent.liteav.basic.d.b unused = b.this.p = com.tencent.liteav.basic.d.b.a((EGLConfig) null, (EGLContext) null, (Surface) null, i2, i3);
                    zArr[0] = b.this.p != null;
                }
            });
            if (zArr[0]) {
                return this.p.c();
            }
            return null;
        }
        com.tencent.liteav.basic.d.b bVar = this.p;
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        synchronized (this.i) {
            this.i.add(runnable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r0.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if (r0 != null) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.Queue<java.lang.Runnable> r3) {
        /*
            r2 = this;
            monitor-enter(r3)
            boolean r0 = r3.isEmpty()     // Catch:{ all -> 0x0019 }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r3)     // Catch:{ all -> 0x0019 }
            return r1
        L_0x000a:
            java.lang.Object r0 = r3.poll()     // Catch:{ all -> 0x0019 }
            java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ all -> 0x0019 }
            monitor-exit(r3)     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x0014
            return r1
        L_0x0014:
            r0.run()
            r3 = 1
            return r3
        L_0x0019:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0019 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoencoder.b.a(java.util.Queue):boolean");
    }

    public long a(byte[] bArr, int i2, int i3, int i4, long j2) {
        if (this.p == null) {
            return -1;
        }
        final int i5 = i3;
        final int i6 = i4;
        final int i7 = i2;
        final byte[] bArr2 = bArr;
        final long j3 = j2;
        this.q.b(new Runnable() {
            public void run() {
                if (!(b.this.t != null && b.this.t.n() == i5 && b.this.t.o() == i6)) {
                    if (b.this.t != null) {
                        b.this.t.d();
                        k unused = b.this.t = null;
                    }
                    k unused2 = b.this.t = new k(i7);
                    if (!b.this.t.a()) {
                        b.this.p.b();
                        com.tencent.liteav.basic.d.b unused3 = b.this.p = null;
                        k unused4 = b.this.t = null;
                        return;
                    }
                    b.this.t.a(true);
                    b.this.t.a(i5, i6);
                }
                b.this.t.a(bArr2);
                GLES20.glViewport(0, 0, i5, i6);
                int q = b.this.t.q();
                GLES20.glFlush();
                b.this.a(q, i5, i6, j3);
            }
        });
        return 0;
    }

    public void a() {
        c cVar = this.q;
        if (cVar != null) {
            final com.tencent.liteav.basic.d.b bVar = this.p;
            cVar.b(new Runnable() {
                public void run() {
                    b.this.i.clear();
                    if (b.this.f32118a != null) {
                        b.this.f32118a.stop();
                    }
                    if (b.this.t != null) {
                        b.this.t.d();
                        k unused = b.this.t = null;
                    }
                    com.tencent.liteav.basic.d.b bVar = bVar;
                    if (bVar != null) {
                        bVar.b();
                    }
                }
            });
            this.q = null;
            this.p = null;
        } else {
            this.i.clear();
            c cVar2 = this.f32118a;
            if (cVar2 != null) {
                cVar2.stop();
            }
        }
        if (this.f32122e == 3) {
            this.k = BitmapDescriptorFactory.HUE_RED;
            this.l = BitmapDescriptorFactory.HUE_RED;
            this.m = BitmapDescriptorFactory.HUE_RED;
            this.n = 0;
            d();
        }
        this.f32119b = null;
        this.f32121d = 0;
    }

    public void a(int i2) {
        c cVar = this.f32118a;
        if (cVar != null) {
            cVar.setRotation(i2);
        }
    }

    public long a(int i2, int i3, int i4, long j2) {
        do {
        } while (a((Queue<Runnable>) this.i));
        c cVar = this.f32118a;
        if (cVar != null) {
            return cVar.pushVideoFrame(i2, i3, i4, j2);
        }
        return 10000002;
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        this.f32120c = new WeakReference<>(aVar);
    }

    public void a(d dVar) {
        this.f32119b = dVar;
        a((Runnable) new Runnable() {
            public void run() {
                if (b.this.f32118a != null) {
                    b.this.f32118a.setListener(b.this.f32119b);
                }
            }
        });
    }

    public void b(int i2) {
        this.f32121d = i2;
        a((Runnable) new Runnable() {
            public void run() {
                if (b.this.f32118a != null) {
                    b.this.f32118a.setBitrate(b.this.f32121d);
                }
            }
        });
    }

    public boolean c(int i2) {
        c cVar = this.f32118a;
        if (cVar == null) {
            return false;
        }
        cVar.setEncodeIdrFpsFromQos(i2);
        return true;
    }

    public double b() {
        c cVar = this.f32118a;
        if (cVar != null) {
            return cVar.getRealFPS();
        }
        return 0.0d;
    }

    private void c() {
        if (this.h == null) {
            this.h = new a(this);
        }
        this.f32124g = new Timer();
        this.f32124g.schedule(this.h, 1000, 1000);
    }

    /* access modifiers changed from: private */
    public void d() {
        Timer timer = this.f32124g;
        if (timer != null) {
            timer.cancel();
            this.f32124g = null;
        }
        if (this.h != null) {
            this.h = null;
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        WeakReference<com.tencent.liteav.basic.c.a> weakReference = this.f32120c;
        if (weakReference != null) {
            com.tencent.liteav.basic.c.a aVar = (com.tencent.liteav.basic.c.a) weakReference.get();
            if (aVar != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("EVT_ID", i2);
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
                aVar.onNotifyEvent(i2, bundle);
            }
        }
    }

    private void a(int i2, String str, int i3) {
        WeakReference<com.tencent.liteav.basic.c.a> weakReference = this.f32120c;
        if (weakReference != null) {
            com.tencent.liteav.basic.c.a aVar = (com.tencent.liteav.basic.c.a) weakReference.get();
            if (aVar != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("EVT_ID", i2);
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
                bundle.putInt("EVT_PARAM1", i3);
                aVar.onNotifyEvent(i2, bundle);
            }
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        a((Runnable) new Runnable() {
            public void run() {
                b.this.a(1107, "软编切硬编");
                if (b.this.f32118a != null) {
                    b.this.f32118a.setListener((d) null);
                    b.this.f32118a.stop();
                }
                c unused = b.this.f32118a = new a();
                int unused2 = b.this.f32123f = 1;
                b bVar = b.this;
                bVar.setStatusValue(4007, Long.valueOf((long) bVar.f32123f));
                b.this.f32118a.start(b.this.j);
                if (b.this.f32119b != null) {
                    b.this.f32118a.setListener(b.this.f32119b);
                }
                if (b.this.f32121d != 0) {
                    b.this.f32118a.setBitrate(b.this.f32121d);
                }
                b.this.f32118a.setID(b.this.getID());
            }
        });
        TXCLog.w("TXCVideoEncoder", "switchSWToHW");
    }

    static class a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<b> f32140a;

        public a(b bVar) {
            this.f32140a = new WeakReference<>(bVar);
        }

        public void run() {
            WeakReference<b> weakReference = this.f32140a;
            if (weakReference != null) {
                b bVar = (b) weakReference.get();
                if (bVar != null) {
                    if (bVar.n < bVar.o) {
                        int[] a2 = com.tencent.liteav.basic.util.b.a();
                        b.k(bVar);
                        float unused = bVar.k = bVar.k + ((float) (a2[0] / 10));
                        float unused2 = bVar.l = bVar.l + ((float) (a2[1] / 10));
                        double n = (double) bVar.m;
                        double d2 = (double) bVar.j.fps;
                        Double.isNaN(d2);
                        Double.isNaN(n);
                        float unused3 = bVar.m = (float) (n + ((bVar.b() * 100.0d) / d2));
                        return;
                    }
                    if (com.tencent.liteav.basic.e.b.a().a(bVar.k / ((float) bVar.o), bVar.l / ((float) bVar.o), bVar.m / ((float) bVar.o)) && com.tencent.liteav.basic.e.b.a().c() != 0) {
                        bVar.e();
                    }
                    bVar.d();
                }
            }
        }
    }
}
