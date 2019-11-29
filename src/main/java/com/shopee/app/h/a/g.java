package com.shopee.app.h.a;

import com.beetalklib.network.file.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.h.c.c;
import com.shopee.app.network.a;
import java.util.ArrayDeque;
import java.util.HashSet;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static b f17615a = new b(6);

    /* renamed from: b  reason: collision with root package name */
    private static g f17616b = null;

    /* renamed from: c  reason: collision with root package name */
    private int f17617c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayDeque<f> f17618d = new ArrayDeque<>();

    /* renamed from: e  reason: collision with root package name */
    private HashSet<f> f17619e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private c f17620f = new c() {
    };

    public static g a() {
        if (f17616b == null) {
            f17616b = new g();
        }
        return f17616b;
    }

    private g() {
        if (a.d(ar.a())) {
            this.f17617c = 5;
        } else {
            this.f17617c = 3;
        }
        f17615a.a(this.f17617c);
    }

    /* access modifiers changed from: protected */
    public synchronized void a(String str, String str2) {
        com.garena.android.appkit.d.a.e("scheduler push download %s", str2);
        synchronized (this.f17618d) {
            f fVar = new f(str, str2, 1);
            if (this.f17618d.contains(fVar)) {
                this.f17618d.remove(fVar);
            }
            this.f17618d.addFirst(fVar);
            c();
        }
    }

    public boolean b() {
        com.garena.android.appkit.d.a.e("scheduler ongoing %d", Integer.valueOf(this.f17619e.size()));
        if (this.f17619e.size() >= this.f17617c) {
            return true;
        }
        return false;
    }

    private boolean a(f fVar) {
        return this.f17619e.contains(fVar);
    }

    public synchronized void a(String str) {
        com.garena.android.appkit.d.a.e("scheduler download complete %s", str);
        this.f17619e.remove(new f(str, 1));
        c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0060, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void c() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.ArrayDeque<com.shopee.app.h.a.f> r0 = r6.f17618d     // Catch:{ all -> 0x0064 }
            monitor-enter(r0)     // Catch:{ all -> 0x0064 }
            boolean r1 = r6.b()     // Catch:{ all -> 0x0061 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            monitor-exit(r6)
            return
        L_0x000d:
            java.util.ArrayDeque<com.shopee.app.h.a.f> r1 = r6.f17618d     // Catch:{ all -> 0x0061 }
            java.lang.Object r1 = r1.peekFirst()     // Catch:{ all -> 0x0061 }
            com.shopee.app.h.a.f r1 = (com.shopee.app.h.a.f) r1     // Catch:{ all -> 0x0061 }
            if (r1 == 0) goto L_0x005e
            boolean r2 = r6.a((com.shopee.app.h.a.f) r1)     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x0025
            java.util.ArrayDeque<com.shopee.app.h.a.f> r2 = r6.f17618d     // Catch:{ all -> 0x0061 }
            r2.remove(r1)     // Catch:{ all -> 0x0061 }
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            monitor-exit(r6)
            return
        L_0x0025:
            int r2 = r1.f17613c     // Catch:{ all -> 0x0061 }
            r3 = 1
            if (r2 == r3) goto L_0x002b
            goto L_0x0059
        L_0x002b:
            boolean r2 = r1.f17611a     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x003c
            com.shopee.app.h.a.a r2 = com.shopee.app.h.a.a.a()     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = r1.f17614d     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = r1.f17612b     // Catch:{ all -> 0x0061 }
            int r2 = r2.b((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0061 }
            goto L_0x0046
        L_0x003c:
            com.shopee.app.h.a.a r2 = com.shopee.app.h.a.a.a()     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = r1.f17612b     // Catch:{ all -> 0x0061 }
            int r2 = r2.a((java.lang.String) r4)     // Catch:{ all -> 0x0061 }
        L_0x0046:
            java.lang.String r4 = "scheduler - download-response %d"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0061 }
            r5 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0061 }
            r3[r5] = r2     // Catch:{ all -> 0x0061 }
            com.garena.android.appkit.d.a.e(r4, r3)     // Catch:{ all -> 0x0061 }
            java.util.HashSet<com.shopee.app.h.a.f> r2 = r6.f17619e     // Catch:{ all -> 0x0061 }
            r2.add(r1)     // Catch:{ all -> 0x0061 }
        L_0x0059:
            java.util.ArrayDeque<com.shopee.app.h.a.f> r2 = r6.f17618d     // Catch:{ all -> 0x0061 }
            r2.remove(r1)     // Catch:{ all -> 0x0061 }
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            monitor-exit(r6)
            return
        L_0x0061:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            throw r1     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.h.a.g.c():void");
    }
}
