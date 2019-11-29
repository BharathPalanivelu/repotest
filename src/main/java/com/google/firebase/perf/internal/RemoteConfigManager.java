package com.google.firebase.perf.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.p000firebaseperf.zzb;
import com.google.android.gms.internal.p000firebaseperf.zzbb;
import com.google.android.gms.internal.p000firebaseperf.zzh;
import com.google.android.gms.internal.p000firebaseperf.zzk;
import com.google.android.gms.internal.p000firebaseperf.zzr;
import com.google.android.gms.internal.p000firebaseperf.zzu;
import com.google.android.gms.internal.p000firebaseperf.zzv;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.b;
import com.google.firebase.remoteconfig.a;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Keep
public class RemoteConfigManager {
    private static final RemoteConfigManager zzfb = new RemoteConfigManager();
    private static final long zzfc = TimeUnit.HOURS.toMillis(12);
    private final Executor executor;
    private b zzcp;
    private boolean zzfd;
    private long zzfe;
    private zzh<zzv<String, Long>> zzff;
    private zzv<String, Long> zzfg;
    private a zzfh;

    private RemoteConfigManager() {
        this(new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue()), (a) null, (b) null);
    }

    @VisibleForTesting
    private RemoteConfigManager(Executor executor2, a aVar, b bVar) {
        this.zzfd = false;
        this.zzfe = 0;
        this.zzff = zzk.zza(new v(this));
        this.zzfg = zzv.zzj();
        this.executor = executor2;
        this.zzfh = null;
        this.zzcp = null;
    }

    public static RemoteConfigManager zzbz() {
        return zzfb;
    }

    public final void zza(a aVar) {
        this.zzfh = aVar;
    }

    public final void zza(b bVar) {
        this.zzcp = bVar;
    }

    public final long zzc(String str, long j) {
        zzca();
        long longValue = this.zzfg.getOrDefault(zzbb.zzl(str), Long.valueOf(j)).longValue();
        if (!zzcc()) {
            return longValue;
        }
        String a2 = this.zzfh.a(zzbb.zzm(str));
        try {
            longValue = (long) (((float) Long.parseLong(a2)) * 100.0f);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
            sb.append("Fetched value: ");
            sb.append(longValue);
            sb.append(" for key: ");
            sb.append(str);
            sb.append(" from firebase remote config.");
            Log.d("FirebasePerformance", sb.toString());
            return longValue;
        } catch (NumberFormatException unused) {
            if (a2.isEmpty()) {
                return longValue;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(a2).length() + 45 + String.valueOf(str).length());
            sb2.append("Could not parse value: ");
            sb2.append(a2);
            sb2.append(" for key: ");
            sb2.append(str);
            sb2.append(" into a long");
            Log.d("FirebasePerformance", sb2.toString());
            return longValue;
        }
    }

    public final float zza(String str, float f2) {
        zzca();
        Long l = this.zzfg.get(zzbb.zzl(str));
        if (l != null) {
            f2 = (float) l.longValue();
        }
        if (!zzcc()) {
            return f2;
        }
        String a2 = this.zzfh.a(zzbb.zzm(str));
        try {
            return 100.0f * Float.parseFloat(a2);
        } catch (NumberFormatException unused) {
            if (a2.isEmpty()) {
                return f2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 46 + String.valueOf(str).length());
            sb.append("Could not parse value: ");
            sb.append(a2);
            sb.append(" for key: ");
            sb.append(str);
            sb.append(" into a float");
            Log.d("FirebasePerformance", sb.toString());
            return f2;
        }
    }

    private final void zzca() {
        if (this.zzfd) {
            zzcb();
        } else {
            this.executor.execute(new x(this));
        }
    }

    private final void zzcb() {
        if (zzcc()) {
            if (System.currentTimeMillis() - this.zzfe > zzfc) {
                this.zzfe = System.currentTimeMillis();
                this.zzfh.b().addOnFailureListener(this.executor, (OnFailureListener) new w(this));
            }
        }
    }

    private final boolean zzcc() {
        return this.zzfh != null && this.zzfg.getOrDefault(zzbb.zzl("firebase_remote_config_enabled"), 1L).longValue() == 1;
    }

    private static zzr<String> zza(Context context, String str) {
        zzu zzh = zzr.zzh();
        int zzf = zzf(context);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append(":");
        sb.append(zzf);
        String[] strArr = {sb.toString(), str, "1.0.0.249530108"};
        for (int i = 0; i < 3; i++) {
            String valueOf = String.valueOf(strArr[i]);
            String zzi = zzi(valueOf.length() != 0 ? "_fireperf1:".concat(valueOf) : new String("_fireperf1:"));
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzi).length() + 16);
            sb2.append("fireperf:");
            sb2.append(zzi);
            sb2.append("_limits");
            String str2 = null;
            try {
                str2 = zzb.zza(context.getContentResolver(), sb2.toString(), (String) null);
            } catch (SecurityException e2) {
                String valueOf2 = String.valueOf(e2.getMessage());
                Log.w("FirebasePerformance", valueOf2.length() != 0 ? "Failed to fetch Gservices flag. SecurityException: ".concat(valueOf2) : new String("Failed to fetch Gservices flag. SecurityException: "));
            }
            if (str2 != null) {
                zzh.zzb(str2);
            }
        }
        return zzh.zzi();
    }

    @VisibleForTesting
    private static String zzi(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] digest = MessageDigest.getInstance(Hash.ALGORITHM_SHA1).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i])}));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static zzv<String, Long> zzc(List<String> list) {
        if (list == null) {
            return zzv.zzj();
        }
        HashMap hashMap = new HashMap();
        for (String split : list) {
            for (String split2 : split.split(",")) {
                String[] split3 = split2.split(":");
                if (split3.length >= 2) {
                    String trim = split3[0].trim();
                    if (!trim.isEmpty() && !hashMap.containsKey(trim)) {
                        try {
                            long parseLong = Long.parseLong(split3[1].trim());
                            if (parseLong >= 0) {
                                hashMap.put(trim, Long.valueOf(parseLong));
                            }
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            }
        }
        return zzv.zza(hashMap);
    }

    @VisibleForTesting
    private static int zzf(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Exception exc) {
        this.zzfe = 0;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzcd() {
        if (this.zzcp != null) {
            this.zzfg = this.zzff.get();
            this.zzfd = true;
            zzv<String, Long> zzv = this.zzfg;
        } else {
            zzv.zzj();
        }
        zzcb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzv zzce() {
        return zzc(zza(this.zzcp.a(), this.zzcp.c().b()));
    }
}
