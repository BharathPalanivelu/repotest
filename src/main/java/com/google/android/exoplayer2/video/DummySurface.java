package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.s.v;

@TargetApi(17)
public final class DummySurface extends Surface {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f12222b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f12223c;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f12224a;

    /* renamed from: d  reason: collision with root package name */
    private final a f12225d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12226e;

    public static synchronized boolean a(Context context) {
        boolean z;
        synchronized (DummySurface.class) {
            if (!f12223c) {
                if (v.f11449a >= 17) {
                    boolean z2 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content") && !b(context)) {
                        z2 = true;
                    }
                    f12222b = z2;
                }
                f12223c = true;
            }
            z = f12222b;
        }
        return z;
    }

    public static DummySurface a(Context context, boolean z) {
        a();
        com.google.android.exoplayer2.s.a.b(!z || a(context));
        return new a().a(z);
    }

    private DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f12225d = aVar;
        this.f12224a = z;
    }

    public void release() {
        super.release();
        synchronized (this.f12225d) {
            if (!this.f12226e) {
                this.f12225d.a();
                this.f12226e = true;
            }
        }
    }

    private static void a() {
        if (v.f11449a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    private static boolean b(Context context) {
        return v.f11449a == 24 && (v.f11452d.startsWith("SM-G950") || v.f11452d.startsWith("SM-G955")) && !a(context.getPackageManager());
    }

    @TargetApi(24)
    private static boolean a(PackageManager packageManager) {
        return packageManager.hasSystemFeature("android.hardware.vr.high_performance");
    }

    private static class a extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f12227a = new int[1];

        /* renamed from: b  reason: collision with root package name */
        private Handler f12228b;

        /* renamed from: c  reason: collision with root package name */
        private SurfaceTexture f12229c;

        /* renamed from: d  reason: collision with root package name */
        private Error f12230d;

        /* renamed from: e  reason: collision with root package name */
        private RuntimeException f12231e;

        /* renamed from: f  reason: collision with root package name */
        private DummySurface f12232f;

        public a() {
            super("dummySurface");
        }

        public DummySurface a(boolean z) {
            boolean z2;
            start();
            this.f12228b = new Handler(getLooper(), this);
            synchronized (this) {
                z2 = false;
                this.f12228b.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
                while (this.f12232f == null && this.f12231e == null && this.f12230d == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f12231e;
            if (runtimeException == null) {
                Error error = this.f12230d;
                if (error == null) {
                    return this.f12232f;
                }
                throw error;
            }
            throw runtimeException;
        }

        public void a() {
            this.f12228b.sendEmptyMessage(3);
        }

        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.f12228b.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                try {
                    b(message.arg1 != 0);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                    this.f12231e = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e3) {
                    try {
                        Log.e("DummySurface", "Failed to initialize dummy surface", e3);
                        this.f12230d = e3;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                            throw th;
                        }
                    }
                }
                return true;
            } else if (i == 2) {
                this.f12229c.updateTexImage();
                return true;
            } else if (i != 3) {
                return true;
            } else {
                try {
                    b();
                } catch (Throwable th2) {
                    quit();
                    throw th2;
                }
                quit();
                return true;
            }
        }

        private void b(boolean z) {
            int[] iArr;
            int[] iArr2;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            com.google.android.exoplayer2.s.a.b(eglGetDisplay != null, "eglGetDisplay failed");
            int[] iArr3 = new int[2];
            com.google.android.exoplayer2.s.a.b(EGL14.eglInitialize(eglGetDisplay, iArr3, 0, iArr3, 1), "eglInitialize failed");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr4 = new int[1];
            com.google.android.exoplayer2.s.a.b(EGL14.eglChooseConfig(eglGetDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr4, 0) && iArr4[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (z) {
                iArr = new int[]{12440, 2, 12992, 1, 12344};
            } else {
                iArr = new int[]{12440, 2, 12344};
            }
            EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
            com.google.android.exoplayer2.s.a.b(eglCreateContext != null, "eglCreateContext failed");
            if (z) {
                iArr2 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
            } else {
                iArr2 = new int[]{12375, 1, 12374, 1, 12344};
            }
            EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, iArr2, 0);
            com.google.android.exoplayer2.s.a.b(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
            com.google.android.exoplayer2.s.a.b(EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext), "eglMakeCurrent failed");
            GLES20.glGenTextures(1, this.f12227a, 0);
            this.f12229c = new SurfaceTexture(this.f12227a[0]);
            this.f12229c.setOnFrameAvailableListener(this);
            this.f12232f = new DummySurface(this, this.f12229c, z);
        }

        private void b() {
            try {
                this.f12229c.release();
            } finally {
                this.f12232f = null;
                this.f12229c = null;
                GLES20.glDeleteTextures(1, this.f12227a, 0);
            }
        }
    }
}
