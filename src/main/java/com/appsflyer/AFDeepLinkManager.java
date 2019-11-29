package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.appsflyer.internal.q;
import com.appsflyer.internal.x;
import com.appsflyer.share.Constants;
import com.facebook.common.util.UriUtil;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class AFDeepLinkManager {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static Uri f0 = null;

    /* renamed from: ˊ  reason: contains not printable characters */
    static final int f1 = ((int) TimeUnit.SECONDS.toMillis(2));

    /* renamed from: ˋ  reason: contains not printable characters */
    static volatile boolean f2;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Uri f3 = null;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static AFDeepLinkManager f4 = null;

    /* renamed from: ॱ  reason: contains not printable characters */
    static String[] f5;
    protected int currentActivityHash = -1;

    private AFDeepLinkManager() {
    }

    public static AFDeepLinkManager getInstance() {
        if (f4 == null) {
            f4 = new AFDeepLinkManager();
        }
        return f4;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m21(Context context, Map<String, Object> map, Uri uri) {
        String obj = uri.toString();
        boolean z = false;
        if (f5 != null && !obj.contains("af_tranid=")) {
            StringBuilder sb = new StringBuilder("Validate ESP deeplinks : ");
            sb.append(Arrays.asList(f5));
            AFLogger.afRDLog(sb.toString());
            String[] strArr = f5;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str = strArr[i];
                if (obj.contains("://".concat(String.valueOf(str)))) {
                    z = true;
                    break;
                } else {
                    AFLogger.afRDLog("Validate ESP: reject ".concat(String.valueOf(str)));
                    i++;
                }
            }
        }
        if (z) {
            StringBuilder sb2 = new StringBuilder("Validation ESP succeeded for: ");
            sb2.append(uri.toString());
            AFLogger.afRDLog(sb2.toString());
            f2 = true;
            AFExecutor.getInstance().getSerialExecutor().execute(new AnonymousClass2(uri, map, context));
            return;
        }
        AppsFlyerLibCore.getInstance().handleDeepLinkCallback(context, map, uri);
    }

    /* renamed from: com.appsflyer.AFDeepLinkManager$2  reason: invalid class name */
    class AnonymousClass2 implements Runnable {

        /* renamed from: ˎ  reason: contains not printable characters */
        private /* synthetic */ Uri f7;

        /* renamed from: ˏ  reason: contains not printable characters */
        private /* synthetic */ Context f8;

        /* renamed from: ॱ  reason: contains not printable characters */
        private /* synthetic */ Map f9;

        AnonymousClass2(Uri uri, Map map, Context context) {
            this.f7 = uri;
            this.f9 = map;
            this.f8 = context;
        }

        public final void run() {
            long j;
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            Uri uri = null;
            try {
                StringBuilder sb = new StringBuilder("ESP deeplink resoling is started: ");
                sb.append(this.f7.toString());
                AFLogger.afRDLog(sb.toString());
                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.f7.toString()).openConnection()));
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setReadTimeout(AFDeepLinkManager.f1);
                httpURLConnection.setConnectTimeout(AFDeepLinkManager.f1);
                httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
                httpURLConnection.connect();
                AFLogger.afRDLog("ESP deeplink resoling is finished");
                hashMap.put("status", String.valueOf(httpURLConnection.getResponseCode()));
                if (httpURLConnection.getResponseCode() >= 300 && httpURLConnection.getResponseCode() <= 305) {
                    uri = Uri.parse(httpURLConnection.getHeaderField(Constants.HTTP_REDIRECT_URL_HEADER_FIELD));
                }
                j = System.currentTimeMillis() - currentTimeMillis;
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                hashMap.put("error", th.getLocalizedMessage());
                hashMap.put("status", "-1");
                j = System.currentTimeMillis() - currentTimeMillis;
                AFLogger.afErrorLog(th.getMessage(), th);
            }
            hashMap.put("latency", Long.toString(j));
            if (uri != null) {
                hashMap.put(UriUtil.LOCAL_RESOURCE_SCHEME, uri.toString());
            } else {
                hashMap.put(UriUtil.LOCAL_RESOURCE_SCHEME, "");
            }
            StringBuilder sb2 = new StringBuilder("ESP deeplink results: ");
            sb2.append(new JSONObject(hashMap).toString());
            AFLogger.afRDLog(sb2.toString());
            synchronized (this.f9) {
                this.f9.put("af_deeplink_r", hashMap);
                this.f9.put("af_deeplink", this.f7.toString());
            }
            AFDeepLinkManager.f2 = false;
            if (uri == null) {
                uri = this.f7;
            }
            AppsFlyerLibCore.getInstance().handleDeepLinkCallback(this.f8, this.f9, uri);
        }

        AnonymousClass2() {
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        static void m22(Context context) {
            Context applicationContext = context.getApplicationContext();
            AFLogger.afInfoLog("onBecameBackground");
            AppsFlyerLibCore.getInstance().f61 = System.currentTimeMillis();
            AFLogger.afInfoLog("callStatsBackground background call");
            AppsFlyerLibCore.getInstance().m97((WeakReference<Context>) new WeakReference(applicationContext));
            if (x.f258 == null) {
                x.f258 = new x();
            }
            x xVar = x.f258;
            if (xVar.f274) {
                xVar.m207();
                if (applicationContext != null) {
                    String packageName = applicationContext.getPackageName();
                    PackageManager packageManager = applicationContext.getPackageManager();
                    try {
                        if (x.f258 == null) {
                            x.f258 = new x();
                        }
                        x.f258.m204(packageName, packageManager);
                        if (x.f258 == null) {
                            x.f258 = new x();
                        }
                        String r6 = x.f258.m206();
                        q qVar = new q((Context) null, AppsFlyerLib.getInstance().isTrackingStopped());
                        qVar.f234 = r6;
                        qVar.f236 = false;
                        StringBuilder sb = new StringBuilder();
                        sb.append(ServerConfigHandler.getUrl("https://%smonitorsdk.%s/remote-debug?app_id="));
                        sb.append(packageName);
                        qVar.execute(new String[]{sb.toString()});
                    } catch (Throwable unused) {
                    }
                }
                xVar.m208();
            } else {
                AFLogger.afDebugLog("RD status is OFF");
            }
            AFExecutor instance = AFExecutor.getInstance();
            try {
                AFExecutor.m23(instance.f13);
                if (instance.f11 instanceof ThreadPoolExecutor) {
                    AFExecutor.m23((ThreadPoolExecutor) instance.f11);
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog("failed to stop Executors", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processIntentForDeepLink(Intent intent, Context context, Map<String, Object> map) {
        Uri uri;
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            uri = null;
        } else {
            uri = intent.getData();
        }
        if (uri != null) {
            boolean z = AppsFlyerProperties.getInstance().getBoolean("consumeAfDeepLink", false);
            boolean z2 = (intent.getFlags() & 4194304) == 0;
            if (intent.hasExtra("appsflyer_click_ts") && !z) {
                long longExtra = intent.getLongExtra("appsflyer_click_ts", 0);
                long j = AppsFlyerProperties.getInstance().getLong("appsflyer_click_consumed_ts", 0);
                if (longExtra == 0 || longExtra == j) {
                    StringBuilder sb = new StringBuilder("skipping re-use of previously consumed deep link: ");
                    sb.append(uri.toString());
                    sb.append(" w/Ex: ");
                    sb.append(String.valueOf(longExtra));
                    AFLogger.afInfoLog(sb.toString());
                    return;
                }
                m21(context, map, uri);
                AppsFlyerProperties.getInstance().set("appsflyer_click_consumed_ts", longExtra);
            } else if (z || z2) {
                Boolean valueOf = Boolean.valueOf(z2);
                Uri uri2 = f3;
                if (uri2 == null || !uri.equals(uri2)) {
                    m21(context, map, uri);
                    f3 = uri;
                    return;
                }
                StringBuilder sb2 = new StringBuilder("skipping re-use of previously consumed deep link: ");
                sb2.append(uri.toString());
                sb2.append(valueOf.booleanValue() ? " w/sT" : " w/cAPI");
                AFLogger.afInfoLog(sb2.toString());
            } else {
                if (this.currentActivityHash != AppsFlyerProperties.getInstance().getInt("lastActivityHash", 0)) {
                    m21(context, map, uri);
                    AppsFlyerProperties.getInstance().set("lastActivityHash", this.currentActivityHash);
                    return;
                }
                StringBuilder sb3 = new StringBuilder("skipping re-use of previously consumed deep link: ");
                sb3.append(uri.toString());
                sb3.append(" w/hC: ");
                sb3.append(String.valueOf(this.currentActivityHash));
                AFLogger.afInfoLog(sb3.toString());
            }
        } else {
            Uri uri3 = f0;
            if (uri3 != null && uri3 != f3) {
                m21(context, map, uri3);
                StringBuilder sb4 = new StringBuilder("using trampoline Intent fallback with URI : ");
                sb4.append(f0.toString());
                AFLogger.afInfoLog(sb4.toString());
                f0 = null;
            } else if (AppsFlyerLibCore.getInstance().latestDeepLink != null) {
                m21(context, map, AppsFlyerLibCore.getInstance().latestDeepLink);
            }
        }
    }

    public void collectIntentsFromActivities(Intent intent) {
        Uri uri;
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            uri = null;
        } else {
            uri = intent.getData();
        }
        if (uri != null && intent.getData() != f0) {
            f0 = intent.getData();
        }
    }
}
