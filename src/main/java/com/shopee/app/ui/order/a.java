package com.shopee.app.ui.order;

import android.app.Activity;
import android.content.Context;
import com.shopee.app.a.f;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bd;
import com.shopee.app.d.c.bj;
import com.shopee.app.d.c.cl;
import com.shopee.app.d.c.cm;
import com.shopee.app.d.c.cn;
import com.shopee.app.d.c.ef;
import com.shopee.app.d.c.eg;
import com.shopee.app.d.c.h;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.q;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.order.rate.f;
import com.shopee.app.ui.order.search.d;
import com.shopee.app.ui.order.search.e;
import com.shopee.app.ui.order.search.g;
import com.shopee.app.ui.order.search.l;
import com.shopee.app.ui.order.views.j;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f23445a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f23446b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f23447c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f23448d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f23449e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f23450f;

    /* renamed from: g  reason: collision with root package name */
    private b f23451g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<com.shopee.app.ui.actionbar.a> k;
    private Provider<Context> l;
    private Provider<Activity> m;

    private a(C0369a aVar) {
        a(aVar);
    }

    public static C0369a c() {
        return new C0369a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f23445a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f23445a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f23445a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private d h() {
        return e.a((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private l i() {
        return new l((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f23445a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f23445a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), h());
    }

    private com.shopee.app.ui.order.search.c j() {
        return new com.shopee.app.ui.order.search.c(new com.shopee.app.ui.order.search.n());
    }

    private ef k() {
        return eg.a((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bb) b.a.c.a(this.f23445a.ratingShopeeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private cm l() {
        return cn.a((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private k m() {
        return new k(this.l.get(), this.f23446b.get(), this.f23450f.get(), (bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), l());
    }

    private com.shopee.app.d.c.bi n() {
        return bj.a((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (at) b.a.c.a(this.f23445a.orderNotiStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private e o() {
        return new e((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), m(), n());
    }

    private bd p() {
        return new bd((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), new com.shopee.app.data.store.c.c(), new com.shopee.app.data.store.c.e(), new com.shopee.app.data.store.c.b(), new ah(), new ao(), (at) b.a.c.a(this.f23445a.orderNotiStore(), "Cannot return null from a non-@Nullable component method"), (bb) b.a.c.a(this.f23445a.ratingShopeeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private h q() {
        return com.shopee.app.d.c.i.a((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (at) b.a.c.a(this.f23445a.orderNotiStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.order.b.a r() {
        return new com.shopee.app.ui.order.b.a((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (MeCounter) b.a.c.a(this.f23445a.meCounter(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f23445a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), p(), q());
    }

    private cl s() {
        return new cl((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), new com.shopee.app.data.store.c.e(), new ah(), new ao(), new com.shopee.app.data.store.c.c());
    }

    private com.shopee.app.ui.order.rate.d t() {
        return new com.shopee.app.ui.order.rate.d((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), s());
    }

    private com.shopee.app.d.c.g.c u() {
        return new com.shopee.app.d.c.g.c((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.r(), new bh(), (at) b.a.c.a(this.f23445a.orderNotiStore(), "Cannot return null from a non-@Nullable component method"), (q) b.a.c.a(this.f23445a.checkoutIdStore(), "Cannot return null from a non-@Nullable component method"), new ah(), new ao(), new com.shopee.app.data.store.c.c(), (SettingConfigStore) b.a.c.a(this.f23445a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.order.b.b.a v() {
        return new com.shopee.app.ui.order.b.b.a((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), u(), q());
    }

    private com.shopee.app.d.c.g.a w() {
        return com.shopee.app.d.c.g.b.a((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.e(), (com.shopee.app.data.store.c.d) b.a.c.a(this.f23445a.returnIdStore(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.c(), (at) b.a.c.a(this.f23445a.orderNotiStore(), "Cannot return null from a non-@Nullable component method"), new ao(), new bh(), new ah());
    }

    private com.shopee.app.ui.order.b.c.e x() {
        return new com.shopee.app.ui.order.b.c.e((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), w(), q());
    }

    private com.shopee.app.d.c.c y() {
        return com.shopee.app.d.c.d.a((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.c(), new ah(), new com.shopee.app.data.store.r(), new bh(), new ao(), (SettingConfigStore) b.a.c.a(this.f23445a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.order.detail.b z() {
        return com.shopee.app.ui.order.detail.d.a((n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), m(), y());
    }

    private void a(C0369a aVar) {
        this.f23446b = b.a.a.a(o.a(aVar.f23452a));
        this.f23445a = aVar.f23453b;
        this.f23447c = b.a.a.a(com.shopee.app.a.r.a(aVar.f23452a));
        this.f23448d = b.a.a.a(s.a(aVar.f23452a));
        this.f23449e = b.a.a.a(t.a(aVar.f23452a));
        this.f23450f = b.a.a.a(m.a(aVar.f23452a));
        this.f23451g = new b(aVar.f23453b);
        this.h = b.a.a.a(f.a(aVar.f23452a, this.f23451g));
        this.i = new c(aVar.f23453b);
        this.j = b.a.a.a(w.a(aVar.f23452a, this.i));
        this.k = b.a.a.a(com.shopee.app.a.c.a(aVar.f23452a));
        this.l = b.a.a.a(com.shopee.app.a.h.a(aVar.f23452a));
        this.m = b.a.a.a(com.shopee.app.a.d.a(aVar.f23452a));
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
        return this.f23446b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f23449e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.order.detail.k kVar) {
        b(kVar);
    }

    public void a(com.shopee.app.ui.order.views.m mVar) {
        b(mVar);
    }

    public void a(com.shopee.app.ui.dialog.k kVar) {
        b(kVar);
    }

    public void a(com.shopee.app.ui.order.search.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.order.search.o oVar) {
        b(oVar);
    }

    public void a(g gVar) {
        b(gVar);
    }

    public void a(j jVar) {
        b(jVar);
    }

    public void a(com.shopee.app.ui.actionbox.actionrequired.c cVar) {
        b(cVar);
    }

    public void a(b bVar) {
        b(bVar);
    }

    public void a(g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.ui.order.b.b bVar) {
        b(bVar);
    }

    public void a(com.shopee.app.ui.order.detail.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.order.rate.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.order.rate.f fVar) {
        b(fVar);
    }

    public void a(com.shopee.app.ui.order.b.b.b bVar) {
        b(bVar);
    }

    public void a(com.shopee.app.ui.order.b.c.f fVar) {
        b(fVar);
    }

    public void a(com.shopee.app.ui.order.detail.e eVar) {
        b(eVar);
    }

    public void a(com.shopee.app.ui.order.b.e eVar) {
        b(eVar);
    }

    public void a(com.shopee.app.ui.order.b.c.b bVar) {
        b(bVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f23446b.get());
        return avatarView;
    }

    private k b(k kVar) {
        com.shopee.app.ui.actionbar.l.a(kVar, (bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbar.l.a(kVar, this.f23447c.get());
        com.shopee.app.ui.actionbar.l.a(kVar, d());
        com.shopee.app.ui.actionbar.l.a(kVar, this.f23446b.get());
        com.shopee.app.ui.actionbar.l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f23445a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f23448d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f23446b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f23445a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f23445a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f23446b.get());
        return aVar;
    }

    private com.shopee.app.ui.order.detail.k b(com.shopee.app.ui.order.detail.k kVar) {
        com.shopee.app.ui.order.detail.m.a(kVar, (bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.order.detail.m.a(kVar, this.f23446b.get());
        com.shopee.app.ui.order.detail.m.a(kVar, new ao());
        return kVar;
    }

    private com.shopee.app.ui.order.views.m b(com.shopee.app.ui.order.views.m mVar) {
        com.shopee.app.ui.order.views.o.a(mVar, this.f23446b.get());
        return mVar;
    }

    private com.shopee.app.ui.dialog.k b(com.shopee.app.ui.dialog.k kVar) {
        com.shopee.app.ui.dialog.m.a(kVar, (bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.dialog.m.a(kVar, this.f23446b.get());
        com.shopee.app.ui.dialog.m.a(kVar, (SettingConfigStore) b.a.c.a(this.f23445a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private com.shopee.app.ui.order.search.a b(com.shopee.app.ui.order.search.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23445a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f23450f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23445a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f23445a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f23446b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f23445a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23445a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f23445a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f23445a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f23445a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        com.shopee.app.ui.order.search.b.a(aVar, (SettingConfigStore) b.a.c.a(this.f23445a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.ui.order.search.o b(com.shopee.app.ui.order.search.o oVar) {
        com.shopee.app.ui.order.search.q.a(oVar, this.f23450f.get());
        com.shopee.app.ui.order.search.q.a(oVar, this.f23447c.get());
        com.shopee.app.ui.order.search.q.a(oVar, i());
        com.shopee.app.ui.order.search.q.a(oVar, j());
        com.shopee.app.ui.order.search.q.a(oVar, (UserInfo) b.a.c.a(this.f23445a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.order.search.q.a(oVar, this.f23446b.get());
        com.shopee.app.ui.order.search.q.a(oVar, this.k.get());
        com.shopee.app.ui.order.search.q.a(oVar, (SettingConfigStore) b.a.c.a(this.f23445a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return oVar;
    }

    private g b(g gVar) {
        com.shopee.app.ui.order.search.i.a(gVar, this.f23446b.get());
        return gVar;
    }

    private j b(j jVar) {
        com.shopee.app.ui.order.views.l.a(jVar, this.f23446b.get());
        return jVar;
    }

    private com.shopee.app.ui.actionbox.actionrequired.c b(com.shopee.app.ui.actionbox.actionrequired.c cVar) {
        com.shopee.app.ui.actionbox.actionrequired.d.a(cVar, this.f23446b.get());
        com.shopee.app.ui.actionbox.actionrequired.d.a(cVar, (bb) b.a.c.a(this.f23445a.ratingShopeeStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox.actionrequired.d.a(cVar, (bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbox.actionrequired.d.a(cVar, k());
        return cVar;
    }

    private b b(b bVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23445a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.f23450f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23445a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (UserInfo) b.a.c.a(this.f23445a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.f23446b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f23445a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23445a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (al) b.a.c.a(this.f23445a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f23445a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f23445a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, g());
        c.a(bVar, (UserInfo) b.a.c.a(this.f23445a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        c.a(bVar, (bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        c.a(bVar, this.f23446b.get());
        c.a(bVar, (MeCounter) b.a.c.a(this.f23445a.meCounter(), "Cannot return null from a non-@Nullable component method"));
        return bVar;
    }

    private g b(g gVar) {
        i.a(gVar, o());
        i.a(gVar, this.f23447c.get());
        i.a(gVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23445a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        i.a(gVar, (SettingConfigStore) b.a.c.a(this.f23445a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        i.a(gVar, this.f23446b.get());
        return gVar;
    }

    private com.shopee.app.ui.order.b.b b(com.shopee.app.ui.order.b.b bVar) {
        com.shopee.app.ui.order.b.d.a(bVar, r());
        com.shopee.app.ui.order.b.d.a(bVar, this.f23447c.get());
        com.shopee.app.ui.order.b.d.a(bVar, this.f23446b.get());
        com.shopee.app.ui.order.b.d.a(bVar, this.f23450f.get());
        com.shopee.app.ui.order.b.d.a(bVar, this.m.get());
        com.shopee.app.ui.order.b.d.a(bVar, this.h.get());
        return bVar;
    }

    private com.shopee.app.ui.order.detail.a b(com.shopee.app.ui.order.detail.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23445a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f23450f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23445a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f23445a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f23446b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f23445a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23445a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f23445a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f23445a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f23445a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private com.shopee.app.ui.order.rate.a b(com.shopee.app.ui.order.rate.a aVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (n) b.a.c.a(this.f23445a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (bi) b.a.c.a(this.f23445a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23445a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f23450f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23445a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (UserInfo) b.a.c.a(this.f23445a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.f23446b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f23445a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23445a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) aVar, (al) b.a.c.a(this.f23445a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f23445a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f23445a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private com.shopee.app.ui.order.rate.f b(com.shopee.app.ui.order.rate.f fVar) {
        com.shopee.app.ui.order.rate.h.a(fVar, this.m.get());
        com.shopee.app.ui.order.rate.h.a(fVar, t());
        com.shopee.app.ui.order.rate.h.a(fVar, this.f23447c.get());
        com.shopee.app.ui.order.rate.h.a(fVar, this.f23450f.get());
        com.shopee.app.ui.order.rate.h.a(fVar, new f.a());
        return fVar;
    }

    private com.shopee.app.ui.order.b.b.b b(com.shopee.app.ui.order.b.b.b bVar) {
        com.shopee.app.ui.order.b.b.d.a(bVar, v());
        com.shopee.app.ui.order.b.b.d.a(bVar, this.f23447c.get());
        com.shopee.app.ui.order.b.b.d.a(bVar, this.f23446b.get());
        com.shopee.app.ui.order.b.b.d.a(bVar, this.f23450f.get());
        com.shopee.app.ui.order.b.b.d.a(bVar, this.m.get());
        com.shopee.app.ui.order.b.b.d.a(bVar, this.h.get());
        return bVar;
    }

    private com.shopee.app.ui.order.b.c.f b(com.shopee.app.ui.order.b.c.f fVar) {
        com.shopee.app.ui.order.b.c.h.a(fVar, x());
        com.shopee.app.ui.order.b.c.h.a(fVar, this.f23447c.get());
        com.shopee.app.ui.order.b.c.h.a(fVar, this.f23446b.get());
        com.shopee.app.ui.order.b.c.h.a(fVar, this.f23450f.get());
        com.shopee.app.ui.order.b.c.h.a(fVar, this.m.get());
        com.shopee.app.ui.order.b.c.h.a(fVar, this.h.get());
        com.shopee.app.ui.order.b.c.h.a(fVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23445a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        return fVar;
    }

    private com.shopee.app.ui.order.detail.e b(com.shopee.app.ui.order.detail.e eVar) {
        com.shopee.app.ui.order.detail.g.a(eVar, z());
        com.shopee.app.ui.order.detail.g.a(eVar, this.f23446b.get());
        com.shopee.app.ui.order.detail.g.a(eVar, this.f23447c.get());
        com.shopee.app.ui.order.detail.g.a(eVar, this.m.get());
        return eVar;
    }

    private com.shopee.app.ui.order.b.e b(com.shopee.app.ui.order.b.e eVar) {
        com.shopee.app.ui.order.b.g.a(eVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23445a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.order.b.g.a(eVar, (UserInfo) b.a.c.a(this.f23445a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.order.b.g.a(eVar, this.f23446b.get());
        return eVar;
    }

    private com.shopee.app.ui.order.b.c.b b(com.shopee.app.ui.order.b.c.b bVar) {
        com.shopee.app.ui.order.b.c.d.a(bVar, this.m.get());
        com.shopee.app.ui.order.b.c.d.a(bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23445a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        return bVar;
    }

    /* renamed from: com.shopee.app.ui.order.a$a  reason: collision with other inner class name */
    public static final class C0369a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f23452a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f23453b;

        private C0369a() {
        }

        public d a() {
            if (this.f23452a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f23453b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0369a a(com.shopee.app.a.b bVar) {
            this.f23452a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0369a a(UserComponent userComponent) {
            this.f23453b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23458a;

        b(UserComponent userComponent) {
            this.f23458a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f23458a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23460a;

        c(UserComponent userComponent) {
            this.f23460a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f23460a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
