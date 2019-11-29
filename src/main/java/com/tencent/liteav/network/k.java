package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.util.Iterator;
import java.util.Vector;

public class k {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31800a = "";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31801b = "";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f31802c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f31803d = "";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Handler f31804e;

    public interface a {
        void a(int i, String str, Vector<e> vector);
    }

    public k(Context context) {
        if (context != null) {
            this.f31804e = new Handler(context.getMainLooper());
        }
    }

    public String a() {
        return this.f31800a;
    }

    public String b() {
        return this.f31801b;
    }

    public int c() {
        return this.f31802c;
    }

    public String d() {
        return this.f31803d;
    }

    public int a(String str, int i, a aVar) {
        this.f31800a = "";
        this.f31801b = "";
        this.f31802c = 0;
        this.f31803d = "";
        if (str == null || str.isEmpty()) {
            return -1;
        }
        String streamIDByStreamUrl = TXCCommonUtil.getStreamIDByStreamUrl(str);
        if (streamIDByStreamUrl == null || streamIDByStreamUrl.isEmpty()) {
            return -2;
        }
        String a2 = a("bizid", str);
        String a3 = a("txSecret", str);
        String a4 = a("txTime", str);
        if (!a(true, a2, a4, a3)) {
            return -3;
        }
        final String str2 = streamIDByStreamUrl;
        final String str3 = a2;
        final String str4 = a3;
        final String str5 = a4;
        final a aVar2 = aVar;
        a(streamIDByStreamUrl, a2, a3, a4, i, new a() {
            public void a(int i, String str, Vector<e> vector) {
                String unused = k.this.f31800a = str2;
                String unused2 = k.this.f31801b = str3;
                int unused3 = k.this.f31802c = i;
                String unused4 = k.this.f31803d = str;
                if (vector == null || vector.isEmpty()) {
                    a aVar = aVar2;
                    if (aVar != null) {
                        aVar.a(i, str, (Vector<e>) null);
                        return;
                    }
                    return;
                }
                Vector vector2 = new Vector();
                Iterator<e> it = vector.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    String str2 = next.f31772a;
                    if (str2.indexOf("?") != -1) {
                        str2 = str2.substring(0, str2.indexOf("?"));
                    }
                    vector2.add(new e(str2 + "?txSecret=" + str4 + "&txTime=" + str5 + "&bizid=" + str3, next.f31773b));
                }
                if (aVar2 != null) {
                    Iterator it2 = vector2.iterator();
                    while (it2.hasNext()) {
                        e eVar = (e) it2.next();
                        TXCLog.e("TXRTMPAccUrlFetcher", "accurl = " + eVar.f31772a + " quic = " + eVar.f31773b);
                    }
                    aVar2.a(i, str, vector2);
                }
            }
        });
        return 0;
    }

    /* access modifiers changed from: private */
    public boolean a(boolean z, String str, String str2, String str3) {
        if (z) {
            if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || str3 == null || str3.isEmpty()) {
                return false;
            }
            return true;
        } else if (str == null || str2 == null || str3 == null) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: private */
    public long e() {
        return b.a().a("Network", "AccRetryCountWithoutSecret");
    }

    private void a(String str, String str2, String str3, String str4, int i, a aVar) {
        final String str5 = str2;
        final String str6 = str4;
        final String str7 = str3;
        final String str8 = str;
        final int i2 = i;
        final a aVar2 = aVar;
        new Thread("getRTMPAccUrl") {
            /* JADX WARNING: type inference failed for: r12v0 */
            /* JADX WARNING: type inference failed for: r12v1, types: [boolean, int] */
            /* JADX WARNING: type inference failed for: r12v3 */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x01ee A[SYNTHETIC, Splitter:B:59:0x01ee] */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x0203 A[Catch:{ Exception -> 0x0246 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r18 = this;
                    r1 = r18
                    java.lang.String r2 = "message"
                    java.lang.String r3 = "pull_addr"
                    java.lang.String r4 = "code"
                    java.lang.String r5 = "TXRTMPAccUrlFetcher"
                    java.lang.String r0 = r3
                    r6 = 0
                    if (r0 == 0) goto L_0x0021
                    boolean r0 = r0.isEmpty()
                    if (r0 != 0) goto L_0x0021
                    java.lang.String r0 = r3
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                    int r0 = r0.intValue()
                    r7 = r0
                    goto L_0x0022
                L_0x0021:
                    r7 = 0
                L_0x0022:
                    r0 = 5
                    com.tencent.liteav.network.k r8 = com.tencent.liteav.network.k.this
                    java.lang.String r9 = r3
                    java.lang.String r10 = r4
                    java.lang.String r11 = r5
                    r12 = 1
                    boolean r8 = r8.a(r12, r9, r10, r11)
                    if (r8 != 0) goto L_0x003c
                    com.tencent.liteav.network.k r0 = com.tencent.liteav.network.k.this
                    long r8 = r0.e()
                    int r0 = (int) r8
                    if (r0 > 0) goto L_0x003c
                    r0 = 1
                L_0x003c:
                    java.lang.String r8 = ""
                    r9 = -1
                    r9 = r0
                    r11 = r8
                    r10 = -1
                L_0x0042:
                    if (r9 < r12) goto L_0x0272
                    org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x024e }
                    r0.<init>()     // Catch:{ Exception -> 0x024e }
                    java.lang.String r13 = "bizid"
                    r0.put(r13, r7)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r13 = "stream_id"
                    java.lang.String r14 = r6     // Catch:{ Exception -> 0x024e }
                    r0.put(r13, r14)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r13 = "txSecret"
                    java.lang.String r14 = r5     // Catch:{ Exception -> 0x024e }
                    r0.put(r13, r14)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r13 = "txTime"
                    java.lang.String r14 = r4     // Catch:{ Exception -> 0x024e }
                    r0.put(r13, r14)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r13 = "type"
                    r0.put(r13, r12)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x024e }
                    java.net.URL r13 = new java.net.URL     // Catch:{ Exception -> 0x024e }
                    java.lang.String r14 = "https://livepull.myqcloud.com/getpulladdr"
                    r13.<init>(r14)     // Catch:{ Exception -> 0x024e }
                    java.net.URLConnection r13 = r13.openConnection()     // Catch:{ Exception -> 0x024e }
                    java.lang.Object r13 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r13)     // Catch:{ Exception -> 0x024e }
                    java.net.URLConnection r13 = (java.net.URLConnection) r13     // Catch:{ Exception -> 0x024e }
                    javax.net.ssl.HttpsURLConnection r13 = (javax.net.ssl.HttpsURLConnection) r13     // Catch:{ Exception -> 0x024e }
                    r13.setDoOutput(r12)     // Catch:{ Exception -> 0x024e }
                    r13.setDoInput(r12)     // Catch:{ Exception -> 0x024e }
                    r13.setUseCaches(r6)     // Catch:{ Exception -> 0x024e }
                    r14 = 5000(0x1388, float:7.006E-42)
                    r13.setConnectTimeout(r14)     // Catch:{ Exception -> 0x024e }
                    r13.setReadTimeout(r14)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r14 = "POST"
                    r13.setRequestMethod(r14)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r14 = "Charsert"
                    java.lang.String r15 = "UTF-8"
                    r13.setRequestProperty(r14, r15)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r14 = "Content-Type"
                    java.lang.String r15 = "text/plain;"
                    r13.setRequestProperty(r14, r15)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r14 = "Content-Length"
                    int r15 = r0.length()     // Catch:{ Exception -> 0x024e }
                    java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x024e }
                    r13.setRequestProperty(r14, r15)     // Catch:{ Exception -> 0x024e }
                    java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024e }
                    r14.<init>()     // Catch:{ Exception -> 0x024e }
                    java.lang.String r15 = "getAccelerateStreamPlayUrl: sendHttpRequest[ "
                    r14.append(r15)     // Catch:{ Exception -> 0x024e }
                    r14.append(r0)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r15 = "] retryIndex = "
                    r14.append(r15)     // Catch:{ Exception -> 0x024e }
                    r14.append(r9)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x024e }
                    com.tencent.liteav.basic.log.TXCLog.e(r5, r14)     // Catch:{ Exception -> 0x024e }
                    java.io.DataOutputStream r14 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x024e }
                    java.io.OutputStream r15 = r13.getOutputStream()     // Catch:{ Exception -> 0x024e }
                    r14.<init>(r15)     // Catch:{ Exception -> 0x024e }
                    byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x024e }
                    r14.write(r0)     // Catch:{ Exception -> 0x024e }
                    java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x024e }
                    java.io.InputStreamReader r14 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x024e }
                    java.io.InputStream r13 = r13.getInputStream()     // Catch:{ Exception -> 0x024e }
                    r14.<init>(r13)     // Catch:{ Exception -> 0x024e }
                    r0.<init>(r14)     // Catch:{ Exception -> 0x024e }
                    r13 = r8
                L_0x00eb:
                    java.lang.String r14 = r0.readLine()     // Catch:{ Exception -> 0x024e }
                    if (r14 == 0) goto L_0x0101
                    java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024e }
                    r15.<init>()     // Catch:{ Exception -> 0x024e }
                    r15.append(r13)     // Catch:{ Exception -> 0x024e }
                    r15.append(r14)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r13 = r15.toString()     // Catch:{ Exception -> 0x024e }
                    goto L_0x00eb
                L_0x0101:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024e }
                    r0.<init>()     // Catch:{ Exception -> 0x024e }
                    java.lang.String r14 = "getAccelerateStreamPlayUrl: receive response, strResponse = "
                    r0.append(r14)     // Catch:{ Exception -> 0x024e }
                    r0.append(r13)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x024e }
                    com.tencent.liteav.basic.log.TXCLog.e(r5, r0)     // Catch:{ Exception -> 0x024e }
                    org.json.JSONTokener r0 = new org.json.JSONTokener     // Catch:{ Exception -> 0x024e }
                    r0.<init>(r13)     // Catch:{ Exception -> 0x024e }
                    java.lang.Object r0 = r0.nextValue()     // Catch:{ Exception -> 0x024e }
                    org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ Exception -> 0x024e }
                    boolean r13 = r0.has(r4)     // Catch:{ Exception -> 0x024e }
                    if (r13 == 0) goto L_0x012a
                    int r10 = r0.getInt(r4)     // Catch:{ Exception -> 0x024e }
                L_0x012a:
                    if (r10 == 0) goto L_0x0152
                    boolean r13 = r0.has(r2)     // Catch:{ Exception -> 0x024e }
                    if (r13 == 0) goto L_0x0136
                    java.lang.String r11 = r0.getString(r2)     // Catch:{ Exception -> 0x024e }
                L_0x0136:
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024e }
                    r13.<init>()     // Catch:{ Exception -> 0x024e }
                    java.lang.String r14 = "getAccelerateStreamPlayUrl: errorCode = "
                    r13.append(r14)     // Catch:{ Exception -> 0x024e }
                    r13.append(r10)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r14 = " errorMessage = "
                    r13.append(r14)     // Catch:{ Exception -> 0x024e }
                    r13.append(r11)     // Catch:{ Exception -> 0x024e }
                    java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x024e }
                    com.tencent.liteav.basic.log.TXCLog.e(r5, r13)     // Catch:{ Exception -> 0x024e }
                L_0x0152:
                    boolean r13 = r0.has(r3)     // Catch:{ Exception -> 0x024e }
                    if (r13 == 0) goto L_0x024a
                    java.util.Vector r13 = new java.util.Vector     // Catch:{ Exception -> 0x024e }
                    r13.<init>()     // Catch:{ Exception -> 0x024e }
                    java.util.Vector r14 = new java.util.Vector     // Catch:{ Exception -> 0x024e }
                    r14.<init>()     // Catch:{ Exception -> 0x024e }
                    org.json.JSONArray r0 = r0.getJSONArray(r3)     // Catch:{ Exception -> 0x024e }
                    if (r0 == 0) goto L_0x01e2
                    int r15 = r0.length()     // Catch:{ Exception -> 0x024e }
                    if (r15 != 0) goto L_0x0170
                    goto L_0x01e2
                L_0x0170:
                    r15 = 0
                L_0x0171:
                    int r6 = r0.length()     // Catch:{ Exception -> 0x024e }
                    if (r15 >= r6) goto L_0x01df
                    java.lang.Object r6 = r0.get(r15)     // Catch:{ Exception -> 0x024e }
                    org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ Exception -> 0x024e }
                    if (r6 == 0) goto L_0x01d3
                    java.lang.String r12 = "rtmp_url"
                    java.lang.String r12 = r6.getString(r12)     // Catch:{ Exception -> 0x024e }
                    r16 = r0
                    java.lang.String r0 = "proto"
                    int r0 = r6.getInt(r0)     // Catch:{ Exception -> 0x024e }
                    r6 = 1
                    if (r0 != r6) goto L_0x0192
                    r0 = 1
                    goto L_0x0193
                L_0x0192:
                    r0 = 0
                L_0x0193:
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024e }
                    r6.<init>()     // Catch:{ Exception -> 0x024e }
                    r17 = r2
                    java.lang.String r2 = "getAccelerateStreamPlayUrl: streamUrl = "
                    r6.append(r2)     // Catch:{ Exception -> 0x0248 }
                    r6.append(r12)     // Catch:{ Exception -> 0x0248 }
                    java.lang.String r2 = " Q channel = "
                    r6.append(r2)     // Catch:{ Exception -> 0x0248 }
                    r6.append(r0)     // Catch:{ Exception -> 0x0248 }
                    java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x0248 }
                    com.tencent.liteav.basic.log.TXCLog.e(r5, r2)     // Catch:{ Exception -> 0x0248 }
                    java.lang.String r2 = com.tencent.liteav.basic.util.TXCCommonUtil.getStreamIDByStreamUrl(r12)     // Catch:{ Exception -> 0x0248 }
                    if (r2 == 0) goto L_0x01d7
                    java.lang.String r6 = r6     // Catch:{ Exception -> 0x0248 }
                    boolean r2 = r2.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0248 }
                    if (r2 == 0) goto L_0x01d7
                    if (r0 == 0) goto L_0x01ca
                    com.tencent.liteav.network.e r2 = new com.tencent.liteav.network.e     // Catch:{ Exception -> 0x0248 }
                    r2.<init>(r12, r0)     // Catch:{ Exception -> 0x0248 }
                    r13.add(r2)     // Catch:{ Exception -> 0x0248 }
                    goto L_0x01d7
                L_0x01ca:
                    com.tencent.liteav.network.e r2 = new com.tencent.liteav.network.e     // Catch:{ Exception -> 0x0248 }
                    r2.<init>(r12, r0)     // Catch:{ Exception -> 0x0248 }
                    r14.add(r2)     // Catch:{ Exception -> 0x0248 }
                    goto L_0x01d7
                L_0x01d3:
                    r16 = r0
                    r17 = r2
                L_0x01d7:
                    int r15 = r15 + 1
                    r0 = r16
                    r2 = r17
                    r12 = 1
                    goto L_0x0171
                L_0x01df:
                    r17 = r2
                    goto L_0x01e9
                L_0x01e2:
                    r17 = r2
                    java.lang.String r0 = "getAccelerateStreamPlayUrl: no pull_addr"
                    com.tencent.liteav.basic.log.TXCLog.e(r5, r0)     // Catch:{ Exception -> 0x0248 }
                L_0x01e9:
                    int r0 = r7     // Catch:{ Exception -> 0x0248 }
                    r2 = 1
                    if (r0 != r2) goto L_0x0203
                    int r0 = r14.size()     // Catch:{ Exception -> 0x0246 }
                    if (r0 <= 0) goto L_0x025a
                    com.tencent.liteav.network.k r0 = com.tencent.liteav.network.k.this     // Catch:{ Exception -> 0x0246 }
                    android.os.Handler r0 = r0.f31804e     // Catch:{ Exception -> 0x0246 }
                    com.tencent.liteav.network.k$2$1 r6 = new com.tencent.liteav.network.k$2$1     // Catch:{ Exception -> 0x0246 }
                    r6.<init>(r14)     // Catch:{ Exception -> 0x0246 }
                    r0.post(r6)     // Catch:{ Exception -> 0x0246 }
                    return
                L_0x0203:
                    int r0 = r7     // Catch:{ Exception -> 0x0246 }
                    r6 = 2
                    if (r0 != r6) goto L_0x021d
                    int r0 = r13.size()     // Catch:{ Exception -> 0x0246 }
                    if (r0 <= 0) goto L_0x025a
                    com.tencent.liteav.network.k r0 = com.tencent.liteav.network.k.this     // Catch:{ Exception -> 0x0246 }
                    android.os.Handler r0 = r0.f31804e     // Catch:{ Exception -> 0x0246 }
                    com.tencent.liteav.network.k$2$2 r6 = new com.tencent.liteav.network.k$2$2     // Catch:{ Exception -> 0x0246 }
                    r6.<init>(r13)     // Catch:{ Exception -> 0x0246 }
                    r0.post(r6)     // Catch:{ Exception -> 0x0246 }
                    return
                L_0x021d:
                    java.util.Iterator r0 = r14.iterator()     // Catch:{ Exception -> 0x0246 }
                L_0x0221:
                    boolean r6 = r0.hasNext()     // Catch:{ Exception -> 0x0246 }
                    if (r6 == 0) goto L_0x0231
                    java.lang.Object r6 = r0.next()     // Catch:{ Exception -> 0x0246 }
                    com.tencent.liteav.network.e r6 = (com.tencent.liteav.network.e) r6     // Catch:{ Exception -> 0x0246 }
                    r13.add(r6)     // Catch:{ Exception -> 0x0246 }
                    goto L_0x0221
                L_0x0231:
                    int r0 = r13.size()     // Catch:{ Exception -> 0x0246 }
                    if (r0 <= 0) goto L_0x025a
                    com.tencent.liteav.network.k r0 = com.tencent.liteav.network.k.this     // Catch:{ Exception -> 0x0246 }
                    android.os.Handler r0 = r0.f31804e     // Catch:{ Exception -> 0x0246 }
                    com.tencent.liteav.network.k$2$3 r6 = new com.tencent.liteav.network.k$2$3     // Catch:{ Exception -> 0x0246 }
                    r6.<init>(r13)     // Catch:{ Exception -> 0x0246 }
                    r0.post(r6)     // Catch:{ Exception -> 0x0246 }
                    return
                L_0x0246:
                    r0 = move-exception
                    goto L_0x0252
                L_0x0248:
                    r0 = move-exception
                    goto L_0x0251
                L_0x024a:
                    r17 = r2
                    r2 = 1
                    goto L_0x025a
                L_0x024e:
                    r0 = move-exception
                    r17 = r2
                L_0x0251:
                    r2 = 1
                L_0x0252:
                    java.lang.String r6 = "getAccelerateStreamPlayUrl exception"
                    com.tencent.liteav.basic.log.TXCLog.e(r5, r6)
                    r0.printStackTrace()
                L_0x025a:
                    r12 = 1000(0x3e8, double:4.94E-321)
                    r6 = 0
                    sleep(r12, r6)     // Catch:{ Exception -> 0x0261 }
                    goto L_0x026b
                L_0x0261:
                    r0 = move-exception
                    r12 = r0
                    java.lang.String r0 = "getAccelerateStreamPlayUrl exception sleep"
                    com.tencent.liteav.basic.log.TXCLog.e(r5, r0)
                    r12.printStackTrace()
                L_0x026b:
                    int r9 = r9 + -1
                    r2 = r17
                    r12 = 1
                    goto L_0x0042
                L_0x0272:
                    com.tencent.liteav.network.k r0 = com.tencent.liteav.network.k.this
                    android.os.Handler r0 = r0.f31804e
                    com.tencent.liteav.network.k$2$4 r2 = new com.tencent.liteav.network.k$2$4
                    r2.<init>(r10, r11)
                    r0.post(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.network.k.AnonymousClass2.run():void");
            }
        }.start();
    }

    private String a(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        for (String str3 : str2.split("[?&]")) {
            if (str3.indexOf(SimpleComparison.EQUAL_TO_OPERATION) != -1) {
                String[] split = str3.split("[=]");
                if (split.length == 2) {
                    String str4 = split[0];
                    String str5 = split[1];
                    if (str4 != null && str4.toLowerCase().equalsIgnoreCase(lowerCase)) {
                        return str5;
                    }
                } else {
                    continue;
                }
            }
        }
        return "";
    }
}
