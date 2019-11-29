package com.shopee.app.ui.myaccount.PhoneSettings;

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

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f23230a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f23231b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f23232c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f23233d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f23234e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f23235f;

    /* renamed from: g  reason: collision with root package name */
    private b f23236g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;

    private a(C0363a aVar) {
        a(aVar);
    }

    public static C0363a c() {
        return new C0363a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f23230a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f23230a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f23230a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f23230a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f23230a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private d h() {
        return new d((n) b.a.c.a(this.f23230a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(C0363a aVar) {
        this.f23231b = b.a.a.a(o.a(aVar.f23237a));
        this.f23230a = aVar.f23238b;
        this.f23232c = b.a.a.a(com.shopee.app.a.r.a(aVar.f23237a));
        this.f23233d = b.a.a.a(s.a(aVar.f23237a));
        this.f23234e = b.a.a.a(t.a(aVar.f23237a));
        this.f23235f = b.a.a.a(m.a(aVar.f23237a));
        this.f23236g = new b(aVar.f23238b);
        this.h = b.a.a.a(f.a(aVar.f23237a, this.f23236g));
        this.i = new c(aVar.f23238b);
        this.j = b.a.a.a(w.a(aVar.f23237a, this.i));
        this.k = b.a.a.a(d.a(aVar.f23237a));
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
        return this.f23231b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f23234e.get();
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
        com.shopee.app.ui.common.c.a(avatarView, this.f23231b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f23230a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f23232c.get());
        l.a(kVar, d());
        l.a(kVar, this.f23231b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f23230a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f23233d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f23231b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f23230a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f23230a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f23231b.get());
        return aVar;
    }

    private b b(b bVar) {
        com.shopee.app.ui.a.f.a((e) bVar, (n) b.a.c.a(this.f23230a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (bi) b.a.c.a(this.f23230a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23230a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.f23235f.get());
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23230a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (UserInfo) b.a.c.a(this.f23230a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) bVar, this.f23231b.get());
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f23230a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23230a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) bVar, (al) b.a.c.a(this.f23230a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f23230a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f23230a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, g());
        return bVar;
    }

    private f b(f fVar) {
        h.a(fVar, this.f23231b.get());
        h.a(fVar, (UserInfo) b.a.c.a(this.f23230a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        h.a(fVar, h());
        h.a(fVar, this.f23232c.get());
        h.a(fVar, this.k.get());
        h.a(fVar, this.f23235f.get());
        h.a(fVar, new com.shopee.app.h.m());
        return fVar;
    }

    /* renamed from: com.shopee.app.ui.myaccount.PhoneSettings.a$a  reason: collision with other inner class name */
    public static final class C0363a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f23237a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f23238b;

        private C0363a() {
        }

        public c a() {
            if (this.f23237a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f23238b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0363a a(com.shopee.app.a.b bVar) {
            this.f23237a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0363a a(UserComponent userComponent) {
            this.f23238b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23239a;

        b(UserComponent userComponent) {
            this.f23239a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f23239a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23240a;

        c(UserComponent userComponent) {
            this.f23240a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f23240a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
