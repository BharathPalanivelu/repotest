package com.google.firebase.perf.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.internal.p000firebaseperf.zzaw;
import com.google.android.gms.internal.p000firebaseperf.zzbk;
import com.google.android.gms.internal.p000firebaseperf.zzbn;
import com.google.android.gms.internal.p000firebaseperf.zzbr;
import com.google.android.gms.internal.p000firebaseperf.zzbt;
import com.google.android.gms.internal.p000firebaseperf.zzcd;
import com.google.android.gms.internal.p000firebaseperf.zzci;
import com.google.android.gms.internal.p000firebaseperf.zzcn;
import com.google.android.gms.internal.p000firebaseperf.zzda;
import com.google.android.gms.internal.p000firebaseperf.zzep;
import com.google.firebase.b;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.perf.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static c f14234a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f14235b = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: c  reason: collision with root package name */
    private b f14236c;

    /* renamed from: d  reason: collision with root package name */
    private a f14237d;

    /* renamed from: e  reason: collision with root package name */
    private FirebaseInstanceId f14238e = null;

    /* renamed from: f  reason: collision with root package name */
    private Context f14239f;

    /* renamed from: g  reason: collision with root package name */
    private ClearcutLogger f14240g = null;
    private String h;
    private final zzbr.zzb i = zzbr.zzdg();
    private r j = null;
    private a k = null;
    private FeatureControl l = null;
    private boolean m;

    public static c a() {
        if (f14234a == null) {
            synchronized (c.class) {
                if (f14234a == null) {
                    try {
                        b.d();
                        f14234a = new c((ExecutorService) null, (ClearcutLogger) null, (r) null, (a) null, (FirebaseInstanceId) null, (FeatureControl) null);
                    } catch (IllegalStateException unused) {
                        return null;
                    }
                }
            }
        }
        return f14234a;
    }

    private c(ExecutorService executorService, ClearcutLogger clearcutLogger, r rVar, a aVar, FirebaseInstanceId firebaseInstanceId, FeatureControl featureControl) {
        this.f14235b.execute(new f(this));
    }

    public final void a(zzda zzda, zzbt zzbt) {
        this.f14235b.execute(new e(this, zzda, zzbt));
        SessionManager.zzcf().zzch();
    }

    public final void a(zzci zzci, zzbt zzbt) {
        this.f14235b.execute(new h(this, zzci, zzbt));
        SessionManager.zzcf().zzch();
    }

    public final void a(zzcd zzcd, zzbt zzbt) {
        this.f14235b.execute(new g(this, zzcd, zzbt));
        SessionManager.zzcf().zzch();
    }

    public final void a(boolean z) {
        this.f14235b.execute(new j(this, z));
    }

    /* access modifiers changed from: private */
    public final void b() {
        this.f14236c = b.d();
        this.f14237d = a.a();
        this.f14239f = this.f14236c.a();
        this.h = this.f14236c.c().b();
        this.i.zzv(this.h).zzb(zzbn.zzcv().zzq(this.f14239f.getPackageName()).zzr("1.0.0.249530108").zzs(a(this.f14239f)));
        c();
        if (this.f14240g == null) {
            try {
                this.f14240g = ClearcutLogger.anonymousLogger(this.f14239f, "FIREPERF");
            } catch (SecurityException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.w("FirebasePerformance", valueOf.length() != 0 ? "Caught SecurityException while init ClearcutLogger: ".concat(valueOf) : new String("Caught SecurityException while init ClearcutLogger: "));
                this.f14240g = null;
            }
        }
        r rVar = this.j;
        if (rVar == null) {
            rVar = new r(this.f14239f, 100, 500);
        }
        this.j = rVar;
        a aVar = this.k;
        if (aVar == null) {
            aVar = a.a();
        }
        this.k = aVar;
        FeatureControl featureControl = this.l;
        if (featureControl == null) {
            featureControl = FeatureControl.zzao();
        }
        this.l = featureControl;
        this.m = zzbk.zzg(this.f14239f);
    }

    private final void a(zzcn zzcn) {
        if (this.f14240g == null || !d()) {
            return;
        }
        if (!zzcn.zzfb().zzdb()) {
            Log.w("FirebasePerformance", "App Instance ID is null or empty, dropping the log");
            return;
        }
        Context context = this.f14239f;
        ArrayList arrayList = new ArrayList();
        if (zzcn.zzfc()) {
            arrayList.add(new k(zzcn.zzfd()));
        }
        if (zzcn.zzfe()) {
            arrayList.add(new l(zzcn.zzff(), context));
        }
        if (zzcn.zzfa()) {
            arrayList.add(new d(zzcn.zzfb()));
        }
        if (zzcn.zzfg()) {
            arrayList.add(new i(zzcn.zzfh()));
        }
        boolean z = false;
        if (!arrayList.isEmpty()) {
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = true;
                    break;
                }
                Object obj = arrayList2.get(i2);
                i2++;
                if (!((q) obj).a()) {
                    break;
                }
            }
        } else {
            Log.d("FirebasePerformance", "No validators found for PerfMetric.");
        }
        if (!z) {
            Log.w("FirebasePerformance", "Unable to process the PerfMetric due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values.");
        } else if (!this.j.a(zzcn)) {
            if (zzcn.zzfe()) {
                this.k.a(zzaw.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1);
            } else if (zzcn.zzfc()) {
                this.k.a(zzaw.TRACE_EVENT_RATE_LIMITED.toString(), 1);
            }
            if (!this.m) {
                return;
            }
            if (zzcn.zzfe()) {
                String valueOf = String.valueOf(zzcn.zzff().getUrl());
                Log.i("FirebasePerformance", valueOf.length() != 0 ? "Rate Limited NetworkRequestMetric - ".concat(valueOf) : new String("Rate Limited NetworkRequestMetric - "));
            } else if (zzcn.zzfc()) {
                String valueOf2 = String.valueOf(zzcn.zzfd().getName());
                Log.i("FirebasePerformance", valueOf2.length() != 0 ? "Rate Limited TraceMetric - ".concat(valueOf2) : new String("Rate Limited TraceMetric - "));
            }
        } else {
            try {
                this.f14240g.newEvent(zzcn.toByteArray()).log();
            } catch (SecurityException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b(zzcd zzcd, zzbt zzbt) {
        if (d()) {
            if (this.m) {
                Log.d("FirebasePerformance", String.format("Logging GaugeMetric. Cpu Metrics: %d, Memory Metrics: %d, Has Metadata: %b, Session ID: %s", new Object[]{Integer.valueOf(zzcd.zzdv()), Integer.valueOf(zzcd.zzdw()), Boolean.valueOf(zzcd.zzdt()), zzcd.zzds()}));
            }
            if (this.l.zzap()) {
                zzcn.zza zzfi = zzcn.zzfi();
                c();
                zzfi.zzb(this.i.zzf(zzbt)).zzb(zzcd);
                a((zzcn) ((zzep) zzfi.zzhr()));
            } else if (this.m) {
                Log.d("FirebasePerformance", "Sessions are disabled. Not logging GaugeMetric.");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b(zzda zzda, zzbt zzbt) {
        Map<String, String> map;
        if (d()) {
            if (this.m) {
                Log.d("FirebasePerformance", String.format("Logging TraceMetric - %s %dms", new Object[]{zzda.getName(), Long.valueOf(zzda.getDurationUs() / 1000)}));
            }
            if (!this.l.zzap()) {
                zzda = (zzda) ((zzep) ((zzda.zzb) zzda.zzhg()).zzfx().zzhr());
                if (this.m) {
                    Log.d("FirebasePerformance", String.format("Sessions are disabled. Dropping all sessions from Trace - %s", new Object[]{zzda.getName()}));
                }
            }
            c();
            zzcn.zza zzfi = zzcn.zzfi();
            zzbr.zzb zzf = ((zzbr.zzb) ((zzep.zzb) this.i.clone())).zzf(zzbt);
            e();
            a aVar = this.f14237d;
            if (aVar != null) {
                map = aVar.c();
            } else {
                map = Collections.emptyMap();
            }
            a((zzcn) ((zzep) zzfi.zzb(zzf.zzc(map)).zzb(zzda).zzhr()));
        }
    }

    /* access modifiers changed from: private */
    public final void b(zzci zzci, zzbt zzbt) {
        long j2;
        if (d()) {
            if (this.m) {
                long j3 = 0;
                if (!zzci.zzeq()) {
                    j2 = 0;
                } else {
                    j2 = zzci.zzer();
                }
                if (zzci.zzeg()) {
                    j3 = zzci.zzeh();
                }
                Log.d("FirebasePerformance", String.format("Logging NetworkRequestMetric - %s %db %dms,", new Object[]{zzci.getUrl(), Long.valueOf(j3), Long.valueOf(j2 / 1000)}));
            }
            if (!this.l.zzap()) {
                zzci = (zzci) ((zzep) ((zzci.zza) zzci.zzhg()).zzez().zzhr());
                if (this.m) {
                    Log.d("FirebasePerformance", String.format("Sessions are disabled. Dropping all sessions from Network Request - %s", new Object[]{zzci.getUrl()}));
                }
            }
            c();
            a((zzcn) ((zzep) zzcn.zzfi().zzb(this.i.zzf(zzbt)).zze(zzci).zzhr()));
        }
    }

    public final void b(boolean z) {
        this.j.a(z);
    }

    private static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    private final void c() {
        if (!this.i.zzdb() && d()) {
            if (this.f14238e == null) {
                this.f14238e = FirebaseInstanceId.getInstance();
            }
            String id = this.f14238e.getId();
            if (id != null && !id.isEmpty()) {
                this.i.zzw(id);
            }
        }
    }

    private final boolean d() {
        e();
        a aVar = this.f14237d;
        if (aVar != null) {
            return aVar.b();
        }
        return false;
    }

    private final void e() {
        if (this.f14237d == null) {
            this.f14237d = this.f14236c != null ? a.a() : null;
        }
    }
}
