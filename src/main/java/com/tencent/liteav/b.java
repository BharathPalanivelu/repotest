package com.tencent.liteav;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.d.l;
import com.tencent.liteav.basic.d.m;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.microedition.khronos.egl.EGLContext;

public class b implements a, m, com.tencent.liteav.capturer.b, l {

    /* renamed from: a  reason: collision with root package name */
    WeakReference<a> f31201a;

    /* renamed from: b  reason: collision with root package name */
    private Context f31202b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.tencent.liteav.capturer.a f31203c;

    /* renamed from: d  reason: collision with root package name */
    private m f31204d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31205e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public f f31206f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f31207g;
    private boolean h;
    /* access modifiers changed from: private */
    public int i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public l k;
    private boolean l;
    private long m;
    private long n;
    private long o;
    private int p;
    private Object q;
    private HandlerThread r;
    /* access modifiers changed from: private */
    public Handler s;
    private String t;

    public b(Context context, f fVar, l lVar, boolean z) {
        this.f31203c = null;
        this.f31207g = 0;
        this.h = false;
        this.i = -1;
        this.j = -1;
        this.k = null;
        this.l = false;
        this.m = 0;
        this.o = 0;
        this.p = 0;
        this.q = new Object();
        this.r = null;
        this.s = null;
        this.t = "";
        this.f31203c = new com.tencent.liteav.capturer.a();
        try {
            this.f31206f = (f) fVar.clone();
        } catch (CloneNotSupportedException e2) {
            this.f31206f = new f();
            e2.printStackTrace();
        }
        this.f31202b = context;
        this.k = lVar;
        this.k.setSurfaceTextureListener(this);
        this.f31206f.P = z;
    }

    public void a() {
        TXCLog.i("CameraCapture", "start->enter with getSurfaceTexture:" + this.k.getSurfaceTexture());
        this.k.a(this.f31206f.h, this.f31206f.P ^ true);
        c(this.k.getSurfaceTexture());
    }

    public void a(boolean z) {
        c();
        this.k.a();
        synchronized (this.q) {
            if (this.s != null) {
                this.s.removeCallbacksAndMessages((Object) null);
            }
            if (this.r != null) {
                TXCLog.w("CameraCapture", "stop camera monitor ");
                this.r.quit();
                this.r = null;
                this.s = null;
            }
        }
    }

    public void a(String str) {
        this.t = str;
    }

    public void b() {
        TXCLog.i("CameraCapture", "startCapture->enter with getSurfaceTexture:" + this.k.getSurfaceTexture());
        c(this.k.getSurfaceTexture());
    }

    public void c() {
        TXCLog.i("CameraCapture", "stopCapture->enter with null");
        this.f31203c.a((com.tencent.liteav.capturer.b) null);
        this.f31203c.b();
        this.f31205e = false;
    }

    public void b(boolean z) {
        if (this.f31205e && this.f31203c != null) {
            f fVar = this.f31206f;
            fVar.m = z ? !fVar.m : fVar.m;
            this.f31203c.b();
            this.k.a(false);
            this.f31203c.b(this.f31206f.h);
            this.f31203c.a(i());
            this.f31203c.a(this.f31206f.P, this.f31206f.f31618a, this.f31206f.f31619b);
            this.f31203c.a((com.tencent.liteav.capturer.b) this);
            this.f31203c.a(this.k.getSurfaceTexture());
            if (this.f31203c.c(this.f31206f.m) == 0) {
                this.f31205e = true;
                a(1003, "打开摄像头成功");
            } else {
                this.f31205e = false;
                a(-1301, "打开摄像头失败，请确认摄像头权限是否打开");
            }
            this.l = false;
        }
    }

    public boolean d() {
        return this.f31205e;
    }

    public int e() {
        return this.f31203c.a();
    }

    public boolean a(int i2) {
        return this.f31203c.c(i2);
    }

    public void a(float f2) {
        this.f31203c.a(f2);
    }

    public void b(int i2) {
        this.i = i2;
        j();
    }

    public void c(int i2) {
        l lVar = this.k;
        if (lVar != null) {
            lVar.setRendMode(i2);
        }
    }

    public void d(int i2) {
        l lVar = this.k;
        if (lVar != null) {
            lVar.setRendMirror(i2);
        }
    }

    public void a(m mVar) {
        this.f31204d = mVar;
    }

    public void c(final boolean z) {
        a((Runnable) new Runnable() {
            public void run() {
                b.this.f31206f.M = z;
            }
        });
    }

    public boolean d(boolean z) {
        return this.f31203c.a(z);
    }

    public void a(com.tencent.liteav.basic.structs.b bVar) {
        l lVar = this.k;
        if (lVar != null) {
            lVar.a(bVar.f31404a, bVar.i, this.f31207g, bVar.f31408e, bVar.f31409f, this.f31203c.d());
        }
    }

    public void e(boolean z) {
        this.h = z;
    }

    public void a(Runnable runnable) {
        this.k.a(runnable);
    }

    public EGLContext f() {
        return this.k.getGLContext();
    }

    public void onNotifyEvent(int i2, Bundle bundle) {
        com.tencent.liteav.basic.util.b.a(this.f31201a, i2, bundle);
    }

    public void a(a aVar) {
        this.f31201a = new WeakReference<>(aVar);
    }

    public void e(int i2) {
        this.j = i2;
        j();
    }

    public void a(int i2, int i3) {
        f fVar = this.f31206f;
        fVar.f31618a = i2;
        fVar.f31619b = i3;
    }

    public void f(int i2) {
        this.f31206f.h = i2;
        com.tencent.liteav.capturer.a aVar = this.f31203c;
        if (aVar != null) {
            aVar.b(i2);
        }
        l lVar = this.k;
        if (lVar != null && (lVar instanceof TXCGLSurfaceView)) {
            ((TXCGLSurfaceView) lVar).setFPS(i2);
        }
    }

    public void a(float f2, float f3) {
        if (this.f31203c != null && this.f31206f.E) {
            this.f31203c.a(f2, f3);
        }
    }

    public boolean g() {
        com.tencent.liteav.capturer.a aVar = this.f31203c;
        if (aVar != null) {
            return aVar.d();
        }
        return false;
    }

    private void c(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null && !this.f31205e) {
            com.tencent.liteav.capturer.a aVar = this.f31203c;
            if (aVar != null) {
                aVar.a((com.tencent.liteav.capturer.b) this);
                this.f31203c.a(surfaceTexture);
                this.f31203c.b(this.f31206f.h);
                this.f31203c.d(this.f31206f.l);
                this.f31203c.b(this.f31206f.E);
                this.f31203c.a(i());
                this.f31203c.a(this.f31206f.P, this.f31206f.f31618a, this.f31206f.f31619b);
                if (this.f31203c.c(this.f31206f.m) == 0) {
                    this.f31205e = true;
                    this.n = System.currentTimeMillis();
                    a(1003, "打开摄像头成功");
                    this.l = false;
                    if (this.h && !com.tencent.liteav.audio.b.a().c()) {
                        if (com.tencent.liteav.audio.b.a().a(this.f31202b) == 0) {
                            a((int) TXLiteAVCode.EVT_MIC_START_SUCC, "打开麦克风成功");
                        }
                        this.h = false;
                        return;
                    }
                    return;
                }
                this.f31205e = false;
                a(-1301, "打开摄像头失败，请确认摄像头权限是否打开");
            }
        }
    }

    private void a(int i2, String str) {
        com.tencent.liteav.basic.util.b.a(this.f31201a, i2, str);
    }

    public void a(SurfaceTexture surfaceTexture) {
        TXCLog.i("CameraCapture", "onSurfaceTextureAvailable->enter with mListener:" + this.f31204d);
        c(surfaceTexture);
        m mVar = this.f31204d;
        if (mVar != null) {
            mVar.a(surfaceTexture);
        }
    }

    public void b(SurfaceTexture surfaceTexture) {
        TXCLog.i("CameraCapture", "onSurfaceTextureDestroy->enter with mListener:" + this.f31204d);
        m mVar = this.f31204d;
        if (mVar != null) {
            mVar.u();
        }
    }

    public int a(int i2, float[] fArr) {
        a(i2, (byte[]) null, fArr, 4);
        return 0;
    }

    public void a(byte[] bArr, float[] fArr) {
        a(-1, bArr, fArr, 3);
    }

    private void a(int i2, byte[] bArr, float[] fArr, int i3) {
        if (this.f31205e) {
            boolean z = true;
            if (!this.l) {
                com.tencent.liteav.basic.util.b.a(this.f31201a, 1007, "首帧画面采集完成");
                this.l = true;
                TXCLog.d("CameraCapture", "trtc_render: render first frame");
            }
            com.tencent.liteav.basic.structs.b bVar = new com.tencent.liteav.basic.structs.b();
            bVar.f31408e = this.f31203c.e();
            bVar.f31409f = this.f31203c.f();
            bVar.f31410g = this.f31206f.f31618a;
            bVar.h = this.f31206f.f31619b;
            bVar.j = this.f31203c.c();
            if (!this.f31203c.d()) {
                z = this.f31206f.M;
            } else if (this.f31206f.M) {
                z = false;
            }
            bVar.i = z;
            bVar.f31404a = i2;
            bVar.f31406c = fArr;
            bVar.f31407d = this.f31206f.P;
            bVar.m = bArr;
            bVar.f31405b = i3;
            if (bVar.j == 0 || bVar.j == 180) {
                bVar.f31410g = this.f31206f.f31619b;
                bVar.h = this.f31206f.f31618a;
            } else {
                bVar.f31410g = this.f31206f.f31618a;
                bVar.h = this.f31206f.f31619b;
            }
            bVar.l = com.tencent.liteav.basic.util.b.a(bVar.f31408e, bVar.f31409f, this.f31206f.f31619b, this.f31206f.f31618a);
            m mVar = this.f31204d;
            if (mVar != null) {
                mVar.b(bVar);
            }
            this.m++;
            long currentTimeMillis = System.currentTimeMillis() - this.n;
            if (currentTimeMillis >= 1000) {
                double d2 = (double) (this.m - this.o);
                Double.isNaN(d2);
                double d3 = (double) currentTimeMillis;
                Double.isNaN(d3);
                TXCStatus.a(this.t, 1001, this.p, Double.valueOf((d2 * 1000.0d) / d3));
                this.o = this.m;
                this.n += currentTimeMillis;
            }
        }
    }

    private int i() {
        if (!this.f31206f.N) {
            int i2 = this.f31206f.k;
            if (i2 == 0) {
                return 4;
            }
            if (i2 == 1) {
                return 5;
            }
            if (i2 != 2) {
                return i2 != 6 ? 7 : 3;
            }
            return 6;
        }
    }

    private void j() {
        a((Runnable) new Runnable() {
            public void run() {
                if (b.this.i != -1) {
                    b bVar = b.this;
                    int unused = bVar.f31207g = bVar.i;
                    int unused2 = b.this.i = -1;
                }
                if (b.this.j != -1) {
                    b.this.f31206f.l = b.this.j;
                    b.this.f31203c.d(b.this.f31206f.l);
                    int unused3 = b.this.j = -1;
                }
            }
        });
    }

    public void a(byte[] bArr) {
        l lVar = this.k;
        if (lVar != null) {
            lVar.a(bArr);
        }
    }

    public void h() {
        if (this.f31203c.g() != null) {
            this.f31203c.b();
        }
        synchronized (this.q) {
            if (this.r == null) {
                this.r = new HandlerThread("cameraMonitorThread");
                this.r.start();
                this.s = new Handler(this.r.getLooper());
                TXCLog.w("CameraCapture", "start camera monitor ");
            }
            if (this.s != null) {
                this.s.postDelayed(new Runnable() {
                    public void run() {
                        try {
                            if (b.this.d() && b.this.k() && b.this.f31203c.g() == null) {
                                TXCLog.w("CameraCapture", "camera monitor restart capture");
                                b.this.f31203c.b();
                                b.this.k.a(false);
                                b.this.f31203c.b(b.this.f31206f.h);
                                b.this.f31203c.a(b.this.f31206f.P, b.this.f31206f.f31618a, b.this.f31206f.f31619b);
                                b.this.f31203c.a(b.this.k.getSurfaceTexture());
                                b.this.f31203c.c(b.this.f31206f.m);
                            } else if (b.this.s != null) {
                                b.this.s.postDelayed(this, 2000);
                            }
                        } catch (Exception unused) {
                            TXCLog.w("CameraCapture", "camera monitor exception ");
                        }
                    }
                }, 2000);
            }
        }
    }

    public void g(int i2) {
        this.p = i2;
    }

    /* access modifiers changed from: private */
    public boolean k() {
        try {
            if (this.f31202b != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f31202b.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    TXCLog.w("CameraCapture", "List of RunningAppProcessInfo is null");
                    return false;
                }
                for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
                    if (runningAppProcessInfo == null) {
                        TXCLog.w("CameraCapture", "ActivityManager.RunningAppProcessInfo is null");
                    } else if (runningAppProcessInfo.processName.equals(this.f31202b.getPackageName()) && runningAppProcessInfo.importance == 100) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
