package com.google.android.gms.internal.icing;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.c;

final class zzbh implements zzbg {
    static zzbh zzcq;
    private final Context zzcr;

    static zzbh zzc(Context context) {
        zzbh zzbh;
        synchronized (zzbh.class) {
            if (zzcq == null) {
                zzcq = c.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzbh(context) : new zzbh();
            }
            zzbh = zzcq;
        }
        return zzbh;
    }

    private zzbh(Context context) {
        this.zzcr = context;
        this.zzcr.getContentResolver().registerContentObserver(zzax.CONTENT_URI, true, new zzbj(this, (Handler) null));
    }

    private zzbh() {
        this.zzcr = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzj */
    public final String zzi(String str) {
        if (this.zzcr == null) {
            return null;
        }
        try {
            return (String) zzbf.zza(new zzbk(this, str));
        } catch (SecurityException e2) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzk(String str) {
        return zzax.zza(this.zzcr.getContentResolver(), str, (String) null);
    }
}
