package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.android.gms.internal.p000firebaseperf.zzau;
import com.google.android.gms.internal.p000firebaseperf.zzbg;
import com.google.android.gms.internal.p000firebaseperf.zzbl;
import com.google.firebase.perf.internal.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class FirebasePerfUrlConnection {
    private FirebasePerfUrlConnection() {
    }

    @Keep
    public static InputStream openStream(URL url) throws IOException {
        return a(new zzbl(url), c.a(), new zzbg());
    }

    @Keep
    public static Object getContent(URL url) throws IOException {
        return b(new zzbl(url), c.a(), new zzbg());
    }

    @Keep
    public static Object getContent(URL url, Class[] clsArr) throws IOException {
        return a(new zzbl(url), clsArr, c.a(), new zzbg());
    }

    @Keep
    public static Object instrument(Object obj) throws IOException {
        if (obj instanceof HttpsURLConnection) {
            return new e((HttpsURLConnection) obj, new zzbg(), zzau.zza(c.a()));
        }
        return obj instanceof HttpURLConnection ? new b((HttpURLConnection) obj, new zzbg(), zzau.zza(c.a())) : obj;
    }

    private static InputStream a(zzbl zzbl, c cVar, zzbg zzbg) throws IOException {
        zzbg.reset();
        long zzcr = zzbg.zzcr();
        zzau zza = zzau.zza(cVar);
        try {
            URLConnection openConnection = zzbl.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new e((HttpsURLConnection) openConnection, zzbg, zza).getInputStream();
            }
            if (openConnection instanceof HttpURLConnection) {
                return new b((HttpURLConnection) openConnection, zzbg, zza).getInputStream();
            }
            return openConnection.getInputStream();
        } catch (IOException e2) {
            zza.zzg(zzcr);
            zza.zzj(zzbg.zzcs());
            zza.zza(zzbl.toString());
            h.a(zza);
            throw e2;
        }
    }

    private static Object b(zzbl zzbl, c cVar, zzbg zzbg) throws IOException {
        zzbg.reset();
        long zzcr = zzbg.zzcr();
        zzau zza = zzau.zza(cVar);
        try {
            URLConnection openConnection = zzbl.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new e((HttpsURLConnection) openConnection, zzbg, zza).getContent();
            }
            if (openConnection instanceof HttpURLConnection) {
                return new b((HttpURLConnection) openConnection, zzbg, zza).getContent();
            }
            return openConnection.getContent();
        } catch (IOException e2) {
            zza.zzg(zzcr);
            zza.zzj(zzbg.zzcs());
            zza.zza(zzbl.toString());
            h.a(zza);
            throw e2;
        }
    }

    private static Object a(zzbl zzbl, Class[] clsArr, c cVar, zzbg zzbg) throws IOException {
        zzbg.reset();
        long zzcr = zzbg.zzcr();
        zzau zza = zzau.zza(cVar);
        try {
            URLConnection openConnection = zzbl.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new e((HttpsURLConnection) openConnection, zzbg, zza).getContent(clsArr);
            }
            if (openConnection instanceof HttpURLConnection) {
                return new b((HttpURLConnection) openConnection, zzbg, zza).getContent(clsArr);
            }
            return openConnection.getContent(clsArr);
        } catch (IOException e2) {
            zza.zzg(zzcr);
            zza.zzj(zzbg.zzcs());
            zza.zza(zzbl.toString());
            h.a(zza);
            throw e2;
        }
    }
}
