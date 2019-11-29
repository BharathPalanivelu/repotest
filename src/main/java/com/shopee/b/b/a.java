package com.shopee.b.b;

import android.content.Context;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f27104a;

    public a(Context context) {
        j.b(context, "context");
        this.f27104a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "permission"
            d.d.b.j.b(r5, r0)     // Catch:{ all -> 0x0026 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0026 }
            r1 = 23
            r2 = 1
            r3 = 0
            if (r0 >= r1) goto L_0x001a
            android.content.Context r0 = r4.f27104a     // Catch:{ all -> 0x0026 }
            int r5 = r0.checkCallingOrSelfPermission(r5)     // Catch:{ all -> 0x0026 }
            if (r5 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r2 = 0
        L_0x0018:
            monitor-exit(r4)
            return r2
        L_0x001a:
            android.content.Context r0 = r4.f27104a     // Catch:{ all -> 0x0026 }
            int r5 = androidx.core.content.b.b((android.content.Context) r0, (java.lang.String) r5)     // Catch:{ all -> 0x0026 }
            if (r5 != 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r2 = 0
        L_0x0024:
            monitor-exit(r4)
            return r2
        L_0x0026:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.b.b.a.a(java.lang.String):boolean");
    }
}
