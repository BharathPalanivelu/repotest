package com.shopee.app.ui.myaccount;

import android.app.Activity;
import com.shopee.app.a.f;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.q;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.bu;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.ba;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.myaccount.a.b;
import com.shopee.app.ui.myaccount.a.d;
import com.shopee.app.ui.setting.l;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.k.h;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f23322a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f23323b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f23324c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f23325d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f23326e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f23327f;

    /* renamed from: g  reason: collision with root package name */
    private b f23328g;
    private Provider<com.shopee.app.ui.common.a> h;
    private d i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;
    private c l;
    private Provider<RegionConfig> m;

    private a(C0365a aVar) {
        a(aVar);
    }

    public static C0365a c() {
        return new C0365a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f23322a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f23322a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f23322a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f23322a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f23322a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private bt h() {
        return bu.a((n) b.a.c.a(this.f23322a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), (SettingConfigStore) b.a.c.a(this.f23322a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.myaccount.a.a i() {
        return new com.shopee.app.ui.myaccount.a.a(h());
    }

    private void a(C0365a aVar) {
        this.f23323b = b.a.a.a(o.a(aVar.f23329a));
        this.f23322a = aVar.f23330b;
        this.f23324c = b.a.a.a(com.shopee.app.a.r.a(aVar.f23329a));
        this.f23325d = b.a.a.a(s.a(aVar.f23329a));
        this.f23326e = b.a.a.a(t.a(aVar.f23329a));
        this.f23327f = b.a.a.a(m.a(aVar.f23329a));
        this.f23328g = new b(aVar.f23330b);
        this.h = b.a.a.a(f.a(aVar.f23329a, this.f23328g));
        this.i = new d(aVar.f23330b);
        this.j = b.a.a.a(w.a(aVar.f23329a, this.i));
        this.k = b.a.a.a(com.shopee.app.a.d.a(aVar.f23329a));
        this.l = new c(aVar.f23330b);
        this.m = b.a.a.a(q.a(aVar.f23329a, this.l));
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
        return this.f23323b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f23326e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(c cVar) {
        b(cVar);
    }

    public void a(b bVar) {
        b(bVar);
    }

    public void a(com.shopee.app.ui.shopassistant.d dVar) {
        b(dVar);
    }

    public void a(b bVar) {
        b(bVar);
    }

    public void a(l lVar) {
        b(lVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f23323b.get());
        return avatarView;
    }

    private k b(k kVar) {
        com.shopee.app.ui.actionbar.l.a(kVar, (bi) b.a.c.a(this.f23322a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.actionbar.l.a(kVar, this.f23324c.get());
        com.shopee.app.ui.actionbar.l.a(kVar, d());
        com.shopee.app.ui.actionbar.l.a(kVar, this.f23323b.get());
        com.shopee.app.ui.actionbar.l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f23322a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f23325d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f23323b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f23322a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f23322a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f23323b.get());
        return aVar;
    }

    private c b(c cVar) {
        com.shopee.app.ui.a.f.a((e) cVar, (n) b.a.c.a(this.f23322a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (bi) b.a.c.a(this.f23322a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23322a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, this.f23327f.get());
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23322a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (UserInfo) b.a.c.a(this.f23322a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) cVar, this.f23323b.get());
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.d.c.f) b.a.c.a(this.f23322a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23322a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) cVar, (al) b.a.c.a(this.f23322a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActionRequiredCounter) b.a.c.a(this.f23322a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActivityCounter) b.a.c.a(this.f23322a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, g());
        return cVar;
    }

    private b b(b bVar) {
        com.shopee.app.ui.a.f.a((e) bVar, (n) b.a.c.a(this.f23322a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (bi) b.a.c.a(this.f23322a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23322a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.f23327f.get());
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23322a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (UserInfo) b.a.c.a(this.f23322a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) bVar, this.f23323b.get());
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f23322a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23322a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) bVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) bVar, (al) b.a.c.a(this.f23322a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f23322a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f23322a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, g());
        return bVar;
    }

    private com.shopee.app.ui.shopassistant.d b(com.shopee.app.ui.shopassistant.d dVar) {
        com.shopee.app.ui.shopassistant.e.a(dVar, (bi) b.a.c.a(this.f23322a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private b b(b bVar) {
        d.a(bVar, i());
        d.a(bVar, this.f23324c.get());
        d.a(bVar, this.f23323b.get());
        d.a(bVar, (UserInfo) b.a.c.a(this.f23322a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        d.a(bVar, this.f23327f.get());
        d.a(bVar, (h) b.a.c.a(this.f23322a.productUploader(), "Cannot return null from a non-@Nullable component method"));
        d.a(bVar, (ba) b.a.c.a(this.f23322a.productUploadStore(), "Cannot return null from a non-@Nullable component method"));
        d.a(bVar, this.k.get());
        d.a(bVar, (com.shopee.app.d.c.e) b.a.c.a(this.f23322a.cleanTemporaryFilesInteractor(), "Cannot return null from a non-@Nullable component method"));
        return bVar;
    }

    private l b(l lVar) {
        com.shopee.app.ui.a.f.a((e) lVar, (n) b.a.c.a(this.f23322a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) lVar, (bi) b.a.c.a(this.f23322a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) lVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23322a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) lVar, this.f23327f.get());
        com.shopee.app.ui.a.f.a((e) lVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23322a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) lVar, (UserInfo) b.a.c.a(this.f23322a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) lVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) lVar, this.f23323b.get());
        com.shopee.app.ui.a.f.a((e) lVar, (com.shopee.app.d.c.f) b.a.c.a(this.f23322a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) lVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23322a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) lVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) lVar, (al) b.a.c.a(this.f23322a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) lVar, (ActionRequiredCounter) b.a.c.a(this.f23322a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) lVar, (ActivityCounter) b.a.c.a(this.f23322a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) lVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) lVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) lVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) lVar, g());
        return lVar;
    }

    /* renamed from: com.shopee.app.ui.myaccount.a$a  reason: collision with other inner class name */
    public static final class C0365a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f23329a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f23330b;

        private C0365a() {
        }

        public d a() {
            if (this.f23329a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f23330b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0365a a(com.shopee.app.a.b bVar) {
            this.f23329a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0365a a(UserComponent userComponent) {
            this.f23330b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23339a;

        b(UserComponent userComponent) {
            this.f23339a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f23339a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class d implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23363a;

        d(UserComponent userComponent) {
            this.f23363a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f23363a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<RegionConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23345a;

        c(UserComponent userComponent) {
            this.f23345a = userComponent;
        }

        /* renamed from: a */
        public RegionConfigStore get() {
            return (RegionConfigStore) b.a.c.a(this.f23345a.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
