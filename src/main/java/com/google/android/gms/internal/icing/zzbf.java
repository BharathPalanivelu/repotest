package com.google.android.gms.internal.icing;

import android.os.Binder;

public final /* synthetic */ class zzbf {
    public static <V> V zza(zzbi<V> zzbi) {
        long clearCallingIdentity;
        try {
            return zzbi.zzl();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zzl = zzbi.zzl();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zzl;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
