package com.shopee.app.react.b;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.ReactInstanceManager;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.q;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.v;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.as;
import com.shopee.app.d.c.at;
import com.shopee.app.d.c.de;
import com.shopee.app.d.c.df;
import com.shopee.app.d.c.dl;
import com.shopee.app.d.c.dm;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.react.debug.ReactDebugActivity;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.follow.search.j;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.product.search.l;
import com.shopee.app.upload.UploadManager_Factory;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.util.ak;
import com.shopee.app.util.ax;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private d f18565a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f18566b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f18567c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<com.shopee.app.ui.common.i> f18568d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f18569e;

    /* renamed from: f  reason: collision with root package name */
    private h f18570f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<com.shopee.app.tracking.c> f18571g;
    private Provider<Activity> h;
    private Provider<com.shopee.app.a.a.a> i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private g k;
    private Provider<RegionConfig> l;
    private f m;
    private d n;
    private i o;
    private UploadManager_Factory p;
    private com.shopee.app.util.l.c q;
    private b r;
    private e s;
    private ax t;
    private Provider<r> u;
    private Provider<Context> v;
    private c w;
    private Provider<com.shopee.app.ui.common.a> x;

    private a(C0276a aVar) {
        a(aVar);
    }

    public static C0276a c() {
        return new C0276a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f18565a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private j e() {
        return new j((n) b.a.c.a(this.f18565a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.follow.search.d f() {
        return new com.shopee.app.ui.follow.search.d((n) b.a.c.a(this.f18565a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private l g() {
        return new l((n) b.a.c.a(this.f18565a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f18565a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (SearchKeywordsStore) b.a.c.a(this.f18565a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"), e(), f(), this.f18571g.get());
    }

    private as h() {
        return at.a((n) b.a.c.a(this.f18565a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ao(), new ah());
    }

    private com.shopee.app.ui.common.a.a i() {
        return new com.shopee.app.ui.common.a.a(h());
    }

    private com.shopee.app.d.c.b j() {
        return new com.shopee.app.d.c.b((n) b.a.c.a(this.f18565a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new p(), new bh(), (UserInfo) b.a.c.a(this.f18565a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private de k() {
        return df.a((n) b.a.c.a(this.f18565a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh());
    }

    private com.shopee.app.g.i l() {
        return new com.shopee.app.g.i((bi) b.a.c.a(this.f18565a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), k());
    }

    private dl m() {
        return dm.a((n) b.a.c.a(this.f18565a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.g.h n() {
        return b(com.shopee.app.g.j.a(this.v.get()));
    }

    private com.shopee.app.d.c.c.a o() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f18565a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f18565a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n p() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f18565a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i q() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f18565a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.c.a r() {
        return new com.shopee.app.ui.c.a((al) b.a.c.a(this.f18565a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(C0276a aVar) {
        this.f18566b = b.a.a.a(o.a(aVar.f18572a));
        this.f18565a = aVar.f18573b;
        this.f18567c = b.a.a.a(com.shopee.app.a.r.a(aVar.f18572a));
        this.f18568d = b.a.a.a(s.a(aVar.f18572a));
        this.f18569e = b.a.a.a(t.a(aVar.f18572a));
        this.f18570f = new h(aVar.f18573b);
        this.f18571g = b.a.a.a(v.a(aVar.f18572a, this.f18570f));
        this.h = b.a.a.a(com.shopee.app.a.d.a(aVar.f18572a));
        this.i = b.a.a.a(com.shopee.app.a.e.a(aVar.f18572a));
        this.j = b.a.a.a(w.a(aVar.f18572a, this.f18570f));
        this.k = new g(aVar.f18573b);
        this.l = b.a.a.a(q.a(aVar.f18572a, this.k));
        this.m = new f(aVar.f18573b);
        this.n = new d(aVar.f18573b);
        this.o = new i(aVar.f18573b);
        this.p = UploadManager_Factory.create(this.o);
        this.q = com.shopee.app.util.l.c.a(this.f18566b, this.m, this.n, this.p);
        this.r = new b(aVar.f18573b);
        this.s = new e(aVar.f18573b);
        this.t = ax.a(this.n, this.f18566b, this.f18570f, this.m, this.p, this.r, this.s);
        this.u = b.a.a.a(m.a(aVar.f18572a));
        this.v = b.a.a.a(com.shopee.app.a.h.a(aVar.f18572a));
        this.w = new c(aVar.f18573b);
        this.x = b.a.a.a(com.shopee.app.a.f.a(aVar.f18572a, this.w));
    }

    public void a(AvatarView avatarView) {
        b(avatarView);
    }

    public void a(k kVar) {
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
        return this.f18566b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f18569e.get();
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

    public void a(com.shopee.app.g.h hVar) {
        b(hVar);
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

    public void a(com.shopee.app.react.d dVar) {
        b(dVar);
    }

    public void a(ReactDebugActivity reactDebugActivity) {
        b(reactDebugActivity);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f18566b.get());
        return avatarView;
    }

    private k b(k kVar) {
        com.shopee.app.ui.actionbar.l.a(kVar, (bi) b.a.c.a(this.f18565a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbar.l.a(kVar, this.f18567c.get());
        com.shopee.app.ui.actionbar.l.a(kVar, d());
        com.shopee.app.ui.actionbar.l.a(kVar, this.f18566b.get());
        com.shopee.app.ui.actionbar.l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f18565a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f18568d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f18566b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f18565a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f18565a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f18566b.get());
        return aVar;
    }

    private com.shopee.app.ui.product.search.o b(com.shopee.app.ui.product.search.o oVar) {
        com.shopee.app.ui.product.search.q.a(oVar, g());
        com.shopee.app.ui.product.search.q.a(oVar, this.f18567c.get());
        com.shopee.app.ui.product.search.q.a(oVar, this.f18566b.get());
        com.shopee.app.ui.product.search.q.a(oVar, this.h.get());
        com.shopee.app.ui.product.search.q.a(oVar, (com.shopee.app.tracking.a) b.a.c.a(this.f18565a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.product.search.q.a(oVar, this.f18571g.get());
        com.shopee.app.ui.product.search.q.a(oVar, (SearchKeywordsStore) b.a.c.a(this.f18565a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.product.search.q.a(oVar, this.i.get());
        com.shopee.app.ui.product.search.q.a(oVar, this.j.get());
        return oVar;
    }

    private com.shopee.app.ui.common.a.c b(com.shopee.app.ui.common.a.c cVar) {
        com.shopee.app.ui.common.a.e.a(cVar, i());
        com.shopee.app.ui.common.a.e.a(cVar, this.f18567c.get());
        com.shopee.app.ui.common.a.e.a(cVar, (UserInfo) b.a.c.a(this.f18565a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f18565a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, this.j.get());
        com.shopee.app.ui.common.a.e.a(cVar, this.l.get());
        com.shopee.app.ui.common.a.e.a(cVar, (SettingConfigStore) b.a.c.a(this.f18565a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, (com.shopee.app.util.s) b.a.c.a(this.f18565a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, this.f18566b.get());
        com.shopee.app.ui.common.a.e.a(cVar, j());
        com.shopee.app.ui.common.a.e.a(cVar, (bi) b.a.c.a(this.f18565a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.common.a.e.a(cVar, this.h.get());
        return cVar;
    }

    private com.shopee.app.g.h b(com.shopee.app.g.h hVar) {
        com.shopee.app.g.k.a(hVar, l());
        com.shopee.app.g.k.a(hVar, this.f18567c.get());
        com.shopee.app.g.k.a(hVar, (SettingConfigStore) b.a.c.a(this.f18565a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.g.k.a(hVar, (com.shopee.app.tracking.f) b.a.c.a(this.f18565a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.g.k.a(hVar, (UserInfo) b.a.c.a(this.f18565a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return hVar;
    }

    private com.shopee.app.react.modules.ui.navigator.a b(com.shopee.app.react.modules.ui.navigator.a aVar) {
        com.shopee.app.react.modules.ui.navigator.b.a(aVar, b.a.a.b(this.q));
        com.shopee.app.react.modules.ui.navigator.b.b(aVar, b.a.a.b(this.t));
        com.shopee.app.react.modules.ui.navigator.b.c(aVar, b.a.a.b(this.f18566b));
        return aVar;
    }

    private com.shopee.app.react.modules.ui.email.a b(com.shopee.app.react.modules.ui.email.a aVar) {
        com.shopee.app.react.modules.ui.email.c.a(aVar, m());
        return aVar;
    }

    private com.shopee.app.react.modules.ui.progress.a b(com.shopee.app.react.modules.ui.progress.a aVar) {
        com.shopee.app.react.modules.ui.progress.b.a(aVar, this.u.get());
        return aVar;
    }

    private com.shopee.app.react.modules.ui.share.a b(com.shopee.app.react.modules.ui.share.a aVar) {
        com.shopee.app.react.modules.ui.share.b.a(aVar, n());
        com.shopee.app.react.modules.ui.share.b.a(aVar, (ShareConfigStore) b.a.c.a(this.f18565a.shareConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.modules.ui.share.b.a(aVar, (UserInfo) b.a.c.a(this.f18565a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.react.modules.ui.video.a b(com.shopee.app.react.modules.ui.video.a aVar) {
        com.shopee.app.react.modules.ui.video.b.a(aVar, this.f18566b.get());
        com.shopee.app.react.modules.ui.video.b.a(aVar, (SettingConfigStore) b.a.c.a(this.f18565a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.react.modules.unused.imagemanager.a b(com.shopee.app.react.modules.unused.imagemanager.a aVar) {
        com.shopee.app.react.modules.unused.imagemanager.c.a(aVar, m());
        return aVar;
    }

    private com.shopee.app.react.modules.ui.product.a b(com.shopee.app.react.modules.ui.product.a aVar) {
        com.shopee.app.react.modules.ui.product.d.a(aVar, (UserInfo) b.a.c.a(this.f18565a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.modules.ui.product.d.a(aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f18565a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.modules.ui.product.d.a(aVar, this.f18566b.get());
        return aVar;
    }

    private com.shopee.app.react.modules.ui.location.b b(com.shopee.app.react.modules.ui.location.b bVar) {
        com.shopee.app.react.modules.ui.location.c.a(bVar, (SettingConfigStore) b.a.c.a(this.f18565a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return bVar;
    }

    private com.shopee.app.react.d b(com.shopee.app.react.d dVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (n) b.a.c.a(this.f18565a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (bi) b.a.c.a(this.f18565a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (com.shopee.app.application.a.b) b.a.c.a(this.f18565a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, this.u.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (com.shopee.app.tracking.f) b.a.c.a(this.f18565a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (UserInfo) b.a.c.a(this.f18565a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, this.x.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, this.f18566b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (com.shopee.app.d.c.f) b.a.c.a(this.f18565a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (com.shopee.app.tracking.a) b.a.c.a(this.f18565a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (al) b.a.c.a(this.f18565a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActionRequiredCounter) b.a.c.a(this.f18565a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActivityCounter) b.a.c.a(this.f18565a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, o());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, this.x.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, p());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, q());
        com.shopee.app.react.f.a(dVar, (com.shopee.app.react.g) b.a.c.a(this.f18565a.c(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.f.a(dVar, (ReactInstanceManager) b.a.c.a(this.f18565a.b(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.f.a(dVar, this.u.get());
        com.shopee.app.react.f.a(dVar, (com.shopee.app.react.a.a) b.a.c.a(this.f18565a.h(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.f.a(dVar, (com.garena.reactpush.d.c) b.a.c.a(this.f18565a.e(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.f.a(dVar, p());
        com.shopee.app.react.f.a(dVar, q());
        com.shopee.app.react.f.a(dVar, r());
        return dVar;
    }

    private ReactDebugActivity b(ReactDebugActivity reactDebugActivity) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) reactDebugActivity, (n) b.a.c.a(this.f18565a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) reactDebugActivity, (bi) b.a.c.a(this.f18565a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) reactDebugActivity, (com.shopee.app.application.a.b) b.a.c.a(this.f18565a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) reactDebugActivity, this.u.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) reactDebugActivity, (com.shopee.app.tracking.f) b.a.c.a(this.f18565a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) reactDebugActivity, (UserInfo) b.a.c.a(this.f18565a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) reactDebugActivity, this.x.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) reactDebugActivity, this.f18566b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) reactDebugActivity, (com.shopee.app.d.c.f) b.a.c.a(this.f18565a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) reactDebugActivity, (com.shopee.app.tracking.a) b.a.c.a(this.f18565a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) reactDebugActivity, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) reactDebugActivity, (al) b.a.c.a(this.f18565a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) reactDebugActivity, (ActionRequiredCounter) b.a.c.a(this.f18565a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) reactDebugActivity, (ActivityCounter) b.a.c.a(this.f18565a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) reactDebugActivity, o());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) reactDebugActivity, this.x.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) reactDebugActivity, p());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) reactDebugActivity, q());
        com.shopee.app.react.debug.a.a(reactDebugActivity, (com.shopee.app.react.g) b.a.c.a(this.f18565a.c(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.debug.a.a(reactDebugActivity, (com.shopee.app.react.a.a) b.a.c.a(this.f18565a.h(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.react.debug.a.a(reactDebugActivity, (com.garena.reactpush.b.b) b.a.c.a(this.f18565a.g(), "Cannot return null from a non-@Nullable component method"));
        return reactDebugActivity;
    }

    /* renamed from: com.shopee.app.react.b.a$a  reason: collision with other inner class name */
    public static final class C0276a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f18572a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public d f18573b;

        private C0276a() {
        }

        public c a() {
            if (this.f18572a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f18573b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(d.class.getCanonicalName() + " must be set");
            }
        }

        public C0276a a(com.shopee.app.a.b bVar) {
            this.f18572a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0276a a(d dVar) {
            this.f18573b = (d) b.a.c.a(dVar);
            return this;
        }
    }

    private static class h implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final d f18580a;

        h(d dVar) {
            this.f18580a = dVar;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f18580a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class g implements Provider<RegionConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final d f18579a;

        g(d dVar) {
            this.f18579a = dVar;
        }

        /* renamed from: a */
        public RegionConfigStore get() {
            return (RegionConfigStore) b.a.c.a(this.f18579a.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class f implements Provider<com.shopee.navigator.e> {

        /* renamed from: a  reason: collision with root package name */
        private final d f18578a;

        f(d dVar) {
            this.f18578a = dVar;
        }

        /* renamed from: a */
        public com.shopee.navigator.e get() {
            return (com.shopee.navigator.e) b.a.c.a(this.f18578a.navigator2(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class d implements Provider<UserInfo> {

        /* renamed from: a  reason: collision with root package name */
        private final d f18576a;

        d(d dVar) {
            this.f18576a = dVar;
        }

        /* renamed from: a */
        public UserInfo get() {
            return (UserInfo) b.a.c.a(this.f18576a.loggedInUser(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class i implements Provider<UploadStore> {

        /* renamed from: a  reason: collision with root package name */
        private final d f18581a;

        i(d dVar) {
            this.f18581a = dVar;
        }

        /* renamed from: a */
        public UploadStore get() {
            return (UploadStore) b.a.c.a(this.f18581a.uploadStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class b implements Provider<com.shopee.app.tracking.a> {

        /* renamed from: a  reason: collision with root package name */
        private final d f18574a;

        b(d dVar) {
            this.f18574a = dVar;
        }

        /* renamed from: a */
        public com.shopee.app.tracking.a get() {
            return (com.shopee.app.tracking.a) b.a.c.a(this.f18574a.actionTracker(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class e implements Provider<al> {

        /* renamed from: a  reason: collision with root package name */
        private final d f18577a;

        e(d dVar) {
            this.f18577a = dVar;
        }

        /* renamed from: a */
        public al get() {
            return (al) b.a.c.a(this.f18577a.loginStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final d f18575a;

        c(d dVar) {
            this.f18575a = dVar;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f18575a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
