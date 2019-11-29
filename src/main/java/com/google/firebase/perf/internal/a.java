package com.google.firebase.perf.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.app.f;
import com.google.android.gms.internal.p000firebaseperf.zzaw;
import com.google.android.gms.internal.p000firebaseperf.zzax;
import com.google.android.gms.internal.p000firebaseperf.zzaz;
import com.google.android.gms.internal.p000firebaseperf.zzbg;
import com.google.android.gms.internal.p000firebaseperf.zzbt;
import com.google.android.gms.internal.p000firebaseperf.zzda;
import com.google.android.gms.internal.p000firebaseperf.zzep;
import com.google.firebase.perf.metrics.Trace;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f14227a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14228b = false;

    /* renamed from: c  reason: collision with root package name */
    private c f14229c = null;

    /* renamed from: d  reason: collision with root package name */
    private final zzax f14230d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14231e = true;

    /* renamed from: f  reason: collision with root package name */
    private final WeakHashMap<Activity, Boolean> f14232f = new WeakHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private zzbg f14233g;
    private zzbg h;
    private final Map<String, Long> i = new HashMap();
    private AtomicInteger j = new AtomicInteger(0);
    private zzbt k = zzbt.BACKGROUND;
    private Set<WeakReference<C0235a>> l = new HashSet();
    private boolean m = false;
    private f n;
    private final WeakHashMap<Activity, Trace> o = new WeakHashMap<>();

    /* renamed from: com.google.firebase.perf.internal.a$a  reason: collision with other inner class name */
    public interface C0235a {
        void zza(zzbt zzbt);
    }

    public static a a() {
        if (f14227a != null) {
            return f14227a;
        }
        return a((c) null, new zzax());
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    private static a a(c cVar, zzax zzax) {
        if (f14227a == null) {
            synchronized (a.class) {
                if (f14227a == null) {
                    f14227a = new a((c) null, zzax);
                }
            }
        }
        return f14227a;
    }

    private a(c cVar, zzax zzax) {
        this.f14230d = zzax;
        this.m = e();
        if (this.m) {
            this.n = new f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f14228b     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0019 }
            boolean r0 = r2 instanceof android.app.Application     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0017
            android.app.Application r2 = (android.app.Application) r2     // Catch:{ all -> 0x0019 }
            r2.registerActivityLifecycleCallbacks(r1)     // Catch:{ all -> 0x0019 }
            r2 = 1
            r1.f14228b = r2     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.a.a(android.content.Context):void");
    }

    public final void a(String str, long j2) {
        synchronized (this.i) {
            Long l2 = this.i.get(str);
            if (l2 == null) {
                this.i.put(str, 1L);
            } else {
                this.i.put(str, Long.valueOf(l2.longValue() + 1));
            }
        }
    }

    public final void a(int i2) {
        this.j.addAndGet(1);
    }

    public synchronized void onActivityStarted(Activity activity) {
        if (this.m) {
            this.n.a(activity);
            d();
            Trace trace = new Trace(a(activity), this.f14229c, this.f14230d, this);
            trace.start();
            this.o.put(activity, trace);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityStopped(android.app.Activity r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = r10.m     // Catch:{ all -> 0x00ec }
            r1 = 0
            if (r0 == 0) goto L_0x00b9
            java.util.WeakHashMap<android.app.Activity, com.google.firebase.perf.metrics.Trace> r0 = r10.o     // Catch:{ all -> 0x00ec }
            boolean r0 = r0.containsKey(r11)     // Catch:{ all -> 0x00ec }
            if (r0 == 0) goto L_0x00b9
            java.util.WeakHashMap<android.app.Activity, com.google.firebase.perf.metrics.Trace> r0 = r10.o     // Catch:{ all -> 0x00ec }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x00ec }
            com.google.firebase.perf.metrics.Trace r0 = (com.google.firebase.perf.metrics.Trace) r0     // Catch:{ all -> 0x00ec }
            if (r0 == 0) goto L_0x00b9
            java.util.WeakHashMap<android.app.Activity, com.google.firebase.perf.metrics.Trace> r2 = r10.o     // Catch:{ all -> 0x00ec }
            r2.remove(r11)     // Catch:{ all -> 0x00ec }
            androidx.core.app.f r2 = r10.n     // Catch:{ all -> 0x00ec }
            android.util.SparseIntArray[] r2 = r2.b(r11)     // Catch:{ all -> 0x00ec }
            if (r2 == 0) goto L_0x0049
            r2 = r2[r1]     // Catch:{ all -> 0x00ec }
            if (r2 == 0) goto L_0x0049
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x002d:
            int r7 = r2.size()     // Catch:{ all -> 0x00ec }
            if (r3 >= r7) goto L_0x004c
            int r7 = r2.keyAt(r3)     // Catch:{ all -> 0x00ec }
            int r8 = r2.valueAt(r3)     // Catch:{ all -> 0x00ec }
            int r4 = r4 + r8
            r9 = 700(0x2bc, float:9.81E-43)
            if (r7 <= r9) goto L_0x0041
            int r6 = r6 + r8
        L_0x0041:
            r9 = 16
            if (r7 <= r9) goto L_0x0046
            int r5 = r5 + r8
        L_0x0046:
            int r3 = r3 + 1
            goto L_0x002d
        L_0x0049:
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x004c:
            if (r4 <= 0) goto L_0x0058
            com.google.android.gms.internal.firebase-perf.zzaw r2 = com.google.android.gms.internal.p000firebaseperf.zzaw.FRAMES_TOTAL     // Catch:{ all -> 0x00ec }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ec }
            long r7 = (long) r4     // Catch:{ all -> 0x00ec }
            r0.putMetric(r2, r7)     // Catch:{ all -> 0x00ec }
        L_0x0058:
            if (r5 <= 0) goto L_0x0064
            com.google.android.gms.internal.firebase-perf.zzaw r2 = com.google.android.gms.internal.p000firebaseperf.zzaw.FRAMES_SLOW     // Catch:{ all -> 0x00ec }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ec }
            long r7 = (long) r5     // Catch:{ all -> 0x00ec }
            r0.putMetric(r2, r7)     // Catch:{ all -> 0x00ec }
        L_0x0064:
            if (r6 <= 0) goto L_0x0070
            com.google.android.gms.internal.firebase-perf.zzaw r2 = com.google.android.gms.internal.p000firebaseperf.zzaw.FRAMES_FROZEN     // Catch:{ all -> 0x00ec }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ec }
            long r7 = (long) r6     // Catch:{ all -> 0x00ec }
            r0.putMetric(r2, r7)     // Catch:{ all -> 0x00ec }
        L_0x0070:
            android.content.Context r2 = r11.getApplicationContext()     // Catch:{ all -> 0x00ec }
            boolean r2 = com.google.android.gms.internal.p000firebaseperf.zzbk.zzg(r2)     // Catch:{ all -> 0x00ec }
            if (r2 == 0) goto L_0x00b6
            java.lang.String r2 = "FirebasePerformance"
            java.lang.String r3 = a((android.app.Activity) r11)     // Catch:{ all -> 0x00ec }
            java.lang.String r7 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x00ec }
            int r7 = r7.length()     // Catch:{ all -> 0x00ec }
            int r7 = r7 + 81
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ec }
            r8.<init>(r7)     // Catch:{ all -> 0x00ec }
            java.lang.String r7 = "sendScreenTrace name:"
            r8.append(r7)     // Catch:{ all -> 0x00ec }
            r8.append(r3)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = " _fr_tot:"
            r8.append(r3)     // Catch:{ all -> 0x00ec }
            r8.append(r4)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = " _fr_slo:"
            r8.append(r3)     // Catch:{ all -> 0x00ec }
            r8.append(r5)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = " _fr_fzn:"
            r8.append(r3)     // Catch:{ all -> 0x00ec }
            r8.append(r6)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r8.toString()     // Catch:{ all -> 0x00ec }
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x00ec }
        L_0x00b6:
            r0.stop()     // Catch:{ all -> 0x00ec }
        L_0x00b9:
            java.util.WeakHashMap<android.app.Activity, java.lang.Boolean> r0 = r10.f14232f     // Catch:{ all -> 0x00ec }
            boolean r0 = r0.containsKey(r11)     // Catch:{ all -> 0x00ec }
            if (r0 == 0) goto L_0x00ea
            java.util.WeakHashMap<android.app.Activity, java.lang.Boolean> r0 = r10.f14232f     // Catch:{ all -> 0x00ec }
            r0.remove(r11)     // Catch:{ all -> 0x00ec }
            java.util.WeakHashMap<android.app.Activity, java.lang.Boolean> r11 = r10.f14232f     // Catch:{ all -> 0x00ec }
            boolean r11 = r11.isEmpty()     // Catch:{ all -> 0x00ec }
            if (r11 == 0) goto L_0x00ea
            com.google.android.gms.internal.firebase-perf.zzbg r11 = new com.google.android.gms.internal.firebase-perf.zzbg     // Catch:{ all -> 0x00ec }
            r11.<init>()     // Catch:{ all -> 0x00ec }
            r10.f14233g = r11     // Catch:{ all -> 0x00ec }
            com.google.android.gms.internal.firebase-perf.zzbt r11 = com.google.android.gms.internal.p000firebaseperf.zzbt.BACKGROUND     // Catch:{ all -> 0x00ec }
            r10.a((com.google.android.gms.internal.p000firebaseperf.zzbt) r11)     // Catch:{ all -> 0x00ec }
            r10.a((boolean) r1)     // Catch:{ all -> 0x00ec }
            com.google.android.gms.internal.firebase-perf.zzaz r11 = com.google.android.gms.internal.p000firebaseperf.zzaz.FOREGROUND_TRACE_NAME     // Catch:{ all -> 0x00ec }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00ec }
            com.google.android.gms.internal.firebase-perf.zzbg r0 = r10.h     // Catch:{ all -> 0x00ec }
            com.google.android.gms.internal.firebase-perf.zzbg r1 = r10.f14233g     // Catch:{ all -> 0x00ec }
            r10.a(r11, r0, r1)     // Catch:{ all -> 0x00ec }
        L_0x00ea:
            monitor-exit(r10)
            return
        L_0x00ec:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x00f0
        L_0x00ef:
            throw r11
        L_0x00f0:
            goto L_0x00ef
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.a.onActivityStopped(android.app.Activity):void");
    }

    public synchronized void onActivityResumed(Activity activity) {
        if (this.f14232f.isEmpty()) {
            this.h = new zzbg();
            this.f14232f.put(activity, true);
            if (this.f14231e) {
                a(zzbt.FOREGROUND);
                a(true);
                this.f14231e = false;
                return;
            }
            a(zzbt.FOREGROUND);
            a(true);
            a(zzaz.BACKGROUND_TRACE_NAME.toString(), this.f14233g, this.h);
            return;
        }
        this.f14232f.put(activity, true);
    }

    public final boolean b() {
        return this.f14231e;
    }

    public final zzbt c() {
        return this.k;
    }

    public final void a(WeakReference<C0235a> weakReference) {
        synchronized (this.l) {
            this.l.add(weakReference);
        }
    }

    public final void b(WeakReference<C0235a> weakReference) {
        synchronized (this.l) {
            this.l.remove(weakReference);
        }
    }

    private final void a(zzbt zzbt) {
        this.k = zzbt;
        synchronized (this.l) {
            Iterator<WeakReference<C0235a>> it = this.l.iterator();
            while (it.hasNext()) {
                C0235a aVar = (C0235a) it.next().get();
                if (aVar != null) {
                    aVar.zza(this.k);
                } else {
                    it.remove();
                }
            }
        }
    }

    private final void a(String str, zzbg zzbg, zzbg zzbg2) {
        d();
        zzda.zzb zzb = zzda.zzfu().zzae(str).zzak(zzbg.zzcr()).zzal(zzbg.zza(zzbg2)).zzb(SessionManager.zzcf().zzcg().e());
        int andSet = this.j.getAndSet(0);
        synchronized (this.i) {
            zzb.zze(this.i);
            if (andSet != 0) {
                zzb.zzd(zzaw.TRACE_STARTED_NOT_STOPPED.toString(), (long) andSet);
            }
            this.i.clear();
        }
        c cVar = this.f14229c;
        if (cVar != null) {
            cVar.a((zzda) ((zzep) zzb.zzhr()), zzbt.FOREGROUND_BACKGROUND);
        }
    }

    private final void a(boolean z) {
        d();
        c cVar = this.f14229c;
        if (cVar != null) {
            cVar.a(z);
        }
    }

    private final void d() {
        if (this.f14229c == null) {
            this.f14229c = c.a();
        }
    }

    private static boolean e() {
        try {
            Class.forName("androidx.core.app.f");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static String a(Activity activity) {
        String valueOf = String.valueOf(activity.getClass().getSimpleName());
        return valueOf.length() != 0 ? "_st_".concat(valueOf) : new String("_st_");
    }
}
