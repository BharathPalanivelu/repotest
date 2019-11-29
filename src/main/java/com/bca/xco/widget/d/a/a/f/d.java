package com.bca.xco.widget.d.a.a.f;

import com.bca.xco.widget.d.a.g;
import com.bca.xco.widget.d.a.x;
import com.bca.xco.widget.d.a.z;
import com.bca.xco.widget.d.b.a;
import com.bca.xco.widget.d.b.m;
import com.tencent.qcloud.core.http.HttpConstants;
import java.net.ProtocolException;

public final class d implements g {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f4871a;

    public d(boolean z) {
        this.f4871a = z;
    }

    public z a(g.a aVar) {
        h hVar = (h) aVar;
        a c2 = hVar.c();
        com.bca.xco.widget.d.a.a.a.g b2 = hVar.b();
        x a2 = aVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        c2.a(a2);
        if (g.c(a2.b()) && a2.d() != null) {
            a a3 = m.a(c2.a(a2, a2.d().b()));
            a2.d().a(a3);
            a3.close();
        }
        c2.b();
        z a4 = c2.a().a(a2).a(b2.b().c()).a(currentTimeMillis).b(System.currentTimeMillis()).a();
        if (!this.f4871a || a4.b() != 101) {
            a4 = a4.f().a(c2.a(a4)).a();
        }
        if ("close".equalsIgnoreCase(a4.a().a(HttpConstants.Header.CONNECTION)) || "close".equalsIgnoreCase(a4.a(HttpConstants.Header.CONNECTION))) {
            b2.d();
        }
        int b3 = a4.b();
        if ((b3 != 204 && b3 != 205) || a4.e().b() <= 0) {
            return a4;
        }
        throw new ProtocolException("HTTP " + b3 + " had non-zero Content-Length: " + a4.e().b());
    }
}
