package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.Pair;
import androidx.b.g;
import com.firebase.jobdispatcher.d;
import com.firebase.jobdispatcher.n;
import com.firebase.jobdispatcher.q;
import com.firebase.jobdispatcher.u;

public class GooglePlayReceiver extends Service implements d.a {

    /* renamed from: d  reason: collision with root package name */
    private static final p f7177d = new p("com.firebase.jobdispatcher.");
    private static final g<String, g<String, o>> h = new g<>(1);

    /* renamed from: a  reason: collision with root package name */
    Messenger f7178a;

    /* renamed from: b  reason: collision with root package name */
    c f7179b;

    /* renamed from: c  reason: collision with root package name */
    aa f7180c;

    /* renamed from: e  reason: collision with root package name */
    private final f f7181e = new f();

    /* renamed from: f  reason: collision with root package name */
    private d f7182f;

    /* renamed from: g  reason: collision with root package name */
    private int f7183g;

    private static void a(o oVar, int i) {
        try {
            oVar.a(i);
        } catch (Throwable th) {
            Log.e("FJD.GooglePlayReceiver", "Encountered error running callback", th.getCause());
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            super.onStartCommand(intent, i, i2);
            if (intent == null) {
                Log.w("FJD.GooglePlayReceiver", "Null Intent passed, terminating");
                synchronized (h) {
                    this.f7183g = i2;
                    if (h.isEmpty()) {
                        stopSelf(this.f7183g);
                    }
                }
                return 2;
            }
            String action = intent.getAction();
            if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(action)) {
                a().a(a(intent));
                synchronized (h) {
                    this.f7183g = i2;
                    if (h.isEmpty()) {
                        stopSelf(this.f7183g);
                    }
                }
                return 2;
            } else if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(action)) {
                synchronized (h) {
                    this.f7183g = i2;
                    if (h.isEmpty()) {
                        stopSelf(this.f7183g);
                    }
                }
                return 2;
            } else {
                Log.e("FJD.GooglePlayReceiver", "Unknown action received, terminating");
                synchronized (h) {
                    this.f7183g = i2;
                    if (h.isEmpty()) {
                        stopSelf(this.f7183g);
                    }
                }
                return 2;
            }
        } catch (Throwable th) {
            synchronized (h) {
                this.f7183g = i2;
                if (h.isEmpty()) {
                    stopSelf(this.f7183g);
                }
                throw th;
            }
        }
    }

    public IBinder onBind(Intent intent) {
        if (intent == null || Build.VERSION.SDK_INT < 21 || !"com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction())) {
            return null;
        }
        return c().getBinder();
    }

    private synchronized Messenger c() {
        if (this.f7178a == null) {
            this.f7178a = new Messenger(new j(Looper.getMainLooper(), this));
        }
        return this.f7178a;
    }

    /* access modifiers changed from: package-private */
    public synchronized d a() {
        if (this.f7182f == null) {
            this.f7182f = new d(this, this);
        }
        return this.f7182f;
    }

    private synchronized c d() {
        if (this.f7179b == null) {
            this.f7179b = new g(getApplicationContext());
        }
        return this.f7179b;
    }

    private synchronized aa e() {
        if (this.f7180c == null) {
            this.f7180c = new aa(d().a());
        }
        return this.f7180c;
    }

    /* access modifiers changed from: package-private */
    public q a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Log.e("FJD.GooglePlayReceiver", "No data provided, terminating");
            return null;
        }
        Pair<o, Bundle> a2 = this.f7181e.a(extras);
        if (a2 != null) {
            return a((o) a2.first, (Bundle) a2.second);
        }
        Log.i("FJD.GooglePlayReceiver", "no callback found");
        return null;
    }

    /* access modifiers changed from: package-private */
    public q a(o oVar, Bundle bundle) {
        q a2 = f7177d.a(bundle);
        if (a2 == null) {
            Log.e("FJD.GooglePlayReceiver", "unable to decode job");
            a(oVar, 2);
            return null;
        }
        synchronized (h) {
            g gVar = h.get(a2.i());
            if (gVar == null) {
                gVar = new g(1);
                h.put(a2.i(), gVar);
            }
            gVar.put(a2.e(), oVar);
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0090, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.firebase.jobdispatcher.q r6, int r7) {
        /*
            r5 = this;
            androidx.b.g<java.lang.String, androidx.b.g<java.lang.String, com.firebase.jobdispatcher.o>> r0 = h
            monitor-enter(r0)
            androidx.b.g<java.lang.String, androidx.b.g<java.lang.String, com.firebase.jobdispatcher.o>> r1 = h     // Catch:{ all -> 0x0091 }
            java.lang.String r2 = r6.i()     // Catch:{ all -> 0x0091 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0091 }
            androidx.b.g r1 = (androidx.b.g) r1     // Catch:{ all -> 0x0091 }
            if (r1 != 0) goto L_0x0020
            androidx.b.g<java.lang.String, androidx.b.g<java.lang.String, com.firebase.jobdispatcher.o>> r6 = h     // Catch:{ all -> 0x00a0 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x00a0 }
            if (r6 == 0) goto L_0x001e
            int r6 = r5.f7183g     // Catch:{ all -> 0x00a0 }
            r5.stopSelf(r6)     // Catch:{ all -> 0x00a0 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x00a0 }
            return
        L_0x0020:
            java.lang.String r2 = r6.e()     // Catch:{ all -> 0x0091 }
            java.lang.Object r2 = r1.remove(r2)     // Catch:{ all -> 0x0091 }
            com.firebase.jobdispatcher.o r2 = (com.firebase.jobdispatcher.o) r2     // Catch:{ all -> 0x0091 }
            if (r2 != 0) goto L_0x003b
            androidx.b.g<java.lang.String, androidx.b.g<java.lang.String, com.firebase.jobdispatcher.o>> r6 = h     // Catch:{ all -> 0x00a0 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x00a0 }
            if (r6 == 0) goto L_0x0039
            int r6 = r5.f7183g     // Catch:{ all -> 0x00a0 }
            r5.stopSelf(r6)     // Catch:{ all -> 0x00a0 }
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x00a0 }
            return
        L_0x003b:
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x004a
            androidx.b.g<java.lang.String, androidx.b.g<java.lang.String, com.firebase.jobdispatcher.o>> r1 = h     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = r6.i()     // Catch:{ all -> 0x0091 }
            r1.remove(r3)     // Catch:{ all -> 0x0091 }
        L_0x004a:
            boolean r1 = a((com.firebase.jobdispatcher.r) r6, (int) r7)     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x0054
            r5.a((com.firebase.jobdispatcher.q) r6)     // Catch:{ all -> 0x0091 }
            goto L_0x0082
        L_0x0054:
            java.lang.String r1 = "FJD.GooglePlayReceiver"
            r3 = 2
            boolean r1 = android.util.Log.isLoggable(r1, r3)     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x007f
            java.lang.String r1 = "FJD.GooglePlayReceiver"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            r3.<init>()     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = "sending jobFinished for "
            r3.append(r4)     // Catch:{ all -> 0x0091 }
            java.lang.String r6 = r6.e()     // Catch:{ all -> 0x0091 }
            r3.append(r6)     // Catch:{ all -> 0x0091 }
            java.lang.String r6 = " = "
            r3.append(r6)     // Catch:{ all -> 0x0091 }
            r3.append(r7)     // Catch:{ all -> 0x0091 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0091 }
            android.util.Log.v(r1, r6)     // Catch:{ all -> 0x0091 }
        L_0x007f:
            a((com.firebase.jobdispatcher.o) r2, (int) r7)     // Catch:{ all -> 0x0091 }
        L_0x0082:
            androidx.b.g<java.lang.String, androidx.b.g<java.lang.String, com.firebase.jobdispatcher.o>> r6 = h     // Catch:{ all -> 0x00a0 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x00a0 }
            if (r6 == 0) goto L_0x008f
            int r6 = r5.f7183g     // Catch:{ all -> 0x00a0 }
            r5.stopSelf(r6)     // Catch:{ all -> 0x00a0 }
        L_0x008f:
            monitor-exit(r0)     // Catch:{ all -> 0x00a0 }
            return
        L_0x0091:
            r6 = move-exception
            androidx.b.g<java.lang.String, androidx.b.g<java.lang.String, com.firebase.jobdispatcher.o>> r7 = h     // Catch:{ all -> 0x00a0 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x00a0 }
            if (r7 == 0) goto L_0x009f
            int r7 = r5.f7183g     // Catch:{ all -> 0x00a0 }
            r5.stopSelf(r7)     // Catch:{ all -> 0x00a0 }
        L_0x009f:
            throw r6     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a0 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.GooglePlayReceiver.a(com.firebase.jobdispatcher.q, int):void");
    }

    private void a(q qVar) {
        d().a(new n.a(e(), qVar).a(true).j());
    }

    private static boolean a(r rVar, int i) {
        if (!rVar.h() || !(rVar.f() instanceof u.a) || i == 1) {
            return false;
        }
        return true;
    }

    static p b() {
        return f7177d;
    }

    static void a(n nVar) {
        synchronized (h) {
            g gVar = h.get(nVar.i());
            if (gVar != null) {
                if (((o) gVar.get(nVar.e())) != null) {
                    d.a(new q.a().a(nVar.e()).b(nVar.i()).a(nVar.f()).a(), false);
                }
            }
        }
    }
}
