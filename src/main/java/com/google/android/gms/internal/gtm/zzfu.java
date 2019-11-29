package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.util.VisibleForTesting;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

final class zzfu implements zzed {
    private final String zzabp;
    private final zzfx zzapo;
    private final zzfw zzapp;
    private final Context zzrm;

    @VisibleForTesting
    private zzfu(zzfx zzfx, Context context, zzfw zzfw) {
        this.zzapo = zzfx;
        this.zzrm = context.getApplicationContext();
        this.zzapp = zzfw;
        String str = Build.VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        String str2 = null;
        if (!(locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage().toLowerCase());
            if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
                sb.append("-");
                sb.append(locale.getCountry().toLowerCase());
            }
            str2 = sb.toString();
        }
        this.zzabp = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleTagManager", "5.06", str, str2, Build.MODEL, Build.ID});
    }

    @VisibleForTesting
    zzfu(Context context, zzfw zzfw) {
        this(new zzfv(), context, zzfw);
    }

    public final boolean zzhy() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzrm.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzev.zzab("...no network connectivity");
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x020e, code lost:
        r1.zzapp.zzc(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0213, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0215, code lost:
        if (r16 == null) goto L_0x021a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x021a, code lost:
        r14.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x021e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x021f, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0220, code lost:
        if (r6 == null) goto L_0x0225;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0225, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0226, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0235, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0239, code lost:
        r5 = java.lang.String.valueOf(r11);
        r6 = r0.getClass().getSimpleName();
        r12 = new java.lang.StringBuilder((java.lang.String.valueOf(r5).length() + 27) + java.lang.String.valueOf(r6).length());
        r12.append("Exception sending hit to ");
        r12.append(r5);
        r12.append(": ");
        r12.append(r6);
        com.google.android.gms.internal.gtm.zzev.zzac(r12.toString());
        com.google.android.gms.internal.gtm.zzev.zzac(r0.getMessage());
        r1.zzapp.zzc(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f9, code lost:
        r6 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00fa, code lost:
        if (r6 == 0) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fd, code lost:
        if (r6 == 1) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ff, code lost:
        if (r6 == 2) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0102, code lost:
        if (r6 == 3) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0107, code lost:
        r14.setRequestMethod(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010a, code lost:
        if (r13 == null) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010c, code lost:
        r14.setDoOutput(true);
        r5 = r13.getBytes(java.nio.charset.Charset.forName("UTF-8"));
        r14.setFixedLengthStreamingMode(r5.length);
        r6 = new java.io.BufferedOutputStream(r14.getOutputStream());
        r6.write(r5);
        r6.flush();
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0130, code lost:
        if (r13 == null) goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0132, code lost:
        r5 = new java.lang.Object[2];
        r5[0] = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r5[1] = r13;
        com.google.android.gms.internal.gtm.zzev.zzac(java.lang.String.format("Body of %s hit is ignored: %s.", r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0146, code lost:
        r14.setRequestMethod(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0149, code lost:
        r5 = r14.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014f, code lost:
        if (r5 < 200) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0153, code lost:
        if (r5 < 300) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0156, code lost:
        r5 = r14.getInputStream();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r6 = java.lang.String.valueOf(r11);
        r12 = new java.lang.StringBuilder((java.lang.String.valueOf(r6).length() + 23) + java.lang.String.valueOf(r0).length());
        r12.append("Hit sent to ");
        r12.append(r6);
        r12.append("(method = ");
        r12.append(r0);
        r12.append(com.litesuits.orm.db.assit.SQLBuilder.PARENTHESES_RIGHT);
        com.google.android.gms.internal.gtm.zzev.zzab(r12.toString());
        r1.zzapp.zza(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0198, code lost:
        r16 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x019c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x019d, code lost:
        r16 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r0 = java.lang.String.valueOf(r11);
        r12 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 39);
        r12.append("Bad response received for ");
        r12.append(r0);
        r12.append(": ");
        r12.append(r5);
        com.google.android.gms.internal.gtm.zzev.zzac(r12.toString());
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r5 = r14.getErrorStream();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01d2, code lost:
        if (r5 == null) goto L_0x0208;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01d4, code lost:
        r6 = new java.io.BufferedReader(new java.io.InputStreamReader(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        r5 = r6.readLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e2, code lost:
        if (r5 == null) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01e4, code lost:
        r0.append(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01e8, code lost:
        r0 = java.lang.String.valueOf(r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01f6, code lost:
        if (r0.length() == 0) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01f8, code lost:
        r0 = "Error Message: ".concat(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01fd, code lost:
        r0 = new java.lang.String("Error Message: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0202, code lost:
        com.google.android.gms.internal.gtm.zzev.zzac(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0206, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0208, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0209, code lost:
        if (r6 == null) goto L_0x020e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0222 A[SYNTHETIC, Splitter:B:109:0x0222] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x022e A[SYNTHETIC, Splitter:B:117:0x022e] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0225 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0231 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(java.util.List<com.google.android.gms.internal.gtm.zzeh> r19) {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r2 = "GET"
            java.lang.String r3 = ": "
            int r0 = r19.size()
            r4 = 40
            int r4 = java.lang.Math.min(r0, r4)
            r6 = 1
            r7 = 0
            r8 = 1
        L_0x0013:
            if (r7 >= r4) goto L_0x0283
            r9 = r19
            java.lang.Object r0 = r9.get(r7)
            r10 = r0
            com.google.android.gms.internal.gtm.zzeh r10 = (com.google.android.gms.internal.gtm.zzeh) r10
            java.net.URL r11 = zzd((com.google.android.gms.internal.gtm.zzeh) r10)
            java.lang.String r0 = r10.zzkj()
            java.util.Map r12 = r10.zzkk()
            java.lang.String r13 = r10.zzkl()
            if (r11 != 0) goto L_0x003d
            java.lang.String r0 = "No destination: discarding hit."
            com.google.android.gms.internal.gtm.zzev.zzac(r0)
            com.google.android.gms.internal.gtm.zzfw r0 = r1.zzapp
            r0.zzb(r10)
        L_0x003a:
            r15 = 1
            goto L_0x027e
        L_0x003d:
            com.google.android.gms.internal.gtm.zzfx r14 = r1.zzapo     // Catch:{ IOException -> 0x0237 }
            java.net.HttpURLConnection r14 = r14.zzc(r11)     // Catch:{ IOException -> 0x0237 }
            if (r8 == 0) goto L_0x004b
            android.content.Context r15 = r1.zzrm     // Catch:{ all -> 0x0228 }
            com.google.android.gms.internal.gtm.zzex.zzn(r15)     // Catch:{ all -> 0x0228 }
            r8 = 0
        L_0x004b:
            java.lang.String r15 = "User-Agent"
            java.lang.String r5 = r1.zzabp     // Catch:{ all -> 0x0228 }
            r14.setRequestProperty(r15, r5)     // Catch:{ all -> 0x0228 }
            if (r12 == 0) goto L_0x0078
            java.util.Set r5 = r12.entrySet()     // Catch:{ all -> 0x0228 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0228 }
        L_0x005c:
            boolean r12 = r5.hasNext()     // Catch:{ all -> 0x0228 }
            if (r12 == 0) goto L_0x0078
            java.lang.Object r12 = r5.next()     // Catch:{ all -> 0x0228 }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ all -> 0x0228 }
            java.lang.Object r15 = r12.getKey()     // Catch:{ all -> 0x0228 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0228 }
            java.lang.Object r12 = r12.getValue()     // Catch:{ all -> 0x0228 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0228 }
            r14.setRequestProperty(r15, r12)     // Catch:{ all -> 0x0228 }
            goto L_0x005c
        L_0x0078:
            if (r0 != 0) goto L_0x0099
            java.lang.String r0 = "Hit %d retrieved from the store has null HTTP method."
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ all -> 0x0228 }
            long r12 = r10.zzih()     // Catch:{ all -> 0x0228 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0228 }
            r13 = 0
            r5[r13] = r12     // Catch:{ all -> 0x0228 }
            java.lang.String r0 = java.lang.String.format(r0, r5)     // Catch:{ all -> 0x0228 }
            com.google.android.gms.internal.gtm.zzev.zzac(r0)     // Catch:{ all -> 0x0228 }
            com.google.android.gms.internal.gtm.zzfw r0 = r1.zzapp     // Catch:{ all -> 0x0228 }
            r0.zzb(r10)     // Catch:{ all -> 0x0228 }
            r14.disconnect()     // Catch:{ IOException -> 0x0237 }
            goto L_0x003a
        L_0x0099:
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0228 }
            java.lang.String r12 = "POST"
            java.lang.String r15 = "PUT"
            java.lang.String r6 = "HEAD"
            if (r5 != 0) goto L_0x00d0
            boolean r5 = r0.equals(r6)     // Catch:{ all -> 0x0228 }
            if (r5 != 0) goto L_0x00d0
            boolean r5 = r0.equals(r12)     // Catch:{ all -> 0x0228 }
            if (r5 != 0) goto L_0x00d0
            boolean r5 = r0.equals(r15)     // Catch:{ all -> 0x0228 }
            if (r5 != 0) goto L_0x00d0
            java.lang.String r5 = "Unrecongnized HTTP method %s. Supported methods are GET, HEAD, PUT and/or POST"
            r6 = 1
            java.lang.Object[] r12 = new java.lang.Object[r6]     // Catch:{ all -> 0x0228 }
            r6 = 0
            r12[r6] = r0     // Catch:{ all -> 0x0228 }
            java.lang.String r0 = java.lang.String.format(r5, r12)     // Catch:{ all -> 0x0228 }
            com.google.android.gms.internal.gtm.zzev.zzac(r0)     // Catch:{ all -> 0x0228 }
            com.google.android.gms.internal.gtm.zzfw r0 = r1.zzapp     // Catch:{ all -> 0x0228 }
            r0.zzb(r10)     // Catch:{ all -> 0x0228 }
            r14.disconnect()     // Catch:{ IOException -> 0x0237 }
            goto L_0x003a
        L_0x00d0:
            int r17 = r0.hashCode()     // Catch:{ all -> 0x0228 }
            r5 = 2
            switch(r17) {
                case 70454: goto L_0x00f1;
                case 79599: goto L_0x00e9;
                case 2213344: goto L_0x00e1;
                case 2461856: goto L_0x00d9;
                default: goto L_0x00d8;
            }     // Catch:{ all -> 0x0228 }
        L_0x00d8:
            goto L_0x00f9
        L_0x00d9:
            boolean r6 = r0.equals(r12)     // Catch:{ all -> 0x0228 }
            if (r6 == 0) goto L_0x00f9
            r6 = 2
            goto L_0x00fa
        L_0x00e1:
            boolean r6 = r0.equals(r6)     // Catch:{ all -> 0x0228 }
            if (r6 == 0) goto L_0x00f9
            r6 = 1
            goto L_0x00fa
        L_0x00e9:
            boolean r6 = r0.equals(r15)     // Catch:{ all -> 0x0228 }
            if (r6 == 0) goto L_0x00f9
            r6 = 3
            goto L_0x00fa
        L_0x00f1:
            boolean r6 = r0.equals(r2)     // Catch:{ all -> 0x0228 }
            if (r6 == 0) goto L_0x00f9
            r6 = 0
            goto L_0x00fa
        L_0x00f9:
            r6 = -1
        L_0x00fa:
            if (r6 == 0) goto L_0x0130
            r12 = 1
            if (r6 == r12) goto L_0x0130
            if (r6 == r5) goto L_0x0107
            r5 = 3
            if (r6 == r5) goto L_0x0107
        L_0x0104:
            r12 = 0
            r15 = 1
            goto L_0x0149
        L_0x0107:
            r14.setRequestMethod(r0)     // Catch:{ all -> 0x0228 }
            if (r13 == 0) goto L_0x0104
            r14.setDoOutput(r12)     // Catch:{ all -> 0x0228 }
            java.lang.String r5 = "UTF-8"
            java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch:{ all -> 0x0228 }
            byte[] r5 = r13.getBytes(r5)     // Catch:{ all -> 0x0228 }
            int r6 = r5.length     // Catch:{ all -> 0x0228 }
            r14.setFixedLengthStreamingMode(r6)     // Catch:{ all -> 0x0228 }
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0228 }
            java.io.OutputStream r12 = r14.getOutputStream()     // Catch:{ all -> 0x0228 }
            r6.<init>(r12)     // Catch:{ all -> 0x0228 }
            r6.write(r5)     // Catch:{ all -> 0x0228 }
            r6.flush()     // Catch:{ all -> 0x0228 }
            r6.close()     // Catch:{ all -> 0x0228 }
            goto L_0x0104
        L_0x0130:
            if (r13 == 0) goto L_0x0144
            java.lang.String r6 = "Body of %s hit is ignored: %s."
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0228 }
            r12 = 0
            r5[r12] = r0     // Catch:{ all -> 0x0228 }
            r15 = 1
            r5[r15] = r13     // Catch:{ all -> 0x0226 }
            java.lang.String r5 = java.lang.String.format(r6, r5)     // Catch:{ all -> 0x0226 }
            com.google.android.gms.internal.gtm.zzev.zzac(r5)     // Catch:{ all -> 0x0226 }
            goto L_0x0146
        L_0x0144:
            r12 = 0
            r15 = 1
        L_0x0146:
            r14.setRequestMethod(r0)     // Catch:{ all -> 0x0226 }
        L_0x0149:
            int r5 = r14.getResponseCode()     // Catch:{ all -> 0x0226 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 < r6) goto L_0x01a1
            r6 = 300(0x12c, float:4.2E-43)
            if (r5 < r6) goto L_0x0156
            goto L_0x01a1
        L_0x0156:
            java.io.InputStream r5 = r14.getInputStream()     // Catch:{ all -> 0x0226 }
            java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x019c }
            java.lang.String r13 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x019c }
            int r13 = r13.length()     // Catch:{ all -> 0x019c }
            int r13 = r13 + 23
            java.lang.String r16 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x019c }
            int r16 = r16.length()     // Catch:{ all -> 0x019c }
            int r13 = r13 + r16
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r12.<init>(r13)     // Catch:{ all -> 0x019c }
            java.lang.String r13 = "Hit sent to "
            r12.append(r13)     // Catch:{ all -> 0x019c }
            r12.append(r6)     // Catch:{ all -> 0x019c }
            java.lang.String r6 = "(method = "
            r12.append(r6)     // Catch:{ all -> 0x019c }
            r12.append(r0)     // Catch:{ all -> 0x019c }
            java.lang.String r0 = ")"
            r12.append(r0)     // Catch:{ all -> 0x019c }
            java.lang.String r0 = r12.toString()     // Catch:{ all -> 0x019c }
            com.google.android.gms.internal.gtm.zzev.zzab(r0)     // Catch:{ all -> 0x019c }
            com.google.android.gms.internal.gtm.zzfw r0 = r1.zzapp     // Catch:{ all -> 0x019c }
            r0.zza(r10)     // Catch:{ all -> 0x019c }
            r16 = r5
            goto L_0x0215
        L_0x019c:
            r0 = move-exception
            r16 = r5
            goto L_0x022c
        L_0x01a1:
            java.lang.String r0 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0226 }
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0226 }
            int r6 = r6.length()     // Catch:{ all -> 0x0226 }
            int r6 = r6 + 39
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0226 }
            r12.<init>(r6)     // Catch:{ all -> 0x0226 }
            java.lang.String r6 = "Bad response received for "
            r12.append(r6)     // Catch:{ all -> 0x0226 }
            r12.append(r0)     // Catch:{ all -> 0x0226 }
            r12.append(r3)     // Catch:{ all -> 0x0226 }
            r12.append(r5)     // Catch:{ all -> 0x0226 }
            java.lang.String r0 = r12.toString()     // Catch:{ all -> 0x0226 }
            com.google.android.gms.internal.gtm.zzev.zzac(r0)     // Catch:{ all -> 0x0226 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0226 }
            r0.<init>()     // Catch:{ all -> 0x0226 }
            java.io.InputStream r5 = r14.getErrorStream()     // Catch:{ all -> 0x021e }
            if (r5 == 0) goto L_0x0208
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x021e }
            java.io.InputStreamReader r12 = new java.io.InputStreamReader     // Catch:{ all -> 0x021e }
            r12.<init>(r5)     // Catch:{ all -> 0x021e }
            r6.<init>(r12)     // Catch:{ all -> 0x021e }
        L_0x01de:
            java.lang.String r5 = r6.readLine()     // Catch:{ all -> 0x0206 }
            if (r5 == 0) goto L_0x01e8
            r0.append(r5)     // Catch:{ all -> 0x0206 }
            goto L_0x01de
        L_0x01e8:
            java.lang.String r5 = "Error Message: "
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0206 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0206 }
            int r12 = r0.length()     // Catch:{ all -> 0x0206 }
            if (r12 == 0) goto L_0x01fd
            java.lang.String r0 = r5.concat(r0)     // Catch:{ all -> 0x0206 }
            goto L_0x0202
        L_0x01fd:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0206 }
            r0.<init>(r5)     // Catch:{ all -> 0x0206 }
        L_0x0202:
            com.google.android.gms.internal.gtm.zzev.zzac(r0)     // Catch:{ all -> 0x0206 }
            goto L_0x0209
        L_0x0206:
            r0 = move-exception
            goto L_0x0220
        L_0x0208:
            r6 = 0
        L_0x0209:
            if (r6 == 0) goto L_0x020e
            r6.close()     // Catch:{ all -> 0x0226 }
        L_0x020e:
            com.google.android.gms.internal.gtm.zzfw r0 = r1.zzapp     // Catch:{ all -> 0x0226 }
            r0.zzc(r10)     // Catch:{ all -> 0x0226 }
            r16 = 0
        L_0x0215:
            if (r16 == 0) goto L_0x021a
            r16.close()     // Catch:{ IOException -> 0x0235 }
        L_0x021a:
            r14.disconnect()     // Catch:{ IOException -> 0x0235 }
            goto L_0x027e
        L_0x021e:
            r0 = move-exception
            r6 = 0
        L_0x0220:
            if (r6 == 0) goto L_0x0225
            r6.close()     // Catch:{ all -> 0x0226 }
        L_0x0225:
            throw r0     // Catch:{ all -> 0x0226 }
        L_0x0226:
            r0 = move-exception
            goto L_0x022a
        L_0x0228:
            r0 = move-exception
            r15 = 1
        L_0x022a:
            r16 = 0
        L_0x022c:
            if (r16 == 0) goto L_0x0231
            r16.close()     // Catch:{ IOException -> 0x0235 }
        L_0x0231:
            r14.disconnect()     // Catch:{ IOException -> 0x0235 }
            throw r0     // Catch:{ IOException -> 0x0235 }
        L_0x0235:
            r0 = move-exception
            goto L_0x0239
        L_0x0237:
            r0 = move-exception
            r15 = 1
        L_0x0239:
            java.lang.String r5 = java.lang.String.valueOf(r11)
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = r6.getSimpleName()
            java.lang.String r11 = java.lang.String.valueOf(r5)
            int r11 = r11.length()
            int r11 = r11 + 27
            java.lang.String r12 = java.lang.String.valueOf(r6)
            int r12 = r12.length()
            int r11 = r11 + r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r11)
            java.lang.String r11 = "Exception sending hit to "
            r12.append(r11)
            r12.append(r5)
            r12.append(r3)
            r12.append(r6)
            java.lang.String r5 = r12.toString()
            com.google.android.gms.internal.gtm.zzev.zzac(r5)
            java.lang.String r0 = r0.getMessage()
            com.google.android.gms.internal.gtm.zzev.zzac(r0)
            com.google.android.gms.internal.gtm.zzfw r0 = r1.zzapp
            r0.zzc(r10)
        L_0x027e:
            int r7 = r7 + 1
            r6 = 1
            goto L_0x0013
        L_0x0283:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfu.zzd(java.util.List):void");
    }

    @VisibleForTesting
    private static URL zzd(zzeh zzeh) {
        try {
            return new URL(zzeh.zzij());
        } catch (MalformedURLException unused) {
            zzev.zzav("Error trying to parse the GTM url.");
            return null;
        }
    }
}
