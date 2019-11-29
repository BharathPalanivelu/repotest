package com.shopee.live.livestreaming.util;

import android.content.Context;
import com.google.a.f;
import com.shopee.live.livestreaming.data.entity.require.LicenseEntity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static aa f29387a = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f29388d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f29389e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f29390f = "";

    /* renamed from: g  reason: collision with root package name */
    private static String f29391g = "";

    /* renamed from: b  reason: collision with root package name */
    private Context f29392b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, String> f29393c;

    private aa(Context context) {
        this.f29392b = context;
        f29388d = e("livestreaming-events.json");
        f29389e = e("tengxunyun-events.json");
        f29390f = e("livestreaming-issue.json");
        f29391g = e("livestreaming-license.json");
    }

    private String e(String str) {
        if (d.a(str)) {
            return "";
        }
        try {
            InputStream open = this.f29392b.getResources().getAssets().open(str);
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    String sb2 = sb.toString();
                    open.close();
                    bufferedReader.close();
                    return sb2;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static aa a(Context context) {
        if (f29387a == null) {
            f29387a = new aa(context);
        }
        return f29387a;
    }

    public LicenseEntity a(String str) {
        LicenseEntity licenseEntity = null;
        if (!d.a(str) && !d.a(f29391g)) {
            try {
                f fVar = new f();
                JSONObject optJSONObject = new JSONObject(f29391g).optJSONObject(str);
                if (optJSONObject != null) {
                    licenseEntity = (LicenseEntity) fVar.a(optJSONObject.toString(), LicenseEntity.class);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return licenseEntity == null ? new LicenseEntity() : licenseEntity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity b(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = com.shopee.live.livestreaming.util.d.a((java.lang.String) r4)
            if (r0 != 0) goto L_0x002f
            java.lang.String r0 = f29388d
            boolean r0 = com.shopee.live.livestreaming.util.d.a((java.lang.String) r0)
            if (r0 != 0) goto L_0x002f
            com.google.a.f r0 = new com.google.a.f     // Catch:{ Exception -> 0x002b }
            r0.<init>()     // Catch:{ Exception -> 0x002b }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = f29388d     // Catch:{ Exception -> 0x002b }
            r1.<init>(r2)     // Catch:{ Exception -> 0x002b }
            org.json.JSONObject r4 = r1.getJSONObject(r4)     // Catch:{ Exception -> 0x002b }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x002b }
            java.lang.Class<com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity> r1 = com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity.class
            java.lang.Object r4 = r0.a((java.lang.String) r4, r1)     // Catch:{ Exception -> 0x002b }
            com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity r4 = (com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity) r4     // Catch:{ Exception -> 0x002b }
            goto L_0x0030
        L_0x002b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x002f:
            r4 = 0
        L_0x0030:
            if (r4 != 0) goto L_0x0037
            com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity r4 = new com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity
            r4.<init>()
        L_0x0037:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.util.aa.b(java.lang.String):com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity c(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = com.shopee.live.livestreaming.util.d.a((java.lang.String) r4)
            if (r0 != 0) goto L_0x002f
            java.lang.String r0 = f29390f
            boolean r0 = com.shopee.live.livestreaming.util.d.a((java.lang.String) r0)
            if (r0 != 0) goto L_0x002f
            com.google.a.f r0 = new com.google.a.f     // Catch:{ Exception -> 0x002b }
            r0.<init>()     // Catch:{ Exception -> 0x002b }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = f29390f     // Catch:{ Exception -> 0x002b }
            r1.<init>(r2)     // Catch:{ Exception -> 0x002b }
            org.json.JSONObject r4 = r1.getJSONObject(r4)     // Catch:{ Exception -> 0x002b }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x002b }
            java.lang.Class<com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity> r1 = com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity.class
            java.lang.Object r4 = r0.a((java.lang.String) r4, r1)     // Catch:{ Exception -> 0x002b }
            com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity r4 = (com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity) r4     // Catch:{ Exception -> 0x002b }
            goto L_0x0030
        L_0x002b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x002f:
            r4 = 0
        L_0x0030:
            if (r4 != 0) goto L_0x0037
            com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity r4 = new com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity
            r4.<init>()
        L_0x0037:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.util.aa.c(java.lang.String):com.shopee.live.livestreaming.data.entity.require.UpLoadEventEntity");
    }

    public String d(String str) {
        HashMap<String, String> hashMap = this.f29393c;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        if (d.a(f29389e)) {
            return "";
        }
        try {
            this.f29393c = (HashMap) new f().a(new JSONObject(f29389e).toString(), HashMap.class);
            return this.f29393c.get(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
