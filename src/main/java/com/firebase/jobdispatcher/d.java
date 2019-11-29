package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.b.g;
import com.firebase.jobdispatcher.l;
import com.firebase.jobdispatcher.q;

class d {

    /* renamed from: a  reason: collision with root package name */
    private static final g<String, t> f7187a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    private final l f7188b = new l.a() {
        public void a(Bundle bundle, int i) {
            q.a b2 = GooglePlayReceiver.b().b(bundle);
            if (b2 == null) {
                Log.wtf("FJD.ExternalReceiver", "jobFinished: unknown invocation provided");
            } else {
                d.this.a(b2.a(), i);
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final Context f7189c;

    /* renamed from: d  reason: collision with root package name */
    private final a f7190d;

    interface a {
        void a(q qVar, int i);
    }

    d(Context context, a aVar) {
        this.f7189c = context;
        this.f7190d = aVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.firebase.jobdispatcher.q r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            androidx.b.g<java.lang.String, com.firebase.jobdispatcher.t> r0 = f7187a
            monitor-enter(r0)
            androidx.b.g<java.lang.String, com.firebase.jobdispatcher.t> r1 = f7187a     // Catch:{ all -> 0x006c }
            java.lang.String r2 = r6.i()     // Catch:{ all -> 0x006c }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x006c }
            com.firebase.jobdispatcher.t r1 = (com.firebase.jobdispatcher.t) r1     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0028
            boolean r2 = r1.a()     // Catch:{ all -> 0x006c }
            if (r2 != 0) goto L_0x0028
            boolean r2 = r1.c(r6)     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x003a
            boolean r2 = r1.b()     // Catch:{ all -> 0x006c }
            if (r2 != 0) goto L_0x003a
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            return
        L_0x0028:
            com.firebase.jobdispatcher.t r1 = new com.firebase.jobdispatcher.t     // Catch:{ all -> 0x006c }
            com.firebase.jobdispatcher.l r2 = r5.f7188b     // Catch:{ all -> 0x006c }
            android.content.Context r3 = r5.f7189c     // Catch:{ all -> 0x006c }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x006c }
            androidx.b.g<java.lang.String, com.firebase.jobdispatcher.t> r2 = f7187a     // Catch:{ all -> 0x006c }
            java.lang.String r3 = r6.i()     // Catch:{ all -> 0x006c }
            r2.put(r3, r1)     // Catch:{ all -> 0x006c }
        L_0x003a:
            boolean r2 = r1.b(r6)     // Catch:{ all -> 0x006c }
            if (r2 != 0) goto L_0x006a
            android.content.Context r2 = r5.f7189c     // Catch:{ all -> 0x006c }
            android.content.Intent r3 = r5.a((com.firebase.jobdispatcher.r) r6)     // Catch:{ all -> 0x006c }
            r4 = 1
            boolean r2 = r2.bindService(r3, r1, r4)     // Catch:{ all -> 0x006c }
            if (r2 != 0) goto L_0x006a
            java.lang.String r2 = "FJD.ExternalReceiver"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r3.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r4 = "Unable to bind to "
            r3.append(r4)     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r6.i()     // Catch:{ all -> 0x006c }
            r3.append(r6)     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x006c }
            android.util.Log.e(r2, r6)     // Catch:{ all -> 0x006c }
            r1.c()     // Catch:{ all -> 0x006c }
        L_0x006a:
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            return
        L_0x006c:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.d.a(com.firebase.jobdispatcher.q):void");
    }

    private Intent a(r rVar) {
        Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
        intent.setClassName(this.f7189c, rVar.i());
        return intent;
    }

    static void a(q qVar, boolean z) {
        synchronized (f7187a) {
            t tVar = f7187a.get(qVar.i());
            if (tVar != null) {
                tVar.a(qVar, z);
                if (tVar.a()) {
                    f7187a.remove(qVar.i());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(q qVar, int i) {
        synchronized (f7187a) {
            t tVar = f7187a.get(qVar.i());
            if (tVar != null) {
                tVar.a(qVar);
                if (tVar.a()) {
                    f7187a.remove(qVar.i());
                }
            }
        }
        this.f7190d.a(qVar, i);
    }
}
