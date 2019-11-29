package com.shopee.feeds.feedlibrary.util.b;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f28259a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f28260b = "";

    private b(Context context) {
        try {
            InputStream open = context.getResources().getAssets().open("feeds-events.json");
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    f28260b = sb.toString();
                    return;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static b a(Context context) {
        if (f28259a == null) {
            f28259a = new b(context);
        }
        return f28259a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.shopee.feeds.feedlibrary.util.b.c a(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r4)
            if (r0 != 0) goto L_0x002f
            java.lang.String r0 = f28260b
            boolean r0 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r0)
            if (r0 != 0) goto L_0x002f
            com.google.a.f r0 = new com.google.a.f     // Catch:{ Exception -> 0x002b }
            r0.<init>()     // Catch:{ Exception -> 0x002b }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = f28260b     // Catch:{ Exception -> 0x002b }
            r1.<init>(r2)     // Catch:{ Exception -> 0x002b }
            org.json.JSONObject r4 = r1.getJSONObject(r4)     // Catch:{ Exception -> 0x002b }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x002b }
            java.lang.Class<com.shopee.feeds.feedlibrary.util.b.c> r1 = com.shopee.feeds.feedlibrary.util.b.c.class
            java.lang.Object r4 = r0.a((java.lang.String) r4, r1)     // Catch:{ Exception -> 0x002b }
            com.shopee.feeds.feedlibrary.util.b.c r4 = (com.shopee.feeds.feedlibrary.util.b.c) r4     // Catch:{ Exception -> 0x002b }
            goto L_0x0030
        L_0x002b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x002f:
            r4 = 0
        L_0x0030:
            if (r4 != 0) goto L_0x0037
            com.shopee.feeds.feedlibrary.util.b.c r4 = new com.shopee.feeds.feedlibrary.util.b.c
            r4.<init>()
        L_0x0037:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.util.b.b.a(java.lang.String):com.shopee.feeds.feedlibrary.util.b.c");
    }
}
