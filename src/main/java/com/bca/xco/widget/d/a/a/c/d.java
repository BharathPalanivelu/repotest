package com.bca.xco.widget.d.a.a.c;

import com.bca.xco.widget.d.a.a.f.e;
import com.bca.xco.widget.d.a.a.f.f;
import com.bca.xco.widget.d.a.j;
import com.bca.xco.widget.d.a.r;
import com.bca.xco.widget.d.a.x;
import com.bca.xco.widget.d.a.z;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final x f4809a;

    /* renamed from: b  reason: collision with root package name */
    public final z f4810b;

    private d(x xVar, z zVar) {
        this.f4809a = xVar;
        this.f4810b = zVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.g().d() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.bca.xco.widget.d.a.z r3, com.bca.xco.widget.d.a.x r4) {
        /*
            int r0 = r3.b()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L_0x005a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L_0x0031
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L_0x005a
            switch(r0) {
                case 300: goto L_0x005a;
                case 301: goto L_0x005a;
                case 302: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0059
        L_0x0031:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.a((java.lang.String) r0)
            if (r0 != 0) goto L_0x005a
            com.bca.xco.widget.d.a.j r0 = r3.g()
            int r0 = r0.c()
            r1 = -1
            if (r0 != r1) goto L_0x005a
            com.bca.xco.widget.d.a.j r0 = r3.g()
            boolean r0 = r0.e()
            if (r0 != 0) goto L_0x005a
            com.bca.xco.widget.d.a.j r0 = r3.g()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            com.bca.xco.widget.d.a.j r3 = r3.g()
            boolean r3 = r3.b()
            if (r3 != 0) goto L_0x006f
            com.bca.xco.widget.d.a.j r3 = r4.f()
            boolean r3 = r3.b()
            if (r3 != 0) goto L_0x006f
            r2 = 1
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.c.d.a(com.bca.xco.widget.d.a.z, com.bca.xco.widget.d.a.x):boolean");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f4811a;

        /* renamed from: b  reason: collision with root package name */
        final x f4812b;

        /* renamed from: c  reason: collision with root package name */
        final z f4813c;

        /* renamed from: d  reason: collision with root package name */
        private Date f4814d;

        /* renamed from: e  reason: collision with root package name */
        private String f4815e;

        /* renamed from: f  reason: collision with root package name */
        private Date f4816f;

        /* renamed from: g  reason: collision with root package name */
        private String f4817g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l = -1;

        public a(long j2, x xVar, z zVar) {
            this.f4811a = j2;
            this.f4812b = xVar;
            this.f4813c = zVar;
            if (zVar != null) {
                this.i = zVar.h();
                this.j = zVar.i();
                r d2 = zVar.d();
                int a2 = d2.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    String a3 = d2.a(i2);
                    String b2 = d2.b(i2);
                    if (HttpConstants.Header.DATE.equalsIgnoreCase(a3)) {
                        this.f4814d = e.a(b2);
                        this.f4815e = b2;
                    } else if (COSRequestHeaderKey.EXPIRES.equalsIgnoreCase(a3)) {
                        this.h = e.a(b2);
                    } else if ("Last-Modified".equalsIgnoreCase(a3)) {
                        this.f4816f = e.a(b2);
                        this.f4817g = b2;
                    } else if ("ETag".equalsIgnoreCase(a3)) {
                        this.k = b2;
                    } else if ("Age".equalsIgnoreCase(a3)) {
                        this.l = f.b(b2, -1);
                    }
                }
            }
        }

        public d a() {
            d b2 = b();
            return (b2.f4809a == null || !this.f4812b.f().i()) ? b2 : new d((x) null, (z) null);
        }

        private d b() {
            if (this.f4813c == null) {
                return new d(this.f4812b, (z) null);
            }
            if (this.f4812b.g() && this.f4813c.c() == null) {
                return new d(this.f4812b, (z) null);
            }
            if (!d.a(this.f4813c, this.f4812b)) {
                return new d(this.f4812b, (z) null);
            }
            j f2 = this.f4812b.f();
            if (f2.a() || a(this.f4812b)) {
                return new d(this.f4812b, (z) null);
            }
            long d2 = d();
            long c2 = c();
            if (f2.c() != -1) {
                c2 = Math.min(c2, TimeUnit.SECONDS.toMillis((long) f2.c()));
            }
            long j2 = 0;
            long millis = f2.h() != -1 ? TimeUnit.SECONDS.toMillis((long) f2.h()) : 0;
            j g2 = this.f4813c.g();
            if (!g2.f() && f2.g() != -1) {
                j2 = TimeUnit.SECONDS.toMillis((long) f2.g());
            }
            if (!g2.a()) {
                long j3 = millis + d2;
                if (j3 < j2 + c2) {
                    z.a f3 = this.f4813c.f();
                    if (j3 >= c2) {
                        f3.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (d2 > 86400000 && e()) {
                        f3.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new d((x) null, f3.a());
                }
            }
            String str = this.k;
            String str2 = COSRequestHeaderKey.IF_MODIFIED_SINCE;
            if (str != null) {
                str2 = COSRequestHeaderKey.IF_NONE_MATCH;
            } else if (this.f4816f != null) {
                str = this.f4817g;
            } else if (this.f4814d == null) {
                return new d(this.f4812b, (z) null);
            } else {
                str = this.f4815e;
            }
            r.a b2 = this.f4812b.c().b();
            com.bca.xco.widget.d.a.a.a.f4741a.a(b2, str2, str);
            return new d(this.f4812b.e().a(b2.a()).b(), this.f4813c);
        }

        private long c() {
            j g2 = this.f4813c.g();
            if (g2.c() != -1) {
                return TimeUnit.SECONDS.toMillis((long) g2.c());
            }
            if (this.h != null) {
                Date date = this.f4814d;
                long time = this.h.getTime() - (date != null ? date.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f4816f == null || this.f4813c.a().a().k() != null) {
                return 0;
            } else {
                Date date2 = this.f4814d;
                long time2 = (date2 != null ? date2.getTime() : this.i) - this.f4816f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0;
            }
        }

        private long d() {
            Date date = this.f4814d;
            long j2 = 0;
            if (date != null) {
                j2 = Math.max(0, this.j - date.getTime());
            }
            if (this.l != -1) {
                j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) this.l));
            }
            long j3 = this.j;
            return j2 + (j3 - this.i) + (this.f4811a - j3);
        }

        private boolean e() {
            return this.f4813c.g().c() == -1 && this.h == null;
        }

        private static boolean a(x xVar) {
            return (xVar.a(COSRequestHeaderKey.IF_MODIFIED_SINCE) == null && xVar.a(COSRequestHeaderKey.IF_NONE_MATCH) == null) ? false : true;
        }
    }
}
