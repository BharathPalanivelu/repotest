package com.shopee.app.ui.product.add;

import android.app.Activity;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.a.l;
import com.shopee.app.a.q;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.ab;
import com.shopee.app.d.c.ac;
import com.shopee.app.d.c.ax;
import com.shopee.app.d.c.ay;
import com.shopee.app.d.c.az;
import com.shopee.app.d.c.ba;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.bu;
import com.shopee.app.d.c.cg;
import com.shopee.app.d.c.ch;
import com.shopee.app.d.c.cy;
import com.shopee.app.d.c.cz;
import com.shopee.app.d.c.da;
import com.shopee.app.d.c.db;
import com.shopee.app.d.c.dv;
import com.shopee.app.d.c.dw;
import com.shopee.app.d.c.el;
import com.shopee.app.d.c.em;
import com.shopee.app.d.c.x;
import com.shopee.app.d.c.y;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.ag;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.an;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.h.p;
import com.shopee.app.network.http.a.g;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.product.add.z;
import com.shopee.app.ui.product.attributes.f;
import com.shopee.app.ui.product.attributes.h;
import com.shopee.app.ui.product.attributes.m;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.util.ak;
import com.shopee.app.util.am;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.app.util.s;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class o implements d {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f24133a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f24134b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f24135c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f24136d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f24137e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f24138f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<Activity> f24139g;
    private Provider<com.shopee.app.ui.actionbar.a> h;
    private b i;
    private Provider<com.shopee.app.ui.common.a> j;
    private e k;
    private Provider<com.shopee.app.tracking.trackingv3.b> l;
    private d m;
    private Provider<com.shopee.app.network.http.a.a> n;
    private Provider<g> o;
    private Provider<com.shopee.app.ui.product.b.a> p;
    private Provider<com.shopee.app.ui.product.b.d> q;
    private c r;
    private Provider<RegionConfig> s;

    private o(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private ax e() {
        return ay.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.g(), ag.b());
    }

    private com.shopee.app.ui.product.attributes.k f() {
        return new com.shopee.app.ui.product.attributes.k((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), e());
    }

    private f g() {
        return new f(new h());
    }

    private com.shopee.app.d.c.c.a h() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f24133a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n i() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f24133a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i j() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f24133a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private m k() {
        return new m((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.product.attributes.a l() {
        return new com.shopee.app.ui.product.attributes.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private j m() {
        return new j((SettingConfigStore) b.a.c.a(this.f24133a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private cy n() {
        return cz.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f24133a.jobManager(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f24133a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private UploadManager o() {
        return new UploadManager((UploadStore) b.a.c.a(this.f24133a.uploadStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private da p() {
        return db.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f24133a.jobManager(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f24133a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f24133a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), o());
    }

    private ab q() {
        return ac.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.m());
    }

    private x r() {
        return y.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.m());
    }

    private cg s() {
        return ch.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.g());
    }

    private az t() {
        return ba.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), s(), new an(), new com.shopee.app.data.store.g(), ag.b());
    }

    private com.shopee.app.util.f.a u() {
        return new com.shopee.app.util.f.a((p) b.a.c.a(this.f24133a.serverManager(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f24133a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.b.a v() {
        return new com.shopee.app.d.c.b.a(new com.shopee.app.data.store.m());
    }

    private dv w() {
        return dw.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.ba) b.a.c.a(this.f24133a.productUploadStore(), "Cannot return null from a non-@Nullable component method"), (UploadStore) b.a.c.a(this.f24133a.uploadStore(), "Cannot return null from a non-@Nullable component method"), u(), (be) b.a.c.a(this.f24133a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"), o(), new com.shopee.app.data.store.m(), ag.b(), (SettingConfigStore) b.a.c.a(this.f24133a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f24133a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), v());
    }

    private el x() {
        return em.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.m(), (com.shopee.app.data.store.ba) b.a.c.a(this.f24133a.productUploadStore(), "Cannot return null from a non-@Nullable component method"), ag.b(), (SettingConfigStore) b.a.c.a(this.f24133a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f24133a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), v());
    }

    private aj y() {
        return new aj((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (be) b.a.c.a(this.f24133a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.ak z() {
        return com.shopee.app.d.c.al.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.m(), new ah());
    }

    private bt A() {
        return bu.a((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), (SettingConfigStore) b.a.c.a(this.f24133a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private e B() {
        String str = "Cannot return null from a non-@Nullable component method";
        return new e((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), m(), n(), p(), q(), r(), t(), s(), w(), x(), (UserInfo) b.a.c.a(this.f24133a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f24133a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), y(), z(), A(), (OkHttpClient) b.a.c.a(this.f24133a.okHttpClient(), str), this.n.get(), (al) b.a.c.a(this.f24133a.loginStore(), str), (s) b.a.c.a(this.f24133a.featureToggleManager(), str), this.q.get());
    }

    private ac C() {
        return new ac((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private x D() {
        return new x((n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), C());
    }

    private com.shopee.app.ui.common.y E() {
        return new com.shopee.app.ui.common.y((bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f24133a.jobManager(), "Cannot return null from a non-@Nullable component method"), (be) b.a.c.a(this.f24133a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"), o(), (am) b.a.c.a(this.f24133a.networkUtil(), "Cannot return null from a non-@Nullable component method"), (UploadStore) b.a.c.a(this.f24133a.uploadStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(a aVar) {
        this.f24134b = b.a.a.a(com.shopee.app.a.o.a(aVar.f24140a));
        this.f24133a = aVar.f24141b;
        this.f24135c = b.a.a.a(com.shopee.app.a.r.a(aVar.f24140a));
        this.f24136d = b.a.a.a(com.shopee.app.a.s.a(aVar.f24140a));
        this.f24137e = b.a.a.a(t.a(aVar.f24140a));
        this.f24138f = b.a.a.a(com.shopee.app.a.m.a(aVar.f24140a));
        this.f24139g = b.a.a.a(com.shopee.app.a.d.a(aVar.f24140a));
        this.h = b.a.a.a(com.shopee.app.a.c.a(aVar.f24140a));
        this.i = new b(aVar.f24141b);
        this.j = b.a.a.a(com.shopee.app.a.f.a(aVar.f24140a, this.i));
        this.k = new e(aVar.f24141b);
        this.l = b.a.a.a(w.a(aVar.f24140a, this.k));
        this.m = new d(aVar.f24141b);
        this.n = b.a.a.a(com.shopee.app.a.g.a(aVar.f24140a, this.m));
        this.o = b.a.a.a(l.a(aVar.f24140a, this.m));
        this.p = b.a.a.a(com.shopee.app.ui.product.b.b.b());
        this.q = b.a.a.a(com.shopee.app.ui.product.b.e.a(this.i, this.o, this.p));
        this.r = new c(aVar.f24141b);
        this.s = b.a.a.a(q.a(aVar.f24140a, this.r));
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
        return this.f24134b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f24137e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.product.attributes.q qVar) {
        b(qVar);
    }

    public void a(com.shopee.app.ui.product.attributes.g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.ui.product.attributes.n nVar) {
        b(nVar);
    }

    public void a(com.shopee.app.ui.product.attributes.c cVar) {
        b(cVar);
    }

    public void a(b bVar) {
        b(bVar);
    }

    public void a(k kVar) {
        b(kVar);
    }

    public void a(ag agVar) {
        b(agVar);
    }

    public void a(p pVar) {
        b(pVar);
    }

    public void a(u uVar) {
        b(uVar);
    }

    public void a(z zVar) {
        b(zVar);
    }

    public void a(q qVar) {
        b(qVar);
    }

    public void a(g gVar) {
        b(gVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f24134b.get());
        return avatarView;
    }

    private k b(k kVar) {
        com.shopee.app.ui.actionbar.l.a(kVar, (bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbar.l.a(kVar, this.f24135c.get());
        com.shopee.app.ui.actionbar.l.a(kVar, d());
        com.shopee.app.ui.actionbar.l.a(kVar, this.f24134b.get());
        com.shopee.app.ui.actionbar.l.a(kVar, (s) b.a.c.a(this.f24133a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f24136d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f24134b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f24133a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f24133a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f24134b.get());
        return aVar;
    }

    private com.shopee.app.ui.product.attributes.q b(com.shopee.app.ui.product.attributes.q qVar) {
        com.shopee.app.ui.product.attributes.s.a(qVar, this.f24138f.get());
        com.shopee.app.ui.product.attributes.s.a(qVar, this.f24135c.get());
        com.shopee.app.ui.product.attributes.s.a(qVar, f());
        com.shopee.app.ui.product.attributes.s.a(qVar, g());
        com.shopee.app.ui.product.attributes.s.a(qVar, this.f24139g.get());
        com.shopee.app.ui.product.attributes.s.a(qVar, this.h.get());
        return qVar;
    }

    private com.shopee.app.ui.product.attributes.g b(com.shopee.app.ui.product.attributes.g gVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.application.a.b) b.a.c.a(this.f24133a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.f24138f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.tracking.f) b.a.c.a(this.f24133a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (UserInfo) b.a.c.a(this.f24133a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.f24134b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.d.c.f) b.a.c.a(this.f24133a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.tracking.a) b.a.c.a(this.f24133a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (al) b.a.c.a(this.f24133a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActionRequiredCounter) b.a.c.a(this.f24133a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActivityCounter) b.a.c.a(this.f24133a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, h());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, this.j.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, i());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, j());
        return gVar;
    }

    private com.shopee.app.ui.product.attributes.n b(com.shopee.app.ui.product.attributes.n nVar) {
        com.shopee.app.ui.product.attributes.p.a(nVar, this.f24138f.get());
        com.shopee.app.ui.product.attributes.p.a(nVar, this.f24135c.get());
        com.shopee.app.ui.product.attributes.p.a(nVar, k());
        return nVar;
    }

    private com.shopee.app.ui.product.attributes.c b(com.shopee.app.ui.product.attributes.c cVar) {
        com.shopee.app.ui.product.attributes.e.a(cVar, this.f24138f.get());
        com.shopee.app.ui.product.attributes.e.a(cVar, this.f24135c.get());
        com.shopee.app.ui.product.attributes.e.a(cVar, l());
        com.shopee.app.ui.product.attributes.e.a(cVar, this.f24134b.get());
        return cVar;
    }

    private b b(b bVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f24133a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.f24138f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f24133a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (UserInfo) b.a.c.a(this.f24133a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.f24134b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f24133a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f24133a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (al) b.a.c.a(this.f24133a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f24133a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f24133a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, h());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.j.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, i());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, j());
        c.a(bVar, (com.shopee.app.ui.product.twitter.e) b.a.c.a(this.f24133a.twitterClient(), "Cannot return null from a non-@Nullable component method"));
        c.a(bVar, (SettingConfigStore) b.a.c.a(this.f24133a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return bVar;
    }

    private k b(k kVar) {
        m.a(kVar, this.f24135c.get());
        m.a(kVar, this.f24134b.get());
        m.a(kVar, this.f24139g.get());
        m.a(kVar, this.f24138f.get());
        m.a(kVar, B());
        m.a(kVar, (com.shopee.app.ui.product.twitter.e) b.a.c.a(this.f24133a.twitterClient(), "Cannot return null from a non-@Nullable component method"));
        m.a(kVar, (be) b.a.c.a(this.f24133a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        m.a(kVar, (com.shopee.app.application.a.b) b.a.c.a(this.f24133a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        m.a(kVar, (com.shopee.app.tracking.f) b.a.c.a(this.f24133a.tracker(), "Cannot return null from a non-@Nullable component method"));
        m.a(kVar, new bh());
        m.a(kVar, new com.shopee.app.h.m());
        m.a(kVar, (SettingConfigStore) b.a.c.a(this.f24133a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        m.a(kVar, (ShareConfigStore) b.a.c.a(this.f24133a.shareConfigStore(), "Cannot return null from a non-@Nullable component method"));
        m.a(kVar, this.s.get());
        m.a(kVar, (SearchKeywordsStore) b.a.c.a(this.f24133a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"));
        m.a(kVar, (com.shopee.app.tracking.a) b.a.c.a(this.f24133a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        m.a(kVar, (s) b.a.c.a(this.f24133a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        m.a(kVar, (UserInfo) b.a.c.a(this.f24133a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        m.a(kVar, this.q.get());
        return kVar;
    }

    private ag b(ag agVar) {
        ai.a(agVar, (bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        ai.a(agVar, this.s.get());
        return agVar;
    }

    private p b(p pVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) pVar, (n) b.a.c.a(this.f24133a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) pVar, (bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) pVar, (com.shopee.app.application.a.b) b.a.c.a(this.f24133a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) pVar, this.f24138f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) pVar, (com.shopee.app.tracking.f) b.a.c.a(this.f24133a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) pVar, (UserInfo) b.a.c.a(this.f24133a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) pVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) pVar, this.f24134b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) pVar, (com.shopee.app.d.c.f) b.a.c.a(this.f24133a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) pVar, (com.shopee.app.tracking.a) b.a.c.a(this.f24133a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) pVar, this.l.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) pVar, (al) b.a.c.a(this.f24133a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) pVar, (ActionRequiredCounter) b.a.c.a(this.f24133a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) pVar, (ActivityCounter) b.a.c.a(this.f24133a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) pVar, h());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) pVar, this.j.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) pVar, i());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) pVar, j());
        return pVar;
    }

    private u b(u uVar) {
        w.a(uVar, (bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return uVar;
    }

    private z b(z zVar) {
        ab.a(zVar, this.f24135c.get());
        ab.a(zVar, D());
        ab.a(zVar, this.f24138f.get());
        ab.a(zVar, new z.a());
        ab.a(zVar, this.f24139g.get());
        return zVar;
    }

    private q b(q qVar) {
        s.a(qVar, (bi) b.a.c.a(this.f24133a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return qVar;
    }

    private g b(g gVar) {
        i.a(gVar, E());
        i.a(gVar, this.f24135c.get());
        i.a(gVar, this.f24139g.get());
        return gVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f24140a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f24141b;

        private a() {
        }

        public d a() {
            if (this.f24140a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f24141b != null) {
                return new o(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f24140a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f24141b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f24142a;

        b(UserComponent userComponent) {
            this.f24142a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f24142a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class e implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f24145a;

        e(UserComponent userComponent) {
            this.f24145a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f24145a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class d implements Provider<f.n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f24144a;

        d(UserComponent userComponent) {
            this.f24144a = userComponent;
        }

        /* renamed from: a */
        public f.n get() {
            return (f.n) b.a.c.a(this.f24144a.retrofit(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<RegionConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f24143a;

        c(UserComponent userComponent) {
            this.f24143a = userComponent;
        }

        /* renamed from: a */
        public RegionConfigStore get() {
            return (RegionConfigStore) b.a.c.a(this.f24143a.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
