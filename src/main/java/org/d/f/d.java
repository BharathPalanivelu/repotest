package org.d.f;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import org.d.b.a.j;
import org.d.d.e;

public class d {
    public static a a(j jVar, String str) {
        if (org.apache.commons.c.d.c(jVar.a())) {
            try {
                String a2 = jVar.a();
                return new a(org.apache.commons.c.d.a(a2, str, "?"), e.d(new URL(a2).getQuery()));
            } catch (MalformedURLException e2) {
                throw new org.d.a.a.a("Malformed URL", e2);
            }
        } else {
            throw new org.d.a.a.a("No nextUrl");
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f33976a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f33977b;

        public a(String str, Map<String, String> map) {
            this.f33976a = str;
            this.f33977b = map;
        }

        public String a() {
            return this.f33976a;
        }

        public String b() {
            return e.a(this.f33976a);
        }

        public Map<String, String> c() {
            return this.f33977b;
        }
    }
}
