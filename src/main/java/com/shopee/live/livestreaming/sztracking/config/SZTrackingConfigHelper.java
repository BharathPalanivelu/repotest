package com.shopee.live.livestreaming.sztracking.config;

import a.k;
import android.text.TextUtils;
import com.google.a.f;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.shopee.arcatch.data.common_bean.ShopeeEnv;
import com.shopee.e.a.a;
import com.shopee.live.livestreaming.b;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.sztracking.SZTrackingReporter;
import com.shopee.live.livestreaming.util.x;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class SZTrackingConfigHelper {
    private static final String LOCAL_ASSET_CONFIG_FILE_NAME = "ssz_tracking_event_config.json";
    private static final String SZ_TRACKING_PREF = "live_streaming_sz_tracking_store";
    private static final String TAG = "SZTrackingConfigHelper";
    private static SZTrackingConfigStore mStore;

    public interface GetConfigCallback {
        void onResolve(SZTrackingConfigEntity sZTrackingConfigEntity);
    }

    public static void getConfig(final GetConfigCallback getConfigCallback) {
        k.a(new Callable<Void>() {
            public Void call() throws Exception {
                SZTrackingConfigEntity sZTrackingConfigEntity = SZTrackingConfigHelper.getStore().get();
                if (!SZTrackingConfigHelper.configIsOk(sZTrackingConfigEntity)) {
                    getConfigCallback.onResolve(SZTrackingConfigHelper.getFromLocalAssets());
                } else {
                    getConfigCallback.onResolve(sZTrackingConfigEntity);
                }
                Call unused = SZTrackingConfigHelper.pullConfig();
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public static SZTrackingConfigStore getStore() {
        if (mStore == null) {
            mStore = new SZTrackingConfigStore(b.b().c().getSharedPreferences(SZ_TRACKING_PREF, 0));
        }
        return mStore;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.shopee.live.livestreaming.sztracking.config.SZTrackingConfigEntity getFromLocalAssets() {
        /*
            java.lang.String r0 = ""
            com.shopee.live.livestreaming.a r1 = com.shopee.live.livestreaming.b.b()     // Catch:{ IOException -> 0x0038 }
            android.content.Context r1 = r1.c()     // Catch:{ IOException -> 0x0038 }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ IOException -> 0x0038 }
            java.lang.String r2 = "ssz_tracking_event_config.json"
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ IOException -> 0x0038 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0038 }
            r2.<init>()     // Catch:{ IOException -> 0x0038 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0038 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0038 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0038 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0038 }
        L_0x0023:
            java.lang.String r4 = r3.readLine()     // Catch:{ IOException -> 0x0038 }
            if (r4 == 0) goto L_0x002d
            r2.append(r4)     // Catch:{ IOException -> 0x0038 }
            goto L_0x0023
        L_0x002d:
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x0038 }
            r1.close()     // Catch:{ IOException -> 0x0038 }
            r3.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003c:
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0055
            com.google.a.f r2 = new com.google.a.f     // Catch:{ Exception -> 0x0051 }
            r2.<init>()     // Catch:{ Exception -> 0x0051 }
            java.lang.Class<com.shopee.live.livestreaming.sztracking.config.SZTrackingConfigEntity> r3 = com.shopee.live.livestreaming.sztracking.config.SZTrackingConfigEntity.class
            java.lang.Object r0 = r2.a((java.lang.String) r0, r3)     // Catch:{ Exception -> 0x0051 }
            com.shopee.live.livestreaming.sztracking.config.SZTrackingConfigEntity r0 = (com.shopee.live.livestreaming.sztracking.config.SZTrackingConfigEntity) r0     // Catch:{ Exception -> 0x0051 }
            goto L_0x0056
        L_0x0051:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0055:
            r0 = r1
        L_0x0056:
            if (r0 != 0) goto L_0x005d
            com.shopee.live.livestreaming.sztracking.config.SZTrackingConfigEntity r0 = new com.shopee.live.livestreaming.sztracking.config.SZTrackingConfigEntity
            r0.<init>()
        L_0x005d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.sztracking.config.SZTrackingConfigHelper.getFromLocalAssets():com.shopee.live.livestreaming.sztracking.config.SZTrackingConfigEntity");
    }

    /* access modifiers changed from: private */
    public static Call pullConfig() {
        Request.Builder builder = new Request.Builder();
        builder.url(getSZTrackConfigUrl());
        Call newCall = getClient().newCall(builder.build());
        FirebasePerfOkHttpClient.enqueue(newCall, new Callback() {
            public void onFailure(Call call, IOException iOException) {
            }

            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                if (body != null) {
                    String string = body.string();
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            SZTrackingConfigEntity sZTrackingConfigEntity = (SZTrackingConfigEntity) new f().a(string, SZTrackingConfigEntity.class);
                            if (SZTrackingConfigHelper.configIsOk(sZTrackingConfigEntity)) {
                                SZTrackingConfigHelper.getStore().put(sZTrackingConfigEntity);
                                if (SZTrackingReporter.hasInstance()) {
                                    SZTrackingReporter.getInstance().lambda$init$0$SZTrackingReporter(sZTrackingConfigEntity);
                                    a.a(SZTrackingConfigHelper.TAG, "update sz tracking config: " + sZTrackingConfigEntity.toJson());
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        });
        return newCall;
    }

    private static OkHttpClient getClient() {
        OkHttpClient a2 = com.shopee.sdk.b.a().g().a();
        return a2 == null ? new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build() : a2;
    }

    private static String getSZTrackConfigUrl() {
        String b2 = x.b();
        String e2 = com.garena.android.appkit.tools.b.e(c.g.live_streaming_base_url_cdn);
        if (ShopeeEnv.ENV_TEST.equals(b2)) {
            return e2 + "test/" + LOCAL_ASSET_CONFIG_FILE_NAME + "?ts=" + System.currentTimeMillis();
        } else if (ShopeeEnv.ENV_UAT.equals(b2)) {
            return e2 + "uat/" + LOCAL_ASSET_CONFIG_FILE_NAME + "?ts=" + System.currentTimeMillis();
        } else if (ShopeeEnv.ENV_STAGING.equals(b2)) {
            return e2 + "test/" + LOCAL_ASSET_CONFIG_FILE_NAME + "?ts=" + System.currentTimeMillis();
        } else if ("live".equals(b2)) {
            return e2 + "live/" + LOCAL_ASSET_CONFIG_FILE_NAME + "?ts=" + System.currentTimeMillis();
        } else {
            return e2 + "test/" + LOCAL_ASSET_CONFIG_FILE_NAME + "?ts=" + System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: private */
    public static boolean configIsOk(SZTrackingConfigEntity sZTrackingConfigEntity) {
        return sZTrackingConfigEntity != null && sZTrackingConfigEntity.getSend_interval() > 0 && sZTrackingConfigEntity.getSend_limit_size() > 0 && sZTrackingConfigEntity.getBlack_screen_detect_time_for_reconnect() > 0 && sZTrackingConfigEntity.getBlack_screen_detect_time_for_first_time_connect() > 0 && sZTrackingConfigEntity.getLow_fps() > 0 && sZTrackingConfigEntity.getLow_fps_report_interval() > 0;
    }
}
