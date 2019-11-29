package com.google.android.gms.internal.firebase_remote_config;

import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzas extends zzag {
    private static final String[] zzca;
    private final HostnameVerifier hostnameVerifier;
    private final zzap zzcw;
    private final SSLSocketFactory zzcx;

    public zzas() {
        this((zzap) null, (SSLSocketFactory) null, (HostnameVerifier) null);
    }

    private zzas(zzap zzap, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier2) {
        zzao zzao;
        if (System.getProperty("com.google.api.client.should_use_proxy") != null) {
            zzao = new zzao(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("https.proxyHost"), Integer.parseInt(System.getProperty("https.proxyPort")))));
        } else {
            zzao = new zzao();
        }
        this.zzcw = zzao;
        this.zzcx = null;
        this.hostnameVerifier = null;
    }

    public final boolean zzz(String str) {
        return Arrays.binarySearch(zzca, str) >= 0;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzaj zzc(String str, String str2) throws IOException {
        Object[] objArr = {str};
        if (zzz(str)) {
            HttpURLConnection zza = this.zzcw.zza(new URL(str2));
            zza.setRequestMethod(str);
            boolean z = zza instanceof HttpsURLConnection;
            return new zzar(zza);
        }
        throw new IllegalArgumentException(zzdy.zza("HTTP method %s not supported", objArr));
    }

    static {
        String[] strArr = {"DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", HttpConstants.RequestMethod.TRACE};
        zzca = strArr;
        Arrays.sort(strArr);
    }
}
