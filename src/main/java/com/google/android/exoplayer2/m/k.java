package com.google.android.exoplayer2.m;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.m.d;
import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.n.o;

public final class k implements d, u<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f10778a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d.a f10779b;

    /* renamed from: c  reason: collision with root package name */
    private final o f10780c;

    /* renamed from: d  reason: collision with root package name */
    private int f10781d;

    /* renamed from: e  reason: collision with root package name */
    private long f10782e;

    /* renamed from: f  reason: collision with root package name */
    private long f10783f;

    /* renamed from: g  reason: collision with root package name */
    private long f10784g;
    private long h;
    private long i;

    public k() {
        this((Handler) null, (d.a) null);
    }

    public k(Handler handler, d.a aVar) {
        this(handler, aVar, 2000);
    }

    public k(Handler handler, d.a aVar, int i2) {
        this.f10778a = handler;
        this.f10779b = aVar;
        this.f10780c = new o(i2);
        this.i = -1;
    }

    public synchronized long a() {
        return this.i;
    }

    public synchronized void a(Object obj, i iVar) {
        if (this.f10781d == 0) {
            this.f10782e = SystemClock.elapsedRealtime();
        }
        this.f10781d++;
    }

    public synchronized void a(Object obj, int i2) {
        this.f10783f += (long) i2;
    }

    public synchronized void a(Object obj) {
        a.b(this.f10781d > 0);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = (int) (elapsedRealtime - this.f10782e);
        long j = (long) i2;
        this.f10784g += j;
        this.h += this.f10783f;
        if (i2 > 0) {
            this.f10780c.a((int) Math.sqrt((double) this.f10783f), (float) ((this.f10783f * 8000) / j));
            if (this.f10784g >= 2000 || this.h >= 524288) {
                float a2 = this.f10780c.a(0.5f);
                this.i = Float.isNaN(a2) ? -1 : (long) a2;
            }
        }
        a(i2, this.f10783f, this.i);
        int i3 = this.f10781d - 1;
        this.f10781d = i3;
        if (i3 > 0) {
            this.f10782e = elapsedRealtime;
        }
        this.f10783f = 0;
    }

    private void a(int i2, long j, long j2) {
        Handler handler = this.f10778a;
        if (handler != null && this.f10779b != null) {
            final int i3 = i2;
            final long j3 = j;
            final long j4 = j2;
            handler.post(new Runnable() {
                public void run() {
                    k.this.f10779b.a(i3, j3, j4);
                }
            });
        }
    }
}
