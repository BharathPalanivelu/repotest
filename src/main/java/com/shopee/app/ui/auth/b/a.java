package com.shopee.app.ui.auth.b;

import android.app.Activity;
import com.shopee.app.a.d;
import com.shopee.app.a.f;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.s;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.t;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.actionbar.l;
import com.shopee.app.ui.auth.g;
import com.shopee.app.ui.auth.p;
import com.shopee.app.ui.auth.phone.h;
import com.shopee.app.ui.auth.phone.j;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f19493a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f19494b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f19495c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f19496d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f19497e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f19498f;

    /* renamed from: g  reason: collision with root package name */
    private b f19499g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;
    private Provider<com.shopee.app.ui.actionbar.a> l;

    private a(C0297a aVar) {
        a(aVar);
    }

    public static C0297a c() {
        return new C0297a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f19493a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f19493a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f19493a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f19493a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f19493a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private g h() {
        return new g((n) b.a.c.a(this.f19493a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.f19494b.get(), this.k.get());
    }

    private com.shopee.app.ui.auth.k i() {
        return new com.shopee.app.ui.auth.k(this.k.get(), (n) b.a.c.a(this.f19493a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.f19494b.get());
    }

    private d j() {
        return new d((n) b.a.c.a(this.f19493a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private p k() {
        return new p((n) b.a.c.a(this.f19493a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private t l() {
        return new t((n) b.a.c.a(this.f19493a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private h m() {
        return new h((n) b.a.c.a(this.f19493a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), l());
    }

    private void a(C0297a aVar) {
        this.f19494b = b.a.a.a(o.a(aVar.f19500a));
        this.f19493a = aVar.f19501b;
        this.f19495c = b.a.a.a(com.shopee.app.a.r.a(aVar.f19500a));
        this.f19496d = b.a.a.a(s.a(aVar.f19500a));
        this.f19497e = b.a.a.a(com.shopee.app.a.t.a(aVar.f19500a));
        this.f19498f = b.a.a.a(m.a(aVar.f19500a));
        this.f19499g = new b(aVar.f19501b);
        this.h = b.a.a.a(f.a(aVar.f19500a, this.f19499g));
        this.i = new c(aVar.f19501b);
        this.j = b.a.a.a(w.a(aVar.f19500a, this.i));
        this.k = b.a.a.a(d.a(aVar.f19500a));
        this.l = b.a.a.a(com.shopee.app.a.c.a(aVar.f19500a));
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
        return this.f19494b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f19497e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.auth.b bVar) {
        b(bVar);
    }

    public void a(com.shopee.app.ui.auth.d dVar) {
        b(dVar);
    }

    public void a(com.shopee.app.ui.auth.m mVar) {
        b(mVar);
    }

    public void a(com.shopee.app.ui.auth.r rVar) {
        b(rVar);
    }

    public void a(com.shopee.app.ui.auth.phone.g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.ui.auth.phone.a aVar) {
        b(aVar);
    }

    public void a(j jVar) {
        b(jVar);
    }

    public void a(com.shopee.app.ui.auth.phone.d dVar) {
        b(dVar);
    }

    public void a(com.shopee.app.ui.auth.h hVar) {
        b(hVar);
    }

    public void a(com.shopee.app.ui.auth.j jVar) {
        b(jVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f19494b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f19493a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f19495c.get());
        l.a(kVar, d());
        l.a(kVar, this.f19494b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f19493a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f19496d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f19494b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f19493a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f19493a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f19494b.get());
        return aVar;
    }

    private com.shopee.app.ui.auth.b b(com.shopee.app.ui.auth.b bVar) {
        com.shopee.app.ui.a.f.a((e) bVar, (n) b.a.c.a(this.f19493a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (bi) b.a.c.a(this.f19493a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19493a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.f19498f.get());
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19493a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (UserInfo) b.a.c.a(this.f19493a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) bVar, this.f19494b.get());
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19493a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19493a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) bVar, (al) b.a.c.a(this.f19493a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f19493a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f19493a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, g());
        com.shopee.app.ui.auth.c.a(bVar, (bi) b.a.c.a(this.f19493a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.c.a(bVar, h());
        com.shopee.app.ui.auth.c.a(bVar, this.j.get());
        com.shopee.app.ui.auth.c.a(bVar, (al) b.a.c.a(this.f19493a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.c.a(bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19493a.tracker(), "Cannot return null from a non-@Nullable component method"));
        return bVar;
    }

    private com.shopee.app.ui.auth.d b(com.shopee.app.ui.auth.d dVar) {
        com.shopee.app.ui.auth.f.a(dVar, this.l.get());
        com.shopee.app.ui.auth.f.a(dVar, h());
        com.shopee.app.ui.auth.f.a(dVar, i());
        return dVar;
    }

    private com.shopee.app.ui.auth.m b(com.shopee.app.ui.auth.m mVar) {
        com.shopee.app.ui.auth.o.a(mVar, j());
        com.shopee.app.ui.auth.o.a(mVar, this.f19495c.get());
        com.shopee.app.ui.auth.o.a(mVar, this.k.get());
        com.shopee.app.ui.auth.o.a(mVar, this.f19494b.get());
        com.shopee.app.ui.auth.o.a(mVar, this.f19498f.get());
        com.shopee.app.ui.auth.o.a(mVar, (aa) b.a.c.a(this.f19493a.deviceStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.o.a(mVar, (SettingConfigStore) b.a.c.a(this.f19493a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.o.a(mVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19493a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.o.a(mVar, this.j.get());
        com.shopee.app.ui.auth.o.a(mVar, (com.shopee.app.util.s) b.a.c.a(this.f19493a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return mVar;
    }

    private com.shopee.app.ui.auth.r b(com.shopee.app.ui.auth.r rVar) {
        com.shopee.app.ui.auth.t.a(rVar, this.f19494b.get());
        com.shopee.app.ui.auth.t.a(rVar, this.f19495c.get());
        com.shopee.app.ui.auth.t.a(rVar, k());
        com.shopee.app.ui.auth.t.a(rVar, this.f19498f.get());
        com.shopee.app.ui.auth.t.a(rVar, (UserInfo) b.a.c.a(this.f19493a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.t.a(rVar, this.k.get());
        com.shopee.app.ui.auth.t.a(rVar, (SettingConfigStore) b.a.c.a(this.f19493a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.t.a(rVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19493a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.t.a(rVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19493a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.t.a(rVar, (al) b.a.c.a(this.f19493a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.t.a(rVar, this.j.get());
        com.shopee.app.ui.auth.t.a(rVar, (com.shopee.app.util.s) b.a.c.a(this.f19493a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return rVar;
    }

    private com.shopee.app.ui.auth.phone.g b(com.shopee.app.ui.auth.phone.g gVar) {
        com.shopee.app.ui.a.f.a((e) gVar, (n) b.a.c.a(this.f19493a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, (bi) b.a.c.a(this.f19493a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19493a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, this.f19498f.get());
        com.shopee.app.ui.a.f.a((e) gVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19493a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, (UserInfo) b.a.c.a(this.f19493a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) gVar, this.f19494b.get());
        com.shopee.app.ui.a.f.a((e) gVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19493a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19493a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) gVar, (al) b.a.c.a(this.f19493a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActionRequiredCounter) b.a.c.a(this.f19493a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActivityCounter) b.a.c.a(this.f19493a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, g());
        return gVar;
    }

    private com.shopee.app.ui.auth.phone.a b(com.shopee.app.ui.auth.phone.a aVar) {
        com.shopee.app.ui.a.f.a((e) aVar, (n) b.a.c.a(this.f19493a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (bi) b.a.c.a(this.f19493a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19493a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.f19498f.get());
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19493a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (UserInfo) b.a.c.a(this.f19493a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) aVar, this.f19494b.get());
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19493a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19493a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) aVar, (al) b.a.c.a(this.f19493a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f19493a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f19493a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private j b(j jVar) {
        com.shopee.app.ui.auth.phone.l.a(jVar, m());
        com.shopee.app.ui.auth.phone.l.a(jVar, this.f19495c.get());
        com.shopee.app.ui.auth.phone.l.a(jVar, this.f19494b.get());
        com.shopee.app.ui.auth.phone.l.a(jVar, this.f19498f.get());
        com.shopee.app.ui.auth.phone.l.a(jVar, this.k.get());
        com.shopee.app.ui.auth.phone.l.a(jVar, (UserInfo) b.a.c.a(this.f19493a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.phone.l.a(jVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19493a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.phone.l.a(jVar, (SettingConfigStore) b.a.c.a(this.f19493a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return jVar;
    }

    private com.shopee.app.ui.auth.phone.d b(com.shopee.app.ui.auth.phone.d dVar) {
        com.shopee.app.ui.auth.phone.f.a(dVar, this.f19494b.get());
        com.shopee.app.ui.auth.phone.f.a(dVar, this.f19495c.get());
        com.shopee.app.ui.auth.phone.f.a(dVar, new com.shopee.app.ui.auth.phone.b());
        com.shopee.app.ui.auth.phone.f.a(dVar, this.f19498f.get());
        com.shopee.app.ui.auth.phone.f.a(dVar, (UserInfo) b.a.c.a(this.f19493a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.phone.f.a(dVar, this.k.get());
        com.shopee.app.ui.auth.phone.f.a(dVar, (aa) b.a.c.a(this.f19493a.deviceStore(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private com.shopee.app.ui.auth.h b(com.shopee.app.ui.auth.h hVar) {
        com.shopee.app.ui.a.f.a((e) hVar, (n) b.a.c.a(this.f19493a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, (bi) b.a.c.a(this.f19493a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19493a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, this.f19498f.get());
        com.shopee.app.ui.a.f.a((e) hVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19493a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, (UserInfo) b.a.c.a(this.f19493a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) hVar, this.f19494b.get());
        com.shopee.app.ui.a.f.a((e) hVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19493a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19493a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) hVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) hVar, (al) b.a.c.a(this.f19493a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, (ActionRequiredCounter) b.a.c.a(this.f19493a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, (ActivityCounter) b.a.c.a(this.f19493a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) hVar, g());
        com.shopee.app.ui.auth.i.a(hVar, (UserInfo) b.a.c.a(this.f19493a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return hVar;
    }

    private com.shopee.app.ui.auth.j b(com.shopee.app.ui.auth.j jVar) {
        com.shopee.app.ui.a.f.a((e) jVar, (n) b.a.c.a(this.f19493a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) jVar, (bi) b.a.c.a(this.f19493a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) jVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19493a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) jVar, this.f19498f.get());
        com.shopee.app.ui.a.f.a((e) jVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19493a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) jVar, (UserInfo) b.a.c.a(this.f19493a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) jVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) jVar, this.f19494b.get());
        com.shopee.app.ui.a.f.a((e) jVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19493a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) jVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19493a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) jVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) jVar, (al) b.a.c.a(this.f19493a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) jVar, (ActionRequiredCounter) b.a.c.a(this.f19493a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) jVar, (ActivityCounter) b.a.c.a(this.f19493a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) jVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) jVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) jVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) jVar, g());
        return jVar;
    }

    /* renamed from: com.shopee.app.ui.auth.b.a$a  reason: collision with other inner class name */
    public static final class C0297a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f19500a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f19501b;

        private C0297a() {
        }

        public b a() {
            if (this.f19500a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f19501b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0297a a(com.shopee.app.a.b bVar) {
            this.f19500a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0297a a(UserComponent userComponent) {
            this.f19501b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f19502a;

        b(UserComponent userComponent) {
            this.f19502a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f19502a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f19503a;

        c(UserComponent userComponent) {
            this.f19503a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f19503a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
