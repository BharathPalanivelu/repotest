package com.shopee.app.ui.auth.password;

import android.app.Activity;
import com.shopee.app.a.d;
import com.shopee.app.a.f;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.actionbar.l;
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

public final class g implements i {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f19608a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f19609b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f19610c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f19611d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f19612e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f19613f;

    /* renamed from: g  reason: collision with root package name */
    private b f19614g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;

    private g(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f19608a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f19608a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f19608a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f19608a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f19608a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private m h() {
        return new m((n) b.a.c.a(this.f19608a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private t i() {
        return new t((n) b.a.c.a(this.f19608a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private b j() {
        return new b((n) b.a.c.a(this.f19608a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(a aVar) {
        this.f19609b = b.a.a.a(o.a(aVar.f19615a));
        this.f19608a = aVar.f19616b;
        this.f19610c = b.a.a.a(com.shopee.app.a.r.a(aVar.f19615a));
        this.f19611d = b.a.a.a(s.a(aVar.f19615a));
        this.f19612e = b.a.a.a(t.a(aVar.f19615a));
        this.f19613f = b.a.a.a(m.a(aVar.f19615a));
        this.f19614g = new b(aVar.f19616b);
        this.h = b.a.a.a(f.a(aVar.f19615a, this.f19614g));
        this.i = new c(aVar.f19616b);
        this.j = b.a.a.a(w.a(aVar.f19615a, this.i));
        this.k = b.a.a.a(d.a(aVar.f19615a));
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
        return this.f19609b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f19612e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(k kVar) {
        b(kVar);
    }

    public void a(o oVar) {
        b(oVar);
    }

    public void a(r rVar) {
        b(rVar);
    }

    public void a(v vVar) {
        b(vVar);
    }

    public void a(a aVar) {
        b(aVar);
    }

    public void a(d dVar) {
        b(dVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f19609b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f19608a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f19610c.get());
        l.a(kVar, d());
        l.a(kVar, this.f19609b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f19608a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f19611d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f19609b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f19608a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f19608a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f19609b.get());
        return aVar;
    }

    private k b(k kVar) {
        com.shopee.app.ui.a.f.a((e) kVar, (n) b.a.c.a(this.f19608a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, (bi) b.a.c.a(this.f19608a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19608a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, this.f19613f.get());
        com.shopee.app.ui.a.f.a((e) kVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19608a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, (UserInfo) b.a.c.a(this.f19608a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) kVar, this.f19609b.get());
        com.shopee.app.ui.a.f.a((e) kVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19608a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19608a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) kVar, (al) b.a.c.a(this.f19608a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) kVar, (ActionRequiredCounter) b.a.c.a(this.f19608a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) kVar, (ActivityCounter) b.a.c.a(this.f19608a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) kVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) kVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) kVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) kVar, g());
        l.a(kVar, this.f19609b.get());
        return kVar;
    }

    private o b(o oVar) {
        q.a(oVar, h());
        q.a(oVar, this.f19610c.get());
        q.a(oVar, this.k.get());
        q.a(oVar, this.f19613f.get());
        q.a(oVar, this.f19609b.get());
        return oVar;
    }

    private r b(r rVar) {
        com.shopee.app.ui.a.f.a((e) rVar, (n) b.a.c.a(this.f19608a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) rVar, (bi) b.a.c.a(this.f19608a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) rVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19608a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) rVar, this.f19613f.get());
        com.shopee.app.ui.a.f.a((e) rVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19608a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) rVar, (UserInfo) b.a.c.a(this.f19608a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) rVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) rVar, this.f19609b.get());
        com.shopee.app.ui.a.f.a((e) rVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19608a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) rVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19608a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) rVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) rVar, (al) b.a.c.a(this.f19608a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) rVar, (ActionRequiredCounter) b.a.c.a(this.f19608a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) rVar, (ActivityCounter) b.a.c.a(this.f19608a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) rVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) rVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) rVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) rVar, g());
        s.a(rVar, (UserInfo) b.a.c.a(this.f19608a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return rVar;
    }

    private v b(v vVar) {
        x.a(vVar, i());
        x.a(vVar, this.f19610c.get());
        x.a(vVar, this.k.get());
        x.a(vVar, this.f19613f.get());
        x.a(vVar, this.f19609b.get());
        x.a(vVar, (UserInfo) b.a.c.a(this.f19608a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return vVar;
    }

    private a b(a aVar) {
        com.shopee.app.ui.a.f.a((e) aVar, (n) b.a.c.a(this.f19608a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (bi) b.a.c.a(this.f19608a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.application.a.b) b.a.c.a(this.f19608a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.f19613f.get());
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.tracking.f) b.a.c.a(this.f19608a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (UserInfo) b.a.c.a(this.f19608a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) aVar, this.f19609b.get());
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.d.c.f) b.a.c.a(this.f19608a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, (com.shopee.app.tracking.a) b.a.c.a(this.f19608a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) aVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) aVar, (al) b.a.c.a(this.f19608a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActionRequiredCounter) b.a.c.a(this.f19608a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, (ActivityCounter) b.a.c.a(this.f19608a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) aVar, g());
        return aVar;
    }

    private d b(d dVar) {
        f.a(dVar, j());
        f.a(dVar, (UserInfo) b.a.c.a(this.f19608a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        f.a(dVar, this.f19613f.get());
        f.a(dVar, this.f19609b.get());
        f.a(dVar, this.f19610c.get());
        f.a(dVar, this.k.get());
        return dVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f19615a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f19616b;

        private a() {
        }

        public i a() {
            if (this.f19615a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f19616b != null) {
                return new g(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f19615a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f19616b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f19617a;

        b(UserComponent userComponent) {
            this.f19617a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f19617a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f19618a;

        c(UserComponent userComponent) {
            this.f19618a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f19618a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
