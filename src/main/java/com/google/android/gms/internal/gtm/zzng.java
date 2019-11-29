package com.google.android.gms.internal.gtm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class zzng implements zznh {
    private HttpURLConnection zzatk;
    private InputStream zzatl = null;

    zzng() {
    }

    public final InputStream zzcj(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.zzatk = httpURLConnection;
        HttpURLConnection httpURLConnection2 = this.zzatk;
        int responseCode = httpURLConnection2.getResponseCode();
        if (responseCode == 200) {
            this.zzatl = httpURLConnection2.getInputStream();
            return this.zzatl;
        }
        StringBuilder sb = new StringBuilder(25);
        sb.append("Bad response: ");
        sb.append(responseCode);
        String sb2 = sb.toString();
        if (responseCode == 404) {
            throw new FileNotFoundException(sb2);
        } else if (responseCode == 503) {
            throw new zznl(sb2);
        } else {
            throw new IOException(sb2);
        }
    }

    public final void close() {
        HttpURLConnection httpURLConnection = this.zzatk;
        try {
            if (this.zzatl != null) {
                this.zzatl.close();
            }
        } catch (IOException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            zzev.zza(valueOf.length() != 0 ? "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(valueOf) : new String("HttpUrlConnectionNetworkClient: Error when closing http input stream: "), e2);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
