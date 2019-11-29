package com.appsflyer.cache;

import android.content.Context;
import android.util.Log;
import com.appsflyer.AppsFlyerLibCore;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CacheManager {
    public static final String AF_CACHE_DIR = "AFRequestCache";
    public static final int CACHE_MAX_SIZE = 40;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static CacheManager f111 = new CacheManager();

    private CacheManager() {
    }

    public static CacheManager getInstance() {
        return f111;
    }

    public List<RequestCacheData> getCachedRequests(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(context.getFilesDir(), AF_CACHE_DIR);
            if (!file.exists()) {
                file.mkdir();
            } else {
                for (File file2 : file.listFiles()) {
                    StringBuilder sb = new StringBuilder("Found cached request");
                    sb.append(file2.getName());
                    Log.i(AppsFlyerLibCore.LOG_TAG, sb.toString());
                    arrayList.add(m119(file2));
                }
            }
        } catch (Exception unused) {
            Log.i(AppsFlyerLibCore.LOG_TAG, "Could not cache request");
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026 A[SYNTHETIC, Splitter:B:13:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002d A[SYNTHETIC, Splitter:B:21:0x002d] */
    /* renamed from: ॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.appsflyer.cache.RequestCacheData m119(java.io.File r4) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ Exception -> 0x002a, all -> 0x0022 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x002a, all -> 0x0022 }
            long r2 = r4.length()     // Catch:{ Exception -> 0x002b, all -> 0x0020 }
            int r3 = (int) r2     // Catch:{ Exception -> 0x002b, all -> 0x0020 }
            char[] r2 = new char[r3]     // Catch:{ Exception -> 0x002b, all -> 0x0020 }
            r1.read(r2)     // Catch:{ Exception -> 0x002b, all -> 0x0020 }
            com.appsflyer.cache.RequestCacheData r3 = new com.appsflyer.cache.RequestCacheData     // Catch:{ Exception -> 0x002b, all -> 0x0020 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x002b, all -> 0x0020 }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x002b, all -> 0x0020 }
            r3.setCacheKey(r4)     // Catch:{ Exception -> 0x002b, all -> 0x0020 }
            r1.close()     // Catch:{ IOException -> 0x001f }
        L_0x001f:
            return r3
        L_0x0020:
            r4 = move-exception
            goto L_0x0024
        L_0x0022:
            r4 = move-exception
            r1 = r0
        L_0x0024:
            if (r1 == 0) goto L_0x0029
            r1.close()     // Catch:{ IOException -> 0x0029 }
        L_0x0029:
            throw r4
        L_0x002a:
            r1 = r0
        L_0x002b:
            if (r1 == 0) goto L_0x0030
            r1.close()     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.cache.CacheManager.m119(java.io.File):com.appsflyer.cache.RequestCacheData");
    }

    public void init(Context context) {
        try {
            if (!new File(context.getFilesDir(), AF_CACHE_DIR).exists()) {
                new File(context.getFilesDir(), AF_CACHE_DIR).mkdir();
            }
        } catch (Exception unused) {
            Log.i(AppsFlyerLibCore.LOG_TAG, "Could not create cache directory");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009a A[SYNTHETIC, Splitter:B:29:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a1 A[SYNTHETIC, Splitter:B:33:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cacheRequest(com.appsflyer.cache.RequestCacheData r8, android.content.Context r9) {
        /*
            r7 = this;
            java.lang.String r0 = "AFRequestCache"
            java.lang.String r1 = "AppsFlyer_4.10.0"
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0093 }
            java.io.File r4 = r9.getFilesDir()     // Catch:{ Exception -> 0x0093 }
            r3.<init>(r4, r0)     // Catch:{ Exception -> 0x0093 }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0093 }
            if (r4 != 0) goto L_0x0018
            r3.mkdir()     // Catch:{ Exception -> 0x0093 }
            return
        L_0x0018:
            java.io.File[] r3 = r3.listFiles()     // Catch:{ Exception -> 0x0093 }
            if (r3 == 0) goto L_0x0029
            int r3 = r3.length     // Catch:{ Exception -> 0x0093 }
            r4 = 40
            if (r3 <= r4) goto L_0x0029
            java.lang.String r8 = "reached cache limit, not caching request"
            android.util.Log.i(r1, r8)     // Catch:{ Exception -> 0x0093 }
            return
        L_0x0029:
            java.lang.String r3 = "caching request..."
            android.util.Log.i(r1, r3)     // Catch:{ Exception -> 0x0093 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0093 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0093 }
            java.io.File r9 = r9.getFilesDir()     // Catch:{ Exception -> 0x0093 }
            r4.<init>(r9, r0)     // Catch:{ Exception -> 0x0093 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0093 }
            java.lang.String r9 = java.lang.Long.toString(r5)     // Catch:{ Exception -> 0x0093 }
            r3.<init>(r4, r9)     // Catch:{ Exception -> 0x0093 }
            r3.createNewFile()     // Catch:{ Exception -> 0x0093 }
            java.io.OutputStreamWriter r9 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0093 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0093 }
            java.lang.String r3 = r3.getPath()     // Catch:{ Exception -> 0x0093 }
            r4 = 1
            r0.<init>(r3, r4)     // Catch:{ Exception -> 0x0093 }
            r9.<init>(r0)     // Catch:{ Exception -> 0x0093 }
            java.lang.String r0 = "version="
            r9.write(r0)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            java.lang.String r0 = r8.getVersion()     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            r9.write(r0)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            r0 = 10
            r9.write(r0)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            java.lang.String r2 = "url="
            r9.write(r2)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            java.lang.String r2 = r8.getRequestURL()     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            r9.write(r2)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            r9.write(r0)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            java.lang.String r2 = "data="
            r9.write(r2)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            java.lang.String r8 = r8.getPostData()     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            r9.write(r8)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            r9.write(r0)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            r9.flush()     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            r9.close()     // Catch:{ IOException -> 0x008b }
        L_0x008b:
            return
        L_0x008c:
            r8 = move-exception
            r2 = r9
            goto L_0x009f
        L_0x008f:
            r2 = r9
            goto L_0x0093
        L_0x0091:
            r8 = move-exception
            goto L_0x009f
        L_0x0093:
            java.lang.String r8 = "Could not cache request"
            android.util.Log.i(r1, r8)     // Catch:{ all -> 0x0091 }
            if (r2 == 0) goto L_0x009e
            r2.close()     // Catch:{ IOException -> 0x009e }
        L_0x009e:
            return
        L_0x009f:
            if (r2 == 0) goto L_0x00a4
            r2.close()     // Catch:{ IOException -> 0x00a4 }
        L_0x00a4:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.cache.CacheManager.cacheRequest(com.appsflyer.cache.RequestCacheData, android.content.Context):void");
    }

    public void deleteRequest(String str, Context context) {
        File file = new File(new File(context.getFilesDir(), AF_CACHE_DIR), str);
        StringBuilder sb = new StringBuilder("Deleting ");
        sb.append(str);
        sb.append(" from cache");
        Log.i(AppsFlyerLibCore.LOG_TAG, sb.toString());
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder("Could not delete ");
                sb2.append(str);
                sb2.append(" from cache");
                Log.i(AppsFlyerLibCore.LOG_TAG, sb2.toString(), e2);
            }
        }
    }

    public void clearCache(Context context) {
        try {
            File file = new File(context.getFilesDir(), AF_CACHE_DIR);
            if (!file.exists()) {
                file.mkdir();
                return;
            }
            for (File file2 : file.listFiles()) {
                StringBuilder sb = new StringBuilder("Found cached request");
                sb.append(file2.getName());
                Log.i(AppsFlyerLibCore.LOG_TAG, sb.toString());
                deleteRequest(m119(file2).getCacheKey(), context);
            }
        } catch (Exception unused) {
            Log.i(AppsFlyerLibCore.LOG_TAG, "Could not cache request");
        }
    }
}
