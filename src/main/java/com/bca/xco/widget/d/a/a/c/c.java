package com.bca.xco.widget.d.a.a.c;

import com.bca.xco.widget.d.a.a.c.d;
import com.bca.xco.widget.d.a.a.f.f;
import com.bca.xco.widget.d.a.a.f.i;
import com.bca.xco.widget.d.a.aa;
import com.bca.xco.widget.d.a.g;
import com.bca.xco.widget.d.a.r;
import com.bca.xco.widget.d.a.u;
import com.bca.xco.widget.d.a.v;
import com.bca.xco.widget.d.a.x;
import com.bca.xco.widget.d.a.z;
import com.bca.xco.widget.d.b.a;
import com.bca.xco.widget.d.b.b;
import com.bca.xco.widget.d.b.m;
import com.bca.xco.widget.d.b.s;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class c implements g {

    /* renamed from: b  reason: collision with root package name */
    private static final aa f4802b = new aa() {
        public u a() {
            return null;
        }

        public long b() {
            return 0;
        }

        public b c() {
            return new com.bca.xco.widget.d.b.g();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final b f4803a;

    public c(b bVar) {
        this.f4803a = bVar;
    }

    public z a(g.a aVar) {
        b bVar = this.f4803a;
        z a2 = bVar != null ? bVar.a(aVar.a()) : null;
        d a3 = new d.a(System.currentTimeMillis(), aVar.a(), a2).a();
        x xVar = a3.f4809a;
        z zVar = a3.f4810b;
        b bVar2 = this.f4803a;
        if (bVar2 != null) {
            bVar2.a(a3);
        }
        if (a2 != null && zVar == null) {
            com.bca.xco.widget.d.a.a.c.a((Closeable) a2.e());
        }
        if (xVar == null && zVar == null) {
            return new z.a().a(aVar.a()).a(v.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(f4802b).a(-1).b(System.currentTimeMillis()).a();
        }
        if (xVar == null) {
            return zVar.f().b(a(zVar)).a();
        }
        try {
            z a4 = aVar.a(xVar);
            if (a4 == null && a2 != null) {
            }
            if (zVar != null) {
                if (a(zVar, a4)) {
                    z a5 = zVar.f().a(a(zVar.d(), a4.d())).b(a(zVar)).a(a(a4)).a();
                    a4.e().close();
                    this.f4803a.a();
                    this.f4803a.a(zVar, a5);
                    return a5;
                }
                com.bca.xco.widget.d.a.a.c.a((Closeable) zVar.e());
            }
            z a6 = a4.f().b(a(zVar)).a(a(a4)).a();
            if (f.b(a6)) {
                return a(a(a6, a4.a(), this.f4803a), a6);
            }
            return a6;
        } finally {
            if (a2 != null) {
                com.bca.xco.widget.d.a.a.c.a((Closeable) a2.e());
            }
        }
    }

    private static z a(z zVar) {
        return (zVar == null || zVar.e() == null) ? zVar : zVar.f().a((aa) null).a();
    }

    private a a(z zVar, x xVar, b bVar) {
        if (bVar == null) {
            return null;
        }
        if (d.a(zVar, xVar)) {
            return bVar.a(zVar);
        }
        if (com.bca.xco.widget.d.a.a.f.g.a(xVar.b())) {
            try {
                bVar.b(xVar);
            } catch (IOException unused) {
            }
        }
        return null;
    }

    private z a(final a aVar, z zVar) {
        if (aVar == null) {
            return zVar;
        }
        com.bca.xco.widget.d.b.c a2 = aVar.a();
        if (a2 == null) {
            return zVar;
        }
        final b c2 = zVar.e().c();
        final a a3 = m.a(a2);
        return zVar.f().a((aa) new i(zVar.d(), m.a((com.bca.xco.widget.d.b.d) new com.bca.xco.widget.d.b.d() {

            /* renamed from: a  reason: collision with root package name */
            boolean f4804a;

            public long a(com.bca.xco.widget.d.b.g gVar, long j) {
                try {
                    long a2 = c2.a(gVar, j);
                    if (a2 == -1) {
                        if (!this.f4804a) {
                            this.f4804a = true;
                            a3.close();
                        }
                        return -1;
                    }
                    gVar.a(a3.b(), gVar.m() - a2, a2);
                    a3.c();
                    return a2;
                } catch (IOException e2) {
                    if (!this.f4804a) {
                        this.f4804a = true;
                        aVar.b();
                    }
                    throw e2;
                }
            }

            public s a() {
                return c2.a();
            }

            public void close() {
                if (!this.f4804a && !com.bca.xco.widget.d.a.a.c.a((com.bca.xco.widget.d.b.d) this, 100, TimeUnit.MILLISECONDS)) {
                    this.f4804a = true;
                    aVar.b();
                }
                c2.close();
            }
        }))).a();
    }

    private static boolean a(z zVar, z zVar2) {
        if (zVar2.b() == 304) {
            return true;
        }
        Date b2 = zVar.d().b("Last-Modified");
        if (b2 == null) {
            return false;
        }
        Date b3 = zVar2.d().b("Last-Modified");
        if (b3 == null || b3.getTime() >= b2.getTime()) {
            return false;
        }
        return true;
    }

    private static r a(r rVar, r rVar2) {
        r.a aVar = new r.a();
        int a2 = rVar.a();
        for (int i = 0; i < a2; i++) {
            String a3 = rVar.a(i);
            String b2 = rVar.b(i);
            if ((!"Warning".equalsIgnoreCase(a3) || !b2.startsWith("1")) && (!a(a3) || rVar2.a(a3) == null)) {
                com.bca.xco.widget.d.a.a.a.f4741a.a(aVar, a3, b2);
            }
        }
        int a4 = rVar2.a();
        for (int i2 = 0; i2 < a4; i2++) {
            String a5 = rVar2.a(i2);
            if (!HttpConstants.Header.CONTENT_LENGTH.equalsIgnoreCase(a5) && a(a5)) {
                com.bca.xco.widget.d.a.a.a.f4741a.a(aVar, a5, rVar2.b(i2));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return !HttpConstants.Header.CONNECTION.equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !HttpConstants.Header.TRANSFER_ENCODING.equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }
}
