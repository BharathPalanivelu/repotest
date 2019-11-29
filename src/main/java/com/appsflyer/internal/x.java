package com.appsflyer.internal;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerParameters;
import com.tencent.qcloud.core.http.HttpMetric;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public final class x {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static x f258;

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f259;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final String f260;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f261;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final String f262;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final String f263;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final String f264;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final String f265;

    /* renamed from: ʿ  reason: contains not printable characters */
    private final String f266;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final String f267;

    /* renamed from: ˉ  reason: contains not printable characters */
    private JSONObject f268;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f269;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private final String f270;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private boolean f271;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final String f272;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private JSONArray f273;

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean f274;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private final String f275;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private boolean f276;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final String f277;

    /* renamed from: ˌ  reason: contains not printable characters */
    private int f278;

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean f279;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private String f280;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final String f281;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final String f282;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f283;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final String f284;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final String f285;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final String f286;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f287;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final String f288;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f289;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final String f290;

    public x() {
        this.f269 = "brand";
        this.f283 = "model";
        this.f261 = "platform";
        this.f289 = "platform_version";
        this.f287 = ServerParameters.ADVERTISING_ID_PARAM;
        this.f263 = "imei";
        this.f259 = "android_id";
        this.f272 = "sdk_version";
        this.f282 = "devkey";
        this.f284 = "originalAppsFlyerId";
        this.f281 = "uid";
        this.f277 = "app_id";
        this.f290 = "app_version";
        this.f288 = AppsFlyerProperties.CHANNEL;
        this.f286 = "preInstall";
        this.f285 = "data";
        this.f260 = "r_debugging_off";
        this.f264 = "r_debugging_on";
        this.f266 = "public_api_call";
        this.f265 = HttpMetric.ATTR_EXCEPTION;
        this.f267 = "server_request";
        this.f262 = "server_response";
        this.f275 = "yyyy-MM-dd HH:mm:ssZ";
        this.f270 = "MM-dd HH:mm:ss.SSS";
        this.f271 = true;
        this.f278 = 0;
        this.f280 = "-1";
        this.f276 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
        this.f279 = true ^ this.f276;
        this.f273 = new JSONArray();
        this.f278 = 0;
        this.f274 = false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final synchronized void m209(String str) {
        this.f280 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final synchronized void m202() {
        this.f274 = true;
        m205("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final synchronized void m207() {
        m205("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.f274 = false;
        this.f271 = false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final synchronized void m208() {
        this.f268 = null;
        this.f273 = null;
        f258 = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: ॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m200(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r2 = this;
            monitor-enter(r2)
            org.json.JSONObject r0 = r2.f268     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            java.lang.String r1 = "brand"
            r0.put(r1, r3)     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            org.json.JSONObject r3 = r2.f268     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            java.lang.String r0 = "model"
            r3.put(r0, r4)     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            org.json.JSONObject r3 = r2.f268     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            java.lang.String r4 = "platform"
            java.lang.String r0 = "Android"
            r3.put(r4, r0)     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            org.json.JSONObject r3 = r2.f268     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            java.lang.String r4 = "platform_version"
            r3.put(r4, r5)     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            if (r6 == 0) goto L_0x002e
            int r3 = r6.length()     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            if (r3 <= 0) goto L_0x002e
            org.json.JSONObject r3 = r2.f268     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            java.lang.String r4 = "advertiserId"
            r3.put(r4, r6)     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
        L_0x002e:
            if (r7 == 0) goto L_0x003d
            int r3 = r7.length()     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            if (r3 <= 0) goto L_0x003d
            org.json.JSONObject r3 = r2.f268     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            java.lang.String r4 = "imei"
            r3.put(r4, r7)     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
        L_0x003d:
            if (r8 == 0) goto L_0x004c
            int r3 = r8.length()     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            if (r3 <= 0) goto L_0x004c
            org.json.JSONObject r3 = r2.f268     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            java.lang.String r4 = "android_id"
            r3.put(r4, r8)     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
        L_0x004c:
            monitor-exit(r2)
            return
        L_0x004e:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x0051:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.x.m200(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: ॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m199(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            org.json.JSONObject r0 = r2.f268     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            java.lang.String r1 = "sdk_version"
            r0.put(r1, r3)     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            if (r4 == 0) goto L_0x0017
            int r3 = r4.length()     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            if (r3 <= 0) goto L_0x0017
            org.json.JSONObject r3 = r2.f268     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            java.lang.String r0 = "devkey"
            r3.put(r0, r4)     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
        L_0x0017:
            if (r5 == 0) goto L_0x0026
            int r3 = r5.length()     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            if (r3 <= 0) goto L_0x0026
            org.json.JSONObject r3 = r2.f268     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            java.lang.String r4 = "originalAppsFlyerId"
            r3.put(r4, r5)     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
        L_0x0026:
            if (r6 == 0) goto L_0x0035
            int r3 = r6.length()     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            if (r3 <= 0) goto L_0x0035
            org.json.JSONObject r3 = r2.f268     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            java.lang.String r4 = "uid"
            r3.put(r4, r6)     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
        L_0x0035:
            monitor-exit(r2)
            return
        L_0x0037:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x003a:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.x.m199(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private synchronized void m198(String str, String str2, String str3, String str4) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.f268.put("app_id", str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str2 != null && str2.length() > 0) {
            this.f268.put("app_version", str2);
        }
        if (str3 != null && str3.length() > 0) {
            this.f268.put(AppsFlyerProperties.CHANNEL, str3);
        }
        if (str4 != null && str4.length() > 0) {
            this.f268.put("preInstall", str4);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String m206() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            org.json.JSONObject r1 = r4.f268     // Catch:{ JSONException -> 0x0018, all -> 0x0015 }
            java.lang.String r2 = "data"
            org.json.JSONArray r3 = r4.f273     // Catch:{ JSONException -> 0x0018, all -> 0x0015 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0018, all -> 0x0015 }
            org.json.JSONObject r1 = r4.f268     // Catch:{ JSONException -> 0x0018, all -> 0x0015 }
            java.lang.String r0 = r1.toString()     // Catch:{ JSONException -> 0x0018, all -> 0x0015 }
            r4.m201()     // Catch:{ JSONException -> 0x0018, all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x0018:
            monitor-exit(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.x.m206():java.lang.String");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0070 */
    /* renamed from: ˋ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m204(java.lang.String r11, android.content.pm.PackageManager r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0081 }
            com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.getInstance()     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "remote_debug_static_data"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0081 }
            if (r2 == 0) goto L_0x0019
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0070 }
            r11.<init>(r2)     // Catch:{ Throwable -> 0x0070 }
            r10.f268 = r11     // Catch:{ Throwable -> 0x0070 }
            goto L_0x0070
        L_0x0019:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0081 }
            r2.<init>()     // Catch:{ all -> 0x0081 }
            r10.f268 = r2     // Catch:{ all -> 0x0081 }
            java.lang.String r4 = android.os.Build.BRAND     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ all -> 0x0081 }
            java.lang.String r6 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "advertiserId"
            java.lang.String r7 = r0.getString(r2)     // Catch:{ all -> 0x0081 }
            java.lang.String r8 = r1.f56     // Catch:{ all -> 0x0081 }
            java.lang.String r9 = r1.f50     // Catch:{ all -> 0x0081 }
            r3 = r10
            r3.m200(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "4.10.0.197"
            java.lang.String r2 = "AppsFlyerKey"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0081 }
            java.lang.String r3 = "KSAppsFlyerId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0081 }
            java.lang.String r4 = "uid"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0081 }
            r10.m199(r1, r2, r3, r4)     // Catch:{ all -> 0x0081 }
            r1 = 0
            android.content.pm.PackageInfo r12 = r12.getPackageInfo(r11, r1)     // Catch:{ Throwable -> 0x0065 }
            int r12 = r12.versionCode     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r1 = "channel"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r2 = "preInstallName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Throwable -> 0x0065 }
            r10.m198(r11, r12, r1, r2)     // Catch:{ Throwable -> 0x0065 }
        L_0x0065:
            java.lang.String r11 = "remote_debug_static_data"
            org.json.JSONObject r12 = r10.f268     // Catch:{ all -> 0x0081 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0081 }
            r0.set((java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x0081 }
        L_0x0070:
            org.json.JSONObject r11 = r10.f268     // Catch:{ JSONException -> 0x007b }
            java.lang.String r12 = "launch_counter"
            java.lang.String r0 = r10.f280     // Catch:{ JSONException -> 0x007b }
            r11.put(r12, r0)     // Catch:{ JSONException -> 0x007b }
            monitor-exit(r10)
            return
        L_0x007b:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ all -> 0x0081 }
            monitor-exit(r10)
            return
        L_0x0081:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.x.m204(java.lang.String, android.content.pm.PackageManager):void");
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private synchronized void m201() {
        this.f273 = null;
        this.f273 = new JSONArray();
        this.f278 = 0;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final synchronized void m203() {
        this.f271 = false;
        m201();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b4, code lost:
        return;
     */
    /* renamed from: ˋ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m205(java.lang.String r12, java.lang.String r13, java.lang.String... r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = r11.f279     // Catch:{ all -> 0x00b5 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0011
            boolean r0 = r11.f271     // Catch:{ all -> 0x00b5 }
            if (r0 != 0) goto L_0x000f
            boolean r0 = r11.f274     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x0011
        L_0x000f:
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 == 0) goto L_0x00b3
            int r0 = r11.f278     // Catch:{ all -> 0x00b5 }
            r3 = 98304(0x18000, float:1.37753E-40)
            if (r0 < r3) goto L_0x001d
            goto L_0x00b3
        L_0x001d:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r0 = ""
            int r5 = r14.length     // Catch:{ Throwable -> 0x00b1 }
            if (r5 <= 0) goto L_0x0045
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00b1 }
            r0.<init>()     // Catch:{ Throwable -> 0x00b1 }
            int r5 = r14.length     // Catch:{ Throwable -> 0x00b1 }
            int r5 = r5 - r1
        L_0x002d:
            if (r5 <= 0) goto L_0x003c
            r6 = r14[r5]     // Catch:{ Throwable -> 0x00b1 }
            r0.append(r6)     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r6 = ", "
            r0.append(r6)     // Catch:{ Throwable -> 0x00b1 }
            int r5 = r5 + -1
            goto L_0x002d
        L_0x003c:
            r14 = r14[r2]     // Catch:{ Throwable -> 0x00b1 }
            r0.append(r14)     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00b1 }
        L_0x0045:
            java.text.SimpleDateFormat r14 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r5 = "MM-dd HH:mm:ss.SSS"
            java.util.Locale r6 = java.util.Locale.ENGLISH     // Catch:{ Throwable -> 0x00b1 }
            r14.<init>(r5, r6)     // Catch:{ Throwable -> 0x00b1 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r14 = r14.format(r3)     // Catch:{ Throwable -> 0x00b1 }
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 5
            if (r12 == 0) goto L_0x0080
            java.lang.String r7 = "%18s %5s _/%s [%s] %s %s"
            r8 = 6
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x00b1 }
            r8[r2] = r14     // Catch:{ Throwable -> 0x00b1 }
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch:{ Throwable -> 0x00b1 }
            long r9 = r14.getId()     // Catch:{ Throwable -> 0x00b1 }
            java.lang.Long r14 = java.lang.Long.valueOf(r9)     // Catch:{ Throwable -> 0x00b1 }
            r8[r1] = r14     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r14 = "AppsFlyer_4.10.0"
            r8[r5] = r14     // Catch:{ Throwable -> 0x00b1 }
            r8[r4] = r12     // Catch:{ Throwable -> 0x00b1 }
            r8[r3] = r13     // Catch:{ Throwable -> 0x00b1 }
            r8[r6] = r0     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r12 = java.lang.String.format(r7, r8)     // Catch:{ Throwable -> 0x00b1 }
            goto L_0x00a0
        L_0x0080:
            java.lang.String r12 = "%18s %5s %s/%s %s"
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Throwable -> 0x00b1 }
            r6[r2] = r14     // Catch:{ Throwable -> 0x00b1 }
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch:{ Throwable -> 0x00b1 }
            long r7 = r14.getId()     // Catch:{ Throwable -> 0x00b1 }
            java.lang.Long r14 = java.lang.Long.valueOf(r7)     // Catch:{ Throwable -> 0x00b1 }
            r6[r1] = r14     // Catch:{ Throwable -> 0x00b1 }
            r6[r5] = r13     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r13 = "AppsFlyer_4.10.0"
            r6[r4] = r13     // Catch:{ Throwable -> 0x00b1 }
            r6[r3] = r0     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r12 = java.lang.String.format(r12, r6)     // Catch:{ Throwable -> 0x00b1 }
        L_0x00a0:
            org.json.JSONArray r13 = r11.f273     // Catch:{ Throwable -> 0x00b1 }
            r13.put(r12)     // Catch:{ Throwable -> 0x00b1 }
            int r13 = r11.f278     // Catch:{ Throwable -> 0x00b1 }
            byte[] r12 = r12.getBytes()     // Catch:{ Throwable -> 0x00b1 }
            int r12 = r12.length     // Catch:{ Throwable -> 0x00b1 }
            int r13 = r13 + r12
            r11.f278 = r13     // Catch:{ Throwable -> 0x00b1 }
            monitor-exit(r11)
            return
        L_0x00b1:
            monitor-exit(r11)
            return
        L_0x00b3:
            monitor-exit(r11)
            return
        L_0x00b5:
            r12 = move-exception
            monitor-exit(r11)
            goto L_0x00b9
        L_0x00b8:
            throw r12
        L_0x00b9:
            goto L_0x00b8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.x.m205(java.lang.String, java.lang.String, java.lang.String[]):void");
    }
}
