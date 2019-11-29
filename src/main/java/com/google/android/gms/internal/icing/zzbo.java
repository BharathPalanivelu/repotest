package com.google.android.gms.internal.icing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzbo<T> {
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzcr = null;
    private static final Object zzcw = new Object();
    private static boolean zzcx = false;
    private static final AtomicInteger zzda = new AtomicInteger();
    private final String name;
    private final zzbp zzcy;
    private final T zzcz;
    private volatile int zzdb;
    private volatile T zzdc;

    public static void zze(Context context) {
        synchronized (zzcw) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzcr != context) {
                synchronized (zzbc.class) {
                    zzbc.zzcj.clear();
                }
                synchronized (zzbs.class) {
                    zzbs.zzdn.clear();
                }
                synchronized (zzbh.class) {
                    zzbh.zzcq = null;
                }
                zzda.incrementAndGet();
                zzcr = context;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    static void zzr() {
        zzda.incrementAndGet();
    }

    private zzbo(zzbp zzbp, String str, T t) {
        this.zzdb = -1;
        if (zzbp.zzde != null) {
            this.zzcy = zzbp;
            this.name = str;
            this.zzcz = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    private final String zzm(String str) {
        if (str != null && str.isEmpty()) {
            return this.name;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.name);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zzs() {
        return zzm(this.zzcy.zzdg);
    }

    public final T get() {
        int i = zzda.get();
        if (this.zzdb < i) {
            synchronized (this) {
                if (this.zzdb < i) {
                    if (zzcr != null) {
                        zzbp zzbp = this.zzcy;
                        T zzt = zzt();
                        if (zzt == null) {
                            zzt = zzu();
                            if (zzt == null) {
                                zzt = this.zzcz;
                            }
                        }
                        this.zzdc = zzt;
                        this.zzdb = i;
                    } else {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                }
            }
        }
        return this.zzdc;
    }

    private final T zzt() {
        zzbg zzbg;
        zzbp zzbp = this.zzcy;
        String str = (String) zzbh.zzc(zzcr).zzi("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
        if (!(str != null && zzax.zzbt.matcher(str).matches())) {
            if (this.zzcy.zzde == null) {
                Context context = zzcr;
                zzbp zzbp2 = this.zzcy;
                zzbg = zzbs.zza(context, (String) null);
            } else if (zzbm.zza(zzcr, this.zzcy.zzde)) {
                zzbp zzbp3 = this.zzcy;
                zzbg = zzbc.zza(zzcr.getContentResolver(), this.zzcy.zzde);
            } else {
                zzbg = null;
            }
            if (zzbg != null) {
                Object zzi = zzbg.zzi(zzs());
                if (zzi != null) {
                    return zza(zzi);
                }
            }
        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
            String valueOf = String.valueOf(zzs());
            Log.d("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
        }
        return null;
    }

    private final T zzu() {
        zzbp zzbp = this.zzcy;
        Object zzi = zzbh.zzc(zzcr).zzi(zzm(this.zzcy.zzdf));
        if (zzi != null) {
            return zza(zzi);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static zzbo<Boolean> zza(zzbp zzbp, String str, boolean z) {
        return new zzbq(zzbp, str, Boolean.valueOf(z));
    }

    /* synthetic */ zzbo(zzbp zzbp, String str, Object obj, zzbn zzbn) {
        this(zzbp, str, obj);
    }
}
