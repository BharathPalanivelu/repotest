package org.d;

import com.google.a.o;
import com.google.a.u;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.IOException;
import java.net.Proxy;
import java.net.SocketException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.d.b.a.j;
import org.d.d.c;
import org.d.d.f;
import org.d.f.d;
import org.d.f.e;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected static final Logger f33877a = LoggerFactory.getLogger((Class<?>) b.class);

    /* renamed from: b  reason: collision with root package name */
    protected final c f33878b;

    /* renamed from: c  reason: collision with root package name */
    private Proxy f33879c;

    public b() {
        this(new c());
    }

    public b(c cVar) {
        e.a((Object) cVar, "config cannot be null");
        this.f33878b = cVar;
    }

    public org.d.b.b.a.b a() throws org.d.c.b {
        org.d.f.b.a(f33877a, "getCurrentUserInfo", (String) null);
        f33877a.info("Getting current user info...");
        return (org.d.b.b.a.b) a(f.GET, org.d.b.b.a.b.class, "/users/self", (Map<String, String>) null);
    }

    public org.d.b.b.b.b a(String str, int i, String str2, String str3, Date date, Date date2) throws org.d.c.b {
        e.a(str, "UserId cannot be null or empty.");
        HashMap hashMap = new HashMap();
        if (str3 != null) {
            hashMap.put("max_id", String.valueOf(str3));
        }
        if (str2 != null) {
            hashMap.put("min_id", String.valueOf(str2));
        }
        if (i != 0) {
            hashMap.put("count", String.valueOf(i));
        }
        if (date != null) {
            hashMap.put("max_timestamp", String.valueOf(date.getTime() / 1000));
        }
        if (date2 != null) {
            hashMap.put("min_timestamp", String.valueOf(date2.getTime() / 1000));
        }
        return (org.d.b.b.b.b) a(f.GET, org.d.b.b.b.b.class, String.format("/users/%s/media/recent", new Object[]{str}), hashMap);
    }

    public org.d.b.b.b.b a(j jVar) throws org.d.c.b {
        d.a a2 = d.a(jVar, this.f33878b.a());
        return (org.d.b.b.b.b) a(f.GET, org.d.b.b.b.b.class, a2.a(), a2.b(), a2.c());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends org.d.d> T a(org.d.d.f r7, java.lang.Class<T> r8, java.lang.String r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11) throws org.d.c.b {
        /*
            r6 = this;
            org.d.d.c r0 = r6.c(r7, r9, r10, r11)     // Catch:{ IOException -> 0x006c }
            org.d.c r1 = r6.f33878b     // Catch:{ IOException -> 0x006c }
            boolean r1 = r1.f()     // Catch:{ IOException -> 0x006c }
            if (r1 == 0) goto L_0x003b
            boolean r1 = r6.b(r0)     // Catch:{ IOException -> 0x006c }
            if (r1 == 0) goto L_0x003b
            java.lang.Exception r1 = r6.a((org.d.d.c) r0)     // Catch:{ IOException -> 0x006c }
            r2 = 2
            r3 = 0
        L_0x0018:
            if (r1 == 0) goto L_0x003b
            if (r3 >= r2) goto L_0x003b
            r4 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x0021 }
        L_0x0021:
            org.slf4j.Logger r1 = f33877a     // Catch:{ IOException -> 0x006c }
            java.lang.String r4 = "(Retry #{}) Retrying request for {}"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x006c }
            java.lang.String r0 = r0.a()     // Catch:{ IOException -> 0x006c }
            r1.warn((java.lang.String) r4, (java.lang.Object) r5, (java.lang.Object) r0)     // Catch:{ IOException -> 0x006c }
            org.d.d.c r0 = r6.c(r7, r9, r10, r11)     // Catch:{ IOException -> 0x006c }
            java.lang.Exception r1 = r6.a((org.d.d.c) r0)     // Catch:{ IOException -> 0x006c }
            int r3 = r3 + 1
            goto L_0x0018
        L_0x003b:
            java.lang.String r7 = r0.b()     // Catch:{ IOException -> 0x006c }
            org.slf4j.Logger r9 = f33877a     // Catch:{ IOException -> 0x006c }
            org.d.f.b.a(r9, r7)     // Catch:{ IOException -> 0x006c }
            java.util.Map r9 = r0.e()
            int r10 = r0.d()
            r11 = 200(0xc8, float:2.8E-43)
            if (r10 < r11) goto L_0x0062
            int r10 = r0.d()
            r11 = 300(0x12c, float:4.2E-43)
            if (r10 >= r11) goto L_0x0062
            java.lang.Object r7 = a(r8, (java.lang.String) r7)
            org.d.d r7 = (org.d.d) r7
            r7.a(r9)
            return r7
        L_0x0062:
            int r8 = r0.d()
            long r10 = (long) r8
            org.d.c.b r7 = r6.a(r10, r7, r9)
            throw r7
        L_0x006c:
            r7 = move-exception
            org.d.c.b r8 = new org.d.c.b
            java.lang.String r9 = "IOException while retrieving data"
            r8.<init>((java.lang.String) r9, (java.lang.Exception) r7)
            goto L_0x0076
        L_0x0075:
            throw r8
        L_0x0076:
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: org.d.b.a(org.d.d.f, java.lang.Class, java.lang.String, java.lang.String, java.util.Map):org.d.d");
    }

    private Exception a(c cVar) {
        int d2 = cVar.d();
        try {
            new com.google.a.f().a(cVar.b(), o.class);
            return null;
        } catch (IllegalStateException e2) {
            if (e2.getCause() instanceof SocketException) {
                f33877a.warn(String.format("Socket error with HTTP response (code %d).", new Object[]{Integer.valueOf(d2)}), e2.getCause());
                return e2;
            }
            f33877a.warn(String.format("IllegalState exception with HTTP response (code %d).", new Object[]{Integer.valueOf(d2)}), e2.getCause());
            return e2;
        } catch (u e3) {
            f33877a.warn(String.format("HTTP response body contained malformed JSON (code %d).", new Object[]{Integer.valueOf(d2)}), (Object) Integer.valueOf(cVar.d()));
            return e3;
        }
    }

    private boolean b(c cVar) {
        return (cVar.d() >= 200 && cVar.d() < 300) || cVar.d() >= 500;
    }

    /* access modifiers changed from: protected */
    public <T extends d> T a(f fVar, Class<T> cls, String str, Map<String, String> map) throws org.d.c.b {
        return a(fVar, cls, str, str, map);
    }

    /* access modifiers changed from: protected */
    public org.d.c.b a(long j, String str, Map<String, String> map) throws org.d.c.b {
        com.google.a.f fVar = new com.google.a.f();
        if (j == 400) {
            org.d.b.a.f a2 = org.d.b.a.f.a(fVar, str);
            a2.a(map);
            a2.a();
        } else if (j == 429) {
            try {
                org.d.b.a.f a3 = org.d.b.a.f.a(fVar, str);
                a3.a(map);
                a3.a();
            } catch (u e2) {
                throw new org.d.c.b("Failed to decode error response " + str, (Exception) e2, map);
            }
        }
        throw new org.d.c.b("Unknown error response code: " + j + SQLBuilder.BLANK + str, map);
    }

    /* access modifiers changed from: protected */
    public c c(f fVar, String str, String str2, Map<String, String> map) throws IOException {
        org.d.d.b b2 = b(fVar, str, str2, map);
        f33877a.debug("Sending request to Instagram...");
        return b2.a();
    }

    /* access modifiers changed from: protected */
    public org.d.d.b b(f fVar, String str, String str2, Map<String, String> map) throws org.d.c.b {
        org.d.d.b bVar = new org.d.d.b(fVar, this.f33878b.a() + str);
        Logger logger = f33877a;
        logger.debug("Creating request for Instagram -  " + bVar.e());
        a(bVar, this.f33878b);
        Proxy proxy = this.f33879c;
        if (proxy != null) {
            bVar.a(proxy);
        }
        if (map != null) {
            map.remove("sig");
            for (Map.Entry next : map.entrySet()) {
                if (fVar == f.GET) {
                    bVar.b((String) next.getKey(), (String) next.getValue());
                } else {
                    bVar.a((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        return bVar;
    }

    public static void a(org.d.d.b bVar, c cVar) {
        bVar.a(cVar.b(), TimeUnit.MILLISECONDS);
        bVar.b(cVar.c(), TimeUnit.MILLISECONDS);
        bVar.a(cVar.d());
    }

    public static <T> T a(Class<T> cls, String str) throws org.d.c.b {
        try {
            return new com.google.a.f().a(str, cls);
        } catch (Exception e2) {
            throw new org.d.c.b("Error parsing json to object type " + cls.getName(), e2);
        }
    }
}
