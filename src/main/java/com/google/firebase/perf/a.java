package com.google.firebase.perf;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.zzay;
import com.google.firebase.b;
import com.google.firebase.perf.internal.FeatureControl;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.metrics.Trace;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f14220a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f14221b;

    /* renamed from: c  reason: collision with root package name */
    private final zzay f14222c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f14223d;

    public static a a() {
        if (f14220a == null) {
            synchronized (a.class) {
                if (f14220a == null) {
                    f14220a = (a) b.d().a(a.class);
                }
            }
        }
        return f14220a;
    }

    a(b bVar, com.google.firebase.remoteconfig.a aVar) {
        this(bVar, aVar, RemoteConfigManager.zzbz(), FeatureControl.zzao(), GaugeManager.zzbf());
    }

    private a(b bVar, com.google.firebase.remoteconfig.a aVar, RemoteConfigManager remoteConfigManager, FeatureControl featureControl, GaugeManager gaugeManager) {
        this.f14221b = new ConcurrentHashMap();
        this.f14223d = null;
        if (bVar == null) {
            this.f14223d = false;
            this.f14222c = new zzay(new Bundle());
            return;
        }
        Context a2 = bVar.a();
        this.f14222c = b(a2);
        this.f14223d = a(a2);
        remoteConfigManager.zza(aVar);
        remoteConfigManager.zza(bVar);
        featureControl.zza(this.f14222c);
        gaugeManager.zze(a2);
    }

    public void a(boolean z) {
        try {
            b.d();
            SharedPreferences sharedPreferences = b.d().a().getSharedPreferences("FirebasePerfSharedPrefs", 0);
            if (!d()) {
                sharedPreferences.edit().putBoolean("isEnabled", z).apply();
                this.f14223d = Boolean.valueOf(z);
                if (z) {
                    Log.i("FirebasePerformance", "Firebase Performance is Enabled");
                } else {
                    Log.i("FirebasePerformance", "Firebase Performance is Disabled");
                }
            } else {
                Log.i("FirebasePerformance", "Firebase Performance is permanently disabled");
            }
        } catch (IllegalStateException unused) {
        }
    }

    public boolean b() {
        Boolean bool = this.f14223d;
        if (bool != null) {
            return bool.booleanValue();
        }
        return b.d().e();
    }

    public final Map<String, String> c() {
        return new HashMap(this.f14221b);
    }

    private final Boolean a(Context context) {
        if (d()) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("FirebasePerfSharedPrefs", 0);
        try {
            if (sharedPreferences.contains("isEnabled")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("isEnabled", true));
            }
        } catch (ClassCastException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.d("FirebasePerformance", valueOf.length() != 0 ? "Unable to access enable value: ".concat(valueOf) : new String("Unable to access enable value: "));
        }
        if (this.f14222c.containsKey("firebase_performance_collection_enabled")) {
            return Boolean.valueOf(this.f14222c.getBoolean("firebase_performance_collection_enabled", true));
        }
        Log.d("isEnabled", "No perf enable meta data found in manifest.");
        return null;
    }

    public Trace a(String str) {
        return Trace.a(str);
    }

    private final boolean d() {
        return this.f14222c.getBoolean("firebase_performance_collection_deactivated", false);
    }

    private static zzay b(Context context) {
        Bundle bundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.d("isEnabled", valueOf.length() != 0 ? "No perf enable meta data found ".concat(valueOf) : new String("No perf enable meta data found "));
            bundle = null;
        }
        return bundle != null ? new zzay(bundle) : new zzay();
    }
}
