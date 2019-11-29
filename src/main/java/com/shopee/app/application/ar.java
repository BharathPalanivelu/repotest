package com.shopee.app.application;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import androidx.i.b;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.beetalk.sdk.l;
import com.facebook.applinks.AppLinkData;
import com.facebook.common.util.ByteConstants;
import com.facebook.login.LoginManager;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.network.OkHttpClientFactory;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.soloader.SoLoader;
import com.garena.android.appkit.f.e;
import com.garena.android.gpns.utility.CONSTANT;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakewharton.processphoenix.ProcessPhoenix;
import com.shopee.app.appuser.DaggerUserComponent;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.appuser.UserModule;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.al;
import com.shopee.app.h.f;
import com.shopee.app.h.s;
import com.shopee.app.react.modules.app.data.c;
import com.shopee.app.ui.common.d;
import com.shopee.app.ui.home.HomeActivity_;
import com.shopee.app.ui.home.b.a;
import com.shopee.app.ui.image.j;
import com.shopee.app.util.ShopeeInstallReceiver;
import com.shopee.app.util.bl;
import com.shopee.app.util.bm;
import com.shopee.app.util.i;
import com.shopee.app.util.l;
import com.shopee.app.util.q;
import com.shopee.app.web.WebRegister;
import com.shopee.shopeetracker.utils.Logger;
import com.squareup.a.ab;
import com.squareup.a.o;
import com.squareup.a.w;
import com.tencent.imsdk.BaseConstants;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import okhttp3.Cookie;
import okhttp3.OkHttpClient;

public class ar extends b {

    /* renamed from: c  reason: collision with root package name */
    private static Application f6919c;

    /* renamed from: a  reason: collision with root package name */
    public a f6920a;

    /* renamed from: b  reason: collision with root package name */
    c f6921b;

    /* renamed from: d  reason: collision with root package name */
    private UserComponent f6922d;

    /* renamed from: e  reason: collision with root package name */
    private b f6923e;

    /* renamed from: f  reason: collision with root package name */
    private ao f6924f;

    /* renamed from: g  reason: collision with root package name */
    private w f6925g;

    private void m() {
    }

    public static Context a() {
        return f6919c;
    }

    public static SharedPreferences a(String str) {
        return f6919c.getSharedPreferences(str, 0);
    }

    public void onCreate() {
        if (!ProcessPhoenix.a(this) && !com.google.android.play.core.missingsplits.b.a(this).a()) {
            super.onCreate();
            f6919c = this;
            if (Build.VERSION.SDK_INT >= 28) {
                WebView.setDataDirectorySuffix(q());
            }
            SoLoader.init((Context) this, false);
            try {
                w.a(b((Context) f6919c));
            } catch (Exception unused) {
            }
            q.a((Application) this);
            CookieSyncManager.createInstance(this);
            d();
            this.f6924f = new aq();
            this.f6924f.a(this);
            r();
            s();
            t();
            q.a(e().loggedInUser());
            WebRegister.init();
            if (v()) {
                e.a().a(new Runnable() {
                    public void run() {
                    }
                });
                n();
                o();
                p();
                h();
                c();
                System.setProperty("http.maxConnections", "15");
                b();
                final OkHttpClient a2 = f().l().a(false, false, e().settingConfigStore().certPinningEnabled());
                OkHttpClientProvider.setOkHttpClientFactory(new OkHttpClientFactory() {
                    public OkHttpClient createNewNetworkModuleClient() {
                        return a2;
                    }
                });
                FrescoModule.initializeFresco(this);
                com.garena.reactpush.b.f6699b = true;
                al.a();
                com.shopee.app.i.a.a().b();
                m();
            }
        }
    }

    private void n() {
        AppsFlyerLib instance = AppsFlyerLib.getInstance();
        instance.init("52exGkmASkSHeuRyuFmKeW", (AppsFlyerConversionListener) null, getApplicationContext());
        instance.setCollectIMEI(false);
        instance.setCollectAndroidID(false);
        instance.enableUninstallTracking("808332928752");
        instance.startTracking(this);
        instance.registerConversionListener(this, new AppsFlyerConversionListener() {
            public void onAttributionFailure(String str) {
            }

            public void onInstallConversionFailure(String str) {
            }

            public void onInstallConversionDataLoaded(Map<String, String> map) {
                if (map != null) {
                    boolean z = false;
                    if (map.containsKey("is_first_launch")) {
                        z = Boolean.parseBoolean(map.get("is_first_launch"));
                    }
                    if (z && map.containsKey("af_sub1")) {
                        Uri parse = Uri.parse("deeplink://app?af_sub1=" + bm.a(map.get("af_sub1")));
                        if (com.shopee.app.ui.home.d.e.a(parse.getEncodedQuery()) != null) {
                            ShopeeInstallReceiver.f26121a = parse.getEncodedQuery();
                            ar.f().e().uiEventBus().a().j.a(parse.getEncodedQuery()).a();
                        }
                    }
                }
            }

            public void onAppOpenAttribution(Map<String, String> map) {
                if (map != null) {
                    ar.this.f6921b.a(map.toString());
                }
            }
        });
        AppLinkData.fetchDeferredAppLinkData(this, new AppLinkData.CompletionHandler() {
            public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                if (appLinkData != null) {
                    Uri targetUri = appLinkData.getTargetUri();
                    if (targetUri != null && com.shopee.app.ui.home.d.e.a(targetUri.getEncodedQuery()) != null) {
                        ShopeeInstallReceiver.f26121a = targetUri.getEncodedQuery();
                        ar.f().e().uiEventBus().a().j.a(targetUri.getEncodedQuery()).a();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void b() {
        au.a(this, this.f6922d.settingConfigStore());
    }

    private void o() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            f.a().a(true);
        }
    }

    private void p() {
        d.f7007a *= 1;
        d.f7008b = d.f7008b.multiply(new BigDecimal(1));
    }

    public void c() {
        al loginStore = this.f6922d.loginStore();
        if (loginStore.c()) {
            i.f7040c = "https://mall.test.shopee.co.id/";
            i.f7039b = "api.test.beeshopmobile.com:20346";
            i.f7041d = "http://test.shopee.co.id/";
            i.f7043f = "4c459f3ddbc2d928366a298d4ab85c00a0d1dba2a4b1fb3c9a2f783fb48dfb46";
            l.y = l.a.TEST;
            i.f7038a = "http://203.117.172.181:12030";
            com.shopee.app.util.l.r = l.a.f7052a;
            i.f7044g = "https://c-api-bit.test.shopeemobile.com/id/tr";
        } else if (loginStore.d()) {
            i.f7040c = "https://mall.staging.shopee.co.id/";
            i.f7039b = "api.staging.shopee.co.id:20446";
            i.f7041d = "http://staging.shopee.co.id/";
            i.f7043f = "4c459f3ddbc2d928366a298d4ab85c00a0d1dba2a4b1fb3c9a2f783fb48dfb46";
            com.shopee.app.util.l.y = l.a.TEST;
            i.f7038a = "http://203.117.172.181:12030";
            com.shopee.app.util.l.r = l.a.f7052a;
            i.f7044g = "https://c-api-bit.staging.shopeemobile.com/id/tr";
        } else if (loginStore.f()) {
            i.f7040c = "https://mall.uat.shopee.co.id/";
            i.f7039b = "api.uat.shopee.co.id:20443";
            i.f7041d = "https://uat.shopee.co.id/";
            i.f7043f = "4c459f3ddbc2d928366a298d4ab85c00a0d1dba2a4b1fb3c9a2f783fb48dfb46";
            com.shopee.app.util.l.y = l.a.TEST;
            i.f7038a = "http://203.117.172.181:12030";
            com.shopee.app.util.l.r = l.a.f7052a;
            i.f7044g = "https://c-api-bit.uat.shopeemobile.com/id/tr";
        }
        bl.f7034a.a(loginStore.g());
        TextUtils.isEmpty(loginStore.k());
        TextUtils.isEmpty(loginStore.j());
        TextUtils.isEmpty(loginStore.z());
    }

    private String q() {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        String str = "";
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                str = next.processName;
            }
        }
        return str;
    }

    public void d() {
        this.f6923e = an.a().a(new c(this)).a();
        a(this.f6923e.loginStore().a());
        this.f6922d.inject(this);
    }

    public void a(UserInfo userInfo) {
        this.f6922d = DaggerUserComponent.builder().applicationComponent(this.f6923e).userModule(new UserModule(userInfo)).build();
        new s(userInfo).a();
        FirebaseAnalytics.getInstance(this).a(com.shopee.app.g.c.b(Integer.toString(userInfo.getUserId())));
    }

    public UserComponent e() {
        return this.f6922d;
    }

    public static ar a(Context context) {
        return (ar) context.getApplicationContext();
    }

    public static ar f() {
        return (ar) f6919c;
    }

    public static boolean g() {
        return f6919c != null;
    }

    public void h() {
        if (g()) {
            Resources resources = getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            if (Build.VERSION.SDK_INT >= 17) {
                configuration.setLocale(e().deviceStore().a());
            } else {
                configuration.locale = e().deviceStore().a();
            }
            resources.updateConfiguration(configuration, displayMetrics);
            com.garena.android.appkit.tools.b.a();
        }
    }

    private void r() {
        com.garena.android.appkit.d.a.f6688a = "com.shopee.id";
        com.garena.android.appkit.d.a.f6689b = true;
        com.garena.android.appkit.d.b.f6691a = false;
        com.garena.android.appkit.tools.a.f6696a = this;
        com.garena.android.appkit.d.a.f6690c = true;
        Logger.DEBUG = false;
    }

    private void s() {
        CONSTANT.CONFIG.PUSH_ID = String.valueOf(10022);
        CONSTANT.CONFIG.PUSH_PACKAGE = getPackageName();
    }

    private void t() {
        com.garena.videolib.a.f6703b = "http://cv.shopee.co.id/";
        com.garena.videolib.a.f6702a = "https://v.shopee.co.id/rup";
    }

    public void i() {
        this.f6920a = null;
        this.f6923e.crossUserStatusStore().a(ak.a());
        u();
        CookieManager instance = CookieManager.getInstance();
        List<Cookie> b2 = com.shopee.app.network.http.b.a.b();
        instance.removeAllCookie();
        instance.removeSessionCookie();
        CookieSyncManager.getInstance().sync();
        com.shopee.app.network.http.b.a.a(b2);
        UserInfo userInfo = new UserInfo();
        this.f6923e.loginStore().a(userInfo);
        ak.a().r();
        this.f6922d.tracker().a();
        com.shopee.app.database.b.f().e();
        com.shopee.app.database.b.f().A();
        a(userInfo);
        com.shopee.app.ui.webview.i.a();
        a(false);
    }

    private void u() {
        try {
            LoginManager.getInstance().logOut();
            com.shopee.app.f.a.a().f();
            com.beetalk.sdk.f.d();
        } catch (Exception unused) {
        }
    }

    public static void a(boolean z) {
        try {
            CookieSyncManager.getInstance().sync();
        } catch (Exception unused) {
        }
        if (z) {
            if (f().e().deviceStore().m() == 2) {
                f().e().deviceStore().a(0);
                return;
            }
            f().e().deviceStore().a(f().e().deviceStore().m() + 1);
        }
        final Intent intent = new Intent(f(), HomeActivity_.class);
        if (z) {
            b(intent);
        } else {
            com.garena.android.appkit.f.f.a().a(new Runnable() {
                public void run() {
                    ar.b(intent);
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: private */
    public static void b(Intent intent) {
        try {
            ProcessPhoenix.a(f(), intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void j() {
        final Intent b2 = HomeActivity_.a(f()).a("setting").a(true).b(4).b();
        b2.addFlags(67108864);
        com.garena.android.appkit.f.f.a().a(new Runnable() {
            public void run() {
                ar.b(b2);
            }
        }, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
    }

    public static void k() {
        final Intent b2 = HomeActivity_.a(f()).a("editProfile").b(4).b();
        b2.addFlags(67108864);
        com.garena.android.appkit.f.f.a().a(new Runnable() {
            public void run() {
                ar.b(b2);
            }
        }, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
    }

    private boolean v() {
        return !ProcessPhoenix.a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (v()) {
            h();
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        com.shopee.app.ui.webview.c.p();
    }

    public ao l() {
        return this.f6924f;
    }

    public synchronized w b(Context context) {
        if (this.f6925g == null) {
            this.f6925g = new w.a(context).a((com.squareup.a.d) new o(c(context))).a((ab) new j.a()).a((ab) new j.c()).a((ab) new j.d()).a();
        }
        return this.f6925g;
    }

    static int c(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        return (int) ((((long) ((context.getApplicationInfo().flags & ByteConstants.MB) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * BaseConstants.MEGA) / 15);
    }
}
