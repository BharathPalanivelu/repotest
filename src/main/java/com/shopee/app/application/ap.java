package com.shopee.app.application;

import android.content.Context;
import com.facebook.react.modules.network.ReactCookieJarContainer;
import com.garena.f.b;
import com.garena.f.d;
import com.garena.h.f;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.network.b.a;
import com.shopee.app.util.be;
import com.shopee.app.util.e;
import com.shopee.app.util.p;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

public class ap {

    /* renamed from: a  reason: collision with root package name */
    private ReactCookieJarContainer f15864a = new ReactCookieJarContainer();

    ap() {
        this.f15864a.setCookieJar(new be());
    }

    public OkHttpClient.Builder a(Context context) {
        SettingConfigStore settingConfigStore = ar.f().e().settingConfigStore();
        OkHttpClient.Builder cookieJar = new OkHttpClient.Builder().cache(new Cache(new File(context.getCacheDir(), "HTTP_CACHE"), 10485760)).connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).dispatcher(new Dispatcher(p.a())).cookieJar(this.f15864a);
        if (settingConfigStore.isTrackerStoEnabled()) {
            cookieJar.eventListenerFactory(a.f17775a);
        }
        return cookieJar;
    }

    /* access modifiers changed from: package-private */
    public OkHttpClient.Builder a(boolean z) {
        SettingConfigStore settingConfigStore = ar.f().e().settingConfigStore();
        OkHttpClient.Builder cookieJar = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).dispatcher(new Dispatcher(p.a())).cookieJar(this.f15864a);
        if (settingConfigStore.isTrackerStoEnabled()) {
            cookieJar.eventListenerFactory(a.f17775a);
        }
        if (z) {
            cookieJar.certificatePinner(new CertificatePinner.Builder().add("capi.wallet.airpay.com.my", e.d()).add("capi.wallet.airpay.co.id", e.d()).build());
        }
        cookieJar.cache(new Cache(new File(ar.f().getCacheDir(), "REACT_HTTP_CACHE"), 10485760));
        return cookieJar;
    }

    /* access modifiers changed from: package-private */
    public d.a a(com.shopee.app.network.e eVar) {
        return new d.a().a((b) eVar).a((f) new com.shopee.app.network.e.b()).a((com.garena.f.e) eVar);
    }
}
