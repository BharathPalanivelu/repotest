package com.tencent.liteav.basic.d;

import android.opengl.EGLContext;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import javax.microedition.khronos.egl.EGLConfig;

public class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public int f31303a = 720;

    /* renamed from: b  reason: collision with root package name */
    public int f31304b = 1280;

    /* renamed from: c  reason: collision with root package name */
    public Surface f31305c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31306d = false;

    /* renamed from: e  reason: collision with root package name */
    public EGLContext f31307e = null;

    /* renamed from: f  reason: collision with root package name */
    protected b f31308f = null;

    /* renamed from: g  reason: collision with root package name */
    public javax.microedition.khronos.egl.EGLContext f31309g = null;
    private a h = null;
    private c i = null;

    interface a {
        void c();

        void d();

        void e();
    }

    public static void a(final Handler handler, final HandlerThread handlerThread) {
        if (handler != null && handlerThread != null) {
            Message message = new Message();
            message.what = 101;
            message.obj = new Runnable() {
                public void run() {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            if (handler != null) {
                                handler.removeCallbacksAndMessages((Object) null);
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
            };
            handler.sendMessage(message);
        }
    }

    public f(Looper looper) {
        super(looper);
    }

    public void a(a aVar) {
        this.h = aVar;
    }

    public javax.microedition.khronos.egl.EGLContext a() {
        b bVar = this.f31308f;
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    public Surface b() {
        return this.f31305c;
    }

    public void c() {
        b bVar = this.f31308f;
        if (bVar != null) {
            bVar.a();
        }
        c cVar = this.i;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void handleMessage(Message message) {
        if (message != null) {
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
            }
            if (message != null && message.obj != null) {
                ((Runnable) message.obj).run();
            }
        }
    }

    private void a(Message message) {
        try {
            d();
        } catch (Exception unused) {
            TXCLog.e("TXGLThreadHandler", "surface-render: init egl context exception " + this.f31305c);
            this.f31305c = null;
        }
    }

    private void b(Message message) {
        e();
    }

    private void c(Message message) {
        try {
            if (this.h != null) {
                this.h.d();
            }
        } catch (Exception e2) {
            TXCLog.e("TXGLThreadHandler", "onMsgRend Exception " + e2.getMessage());
            e2.printStackTrace();
        }
    }

    private boolean d() {
        TXCLog.d("TXGLThreadHandler", String.format("init egl size[%d/%d]", new Object[]{Integer.valueOf(this.f31303a), Integer.valueOf(this.f31304b)}));
        if (!this.f31306d) {
            this.f31308f = b.a((EGLConfig) null, this.f31309g, this.f31305c, this.f31303a, this.f31304b);
        } else {
            this.i = c.a((android.opengl.EGLConfig) null, this.f31307e, this.f31305c, this.f31303a, this.f31304b);
        }
        if (this.f31308f == null && this.i == null) {
            return false;
        }
        TXCLog.w("TXGLThreadHandler", "surface-render: create egl context " + this.f31305c);
        a aVar = this.h;
        if (aVar != null) {
            aVar.c();
        }
        return true;
    }

    private void e() {
        TXCLog.w("TXGLThreadHandler", "surface-render: destroy egl context " + this.f31305c);
        a aVar = this.h;
        if (aVar != null) {
            aVar.e();
        }
        b bVar = this.f31308f;
        if (bVar != null) {
            bVar.b();
            this.f31308f = null;
        }
        c cVar = this.i;
        if (cVar != null) {
            cVar.b();
            this.i = null;
        }
        this.f31305c = null;
    }
}
