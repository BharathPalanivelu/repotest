package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.WindowManager;
import com.appsflyer.share.Constants;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.ServerProtocol;
import com.garena.android.gpns.utility.CONSTANT;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32585a = "j";

    j() {
    }

    static List<String> a(Context context, List<String> list) throws InterruptedException {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            String[] checkURLs = NativeGatherer.INSTANCE.checkURLs((String[]) list.toArray(new String[list.size()]));
            String str = Build.TAGS;
            PackageManager packageManager = context.getPackageManager();
            int i = 0;
            for (String next : list) {
                if (!Thread.currentThread().isInterrupted()) {
                    URI uri = null;
                    try {
                        uri = new URI(next);
                    } catch (URISyntaxException e2) {
                        Log.d(f32585a, "malformed check url", e2);
                    }
                    if (uri != null) {
                        if (uri.getScheme().equals(UriUtil.LOCAL_FILE_SCHEME)) {
                            z = new File(uri).exists();
                        } else {
                            if (uri.getScheme().equals("tags")) {
                                if (str != null) {
                                    String host = uri.getHost();
                                    if (host != null && !host.isEmpty()) {
                                        z = str.contains(host);
                                    }
                                }
                            } else if (uri.getScheme().equals("pkg") && packageManager != null) {
                                try {
                                    packageManager.getPackageInfo(uri.getHost(), 1);
                                    z = true;
                                } catch (PackageManager.NameNotFoundException unused) {
                                }
                            }
                            z = false;
                        }
                        if (z) {
                            arrayList.add(next);
                        } else {
                            i++;
                        }
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            Log.d(f32585a, "matched " + i + Constants.URL_PATH_DELIMITER + list.size());
            if (checkURLs != null && checkURLs.length > 0) {
                for (String str2 : checkURLs) {
                    arrayList.add("z" + str2);
                }
            }
            Collections.sort(arrayList);
            if (!arrayList.isEmpty() && Log.isLoggable(f32585a, 3)) {
                Log.d(f32585a, "found " + v.a((List<String>) arrayList, ";"));
            }
        }
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f32586a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f32587b = 0;

        a() {
        }
    }

    static String a(StringBuilder sb) {
        if (NativeGatherer.INSTANCE.isAvailable()) {
            List<String> fontList = NativeGatherer.INSTANCE.getFontList("/system/fonts");
            if (fontList == null || fontList.isEmpty() || fontList.size() != 2) {
                return null;
            }
            String str = fontList.get(0);
            sb.append(fontList.get(1));
            return str;
        }
        List<String> a2 = a();
        StringBuilder sb2 = new StringBuilder();
        for (String append : a2) {
            sb2.append(append);
        }
        sb.append(a2.size());
        return v.b(sb2.toString());
    }

    static List<String> a() {
        ArrayList arrayList = new ArrayList();
        String[] list = new File("/system/fonts/").list();
        if (list == null) {
            return arrayList;
        }
        for (String str : list) {
            if (str != null && str.endsWith(".ttf")) {
                StringBuilder sb = new StringBuilder(str);
                arrayList.add(sb.substring(0, sb.length() - 4));
            }
        }
        return arrayList;
    }

    static String b() {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new String[]{"MemTotal"});
        String a2 = a("/proc/meminfo", arrayList, ":");
        String str = f32585a;
        Log.d(str, "getMemInfo returned: " + a2);
        return a2;
    }

    static String c() {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new String[]{"Processor", "BogoMips", "Hardware", "Serial"});
        String a2 = a("/proc/cpuinfo", arrayList, ":");
        String str = f32585a;
        Log.d(str, "getCPUInfo returned: " + a2);
        return a2;
    }

    static String d() {
        StringBuilder sb = new StringBuilder();
        u uVar = new u(Environment.getDataDirectory().getPath());
        long b2 = uVar.b();
        long c2 = uVar.c();
        sb.append(c2 * b2 != 0 ? (((((float) c2) * ((float) b2)) / 1024.0f) / 1024.0f) / 1024.0f : 1.0f);
        sb.append(" - ");
        sb.append(Long.toString((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
        String str = f32585a;
        Log.d(str, "getDeviceState: " + v.b(sb.toString()));
        return v.b(sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a6 A[Catch:{ IOException -> 0x00ba, all -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ca A[SYNTHETIC, Splitter:B:57:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d7 A[SYNTHETIC, Splitter:B:62:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0026 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String a(java.lang.String r8, java.util.List<java.lang.String> r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "get info = tidy up failed"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            if (r8 == 0) goto L_0x00e2
            if (r9 == 0) goto L_0x00e2
            java.io.File r2 = new java.io.File
            r2.<init>(r8)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x00e2
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00c0 }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x00c0 }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x00c0 }
            r5.<init>(r8)     // Catch:{ IOException -> 0x00c0 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x00c0 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00c0 }
        L_0x0026:
            java.lang.String r8 = r3.readLine()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            if (r8 == 0) goto L_0x00b4
            java.lang.String r2 = ""
            java.lang.String r4 = ","
            if (r10 == 0) goto L_0x006e
            boolean r5 = r10.isEmpty()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            if (r5 != 0) goto L_0x006e
            java.util.List r8 = com.threatmetrix.TrustDefenderMobile.v.b(r8, r10)     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            boolean r5 = r8.isEmpty()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            if (r5 == 0) goto L_0x0043
            goto L_0x0026
        L_0x0043:
            r5 = 0
            java.lang.Object r5 = r8.get(r5)     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            java.lang.String r5 = r5.trim()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            int r6 = r5.length()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            if (r6 != 0) goto L_0x0055
            goto L_0x0026
        L_0x0055:
            boolean r5 = r9.contains(r5)     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            if (r5 == 0) goto L_0x00a0
            int r5 = r8.size()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            r6 = 1
            if (r5 <= r6) goto L_0x00a0
            java.lang.Object r8 = r8.get(r6)     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            java.lang.String r8 = r8.trim()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            r2 = r8
            goto L_0x00a0
        L_0x006e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            r5.<init>()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            java.util.Iterator r6 = r9.iterator()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
        L_0x0077:
            boolean r7 = r6.hasNext()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            if (r7 == 0) goto L_0x0096
            java.lang.Object r7 = r6.next()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            boolean r7 = r8.contains(r7)     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            if (r7 == 0) goto L_0x0077
            int r7 = r5.length()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            if (r7 <= 0) goto L_0x0092
            r5.append(r4)     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
        L_0x0092:
            r5.append(r8)     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            goto L_0x0077
        L_0x0096:
            int r8 = r5.length()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            if (r8 == 0) goto L_0x00a0
            java.lang.String r2 = r5.toString()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
        L_0x00a0:
            boolean r8 = r2.isEmpty()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            if (r8 != 0) goto L_0x0026
            int r8 = r1.length()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            if (r8 <= 0) goto L_0x00af
            r1.append(r4)     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
        L_0x00af:
            r1.append(r2)     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            goto L_0x0026
        L_0x00b4:
            r3.close()     // Catch:{ IOException -> 0x00ce }
            goto L_0x00e2
        L_0x00b8:
            r8 = move-exception
            goto L_0x00d5
        L_0x00ba:
            r8 = move-exception
            r2 = r3
            goto L_0x00c1
        L_0x00bd:
            r8 = move-exception
            r3 = r2
            goto L_0x00d5
        L_0x00c0:
            r8 = move-exception
        L_0x00c1:
            java.lang.String r9 = f32585a     // Catch:{ all -> 0x00bd }
            java.lang.String r10 = "get info = FAILED"
            android.util.Log.d(r9, r10, r8)     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x00e2
            r2.close()     // Catch:{ IOException -> 0x00ce }
            goto L_0x00e2
        L_0x00ce:
            r8 = move-exception
            java.lang.String r9 = f32585a
            android.util.Log.d(r9, r0, r8)
            goto L_0x00e2
        L_0x00d5:
            if (r3 == 0) goto L_0x00e1
            r3.close()     // Catch:{ IOException -> 0x00db }
            goto L_0x00e1
        L_0x00db:
            r9 = move-exception
            java.lang.String r10 = f32585a
            android.util.Log.d(r10, r0, r9)
        L_0x00e1:
            throw r8
        L_0x00e2:
            java.lang.String r8 = r1.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefenderMobile.j.a(java.lang.String, java.util.List, java.lang.String):java.lang.String");
    }

    static String a(Context context, Context context2) {
        Log.d(f32585a, "getDeviceFingerprint()");
        StringBuilder sb = new StringBuilder();
        if (Thread.currentThread().isInterrupted()) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context2.getSystemService("phone");
        sb.append(telephonyManager.getPhoneType() == 1 ? telephonyManager.getNetworkOperatorName() : "Unknown");
        sb.append(telephonyManager.getSimCountryIso());
        u uVar = new u(Environment.getDataDirectory().getPath());
        sb.append((((((float) uVar.a()) * ((float) uVar.b())) / 1024.0f) / 1024.0f) / 1024.0f);
        f fVar = new f(((WindowManager) context.getSystemService("window")).getDefaultDisplay());
        sb.append(fVar.a());
        sb.append("x");
        sb.append(fVar.b());
        Log.d(f32585a, "Calling getCPUInfo");
        sb.append(c());
        Log.d(f32585a, "Calling getMemInfo");
        sb.append(b());
        sb.append(Build.DEVICE);
        sb.append(SQLBuilder.BLANK);
        sb.append(Build.MODEL);
        sb.append(SQLBuilder.BLANK);
        sb.append(Build.PRODUCT);
        sb.append(SQLBuilder.BLANK);
        sb.append(Build.MANUFACTURER);
        sb.append(SQLBuilder.BLANK);
        sb.append(Build.VERSION.RELEASE);
        String str = f32585a;
        Log.d(str, "getDeviceFingerprint returned: hash(" + sb.toString() + SQLBuilder.PARENTHESES_RIGHT);
        return v.b(sb.toString());
    }

    static String a(List<URI> list) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (URI next : list) {
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            } else if (next != null) {
                if (next.getScheme().equals(UriUtil.LOCAL_FILE_SCHEME)) {
                    File file = new File(next.getPath());
                    String query = next.getQuery();
                    if (query == null || query.isEmpty()) {
                        if (sb.length() > 0) {
                            sb.append(";");
                        }
                        sb.append(next.getPath());
                        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
                        sb.append(file.exists() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
                    } else if (file.exists()) {
                        Map d2 = v.d(query);
                        boolean containsKey = d2.containsKey("grep");
                        if (containsKey || d2.containsKey("keys")) {
                            String str = (String) d2.get("sep");
                            if (!containsKey && (str == null || str.isEmpty())) {
                                str = ":";
                            }
                            String str2 = (String) (containsKey ? d2.get("grep") : d2.get("keys"));
                            if (str2 == null || str2.isEmpty()) {
                                break;
                            }
                            String a2 = a(file.getAbsolutePath(), v.b(str2, ","), str);
                            if (a2 != null && !a2.isEmpty()) {
                                if (sb.length() > 0) {
                                    sb.append(";");
                                }
                                sb.append(next.getPath());
                                sb.append(SimpleComparison.EQUAL_TO_OPERATION);
                                sb.append(a2);
                            }
                        }
                    } else {
                        continue;
                    }
                } else if (next.getScheme().equals("intro")) {
                    try {
                        String host = next.getHost();
                        String path = next.getPath();
                        if (host != null) {
                            if (!host.isEmpty()) {
                                if (path != null) {
                                    if (!path.isEmpty()) {
                                        if (path.startsWith(Constants.URL_PATH_DELIMITER)) {
                                            path = path.substring(1);
                                        }
                                        Class b2 = af.b(host);
                                        if (b2 == null) {
                                            String str3 = f32585a;
                                            Log.d(str3, "getURLs: failed to find class: " + host);
                                        } else {
                                            Method a3 = af.a(b2, path, new Class[0]);
                                            if (a3 != null) {
                                                Object a4 = af.a((Object) b2, a3, new Object[0]);
                                                if (a4 != null) {
                                                    String obj = a4.toString();
                                                    if (obj != null) {
                                                        if (sb.length() > 0) {
                                                            sb.append(";");
                                                        }
                                                        sb.append(next.getHost());
                                                        sb.append(next.getPath());
                                                        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
                                                        sb.append(obj);
                                                    }
                                                }
                                            } else {
                                                Field a5 = af.a(b2, path);
                                                if (a5 != null) {
                                                    Object a6 = af.a((Object) b2, a5);
                                                    if (a6 != null && (a6 instanceof String)) {
                                                        if (sb.length() > 0) {
                                                            sb.append(";");
                                                        }
                                                        sb.append(next.getHost());
                                                        sb.append(next.getPath());
                                                        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
                                                        sb.append((String) a6);
                                                    }
                                                } else {
                                                    String str4 = f32585a;
                                                    Log.d(str4, "getURLs: failed to find method or field: " + path);
                                                }
                                            }
                                        }
                                    }
                                }
                                Log.d(f32585a, "getURLs: empty methodName");
                            }
                        }
                        Log.d(f32585a, "getURLs: empty className");
                    } catch (Exception unused) {
                    }
                }
            }
        }
        if (sb.length() > 0) {
            String str5 = f32585a;
            Log.d(str5, "found " + sb.toString());
        }
        return sb.toString();
    }

    static boolean a(a aVar) {
        if (aVar != null) {
            TimeZone timeZone = TimeZone.getDefault();
            if (timeZone != null) {
                aVar.f32586a = timeZone.getRawOffset() / CONSTANT.TIME.MIN_1;
                aVar.f32587b = timeZone.getDSTSavings() / CONSTANT.TIME.MIN_1;
                String str = f32585a;
                Log.d(str, "getTimeZoneInfo: dstDiff=" + aVar.f32587b + " gmfOffset=" + aVar.f32586a);
                return true;
            }
            Log.w(f32585a, "getTimeZoneInfo: FAILED");
            return false;
        }
        throw new IllegalArgumentException("tzInfo cannot be null");
    }
}
