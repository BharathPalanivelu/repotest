package com.google.android.gms.internal.gtm;

import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@VisibleForTesting
public class zzfd {
    private static zzfd zzaoq;
    private volatile String zzaec = null;
    private volatile String zzais = null;
    private volatile int zzaor = zza.zzaos;

    /* 'enum' modifier removed */
    static final class zza {
        public static final int zzaos = 1;
        public static final int zzaot = 2;
        private static final /* synthetic */ int[] zzaou = {1, 2};
    }

    zzfd() {
    }

    @VisibleForTesting
    public static zzfd zzkr() {
        zzfd zzfd;
        synchronized (zzfd.class) {
            if (zzaoq == null) {
                zzaoq = new zzfd();
            }
            zzfd = zzaoq;
        }
        return zzfd;
    }

    public final synchronized boolean zza(String str, Uri uri) {
        try {
            String decode = URLDecoder.decode(uri.toString(), "UTF-8");
            if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\S+")) {
                String valueOf = String.valueOf(decode);
                zzev.zzac(valueOf.length() != 0 ? "Bad preview url: ".concat(valueOf) : new String("Bad preview url: "));
                return false;
            }
            String queryParameter = uri.getQueryParameter("id");
            String queryParameter2 = uri.getQueryParameter("gtm_auth");
            String queryParameter3 = uri.getQueryParameter("gtm_preview");
            if (!str.equals(queryParameter)) {
                zzev.zzac("Preview fails (container doesn't match the container specified by the asset)");
                return false;
            }
            if (queryParameter != null) {
                if (queryParameter.length() > 0) {
                    if (queryParameter3 == null || queryParameter3.length() != 0) {
                        if (queryParameter3 != null) {
                            if (queryParameter3.length() > 0 && queryParameter2 != null && queryParameter2.length() > 0) {
                                this.zzaor = zza.zzaot;
                                this.zzais = uri.getQuery();
                                this.zzaec = queryParameter;
                            }
                        }
                        String valueOf2 = String.valueOf(decode);
                        zzev.zzac(valueOf2.length() != 0 ? "Bad preview url: ".concat(valueOf2) : new String("Bad preview url: "));
                        return false;
                    }
                    if (queryParameter.equals(this.zzaec)) {
                        if (this.zzaor != zza.zzaos) {
                            String valueOf3 = String.valueOf(this.zzaec);
                            zzev.zzab(valueOf3.length() != 0 ? "Exit preview mode for container: ".concat(valueOf3) : new String("Exit preview mode for container: "));
                            this.zzaor = zza.zzaos;
                            this.zzaec = null;
                            this.zzais = null;
                        }
                    }
                    zzev.zzac("Error in exiting preview mode. The container is not in preview.");
                    return false;
                    return true;
                }
            }
            String valueOf4 = String.valueOf(decode);
            zzev.zzac(valueOf4.length() != 0 ? "Bad preview url: ".concat(valueOf4) : new String("Bad preview url: "));
            return false;
        } catch (UnsupportedEncodingException e2) {
            String valueOf5 = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 32);
            sb.append("Error decoding the preview url: ");
            sb.append(valueOf5);
            zzev.zzac(sb.toString());
            return false;
        }
    }

    public final boolean isPreview() {
        return this.zzaor == zza.zzaot;
    }

    public final boolean zzbw(String str) {
        return isPreview() && this.zzaec.equals(str);
    }

    public final String zzks() {
        return this.zzais;
    }

    public final String getContainerId() {
        return this.zzaec;
    }
}
