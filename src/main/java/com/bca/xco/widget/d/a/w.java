package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.a.g;
import com.bca.xco.widget.d.a.a.b;
import com.bca.xco.widget.d.a.a.f.c;
import com.bca.xco.widget.d.a.a.f.d;
import com.bca.xco.widget.d.a.a.f.h;
import com.bca.xco.widget.d.a.a.f.k;
import com.salesforce.android.chat.core.internal.liveagent.response.message.FileTransferMessage;
import java.io.IOException;
import java.util.ArrayList;

final class w implements b {

    /* renamed from: a  reason: collision with root package name */
    x f5168a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final s f5169b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final k f5170c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5171d;

    protected w(s sVar, x xVar) {
        this.f5169b = sVar;
        this.f5168a = xVar;
        this.f5170c = new k(sVar);
    }

    public z a() {
        synchronized (this) {
            if (!this.f5171d) {
                this.f5171d = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        try {
            this.f5169b.s().a(this);
            z e2 = e();
            if (e2 != null) {
                return e2;
            }
            throw new IOException(FileTransferMessage.EVENT_TYPE_CANCELLED);
        } finally {
            this.f5169b.s().b(this);
        }
    }

    /* renamed from: b */
    public w clone() {
        return new w(this.f5169b, this.f5168a);
    }

    final class a extends b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f5172b;

        /* renamed from: c  reason: collision with root package name */
        private final c f5173c;

        /* access modifiers changed from: package-private */
        public String b() {
            return this.f5172b.f5168a.a().f();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[SYNTHETIC, Splitter:B:12:0x0034] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0054 A[Catch:{ all -> 0x002d }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r5 = this;
                r0 = 1
                r1 = 0
                com.bca.xco.widget.d.a.w r2 = r5.f5172b     // Catch:{ IOException -> 0x002f }
                com.bca.xco.widget.d.a.z r2 = r2.e()     // Catch:{ IOException -> 0x002f }
                com.bca.xco.widget.d.a.w r3 = r5.f5172b     // Catch:{ IOException -> 0x002f }
                com.bca.xco.widget.d.a.a.f.k r3 = r3.f5170c     // Catch:{ IOException -> 0x002f }
                boolean r1 = r3.a()     // Catch:{ IOException -> 0x002f }
                if (r1 == 0) goto L_0x0023
                com.bca.xco.widget.d.a.c r1 = r5.f5173c     // Catch:{ IOException -> 0x002b }
                com.bca.xco.widget.d.a.w r2 = r5.f5172b     // Catch:{ IOException -> 0x002b }
                java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x002b }
                java.lang.String r4 = "Canceled"
                r3.<init>(r4)     // Catch:{ IOException -> 0x002b }
                r1.a((com.bca.xco.widget.d.a.b) r2, (java.io.IOException) r3)     // Catch:{ IOException -> 0x002b }
                goto L_0x005b
            L_0x0023:
                com.bca.xco.widget.d.a.c r1 = r5.f5173c     // Catch:{ IOException -> 0x002b }
                com.bca.xco.widget.d.a.w r3 = r5.f5172b     // Catch:{ IOException -> 0x002b }
                r1.a((com.bca.xco.widget.d.a.b) r3, (com.bca.xco.widget.d.a.z) r2)     // Catch:{ IOException -> 0x002b }
                goto L_0x005b
            L_0x002b:
                r1 = move-exception
                goto L_0x0032
            L_0x002d:
                r0 = move-exception
                goto L_0x0069
            L_0x002f:
                r0 = move-exception
                r1 = r0
                r0 = 0
            L_0x0032:
                if (r0 == 0) goto L_0x0054
                com.bca.xco.widget.d.a.a.d.e r0 = com.bca.xco.widget.d.a.a.d.e.b()     // Catch:{ all -> 0x002d }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
                r3.<init>()     // Catch:{ all -> 0x002d }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x002d }
                com.bca.xco.widget.d.a.w r4 = r5.f5172b     // Catch:{ all -> 0x002d }
                java.lang.String r4 = r4.d()     // Catch:{ all -> 0x002d }
                r3.append(r4)     // Catch:{ all -> 0x002d }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002d }
                r0.a((int) r2, (java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x002d }
                goto L_0x005b
            L_0x0054:
                com.bca.xco.widget.d.a.c r0 = r5.f5173c     // Catch:{ all -> 0x002d }
                com.bca.xco.widget.d.a.w r2 = r5.f5172b     // Catch:{ all -> 0x002d }
                r0.a((com.bca.xco.widget.d.a.b) r2, (java.io.IOException) r1)     // Catch:{ all -> 0x002d }
            L_0x005b:
                com.bca.xco.widget.d.a.w r0 = r5.f5172b
                com.bca.xco.widget.d.a.s r0 = r0.f5169b
                com.bca.xco.widget.d.a.p r0 = r0.s()
                r0.a((com.bca.xco.widget.d.a.w.a) r5)
                return
            L_0x0069:
                com.bca.xco.widget.d.a.w r1 = r5.f5172b
                com.bca.xco.widget.d.a.s r1 = r1.f5169b
                com.bca.xco.widget.d.a.p r1 = r1.s()
                r1.a((com.bca.xco.widget.d.a.w.a) r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.w.a.a():void");
        }
    }

    /* access modifiers changed from: private */
    public String d() {
        String str = this.f5170c.a() ? "canceled call" : "call";
        return str + " to " + c();
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.f5168a.a().m().toString();
    }

    /* access modifiers changed from: private */
    public z e() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f5169b.v());
        arrayList.add(this.f5170c);
        arrayList.add(new c(this.f5169b.f()));
        arrayList.add(new com.bca.xco.widget.d.a.a.c.c(this.f5169b.g()));
        arrayList.add(new com.bca.xco.widget.d.a.a.a.a(this.f5169b));
        if (!this.f5170c.b()) {
            arrayList.addAll(this.f5169b.w());
        }
        arrayList.add(new d(this.f5170c.b()));
        return new h(arrayList, (g) null, (com.bca.xco.widget.d.a.a.f.a) null, (d) null, 0, this.f5168a).a(this.f5168a);
    }
}
