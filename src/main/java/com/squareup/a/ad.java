package com.squareup.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class ad {

    /* renamed from: a  reason: collision with root package name */
    final HandlerThread f30509a = new HandlerThread("Picasso-Stats", 10);

    /* renamed from: b  reason: collision with root package name */
    final d f30510b;

    /* renamed from: c  reason: collision with root package name */
    final Handler f30511c;

    /* renamed from: d  reason: collision with root package name */
    long f30512d;

    /* renamed from: e  reason: collision with root package name */
    long f30513e;

    /* renamed from: f  reason: collision with root package name */
    long f30514f;

    /* renamed from: g  reason: collision with root package name */
    long f30515g;
    long h;
    long i;
    long j;
    long k;
    int l;
    int m;
    int n;

    ad(d dVar) {
        this.f30510b = dVar;
        this.f30509a.start();
        aj.a(this.f30509a.getLooper());
        this.f30511c = new a(this.f30509a.getLooper(), this);
    }

    /* access modifiers changed from: package-private */
    public void a(Bitmap bitmap) {
        a(bitmap, 2);
    }

    /* access modifiers changed from: package-private */
    public void b(Bitmap bitmap) {
        a(bitmap, 3);
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        Handler handler = this.f30511c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j2)));
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f30511c.sendEmptyMessage(0);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f30511c.sendEmptyMessage(1);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f30512d++;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f30513e++;
    }

    /* access modifiers changed from: package-private */
    public void a(Long l2) {
        this.l++;
        this.f30514f += l2.longValue();
        this.i = a(this.l, this.f30514f);
    }

    /* access modifiers changed from: package-private */
    public void b(long j2) {
        this.m++;
        this.f30515g += j2;
        this.j = a(this.m, this.f30515g);
    }

    /* access modifiers changed from: package-private */
    public void c(long j2) {
        this.n++;
        this.h += j2;
        this.k = a(this.m, this.h);
    }

    /* access modifiers changed from: package-private */
    public ae e() {
        return new ae(this.f30510b.b(), this.f30510b.a(), this.f30512d, this.f30513e, this.f30514f, this.f30515g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
    }

    private void a(Bitmap bitmap, int i2) {
        int a2 = aj.a(bitmap);
        Handler handler = this.f30511c;
        handler.sendMessage(handler.obtainMessage(i2, a2, 0));
    }

    private static long a(int i2, long j2) {
        return j2 / ((long) i2);
    }

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final ad f30516a;

        public a(Looper looper, ad adVar) {
            super(looper);
            this.f30516a = adVar;
        }

        public void handleMessage(final Message message) {
            int i = message.what;
            if (i == 0) {
                this.f30516a.c();
            } else if (i == 1) {
                this.f30516a.d();
            } else if (i == 2) {
                this.f30516a.b((long) message.arg1);
            } else if (i == 3) {
                this.f30516a.c((long) message.arg1);
            } else if (i != 4) {
                w.f7153a.post(new Runnable() {
                    public void run() {
                        throw new AssertionError("Unhandled stats message." + message.what);
                    }
                });
            } else {
                this.f30516a.a((Long) message.obj);
            }
        }
    }
}
