package com.shopee.app.ui.gallery.instagram;

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

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f21922a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f21923b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f21924c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f21925d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f21926e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f21927f;

    /* renamed from: g  reason: collision with root package name */
    private b f21928g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;
    private Provider<com.shopee.app.ui.actionbar.a> l;

    private a(C0322a aVar) {
        a(aVar);
    }

    public static C0322a c() {
        return new C0322a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f21922a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f21922a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f21922a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f21922a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f21922a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private cc h() {
        return cd.a((n) b.a.c.a(this.f21922a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (e) b.a.c.a(this.f21922a.instagramClient(), "Cannot return null from a non-@Nullable component method"));
    }

    private d i() {
        return new d((n) b.a.c.a(this.f21922a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (e) b.a.c.a(this.f21922a.instagramClient(), "Cannot return null from a non-@Nullable component method"), h());
    }

    private void a(C0322a aVar) {
        this.f21923b = b.a.a.a(o.a(aVar.f21929a));
        this.f21922a = aVar.f21930b;
        this.f21924c = b.a.a.a(com.shopee.app.a.r.a(aVar.f21929a));
        this.f21925d = b.a.a.a(s.a(aVar.f21929a));
        this.f21926e = b.a.a.a(t.a(aVar.f21929a));
        this.f21927f = b.a.a.a(m.a(aVar.f21929a));
        this.f21928g = new b(aVar.f21930b);
        this.h = b.a.a.a(f.a(aVar.f21929a, this.f21928g));
        this.i = new c(aVar.f21930b);
        this.j = b.a.a.a(w.a(aVar.f21929a, this.i));
        this.k = b.a.a.a(d.a(aVar.f21929a));
        this.l = b.a.a.a(com.shopee.app.a.c.a(aVar.f21929a));
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
        return this.f21923b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f21926e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(b bVar) {
        b(bVar);
    }

    public void a(f fVar) {
        b(fVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f21923b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f21922a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f21924c.get());
        l.a(kVar, d());
        l.a(kVar, this.f21923b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f21922a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f21925d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f21923b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f21922a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f21922a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f21923b.get());
        return aVar;
    }

    private b b(b bVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (n) b.a.c.a(this.f21922a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (bi) b.a.c.a(this.f21922a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f21922a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.f21927f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f21922a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (UserInfo) b.a.c.a(this.f21922a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.f21923b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f21922a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f21922a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (al) b.a.c.a(this.f21922a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f21922a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f21922a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, g());
        return bVar;
    }

    private f b(f fVar) {
        h.a(fVar, this.f21924c.get());
        h.a(fVar, this.k.get());
        h.a(fVar, i());
        h.a(fVar, this.l.get());
        h.a(fVar, this.f21927f.get());
        h.a(fVar, (UserInfo) b.a.c.a(this.f21922a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return fVar;
    }

    /* renamed from: com.shopee.app.ui.gallery.instagram.a$a  reason: collision with other inner class name */
    public static final class C0322a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f21929a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f21930b;

        private C0322a() {
        }

        public c a() {
            if (this.f21929a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f21930b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0322a a(com.shopee.app.a.b bVar) {
            this.f21929a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0322a a(UserComponent userComponent) {
            this.f21930b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f21931a;

        b(UserComponent userComponent) {
            this.f21931a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f21931a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f21932a;

        c(UserComponent userComponent) {
            this.f21932a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f21932a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
