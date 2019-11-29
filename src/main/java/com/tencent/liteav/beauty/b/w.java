package com.tencent.liteav.beauty.b;

import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Handler;
import android.os.Looper;

public class w {

    /* renamed from: b  reason: collision with root package name */
    private static final String f31506b = "w";

    /* renamed from: a  reason: collision with root package name */
    SurfaceTexture.OnFrameAvailableListener f31507a;

    /* renamed from: c  reason: collision with root package name */
    private SurfaceTexture f31508c;

    /* renamed from: d  reason: collision with root package name */
    private int f31509d = -1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31510e = false;

    /* renamed from: f  reason: collision with root package name */
    private MediaExtractor f31511f;

    /* renamed from: g  reason: collision with root package name */
    private AssetFileDescriptor f31512g;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private int k = -1;
    private long l;
    private MediaCodec m;
    private boolean n = false;
    private boolean o;
    private Handler p;
    /* access modifiers changed from: private */
    public Object q = new Object();

    w() {
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        synchronized (this.q) {
            if (this.p != null) {
                if (Looper.myLooper() == this.p.getLooper()) {
                    c();
                } else {
                    AnonymousClass1 r1 = new Runnable() {
                        public void run() {
                            synchronized (w.this.q) {
                                w.this.c();
                                w.this.q.notify();
                            }
                        }
                    };
                    this.p.removeCallbacksAndMessages((Object) null);
                    this.p.post(r1);
                    this.p.getLooper().quitSafely();
                    while (true) {
                        try {
                            this.q.wait();
                            break;
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private void b() {
        if (this.f31510e) {
            this.f31510e = false;
            MediaExtractor mediaExtractor = this.f31511f;
            if (mediaExtractor != null) {
                mediaExtractor.release();
                this.f31511f = null;
            }
            try {
                this.m.stop();
                try {
                    this.m.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                } catch (Throwable th) {
                    this.m = null;
                    throw th;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                try {
                    this.m.release();
                } catch (Exception e4) {
                    e4.printStackTrace();
                } catch (Throwable th2) {
                    this.m = null;
                    throw th2;
                }
            } catch (Throwable th3) {
                try {
                    this.m.release();
                } catch (Exception e5) {
                    e5.printStackTrace();
                } catch (Throwable th4) {
                    this.m = null;
                    throw th4;
                }
                this.m = null;
                throw th3;
            }
            this.m = null;
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        b();
        this.f31507a = null;
        this.l = 0;
        this.o = false;
        SurfaceTexture surfaceTexture = this.f31508c;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f31508c = null;
        }
        synchronized (this.q) {
            if (this.p != null) {
                this.p.removeCallbacksAndMessages((Object) null);
                this.p.getLooper().quit();
                this.p = null;
                this.q.notify();
            }
        }
        AssetFileDescriptor assetFileDescriptor = this.f31512g;
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f31512g = null;
        }
    }
}
