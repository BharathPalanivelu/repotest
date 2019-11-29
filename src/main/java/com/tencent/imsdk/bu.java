package com.tencent.imsdk;

import com.tencent.imsdk.utils.QualityReportHelper;
import java.util.List;

final class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TIMCallBack f30789a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ List f30790b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ QualityReportHelper f30791c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ String f30792d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ long f30793e;

    /* renamed from: f  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30794f;

    bu(IMMsfCoreProxy iMMsfCoreProxy, List list, TIMCallBack tIMCallBack, QualityReportHelper qualityReportHelper, String str, long j) {
        this.f30794f = iMMsfCoreProxy;
        this.f30790b = list;
        this.f30789a = tIMCallBack;
        this.f30791c = qualityReportHelper;
        this.f30792d = str;
        this.f30793e = j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x013d, code lost:
        com.tencent.imsdk.IMMsfCoreProxy.mainHandler.post(new com.tencent.imsdk.bx(r12));
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012e A[Catch:{ Throwable -> 0x00ed, Throwable -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013d A[EDGE_INSN: B:60:0x013d->B:39:0x013d ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r12 = this;
            java.lang.String r0 = "imsdk.IMMsfCoreProxy"
            java.util.List r1 = r12.f30790b
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = 0
        L_0x000a:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x01a8
            java.lang.Object r4 = r1.next()
            java.lang.String r4 = (java.lang.String) r4
            r5 = 1
            int r3 = r3 + r5
            r6 = 0
            r7 = 6010(0x177a, float:8.422E-42)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0186 }
            java.lang.String r9 = "downloading from url: "
            r8.<init>(r9)     // Catch:{ Throwable -> 0x0186 }
            r8.append(r4)     // Catch:{ Throwable -> 0x0186 }
            java.lang.String r8 = r8.toString()     // Catch:{ Throwable -> 0x0186 }
            com.tencent.imsdk.log.QLog.d(r0, r5, r8)     // Catch:{ Throwable -> 0x0186 }
            java.net.URL r8 = new java.net.URL     // Catch:{ Throwable -> 0x0186 }
            r8.<init>(r4)     // Catch:{ Throwable -> 0x0186 }
            java.net.URLConnection r4 = r8.openConnection()     // Catch:{ Throwable -> 0x0186 }
            java.lang.Object r4 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r4)     // Catch:{ Throwable -> 0x0186 }
            java.net.URLConnection r4 = (java.net.URLConnection) r4     // Catch:{ Throwable -> 0x0186 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Throwable -> 0x0186 }
            java.lang.String r6 = "connection"
            java.lang.String r8 = "close"
            r4.setRequestProperty(r6, r8)     // Catch:{ Throwable -> 0x0184 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0184 }
            java.lang.String r8 = "http resp code: "
            r6.<init>(r8)     // Catch:{ Throwable -> 0x0184 }
            int r8 = r4.getResponseCode()     // Catch:{ Throwable -> 0x0184 }
            r6.append(r8)     // Catch:{ Throwable -> 0x0184 }
            java.lang.String r8 = "|descr: "
            r6.append(r8)     // Catch:{ Throwable -> 0x0184 }
            java.lang.String r8 = r4.getResponseMessage()     // Catch:{ Throwable -> 0x0184 }
            r6.append(r8)     // Catch:{ Throwable -> 0x0184 }
            java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x0184 }
            com.tencent.imsdk.log.QLog.d(r0, r5, r6)     // Catch:{ Throwable -> 0x0184 }
            int r6 = r4.getResponseCode()     // Catch:{ Throwable -> 0x0184 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r6 == r8) goto L_0x00a7
            java.util.List r6 = r12.f30790b     // Catch:{ Throwable -> 0x0184 }
            int r6 = r6.size()     // Catch:{ Throwable -> 0x0184 }
            if (r3 >= r6) goto L_0x0076
            goto L_0x000a
        L_0x0076:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0184 }
            r1.<init>()     // Catch:{ Throwable -> 0x0184 }
            int r2 = r4.getResponseCode()     // Catch:{ Throwable -> 0x0184 }
            r1.append(r2)     // Catch:{ Throwable -> 0x0184 }
            java.lang.String r2 = "|"
            r1.append(r2)     // Catch:{ Throwable -> 0x0184 }
            java.lang.String r2 = r4.getResponseMessage()     // Catch:{ Throwable -> 0x0184 }
            r1.append(r2)     // Catch:{ Throwable -> 0x0184 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0184 }
            android.os.Handler r2 = com.tencent.imsdk.IMMsfCoreProxy.mainHandler     // Catch:{ Throwable -> 0x0184 }
            com.tencent.imsdk.bv r3 = new com.tencent.imsdk.bv     // Catch:{ Throwable -> 0x0184 }
            r3.<init>(r12, r1)     // Catch:{ Throwable -> 0x0184 }
            r2.post(r3)     // Catch:{ Throwable -> 0x0184 }
            com.tencent.imsdk.utils.QualityReportHelper r2 = r12.f30791c     // Catch:{ Throwable -> 0x0184 }
            r2.init(r7, r1)     // Catch:{ Throwable -> 0x0184 }
            com.tencent.imsdk.utils.QualityReportHelper r1 = r12.f30791c     // Catch:{ Throwable -> 0x0184 }
            r1.report()     // Catch:{ Throwable -> 0x0184 }
            return
        L_0x00a7:
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ Throwable -> 0x014d }
            java.io.InputStream r7 = r4.getInputStream()     // Catch:{ Throwable -> 0x014d }
            r6.<init>(r7)     // Catch:{ Throwable -> 0x014d }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x014d }
            java.lang.String r8 = r12.f30792d     // Catch:{ Throwable -> 0x014d }
            r7.<init>(r8)     // Catch:{ Throwable -> 0x014d }
            r8 = 10240(0x2800, float:1.4349E-41)
            byte[] r8 = new byte[r8]     // Catch:{ Throwable -> 0x014d }
        L_0x00bb:
            int r9 = r6.read(r8)     // Catch:{ Throwable -> 0x014d }
            if (r9 < 0) goto L_0x00c5
            r7.write(r8, r2, r9)     // Catch:{ Throwable -> 0x014d }
            goto L_0x00bb
        L_0x00c5:
            r7.flush()     // Catch:{ Throwable -> 0x014d }
            r7.close()     // Catch:{ Throwable -> 0x014d }
            com.tencent.imsdk.utils.QualityReportHelper r6 = r12.f30791c     // Catch:{ Throwable -> 0x014d }
            java.lang.String r7 = ""
            r6.init(r2, r7)     // Catch:{ Throwable -> 0x014d }
            com.tencent.imsdk.utils.QualityReportHelper r6 = r12.f30791c     // Catch:{ Throwable -> 0x014d }
            r6.report()     // Catch:{ Throwable -> 0x014d }
            r6 = 0
        L_0x00d8:
            java.io.File r7 = new java.io.File     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r8 = r12.f30792d     // Catch:{ Throwable -> 0x00ed }
            r7.<init>(r8)     // Catch:{ Throwable -> 0x00ed }
            boolean r8 = r7.exists()     // Catch:{ Throwable -> 0x00ed }
            if (r8 == 0) goto L_0x00eb
            long r7 = r7.length()     // Catch:{ Throwable -> 0x00ed }
            int r8 = (int) r7
            goto L_0x0104
        L_0x00eb:
            r8 = 0
            goto L_0x0104
        L_0x00ed:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x014d }
            java.lang.String r9 = "getVideoSize: "
            r8.<init>(r9)     // Catch:{ Throwable -> 0x014d }
            java.lang.String r7 = com.tencent.imsdk.log.QLog.getStackTraceString(r7)     // Catch:{ Throwable -> 0x014d }
            r8.append(r7)     // Catch:{ Throwable -> 0x014d }
            java.lang.String r7 = r8.toString()     // Catch:{ Throwable -> 0x014d }
            com.tencent.imsdk.log.QLog.e(r0, r5, r7)     // Catch:{ Throwable -> 0x014d }
            goto L_0x00eb
        L_0x0104:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x014d }
            java.lang.String r9 = "downloading...filesize: "
            r7.<init>(r9)     // Catch:{ Throwable -> 0x014d }
            r7.append(r8)     // Catch:{ Throwable -> 0x014d }
            java.lang.String r9 = "|expectedSize: "
            r7.append(r9)     // Catch:{ Throwable -> 0x014d }
            long r9 = r12.f30793e     // Catch:{ Throwable -> 0x014d }
            r7.append(r9)     // Catch:{ Throwable -> 0x014d }
            java.lang.String r9 = "|times: "
            r7.append(r9)     // Catch:{ Throwable -> 0x014d }
            r7.append(r6)     // Catch:{ Throwable -> 0x014d }
            java.lang.String r7 = r7.toString()     // Catch:{ Throwable -> 0x014d }
            com.tencent.imsdk.log.QLog.w(r0, r5, r7)     // Catch:{ Throwable -> 0x014d }
            long r7 = (long) r8     // Catch:{ Throwable -> 0x014d }
            long r9 = r12.f30793e     // Catch:{ Throwable -> 0x014d }
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x013d
            r7 = 4
            if (r6 < r7) goto L_0x0132
            goto L_0x013d
        L_0x0132:
            r7 = 100
            java.lang.Thread.sleep(r7)     // Catch:{ Throwable -> 0x014d }
            int r6 = r6 + 1
            r7 = 5
            if (r6 < r7) goto L_0x00d8
            goto L_0x0147
        L_0x013d:
            android.os.Handler r6 = com.tencent.imsdk.IMMsfCoreProxy.mainHandler     // Catch:{ Throwable -> 0x014d }
            com.tencent.imsdk.bx r7 = new com.tencent.imsdk.bx     // Catch:{ Throwable -> 0x014d }
            r7.<init>(r12)     // Catch:{ Throwable -> 0x014d }
            r6.post(r7)     // Catch:{ Throwable -> 0x014d }
        L_0x0147:
            r4.disconnect()
            return
        L_0x014b:
            r0 = move-exception
            goto L_0x0180
        L_0x014d:
            r6 = move-exception
            java.lang.String r6 = com.tencent.imsdk.log.QLog.getStackTraceString(r6)     // Catch:{ all -> 0x014b }
            com.tencent.imsdk.log.QLog.e(r0, r5, r6)     // Catch:{ all -> 0x014b }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x014b }
            java.lang.String r7 = r12.f30792d     // Catch:{ all -> 0x014b }
            r5.<init>(r7)     // Catch:{ all -> 0x014b }
            boolean r7 = r5.exists()     // Catch:{ all -> 0x014b }
            if (r7 == 0) goto L_0x0165
            r5.delete()     // Catch:{ all -> 0x014b }
        L_0x0165:
            android.os.Handler r5 = com.tencent.imsdk.IMMsfCoreProxy.mainHandler     // Catch:{ all -> 0x014b }
            com.tencent.imsdk.by r7 = new com.tencent.imsdk.by     // Catch:{ all -> 0x014b }
            r7.<init>(r12, r6)     // Catch:{ all -> 0x014b }
            r5.post(r7)     // Catch:{ all -> 0x014b }
            com.tencent.imsdk.utils.QualityReportHelper r5 = r12.f30791c     // Catch:{ all -> 0x014b }
            r7 = 6022(0x1786, float:8.439E-42)
            r5.init(r7, r6)     // Catch:{ all -> 0x014b }
            com.tencent.imsdk.utils.QualityReportHelper r5 = r12.f30791c     // Catch:{ all -> 0x014b }
            r5.report()     // Catch:{ all -> 0x014b }
            r4.disconnect()
            goto L_0x000a
        L_0x0180:
            r4.disconnect()
            throw r0
        L_0x0184:
            r1 = move-exception
            goto L_0x0188
        L_0x0186:
            r1 = move-exception
            r4 = r6
        L_0x0188:
            java.lang.String r1 = com.tencent.imsdk.log.QLog.getStackTraceString(r1)
            com.tencent.imsdk.log.QLog.e(r0, r5, r1)
            android.os.Handler r0 = com.tencent.imsdk.IMMsfCoreProxy.mainHandler
            com.tencent.imsdk.bw r2 = new com.tencent.imsdk.bw
            r2.<init>(r12, r1)
            r0.post(r2)
            com.tencent.imsdk.utils.QualityReportHelper r0 = r12.f30791c
            r0.init(r7, r1)
            com.tencent.imsdk.utils.QualityReportHelper r0 = r12.f30791c
            r0.report()
            if (r4 == 0) goto L_0x01a8
            r4.disconnect()
        L_0x01a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.bu.run():void");
    }
}
