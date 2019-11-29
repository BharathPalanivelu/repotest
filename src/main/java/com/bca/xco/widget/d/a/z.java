package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.r;
import java.io.Closeable;

public final class z implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final x f5189a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final v f5190b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f5191c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f5192d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final q f5193e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final r f5194f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final aa f5195g;
    /* access modifiers changed from: private */
    public final z h;
    /* access modifiers changed from: private */
    public final z i;
    /* access modifiers changed from: private */
    public final z j;
    /* access modifiers changed from: private */
    public final long k;
    /* access modifiers changed from: private */
    public final long l;
    private volatile j m;

    private z(a aVar) {
        this.f5189a = aVar.f5196a;
        this.f5190b = aVar.f5197b;
        this.f5191c = aVar.f5198c;
        this.f5192d = aVar.f5199d;
        this.f5193e = aVar.f5200e;
        this.f5194f = aVar.f5201f.a();
        this.f5195g = aVar.f5202g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public x a() {
        return this.f5189a;
    }

    public int b() {
        return this.f5191c;
    }

    public q c() {
        return this.f5193e;
    }

    public String a(String str) {
        return a(str, (String) null);
    }

    public String a(String str, String str2) {
        String a2 = this.f5194f.a(str);
        return a2 != null ? a2 : str2;
    }

    public r d() {
        return this.f5194f;
    }

    public aa e() {
        return this.f5195g;
    }

    public a f() {
        return new a();
    }

    public j g() {
        j jVar = this.m;
        if (jVar != null) {
            return jVar;
        }
        j a2 = j.a(this.f5194f);
        this.m = a2;
        return a2;
    }

    public long h() {
        return this.k;
    }

    public long i() {
        return this.l;
    }

    public void close() {
        this.f5195g.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f5190b + ", code=" + this.f5191c + ", message=" + this.f5192d + ", url=" + this.f5189a.a() + '}';
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public x f5196a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public v f5197b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f5198c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f5199d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public q f5200e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public r.a f5201f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public aa f5202g;
        /* access modifiers changed from: private */
        public z h;
        /* access modifiers changed from: private */
        public z i;
        /* access modifiers changed from: private */
        public z j;
        /* access modifiers changed from: private */
        public long k;
        /* access modifiers changed from: private */
        public long l;

        public a() {
            this.f5198c = -1;
            this.f5201f = new r.a();
        }

        private a(z zVar) {
            this.f5198c = -1;
            this.f5196a = zVar.f5189a;
            this.f5197b = zVar.f5190b;
            this.f5198c = zVar.f5191c;
            this.f5199d = zVar.f5192d;
            this.f5200e = zVar.f5193e;
            this.f5201f = zVar.f5194f.b();
            this.f5202g = zVar.f5195g;
            this.h = zVar.h;
            this.i = zVar.i;
            this.j = zVar.j;
            this.k = zVar.k;
            this.l = zVar.l;
        }

        public a a(x xVar) {
            this.f5196a = xVar;
            return this;
        }

        public a a(v vVar) {
            this.f5197b = vVar;
            return this;
        }

        public a a(int i2) {
            this.f5198c = i2;
            return this;
        }

        public a a(String str) {
            this.f5199d = str;
            return this;
        }

        public a a(q qVar) {
            this.f5200e = qVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f5201f.a(str, str2);
            return this;
        }

        public a a(r rVar) {
            this.f5201f = rVar.b();
            return this;
        }

        public a a(aa aaVar) {
            this.f5202g = aaVar;
            return this;
        }

        public a a(z zVar) {
            if (zVar != null) {
                a("networkResponse", zVar);
            }
            this.h = zVar;
            return this;
        }

        public a b(z zVar) {
            if (zVar != null) {
                a("cacheResponse", zVar);
            }
            this.i = zVar;
            return this;
        }

        private void a(String str, z zVar) {
            if (zVar.f5195g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (zVar.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (zVar.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (zVar.j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a c(z zVar) {
            if (zVar != null) {
                d(zVar);
            }
            this.j = zVar;
            return this;
        }

        private void d(z zVar) {
            if (zVar.f5195g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(long j2) {
            this.k = j2;
            return this;
        }

        public a b(long j2) {
            this.l = j2;
            return this;
        }

        public z a() {
            if (this.f5196a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f5197b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f5198c >= 0) {
                return new z(this);
            } else {
                throw new IllegalStateException("code < 0: " + this.f5198c);
            }
        }
    }
}
