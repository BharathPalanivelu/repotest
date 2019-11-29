package com.tencent.liteav.screencapture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.d.i;
import com.tencent.liteav.basic.d.j;
import com.tencent.liteav.basic.d.k;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.screencapture.b;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected Handler f31962a = null;

    /* renamed from: b  reason: collision with root package name */
    protected volatile HandlerThread f31963b = null;

    /* renamed from: c  reason: collision with root package name */
    protected volatile C0491a f31964c = null;

    /* renamed from: d  reason: collision with root package name */
    protected volatile WeakReference<c> f31965d = null;

    /* renamed from: e  reason: collision with root package name */
    protected volatile int f31966e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected int f31967f = 720;

    /* renamed from: g  reason: collision with root package name */
    protected int f31968g = 1280;
    protected int h = 20;
    protected boolean i = false;
    /* access modifiers changed from: private */
    public Object j = null;
    private boolean k = false;
    /* access modifiers changed from: private */
    public int l = this.f31967f;
    /* access modifiers changed from: private */
    public int m = this.f31968g;
    private Context n = null;
    private b.a o = new b.a() {
        public void a(int i) {
            a.this.b(i);
            a aVar = a.this;
            aVar.b(105, aVar.l, a.this.m);
        }
    };

    public a(Context context, boolean z) {
        this.n = context;
        this.f31962a = new Handler(Looper.getMainLooper());
        this.k = z;
        if (Build.VERSION.SDK_INT >= 21) {
            b.a().a(context);
        }
    }

    public int a(int i2, int i3, int i4) {
        int i5;
        if (this.k) {
            i5 = ((WindowManager) this.n.getSystemService("window")).getDefaultDisplay().getRotation();
            if (i5 == 0 || i5 == 2) {
                if (i2 > i3) {
                    this.f31967f = i3;
                    this.f31968g = i2;
                } else {
                    this.f31967f = i2;
                    this.f31968g = i3;
                }
            } else if (i2 < i3) {
                this.f31967f = i3;
                this.f31968g = i2;
            } else {
                this.f31967f = i2;
                this.f31968g = i3;
            }
        } else {
            this.f31967f = i2;
            this.f31968g = i3;
            i5 = 0;
        }
        TXCLog.d("ScreenCapture", String.format("start screen capture orientation[%d] input size[%d/%d] output size[%d/%d]", new Object[]{Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.f31967f), Integer.valueOf(this.f31968g)}));
        this.h = i4;
        if (Build.VERSION.SDK_INT < 21) {
            a(20000004, (EGLContext) null);
            return 20000004;
        }
        this.l = this.f31967f;
        this.m = this.f31968g;
        a();
        if (this.k) {
            b.a().a(this.o);
        }
        return 0;
    }

    public void a(Object obj) {
        b.a().b(this.o);
        this.j = obj;
        b();
    }

    public void a(final boolean z) {
        synchronized (this) {
            if (this.f31964c != null) {
                this.f31964c.post(new Runnable() {
                    public void run() {
                        a.this.i = z;
                    }
                });
            } else {
                this.i = z;
            }
        }
    }

    public void a(c cVar) {
        this.f31965d = new WeakReference<>(cVar);
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        b.a().a(aVar);
    }

    public synchronized void a(Runnable runnable) {
        if (this.f31964c != null) {
            this.f31964c.post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        b();
        synchronized (this) {
            this.f31963b = new HandlerThread("ScreenCaptureGLThread");
            this.f31963b.start();
            this.f31964c = new C0491a(this.f31963b.getLooper(), this);
            int i2 = 1;
            this.f31966e++;
            this.f31964c.f31976a = this.f31966e;
            this.f31964c.f31980e = this.l;
            this.f31964c.f31981f = this.m;
            C0491a aVar = this.f31964c;
            if (this.h >= 1) {
                i2 = this.h;
            }
            aVar.f31982g = i2;
        }
        a(100);
    }

    /* access modifiers changed from: protected */
    public void b() {
        synchronized (this) {
            this.f31966e++;
            if (this.f31964c != null) {
                final HandlerThread handlerThread = this.f31963b;
                final C0491a aVar = this.f31964c;
                a(101, (Runnable) new Runnable() {
                    public void run() {
                        a.this.f31962a.post(new Runnable() {
                            public void run() {
                                if (aVar != null) {
                                    aVar.removeCallbacksAndMessages((Object) null);
                                }
                                if (handlerThread == null) {
                                    return;
                                }
                                if (Build.VERSION.SDK_INT >= 18) {
                                    handlerThread.quitSafely();
                                } else {
                                    handlerThread.quit();
                                }
                            }
                        });
                    }
                });
            }
            this.f31964c = null;
            this.f31963b = null;
        }
    }

    /* access modifiers changed from: protected */
    public c c() {
        if (this.f31965d == null) {
            return null;
        }
        return (c) this.f31965d.get();
    }

    /* access modifiers changed from: protected */
    public void a(int i2, long j2) {
        synchronized (this) {
            if (this.f31964c != null) {
                this.f31964c.sendEmptyMessageDelayed(i2, j2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        synchronized (this) {
            if (this.f31964c != null) {
                this.f31964c.sendEmptyMessage(i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3, int i4) {
        synchronized (this) {
            if (this.f31964c != null) {
                Message message = new Message();
                message.what = i2;
                message.arg1 = i3;
                message.arg2 = i4;
                this.f31964c.sendMessage(message);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, Runnable runnable) {
        synchronized (this) {
            if (this.f31964c != null) {
                Message message = new Message();
                message.what = i2;
                message.obj = runnable;
                this.f31964c.sendMessage(message);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, EGLContext eGLContext) {
        c c2 = c();
        if (c2 != null) {
            c2.a(i2, eGLContext);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, int i4, int i5, long j2) {
        c c2 = c();
        if (c2 != null) {
            c2.a(i2, i3, i4, i5, j2);
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i2) {
        if (i2 == 0) {
            int i3 = this.f31967f;
            int i4 = this.f31968g;
            if (i3 >= i4) {
                i3 = i4;
            }
            this.l = i3;
            int i5 = this.f31967f;
            int i6 = this.f31968g;
            if (i5 < i6) {
                i5 = i6;
            }
            this.m = i5;
        } else {
            int i7 = this.f31967f;
            int i8 = this.f31968g;
            if (i7 < i8) {
                i7 = i8;
            }
            this.l = i7;
            int i9 = this.f31967f;
            int i10 = this.f31968g;
            if (i9 >= i10) {
                i9 = i10;
            }
            this.m = i9;
        }
        TXCLog.d("ScreenCapture", String.format("reset screen capture angle[%d] output size[%d/%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.l), Integer.valueOf(this.m)}));
    }

    /* renamed from: com.tencent.liteav.screencapture.a$a  reason: collision with other inner class name */
    protected class C0491a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public int f31976a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int[] f31977b = null;

        /* renamed from: c  reason: collision with root package name */
        public Surface f31978c = null;

        /* renamed from: d  reason: collision with root package name */
        public SurfaceTexture f31979d = null;

        /* renamed from: e  reason: collision with root package name */
        public int f31980e = 720;

        /* renamed from: f  reason: collision with root package name */
        public int f31981f = 1280;

        /* renamed from: g  reason: collision with root package name */
        public int f31982g = 25;
        protected boolean h = false;
        protected long i = 0;
        protected long j = 0;
        protected com.tencent.liteav.basic.d.b k = null;
        protected h l = null;
        float[] m = new float[16];

        public C0491a(Looper looper, a aVar) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message != null) {
                if (this.f31976a == a.this.f31966e || 101 == message.what) {
                    switch (message.what) {
                        case 100:
                            a(message);
                            break;
                        case 101:
                            b(message);
                            break;
                        case 102:
                            try {
                                c(message);
                                break;
                            } catch (Exception unused) {
                                break;
                            }
                        case 103:
                            d(message);
                            break;
                        case 105:
                            e(message);
                            break;
                    }
                    if (message != null && message.obj != null) {
                        ((Runnable) message.obj).run();
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public void a(Message message) {
            this.i = 0;
            this.j = 0;
            if (!a()) {
                b();
                a.this.b();
                a.this.a(20000003, (EGLContext) null);
                return;
            }
            a.this.a(0, this.k.c());
        }

        /* access modifiers changed from: protected */
        public void b(Message message) {
            c c2 = a.this.c();
            if (c2 != null) {
                c2.a(a.this.j);
            }
            b();
        }

        /* access modifiers changed from: protected */
        public void c(Message message) {
            a.this.a(102, 5);
            if (a.this.i) {
                if (!this.h) {
                    this.i = 0;
                    this.j = System.nanoTime();
                    return;
                }
                long nanoTime = System.nanoTime();
                long j2 = this.j;
                if (nanoTime >= ((((this.i * 1000) * 1000) * 1000) / ((long) this.f31982g)) + j2) {
                    if (j2 == 0) {
                        this.j = nanoTime;
                    } else if (nanoTime > j2 + 1000000000) {
                        this.i = 0;
                        this.j = nanoTime;
                    }
                    this.i++;
                    SurfaceTexture surfaceTexture = this.f31979d;
                    if (surfaceTexture != null && this.f31977b != null) {
                        surfaceTexture.getTransformMatrix(this.m);
                        try {
                            this.f31979d.updateTexImage();
                        } catch (Exception e2) {
                            TXCLog.e("ScreenCapture", "onMsgRend Exception " + e2.getMessage());
                            e2.printStackTrace();
                        }
                        this.l.a(this.m);
                        GLES20.glViewport(0, 0, this.f31980e, this.f31981f);
                        a.this.a(0, this.l.b(this.f31977b[0]), this.f31980e, this.f31981f, TXCTimeUtil.getTimeTick());
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public void d(Message message) {
            if (message != null) {
                int i2 = 1;
                if (message.arg1 >= 1) {
                    i2 = message.arg1;
                }
                this.f31982g = i2;
                this.i = 0;
                this.j = 0;
            }
        }

        /* access modifiers changed from: protected */
        public void e(Message message) {
            if (message != null) {
                this.f31980e = message.arg1;
                this.f31981f = message.arg2;
                c();
                this.l.a(this.f31980e, this.f31981f);
                d();
                TXCLog.d("ScreenCapture", String.format("set screen capture size[%d/%d]", new Object[]{Integer.valueOf(a.this.l), Integer.valueOf(a.this.m)}));
            }
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            TXCLog.d("ScreenCapture", String.format("init egl size[%d/%d]", new Object[]{Integer.valueOf(this.f31980e), Integer.valueOf(this.f31981f)}));
            this.k = com.tencent.liteav.basic.d.b.a((EGLConfig) null, (EGLContext) null, (Surface) null, this.f31980e, this.f31981f);
            if (this.k == null) {
                return false;
            }
            this.l = new h();
            if (!this.l.a()) {
                return false;
            }
            this.l.a(true);
            this.l.a(this.f31980e, this.f31981f);
            this.l.a(k.f31351e, k.a(j.NORMAL, false, false));
            d();
            return true;
        }

        /* access modifiers changed from: protected */
        public void b() {
            c();
            h hVar = this.l;
            if (hVar != null) {
                hVar.d();
                this.l = null;
            }
            com.tencent.liteav.basic.d.b bVar = this.k;
            if (bVar != null) {
                bVar.b();
                this.k = null;
            }
        }

        /* access modifiers changed from: protected */
        public void c() {
            SurfaceTexture surfaceTexture = this.f31979d;
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                this.f31979d.release();
                this.h = false;
                this.f31979d = null;
            }
            b.a().a(this.f31978c);
            Surface surface = this.f31978c;
            if (surface != null) {
                surface.release();
                this.f31978c = null;
            }
            int[] iArr = this.f31977b;
            if (iArr != null) {
                GLES20.glDeleteTextures(1, iArr, 0);
                this.f31977b = null;
            }
        }

        /* access modifiers changed from: protected */
        public void d() {
            this.f31977b = new int[1];
            this.f31977b[0] = i.b();
            int[] iArr = this.f31977b;
            if (iArr[0] <= 0) {
                this.f31977b = null;
                return;
            }
            this.f31979d = new SurfaceTexture(iArr[0]);
            this.f31978c = new Surface(this.f31979d);
            this.f31979d.setDefaultBufferSize(this.f31980e, this.f31981f);
            this.f31979d.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    a.this.a(104, (Runnable) new Runnable() {
                        public void run() {
                            C0491a.this.h = true;
                            a.this.a(102);
                        }
                    });
                    surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                }
            });
            b.a().a(this.f31978c, this.f31980e, this.f31981f);
        }
    }
}
