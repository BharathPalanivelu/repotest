package com.google.android.gms.internal.firebase_remote_config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.connector.a;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.b;
import com.google.firebase.remoteconfig.c;
import com.google.firebase.remoteconfig.g;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

public final class zzes {
    public static final long zzla = TimeUnit.HOURS.toSeconds(12);
    private static final int[] zzlb = {2, 4, 8, 16, 32, 64, 128, 256};
    private static final Pattern zzlg = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    private final String appId;
    private final Executor executor;
    private final String namespace;
    private final Context zzja;
    private final zzei zzjd;
    private final zzev zzji;
    private final FirebaseInstanceId zzjy;
    private final a zzjz;
    private final Clock zzlc;
    private final Random zzld;
    private final zzcy zzle;
    private final String zzlf;

    public zzes(Context context, String str, FirebaseInstanceId firebaseInstanceId, a aVar, String str2, Executor executor2, Clock clock, Random random, zzei zzei, zzcy zzcy, zzev zzev) {
        this.zzja = context;
        this.appId = str;
        this.zzjy = firebaseInstanceId;
        this.zzjz = aVar;
        this.namespace = str2;
        this.executor = executor2;
        this.zzlc = clock;
        this.zzld = random;
        this.zzjd = zzei;
        this.zzle = zzcy;
        this.zzji = zzev;
        Matcher matcher = zzlg.matcher(str);
        this.zzlf = matcher.matches() ? matcher.group(1) : null;
    }

    public final Task<zzet> zza(boolean z) {
        return zza(z, this.zzji.getMinimumFetchIntervalInSeconds());
    }

    public final Task<zzet> zza(boolean z, long j) {
        return this.zzjd.zzcp().continueWithTask(this.executor, new zzer(this, z, j));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025 A[Catch:{ c -> 0x0038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c A[Catch:{ c -> 0x0038 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.tasks.Task<com.google.android.gms.internal.firebase_remote_config.zzet> zzb(java.util.Date r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.firebase_remote_config.zzdf r0 = r3.zzc(r4)     // Catch:{ c -> 0x0038 }
            java.lang.String r1 = r0.getState()     // Catch:{ c -> 0x0038 }
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = r0.getState()     // Catch:{ c -> 0x0038 }
            java.lang.String r2 = "NO_CHANGE"
            boolean r1 = r1.equals(r2)     // Catch:{ c -> 0x0038 }
            if (r1 != 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r1 = 0
            goto L_0x001a
        L_0x0019:
            r1 = 1
        L_0x001a:
            if (r1 != 0) goto L_0x0025
            com.google.android.gms.internal.firebase_remote_config.zzet r4 = com.google.android.gms.internal.firebase_remote_config.zzet.zzd(r4)     // Catch:{ c -> 0x0038 }
            com.google.android.gms.tasks.Task r4 = com.google.android.gms.tasks.Tasks.forResult(r4)     // Catch:{ c -> 0x0038 }
            return r4
        L_0x0025:
            com.google.android.gms.internal.firebase_remote_config.zzen r4 = zza((com.google.android.gms.internal.firebase_remote_config.zzdf) r0, (java.util.Date) r4)     // Catch:{ c -> 0x0038 }
            com.google.android.gms.internal.firebase_remote_config.zzei r0 = r3.zzjd     // Catch:{ c -> 0x0038 }
            com.google.android.gms.tasks.Task r4 = r0.zzc(r4)     // Catch:{ c -> 0x0038 }
            java.util.concurrent.Executor r0 = r3.executor     // Catch:{ c -> 0x0038 }
            com.google.android.gms.tasks.SuccessContinuation r1 = com.google.android.gms.internal.firebase_remote_config.zzeu.zzjk     // Catch:{ c -> 0x0038 }
            com.google.android.gms.tasks.Task r4 = r4.onSuccessTask(r0, r1)     // Catch:{ c -> 0x0038 }
            return r4
        L_0x0038:
            r4 = move-exception
            com.google.android.gms.tasks.Task r4 = com.google.android.gms.tasks.Tasks.forException(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzes.zzb(java.util.Date):com.google.android.gms.tasks.Task");
    }

    private final zzdf zzc(Date date) throws c {
        try {
            zzdc zza = new zzcz(new zzda(this.zzle)).zza(this.zzlf, this.namespace, zzcw());
            zzw zzg = zza.zzg();
            zzg.zzr(this.zzji.zzcz());
            zzg.zzb("X-Android-Package", this.zzja.getPackageName());
            zzg.zzb("X-Android-Cert", zza(this.zzja, this.zzja.getPackageName()));
            zzdf zzdf = (zzdf) zza.zzi();
            this.zzji.zzbd(zza.zzh().zzq());
            this.zzji.zza(0, zzev.zzlj);
            return zzdf;
        } catch (zzaf e2) {
            Log.e("FirebaseRemoteConfig", "Fetch failed! Server responded with an error.", e2);
            int statusCode = e2.getStatusCode();
            if (statusCode == 429 || statusCode == 503 || statusCode == 504) {
                int zzdd = this.zzji.zzda().zzdd() + 1;
                TimeUnit timeUnit = TimeUnit.MINUTES;
                int[] iArr = zzlb;
                long millis = timeUnit.toMillis((long) iArr[Math.min(zzdd, iArr.length) - 1]);
                this.zzji.zza(zzdd, new Date(date.getTime() + (millis / 2) + ((long) this.zzld.nextInt((int) millis))));
            }
            int statusCode2 = e2.getStatusCode();
            throw new g(statusCode2, String.format("Fetch failed: %s", new Object[]{statusCode2 != 401 ? statusCode2 != 403 ? statusCode2 != 429 ? statusCode2 != 500 ? (statusCode2 == 503 || statusCode2 == 504) ? "The server is unavailable. Please try again later." : "The server returned an unexpected error." : "There was an internal server error." : "You have reached the throttle limit for your project. Please wait before making more requests." : "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project." : "The request did not have the required credentials. Please make sure your google-services.json is valid."}));
        } catch (IOException e3) {
            throw new b("Fetch failed due to an unexpected error! Check logs for details.", e3);
        }
    }

    private static String zza(Context context, String str) {
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, str);
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            String valueOf = String.valueOf(str);
            Log.e("FirebaseRemoteConfig", valueOf.length() != 0 ? "Could not get fingerprint hash for package: ".concat(valueOf) : new String("Could not get fingerprint hash for package: "));
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf2 = String.valueOf(str);
            Log.e("FirebaseRemoteConfig", valueOf2.length() != 0 ? "No such package: ".concat(valueOf2) : new String("No such package: "), e2);
            return null;
        }
    }

    private static zzen zza(zzdf zzdf, Date date) throws b {
        try {
            zzep zza = zzen.zzct().zza(date);
            Map<String, String> entries = zzdf.getEntries();
            if (entries != null) {
                zza.zzd(entries);
            }
            List<zzdd> zzcf = zzdf.zzcf();
            if (zzcf != null) {
                zza.zzb(zzcf);
            }
            return zza.zzcv();
        } catch (JSONException e2) {
            throw new b("Fetch failed: fetch response could not be parsed.", e2);
        }
    }

    private final zzdg zzcw() throws b {
        String id = this.zzjy.getId();
        if (id != null) {
            String token = this.zzjy.getToken();
            zzdg zzdg = new zzdg();
            zzdg.zzas(id);
            if (token != null) {
                zzdg.zzat(token);
            }
            zzdg.zzar(this.appId);
            Locale locale = this.zzja.getResources().getConfiguration().locale;
            zzdg.zzav(locale.getCountry());
            zzdg.zzaw(locale.toString());
            zzdg.zzay(Integer.toString(Build.VERSION.SDK_INT));
            zzdg.zzba(TimeZone.getDefault().getID());
            try {
                PackageInfo packageInfo = this.zzja.getPackageManager().getPackageInfo(this.zzja.getPackageName(), 0);
                if (packageInfo != null) {
                    zzdg.zzau(packageInfo.versionName);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            zzdg.zzax(this.zzja.getPackageName());
            zzdg.zzaz("17.0.0");
            HashMap hashMap = new HashMap();
            a aVar = this.zzjz;
            if (aVar != null) {
                for (Map.Entry next : aVar.a(false).entrySet()) {
                    hashMap.put((String) next.getKey(), next.getValue().toString());
                }
            }
            zzdg.zza(hashMap);
            return zzdg;
        }
        throw new b("Fetch request could not be created: Firebase instance id is null.");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.tasks.Task zza(boolean r5, long r6, com.google.android.gms.tasks.Task r8) throws java.lang.Exception {
        /*
            r4 = this;
            java.util.Date r0 = new java.util.Date
            com.google.android.gms.common.util.Clock r1 = r4.zzlc
            long r1 = r1.currentTimeMillis()
            r0.<init>(r1)
            boolean r8 = r8.isSuccessful()
            r1 = 0
            if (r8 == 0) goto L_0x0044
            if (r5 == 0) goto L_0x0016
        L_0x0014:
            r5 = 0
            goto L_0x0039
        L_0x0016:
            com.google.android.gms.internal.firebase_remote_config.zzev r5 = r4.zzji
            java.util.Date r5 = r5.zzcy()
            java.util.Date r8 = com.google.android.gms.internal.firebase_remote_config.zzev.zzli
            boolean r8 = r5.equals(r8)
            if (r8 == 0) goto L_0x0025
            goto L_0x0014
        L_0x0025:
            java.util.Date r8 = new java.util.Date
            long r2 = r5.getTime()
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            long r5 = r5.toMillis(r6)
            long r2 = r2 + r5
            r8.<init>(r2)
            boolean r5 = r0.before(r8)
        L_0x0039:
            if (r5 == 0) goto L_0x0044
            com.google.android.gms.internal.firebase_remote_config.zzet r5 = com.google.android.gms.internal.firebase_remote_config.zzet.zze(r0)
            com.google.android.gms.tasks.Task r5 = com.google.android.gms.tasks.Tasks.forResult(r5)
            return r5
        L_0x0044:
            com.google.android.gms.internal.firebase_remote_config.zzev r5 = r4.zzji
            com.google.android.gms.internal.firebase_remote_config.zzey r5 = r5.zzda()
            java.util.Date r5 = r5.zzde()
            boolean r6 = r0.before(r5)
            if (r6 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r5 = 0
        L_0x0056:
            if (r5 == 0) goto L_0x0084
            com.google.firebase.remoteconfig.e r6 = new com.google.firebase.remoteconfig.e
            long r7 = r5.getTime()
            long r2 = r0.getTime()
            long r7 = r7 - r2
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r7 = r2.toSeconds(r7)
            java.lang.String r7 = android.text.format.DateUtils.formatElapsedTime(r7)
            r0[r1] = r7
            java.lang.String r7 = "Fetch is throttled. Please wait before calling fetch again: %s"
            java.lang.String r7 = java.lang.String.format(r7, r0)
            long r0 = r5.getTime()
            r6.<init>(r7, r0)
            com.google.android.gms.tasks.Task r5 = com.google.android.gms.tasks.Tasks.forException(r6)
            return r5
        L_0x0084:
            com.google.android.gms.tasks.Task r5 = r4.zzb(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzes.zza(boolean, long, com.google.android.gms.tasks.Task):com.google.android.gms.tasks.Task");
    }
}
