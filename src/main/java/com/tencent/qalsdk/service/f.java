package com.tencent.qalsdk.service;

import com.tencent.qalsdk.sdk.MsfCommand;

final /* synthetic */ class f {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f32314a = new int[MsfCommand.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
    static {
        /*
            com.tencent.qalsdk.sdk.MsfCommand[] r0 = com.tencent.qalsdk.sdk.MsfCommand.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f32314a = r0
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.registerMsfService     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.unRegisterMsfService     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.registerPush     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.unRegisterPush     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x0040 }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.qal_setAppStatus     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x004b }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.registerCmdCallback     // Catch:{ NoSuchFieldError -> 0x004b }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x0056 }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.resetCmdCallback     // Catch:{ NoSuchFieldError -> 0x0056 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x0062 }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.getGatewayIp     // Catch:{ NoSuchFieldError -> 0x0062 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
            r2 = 8
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
        L_0x0062:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x006e }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.httpreq_remove     // Catch:{ NoSuchFieldError -> 0x006e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
            r2 = 9
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
        L_0x006e:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x007a }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.qal_setAppEnv     // Catch:{ NoSuchFieldError -> 0x007a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
            r2 = 10
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007a }
        L_0x007a:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x0086 }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.qal_setLogLevel     // Catch:{ NoSuchFieldError -> 0x0086 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
            r2 = 11
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
        L_0x0086:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x0092 }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.qal_reportEvent     // Catch:{ NoSuchFieldError -> 0x0092 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
            r2 = 12
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
        L_0x0092:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x009e }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.qal_setServerEnv     // Catch:{ NoSuchFieldError -> 0x009e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
            r2 = 13
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009e }
        L_0x009e:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x00aa }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.qal_setProxyList     // Catch:{ NoSuchFieldError -> 0x00aa }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
            r2 = 14
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
        L_0x00aa:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x00b6 }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.qal_cancelProxyList     // Catch:{ NoSuchFieldError -> 0x00b6 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
            r2 = 15
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b6 }
        L_0x00b6:
            int[] r0 = f32314a     // Catch:{ NoSuchFieldError -> 0x00c2 }
            com.tencent.qalsdk.sdk.MsfCommand r1 = com.tencent.qalsdk.sdk.MsfCommand.qal_setDefineVersion     // Catch:{ NoSuchFieldError -> 0x00c2 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c2 }
            r2 = 16
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c2 }
        L_0x00c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.service.f.<clinit>():void");
    }
}
