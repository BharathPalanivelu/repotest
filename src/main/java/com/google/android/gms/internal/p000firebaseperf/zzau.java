package com.google.android.gms.internal.p000firebaseperf;

import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.zzci;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.internal.a;
import com.google.firebase.perf.internal.b;
import com.google.firebase.perf.internal.c;
import com.google.firebase.perf.internal.y;
import com.google.firebase.perf.internal.zzq;
import com.tencent.qcloud.core.http.HttpConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzau  reason: invalid package */
public final class zzau extends b implements y {
    private final List<zzq> zzbk;
    private final GaugeManager zzbl;
    private c zzbm;
    private final zzci.zza zzbn;
    private boolean zzbo;
    private boolean zzbp;
    private final WeakReference<y> zzbq;

    public final void zza(zzq zzq) {
        if (this.zzbn.zzek() && !this.zzbn.zzeq()) {
            this.zzbk.add(zzq);
        }
    }

    public static zzau zza(c cVar) {
        return new zzau(cVar);
    }

    private zzau(c cVar) {
        this(cVar, a.a(), GaugeManager.zzbf());
    }

    private zzau(c cVar, a aVar, GaugeManager gaugeManager) {
        super(aVar);
        this.zzbn = zzci.zzeu();
        this.zzbq = new WeakReference<>(this);
        this.zzbm = cVar;
        this.zzbl = gaugeManager;
        this.zzbk = new ArrayList();
        zzay();
    }

    public final void zzae() {
        this.zzbp = true;
    }

    public final zzau zza(String str) {
        if (str != null) {
            HttpUrl parse = HttpUrl.parse(str);
            if (parse != null) {
                str = parse.newBuilder().username("").password("").query((String) null).fragment((String) null).toString();
            }
            zzci.zza zza = this.zzbn;
            if (str.length() > 2000) {
                if (str.charAt(2000) != '/') {
                    HttpUrl parse2 = HttpUrl.parse(str);
                    if (parse2 != null && parse2.encodedPath().lastIndexOf(47) >= 0) {
                        int lastIndexOf = str.lastIndexOf(47, 1999);
                        if (lastIndexOf >= 0) {
                            str = str.substring(0, lastIndexOf);
                        }
                    }
                }
                str = str.substring(0, 2000);
            }
            zza.zzab(str);
        }
        return this;
    }

    public final zzau zzb(String str) {
        zzci.zzb zzb;
        if (str != null) {
            String upperCase = str.toUpperCase();
            char c2 = 65535;
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals("OPTIONS")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 70454:
                    if (upperCase.equals("GET")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 79599:
                    if (upperCase.equals("PUT")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals("HEAD")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals("POST")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals("PATCH")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals(HttpConstants.RequestMethod.TRACE)) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals("CONNECT")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals("DELETE")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    zzb = zzci.zzb.GET;
                    break;
                case 1:
                    zzb = zzci.zzb.PUT;
                    break;
                case 2:
                    zzb = zzci.zzb.POST;
                    break;
                case 3:
                    zzb = zzci.zzb.DELETE;
                    break;
                case 4:
                    zzb = zzci.zzb.HEAD;
                    break;
                case 5:
                    zzb = zzci.zzb.PATCH;
                    break;
                case 6:
                    zzb = zzci.zzb.OPTIONS;
                    break;
                case 7:
                    zzb = zzci.zzb.TRACE;
                    break;
                case 8:
                    zzb = zzci.zzb.CONNECT;
                    break;
                default:
                    zzb = zzci.zzb.HTTP_METHOD_UNKNOWN;
                    break;
            }
            this.zzbn.zzb(zzb);
        }
        return this;
    }

    public final zzau zzb(int i) {
        this.zzbn.zzl(i);
        return this;
    }

    public final boolean zzaf() {
        return this.zzbn.zzaf();
    }

    public final zzau zzf(long j) {
        this.zzbn.zzad(j);
        return this;
    }

    public final zzau zzb(Map<String, String> map) {
        this.zzbn.zzey().zzd(map);
        return this;
    }

    public final zzau zzg(long j) {
        zzq zzcg = SessionManager.zzcf().zzcg();
        SessionManager.zzcf().zzc(this.zzbq);
        this.zzbn.zzaf(j);
        this.zzbk.add(zzcg);
        if (zzcg.c()) {
            this.zzbl.zzbh();
        }
        return this;
    }

    public final zzau zzh(long j) {
        this.zzbn.zzag(j);
        return this;
    }

    public final zzau zzi(long j) {
        this.zzbn.zzah(j);
        return this;
    }

    public final long zzag() {
        return this.zzbn.zzep();
    }

    public final zzau zzj(long j) {
        this.zzbn.zzai(j);
        if (SessionManager.zzcf().zzcg().c()) {
            this.zzbl.zzbh();
        }
        return this;
    }

    public final zzau zzk(long j) {
        this.zzbn.zzae(j);
        return this;
    }

    public final zzau zzc(String str) {
        if (str == null) {
            this.zzbn.zzex();
            return this;
        }
        boolean z = false;
        if (str.length() <= 128) {
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                }
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt > 127) {
                    break;
                }
                i++;
            }
        }
        if (z) {
            this.zzbn.zzac(str);
        } else {
            String valueOf = String.valueOf(str);
            Log.i("FirebasePerformance", valueOf.length() != 0 ? "The content type of the response is not a valid content-type:".concat(valueOf) : new String("The content type of the response is not a valid content-type:"));
        }
        return this;
    }

    public final zzau zzah() {
        this.zzbn.zzb(zzci.zzd.GENERIC_CLIENT_ERROR);
        return this;
    }

    public final zzci zzai() {
        SessionManager.zzcf().zzd(this.zzbq);
        zzaz();
        zzcr[] a2 = zzq.a(this.zzbk);
        if (a2 != null) {
            this.zzbn.zzc(Arrays.asList(a2));
        }
        zzci zzci = (zzci) ((zzep) this.zzbn.zzhr());
        if (!this.zzbo) {
            c cVar = this.zzbm;
            if (cVar != null) {
                cVar.a(zzci, zzal());
            }
            this.zzbo = true;
        } else if (this.zzbp) {
            Log.i("FirebasePerformance", "This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
        }
        return zzci;
    }
}
