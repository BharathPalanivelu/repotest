package com.appsflyer.internal;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.n;
import com.appsflyer.share.Constants;

public final class r {
    r() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static n m178(ContentResolver contentResolver) {
        String str;
        if (contentResolver == null || AppsFlyerProperties.getInstance().getString("amazon_aid") != null || !"Amazon".equals(Build.MANUFACTURER)) {
            return null;
        }
        int i = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
        if (i == 0) {
            return new n(n.b.AMAZON, Settings.Secure.getString(contentResolver, Constants.URL_ADVERTISING_ID), false);
        } else if (i == 2) {
            return null;
        } else {
            try {
                str = Settings.Secure.getString(contentResolver, Constants.URL_ADVERTISING_ID);
            } catch (Throwable th) {
                AFLogger.afErrorLog("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
                str = "";
            }
            return new n(n.b.AMAZON, str, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (r8.length() == 0) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008c A[SYNTHETIC, Splitter:B:34:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m177(android.content.Context r12, java.util.Map<java.lang.String, java.lang.Object> r13) {
        /*
            java.lang.String r0 = "advertiserIdEnabled"
            java.lang.String r1 = "advertiserId"
            java.lang.String r2 = "Trying to fetch GAID.."
            com.appsflyer.AFLogger.afInfoLog(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.common.GoogleApiAvailability r3 = com.google.android.gms.common.GoogleApiAvailability.getInstance()     // Catch:{ Throwable -> 0x0017 }
            int r3 = r3.isGooglePlayServicesAvailable(r12)     // Catch:{ Throwable -> 0x0017 }
            goto L_0x0020
        L_0x0017:
            r3 = move-exception
            java.lang.String r4 = r3.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r4, r3)
            r3 = -1
        L_0x0020:
            r4 = 0
            r5 = 0
            r6 = 1
            java.lang.String r7 = "com.google.android.gms.ads.identifier.AdvertisingIdClient"
            java.lang.Class.forName(r7)     // Catch:{ Throwable -> 0x0061 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r7 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r12)     // Catch:{ Throwable -> 0x0061 }
            if (r7 == 0) goto L_0x0054
            java.lang.String r8 = r7.getId()     // Catch:{ Throwable -> 0x0061 }
            boolean r7 = r7.isLimitAdTrackingEnabled()     // Catch:{ Throwable -> 0x0052 }
            if (r7 != 0) goto L_0x003a
            r7 = 1
            goto L_0x003b
        L_0x003a:
            r7 = 0
        L_0x003b:
            java.lang.String r4 = java.lang.Boolean.toString(r7)     // Catch:{ Throwable -> 0x0052 }
            if (r8 == 0) goto L_0x0047
            int r7 = r8.length()     // Catch:{ Throwable -> 0x004f }
            if (r7 != 0) goto L_0x004c
        L_0x0047:
            java.lang.String r7 = "emptyOrNull |"
            r2.append(r7)     // Catch:{ Throwable -> 0x004f }
        L_0x004c:
            r9 = 1
            goto L_0x00e5
        L_0x004f:
            r7 = move-exception
            r9 = 1
            goto L_0x0064
        L_0x0052:
            r7 = move-exception
            goto L_0x0063
        L_0x0054:
            java.lang.String r7 = "gpsAdInfo-null |"
            r2.append(r7)     // Catch:{ Throwable -> 0x0061 }
            com.appsflyer.internal.r$e r7 = new com.appsflyer.internal.r$e     // Catch:{ Throwable -> 0x0061 }
            java.lang.String r8 = "GpsAdIndo is null"
            r7.<init>(r8)     // Catch:{ Throwable -> 0x0061 }
            throw r7     // Catch:{ Throwable -> 0x0061 }
        L_0x0061:
            r7 = move-exception
            r8 = r4
        L_0x0063:
            r9 = 0
        L_0x0064:
            java.lang.String r10 = r7.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r10, r7)
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getSimpleName()
            r2.append(r7)
            java.lang.String r7 = " |"
            r2.append(r7)
            java.lang.String r10 = "WARNING: Google Play Services is missing."
            com.appsflyer.AFLogger.afInfoLog(r10)
            com.appsflyer.AppsFlyerProperties r10 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r11 = "enableGpsFallback"
            boolean r10 = r10.getBoolean(r11, r6)
            if (r10 == 0) goto L_0x00e5
            com.appsflyer.internal.m$c r4 = com.appsflyer.internal.m.m165(r12)     // Catch:{ Throwable -> 0x00a9 }
            java.lang.String r8 = r4.f197     // Catch:{ Throwable -> 0x00a9 }
            boolean r4 = r4.f196     // Catch:{ Throwable -> 0x00a9 }
            if (r4 != 0) goto L_0x0097
            r5 = 1
        L_0x0097:
            java.lang.String r4 = java.lang.Boolean.toString(r5)     // Catch:{ Throwable -> 0x00a9 }
            if (r8 == 0) goto L_0x00a3
            int r5 = r8.length()     // Catch:{ Throwable -> 0x00a9 }
            if (r5 != 0) goto L_0x00e5
        L_0x00a3:
            java.lang.String r5 = "emptyOrNull (bypass) |"
            r2.append(r5)     // Catch:{ Throwable -> 0x00a9 }
            goto L_0x00e5
        L_0x00a9:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r5, r4)
            java.lang.Class r5 = r4.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r2.append(r5)
            r2.append(r7)
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r5.getString(r1)
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r5 = r5.getString(r0)
            java.lang.String r6 = r4.getLocalizedMessage()
            if (r6 == 0) goto L_0x00dd
            java.lang.String r4 = r4.getLocalizedMessage()
            com.appsflyer.AFLogger.afInfoLog(r4)
            goto L_0x00e4
        L_0x00dd:
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.afInfoLog(r4)
        L_0x00e4:
            r4 = r5
        L_0x00e5:
            java.lang.Class r12 = r12.getClass()
            java.lang.String r12 = r12.getName()
            java.lang.String r5 = "android.app.ReceiverRestrictedContext"
            boolean r12 = r12.equals(r5)
            if (r12 == 0) goto L_0x010a
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r12.getString(r1)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r4 = r12.getString(r0)
            java.lang.String r12 = "context = android.app.ReceiverRestrictedContext |"
            r2.append(r12)
        L_0x010a:
            int r12 = r2.length()
            if (r12 <= 0) goto L_0x0129
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r3)
            java.lang.String r3 = ": "
            r12.append(r3)
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            java.lang.String r2 = "gaidError"
            r13.put(r2, r12)
        L_0x0129:
            if (r8 == 0) goto L_0x014a
            if (r4 == 0) goto L_0x014a
            r13.put(r1, r8)
            r13.put(r0, r4)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            r12.set((java.lang.String) r1, (java.lang.String) r8)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            r12.set((java.lang.String) r0, (java.lang.String) r4)
            java.lang.String r12 = java.lang.String.valueOf(r9)
            java.lang.String r0 = "isGaidWithGps"
            r13.put(r0, r12)
        L_0x014a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.r.m177(android.content.Context, java.util.Map):void");
    }

    static class e extends IllegalStateException {
        e(String str) {
            super(str);
        }
    }
}
