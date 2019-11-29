package com.google.android.exoplayer2.j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.ac;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.d.e;
import com.google.android.exoplayer2.n.h;
import com.google.android.exoplayer2.y;
import java.util.Collections;
import java.util.List;

public final class j extends y implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f10624a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10625b;

    /* renamed from: c  reason: collision with root package name */
    private final g f10626c;

    /* renamed from: d  reason: collision with root package name */
    private final ah f10627d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10628e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10629f;

    /* renamed from: g  reason: collision with root package name */
    private int f10630g;
    private com.google.android.exoplayer2.j h;
    private e i;
    private h j;
    private i k;
    private i l;
    private int m;

    public interface a {
        void a(List<a> list);
    }

    public boolean v() {
        return true;
    }

    public j(a aVar, Looper looper) {
        this(aVar, looper, g.f10620a);
    }

    public j(a aVar, Looper looper, g gVar) {
        super(3);
        Handler handler;
        this.f10625b = (a) com.google.android.exoplayer2.n.a.a(aVar);
        if (looper == null) {
            handler = null;
        } else {
            handler = new Handler(looper, this);
        }
        this.f10624a = handler;
        this.f10626c = gVar;
        this.f10627d = new ah();
    }

    public int b(com.google.android.exoplayer2.j jVar) {
        if (this.f10626c.a(jVar)) {
            return 3;
        }
        return h.c(jVar.f10427f) ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void a(com.google.android.exoplayer2.j[] jVarArr) throws ac {
        this.h = jVarArr[0];
        if (this.i != null) {
            this.f10630g = 1;
        } else {
            this.i = this.f10626c.b(this.h);
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z) {
        z();
        this.f10628e = false;
        this.f10629f = false;
        if (this.f10630g != 0) {
            x();
            return;
        }
        t();
        this.i.c();
    }

    public void a(long j2, long j3) throws ac {
        boolean z;
        if (!this.f10629f) {
            if (this.l == null) {
                this.i.a(j2);
                try {
                    this.l = (i) this.i.b();
                } catch (f e2) {
                    throw ac.a(e2, r());
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
                i iVar = this.l;
                if (iVar != null) {
                    if (iVar.c()) {
                        if (!z && y() == Clock.MAX_TIME) {
                            if (this.f10630g == 2) {
                                x();
                            } else {
                                t();
                                this.f10629f = true;
                            }
                        }
                    } else if (this.l.f9283a <= j2) {
                        i iVar2 = this.k;
                        if (iVar2 != null) {
                            iVar2.e();
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
                if (this.f10630g != 2) {
                    while (!this.f10628e) {
                        try {
                            if (this.j == null) {
                                this.j = (h) this.i.a();
                                if (this.j == null) {
                                    return;
                                }
                            }
                            if (this.f10630g == 1) {
                                this.j.a_(4);
                                this.i.a(this.j);
                                this.j = null;
                                this.f10630g = 2;
                                return;
                            }
                            int a2 = a(this.f10627d, (e) this.j, false);
                            if (a2 == -4) {
                                if (this.j.c()) {
                                    this.f10628e = true;
                                } else {
                                    this.j.f10621d = this.f10627d.f9107a.w;
                                    this.j.h();
                                }
                                this.i.a(this.j);
                                this.j = null;
                            } else if (a2 == -3) {
                                return;
                            }
                        } catch (f e3) {
                            throw ac.a(e3, r());
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
        return this.f10629f;
    }

    private void t() {
        this.j = null;
        this.m = -1;
        i iVar = this.k;
        if (iVar != null) {
            iVar.e();
            this.k = null;
        }
        i iVar2 = this.l;
        if (iVar2 != null) {
            iVar2.e();
            this.l = null;
        }
    }

    private void w() {
        t();
        this.i.d();
        this.i = null;
        this.f10630g = 0;
    }

    private void x() {
        w();
        this.i = this.f10626c.b(this.h);
    }

    private long y() {
        int i2 = this.m;
        return (i2 == -1 || i2 >= this.k.i_()) ? Clock.MAX_TIME : this.k.a(this.m);
    }

    private void a(List<a> list) {
        Handler handler = this.f10624a;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            b(list);
        }
    }

    private void z() {
        a((List<a>) Collections.emptyList());
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            b((List<a>) (List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    private void b(List<a> list) {
        this.f10625b.a(list);
    }
}
