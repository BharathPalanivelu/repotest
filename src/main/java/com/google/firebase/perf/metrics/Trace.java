package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.p000firebaseperf.zzax;
import com.google.android.gms.internal.p000firebaseperf.zzaz;
import com.google.android.gms.internal.p000firebaseperf.zzbg;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.internal.a;
import com.google.firebase.perf.internal.b;
import com.google.firebase.perf.internal.c;
import com.google.firebase.perf.internal.q;
import com.google.firebase.perf.internal.y;
import com.google.firebase.perf.internal.zzq;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Trace extends b implements Parcelable, y {
    @Keep
    public static final Parcelable.Creator<Trace> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Trace> f14297a = new ConcurrentHashMap();
    @VisibleForTesting
    private static final Parcelable.Creator<Trace> n = new d();

    /* renamed from: b  reason: collision with root package name */
    private final Trace f14298b;

    /* renamed from: c  reason: collision with root package name */
    private final GaugeManager f14299c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14300d;

    /* renamed from: e  reason: collision with root package name */
    private final List<zzq> f14301e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Trace> f14302f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, zza> f14303g;
    private final zzax h;
    private final c i;
    private final Map<String, String> j;
    private zzbg k;
    private zzbg l;
    private final WeakReference<y> m;

    @Keep
    public int describeContents() {
        return 0;
    }

    public final void zza(zzq zzq) {
        if (h() && !g()) {
            this.f14301e.add(zzq);
        }
    }

    public static Trace a(String str) {
        return new Trace(str);
    }

    private Trace(String str) {
        this(str, c.a(), new zzax(), a.a(), GaugeManager.zzbf());
    }

    public Trace(String str, c cVar, zzax zzax, a aVar) {
        this(str, cVar, zzax, aVar, GaugeManager.zzbf());
    }

    private Trace(String str, c cVar, zzax zzax, a aVar, GaugeManager gaugeManager) {
        super(aVar);
        this.m = new WeakReference<>(this);
        this.f14298b = null;
        this.f14300d = str.trim();
        this.f14302f = new ArrayList();
        this.f14303g = new ConcurrentHashMap();
        this.j = new ConcurrentHashMap();
        this.h = zzax;
        this.i = cVar;
        this.f14301e = new ArrayList();
        this.f14299c = gaugeManager;
    }

    @Keep
    public void start() {
        String str;
        String str2 = this.f14300d;
        if (str2 == null) {
            str = "Trace name must not be null";
        } else if (str2.length() > 100) {
            str = String.format(Locale.US, "Trace name must not exceed %d characters", new Object[]{100});
        } else {
            if (str2.startsWith("_")) {
                zzaz[] values = zzaz.values();
                int length = values.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        if (values[i2].toString().equals(str2)) {
                            break;
                        }
                        i2++;
                    } else if (!str2.startsWith("_st_")) {
                        str = "Trace name must not start with '_'";
                    }
                }
            }
            str = null;
        }
        if (str != null) {
            Log.e("FirebasePerformance", String.format("Cannot start trace %s. Trace name is invalid.(%s)", new Object[]{this.f14300d, str}));
        } else if (this.k != null) {
            Log.e("FirebasePerformance", String.format("Trace '%s' has already started, should not start again!", new Object[]{this.f14300d}));
        } else {
            zzay();
            zzq zzcg = SessionManager.zzcf().zzcg();
            SessionManager.zzcf().zzc(this.m);
            this.f14301e.add(zzcg);
            this.k = new zzbg();
            Log.i("FirebasePerformance", String.format("Session ID - %s", new Object[]{zzcg.b()}));
            if (zzcg.c()) {
                this.f14299c.zzbh();
            }
        }
    }

    @Keep
    public void stop() {
        if (!h()) {
            Log.e("FirebasePerformance", String.format("Trace '%s' has not been started so unable to stop!", new Object[]{this.f14300d}));
        } else if (g()) {
            Log.e("FirebasePerformance", String.format("Trace '%s' has already stopped, should not stop again!", new Object[]{this.f14300d}));
        } else {
            SessionManager.zzcf().zzd(this.m);
            zzaz();
            this.l = new zzbg();
            if (this.f14298b == null) {
                zzbg zzbg = this.l;
                if (!this.f14302f.isEmpty()) {
                    Trace trace = this.f14302f.get(this.f14302f.size() - 1);
                    if (trace.l == null) {
                        trace.l = zzbg;
                    }
                }
                if (!this.f14300d.isEmpty()) {
                    c cVar = this.i;
                    if (cVar != null) {
                        cVar.a(new c(this).a(), zzal());
                        if (SessionManager.zzcf().zzcg().c()) {
                            this.f14299c.zzbh();
                            return;
                        }
                        return;
                    }
                    return;
                }
                Log.e("FirebasePerformance", "Trace name is empty, no log is sent to server");
            }
        }
    }

    private final zza b(String str) {
        zza zza = this.f14303g.get(str);
        if (zza != null) {
            return zza;
        }
        zza zza2 = new zza(str);
        this.f14303g.put(str, zza2);
        return zza2;
    }

    @Keep
    public void incrementMetric(String str, long j2) {
        String a2 = q.a(str);
        if (a2 != null) {
            Log.e("FirebasePerformance", String.format("Cannot increment metric %s. Metric name is invalid.(%s)", new Object[]{str, a2}));
        } else if (!h()) {
            Log.w("FirebasePerformance", String.format("Cannot increment metric '%s' for trace '%s' because it's not started", new Object[]{str, this.f14300d}));
        } else if (g()) {
            Log.w("FirebasePerformance", String.format("Cannot increment metric '%s' for trace '%s' because it's been stopped", new Object[]{str, this.f14300d}));
        } else {
            b(str.trim()).a(j2);
        }
    }

    @Keep
    public long getLongMetric(String str) {
        zza zza = str != null ? this.f14303g.get(str.trim()) : null;
        if (zza == null) {
            return 0;
        }
        return zza.b();
    }

    @Keep
    public void putMetric(String str, long j2) {
        String a2 = q.a(str);
        if (a2 != null) {
            Log.e("FirebasePerformance", String.format("Cannot set value for metric %s. Metric name is invalid.(%s)", new Object[]{str, a2}));
        } else if (!h()) {
            Log.w("FirebasePerformance", String.format("Cannot set value for metric '%s' for trace '%s' because it's not started", new Object[]{str, this.f14300d}));
        } else if (g()) {
            Log.w("FirebasePerformance", String.format("Cannot set value for metric '%s' for trace '%s' because it's been stopped", new Object[]{str, this.f14300d}));
        } else {
            b(str.trim()).b(j2);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (h() && !g()) {
                Log.w("FirebasePerformance", String.format("Trace '%s' is started but not stopped when it is destructed!", new Object[]{this.f14300d}));
                zzc(1);
            }
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final String a() {
        return this.f14300d;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final Map<String, zza> b() {
        return this.f14303g;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzbg c() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzbg d() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final List<Trace> e() {
        return this.f14302f;
    }

    @VisibleForTesting
    private final boolean g() {
        return this.l != null;
    }

    @VisibleForTesting
    private final boolean h() {
        return this.k != null;
    }

    @Keep
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f14298b, 0);
        parcel.writeString(this.f14300d);
        parcel.writeList(this.f14302f);
        parcel.writeMap(this.f14303g);
        parcel.writeParcelable(this.k, 0);
        parcel.writeParcelable(this.l, 0);
        parcel.writeList(this.f14301e);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private Trace(Parcel parcel, boolean z) {
        super(z ? null : a.a());
        this.m = new WeakReference<>(this);
        this.f14298b = (Trace) parcel.readParcelable(Trace.class.getClassLoader());
        this.f14300d = parcel.readString();
        this.f14302f = new ArrayList();
        parcel.readList(this.f14302f, Trace.class.getClassLoader());
        this.f14303g = new ConcurrentHashMap();
        this.j = new ConcurrentHashMap();
        parcel.readMap(this.f14303g, zza.class.getClassLoader());
        this.k = (zzbg) parcel.readParcelable(zzbg.class.getClassLoader());
        this.l = (zzbg) parcel.readParcelable(zzbg.class.getClassLoader());
        this.f14301e = new ArrayList();
        parcel.readList(this.f14301e, zzq.class.getClassLoader());
        if (z) {
            this.i = null;
            this.h = null;
            this.f14299c = null;
            return;
        }
        this.i = c.a();
        this.h = new zzax();
        this.f14299c = GaugeManager.zzbf();
    }

    @Keep
    public void putAttribute(String str, String str2) {
        boolean z = false;
        try {
            str = str.trim();
            str2 = str2.trim();
            if (!g()) {
                if (!this.j.containsKey(str)) {
                    if (this.j.size() >= 5) {
                        throw new IllegalArgumentException(String.format(Locale.US, "Exceeds max limit of number of attributes - %d", new Object[]{5}));
                    }
                }
                String a2 = q.a((Map.Entry<String, String>) new AbstractMap.SimpleEntry(str, str2));
                if (a2 == null) {
                    z = true;
                    if (z) {
                        this.j.put(str, str2);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(a2);
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Trace %s has been stopped", new Object[]{this.f14300d}));
        } catch (Exception e2) {
            Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", new Object[]{str, str2, e2.getMessage()}));
        }
    }

    @Keep
    public void removeAttribute(String str) {
        if (g()) {
            Log.e("FirebasePerformance", "Can't remove a attribute from a Trace that's stopped.");
        } else {
            this.j.remove(str);
        }
    }

    @Keep
    public String getAttribute(String str) {
        return this.j.get(str);
    }

    @Keep
    public Map<String, String> getAttributes() {
        return new HashMap(this.j);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final List<zzq> f() {
        return this.f14301e;
    }

    /* synthetic */ Trace(Parcel parcel, boolean z, b bVar) {
        this(parcel, z);
    }
}
