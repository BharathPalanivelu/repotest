package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.appsflyer.AFDeepLinkManager;
import com.appsflyer.AFExecutor;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.cache.CacheManager;
import com.appsflyer.cache.RequestCacheData;
import com.appsflyer.internal.b;
import com.appsflyer.internal.f;
import com.appsflyer.internal.g;
import com.appsflyer.internal.h;
import com.appsflyer.internal.l;
import com.appsflyer.internal.n;
import com.appsflyer.internal.o;
import com.appsflyer.internal.p;
import com.appsflyer.internal.q;
import com.appsflyer.internal.r;
import com.appsflyer.internal.s;
import com.appsflyer.internal.t;
import com.appsflyer.internal.u;
import com.appsflyer.internal.v;
import com.appsflyer.internal.w;
import com.appsflyer.internal.x;
import com.appsflyer.internal.y;
import com.appsflyer.share.Constants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.imsdk.TIMGroupManager;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.NetworkInterface;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppsFlyerLibCore extends AppsFlyerLib implements h {
    public static final String AF_PRE_INSTALL_PATH = "AF_PRE_INSTALL_PATH";
    public static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    public static final String ATTRIBUTION_ID_CONTENT_URI = "content://com.facebook.katana.provider.AttributionIdProvider";
    public static final String IS_STOP_TRACKING_USED = "is_stop_tracking_used";
    public static final String LOG_TAG = "AppsFlyer_4.10.0";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT = "/data/local/tmp/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT_ETC = "/etc/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_RO_PROP = "ro.appsflyer.preinstall.path";

    /* renamed from: ʻ  reason: contains not printable characters */
    private static final String f28;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private static AppsFlyerLibCore f29 = new AppsFlyerLibCore();

    /* renamed from: ʼ  reason: contains not printable characters */
    private static String f30;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static AppsFlyerInAppPurchaseValidatorListener f31 = null;
    /* access modifiers changed from: private */

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public static final List<String> f32 = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private static String f33;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final String f34;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static AppsFlyerTrackingRequestListener f35 = null;
    /* access modifiers changed from: private */

    /* renamed from: ͺ  reason: contains not printable characters */
    public static AppsFlyerConversionListener f36 = null;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final String f37 = BuildConfig.VERSION_NAME.substring(0, BuildConfig.VERSION_NAME.indexOf("."));

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static final List<String> f38 = Arrays.asList(new String[]{"is_cache"});

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static String f39;
    protected Uri latestDeepLink = null;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private p.b f40;

    /* renamed from: ʽ  reason: contains not printable characters */
    long f41;
    /* access modifiers changed from: private */

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public Map<String, String> f42;
    /* access modifiers changed from: private */

    /* renamed from: ʾ  reason: contains not printable characters */
    public long f43;
    /* access modifiers changed from: private */

    /* renamed from: ʿ  reason: contains not printable characters */
    public boolean f44 = false;
    /* access modifiers changed from: private */

    /* renamed from: ˈ  reason: contains not printable characters */
    public ScheduledExecutorService f45 = null;

    /* renamed from: ˉ  reason: contains not printable characters */
    private String f46;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private long f47;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private boolean f48 = false;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private boolean f49 = false;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String f50;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private Map<Long, String> f51;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private boolean f52;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private w f53 = new w();

    /* renamed from: ˌ  reason: contains not printable characters */
    private boolean f54;

    /* renamed from: ˍ  reason: contains not printable characters */
    private boolean f55 = false;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String f56;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private boolean f57 = false;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private long f58 = -1;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private long f59 = TimeUnit.SECONDS.toMillis(5);

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private long f60 = -1;

    /* renamed from: ᐝ  reason: contains not printable characters */
    long f61;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private g f62 = null;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f37);
        sb.append("/androidevent?buildnumber=4.10.0&app_id=");
        f28 = sb.toString();
        StringBuilder sb2 = new StringBuilder("https://%sattr.%s/api/v");
        sb2.append(f28);
        f39 = sb2.toString();
        StringBuilder sb3 = new StringBuilder("https://%st.%s/api/v");
        sb3.append(f28);
        f30 = sb3.toString();
        StringBuilder sb4 = new StringBuilder("https://%sevents.%s/api/v");
        sb4.append(f28);
        f33 = sb4.toString();
        StringBuilder sb5 = new StringBuilder("https://%sregister.%s/api/v");
        sb5.append(f28);
        f34 = sb5.toString();
    }

    private AppsFlyerLibCore() {
        AFVersionDeclaration.init();
    }

    public static AppsFlyerLibCore getInstance() {
        return f29;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m52(Context context, String str) {
        Intent intent = new Intent("com.appsflyer.testIntgrationBroadcast");
        intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, str);
        if (Build.VERSION.SDK_INT < 26) {
            context.sendBroadcast(intent);
        } else if (context.getPackageManager().queryBroadcastReceivers(intent, 0).toString().contains("com.appsflyer.referrerSender")) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName("com.appsflyer.referrerSender", "com.appsflyer.referrerSender.Receiver"));
            context.sendBroadcast(intent2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m95(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(AppsFlyerProperties.IS_MONITOR);
        if (stringExtra != null) {
            AFLogger.afInfoLog("Turning on monitoring.");
            AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_MONITOR, stringExtra.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            m69(context, (String) null, "START_TRACKING", context.getPackageName());
            return;
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance().setOnReceiveCalled();
        String stringExtra2 = intent.getStringExtra("referrer");
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(stringExtra2)));
        if (stringExtra2 != null) {
            if ("AppsFlyer_Test".equals(intent.getStringExtra("TestIntegrationMode"))) {
                SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
                edit.clear();
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
                AppsFlyerProperties.getInstance().setFirstLaunchCalled(false);
                AFLogger.afInfoLog("Test mode started..");
                this.f47 = System.currentTimeMillis();
            }
            SharedPreferences.Editor edit2 = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
            edit2.putString("referrer", stringExtra2);
            if (Build.VERSION.SDK_INT >= 9) {
                edit2.apply();
            } else {
                edit2.commit();
            }
            AppsFlyerProperties.getInstance().setReferrer(stringExtra2);
            if (AppsFlyerProperties.getInstance().isFirstLaunchCalled()) {
                AFLogger.afInfoLog("onReceive: isLaunchCalled");
                if (stringExtra2 != null && stringExtra2.length() > 5) {
                    m79(AFExecutor.getInstance().m24(), new b(this, new WeakReference(context.getApplicationContext()), (String) null, (String) null, (String) null, stringExtra2, true, intent, (String) null, (byte) 0), 5, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m72(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(keys.next()));
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i)));
                }
            } catch (JSONException unused) {
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = jSONObject.keys();
        loop2:
        while (true) {
            str = null;
            while (keys2.hasNext() && str == null) {
                String next = keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    String str2 = str;
                    int i2 = 0;
                    while (i2 < jSONArray2.length()) {
                        try {
                            if (jSONArray2.getLong(i2) != ((Long) arrayList.get(0)).longValue() && jSONArray2.getLong(i2) != ((Long) arrayList.get(1)).longValue() && jSONArray2.getLong(i2) != ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                                i2++;
                                str2 = next;
                            }
                        } catch (JSONException unused2) {
                        }
                    }
                    str = str2;
                } catch (JSONException unused3) {
                }
            }
        }
        if (str != null) {
            jSONObject.remove(str);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static void m76(Context context, String str) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String string = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).getString("extraReferrers", (String) null);
            if (string == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject = jSONObject2;
                jSONArray = new JSONArray();
            } else {
                jSONObject = new JSONObject(string);
                if (jSONObject.has(str)) {
                    jSONArray = new JSONArray((String) jSONObject.get(str));
                } else {
                    jSONArray = new JSONArray();
                }
            }
            if (((long) jSONArray.length()) < 5) {
                jSONArray.put(currentTimeMillis);
            }
            if (((long) jSONObject.length()) >= 4) {
                m72(jSONObject);
            }
            jSONObject.put(str, jSONArray.toString());
            String jSONObject3 = jSONObject.toString();
            SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
            edit.putString("extraReferrers", jSONObject3);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Couldn't save referrer - ");
            sb.append(str);
            sb.append(": ");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    public void stopTracking(boolean z, Context context) {
        this.f55 = z;
        CacheManager.getInstance().clearCache(context);
        if (this.f55) {
            SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
            edit.putBoolean(IS_STOP_TRACKING_USED, true);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    public void onPause(Context context) {
        AFDeepLinkManager.AnonymousClass2.m22(context);
        o r2 = o.m168(context);
        r2.f217.post(r2.f211);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m84(Application application) {
        AppsFlyerProperties.getInstance().loadProperties(application.getApplicationContext());
        if (Build.VERSION.SDK_INT < 14) {
            AFLogger.afInfoLog("SDK<14 call trackEvent manually");
            AFLogger.afInfoLog("onBecameForeground");
            getInstance().f41 = System.currentTimeMillis();
            getInstance().m96((Context) application, (String) null, (Map<String, Object>) null);
            AFLogger.resetDeltaTime();
        } else if (this.f40 == null) {
            if (p.f224 == null) {
                p.f224 = new p();
            }
            this.f40 = new p.b() {
                /* renamed from: ˋ  reason: contains not printable characters */
                public final void m101(Activity activity) {
                    if (2 > AppsFlyerLibCore.m44(AppsFlyerLibCore.m46((Context) activity), "appsFlyerCount", false)) {
                        o r0 = o.m168(activity);
                        r0.f217.post(r0.f211);
                        r0.f217.post(r0.f213);
                    }
                    AFLogger.afInfoLog("onBecameForeground");
                    AppsFlyerLibCore.getInstance().f41 = System.currentTimeMillis();
                    AppsFlyerLibCore.getInstance().m96((Context) activity, (String) null, (Map<String, Object>) null);
                    AFLogger.resetDeltaTime();
                }

                /* renamed from: ˎ  reason: contains not printable characters */
                public final void m102(WeakReference<Context> weakReference) {
                    AFDeepLinkManager.AnonymousClass2.m22(weakReference.get());
                    o r2 = o.m168(weakReference.get());
                    r2.f217.post(r2.f211);
                }
            };
            if (p.f224 != null) {
                p.f224.f227 = this.f40;
                if (Build.VERSION.SDK_INT >= 14) {
                    application.registerActivityLifecycleCallbacks(p.f224);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Foreground is not initialised - invoke at least once with parameter init/get");
        }
    }

    public void updateServerUninstallToken(Context context, String str) {
        if (str != null) {
            v.m190(context, new b.C0090b.a(str));
        }
    }

    public AppsFlyerLib enableLocationCollection(boolean z) {
        this.f48 = z;
        return this;
    }

    public void waitForCustomerUserId(boolean z) {
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z);
    }

    public String getOutOfStore(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        String r3 = m58((WeakReference<Context>) new WeakReference(context), "AF_STORE");
        if (r3 != null) {
            return r3;
        }
        AFLogger.afInfoLog("No out-of-store value set");
        return null;
    }

    public void setOutOfStore(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
            AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            return;
        }
        AFLogger.m36("Cannot set setOutOfStore with null");
    }

    public void sendDeepLinkData(Activity activity) {
        if (activity != null && activity.getIntent() != null) {
            if (x.f258 == null) {
                x.f258 = new x();
            }
            x xVar = x.f258;
            StringBuilder sb = new StringBuilder("activity_intent_");
            sb.append(activity.getIntent().toString());
            xVar.m205("public_api_call", "sendDeepLinkData", activity.getLocalClassName(), sb.toString());
        } else if (activity != null) {
            if (x.f258 == null) {
                x.f258 = new x();
            }
            x.f258.m205("public_api_call", "sendDeepLinkData", activity.getLocalClassName(), "activity_intent_null");
        } else {
            if (x.f258 == null) {
                x.f258 = new x();
            }
            x.f258.m205("public_api_call", "sendDeepLinkData", "activity_null");
        }
        try {
            m84(activity.getApplication());
            StringBuilder sb2 = new StringBuilder("getDeepLinkData with activity ");
            sb2.append(activity.getIntent().getDataString());
            AFLogger.afInfoLog(sb2.toString());
        } catch (Exception e2) {
            AFLogger.afInfoLog("getDeepLinkData Exception: ".concat(String.valueOf(e2)));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendPushNotificationData(android.app.Activity r19) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            java.lang.String r0 = "c"
            java.lang.String r3 = "pid"
            r4 = 2
            java.lang.String r5 = "public_api_call"
            r6 = 0
            r7 = 1
            java.lang.String r8 = "sendPushNotificationData"
            if (r2 == 0) goto L_0x0048
            android.content.Intent r9 = r19.getIntent()
            if (r9 == 0) goto L_0x0048
            com.appsflyer.internal.x r9 = com.appsflyer.internal.x.f258
            if (r9 != 0) goto L_0x0022
            com.appsflyer.internal.x r9 = new com.appsflyer.internal.x
            r9.<init>()
            com.appsflyer.internal.x.f258 = r9
        L_0x0022:
            com.appsflyer.internal.x r9 = com.appsflyer.internal.x.f258
            java.lang.String[] r10 = new java.lang.String[r4]
            java.lang.String r11 = r19.getLocalClassName()
            r10[r6] = r11
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r11 = "activity_intent_"
            r6.<init>(r11)
            android.content.Intent r11 = r19.getIntent()
            java.lang.String r11 = r11.toString()
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            r10[r7] = r6
            r9.m205(r5, r8, r10)
            goto L_0x007d
        L_0x0048:
            if (r2 == 0) goto L_0x0067
            com.appsflyer.internal.x r9 = com.appsflyer.internal.x.f258
            if (r9 != 0) goto L_0x0055
            com.appsflyer.internal.x r9 = new com.appsflyer.internal.x
            r9.<init>()
            com.appsflyer.internal.x.f258 = r9
        L_0x0055:
            com.appsflyer.internal.x r9 = com.appsflyer.internal.x.f258
            java.lang.String[] r10 = new java.lang.String[r4]
            java.lang.String r11 = r19.getLocalClassName()
            r10[r6] = r11
            java.lang.String r6 = "activity_intent_null"
            r10[r7] = r6
            r9.m205(r5, r8, r10)
            goto L_0x007d
        L_0x0067:
            com.appsflyer.internal.x r9 = com.appsflyer.internal.x.f258
            if (r9 != 0) goto L_0x0072
            com.appsflyer.internal.x r9 = new com.appsflyer.internal.x
            r9.<init>()
            com.appsflyer.internal.x.f258 = r9
        L_0x0072:
            com.appsflyer.internal.x r9 = com.appsflyer.internal.x.f258
            java.lang.String[] r7 = new java.lang.String[r7]
            java.lang.String r10 = "activity_null"
            r7[r6] = r10
            r9.m205(r5, r8, r7)
        L_0x007d:
            boolean r5 = r2 instanceof android.app.Activity
            if (r5 == 0) goto L_0x00b0
            r5 = r2
            android.app.Activity r5 = (android.app.Activity) r5
            android.content.Intent r7 = r5.getIntent()
            if (r7 == 0) goto L_0x00b0
            android.os.Bundle r8 = r7.getExtras()
            if (r8 == 0) goto L_0x00b0
            java.lang.String r9 = "af"
            java.lang.String r10 = r8.getString(r9)
            if (r10 == 0) goto L_0x00b1
            java.lang.String r11 = java.lang.String.valueOf(r10)
            java.lang.String r12 = "Push Notification received af payload = "
            java.lang.String r11 = r12.concat(r11)
            com.appsflyer.AFLogger.afInfoLog(r11)
            r8.remove(r9)
            android.content.Intent r7 = r7.putExtras(r8)
            r5.setIntent(r7)
            goto L_0x00b1
        L_0x00b0:
            r10 = 0
        L_0x00b1:
            r1.f46 = r10
            java.lang.String r5 = r1.f46
            if (r5 == 0) goto L_0x01c3
            long r7 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.f51
            java.lang.String r9 = ")"
            if (r5 != 0) goto L_0x00d0
            java.lang.String r0 = "pushes: initializing pushes history.."
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1.f51 = r0
            r12 = r7
            goto L_0x0181
        L_0x00d0:
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0166 }
            java.lang.String r10 = "pushPayloadMaxAging"
            r11 = 1800000(0x1b7740, double:8.89318E-318)
            long r10 = r5.getLong(r10, r11)     // Catch:{ Throwable -> 0x0166 }
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.f51     // Catch:{ Throwable -> 0x0166 }
            java.util.Set r5 = r5.keySet()     // Catch:{ Throwable -> 0x0166 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Throwable -> 0x0166 }
            r12 = r7
        L_0x00e8:
            boolean r14 = r5.hasNext()     // Catch:{ Throwable -> 0x0164 }
            if (r14 == 0) goto L_0x0181
            java.lang.Object r14 = r5.next()     // Catch:{ Throwable -> 0x0164 }
            java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ Throwable -> 0x0164 }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r4 = r1.f46     // Catch:{ Throwable -> 0x0164 }
            r15.<init>(r4)     // Catch:{ Throwable -> 0x0164 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0164 }
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.f51     // Catch:{ Throwable -> 0x0164 }
            java.lang.Object r6 = r6.get(r14)     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Throwable -> 0x0164 }
            r4.<init>(r6)     // Catch:{ Throwable -> 0x0164 }
            java.lang.Object r6 = r15.get(r3)     // Catch:{ Throwable -> 0x0164 }
            java.lang.Object r2 = r4.get(r3)     // Catch:{ Throwable -> 0x0164 }
            boolean r2 = r6.equals(r2)     // Catch:{ Throwable -> 0x0164 }
            if (r2 == 0) goto L_0x0144
            java.lang.Object r2 = r15.get(r0)     // Catch:{ Throwable -> 0x0164 }
            java.lang.Object r6 = r4.get(r0)     // Catch:{ Throwable -> 0x0164 }
            boolean r2 = r2.equals(r6)     // Catch:{ Throwable -> 0x0164 }
            if (r2 == 0) goto L_0x0144
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r2 = "PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: "
            r0.<init>(r2)     // Catch:{ Throwable -> 0x0164 }
            r0.append(r4)     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r2 = ", new: "
            r0.append(r2)     // Catch:{ Throwable -> 0x0164 }
            r0.append(r15)     // Catch:{ Throwable -> 0x0164 }
            r0.append(r9)     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0164 }
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ Throwable -> 0x0164 }
            r2 = 0
            r1.f46 = r2     // Catch:{ Throwable -> 0x0164 }
            return
        L_0x0144:
            r2 = 0
            long r16 = r14.longValue()     // Catch:{ Throwable -> 0x0164 }
            long r16 = r7 - r16
            int r4 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x0154
            java.util.Map<java.lang.Long, java.lang.String> r4 = r1.f51     // Catch:{ Throwable -> 0x0164 }
            r4.remove(r14)     // Catch:{ Throwable -> 0x0164 }
        L_0x0154:
            long r16 = r14.longValue()     // Catch:{ Throwable -> 0x0164 }
            int r4 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r4 > 0) goto L_0x0160
            long r12 = r14.longValue()     // Catch:{ Throwable -> 0x0164 }
        L_0x0160:
            r2 = r19
            r4 = 2
            goto L_0x00e8
        L_0x0164:
            r0 = move-exception
            goto L_0x0168
        L_0x0166:
            r0 = move-exception
            r12 = r7
        L_0x0168:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error while handling push notification measurement: "
            r2.<init>(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.afErrorLog(r2, r0)
        L_0x0181:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "pushPayloadHistorySize"
            r3 = 2
            int r0 = r0.getInt(r2, r3)
            java.util.Map<java.lang.Long, java.lang.String> r2 = r1.f51
            int r2 = r2.size()
            if (r2 != r0) goto L_0x01b1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "pushes: removing oldest overflowing push (oldest push:"
            r0.<init>(r2)
            r0.append(r12)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.f51
            java.lang.Long r2 = java.lang.Long.valueOf(r12)
            r0.remove(r2)
        L_0x01b1:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.f51
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = r1.f46
            r0.put(r2, r3)
            android.app.Application r0 = r19.getApplication()
            r1.m84((android.app.Application) r0)
        L_0x01c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.sendPushNotificationData(android.app.Activity):void");
    }

    public void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setUserEmails", (String[]) arrayList.toArray(new String[(strArr.length + 1)]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        String str = null;
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : strArr) {
            int i = AnonymousClass2.f63[emailsCryptType.ordinal()];
            if (i == 2) {
                arrayList2.add(y.m210(str2));
                str = "md5_el_arr";
            } else if (i == 3) {
                arrayList2.add(y.m211(str2));
                str = "sha256_el_arr";
            } else if (i != 4) {
                arrayList2.add(y.m213(str2));
                str = "sha1_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
        }
        hashMap.put(str, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: ˊ  reason: contains not printable characters */
        static final /* synthetic */ int[] f63 = new int[AppsFlyerProperties.EmailsCryptType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.appsflyer.AppsFlyerProperties$EmailsCryptType[] r0 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63 = r0
                int[] r0 = f63     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA1     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f63     // Catch:{ NoSuchFieldError -> 0x001f }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.MD5     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f63     // Catch:{ NoSuchFieldError -> 0x002a }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA256     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f63     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.NONE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.AnonymousClass2.<clinit>():void");
        }
    }

    public void setResolveDeepLinkURLs(String... strArr) {
        AFDeepLinkManager.f5 = strArr;
    }

    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener, Context context) {
        if (context == null) {
            AFLogger.afWarnLog("init :: context is null, Google Install Referrer will be not initialized!");
        } else if (m89(context)) {
            if (this.f62 == null) {
                this.f62 = new g();
                this.f62.m150(context, this);
            } else {
                AFLogger.afWarnLog("AFInstallReferrer instance already created");
            }
        }
        return init(str, appsFlyerConversionListener);
    }

    public void startTracking(Application application) {
        if (!this.f52) {
            AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! The API call 'startTracking(Application)' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
        } else {
            startTracking(application, (String) null);
        }
    }

    public void startTracking(Application application, String str) {
        startTracking(application, str, (AppsFlyerTrackingRequestListener) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m97(WeakReference<Context> weakReference) {
        if (weakReference.get() != null) {
            AFLogger.afInfoLog("app went to background");
            SharedPreferences sharedPreferences = weakReference.get().getApplicationContext().getSharedPreferences("appsflyer-data", 0);
            AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
            long j = this.f61 - this.f41;
            HashMap hashMap = new HashMap();
            String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
            if (string == null) {
                AFLogger.afWarnLog("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
                return;
            }
            String string2 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            n r7 = r.m178(weakReference.get().getContentResolver());
            if (r7 != null) {
                hashMap.put("amazon_aid", r7.f202);
                hashMap.put("amazon_aid_limit", String.valueOf(r7.f203));
            }
            String string3 = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
            if (string3 != null) {
                hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string3);
            }
            hashMap.put("app_id", weakReference.get().getPackageName());
            hashMap.put("devkey", string);
            hashMap.put("uid", u.m186(weakReference));
            hashMap.put("time_in_app", String.valueOf(j / 1000));
            hashMap.put("statType", "user_closed_app");
            hashMap.put("platform", "Android");
            hashMap.put("launch_counter", Integer.toString(m44(sharedPreferences, "appsFlyerCount", false)));
            hashMap.put(AppsFlyerProperties.CHANNEL, m57(weakReference));
            if (string2 == null) {
                string2 = "";
            }
            hashMap.put("originalAppsflyerId", string2);
            if (this.f57) {
                try {
                    q qVar = new q((Context) null, isTrackingStopped());
                    qVar.f237 = hashMap;
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        AFLogger.afDebugLog("Main thread detected. Running callStats task in a new thread.");
                        qVar.execute(new String[]{ServerConfigHandler.getUrl("https://%sstats.%s/stats")});
                        return;
                    }
                    StringBuilder sb = new StringBuilder("Running callStats task (on current thread: ");
                    sb.append(Thread.currentThread().toString());
                    sb.append(" )");
                    AFLogger.afDebugLog(sb.toString());
                    qVar.onPreExecute();
                    qVar.onPostExecute(qVar.doInBackground(ServerConfigHandler.getUrl("https://%sstats.%s/stats")));
                } catch (Throwable th) {
                    AFLogger.afErrorLog("Could not send callStats request", th);
                }
            } else {
                AFLogger.afDebugLog("Stats call is disabled, ignore ...");
            }
        }
    }

    public void trackAppLaunch(Context context, String str) {
        if (m89(context)) {
            if (this.f62 == null) {
                this.f62 = new g();
                this.f62.m150(context, this);
            } else {
                AFLogger.afWarnLog("AFInstallReferrer instance already created");
            }
        }
        m70(context, str, (String) null, (String) null, "", (Intent) null, (String) null);
    }

    /* access modifiers changed from: protected */
    public void setDeepLinkData(Intent intent) {
        if (intent != null) {
            try {
                if ("android.intent.action.VIEW".equals(intent.getAction())) {
                    this.latestDeepLink = intent.getData();
                    StringBuilder sb = new StringBuilder("Unity setDeepLinkData = ");
                    sb.append(this.latestDeepLink);
                    AFLogger.afDebugLog(sb.toString());
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog("Exception while setting deeplink data (unity). ", th);
            }
        }
    }

    public void setPluginDeepLinkData(Intent intent) {
        setDeepLinkData(intent);
    }

    public void trackEvent(Context context, String str, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject(map == null ? new HashMap<>() : map);
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "trackEvent", str, jSONObject.toString());
        m96(context, str, map);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m96(Context context, String str, Map<String, Object> map) {
        String str2;
        Intent intent;
        String str3;
        Uri uri = null;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            Intent intent2 = activity.getIntent();
            AFDeepLinkManager.getInstance().currentActivityHash = System.identityHashCode(activity);
            try {
                uri = androidx.core.app.a.c(activity);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
            if (uri != null) {
                str2 = uri.toString();
            } else {
                str2 = "";
            }
            intent = intent2;
        } else {
            str2 = "";
            intent = null;
        }
        if (AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY) == null) {
            AFLogger.afWarnLog("[TrackEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        JSONObject jSONObject = new JSONObject(map);
        String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
        String jSONObject2 = jSONObject.toString();
        if (referrer == null) {
            str3 = "";
        } else {
            str3 = referrer;
        }
        m70(context, (String) null, str, jSONObject2, str3, intent, str2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m69(Context context, String str, String str2, String str3) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.IS_MONITOR, false)) {
            Intent intent = new Intent("com.appsflyer.MonitorBroadcast");
            intent.setPackage("com.appsflyer.nightvision");
            intent.putExtra(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str2);
            intent.putExtra(AppMeasurementSdk.ConditionalUserProperty.VALUE, str3);
            intent.putExtra("packageName", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            intent.putExtra(Constants.URL_MEDIA_SOURCE, new Integer(Process.myPid()));
            intent.putExtra("eventIdentifier", str);
            intent.putExtra(ServerProtocol.DIALOG_PARAM_SDK_VERSION, BuildConfig.VERSION_NAME);
            context.sendBroadcast(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void getConversionData(Context context, final ConversionDataListener conversionDataListener) {
        f36 = new AppsFlyerConversionListener() {
            public final void onAppOpenAttribution(Map<String, String> map) {
            }

            public final void onAttributionFailure(String str) {
            }

            public final void onInstallConversionDataLoaded(Map<String, String> map) {
                conversionDataListener.onConversionDataLoaded(map);
            }

            public final void onInstallConversionFailure(String str) {
                conversionDataListener.onConversionFailure(str);
            }
        };
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static Map<String, String> m82(Context context, String str) {
        String str2;
        String str3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] split = str.split("&");
        int length = split.length;
        int i = 0;
        boolean z = false;
        while (true) {
            str2 = "media_source";
            if (i < length) {
                String str4 = split[i];
                int indexOf = str4.indexOf(SimpleComparison.EQUAL_TO_OPERATION);
                String substring = indexOf > 0 ? str4.substring(0, indexOf) : str4;
                if (!linkedHashMap.containsKey(substring)) {
                    if (substring.equals(Constants.URL_CAMPAIGN)) {
                        str2 = "campaign";
                    } else if (!substring.equals(Constants.URL_MEDIA_SOURCE)) {
                        if (substring.equals("af_prt")) {
                            z = true;
                            str2 = "agency";
                        }
                        linkedHashMap.put(substring, "");
                    }
                    substring = str2;
                    linkedHashMap.put(substring, "");
                }
                if (indexOf > 0) {
                    int i2 = indexOf + 1;
                    if (str4.length() > i2) {
                        str3 = str4.substring(i2);
                        linkedHashMap.put(substring, str3);
                        i++;
                    }
                }
                str3 = null;
                linkedHashMap.put(substring, str3);
                i++;
            } else {
                try {
                    break;
                } catch (Exception e2) {
                    AFLogger.afErrorLog("Could not fetch install time. ", e2);
                }
            }
        }
        if (!linkedHashMap.containsKey("install_time")) {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            long j = packageInfo.firstInstallTime;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            linkedHashMap.put("install_time", simpleDateFormat.format(new Date(j)));
        }
        if (!linkedHashMap.containsKey("af_status")) {
            linkedHashMap.put("af_status", "Non-organic");
        }
        if (z) {
            linkedHashMap.remove(str2);
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static Map<String, String> m75(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!f38.contains(next)) {
                    String string = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(string) && !"null".equals(string)) {
                        hashMap.put(next, string);
                    }
                }
            }
            return hashMap;
        } catch (JSONException e2) {
            AFLogger.afErrorLog(e2.getMessage(), e2);
            return null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m70(Context context, String str, String str2, String str3, String str4, Intent intent, String str5) {
        Context applicationContext = context.getApplicationContext();
        boolean z = false;
        boolean z2 = str2 == null;
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false) && AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID) == null) {
            z = true;
        }
        if (z) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        if (z2) {
            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
            } else if (m88()) {
                return;
            }
            this.f60 = System.currentTimeMillis();
        }
        m79(AFExecutor.getInstance().m24(), new b(this, new WeakReference(applicationContext), str, str2, str3, str4, false, intent, str5, (byte) 0), 150, TimeUnit.MILLISECONDS);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m88() {
        if (this.f60 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f60;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", Locale.US);
            long j = this.f60;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(new Date(j));
            long j2 = this.f58;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format2 = simpleDateFormat.format(new Date(j2));
            if (currentTimeMillis < this.f59 && !isTrackingStopped()) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{format, format2, Long.valueOf(currentTimeMillis), Long.valueOf(this.f59)}));
                return true;
            } else if (!isTrackingStopped()) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{format, format2, Long.valueOf(currentTimeMillis)}));
            }
        } else if (!isTrackingStopped()) {
            AFLogger.afInfoLog("Sending first launch for this session!");
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x02a5 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02b8 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02eb A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0314 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x031e A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x033f A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x035b A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0392 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03a6 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03b2 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03ba A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03c6 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x03ce A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x03da A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x03e9 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03ea A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0405 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0414 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0423 A[SYNTHETIC, Splitter:B:201:0x0423] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0439 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x044e A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x045f A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0465 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x047c A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0494 A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x04af A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x04dd A[Catch:{ Exception -> 0x02be, Throwable -> 0x025b }] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x04fc A[SYNTHETIC, Splitter:B:237:0x04fc] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0528 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x052e A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x053f  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0546 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x05dd A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x05e8 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0601 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x064d A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0653 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x065e A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x066e A[Catch:{ Exception -> 0x0674 }] */
    /* JADX WARNING: Removed duplicated region for block: B:365:0x0728  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0797 A[Catch:{ Throwable -> 0x07d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x07ea A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x07fa A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x080b A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x0838 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x0843 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x0875 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x087b A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x08a6 A[ADDED_TO_REGION, Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x08b5 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x08e0 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x0906 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x0962 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:448:0x0964 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x098b A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x0999 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:459:0x099b A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:462:0x09d6 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:503:0x0b9a A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:506:0x0bb6 A[Catch:{ all -> 0x0b88, all -> 0x0b7e, NameNotFoundException -> 0x051e, Throwable -> 0x0513, Throwable -> 0x0be0 }] */
    /* renamed from: ˋ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> m93(android.content.Context r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, boolean r29, android.content.SharedPreferences r30, boolean r31, android.content.Intent r32, java.lang.String r33) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r30
            r7 = r31
            java.lang.String r8 = "prev_event_name"
            java.lang.String r9 = "preInstallName"
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            com.appsflyer.internal.r.m177(r2, r10)
            java.util.Date r11 = new java.util.Date
            r11.<init>()
            long r11 = r11.getTime()
            java.lang.String r13 = java.lang.Long.toString(r11)
            java.lang.String r14 = "af_timestamp"
            r10.put(r14, r13)
            java.lang.String r11 = com.appsflyer.internal.b.m132(r2, r11)
            if (r11 == 0) goto L_0x0037
            java.lang.String r12 = "cksm_v1"
            r10.put(r12, r11)
        L_0x0037:
            boolean r11 = r23.isTrackingStopped()     // Catch:{ Throwable -> 0x0be2 }
            if (r11 != 0) goto L_0x0055
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r12 = "******* sendTrackingWithEvent: "
            r11.<init>(r12)     // Catch:{ Throwable -> 0x0be2 }
            if (r7 == 0) goto L_0x0049
            java.lang.String r12 = "Launch"
            goto L_0x004a
        L_0x0049:
            r12 = r4
        L_0x004a:
            r11.append(r12)     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r11 = r11.toString()     // Catch:{ Throwable -> 0x0be2 }
            com.appsflyer.AFLogger.afInfoLog(r11)     // Catch:{ Throwable -> 0x0be2 }
            goto L_0x005a
        L_0x0055:
            java.lang.String r11 = "SDK tracking has been stopped"
            com.appsflyer.AFLogger.afInfoLog(r11)     // Catch:{ Throwable -> 0x0be2 }
        L_0x005a:
            java.lang.String r11 = "AppsFlyer_4.10.0"
            java.lang.String r12 = "EVENT_CREATED_WITH_NAME"
            if (r7 == 0) goto L_0x0063
            java.lang.String r13 = "Launch"
            goto L_0x0064
        L_0x0063:
            r13 = r4
        L_0x0064:
            m69(r2, r11, r12, r13)     // Catch:{ Throwable -> 0x0be2 }
            com.appsflyer.cache.CacheManager r11 = com.appsflyer.cache.CacheManager.getInstance()     // Catch:{ Throwable -> 0x0be2 }
            r11.init(r2)     // Catch:{ Throwable -> 0x0be2 }
            r11 = 0
            android.content.pm.PackageManager r12 = r24.getPackageManager()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r13 = r24.getPackageName()     // Catch:{ Exception -> 0x00b0 }
            r15 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r12 = r12.getPackageInfo(r13, r15)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String[] r12 = r12.requestedPermissions     // Catch:{ Exception -> 0x00b0 }
            java.util.List r12 = java.util.Arrays.asList(r12)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r13 = "android.permission.INTERNET"
            boolean r13 = r12.contains(r13)     // Catch:{ Exception -> 0x00b0 }
            if (r13 != 0) goto L_0x0095
            java.lang.String r13 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r13)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r13 = "PERMISSION_INTERNET_MISSING"
            m69(r2, r11, r13, r11)     // Catch:{ Exception -> 0x00b0 }
        L_0x0095:
            java.lang.String r13 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r13 = r12.contains(r13)     // Catch:{ Exception -> 0x00b0 }
            if (r13 != 0) goto L_0x00a2
            java.lang.String r13 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r13)     // Catch:{ Exception -> 0x00b0 }
        L_0x00a2:
            java.lang.String r13 = "android.permission.ACCESS_WIFI_STATE"
            boolean r12 = r12.contains(r13)     // Catch:{ Exception -> 0x00b0 }
            if (r12 != 0) goto L_0x00b7
            java.lang.String r12 = "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r12)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x00b7
        L_0x00b0:
            r0 = move-exception
            r12 = r0
            java.lang.String r13 = "Exception while validation permissions. "
            com.appsflyer.AFLogger.afErrorLog(r13, r12)     // Catch:{ Throwable -> 0x0be2 }
        L_0x00b7:
            if (r29 == 0) goto L_0x00c0
            java.lang.String r12 = "af_events_api"
            java.lang.String r13 = "1"
            r10.put(r12, r13)     // Catch:{ Throwable -> 0x0be2 }
        L_0x00c0:
            java.lang.String r12 = "brand"
            java.lang.String r13 = android.os.Build.BRAND     // Catch:{ Throwable -> 0x0be2 }
            r10.put(r12, r13)     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r12 = "device"
            java.lang.String r13 = android.os.Build.DEVICE     // Catch:{ Throwable -> 0x0be2 }
            r10.put(r12, r13)     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r12 = "product"
            java.lang.String r13 = android.os.Build.PRODUCT     // Catch:{ Throwable -> 0x0be2 }
            r10.put(r12, r13)     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r12 = "sdk"
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch:{ Throwable -> 0x0be2 }
            r10.put(r12, r13)     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r12 = "model"
            java.lang.String r13 = android.os.Build.MODEL     // Catch:{ Throwable -> 0x0be2 }
            r10.put(r12, r13)     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r12 = "deviceType"
            java.lang.String r13 = android.os.Build.TYPE     // Catch:{ Throwable -> 0x0be2 }
            r10.put(r12, r13)     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r12 = "window"
            java.lang.Object r12 = r2.getSystemService(r12)     // Catch:{ Throwable -> 0x0be2 }
            android.view.WindowManager r12 = (android.view.WindowManager) r12     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r15 = ""
            r11 = 2
            r13 = 1
            if (r12 == 0) goto L_0x011f
            android.view.Display r12 = r12.getDefaultDisplay()     // Catch:{ Throwable -> 0x0be2 }
            int r12 = r12.getRotation()     // Catch:{ Throwable -> 0x0be2 }
            if (r12 == 0) goto L_0x0118
            if (r12 == r13) goto L_0x0115
            if (r12 == r11) goto L_0x0112
            r11 = 3
            if (r12 == r11) goto L_0x010f
            r11 = r15
            goto L_0x011a
        L_0x010f:
            java.lang.String r11 = "lr"
            goto L_0x011a
        L_0x0112:
            java.lang.String r11 = "pr"
            goto L_0x011a
        L_0x0115:
            java.lang.String r11 = "l"
            goto L_0x011a
        L_0x0118:
            java.lang.String r11 = "p"
        L_0x011a:
            java.lang.String r12 = "sc_o"
            r10.put(r12, r11)     // Catch:{ Throwable -> 0x0be2 }
        L_0x011f:
            java.lang.String r11 = "appsFlyerCount"
            java.lang.String r12 = "appsflyer-data"
            r13 = 0
            if (r7 == 0) goto L_0x01db
            android.content.Context r8 = r24.getApplicationContext()     // Catch:{ Throwable -> 0x0be2 }
            android.content.SharedPreferences r8 = r8.getSharedPreferences(r12, r13)     // Catch:{ Throwable -> 0x0be2 }
            boolean r8 = r8.contains(r11)     // Catch:{ Throwable -> 0x0be2 }
            r18 = 1
            r8 = r8 ^ 1
            if (r8 == 0) goto L_0x0152
            com.appsflyer.AppsFlyerProperties r8 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be2 }
            boolean r8 = r8.isOtherSdkStringDisabled()     // Catch:{ Throwable -> 0x0be2 }
            if (r8 != 0) goto L_0x014f
            float r8 = m91(r24)     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r13 = "batteryLevel"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Throwable -> 0x0be2 }
            r10.put(r13, r8)     // Catch:{ Throwable -> 0x0be2 }
        L_0x014f:
            m59((android.content.Context) r24)     // Catch:{ Throwable -> 0x0be2 }
        L_0x0152:
            java.lang.String r8 = "timepassedsincelastlaunch"
            android.content.Context r13 = r24.getApplicationContext()     // Catch:{ Throwable -> 0x0be2 }
            r19 = r14
            r14 = 0
            android.content.SharedPreferences r13 = r13.getSharedPreferences(r12, r14)     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r14 = "AppsFlyerTimePassedSincePrevLaunch"
            r3 = 0
            long r13 = r13.getLong(r14, r3)     // Catch:{ Throwable -> 0x0be2 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0be2 }
            r20 = r15
            java.lang.String r15 = "AppsFlyerTimePassedSincePrevLaunch"
            m68(r2, r15, r3)     // Catch:{ Throwable -> 0x0be2 }
            r16 = 0
            int r15 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r15 <= 0) goto L_0x017d
            long r3 = r3 - r13
            r13 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r13
            goto L_0x017f
        L_0x017d:
            r3 = -1
        L_0x017f:
            java.lang.String r3 = java.lang.Long.toString(r3)     // Catch:{ Throwable -> 0x0be2 }
            r10.put(r8, r3)     // Catch:{ Throwable -> 0x0be2 }
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r4 = "oneLinkSlug"
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Throwable -> 0x0be2 }
            if (r3 == 0) goto L_0x01a6
            java.lang.String r4 = "onelink_id"
            r10.put(r4, r3)     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r3 = "ol_ver"
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r8 = "onelinkVersion"
            java.lang.String r4 = r4.getString(r8)     // Catch:{ Throwable -> 0x0be2 }
            r10.put(r3, r4)     // Catch:{ Throwable -> 0x0be2 }
        L_0x01a6:
            java.lang.String r3 = "appsflyerGetConversionDataTiming"
            r13 = 0
            long r3 = r6.getLong(r3, r13)     // Catch:{ Throwable -> 0x0be2 }
            int r8 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r8 <= 0) goto L_0x01d3
            java.lang.String r8 = "gcd_timing"
            java.lang.String r3 = java.lang.Long.toString(r3)     // Catch:{ Throwable -> 0x0be2 }
            r10.put(r8, r3)     // Catch:{ Throwable -> 0x0be2 }
            java.lang.String r3 = "appsflyerGetConversionDataTiming"
            android.content.SharedPreferences$Editor r4 = r30.edit()     // Catch:{ Throwable -> 0x0be2 }
            r13 = 0
            r4.putLong(r3, r13)     // Catch:{ Throwable -> 0x0be2 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0be2 }
            r8 = 9
            if (r3 < r8) goto L_0x01d0
            r4.apply()     // Catch:{ Throwable -> 0x0be2 }
            goto L_0x01d3
        L_0x01d0:
            r4.commit()     // Catch:{ Throwable -> 0x0be2 }
        L_0x01d3:
            r1 = r26
            r21 = r11
            r22 = r12
            goto L_0x026d
        L_0x01db:
            r19 = r14
            r20 = r15
            android.content.Context r3 = r24.getApplicationContext()     // Catch:{ Throwable -> 0x0be2 }
            r4 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r12, r4)     // Catch:{ Throwable -> 0x0be2 }
            android.content.SharedPreferences$Editor r4 = r3.edit()     // Catch:{ Throwable -> 0x0be2 }
            r13 = 0
            java.lang.String r14 = r3.getString(r8, r13)     // Catch:{ Exception -> 0x0260 }
            java.lang.String r13 = "prev_event_value"
            if (r14 == 0) goto L_0x0236
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x022e }
            r15.<init>()     // Catch:{ Exception -> 0x022e }
            java.lang.String r7 = "prev_event_timestamp"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022e }
            r6.<init>()     // Catch:{ Exception -> 0x022e }
            java.lang.String r1 = "prev_event_timestamp"
            r21 = r11
            r22 = r12
            r11 = -1
            long r11 = r3.getLong(r1, r11)     // Catch:{ Exception -> 0x022c }
            r6.append(r11)     // Catch:{ Exception -> 0x022c }
            java.lang.String r1 = r6.toString()     // Catch:{ Exception -> 0x022c }
            r15.put(r7, r1)     // Catch:{ Exception -> 0x022c }
            r1 = 0
            java.lang.String r3 = r3.getString(r13, r1)     // Catch:{ Exception -> 0x022c }
            r15.put(r13, r3)     // Catch:{ Exception -> 0x022c }
            r15.put(r8, r14)     // Catch:{ Exception -> 0x022c }
            java.lang.String r1 = "prev_event"
            java.lang.String r3 = r15.toString()     // Catch:{ Exception -> 0x022c }
            r10.put(r1, r3)     // Catch:{ Exception -> 0x022c }
            goto L_0x023a
        L_0x022c:
            r0 = move-exception
            goto L_0x0233
        L_0x022e:
            r0 = move-exception
            r21 = r11
            r22 = r12
        L_0x0233:
            r1 = r26
            goto L_0x0267
        L_0x0236:
            r21 = r11
            r22 = r12
        L_0x023a:
            r1 = r26
            r4.putString(r8, r1)     // Catch:{ Exception -> 0x0259 }
            r4.putString(r13, r5)     // Catch:{ Exception -> 0x0259 }
            java.lang.String r3 = "prev_event_timestamp"
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0259 }
            r4.putLong(r3, r6)     // Catch:{ Exception -> 0x0259 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0259 }
            r6 = 9
            if (r3 < r6) goto L_0x0255
            r4.apply()     // Catch:{ Exception -> 0x0259 }
            goto L_0x026d
        L_0x0255:
            r4.commit()     // Catch:{ Exception -> 0x0259 }
            goto L_0x026d
        L_0x0259:
            r0 = move-exception
            goto L_0x0267
        L_0x025b:
            r0 = move-exception
            r7 = r23
            goto L_0x0be4
        L_0x0260:
            r0 = move-exception
            r1 = r26
            r21 = r11
            r22 = r12
        L_0x0267:
            r3 = r0
            java.lang.String r4 = "Error while processing previous event."
            com.appsflyer.AFLogger.afErrorLog(r4, r3)     // Catch:{ Throwable -> 0x025b }
        L_0x026d:
            java.lang.String r3 = "KSAppsFlyerId"
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Throwable -> 0x025b }
            java.lang.String r4 = "KSAppsFlyerRICounter"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r4 = r6.getString(r4)     // Catch:{ Throwable -> 0x025b }
            if (r3 == 0) goto L_0x0299
            if (r4 == 0) goto L_0x0299
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ Throwable -> 0x025b }
            int r6 = r6.intValue()     // Catch:{ Throwable -> 0x025b }
            if (r6 <= 0) goto L_0x0299
            java.lang.String r6 = "reinstallCounter"
            r10.put(r6, r4)     // Catch:{ Throwable -> 0x025b }
            java.lang.String r4 = "originalAppsflyerId"
            r10.put(r4, r3)     // Catch:{ Throwable -> 0x025b }
        L_0x0299:
            java.lang.String r3 = "additionalCustomData"
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Throwable -> 0x025b }
            if (r3 == 0) goto L_0x02aa
            java.lang.String r4 = "customData"
            r10.put(r4, r3)     // Catch:{ Throwable -> 0x025b }
        L_0x02aa:
            android.content.pm.PackageManager r3 = r24.getPackageManager()     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = r24.getPackageName()     // Catch:{ Exception -> 0x02be }
            java.lang.String r3 = r3.getInstallerPackageName(r4)     // Catch:{ Exception -> 0x02be }
            if (r3 == 0) goto L_0x02c5
            java.lang.String r4 = "installer_package"
            r10.put(r4, r3)     // Catch:{ Exception -> 0x02be }
            goto L_0x02c5
        L_0x02be:
            r0 = move-exception
            r3 = r0
            java.lang.String r4 = "Exception while getting the app's installer package. "
            com.appsflyer.AFLogger.afErrorLog(r4, r3)     // Catch:{ Throwable -> 0x025b }
        L_0x02c5:
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r4 = "sdkExtension"
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Throwable -> 0x025b }
            if (r3 == 0) goto L_0x02dc
            int r4 = r3.length()     // Catch:{ Throwable -> 0x025b }
            if (r4 <= 0) goto L_0x02dc
            java.lang.String r4 = "sdkExtension"
            r10.put(r4, r3)     // Catch:{ Throwable -> 0x025b }
        L_0x02dc:
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch:{ Throwable -> 0x025b }
            r3.<init>(r2)     // Catch:{ Throwable -> 0x025b }
            java.lang.String r3 = m57((java.lang.ref.WeakReference<android.content.Context>) r3)     // Catch:{ Throwable -> 0x025b }
            java.lang.String r4 = m42(r2, r3)     // Catch:{ Throwable -> 0x025b }
            if (r4 == 0) goto L_0x02f0
            java.lang.String r6 = "channel"
            r10.put(r6, r4)     // Catch:{ Throwable -> 0x025b }
        L_0x02f0:
            if (r4 == 0) goto L_0x02f8
            boolean r6 = r4.equals(r3)     // Catch:{ Throwable -> 0x025b }
            if (r6 == 0) goto L_0x02fc
        L_0x02f8:
            if (r4 != 0) goto L_0x0301
            if (r3 == 0) goto L_0x0301
        L_0x02fc:
            java.lang.String r4 = "af_latestchannel"
            r10.put(r4, r3)     // Catch:{ Throwable -> 0x025b }
        L_0x0301:
            android.content.Context r3 = r24.getApplicationContext()     // Catch:{ Throwable -> 0x025b }
            r4 = r22
            r6 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r6)     // Catch:{ Throwable -> 0x025b }
            java.lang.String r6 = "INSTALL_STORE"
            boolean r6 = r3.contains(r6)     // Catch:{ Throwable -> 0x025b }
            if (r6 == 0) goto L_0x031e
            java.lang.String r6 = "INSTALL_STORE"
            r7 = 0
            java.lang.String r3 = r3.getString(r6, r7)     // Catch:{ Throwable -> 0x025b }
            r6 = r21
            goto L_0x033d
        L_0x031e:
            android.content.Context r3 = r24.getApplicationContext()     // Catch:{ Throwable -> 0x025b }
            r6 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r6)     // Catch:{ Throwable -> 0x025b }
            r6 = r21
            boolean r3 = r3.contains(r6)     // Catch:{ Throwable -> 0x025b }
            r7 = 1
            r3 = r3 ^ r7
            if (r3 == 0) goto L_0x0337
            java.lang.String r11 = m41(r24)     // Catch:{ Throwable -> 0x025b }
            r3 = r11
            goto L_0x0338
        L_0x0337:
            r3 = 0
        L_0x0338:
            java.lang.String r7 = "INSTALL_STORE"
            m60(r2, r7, r3)     // Catch:{ Throwable -> 0x025b }
        L_0x033d:
            if (r3 == 0) goto L_0x0348
            java.lang.String r7 = "af_installstore"
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ Throwable -> 0x025b }
            r10.put(r7, r3)     // Catch:{ Throwable -> 0x025b }
        L_0x0348:
            android.content.Context r3 = r24.getApplicationContext()     // Catch:{ Throwable -> 0x025b }
            r7 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r7)     // Catch:{ Throwable -> 0x025b }
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r7 = r7.getString(r9)     // Catch:{ Throwable -> 0x025b }
            if (r7 != 0) goto L_0x0403
            boolean r8 = r3.contains(r9)     // Catch:{ Throwable -> 0x025b }
            if (r8 == 0) goto L_0x0369
            r7 = 0
            java.lang.String r3 = r3.getString(r9, r7)     // Catch:{ Throwable -> 0x025b }
            r7 = r3
            goto L_0x03fa
        L_0x0369:
            android.content.Context r3 = r24.getApplicationContext()     // Catch:{ Throwable -> 0x025b }
            r8 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r8)     // Catch:{ Throwable -> 0x025b }
            boolean r3 = r3.contains(r6)     // Catch:{ Throwable -> 0x025b }
            r8 = 1
            r3 = r3 ^ r8
            if (r3 == 0) goto L_0x03f5
            java.lang.String r3 = "ro.appsflyer.preinstall.path"
            java.lang.String r3 = m80((java.lang.String) r3)     // Catch:{ Throwable -> 0x025b }
            java.io.File r3 = m56((java.lang.String) r3)     // Catch:{ Throwable -> 0x025b }
            if (r3 == 0) goto L_0x038f
            boolean r7 = r3.exists()     // Catch:{ Throwable -> 0x025b }
            if (r7 != 0) goto L_0x038d
            goto L_0x038f
        L_0x038d:
            r7 = 0
            goto L_0x0390
        L_0x038f:
            r7 = 1
        L_0x0390:
            if (r7 == 0) goto L_0x03a4
            java.lang.String r3 = "AF_PRE_INSTALL_PATH"
            android.content.pm.PackageManager r7 = r24.getPackageManager()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r8 = r24.getPackageName()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r3 = m48((java.lang.String) r3, (android.content.pm.PackageManager) r7, (java.lang.String) r8)     // Catch:{ Throwable -> 0x025b }
            java.io.File r3 = m56((java.lang.String) r3)     // Catch:{ Throwable -> 0x025b }
        L_0x03a4:
            if (r3 == 0) goto L_0x03af
            boolean r7 = r3.exists()     // Catch:{ Throwable -> 0x025b }
            if (r7 != 0) goto L_0x03ad
            goto L_0x03af
        L_0x03ad:
            r7 = 0
            goto L_0x03b0
        L_0x03af:
            r7 = 1
        L_0x03b0:
            if (r7 == 0) goto L_0x03b8
            java.lang.String r3 = "/data/local/tmp/pre_install.appsflyer"
            java.io.File r3 = m56((java.lang.String) r3)     // Catch:{ Throwable -> 0x025b }
        L_0x03b8:
            if (r3 == 0) goto L_0x03c3
            boolean r7 = r3.exists()     // Catch:{ Throwable -> 0x025b }
            if (r7 != 0) goto L_0x03c1
            goto L_0x03c3
        L_0x03c1:
            r7 = 0
            goto L_0x03c4
        L_0x03c3:
            r7 = 1
        L_0x03c4:
            if (r7 == 0) goto L_0x03cc
            java.lang.String r3 = "/etc/pre_install.appsflyer"
            java.io.File r3 = m56((java.lang.String) r3)     // Catch:{ Throwable -> 0x025b }
        L_0x03cc:
            if (r3 == 0) goto L_0x03d7
            boolean r7 = r3.exists()     // Catch:{ Throwable -> 0x025b }
            if (r7 != 0) goto L_0x03d5
            goto L_0x03d7
        L_0x03d5:
            r7 = 0
            goto L_0x03d8
        L_0x03d7:
            r7 = 1
        L_0x03d8:
            if (r7 != 0) goto L_0x03e6
            java.lang.String r7 = r24.getPackageName()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r11 = m47((java.io.File) r3, (java.lang.String) r7)     // Catch:{ Throwable -> 0x025b }
            if (r11 == 0) goto L_0x03e6
            r7 = r11
            goto L_0x03e7
        L_0x03e6:
            r7 = 0
        L_0x03e7:
            if (r7 == 0) goto L_0x03ea
            goto L_0x03f5
        L_0x03ea:
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch:{ Throwable -> 0x025b }
            r3.<init>(r2)     // Catch:{ Throwable -> 0x025b }
            java.lang.String r7 = "AF_PRE_INSTALL_NAME"
            java.lang.String r7 = m58((java.lang.ref.WeakReference<android.content.Context>) r3, (java.lang.String) r7)     // Catch:{ Throwable -> 0x025b }
        L_0x03f5:
            if (r7 == 0) goto L_0x03fa
            m60(r2, r9, r7)     // Catch:{ Throwable -> 0x025b }
        L_0x03fa:
            if (r7 == 0) goto L_0x0403
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            r3.set((java.lang.String) r9, (java.lang.String) r7)     // Catch:{ Throwable -> 0x025b }
        L_0x0403:
            if (r7 == 0) goto L_0x040e
            java.lang.String r3 = "af_preinstall_name"
            java.lang.String r7 = r7.toLowerCase()     // Catch:{ Throwable -> 0x025b }
            r10.put(r3, r7)     // Catch:{ Throwable -> 0x025b }
        L_0x040e:
            java.lang.String r3 = m41(r24)     // Catch:{ Throwable -> 0x025b }
            if (r3 == 0) goto L_0x041d
            java.lang.String r7 = "af_currentstore"
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ Throwable -> 0x025b }
            r10.put(r7, r3)     // Catch:{ Throwable -> 0x025b }
        L_0x041d:
            java.lang.String r3 = "appsflyerKey"
            r7 = r25
            if (r7 == 0) goto L_0x042d
            int r8 = r25.length()     // Catch:{ Throwable -> 0x025b }
            if (r8 <= 0) goto L_0x042d
            r10.put(r3, r7)     // Catch:{ Throwable -> 0x025b }
            goto L_0x0442
        L_0x042d:
            java.lang.String r7 = "AppsFlyerKey"
            com.appsflyer.AppsFlyerProperties r8 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r7 = r8.getString(r7)     // Catch:{ Throwable -> 0x025b }
            if (r7 == 0) goto L_0x0bcb
            int r8 = r7.length()     // Catch:{ Throwable -> 0x025b }
            if (r8 <= 0) goto L_0x0bcb
            r10.put(r3, r7)     // Catch:{ Throwable -> 0x025b }
        L_0x0442:
            java.lang.String r7 = "AppUserId"
            com.appsflyer.AppsFlyerProperties r8 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r7 = r8.getString(r7)     // Catch:{ Throwable -> 0x025b }
            if (r7 == 0) goto L_0x0453
            java.lang.String r8 = "appUserId"
            r10.put(r8, r7)     // Catch:{ Throwable -> 0x025b }
        L_0x0453:
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r8 = "userEmails"
            java.lang.String r7 = r7.getString(r8)     // Catch:{ Throwable -> 0x025b }
            if (r7 == 0) goto L_0x0465
            java.lang.String r8 = "user_emails"
            r10.put(r8, r7)     // Catch:{ Throwable -> 0x025b }
            goto L_0x047a
        L_0x0465:
            java.lang.String r7 = "userEmail"
            com.appsflyer.AppsFlyerProperties r8 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r7 = r8.getString(r7)     // Catch:{ Throwable -> 0x025b }
            if (r7 == 0) goto L_0x047a
            java.lang.String r8 = "sha1_el"
            java.lang.String r7 = com.appsflyer.internal.y.m213(r7)     // Catch:{ Throwable -> 0x025b }
            r10.put(r8, r7)     // Catch:{ Throwable -> 0x025b }
        L_0x047a:
            if (r1 == 0) goto L_0x0488
            java.lang.String r7 = "eventName"
            r10.put(r7, r1)     // Catch:{ Throwable -> 0x025b }
            if (r5 == 0) goto L_0x0488
            java.lang.String r7 = "eventValue"
            r10.put(r7, r5)     // Catch:{ Throwable -> 0x025b }
        L_0x0488:
            java.lang.String r5 = "appid"
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r5 = r7.getString(r5)     // Catch:{ Throwable -> 0x025b }
            if (r5 == 0) goto L_0x04a3
            java.lang.String r5 = "appid"
            java.lang.String r7 = "appid"
            com.appsflyer.AppsFlyerProperties r8 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r7 = r8.getString(r7)     // Catch:{ Throwable -> 0x025b }
            r10.put(r5, r7)     // Catch:{ Throwable -> 0x025b }
        L_0x04a3:
            java.lang.String r5 = "currencyCode"
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r5 = r7.getString(r5)     // Catch:{ Throwable -> 0x025b }
            if (r5 == 0) goto L_0x04d1
            int r7 = r5.length()     // Catch:{ Throwable -> 0x025b }
            r8 = 3
            if (r7 == r8) goto L_0x04cc
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x025b }
            java.lang.String r8 = "WARNING: currency code should be 3 characters!!! '"
            r7.<init>(r8)     // Catch:{ Throwable -> 0x025b }
            r7.append(r5)     // Catch:{ Throwable -> 0x025b }
            java.lang.String r8 = "' is not a legal value."
            r7.append(r8)     // Catch:{ Throwable -> 0x025b }
            java.lang.String r7 = r7.toString()     // Catch:{ Throwable -> 0x025b }
            com.appsflyer.AFLogger.afWarnLog(r7)     // Catch:{ Throwable -> 0x025b }
        L_0x04cc:
            java.lang.String r7 = "currency"
            r10.put(r7, r5)     // Catch:{ Throwable -> 0x025b }
        L_0x04d1:
            java.lang.String r5 = "IS_UPDATE"
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r5 = r7.getString(r5)     // Catch:{ Throwable -> 0x025b }
            if (r5 == 0) goto L_0x04e2
            java.lang.String r7 = "isUpdate"
            r10.put(r7, r5)     // Catch:{ Throwable -> 0x025b }
        L_0x04e2:
            boolean r5 = r23.isPreInstalledApp(r24)     // Catch:{ Throwable -> 0x025b }
            java.lang.String r7 = "af_preinstalled"
            java.lang.String r5 = java.lang.Boolean.toString(r5)     // Catch:{ Throwable -> 0x025b }
            r10.put(r7, r5)     // Catch:{ Throwable -> 0x025b }
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x025b }
            java.lang.String r7 = "collectFacebookAttrId"
            r8 = 1
            boolean r5 = r5.getBoolean(r7, r8)     // Catch:{ Throwable -> 0x025b }
            if (r5 == 0) goto L_0x052e
            android.content.pm.PackageManager r5 = r24.getPackageManager()     // Catch:{ NameNotFoundException -> 0x051e, Throwable -> 0x0513 }
            java.lang.String r7 = "com.facebook.katana"
            r8 = 0
            r5.getApplicationInfo(r7, r8)     // Catch:{ NameNotFoundException -> 0x051e, Throwable -> 0x0513 }
            android.content.ContentResolver r5 = r24.getContentResolver()     // Catch:{ NameNotFoundException -> 0x051e, Throwable -> 0x0513 }
            r7 = r23
            java.lang.String r11 = r7.getAttributionId(r5)     // Catch:{ NameNotFoundException -> 0x0520, Throwable -> 0x0511 }
            goto L_0x0526
        L_0x0511:
            r0 = move-exception
            goto L_0x0516
        L_0x0513:
            r0 = move-exception
            r7 = r23
        L_0x0516:
            r5 = r0
            java.lang.String r8 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.afErrorLog(r8, r5)     // Catch:{ Throwable -> 0x0be0 }
        L_0x051c:
            r11 = 0
            goto L_0x0526
        L_0x051e:
            r7 = r23
        L_0x0520:
            java.lang.String r5 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.afWarnLog(r5)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x051c
        L_0x0526:
            if (r11 == 0) goto L_0x0530
            java.lang.String r5 = "fb"
            r10.put(r5, r11)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x0530
        L_0x052e:
            r7 = r23
        L_0x0530:
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r8 = "deviceTrackingDisabled"
            r9 = 0
            boolean r5 = r5.getBoolean(r8, r9)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r8 = "true"
            if (r5 == 0) goto L_0x0546
            java.lang.String r5 = "deviceTrackingDisabled"
            r10.put(r5, r8)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x0663
        L_0x0546:
            android.content.Context r5 = r24.getApplicationContext()     // Catch:{ Throwable -> 0x0be0 }
            r9 = 0
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r4, r9)     // Catch:{ Throwable -> 0x0be0 }
            com.appsflyer.AppsFlyerProperties r9 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r11 = "collectIMEI"
            r12 = 1
            boolean r9 = r9.getBoolean(r11, r12)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r11 = "imeiCached"
            r12 = 0
            java.lang.String r11 = r5.getString(r11, r12)     // Catch:{ Throwable -> 0x0be0 }
            if (r9 == 0) goto L_0x05d3
            java.lang.String r9 = r7.f56     // Catch:{ Throwable -> 0x0be0 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Throwable -> 0x0be0 }
            if (r9 == 0) goto L_0x05d3
            boolean r9 = m40(r24)     // Catch:{ Throwable -> 0x0be0 }
            if (r9 == 0) goto L_0x05da
            java.lang.String r9 = "phone"
            java.lang.Object r9 = r2.getSystemService(r9)     // Catch:{ InvocationTargetException -> 0x05bb, Exception -> 0x05a2 }
            android.telephony.TelephonyManager r9 = (android.telephony.TelephonyManager) r9     // Catch:{ InvocationTargetException -> 0x05bb, Exception -> 0x05a2 }
            java.lang.Class r12 = r9.getClass()     // Catch:{ InvocationTargetException -> 0x05bb, Exception -> 0x05a2 }
            java.lang.String r13 = "getDeviceId"
            r14 = 0
            java.lang.Class[] r15 = new java.lang.Class[r14]     // Catch:{ InvocationTargetException -> 0x05bb, Exception -> 0x05a2 }
            java.lang.reflect.Method r12 = r12.getMethod(r13, r15)     // Catch:{ InvocationTargetException -> 0x05bb, Exception -> 0x05a2 }
            java.lang.Object[] r13 = new java.lang.Object[r14]     // Catch:{ InvocationTargetException -> 0x05bb, Exception -> 0x05a2 }
            java.lang.Object r9 = r12.invoke(r9, r13)     // Catch:{ InvocationTargetException -> 0x05bb, Exception -> 0x05a2 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ InvocationTargetException -> 0x05bb, Exception -> 0x05a2 }
            if (r9 == 0) goto L_0x0592
            r11 = r9
            goto L_0x05db
        L_0x0592:
            if (r11 == 0) goto L_0x05da
            java.lang.String r9 = "use cached IMEI: "
            java.lang.String r12 = java.lang.String.valueOf(r11)     // Catch:{ InvocationTargetException -> 0x05bb, Exception -> 0x05a2 }
            java.lang.String r9 = r9.concat(r12)     // Catch:{ InvocationTargetException -> 0x05bb, Exception -> 0x05a2 }
            com.appsflyer.AFLogger.afDebugLog(r9)     // Catch:{ InvocationTargetException -> 0x05bb, Exception -> 0x05a2 }
            goto L_0x05db
        L_0x05a2:
            r0 = move-exception
            r9 = r0
            if (r11 == 0) goto L_0x05b4
            java.lang.String r12 = "use cached IMEI: "
            java.lang.String r13 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r12 = r12.concat(r13)     // Catch:{ Throwable -> 0x0be0 }
            com.appsflyer.AFLogger.afDebugLog(r12)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x05b5
        L_0x05b4:
            r11 = 0
        L_0x05b5:
            java.lang.String r12 = "WARNING: other reason: "
            com.appsflyer.AFLogger.afErrorLog(r12, r9)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x05db
        L_0x05bb:
            if (r11 == 0) goto L_0x05cc
            java.lang.String r9 = "use cached IMEI: "
            java.lang.String r12 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r9 = r9.concat(r12)     // Catch:{ Throwable -> 0x0be0 }
            com.appsflyer.AFLogger.afDebugLog(r9)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x05cd
        L_0x05cc:
            r11 = 0
        L_0x05cd:
            java.lang.String r9 = "WARNING: READ_PHONE_STATE is missing."
            com.appsflyer.AFLogger.afWarnLog(r9)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x05db
        L_0x05d3:
            java.lang.String r9 = r7.f56     // Catch:{ Throwable -> 0x0be0 }
            if (r9 == 0) goto L_0x05da
            java.lang.String r11 = r7.f56     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x05db
        L_0x05da:
            r11 = 0
        L_0x05db:
            if (r11 == 0) goto L_0x05e8
            java.lang.String r9 = "imeiCached"
            m60(r2, r9, r11)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r9 = "imei"
            r10.put(r9, r11)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x05ed
        L_0x05e8:
            java.lang.String r9 = "IMEI was not collected."
            com.appsflyer.AFLogger.afInfoLog(r9)     // Catch:{ Throwable -> 0x0be0 }
        L_0x05ed:
            com.appsflyer.AppsFlyerProperties r9 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r11 = "collectAndroidId"
            r12 = 1
            boolean r9 = r9.getBoolean(r11, r12)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r11 = "androidIdCached"
            r12 = 0
            java.lang.String r5 = r5.getString(r11, r12)     // Catch:{ Throwable -> 0x0be0 }
            if (r9 == 0) goto L_0x0649
            java.lang.String r9 = r7.f50     // Catch:{ Throwable -> 0x0be0 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Throwable -> 0x0be0 }
            if (r9 == 0) goto L_0x0649
            boolean r9 = m40(r24)     // Catch:{ Throwable -> 0x0be0 }
            if (r9 == 0) goto L_0x0650
            android.content.ContentResolver r9 = r24.getContentResolver()     // Catch:{ Exception -> 0x062d }
            java.lang.String r11 = "android_id"
            java.lang.String r11 = android.provider.Settings.Secure.getString(r9, r11)     // Catch:{ Exception -> 0x062d }
            if (r11 == 0) goto L_0x061c
            goto L_0x0651
        L_0x061c:
            if (r5 == 0) goto L_0x0650
            java.lang.String r9 = "use cached AndroidId: "
            java.lang.String r11 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x062d }
            java.lang.String r9 = r9.concat(r11)     // Catch:{ Exception -> 0x062d }
            com.appsflyer.AFLogger.afDebugLog(r9)     // Catch:{ Exception -> 0x062d }
            r11 = r5
            goto L_0x0651
        L_0x062d:
            r0 = move-exception
            r9 = r0
            if (r5 == 0) goto L_0x0640
            java.lang.String r11 = "use cached AndroidId: "
            java.lang.String r12 = java.lang.String.valueOf(r5)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r11 = r11.concat(r12)     // Catch:{ Throwable -> 0x0be0 }
            com.appsflyer.AFLogger.afDebugLog(r11)     // Catch:{ Throwable -> 0x0be0 }
            r11 = r5
            goto L_0x0641
        L_0x0640:
            r11 = 0
        L_0x0641:
            java.lang.String r5 = r9.getMessage()     // Catch:{ Throwable -> 0x0be0 }
            com.appsflyer.AFLogger.afErrorLog(r5, r9)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x0651
        L_0x0649:
            java.lang.String r5 = r7.f50     // Catch:{ Throwable -> 0x0be0 }
            if (r5 == 0) goto L_0x0650
            java.lang.String r11 = r7.f50     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x0651
        L_0x0650:
            r11 = 0
        L_0x0651:
            if (r11 == 0) goto L_0x065e
            java.lang.String r5 = "androidIdCached"
            m60(r2, r5, r11)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r5 = "android_id"
            r10.put(r5, r11)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x0663
        L_0x065e:
            java.lang.String r5 = "Android ID was not collected."
            com.appsflyer.AFLogger.afInfoLog(r5)     // Catch:{ Throwable -> 0x0be0 }
        L_0x0663:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x0674 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0674 }
            java.lang.String r5 = com.appsflyer.internal.u.m186(r5)     // Catch:{ Exception -> 0x0674 }
            if (r5 == 0) goto L_0x068b
            java.lang.String r9 = "uid"
            r10.put(r9, r5)     // Catch:{ Exception -> 0x0674 }
            goto L_0x068b
        L_0x0674:
            r0 = move-exception
            r5 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r11 = "ERROR: could not get uid "
            r9.<init>(r11)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r11 = r5.getMessage()     // Catch:{ Throwable -> 0x0be0 }
            r9.append(r11)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r9 = r9.toString()     // Catch:{ Throwable -> 0x0be0 }
            com.appsflyer.AFLogger.afErrorLog(r9, r5)     // Catch:{ Throwable -> 0x0be0 }
        L_0x068b:
            java.lang.String r5 = "lang"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0699 }
            java.lang.String r9 = r9.getDisplayLanguage()     // Catch:{ Exception -> 0x0699 }
            r10.put(r5, r9)     // Catch:{ Exception -> 0x0699 }
            goto L_0x06a0
        L_0x0699:
            r0 = move-exception
            r5 = r0
            java.lang.String r9 = "Exception while collecting display language name. "
            com.appsflyer.AFLogger.afErrorLog(r9, r5)     // Catch:{ Throwable -> 0x0be0 }
        L_0x06a0:
            java.lang.String r5 = "lang_code"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x06ae }
            java.lang.String r9 = r9.getLanguage()     // Catch:{ Exception -> 0x06ae }
            r10.put(r5, r9)     // Catch:{ Exception -> 0x06ae }
            goto L_0x06b5
        L_0x06ae:
            r0 = move-exception
            r5 = r0
            java.lang.String r9 = "Exception while collecting display language code. "
            com.appsflyer.AFLogger.afErrorLog(r9, r5)     // Catch:{ Throwable -> 0x0be0 }
        L_0x06b5:
            java.lang.String r5 = "country"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x06c3 }
            java.lang.String r9 = r9.getCountry()     // Catch:{ Exception -> 0x06c3 }
            r10.put(r5, r9)     // Catch:{ Exception -> 0x06c3 }
            goto L_0x06ca
        L_0x06c3:
            r0 = move-exception
            r5 = r0
            java.lang.String r9 = "Exception while collecting country name. "
            com.appsflyer.AFLogger.afErrorLog(r9, r5)     // Catch:{ Throwable -> 0x0be0 }
        L_0x06ca:
            java.lang.String r5 = "platformextension"
            com.appsflyer.internal.w r9 = r7.f53     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r9 = r9.m194()     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r5, r9)     // Catch:{ Throwable -> 0x0be0 }
            m61((android.content.Context) r2, (java.util.Map<java.lang.String, ? super java.lang.String>) r10)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r5 = "yyyy-MM-dd_HHmmssZ"
            java.text.SimpleDateFormat r9 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x0be0 }
            java.util.Locale r11 = java.util.Locale.US     // Catch:{ Throwable -> 0x0be0 }
            r9.<init>(r5, r11)     // Catch:{ Throwable -> 0x0be0 }
            android.content.pm.PackageManager r5 = r24.getPackageManager()     // Catch:{ Exception -> 0x0708 }
            java.lang.String r11 = r24.getPackageName()     // Catch:{ Exception -> 0x0708 }
            r12 = 0
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r11, r12)     // Catch:{ Exception -> 0x0708 }
            long r11 = r5.firstInstallTime     // Catch:{ Exception -> 0x0708 }
            java.lang.String r5 = "installDate"
            java.lang.String r13 = "UTC"
            java.util.TimeZone r13 = java.util.TimeZone.getTimeZone(r13)     // Catch:{ Exception -> 0x0708 }
            r9.setTimeZone(r13)     // Catch:{ Exception -> 0x0708 }
            java.util.Date r13 = new java.util.Date     // Catch:{ Exception -> 0x0708 }
            r13.<init>(r11)     // Catch:{ Exception -> 0x0708 }
            java.lang.String r11 = r9.format(r13)     // Catch:{ Exception -> 0x0708 }
            r10.put(r5, r11)     // Catch:{ Exception -> 0x0708 }
            goto L_0x070f
        L_0x0708:
            r0 = move-exception
            r5 = r0
            java.lang.String r11 = "Exception while collecting install date. "
            com.appsflyer.AFLogger.afErrorLog(r11, r5)     // Catch:{ Throwable -> 0x0be0 }
        L_0x070f:
            android.content.pm.PackageManager r5 = r24.getPackageManager()     // Catch:{ Throwable -> 0x07d7 }
            java.lang.String r11 = r24.getPackageName()     // Catch:{ Throwable -> 0x07d7 }
            r12 = 0
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r11, r12)     // Catch:{ Throwable -> 0x07d7 }
            java.lang.String r11 = "versionCode"
            r13 = r30
            int r11 = r13.getInt(r11, r12)     // Catch:{ Throwable -> 0x07d5 }
            int r14 = r5.versionCode     // Catch:{ Throwable -> 0x07d5 }
            if (r14 <= r11) goto L_0x073d
            java.lang.String r11 = "appsflyerConversionDataRequestRetries"
            m77((android.content.Context) r2, (java.lang.String) r11, (int) r12)     // Catch:{ Throwable -> 0x0735 }
            java.lang.String r11 = "versionCode"
            int r12 = r5.versionCode     // Catch:{ Throwable -> 0x0735 }
            m77((android.content.Context) r2, (java.lang.String) r11, (int) r12)     // Catch:{ Throwable -> 0x0735 }
            goto L_0x073d
        L_0x0735:
            r0 = move-exception
            r1 = r0
            r21 = r3
            r25 = r8
            goto L_0x07df
        L_0x073d:
            java.lang.String r11 = "app_version_code"
            int r12 = r5.versionCode     // Catch:{ Throwable -> 0x07d5 }
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ Throwable -> 0x07d5 }
            r10.put(r11, r12)     // Catch:{ Throwable -> 0x07d5 }
            java.lang.String r11 = "app_version_name"
            java.lang.String r12 = r5.versionName     // Catch:{ Throwable -> 0x07d5 }
            r10.put(r11, r12)     // Catch:{ Throwable -> 0x07d5 }
            long r11 = r5.firstInstallTime     // Catch:{ Throwable -> 0x07d5 }
            long r14 = r5.lastUpdateTime     // Catch:{ Throwable -> 0x07d5 }
            java.lang.String r5 = "date1"
            r21 = r3
            java.lang.String r3 = "yyyy-MM-dd_HHmmssZ"
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x07d3 }
            r25 = r8
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ Throwable -> 0x07d1 }
            r1.<init>(r3, r8)     // Catch:{ Throwable -> 0x07d1 }
            java.util.Date r3 = new java.util.Date     // Catch:{ Throwable -> 0x07d1 }
            r3.<init>(r11)     // Catch:{ Throwable -> 0x07d1 }
            java.lang.String r1 = r1.format(r3)     // Catch:{ Throwable -> 0x07d1 }
            r10.put(r5, r1)     // Catch:{ Throwable -> 0x07d1 }
            java.lang.String r1 = "date2"
            java.lang.String r3 = "yyyy-MM-dd_HHmmssZ"
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x07d1 }
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ Throwable -> 0x07d1 }
            r5.<init>(r3, r8)     // Catch:{ Throwable -> 0x07d1 }
            java.util.Date r3 = new java.util.Date     // Catch:{ Throwable -> 0x07d1 }
            r3.<init>(r14)     // Catch:{ Throwable -> 0x07d1 }
            java.lang.String r3 = r5.format(r3)     // Catch:{ Throwable -> 0x07d1 }
            r10.put(r1, r3)     // Catch:{ Throwable -> 0x07d1 }
            android.content.Context r1 = r24.getApplicationContext()     // Catch:{ Throwable -> 0x07d1 }
            r3 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r4, r3)     // Catch:{ Throwable -> 0x07d1 }
            java.lang.String r5 = "appsFlyerFirstInstall"
            r8 = 0
            java.lang.String r1 = r1.getString(r5, r8)     // Catch:{ Throwable -> 0x07d1 }
            if (r1 != 0) goto L_0x07be
            android.content.Context r1 = r24.getApplicationContext()     // Catch:{ Throwable -> 0x07d1 }
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r4, r3)     // Catch:{ Throwable -> 0x07d1 }
            boolean r1 = r1.contains(r6)     // Catch:{ Throwable -> 0x07d1 }
            r3 = 1
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x07b7
            java.lang.String r1 = "AppsFlyer: first launch detected"
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ Throwable -> 0x07d1 }
            java.util.Date r1 = new java.util.Date     // Catch:{ Throwable -> 0x07d1 }
            r1.<init>()     // Catch:{ Throwable -> 0x07d1 }
            java.lang.String r15 = r9.format(r1)     // Catch:{ Throwable -> 0x07d1 }
            r1 = r15
            goto L_0x07b9
        L_0x07b7:
            r1 = r20
        L_0x07b9:
            java.lang.String r3 = "appsFlyerFirstInstall"
            m60(r2, r3, r1)     // Catch:{ Throwable -> 0x07d1 }
        L_0x07be:
            java.lang.String r3 = "AppsFlyer: first launch date: "
            java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x07d1 }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ Throwable -> 0x07d1 }
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ Throwable -> 0x07d1 }
            java.lang.String r3 = "firstLaunchDate"
            r10.put(r3, r1)     // Catch:{ Throwable -> 0x07d1 }
            goto L_0x07e4
        L_0x07d1:
            r0 = move-exception
            goto L_0x07de
        L_0x07d3:
            r0 = move-exception
            goto L_0x07dc
        L_0x07d5:
            r0 = move-exception
            goto L_0x07da
        L_0x07d7:
            r0 = move-exception
            r13 = r30
        L_0x07da:
            r21 = r3
        L_0x07dc:
            r25 = r8
        L_0x07de:
            r1 = r0
        L_0x07df:
            java.lang.String r3 = "Exception while collecting app version data "
            com.appsflyer.AFLogger.afErrorLog(r3, r1)     // Catch:{ Throwable -> 0x0be0 }
        L_0x07e4:
            int r1 = r28.length()     // Catch:{ Throwable -> 0x0be0 }
            if (r1 <= 0) goto L_0x07f1
            java.lang.String r1 = "referrer"
            r3 = r28
            r10.put(r1, r3)     // Catch:{ Throwable -> 0x0be0 }
        L_0x07f1:
            java.lang.String r1 = "extraReferrers"
            r3 = 0
            java.lang.String r1 = r13.getString(r1, r3)     // Catch:{ Throwable -> 0x0be0 }
            if (r1 == 0) goto L_0x07ff
            java.lang.String r3 = "extraReferrers"
            r10.put(r3, r1)     // Catch:{ Throwable -> 0x0be0 }
        L_0x07ff:
            java.lang.String r1 = "afUninstallToken"
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r1 = r3.getString(r1)     // Catch:{ Throwable -> 0x0be0 }
            if (r1 == 0) goto L_0x0816
            com.appsflyer.internal.b$b$a r1 = com.appsflyer.internal.b.C0090b.a.m140((java.lang.String) r1)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = "af_gcm_token"
            java.lang.String r1 = r1.f151     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r3, r1)     // Catch:{ Throwable -> 0x0be0 }
        L_0x0816:
            boolean r1 = com.appsflyer.internal.v.m187(r24)     // Catch:{ Throwable -> 0x0be0 }
            boolean r3 = com.appsflyer.internal.v.m189(r24)     // Catch:{ Throwable -> 0x0be0 }
            r1 = r1 | r3
            r7.f54 = r1     // Catch:{ Throwable -> 0x0be0 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = "didConfigureTokenRefreshService="
            r1.<init>(r3)     // Catch:{ Throwable -> 0x0be0 }
            boolean r3 = r7.f54     // Catch:{ Throwable -> 0x0be0 }
            r1.append(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0be0 }
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ Throwable -> 0x0be0 }
            boolean r1 = r7.f54     // Catch:{ Throwable -> 0x0be0 }
            if (r1 != 0) goto L_0x083f
            java.lang.String r1 = "tokenRefreshConfigured"
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r1, r3)     // Catch:{ Throwable -> 0x0be0 }
        L_0x083f:
            r1 = r31
            if (r1 == 0) goto L_0x0875
            com.appsflyer.AFDeepLinkManager r3 = com.appsflyer.AFDeepLinkManager.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            r4 = r32
            r3.processIntentForDeepLink(r4, r2, r10)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = r7.f46     // Catch:{ Throwable -> 0x0be0 }
            if (r3 == 0) goto L_0x0868
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r4 = r7.f46     // Catch:{ Throwable -> 0x0be0 }
            r3.<init>(r4)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r4 = "isPush"
            r5 = r25
            r3.put(r4, r5)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r4 = "af_deeplink"
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r4, r3)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x086a
        L_0x0868:
            r5 = r25
        L_0x086a:
            r3 = 0
            r7.f46 = r3     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = "open_referrer"
            r4 = r33
            r10.put(r3, r4)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x0877
        L_0x0875:
            r5 = r25
        L_0x0877:
            boolean r3 = r7.f49     // Catch:{ Throwable -> 0x0be0 }
            if (r3 == 0) goto L_0x0891
            java.lang.String r3 = "testAppMode_retargeting"
            r10.put(r3, r5)     // Catch:{ Throwable -> 0x0be0 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0be0 }
            r3.<init>(r10)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0be0 }
            m52((android.content.Context) r2, (java.lang.String) r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = "Sent retargeting params to test app"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ Throwable -> 0x0be0 }
        L_0x0891:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0be0 }
            long r8 = r7.f47     // Catch:{ Throwable -> 0x0be0 }
            long r3 = r3 - r8
            com.appsflyer.AppsFlyerProperties r8 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r8 = r8.getReferrer(r2)     // Catch:{ Throwable -> 0x0be0 }
            r11 = 30000(0x7530, double:1.4822E-319)
            int r9 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r9 > 0) goto L_0x08b2
            if (r8 == 0) goto L_0x08b2
            java.lang.String r3 = "AppsFlyer_Test"
            boolean r3 = r8.contains(r3)     // Catch:{ Throwable -> 0x0be0 }
            if (r3 == 0) goto L_0x08b2
            r3 = 1
            goto L_0x08b3
        L_0x08b2:
            r3 = 0
        L_0x08b3:
            if (r3 == 0) goto L_0x08d4
            java.lang.String r3 = "testAppMode"
            r10.put(r3, r5)     // Catch:{ Throwable -> 0x0be0 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0be0 }
            r3.<init>(r10)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0be0 }
            m52((android.content.Context) r2, (java.lang.String) r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = "Sent params to test app"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = "Test mode ended!"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ Throwable -> 0x0be0 }
            r3 = 0
            r7.f47 = r3     // Catch:{ Throwable -> 0x0be0 }
        L_0x08d4:
            java.lang.String r3 = "advertiserId"
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Throwable -> 0x0be0 }
            if (r3 != 0) goto L_0x08fc
            com.appsflyer.internal.r.m177(r2, r10)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = "advertiserId"
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Throwable -> 0x0be0 }
            if (r3 == 0) goto L_0x08f5
            java.lang.String r3 = "GAID_retry"
            r10.put(r3, r5)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x08fc
        L_0x08f5:
            java.lang.String r3 = "GAID_retry"
            java.lang.String r4 = "false"
            r10.put(r3, r4)     // Catch:{ Throwable -> 0x0be0 }
        L_0x08fc:
            android.content.ContentResolver r3 = r24.getContentResolver()     // Catch:{ Throwable -> 0x0be0 }
            com.appsflyer.internal.n r3 = com.appsflyer.internal.r.m178(r3)     // Catch:{ Throwable -> 0x0be0 }
            if (r3 == 0) goto L_0x0918
            java.lang.String r4 = "amazon_aid"
            java.lang.String r8 = r3.f202     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r4, r8)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r4 = "amazon_aid_limit"
            boolean r3 = r3.f203     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r4, r3)     // Catch:{ Throwable -> 0x0be0 }
        L_0x0918:
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = r3.getReferrer(r2)     // Catch:{ Throwable -> 0x0be0 }
            if (r3 == 0) goto L_0x0935
            int r4 = r3.length()     // Catch:{ Throwable -> 0x0be0 }
            if (r4 <= 0) goto L_0x0935
            java.lang.String r4 = "referrer"
            java.lang.Object r4 = r10.get(r4)     // Catch:{ Throwable -> 0x0be0 }
            if (r4 != 0) goto L_0x0935
            java.lang.String r4 = "referrer"
            r10.put(r4, r3)     // Catch:{ Throwable -> 0x0be0 }
        L_0x0935:
            java.lang.String r3 = "sentSuccessfully"
            r4 = r20
            java.lang.String r3 = r13.getString(r3, r4)     // Catch:{ Throwable -> 0x0be0 }
            boolean r3 = r5.equals(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r4 = "sentRegisterRequestToAF"
            r5 = 0
            boolean r4 = r13.getBoolean(r4, r5)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r5 = "registeredUninstall"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r5, r4)     // Catch:{ Throwable -> 0x0be0 }
            int r4 = m44((android.content.SharedPreferences) r13, (java.lang.String) r6, (boolean) r1)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r5 = "counter"
            java.lang.String r8 = java.lang.Integer.toString(r4)     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r5, r8)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r5 = "iaecounter"
            if (r26 == 0) goto L_0x0964
            r8 = 1
            goto L_0x0965
        L_0x0964:
            r8 = 0
        L_0x0965:
            java.lang.String r9 = "appsFlyerInAppEventCount"
            int r8 = m44((android.content.SharedPreferences) r13, (java.lang.String) r9, (boolean) r8)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r8 = java.lang.Integer.toString(r8)     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r5, r8)     // Catch:{ Throwable -> 0x0be0 }
            if (r1 == 0) goto L_0x0995
            r5 = 1
            if (r4 != r5) goto L_0x0995
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            r5.setFirstLaunchCalled()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r5 = "waitForCustomerId"
            com.appsflyer.AppsFlyerProperties r8 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            r9 = 0
            boolean r5 = r8.getBoolean(r5, r9)     // Catch:{ Throwable -> 0x0be0 }
            if (r5 == 0) goto L_0x0995
            java.lang.String r5 = "wait_cid"
            r8 = 1
            java.lang.String r9 = java.lang.Boolean.toString(r8)     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r5, r9)     // Catch:{ Throwable -> 0x0be0 }
        L_0x0995:
            java.lang.String r5 = "isFirstCall"
            if (r3 != 0) goto L_0x099b
            r3 = 1
            goto L_0x099c
        L_0x099b:
            r3 = 0
        L_0x099c:
            java.lang.String r3 = java.lang.Boolean.toString(r3)     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r5, r3)     // Catch:{ Throwable -> 0x0be0 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Throwable -> 0x0be0 }
            r3.<init>()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r5 = "cpu_abi"
            java.lang.String r8 = "ro.product.cpu.abi"
            java.lang.String r8 = m80((java.lang.String) r8)     // Catch:{ Throwable -> 0x0be0 }
            r3.put(r5, r8)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r5 = "cpu_abi2"
            java.lang.String r8 = "ro.product.cpu.abi2"
            java.lang.String r8 = m80((java.lang.String) r8)     // Catch:{ Throwable -> 0x0be0 }
            r3.put(r5, r8)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r5 = "arch"
            java.lang.String r8 = "os.arch"
            java.lang.String r8 = m80((java.lang.String) r8)     // Catch:{ Throwable -> 0x0be0 }
            r3.put(r5, r8)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r5 = "build_display_id"
            java.lang.String r8 = "ro.build.display.id"
            java.lang.String r8 = m80((java.lang.String) r8)     // Catch:{ Throwable -> 0x0be0 }
            r3.put(r5, r8)     // Catch:{ Throwable -> 0x0be0 }
            if (r1 == 0) goto L_0x0a4f
            boolean r5 = r7.f48     // Catch:{ Throwable -> 0x0be0 }
            if (r5 == 0) goto L_0x0a1b
            com.appsflyer.internal.i.m152()     // Catch:{ Throwable -> 0x0be0 }
            android.location.Location r5 = com.appsflyer.internal.i.m151(r24)     // Catch:{ Throwable -> 0x0be0 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Throwable -> 0x0be0 }
            r9 = 3
            r8.<init>(r9)     // Catch:{ Throwable -> 0x0be0 }
            if (r5 == 0) goto L_0x0a10
            java.lang.String r9 = "lat"
            double r11 = r5.getLatitude()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x0be0 }
            r8.put(r9, r11)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r9 = "lon"
            double r11 = r5.getLongitude()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x0be0 }
            r8.put(r9, r11)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r9 = "ts"
            long r11 = r5.getTime()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r5 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x0be0 }
            r8.put(r9, r5)     // Catch:{ Throwable -> 0x0be0 }
        L_0x0a10:
            boolean r5 = r8.isEmpty()     // Catch:{ Throwable -> 0x0be0 }
            if (r5 != 0) goto L_0x0a1b
            java.lang.String r5 = "loc"
            r3.put(r5, r8)     // Catch:{ Throwable -> 0x0be0 }
        L_0x0a1b:
            com.appsflyer.internal.e r5 = com.appsflyer.internal.e.m146()     // Catch:{ Throwable -> 0x0be0 }
            com.appsflyer.internal.e$c r5 = r5.m147(r2)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r8 = "btl"
            float r9 = r5.f168     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r9 = java.lang.Float.toString(r9)     // Catch:{ Throwable -> 0x0be0 }
            r3.put(r8, r9)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r8 = r5.f167     // Catch:{ Throwable -> 0x0be0 }
            if (r8 == 0) goto L_0x0a39
            java.lang.String r8 = "btch"
            java.lang.String r5 = r5.f167     // Catch:{ Throwable -> 0x0be0 }
            r3.put(r8, r5)     // Catch:{ Throwable -> 0x0be0 }
        L_0x0a39:
            r5 = 2
            if (r5 < r4) goto L_0x0a4f
            com.appsflyer.internal.o r4 = com.appsflyer.internal.o.m168(r24)     // Catch:{ Throwable -> 0x0be0 }
            java.util.List r4 = r4.m170()     // Catch:{ Throwable -> 0x0be0 }
            boolean r5 = r4.isEmpty()     // Catch:{ Throwable -> 0x0be0 }
            if (r5 != 0) goto L_0x0a4f
            java.lang.String r5 = "sensors"
            r3.put(r5, r4)     // Catch:{ Throwable -> 0x0be0 }
        L_0x0a4f:
            java.util.Map r4 = com.appsflyer.AFScreenManager.getScreenMetrics(r24)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r5 = "dim"
            r3.put(r5, r4)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r4 = "deviceData"
            r10.put(r4, r3)     // Catch:{ Throwable -> 0x0be0 }
            com.appsflyer.internal.y r3 = new com.appsflyer.internal.y     // Catch:{ Throwable -> 0x0be0 }
            r3.<init>()     // Catch:{ Throwable -> 0x0be0 }
            r3 = r21
            java.lang.Object r4 = r10.get(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Throwable -> 0x0be0 }
            r5 = r19
            java.lang.Object r8 = r10.get(r5)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r9 = "uid"
            java.lang.Object r9 = r10.get(r9)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Throwable -> 0x0be0 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0be0 }
            r11.<init>()     // Catch:{ Throwable -> 0x0be0 }
            r12 = 7
            r14 = 0
            java.lang.String r4 = r4.substring(r14, r12)     // Catch:{ Throwable -> 0x0be0 }
            r11.append(r4)     // Catch:{ Throwable -> 0x0be0 }
            r4 = 7
            java.lang.String r4 = r9.substring(r14, r4)     // Catch:{ Throwable -> 0x0be0 }
            r11.append(r4)     // Catch:{ Throwable -> 0x0be0 }
            int r4 = r8.length()     // Catch:{ Throwable -> 0x0be0 }
            int r4 = r4 + -7
            java.lang.String r4 = r8.substring(r4)     // Catch:{ Throwable -> 0x0be0 }
            r11.append(r4)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r4 = r11.toString()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r4 = com.appsflyer.internal.y.m213(r4)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r8 = "af_v"
            r10.put(r8, r4)     // Catch:{ Throwable -> 0x0be0 }
            com.appsflyer.internal.y r4 = new com.appsflyer.internal.y     // Catch:{ Throwable -> 0x0be0 }
            r4.<init>()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.Object r3 = r10.get(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Throwable -> 0x0be0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0be0 }
            r4.<init>()     // Catch:{ Throwable -> 0x0be0 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.Object r3 = r10.get(r5)     // Catch:{ Throwable -> 0x0be0 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = r4.toString()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0be0 }
            r4.<init>()     // Catch:{ Throwable -> 0x0be0 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = "uid"
            java.lang.Object r3 = r10.get(r3)     // Catch:{ Throwable -> 0x0be0 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = r4.toString()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0be0 }
            r4.<init>()     // Catch:{ Throwable -> 0x0be0 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = "installDate"
            java.lang.Object r3 = r10.get(r3)     // Catch:{ Throwable -> 0x0be0 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = r4.toString()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0be0 }
            r4.<init>()     // Catch:{ Throwable -> 0x0be0 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = "counter"
            java.lang.Object r3 = r10.get(r3)     // Catch:{ Throwable -> 0x0be0 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = r4.toString()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0be0 }
            r4.<init>()     // Catch:{ Throwable -> 0x0be0 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = "iaecounter"
            java.lang.Object r3 = r10.get(r3)     // Catch:{ Throwable -> 0x0be0 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = r4.toString()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = com.appsflyer.internal.y.m210(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r3 = com.appsflyer.internal.y.m213(r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r4 = "af_v2"
            r10.put(r4, r3)     // Catch:{ Throwable -> 0x0be0 }
            boolean r3 = m92(r24)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r4 = "ivc"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r4, r3)     // Catch:{ Throwable -> 0x0be0 }
            if (r1 == 0) goto L_0x0b92
            r1 = 0
            int r3 = m44((android.content.SharedPreferences) r13, (java.lang.String) r6, (boolean) r1)     // Catch:{ Throwable -> 0x0be0 }
            r4 = 2
            if (r3 > r4) goto L_0x0b92
            r3 = 28260(0x6e64, float:3.96E-41)
            r4 = 24
            java.lang.Object r3 = com.appsflyer.internal.c.m145(r1, r3, r4)     // Catch:{ all -> 0x0b88 }
            java.lang.Class r3 = (java.lang.Class) r3     // Catch:{ all -> 0x0b88 }
            java.lang.String r1 = "ˊ"
            r4 = 0
            java.lang.reflect.Method r1 = r3.getMethod(r1, r4)     // Catch:{ all -> 0x0b88 }
            java.lang.Object r1 = r1.invoke(r4, r4)     // Catch:{ all -> 0x0b88 }
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0b7e }
            r3 = 1
            r4[r3] = r10     // Catch:{ all -> 0x0b7e }
            r3 = 0
            r4[r3] = r2     // Catch:{ all -> 0x0b7e }
            r2 = 28260(0x6e64, float:3.96E-41)
            r5 = 24
            java.lang.Object r2 = com.appsflyer.internal.c.m145(r3, r2, r5)     // Catch:{ all -> 0x0b7e }
            java.lang.Class r2 = (java.lang.Class) r2     // Catch:{ all -> 0x0b7e }
            java.lang.String r5 = "ˏ"
            r6 = 2
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ all -> 0x0b7e }
            java.lang.Class<android.content.Context> r8 = android.content.Context.class
            r6[r3] = r8     // Catch:{ all -> 0x0b7e }
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            r8 = 1
            r6[r8] = r3     // Catch:{ all -> 0x0b7e }
            java.lang.reflect.Method r2 = r2.getMethod(r5, r6)     // Catch:{ all -> 0x0b7e }
            r2.invoke(r1, r4)     // Catch:{ all -> 0x0b7e }
            goto L_0x0b92
        L_0x0b7e:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Throwable -> 0x0be0 }
            if (r2 == 0) goto L_0x0b87
            throw r2     // Catch:{ Throwable -> 0x0be0 }
        L_0x0b87:
            throw r1     // Catch:{ Throwable -> 0x0be0 }
        L_0x0b88:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Throwable -> 0x0be0 }
            if (r2 == 0) goto L_0x0b91
            throw r2     // Catch:{ Throwable -> 0x0be0 }
        L_0x0b91:
            throw r1     // Catch:{ Throwable -> 0x0be0 }
        L_0x0b92:
            java.lang.String r1 = "is_stop_tracking_used"
            boolean r1 = r13.contains(r1)     // Catch:{ Throwable -> 0x0be0 }
            if (r1 == 0) goto L_0x0baa
            java.lang.String r1 = "istu"
            java.lang.String r2 = "is_stop_tracking_used"
            r3 = 0
            boolean r2 = r13.getBoolean(r2, r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x0be0 }
            r10.put(r1, r2)     // Catch:{ Throwable -> 0x0be0 }
        L_0x0baa:
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r2 = "consumeAfDeepLink"
            java.lang.Object r1 = r1.getObject(r2)     // Catch:{ Throwable -> 0x0be0 }
            if (r1 == 0) goto L_0x0bec
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r2 = "consumeAfDeepLink"
            r3 = 0
            boolean r1 = r1.getBoolean(r2, r3)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r2 = "is_dp_api"
            r10.put(r2, r1)     // Catch:{ Throwable -> 0x0be0 }
            goto L_0x0bec
        L_0x0bcb:
            r7 = r23
            java.lang.String r1 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. "
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r1 = "AppsFlyer_4.10.0"
            java.lang.String r3 = "DEV_KEY_MISSING"
            r4 = 0
            m69(r2, r1, r3, r4)     // Catch:{ Throwable -> 0x0be0 }
            java.lang.String r1 = "AppsFlyer will not track this event."
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ Throwable -> 0x0be0 }
            return r4
        L_0x0be0:
            r0 = move-exception
            goto L_0x0be4
        L_0x0be2:
            r0 = move-exception
            r7 = r1
        L_0x0be4:
            r1 = r0
            java.lang.String r2 = r1.getLocalizedMessage()
            com.appsflyer.AFLogger.afErrorLog(r2, r1)
        L_0x0bec:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m93(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, android.content.SharedPreferences, boolean, android.content.Intent, java.lang.String):java.util.Map");
    }

    public void setConsumeAFDeepLinks(boolean z) {
        AppsFlyerProperties.getInstance().set("consumeAfDeepLink", z);
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setConsumeAFDeepLinks: ".concat(String.valueOf(z)), new String[0]);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m61(Context context, Map<String, ? super String> map) {
        f.m149();
        f.e r2 = f.m148(context);
        map.put("network", r2.f170);
        if (r2.f172 != null) {
            map.put("operator", r2.f172);
        }
        if (r2.f171 != null) {
            map.put("carrier", r2.f171);
        }
    }

    /* access modifiers changed from: protected */
    public void handleDeepLinkCallback(Context context, Map<String, Object> map, Uri uri) {
        final Map map2;
        String str;
        String obj = uri.toString();
        if (obj == null) {
            obj = null;
        } else if (obj.matches("fb\\d*?://authorize.*") && obj.contains("access_token")) {
            int indexOf = obj.indexOf(63);
            if (indexOf == -1) {
                str = "";
            } else {
                str = obj.substring(indexOf);
            }
            if (str.length() != 0) {
                ArrayList arrayList = new ArrayList();
                if (str.contains("&")) {
                    arrayList = new ArrayList(Arrays.asList(str.split("&")));
                } else {
                    arrayList.add(str);
                }
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (str2.contains("access_token")) {
                        it.remove();
                    } else {
                        if (sb.length() != 0) {
                            sb.append("&");
                        } else if (!str2.startsWith("?")) {
                            sb.append("?");
                        }
                        sb.append(str2);
                    }
                }
                obj = obj.replace(str, sb.toString());
            }
        }
        if (!map.containsKey("af_deeplink")) {
            map.put("af_deeplink", obj);
        }
        boolean z = true;
        if (uri.getQueryParameter("af_deeplink") != null) {
            this.f49 = "AppsFlyer_Test".equals(uri.getQueryParameter("media_source")) && Boolean.parseBoolean(uri.getQueryParameter("is_retargeting"));
            map2 = m82(context, uri.getQuery());
            String path = uri.getPath();
            if (path != null) {
                map2.put("path", path);
            }
            String scheme = uri.getScheme();
            if (scheme != null) {
                map2.put("scheme", scheme);
            }
            String host = uri.getHost();
            if (host != null) {
                map2.put("host", host);
            }
        } else {
            map2 = new HashMap();
            map2.put("link", uri.toString());
        }
        final WeakReference weakReference = new WeakReference(context);
        t tVar = new t(uri, this);
        tVar.setConnProvider(new OneLinkHttpTask.HttpsUrlConnectionProvider());
        if (TextUtils.isEmpty(tVar.f110) || TextUtils.isEmpty(tVar.f241)) {
            z = false;
        }
        if (z) {
            tVar.f242 = new t.d() {
                /* renamed from: ˊ  reason: contains not printable characters */
                public final void m99(String str) {
                    if (AppsFlyerLibCore.f36 != null) {
                        m98(map2);
                        AppsFlyerLibCore.f36.onAttributionFailure(str);
                    }
                }

                /* renamed from: ˋ  reason: contains not printable characters */
                private void m98(Map<String, String> map) {
                    if (weakReference.get() != null) {
                        AppsFlyerLibCore.m60((Context) weakReference.get(), "deeplinkAttribution", new JSONObject(map).toString());
                    }
                }

                /* renamed from: ˎ  reason: contains not printable characters */
                public final void m100(Map<String, String> map) {
                    for (String next : map.keySet()) {
                        map2.put(next, map.get(next));
                    }
                    m98(map2);
                    AppsFlyerLibCore.m62(map2);
                }
            };
            AFExecutor.getInstance().getThreadPoolExecutor().execute(tVar);
            return;
        }
        AppsFlyerConversionListener appsFlyerConversionListener = f36;
        if (appsFlyerConversionListener != null) {
            try {
                appsFlyerConversionListener.onAppOpenAttribution(map2);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private static boolean m43(Context context) {
        try {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
                return true;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            AFLogger.afErrorLog("WARNING:  Google Play Services is unavailable. ", e2);
            return false;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private static boolean m40(Context context) {
        if ((AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) || !m43(context)) {
            return true;
        }
        return false;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private static String m41(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        String r2 = m58((WeakReference<Context>) new WeakReference(context), "AF_STORE");
        if (r2 != null) {
            return r2;
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String m80(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m58(WeakReference<Context> weakReference, String str) {
        if (weakReference.get() == null) {
            return null;
        }
        return m48(str, weakReference.get().getPackageManager(), weakReference.get().getPackageName());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String m48(String str, PackageManager packageManager, String str2) {
        try {
            Bundle bundle = packageManager.getApplicationInfo(str2, 128).metaData;
            if (bundle == null) {
                return null;
            }
            Object obj = bundle.get(str);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Could not find ");
            sb.append(str);
            sb.append(" value in the manifest");
            AFLogger.afErrorLog(sb.toString(), th);
            return null;
        }
    }

    public void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put(Constants.URL_MEDIA_SOURCE, str);
            } catch (JSONException e2) {
                AFLogger.afErrorLog(e2.getMessage(), e2);
            }
        }
        if (str2 != null) {
            jSONObject.put(Constants.URL_CAMPAIGN, str2);
        }
        if (str3 != null) {
            jSONObject.put(Constants.URL_SITE_ID, str3);
        }
        if (jSONObject.has(Constants.URL_MEDIA_SOURCE)) {
            AppsFlyerProperties.getInstance().set("preInstallName", jSONObject.toString());
            return;
        }
        AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0042 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034 A[SYNTHETIC, Splitter:B:18:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060 A[SYNTHETIC, Splitter:B:32:0x0060] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0042=Splitter:B:24:0x0042, B:15:0x002b=Splitter:B:15:0x002b} */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m47(java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.Properties r1 = new java.util.Properties     // Catch:{ FileNotFoundException -> 0x0041, Throwable -> 0x0029, all -> 0x0026 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0041, Throwable -> 0x0029, all -> 0x0026 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0041, Throwable -> 0x0029, all -> 0x0026 }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0041, Throwable -> 0x0029, all -> 0x0026 }
            r1.load(r2)     // Catch:{ FileNotFoundException -> 0x0042, Throwable -> 0x0024 }
            java.lang.String r3 = "Found PreInstall property!"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ FileNotFoundException -> 0x0042, Throwable -> 0x0024 }
            java.lang.String r4 = r1.getProperty(r5)     // Catch:{ FileNotFoundException -> 0x0042, Throwable -> 0x0024 }
            r2.close()     // Catch:{ Throwable -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x0023:
            return r4
        L_0x0024:
            r4 = move-exception
            goto L_0x002b
        L_0x0026:
            r4 = move-exception
            r2 = r0
            goto L_0x005e
        L_0x0029:
            r4 = move-exception
            r2 = r0
        L_0x002b:
            java.lang.String r5 = r4.getMessage()     // Catch:{ all -> 0x005d }
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ Throwable -> 0x0038 }
            goto L_0x005c
        L_0x0038:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r5, r4)
            goto L_0x005c
        L_0x0041:
            r2 = r0
        L_0x0042:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            java.lang.String r1 = "PreInstall file wasn't found: "
            r5.<init>(r1)     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x005d }
            r5.append(r4)     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x005d }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ Throwable -> 0x0038 }
        L_0x005c:
            return r0
        L_0x005d:
            r4 = move-exception
        L_0x005e:
            if (r2 == 0) goto L_0x006c
            r2.close()     // Catch:{ Throwable -> 0x0064 }
            goto L_0x006c
        L_0x0064:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x006c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m47(java.io.File, java.lang.String):java.lang.String");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static File m56(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.trim().length() > 0) {
                return new File(str.trim());
            }
            return null;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m57(WeakReference<Context> weakReference) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.CHANNEL);
        if (string == null) {
            string = m58(weakReference, "CHANNEL");
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }

    public boolean isPreInstalledApp(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            AFLogger.afErrorLog("Could not check if app is pre installed", e2);
        }
    }

    public String getAttributionId(ContentResolver contentResolver) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(Uri.parse(ATTRIBUTION_ID_CONTENT_URI), new String[]{ATTRIBUTION_ID_COLUMN_NAME}, (String) null, (String[]) null, (String) null);
        String str = null;
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str = query.getString(query.getColumnIndex(ATTRIBUTION_ID_COLUMN_NAME));
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception e2) {
                            AFLogger.afErrorLog(e2.getMessage(), e2);
                        }
                    }
                    return str;
                }
            } catch (Exception e3) {
                AFLogger.afErrorLog("Could not collect cursor attribution. ", e3);
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e4) {
                        AFLogger.afErrorLog(e4.getMessage(), e4);
                    }
                }
                throw th;
            }
        }
        if (query != null) {
            try {
                query.close();
            } catch (Exception e5) {
                AFLogger.afErrorLog(e5.getMessage(), e5);
            }
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static SharedPreferences m46(Context context) {
        return context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static int m44(SharedPreferences sharedPreferences, String str, boolean z) {
        int i = sharedPreferences.getInt(str, 0);
        if (z) {
            i++;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
        if (x.f258 == null) {
            x.f258 = new x();
        }
        if (x.f258.f274) {
            if (x.f258 == null) {
                x.f258 = new x();
            }
            x.f258.m209(String.valueOf(i));
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0250 A[SYNTHETIC, Splitter:B:109:0x0250] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x025c A[Catch:{ s -> 0x023b, all -> 0x0260 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0267  */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m71(java.net.URL r20, java.lang.String r21, java.lang.String r22, java.lang.ref.WeakReference<android.content.Context> r23, java.lang.String r24, boolean r25) throws java.io.IOException {
        /*
            r19 = this;
            r1 = r19
            r0 = r21
            r2 = r22
            r3 = r24
            java.lang.String r4 = "is_first_launch"
            java.lang.String r5 = "appsflyerConversionDataCacheExpiration"
            java.lang.Object r6 = r23.get()
            android.content.Context r6 = (android.content.Context) r6
            r7 = 1
            r8 = 0
            if (r25 == 0) goto L_0x001c
            com.appsflyer.AppsFlyerConversionListener r9 = f36
            if (r9 == 0) goto L_0x001c
            r9 = 1
            goto L_0x001d
        L_0x001c:
            r9 = 0
        L_0x001d:
            com.appsflyer.internal.x r11 = com.appsflyer.internal.x.f258     // Catch:{ all -> 0x0262 }
            if (r11 != 0) goto L_0x002d
            com.appsflyer.internal.x r11 = new com.appsflyer.internal.x     // Catch:{ all -> 0x0029 }
            r11.<init>()     // Catch:{ all -> 0x0029 }
            com.appsflyer.internal.x.f258 = r11     // Catch:{ all -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r0 = move-exception
            r11 = 0
            goto L_0x0265
        L_0x002d:
            com.appsflyer.internal.x r11 = com.appsflyer.internal.x.f258     // Catch:{ all -> 0x0262 }
            java.lang.String r12 = r20.toString()     // Catch:{ all -> 0x0262 }
            java.lang.String r13 = "server_request"
            java.lang.String[] r14 = new java.lang.String[r7]     // Catch:{ all -> 0x0262 }
            r14[r8] = r0     // Catch:{ all -> 0x0262 }
            r11.m205(r13, r12, r14)     // Catch:{ all -> 0x0262 }
            java.net.URLConnection r11 = r20.openConnection()     // Catch:{ all -> 0x0262 }
            java.lang.Object r11 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r11)     // Catch:{ all -> 0x0262 }
            java.net.URLConnection r11 = (java.net.URLConnection) r11     // Catch:{ all -> 0x0262 }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x0262 }
            java.lang.String r12 = "POST"
            r11.setRequestMethod(r12)     // Catch:{ all -> 0x0260 }
            byte[] r12 = r21.getBytes()     // Catch:{ all -> 0x0260 }
            int r12 = r12.length     // Catch:{ all -> 0x0260 }
            java.lang.String r13 = "Content-Length"
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0260 }
            r11.setRequestProperty(r13, r12)     // Catch:{ all -> 0x0260 }
            java.lang.String r12 = "Content-Type"
            java.lang.String r13 = "application/json"
            r11.setRequestProperty(r12, r13)     // Catch:{ all -> 0x0260 }
            r12 = 10000(0x2710, float:1.4013E-41)
            r11.setConnectTimeout(r12)     // Catch:{ all -> 0x0260 }
            r11.setDoOutput(r7)     // Catch:{ all -> 0x0260 }
            java.io.OutputStreamWriter r12 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x024c }
            java.io.OutputStream r13 = r11.getOutputStream()     // Catch:{ all -> 0x024c }
            java.lang.String r14 = "UTF-8"
            r12.<init>(r13, r14)     // Catch:{ all -> 0x024c }
            r12.write(r0)     // Catch:{ all -> 0x0249 }
            r12.close()     // Catch:{ all -> 0x0260 }
            int r0 = r11.getResponseCode()     // Catch:{ all -> 0x0260 }
            java.lang.String r12 = m81((java.net.HttpURLConnection) r11)     // Catch:{ all -> 0x0260 }
            com.appsflyer.internal.x r13 = com.appsflyer.internal.x.f258     // Catch:{ all -> 0x0260 }
            if (r13 != 0) goto L_0x008e
            com.appsflyer.internal.x r13 = new com.appsflyer.internal.x     // Catch:{ all -> 0x0260 }
            r13.<init>()     // Catch:{ all -> 0x0260 }
            com.appsflyer.internal.x.f258 = r13     // Catch:{ all -> 0x0260 }
        L_0x008e:
            com.appsflyer.internal.x r13 = com.appsflyer.internal.x.f258     // Catch:{ all -> 0x0260 }
            java.lang.String r14 = r20.toString()     // Catch:{ all -> 0x0260 }
            java.lang.String r15 = "server_response"
            r10 = 2
            java.lang.String[] r10 = new java.lang.String[r10]     // Catch:{ all -> 0x0260 }
            java.lang.String r16 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0260 }
            r10[r8] = r16     // Catch:{ all -> 0x0260 }
            r10[r7] = r12     // Catch:{ all -> 0x0260 }
            r13.m205(r15, r14, r10)     // Catch:{ all -> 0x0260 }
            java.lang.String r10 = "response code: "
            java.lang.String r13 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0260 }
            java.lang.String r10 = r10.concat(r13)     // Catch:{ all -> 0x0260 }
            com.appsflyer.AFLogger.afInfoLog(r10)     // Catch:{ all -> 0x0260 }
            java.lang.String r10 = "AppsFlyer_4.10.0"
            java.lang.String r13 = "SERVER_RESPONSE_CODE"
            java.lang.String r14 = java.lang.Integer.toString(r0)     // Catch:{ all -> 0x0260 }
            m69(r6, r10, r13, r14)     // Catch:{ all -> 0x0260 }
            android.content.Context r10 = r6.getApplicationContext()     // Catch:{ all -> 0x0260 }
            java.lang.String r13 = "appsflyer-data"
            android.content.SharedPreferences r10 = r10.getSharedPreferences(r13, r8)     // Catch:{ all -> 0x0260 }
            r13 = 200(0xc8, float:2.8E-43)
            if (r0 != r13) goto L_0x0193
            java.lang.Object r0 = r23.get()     // Catch:{ all -> 0x0260 }
            if (r0 == 0) goto L_0x00e1
            if (r25 == 0) goto L_0x00e1
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0260 }
            r1.f58 = r13     // Catch:{ all -> 0x0260 }
            com.appsflyer.AppsFlyerTrackingRequestListener r0 = f35     // Catch:{ all -> 0x0260 }
            if (r0 == 0) goto L_0x00e1
            com.appsflyer.AppsFlyerTrackingRequestListener r0 = f35     // Catch:{ all -> 0x0260 }
            r0.onTrackingRequestSuccess()     // Catch:{ all -> 0x0260 }
        L_0x00e1:
            java.lang.String r0 = "afUninstallToken"
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0260 }
            java.lang.String r0 = r13.getString(r0)     // Catch:{ all -> 0x0260 }
            if (r0 == 0) goto L_0x0118
            java.lang.String r13 = "Uninstall Token exists: "
            java.lang.String r14 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0260 }
            java.lang.String r13 = r13.concat(r14)     // Catch:{ all -> 0x0260 }
            com.appsflyer.AFLogger.afDebugLog(r13)     // Catch:{ all -> 0x0260 }
            java.lang.String r13 = "sentRegisterRequestToAF"
            boolean r13 = r10.getBoolean(r13, r8)     // Catch:{ all -> 0x0260 }
            if (r13 != 0) goto L_0x0138
            java.lang.String r13 = "Resending Uninstall token to AF servers: "
            java.lang.String r14 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0260 }
            java.lang.String r13 = r13.concat(r14)     // Catch:{ all -> 0x0260 }
            com.appsflyer.AFLogger.afDebugLog(r13)     // Catch:{ all -> 0x0260 }
            com.appsflyer.internal.b$b$a r13 = new com.appsflyer.internal.b$b$a     // Catch:{ all -> 0x0260 }
            r13.<init>(r0)     // Catch:{ all -> 0x0260 }
            com.appsflyer.internal.v.m190(r6, r13)     // Catch:{ all -> 0x0260 }
            goto L_0x0138
        L_0x0118:
            java.lang.String r0 = "gcmProjectNumber"
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0260 }
            java.lang.String r0 = r13.getString(r0)     // Catch:{ all -> 0x0260 }
            if (r0 == 0) goto L_0x0138
            java.lang.String r0 = "GCM Project number exists. Fetching token and sending to AF servers"
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ all -> 0x0260 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0260 }
            r0.<init>(r6)     // Catch:{ all -> 0x0260 }
            com.appsflyer.internal.v$e r13 = new com.appsflyer.internal.v$e     // Catch:{ all -> 0x0260 }
            r13.<init>(r0)     // Catch:{ all -> 0x0260 }
            java.lang.Void[] r0 = new java.lang.Void[r8]     // Catch:{ all -> 0x0260 }
            r13.execute(r0)     // Catch:{ all -> 0x0260 }
        L_0x0138:
            android.net.Uri r0 = r1.latestDeepLink     // Catch:{ all -> 0x0260 }
            if (r0 == 0) goto L_0x013f
            r13 = 0
            r1.latestDeepLink = r13     // Catch:{ all -> 0x0260 }
        L_0x013f:
            if (r3 == 0) goto L_0x0148
            com.appsflyer.cache.CacheManager r0 = com.appsflyer.cache.CacheManager.getInstance()     // Catch:{ all -> 0x0260 }
            r0.deleteRequest(r3, r6)     // Catch:{ all -> 0x0260 }
        L_0x0148:
            java.lang.Object r0 = r23.get()     // Catch:{ all -> 0x0260 }
            if (r0 == 0) goto L_0x0185
            if (r3 != 0) goto L_0x0185
            java.lang.String r0 = "sentSuccessfully"
            java.lang.String r3 = "true"
            m60(r6, r0, r3)     // Catch:{ all -> 0x0260 }
            boolean r0 = r1.f44     // Catch:{ all -> 0x0260 }
            if (r0 != 0) goto L_0x0185
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0260 }
            long r7 = r1.f43     // Catch:{ all -> 0x0260 }
            long r13 = r13 - r7
            r7 = 15000(0x3a98, double:7.411E-320)
            int r0 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0169
            goto L_0x0185
        L_0x0169:
            java.util.concurrent.ScheduledExecutorService r0 = r1.f45     // Catch:{ all -> 0x0260 }
            if (r0 != 0) goto L_0x0185
            com.appsflyer.AFExecutor r0 = com.appsflyer.AFExecutor.getInstance()     // Catch:{ all -> 0x0260 }
            java.util.concurrent.ScheduledThreadPoolExecutor r0 = r0.m24()     // Catch:{ all -> 0x0260 }
            r1.f45 = r0     // Catch:{ all -> 0x0260 }
            com.appsflyer.AppsFlyerLibCore$a r0 = new com.appsflyer.AppsFlyerLibCore$a     // Catch:{ all -> 0x0260 }
            r0.<init>(r6)     // Catch:{ all -> 0x0260 }
            java.util.concurrent.ScheduledExecutorService r7 = r1.f45     // Catch:{ all -> 0x0260 }
            r13 = 1
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0260 }
            m79(r7, r0, r13, r8)     // Catch:{ all -> 0x0260 }
        L_0x0185:
            org.json.JSONObject r0 = com.appsflyer.ServerConfigHandler.m118(r12)     // Catch:{ all -> 0x0260 }
            java.lang.String r7 = "send_background"
            r8 = 0
            boolean r0 = r0.optBoolean(r7, r8)     // Catch:{ all -> 0x0260 }
            r1.f57 = r0     // Catch:{ all -> 0x0260 }
            goto L_0x01a6
        L_0x0193:
            com.appsflyer.AppsFlyerTrackingRequestListener r7 = f35     // Catch:{ all -> 0x0260 }
            if (r7 == 0) goto L_0x01a6
            java.lang.String r7 = "Failure: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0260 }
            java.lang.String r0 = r7.concat(r0)     // Catch:{ all -> 0x0260 }
            com.appsflyer.AppsFlyerTrackingRequestListener r7 = f35     // Catch:{ all -> 0x0260 }
            r7.onTrackingRequestFailure(r0)     // Catch:{ all -> 0x0260 }
        L_0x01a6:
            java.lang.String r0 = "appsflyerConversionDataRequestRetries"
            r7 = 0
            int r0 = r10.getInt(r0, r7)     // Catch:{ all -> 0x0260 }
            r7 = 0
            long r12 = r10.getLong(r5, r7)     // Catch:{ all -> 0x0260 }
            java.lang.String r14 = "attributionId"
            int r16 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r16 == 0) goto L_0x01cf
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0260 }
            long r16 = r16 - r12
            r12 = 5184000000(0x134fd9000, double:2.561236308E-314)
            int r18 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r18 <= 0) goto L_0x01cf
            r12 = 0
            m60(r6, r14, r12)     // Catch:{ all -> 0x0260 }
            m68(r6, r5, r7)     // Catch:{ all -> 0x0260 }
        L_0x01cf:
            r5 = 0
            java.lang.String r7 = r10.getString(r14, r5)     // Catch:{ all -> 0x0260 }
            if (r7 != 0) goto L_0x01fa
            if (r2 == 0) goto L_0x01fa
            if (r9 == 0) goto L_0x01fa
            com.appsflyer.AppsFlyerConversionListener r5 = f36     // Catch:{ all -> 0x0260 }
            if (r5 == 0) goto L_0x01fa
            r5 = 5
            if (r0 > r5) goto L_0x01fa
            com.appsflyer.AFExecutor r0 = com.appsflyer.AFExecutor.getInstance()     // Catch:{ all -> 0x0260 }
            java.util.concurrent.ScheduledThreadPoolExecutor r0 = r0.m24()     // Catch:{ all -> 0x0260 }
            com.appsflyer.AppsFlyerLibCore$e r3 = new com.appsflyer.AppsFlyerLibCore$e     // Catch:{ all -> 0x0260 }
            android.content.Context r4 = r6.getApplicationContext()     // Catch:{ all -> 0x0260 }
            r3.<init>(r4, r2, r0)     // Catch:{ all -> 0x0260 }
            r4 = 10
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0260 }
            m79(r0, r3, r4, r2)     // Catch:{ all -> 0x0260 }
            goto L_0x0243
        L_0x01fa:
            if (r2 != 0) goto L_0x0202
            java.lang.String r0 = "AppsFlyer dev key is missing."
            com.appsflyer.AFLogger.afWarnLog(r0)     // Catch:{ all -> 0x0260 }
            goto L_0x0243
        L_0x0202:
            if (r9 == 0) goto L_0x0243
            com.appsflyer.AppsFlyerConversionListener r0 = f36     // Catch:{ all -> 0x0260 }
            if (r0 == 0) goto L_0x0243
            r13 = 0
            java.lang.String r0 = r10.getString(r14, r13)     // Catch:{ all -> 0x0260 }
            if (r0 == 0) goto L_0x0243
            java.lang.String r0 = "appsFlyerCount"
            r2 = 0
            int r0 = m44((android.content.SharedPreferences) r10, (java.lang.String) r0, (boolean) r2)     // Catch:{ all -> 0x0260 }
            r3 = 1
            if (r0 <= r3) goto L_0x0243
            java.util.Map r0 = m66((android.content.Context) r6)     // Catch:{ s -> 0x023b }
            if (r0 == 0) goto L_0x0243
            boolean r3 = r0.containsKey(r4)     // Catch:{ Throwable -> 0x0232 }
            if (r3 != 0) goto L_0x022c
            java.lang.String r2 = java.lang.Boolean.toString(r2)     // Catch:{ Throwable -> 0x0232 }
            r0.put(r4, r2)     // Catch:{ Throwable -> 0x0232 }
        L_0x022c:
            com.appsflyer.AppsFlyerConversionListener r2 = f36     // Catch:{ Throwable -> 0x0232 }
            r2.onInstallConversionDataLoaded(r0)     // Catch:{ Throwable -> 0x0232 }
            goto L_0x0243
        L_0x0232:
            r0 = move-exception
            java.lang.String r2 = r0.getLocalizedMessage()     // Catch:{ s -> 0x023b }
            com.appsflyer.AFLogger.afErrorLog(r2, r0)     // Catch:{ s -> 0x023b }
            goto L_0x0243
        L_0x023b:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x0260 }
            com.appsflyer.AFLogger.afErrorLog(r2, r0)     // Catch:{ all -> 0x0260 }
        L_0x0243:
            if (r11 == 0) goto L_0x0248
            r11.disconnect()
        L_0x0248:
            return
        L_0x0249:
            r0 = move-exception
            r13 = r12
            goto L_0x024e
        L_0x024c:
            r0 = move-exception
            r13 = 0
        L_0x024e:
            if (r13 != 0) goto L_0x025c
            com.appsflyer.AppsFlyerTrackingRequestListener r2 = f35     // Catch:{ all -> 0x0260 }
            if (r2 == 0) goto L_0x025f
            com.appsflyer.AppsFlyerTrackingRequestListener r2 = f35     // Catch:{ all -> 0x0260 }
            java.lang.String r3 = "No Connectivity"
            r2.onTrackingRequestFailure(r3)     // Catch:{ all -> 0x0260 }
            goto L_0x025f
        L_0x025c:
            r13.close()     // Catch:{ all -> 0x0260 }
        L_0x025f:
            throw r0     // Catch:{ all -> 0x0260 }
        L_0x0260:
            r0 = move-exception
            goto L_0x0265
        L_0x0262:
            r0 = move-exception
            r13 = 0
            r11 = r13
        L_0x0265:
            if (r11 == 0) goto L_0x026a
            r11.disconnect()
        L_0x026a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m71(java.net.URL, java.lang.String, java.lang.String, java.lang.ref.WeakReference, java.lang.String, boolean):void");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m79(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j, TimeUnit timeUnit) {
        if (scheduledExecutorService != null) {
            try {
                if (!scheduledExecutorService.isShutdown() && !scheduledExecutorService.isTerminated()) {
                    scheduledExecutorService.schedule(runnable, j, timeUnit);
                    return;
                }
            } catch (RejectedExecutionException e2) {
                AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e2);
                return;
            } catch (Throwable th) {
                AFLogger.afErrorLog("scheduleJob failed with Exception", th);
                return;
            }
        }
        AFLogger.afWarnLog("scheduler is null, shut downed or terminated");
    }

    public void onHandleReferrer(Map<String, String> map) {
        this.f42 = map;
    }

    public boolean isTrackingStopped() {
        return this.f55;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        if (r3 != null) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[SYNTHETIC, Splitter:B:27:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086 A[SYNTHETIC, Splitter:B:45:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b A[Catch:{ Throwable -> 0x008e }] */
    /* renamed from: ॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m81(java.net.HttpURLConnection r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.InputStream r2 = r7.getErrorStream()     // Catch:{ Throwable -> 0x003d, all -> 0x003a }
            if (r2 != 0) goto L_0x0010
            java.io.InputStream r2 = r7.getInputStream()     // Catch:{ Throwable -> 0x003d, all -> 0x003a }
        L_0x0010:
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x003d, all -> 0x003a }
            r3.<init>(r2)     // Catch:{ Throwable -> 0x003d, all -> 0x003a }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x0038 }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x0038 }
        L_0x001a:
            java.lang.String r1 = r2.readLine()     // Catch:{ Throwable -> 0x0033, all -> 0x0030 }
            if (r1 == 0) goto L_0x0029
            r0.append(r1)     // Catch:{ Throwable -> 0x0033, all -> 0x0030 }
            r1 = 10
            r0.append(r1)     // Catch:{ Throwable -> 0x0033, all -> 0x0030 }
            goto L_0x001a
        L_0x0029:
            r2.close()     // Catch:{ Throwable -> 0x0060 }
        L_0x002c:
            r3.close()     // Catch:{ Throwable -> 0x0060 }
            goto L_0x0060
        L_0x0030:
            r7 = move-exception
            r1 = r2
            goto L_0x0084
        L_0x0033:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x003f
        L_0x0038:
            r2 = move-exception
            goto L_0x003f
        L_0x003a:
            r7 = move-exception
            r3 = r1
            goto L_0x0084
        L_0x003d:
            r2 = move-exception
            r3 = r1
        L_0x003f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = "Could not read connection response from: "
            r4.<init>(r5)     // Catch:{ all -> 0x0083 }
            java.net.URL r7 = r7.getURL()     // Catch:{ all -> 0x0083 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0083 }
            r4.append(r7)     // Catch:{ all -> 0x0083 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0083 }
            com.appsflyer.AFLogger.afErrorLog(r7, r2)     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x005d
            r1.close()     // Catch:{ Throwable -> 0x0060 }
        L_0x005d:
            if (r3 == 0) goto L_0x0060
            goto L_0x002c
        L_0x0060:
            java.lang.String r7 = r0.toString()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x006a }
            r0.<init>(r7)     // Catch:{ JSONException -> 0x006a }
            return r7
        L_0x006a:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "string_response"
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r7 = r0.toString()     // Catch:{ JSONException -> 0x0079 }
            return r7
        L_0x0079:
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r7 = r7.toString()
            return r7
        L_0x0083:
            r7 = move-exception
        L_0x0084:
            if (r1 == 0) goto L_0x0089
            r1.close()     // Catch:{ Throwable -> 0x008e }
        L_0x0089:
            if (r3 == 0) goto L_0x008e
            r3.close()     // Catch:{ Throwable -> 0x008e }
        L_0x008e:
            goto L_0x0090
        L_0x008f:
            throw r7
        L_0x0090:
            goto L_0x008f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m81(java.net.HttpURLConnection):java.lang.String");
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static float m91(Context context) {
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra == -1 || intExtra2 == -1) {
                return 50.0f;
            }
            return (((float) intExtra) / ((float) intExtra2)) * 100.0f;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return 1.0f;
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static boolean m92(Context context) {
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    for (Network networkCapabilities : connectivityManager.getAllNetworks()) {
                        NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(networkCapabilities);
                        if (networkCapabilities2.hasTransport(4) && !networkCapabilities2.hasCapability(15)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e2) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e2);
                }
            } else if (Build.VERSION.SDK_INT >= 16) {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (it.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                    return arrayList.contains("tun0");
                } catch (Exception e3) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e3);
                }
            }
        }
        return false;
    }

    public void setLogLevel(AFLogger.LogLevel logLevel) {
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
    }

    public void setMinTimeBetweenSessions(int i) {
        this.f59 = TimeUnit.SECONDS.toMillis((long) i);
    }

    class b implements Runnable {

        /* renamed from: ʻ  reason: contains not printable characters */
        private boolean f72;

        /* renamed from: ʼ  reason: contains not printable characters */
        private String f73;

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f75;

        /* renamed from: ˋ  reason: contains not printable characters */
        private WeakReference<Context> f76;

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f77;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final String f78;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final Intent f79;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private String f80;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private boolean f81;

        /* synthetic */ b(AppsFlyerLibCore appsFlyerLibCore, WeakReference weakReference, String str, String str2, String str3, String str4, boolean z, Intent intent, String str5, byte b2) {
            this(weakReference, str, str2, str3, str4, z, intent, str5);
        }

        private b(WeakReference<Context> weakReference, String str, String str2, String str3, String str4, boolean z, Intent intent, String str5) {
            this.f76 = weakReference;
            this.f77 = str;
            this.f75 = str2;
            this.f80 = str3;
            this.f73 = str4;
            this.f81 = true;
            this.f72 = z;
            this.f79 = intent;
            this.f78 = str5;
        }

        public final void run() {
            AppsFlyerLibCore.m86(AppsFlyerLibCore.this, this.f76.get(), this.f77, this.f75, this.f80, this.f73, this.f81, this.f72, this.f79, this.f78);
        }
    }

    class c implements Runnable {

        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean f82;

        /* renamed from: ˋ  reason: contains not printable characters */
        private WeakReference<Context> f83;

        /* renamed from: ˎ  reason: contains not printable characters */
        private int f84;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f85;

        /* renamed from: ॱ  reason: contains not printable characters */
        private Map<String, Object> f86;

        /* synthetic */ c(AppsFlyerLibCore appsFlyerLibCore, String str, Map map, Context context, boolean z, int i, byte b2) {
            this(str, map, context, z, i);
        }

        private c(String str, Map<String, Object> map, Context context, boolean z, int i) {
            this.f83 = null;
            this.f85 = str;
            this.f86 = map;
            this.f83 = new WeakReference<>(context);
            this.f82 = z;
            this.f84 = i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0064, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
            com.appsflyer.AFLogger.afErrorLog(r0.getMessage(), r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x006d, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x006e, code lost:
            com.appsflyer.AFLogger.afErrorLog("Exception while sending request to server. ", r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
            com.appsflyer.cache.CacheManager.getInstance().cacheRequest(new com.appsflyer.cache.RequestCacheData(r9.f85, r0, com.appsflyer.BuildConfig.VERSION_NAME), r9.f83.get());
            com.appsflyer.AFLogger.afErrorLog(r1.getMessage(), r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r9 = this;
                com.appsflyer.AppsFlyerLibCore r0 = com.appsflyer.AppsFlyerLibCore.this
                boolean r0 = r0.isTrackingStopped()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                r0 = 0
                boolean r1 = r9.f82
                if (r1 == 0) goto L_0x0028
                int r1 = r9.f84
                r2 = 2
                if (r1 > r2) goto L_0x0028
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                boolean r1 = com.appsflyer.AppsFlyerLibCore.m63((com.appsflyer.AppsFlyerLibCore) r1)
                if (r1 == 0) goto L_0x0028
                java.util.Map<java.lang.String, java.lang.Object> r1 = r9.f86
                com.appsflyer.AppsFlyerLibCore r2 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r2 = r2.f42
                java.lang.String r3 = "rfr"
                r1.put(r3, r2)
            L_0x0028:
                java.util.Map<java.lang.String, java.lang.Object> r1 = r9.f86
                com.appsflyer.internal.b$b r2 = new com.appsflyer.internal.b$b
                java.lang.ref.WeakReference<android.content.Context> r3 = r9.f83
                java.lang.Object r3 = r3.get()
                android.content.Context r3 = (android.content.Context) r3
                r2.<init>(r1, r3)
                r1.putAll(r2)
                java.util.Map<java.lang.String, java.lang.Object> r1 = r9.f86     // Catch:{ IOException -> 0x006d, Throwable -> 0x0064 }
                java.lang.String r2 = "appsflyerKey"
                java.lang.Object r1 = r1.get(r2)     // Catch:{ IOException -> 0x006d, Throwable -> 0x0064 }
                r5 = r1
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x006d, Throwable -> 0x0064 }
                java.util.Map<java.lang.String, java.lang.Object> r1 = r9.f86     // Catch:{ IOException -> 0x006d, Throwable -> 0x0064 }
                monitor-enter(r1)     // Catch:{ IOException -> 0x006d, Throwable -> 0x0064 }
                java.util.Map<java.lang.String, java.lang.Object> r2 = r9.f86     // Catch:{ all -> 0x0061 }
                org.json.JSONObject r2 = com.appsflyer.AFHelper.convertToJsonObject(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0061 }
                monitor-exit(r1)     // Catch:{ all -> 0x0061 }
                com.appsflyer.AppsFlyerLibCore r2 = com.appsflyer.AppsFlyerLibCore.this     // Catch:{ IOException -> 0x006d, Throwable -> 0x0064 }
                java.lang.String r3 = r9.f85     // Catch:{ IOException -> 0x006d, Throwable -> 0x0064 }
                java.lang.ref.WeakReference<android.content.Context> r6 = r9.f83     // Catch:{ IOException -> 0x006d, Throwable -> 0x0064 }
                r7 = 0
                boolean r8 = r9.f82     // Catch:{ IOException -> 0x006d, Throwable -> 0x0064 }
                r4 = r0
                com.appsflyer.AppsFlyerLibCore.m87(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ IOException -> 0x006d, Throwable -> 0x0064 }
                return
            L_0x0061:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ IOException -> 0x006d, Throwable -> 0x0064 }
                throw r2     // Catch:{ IOException -> 0x006d, Throwable -> 0x0064 }
            L_0x0064:
                r0 = move-exception
                java.lang.String r1 = r0.getMessage()
                com.appsflyer.AFLogger.afErrorLog(r1, r0)
                return
            L_0x006d:
                r1 = move-exception
                java.lang.String r2 = "Exception while sending request to server. "
                com.appsflyer.AFLogger.afErrorLog(r2, r1)
                if (r0 == 0) goto L_0x00a2
                java.lang.ref.WeakReference<android.content.Context> r2 = r9.f83
                if (r2 == 0) goto L_0x00a2
                java.lang.String r2 = r9.f85
                java.lang.String r3 = "&isCachedRequest=true&timeincache="
                boolean r2 = r2.contains(r3)
                if (r2 != 0) goto L_0x00a2
                com.appsflyer.cache.CacheManager r2 = com.appsflyer.cache.CacheManager.getInstance()
                com.appsflyer.cache.RequestCacheData r3 = new com.appsflyer.cache.RequestCacheData
                java.lang.String r4 = r9.f85
                java.lang.String r5 = "4.10.0"
                r3.<init>(r4, r0, r5)
                java.lang.ref.WeakReference<android.content.Context> r0 = r9.f83
                java.lang.Object r0 = r0.get()
                android.content.Context r0 = (android.content.Context) r0
                r2.cacheRequest(r3, r0)
                java.lang.String r0 = r1.getMessage()
                com.appsflyer.AFLogger.afErrorLog(r0, r1)
            L_0x00a2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.c.run():void");
        }
    }

    class e extends d {
        public e(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
            super(context, str, scheduledExecutorService);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final String m106() {
            return ServerConfigHandler.getUrl("https://%sapi.%s/install_data/v3/");
        }

        /* access modifiers changed from: protected */
        /* renamed from: ˏ  reason: contains not printable characters */
        public final void m108(Map<String, String> map) {
            map.put("is_first_launch", Boolean.toString(true));
            AppsFlyerLibCore.f36.onInstallConversionDataLoaded(map);
            AppsFlyerLibCore.m77(this.f89.get(), "appsflyerConversionDataRequestRetries", 0);
        }

        /* access modifiers changed from: protected */
        /* renamed from: ˋ  reason: contains not printable characters */
        public final void m107(String str, int i) {
            AppsFlyerLibCore.f36.onInstallConversionFailure(str);
            if (i >= 400 && i < 500) {
                AppsFlyerLibCore.m77(this.f89.get(), "appsflyerConversionDataRequestRetries", AppsFlyerLibCore.m46(this.f89.get()).getInt("appsflyerConversionDataRequestRetries", 0) + 1);
            }
        }
    }

    abstract class d implements Runnable {

        /* renamed from: ˊ  reason: contains not printable characters */
        private ScheduledExecutorService f88;

        /* renamed from: ˋ  reason: contains not printable characters */
        WeakReference<Context> f89 = null;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f91;

        /* renamed from: ॱ  reason: contains not printable characters */
        private AtomicInteger f92 = new AtomicInteger(0);

        /* renamed from: ˊ  reason: contains not printable characters */
        public abstract String m103();

        /* access modifiers changed from: protected */
        /* renamed from: ˋ  reason: contains not printable characters */
        public abstract void m104(String str, int i);

        /* access modifiers changed from: protected */
        /* renamed from: ˏ  reason: contains not printable characters */
        public abstract void m105(Map<String, String> map);

        d(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
            this.f89 = new WeakReference<>(context);
            this.f91 = str;
            if (scheduledExecutorService == null) {
                this.f88 = AFExecutor.getInstance().m24();
            } else {
                this.f88 = scheduledExecutorService;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00a0 A[Catch:{ Throwable -> 0x0242 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0100 A[Catch:{ Throwable -> 0x023c, all -> 0x023a }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0121 A[Catch:{ Throwable -> 0x023c, all -> 0x023a }] */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0203 A[Catch:{ Throwable -> 0x023c, all -> 0x023a }] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0236  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0249 A[Catch:{ all -> 0x023f }] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x025e  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x026e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r15 = this;
                java.lang.String r0 = "af_siteid"
                java.lang.String r1 = r15.f91
                if (r1 == 0) goto L_0x0272
                int r1 = r1.length()
                if (r1 != 0) goto L_0x000e
                goto L_0x0272
            L_0x000e:
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                boolean r1 = r1.isTrackingStopped()
                if (r1 == 0) goto L_0x0017
                return
            L_0x0017:
                java.util.concurrent.atomic.AtomicInteger r1 = r15.f92
                r1.incrementAndGet()
                r1 = 0
                r2 = 0
                java.lang.ref.WeakReference<android.content.Context> r3 = r15.f89     // Catch:{ Throwable -> 0x0242 }
                java.lang.Object r3 = r3.get()     // Catch:{ Throwable -> 0x0242 }
                android.content.Context r3 = (android.content.Context) r3     // Catch:{ Throwable -> 0x0242 }
                if (r3 != 0) goto L_0x002e
                java.util.concurrent.atomic.AtomicInteger r0 = r15.f92
                r0.decrementAndGet()
                return
            L_0x002e:
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0242 }
                java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ Throwable -> 0x0242 }
                r6.<init>(r3)     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r6 = com.appsflyer.AppsFlyerLibCore.m57((java.lang.ref.WeakReference<android.content.Context>) r6)     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r6 = com.appsflyer.AppsFlyerLibCore.m42(r3, r6)     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r7 = ""
                r8 = 1
                if (r6 == 0) goto L_0x006a
                java.util.List r9 = com.appsflyer.AppsFlyerLibCore.f32     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r10 = r6.toLowerCase()     // Catch:{ Throwable -> 0x0242 }
                boolean r9 = r9.contains(r10)     // Catch:{ Throwable -> 0x0242 }
                if (r9 != 0) goto L_0x005d
                java.lang.String r9 = "-"
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r6 = r9.concat(r6)     // Catch:{ Throwable -> 0x0242 }
                goto L_0x006b
            L_0x005d:
                java.lang.String r9 = "AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix."
                java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x0242 }
                r10[r2] = r6     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r6 = java.lang.String.format(r9, r10)     // Catch:{ Throwable -> 0x0242 }
                com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ Throwable -> 0x0242 }
            L_0x006a:
                r6 = r7
            L_0x006b:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0242 }
                r9.<init>()     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r10 = r15.m103()     // Catch:{ Throwable -> 0x0242 }
                r9.append(r10)     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r10 = r3.getPackageName()     // Catch:{ Throwable -> 0x0242 }
                r9.append(r10)     // Catch:{ Throwable -> 0x0242 }
                r9.append(r6)     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r6 = "?devkey="
                r9.append(r6)     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r6 = r15.f91     // Catch:{ Throwable -> 0x0242 }
                r9.append(r6)     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r6 = "&device_id="
                r9.append(r6)     // Catch:{ Throwable -> 0x0242 }
                java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ Throwable -> 0x0242 }
                r6.<init>(r3)     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r6 = com.appsflyer.internal.u.m186(r6)     // Catch:{ Throwable -> 0x0242 }
                r9.append(r6)     // Catch:{ Throwable -> 0x0242 }
                com.appsflyer.internal.x r6 = com.appsflyer.internal.x.f258     // Catch:{ Throwable -> 0x0242 }
                if (r6 != 0) goto L_0x00a7
                com.appsflyer.internal.x r6 = new com.appsflyer.internal.x     // Catch:{ Throwable -> 0x0242 }
                r6.<init>()     // Catch:{ Throwable -> 0x0242 }
                com.appsflyer.internal.x.f258 = r6     // Catch:{ Throwable -> 0x0242 }
            L_0x00a7:
                com.appsflyer.internal.x r6 = com.appsflyer.internal.x.f258     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r10 = r9.toString()     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r11 = "server_request"
                java.lang.String[] r12 = new java.lang.String[r8]     // Catch:{ Throwable -> 0x0242 }
                r12[r2] = r7     // Catch:{ Throwable -> 0x0242 }
                r6.m205(r11, r10, r12)     // Catch:{ Throwable -> 0x0242 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r7 = "Calling server for attribution url: "
                r6.<init>(r7)     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r7 = r9.toString()     // Catch:{ Throwable -> 0x0242 }
                r6.append(r7)     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x0242 }
                com.appsflyer.AFExecutor.AnonymousClass2.AnonymousClass1.m27(r6)     // Catch:{ Throwable -> 0x0242 }
                java.net.URL r6 = new java.net.URL     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r7 = r9.toString()     // Catch:{ Throwable -> 0x0242 }
                r6.<init>(r7)     // Catch:{ Throwable -> 0x0242 }
                java.net.URLConnection r6 = r6.openConnection()     // Catch:{ Throwable -> 0x0242 }
                java.lang.Object r6 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r6)     // Catch:{ Throwable -> 0x0242 }
                java.net.URLConnection r6 = (java.net.URLConnection) r6     // Catch:{ Throwable -> 0x0242 }
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Throwable -> 0x0242 }
                java.lang.String r1 = "GET"
                r6.setRequestMethod(r1)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r1 = 10000(0x2710, float:1.4013E-41)
                r6.setConnectTimeout(r1)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r1 = "Connection"
                java.lang.String r7 = "close"
                r6.setRequestProperty(r1, r7)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r6.connect()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                int r1 = r6.getResponseCode()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r7 = com.appsflyer.AppsFlyerLibCore.m81((java.net.HttpURLConnection) r6)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                com.appsflyer.internal.x r10 = com.appsflyer.internal.x.f258     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                if (r10 != 0) goto L_0x0107
                com.appsflyer.internal.x r10 = new com.appsflyer.internal.x     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r10.<init>()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                com.appsflyer.internal.x.f258 = r10     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
            L_0x0107:
                com.appsflyer.internal.x r10 = com.appsflyer.internal.x.f258     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r11 = r9.toString()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r12 = "server_response"
                r13 = 2
                java.lang.String[] r13 = new java.lang.String[r13]     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r14 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r13[r2] = r14     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r13[r8] = r7     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r10.m205(r12, r11, r13)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r10 = 200(0xc8, float:2.8E-43)
                if (r1 != r10) goto L_0x0203
                long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r1 = "appsflyerGetConversionDataTiming"
                long r9 = r9 - r4
                com.appsflyer.AppsFlyerLibCore.m68(r3, r1, r9)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r1 = "Attribution data: "
                java.lang.String r4 = java.lang.String.valueOf(r7)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r1 = r1.concat(r4)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                com.appsflyer.AFExecutor.AnonymousClass2.AnonymousClass1.m27(r1)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                int r1 = r7.length()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                if (r1 <= 0) goto L_0x022f
                if (r3 == 0) goto L_0x022f
                java.util.Map r1 = com.appsflyer.AppsFlyerLibCore.m75((java.lang.String) r7)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r4 = "iscache"
                java.lang.Object r4 = r1.get(r4)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                if (r4 == 0) goto L_0x0161
                java.lang.String r5 = java.lang.Boolean.toString(r2)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                boolean r5 = r5.equals(r4)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                if (r5 == 0) goto L_0x0161
                java.lang.String r5 = "appsflyerConversionDataCacheExpiration"
                long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                com.appsflyer.AppsFlyerLibCore.m68(r3, r5, r9)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
            L_0x0161:
                boolean r5 = r1.containsKey(r0)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r9 = "[Invite] Detected App-Invite via channel: "
                java.lang.String r10 = "af_channel"
                if (r5 == 0) goto L_0x0198
                boolean r5 = r1.containsKey(r10)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                if (r5 == 0) goto L_0x0187
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r5.<init>(r9)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.Object r11 = r1.get(r10)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r11 = (java.lang.String) r11     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r5.append(r11)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                com.appsflyer.AFLogger.afDebugLog(r5)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                goto L_0x0198
            L_0x0187:
                java.lang.String r5 = "[CrossPromotion] App was installed via %s's Cross Promotion"
                java.lang.Object[] r11 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.Object r12 = r1.get(r0)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r11[r2] = r12     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r5 = java.lang.String.format(r5, r11)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                com.appsflyer.AFLogger.afDebugLog(r5)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
            L_0x0198:
                boolean r0 = r1.containsKey(r0)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                if (r0 == 0) goto L_0x01b3
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r0.<init>(r9)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.Object r5 = r1.get(r10)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r0.append(r5)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
            L_0x01b3:
                java.lang.String r0 = "is_first_launch"
                java.lang.String r5 = java.lang.Boolean.toString(r2)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r1.put(r0, r5)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r0.<init>(r1)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r5 = "attributionId"
                if (r0 == 0) goto L_0x01cd
                com.appsflyer.AppsFlyerLibCore.m60(r3, r5, r0)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                goto L_0x01d0
            L_0x01cd:
                com.appsflyer.AppsFlyerLibCore.m60(r3, r5, r7)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
            L_0x01d0:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r5 = "iscache="
                r0.<init>(r5)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r0.append(r4)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r4 = " caching conversion data"
                r0.append(r4)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                com.appsflyer.AppsFlyerConversionListener r0 = com.appsflyer.AppsFlyerLibCore.f36     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                if (r0 == 0) goto L_0x022f
                java.util.concurrent.atomic.AtomicInteger r0 = r15.f92     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                int r0 = r0.intValue()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                if (r0 > r8) goto L_0x022f
                java.util.Map r1 = com.appsflyer.AppsFlyerLibCore.m66((android.content.Context) r3)     // Catch:{ s -> 0x01f9 }
                goto L_0x01ff
            L_0x01f9:
                r0 = move-exception
                java.lang.String r3 = "Exception while trying to fetch attribution data. "
                com.appsflyer.AFLogger.afErrorLog(r3, r0)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
            L_0x01ff:
                r15.m105(r1)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                goto L_0x022f
            L_0x0203:
                com.appsflyer.AppsFlyerConversionListener r0 = com.appsflyer.AppsFlyerLibCore.f36     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                if (r0 == 0) goto L_0x0216
                java.lang.String r0 = "Error connection to server: "
                java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r0 = r0.concat(r3)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r15.m104(r0, r1)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
            L_0x0216:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r3 = "AttributionIdFetcher response code: "
                r0.<init>(r3)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r0.append(r1)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r1 = "  url: "
                r0.append(r1)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                r0.append(r9)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
                com.appsflyer.AFExecutor.AnonymousClass2.AnonymousClass1.m27(r0)     // Catch:{ Throwable -> 0x023c, all -> 0x023a }
            L_0x022f:
                java.util.concurrent.atomic.AtomicInteger r0 = r15.f92
                r0.decrementAndGet()
                if (r6 == 0) goto L_0x0261
                r6.disconnect()
                goto L_0x0261
            L_0x023a:
                r0 = move-exception
                goto L_0x0267
            L_0x023c:
                r0 = move-exception
                r1 = r6
                goto L_0x0243
            L_0x023f:
                r0 = move-exception
                r6 = r1
                goto L_0x0267
            L_0x0242:
                r0 = move-exception
            L_0x0243:
                com.appsflyer.AppsFlyerConversionListener r3 = com.appsflyer.AppsFlyerLibCore.f36     // Catch:{ all -> 0x023f }
                if (r3 == 0) goto L_0x0250
                java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x023f }
                r15.m104(r3, r2)     // Catch:{ all -> 0x023f }
            L_0x0250:
                java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x023f }
                com.appsflyer.AFLogger.afErrorLog(r2, r0)     // Catch:{ all -> 0x023f }
                java.util.concurrent.atomic.AtomicInteger r0 = r15.f92
                r0.decrementAndGet()
                if (r1 == 0) goto L_0x0261
                r1.disconnect()
            L_0x0261:
                java.util.concurrent.ScheduledExecutorService r0 = r15.f88
                r0.shutdown()
                return
            L_0x0267:
                java.util.concurrent.atomic.AtomicInteger r1 = r15.f92
                r1.decrementAndGet()
                if (r6 == 0) goto L_0x0271
                r6.disconnect()
            L_0x0271:
                throw r0
            L_0x0272:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.d.run():void");
        }
    }

    class a implements Runnable {

        /* renamed from: ˏ  reason: contains not printable characters */
        private WeakReference<Context> f71 = null;

        public a(Context context) {
            this.f71 = new WeakReference<>(context);
        }

        public final void run() {
            if (!AppsFlyerLibCore.this.f44) {
                long unused = AppsFlyerLibCore.this.f43 = System.currentTimeMillis();
                if (this.f71 != null) {
                    boolean unused2 = AppsFlyerLibCore.this.f44 = true;
                    try {
                        String r1 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
                        synchronized (this.f71) {
                            for (RequestCacheData next : CacheManager.getInstance().getCachedRequests(this.f71.get())) {
                                StringBuilder sb = new StringBuilder("resending request: ");
                                sb.append(next.getRequestURL());
                                AFLogger.afInfoLog(sb.toString());
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long parseLong = Long.parseLong(next.getCacheKey(), 10);
                                    AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(next.getRequestURL());
                                    sb2.append("&isCachedRequest=true&timeincache=");
                                    sb2.append(Long.toString((currentTimeMillis - parseLong) / 1000));
                                    AppsFlyerLibCore.m87(appsFlyerLibCore, sb2.toString(), next.getPostData(), r1, this.f71, next.getCacheKey(), false);
                                } catch (Exception e2) {
                                    AFLogger.afErrorLog("Failed to resend cached request", e2);
                                }
                            }
                        }
                    } catch (Exception e3) {
                        try {
                            AFLogger.afErrorLog("failed to check cache. ", e3);
                        } catch (Throwable th) {
                            boolean unused3 = AppsFlyerLibCore.this.f44 = false;
                            throw th;
                        }
                    }
                    boolean unused4 = AppsFlyerLibCore.this.f44 = false;
                    AppsFlyerLibCore.this.f45.shutdown();
                    ScheduledExecutorService unused5 = AppsFlyerLibCore.this.f45 = null;
                }
            }
        }
    }

    public String getSdkVersion() {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "getSdkVersion", new String[0]);
        return "version: 4.10.0 (build 197)";
    }

    @Deprecated
    public void setGCMProjectID(String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setGCMProjectID", str);
        AFLogger.afWarnLog("Method 'setGCMProjectNumber' is deprecated. Please follow the documentation.");
        enableUninstallTracking(str);
    }

    @Deprecated
    public void setGCMProjectNumber(String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setGCMProjectNumber", str);
        AFLogger.afWarnLog("Method 'setGCMProjectNumber' is deprecated. Please follow the documentation.");
        enableUninstallTracking(str);
    }

    @Deprecated
    public void setGCMProjectNumber(Context context, String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setGCMProjectNumber", str);
        AFLogger.afWarnLog("Method 'setGCMProjectNumber' is deprecated. Please use 'enableUninstallTracking'.");
        enableUninstallTracking(str);
    }

    public void enableUninstallTracking(String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "enableUninstallTracking", str);
        AppsFlyerProperties.getInstance().set("gcmProjectNumber", str);
    }

    public void setDebugLog(boolean z) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setDebugLog", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("shouldLog", z);
        AppsFlyerProperties.getInstance().set("logLevel", (z ? AFLogger.LogLevel.DEBUG : AFLogger.LogLevel.NONE).getLevel());
    }

    public void setImeiData(String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setImeiData", str);
        this.f56 = str;
    }

    public void setAndroidIdData(String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setAndroidIdData", str);
        this.f50 = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m60(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
        edit.putString(str, str2);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m77(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
        edit.putInt(str, i);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m68(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
        edit.putLong(str, j);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    @Deprecated
    public void setAppUserId(String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setAppUserId", str);
        setCustomerUserId(str);
    }

    public void setCustomerIdAndTrack(String str, Context context) {
        Intent intent;
        if (context != null) {
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false) && AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID) == null) {
                setCustomerUserId(str);
                AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
                StringBuilder sb = new StringBuilder("CustomerUserId set: ");
                sb.append(str);
                sb.append(" - Initializing AppsFlyer Tacking");
                AFLogger.afInfoLog(sb.toString(), true);
                String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
                String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
                if (referrer == null) {
                    referrer = "";
                }
                String str2 = referrer;
                if (context instanceof Activity) {
                    intent = ((Activity) context).getIntent();
                } else {
                    intent = null;
                }
                m70(context, string, (String) null, (String) null, str2, intent, (String) null);
                if (AppsFlyerProperties.getInstance().getString("afUninstallToken") != null) {
                    m94(context, AppsFlyerProperties.getInstance().getString("afUninstallToken"));
                    return;
                }
                return;
            }
            setCustomerUserId(str);
            AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
        }
    }

    public void setAppInviteOneLink(String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setAppInviteOneLink", str);
        AFLogger.afInfoLog("setAppInviteOneLink = ".concat(String.valueOf(str)));
        if (str == null || !str.equals(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID))) {
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_DOMAIN);
            AppsFlyerProperties.getInstance().remove("onelinkVersion");
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_SCHEME);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_ID, str);
    }

    public void setAdditionalData(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            if (x.f258 == null) {
                x.f258 = new x();
            }
            x.f258.m205("public_api_call", "setAdditionalData", hashMap.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject(hashMap).toString());
        }
    }

    @Deprecated
    public void setUserEmail(String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setUserEmail", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.USER_EMAIL, str);
    }

    public void setUserEmails(String... strArr) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
    }

    public void setCollectAndroidID(boolean z) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setCollectAndroidID", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z));
    }

    public void setCollectIMEI(boolean z) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setCollectIMEI", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z));
    }

    @Deprecated
    public void setCollectFingerPrint(boolean z) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setCollectFingerPrint", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_FINGER_PRINT, Boolean.toString(z));
    }

    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x xVar = x.f258;
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = appsFlyerConversionListener == null ? "null" : "conversionDataListener";
        xVar.m205("public_api_call", "init", strArr);
        AFLogger.m34(String.format("Initializing AppsFlyer SDK: (v%s.%s)", new Object[]{BuildConfig.VERSION_NAME, "197"}));
        this.f52 = true;
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str);
        AFExecutor.AnonymousClass2.AnonymousClass1.m26(str);
        f36 = appsFlyerConversionListener;
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m89(Context context) {
        if (m44(context.getApplicationContext().getSharedPreferences("appsflyer-data", 0), "appsFlyerCount", false) > 2) {
            AFLogger.afRDLog("Install referrer will not load, the counter > 2, ");
            return false;
        }
        try {
            Class.forName("com.android.a.a.a");
            if (AFExecutor.AnonymousClass2.m25(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.afDebugLog("Install referrer is allowed");
                return true;
            }
            AFLogger.afDebugLog("Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException unused) {
            AFLogger.afRDLog("Class com.android.installreferrer.api.InstallReferrerClient not found");
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest : com.android.installreferrer.api.InstallReferrerClient", th);
            return false;
        }
    }

    public void startTracking(Application application, String str, AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "startTracking", str);
        AFLogger.afInfoLog(String.format("Starting AppsFlyer Tracking: (v%s.%s)", new Object[]{BuildConfig.VERSION_NAME, "197"}));
        AFLogger.afInfoLog("Build Number: 197");
        AppsFlyerProperties.getInstance().loadProperties(application.getApplicationContext());
        if (!TextUtils.isEmpty(str)) {
            AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str);
            AFExecutor.AnonymousClass2.AnonymousClass1.m26(str);
        } else if (TextUtils.isEmpty(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY))) {
            AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the startTracking API method (should be called on Activity's onCreate).");
            return;
        }
        if (appsFlyerTrackingRequestListener != null) {
            f35 = appsFlyerTrackingRequestListener;
        }
        Context baseContext = application.getBaseContext();
        try {
            if ((baseContext.getPackageManager().getPackageInfo(baseContext.getPackageName(), 0).applicationInfo.flags & TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG) != 0) {
                if (baseContext.getResources().getIdentifier("appsflyer_backup_rules", "xml", baseContext.getPackageName()) != 0) {
                    AFLogger.afInfoLog("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                } else {
                    AFLogger.m36("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
                }
            }
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("checkBackupRules Exception: ");
            sb.append(e2.toString());
            AFLogger.afRDLog(sb.toString());
        }
        m84(application);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        	at java.util.ArrayList.get(ArrayList.java:433)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:695)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:695)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m59(android.content.Context r4) {
        /*
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r1 = "OPPO"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0012
            r0 = 23
            java.lang.String r1 = "OPPO device found"
            com.appsflyer.AFLogger.afRDLog(r1)
            goto L_0x0014
        L_0x0012:
            r0 = 18
        L_0x0014:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x00c9
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            r1 = 0
            java.lang.String r2 = "keyPropDisableAFKeystore"
            boolean r0 = r0.getBoolean(r2, r1)
            if (r0 != 0) goto L_0x00c9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "OS SDK is="
            r0.<init>(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r0.append(r2)
            java.lang.String r2 = "; use KeyStore"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afRDLog(r0)
            com.appsflyer.AFKeystoreWrapper r0 = new com.appsflyer.AFKeystoreWrapper
            r0.<init>(r4)
            boolean r2 = r0.m32()
            if (r2 != 0) goto L_0x005d
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r2.<init>(r4)
            java.lang.String r4 = com.appsflyer.internal.u.m186(r2)
            r0.f22 = r4
            r0.f23 = r1
            java.lang.String r4 = r0.m29()
            r0.m31(r4)
            goto L_0x00a7
        L_0x005d:
            java.lang.String r4 = r0.m29()
            java.lang.Object r1 = r0.f24
            monitor-enter(r1)
            int r2 = r0.f23     // Catch:{ all -> 0x00c6 }
            int r2 = r2 + 1
            r0.f23 = r2     // Catch:{ all -> 0x00c6 }
            java.lang.String r2 = "Deleting key with alias: "
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x00c6 }
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ all -> 0x00c6 }
            java.lang.Object r2 = r0.f24     // Catch:{ KeyStoreException -> 0x0084 }
            monitor-enter(r2)     // Catch:{ KeyStoreException -> 0x0084 }
            java.security.KeyStore r3 = r0.f20     // Catch:{ all -> 0x0081 }
            r3.deleteEntry(r4)     // Catch:{ all -> 0x0081 }
            monitor-exit(r2)     // Catch:{ all -> 0x0081 }
            goto L_0x009f
        L_0x0081:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ KeyStoreException -> 0x0084 }
            throw r4     // Catch:{ KeyStoreException -> 0x0084 }
        L_0x0084:
            r4 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = "Exception "
            r2.<init>(r3)     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = r4.getMessage()     // Catch:{ all -> 0x00c6 }
            r2.append(r3)     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = " occurred"
            r2.append(r3)     // Catch:{ all -> 0x00c6 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c6 }
            com.appsflyer.AFLogger.afErrorLog(r2, r4)     // Catch:{ all -> 0x00c6 }
        L_0x009f:
            monitor-exit(r1)     // Catch:{ all -> 0x00c6 }
            java.lang.String r4 = r0.m29()
            r0.m31(r4)
        L_0x00a7:
            java.lang.String r4 = r0.m30()
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "KSAppsFlyerId"
            r1.set((java.lang.String) r2, (java.lang.String) r4)
            int r4 = r0.m33()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "KSAppsFlyerRICounter"
            r0.set((java.lang.String) r1, (java.lang.String) r4)
            return
        L_0x00c6:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        L_0x00c9:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "OS SDK is="
            r4.<init>(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r4.append(r0)
            java.lang.String r0 = "; no KeyStore usage"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.afRDLog(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m59(android.content.Context):void");
    }

    public void setCustomerUserId(String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_USER_ID, str);
    }

    public void setAppId(String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setAppId", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_ID, str);
    }

    public void setExtension(String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setExtension", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    public void setIsUpdate(boolean z) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setIsUpdate", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
    }

    public void setCurrencyCode(String str) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
    }

    public void trackLocation(Context context, double d2, double d3) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "trackLocation", String.valueOf(d2), String.valueOf(d3));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d3));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d2));
        m96(context, AFInAppEventType.LOCATION_COORDINATES, (Map<String, Object>) hashMap);
    }

    public void reportTrackSession(Context context) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "reportTrackSession", new String[0]);
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.f279 = false;
        m96(context, (String) null, (Map<String, Object>) null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m94(Context context, String str) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false) && AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID) == null) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        HashMap hashMap = new HashMap();
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        if (string == null) {
            AFLogger.afWarnLog("[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            hashMap.put("app_version_name", packageInfo.versionName);
            hashMap.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            long j = packageInfo.firstInstallTime;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            hashMap.put("installDate", simpleDateFormat.format(new Date(j)));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Exception while collecting application version info.", th);
        }
        m61(context, (Map<String, ? super String>) hashMap);
        String string2 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string2 != null) {
            hashMap.put("appUserId", string2);
        }
        try {
            hashMap.put("model", Build.MODEL);
            hashMap.put("brand", Build.BRAND);
        } catch (Throwable th2) {
            AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        n r2 = r.m178(context.getContentResolver());
        if (r2 != null) {
            hashMap.put("amazon_aid", r2.f202);
            hashMap.put("amazon_aid_limit", String.valueOf(r2.f203));
        }
        String string3 = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        if (string3 != null) {
            hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string3);
        }
        hashMap.put("devkey", string);
        hashMap.put("uid", u.m186(new WeakReference(context)));
        hashMap.put("af_gcm_token", str);
        hashMap.put("launch_counter", Integer.toString(m44(context.getApplicationContext().getSharedPreferences("appsflyer-data", 0), "appsFlyerCount", false)));
        hashMap.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Integer.toString(Build.VERSION.SDK_INT));
        String r13 = m57((WeakReference<Context>) new WeakReference(context));
        if (r13 != null) {
            hashMap.put(AppsFlyerProperties.CHANNEL, r13);
        }
        try {
            q qVar = new q(context, isTrackingStopped());
            qVar.f237 = hashMap;
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl(f34));
            sb.append(packageName);
            qVar.execute(new String[]{sb.toString()});
        } catch (Throwable th3) {
            AFLogger.afErrorLog(th3.getMessage(), th3);
        }
    }

    public void setDeviceTrackingDisabled(boolean z) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "setDeviceTrackingDisabled", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public static Map<String, String> m66(Context context) throws s {
        String string = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).getString("attributionId", (String) null);
        if (string != null && string.length() > 0) {
            return m75(string);
        }
        throw new s();
    }

    public void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "registerConversionListener", new String[0]);
        if (appsFlyerConversionListener != null) {
            f36 = appsFlyerConversionListener;
        }
    }

    public void unregisterConversionListener() {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "unregisterConversionListener", new String[0]);
        f36 = null;
    }

    public void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            AFLogger.afDebugLog("registerValidatorListener null listener");
        } else {
            f31 = appsFlyerInAppPurchaseValidatorListener;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m42(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
        if (sharedPreferences.contains("CACHED_CHANNEL")) {
            return sharedPreferences.getString("CACHED_CHANNEL", (String) null);
        }
        m60(context, "CACHED_CHANNEL", str);
        return str;
    }

    public String getAppsFlyerUID(Context context) {
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205("public_api_call", "getAppsFlyerUID", new String[0]);
        return u.m186(new WeakReference(context));
    }

    public void validateAndTrackInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Context context2 = context;
        String str6 = str3;
        String str7 = str4;
        String str8 = str5;
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x xVar = x.f258;
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str6;
        strArr[3] = str7;
        strArr[4] = str8;
        strArr[5] = map == null ? "" : map.toString();
        xVar.m205("public_api_call", "validateAndTrackInAppPurchase", strArr);
        if (!isTrackingStopped()) {
            StringBuilder sb = new StringBuilder("Validate in app called with parameters: ");
            sb.append(str6);
            sb.append(SQLBuilder.BLANK);
            sb.append(str7);
            sb.append(SQLBuilder.BLANK);
            sb.append(str8);
            AFLogger.afInfoLog(sb.toString());
        }
        if (str == null || str7 == null || str2 == null || str8 == null || str6 == null) {
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = f31;
            if (appsFlyerInAppPurchaseValidatorListener != null) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                return;
            }
            return;
        }
        m79(AFExecutor.getInstance().m24(), new l(context.getApplicationContext(), AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY), str, str2, str3, str4, str5, map, context2 instanceof Activity ? ((Activity) context2).getIntent() : null), 10, TimeUnit.MILLISECONDS);
    }

    public void setHost(String str, String str2) {
        if (str != null) {
            AppsFlyerProperties.getInstance().set("custom_host_prefix", str);
        }
        if (str2 == null || str2.isEmpty()) {
            AFLogger.afWarnLog("hostName cannot be null or empty");
        } else {
            AppsFlyerProperties.getInstance().set("custom_host", str2);
        }
    }

    public String getHostName() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host");
        return string != null ? string : ServerParameters.DEFAULT_HOST;
    }

    @Deprecated
    public void setHostName(String str) {
        AppsFlyerProperties.getInstance().set("custom_host", str);
    }

    public String getHostPrefix() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host_prefix");
        return string != null ? string : "";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static /* synthetic */ void m62(Map map) {
        AppsFlyerConversionListener appsFlyerConversionListener = f36;
        if (appsFlyerConversionListener != null) {
            try {
                appsFlyerConversionListener.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static /* synthetic */ void m86(AppsFlyerLibCore appsFlyerLibCore, Context context, String str, String str2, String str3, String str4, boolean z, boolean z2, Intent intent, String str5) {
        String str6;
        ScheduledExecutorService scheduledExecutorService;
        AppsFlyerLibCore appsFlyerLibCore2 = appsFlyerLibCore;
        if (context == null) {
            AFLogger.afDebugLog("sendTrackingWithEvent - got null context. skipping event/launch.");
            return;
        }
        int i = 0;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
        AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
        if (!appsFlyerLibCore.isTrackingStopped()) {
            StringBuilder sb = new StringBuilder("sendTrackingWithEvent from activity: ");
            sb.append(context.getClass().getName());
            AFLogger.afInfoLog(sb.toString());
        }
        boolean z3 = true;
        boolean z4 = str2 == null;
        Map<String, Object> r1 = appsFlyerLibCore.m93(context, str, str2, str3, str4, z, sharedPreferences, z4, intent, str5);
        String str7 = (String) r1.get("appsflyerKey");
        if (str7 == null || str7.length() == 0) {
            AFLogger.afDebugLog("Not sending data yet, waiting for dev key");
            return;
        }
        if (!appsFlyerLibCore.isTrackingStopped()) {
            AFLogger.afInfoLog("AppsFlyerLib.sendTrackingWithEvent");
        }
        if (!z4) {
            str6 = ServerConfigHandler.getUrl(f33);
        } else if (z2) {
            str6 = ServerConfigHandler.getUrl(f39);
        } else {
            str6 = ServerConfigHandler.getUrl(f30);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str6);
        sb2.append(context.getPackageName());
        String obj = sb2.toString();
        int r3 = m44(sharedPreferences, "appsFlyerCount", false);
        if (!(AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) && r1.get(ServerParameters.ADVERTISING_ID_PARAM) != null) {
            try {
                if (TextUtils.isEmpty(appsFlyerLibCore2.f50) && r1.remove("android_id") != null) {
                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: android_id");
                }
                if (TextUtils.isEmpty(appsFlyerLibCore2.f56) && r1.remove("imei") != null) {
                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: imei");
                }
            } catch (Exception e2) {
                AFLogger.afErrorLog("failed to remove IMEI or AndroidID key from params; ", e2);
            }
        }
        c cVar = new c(appsFlyerLibCore, obj, r1, context.getApplicationContext(), z4, r3, (byte) 0);
        if (z4 && m89(context)) {
            Map<String, String> map = appsFlyerLibCore2.f42;
            if (map == null || map.size() <= 0) {
                z3 = false;
            }
            if (!z3) {
                i = 500;
                AFLogger.afDebugLog("Failed to get new referrer, wait ...");
            }
        }
        if (AFDeepLinkManager.f2) {
            AFLogger.afRDLog("ESP deeplink: execute launch on SerialExecutor");
            scheduledExecutorService = AFExecutor.getInstance().getSerialExecutor();
        } else {
            scheduledExecutorService = AFExecutor.getInstance().m24();
        }
        m79(scheduledExecutorService, cVar, (long) i, TimeUnit.MILLISECONDS);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static /* synthetic */ boolean m63(AppsFlyerLibCore appsFlyerLibCore) {
        Map<String, String> map = appsFlyerLibCore.f42;
        return map != null && map.size() > 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static /* synthetic */ void m87(AppsFlyerLibCore appsFlyerLibCore, String str, String str2, String str3, WeakReference weakReference, String str4, boolean z) throws IOException {
        String str5 = str;
        URL url = new URL(str5);
        StringBuilder sb = new StringBuilder("url: ");
        sb.append(url.toString());
        AFLogger.afInfoLog(sb.toString());
        AFExecutor.AnonymousClass2.AnonymousClass1.m27("data: ".concat(String.valueOf(str2)));
        m69((Context) weakReference.get(), LOG_TAG, "EVENT_DATA", str2);
        try {
            appsFlyerLibCore.m71(url, str2, str3, weakReference, str4, z);
        } catch (IOException e2) {
            IOException iOException = e2;
            AFLogger.afErrorLog("Exception in sendRequestToServer. ", iOException);
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.USE_HTTP_FALLBACK, false)) {
                appsFlyerLibCore.m71(new URL(str5.replace("https:", "http:")), str2, str3, weakReference, str4, z);
                return;
            }
            StringBuilder sb2 = new StringBuilder("failed to send requeset to server. ");
            sb2.append(iOException.getLocalizedMessage());
            AFLogger.afInfoLog(sb2.toString());
            m69((Context) weakReference.get(), LOG_TAG, "ERROR", iOException.getLocalizedMessage());
            throw iOException;
        }
    }
}
