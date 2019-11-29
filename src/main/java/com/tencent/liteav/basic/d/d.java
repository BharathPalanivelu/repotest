package com.tencent.liteav.basic.d;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

public class d implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private volatile HandlerThread f31272a = null;

    /* renamed from: b  reason: collision with root package name */
    private volatile f f31273b = null;

    /* renamed from: c  reason: collision with root package name */
    private g f31274c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f31275d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31276e = false;

    /* renamed from: f  reason: collision with root package name */
    private float f31277f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f31278g = 1.0f;
    private int h = 0;
    private int i = 0;
    private boolean j = false;
    private n k = null;
    private boolean l = false;

    public void d() {
    }

    public void a(EGLContext eGLContext, Surface surface) {
        TXCLog.i("TXGLSurfaceRenderThread", "surface-render: surface render start " + surface);
        b(eGLContext, surface);
    }

    public void a() {
        TXCLog.i("TXGLSurfaceRenderThread", "surface-render: surface render stop ");
        f();
    }

    public Surface b() {
        Surface b2;
        synchronized (this) {
            b2 = this.f31273b != null ? this.f31273b.b() : null;
        }
        return b2;
    }

    public void a(Runnable runnable) {
        synchronized (this) {
            if (this.f31273b != null) {
                this.f31273b.post(runnable);
            }
        }
    }

    public void a(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, boolean z2) {
        GLES20.glFinish();
        synchronized (this) {
            if (this.f31273b != null) {
                final int i8 = i2;
                final boolean z3 = z;
                final int i9 = i3;
                final int i10 = i4;
                final int i11 = i5;
                final int i12 = i6;
                final int i13 = i7;
                final boolean z4 = z2;
                this.f31273b.post(new Runnable() {
                    public void run() {
                        try {
                            d.this.b(i8, z3, i9, i10, i11, i12, i13, z4);
                        } catch (Exception unused) {
                            TXCLog.e("TXGLSurfaceRenderThread", "surface-render: render texture error occurred!");
                        }
                    }
                });
            }
        }
    }

    public void a(n nVar) {
        this.k = nVar;
        this.j = true;
    }

    public void c() {
        this.f31274c = new g();
        if (this.f31274c.a()) {
            this.f31274c.a(k.f31351e, k.a(j.NORMAL, false, false));
        }
    }

    public void e() {
        g gVar = this.f31274c;
        if (gVar != null) {
            gVar.d();
            this.f31274c = null;
        }
    }

    private void b(EGLContext eGLContext, Surface surface) {
        f();
        synchronized (this) {
            this.f31272a = new HandlerThread("TXGLSurfaceRenderThread");
            this.f31272a.start();
            this.f31273b = new f(this.f31272a.getLooper());
            this.f31273b.a((f.a) this);
            this.f31273b.f31309g = eGLContext;
            this.f31273b.f31305c = surface;
            TXCLog.w("TXGLSurfaceRenderThread", "surface-render: create gl thread " + this.f31272a.getName());
        }
        a(100);
    }

    private void f() {
        synchronized (this) {
            if (this.f31273b != null) {
                f.a(this.f31273b, this.f31272a);
                TXCLog.w("TXGLSurfaceRenderThread", "surface-render: destroy gl thread");
            }
            this.f31273b = null;
            this.f31272a = null;
        }
    }

    private void a(int i2) {
        synchronized (this) {
            if (this.f31273b != null) {
                this.f31273b.sendEmptyMessage(i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, boolean z2) {
        boolean z3 = z;
        int i8 = i3;
        int i9 = i6;
        int i10 = i7;
        if (i9 != 0 && i10 != 0 && this.f31274c != null) {
            if (this.l) {
                this.l = false;
                return;
            }
            if (z2) {
                GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
                GLES20.glClear(16640);
                GLES20.glBindFramebuffer(36160, 0);
                if (this.f31273b != null) {
                    this.f31273b.c();
                }
                this.l = true;
            }
            int i11 = i4 != 0 ? i4 : i9;
            int i12 = i5 != 0 ? i5 : i10;
            this.h = i11;
            this.i = i12;
            GLES20.glViewport(0, 0, i11, i12);
            float f2 = i12 != 0 ? ((float) i11) / ((float) i12) : 1.0f;
            float f3 = i10 != 0 ? ((float) i9) / ((float) i10) : 1.0f;
            if (!(this.f31276e == z3 && this.f31275d == i8 && this.f31277f == f2 && this.f31278g == f3)) {
                this.f31276e = z3;
                this.f31275d = i8;
                this.f31277f = f2;
                this.f31278g = f3;
                int i13 = (720 - this.f31275d) % 360;
                boolean z4 = i13 == 90 || i13 == 270;
                int i14 = z4 ? i12 : i11;
                if (z4) {
                    i12 = i11;
                }
                this.f31274c.a(i6, i7, i13, k.a(j.NORMAL, false, true), ((float) i14) / ((float) i12), z4 ? false : this.f31276e, z4 ? this.f31276e : false);
                if (z4) {
                    this.f31274c.g();
                } else {
                    this.f31274c.h();
                }
            }
            GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
            GLES20.glClear(16640);
            GLES20.glBindFramebuffer(36160, 0);
            this.f31274c.a(i2);
            g();
            if (this.f31273b != null) {
                this.f31273b.c();
            }
        }
    }

    private void g() {
        if (this.j) {
            int i2 = this.h;
            if (i2 != 0) {
                int i3 = this.i;
                if (i3 != 0) {
                    boolean z = i2 <= i3;
                    int i4 = this.i;
                    int i5 = this.h;
                    if (i4 < i5) {
                        i4 = i5;
                    }
                    int i6 = this.i;
                    int i7 = this.h;
                    if (i6 >= i7) {
                        i6 = i7;
                    }
                    if (z) {
                        int i8 = i6;
                        i6 = i4;
                        i4 = i8;
                    }
                    ByteBuffer allocate = ByteBuffer.allocate(i4 * i6 * 4);
                    Bitmap createBitmap = Bitmap.createBitmap(i4, i6, Bitmap.Config.ARGB_8888);
                    allocate.position(0);
                    GLES20.glReadPixels(0, 0, i4, i6, 6408, 5121, allocate);
                    final n nVar = this.k;
                    if (nVar != null) {
                        final ByteBuffer byteBuffer = allocate;
                        final Bitmap bitmap = createBitmap;
                        final int i9 = i4;
                        final int i10 = i6;
                        new Thread(new Runnable() {
                            public void run() {
                                byteBuffer.position(0);
                                bitmap.copyPixelsFromBuffer(byteBuffer);
                                Matrix matrix = new Matrix();
                                matrix.setScale(1.0f, -1.0f);
                                nVar.a(Bitmap.createBitmap(bitmap, 0, 0, i9, i10, matrix, false));
                                bitmap.recycle();
                            }
                        }).start();
                    }
                }
            }
            this.k = null;
            this.j = false;
        }
    }
}
