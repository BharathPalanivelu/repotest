package com.shopee.app.ui.webview;

import android.app.Activity;
import android.content.Context;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.q;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.v;
import com.shopee.app.a.w;
import com.shopee.app.a.x;
import com.shopee.app.a.y;
import com.shopee.app.a.z;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.ar;
import com.shopee.app.d.c.as;
import com.shopee.app.d.c.at;
import com.shopee.app.d.c.de;
import com.shopee.app.d.c.df;
import com.shopee.app.d.c.dl;
import com.shopee.app.d.c.dm;
import com.shopee.app.d.c.du;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.WebDataStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.network.http.a.k;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.ay;
import com.shopee.app.ui.common.ba;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.follow.search.j;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.product.search.l;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.UploadManager_Factory;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.util.ak;
import com.shopee.app.util.aw;
import com.shopee.app.util.ax;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.app.web.bridge.WebBridge;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebBridgeModule_MembersInjector;
import com.shopee.app.web.bridge.modules.FacebookConnectAccountModule;
import com.shopee.app.web.bridge.modules.FacebookConnectAccountModule_MembersInjector;
import com.shopee.app.web.bridge.modules.FacebookConnectStatusModule;
import com.shopee.app.web.bridge.modules.FacebookConnectStatusModule_MembersInjector;
import com.shopee.app.web.bridge.modules.FileDownloaderModule;
import com.shopee.app.web.bridge.modules.FileDownloaderModule_MembersInjector;
import com.shopee.app.web.bridge.modules.NavigateAppRLModule;
import com.shopee.app.web.bridge.modules.NavigateAppRLModule_MembersInjector;
import com.shopee.app.web.bridge.modules.PermissionCheckModule;
import com.shopee.app.web.bridge.modules.PermissionCheckModule_MembersInjector;
import com.shopee.app.web.bridge.modules.PermissionRequestModule;
import com.shopee.app.web.bridge.modules.PermissionRequestModule_MembersInjector;
import com.shopee.app.web.bridge.modules.RequestAuthCodeFromCoreAuthModule;
import com.shopee.app.web.bridge.modules.RequestAuthCodeFromCoreAuthModule_MembersInjector;
import com.shopee.app.web.bridge.modules.StartShakeDetectionModule;
import com.shopee.app.web.bridge.modules.StartShakeDetectionModule_MembersInjector;
import com.shopee.app.web.bridge.modules.StopShakeDetectionModule;
import com.shopee.app.web.bridge.modules.StopShakeDetectionModule_MembersInjector;
import com.shopee.web.sdk.bridge.internal.a;
import javax.inject.Provider;

public final class a implements e {
    private c A;
    private Provider<com.shopee.app.ui.common.a> B;
    private Provider<Context> C;
    private Provider<a.C0476a> D;

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f25813a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f25814b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f25815c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<com.shopee.app.ui.common.i> f25816d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f25817e;

    /* renamed from: f  reason: collision with root package name */
    private h f25818f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<com.shopee.app.tracking.c> f25819g;
    private Provider<Activity> h;
    private Provider<com.shopee.app.a.a.a> i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private f k;
    private Provider<RegionConfig> l;
    private g m;
    private Provider<com.shopee.app.network.http.a.d> n;
    private Provider<k> o;
    private e p;
    private d q;
    private i r;
    private UploadManager_Factory s;
    private com.shopee.app.util.l.c t;
    private Provider<com.shopee.app.react.modules.app.FirebasePerf.a> u;
    private b v;
    private Provider<com.shopee.app.util.i.c> w;
    private Provider<WebBridge> x;
    private Provider<com.shopee.app.ui.actionbar.a> y;
    private Provider<r> z;

    private a(C0396a aVar) {
        a(aVar);
    }

    public static C0396a c() {
        return new C0396a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private j e() {
        return new j((n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.follow.search.d f() {
        return new com.shopee.app.ui.follow.search.d((n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private l g() {
        return new l((n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (SearchKeywordsStore) b.a.c.a(this.f25813a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"), e(), f(), this.f25819g.get());
    }

    private as h() {
        return at.a((n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ao(), new ah());
    }

    private com.shopee.app.ui.common.a.a i() {
        return new com.shopee.app.ui.common.a.a(h());
    }

    private com.shopee.app.d.c.b j() {
        return new com.shopee.app.d.c.b((n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new bh(), (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.c.a k() {
        return new com.shopee.app.ui.c.a((al) b.a.c.a(this.f25813a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.util.b l() {
        return new com.shopee.app.util.b(this.f25814b.get(), b.a.a.b(this.t));
    }

    private du m() {
        return new du((n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new av(), (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f25813a.jobManager(), "Cannot return null from a non-@Nullable component method"));
    }

    private UploadManager n() {
        return new UploadManager((UploadStore) b.a.c.a(this.f25813a.uploadStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private aw o() {
        return a(ax.a((UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), this.f25814b.get(), (SettingConfigStore) b.a.c.a(this.f25813a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (com.shopee.navigator.e) b.a.c.a(this.f25813a.navigator2(), "Cannot return null from a non-@Nullable component method"), n()));
    }

    private dl p() {
        return dm.a((n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private ar q() {
        return new ar((n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.react.modules.ui.product.a r() {
        return a(com.shopee.app.react.modules.ui.product.c.a((UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.tracking.f) b.a.c.a(this.f25813a.tracker(), "Cannot return null from a non-@Nullable component method"), this.h.get(), this.f25814b.get()));
    }

    private f s() {
        String str = "Cannot return null from a non-@Nullable component method";
        return new f((bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.tracking.f) b.a.c.a(this.f25813a.tracker(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.tracking.a) b.a.c.a(this.f25813a.actionTracker(), "Cannot return null from a non-@Nullable component method"), this.f25814b.get(), (aa) b.a.c.a(this.f25813a.deviceStore(), "Cannot return null from a non-@Nullable component method"), m(), (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (WebDataStore) b.a.c.a(this.f25813a.webStore(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f25813a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (al) b.a.c.a(this.f25813a.loginStore(), "Cannot return null from a non-@Nullable component method"), o(), l(), p(), j(), (com.shopee.app.application.a.b) b.a.c.a(this.f25813a.appLifeCycleManager(), str), (be) b.a.c.a(this.f25813a.uiStatusStore(), str), q(), (SettingConfigStore) b.a.c.a(this.f25813a.settingConfigStore(), str), this.x.get(), r(), this.u.get());
    }

    private com.shopee.app.ui.common.n t() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f25813a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private de u() {
        return df.a((n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh());
    }

    private com.shopee.app.g.i v() {
        return new com.shopee.app.g.i((bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), u());
    }

    private com.shopee.app.g.h w() {
        return b(com.shopee.app.g.j.a(this.C.get()));
    }

    private com.shopee.app.d.c.c.a x() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f25813a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i y() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f25813a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(C0396a aVar) {
        this.f25814b = b.a.a.a(o.a(aVar.f25820a));
        this.f25813a = aVar.f25821b;
        this.f25815c = b.a.a.a(com.shopee.app.a.r.a(aVar.f25820a));
        this.f25816d = b.a.a.a(s.a(aVar.f25820a));
        this.f25817e = b.a.a.a(t.a(aVar.f25820a));
        this.f25818f = new h(aVar.f25821b);
        this.f25819g = b.a.a.a(v.a(aVar.f25820a, this.f25818f));
        this.h = b.a.a.a(com.shopee.app.a.d.a(aVar.f25820a));
        this.i = b.a.a.a(com.shopee.app.a.e.a(aVar.f25820a));
        this.j = b.a.a.a(w.a(aVar.f25820a, this.f25818f));
        this.k = new f(aVar.f25821b);
        this.l = b.a.a.a(q.a(aVar.f25820a, this.k));
        this.m = new g(aVar.f25821b);
        this.n = b.a.a.a(com.shopee.app.a.j.a(aVar.f25820a, this.m));
        this.o = b.a.a.a(x.a(aVar.f25820a, this.m));
        this.p = new e(aVar.f25821b);
        this.q = new d(aVar.f25821b);
        this.r = new i(aVar.f25821b);
        this.s = UploadManager_Factory.create(this.r);
        this.t = com.shopee.app.util.l.c.a(this.f25814b, this.p, this.q, this.s);
        this.u = b.a.a.a(com.shopee.app.react.modules.app.FirebasePerf.b.b());
        this.v = new b(aVar.f25821b);
        this.w = b.a.a.a(com.shopee.app.a.p.a(aVar.f25820a));
        this.x = b.a.a.a(z.a(aVar.f25820a, this.u, this.v, this.w, com.shopee.app.util.e.b.b()));
        this.y = b.a.a.a(com.shopee.app.a.c.a(aVar.f25820a));
        this.z = b.a.a.a(m.a(aVar.f25820a));
        this.A = new c(aVar.f25821b);
        this.B = b.a.a.a(com.shopee.app.a.f.a(aVar.f25820a, this.A));
        this.C = b.a.a.a(com.shopee.app.a.h.a(aVar.f25820a));
        this.D = b.a.a.a(y.a(aVar.f25820a));
    }

    public void a(AvatarView avatarView) {
        b(avatarView);
    }

    public void a(com.shopee.app.ui.actionbar.k kVar) {
        b(kVar);
    }

    public void a(MaterialTabView materialTabView) {
        b(materialTabView);
    }

    public void a(com.shopee.app.ui.product.a.a aVar) {
        b(aVar);
    }

    public void a(OptionRow optionRow) {
        b(optionRow);
    }

    public void a(OptionBox optionBox) {
        b(optionBox);
    }

    public ak a() {
        return this.f25814b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f25817e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.product.search.o oVar) {
        b(oVar);
    }

    public void a(com.shopee.app.ui.common.a.c cVar) {
        b(cVar);
    }

    public void inject(WebBridgeModule webBridgeModule) {
        a(webBridgeModule);
    }

    public void inject(FacebookConnectStatusModule facebookConnectStatusModule) {
        a(facebookConnectStatusModule);
    }

    public void inject(FacebookConnectAccountModule facebookConnectAccountModule) {
        a(facebookConnectAccountModule);
    }

    public void inject(PermissionCheckModule permissionCheckModule) {
        a(permissionCheckModule);
    }

    public void inject(PermissionRequestModule permissionRequestModule) {
        a(permissionRequestModule);
    }

    public void inject(RequestAuthCodeFromCoreAuthModule requestAuthCodeFromCoreAuthModule) {
        a(requestAuthCodeFromCoreAuthModule);
    }

    public void inject(StartShakeDetectionModule startShakeDetectionModule) {
        a(startShakeDetectionModule);
    }

    public void inject(StopShakeDetectionModule stopShakeDetectionModule) {
        a(stopShakeDetectionModule);
    }

    public void inject(FileDownloaderModule fileDownloaderModule) {
        a(fileDownloaderModule);
    }

    public void inject(NavigateAppRLModule navigateAppRLModule) {
        a(navigateAppRLModule);
    }

    public void a(com.shopee.app.web2.b.g.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.web2.b.c.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.web2.b.d.c cVar) {
        b(cVar);
    }

    public void a(com.shopee.app.web2.b.d.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.web2.b.e.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.web2.b.e.c cVar) {
        b(cVar);
    }

    public void a(g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.web2.d dVar) {
        b(dVar);
    }

    public void a(c cVar) {
        b(cVar);
    }

    public void a(com.shopee.app.web2.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.webview.simpleweb.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.webview.simpleweb.b bVar) {
        b(bVar);
    }

    public void a(com.shopee.app.g.h hVar) {
        b(hVar);
    }

    public void a(ay ayVar) {
        b(ayVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f25814b.get());
        return avatarView;
    }

    private com.shopee.app.ui.actionbar.k b(com.shopee.app.ui.actionbar.k kVar) {
        com.shopee.app.ui.actionbar.l.a(kVar, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbar.l.a(kVar, this.f25815c.get());
        com.shopee.app.ui.actionbar.l.a(kVar, d());
        com.shopee.app.ui.actionbar.l.a(kVar, this.f25814b.get());
        com.shopee.app.ui.actionbar.l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f25813a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f25816d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f25814b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f25814b.get());
        return aVar;
    }

    private com.shopee.app.ui.product.search.o b(com.shopee.app.ui.product.search.o oVar) {
        com.shopee.app.ui.product.search.q.a(oVar, g());
        com.shopee.app.ui.product.search.q.a(oVar, this.f25815c.get());
        com.shopee.app.ui.product.search.q.a(oVar, this.f25814b.get());
        com.shopee.app.ui.product.search.q.a(oVar, this.h.get());
        com.shopee.app.ui.product.search.q.a(oVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25813a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.product.search.q.a(oVar, this.f25819g.get());
        com.shopee.app.ui.product.search.q.a(oVar, (SearchKeywordsStore) b.a.c.a(this.f25813a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.product.search.q.a(oVar, this.i.get());
        com.shopee.app.ui.product.search.q.a(oVar, this.j.get());
        return oVar;
    }

    private com.shopee.app.ui.common.a.c b(com.shopee.app.ui.common.a.c cVar) {
        com.shopee.app.ui.common.a.e.a(cVar, i());
        com.shopee.app.ui.common.a.e.a(cVar, this.f25815c.get());
        com.shopee.app.ui.common.a.e.a(cVar, (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25813a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, this.j.get());
        com.shopee.app.ui.common.a.e.a(cVar, this.l.get());
        com.shopee.app.ui.common.a.e.a(cVar, (SettingConfigStore) b.a.c.a(this.f25813a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, (com.shopee.app.util.s) b.a.c.a(this.f25813a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, this.f25814b.get());
        com.shopee.app.ui.common.a.e.a(cVar, j());
        com.shopee.app.ui.common.a.e.a(cVar, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, this.h.get());
        return cVar;
    }

    private WebBridgeModule a(WebBridgeModule webBridgeModule) {
        WebBridgeModule_MembersInjector.injectMActivity(webBridgeModule, this.h.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(webBridgeModule, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return webBridgeModule;
    }

    private FacebookConnectStatusModule a(FacebookConnectStatusModule facebookConnectStatusModule) {
        WebBridgeModule_MembersInjector.injectMActivity(facebookConnectStatusModule, this.h.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(facebookConnectStatusModule, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        FacebookConnectStatusModule_MembersInjector.injectLoginManager(facebookConnectStatusModule, new com.shopee.app.h.m());
        FacebookConnectStatusModule_MembersInjector.injectMFacebookGraphAPI(facebookConnectStatusModule, this.n.get());
        return facebookConnectStatusModule;
    }

    private FacebookConnectAccountModule a(FacebookConnectAccountModule facebookConnectAccountModule) {
        WebBridgeModule_MembersInjector.injectMActivity(facebookConnectAccountModule, this.h.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(facebookConnectAccountModule, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        FacebookConnectAccountModule_MembersInjector.injectMLifeCycleManager(facebookConnectAccountModule, (com.shopee.app.application.a.b) b.a.c.a(this.f25813a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        FacebookConnectAccountModule_MembersInjector.injectMDataEventBus(facebookConnectAccountModule, (n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        return facebookConnectAccountModule;
    }

    private PermissionCheckModule a(PermissionCheckModule permissionCheckModule) {
        WebBridgeModule_MembersInjector.injectMActivity(permissionCheckModule, this.h.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(permissionCheckModule, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        PermissionCheckModule_MembersInjector.injectMLoginStore(permissionCheckModule, (al) b.a.c.a(this.f25813a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        return permissionCheckModule;
    }

    private PermissionRequestModule a(PermissionRequestModule permissionRequestModule) {
        WebBridgeModule_MembersInjector.injectMActivity(permissionRequestModule, this.h.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(permissionRequestModule, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        PermissionRequestModule_MembersInjector.injectMHandler(permissionRequestModule, k());
        return permissionRequestModule;
    }

    private RequestAuthCodeFromCoreAuthModule a(RequestAuthCodeFromCoreAuthModule requestAuthCodeFromCoreAuthModule) {
        WebBridgeModule_MembersInjector.injectMActivity(requestAuthCodeFromCoreAuthModule, this.h.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(requestAuthCodeFromCoreAuthModule, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        RequestAuthCodeFromCoreAuthModule_MembersInjector.injectUserAPI(requestAuthCodeFromCoreAuthModule, b.a.a.b(this.o));
        return requestAuthCodeFromCoreAuthModule;
    }

    private StartShakeDetectionModule a(StartShakeDetectionModule startShakeDetectionModule) {
        WebBridgeModule_MembersInjector.injectMActivity(startShakeDetectionModule, this.h.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(startShakeDetectionModule, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        StartShakeDetectionModule_MembersInjector.injectShakeHandler(startShakeDetectionModule, this.f25817e.get());
        return startShakeDetectionModule;
    }

    private StopShakeDetectionModule a(StopShakeDetectionModule stopShakeDetectionModule) {
        WebBridgeModule_MembersInjector.injectMActivity(stopShakeDetectionModule, this.h.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(stopShakeDetectionModule, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        StopShakeDetectionModule_MembersInjector.injectShakeHandler(stopShakeDetectionModule, this.f25817e.get());
        return stopShakeDetectionModule;
    }

    private FileDownloaderModule a(FileDownloaderModule fileDownloaderModule) {
        WebBridgeModule_MembersInjector.injectMActivity(fileDownloaderModule, this.h.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(fileDownloaderModule, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        FileDownloaderModule_MembersInjector.injectPermissionHandler(fileDownloaderModule, k());
        return fileDownloaderModule;
    }

    private NavigateAppRLModule a(NavigateAppRLModule navigateAppRLModule) {
        WebBridgeModule_MembersInjector.injectMActivity(navigateAppRLModule, this.h.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(navigateAppRLModule, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        NavigateAppRLModule_MembersInjector.injectMAppPathHelper(navigateAppRLModule, l());
        return navigateAppRLModule;
    }

    private com.shopee.app.web2.b.g.a b(com.shopee.app.web2.b.g.a aVar) {
        com.shopee.app.web2.b.g.b.a(aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25813a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.web2.b.c.a b(com.shopee.app.web2.b.c.a aVar) {
        com.shopee.app.web2.b.c.b.a(aVar, (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.web2.b.d.c b(com.shopee.app.web2.b.d.c cVar) {
        com.shopee.app.web2.b.d.d.a(cVar, (com.shopee.navigator.e) b.a.c.a(this.f25813a.navigator2(), "Cannot return null from a non-@Nullable component method"));
        return cVar;
    }

    private com.shopee.app.web2.b.d.a b(com.shopee.app.web2.b.d.a aVar) {
        com.shopee.app.web2.b.d.b.a(aVar, (com.shopee.navigator.e) b.a.c.a(this.f25813a.navigator2(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.web2.b.e.a b(com.shopee.app.web2.b.e.a aVar) {
        com.shopee.app.web2.b.e.b.a(aVar, (al) b.a.c.a(this.f25813a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.web2.b.e.c b(com.shopee.app.web2.b.e.c cVar) {
        com.shopee.app.web2.b.e.d.a(cVar, (al) b.a.c.a(this.f25813a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        return cVar;
    }

    private aw a(aw awVar) {
        com.shopee.app.util.ay.a(awVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25813a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.ay.a(awVar, (al) b.a.c.a(this.f25813a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        return awVar;
    }

    private com.shopee.app.react.modules.ui.product.a a(com.shopee.app.react.modules.ui.product.a aVar) {
        com.shopee.app.react.modules.ui.product.d.a(aVar, (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.modules.ui.product.d.a(aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25813a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.modules.ui.product.d.a(aVar, this.f25814b.get());
        return aVar;
    }

    private com.shopee.app.g.h b(com.shopee.app.g.h hVar) {
        com.shopee.app.g.k.a(hVar, v());
        com.shopee.app.g.k.a(hVar, this.f25815c.get());
        com.shopee.app.g.k.a(hVar, (SettingConfigStore) b.a.c.a(this.f25813a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.g.k.a(hVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25813a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.g.k.a(hVar, (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return hVar;
    }

    private g b(g gVar) {
        h.a(gVar, this.h.get());
        h.a(gVar, s());
        h.a(gVar, this.f25814b.get());
        h.a(gVar, this.f25815c.get());
        h.a(gVar, this.y.get());
        h.a(gVar, this.z.get());
        h.a(gVar, (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        h.a(gVar, (be) b.a.c.a(this.f25813a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        h.a(gVar, (ShareConfigStore) b.a.c.a(this.f25813a.shareConfigStore(), "Cannot return null from a non-@Nullable component method"));
        h.a(gVar, new com.shopee.app.h.m());
        h.a(gVar, this.B.get());
        h.a(gVar, t());
        h.a(gVar, n());
        h.a(gVar, (MeCounter) b.a.c.a(this.f25813a.meCounter(), "Cannot return null from a non-@Nullable component method"));
        h.a(gVar, w());
        h.a(gVar, this.x.get());
        return gVar;
    }

    private com.shopee.app.web2.d b(com.shopee.app.web2.d dVar) {
        com.shopee.app.web2.f.a(dVar, this.h.get());
        com.shopee.app.web2.f.a(dVar, new com.shopee.app.web2.c());
        com.shopee.app.web2.f.a(dVar, this.f25815c.get());
        com.shopee.app.web2.f.a(dVar, (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private c b(c cVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25813a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.z.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25813a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.B.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.f25814b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25813a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25813a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (al) b.a.c.a(this.f25813a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActionRequiredCounter) b.a.c.a(this.f25813a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActivityCounter) b.a.c.a(this.f25813a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, x());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, this.B.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, t());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, y());
        d.a(cVar, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        d.a(cVar, this.x.get());
        return cVar;
    }

    private com.shopee.app.web2.a b(com.shopee.app.web2.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25813a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.z.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25813a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.B.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25814b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25813a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25813a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f25813a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f25813a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f25813a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, x());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.B.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, t());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, y());
        com.shopee.app.web2.b.a(aVar, this.D.get());
        return aVar;
    }

    private com.shopee.app.ui.webview.simpleweb.a b(com.shopee.app.ui.webview.simpleweb.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f25813a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f25813a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25813a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.z.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25813a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f25813a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.B.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25814b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25813a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25813a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f25813a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f25813a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f25813a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, x());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.B.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, t());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, y());
        return aVar;
    }

    private com.shopee.app.ui.webview.simpleweb.b b(com.shopee.app.ui.webview.simpleweb.b bVar) {
        com.shopee.app.ui.webview.simpleweb.d.a(bVar, this.h.get());
        return bVar;
    }

    private ay b(ay ayVar) {
        ba.a(ayVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25813a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        ba.a(ayVar, this.f25816d.get());
        return ayVar;
    }

    /* renamed from: com.shopee.app.ui.webview.a$a  reason: collision with other inner class name */
    public static final class C0396a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f25820a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f25821b;

        private C0396a() {
        }

        public e a() {
            if (this.f25820a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f25821b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0396a a(com.shopee.app.a.b bVar) {
            this.f25820a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0396a a(UserComponent userComponent) {
            this.f25821b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class h implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25828a;

        h(UserComponent userComponent) {
            this.f25828a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f25828a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class f implements Provider<RegionConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25826a;

        f(UserComponent userComponent) {
            this.f25826a = userComponent;
        }

        /* renamed from: a */
        public RegionConfigStore get() {
            return (RegionConfigStore) b.a.c.a(this.f25826a.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class g implements Provider<f.n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25827a;

        g(UserComponent userComponent) {
            this.f25827a = userComponent;
        }

        /* renamed from: a */
        public f.n get() {
            return (f.n) b.a.c.a(this.f25827a.retrofit(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class e implements Provider<com.shopee.navigator.e> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25825a;

        e(UserComponent userComponent) {
            this.f25825a = userComponent;
        }

        /* renamed from: a */
        public com.shopee.navigator.e get() {
            return (com.shopee.navigator.e) b.a.c.a(this.f25825a.navigator2(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class d implements Provider<UserInfo> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25824a;

        d(UserComponent userComponent) {
            this.f25824a = userComponent;
        }

        /* renamed from: a */
        public UserInfo get() {
            return (UserInfo) b.a.c.a(this.f25824a.loggedInUser(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class i implements Provider<UploadStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25829a;

        i(UserComponent userComponent) {
            this.f25829a = userComponent;
        }

        /* renamed from: a */
        public UploadStore get() {
            return (UploadStore) b.a.c.a(this.f25829a.uploadStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class b implements Provider<com.shopee.app.react.modules.app.data.g> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25822a;

        b(UserComponent userComponent) {
            this.f25822a = userComponent;
        }

        /* renamed from: a */
        public com.shopee.app.react.modules.app.data.g get() {
            return (com.shopee.app.react.modules.app.data.g) b.a.c.a(this.f25822a.dataBridgeHandler(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25823a;

        c(UserComponent userComponent) {
            this.f25823a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f25823a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
