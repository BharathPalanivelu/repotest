package org.d.b.a;

import com.google.a.l;
import java.util.Map;
import org.d.c.a;
import org.d.c.b;
import org.d.c.c;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private i f33896a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f33897b;

    f(i iVar) {
        this.f33896a = iVar;
    }

    public void a(Map<String, String> map) {
        this.f33897b = map;
    }

    public void a() throws b {
        if (this.f33896a != null) {
            String str = this.f33896a.b() + ": " + this.f33896a.c();
            int a2 = this.f33896a.a();
            if (a2 == 400) {
                throw new a(this.f33896a.b(), str, this.f33897b);
            } else if (a2 != 429) {
                throw new b(this.f33896a.b(), str, this.f33897b);
            } else {
                throw new c(this.f33896a.b(), str, this.f33897b);
            }
        } else {
            throw new b("No metadata found in response", this.f33897b);
        }
    }

    public static f a(com.google.a.f fVar, String str) {
        i iVar;
        l lVar = (l) fVar.a(str, l.class);
        l c2 = lVar != null ? lVar.m().c("meta") : null;
        if (c2 != null) {
            iVar = (i) fVar.a(c2, i.class);
        } else {
            iVar = (i) fVar.a(lVar, i.class);
        }
        if (iVar.a() == 0 || iVar.b() == null) {
            return new f((i) null);
        }
        return new f(iVar);
    }
}
