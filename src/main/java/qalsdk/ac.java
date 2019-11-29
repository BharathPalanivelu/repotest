package qalsdk;

public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public static String f34065a = "im_open_status.stat_hello";

    /* renamed from: d  reason: collision with root package name */
    private static byte f34066d;

    /* renamed from: b  reason: collision with root package name */
    ad f34067b;

    /* renamed from: c  reason: collision with root package name */
    long f34068c = 0;

    public ac(ad adVar) {
        this.f34067b = adVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x014d A[Catch:{ Exception -> 0x0285 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0150 A[Catch:{ Exception -> 0x0285 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0181 A[Catch:{ Exception -> 0x0285 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0194 A[Catch:{ Exception -> 0x0285 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01b1 A[SYNTHETIC, Splitter:B:57:0x01b1] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01c0 A[Catch:{ Exception -> 0x0285 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01e1 A[Catch:{ Exception -> 0x0285 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01e7 A[Catch:{ Exception -> 0x0285 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0217 A[SYNTHETIC, Splitter:B:72:0x0217] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0241 A[Catch:{ Exception -> 0x0285 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(qalsdk.z r16, com.tencent.qalsdk.base.remote.ToServiceMsg r17, boolean r18, qalsdk.ag r19) {
        /*
            r15 = this;
            r1 = r15
            r2 = r16
            r3 = r19
            java.lang.String r4 = "im_open_status.stat_reg"
            java.lang.String r5 = "meizu"
            qalsdk.af r0 = r2.f34212g
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            boolean r0 = qalsdk.a.m()
            r6 = 2
            java.lang.String r7 = "MSF.C.PushManager:PushCoder"
            if (r0 == 0) goto L_0x0040
            qalsdk.af r0 = r2.f34212g
            java.lang.String r0 = r0.f34079a
            boolean r0 = qalsdk.a.a((java.lang.String) r0)
            if (r0 != 0) goto L_0x0040
            boolean r0 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r0 == 0) goto L_0x003f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            qalsdk.af r2 = r2.f34212g
            java.lang.String r2 = r2.f34079a
            r0.append(r2)
            java.lang.String r2 = " is booting and can not autoRegisterPush,return."
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.tencent.qalsdk.util.QLog.d(r7, r6, r0)
        L_0x003f:
            return
        L_0x0040:
            java.lang.String r0 = "unrtime"
            r8 = 1
            r9 = 0
            if (r18 == 0) goto L_0x0062
            java.lang.String r10 = r17.getUin()     // Catch:{ Exception -> 0x0060 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0060 }
            android.content.Context r13 = com.tencent.qalsdk.service.QalService.context     // Catch:{ Exception -> 0x0060 }
            android.content.SharedPreferences r0 = r13.getSharedPreferences(r0, r9)     // Catch:{ Exception -> 0x0060 }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ Exception -> 0x0060 }
            android.content.SharedPreferences$Editor r0 = r0.putLong(r10, r11)     // Catch:{ Exception -> 0x0060 }
            r0.commit()     // Catch:{ Exception -> 0x0060 }
            goto L_0x009f
        L_0x0060:
            r0 = move-exception
            goto L_0x008e
        L_0x0062:
            if (r17 == 0) goto L_0x009f
            java.lang.String r10 = r17.getUin()     // Catch:{ Exception -> 0x0060 }
            android.content.Context r11 = com.tencent.qalsdk.service.QalService.context     // Catch:{ Exception -> 0x0060 }
            android.content.SharedPreferences r11 = r11.getSharedPreferences(r0, r9)     // Catch:{ Exception -> 0x0060 }
            r12 = 0
            long r10 = r11.getLong(r10, r12)     // Catch:{ Exception -> 0x0060 }
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x009f
            java.lang.String r10 = r17.getUin()     // Catch:{ Exception -> 0x0060 }
            android.content.Context r11 = com.tencent.qalsdk.service.QalService.context     // Catch:{ Exception -> 0x0060 }
            android.content.SharedPreferences r0 = r11.getSharedPreferences(r0, r9)     // Catch:{ Exception -> 0x0060 }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ Exception -> 0x0060 }
            android.content.SharedPreferences$Editor r0 = r0.putLong(r10, r12)     // Catch:{ Exception -> 0x0060 }
            r0.commit()     // Catch:{ Exception -> 0x0060 }
            goto L_0x009f
        L_0x008e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "get reginterv error "
            r10.<init>(r11)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            com.tencent.qalsdk.util.QLog.d(r7, r8, r10, r0)
        L_0x009f:
            boolean r0 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r0 == 0) goto L_0x00ba
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r10 = "ConfigManager.isAutoStarting():"
            r0.<init>(r10)
            boolean r10 = qalsdk.a.m()
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            com.tencent.qalsdk.util.QLog.d(r7, r6, r0)
        L_0x00ba:
            com.tencent.qalsdk.im_open.stat_reg$ReqBody r0 = new com.tencent.qalsdk.im_open.stat_reg$ReqBody     // Catch:{ Exception -> 0x0285 }
            r0.<init>()     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBUInt64Field r6 = r0.uint64_bid     // Catch:{ Exception -> 0x0285 }
            long r10 = r2.f34208c     // Catch:{ Exception -> 0x0285 }
            r6.set(r10)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBUInt32Field r6 = r0.uint32_conn_type     // Catch:{ Exception -> 0x0285 }
            r6.set(r9)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBUInt32Field r6 = r0.uint32_status     // Catch:{ Exception -> 0x0285 }
            qalsdk.af r10 = r2.f34212g     // Catch:{ Exception -> 0x0285 }
            int r10 = r10.f34081c     // Catch:{ Exception -> 0x0285 }
            r6.set(r10)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBUInt32Field r6 = r0.uint32_kick_pc     // Catch:{ Exception -> 0x0285 }
            qalsdk.af r10 = r2.f34212g     // Catch:{ Exception -> 0x0285 }
            byte r10 = r10.f34082d     // Catch:{ Exception -> 0x0285 }
            r6.set(r10)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBUInt32Field r6 = r0.uint32_timestamp     // Catch:{ Exception -> 0x0285 }
            qalsdk.af r10 = r2.f34212g     // Catch:{ Exception -> 0x0285 }
            long r10 = r10.f34084f     // Catch:{ Exception -> 0x0285 }
            int r11 = (int) r10     // Catch:{ Exception -> 0x0285 }
            r6.set(r11)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBUInt32Field r6 = r0.uint32_regtype     // Catch:{ Exception -> 0x0285 }
            qalsdk.ag r10 = qalsdk.ag.appRegister     // Catch:{ Exception -> 0x0285 }
            if (r3 == r10) goto L_0x00f8
            qalsdk.ag r10 = qalsdk.ag.fillRegProxy     // Catch:{ Exception -> 0x0285 }
            if (r3 == r10) goto L_0x00f8
            qalsdk.ag r10 = qalsdk.ag.createDefaultRegInfo     // Catch:{ Exception -> 0x0285 }
            if (r3 != r10) goto L_0x00f6
            goto L_0x00f8
        L_0x00f6:
            r10 = 1
            goto L_0x00f9
        L_0x00f8:
            r10 = 0
        L_0x00f9:
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x0285 }
            r6.set(r10)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBBytesField r6 = r0.bytes_guid     // Catch:{ Exception -> 0x0285 }
            com.tencent.qalsdk.core.j.a()     // Catch:{ Exception -> 0x0285 }
            byte[] r10 = com.tencent.qalsdk.core.j.d()     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.ByteStringMicro r10 = com.tencent.mobileqq.pb.ByteStringMicro.copyFrom(r10)     // Catch:{ Exception -> 0x0285 }
            r6.set(r10)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBStringField r6 = r0.str_dev_name     // Catch:{ Exception -> 0x0285 }
            java.lang.String r10 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0285 }
            r6.set(r10)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBStringField r6 = r0.str_dev_type     // Catch:{ Exception -> 0x0285 }
            java.lang.String r10 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0285 }
            r6.set(r10)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBStringField r6 = r0.str_os_ver     // Catch:{ Exception -> 0x0285 }
            java.lang.String r10 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x0285 }
            r6.set(r10)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBStringField r6 = r0.str_build_ver     // Catch:{ Exception -> 0x0285 }
            java.lang.String r10 = android.os.Build.VERSION.SDK     // Catch:{ Exception -> 0x0285 }
            r6.set(r10)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBUInt32Field r6 = r0.vender_appid     // Catch:{ Exception -> 0x0285 }
            r6.set(r9)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBUInt64Field r6 = r0.uint64_tinyid     // Catch:{ Exception -> 0x0285 }
            qalsdk.af r10 = r2.f34212g     // Catch:{ Exception -> 0x0285 }
            java.lang.String r10 = r10.f34079a     // Catch:{ Exception -> 0x0285 }
            long r10 = java.lang.Long.parseLong(r10)     // Catch:{ Exception -> 0x0285 }
            r6.set(r10)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r6 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x0285 }
            r10 = 2002(0x7d2, float:2.805E-42)
            java.util.Locale r11 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0285 }
            java.lang.String r11 = r6.toLowerCase(r11)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r12 = "xiaomi"
            boolean r11 = r11.contains(r12)     // Catch:{ Exception -> 0x0285 }
            if (r11 == 0) goto L_0x0150
            r10 = 2000(0x7d0, float:2.803E-42)
            goto L_0x0183
        L_0x0150:
            java.util.Locale r11 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0285 }
            java.lang.String r6 = r6.toLowerCase(r11)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r11 = "huawei"
            boolean r6 = r6.contains(r11)     // Catch:{ Exception -> 0x0285 }
            if (r6 == 0) goto L_0x0161
            r10 = 2001(0x7d1, float:2.804E-42)
            goto L_0x0183
        L_0x0161:
            java.lang.String r6 = android.os.Build.BRAND     // Catch:{ Exception -> 0x0285 }
            boolean r6 = r5.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0285 }
            if (r6 != 0) goto L_0x017e
            java.lang.String r6 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x0285 }
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0285 }
            if (r5 != 0) goto L_0x017e
            java.lang.String r5 = "22c4185e"
            java.lang.String r6 = android.os.Build.BRAND     // Catch:{ Exception -> 0x0285 }
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0285 }
            if (r5 == 0) goto L_0x017c
            goto L_0x017e
        L_0x017c:
            r5 = 0
            goto L_0x017f
        L_0x017e:
            r5 = 1
        L_0x017f:
            if (r5 == 0) goto L_0x0183
            r10 = 2003(0x7d3, float:2.807E-42)
        L_0x0183:
            com.tencent.mobileqq.pb.PBUInt32Field r5 = r0.uint32_inst_type     // Catch:{ Exception -> 0x0285 }
            r5.set(r10)     // Catch:{ Exception -> 0x0285 }
            com.tencent.qalsdk.config.NativeConfigStore r5 = com.tencent.qalsdk.core.l.a()     // Catch:{ Exception -> 0x0285 }
            java.lang.String r6 = "IMOPEN_STAT_DEFINE_VERSION"
            java.lang.String r5 = r5.getConfig(r6)     // Catch:{ Exception -> 0x0285 }
            if (r5 == 0) goto L_0x0199
            com.tencent.mobileqq.pb.PBStringField r6 = r0.str_define_version     // Catch:{ Exception -> 0x0285 }
            r6.set(r5)     // Catch:{ Exception -> 0x0285 }
        L_0x0199:
            byte[] r5 = r0.toByteArray()     // Catch:{ Exception -> 0x0285 }
            com.tencent.qalsdk.base.remote.ToServiceMsg r6 = new com.tencent.qalsdk.base.remote.ToServiceMsg     // Catch:{ Exception -> 0x0285 }
            java.lang.String r10 = ""
            qalsdk.af r11 = r2.f34212g     // Catch:{ Exception -> 0x0285 }
            java.lang.String r11 = r11.f34079a     // Catch:{ Exception -> 0x0285 }
            r6.<init>(r10, r11, r4)     // Catch:{ Exception -> 0x0285 }
            int r10 = r2.f34206a     // Catch:{ Exception -> 0x0285 }
            r6.setAppId(r10)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r10 = "to_srcCmd"
            if (r17 == 0) goto L_0x01c0
            int r4 = r17.getAppSeq()     // Catch:{ Exception -> 0x0285 }
            r6.setAppSeq(r4)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r4 = r17.getServiceCmd()     // Catch:{ Exception -> 0x0285 }
            r6.addAttribute(r10, r4)     // Catch:{ Exception -> 0x0285 }
            goto L_0x01c3
        L_0x01c0:
            r6.addAttribute(r10, r4)     // Catch:{ Exception -> 0x0285 }
        L_0x01c3:
            int r4 = com.tencent.qalsdk.core.j.b()     // Catch:{ Exception -> 0x0285 }
            r6.setRequestSsoSeq(r4)     // Catch:{ Exception -> 0x0285 }
            byte[] r4 = com.tencent.qalsdk.core.n.a((byte[]) r5)     // Catch:{ Exception -> 0x0285 }
            r6.putWupBuffer(r4)     // Catch:{ Exception -> 0x0285 }
            r4 = 10000(0x2710, double:4.9407E-320)
            r6.setTimeout(r4)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r4 = "regPushReason"
            java.lang.String r5 = r19.toString()     // Catch:{ Exception -> 0x0285 }
            r6.addAttribute(r4, r5)     // Catch:{ Exception -> 0x0285 }
            if (r18 == 0) goto L_0x01e7
            com.tencent.qalsdk.sdk.MsfCommand r4 = com.tencent.qalsdk.sdk.MsfCommand._msf_UnRegPush     // Catch:{ Exception -> 0x0285 }
            r6.setMsfCommand(r4)     // Catch:{ Exception -> 0x0285 }
            goto L_0x01ec
        L_0x01e7:
            com.tencent.qalsdk.sdk.MsfCommand r4 = com.tencent.qalsdk.sdk.MsfCommand._msf_RegPush     // Catch:{ Exception -> 0x0285 }
            r6.setMsfCommand(r4)     // Catch:{ Exception -> 0x0285 }
        L_0x01ec:
            java.lang.String r4 = r2.f34207b     // Catch:{ Exception -> 0x0285 }
            com.tencent.qalsdk.sdk.MsfSdkUtils.addToMsgProcessName(r4, r6)     // Catch:{ Exception -> 0x0285 }
            java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0285 }
            qalsdk.ag r4 = qalsdk.ag.appRegister     // Catch:{ Exception -> 0x0285 }
            if (r3 == r4) goto L_0x01ff
            qalsdk.ag r4 = qalsdk.ag.setAppQuit     // Catch:{ Exception -> 0x0285 }
            if (r3 != r4) goto L_0x01ff
            r6.setNeedCallback(r9)     // Catch:{ Exception -> 0x0285 }
        L_0x01ff:
            qalsdk.ad r3 = r1.f34067b     // Catch:{ Exception -> 0x0285 }
            com.tencent.qalsdk.core.j r3 = r3.f34072d     // Catch:{ Exception -> 0x0285 }
            com.tencent.qalsdk.core.n r3 = r3.f32187c     // Catch:{ Exception -> 0x0285 }
            r3.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r6)     // Catch:{ Exception -> 0x0285 }
            r6.getRequestSsoSeq()     // Catch:{ Exception -> 0x0285 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0285 }
            r2.f34209d = r3     // Catch:{ Exception -> 0x0285 }
            java.lang.String r3 = " bRegType:"
            java.lang.String r4 = " pushStatus:"
            if (r18 == 0) goto L_0x0241
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0285 }
            java.lang.String r6 = "send unregister.push id "
            r5.<init>(r6)     // Catch:{ Exception -> 0x0285 }
            long r9 = r2.f34208c     // Catch:{ Exception -> 0x0285 }
            r5.append(r9)     // Catch:{ Exception -> 0x0285 }
            r5.append(r4)     // Catch:{ Exception -> 0x0285 }
            qalsdk.af r2 = r2.f34212g     // Catch:{ Exception -> 0x0285 }
            int r2 = r2.f34081c     // Catch:{ Exception -> 0x0285 }
            r5.append(r2)     // Catch:{ Exception -> 0x0285 }
            r5.append(r3)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBUInt32Field r0 = r0.uint32_regtype     // Catch:{ Exception -> 0x0285 }
            int r0 = r0.get()     // Catch:{ Exception -> 0x0285 }
            r5.append(r0)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0285 }
            com.tencent.qalsdk.util.QLog.i(r7, r8, r0)     // Catch:{ Exception -> 0x0285 }
            goto L_0x0297
        L_0x0241:
            r2.j = r8     // Catch:{ Exception -> 0x0285 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0285 }
            java.lang.String r6 = "send register. push id "
            r5.<init>(r6)     // Catch:{ Exception -> 0x0285 }
            long r9 = r2.f34208c     // Catch:{ Exception -> 0x0285 }
            r5.append(r9)     // Catch:{ Exception -> 0x0285 }
            r5.append(r4)     // Catch:{ Exception -> 0x0285 }
            qalsdk.af r4 = r2.f34212g     // Catch:{ Exception -> 0x0285 }
            int r4 = r4.f34081c     // Catch:{ Exception -> 0x0285 }
            r5.append(r4)     // Catch:{ Exception -> 0x0285 }
            r5.append(r3)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBUInt32Field r3 = r0.uint32_regtype     // Catch:{ Exception -> 0x0285 }
            int r3 = r3.get()     // Catch:{ Exception -> 0x0285 }
            r5.append(r3)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r3 = " timeStamp:"
            r5.append(r3)     // Catch:{ Exception -> 0x0285 }
            com.tencent.mobileqq.pb.PBUInt32Field r0 = r0.uint32_timestamp     // Catch:{ Exception -> 0x0285 }
            int r0 = r0.get()     // Catch:{ Exception -> 0x0285 }
            r5.append(r0)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r0 = ":"
            r5.append(r0)     // Catch:{ Exception -> 0x0285 }
            long r2 = r2.f34209d     // Catch:{ Exception -> 0x0285 }
            r5.append(r2)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0285 }
            com.tencent.qalsdk.util.QLog.i(r7, r8, r0)     // Catch:{ Exception -> 0x0285 }
            goto L_0x0297
        L_0x0285:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "send registerPush error "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.tencent.qalsdk.util.QLog.d(r7, r8, r2, r0)
        L_0x0297:
            qalsdk.ad r0 = r1.f34067b
            r0.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.ac.a(qalsdk.z, com.tencent.qalsdk.base.remote.ToServiceMsg, boolean, qalsdk.ag):void");
    }
}
