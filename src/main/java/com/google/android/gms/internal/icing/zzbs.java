package com.google.android.gms.internal.icing;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzbs implements zzbg {
    static final Map<String, zzbs> zzdn = new HashMap();
    private final Object zzcl = new Object();
    private volatile Map<String, ?> zzcm;
    private final List<zzbd> zzcn = new ArrayList();
    private final SharedPreferences zzdo;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzdp = new zzbr(this);

    static zzbs zza(Context context, String str) {
        zzbs zzbs;
        SharedPreferences sharedPreferences;
        if (!((!zzaz.zzk() || str.startsWith("direct_boot:")) ? true : zzaz.isUserUnlocked(context))) {
            return null;
        }
        synchronized (zzbs.class) {
            zzbs = zzdn.get(str);
            if (zzbs == null) {
                if (str.startsWith("direct_boot:")) {
                    if (zzaz.zzk()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(str.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(str, 0);
                }
                zzbs = new zzbs(sharedPreferences);
                zzdn.put(str, zzbs);
            }
        }
        return zzbs;
    }

    private zzbs(SharedPreferences sharedPreferences) {
        this.zzdo = sharedPreferences;
        this.zzdo.registerOnSharedPreferenceChangeListener(this.zzdp);
    }

    public final Object zzi(String str) {
        Map<String, ?> map = this.zzcm;
        if (map == null) {
            synchronized (this.zzcl) {
                map = this.zzcm;
                if (map == null) {
                    map = this.zzdo.getAll();
                    this.zzcm = map;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzcl) {
            this.zzcm = null;
            zzbo.zzr();
        }
        synchronized (this) {
            for (zzbd zzq : this.zzcn) {
                zzq.zzq();
            }
        }
    }
}
