package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zznj implements Runnable {
    private final zzmn zzatm;
    private final zzni zzatn;
    private final zzmw zzato;
    private final zznf zzatp;
    private final Context zzrm;

    public zznj(Context context, zzmw zzmw, zzmn zzmn) {
        this(context, zzmw, zzmn, new zzni(), new zznf());
    }

    @VisibleForTesting
    private zznj(Context context, zzmw zzmw, zzmn zzmn, zzni zzni, zznf zznf) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
        this.zzatm = (zzmn) Preconditions.checkNotNull(zzmn);
        this.zzato = zzmw;
        this.zzatn = zzni;
        this.zzatp = zznf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            java.lang.String r0 = " "
            java.lang.String r1 = "android.permission.INTERNET"
            boolean r1 = r9.zzx(r1)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0013
            java.lang.String r1 = "Missing android.permission.INTERNET. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.INTERNET\" />"
            com.google.android.gms.internal.gtm.zzev.zzav(r1)
        L_0x0011:
            r1 = 0
            goto L_0x0040
        L_0x0013:
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = r9.zzx(r1)
            if (r1 != 0) goto L_0x0021
            java.lang.String r1 = "Missing android.permission.ACCESS_NETWORK_STATE. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />"
            com.google.android.gms.internal.gtm.zzev.zzav(r1)
            goto L_0x0011
        L_0x0021:
            android.content.Context r1 = r9.zzrm
            java.lang.String r4 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r4)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()
            if (r1 == 0) goto L_0x003a
            boolean r1 = r1.isConnected()
            if (r1 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r1 = 1
            goto L_0x0040
        L_0x003a:
            java.lang.String r1 = "No network connectivity - Offline"
            com.google.android.gms.internal.gtm.zzev.zzac(r1)
            goto L_0x0011
        L_0x0040:
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.internal.gtm.zzmn r0 = r9.zzatm
            r0.zzb(r3, r3)
            return
        L_0x0048:
            java.lang.String r1 = "Starting to load resource from Network."
            com.google.android.gms.internal.gtm.zzev.zzab(r1)
            com.google.android.gms.internal.gtm.zzng r1 = new com.google.android.gms.internal.gtm.zzng
            r1.<init>()
            r4 = 0
            com.google.android.gms.internal.gtm.zznf r5 = r9.zzatp     // Catch:{ all -> 0x014d }
            com.google.android.gms.internal.gtm.zzmw r6 = r9.zzato     // Catch:{ all -> 0x014d }
            com.google.android.gms.internal.gtm.zzmk r6 = r6.zzlk()     // Catch:{ all -> 0x014d }
            java.lang.String r5 = r5.zzb(r6)     // Catch:{ all -> 0x014d }
            java.lang.String r6 = "Loading resource from "
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x014d }
            int r8 = r7.length()     // Catch:{ all -> 0x014d }
            if (r8 == 0) goto L_0x0070
            java.lang.String r6 = r6.concat(r7)     // Catch:{ all -> 0x014d }
            goto L_0x0076
        L_0x0070:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x014d }
            r7.<init>(r6)     // Catch:{ all -> 0x014d }
            r6 = r7
        L_0x0076:
            com.google.android.gms.internal.gtm.zzev.zzab(r6)     // Catch:{ all -> 0x014d }
            r6 = 2
            java.io.InputStream r4 = r1.zzcj(r5)     // Catch:{ FileNotFoundException -> 0x012a, zznl -> 0x00ba, IOException -> 0x007f }
            goto L_0x00da
        L_0x007f:
            r4 = move-exception
            java.lang.String r6 = r4.getMessage()     // Catch:{ all -> 0x014d }
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x014d }
            int r7 = r7.length()     // Catch:{ all -> 0x014d }
            int r7 = r7 + 54
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x014d }
            int r8 = r8.length()     // Catch:{ all -> 0x014d }
            int r7 = r7 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x014d }
            r8.<init>(r7)     // Catch:{ all -> 0x014d }
            java.lang.String r7 = "NetworkLoader: Error when loading resource from url: "
            r8.append(r7)     // Catch:{ all -> 0x014d }
            r8.append(r5)     // Catch:{ all -> 0x014d }
            r8.append(r0)     // Catch:{ all -> 0x014d }
            r8.append(r6)     // Catch:{ all -> 0x014d }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x014d }
            com.google.android.gms.internal.gtm.zzev.zza(r0, r4)     // Catch:{ all -> 0x014d }
            com.google.android.gms.internal.gtm.zzmn r0 = r9.zzatm     // Catch:{ all -> 0x014d }
            r0.zzb(r2, r3)     // Catch:{ all -> 0x014d }
            r1.close()
            return
        L_0x00ba:
            java.lang.String r2 = "NetworkLoader: Error when loading resource for url: "
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x014d }
            int r8 = r7.length()     // Catch:{ all -> 0x014d }
            if (r8 == 0) goto L_0x00cb
            java.lang.String r2 = r2.concat(r7)     // Catch:{ all -> 0x014d }
            goto L_0x00d1
        L_0x00cb:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x014d }
            r7.<init>(r2)     // Catch:{ all -> 0x014d }
            r2 = r7
        L_0x00d1:
            com.google.android.gms.internal.gtm.zzev.zzav(r2)     // Catch:{ all -> 0x014d }
            com.google.android.gms.internal.gtm.zzmn r2 = r9.zzatm     // Catch:{ all -> 0x014d }
            r7 = 3
            r2.zzb(r7, r3)     // Catch:{ all -> 0x014d }
        L_0x00da:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00ef }
            r2.<init>()     // Catch:{ IOException -> 0x00ef }
            com.google.android.gms.common.util.IOUtils.copyStream(r4, r2)     // Catch:{ IOException -> 0x00ef }
            com.google.android.gms.internal.gtm.zzmn r4 = r9.zzatm     // Catch:{ IOException -> 0x00ef }
            byte[] r2 = r2.toByteArray()     // Catch:{ IOException -> 0x00ef }
            r4.zzc(r2)     // Catch:{ IOException -> 0x00ef }
            r1.close()
            return
        L_0x00ef:
            r2 = move-exception
            java.lang.String r4 = r2.getMessage()     // Catch:{ all -> 0x014d }
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x014d }
            int r7 = r7.length()     // Catch:{ all -> 0x014d }
            int r7 = r7 + 66
            java.lang.String r8 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x014d }
            int r8 = r8.length()     // Catch:{ all -> 0x014d }
            int r7 = r7 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x014d }
            r8.<init>(r7)     // Catch:{ all -> 0x014d }
            java.lang.String r7 = "NetworkLoader: Error when parsing downloaded resources from url: "
            r8.append(r7)     // Catch:{ all -> 0x014d }
            r8.append(r5)     // Catch:{ all -> 0x014d }
            r8.append(r0)     // Catch:{ all -> 0x014d }
            r8.append(r4)     // Catch:{ all -> 0x014d }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x014d }
            com.google.android.gms.internal.gtm.zzev.zza(r0, r2)     // Catch:{ all -> 0x014d }
            com.google.android.gms.internal.gtm.zzmn r0 = r9.zzatm     // Catch:{ all -> 0x014d }
            r0.zzb(r6, r3)     // Catch:{ all -> 0x014d }
            r1.close()
            return
        L_0x012a:
            java.lang.String r0 = "NetworkLoader: No data was retrieved from the given url: "
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x014d }
            int r4 = r2.length()     // Catch:{ all -> 0x014d }
            if (r4 == 0) goto L_0x013b
            java.lang.String r0 = r0.concat(r2)     // Catch:{ all -> 0x014d }
            goto L_0x0141
        L_0x013b:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x014d }
            r2.<init>(r0)     // Catch:{ all -> 0x014d }
            r0 = r2
        L_0x0141:
            com.google.android.gms.internal.gtm.zzev.zzav(r0)     // Catch:{ all -> 0x014d }
            com.google.android.gms.internal.gtm.zzmn r0 = r9.zzatm     // Catch:{ all -> 0x014d }
            r0.zzb(r6, r3)     // Catch:{ all -> 0x014d }
            r1.close()
            return
        L_0x014d:
            r0 = move-exception
            r1.close()
            goto L_0x0153
        L_0x0152:
            throw r0
        L_0x0153:
            goto L_0x0152
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zznj.run():void");
    }

    @VisibleForTesting
    private final boolean zzx(String str) {
        return this.zzrm.getPackageManager().checkPermission(str, this.zzrm.getPackageName()) == 0;
    }
}
