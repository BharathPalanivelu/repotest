package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.b.g;
import com.firebase.jobdispatcher.m;
import com.firebase.jobdispatcher.q;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Locale;

public abstract class s extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f7237a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final g<String, a> f7238b = new g<>(1);

    /* renamed from: c  reason: collision with root package name */
    private final m.a f7239c = new m.a() {
        public void a(Bundle bundle, l lVar) {
            q.a b2 = GooglePlayReceiver.b().b(bundle);
            if (b2 == null) {
                Log.wtf("FJD.JobService", "start: unknown invocation provided");
            } else {
                s.this.a((r) b2.a(), lVar);
            }
        }

        public void a(Bundle bundle, boolean z) {
            q.a b2 = GooglePlayReceiver.b().b(bundle);
            if (b2 == null) {
                Log.wtf("FJD.JobService", "stop: unknown invocation provided");
            } else {
                s.this.a((r) b2.a(), z);
            }
        }
    };

    public abstract boolean a(r rVar);

    public abstract boolean b(r rVar);

    public final void onStart(Intent intent, int i) {
    }

    /* access modifiers changed from: package-private */
    public void a(final r rVar, l lVar) {
        synchronized (this.f7238b) {
            if (this.f7238b.containsKey(rVar.e())) {
                Log.w("FJD.JobService", String.format(Locale.US, "Job with tag = %s was already running.", new Object[]{rVar.e()}));
                return;
            }
            this.f7238b.put(rVar.e(), new a(rVar, lVar));
            f7237a.post(new Runnable() {
                public void run() {
                    synchronized (s.this.f7238b) {
                        if (!s.this.a(rVar)) {
                            a aVar = (a) s.this.f7238b.remove(rVar.e());
                            if (aVar != null) {
                                aVar.a(0);
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(final com.firebase.jobdispatcher.r r5, final boolean r6) {
        /*
            r4 = this;
            androidx.b.g<java.lang.String, com.firebase.jobdispatcher.s$a> r0 = r4.f7238b
            monitor-enter(r0)
            androidx.b.g<java.lang.String, com.firebase.jobdispatcher.s$a> r1 = r4.f7238b     // Catch:{ all -> 0x002f }
            java.lang.String r2 = r5.e()     // Catch:{ all -> 0x002f }
            java.lang.Object r1 = r1.remove(r2)     // Catch:{ all -> 0x002f }
            com.firebase.jobdispatcher.s$a r1 = (com.firebase.jobdispatcher.s.a) r1     // Catch:{ all -> 0x002f }
            if (r1 != 0) goto L_0x0023
            java.lang.String r5 = "FJD.JobService"
            r6 = 3
            boolean r5 = android.util.Log.isLoggable(r5, r6)     // Catch:{ all -> 0x002f }
            if (r5 == 0) goto L_0x0021
            java.lang.String r5 = "FJD.JobService"
            java.lang.String r6 = "Provided job has already been executed."
            android.util.Log.d(r5, r6)     // Catch:{ all -> 0x002f }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x0023:
            android.os.Handler r2 = f7237a     // Catch:{ all -> 0x002f }
            com.firebase.jobdispatcher.s$3 r3 = new com.firebase.jobdispatcher.s$3     // Catch:{ all -> 0x002f }
            r3.<init>(r5, r6, r1)     // Catch:{ all -> 0x002f }
            r2.post(r3)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x002f:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.s.a(com.firebase.jobdispatcher.r, boolean):void");
    }

    public final void b(r rVar, boolean z) {
        if (rVar == null) {
            Log.e("FJD.JobService", "jobFinished called with a null JobParameters");
            return;
        }
        synchronized (this.f7238b) {
            a remove = this.f7238b.remove(rVar.e());
            if (remove != null) {
                remove.a(z ? 1 : 0);
            }
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        stopSelf(i2);
        return 2;
    }

    public final IBinder onBind(Intent intent) {
        return this.f7239c;
    }

    public final boolean onUnbind(Intent intent) {
        synchronized (this.f7238b) {
            for (int size = this.f7238b.size() - 1; size >= 0; size--) {
                a remove = this.f7238b.remove(this.f7238b.b(size));
                if (remove != null) {
                    remove.a(b(remove.f7247a) ? 1 : 2);
                }
            }
        }
        return super.onUnbind(intent);
    }

    public final void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    /* access modifiers changed from: protected */
    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(fileDescriptor, printWriter, strArr);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        final r f7247a;

        /* renamed from: b  reason: collision with root package name */
        final l f7248b;

        private a(r rVar, l lVar) {
            this.f7247a = rVar;
            this.f7248b = lVar;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            try {
                this.f7248b.a(GooglePlayReceiver.b().a(this.f7247a, new Bundle()), i);
            } catch (RemoteException e2) {
                Log.e("FJD.JobService", "Failed to send result to driver", e2);
            }
        }
    }
}
