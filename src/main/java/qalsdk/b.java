package qalsdk;

final class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f34115a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ boolean f34116b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ String f34117c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ a f34118d;

    b(a aVar, String str, boolean z, String str2) {
        this.f34118d = aVar;
        this.f34115a = str;
        this.f34116b = z;
        this.f34117c = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0238 A[SYNTHETIC, Splitter:B:64:0x0238] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x023f A[Catch:{ Exception -> 0x02be }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02ba A[Catch:{ Exception -> 0x02be }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[ADDED_TO_REGION, Catch:{ Exception -> 0x02be }, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r2 = "|"
            java.lang.String r3 = "|0"
            java.lang.String r0 = ":"
            java.lang.String r4 = "MSF.C.ConfigManager"
            com.tencent.qalsdk.im_open.mobroute$MobRouteSSOListReq r5 = new com.tencent.qalsdk.im_open.mobroute$MobRouteSSOListReq     // Catch:{ Exception -> 0x02be }
            r5.<init>()     // Catch:{ Exception -> 0x02be }
            java.lang.String r6 = com.tencent.qalsdk.core.k.a()     // Catch:{ Exception -> 0x02be }
            if (r6 == 0) goto L_0x001e
            com.tencent.mobileqq.pb.PBStringField r6 = r5.string_imei     // Catch:{ Exception -> 0x02be }
            java.lang.String r7 = com.tencent.qalsdk.core.k.a()     // Catch:{ Exception -> 0x02be }
            r6.set(r7)     // Catch:{ Exception -> 0x02be }
        L_0x001e:
            java.lang.String r6 = com.tencent.qalsdk.core.k.b()     // Catch:{ Exception -> 0x02be }
            if (r6 == 0) goto L_0x002d
            com.tencent.mobileqq.pb.PBStringField r6 = r5.string_imsi     // Catch:{ Exception -> 0x02be }
            java.lang.String r7 = com.tencent.qalsdk.core.k.b()     // Catch:{ Exception -> 0x02be }
            r6.set(r7)     // Catch:{ Exception -> 0x02be }
        L_0x002d:
            java.lang.String r6 = r1.f34115a     // Catch:{ Exception -> 0x02be }
            if (r6 == 0) goto L_0x0038
            com.tencent.mobileqq.pb.PBStringField r6 = r5.string_uin     // Catch:{ Exception -> 0x02be }
            java.lang.String r7 = r1.f34115a     // Catch:{ Exception -> 0x02be }
            r6.set(r7)     // Catch:{ Exception -> 0x02be }
        L_0x0038:
            boolean r6 = r1.f34116b     // Catch:{ Exception -> 0x02be }
            r7 = 2
            r8 = 1
            if (r6 == 0) goto L_0x0040
            r6 = 1
            goto L_0x0041
        L_0x0040:
            r6 = 2
        L_0x0041:
            com.tencent.mobileqq.pb.PBUInt32Field r9 = r5.uint32_nettype     // Catch:{ Exception -> 0x02be }
            r9.set(r6)     // Catch:{ Exception -> 0x02be }
            com.tencent.mobileqq.pb.PBUInt32Field r6 = r5.uint32_uintype     // Catch:{ Exception -> 0x02be }
            r9 = 20
            r6.set(r9)     // Catch:{ Exception -> 0x02be }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02be }
            java.lang.String r9 = "get http:"
            r6.<init>(r9)     // Catch:{ Exception -> 0x02be }
            java.lang.String r9 = com.tencent.qalsdk.core.k.a()     // Catch:{ Exception -> 0x02be }
            r6.append(r9)     // Catch:{ Exception -> 0x02be }
            r6.append(r0)     // Catch:{ Exception -> 0x02be }
            java.lang.String r9 = com.tencent.qalsdk.core.k.b()     // Catch:{ Exception -> 0x02be }
            r6.append(r9)     // Catch:{ Exception -> 0x02be }
            r6.append(r0)     // Catch:{ Exception -> 0x02be }
            java.lang.String r0 = r1.f34115a     // Catch:{ Exception -> 0x02be }
            r6.append(r0)     // Catch:{ Exception -> 0x02be }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x02be }
            com.tencent.qalsdk.util.QLog.d(r4, r0)     // Catch:{ Exception -> 0x02be }
            com.tencent.mobileqq.pb.PBUInt32Field r0 = r5.uint32_appid     // Catch:{ Exception -> 0x02be }
            qalsdk.a r6 = r1.f34118d     // Catch:{ Exception -> 0x02be }
            com.tencent.qalsdk.core.j r6 = r6.f34054f     // Catch:{ Exception -> 0x02be }
            int r6 = r6.h()     // Catch:{ Exception -> 0x02be }
            r0.set(r6)     // Catch:{ Exception -> 0x02be }
            int r0 = r5.getSerializedSize()     // Catch:{ Exception -> 0x02be }
            int r0 = r0 + 14
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ Exception -> 0x02be }
            r6.put(r7)     // Catch:{ Exception -> 0x02be }
            r6.putInt(r0)     // Catch:{ Exception -> 0x02be }
            r6.putShort(r8)     // Catch:{ Exception -> 0x02be }
            r6.putShort(r7)     // Catch:{ Exception -> 0x02be }
            int r0 = com.tencent.qalsdk.core.j.b()     // Catch:{ Exception -> 0x02be }
            r6.putInt(r0)     // Catch:{ Exception -> 0x02be }
            byte[] r0 = r5.toByteArray()     // Catch:{ Exception -> 0x02be }
            r6.put(r0)     // Catch:{ Exception -> 0x02be }
            r0 = 3
            r6.put(r0)     // Catch:{ Exception -> 0x02be }
            r6.flip()     // Catch:{ Exception -> 0x02be }
            int r5 = r6.limit()     // Catch:{ Exception -> 0x02be }
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x02be }
            r6.get(r5)     // Catch:{ Exception -> 0x02be }
            com.tencent.qalsdk.util.Cryptor r6 = new com.tencent.qalsdk.util.Cryptor     // Catch:{ Exception -> 0x02be }
            r6.<init>()     // Catch:{ Exception -> 0x02be }
            byte[] r9 = qalsdk.a.f34053g     // Catch:{ Exception -> 0x02be }
            byte[] r5 = r6.encrypt(r5, r9)     // Catch:{ Exception -> 0x02be }
            r6 = 0
            java.lang.String r9 = "succ"
            r10 = 0
            java.net.URL r11 = new java.net.URL     // Catch:{ Throwable -> 0x0224 }
            java.lang.String r12 = "http://configsvr.openmsf.3g.qq.com/configsvr/openlist.jsp"
            r11.<init>(r12)     // Catch:{ Throwable -> 0x0224 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0224 }
            java.lang.String r14 = "start send http sso svrlist  msg"
            com.tencent.qalsdk.util.QLog.i(r4, r8, r14)     // Catch:{ Throwable -> 0x0224 }
            java.net.URLConnection r11 = r11.openConnection()     // Catch:{ Throwable -> 0x0224 }
            java.lang.Object r11 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r11)     // Catch:{ Throwable -> 0x0224 }
            java.net.URLConnection r11 = (java.net.URLConnection) r11     // Catch:{ Throwable -> 0x0224 }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ Throwable -> 0x0224 }
            r11.setDoOutput(r8)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.lang.String r6 = "POST"
            r11.setRequestMethod(r6)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r6 = 20000(0x4e20, float:2.8026E-41)
            r11.setConnectTimeout(r6)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r11.setReadTimeout(r6)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.io.OutputStream r6 = r11.getOutputStream()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r6.write(r5)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.io.OutputStream r5 = r11.getOutputStream()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r5.flush()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.io.OutputStream r5 = r11.getOutputStream()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r5.close()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            int r5 = r11.getResponseCode()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r6 = 200(0xc8, float:2.8E-43)
            r14 = 4
            if (r5 != r6) goto L_0x01d5
            r5 = 128(0x80, float:1.794E-43)
            byte[] r5 = new byte[r5]     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r6.<init>()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r15 = 0
        L_0x011a:
            java.io.InputStream r7 = r11.getInputStream()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            int r7 = r7.read(r5)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r0 = -1
            if (r7 == r0) goto L_0x0130
            byte[] r0 = new byte[r7]     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.lang.System.arraycopy(r5, r10, r0, r10, r7)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r6.add(r0)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            int r15 = r15 + r7
            r0 = 3
            goto L_0x011a
        L_0x0130:
            int r0 = r6.size()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            if (r0 != r8) goto L_0x013d
            java.lang.Object r0 = r6.get(r10)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            byte[] r0 = (byte[]) r0     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            goto L_0x0157
        L_0x013d:
            byte[] r0 = new byte[r15]     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.util.Iterator r5 = r6.iterator()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r6 = 0
        L_0x0144:
            boolean r7 = r5.hasNext()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            if (r7 == 0) goto L_0x0157
            java.lang.Object r7 = r5.next()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            byte[] r7 = (byte[]) r7     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            int r15 = r7.length     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.lang.System.arraycopy(r7, r10, r0, r6, r15)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            int r7 = r7.length     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            int r6 = r6 + r7
            goto L_0x0144
        L_0x0157:
            boolean r5 = com.tencent.qalsdk.util.QLog.isDevelopLevel()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            if (r5 == 0) goto L_0x017c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.lang.String r6 = "send checkSso msg , costTime "
            r5.<init>(r6)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            long r6 = r6 - r12
            r5.append(r6)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.lang.String r6 = " allData len is "
            r5.append(r6)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            int r6 = r0.length     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r5.append(r6)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            com.tencent.qalsdk.util.QLog.d(r4, r14, r5)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
        L_0x017c:
            com.tencent.qalsdk.util.Cryptor r5 = new com.tencent.qalsdk.util.Cryptor     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r5.<init>()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            byte[] r6 = qalsdk.a.f34053g     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            byte[] r0 = r5.decrypt(r0, r6)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            boolean r0 = qalsdk.a.a((byte[]) r0)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            if (r0 == 0) goto L_0x01a0
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            qalsdk.a.f34049b = r5     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            qalsdk.a r0 = r1.f34118d     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            com.tencent.qalsdk.core.j r0 = r0.f34054f     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            qalsdk.k r0 = r0.k     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r0.f34161e = r8     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            goto L_0x01b0
        L_0x01a0:
            java.lang.String r0 = "received sso list is null."
            com.tencent.qalsdk.util.QLog.d(r4, r8, r0)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            qalsdk.a r0 = r1.f34118d     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            com.tencent.qalsdk.core.j r0 = r0.f34054f     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            qalsdk.k r0 = r0.k     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r5 = 3
            r0.f34161e = r5     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
        L_0x01b0:
            boolean r0 = r1.f34116b     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            if (r0 != 0) goto L_0x01c4
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            long r7 = r7 + r5
            qalsdk.a.f34051d = r7     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            qalsdk.a r0 = r1.f34118d     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r0.o()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            goto L_0x0214
        L_0x01c4:
            boolean r0 = r1.f34116b     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            if (r0 == 0) goto L_0x0214
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            long r7 = r7 + r5
            qalsdk.a.f34052e = r7     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            qalsdk.a r0 = r1.f34118d     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r0.p()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            goto L_0x0214
        L_0x01d5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.lang.String r6 = "respCode is "
            r0.<init>(r6)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r0.append(r5)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.lang.String r9 = r0.toString()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            boolean r0 = com.tencent.qalsdk.util.QLog.isDevelopLevel()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.lang.String r6 = "send checkSso msg , resp code is "
            if (r0 == 0) goto L_0x01fa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r0.<init>(r6)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r0.append(r5)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            com.tencent.qalsdk.util.QLog.d(r4, r14, r0)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
        L_0x01fa:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r0.<init>(r6)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r0.append(r5)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            com.tencent.qalsdk.util.QLog.e(r4, r8, r0)     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            qalsdk.a r0 = r1.f34118d     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            com.tencent.qalsdk.core.j r0 = r0.f34054f     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            qalsdk.k r0 = r0.k     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
            r5 = 3
            r0.f34161e = r5     // Catch:{ Throwable -> 0x021d, all -> 0x021a }
        L_0x0214:
            if (r11 == 0) goto L_0x023b
            r11.disconnect()     // Catch:{ Exception -> 0x02be }
            goto L_0x023b
        L_0x021a:
            r0 = move-exception
            goto L_0x02b8
        L_0x021d:
            r0 = move-exception
            r6 = r11
            goto L_0x0225
        L_0x0220:
            r0 = move-exception
            r11 = r6
            goto L_0x02b8
        L_0x0224:
            r0 = move-exception
        L_0x0225:
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x0220 }
            r0.printStackTrace()     // Catch:{ all -> 0x0220 }
            qalsdk.a r0 = r1.f34118d     // Catch:{ all -> 0x0220 }
            com.tencent.qalsdk.core.j r0 = r0.f34054f     // Catch:{ all -> 0x0220 }
            com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ all -> 0x0220 }
            qalsdk.k r0 = r0.k     // Catch:{ all -> 0x0220 }
            r0.f34161e = r10     // Catch:{ all -> 0x0220 }
            if (r6 == 0) goto L_0x023b
            r6.disconnect()     // Catch:{ Exception -> 0x02be }
        L_0x023b:
            java.lang.String r0 = r1.f34117c     // Catch:{ Exception -> 0x02be }
            if (r0 == 0) goto L_0x02b7
            java.lang.String r0 = r1.f34117c     // Catch:{ Exception -> 0x02be }
            int r0 = r0.length()     // Catch:{ Exception -> 0x02be }
            if (r0 <= 0) goto L_0x02b7
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x02be }
            r5.<init>()     // Catch:{ Exception -> 0x02be }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02be }
            r0.<init>()     // Catch:{ Exception -> 0x02be }
            qalsdk.a r6 = r1.f34118d     // Catch:{ Exception -> 0x02be }
            com.tencent.qalsdk.core.j r6 = r6.f34054f     // Catch:{ Exception -> 0x02be }
            java.text.SimpleDateFormat r6 = r6.h     // Catch:{ Exception -> 0x02be }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02be }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x02be }
            java.lang.String r6 = r6.format(r7)     // Catch:{ Exception -> 0x02be }
            r0.append(r6)     // Catch:{ Exception -> 0x02be }
            r0.append(r3)     // Catch:{ Exception -> 0x02be }
            r0.append(r3)     // Catch:{ Exception -> 0x02be }
            r0.append(r2)     // Catch:{ Exception -> 0x02be }
            java.lang.String r3 = r1.f34117c     // Catch:{ Exception -> 0x02be }
            r0.append(r3)     // Catch:{ Exception -> 0x02be }
            r0.append(r2)     // Catch:{ Exception -> 0x02be }
            r0.append(r9)     // Catch:{ Exception -> 0x02be }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02be }
            boolean r2 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x02be }
            if (r2 == 0) goto L_0x0296
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02be }
            java.lang.String r3 = "add waitReportData "
            r2.<init>(r3)     // Catch:{ Exception -> 0x02be }
            r2.append(r0)     // Catch:{ Exception -> 0x02be }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02be }
            r3 = 2
            com.tencent.qalsdk.util.QLog.d(r4, r3, r2)     // Catch:{ Exception -> 0x02be }
        L_0x0296:
            java.lang.String r2 = "utf-8"
            byte[] r0 = r0.getBytes(r2)     // Catch:{ UnsupportedEncodingException -> 0x02a0 }
            r5.add(r0)     // Catch:{ UnsupportedEncodingException -> 0x02a0 }
            goto L_0x02a4
        L_0x02a0:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x02be }
        L_0x02a4:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x02be }
            r0.<init>()     // Catch:{ Exception -> 0x02be }
            java.lang.String r2 = "CHECKSSOLISTBYHTTP"
            r0.put(r2, r5)     // Catch:{ Exception -> 0x02be }
            qalsdk.a r2 = r1.f34118d     // Catch:{ Exception -> 0x02be }
            com.tencent.qalsdk.core.j r2 = r2.f34054f     // Catch:{ Exception -> 0x02be }
            com.tencent.qalsdk.core.n r2 = r2.f32187c     // Catch:{ Exception -> 0x02be }
            r2.a((java.util.HashMap<java.lang.String, java.util.ArrayList<byte[]>>) r0)     // Catch:{ Exception -> 0x02be }
        L_0x02b7:
            return
        L_0x02b8:
            if (r11 == 0) goto L_0x02bd
            r11.disconnect()     // Catch:{ Exception -> 0x02be }
        L_0x02bd:
            throw r0     // Catch:{ Exception -> 0x02be }
        L_0x02be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.b.run():void");
    }
}
