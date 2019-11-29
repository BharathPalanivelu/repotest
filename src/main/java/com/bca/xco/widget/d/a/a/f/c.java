package com.bca.xco.widget.d.a.a.f;

import com.bca.xco.widget.d.a.a.d;
import com.bca.xco.widget.d.a.aa;
import com.bca.xco.widget.d.a.e;
import com.bca.xco.widget.d.a.g;
import com.bca.xco.widget.d.a.o;
import com.bca.xco.widget.d.a.r;
import com.bca.xco.widget.d.a.u;
import com.bca.xco.widget.d.a.x;
import com.bca.xco.widget.d.a.y;
import com.bca.xco.widget.d.a.z;
import com.bca.xco.widget.d.b.k;
import com.bca.xco.widget.d.b.m;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.List;

public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    private final e f4870a;

    public c(e eVar) {
        this.f4870a = eVar;
    }

    public z a(g.a aVar) {
        x a2 = aVar.a();
        x.a e2 = a2.e();
        y d2 = a2.d();
        if (d2 != null) {
            u a3 = d2.a();
            if (a3 != null) {
                e2.a(HttpConstants.Header.CONTENT_TYPE, a3.toString());
            }
            long b2 = d2.b();
            if (b2 != -1) {
                e2.a(HttpConstants.Header.CONTENT_LENGTH, Long.toString(b2));
                e2.b(HttpConstants.Header.TRANSFER_ENCODING);
            } else {
                e2.a(HttpConstants.Header.TRANSFER_ENCODING, "chunked");
                e2.b(HttpConstants.Header.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (a2.a(HttpConstants.Header.HOST) == null) {
            e2.a(HttpConstants.Header.HOST, com.bca.xco.widget.d.a.a.c.a(a2.a(), false));
        }
        if (a2.a(HttpConstants.Header.CONNECTION) == null) {
            e2.a(HttpConstants.Header.CONNECTION, "Keep-Alive");
        }
        if (a2.a("Accept-Encoding") == null) {
            z = true;
            e2.a("Accept-Encoding", "gzip");
        }
        List<o> a4 = this.f4870a.a(a2.a());
        if (!a4.isEmpty()) {
            e2.a("Cookie", a(a4));
        }
        if (a2.a(HttpConstants.Header.USER_AGENT) == null) {
            e2.a(HttpConstants.Header.USER_AGENT, d.a());
        }
        z a5 = aVar.a(e2.b());
        f.a(this.f4870a, a2.a(), a5.d());
        z.a a6 = a5.f().a(a2);
        if (z && "gzip".equalsIgnoreCase(a5.a(COSRequestHeaderKey.CONTENT_ENCODING)) && f.b(a5)) {
            k kVar = new k(a5.e().c());
            r a7 = a5.d().b().b(COSRequestHeaderKey.CONTENT_ENCODING).b(HttpConstants.Header.CONTENT_LENGTH).a();
            a6.a(a7);
            a6.a((aa) new i(a7, m.a((com.bca.xco.widget.d.b.d) kVar)));
        }
        return a6.a();
    }

    private String a(List<o> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            o oVar = list.get(i);
            sb.append(oVar.a());
            sb.append('=');
            sb.append(oVar.b());
        }
        return sb.toString();
    }
}
