package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.l;
import java.util.Arrays;

public final class e extends com.google.android.exoplayer2.a implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final c f10837a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10838b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f10839c;

    /* renamed from: d  reason: collision with root package name */
    private final l f10840d;

    /* renamed from: e  reason: collision with root package name */
    private final d f10841e;

    /* renamed from: f  reason: collision with root package name */
    private final Metadata[] f10842f;

    /* renamed from: g  reason: collision with root package name */
    private final long[] f10843g;
    private int h;
    private int i;
    private a j;
    private boolean k;

    public interface a {
        void a(Metadata metadata);
    }

    public boolean t() {
        return true;
    }

    public e(a aVar, Looper looper) {
        this(aVar, looper, c.f10835a);
    }

    public e(a aVar, Looper looper, c cVar) {
        super(4);
        Handler handler;
        this.f10838b = (a) com.google.android.exoplayer2.s.a.a(aVar);
        if (looper == null) {
            handler = null;
        } else {
            handler = new Handler(looper, this);
        }
        this.f10839c = handler;
        this.f10837a = (c) com.google.android.exoplayer2.s.a.a(cVar);
        this.f10840d = new l();
        this.f10841e = new d();
        this.f10842f = new Metadata[5];
        this.f10843g = new long[5];
    }

    public int a(Format format) {
        return this.f10837a.a(format) ? 4 : 0;
    }

    /* access modifiers changed from: protected */
    public void a(Format[] formatArr, long j2) throws com.google.android.exoplayer2.e {
        this.j = this.f10837a.b(formatArr[0]);
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z) {
        v();
        this.k = false;
    }

    public void a(long j2, long j3) throws com.google.android.exoplayer2.e {
        if (!this.k && this.i < 5) {
            this.f10841e.a();
            if (a(this.f10840d, (com.google.android.exoplayer2.g.e) this.f10841e, false) == -4) {
                if (this.f10841e.c()) {
                    this.k = true;
                } else if (!this.f10841e.l_()) {
                    this.f10841e.f10836d = this.f10840d.f10690a.w;
                    this.f10841e.h();
                    try {
                        int i2 = (this.h + this.i) % 5;
                        this.f10842f[i2] = this.j.a(this.f10841e);
                        this.f10843g[i2] = this.f10841e.f9882c;
                        this.i++;
                    } catch (b e2) {
                        throw com.google.android.exoplayer2.e.a(e2, r());
                    }
                }
            }
        }
        if (this.i > 0) {
            long[] jArr = this.f10843g;
            int i3 = this.h;
            if (jArr[i3] <= j2) {
                a(this.f10842f[i3]);
                Metadata[] metadataArr = this.f10842f;
                int i4 = this.h;
                metadataArr[i4] = null;
                this.h = (i4 + 1) % 5;
                this.i--;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        v();
        this.j = null;
    }

    public boolean u() {
        return this.k;
    }

    private void a(Metadata metadata) {
        Handler handler = this.f10839c;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            b(metadata);
        }
    }

    private void v() {
        Arrays.fill(this.f10842f, (Object) null);
        this.h = 0;
        this.i = 0;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            b((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    private void b(Metadata metadata) {
        this.f10838b.a(metadata);
    }
}
