package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.f.g;
import com.bca.xco.widget.d.a.r;

public final class x {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f5174a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f5175b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final r f5176c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final y f5177d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Object f5178e;

    /* renamed from: f  reason: collision with root package name */
    private volatile j f5179f;

    private x(a aVar) {
        this.f5174a = aVar.f5180a;
        this.f5175b = aVar.f5181b;
        this.f5176c = aVar.f5182c.a();
        this.f5177d = aVar.f5183d;
        this.f5178e = aVar.f5184e != null ? aVar.f5184e : this;
    }

    public t a() {
        return this.f5174a;
    }

    public String b() {
        return this.f5175b;
    }

    public r c() {
        return this.f5176c;
    }

    public String a(String str) {
        return this.f5176c.a(str);
    }

    public y d() {
        return this.f5177d;
    }

    public a e() {
        return new a();
    }

    public j f() {
        j jVar = this.f5179f;
        if (jVar != null) {
            return jVar;
        }
        j a2 = j.a(this.f5176c);
        this.f5179f = a2;
        return a2;
    }

    public boolean g() {
        return this.f5174a.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f5175b);
        sb.append(", url=");
        sb.append(this.f5174a);
        sb.append(", tag=");
        Object obj = this.f5178e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public t f5180a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f5181b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public r.a f5182c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public y f5183d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public Object f5184e;

        public a() {
            this.f5181b = "GET";
            this.f5182c = new r.a();
        }

        private a(x xVar) {
            this.f5180a = xVar.f5174a;
            this.f5181b = xVar.f5175b;
            this.f5183d = xVar.f5177d;
            this.f5184e = xVar.f5178e;
            this.f5182c = xVar.f5176c.b();
        }

        public a a(t tVar) {
            if (tVar != null) {
                this.f5180a = tVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a a(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                t e2 = t.e(str);
                if (e2 != null) {
                    return a(e2);
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            throw new NullPointerException("url == null");
        }

        public a a(String str, String str2) {
            this.f5182c.c(str, str2);
            return this;
        }

        public a b(String str) {
            this.f5182c.b(str);
            return this;
        }

        public a a(r rVar) {
            this.f5182c = rVar.b();
            return this;
        }

        public a a() {
            return a("GET", (y) null);
        }

        public a a(y yVar) {
            return a("POST", yVar);
        }

        public a b(y yVar) {
            return a("PUT", yVar);
        }

        public a a(String str, y yVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (yVar != null && !g.c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (yVar != null || !g.b(str)) {
                this.f5181b = str;
                this.f5183d = yVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public x b() {
            if (this.f5180a != null) {
                return new x(this);
            }
            throw new IllegalStateException("url == null");
        }
    }
}
