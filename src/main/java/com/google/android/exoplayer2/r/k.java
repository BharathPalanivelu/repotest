package com.google.android.exoplayer2.r;

import android.os.Handler;
import com.google.android.exoplayer2.r.d;
import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.b;
import com.google.android.exoplayer2.s.p;

public final class k implements d, u<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f11327a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d.a f11328b;

    /* renamed from: c  reason: collision with root package name */
    private final p f11329c;

    /* renamed from: d  reason: collision with root package name */
    private final b f11330d;

    /* renamed from: e  reason: collision with root package name */
    private int f11331e;

    /* renamed from: f  reason: collision with root package name */
    private long f11332f;

    /* renamed from: g  reason: collision with root package name */
    private long f11333g;
    private long h;
    private long i;
    private long j;

    public k() {
        this((Handler) null, (d.a) null);
    }

    public k(Handler handler, d.a aVar) {
        this(handler, aVar, 2000);
    }

    public k(Handler handler, d.a aVar, int i2) {
        this(handler, aVar, i2, b.f11386a);
    }

    public k(Handler handler, d.a aVar, int i2, b bVar) {
        this.f11327a = handler;
        this.f11328b = aVar;
        this.f11329c = new p(i2);
        this.f11330d = bVar;
        this.j = -1;
    }

    public synchronized long a() {
        return this.j;
    }

    public synchronized void a(Object obj, i iVar) {
        if (this.f11331e == 0) {
            this.f11332f = this.f11330d.a();
        }
        this.f11331e++;
    }

    public synchronized void a(Object obj, int i2) {
        this.f11333g += (long) i2;
    }

    public synchronized void a(Object obj) {
        a.b(this.f11331e > 0);
        long a2 = this.f11330d.a();
        int i2 = (int) (a2 - this.f11332f);
        long j2 = (long) i2;
        this.h += j2;
        this.i += this.f11333g;
        if (i2 > 0) {
            this.f11329c.a((int) Math.sqrt((double) this.f11333g), (float) ((this.f11333g * 8000) / j2));
            if (this.h >= 2000 || this.i >= 524288) {
                float a3 = this.f11329c.a(0.5f);
                this.j = Float.isNaN(a3) ? -1 : (long) a3;
            }
        }
        a(i2, this.f11333g, this.j);
        int i3 = this.f11331e - 1;
        this.f11331e = i3;
        if (i3 > 0) {
            this.f11332f = a2;
        }
        this.f11333g = 0;
    }

    private void a(int i2, long j2, long j3) {
        Handler handler = this.f11327a;
        if (handler != null && this.f11328b != null) {
            final int i3 = i2;
            final long j4 = j2;
            final long j5 = j3;
            handler.post(new Runnable() {
                public void run() {
                    k.this.f11328b.a(i3, j4, j5);
                }
            });
        }
    }
}
