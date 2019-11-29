package com.tencent.liteav.basic.d;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.log.TXCLog;
import javax.microedition.khronos.egl.EGLContext;

public class e implements f.a, l {

    /* renamed from: a  reason: collision with root package name */
    public int f31292a = 25;

    /* renamed from: b  reason: collision with root package name */
    private volatile HandlerThread f31293b = null;

    /* renamed from: c  reason: collision with root package name */
    private volatile f f31294c = null;

    /* renamed from: d  reason: collision with root package name */
    private m f31295d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f31296e = null;

    /* renamed from: f  reason: collision with root package name */
    private SurfaceTexture f31297f = null;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f31298g = false;
    private long h = 0;
    private long i = 0;
    private float[] j = new float[16];

    public void a(int i2, boolean z, int i3, int i4, int i5, boolean z2) {
    }

    public void a(byte[] bArr) {
    }

    public void setRendMirror(int i2) {
    }

    public void setRendMode(int i2) {
    }

    public void a(int i2, boolean z) {
        this.f31292a = i2;
        b();
    }

    public void a() {
        f();
    }

    public void setSurfaceTextureListener(m mVar) {
        this.f31295d = mVar;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f31297f;
    }

    public EGLContext getGLContext() {
        EGLContext a2;
        synchronized (this) {
            a2 = this.f31294c != null ? this.f31294c.a() : null;
        }
        return a2;
    }

    public void a(Runnable runnable) {
        synchronized (this) {
            if (this.f31294c != null) {
                this.f31294c.post(runnable);
            }
        }
    }

    public void a(boolean z) {
        synchronized (this) {
            try {
                if (this.f31294c != null) {
                    this.f31294c.removeCallbacksAndMessages((Object) null);
                }
                this.f31298g = false;
                if (this.f31297f != null) {
                    if (this.f31296e != null) {
                        this.f31297f.updateTexImage();
                        this.f31297f.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                                e.this.a(103, (Runnable) new Runnable() {
                                    public void run() {
                                        boolean unused = e.this.f31298g = true;
                                        e.this.a(102);
                                    }
                                });
                                surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                            }
                        });
                        return;
                    }
                }
                try {
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void c() {
        h();
    }

    public void d() {
        a(102, 5);
        if (i()) {
            SurfaceTexture surfaceTexture = this.f31297f;
            if (surfaceTexture != null && this.f31296e != null) {
                try {
                    surfaceTexture.updateTexImage();
                    this.f31297f.getTransformMatrix(this.j);
                } catch (Exception e2) {
                    TXCLog.e("TXGLSurfaceTextureThread", "onMsgRend Exception " + e2.getMessage());
                    e2.printStackTrace();
                }
                m mVar = this.f31295d;
                if (mVar != null) {
                    mVar.a(this.f31296e[0], this.j);
                }
            }
        }
    }

    public void e() {
        g();
    }

    private void b() {
        f();
        synchronized (this) {
            this.f31293b = new HandlerThread("TXGLSurfaceTextureThread");
            this.f31293b.start();
            this.f31294c = new f(this.f31293b.getLooper());
            this.f31294c.a((f.a) this);
            this.f31294c.f31303a = 1280;
            this.f31294c.f31304b = 720;
            TXCLog.w("TXGLSurfaceTextureThread", "create gl thread " + this.f31293b.getName());
        }
        a(100);
    }

    private void f() {
        synchronized (this) {
            if (this.f31294c != null) {
                f.a(this.f31294c, this.f31293b);
                TXCLog.w("TXGLSurfaceTextureThread", "destroy gl thread");
            }
            this.f31294c = null;
            this.f31293b = null;
        }
    }

    private void a(int i2, long j2) {
        synchronized (this) {
            if (this.f31294c != null) {
                this.f31294c.sendEmptyMessageDelayed(i2, j2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        synchronized (this) {
            if (this.f31294c != null) {
                this.f31294c.sendEmptyMessage(i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, Runnable runnable) {
        synchronized (this) {
            if (this.f31294c != null) {
                Message message = new Message();
                message.what = i2;
                message.obj = runnable;
                this.f31294c.sendMessage(message);
            }
        }
    }

    private void g() {
        TXCLog.w("TXGLSurfaceTextureThread", "destroy surface texture ");
        m mVar = this.f31295d;
        if (mVar != null) {
            mVar.b(this.f31297f);
        }
        SurfaceTexture surfaceTexture = this.f31297f;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
            this.f31297f.release();
            this.f31298g = false;
            this.f31297f = null;
        }
        int[] iArr = this.f31296e;
        if (iArr != null) {
            GLES20.glDeleteTextures(1, iArr, 0);
            this.f31296e = null;
        }
    }

    private void h() {
        TXCLog.w("TXGLSurfaceTextureThread", "init surface texture ");
        this.f31296e = new int[1];
        this.f31296e[0] = i.b();
        int[] iArr = this.f31296e;
        if (iArr[0] <= 0) {
            this.f31296e = null;
            return;
        }
        this.f31297f = new SurfaceTexture(iArr[0]);
        this.f31297f.setDefaultBufferSize(1280, 720);
        this.f31297f.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                e.this.a(103, (Runnable) new Runnable() {
                    public void run() {
                        boolean unused = e.this.f31298g = true;
                        e.this.a(102);
                    }
                });
                surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
            }
        });
        m mVar = this.f31295d;
        if (mVar != null) {
            mVar.a(this.f31297f);
        }
    }

    private boolean i() {
        if (!this.f31298g) {
            this.h = 0;
            this.i = System.nanoTime();
            return false;
        }
        long nanoTime = System.nanoTime();
        long j2 = this.i;
        if (nanoTime < ((((this.h * 1000) * 1000) * 1000) / ((long) this.f31292a)) + j2) {
            return false;
        }
        if (j2 == 0) {
            this.i = nanoTime;
        } else if (nanoTime > j2 + 1000000000) {
            this.h = 0;
            this.i = nanoTime;
        }
        this.h++;
        return true;
    }
}
