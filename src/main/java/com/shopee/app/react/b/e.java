package com.shopee.app.react.b;

import com.airbnb.android.react.maps.o;
import com.facebook.hermes.reactexecutor.HermesExecutorFactory;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.garena.reactpush.c.d;
import com.garena.reactpush.d.c;
import com.garena.reactpush.d.f;
import com.garena.reactpush.d.h;
import com.garena.rnrecyclerview.library.b;
import com.horcrux.svg.SvgPackage;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.react.a.a;
import com.shopee.app.react.g;
import com.shopee.app.react.i;
import com.shopee.id.R;
import iyegoroff.RNTextGradient.RNTextGradientPackage;
import okhttp3.OkHttpClient;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final g f18598a;

    public e(g gVar) {
        this.f18598a = gVar;
    }

    /* access modifiers changed from: package-private */
    public g a() {
        return this.f18598a;
    }

    /* access modifiers changed from: package-private */
    public a a(SettingConfigStore settingConfigStore, al alVar) {
        return new a(settingConfigStore, alVar.a());
    }

    /* access modifiers changed from: package-private */
    public ReactInstanceManager a(a aVar, i iVar, com.shopee.app.react.a aVar2, d dVar, com.garena.reactpush.e.c.a aVar3) {
        ReactInstanceManagerBuilder nativeModuleCallExceptionHandler = ReactInstanceManager.builder().setApplication(this.f18598a.d()).addPackage(new MainReactPackage()).addPackage(aVar2).addPackage(new com.garena.library.reactshadow.a()).addPackage(new b()).addPackage(new com.devfd.RNGeocoder.a()).addPackage(new o()).addPackage(new SvgPackage()).addPackage(new com.dieam.reactnativepushnotification.a()).addPackage(new com.calendarevents.a()).addPackage(new com.arttitude360.reactnative.rngoogleplaces.a()).addPackage(new com.BV.LinearGradient.a()).addPackage(new RNTextGradientPackage()).addPackage(new com.shopee.feeds.feedlibrary.rn.a()).setInitialLifecycleState(LifecycleState.BEFORE_RESUME).addPackage(new fr.greweb.reactnativeviewshot.b()).setJSBundleLoader(aVar3).setJSMainModulePath(aVar.h()).setUseDeveloperSupport(!aVar.g()).setNativeModuleCallExceptionHandler(iVar);
        nativeModuleCallExceptionHandler.setJavaScriptExecutorFactory(new HermesExecutorFactory());
        ReactInstanceManager build = nativeModuleCallExceptionHandler.build();
        aVar3.a(build);
        com.garena.reactpush.b.f6701d = dVar;
        return build;
    }

    /* access modifiers changed from: package-private */
    public com.garena.reactpush.b.b a(a aVar) {
        return new com.garena.reactpush.b.b(this.f18598a.d().getSharedPreferences(aVar.e(), 0));
    }

    /* access modifiers changed from: package-private */
    public com.garena.reactpush.d.a b(a aVar) {
        return new com.garena.reactpush.e.c.b(aVar.d(), aVar.j());
    }

    /* access modifiers changed from: package-private */
    public f a(OkHttpClient okHttpClient, a aVar, com.garena.reactpush.b.b bVar, com.garena.reactpush.e.c.a aVar2, d dVar) {
        if (aVar.j()) {
            return new com.garena.reactpush.f.d.b(okHttpClient, bVar, this.f18598a.d().getResources().getDisplayMetrics().density, aVar.d(), aVar.c(), aVar2);
        }
        return new com.garena.reactpush.e.d.a(okHttpClient, bVar, this.f18598a.d().getResources().getDisplayMetrics().density, aVar.d(), aVar.c(), aVar2);
    }

    /* access modifiers changed from: package-private */
    public d b() {
        return new d() {
            public void a(Exception exc) {
            }

            public void a(String str) {
            }

            public void b(String str) {
            }
        };
    }

    /* access modifiers changed from: package-private */
    public h a(OkHttpClient okHttpClient, com.garena.reactpush.b.b bVar, a aVar) {
        if (aVar.j()) {
            return new com.garena.reactpush.f.e.a(okHttpClient, this.f18598a.d().getResources().getDisplayMetrics().density, bVar, R.raw.bundle, aVar.d(), 297, R.raw.manifest_split);
        }
        return new com.garena.reactpush.e.e.a(okHttpClient, this.f18598a.d().getResources().getDisplayMetrics().density, bVar, R.raw.bundle, aVar.d(), 297, R.raw.manifest);
    }

    /* access modifiers changed from: package-private */
    public i c() {
        return new i();
    }

    /* access modifiers changed from: package-private */
    public c a(com.garena.reactpush.b.b bVar, com.garena.reactpush.d.a aVar, com.garena.reactpush.e.c.a aVar2, h hVar) {
        return new com.garena.reactpush.e.c.c(bVar, aVar, aVar2, hVar, this.f18598a.d().getApplicationContext());
    }

    /* access modifiers changed from: package-private */
    public com.garena.reactpush.e.c.a c(a aVar) {
        if (aVar.j()) {
            return new com.garena.reactpush.f.c.a(aVar.d());
        }
        return new com.garena.reactpush.e.c.a(aVar.d());
    }
}
