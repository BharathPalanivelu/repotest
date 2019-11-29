package com.shopee.app.ui.home.me.editprofile;

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

public final class b implements l {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f22314a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f22315b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f22316c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f22317d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f22318e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f22319f;

    /* renamed from: g  reason: collision with root package name */
    private C0325b f22320g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;

    private b(a aVar) {
        a(aVar);
    }

    public static a c() {
        return new a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f22314a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f22314a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f22314a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f22314a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f22314a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(a aVar) {
        this.f22315b = b.a.a.a(o.a(aVar.f22321a));
        this.f22314a = aVar.f22322b;
        this.f22316c = b.a.a.a(com.shopee.app.a.r.a(aVar.f22321a));
        this.f22317d = b.a.a.a(s.a(aVar.f22321a));
        this.f22318e = b.a.a.a(t.a(aVar.f22321a));
        this.f22319f = b.a.a.a(m.a(aVar.f22321a));
        this.f22320g = new C0325b(aVar.f22322b);
        this.h = b.a.a.a(f.a(aVar.f22321a, this.f22320g));
        this.i = new c(aVar.f22322b);
        this.j = b.a.a.a(w.a(aVar.f22321a, this.i));
        this.k = b.a.a.a(d.a(aVar.f22321a));
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
        return this.f22315b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f22318e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(k kVar) {
        b(kVar);
    }

    public void a(m mVar) {
        b(mVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f22315b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f22314a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f22316c.get());
        l.a(kVar, d());
        l.a(kVar, this.f22315b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f22314a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f22317d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f22315b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f22314a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f22314a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f22315b.get());
        return aVar;
    }

    private k b(k kVar) {
        com.shopee.app.ui.a.f.a((e) kVar, (n) b.a.c.a(this.f22314a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, (bi) b.a.c.a(this.f22314a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, (com.shopee.app.application.a.b) b.a.c.a(this.f22314a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, this.f22319f.get());
        com.shopee.app.ui.a.f.a((e) kVar, (com.shopee.app.tracking.f) b.a.c.a(this.f22314a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, (UserInfo) b.a.c.a(this.f22314a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) kVar, this.f22315b.get());
        com.shopee.app.ui.a.f.a((e) kVar, (com.shopee.app.d.c.f) b.a.c.a(this.f22314a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, (com.shopee.app.tracking.a) b.a.c.a(this.f22314a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) kVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) kVar, (al) b.a.c.a(this.f22314a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) kVar, (ActionRequiredCounter) b.a.c.a(this.f22314a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) kVar, (ActivityCounter) b.a.c.a(this.f22314a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) kVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) kVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) kVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) kVar, g());
        return kVar;
    }

    private m b(m mVar) {
        o.a(mVar, this.k.get());
        return mVar;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f22321a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f22322b;

        private a() {
        }

        public l a() {
            if (this.f22321a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f22322b != null) {
                return new b(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(com.shopee.app.a.b bVar) {
            this.f22321a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f22322b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    /* renamed from: com.shopee.app.ui.home.me.editprofile.b$b  reason: collision with other inner class name */
    private static class C0325b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f22323a;

        C0325b(UserComponent userComponent) {
            this.f22323a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f22323a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f22324a;

        c(UserComponent userComponent) {
            this.f22324a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f22324a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
