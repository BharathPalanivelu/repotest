package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

public class zzj implements zzi {
    private final String key;
    private final String zzae;

    public zzj() {
        this((String) null);
    }

    public zzj(String str) {
        this(str, (String) null);
    }

    private zzj(String str, String str2) {
        this.key = str;
        this.zzae = null;
    }

    public final void zza(zzf<?> zzf) throws IOException {
        String str = this.key;
        if (str != null) {
            zzf.put("key", str);
        }
    }
}
