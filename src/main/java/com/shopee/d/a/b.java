package com.shopee.d.a;

import com.shopee.shopeetracker.ShopeeTracker;
import com.shopee.shopeetracker.model.Config;
import com.shopee.shopeetracker.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f27123a = Pattern.compile("(\\d+.\\d+)/(\\d+.\\d+)/(\\d+.\\d+)/(\\d+.\\d+)");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f27124b = Pattern.compile("(\\d+) packets transmitted, (\\d+) (?:packets )?received, (\\d+\\.?\\d*)% packet loss");

    /* renamed from: c  reason: collision with root package name */
    private static List<String> f27125c;

    public void run() {
        try {
            if (!ShopeeTracker.isInitialized()) {
                return;
            }
            if (ShopeeTracker.getInstance().getConfig() != null) {
                if (!com.shopee.d.a.c.b.a(ShopeeTracker.getInstance().getContext())) {
                    double samplingRate = ShopeeTracker.getInstance().getConfig().getSamplingRate();
                    Logger.debug("PingTask", "sampling rate = " + samplingRate + "%");
                    if (Math.random() < samplingRate / 100.0d) {
                        List<String> a2 = a();
                        for (int i = 0; i < a2.size(); i++) {
                            a(a2.get(i));
                        }
                    }
                }
            }
        } catch (Exception e2) {
            Logger.debug("PingTask", e2.getMessage());
        }
    }

    private List<String> a() {
        List<String> list = f27125c;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Config config = ShopeeTracker.getInstance().getConfig();
        return config != null ? config.getPingUrlList() : arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f9 A[SYNTHETIC, Splitter:B:55:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0103 A[SYNTHETIC, Splitter:B:60:0x0103] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010e A[SYNTHETIC, Splitter:B:67:0x010e] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0118 A[SYNTHETIC, Splitter:B:72:0x0118] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0123 A[SYNTHETIC, Splitter:B:79:0x0123] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x012d A[SYNTHETIC, Splitter:B:84:0x012d] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x013a A[SYNTHETIC, Splitter:B:91:0x013a] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0144 A[SYNTHETIC, Splitter:B:96:0x0144] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:52:0x00f4=Splitter:B:52:0x00f4, B:64:0x0109=Splitter:B:64:0x0109, B:76:0x011e=Splitter:B:76:0x011e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "packet loss"
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            r3.<init>()     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            java.lang.String r4 = "ping -c 3 -w 100 "
            r3.append(r4)     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            r3.append(r9)     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            int r3 = r2.waitFor()     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            java.lang.String r4 = "pingtest"
            if (r3 == 0) goto L_0x0039
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            r9.<init>()     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            java.lang.String r0 = "status code  = "
            r9.append(r0)     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            r9.append(r3)     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            com.shopee.shopeetracker.utils.Logger.debug(r4, r9)     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            return
        L_0x0039:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ IOException -> 0x011c, InterruptedException -> 0x0107, Exception -> 0x00f2, all -> 0x00ee }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00ea, InterruptedException -> 0x00e6, Exception -> 0x00e2, all -> 0x00de }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00ea, InterruptedException -> 0x00e6, Exception -> 0x00e2, all -> 0x00de }
            r5.<init>(r2)     // Catch:{ IOException -> 0x00ea, InterruptedException -> 0x00e6, Exception -> 0x00e2, all -> 0x00de }
            r3.<init>(r5)     // Catch:{ IOException -> 0x00ea, InterruptedException -> 0x00e6, Exception -> 0x00e2, all -> 0x00de }
            com.shopee.d.a.a.e r1 = new com.shopee.d.a.a.e     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            r1.<init>()     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            r1.endpoint = r9     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
        L_0x004e:
            java.lang.String r9 = r3.readLine()     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            if (r9 == 0) goto L_0x00c0
            java.lang.String r5 = "rtt"
            boolean r5 = r9.startsWith(r5)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            if (r5 == 0) goto L_0x008c
            java.util.regex.Pattern r5 = f27123a     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            java.util.regex.Matcher r9 = r5.matcher(r9)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            boolean r5 = r9.find()     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            if (r5 == 0) goto L_0x004e
            r5 = 2
            java.lang.String r6 = r9.group(r5)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            double r6 = java.lang.Double.parseDouble(r6)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            r1.latency = r6     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            r6.<init>()     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            java.lang.String r9 = r9.group(r5)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            r6.append(r9)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            java.lang.String r9 = "latency"
            r6.append(r9)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            java.lang.String r9 = r6.toString()     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            com.shopee.shopeetracker.utils.Logger.debug(r4, r9)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            goto L_0x004e
        L_0x008c:
            boolean r5 = r9.contains(r0)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            if (r5 == 0) goto L_0x004e
            java.util.regex.Pattern r5 = f27124b     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            java.util.regex.Matcher r9 = r5.matcher(r9)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            boolean r5 = r9.find()     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            if (r5 == 0) goto L_0x004e
            r5 = 3
            java.lang.String r6 = r9.group(r5)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            double r6 = java.lang.Double.parseDouble(r6)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            r1.packetLossRate = r6     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            r6.<init>()     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            java.lang.String r9 = r9.group(r5)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            r6.append(r9)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            r6.append(r0)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            java.lang.String r9 = r6.toString()     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            com.shopee.shopeetracker.utils.Logger.debug(r4, r9)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            goto L_0x004e
        L_0x00c0:
            com.shopee.d.a.a.a(r1)     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            r3.close()     // Catch:{ IOException -> 0x00dc, InterruptedException -> 0x00da, Exception -> 0x00d8, all -> 0x00d5 }
            if (r2 == 0) goto L_0x00d0
            r2.close()     // Catch:{ Exception -> 0x00cc }
            goto L_0x00d0
        L_0x00cc:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00d0:
            r3.close()     // Catch:{ Exception -> 0x0131 }
            goto L_0x0135
        L_0x00d5:
            r9 = move-exception
            goto L_0x0138
        L_0x00d8:
            r9 = move-exception
            goto L_0x00e4
        L_0x00da:
            r9 = move-exception
            goto L_0x00e8
        L_0x00dc:
            r9 = move-exception
            goto L_0x00ec
        L_0x00de:
            r9 = move-exception
            r3 = r1
            goto L_0x0138
        L_0x00e2:
            r9 = move-exception
            r3 = r1
        L_0x00e4:
            r1 = r2
            goto L_0x00f4
        L_0x00e6:
            r9 = move-exception
            r3 = r1
        L_0x00e8:
            r1 = r2
            goto L_0x0109
        L_0x00ea:
            r9 = move-exception
            r3 = r1
        L_0x00ec:
            r1 = r2
            goto L_0x011e
        L_0x00ee:
            r9 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x0138
        L_0x00f2:
            r9 = move-exception
            r3 = r1
        L_0x00f4:
            r9.printStackTrace()     // Catch:{ all -> 0x0136 }
            if (r1 == 0) goto L_0x0101
            r1.close()     // Catch:{ Exception -> 0x00fd }
            goto L_0x0101
        L_0x00fd:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0101:
            if (r3 == 0) goto L_0x0135
            r3.close()     // Catch:{ Exception -> 0x0131 }
            goto L_0x0135
        L_0x0107:
            r9 = move-exception
            r3 = r1
        L_0x0109:
            r9.printStackTrace()     // Catch:{ all -> 0x0136 }
            if (r1 == 0) goto L_0x0116
            r1.close()     // Catch:{ Exception -> 0x0112 }
            goto L_0x0116
        L_0x0112:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0116:
            if (r3 == 0) goto L_0x0135
            r3.close()     // Catch:{ Exception -> 0x0131 }
            goto L_0x0135
        L_0x011c:
            r9 = move-exception
            r3 = r1
        L_0x011e:
            r9.printStackTrace()     // Catch:{ all -> 0x0136 }
            if (r1 == 0) goto L_0x012b
            r1.close()     // Catch:{ Exception -> 0x0127 }
            goto L_0x012b
        L_0x0127:
            r9 = move-exception
            r9.printStackTrace()
        L_0x012b:
            if (r3 == 0) goto L_0x0135
            r3.close()     // Catch:{ Exception -> 0x0131 }
            goto L_0x0135
        L_0x0131:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0135:
            return
        L_0x0136:
            r9 = move-exception
            r2 = r1
        L_0x0138:
            if (r2 == 0) goto L_0x0142
            r2.close()     // Catch:{ Exception -> 0x013e }
            goto L_0x0142
        L_0x013e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0142:
            if (r3 == 0) goto L_0x014c
            r3.close()     // Catch:{ Exception -> 0x0148 }
            goto L_0x014c
        L_0x0148:
            r0 = move-exception
            r0.printStackTrace()
        L_0x014c:
            goto L_0x014e
        L_0x014d:
            throw r9
        L_0x014e:
            goto L_0x014d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.d.a.b.a(java.lang.String):void");
    }
}
