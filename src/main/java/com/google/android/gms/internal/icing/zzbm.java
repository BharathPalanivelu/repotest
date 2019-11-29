package com.google.android.gms.internal.icing;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;

public final class zzbm {
    private static volatile zzbw<Boolean> zzcu = zzbw.zzv();
    private static final Object zzcv = new Object();

    private static boolean zzd(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean zza(Context context, Uri uri) {
        boolean z;
        String authority = uri.getAuthority();
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            throw new IllegalArgumentException(sb.toString());
        } else if (zzcu.isPresent()) {
            return zzcu.get().booleanValue();
        } else {
            synchronized (zzcv) {
                if (zzcu.isPresent()) {
                    boolean booleanValue = zzcu.get().booleanValue();
                    return booleanValue;
                }
                boolean z2 = false;
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0);
                    if (resolveContentProvider == null || !"com.google.android.gms".equals(resolveContentProvider.packageName)) {
                        z = false;
                        if (z && zzd(context)) {
                            z2 = true;
                        }
                        zzcu = zzbw.zzb(Boolean.valueOf(z2));
                        return zzcu.get().booleanValue();
                    }
                }
                z = true;
                z2 = true;
                zzcu = zzbw.zzb(Boolean.valueOf(z2));
                return zzcu.get().booleanValue();
            }
        }
    }
}
