package com.appsflyer;

public class ServerConfigHandler {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008f  */
    /* renamed from: ˏ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static org.json.JSONObject m118(java.lang.String r3) {
        /*
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007a, Throwable -> 0x0050 }
            r1.<init>(r3)     // Catch:{ JSONException -> 0x007a, Throwable -> 0x0050 }
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            java.lang.String r0 = "disableProxy"
            r2 = 0
            boolean r3 = r3.getBoolean(r0, r2)     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            java.lang.String r0 = "monitor"
            boolean r0 = r1.optBoolean(r0, r2)     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            if (r0 == 0) goto L_0x002d
            if (r3 != 0) goto L_0x002d
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            if (r3 != 0) goto L_0x0026
            com.appsflyer.internal.x r3 = new com.appsflyer.internal.x     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            r3.<init>()     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            com.appsflyer.internal.x.f258 = r3     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
        L_0x0026:
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            r3.m202()     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            goto L_0x009b
        L_0x002d:
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            if (r3 != 0) goto L_0x0038
            com.appsflyer.internal.x r3 = new com.appsflyer.internal.x     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            r3.<init>()     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            com.appsflyer.internal.x.f258 = r3     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
        L_0x0038:
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            r3.m203()     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            if (r3 != 0) goto L_0x0048
            com.appsflyer.internal.x r3 = new com.appsflyer.internal.x     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            r3.<init>()     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            com.appsflyer.internal.x.f258 = r3     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
        L_0x0048:
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            r3.m207()     // Catch:{ JSONException -> 0x007b, Throwable -> 0x004e }
            goto L_0x009b
        L_0x004e:
            r3 = move-exception
            goto L_0x0052
        L_0x0050:
            r3 = move-exception
            r1 = r0
        L_0x0052:
            java.lang.String r0 = r3.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r3)
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258
            if (r3 != 0) goto L_0x0064
            com.appsflyer.internal.x r3 = new com.appsflyer.internal.x
            r3.<init>()
            com.appsflyer.internal.x.f258 = r3
        L_0x0064:
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258
            r3.m203()
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258
            if (r3 != 0) goto L_0x0074
            com.appsflyer.internal.x r3 = new com.appsflyer.internal.x
            r3.<init>()
            com.appsflyer.internal.x.f258 = r3
        L_0x0074:
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258
            r3.m207()
            goto L_0x009b
        L_0x007a:
            r1 = r0
        L_0x007b:
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258
            if (r3 != 0) goto L_0x0086
            com.appsflyer.internal.x r3 = new com.appsflyer.internal.x
            r3.<init>()
            com.appsflyer.internal.x.f258 = r3
        L_0x0086:
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258
            r3.m203()
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258
            if (r3 != 0) goto L_0x0096
            com.appsflyer.internal.x r3 = new com.appsflyer.internal.x
            r3.<init>()
            com.appsflyer.internal.x.f258 = r3
        L_0x0096:
            com.appsflyer.internal.x r3 = com.appsflyer.internal.x.f258
            r3.m207()
        L_0x009b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.ServerConfigHandler.m118(java.lang.String):org.json.JSONObject");
    }

    public static String getUrl(String str) {
        return String.format(str, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AppsFlyerLibCore.getInstance().getHostName()});
    }
}
