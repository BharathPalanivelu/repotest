package com.google.android.gms.internal.firebase_remote_config;

import com.appsflyer.share.Constants;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class zzd {
    private static final Logger logger = Logger.getLogger(zzd.class.getName());
    private final zzaa zze;
    private final zzi zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final String zzj;
    private final zzci zzk;
    private final boolean zzl;
    private final boolean zzm;

    protected zzd(zza zza2) {
        zzaa zzaa;
        this.zzf = zza2.zzf;
        this.zzg = zza(zza2.zzg);
        this.zzh = zzb(zza2.zzh);
        this.zzi = zza2.zzi;
        if (zzdy.zzbc((String) null)) {
            logger.logp(Level.WARNING, "com.google.api.client.googleapis.services.AbstractGoogleClient", "<init>", "Application name is not set. Call Builder#setApplicationName.");
        }
        this.zzj = null;
        if (zza2.zzy == null) {
            zzaa = zza2.zzx.zza((zzad) null);
        } else {
            zzaa = zza2.zzx.zza(zza2.zzy);
        }
        this.zze = zzaa;
        this.zzk = zza2.zzk;
        this.zzl = false;
        this.zzm = false;
    }

    public static abstract class zza {
        zzi zzf;
        String zzg;
        String zzh;
        String zzi;
        final zzci zzk;
        final zzag zzx;
        zzad zzy;

        protected zza(zzag zzag, String str, String str2, zzci zzci, zzad zzad) {
            this.zzx = (zzag) zzdt.checkNotNull(zzag);
            this.zzk = zzci;
            zzc(str);
            zzd(str2);
            this.zzy = zzad;
        }

        public zza zzc(String str) {
            this.zzg = zzd.zza(str);
            return this;
        }

        public zza zzd(String str) {
            this.zzh = zzd.zzb(str);
            return this;
        }

        public zza zze(String str) {
            this.zzi = str;
            return this;
        }

        public zza zza(zzi zzi2) {
            this.zzf = zzi2;
            return this;
        }
    }

    public final String zzc() {
        String valueOf = String.valueOf(this.zzg);
        String valueOf2 = String.valueOf(this.zzh);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final zzaa zzd() {
        return this.zze;
    }

    public zzci zze() {
        return this.zzk;
    }

    /* access modifiers changed from: protected */
    public void zza(zzf<?> zzf2) throws IOException {
        zzi zzi2 = this.zzf;
        if (zzi2 != null) {
            zzi2.zza(zzf2);
        }
    }

    static String zza(String str) {
        if (str != null) {
            return !str.endsWith(Constants.URL_PATH_DELIMITER) ? String.valueOf(str).concat(Constants.URL_PATH_DELIMITER) : str;
        }
        throw new NullPointerException("root URL cannot be null.");
    }

    static String zzb(String str) {
        if (str == null) {
            throw new NullPointerException("service path cannot be null");
        } else if (str.length() == 1) {
            if (Constants.URL_PATH_DELIMITER.equals(str)) {
                return "";
            }
            throw new IllegalArgumentException("service path must equal \"/\" if it is of length 1.");
        } else if (str.length() <= 0) {
            return str;
        } else {
            if (!str.endsWith(Constants.URL_PATH_DELIMITER)) {
                str = String.valueOf(str).concat(Constants.URL_PATH_DELIMITER);
            }
            if (str.startsWith(Constants.URL_PATH_DELIMITER)) {
                return str.substring(1);
            }
            return str;
        }
    }
}
