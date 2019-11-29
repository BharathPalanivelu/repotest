package com.google.android.exoplayer2.p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.s.i;
import java.util.Collections;
import java.util.List;

public final class k extends com.google.android.exoplayer2.a implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f11229a;

    /* renamed from: b  reason: collision with root package name */
    private final a f11230b;

    /* renamed from: c  reason: collision with root package name */
    private final h f11231c;

    /* renamed from: d  reason: collision with root package name */
    private final l f11232d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11233e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11234f;

    /* renamed from: g  reason: collision with root package name */
    private int f11235g;
    private Format h;
    private f i;
    private i j;
    private j k;
    private j l;
    private int m;

    public interface a {
        void a(List<b> list);
    }

    public boolean t() {
        return true;
    }

    public k(a aVar, Looper looper) {
        this(aVar, looper, h.f11225a);
    }

    public k(a aVar, Looper looper, h hVar) {
        super(3);
        Handler handler;
        this.f11230b = (a) com.google.android.exoplayer2.s.a.a(aVar);
        if (looper == null) {
            handler = null;
        } else {
            handler = new Handler(looper, this);
        }
        this.f11229a = handler;
        this.f11231c = hVar;
        this.f11232d = new l();
    }

    public int a(Format format) {
        if (this.f11231c.a(format)) {
            return 4;
        }
        return i.c(format.f8958f) ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void a(Format[] formatArr, long j2) throws e {
        this.h = formatArr[0];
        if (this.i != null) {
            this.f11235g = 1;
        } else {
            this.i = this.f11231c.b(this.h);
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z) {
        z();
        this.f11233e = false;
        this.f11234f = false;
        if (this.f11235g != 0) {
            x();
            return;
        }
        v();
        this.i.c();
    }

    public void a(long j2, long j3) throws e {
        boolean z;
        if (!this.f11234f) {
            if (this.l == null) {
                this.i.a(j2);
                try {
                    this.l = (j) this.i.b();
                } catch (g e2) {
                    throw e.a(e2, r());
                }
            }
            if (d() == 2) {
                if (this.k != null) {
                    long y = y();
                    z = false;
                    while (y <= j2) {
                        this.m++;
                        y = y();
                        z = true;
                    }
                } else {
                    z = false;
                }
                j jVar = this.l;
                if (jVar != null) {
                    if (jVar.c()) {
                        if (!z && y() == Clock.MAX_TIME) {
                            if (this.f11235g == 2) {
                                x();
                            } else {
                                v();
                                this.f11234f = true;
                            }
                        }
                    } else if (this.l.f9884a <= j2) {
                        j jVar2 = this.k;
                        if (jVar2 != null) {
                            jVar2.e();
                        }
                        this.k = this.l;
                        this.l = null;
                        this.m = this.k.a(j2);
                        z = true;
                    }
                }
                if (z) {
                    a(this.k.b(j2));
                }
                if (this.f11235g != 2) {
                    while (!this.f11233e) {
                        try {
                            if (this.j == null) {
                                this.j = (i) this.i.a();
                                if (this.j == null) {
                                    return;
                                }
                            }
                            if (this.f11235g == 1) {
                                this.j.b_(4);
                                this.i.a(this.j);
                                this.j = null;
                                this.f11235g = 2;
                                return;
                            }
                            int a2 = a(this.f11232d, (com.google.android.exoplayer2.g.e) this.j, false);
                            if (a2 == -4) {
                                if (this.j.c()) {
                                    this.f11233e = true;
                                } else {
                                    this.j.f11226d = this.f11232d.f10690a.w;
                                    this.j.h();
                                }
                                this.i.a(this.j);
                                this.j = null;
                            } else if (a2 == -3) {
                                return;
                            }
                        } catch (g e3) {
                            throw e.a(e3, r());
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        this.h = null;
        z();
        w();
    }

    public boolean u() {
        return this.f11234f;
    }

    private void v() {
        this.j = null;
        this.m = -1;
        j jVar = this.k;
        if (jVar != null) {
            jVar.e();
            this.k = null;
        }
        j jVar2 = this.l;
        if (jVar2 != null) {
            jVar2.e();
            this.l = null;
        }
    }

    private void w() {
        v();
        this.i.d();
        this.i = null;
        this.f11235g = 0;
    }

    private void x() {
        w();
        this.i = this.f11231c.b(this.h);
    }

    private long y() {
        int i2 = this.m;
        return (i2 == -1 || i2 >= this.k.b()) ? Clock.MAX_TIME : this.k.a(this.m);
    }

    private void a(List<b> list) {
        Handler handler = this.f11229a;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            b(list);
        }
    }

    private void z() {
        a((List<b>) Collections.emptyList());
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            b((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    private void b(List<b> list) {
        this.f11230b.a(list);
    }
}
