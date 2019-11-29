package com.c.a.g;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.core.util.Pools;
import com.c.a.c.b.i;
import com.c.a.c.b.o;
import com.c.a.c.b.s;
import com.c.a.e;
import com.c.a.g;
import com.c.a.g.a.d;
import com.c.a.g.b.c;
import com.c.a.i.a.a;
import com.c.a.i.a.b;

public final class i<R> implements d, c, h, a.c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pools.a<i<?>> f6201a = com.c.a.i.a.a.a(150, new a.C0112a<i<?>>() {
        /* renamed from: a */
        public i<?> b() {
            return new i<>();
        }
    });
    private int A;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6202b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6203c = String.valueOf(super.hashCode());

    /* renamed from: d  reason: collision with root package name */
    private final b f6204d = b.a();

    /* renamed from: e  reason: collision with root package name */
    private f<R> f6205e;

    /* renamed from: f  reason: collision with root package name */
    private d f6206f;

    /* renamed from: g  reason: collision with root package name */
    private Context f6207g;
    private e h;
    private Object i;
    private Class<R> j;
    private g k;
    private int l;
    private int m;
    private g n;
    private com.c.a.g.a.e<R> o;
    private f<R> p;
    private com.c.a.c.b.i q;
    private c<? super R> r;
    private s<R> s;
    private i.d t;
    private long u;
    private a v;
    private Drawable w;
    private Drawable x;
    private Drawable y;
    private int z;

    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    public static <R> i<R> a(Context context, e eVar, Object obj, Class<R> cls, g gVar, int i2, int i3, g gVar2, com.c.a.g.a.e<R> eVar2, f<R> fVar, f<R> fVar2, d dVar, com.c.a.c.b.i iVar, c<? super R> cVar) {
        i<R> acquire = f6201a.acquire();
        if (acquire == null) {
            acquire = new i<>();
        }
        acquire.b(context, eVar, obj, cls, gVar, i2, i3, gVar2, eVar2, fVar, fVar2, dVar, iVar, cVar);
        return acquire;
    }

    i() {
    }

    private void b(Context context, e eVar, Object obj, Class<R> cls, g gVar, int i2, int i3, g gVar2, com.c.a.g.a.e<R> eVar2, f<R> fVar, f<R> fVar2, d dVar, com.c.a.c.b.i iVar, c<? super R> cVar) {
        this.f6207g = context;
        this.h = eVar;
        this.i = obj;
        this.j = cls;
        this.k = gVar;
        this.l = i2;
        this.m = i3;
        this.n = gVar2;
        this.o = eVar2;
        this.f6205e = fVar;
        this.p = fVar2;
        this.f6206f = dVar;
        this.q = iVar;
        this.r = cVar;
        this.v = a.PENDING;
    }

    public b f_() {
        return this.f6204d;
    }

    public void i() {
        k();
        this.f6207g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = -1;
        this.m = -1;
        this.o = null;
        this.p = null;
        this.f6205e = null;
        this.f6206f = null;
        this.r = null;
        this.t = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = -1;
        this.A = -1;
        f6201a.release(this);
    }

    public void a() {
        k();
        this.f6204d.b();
        this.u = com.c.a.i.d.a();
        if (this.i == null) {
            if (com.c.a.i.i.a(this.l, this.m)) {
                this.z = this.l;
                this.A = this.m;
            }
            a(new o("Received null model"), n() == null ? 5 : 3);
        } else if (this.v == a.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (this.v == a.COMPLETE) {
            a((s<?>) this.s, com.c.a.c.a.MEMORY_CACHE);
        } else {
            this.v = a.WAITING_FOR_SIZE;
            if (com.c.a.i.i.a(this.l, this.m)) {
                a(this.l, this.m);
            } else {
                this.o.a((d) this);
            }
            if ((this.v == a.RUNNING || this.v == a.WAITING_FOR_SIZE) && q()) {
                this.o.b(m());
            }
            if (Log.isLoggable("Request", 2)) {
                a("finished run method in " + com.c.a.i.d.a(this.u));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        k();
        this.f6204d.b();
        this.o.b((d) this);
        this.v = a.CANCELLED;
        i.d dVar = this.t;
        if (dVar != null) {
            dVar.a();
            this.t = null;
        }
    }

    private void k() {
        if (this.f6202b) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    public void c() {
        com.c.a.i.i.a();
        k();
        if (this.v != a.CLEARED) {
            j();
            s<R> sVar = this.s;
            if (sVar != null) {
                a((s<?>) sVar);
            }
            if (q()) {
                this.o.a(m());
            }
            this.v = a.CLEARED;
        }
    }

    public void b() {
        c();
        this.v = a.PAUSED;
    }

    private void a(s<?> sVar) {
        this.q.a(sVar);
        this.s = null;
    }

    public boolean d() {
        return this.v == a.RUNNING || this.v == a.WAITING_FOR_SIZE;
    }

    public boolean e() {
        return this.v == a.COMPLETE;
    }

    public boolean f() {
        return e();
    }

    public boolean g() {
        return this.v == a.CANCELLED || this.v == a.CLEARED;
    }

    public boolean h() {
        return this.v == a.FAILED;
    }

    private Drawable l() {
        if (this.w == null) {
            this.w = this.k.i();
            if (this.w == null && this.k.j() > 0) {
                this.w = a(this.k.j());
            }
        }
        return this.w;
    }

    private Drawable m() {
        if (this.x == null) {
            this.x = this.k.l();
            if (this.x == null && this.k.k() > 0) {
                this.x = a(this.k.k());
            }
        }
        return this.x;
    }

    private Drawable n() {
        if (this.y == null) {
            this.y = this.k.n();
            if (this.y == null && this.k.m() > 0) {
                this.y = a(this.k.m());
            }
        }
        return this.y;
    }

    private Drawable a(int i2) {
        return com.c.a.c.d.c.a.a(this.h, i2, this.k.o() != null ? this.k.o() : this.f6207g.getTheme());
    }

    private void o() {
        if (q()) {
            Drawable drawable = null;
            if (this.i == null) {
                drawable = n();
            }
            if (drawable == null) {
                drawable = l();
            }
            if (drawable == null) {
                drawable = m();
            }
            this.o.c(drawable);
        }
    }

    public void a(int i2, int i3) {
        this.f6204d.b();
        if (Log.isLoggable("Request", 2)) {
            a("Got onSizeReady in " + com.c.a.i.d.a(this.u));
        }
        if (this.v == a.WAITING_FOR_SIZE) {
            this.v = a.RUNNING;
            float w2 = this.k.w();
            this.z = a(i2, w2);
            this.A = a(i3, w2);
            if (Log.isLoggable("Request", 2)) {
                a("finished setup for calling load in " + com.c.a.i.d.a(this.u));
            }
            com.c.a.c.b.i iVar = this.q;
            e eVar = this.h;
            i.d a2 = iVar.a(eVar, this.i, this.k.q(), this.z, this.A, this.k.g(), this.j, this.n, this.k.h(), this.k.d(), this.k.e(), this.k.x(), this.k.f(), this.k.p(), this.k.y(), this.k.z(), this.k.A(), this);
            this.t = a2;
            if (Log.isLoggable("Request", 2)) {
                a("finished onSizeReady in " + com.c.a.i.d.a(this.u));
            }
        }
    }

    private static int a(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * ((float) i2));
    }

    private boolean p() {
        d dVar = this.f6206f;
        return dVar == null || dVar.b(this);
    }

    private boolean q() {
        d dVar = this.f6206f;
        return dVar == null || dVar.c(this);
    }

    private boolean r() {
        d dVar = this.f6206f;
        return dVar == null || !dVar.j();
    }

    private void s() {
        d dVar = this.f6206f;
        if (dVar != null) {
            dVar.d(this);
        }
    }

    private void t() {
        d dVar = this.f6206f;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    public void a(s<?> sVar, com.c.a.c.a aVar) {
        this.f6204d.b();
        this.t = null;
        if (sVar == null) {
            a(new o("Expected to receive a Resource<R> with an object of " + this.j + " inside, but instead got null."));
            return;
        }
        Object c2 = sVar.c();
        if (c2 == null || !this.j.isAssignableFrom(c2.getClass())) {
            a(sVar);
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive an object of ");
            sb.append(this.j);
            sb.append(" but instead got ");
            String str = "";
            sb.append(c2 != null ? c2.getClass() : str);
            sb.append("{");
            sb.append(c2);
            sb.append("} inside Resource{");
            sb.append(sVar);
            sb.append("}.");
            if (c2 == null) {
                str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            sb.append(str);
            a(new o(sb.toString()));
        } else if (!p()) {
            a(sVar);
            this.v = a.COMPLETE;
        } else {
            a(sVar, c2, aVar);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0092, code lost:
        if (r7.f6205e.onResourceReady(r9, r7.i, r7.o, r10, r6) == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x007f, code lost:
        if (r7.p.onResourceReady(r9, r7.i, r7.o, r10, r6) == false) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.c.a.c.b.s<R> r8, R r9, com.c.a.c.a r10) {
        /*
            r7 = this;
            boolean r6 = r7.r()
            com.c.a.g.i$a r0 = com.c.a.g.i.a.COMPLETE
            r7.v = r0
            r7.s = r8
            com.c.a.e r8 = r7.h
            int r8 = r8.e()
            r0 = 3
            if (r8 > r0) goto L_0x006a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Finished loading "
            r8.append(r0)
            java.lang.Class r0 = r9.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r8.append(r0)
            java.lang.String r0 = " from "
            r8.append(r0)
            r8.append(r10)
            java.lang.String r0 = " for "
            r8.append(r0)
            java.lang.Object r0 = r7.i
            r8.append(r0)
            java.lang.String r0 = " with size ["
            r8.append(r0)
            int r0 = r7.z
            r8.append(r0)
            java.lang.String r0 = "x"
            r8.append(r0)
            int r0 = r7.A
            r8.append(r0)
            java.lang.String r0 = "] in "
            r8.append(r0)
            long r0 = r7.u
            double r0 = com.c.a.i.d.a(r0)
            r8.append(r0)
            java.lang.String r0 = " ms"
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            java.lang.String r0 = "Glide"
            android.util.Log.d(r0, r8)
        L_0x006a:
            r8 = 1
            r7.f6202b = r8
            r8 = 0
            com.c.a.g.f<R> r0 = r7.p     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x0081
            com.c.a.g.f<R> r0 = r7.p     // Catch:{ all -> 0x00a5 }
            java.lang.Object r2 = r7.i     // Catch:{ all -> 0x00a5 }
            com.c.a.g.a.e<R> r3 = r7.o     // Catch:{ all -> 0x00a5 }
            r1 = r9
            r4 = r10
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x009f
        L_0x0081:
            com.c.a.g.f<R> r0 = r7.f6205e     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x0094
            com.c.a.g.f<R> r0 = r7.f6205e     // Catch:{ all -> 0x00a5 }
            java.lang.Object r2 = r7.i     // Catch:{ all -> 0x00a5 }
            com.c.a.g.a.e<R> r3 = r7.o     // Catch:{ all -> 0x00a5 }
            r1 = r9
            r4 = r10
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x009f
        L_0x0094:
            com.c.a.g.b.c<? super R> r0 = r7.r     // Catch:{ all -> 0x00a5 }
            com.c.a.g.b.b r10 = r0.a(r10, r6)     // Catch:{ all -> 0x00a5 }
            com.c.a.g.a.e<R> r0 = r7.o     // Catch:{ all -> 0x00a5 }
            r0.a(r9, r10)     // Catch:{ all -> 0x00a5 }
        L_0x009f:
            r7.f6202b = r8
            r7.s()
            return
        L_0x00a5:
            r9 = move-exception
            r7.f6202b = r8
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.g.i.a(com.c.a.c.b.s, java.lang.Object, com.c.a.c.a):void");
    }

    public void a(o oVar) {
        a(oVar, 5);
    }

    /* JADX INFO: finally extract failed */
    private void a(o oVar, int i2) {
        this.f6204d.b();
        int e2 = this.h.e();
        if (e2 <= i2) {
            Log.w("Glide", "Load failed for " + this.i + " with size [" + this.z + "x" + this.A + "]", oVar);
            if (e2 <= 4) {
                oVar.a("Glide");
            }
        }
        this.t = null;
        this.v = a.FAILED;
        this.f6202b = true;
        try {
            if ((this.p == null || !this.p.onLoadFailed(oVar, this.i, this.o, r())) && (this.f6205e == null || !this.f6205e.onLoadFailed(oVar, this.i, this.o, r()))) {
                o();
            }
            this.f6202b = false;
            t();
        } catch (Throwable th) {
            this.f6202b = false;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.c.a.g.c r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.c.a.g.i
            r1 = 0
            if (r0 == 0) goto L_0x0045
            com.c.a.g.i r4 = (com.c.a.g.i) r4
            int r0 = r3.l
            int r2 = r4.l
            if (r0 != r2) goto L_0x0045
            int r0 = r3.m
            int r2 = r4.m
            if (r0 != r2) goto L_0x0045
            java.lang.Object r0 = r3.i
            java.lang.Object r2 = r4.i
            boolean r0 = com.c.a.i.i.b((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0045
            java.lang.Class<R> r0 = r3.j
            java.lang.Class<R> r2 = r4.j
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0045
            com.c.a.g.g r0 = r3.k
            com.c.a.g.g r2 = r4.k
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0045
            com.c.a.g r0 = r3.n
            com.c.a.g r2 = r4.n
            if (r0 != r2) goto L_0x0045
            com.c.a.g.f<R> r0 = r3.p
            if (r0 == 0) goto L_0x0040
            com.c.a.g.f<R> r4 = r4.p
            if (r4 == 0) goto L_0x0045
            goto L_0x0044
        L_0x0040:
            com.c.a.g.f<R> r4 = r4.p
            if (r4 != 0) goto L_0x0045
        L_0x0044:
            r1 = 1
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.g.i.a(com.c.a.g.c):boolean");
    }

    private void a(String str) {
        Log.v("Request", str + " this: " + this.f6203c);
    }
}
