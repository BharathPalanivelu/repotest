package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.internal.p000firebaseperf.zzax;
import com.google.android.gms.internal.p000firebaseperf.zzbg;
import com.google.firebase.perf.internal.c;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class AppStartTrace implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static final long f14289a = TimeUnit.MINUTES.toMicros(1);

    /* renamed from: b  reason: collision with root package name */
    private static volatile AppStartTrace f14290b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14291c = false;

    /* renamed from: d  reason: collision with root package name */
    private c f14292d = null;

    /* renamed from: e  reason: collision with root package name */
    private final zzax f14293e;

    /* renamed from: f  reason: collision with root package name */
    private Context f14294f;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<Activity> f14295g;
    private WeakReference<Activity> h;
    private boolean i = false;
    /* access modifiers changed from: private */
    public zzbg j = null;
    private zzbg k = null;
    private zzbg l = null;
    /* access modifiers changed from: private */
    public boolean m = false;

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final AppStartTrace f14296a;

        public a(AppStartTrace appStartTrace) {
            this.f14296a = appStartTrace;
        }

        public final void run() {
            if (this.f14296a.j == null) {
                boolean unused = this.f14296a.m = true;
            }
        }
    }

    public static AppStartTrace a() {
        if (f14290b != null) {
            return f14290b;
        }
        return a((c) null, new zzax());
    }

    private static AppStartTrace a(c cVar, zzax zzax) {
        if (f14290b == null) {
            synchronized (AppStartTrace.class) {
                if (f14290b == null) {
                    f14290b = new AppStartTrace((c) null, zzax);
                }
            }
        }
        return f14290b;
    }

    private AppStartTrace(c cVar, zzax zzax) {
        this.f14293e = zzax;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f14291c     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x001c }
            boolean r0 = r2 instanceof android.app.Application     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            r0 = r2
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ all -> 0x001c }
            r0.registerActivityLifecycleCallbacks(r1)     // Catch:{ all -> 0x001c }
            r0 = 1
            r1.f14291c = r0     // Catch:{ all -> 0x001c }
            r1.f14294f = r2     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r1)
            return
        L_0x001c:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.a(android.content.Context):void");
    }

    private final synchronized void b() {
        if (this.f14291c) {
            ((Application) this.f14294f).unregisterActivityLifecycleCallbacks(this);
            this.f14291c = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityCreated(android.app.Activity r4, android.os.Bundle r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.firebase.perf.internal.SessionManager r5 = com.google.firebase.perf.internal.SessionManager.zzcf()     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.firebase-perf.zzbt r0 = com.google.android.gms.internal.p000firebaseperf.zzbt.FOREGROUND     // Catch:{ all -> 0x0038 }
            r5.zzc((com.google.android.gms.internal.p000firebaseperf.zzbt) r0)     // Catch:{ all -> 0x0038 }
            boolean r5 = r3.m     // Catch:{ all -> 0x0038 }
            if (r5 != 0) goto L_0x0036
            com.google.android.gms.internal.firebase-perf.zzbg r5 = r3.j     // Catch:{ all -> 0x0038 }
            if (r5 == 0) goto L_0x0013
            goto L_0x0036
        L_0x0013:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0038 }
            r5.<init>(r4)     // Catch:{ all -> 0x0038 }
            r3.f14295g = r5     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.firebase-perf.zzbg r4 = new com.google.android.gms.internal.firebase-perf.zzbg     // Catch:{ all -> 0x0038 }
            r4.<init>()     // Catch:{ all -> 0x0038 }
            r3.j = r4     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.firebase-perf.zzbg r4 = com.google.firebase.perf.provider.FirebasePerfProvider.zzcq()     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.firebase-perf.zzbg r5 = r3.j     // Catch:{ all -> 0x0038 }
            long r4 = r4.zza(r5)     // Catch:{ all -> 0x0038 }
            long r0 = f14289a     // Catch:{ all -> 0x0038 }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0034
            r4 = 1
            r3.i = r4     // Catch:{ all -> 0x0038 }
        L_0x0034:
            monitor-exit(r3)
            return
        L_0x0036:
            monitor-exit(r3)
            return
        L_0x0038:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityStarted(android.app.Activity r1) {
        /*
            r0 = this;
            monitor-enter(r0)
            boolean r1 = r0.m     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0017
            com.google.android.gms.internal.firebase-perf.zzbg r1 = r0.k     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0017
            boolean r1 = r0.i     // Catch:{ all -> 0x0019 }
            if (r1 == 0) goto L_0x000e
            goto L_0x0017
        L_0x000e:
            com.google.android.gms.internal.firebase-perf.zzbg r1 = new com.google.android.gms.internal.firebase-perf.zzbg     // Catch:{ all -> 0x0019 }
            r1.<init>()     // Catch:{ all -> 0x0019 }
            r0.k = r1     // Catch:{ all -> 0x0019 }
            monitor-exit(r0)
            return
        L_0x0017:
            monitor-exit(r0)
            return
        L_0x0019:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityStarted(android.app.Activity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0141, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0143, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityResumed(android.app.Activity r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.m     // Catch:{ all -> 0x0144 }
            if (r0 != 0) goto L_0x0142
            com.google.android.gms.internal.firebase-perf.zzbg r0 = r6.l     // Catch:{ all -> 0x0144 }
            if (r0 != 0) goto L_0x0142
            boolean r0 = r6.i     // Catch:{ all -> 0x0144 }
            if (r0 == 0) goto L_0x000f
            goto L_0x0142
        L_0x000f:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0144 }
            r0.<init>(r7)     // Catch:{ all -> 0x0144 }
            r6.h = r0     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzbg r0 = new com.google.android.gms.internal.firebase-perf.zzbg     // Catch:{ all -> 0x0144 }
            r0.<init>()     // Catch:{ all -> 0x0144 }
            r6.l = r0     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzbg r0 = com.google.firebase.perf.provider.FirebasePerfProvider.zzcq()     // Catch:{ all -> 0x0144 }
            java.lang.String r1 = "FirebasePerformance"
            java.lang.Class r7 = r7.getClass()     // Catch:{ all -> 0x0144 }
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzbg r2 = r6.l     // Catch:{ all -> 0x0144 }
            long r2 = r0.zza(r2)     // Catch:{ all -> 0x0144 }
            java.lang.String r4 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0144 }
            int r4 = r4.length()     // Catch:{ all -> 0x0144 }
            int r4 = r4 + 47
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0144 }
            r5.<init>(r4)     // Catch:{ all -> 0x0144 }
            java.lang.String r4 = "onResume(): "
            r5.append(r4)     // Catch:{ all -> 0x0144 }
            r5.append(r7)     // Catch:{ all -> 0x0144 }
            java.lang.String r7 = ": "
            r5.append(r7)     // Catch:{ all -> 0x0144 }
            r5.append(r2)     // Catch:{ all -> 0x0144 }
            java.lang.String r7 = " microseconds"
            r5.append(r7)     // Catch:{ all -> 0x0144 }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x0144 }
            android.util.Log.d(r1, r7)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r7 = com.google.android.gms.internal.p000firebaseperf.zzda.zzfu()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzaz r1 = com.google.android.gms.internal.p000firebaseperf.zzaz.APP_START_TRACE_NAME     // Catch:{ all -> 0x0144 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r7 = r7.zzae(r1)     // Catch:{ all -> 0x0144 }
            long r1 = r0.zzcr()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r7 = r7.zzak(r1)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzbg r1 = r6.l     // Catch:{ all -> 0x0144 }
            long r1 = r0.zza(r1)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r7 = r7.zzal(r1)     // Catch:{ all -> 0x0144 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0144 }
            r2 = 3
            r1.<init>(r2)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = com.google.android.gms.internal.p000firebaseperf.zzda.zzfu()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzaz r3 = com.google.android.gms.internal.p000firebaseperf.zzaz.ON_CREATE_TRACE_NAME     // Catch:{ all -> 0x0144 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = r2.zzae(r3)     // Catch:{ all -> 0x0144 }
            long r3 = r0.zzcr()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = r2.zzak(r3)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r6.j     // Catch:{ all -> 0x0144 }
            long r3 = r0.zza(r3)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r0 = r2.zzal(r3)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzga r0 = r0.zzhr()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzep r0 = (com.google.android.gms.internal.p000firebaseperf.zzep) r0     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda r0 = (com.google.android.gms.internal.p000firebaseperf.zzda) r0     // Catch:{ all -> 0x0144 }
            r1.add(r0)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r0 = com.google.android.gms.internal.p000firebaseperf.zzda.zzfu()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzaz r2 = com.google.android.gms.internal.p000firebaseperf.zzaz.ON_START_TRACE_NAME     // Catch:{ all -> 0x0144 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = r0.zzae(r2)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r6.j     // Catch:{ all -> 0x0144 }
            long r3 = r3.zzcr()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = r2.zzak(r3)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r6.j     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzbg r4 = r6.k     // Catch:{ all -> 0x0144 }
            long r3 = r3.zza(r4)     // Catch:{ all -> 0x0144 }
            r2.zzal(r3)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzga r0 = r0.zzhr()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzep r0 = (com.google.android.gms.internal.p000firebaseperf.zzep) r0     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda r0 = (com.google.android.gms.internal.p000firebaseperf.zzda) r0     // Catch:{ all -> 0x0144 }
            r1.add(r0)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r0 = com.google.android.gms.internal.p000firebaseperf.zzda.zzfu()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzaz r2 = com.google.android.gms.internal.p000firebaseperf.zzaz.ON_RESUME_TRACE_NAME     // Catch:{ all -> 0x0144 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = r0.zzae(r2)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r6.k     // Catch:{ all -> 0x0144 }
            long r3 = r3.zzcr()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = r2.zzak(r3)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r6.k     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzbg r4 = r6.l     // Catch:{ all -> 0x0144 }
            long r3 = r3.zza(r4)     // Catch:{ all -> 0x0144 }
            r2.zzal(r3)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzga r0 = r0.zzhr()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzep r0 = (com.google.android.gms.internal.p000firebaseperf.zzep) r0     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda r0 = (com.google.android.gms.internal.p000firebaseperf.zzda) r0     // Catch:{ all -> 0x0144 }
            r1.add(r0)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r0 = r7.zze((java.lang.Iterable<? extends com.google.android.gms.internal.p000firebaseperf.zzda>) r1)     // Catch:{ all -> 0x0144 }
            com.google.firebase.perf.internal.SessionManager r1 = com.google.firebase.perf.internal.SessionManager.zzcf()     // Catch:{ all -> 0x0144 }
            com.google.firebase.perf.internal.zzq r1 = r1.zzcg()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzcr r1 = r1.e()     // Catch:{ all -> 0x0144 }
            r0.zzb(r1)     // Catch:{ all -> 0x0144 }
            com.google.firebase.perf.internal.c r0 = r6.f14292d     // Catch:{ all -> 0x0144 }
            if (r0 != 0) goto L_0x0126
            com.google.firebase.perf.internal.c r0 = com.google.firebase.perf.internal.c.a()     // Catch:{ all -> 0x0144 }
            r6.f14292d = r0     // Catch:{ all -> 0x0144 }
        L_0x0126:
            com.google.firebase.perf.internal.c r0 = r6.f14292d     // Catch:{ all -> 0x0144 }
            if (r0 == 0) goto L_0x0139
            com.google.firebase.perf.internal.c r0 = r6.f14292d     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzga r7 = r7.zzhr()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzep r7 = (com.google.android.gms.internal.p000firebaseperf.zzep) r7     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzda r7 = (com.google.android.gms.internal.p000firebaseperf.zzda) r7     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.firebase-perf.zzbt r1 = com.google.android.gms.internal.p000firebaseperf.zzbt.FOREGROUND_BACKGROUND     // Catch:{ all -> 0x0144 }
            r0.a((com.google.android.gms.internal.p000firebaseperf.zzda) r7, (com.google.android.gms.internal.p000firebaseperf.zzbt) r1)     // Catch:{ all -> 0x0144 }
        L_0x0139:
            boolean r7 = r6.f14291c     // Catch:{ all -> 0x0144 }
            if (r7 == 0) goto L_0x0140
            r6.b()     // Catch:{ all -> 0x0144 }
        L_0x0140:
            monitor-exit(r6)
            return
        L_0x0142:
            monitor-exit(r6)
            return
        L_0x0144:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityResumed(android.app.Activity):void");
    }

    public synchronized void onActivityStopped(Activity activity) {
    }
}
