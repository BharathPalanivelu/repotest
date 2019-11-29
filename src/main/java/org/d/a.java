package org.d;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.d.a.b.b;
import org.d.d.f;
import org.d.f.e;
import org.slf4j.Logger;

public class a extends b {

    /* renamed from: c  reason: collision with root package name */
    private b f33874c;

    /* renamed from: d  reason: collision with root package name */
    private final String f33875d;

    public a(b bVar) {
        this(bVar, (String) null, new c());
    }

    private a(b bVar, String str, c cVar) {
        super(cVar);
        e.a(bVar, str, "accessToken and clientId cannot both be null");
        if (bVar == null) {
            e.a(str, "clientId cannot be an empty string");
        } else if (cVar.e()) {
            e.a(bVar.b(), "enforce signed requests need a client secret");
        }
        this.f33874c = bVar;
        this.f33875d = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public org.d.a.b.a b(f fVar, String str, String str2, Map<String, String> map) throws org.d.c.b {
        org.d.d.b b2 = super.b(fVar, str, str2, map);
        org.d.a.b.a aVar = new org.d.a.b.a(b2.g(), b2.e());
        aVar.a(b2.h());
        aVar.a(b2.k());
        aVar.a(b2.i(), TimeUnit.MILLISECONDS);
        aVar.a(b2.l());
        aVar.b(b2.j(), TimeUnit.MILLISECONDS);
        if (fVar == f.GET) {
            for (Map.Entry next : b2.c().entrySet()) {
                aVar.b((String) next.getKey(), (String) next.getValue());
            }
        } else {
            for (Map.Entry next2 : b2.d().entrySet()) {
                aVar.a((String) next2.getKey(), (String) next2.getValue());
            }
        }
        if (fVar == f.GET || fVar == f.DELETE) {
            if (this.f33874c == null) {
                Logger logger = f33877a;
                logger.debug("Using client_id : " + this.f33875d);
                aVar.b("client_id", this.f33875d);
            } else {
                Logger logger2 = f33877a;
                logger2.debug("Using access_token : " + this.f33874c.a());
                aVar.b("access_token", this.f33874c.a());
            }
        } else if (this.f33874c == null) {
            Logger logger3 = f33877a;
            logger3.debug("Using client_id : " + this.f33875d);
            aVar.a("client_id", this.f33875d);
        } else {
            Logger logger4 = f33877a;
            logger4.debug("Using access_token : " + this.f33874c.a());
            aVar.a("access_token", this.f33874c.a());
        }
        if (this.f33878b.e()) {
            boolean z = fVar == f.GET || fVar == f.DELETE;
            Map<String, String> c2 = z ? aVar.c() : aVar.d();
            b bVar = this.f33874c;
            String a2 = org.d.f.a.a(str2, c2, bVar != null ? bVar.b() : null);
            if (z) {
                aVar.b("sig", a2);
            } else {
                aVar.a("sig", a2);
            }
        }
        return aVar;
    }
}
