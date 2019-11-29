package com.shopee.app.ui.gallery;

import android.app.Activity;
import com.shopee.app.a.f;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.aq;
import com.shopee.app.d.c.cb;
import com.shopee.app.d.c.cc;
import com.shopee.app.d.c.cd;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.instagram.e;
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

public final class d implements m {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f21871a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f21872b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f21873c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f21874d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f21875e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f21876f;

    /* renamed from: g  reason: collision with root package name */
    private b f21877g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<com.shopee.app.ui.actionbar.a> k;
    private Provider<Activity> l;

    private d(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f21871a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f21871a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f21871a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f21871a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f21871a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.h.b.a.a h() {
        return new com.shopee.app.h.b.a.a((ar) b.a.c.a(this.f21871a.app(), "Cannot return null from a non-@Nullable component method"));
    }

    private aq i() {
        return new aq((n) b.a.c.a(this.f21871a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), h());
    }

    private q j() {
        return new q((n) b.a.c.a(this.f21871a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), i());
    }

    private cc k() {
        return cd.a((n) b.a.c.a(this.f21871a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (e) b.a.c.a(this.f21871a.instagramClient(), "Cannot return null from a non-@Nullable component method"));
    }

    private h l() {
        return new h((n) b.a.c.a(this.f21871a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), k(), i());
    }

    private cb m() {
        return new cb((n) b.a.c.a(this.f21871a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.gallery.a.a n() {
        return new com.shopee.app.ui.gallery.a.a((n) b.a.c.a(this.f21871a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), m());
    }

    private void a(a aVar) {
        this.f21872b = b.a.a.a(o.a(aVar.f21878a));
        this.f21871a = aVar.f21879b;
        this.f21873c = b.a.a.a(com.shopee.app.a.r.a(aVar.f21878a));
        this.f21874d = b.a.a.a(s.a(aVar.f21878a));
        this.f21875e = b.a.a.a(t.a(aVar.f21878a));
        this.f21876f = b.a.a.a(m.a(aVar.f21878a));
        this.f21877g = new b(aVar.f21879b);
        this.h = b.a.a.a(f.a(aVar.f21878a, this.f21877g));
        this.i = new c(aVar.f21879b);
        this.j = b.a.a.a(w.a(aVar.f21878a, this.i));
        this.k = b.a.a.a(com.shopee.app.a.c.a(aVar.f21878a));
        this.l = b.a.a.a(com.shopee.app.a.d.a(aVar.f21878a));
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
        return this.f21872b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f21875e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(e eVar) {
        b(eVar);
    }

    public void a(v vVar) {
        b(vVar);
    }

    public void a(j jVar) {
        b(jVar);
    }

    public void a(g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.ui.gallery.a.c cVar) {
        b(cVar);
    }

    public void a(s sVar) {
        b(sVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f21872b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f21871a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f21873c.get());
        l.a(kVar, d());
        l.a(kVar, this.f21872b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f21871a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f21874d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f21872b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f21871a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f21871a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f21872b.get());
        return aVar;
    }

    private e b(e eVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) eVar, (n) b.a.c.a(this.f21871a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) eVar, (bi) b.a.c.a(this.f21871a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) eVar, (com.shopee.app.application.a.b) b.a.c.a(this.f21871a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) eVar, this.f21876f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) eVar, (com.shopee.app.tracking.f) b.a.c.a(this.f21871a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) eVar, (UserInfo) b.a.c.a(this.f21871a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) eVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) eVar, this.f21872b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) eVar, (com.shopee.app.d.c.f) b.a.c.a(this.f21871a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) eVar, (com.shopee.app.tracking.a) b.a.c.a(this.f21871a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) eVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) eVar, (al) b.a.c.a(this.f21871a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) eVar, (ActionRequiredCounter) b.a.c.a(this.f21871a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) eVar, (ActivityCounter) b.a.c.a(this.f21871a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) eVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) eVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) eVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) eVar, g());
        return eVar;
    }

    private v b(v vVar) {
        x.a(vVar, this.f21873c.get());
        x.a(vVar, j());
        x.a(vVar, this.f21872b.get());
        x.a(vVar, this.k.get());
        x.a(vVar, this.l.get());
        x.a(vVar, (bi) b.a.c.a(this.f21871a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        x.a(vVar, (UserInfo) b.a.c.a(this.f21871a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return vVar;
    }

    private j b(j jVar) {
        l.a(jVar, this.l.get());
        l.a(jVar, l());
        l.a(jVar, this.f21873c.get());
        l.a(jVar, this.f21876f.get());
        l.a(jVar, (UserInfo) b.a.c.a(this.f21871a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return jVar;
    }

    private g b(g gVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (n) b.a.c.a(this.f21871a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (bi) b.a.c.a(this.f21871a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.application.a.b) b.a.c.a(this.f21871a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.f21876f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.tracking.f) b.a.c.a(this.f21871a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (UserInfo) b.a.c.a(this.f21871a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.f21872b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.d.c.f) b.a.c.a(this.f21871a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (com.shopee.app.tracking.a) b.a.c.a(this.f21871a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) gVar, (al) b.a.c.a(this.f21871a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActionRequiredCounter) b.a.c.a(this.f21871a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActivityCounter) b.a.c.a(this.f21871a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, g());
        return gVar;
    }

    private com.shopee.app.ui.gallery.a.c b(com.shopee.app.ui.gallery.a.c cVar) {
        com.shopee.app.ui.gallery.a.e.a(cVar, this.f21873c.get());
        com.shopee.app.ui.gallery.a.e.a(cVar, n());
        com.shopee.app.ui.gallery.a.e.a(cVar, this.f21872b.get());
        com.shopee.app.ui.gallery.a.e.a(cVar, this.k.get());
        com.shopee.app.ui.gallery.a.e.a(cVar, this.l.get());
        com.shopee.app.ui.gallery.a.e.a(cVar, (bi) b.a.c.a(this.f21871a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.gallery.a.e.a(cVar, (UserInfo) b.a.c.a(this.f21871a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return cVar;
    }

    private s b(s sVar) {
        com.shopee.app.ui.common.s.a(sVar, this.f21874d.get());
        u.a(sVar, this.k.get());
        u.a(sVar, this.l.get());
        return sVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f21878a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f21879b;

        private a() {
        }

        public m a() {
            if (this.f21878a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f21879b != null) {
                return new d(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f21878a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f21879b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f21880a;

        b(UserComponent userComponent) {
            this.f21880a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f21880a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f21881a;

        c(UserComponent userComponent) {
            this.f21881a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f21881a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
