package com.shopee.app.ui.home;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.ReactInstanceManager;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.a.z;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.ai;
import com.shopee.app.d.c.ar;
import com.shopee.app.d.c.as;
import com.shopee.app.d.c.at;
import com.shopee.app.d.c.bb;
import com.shopee.app.d.c.bk;
import com.shopee.app.d.c.bl;
import com.shopee.app.d.c.bn;
import com.shopee.app.d.c.bo;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.bu;
import com.shopee.app.d.c.bv;
import com.shopee.app.d.c.bw;
import com.shopee.app.d.c.ce;
import com.shopee.app.d.c.cf;
import com.shopee.app.d.c.cr;
import com.shopee.app.d.c.cs;
import com.shopee.app.d.c.cw;
import com.shopee.app.d.c.cx;
import com.shopee.app.d.c.de;
import com.shopee.app.d.c.df;
import com.shopee.app.d.c.dl;
import com.shopee.app.d.c.dm;
import com.shopee.app.d.c.du;
import com.shopee.app.d.c.eb;
import com.shopee.app.d.c.ec;
import com.shopee.app.d.c.ed;
import com.shopee.app.d.c.ee;
import com.shopee.app.d.c.ef;
import com.shopee.app.d.c.eg;
import com.shopee.app.d.c.w;
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
import com.shopee.app.data.store.bd;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.data.store.x;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.ChatCounter;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.actionbox.ActionBoxActivity;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.ab;
import com.shopee.app.ui.common.aj;
import com.shopee.app.ui.common.ay;
import com.shopee.app.ui.common.ba;
import com.shopee.app.ui.common.y;
import com.shopee.app.ui.home.chat.ChatTab;
import com.shopee.app.ui.home.follow.FollowTab;
import com.shopee.app.ui.home.me.control.MeControlView;
import com.shopee.app.ui.home.me.v3.MeTabView3;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.b;
import com.shopee.app.ui.home.me.v3.feature.k;
import com.shopee.app.ui.home.react.ReactTabView;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.UploadManager_Factory;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.util.ak;
import com.shopee.app.util.am;
import com.shopee.app.util.aw;
import com.shopee.app.util.ax;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
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

public final class b implements e {
    private Provider<com.shopee.app.ui.common.r> A;
    private d B;
    private Provider<com.shopee.app.ui.common.a> C;
    private Provider<Context> D;
    private Provider<a.C0476a> E;
    private C0323b F;
    private l G;
    private ax H;
    private o I;
    private n J;
    private r K;
    private t L;
    private i M;
    private j N;
    private com.shopee.app.d.c.j.b O;
    private u P;
    private e Q;
    private h R;
    private g S;
    private f T;
    private com.shopee.app.d.c.j.e U;
    private Provider<com.shopee.app.network.http.a.j> V;
    private Provider<com.shopee.app.network.http.a.b> W;
    private Provider<com.shopee.app.network.http.a.i> X;
    private Provider<com.shopee.app.network.http.a.f> Y;

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.app.react.b.d f22091a;

    /* renamed from: b  reason: collision with root package name */
    private f f22092b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<ak> f22093c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<bc> f22094d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.ui.common.i> f22095e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f22096f;

    /* renamed from: g  reason: collision with root package name */
    private s f22097g;
    private Provider<com.shopee.app.tracking.c> h;
    private Provider<Activity> i;
    private Provider<com.shopee.app.a.a.a> j;
    private Provider<com.shopee.app.tracking.trackingv3.b> k;
    private p l;
    private Provider<RegionConfig> m;
    private q n;
    private Provider<com.shopee.app.network.http.a.d> o;
    private Provider<com.shopee.app.network.http.a.k> p;
    private m q;
    private k r;
    private v s;
    private UploadManager_Factory t;
    private com.shopee.app.util.l.c u;
    private Provider<com.shopee.app.react.modules.app.FirebasePerf.a> v;
    private c w;
    private Provider<com.shopee.app.util.i.c> x;
    private Provider<WebBridge> y;
    private Provider<com.shopee.app.ui.actionbar.a> z;

    public void a(com.shopee.app.ui.actionbox.actionrequired.a aVar) {
    }

    public void a(com.shopee.app.ui.home.b.a aVar) {
    }

    private b(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.follow.search.j e() {
        return new com.shopee.app.ui.follow.search.j((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.follow.search.d f() {
        return new com.shopee.app.ui.follow.search.d((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.product.search.l g() {
        return new com.shopee.app.ui.product.search.l((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (SearchKeywordsStore) b.a.c.a(this.f22091a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"), e(), f(), this.h.get());
    }

    private as h() {
        return at.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ao(), new ah());
    }

    private com.shopee.app.ui.common.a.a i() {
        return new com.shopee.app.ui.common.a.a(h());
    }

    private com.shopee.app.d.c.b j() {
        return new com.shopee.app.d.c.b((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.p(), new bh(), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.c.a k() {
        return new com.shopee.app.ui.c.a((al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.util.b l() {
        return new com.shopee.app.util.b(this.f22093c.get(), b.a.a.b(this.u));
    }

    private du m() {
        return new du((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.p(), new av(), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f22091a.jobManager(), "Cannot return null from a non-@Nullable component method"));
    }

    private UploadManager n() {
        return new UploadManager((UploadStore) b.a.c.a(this.f22091a.uploadStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private aw o() {
        return a(ax.a((UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), this.f22093c.get(), (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (com.shopee.navigator.e) b.a.c.a(this.f22091a.navigator2(), "Cannot return null from a non-@Nullable component method"), n()));
    }

    private dl p() {
        return dm.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private ar q() {
        return new ar((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.react.modules.ui.product.a r() {
        return b(com.shopee.app.react.modules.ui.product.c.a((UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"), this.i.get(), this.f22093c.get()));
    }

    private com.shopee.app.ui.webview.f s() {
        String str = "Cannot return null from a non-@Nullable component method";
        return new com.shopee.app.ui.webview.f((bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"), this.f22093c.get(), (aa) b.a.c.a(this.f22091a.deviceStore(), "Cannot return null from a non-@Nullable component method"), m(), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (WebDataStore) b.a.c.a(this.f22091a.webStore(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"), o(), l(), p(), j(), (com.shopee.app.application.a.b) b.a.c.a(this.f22091a.appLifeCycleManager(), str), (be) b.a.c.a(this.f22091a.uiStatusStore(), str), q(), (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), str), this.y.get(), r(), this.v.get());
    }

    private com.shopee.app.ui.common.n t() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private de u() {
        return df.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh());
    }

    private com.shopee.app.g.i v() {
        return new com.shopee.app.g.i((bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), u());
    }

    private com.shopee.app.g.h w() {
        return b(com.shopee.app.g.j.a(this.D.get()));
    }

    private com.shopee.app.d.c.c.a x() {
        return com.shopee.app.d.c.c.b.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f22091a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i y() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private bb z() {
        return new bb((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.at) b.a.c.a(this.f22091a.orderNotiStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.home.me.control.a A() {
        return new com.shopee.app.ui.home.me.control.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), z());
    }

    private y B() {
        return new y((bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f22091a.jobManager(), "Cannot return null from a non-@Nullable component method"), (be) b.a.c.a(this.f22091a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"), n(), (am) b.a.c.a(this.f22091a.networkUtil(), "Cannot return null from a non-@Nullable component method"), (UploadStore) b.a.c.a(this.f22091a.uploadStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.f.c C() {
        return com.shopee.app.d.c.f.d.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bg(), new com.shopee.app.data.store.p(), (ChatBadgeStore) b.a.c.a(this.f22091a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"), new ah(), new com.shopee.app.data.store.c.c(), (x) b.a.c.a(this.f22091a.customerOrderCountStore(), "Cannot return null from a non-@Nullable component method"), new av(), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.f.e D() {
        return com.shopee.app.d.c.f.f.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bg(), new com.shopee.app.data.store.p(), (ChatBadgeStore) b.a.c.a(this.f22091a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"), new ah(), new com.shopee.app.data.store.c.c(), (x) b.a.c.a(this.f22091a.customerOrderCountStore(), "Cannot return null from a non-@Nullable component method"), new av(), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.j E() {
        return com.shopee.app.d.c.k.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.p(), new av(), (ChatBadgeStore) b.a.c.a(this.f22091a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.f.g F() {
        return com.shopee.app.d.c.f.h.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bg(), new com.shopee.app.data.store.p(), (ChatBadgeStore) b.a.c.a(this.f22091a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"), new ah(), new com.shopee.app.data.store.c.c(), (x) b.a.c.a(this.f22091a.customerOrderCountStore(), "Cannot return null from a non-@Nullable component method"), new av(), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.f.k G() {
        return com.shopee.app.d.c.f.l.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new av());
    }

    private com.shopee.app.d.c.f.m H() {
        return com.shopee.app.d.c.f.n.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.o) b.a.c.a(this.f22091a.chatListLoadingStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.f.a I() {
        return com.shopee.app.d.c.f.b.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bg(), new com.shopee.app.data.store.p(), (ChatBadgeStore) b.a.c.a(this.f22091a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"), new ah(), new com.shopee.app.data.store.c.c(), (x) b.a.c.a(this.f22091a.customerOrderCountStore(), "Cannot return null from a non-@Nullable component method"), new av(), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private ce J() {
        return cf.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.p(), new av(), (ChatBadgeStore) b.a.c.a(this.f22091a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private ed K() {
        return ee.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.j) b.a.c.a(this.f22091a.blacklistStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.chat2.e L() {
        return new com.shopee.app.ui.chat2.e(C(), D(), E(), F(), G(), H(), I(), J(), K(), (ChatBadgeStore) b.a.c.a(this.f22091a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private ef M() {
        return eg.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.bb) b.a.c.a(this.f22091a.ratingShopeeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.application.a N() {
        return new com.shopee.app.application.a((SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (ChatCounter) b.a.c.a(this.f22091a.chatCounter(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f22091a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), b.a.a.b(this.J), b.a.a.b(this.K));
    }

    private l O() {
        return g.a(this.f22092b, (com.shopee.app.util.s) b.a.c.a(this.f22091a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private cr P() {
        return cs.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), O(), (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (aa) b.a.c.a(this.f22091a.deviceStore(), "Cannot return null from a non-@Nullable component method"), (ThemeStore) b.a.c.a(this.f22091a.themeStore(), "Cannot return null from a non-@Nullable component method"), (bd) b.a.c.a(this.f22091a.toolTipStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.d.a Q() {
        return new com.shopee.app.d.c.d.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.util.s) b.a.c.a(this.f22091a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (FollowCounter) b.a.c.a(this.f22091a.followCounter(), "Cannot return null from a non-@Nullable component method"), this.V.get());
    }

    private i R() {
        com.shopee.app.h.m mVar = r5;
        com.shopee.app.h.m mVar2 = new com.shopee.app.h.m();
        String str = "Cannot return null from a non-@Nullable component method";
        return new i((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), mVar, N(), (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"), P(), b.a.a.b(this.O), b.a.a.b(this.U), (bd) b.a.c.a(this.f22091a.toolTipStore(), "Cannot return null from a non-@Nullable component method"), O(), Q(), this.k.get(), (FollowCounter) b.a.c.a(this.f22091a.followCounter(), str), (ThemeStore) b.a.c.a(this.f22091a.themeStore(), str));
    }

    private k S() {
        return new k((com.shopee.app.util.s) b.a.c.a(this.f22091a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"), O());
    }

    private com.shopee.app.data.store.ax T() {
        return h.a(this.f22092b, this.D.get());
    }

    private com.shopee.app.d.c.j.c U() {
        return new com.shopee.app.d.c.j.c(b.a.a.b(this.P), (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.home.follow.a V() {
        return new com.shopee.app.ui.home.follow.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (FollowCounter) b.a.c.a(this.f22091a.followCounter(), "Cannot return null from a non-@Nullable component method"), this.m.get(), (com.shopee.app.react.modules.app.data.k) b.a.c.a(this.f22091a.rnConfigProvider(), "Cannot return null from a non-@Nullable component method"), U(), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.util.s) b.a.c.a(this.f22091a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.home.a.p W() {
        return new com.shopee.app.ui.home.a.p(new com.shopee.app.ui.home.a.j());
    }

    private com.shopee.app.g.b X() {
        return new com.shopee.app.g.b(new com.shopee.app.data.store.e(), new ah(), new bh(), (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.d) b.a.c.a(this.f22091a.activityIdStoreStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private w Y() {
        return new w((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), X());
    }

    private eb Z() {
        return ec.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.h) b.a.c.a(this.f22091a.bannerStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.follow.following.c aa() {
        return new com.shopee.app.ui.follow.following.c((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.home.a.k ab() {
        return new com.shopee.app.ui.home.a.k((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), Y(), Z(), (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"), aa(), new com.shopee.app.h.m());
    }

    private bn ac() {
        return bo.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.b) b.a.c.a(this.f22091a.provideActionIdListStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c());
    }

    private com.shopee.app.d.c.u ad() {
        return com.shopee.app.d.c.v.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c(), (com.shopee.app.data.store.b) b.a.c.a(this.f22091a.provideActionIdListStore(), "Cannot return null from a non-@Nullable component method"), (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.bb) b.a.c.a(this.f22091a.ratingShopeeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private bv ae() {
        return bw.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c(), (com.shopee.app.data.store.b) b.a.c.a(this.f22091a.provideActionIdListStore(), "Cannot return null from a non-@Nullable component method"), X());
    }

    private ai af() {
        return new ai((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c(), (com.shopee.app.data.store.bb) b.a.c.a(this.f22091a.ratingShopeeStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.a());
    }

    private com.shopee.app.ui.actionbox2.d ag() {
        return new com.shopee.app.ui.actionbox2.d((ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"), ac(), Y(), (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"), ad(), ae(), af());
    }

    private cw ah() {
        return cx.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (be) b.a.c.a(this.f22091a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private bt ai() {
        return bu.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private bk aj() {
        return bl.a((com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.c.a) b.a.c.a(this.f22091a.orderCountStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.bc ak() {
        return new com.shopee.app.d.c.bc((al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.util.s) b.a.c.a(this.f22091a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"), this.X.get());
    }

    private com.shopee.app.ui.home.me.v3.c al() {
        return new com.shopee.app.ui.home.me.v3.c((MeCounter) b.a.c.a(this.f22091a.meCounter(), "Cannot return null from a non-@Nullable component method"), ah(), (be) b.a.c.a(this.f22091a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), this.W.get(), ai(), aj(), aj(), aj(), ak(), (com.shopee.app.util.s) b.a.c.a(this.f22091a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.aw am() {
        return new com.shopee.app.d.c.aw(this.Y.get(), (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.react.modules.app.data.k) b.a.c.a(this.f22091a.rnConfigProvider(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.util.s) b.a.c.a(this.f22091a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"), (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.home.me.v3.h an() {
        return new com.shopee.app.ui.home.me.v3.h((UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (be) b.a.c.a(this.f22091a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"), ah(), ai(), aj(), am(), ak());
    }

    private void a(a aVar) {
        this.f22093c = b.a.a.a(com.shopee.app.a.o.a(aVar.f22098a));
        this.f22091a = aVar.f22100c;
        this.f22094d = b.a.a.a(com.shopee.app.a.r.a(aVar.f22098a));
        this.f22095e = b.a.a.a(com.shopee.app.a.s.a(aVar.f22098a));
        this.f22096f = b.a.a.a(com.shopee.app.a.t.a(aVar.f22098a));
        this.f22097g = new s(aVar.f22100c);
        this.h = b.a.a.a(com.shopee.app.a.v.a(aVar.f22098a, this.f22097g));
        this.i = b.a.a.a(com.shopee.app.a.d.a(aVar.f22098a));
        this.j = b.a.a.a(com.shopee.app.a.e.a(aVar.f22098a));
        this.k = b.a.a.a(com.shopee.app.a.w.a(aVar.f22098a, this.f22097g));
        this.l = new p(aVar.f22100c);
        this.m = b.a.a.a(com.shopee.app.a.q.a(aVar.f22098a, this.l));
        this.n = new q(aVar.f22100c);
        this.o = b.a.a.a(com.shopee.app.a.j.a(aVar.f22098a, this.n));
        this.p = b.a.a.a(com.shopee.app.a.x.a(aVar.f22098a, this.n));
        this.q = new m(aVar.f22100c);
        this.r = new k(aVar.f22100c);
        this.s = new v(aVar.f22100c);
        this.t = UploadManager_Factory.create(this.s);
        this.u = com.shopee.app.util.l.c.a(this.f22093c, this.q, this.r, this.t);
        this.v = b.a.a.a(com.shopee.app.react.modules.app.FirebasePerf.b.b());
        this.w = new c(aVar.f22100c);
        this.x = b.a.a.a(com.shopee.app.a.p.a(aVar.f22098a));
        this.y = b.a.a.a(z.a(aVar.f22098a, this.v, this.w, this.x, com.shopee.app.util.e.b.b()));
        this.z = b.a.a.a(com.shopee.app.a.c.a(aVar.f22098a));
        this.A = b.a.a.a(com.shopee.app.a.m.a(aVar.f22098a));
        this.B = new d(aVar.f22100c);
        this.C = b.a.a.a(com.shopee.app.a.f.a(aVar.f22098a, this.B));
        this.D = b.a.a.a(com.shopee.app.a.h.a(aVar.f22098a));
        this.E = b.a.a.a(com.shopee.app.a.y.a(aVar.f22098a));
        this.F = new C0323b(aVar.f22100c);
        this.G = new l(aVar.f22100c);
        this.H = ax.a(this.r, this.f22093c, this.f22097g, this.q, this.t, this.F, this.G);
        this.I = new o(aVar.f22100c);
        this.J = new n(aVar.f22100c);
        this.K = new r(aVar.f22100c);
        this.f22092b = aVar.f22099b;
        this.L = new t(aVar.f22100c);
        this.M = new i(aVar.f22100c);
        this.N = new j(aVar.f22100c);
        this.O = com.shopee.app.d.c.j.b.a(this.L, this.M, this.N, this.B);
        this.P = new u(aVar.f22100c);
        this.Q = new e(aVar.f22100c);
        this.R = new h(aVar.f22100c);
        this.S = new g(aVar.f22100c);
        this.T = new f(aVar.f22100c);
        this.U = com.shopee.app.d.c.j.e.a(this.r, this.N, this.f22097g, this.B, this.M, this.P, this.Q, this.R, this.S, this.T);
        this.V = b.a.a.a(com.shopee.app.a.u.a(aVar.f22098a, this.n));
        this.W = b.a.a.a(com.shopee.app.a.i.a(aVar.f22098a, this.n));
        this.X = b.a.a.a(com.shopee.app.a.n.a(aVar.f22098a, this.n));
        this.Y = b.a.a.a(com.shopee.app.a.k.a(aVar.f22098a, this.n));
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
        return this.f22093c.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f22096f.get();
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

    public void a(com.shopee.app.ui.webview.g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.web2.d dVar) {
        b(dVar);
    }

    public void a(com.shopee.app.ui.webview.c cVar) {
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

    public void a(ay ayVar) {
        b(ayVar);
    }

    public void a(MeControlView meControlView) {
        b(meControlView);
    }

    public void a(com.shopee.app.ui.common.aa aaVar) {
        b(aaVar);
    }

    public void a(com.shopee.app.ui.chat2.g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.ui.actionbox.actionrequired.c cVar) {
        b(cVar);
    }

    public void a(com.shopee.app.ui.common.ai aiVar) {
        b(aiVar);
    }

    public void a(com.shopee.app.ui.error.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.react.modules.ui.navigator.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.react.modules.ui.email.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.react.modules.ui.progress.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.react.modules.ui.share.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.react.modules.ui.video.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.react.modules.unused.imagemanager.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.react.modules.ui.product.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.react.modules.ui.location.b bVar) {
        b(bVar);
    }

    public void a(c cVar) {
        b(cVar);
    }

    public void a(m mVar) {
        b(mVar);
    }

    public void a(FollowTab followTab) {
        b(followTab);
    }

    public void a(com.shopee.app.ui.home.a.m mVar) {
        b(mVar);
    }

    public void a(com.shopee.app.ui.home.a.e eVar) {
        b(eVar);
    }

    public void a(com.shopee.app.g.h hVar) {
        b(hVar);
    }

    public void a(com.shopee.app.ui.activity.c cVar) {
        b(cVar);
    }

    public void a(com.shopee.app.ui.activity.d dVar) {
        b(dVar);
    }

    public void a(com.shopee.app.ui.activity.a aVar) {
        b(aVar);
    }

    public void a(ChatTab chatTab) {
        b(chatTab);
    }

    public void a(com.shopee.app.ui.actionbox2.f fVar) {
        b(fVar);
    }

    public void a(com.shopee.app.ui.actionbox2.a aVar) {
        b(aVar);
    }

    public void a(ActionBoxActivity actionBoxActivity) {
        b(actionBoxActivity);
    }

    public void a(com.shopee.app.ui.home.me.v3.feature.k kVar) {
        b(kVar);
    }

    public void a(com.shopee.app.ui.home.me.v3.feature.b bVar) {
        b(bVar);
    }

    public void a(ReactTabView reactTabView) {
        b(reactTabView);
    }

    public void a(MeTabView3 meTabView3) {
        b(meTabView3);
    }

    public void a(com.shopee.app.ui.home.me.v3.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.home.me.v3.f fVar) {
        b(fVar);
    }

    public void a(com.shopee.app.ui.home.me.v3.j jVar) {
        b(jVar);
    }

    public void a(b.a aVar) {
        b(aVar);
    }

    public void a(k.a aVar) {
        b(aVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f22093c.get());
        return avatarView;
    }

    private com.shopee.app.ui.actionbar.k b(com.shopee.app.ui.actionbar.k kVar) {
        com.shopee.app.ui.actionbar.l.a(kVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbar.l.a(kVar, this.f22094d.get());
        com.shopee.app.ui.actionbar.l.a(kVar, d());
        com.shopee.app.ui.actionbar.l.a(kVar, this.f22093c.get());
        com.shopee.app.ui.actionbar.l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f22091a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f22095e.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f22093c.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f22093c.get());
        return aVar;
    }

    private com.shopee.app.ui.product.search.o b(com.shopee.app.ui.product.search.o oVar) {
        com.shopee.app.ui.product.search.q.a(oVar, g());
        com.shopee.app.ui.product.search.q.a(oVar, this.f22094d.get());
        com.shopee.app.ui.product.search.q.a(oVar, this.f22093c.get());
        com.shopee.app.ui.product.search.q.a(oVar, this.i.get());
        com.shopee.app.ui.product.search.q.a(oVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.product.search.q.a(oVar, this.h.get());
        com.shopee.app.ui.product.search.q.a(oVar, (SearchKeywordsStore) b.a.c.a(this.f22091a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.product.search.q.a(oVar, this.j.get());
        com.shopee.app.ui.product.search.q.a(oVar, this.k.get());
        return oVar;
    }

    private com.shopee.app.ui.common.a.c b(com.shopee.app.ui.common.a.c cVar) {
        com.shopee.app.ui.common.a.e.a(cVar, i());
        com.shopee.app.ui.common.a.e.a(cVar, this.f22094d.get());
        com.shopee.app.ui.common.a.e.a(cVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, this.k.get());
        com.shopee.app.ui.common.a.e.a(cVar, this.m.get());
        com.shopee.app.ui.common.a.e.a(cVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, (com.shopee.app.util.s) b.a.c.a(this.f22091a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, this.f22093c.get());
        com.shopee.app.ui.common.a.e.a(cVar, j());
        com.shopee.app.ui.common.a.e.a(cVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, this.i.get());
        return cVar;
    }

    private WebBridgeModule a(WebBridgeModule webBridgeModule) {
        WebBridgeModule_MembersInjector.injectMActivity(webBridgeModule, this.i.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(webBridgeModule, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return webBridgeModule;
    }

    private FacebookConnectStatusModule a(FacebookConnectStatusModule facebookConnectStatusModule) {
        WebBridgeModule_MembersInjector.injectMActivity(facebookConnectStatusModule, this.i.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(facebookConnectStatusModule, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        FacebookConnectStatusModule_MembersInjector.injectLoginManager(facebookConnectStatusModule, new com.shopee.app.h.m());
        FacebookConnectStatusModule_MembersInjector.injectMFacebookGraphAPI(facebookConnectStatusModule, this.o.get());
        return facebookConnectStatusModule;
    }

    private FacebookConnectAccountModule a(FacebookConnectAccountModule facebookConnectAccountModule) {
        WebBridgeModule_MembersInjector.injectMActivity(facebookConnectAccountModule, this.i.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(facebookConnectAccountModule, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        FacebookConnectAccountModule_MembersInjector.injectMLifeCycleManager(facebookConnectAccountModule, (com.shopee.app.application.a.b) b.a.c.a(this.f22091a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        FacebookConnectAccountModule_MembersInjector.injectMDataEventBus(facebookConnectAccountModule, (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        return facebookConnectAccountModule;
    }

    private PermissionCheckModule a(PermissionCheckModule permissionCheckModule) {
        WebBridgeModule_MembersInjector.injectMActivity(permissionCheckModule, this.i.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(permissionCheckModule, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        PermissionCheckModule_MembersInjector.injectMLoginStore(permissionCheckModule, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        return permissionCheckModule;
    }

    private PermissionRequestModule a(PermissionRequestModule permissionRequestModule) {
        WebBridgeModule_MembersInjector.injectMActivity(permissionRequestModule, this.i.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(permissionRequestModule, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        PermissionRequestModule_MembersInjector.injectMHandler(permissionRequestModule, k());
        return permissionRequestModule;
    }

    private RequestAuthCodeFromCoreAuthModule a(RequestAuthCodeFromCoreAuthModule requestAuthCodeFromCoreAuthModule) {
        WebBridgeModule_MembersInjector.injectMActivity(requestAuthCodeFromCoreAuthModule, this.i.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(requestAuthCodeFromCoreAuthModule, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        RequestAuthCodeFromCoreAuthModule_MembersInjector.injectUserAPI(requestAuthCodeFromCoreAuthModule, b.a.a.b(this.p));
        return requestAuthCodeFromCoreAuthModule;
    }

    private StartShakeDetectionModule a(StartShakeDetectionModule startShakeDetectionModule) {
        WebBridgeModule_MembersInjector.injectMActivity(startShakeDetectionModule, this.i.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(startShakeDetectionModule, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        StartShakeDetectionModule_MembersInjector.injectShakeHandler(startShakeDetectionModule, this.f22096f.get());
        return startShakeDetectionModule;
    }

    private StopShakeDetectionModule a(StopShakeDetectionModule stopShakeDetectionModule) {
        WebBridgeModule_MembersInjector.injectMActivity(stopShakeDetectionModule, this.i.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(stopShakeDetectionModule, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        StopShakeDetectionModule_MembersInjector.injectShakeHandler(stopShakeDetectionModule, this.f22096f.get());
        return stopShakeDetectionModule;
    }

    private FileDownloaderModule a(FileDownloaderModule fileDownloaderModule) {
        WebBridgeModule_MembersInjector.injectMActivity(fileDownloaderModule, this.i.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(fileDownloaderModule, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        FileDownloaderModule_MembersInjector.injectPermissionHandler(fileDownloaderModule, k());
        return fileDownloaderModule;
    }

    private NavigateAppRLModule a(NavigateAppRLModule navigateAppRLModule) {
        WebBridgeModule_MembersInjector.injectMActivity(navigateAppRLModule, this.i.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(navigateAppRLModule, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        NavigateAppRLModule_MembersInjector.injectMAppPathHelper(navigateAppRLModule, l());
        return navigateAppRLModule;
    }

    private com.shopee.app.web2.b.g.a b(com.shopee.app.web2.b.g.a aVar) {
        com.shopee.app.web2.b.g.b.a(aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.web2.b.c.a b(com.shopee.app.web2.b.c.a aVar) {
        com.shopee.app.web2.b.c.b.a(aVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.web2.b.d.c b(com.shopee.app.web2.b.d.c cVar) {
        com.shopee.app.web2.b.d.d.a(cVar, (com.shopee.navigator.e) b.a.c.a(this.f22091a.navigator2(), "Cannot return null from a non-@Nullable component method"));
        return cVar;
    }

    private com.shopee.app.web2.b.d.a b(com.shopee.app.web2.b.d.a aVar) {
        com.shopee.app.web2.b.d.b.a(aVar, (com.shopee.navigator.e) b.a.c.a(this.f22091a.navigator2(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.web2.b.e.a b(com.shopee.app.web2.b.e.a aVar) {
        com.shopee.app.web2.b.e.b.a(aVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.web2.b.e.c b(com.shopee.app.web2.b.e.c cVar) {
        com.shopee.app.web2.b.e.d.a(cVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        return cVar;
    }

    private aw a(aw awVar) {
        com.shopee.app.util.ay.a(awVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.ay.a(awVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        return awVar;
    }

    private com.shopee.app.react.modules.ui.product.a b(com.shopee.app.react.modules.ui.product.a aVar) {
        com.shopee.app.react.modules.ui.product.d.a(aVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.modules.ui.product.d.a(aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.modules.ui.product.d.a(aVar, this.f22093c.get());
        return aVar;
    }

    private com.shopee.app.g.h b(com.shopee.app.g.h hVar) {
        com.shopee.app.g.k.a(hVar, v());
        com.shopee.app.g.k.a(hVar, this.f22094d.get());
        com.shopee.app.g.k.a(hVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.g.k.a(hVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.g.k.a(hVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return hVar;
    }

    private com.shopee.app.ui.webview.g b(com.shopee.app.ui.webview.g gVar) {
        com.shopee.app.ui.webview.h.a(gVar, this.i.get());
        com.shopee.app.ui.webview.h.a(gVar, s());
        com.shopee.app.ui.webview.h.a(gVar, this.f22093c.get());
        com.shopee.app.ui.webview.h.a(gVar, this.f22094d.get());
        com.shopee.app.ui.webview.h.a(gVar, this.z.get());
        com.shopee.app.ui.webview.h.a(gVar, this.A.get());
        com.shopee.app.ui.webview.h.a(gVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.webview.h.a(gVar, (be) b.a.c.a(this.f22091a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.webview.h.a(gVar, (ShareConfigStore) b.a.c.a(this.f22091a.shareConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.webview.h.a(gVar, new com.shopee.app.h.m());
        com.shopee.app.ui.webview.h.a(gVar, this.C.get());
        com.shopee.app.ui.webview.h.a(gVar, t());
        com.shopee.app.ui.webview.h.a(gVar, n());
        com.shopee.app.ui.webview.h.a(gVar, (MeCounter) b.a.c.a(this.f22091a.meCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.webview.h.a(gVar, w());
        com.shopee.app.ui.webview.h.a(gVar, this.y.get());
        return gVar;
    }

    private com.shopee.app.web2.d b(com.shopee.app.web2.d dVar) {
        com.shopee.app.web2.f.a(dVar, this.i.get());
        com.shopee.app.web2.f.a(dVar, new com.shopee.app.web2.c());
        com.shopee.app.web2.f.a(dVar, this.f22094d.get());
        com.shopee.app.web2.f.a(dVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private com.shopee.app.ui.webview.c b(com.shopee.app.ui.webview.c cVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22091a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.A.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.C.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.f22093c.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22091a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.k.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, x());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, this.C.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, t());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, y());
        com.shopee.app.ui.webview.d.a(cVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.webview.d.a(cVar, this.y.get());
        return cVar;
    }

    private com.shopee.app.web2.a b(com.shopee.app.web2.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22091a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.A.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.C.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f22093c.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22091a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.k.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, x());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.C.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, t());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, y());
        com.shopee.app.web2.b.a(aVar, this.E.get());
        return aVar;
    }

    private com.shopee.app.ui.webview.simpleweb.a b(com.shopee.app.ui.webview.simpleweb.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22091a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.A.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.C.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f22093c.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22091a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.k.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, x());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.C.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, t());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, y());
        return aVar;
    }

    private com.shopee.app.ui.webview.simpleweb.b b(com.shopee.app.ui.webview.simpleweb.b bVar) {
        com.shopee.app.ui.webview.simpleweb.d.a(bVar, this.i.get());
        return bVar;
    }

    private ay b(ay ayVar) {
        ba.a(ayVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        ba.a(ayVar, this.f22095e.get());
        return ayVar;
    }

    private MeControlView b(MeControlView meControlView) {
        com.shopee.app.ui.home.me.control.b.a(meControlView, A());
        com.shopee.app.ui.home.me.control.b.a(meControlView, this.f22094d.get());
        com.shopee.app.ui.home.me.control.b.a(meControlView, this.m.get());
        com.shopee.app.ui.home.me.control.b.a(meControlView, (MeCounter) b.a.c.a(this.f22091a.meCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.control.b.a(meControlView, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return meControlView;
    }

    private com.shopee.app.ui.common.aa b(com.shopee.app.ui.common.aa aaVar) {
        ab.a(aaVar, B());
        ab.a(aaVar, this.f22094d.get());
        ab.a(aaVar, this.f22093c.get());
        return aaVar;
    }

    private com.shopee.app.ui.chat2.g b(com.shopee.app.ui.chat2.g gVar) {
        com.shopee.app.ui.chat2.i.a(gVar, L());
        com.shopee.app.ui.chat2.i.a(gVar, this.f22094d.get());
        com.shopee.app.ui.chat2.i.a(gVar, new com.shopee.app.h.m());
        com.shopee.app.ui.chat2.i.a(gVar, this.i.get());
        com.shopee.app.ui.chat2.i.a(gVar, this.f22093c.get());
        com.shopee.app.ui.chat2.i.a(gVar, (be) b.a.c.a(this.f22091a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.chat2.i.a(gVar, this.A.get());
        com.shopee.app.ui.chat2.i.a(gVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return gVar;
    }

    private com.shopee.app.ui.actionbox.actionrequired.c b(com.shopee.app.ui.actionbox.actionrequired.c cVar) {
        com.shopee.app.ui.actionbox.actionrequired.d.a(cVar, this.f22093c.get());
        com.shopee.app.ui.actionbox.actionrequired.d.a(cVar, (com.shopee.app.data.store.bb) b.a.c.a(this.f22091a.ratingShopeeStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox.actionrequired.d.a(cVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox.actionrequired.d.a(cVar, M());
        return cVar;
    }

    private com.shopee.app.ui.common.ai b(com.shopee.app.ui.common.ai aiVar) {
        aj.a(aiVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        aj.a(aiVar, this.f22093c.get());
        return aiVar;
    }

    private com.shopee.app.ui.error.a b(com.shopee.app.ui.error.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22091a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.A.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.C.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f22093c.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22091a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.k.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, x());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.C.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, t());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, y());
        return aVar;
    }

    private com.shopee.app.react.modules.ui.navigator.a b(com.shopee.app.react.modules.ui.navigator.a aVar) {
        com.shopee.app.react.modules.ui.navigator.b.a(aVar, b.a.a.b(this.u));
        com.shopee.app.react.modules.ui.navigator.b.b(aVar, b.a.a.b(this.H));
        com.shopee.app.react.modules.ui.navigator.b.c(aVar, b.a.a.b(this.f22093c));
        return aVar;
    }

    private com.shopee.app.react.modules.ui.email.a b(com.shopee.app.react.modules.ui.email.a aVar) {
        com.shopee.app.react.modules.ui.email.c.a(aVar, p());
        return aVar;
    }

    private com.shopee.app.react.modules.ui.progress.a b(com.shopee.app.react.modules.ui.progress.a aVar) {
        com.shopee.app.react.modules.ui.progress.b.a(aVar, this.A.get());
        return aVar;
    }

    private com.shopee.app.react.modules.ui.share.a b(com.shopee.app.react.modules.ui.share.a aVar) {
        com.shopee.app.react.modules.ui.share.b.a(aVar, w());
        com.shopee.app.react.modules.ui.share.b.a(aVar, (ShareConfigStore) b.a.c.a(this.f22091a.shareConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.modules.ui.share.b.a(aVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.react.modules.ui.video.a b(com.shopee.app.react.modules.ui.video.a aVar) {
        com.shopee.app.react.modules.ui.video.b.a(aVar, this.f22093c.get());
        com.shopee.app.react.modules.ui.video.b.a(aVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.react.modules.unused.imagemanager.a b(com.shopee.app.react.modules.unused.imagemanager.a aVar) {
        com.shopee.app.react.modules.unused.imagemanager.c.a(aVar, p());
        return aVar;
    }

    private com.shopee.app.react.modules.ui.location.b b(com.shopee.app.react.modules.ui.location.b bVar) {
        com.shopee.app.react.modules.ui.location.c.a(bVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return bVar;
    }

    private c b(c cVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22091a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.A.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.C.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.f22093c.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22091a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.k.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, x());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, this.C.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, t());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, y());
        d.a(cVar, this.f22093c.get());
        d.a(cVar, (com.shopee.navigator.e) b.a.c.a(this.f22091a.navigator2(), "Cannot return null from a non-@Nullable component method"));
        d.a(cVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        d.a(cVar, o());
        d.a(cVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        d.a(cVar, (b.a<ReactInstanceManager>) b.a.a.b(this.I));
        d.a(cVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        d.a(cVar, k());
        d.a(cVar, this.k.get());
        return cVar;
    }

    private m b(m mVar) {
        o.a(mVar, this.i.get());
        o.a(mVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        o.a(mVar, R());
        o.a(mVar, S());
        o.a(mVar, this.f22093c.get());
        o.a(mVar, this.f22094d.get());
        o.a(mVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        o.a(mVar, n());
        o.a(mVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        o.a(mVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        o.a(mVar, this.k.get());
        o.a(mVar, T());
        o.a(mVar, (MeCounter) b.a.c.a(this.f22091a.meCounter(), "Cannot return null from a non-@Nullable component method"));
        o.a(mVar, (ChatBadgeStore) b.a.c.a(this.f22091a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
        o.a(mVar, O());
        o.a(mVar, this.f22095e.get());
        o.a(mVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        o.a(mVar, (com.shopee.app.util.s) b.a.c.a(this.f22091a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        o.a(mVar, (bd) b.a.c.a(this.f22091a.toolTipStore(), "Cannot return null from a non-@Nullable component method"));
        o.a(mVar, (FollowCounter) b.a.c.a(this.f22091a.followCounter(), "Cannot return null from a non-@Nullable component method"));
        return mVar;
    }

    private FollowTab b(FollowTab followTab) {
        com.shopee.app.ui.home.follow.c.a(followTab, V());
        com.shopee.app.ui.home.follow.c.a(followTab, this.f22094d.get());
        com.shopee.app.ui.home.follow.c.a(followTab, this.i.get());
        com.shopee.app.ui.home.follow.c.a(followTab, this.f22093c.get());
        return followTab;
    }

    private com.shopee.app.ui.home.a.m b(com.shopee.app.ui.home.a.m mVar) {
        com.shopee.app.ui.home.a.o.a(mVar, W());
        com.shopee.app.ui.home.a.o.a(mVar, ab());
        com.shopee.app.ui.home.a.o.a(mVar, this.A.get());
        com.shopee.app.ui.home.a.o.a(mVar, this.f22093c.get());
        com.shopee.app.ui.home.a.o.a(mVar, this.i.get());
        com.shopee.app.ui.home.a.o.a(mVar, this.f22094d.get());
        com.shopee.app.ui.home.a.o.a(mVar, this.z.get());
        com.shopee.app.ui.home.a.o.a(mVar, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.a.o.a(mVar, this.k.get());
        com.shopee.app.ui.home.a.o.a(mVar, this.j.get());
        return mVar;
    }

    private com.shopee.app.ui.home.a.e b(com.shopee.app.ui.home.a.e eVar) {
        com.shopee.app.ui.home.a.g.a(eVar, this.f22093c.get());
        com.shopee.app.ui.home.a.g.a(eVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return eVar;
    }

    private com.shopee.app.ui.activity.c b(com.shopee.app.ui.activity.c cVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22091a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.A.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.C.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.f22093c.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22091a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.k.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, x());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, this.C.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, t());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, y());
        return cVar;
    }

    private com.shopee.app.ui.activity.d b(com.shopee.app.ui.activity.d dVar) {
        com.shopee.app.ui.common.s.a(dVar, this.f22095e.get());
        com.shopee.app.ui.activity.f.a(dVar, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.activity.f.a(dVar, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private com.shopee.app.ui.activity.a b(com.shopee.app.ui.activity.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22091a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.A.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.C.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f22093c.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22091a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.k.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, x());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.C.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, t());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, y());
        return aVar;
    }

    private ChatTab b(ChatTab chatTab) {
        com.shopee.app.ui.home.chat.a.a(chatTab, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.chat.a.a(chatTab, this.k.get());
        return chatTab;
    }

    private com.shopee.app.ui.actionbox2.f b(com.shopee.app.ui.actionbox2.f fVar) {
        com.shopee.app.ui.actionbox2.h.a(fVar, ag());
        com.shopee.app.ui.actionbox2.h.a(fVar, this.f22093c.get());
        com.shopee.app.ui.actionbox2.h.a(fVar, (com.shopee.navigator.e) b.a.c.a(this.f22091a.navigator2(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.h.a(fVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.h.a(fVar, this.i.get());
        com.shopee.app.ui.actionbox2.h.a(fVar, this.z.get());
        com.shopee.app.ui.actionbox2.h.a(fVar, this.A.get());
        com.shopee.app.ui.actionbox2.h.a(fVar, this.f22094d.get());
        com.shopee.app.ui.actionbox2.h.a(fVar, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.h.a(fVar, (MeCounter) b.a.c.a(this.f22091a.meCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.h.a(fVar, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.h.a(fVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.h.a(fVar, new com.shopee.app.h.m());
        com.shopee.app.ui.actionbox2.h.a(fVar, (com.shopee.app.data.store.b) b.a.c.a(this.f22091a.provideActionIdListStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.h.a(fVar, this.k.get());
        com.shopee.app.ui.actionbox2.h.a(fVar, this.j.get());
        return fVar;
    }

    private com.shopee.app.ui.actionbox2.a b(com.shopee.app.ui.actionbox2.a aVar) {
        com.shopee.app.ui.actionbox2.c.a(aVar, this.f22093c.get());
        com.shopee.app.ui.actionbox2.c.a(aVar, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.c.a(aVar, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.c.a(aVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.c.a(aVar, (be) b.a.c.a(this.f22091a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.c.a(aVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.c.a(aVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox2.c.a(aVar, this.i.get());
        com.shopee.app.ui.actionbox2.c.a(aVar, this.k.get());
        return aVar;
    }

    private ActionBoxActivity b(ActionBoxActivity actionBoxActivity) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) actionBoxActivity, (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) actionBoxActivity, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) actionBoxActivity, (com.shopee.app.application.a.b) b.a.c.a(this.f22091a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) actionBoxActivity, this.A.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) actionBoxActivity, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) actionBoxActivity, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) actionBoxActivity, this.C.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) actionBoxActivity, this.f22093c.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) actionBoxActivity, (com.shopee.app.d.c.f) b.a.c.a(this.f22091a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) actionBoxActivity, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) actionBoxActivity, this.k.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) actionBoxActivity, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) actionBoxActivity, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) actionBoxActivity, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) actionBoxActivity, x());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) actionBoxActivity, this.C.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) actionBoxActivity, t());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) actionBoxActivity, y());
        com.shopee.app.ui.actionbox.a.a(actionBoxActivity, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox.a.a(actionBoxActivity, this.f22093c.get());
        com.shopee.app.ui.actionbox.a.a(actionBoxActivity, this.k.get());
        return actionBoxActivity;
    }

    private com.shopee.app.ui.home.me.v3.feature.k b(com.shopee.app.ui.home.me.v3.feature.k kVar) {
        com.shopee.app.ui.home.me.v3.feature.l.a(kVar, n());
        com.shopee.app.ui.home.me.v3.feature.l.a(kVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.l.a(kVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.l.a(kVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private com.shopee.app.ui.home.me.v3.feature.b b(com.shopee.app.ui.home.me.v3.feature.b bVar) {
        com.shopee.app.ui.home.me.v3.feature.d.a(bVar, this.f22093c.get());
        com.shopee.app.ui.home.me.v3.feature.d.a(bVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.d.a(bVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.d.a(bVar, this.k.get());
        return bVar;
    }

    private ReactTabView b(ReactTabView reactTabView) {
        com.shopee.app.ui.home.react.b.a(reactTabView, (com.shopee.app.react.g) b.a.c.a(this.f22091a.c(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.react.b.a(reactTabView, (ReactInstanceManager) b.a.c.a(this.f22091a.b(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.react.b.a(reactTabView, (com.shopee.app.react.a.a) b.a.c.a(this.f22091a.h(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.react.b.a(reactTabView, this.A.get());
        com.shopee.app.ui.home.react.b.a(reactTabView, (com.garena.reactpush.d.c) b.a.c.a(this.f22091a.e(), "Cannot return null from a non-@Nullable component method"));
        return reactTabView;
    }

    private MeTabView3 b(MeTabView3 meTabView3) {
        com.shopee.app.ui.home.me.v3.e.a(meTabView3, al());
        com.shopee.app.ui.home.me.v3.e.a(meTabView3, this.f22094d.get());
        com.shopee.app.ui.home.me.v3.e.a(meTabView3, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.e.a(meTabView3, this.f22093c.get());
        com.shopee.app.ui.home.me.v3.e.a(meTabView3, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.e.a(meTabView3, (be) b.a.c.a(this.f22091a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.e.a(meTabView3, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.e.a(meTabView3, this.A.get());
        com.shopee.app.ui.home.me.v3.e.a(meTabView3, this.z.get());
        com.shopee.app.ui.home.me.v3.e.a(meTabView3, this.i.get());
        com.shopee.app.ui.home.me.v3.e.a(meTabView3, this.k.get());
        com.shopee.app.ui.home.me.v3.e.a(meTabView3, (com.shopee.app.react.modules.app.data.k) b.a.c.a(this.f22091a.rnConfigProvider(), "Cannot return null from a non-@Nullable component method"));
        return meTabView3;
    }

    private com.shopee.app.ui.home.me.v3.a b(com.shopee.app.ui.home.me.v3.a aVar) {
        com.shopee.app.ui.home.me.v3.b.a(aVar, this.i.get());
        com.shopee.app.ui.home.me.v3.b.a(aVar, this.f22093c.get());
        com.shopee.app.ui.home.me.v3.b.a(aVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.b.a(aVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.b.a(aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.b.a(aVar, (MeCounter) b.a.c.a(this.f22091a.meCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.b.a(aVar, (ChatBadgeStore) b.a.c.a(this.f22091a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.b.a(aVar, (ThemeStore) b.a.c.a(this.f22091a.themeStore(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.ui.home.me.v3.f b(com.shopee.app.ui.home.me.v3.f fVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (com.shopee.app.util.n) b.a.c.a(this.f22091a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (bi) b.a.c.a(this.f22091a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22091a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, this.A.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22091a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, this.C.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, this.f22093c.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22091a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22091a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, this.k.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) fVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, (ActionRequiredCounter) b.a.c.a(this.f22091a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, (ActivityCounter) b.a.c.a(this.f22091a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, x());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, this.C.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, t());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) fVar, y());
        com.shopee.app.ui.home.me.v3.g.a(fVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return fVar;
    }

    private com.shopee.app.ui.home.me.v3.j b(com.shopee.app.ui.home.me.v3.j jVar) {
        com.shopee.app.ui.home.me.v3.k.a(jVar, this.f22093c.get());
        com.shopee.app.ui.home.me.v3.k.a(jVar, an());
        com.shopee.app.ui.home.me.v3.k.a(jVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.k.a(jVar, this.A.get());
        com.shopee.app.ui.home.me.v3.k.a(jVar, (ShareConfigStore) b.a.c.a(this.f22091a.shareConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.k.a(jVar, (be) b.a.c.a(this.f22091a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.k.a(jVar, this.m.get());
        com.shopee.app.ui.home.me.v3.k.a(jVar, this.f22094d.get());
        com.shopee.app.ui.home.me.v3.k.a(jVar, this.k.get());
        return jVar;
    }

    private b.a b(b.a aVar) {
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, this.k.get());
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, this.f22093c.get());
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (be) b.a.c.a(this.f22091a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (com.shopee.app.react.modules.app.data.k) b.a.c.a(this.f22091a.rnConfigProvider(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (com.shopee.app.util.s) b.a.c.a(this.f22091a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (com.shopee.navigator.e) b.a.c.a(this.f22091a.navigator2(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private k.a b(k.a aVar) {
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, this.k.get());
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (UserInfo) b.a.c.a(this.f22091a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, this.f22093c.get());
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (al) b.a.c.a(this.f22091a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (be) b.a.c.a(this.f22091a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (com.shopee.app.react.modules.app.data.k) b.a.c.a(this.f22091a.rnConfigProvider(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (com.shopee.app.util.s) b.a.c.a(this.f22091a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (SettingConfigStore) b.a.c.a(this.f22091a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.home.me.v3.feature.j.a((com.shopee.app.ui.home.me.v3.feature.i) aVar, (com.shopee.navigator.e) b.a.c.a(this.f22091a.navigator2(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f22098a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public f f22099b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public com.shopee.app.react.b.d f22100c;

        private a() {
        }

        public e a() {
            if (this.f22098a != null) {
                if (this.f22099b == null) {
                    this.f22099b = new f();
                }
                if (this.f22100c != null) {
                    return new b(this);
                }
                throw new IllegalStateException(com.shopee.app.react.b.d.class.getCanonicalName() + " must be set");
            }
            throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f22098a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(com.shopee.app.react.b.d dVar) {
            this.f22100c = (com.shopee.app.react.b.d) b.a.c.a(dVar);
            return this;
        }
    }

    private static class s implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22120a;

        s(com.shopee.app.react.b.d dVar) {
            this.f22120a = dVar;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f22120a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class p implements Provider<RegionConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22117a;

        p(com.shopee.app.react.b.d dVar) {
            this.f22117a = dVar;
        }

        /* renamed from: a */
        public RegionConfigStore get() {
            return (RegionConfigStore) b.a.c.a(this.f22117a.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class q implements Provider<f.n> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22118a;

        q(com.shopee.app.react.b.d dVar) {
            this.f22118a = dVar;
        }

        /* renamed from: a */
        public f.n get() {
            return (f.n) b.a.c.a(this.f22118a.retrofit(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class m implements Provider<com.shopee.navigator.e> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22114a;

        m(com.shopee.app.react.b.d dVar) {
            this.f22114a = dVar;
        }

        /* renamed from: a */
        public com.shopee.navigator.e get() {
            return (com.shopee.navigator.e) b.a.c.a(this.f22114a.navigator2(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class k implements Provider<UserInfo> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22112a;

        k(com.shopee.app.react.b.d dVar) {
            this.f22112a = dVar;
        }

        /* renamed from: a */
        public UserInfo get() {
            return (UserInfo) b.a.c.a(this.f22112a.loggedInUser(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class v implements Provider<UploadStore> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22123a;

        v(com.shopee.app.react.b.d dVar) {
            this.f22123a = dVar;
        }

        /* renamed from: a */
        public UploadStore get() {
            return (UploadStore) b.a.c.a(this.f22123a.uploadStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<com.shopee.app.react.modules.app.data.g> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22104a;

        c(com.shopee.app.react.b.d dVar) {
            this.f22104a = dVar;
        }

        /* renamed from: a */
        public com.shopee.app.react.modules.app.data.g get() {
            return (com.shopee.app.react.modules.app.data.g) b.a.c.a(this.f22104a.dataBridgeHandler(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class d implements Provider<com.shopee.app.util.n> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22105a;

        d(com.shopee.app.react.b.d dVar) {
            this.f22105a = dVar;
        }

        /* renamed from: a */
        public com.shopee.app.util.n get() {
            return (com.shopee.app.util.n) b.a.c.a(this.f22105a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.shopee.app.ui.home.b$b  reason: collision with other inner class name */
    private static class C0323b implements Provider<com.shopee.app.tracking.a> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22101a;

        C0323b(com.shopee.app.react.b.d dVar) {
            this.f22101a = dVar;
        }

        /* renamed from: a */
        public com.shopee.app.tracking.a get() {
            return (com.shopee.app.tracking.a) b.a.c.a(this.f22101a.actionTracker(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class l implements Provider<al> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22113a;

        l(com.shopee.app.react.b.d dVar) {
            this.f22113a = dVar;
        }

        /* renamed from: a */
        public al get() {
            return (al) b.a.c.a(this.f22113a.loginStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class o implements Provider<ReactInstanceManager> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22116a;

        o(com.shopee.app.react.b.d dVar) {
            this.f22116a = dVar;
        }

        /* renamed from: a */
        public ReactInstanceManager get() {
            return (ReactInstanceManager) b.a.c.a(this.f22116a.b(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class n implements Provider<com.shopee.app.data.store.bb> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22115a;

        n(com.shopee.app.react.b.d dVar) {
            this.f22115a = dVar;
        }

        /* renamed from: a */
        public com.shopee.app.data.store.bb get() {
            return (com.shopee.app.data.store.bb) b.a.c.a(this.f22115a.ratingShopeeStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class r implements Provider<SearchKeywordsStore> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22119a;

        r(com.shopee.app.react.b.d dVar) {
            this.f22119a = dVar;
        }

        /* renamed from: a */
        public SearchKeywordsStore get() {
            return (SearchKeywordsStore) b.a.c.a(this.f22119a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class t implements Provider<com.shopee.app.tracking.f> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22121a;

        t(com.shopee.app.react.b.d dVar) {
            this.f22121a = dVar;
        }

        /* renamed from: a */
        public com.shopee.app.tracking.f get() {
            return (com.shopee.app.tracking.f) b.a.c.a(this.f22121a.tracker(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class i implements Provider<aa> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22110a;

        i(com.shopee.app.react.b.d dVar) {
            this.f22110a = dVar;
        }

        /* renamed from: a */
        public aa get() {
            return (aa) b.a.c.a(this.f22110a.deviceStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class j implements Provider<com.shopee.app.util.q> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22111a;

        j(com.shopee.app.react.b.d dVar) {
            this.f22111a = dVar;
        }

        /* renamed from: a */
        public com.shopee.app.util.q get() {
            return (com.shopee.app.util.q) b.a.c.a(this.f22111a.fabricClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class u implements Provider<be> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22122a;

        u(com.shopee.app.react.b.d dVar) {
            this.f22122a = dVar;
        }

        /* renamed from: a */
        public be get() {
            return (be) b.a.c.a(this.f22122a.uiStatusStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class e implements Provider<com.shopee.app.util.datapoint.a.a> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22106a;

        e(com.shopee.app.react.b.d dVar) {
            this.f22106a = dVar;
        }

        /* renamed from: a */
        public com.shopee.app.util.datapoint.a.a get() {
            return (com.shopee.app.util.datapoint.a.a) b.a.c.a(this.f22106a.deviceInfoHFSyncManager(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class h implements Provider<com.shopee.app.util.datapoint.a.d> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22109a;

        h(com.shopee.app.react.b.d dVar) {
            this.f22109a = dVar;
        }

        /* renamed from: a */
        public com.shopee.app.util.datapoint.a.d get() {
            return (com.shopee.app.util.datapoint.a.d) b.a.c.a(this.f22109a.deviceInfoMFSyncManager(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class g implements Provider<com.shopee.app.util.datapoint.a.c> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22108a;

        g(com.shopee.app.react.b.d dVar) {
            this.f22108a = dVar;
        }

        /* renamed from: a */
        public com.shopee.app.util.datapoint.a.c get() {
            return (com.shopee.app.util.datapoint.a.c) b.a.c.a(this.f22108a.deviceInfoLFSyncManager(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class f implements Provider<com.shopee.app.util.datapoint.a.b> {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.react.b.d f22107a;

        f(com.shopee.app.react.b.d dVar) {
            this.f22107a = dVar;
        }

        /* renamed from: a */
        public com.shopee.app.util.datapoint.a.b get() {
            return (com.shopee.app.util.datapoint.a.b) b.a.c.a(this.f22107a.deviceInfoInstalledAppSyncManager(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
