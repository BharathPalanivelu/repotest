package com.shopee.app.ui.auth.signup;

import android.app.Activity;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.a.d;
import com.shopee.app.a.f;
import com.shopee.app.a.m;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.ao;
import com.shopee.app.d.c.dc;
import com.shopee.app.d.c.eh;
import com.shopee.app.d.c.ei;
import com.shopee.app.d.c.o;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.actionbar.l;
import com.shopee.app.ui.auth.signup.email.g;
import com.shopee.app.ui.auth.signup.email.h;
import com.shopee.app.ui.auth.signup.email.j;
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
    private UserComponent f19782a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f19783b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f19784c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f19785d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f19786e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f19787f;

    /* renamed from: g  reason: collision with root package name */
    private b f19788g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;

    private a(C0298a aVar) {
        a(aVar);
    }

    public static C0298a c() {
        return new C0298a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f19782a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f19782a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f19782a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f19782a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private eh h() {
        return ei.a((n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f19782a.jobManager(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f19782a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.auth.signup.phone.b i() {
        return new com.shopee.app.ui.auth.signup.phone.b((n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), h());
    }

    private h j() {
        return new h((n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), h());
    }

    private o k() {
        return new o((n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f19782a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private ao l() {
        return new ao((n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f19782a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private dc m() {
        return new dc((n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f19782a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.auth.signup.a.a n() {
        return new com.shopee.app.ui.auth.signup.a.a((n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f19782a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), k(), l(), m());
    }

    private com.shopee.app.ui.auth.signup.b.a o() {
        return new com.shopee.app.ui.auth.signup.b.a((n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), m());
    }

    private com.shopee.app.ui.auth.signup.email.b p() {
        return new com.shopee.app.ui.auth.signup.email.b((n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), h());
    }

    private void a(C0298a aVar) {
        this.f19783b = b.a.a.a(com.shopee.app.a.o.a(aVar.f19789a));
        this.f19782a = aVar.f19790b;
        this.f19784c = b.a.a.a(com.shopee.app.a.r.a(aVar.f19789a));
        this.f19785d = b.a.a.a(s.a(aVar.f19789a));
        this.f19786e = b.a.a.a(t.a(aVar.f19789a));
        this.f19787f = b.a.a.a(m.a(aVar.f19789a));
        this.f19788g = new b(aVar.f19790b);
        this.h = b.a.a.a(f.a(aVar.f19789a, this.f19788g));
        this.i = new c(aVar.f19790b);
        this.j = b.a.a.a(w.a(aVar.f19789a, this.i));
        this.k = b.a.a.a(d.a(aVar.f19789a));
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
        return this.f19783b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f19786e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.auth.signup.phone.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.auth.signup.phone.d dVar) {
        b(dVar);
    }

    public void a(g gVar) {
        b(gVar);
    }

    public void a(j jVar) {
        b(jVar);
    }

    public void a(com.shopee.app.ui.auth.signup.thirdparty.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.auth.signup.thirdparty.d dVar) {
        b(dVar);
    }

    public void a(com.shopee.app.ui.auth.signup.email.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.auth.signup.email.d dVar) {
        b(dVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f19783b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f19782a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f19784c.get());
        l.a(kVar, d());
        l.a(kVar, this.f19783b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f19782a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f19785d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f19783b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f19782a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f19782a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f19783b.get());
        return aVar;
    }

    private com.shopee.app.ui.auth.signup.phone.a b(com.shopee.app.ui.auth.signup.phone.a aVar) {
        com.shopee.app.ui.a.f.a((e) aVar, (n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (bi) b.a.c.a(this.f19782a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19782a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.f19787f.get());
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19782a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (UserInfo) b.a.c.a(this.f19782a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) aVar, this.f19783b.get());
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19782a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19782a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) aVar, (al) b.a.c.a(this.f19782a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f19782a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f19782a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private com.shopee.app.ui.auth.signup.phone.d b(com.shopee.app.ui.auth.signup.phone.d dVar) {
        com.shopee.app.ui.auth.signup.phone.f.a(dVar, i());
        com.shopee.app.ui.auth.signup.phone.f.a(dVar, this.k.get());
        com.shopee.app.ui.auth.signup.phone.f.a(dVar, this.f19784c.get());
        com.shopee.app.ui.auth.signup.phone.f.a(dVar, this.f19787f.get());
        com.shopee.app.ui.auth.signup.phone.f.a(dVar, this.f19783b.get());
        com.shopee.app.ui.auth.signup.phone.f.a(dVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19782a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.signup.phone.f.a(dVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19782a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.signup.phone.f.a(dVar, this.j.get());
        return dVar;
    }

    private g b(g gVar) {
        com.shopee.app.ui.a.f.a((e) gVar, (n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, (bi) b.a.c.a(this.f19782a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19782a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, this.f19787f.get());
        com.shopee.app.ui.a.f.a((e) gVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19782a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, (UserInfo) b.a.c.a(this.f19782a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) gVar, this.f19783b.get());
        com.shopee.app.ui.a.f.a((e) gVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19782a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19782a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) gVar, (al) b.a.c.a(this.f19782a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActionRequiredCounter) b.a.c.a(this.f19782a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActivityCounter) b.a.c.a(this.f19782a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, g());
        return gVar;
    }

    private j b(j jVar) {
        com.shopee.app.ui.auth.signup.email.l.a(jVar, j());
        com.shopee.app.ui.auth.signup.email.l.a(jVar, this.k.get());
        com.shopee.app.ui.auth.signup.email.l.a(jVar, this.f19783b.get());
        com.shopee.app.ui.auth.signup.email.l.a(jVar, this.f19784c.get());
        com.shopee.app.ui.auth.signup.email.l.a(jVar, this.f19787f.get());
        com.shopee.app.ui.auth.signup.email.l.a(jVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19782a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.signup.email.l.a(jVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19782a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.signup.email.l.a(jVar, this.j.get());
        return jVar;
    }

    private com.shopee.app.ui.auth.signup.thirdparty.a b(com.shopee.app.ui.auth.signup.thirdparty.a aVar) {
        com.shopee.app.ui.a.f.a((e) aVar, (n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (bi) b.a.c.a(this.f19782a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19782a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.f19787f.get());
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19782a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (UserInfo) b.a.c.a(this.f19782a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) aVar, this.f19783b.get());
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19782a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19782a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) aVar, (al) b.a.c.a(this.f19782a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f19782a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f19782a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        com.shopee.app.ui.auth.signup.thirdparty.b.a(aVar, n());
        com.shopee.app.ui.auth.signup.thirdparty.b.a(aVar, o());
        return aVar;
    }

    private com.shopee.app.ui.auth.signup.thirdparty.d b(com.shopee.app.ui.auth.signup.thirdparty.d dVar) {
        com.shopee.app.ui.auth.signup.thirdparty.f.a(dVar, this.k.get());
        com.shopee.app.ui.auth.signup.thirdparty.f.a(dVar, this.f19784c.get());
        com.shopee.app.ui.auth.signup.thirdparty.f.a(dVar, this.f19783b.get());
        com.shopee.app.ui.auth.signup.thirdparty.f.a(dVar, (SettingConfigStore) b.a.c.a(this.f19782a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.signup.thirdparty.f.a(dVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19782a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.auth.signup.thirdparty.f.b(dVar, this.k.get());
        com.shopee.app.ui.auth.signup.thirdparty.f.a(dVar, this.j.get());
        com.shopee.app.ui.auth.signup.thirdparty.f.a(dVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19782a.tracker(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private com.shopee.app.ui.auth.signup.email.a b(com.shopee.app.ui.auth.signup.email.a aVar) {
        com.shopee.app.ui.a.f.a((e) aVar, (n) b.a.c.a(this.f19782a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (bi) b.a.c.a(this.f19782a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19782a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.f19787f.get());
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19782a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (UserInfo) b.a.c.a(this.f19782a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) aVar, this.f19783b.get());
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19782a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19782a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) aVar, (al) b.a.c.a(this.f19782a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f19782a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f19782a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private com.shopee.app.ui.auth.signup.email.d b(com.shopee.app.ui.auth.signup.email.d dVar) {
        com.shopee.app.ui.auth.signup.email.f.a(dVar, p());
        com.shopee.app.ui.auth.signup.email.f.a(dVar, this.k.get());
        com.shopee.app.ui.auth.signup.email.f.a(dVar, this.f19783b.get());
        com.shopee.app.ui.auth.signup.email.f.a(dVar, this.f19784c.get());
        com.shopee.app.ui.auth.signup.email.f.a(dVar, this.f19787f.get());
        com.shopee.app.ui.auth.signup.email.f.a(dVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19782a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    /* renamed from: com.shopee.app.ui.auth.signup.a$a  reason: collision with other inner class name */
    public static final class C0298a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f19789a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f19790b;

        private C0298a() {
        }

        public b a() {
            if (this.f19789a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f19790b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0298a a(com.shopee.app.a.b bVar) {
            this.f19789a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0298a a(UserComponent userComponent) {
            this.f19790b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f19802a;

        b(UserComponent userComponent) {
            this.f19802a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f19802a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f19806a;

        c(UserComponent userComponent) {
            this.f19806a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f19806a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
