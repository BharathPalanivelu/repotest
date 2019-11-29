package com.google.android.exoplayer2.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.ac;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.d.e;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.y;
import java.util.Arrays;

public final class f extends y implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final d f9856a;

    /* renamed from: b  reason: collision with root package name */
    private final a f9857b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f9858c;

    /* renamed from: d  reason: collision with root package name */
    private final ah f9859d;

    /* renamed from: e  reason: collision with root package name */
    private final e f9860e;

    /* renamed from: f  reason: collision with root package name */
    private final a[] f9861f;

    /* renamed from: g  reason: collision with root package name */
    private final long[] f9862g;
    private int h;
    private int i;
    private b j;
    private boolean k;

    public interface a {
        void onMetadata(a aVar);
    }

    public boolean v() {
        return true;
    }

    public f(a aVar, Looper looper) {
        this(aVar, looper, d.f9854a);
    }

    public f(a aVar, Looper looper, d dVar) {
        super(4);
        Handler handler;
        this.f9857b = (a) com.google.android.exoplayer2.n.a.a(aVar);
        if (looper == null) {
            handler = null;
        } else {
            handler = new Handler(looper, this);
        }
        this.f9858c = handler;
        this.f9856a = (d) com.google.android.exoplayer2.n.a.a(dVar);
        this.f9859d = new ah();
        this.f9860e = new e();
        this.f9861f = new a[5];
        this.f9862g = new long[5];
    }

    public int b(j jVar) {
        return this.f9856a.a(jVar) ? 3 : 0;
    }

    /* access modifiers changed from: protected */
    public void a(j[] jVarArr) throws ac {
        this.j = this.f9856a.b(jVarArr[0]);
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z) {
        t();
        this.k = false;
    }

    public void a(long j2, long j3) throws ac {
        if (!this.k && this.i < 5) {
            this.f9860e.a();
            if (a(this.f9859d, (e) this.f9860e, false) == -4) {
                if (this.f9860e.c()) {
                    this.k = true;
                } else if (!this.f9860e.b()) {
                    this.f9860e.f9855d = this.f9859d.f9107a.w;
                    this.f9860e.h();
                    try {
                        int i2 = (this.h + this.i) % 5;
                        this.f9861f[i2] = this.j.a(this.f9860e);
                        this.f9862g[i2] = this.f9860e.f9281c;
                        this.i++;
                    } catch (c e2) {
                        throw ac.a(e2, r());
                    }
                }
            }
        }
        if (this.i > 0) {
            long[] jArr = this.f9862g;
            int i3 = this.h;
            if (jArr[i3] <= j2) {
                a(this.f9861f[i3]);
                a[] aVarArr = this.f9861f;
                int i4 = this.h;
                aVarArr[i4] = null;
                this.h = (i4 + 1) % 5;
                this.i--;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        t();
        this.j = null;
    }

    public boolean u() {
        return this.k;
    }

    private void a(a aVar) {
        Handler handler = this.f9858c;
        if (handler != null) {
            handler.obtainMessage(0, aVar).sendToTarget();
        } else {
            b(aVar);
        }
    }

    private void t() {
        Arrays.fill(this.f9861f, (Object) null);
        this.h = 0;
        this.i = 0;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            b((a) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    private void b(a aVar) {
        this.f9857b.onMetadata(aVar);
    }
}
