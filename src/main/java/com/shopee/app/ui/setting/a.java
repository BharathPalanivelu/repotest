package com.shopee.app.ui.setting;

import android.app.Activity;
import com.shopee.app.a.o;
import com.shopee.app.a.q;
import com.shopee.app.a.t;
import com.shopee.app.a.u;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.bu;
import com.shopee.app.d.c.cp;
import com.shopee.app.d.c.cq;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.ae;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.bd;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.data.store.v;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.h.m;
import com.shopee.app.network.http.a.j;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.actionbar.l;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.setting.a.c;
import com.shopee.app.ui.setting.a.e;
import com.shopee.app.ui.setting.a.g;
import com.shopee.app.upload.UploadManager_Factory;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.app.util.s;
import javax.inject.Provider;

public final class a implements m {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f25019a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f25020b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f25021c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f25022d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f25023e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f25024f;

    /* renamed from: g  reason: collision with root package name */
    private b f25025g;
    private Provider<com.shopee.app.ui.common.a> h;
    private g i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;
    private e l;
    private Provider<RegionConfig> m;
    private d n;
    private c o;
    private h p;
    private UploadManager_Factory q;
    private com.shopee.app.util.l.c r;
    private f s;
    private Provider<com.shopee.app.network.http.a.d> t;
    private Provider<j> u;

    private a(C0386a aVar) {
        a(aVar);
    }

    public static C0386a c() {
        return new C0386a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f25019a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private bt h() {
        return bu.a((n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), (SettingConfigStore) b.a.c.a(this.f25019a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.setting.privacy.b i() {
        return new com.shopee.app.ui.setting.privacy.b((n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new m(), (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), h());
    }

    private cp j() {
        return cq.a((n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c());
    }

    private com.shopee.app.ui.setting.language.b k() {
        return new com.shopee.app.ui.setting.language.b(j());
    }

    private com.shopee.app.ui.setting.account.b l() {
        return new com.shopee.app.ui.setting.account.b((n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.i.a m() {
        return com.shopee.app.d.c.i.b.a((n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (v) b.a.c.a(this.f25019a.crossUserStatusStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.setting.notification2.b n() {
        return new com.shopee.app.ui.setting.notification2.b((n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), m());
    }

    private com.shopee.app.util.b o() {
        return new com.shopee.app.util.b(this.f25020b.get(), b.a.a.b(this.r));
    }

    private com.shopee.app.ui.setting.emailnotification.b p() {
        return new com.shopee.app.ui.setting.emailnotification.b((n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private e q() {
        return new e((al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"), o(), (SettingConfigStore) b.a.c.a(this.f25019a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (ae) b.a.c.a(this.f25019a.forbiddenZoneStore(), "Cannot return null from a non-@Nullable component method"), (bd) b.a.c.a(this.f25019a.toolTipStore(), "Cannot return null from a non-@Nullable component method"), (s) b.a.c.a(this.f25019a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(C0386a aVar) {
        this.f25020b = b.a.a.a(o.a(aVar.f25026a));
        this.f25019a = aVar.f25027b;
        this.f25021c = b.a.a.a(com.shopee.app.a.r.a(aVar.f25026a));
        this.f25022d = b.a.a.a(com.shopee.app.a.s.a(aVar.f25026a));
        this.f25023e = b.a.a.a(t.a(aVar.f25026a));
        this.f25024f = b.a.a.a(com.shopee.app.a.m.a(aVar.f25026a));
        this.f25025g = new b(aVar.f25027b);
        this.h = b.a.a.a(com.shopee.app.a.f.a(aVar.f25026a, this.f25025g));
        this.i = new g(aVar.f25027b);
        this.j = b.a.a.a(w.a(aVar.f25026a, this.i));
        this.k = b.a.a.a(com.shopee.app.a.d.a(aVar.f25026a));
        this.l = new e(aVar.f25027b);
        this.m = b.a.a.a(q.a(aVar.f25026a, this.l));
        this.n = new d(aVar.f25027b);
        this.o = new c(aVar.f25027b);
        this.p = new h(aVar.f25027b);
        this.q = UploadManager_Factory.create(this.p);
        this.r = com.shopee.app.util.l.c.a(this.f25020b, this.n, this.o, this.q);
        this.s = new f(aVar.f25027b);
        this.t = b.a.a.a(com.shopee.app.a.j.a(aVar.f25026a, this.s));
        this.u = b.a.a.a(u.a(aVar.f25026a, this.s));
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
        return this.f25020b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f25023e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.setting.language.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.setting.privacy.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.setting.privacy.d dVar) {
        b(dVar);
    }

    public void a(com.shopee.app.ui.setting.language.d dVar) {
        b(dVar);
    }

    public void a(com.shopee.app.ui.setting.CustomerService.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.setting.CustomerService.b bVar) {
        b(bVar);
    }

    public void a(com.shopee.app.ui.setting.account.g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.ui.setting.account.d dVar) {
        b(dVar);
    }

    public void a(com.shopee.app.ui.setting.notification2.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.setting.notification2.d dVar) {
        b(dVar);
    }

    public void a(d dVar) {
        b(dVar);
    }

    public void a(e eVar) {
        b(eVar);
    }

    public void a(com.shopee.app.ui.setting.emailnotification.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.setting.emailnotification.d dVar) {
        b(dVar);
    }

    public void a(h hVar) {
        b(hVar);
    }

    public void a(i iVar) {
        b(iVar);
    }

    public void a(com.shopee.app.ui.setting.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.setting.a.a.a aVar) {
        b(aVar);
    }

    public void a(g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.ui.setting.a.j jVar) {
        b(jVar);
    }

    public void a(com.shopee.app.ui.setting.notificationsound.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.setting.notificationsound.b bVar) {
        b(bVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f25020b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f25021c.get());
        l.a(kVar, d());
        l.a(kVar, this.f25020b.get());
        l.a(kVar, (s) b.a.c.a(this.f25019a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f25022d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f25020b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f25020b.get());
        return aVar;
    }

    private com.shopee.app.ui.setting.language.a b(com.shopee.app.ui.setting.language.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25019a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25024f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25019a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25020b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25019a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25019a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f25019a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f25019a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private com.shopee.app.ui.setting.privacy.a b(com.shopee.app.ui.setting.privacy.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25019a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25024f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25019a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25020b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25019a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25019a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f25019a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f25019a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private com.shopee.app.ui.setting.privacy.d b(com.shopee.app.ui.setting.privacy.d dVar) {
        com.shopee.app.ui.setting.privacy.f.a(dVar, i());
        com.shopee.app.ui.setting.privacy.f.a(dVar, this.f25021c.get());
        com.shopee.app.ui.setting.privacy.f.a(dVar, this.f25024f.get());
        com.shopee.app.ui.setting.privacy.f.a(dVar, this.k.get());
        com.shopee.app.ui.setting.privacy.f.a(dVar, this.m.get());
        com.shopee.app.ui.setting.privacy.f.a(dVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private com.shopee.app.ui.setting.language.d b(com.shopee.app.ui.setting.language.d dVar) {
        com.shopee.app.ui.setting.language.f.a(dVar, k());
        com.shopee.app.ui.setting.language.f.a(dVar, this.f25021c.get());
        com.shopee.app.ui.setting.language.f.a(dVar, (aa) b.a.c.a(this.f25019a.deviceStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.setting.language.f.a(dVar, this.f25024f.get());
        com.shopee.app.ui.setting.language.f.a(dVar, this.k.get());
        return dVar;
    }

    private com.shopee.app.ui.setting.CustomerService.a b(com.shopee.app.ui.setting.CustomerService.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25019a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25024f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25019a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25020b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25019a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25019a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f25019a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f25019a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private com.shopee.app.ui.setting.CustomerService.b b(com.shopee.app.ui.setting.CustomerService.b bVar) {
        com.shopee.app.ui.setting.CustomerService.d.a(bVar, this.f25020b.get());
        com.shopee.app.ui.setting.CustomerService.d.a(bVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return bVar;
    }

    private com.shopee.app.ui.setting.account.g b(com.shopee.app.ui.setting.account.g gVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25019a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.f25024f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25019a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.f25020b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25019a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25019a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActionRequiredCounter) b.a.c.a(this.f25019a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActivityCounter) b.a.c.a(this.f25019a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, g());
        com.shopee.app.ui.setting.account.h.a(gVar, this.f25020b.get());
        com.shopee.app.ui.setting.account.h.a(gVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return gVar;
    }

    private com.shopee.app.ui.setting.account.d b(com.shopee.app.ui.setting.account.d dVar) {
        com.shopee.app.ui.setting.account.f.a(dVar, l());
        com.shopee.app.ui.setting.account.f.a(dVar, this.f25020b.get());
        com.shopee.app.ui.setting.account.f.a(dVar, this.f25021c.get());
        com.shopee.app.ui.setting.account.f.a(dVar, this.k.get());
        com.shopee.app.ui.setting.account.f.a(dVar, this.f25024f.get());
        com.shopee.app.ui.setting.account.f.a(dVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private com.shopee.app.ui.setting.notification2.a b(com.shopee.app.ui.setting.notification2.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25019a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25024f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25019a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25020b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25019a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25019a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f25019a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f25019a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private com.shopee.app.ui.setting.notification2.d b(com.shopee.app.ui.setting.notification2.d dVar) {
        com.shopee.app.ui.setting.notification2.f.a(dVar, n());
        com.shopee.app.ui.setting.notification2.f.a(dVar, this.f25021c.get());
        com.shopee.app.ui.setting.notification2.f.a(dVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.setting.notification2.f.a(dVar, this.f25024f.get());
        com.shopee.app.ui.setting.notification2.f.a(dVar, this.k.get());
        com.shopee.app.ui.setting.notification2.f.a(dVar, this.m.get());
        com.shopee.app.ui.setting.notification2.f.a(dVar, (SettingConfigStore) b.a.c.a(this.f25019a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.setting.notification2.f.a(dVar, (s) b.a.c.a(this.f25019a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.setting.notification2.f.a(dVar, (v) b.a.c.a(this.f25019a.crossUserStatusStore(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private d b(d dVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25019a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, this.f25024f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25019a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, this.f25020b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25019a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25019a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) dVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActionRequiredCounter) b.a.c.a(this.f25019a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, (ActivityCounter) b.a.c.a(this.f25019a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) dVar, g());
        return dVar;
    }

    private e b(e eVar) {
        g.a(eVar, (be) b.a.c.a(this.f25019a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        g.a(eVar, this.f25024f.get());
        return eVar;
    }

    private com.shopee.app.ui.setting.emailnotification.a b(com.shopee.app.ui.setting.emailnotification.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25019a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25024f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25019a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25020b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25019a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25019a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f25019a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f25019a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private com.shopee.app.ui.setting.emailnotification.d b(com.shopee.app.ui.setting.emailnotification.d dVar) {
        com.shopee.app.ui.setting.emailnotification.f.a(dVar, p());
        com.shopee.app.ui.setting.emailnotification.f.a(dVar, this.f25021c.get());
        com.shopee.app.ui.setting.emailnotification.f.a(dVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.setting.emailnotification.f.a(dVar, this.f25024f.get());
        com.shopee.app.ui.setting.emailnotification.f.a(dVar, this.k.get());
        com.shopee.app.ui.setting.emailnotification.f.a(dVar, this.m.get());
        return dVar;
    }

    private h b(h hVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25019a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, this.f25024f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25019a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, this.f25020b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25019a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25019a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) hVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, (ActionRequiredCounter) b.a.c.a(this.f25019a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, (ActivityCounter) b.a.c.a(this.f25019a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, g());
        return hVar;
    }

    private i b(i iVar) {
        k.a(iVar, this.f25020b.get());
        return iVar;
    }

    private com.shopee.app.ui.setting.a.a b(com.shopee.app.ui.setting.a.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25019a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25024f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25019a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25020b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25019a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25019a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f25019a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f25019a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        c.a(aVar, new m());
        c.a(aVar, this.t.get());
        c.a(aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25019a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        c.a(aVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        c.a(aVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.ui.setting.a.a.a b(com.shopee.app.ui.setting.a.a.a aVar) {
        com.shopee.app.ui.setting.a.a.b.a(aVar, (FollowCounter) b.a.c.a(this.f25019a.followCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.setting.a.a.b.a(aVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.setting.a.a.b.a(aVar, this.u.get());
        com.shopee.app.ui.setting.a.a.b.a(aVar, (s) b.a.c.a(this.f25019a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.setting.a.a.b.a(aVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.setting.a.a.b.a(aVar, q());
        com.shopee.app.ui.setting.a.a.b.a(aVar, this.f25021c.get());
        com.shopee.app.ui.setting.a.a.b.a(aVar, this.f25020b.get());
        com.shopee.app.ui.setting.a.a.b.a(aVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.setting.a.a.b.a(aVar, (SettingConfigStore) b.a.c.a(this.f25019a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private g b(g gVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25019a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.f25024f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25019a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.f25020b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25019a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25019a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActionRequiredCounter) b.a.c.a(this.f25019a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActivityCounter) b.a.c.a(this.f25019a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, g());
        return gVar;
    }

    private com.shopee.app.ui.setting.a.j b(com.shopee.app.ui.setting.a.j jVar) {
        com.shopee.app.ui.setting.a.l.a(jVar, (ThemeStore) b.a.c.a(this.f25019a.themeStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.setting.a.l.a(jVar, this.f25020b.get());
        com.shopee.app.ui.setting.a.l.a(jVar, this.f25024f.get());
        return jVar;
    }

    private com.shopee.app.ui.setting.notificationsound.a b(com.shopee.app.ui.setting.notificationsound.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f25019a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f25019a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25019a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25024f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25019a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f25019a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f25020b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25019a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25019a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f25019a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f25019a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f25019a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private com.shopee.app.ui.setting.notificationsound.b b(com.shopee.app.ui.setting.notificationsound.b bVar) {
        com.shopee.app.ui.setting.notificationsound.c.a(bVar, (v) b.a.c.a(this.f25019a.crossUserStatusStore(), "Cannot return null from a non-@Nullable component method"));
        return bVar;
    }

    /* renamed from: com.shopee.app.ui.setting.a$a  reason: collision with other inner class name */
    public static final class C0386a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f25026a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f25027b;

        private C0386a() {
        }

        public m a() {
            if (this.f25026a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f25027b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0386a a(com.shopee.app.a.b bVar) {
            this.f25026a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0386a a(UserComponent userComponent) {
            this.f25027b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25085a;

        b(UserComponent userComponent) {
            this.f25085a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f25085a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class g implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25132a;

        g(UserComponent userComponent) {
            this.f25132a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f25132a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class e implements Provider<RegionConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25090a;

        e(UserComponent userComponent) {
            this.f25090a = userComponent;
        }

        /* renamed from: a */
        public RegionConfigStore get() {
            return (RegionConfigStore) b.a.c.a(this.f25090a.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class d implements Provider<com.shopee.navigator.e> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25089a;

        d(UserComponent userComponent) {
            this.f25089a = userComponent;
        }

        /* renamed from: a */
        public com.shopee.navigator.e get() {
            return (com.shopee.navigator.e) b.a.c.a(this.f25089a.navigator2(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<UserInfo> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25087a;

        c(UserComponent userComponent) {
            this.f25087a = userComponent;
        }

        /* renamed from: a */
        public UserInfo get() {
            return (UserInfo) b.a.c.a(this.f25087a.loggedInUser(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class h implements Provider<UploadStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25134a;

        h(UserComponent userComponent) {
            this.f25134a = userComponent;
        }

        /* renamed from: a */
        public UploadStore get() {
            return (UploadStore) b.a.c.a(this.f25134a.uploadStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class f implements Provider<f.n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25128a;

        f(UserComponent userComponent) {
            this.f25128a = userComponent;
        }

        /* renamed from: a */
        public f.n get() {
            return (f.n) b.a.c.a(this.f25128a.retrofit(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
