package com.beetalklib.network.file.b;

import android.text.TextUtils;
import com.beetalklib.network.c.a;
import com.beetalklib.network.file.a.c;
import com.beetalklib.network.file.a.d;
import com.beetalklib.network.file.a.e;
import com.beetalklib.network.file.a.g;
import com.beetalklib.network.file.a.h;
import com.beetalklib.network.file.a.i;
import com.beetalklib.network.file.a.j;
import java.util.ArrayList;
import java.util.List;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private List<g> f5573a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private com.beetalklib.network.file.a.b f5574b;

    public b(int i) {
        this.f5574b = new com.beetalklib.network.file.a.b(i);
    }

    public synchronized void a(int i) {
        this.f5574b.a(i);
    }

    public synchronized void a() {
        this.f5574b.a();
    }

    public void a(String str, int i, String str2, byte[] bArr, String str3, i iVar) {
        if (bArr == null || bArr.length == 0) {
            iVar.a(112);
        } else if (a(new j(str, i, str2, bArr, str3, iVar))) {
            a.b("schedule task %s with success", str2);
        } else {
            a.b("schedule task %s with failure", str2);
        }
    }

    public void a(String str, int i, String str2, String str3, String str4, i iVar) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            iVar.a(112);
        } else if (a(new j(str, i, str2, str3, str4, iVar))) {
            a.b("schedule task %s with success", str2);
        } else {
            a.b("schedule task %s with failure", str2);
        }
    }

    public void a(String str, String str2, byte[] bArr, String str3, i iVar) {
        String[] split = str.split(":");
        a(split[0], Integer.parseInt(split[1]), str2, bArr, str3, iVar);
    }

    public void a(String str, String str2, String str3, String str4, i iVar) {
        String[] split = str.split(":");
        a(split[0], Integer.parseInt(split[1]), str2, str3, str4, iVar);
    }

    public void a(String str, String str2, String str3, c cVar) {
        String[] split = str.split(":");
        a(new d(split[0], Integer.parseInt(split[1]), str2, str3, cVar));
    }

    private synchronized boolean a(d dVar) {
        h a2 = this.f5574b.a(dVar.c(), dVar.d());
        if (a2 != null) {
            new e(a2, this).a(dVar);
            return true;
        }
        if (!this.f5573a.contains(dVar)) {
            this.f5573a.add(dVar);
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(com.beetalklib.network.file.a.j r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.beetalklib.network.file.a.b r0 = r3.f5574b     // Catch:{ all -> 0x002f }
            java.lang.String r1 = r4.b()     // Catch:{ all -> 0x002f }
            int r2 = r4.c()     // Catch:{ all -> 0x002f }
            com.beetalklib.network.file.a.h r0 = r0.a(r1, r2)     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x001f
            com.beetalklib.network.file.a.f r1 = new com.beetalklib.network.file.a.f     // Catch:{ all -> 0x002f }
            r1.<init>(r0, r3)     // Catch:{ all -> 0x002f }
            r4.g()     // Catch:{ all -> 0x002f }
            r1.a((com.beetalklib.network.file.a.j) r4)     // Catch:{ all -> 0x002f }
            r4 = 1
            monitor-exit(r3)
            return r4
        L_0x001f:
            java.util.List<com.beetalklib.network.file.a.g> r0 = r3.f5573a     // Catch:{ all -> 0x002f }
            boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x002f }
            r1 = 0
            if (r0 != 0) goto L_0x002d
            java.util.List<com.beetalklib.network.file.a.g> r0 = r3.f5573a     // Catch:{ all -> 0x002f }
            r0.add(r1, r4)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r3)
            return r1
        L_0x002f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beetalklib.network.file.b.b.a(com.beetalklib.network.file.a.j):boolean");
    }

    public synchronized void a(boolean z) {
        boolean z2;
        while (!this.f5573a.isEmpty()) {
            g gVar = this.f5573a.get(0);
            int e2 = gVar.e();
            if (e2 == 1) {
                z2 = a((j) gVar);
            } else if (e2 != 2) {
                a.a("Unknown task type", new Object[0]);
                z2 = false;
            } else {
                z2 = a((d) gVar);
            }
            if (!z2) {
                break;
            }
            this.f5573a.remove(0);
        }
    }
}
