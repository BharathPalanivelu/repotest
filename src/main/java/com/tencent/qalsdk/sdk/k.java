package com.tencent.qalsdk.sdk;

import android.content.Context;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.im_open.logParams;
import com.tencent.qalsdk.service.QalService;
import com.tencent.qalsdk.util.QLog;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static String f32253a = "k";

    /* renamed from: b  reason: collision with root package name */
    private static String f32254b = "report.zip";

    /* renamed from: c  reason: collision with root package name */
    private static String f32255c = (QLog.getLogBasePath() + "/logzip/");

    /* renamed from: d  reason: collision with root package name */
    private static String f32256d = "--";

    /* renamed from: e  reason: collision with root package name */
    private static String f32257e = IOUtils.LINE_SEPARATOR_WINDOWS;

    public k() {
        Context context = QalService.context;
    }

    public final void a(FromServiceMsg fromServiceMsg) {
        logParams.LogParams logParams = new logParams.LogParams();
        try {
            logParams.mergeFrom(c.a(fromServiceMsg));
            new l(this, logParams).start();
        } catch (InvalidProtocolBufferMicroException e2) {
            e2.printStackTrace();
        }
    }

    private byte[] a(long j, long j2, int i) {
        try {
            File file = new File(f32255c + f32254b);
            if (file.exists()) {
                file.delete();
            }
            a(j, j2, i, f32255c);
            FileInputStream fileInputStream = new FileInputStream(f32255c + f32254b);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e4 A[SYNTHETIC, Splitter:B:43:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f0 A[SYNTHETIC, Splitter:B:48:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(long r18, long r20, int r22, java.lang.String r23) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r22
            r1 = r23
            r2 = 3600(0xe10, double:1.7786E-320)
            long r4 = r18 / r2
            long r4 = r4 * r2
            long r6 = r20 / r2
            r8 = 1
            long r6 = r6 + r8
            long r6 = r6 * r2
            r8 = 0
            java.io.File r9 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00de }
            r9.<init>(r1)     // Catch:{ FileNotFoundException -> 0x00de }
            boolean r10 = r9.exists()     // Catch:{ FileNotFoundException -> 0x00de }
            if (r10 != 0) goto L_0x0020
            r9.mkdir()     // Catch:{ FileNotFoundException -> 0x00de }
        L_0x0020:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00de }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00de }
            r10.<init>()     // Catch:{ FileNotFoundException -> 0x00de }
            r10.append(r1)     // Catch:{ FileNotFoundException -> 0x00de }
            java.lang.String r1 = f32254b     // Catch:{ FileNotFoundException -> 0x00de }
            r10.append(r1)     // Catch:{ FileNotFoundException -> 0x00de }
            java.lang.String r1 = r10.toString()     // Catch:{ FileNotFoundException -> 0x00de }
            r9.<init>(r1)     // Catch:{ FileNotFoundException -> 0x00de }
            java.util.zip.ZipOutputStream r1 = new java.util.zip.ZipOutputStream     // Catch:{ FileNotFoundException -> 0x00de }
            r1.<init>(r9)     // Catch:{ FileNotFoundException -> 0x00de }
            r8 = 1
            java.lang.String r9 = "zip file:"
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 3
            if (r0 == r8) goto L_0x0045
            if (r0 != r12) goto L_0x008c
        L_0x0045:
            r13 = r4
        L_0x0046:
            int r8 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x008c
            long r15 = r13 * r10
            java.lang.String r8 = com.tencent.qalsdk.util.QLog.getLogFileName(r15)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            r15.<init>()     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            java.lang.String r10 = com.tencent.qalsdk.util.QLog.getFilePath()     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            r15.append(r10)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            r15.append(r8)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            java.lang.String r8 = r15.toString()     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            java.io.File r10 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            r10.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            boolean r11 = r10.exists()     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            if (r11 == 0) goto L_0x0082
            java.lang.String r11 = f32253a     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            r15.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            r15.append(r8)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            java.lang.String r8 = r15.toString()     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            com.tencent.qalsdk.util.QLog.d(r11, r8)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            a((java.io.File) r10, (java.util.zip.ZipOutputStream) r1)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
        L_0x0082:
            long r13 = r13 + r2
            r10 = 1000(0x3e8, double:4.94E-321)
            goto L_0x0046
        L_0x0086:
            r0 = move-exception
            r8 = r1
            goto L_0x00dc
        L_0x0089:
            r0 = move-exception
            r8 = r1
            goto L_0x00df
        L_0x008c:
            r8 = 2
            if (r0 == r8) goto L_0x0091
            if (r0 != r12) goto L_0x00d1
        L_0x0091:
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x00d1
            r10 = 1000(0x3e8, double:4.94E-321)
            long r12 = r4 * r10
            java.lang.String r0 = com.tencent.qalsdk.util.ALog.getLogFileName(r12)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            java.lang.String r12 = com.tencent.qalsdk.util.ALog.getFilePath()     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            r8.append(r12)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            r8.append(r0)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            java.lang.String r0 = r8.toString()     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            java.io.File r8 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            r8.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            boolean r12 = r8.exists()     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            if (r12 == 0) goto L_0x00cf
            java.lang.String r12 = f32253a     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            r13.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            r13.append(r0)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            java.lang.String r0 = r13.toString()     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            com.tencent.qalsdk.util.QLog.d(r12, r0)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
            a((java.io.File) r8, (java.util.zip.ZipOutputStream) r1)     // Catch:{ FileNotFoundException -> 0x0089, all -> 0x0086 }
        L_0x00cf:
            long r4 = r4 + r2
            goto L_0x0091
        L_0x00d1:
            r1.close()     // Catch:{ IOException -> 0x00d5 }
            return
        L_0x00d5:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
            return
        L_0x00db:
            r0 = move-exception
        L_0x00dc:
            r1 = r0
            goto L_0x00ee
        L_0x00de:
            r0 = move-exception
        L_0x00df:
            r0.printStackTrace()     // Catch:{ all -> 0x00db }
            if (r8 == 0) goto L_0x00ed
            r8.close()     // Catch:{ IOException -> 0x00e8 }
            goto L_0x00ed
        L_0x00e8:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x00ed:
            return
        L_0x00ee:
            if (r8 == 0) goto L_0x00f9
            r8.close()     // Catch:{ IOException -> 0x00f4 }
            goto L_0x00f9
        L_0x00f4:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x00f9:
            goto L_0x00fb
        L_0x00fa:
            throw r1
        L_0x00fb:
            goto L_0x00fa
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.sdk.k.a(long, long, int, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067 A[SYNTHETIC, Splitter:B:26:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089 A[SYNTHETIC, Splitter:B:34:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0099 A[SYNTHETIC, Splitter:B:39:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0054=Splitter:B:23:0x0054, B:31:0x0076=Splitter:B:31:0x0076} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.io.File r5, java.util.zip.ZipOutputStream r6) {
        /*
            java.lang.String r0 = "创建ZIP文件失败"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0053 }
            r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0053 }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0053 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0053 }
            r4.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0053 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0053 }
            java.util.zip.ZipEntry r1 = new java.util.zip.ZipEntry     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, all -> 0x0048 }
            java.lang.String r5 = r5.getName()     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, all -> 0x0048 }
            r1.<init>(r5)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, all -> 0x0048 }
            r6.putNextEntry(r1)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, all -> 0x0048 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, all -> 0x0048 }
        L_0x0022:
            int r1 = r2.read(r5)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, all -> 0x0048 }
            r4 = -1
            if (r1 == r4) goto L_0x0031
            r4 = 0
            r6.write(r5, r4, r1)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, all -> 0x0048 }
            r6.flush()     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, all -> 0x0048 }
            goto L_0x0022
        L_0x0031:
            r3.close()     // Catch:{ IOException -> 0x0035 }
            return
        L_0x0035:
            r5 = move-exception
            java.lang.String r6 = f32253a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
        L_0x003d:
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            com.tencent.qalsdk.util.QLog.e(r6, r5)
            return
        L_0x0048:
            r5 = move-exception
            r1 = r3
            goto L_0x0097
        L_0x004b:
            r5 = move-exception
            r1 = r3
            goto L_0x0054
        L_0x004e:
            r5 = move-exception
            r1 = r3
            goto L_0x0076
        L_0x0051:
            r5 = move-exception
            goto L_0x0097
        L_0x0053:
            r5 = move-exception
        L_0x0054:
            java.lang.String r6 = f32253a     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r2.<init>(r0)     // Catch:{ all -> 0x0051 }
            r2.append(r5)     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0051 }
            com.tencent.qalsdk.util.QLog.e(r6, r5)     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x0074
            r1.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x0074
        L_0x006b:
            r5 = move-exception
            java.lang.String r6 = f32253a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            goto L_0x003d
        L_0x0074:
            return
        L_0x0075:
            r5 = move-exception
        L_0x0076:
            java.lang.String r6 = f32253a     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r2.<init>(r0)     // Catch:{ all -> 0x0051 }
            r2.append(r5)     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0051 }
            com.tencent.qalsdk.util.QLog.e(r6, r5)     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x0096
            r1.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0096
        L_0x008d:
            r5 = move-exception
            java.lang.String r6 = f32253a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            goto L_0x003d
        L_0x0096:
            return
        L_0x0097:
            if (r1 == 0) goto L_0x00af
            r1.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00af
        L_0x009d:
            r6 = move-exception
            java.lang.String r1 = f32253a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            com.tencent.qalsdk.util.QLog.e(r1, r6)
        L_0x00af:
            goto L_0x00b1
        L_0x00b0:
            throw r5
        L_0x00b1:
            goto L_0x00b0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.sdk.k.a(java.io.File, java.util.zip.ZipOutputStream):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x026c A[SYNTHETIC, Splitter:B:60:0x026c] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0274 A[Catch:{ IOException -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0279 A[Catch:{ IOException -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0285 A[SYNTHETIC, Splitter:B:72:0x0285] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x028d A[Catch:{ IOException -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0292 A[Catch:{ IOException -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.qalsdk.sdk.k r15, com.tencent.qalsdk.im_open.logParams.LogParams r16) {
        /*
            r0 = r16
            java.lang.String r1 = "response:"
            java.lang.String r2 = "-------qalsdklogios"
            com.tencent.mobileqq.pb.PBStringField r3 = r0.url
            java.lang.String r3 = r3.get()
            com.tencent.mobileqq.pb.PBStringField r4 = r0.authorization
            java.lang.String r4 = r4.get()
            com.tencent.mobileqq.pb.PBUInt32Field r5 = r0.begtime
            int r5 = r5.get()
            long r7 = (long) r5
            com.tencent.mobileqq.pb.PBUInt32Field r5 = r0.endtime
            int r5 = r5.get()
            long r9 = (long) r5
            com.tencent.mobileqq.pb.PBEnumField r5 = r0.apn
            int r5 = r5.get()
            java.lang.String r6 = f32253a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "network:"
            r11.<init>(r12)
            boolean r12 = com.tencent.qalsdk.core.m.d()
            r11.append(r12)
            java.lang.String r12 = ":"
            r11.append(r12)
            boolean r13 = com.tencent.qalsdk.core.m.e()
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            com.tencent.qalsdk.util.QLog.d(r6, r11)
            boolean r6 = com.tencent.qalsdk.core.m.d()
            r13 = 0
            r14 = 1
            if (r6 != 0) goto L_0x0058
            r6 = 8
            if (r5 != r6) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r5 = 0
            goto L_0x0059
        L_0x0058:
            r5 = 1
        L_0x0059:
            if (r5 != 0) goto L_0x0063
            java.lang.String r0 = f32253a
            java.lang.String r1 = "network check, need not report"
            com.tencent.qalsdk.util.QLog.d(r0, r1)
            return
        L_0x0063:
            com.tencent.mobileqq.pb.PBEnumField r0 = r0.logtype
            int r11 = r0.get()
            r6 = r15
            byte[] r0 = r6.a(r7, r9, r11)
            if (r0 != 0) goto L_0x0078
            java.lang.String r0 = f32253a
            java.lang.String r1 = "no log"
            com.tencent.qalsdk.util.QLog.d(r0, r1)
            return
        L_0x0078:
            r5 = 0
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r6.<init>(r3)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.net.URLConnection r3 = r6.openConnection()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.Object r3 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r3)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.net.URLConnection r3 = (java.net.URLConnection) r3     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r3.setDoInput(r14)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r3.setDoOutput(r14)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r7 = 15000(0x3a98, float:2.102E-41)
            r3.setConnectTimeout(r7)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r3.setReadTimeout(r7)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r7 = "POST"
            r3.setRequestMethod(r7)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r7 = "Host"
            java.lang.String r8 = "web.file.myqcloud.com"
            r3.setRequestProperty(r7, r8)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r7 = "Authorization"
            r3.setRequestProperty(r7, r4)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = "multipart/form-data; boundary=-------qalsdklogios"
            r3.setRequestProperty(r7, r8)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r7.<init>()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r8 = f32257e     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r7.append(r8)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.<init>()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r9 = f32256d     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r9)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r2)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r9 = f32257e     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r9)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r7.append(r8)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r8 = "Content-Disposition: form-data; name=\"op\""
            r7.append(r8)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.<init>()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r9 = f32257e     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r9)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r9 = f32257e     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r9)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r7.append(r8)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r8 = "upload"
            r7.append(r8)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r8 = f32257e     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r7.append(r8)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.<init>()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r9 = f32256d     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r9)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r2)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r9 = f32257e     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r9)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r7.append(r8)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r8 = "Content-Disposition: form-data; name=\"filecontent\";filename=\"report.zip\""
            r7.append(r8)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.<init>()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r9 = f32257e     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r9)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r9 = f32257e     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r9)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r7.append(r8)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.<init>()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r9 = f32256d     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r9)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r2)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r2 = f32257e     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r8.append(r2)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r2 = r8.toString()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r8 = "Content-Length"
            java.lang.String r9 = r7.toString()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            byte[] r9 = r9.getBytes()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            int r9 = r9.length     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            int r10 = r0.length     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            int r9 = r9 + r10
            java.lang.String r10 = f32257e     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            int r10 = r10.length()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            int r9 = r9 + r10
            int r10 = r2.length()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            int r9 = r9 + r10
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r3.setRequestProperty(r8, r9)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.io.OutputStream r8 = r3.getOutputStream()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r9 = r7.toString()     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            byte[] r9 = r9.getBytes()     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r8.write(r9)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r8.write(r0)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            java.lang.String r0 = f32257e     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r8.write(r0)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            byte[] r0 = r2.getBytes()     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r8.write(r0)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r8.flush()     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            java.lang.String r0 = f32253a     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            java.lang.String r9 = "http request:"
            r2.<init>(r9)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r2.append(r6)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            java.lang.String r6 = "|"
            r2.append(r6)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r2.append(r4)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            java.lang.String r4 = "|body len:"
            r2.append(r4)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            int r4 = r7.length()     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r2.append(r4)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            com.tencent.qalsdk.util.QLog.i(r0, r2)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            int r0 = r3.getResponseCode()     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            java.lang.String r2 = f32253a     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r4.append(r0)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r4.append(r12)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            java.lang.String r6 = r3.getResponseMessage()     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r4.append(r6)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            com.tencent.qalsdk.util.QLog.i(r2, r4)     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L_0x023f
            java.io.InputStream r2 = r3.getInputStream()     // Catch:{ Exception -> 0x025c, all -> 0x0258 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x023b, all -> 0x0236 }
            r3.<init>()     // Catch:{ Exception -> 0x023b, all -> 0x0236 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
        L_0x01de:
            int r4 = r2.read(r0)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            if (r4 <= 0) goto L_0x01e8
            r3.write(r0, r13, r4)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            goto L_0x01de
        L_0x01e8:
            byte[] r0 = r3.toByteArray()     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            java.lang.String r4 = "code"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            java.lang.String r5 = "message"
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            java.lang.String r7 = "data"
            java.lang.String r0 = r0.getString(r7)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            java.lang.String r0 = f32253a     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            r7.<init>(r1)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            r7.append(r4)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            r7.append(r12)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            r7.append(r5)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            r7.append(r12)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            java.lang.String r1 = "access_url"
            java.lang.String r1 = r6.getString(r1)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            r7.append(r1)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            com.tencent.qalsdk.util.QLog.d(r0, r1)     // Catch:{ Exception -> 0x0234, all -> 0x0231 }
            goto L_0x0241
        L_0x0231:
            r0 = move-exception
            r1 = r0
            goto L_0x0239
        L_0x0234:
            r0 = move-exception
            goto L_0x023d
        L_0x0236:
            r0 = move-exception
            r1 = r0
            r3 = r5
        L_0x0239:
            r5 = r2
            goto L_0x0283
        L_0x023b:
            r0 = move-exception
            r3 = r5
        L_0x023d:
            r5 = r2
            goto L_0x0267
        L_0x023f:
            r2 = r5
            r3 = r2
        L_0x0241:
            if (r2 == 0) goto L_0x0249
            r2.close()     // Catch:{ IOException -> 0x0247 }
            goto L_0x0249
        L_0x0247:
            r0 = move-exception
            goto L_0x0254
        L_0x0249:
            if (r8 == 0) goto L_0x024e
            r8.close()     // Catch:{ IOException -> 0x0247 }
        L_0x024e:
            if (r3 == 0) goto L_0x0257
            r3.close()     // Catch:{ IOException -> 0x0247 }
            goto L_0x0257
        L_0x0254:
            r0.printStackTrace()
        L_0x0257:
            return
        L_0x0258:
            r0 = move-exception
            r1 = r0
            r3 = r5
            goto L_0x0283
        L_0x025c:
            r0 = move-exception
            r3 = r5
            goto L_0x0267
        L_0x025f:
            r0 = move-exception
            r1 = r0
            r3 = r5
            r8 = r3
            goto L_0x0283
        L_0x0264:
            r0 = move-exception
            r3 = r5
            r8 = r3
        L_0x0267:
            r0.printStackTrace()     // Catch:{ all -> 0x0281 }
            if (r5 == 0) goto L_0x0272
            r5.close()     // Catch:{ IOException -> 0x0270 }
            goto L_0x0272
        L_0x0270:
            r0 = move-exception
            goto L_0x027d
        L_0x0272:
            if (r8 == 0) goto L_0x0277
            r8.close()     // Catch:{ IOException -> 0x0270 }
        L_0x0277:
            if (r3 == 0) goto L_0x0280
            r3.close()     // Catch:{ IOException -> 0x0270 }
            goto L_0x0280
        L_0x027d:
            r0.printStackTrace()
        L_0x0280:
            return
        L_0x0281:
            r0 = move-exception
            r1 = r0
        L_0x0283:
            if (r5 == 0) goto L_0x028b
            r5.close()     // Catch:{ IOException -> 0x0289 }
            goto L_0x028b
        L_0x0289:
            r0 = move-exception
            goto L_0x0296
        L_0x028b:
            if (r8 == 0) goto L_0x0290
            r8.close()     // Catch:{ IOException -> 0x0289 }
        L_0x0290:
            if (r3 == 0) goto L_0x0299
            r3.close()     // Catch:{ IOException -> 0x0289 }
            goto L_0x0299
        L_0x0296:
            r0.printStackTrace()
        L_0x0299:
            goto L_0x029b
        L_0x029a:
            throw r1
        L_0x029b:
            goto L_0x029a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.sdk.k.a(com.tencent.qalsdk.sdk.k, com.tencent.qalsdk.im_open.logParams$LogParams):void");
    }
}
