package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

public final class zza implements zzad, zzx {
    private final boolean zza;

    public zza() {
        this(false);
    }

    private zza(boolean z) {
        this.zza = false;
    }

    public final void zza(zzab zzab) {
        zzab.zza((zzx) this);
    }

    public final void zzb(zzab zzab) throws IOException {
        String requestMethod = zzab.getRequestMethod();
        boolean z = true;
        if (requestMethod.equals("POST") || ((!requestMethod.equals("GET") || zzab.zzt().zzp().length() <= 2048) && zzab.zzs().zzz(requestMethod))) {
            z = false;
        }
        if (z) {
            String requestMethod2 = zzab.getRequestMethod();
            zzab.zzw("POST");
            zzab.zzx().zzb("X-HTTP-Method-Override", requestMethod2);
            if (requestMethod2.equals("GET")) {
                zzab.zza((zzs) new zzan((zzt) zzab.zzt().clone()));
                zzab.zzt().clear();
            } else if (zzab.zzu() == null) {
                zzab.zza((zzs) new zzo());
            }
        }
    }
}
