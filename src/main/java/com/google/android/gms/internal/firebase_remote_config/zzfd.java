package com.google.android.gms.internal.firebase_remote_config;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.firebase_remote_config.zzfi;
import com.google.android.gms.internal.firebase_remote_config.zzkt;
import com.google.firebase.remoteconfig.j;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public final class zzfd {
    private static final Charset zzlz = Charset.forName("UTF-8");
    private static final ThreadLocal<DateFormat> zzma = new zzfg();
    private final String appId;
    private final Context zzja;
    private final SharedPreferences zzmb;

    public zzfd(Context context, String str) {
        this.zzja = context;
        this.appId = str;
        this.zzmb = context.getSharedPreferences("com.google.firebase.remoteconfig_legacy_settings", 0);
    }

    public final boolean zzdg() {
        if (!this.zzmb.getBoolean("save_legacy_configs", true)) {
            return false;
        }
        zzfi.zze zzdh = zzdh();
        HashMap hashMap = new HashMap();
        if (zzdh != null) {
            Map<String, zzen> zza = zza(zzdh.zzdu());
            Map<String, zzen> zza2 = zza(zzdh.zzdt());
            Map<String, zzen> zza3 = zza(zzdh.zzdv());
            HashSet<String> hashSet = new HashSet<>();
            hashSet.addAll(zza.keySet());
            hashSet.addAll(zza2.keySet());
            hashSet.addAll(zza3.keySet());
            for (String str : hashSet) {
                zzff zzff = new zzff((zzfg) null);
                if (zza.containsKey(str)) {
                    zzff.zzj(zza.get(str));
                }
                if (zza2.containsKey(str)) {
                    zzff.zzi(zza2.get(str));
                }
                if (zza3.containsKey(str)) {
                    zzff.zzk(zza3.get(str));
                }
                hashMap.put(str, zzff);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            zzff zzff2 = (zzff) entry.getValue();
            zzei zzd = zzd(str2, "fetch");
            zzei zzd2 = zzd(str2, "activate");
            zzei zzd3 = zzd(str2, "defaults");
            if (zzff2.zzcx() != null) {
                zzd.zzc(zzff2.zzcx());
            }
            if (zzff2.zzdi() != null) {
                zzd2.zzc(zzff2.zzdi());
            }
            if (zzff2.zzdj() != null) {
                zzd3.zzc(zzff2.zzdj());
            }
        }
        this.zzmb.edit().putBoolean("save_legacy_configs", false).commit();
        return true;
    }

    private final Map<String, zzen> zza(zzfi.zza zza) {
        HashMap hashMap = new HashMap();
        Date date = new Date(zza.getTimestamp());
        List<zzfx> zzdl = zza.zzdl();
        ArrayList arrayList = new ArrayList();
        for (zzfx zza2 : zzdl) {
            zzkt.zzb zza3 = zza(zza2);
            if (zza3 != null) {
                zzdd zzdd = new zzdd();
                zzdd.zzan(zza3.zzjm());
                zzdd.zzaq(zza3.zzjn());
                zzdd.zzao(zzma.get().format(new Date(zza3.zzjo())));
                zzdd.zzap(zza3.zzjp());
                zzdd.zzb(Long.valueOf(zza3.zzjq()));
                zzdd.zza(Long.valueOf(zza3.zzjr()));
                arrayList.add(zzdd);
            }
        }
        for (zzfi.zzd next : zza.zzdk()) {
            String namespace = next.getNamespace();
            if (namespace.startsWith("configns:")) {
                namespace = namespace.substring(9);
            }
            zzep zzct = zzen.zzct();
            List<zzfi.zzb> zzdr = next.zzdr();
            HashMap hashMap2 = new HashMap();
            for (zzfi.zzb next2 : zzdr) {
                hashMap2.put(next2.getKey(), next2.zzdo().zzb(zzlz));
            }
            zzep zza4 = zzct.zzd(hashMap2).zza(date);
            if (namespace.equals("firebase")) {
                zza4.zzb(arrayList);
            }
            try {
                hashMap.put(namespace, zza4.zzcv());
            } catch (JSONException unused) {
                Log.i("FirebaseRemoteConfig", "A set of legacy configs could not be converted.");
            }
        }
        return hashMap;
    }

    private static zzkt.zzb zza(zzfx zzfx) {
        try {
            zzgg zzgg = (zzgg) zzfx.iterator();
            byte[] bArr = new byte[zzfx.size()];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = ((Byte) zzgg.next()).byteValue();
            }
            return zzkt.zzb.zzg(bArr);
        } catch (zzhq e2) {
            Log.i("FirebaseRemoteConfig", "Payload was not defined or could not be deserialized.", e2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0031 A[SYNTHETIC, Splitter:B:24:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0043 A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x004a A[SYNTHETIC, Splitter:B:37:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0056 A[SYNTHETIC, Splitter:B:44:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.firebase_remote_config.zzfi.zze zzdh() {
        /*
            r7 = this;
            java.lang.String r0 = "Failed to close persisted config file."
            java.lang.String r1 = "FirebaseRemoteConfig"
            android.content.Context r2 = r7.zzja
            r3 = 0
            if (r2 != 0) goto L_0x000a
            return r3
        L_0x000a:
            java.lang.String r4 = "persisted_config"
            java.io.FileInputStream r2 = r2.openFileInput(r4)     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0028, all -> 0x0023 }
            com.google.android.gms.internal.firebase_remote_config.zzfi$zze r3 = com.google.android.gms.internal.firebase_remote_config.zzfi.zze.zzb(r2)     // Catch:{ FileNotFoundException -> 0x0021, IOException -> 0x001f }
            if (r2 == 0) goto L_0x001e
            r2.close()     // Catch:{ IOException -> 0x001a }
            goto L_0x001e
        L_0x001a:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L_0x001e:
            return r3
        L_0x001f:
            r4 = move-exception
            goto L_0x002a
        L_0x0021:
            r4 = move-exception
            goto L_0x003c
        L_0x0023:
            r2 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x0054
        L_0x0028:
            r4 = move-exception
            r2 = r3
        L_0x002a:
            java.lang.String r5 = "Cannot initialize from persisted config."
            android.util.Log.e(r1, r5, r4)     // Catch:{ all -> 0x0053 }
            if (r2 == 0) goto L_0x0039
            r2.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L_0x0039:
            return r3
        L_0x003a:
            r4 = move-exception
            r2 = r3
        L_0x003c:
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r1, r5)     // Catch:{ all -> 0x0053 }
            if (r5 == 0) goto L_0x0048
            java.lang.String r5 = "Persisted config file was not found."
            android.util.Log.d(r1, r5, r4)     // Catch:{ all -> 0x0053 }
        L_0x0048:
            if (r2 == 0) goto L_0x0052
            r2.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L_0x0052:
            return r3
        L_0x0053:
            r3 = move-exception
        L_0x0054:
            if (r2 == 0) goto L_0x005e
            r2.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L_0x005e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzfd.zzdh():com.google.android.gms.internal.firebase_remote_config.zzfi$zze");
    }

    private final zzei zzd(String str, String str2) {
        return j.a(this.zzja, this.appId, str, str2);
    }
}
