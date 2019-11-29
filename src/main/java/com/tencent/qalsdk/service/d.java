package com.tencent.qalsdk.service;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f32313a = "MSF.S.ReqHandler";

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0266 A[Catch:{ Exception -> 0x0379 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0275 A[Catch:{ Exception -> 0x0379 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.qalsdk.base.remote.ToServiceMsg r8) {
        /*
            r7 = this;
            java.lang.String r0 = "|"
            if (r8 != 0) goto L_0x0005
            return
        L_0x0005:
            java.util.concurrent.atomic.AtomicBoolean r1 = com.tencent.qalsdk.core.j.f32185a
            boolean r1 = r1.get()
            if (r1 != 0) goto L_0x0015
            java.lang.String r8 = f32313a
            java.lang.String r0 = "so not load yet,return!"
            com.tencent.qalsdk.util.QLog.e(r8, r0)
            return
        L_0x0015:
            java.lang.String r1 = com.tencent.qalsdk.config.a.d(r8)
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "__timestamp_app2msf"
            r8.addAttribute(r3, r2)
            int[] r2 = com.tencent.qalsdk.service.f.f32314a
            com.tencent.qalsdk.sdk.MsfCommand r3 = r8.getMsfCommand()
            int r3 = r3.ordinal()
            r2 = r2[r3]
            java.lang.String r3 = "sig"
            r4 = 1
            switch(r2) {
                case 1: goto L_0x0189;
                case 2: goto L_0x016d;
                case 3: goto L_0x0167;
                case 4: goto L_0x0161;
                case 5: goto L_0x0159;
                case 6: goto L_0x014d;
                case 7: goto L_0x0141;
                case 8: goto L_0x012b;
                case 9: goto L_0x00fc;
                case 10: goto L_0x00e7;
                case 11: goto L_0x00d1;
                case 12: goto L_0x00c3;
                case 13: goto L_0x0086;
                case 14: goto L_0x0069;
                case 15: goto L_0x005a;
                case 16: goto L_0x0048;
                default: goto L_0x0038;
            }
        L_0x0038:
            com.tencent.qalsdk.core.j r1 = com.tencent.qalsdk.service.QalService.core
            com.tencent.qalsdk.core.n r1 = r1.f32187c
            if (r1 == 0) goto L_0x037d
            com.tencent.qalsdk.core.j r1 = com.tencent.qalsdk.service.QalService.core
            com.tencent.qalsdk.core.n r1 = r1.f32187c
            qalsdk.k r1 = r1.k
            if (r1 != 0) goto L_0x01ba
            goto L_0x037d
        L_0x0048:
            java.lang.String r0 = "defineVersion"
            java.lang.Object r8 = r8.getAttribute(r0)
            java.lang.String r8 = (java.lang.String) r8
            com.tencent.qalsdk.config.NativeConfigStore r0 = com.tencent.qalsdk.core.l.a()
            java.lang.String r1 = "IMOPEN_STAT_DEFINE_VERSION"
            r0.setConfig(r1, r8)
            return
        L_0x005a:
            r8.getAttribute(r3)
            com.tencent.qalsdk.core.j r8 = com.tencent.qalsdk.service.QalService.getCore()
            qalsdk.c r8 = r8.g()
            r8.j()
            return
        L_0x0069:
            r8.getAttribute(r3)
            java.lang.String r0 = "proxyList"
            java.lang.Object r8 = r8.getAttribute(r0)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r0 = ";"
            java.lang.String[] r8 = android.text.TextUtils.split(r8, r0)
            com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.service.QalService.getCore()
            qalsdk.c r0 = r0.g()
            r0.a((java.lang.String[]) r8)
            return
        L_0x0086:
            java.lang.String r0 = "serverEnv"
            java.lang.Object r8 = r8.getAttribute(r0)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            com.tencent.qalsdk.service.QalService.getCore()
            com.tencent.qalsdk.core.j.b((int) r8)
            if (r8 != r4) goto L_0x00aa
            com.tencent.qalsdk.core.j r8 = com.tencent.qalsdk.core.j.a()
            com.tencent.qalsdk.core.n r8 = r8.f32187c
            com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.core.j.a()
            android.content.Context r0 = r0.k
            r8.b((android.content.Context) r0)
            goto L_0x00b5
        L_0x00aa:
            com.tencent.qalsdk.core.j r8 = com.tencent.qalsdk.core.j.a()
            com.tencent.qalsdk.core.n r8 = r8.f32187c
            qalsdk.k r8 = r8.k
            r8.j()
        L_0x00b5:
            com.tencent.qalsdk.core.j r8 = com.tencent.qalsdk.core.j.a()
            com.tencent.qalsdk.core.n r8 = r8.f32187c
            qalsdk.k r8 = r8.k
            com.tencent.qalsdk.base.CloseConnReason r0 = com.tencent.qalsdk.base.CloseConnReason.closeByChangeServerEnv
            r8.a((com.tencent.qalsdk.base.CloseConnReason) r0)
            return
        L_0x00c3:
            java.lang.Thread r8 = new java.lang.Thread
            com.tencent.qalsdk.service.e r0 = new com.tencent.qalsdk.service.e
            r0.<init>(r7)
            r8.<init>(r0)
            r8.start()
            return
        L_0x00d1:
            java.lang.String r0 = "logLevel"
            java.lang.Object r8 = r8.getAttribute(r0)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            com.tencent.qalsdk.service.QalService.getCore()
            com.tencent.qalsdk.core.j.a((int) r8)
            com.tencent.qalsdk.util.QLog.setOutputLogLevel(r8)
            return
        L_0x00e7:
            java.lang.String r0 = "appVersion"
            java.lang.Object r0 = r8.getAttribute(r0)
            java.lang.String r0 = (java.lang.String) r0
            com.tencent.qalsdk.service.QalService.appVersion = r0
            java.lang.String r0 = "appChannel"
            java.lang.Object r8 = r8.getAttribute(r0)
            java.lang.String r8 = (java.lang.String) r8
            com.tencent.qalsdk.service.QalService.appChannel = r8
            return
        L_0x00fc:
            com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.service.QalService.core
            com.tencent.qalsdk.core.n r0 = r0.f32187c
            java.util.concurrent.ConcurrentHashMap r0 = r0.f()
            int r1 = r8.getRequestSsoSeq()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.remove(r1)
            java.util.HashMap r8 = r8.getAttributes()
            java.lang.String r0 = "to_timeoutCallbacker"
            java.lang.Object r8 = r8.remove(r0)
            java.lang.Runnable r8 = (java.lang.Runnable) r8
            com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.service.QalService.core
            com.tencent.qalsdk.core.i r0 = r0.i()
            android.os.Handler r0 = r0.b()
            if (r0 == 0) goto L_0x012a
            r0.removeCallbacks(r8)
        L_0x012a:
            return
        L_0x012b:
            java.lang.String r0 = com.tencent.qalsdk.core.n.b()
            com.tencent.qalsdk.base.remote.FromServiceMsg r2 = com.tencent.qalsdk.config.a.c(r8)
            java.lang.String r3 = r8.getServiceCmd()
            r2.addAttribute(r3, r0)
            r2.setMsgSuccess()
            com.tencent.qalsdk.service.c.a((java.lang.String) r1, (com.tencent.qalsdk.base.remote.ToServiceMsg) r8, (com.tencent.qalsdk.base.remote.FromServiceMsg) r2)
            return
        L_0x0141:
            com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.service.QalService.core
            qalsdk.aa r1 = com.tencent.qalsdk.config.a.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r8)
            qalsdk.ad r0 = r0.f32188d
            r0.b((qalsdk.aa) r1, (com.tencent.qalsdk.base.remote.ToServiceMsg) r8)
            return
        L_0x014d:
            com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.service.QalService.core
            qalsdk.aa r1 = com.tencent.qalsdk.config.a.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r8)
            qalsdk.ad r0 = r0.f32188d
            r0.a((qalsdk.aa) r1, (com.tencent.qalsdk.base.remote.ToServiceMsg) r8)
            return
        L_0x0159:
            com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.service.QalService.core
            qalsdk.ad r0 = r0.f32188d
            r0.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r8)
            return
        L_0x0161:
            com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.service.QalService.core
            r0.b((com.tencent.qalsdk.base.remote.ToServiceMsg) r8)
            return
        L_0x0167:
            com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.service.QalService.core
            r0.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r8)
            return
        L_0x016d:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            android.os.Bundle r2 = r8.extraData
            java.lang.String r3 = "to_stop_wake_process"
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x0185
            android.os.Bundle r8 = r8.extraData
            boolean r8 = r8.getBoolean(r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r8)
        L_0x0185:
            com.tencent.qalsdk.service.c.a((java.lang.String) r1, (java.lang.Boolean) r0)
            return
        L_0x0189:
            java.util.HashMap r0 = r8.getAttributes()
            java.lang.String r1 = "intent_bindServiceInfo"
            java.lang.Object r0 = r0.get(r1)
            com.tencent.qalsdk.base.remote.MsfServiceBindInfo r0 = (com.tencent.qalsdk.base.remote.MsfServiceBindInfo) r0
            java.lang.String r1 = r0.getProcessName()
            java.lang.String r2 = r0.getBootBoradcastName()
            com.tencent.qalsdk.base.remote.IMsfServiceCallbacker r0 = r0.getMsfServiceCallbacker()
            r8.getAppId()
            com.tencent.qalsdk.service.c.a((java.lang.String) r1, (java.lang.String) r2, (com.tencent.qalsdk.base.remote.IMsfServiceCallbacker) r0)
            java.lang.String r0 = com.tencent.qalsdk.config.a.d(r8)
            int r8 = r8.getAppId()
            com.tencent.qalsdk.core.j.a((java.lang.String) r0, (int) r8)
            com.tencent.qalsdk.core.j r8 = com.tencent.qalsdk.core.j.a()
            r8.j()
            return
        L_0x01ba:
            com.tencent.qalsdk.core.j r1 = com.tencent.qalsdk.service.QalService.core
            com.tencent.qalsdk.core.n r1 = r1.f32187c
            qalsdk.k r1 = r1.k
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.f34160d
            boolean r1 = r1.get()
            if (r1 != 0) goto L_0x037d
            com.tencent.qalsdk.core.j r1 = com.tencent.qalsdk.service.QalService.core
            com.tencent.qalsdk.core.n r1 = r1.f32187c
            qalsdk.k r1 = r1.k
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.f34160d
            r1.set(r4)
            com.tencent.qalsdk.im_open.UserData$QALUserData r1 = new com.tencent.qalsdk.im_open.UserData$QALUserData     // Catch:{ Exception -> 0x0379 }
            r1.<init>()     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBStringField r2 = r1.sdk_version     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = "2.2.17"
            r2.set(r3)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r2 = com.tencent.qalsdk.service.QalService.appVersion     // Catch:{ Exception -> 0x0379 }
            if (r2 == 0) goto L_0x01ea
            com.tencent.mobileqq.pb.PBStringField r2 = r1.app_version     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = com.tencent.qalsdk.service.QalService.appVersion     // Catch:{ Exception -> 0x0379 }
            r2.set(r3)     // Catch:{ Exception -> 0x0379 }
        L_0x01ea:
            java.lang.String r2 = com.tencent.qalsdk.service.QalService.appChannel     // Catch:{ Exception -> 0x0379 }
            if (r2 == 0) goto L_0x01f5
            com.tencent.mobileqq.pb.PBStringField r2 = r1.app_channel     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = com.tencent.qalsdk.service.QalService.appChannel     // Catch:{ Exception -> 0x0379 }
            r2.set(r3)     // Catch:{ Exception -> 0x0379 }
        L_0x01f5:
            boolean r2 = com.tencent.qalsdk.core.m.d()     // Catch:{ Exception -> 0x0379 }
            if (r2 != 0) goto L_0x021b
            boolean r2 = com.tencent.qalsdk.core.m.c()     // Catch:{ Exception -> 0x0379 }
            if (r2 != 0) goto L_0x0208
            java.lang.String r2 = com.tencent.qalsdk.core.m.i()     // Catch:{ Exception -> 0x0379 }
            if (r2 != 0) goto L_0x0208
            goto L_0x021b
        L_0x0208:
            com.tencent.mobileqq.pb.PBStringField r2 = r1.apn     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = qalsdk.c.a()     // Catch:{ Exception -> 0x0379 }
            r2.set(r3)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBInt32Field r2 = r1.radio_access     // Catch:{ Exception -> 0x0379 }
            int r3 = qalsdk.c.b()     // Catch:{ Exception -> 0x0379 }
            r2.set(r3)     // Catch:{ Exception -> 0x0379 }
            goto L_0x0222
        L_0x021b:
            com.tencent.mobileqq.pb.PBStringField r2 = r1.apn     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = "wifi"
            r2.set(r3)     // Catch:{ Exception -> 0x0379 }
        L_0x0222:
            com.tencent.mobileqq.pb.PBEnumField r2 = r1.os     // Catch:{ Exception -> 0x0379 }
            r2.set(r4)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBStringField r2 = r1.os_version     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x0379 }
            r2.set(r3)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBStringField r2 = r1.device     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0379 }
            r2.set(r3)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBStringField r2 = r1.brand     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x0379 }
            r2.set(r3)     // Catch:{ Exception -> 0x0379 }
            android.content.Context r2 = com.tencent.qalsdk.service.QalService.context     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = "window"
            java.lang.Object r2 = r2.getSystemService(r3)     // Catch:{ Exception -> 0x0379 }
            android.view.WindowManager r2 = (android.view.WindowManager) r2     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBUInt32Field r3 = r1.screen_width     // Catch:{ Exception -> 0x0379 }
            android.view.Display r4 = r2.getDefaultDisplay()     // Catch:{ Exception -> 0x0379 }
            int r4 = r4.getWidth()     // Catch:{ Exception -> 0x0379 }
            r3.set(r4)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBUInt32Field r3 = r1.screen_height     // Catch:{ Exception -> 0x0379 }
            android.view.Display r2 = r2.getDefaultDisplay()     // Catch:{ Exception -> 0x0379 }
            int r2 = r2.getHeight()     // Catch:{ Exception -> 0x0379 }
            r3.set(r2)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r2 = com.tencent.qalsdk.core.k.a()     // Catch:{ Exception -> 0x0379 }
            if (r2 == 0) goto L_0x026f
            com.tencent.mobileqq.pb.PBStringField r2 = r1.imei     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = com.tencent.qalsdk.core.k.a()     // Catch:{ Exception -> 0x0379 }
            r2.set(r3)     // Catch:{ Exception -> 0x0379 }
        L_0x026f:
            java.lang.String r2 = com.tencent.qalsdk.core.k.b()     // Catch:{ Exception -> 0x0379 }
            if (r2 == 0) goto L_0x0286
            com.tencent.mobileqq.pb.PBUInt64Field r2 = r1.imsi     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = com.tencent.qalsdk.core.k.b()     // Catch:{ Exception -> 0x0379 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x0379 }
            long r3 = r3.longValue()     // Catch:{ Exception -> 0x0379 }
            r2.set(r3)     // Catch:{ Exception -> 0x0379 }
        L_0x0286:
            byte[] r2 = r1.toByteArray()     // Catch:{ Exception -> 0x0379 }
            com.tencent.qalsdk.base.remote.ToServiceMsg r3 = new com.tencent.qalsdk.base.remote.ToServiceMsg     // Catch:{ Exception -> 0x0379 }
            java.lang.String r4 = ""
            java.lang.String r5 = r8.getUin()     // Catch:{ Exception -> 0x0379 }
            java.lang.String r6 = "qal.userdata"
            r3.<init>(r4, r5, r6)     // Catch:{ Exception -> 0x0379 }
            int r4 = com.tencent.qalsdk.core.j.b()     // Catch:{ Exception -> 0x0379 }
            r3.setRequestSsoSeq(r4)     // Catch:{ Exception -> 0x0379 }
            byte[] r2 = com.tencent.qalsdk.core.n.a((byte[]) r2)     // Catch:{ Exception -> 0x0379 }
            r3.putWupBuffer(r2)     // Catch:{ Exception -> 0x0379 }
            r2 = 20
            r3.setUinType(r2)     // Catch:{ Exception -> 0x0379 }
            r2 = 0
            r3.setNeedCallback(r2)     // Catch:{ Exception -> 0x0379 }
            r2 = 537050853(0x2002bee5, float:1.107459E-19)
            r3.setAppId(r2)     // Catch:{ Exception -> 0x0379 }
            r4 = 10000(0x2710, double:4.9407E-320)
            r3.setTimeout(r4)     // Catch:{ Exception -> 0x0379 }
            com.tencent.qalsdk.core.j r2 = com.tencent.qalsdk.service.QalService.core     // Catch:{ Exception -> 0x0379 }
            com.tencent.qalsdk.core.n r2 = r2.f32187c     // Catch:{ Exception -> 0x0379 }
            r2.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r3)     // Catch:{ Exception -> 0x0379 }
            r3.getRequestSsoSeq()     // Catch:{ Exception -> 0x0379 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0379 }
            r2.<init>()     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = f32313a     // Catch:{ Exception -> 0x0379 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0379 }
            java.lang.String r5 = "report userdata:"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBStringField r5 = r1.sdk_version     // Catch:{ Exception -> 0x0379 }
            java.lang.String r5 = r5.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r5)     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBStringField r5 = r1.app_version     // Catch:{ Exception -> 0x0379 }
            java.lang.String r5 = r5.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r5)     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBStringField r5 = r1.app_channel     // Catch:{ Exception -> 0x0379 }
            java.lang.String r5 = r5.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r5)     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBStringField r5 = r1.apn     // Catch:{ Exception -> 0x0379 }
            java.lang.String r5 = r5.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r5)     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBInt32Field r5 = r1.radio_access     // Catch:{ Exception -> 0x0379 }
            int r5 = r5.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r5)     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBEnumField r5 = r1.os     // Catch:{ Exception -> 0x0379 }
            int r5 = r5.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r5)     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBStringField r5 = r1.os_version     // Catch:{ Exception -> 0x0379 }
            java.lang.String r5 = r5.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r5)     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBStringField r5 = r1.device     // Catch:{ Exception -> 0x0379 }
            java.lang.String r5 = r5.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r5)     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBStringField r5 = r1.brand     // Catch:{ Exception -> 0x0379 }
            java.lang.String r5 = r5.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r5)     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBUInt32Field r5 = r1.screen_height     // Catch:{ Exception -> 0x0379 }
            int r5 = r5.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r5)     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBUInt32Field r5 = r1.screen_width     // Catch:{ Exception -> 0x0379 }
            int r5 = r5.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r5)     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBStringField r5 = r1.imei     // Catch:{ Exception -> 0x0379 }
            java.lang.String r5 = r5.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r5)     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            com.tencent.mobileqq.pb.PBUInt64Field r0 = r1.imsi     // Catch:{ Exception -> 0x0379 }
            long r0 = r0.get()     // Catch:{ Exception -> 0x0379 }
            r2.append(r0)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0379 }
            r4.append(r0)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0379 }
            com.tencent.qalsdk.util.QLog.d(r3, r0)     // Catch:{ Exception -> 0x0379 }
            goto L_0x037d
        L_0x0379:
            r0 = move-exception
            r0.printStackTrace()
        L_0x037d:
            com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.service.QalService.core
            if (r8 != 0) goto L_0x0382
            goto L_0x038a
        L_0x0382:
            com.tencent.qalsdk.core.n r0 = r0.f32187c
            r0.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r8)
            r8.getRequestSsoSeq()
        L_0x038a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.service.d.a(com.tencent.qalsdk.base.remote.ToServiceMsg):void");
    }
}
