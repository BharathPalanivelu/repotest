package com.c.a.c.d.e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.c.a.c.b.a.e;
import com.c.a.c.m;
import com.c.a.i;
import com.c.a.i.h;
import com.c.a.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class g {

    /* renamed from: a  reason: collision with root package name */
    final j f6080a;

    /* renamed from: b  reason: collision with root package name */
    private final com.c.a.b.a f6081b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f6082c;

    /* renamed from: d  reason: collision with root package name */
    private final List<b> f6083d;

    /* renamed from: e  reason: collision with root package name */
    private final e f6084e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6085f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6086g;
    private boolean h;
    private i<Bitmap> i;
    private a j;
    private boolean k;
    private a l;
    private Bitmap m;
    private m<Bitmap> n;
    private a o;
    private d p;

    public interface b {
        void f();
    }

    interface d {
        void a();
    }

    public g(com.c.a.c cVar, com.c.a.b.a aVar, int i2, int i3, m<Bitmap> mVar, Bitmap bitmap) {
        this(cVar.a(), com.c.a.c.b(cVar.c()), aVar, (Handler) null, a(com.c.a.c.b(cVar.c()), i2, i3), mVar, bitmap);
    }

    g(e eVar, j jVar, com.c.a.b.a aVar, Handler handler, i<Bitmap> iVar, m<Bitmap> mVar, Bitmap bitmap) {
        this.f6083d = new ArrayList();
        this.f6085f = false;
        this.f6086g = false;
        this.h = false;
        this.f6080a = jVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f6084e = eVar;
        this.f6082c = handler;
        this.i = iVar;
        this.f6081b = aVar;
        a(mVar, bitmap);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.c.a.c.m<android.graphics.Bitmap>, java.lang.Object, com.c.a.c.m] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.c.a.c.m<android.graphics.Bitmap> r2, android.graphics.Bitmap r3) {
        /*
            r1 = this;
            java.lang.Object r0 = com.c.a.i.h.a(r2)
            com.c.a.c.m r0 = (com.c.a.c.m) r0
            r1.n = r0
            java.lang.Object r3 = com.c.a.i.h.a(r3)
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3
            r1.m = r3
            com.c.a.i<android.graphics.Bitmap> r3 = r1.i
            com.c.a.g.g r0 = new com.c.a.g.g
            r0.<init>()
            com.c.a.g.g r2 = r0.a((com.c.a.c.m<android.graphics.Bitmap>) r2)
            com.c.a.i r2 = r3.a((com.c.a.g.g) r2)
            r1.i = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.d.e.g.a(com.c.a.c.m, android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: package-private */
    public Bitmap a() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        if (!this.k) {
            boolean isEmpty = this.f6083d.isEmpty();
            if (!this.f6083d.contains(bVar)) {
                this.f6083d.add(bVar);
                if (isEmpty) {
                    k();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    /* access modifiers changed from: package-private */
    public void b(b bVar) {
        this.f6083d.remove(bVar);
        if (this.f6083d.isEmpty()) {
            l();
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return i().getWidth();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return i().getHeight();
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f6081b.g() + j();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.f6087a;
        }
        return -1;
    }

    private int j() {
        return com.c.a.i.i.a(i().getWidth(), i().getHeight(), i().getConfig());
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer f() {
        return this.f6081b.a().asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f6081b.d();
    }

    private void k() {
        if (!this.f6085f) {
            this.f6085f = true;
            this.k = false;
            m();
        }
    }

    private void l() {
        this.f6085f = false;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.f6083d.clear();
        n();
        l();
        a aVar = this.j;
        if (aVar != null) {
            this.f6080a.a((com.c.a.g.a.e<?>) aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.f6080a.a((com.c.a.g.a.e<?>) aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f6080a.a((com.c.a.g.a.e<?>) aVar3);
            this.o = null;
        }
        this.f6081b.i();
        this.k = true;
    }

    /* access modifiers changed from: package-private */
    public Bitmap i() {
        a aVar = this.j;
        return aVar != null ? aVar.g_() : this.m;
    }

    private void m() {
        if (this.f6085f && !this.f6086g) {
            if (this.h) {
                h.a(this.o == null, "Pending target must be null when starting from the first frame");
                this.f6081b.f();
                this.h = false;
            }
            a aVar = this.o;
            if (aVar != null) {
                this.o = null;
                a(aVar);
                return;
            }
            this.f6086g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f6081b.c());
            this.f6081b.b();
            this.l = new a(this.f6082c, this.f6081b.e(), uptimeMillis);
            this.i.a(com.c.a.g.g.a(o())).a((Object) this.f6081b).a(this.l);
        }
    }

    private void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f6084e.a(bitmap);
            this.m = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.f6086g = false;
        if (this.k) {
            this.f6082c.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f6085f) {
            this.o = aVar;
        } else {
            if (aVar.g_() != null) {
                n();
                a aVar2 = this.j;
                this.j = aVar;
                for (int size = this.f6083d.size() - 1; size >= 0; size--) {
                    this.f6083d.get(size).f();
                }
                if (aVar2 != null) {
                    this.f6082c.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            m();
        }
    }

    private class c implements Handler.Callback {
        c() {
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                g.this.a((a) message.obj);
                return true;
            } else if (message.what != 2) {
                return false;
            } else {
                g.this.f6080a.a((com.c.a.g.a.e<?>) (a) message.obj);
                return false;
            }
        }
    }

    static class a extends com.c.a.g.a.c<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        final int f6087a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f6088b;

        /* renamed from: c  reason: collision with root package name */
        private final long f6089c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap f6090d;

        a(Handler handler, int i, long j) {
            this.f6088b = handler;
            this.f6087a = i;
            this.f6089c = j;
        }

        /* access modifiers changed from: package-private */
        public Bitmap g_() {
            return this.f6090d;
        }

        public void a(Bitmap bitmap, com.c.a.g.b.b<? super Bitmap> bVar) {
            this.f6090d = bitmap;
            this.f6088b.sendMessageAtTime(this.f6088b.obtainMessage(1, this), this.f6089c);
        }
    }

    private static i<Bitmap> a(j jVar, int i2, int i3) {
        return jVar.f().a(com.c.a.g.g.a(com.c.a.c.b.h.f5808b).a(true).b(true).a(i2, i3));
    }

    private static com.c.a.c.h o() {
        return new com.c.a.h.b(Double.valueOf(Math.random()));
    }
}
