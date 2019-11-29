package com.shopee.app.ui.shopassistant.shopProfile;

import android.app.Activity;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.a.f;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.bu;
import com.shopee.app.d.c.cy;
import com.shopee.app.d.c.cz;
import com.shopee.app.d.c.dz;
import com.shopee.app.d.c.ea;
import com.shopee.app.d.c.eh;
import com.shopee.app.d.c.ei;
import com.shopee.app.d.c.ej;
import com.shopee.app.d.c.ek;
import com.shopee.app.d.c.g.d;
import com.shopee.app.d.c.s;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.actionbar.l;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.product.common.ShopCoverControl2;
import com.shopee.app.ui.shopassistant.e;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f25468a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f25469b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f25470c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f25471d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f25472e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f25473f;

    /* renamed from: g  reason: collision with root package name */
    private b f25474g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;
    private Provider<com.shopee.app.ui.actionbar.a> l;

    private a(C0390a aVar) {
        a(aVar);
    }

    public static C0390a c() {
        return new C0390a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f25468a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f25468a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f25468a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f25468a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f25468a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private d h() {
        return new d((n) b.a.c.a(this.f25468a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private bt i() {
        return bu.a((n) b.a.c.a(this.f25468a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), (SettingConfigStore) b.a.c.a(this.f25468a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private ej j() {
        return ek.a((n) b.a.c.a(this.f25468a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f25468a.jobManager(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f25468a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private eh k() {
        return ei.a((n) b.a.c.a(this.f25468a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f25468a.jobManager(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f25468a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private cy l() {
        return cz.a((n) b.a.c.a(this.f25468a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (JobManager) b.a.c.a(this.f25468a.jobManager(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.f25468a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.r m() {
        return s.a((n) b.a.c.a(this.f25468a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ar) b.a.c.a(this.f25468a.app(), "Cannot return null from a non-@Nullable component method"));
    }

    private dz n() {
        return ea.a((n) b.a.c.a(this.f25468a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh());
    }

    private d o() {
        return new d((n) b.a.c.a(this.f25468a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f25468a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f25468a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), h(), i(), j(), k(), (SettingConfigStore) b.a.c.a(this.f25468a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), this.f25469b.get(), l(), m(), n());
    }

    private void a(C0390a aVar) {
        this.f25469b = b.a.a.a(o.a(aVar.f25475a));
        this.f25468a = aVar.f25476b;
        this.f25470c = b.a.a.a(com.shopee.app.a.r.a(aVar.f25475a));
        this.f25471d = b.a.a.a(com.shopee.app.a.s.a(aVar.f25475a));
        this.f25472e = b.a.a.a(t.a(aVar.f25475a));
        this.f25473f = b.a.a.a(m.a(aVar.f25475a));
        this.f25474g = new b(aVar.f25476b);
        this.h = b.a.a.a(f.a(aVar.f25475a, this.f25474g));
        this.i = new c(aVar.f25476b);
        this.j = b.a.a.a(w.a(aVar.f25475a, this.i));
        this.k = b.a.a.a(com.shopee.app.a.d.a(aVar.f25475a));
        this.l = b.a.a.a(com.shopee.app.a.c.a(aVar.f25475a));
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
        return this.f25469b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f25472e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(ShopCoverControl2 shopCoverControl2) {
        b(shopCoverControl2);
    }

    public void a(com.shopee.app.ui.shopassistant.d dVar) {
        b(dVar);
    }

    public void a(b bVar) {
        b(bVar);
    }

    public void a(f fVar) {
        b(fVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f25469b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f25468a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f25470c.get());
        l.a(kVar, d());
        l.a(kVar, this.f25469b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f25468a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f25471d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f25469b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f25468a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f25468a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f25469b.get());
        return aVar;
    }

    private ShopCoverControl2 b(ShopCoverControl2 shopCoverControl2) {
        com.shopee.app.ui.product.common.c.a(shopCoverControl2, (bi) b.a.c.a(this.f25468a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return shopCoverControl2;
    }

    private com.shopee.app.ui.shopassistant.d b(com.shopee.app.ui.shopassistant.d dVar) {
        e.a(dVar, (bi) b.a.c.a(this.f25468a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private b b(b bVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (n) b.a.c.a(this.f25468a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (bi) b.a.c.a(this.f25468a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.application.a.b) b.a.c.a(this.f25468a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.f25473f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.f) b.a.c.a(this.f25468a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (UserInfo) b.a.c.a(this.f25468a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.f25469b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.d.c.f) b.a.c.a(this.f25468a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (com.shopee.app.tracking.a) b.a.c.a(this.f25468a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) bVar, (al) b.a.c.a(this.f25468a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActionRequiredCounter) b.a.c.a(this.f25468a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, (ActivityCounter) b.a.c.a(this.f25468a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) bVar, g());
        return bVar;
    }

    private f b(f fVar) {
        h.a(fVar, this.f25473f.get());
        h.a(fVar, o());
        h.a(fVar, this.f25470c.get());
        h.a(fVar, this.f25469b.get());
        h.a(fVar, new com.shopee.app.h.m());
        h.a(fVar, this.k.get());
        h.a(fVar, (be) b.a.c.a(this.f25468a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        h.a(fVar, this.l.get());
        h.a(fVar, (UserInfo) b.a.c.a(this.f25468a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return fVar;
    }

    /* renamed from: com.shopee.app.ui.shopassistant.shopProfile.a$a  reason: collision with other inner class name */
    public static final class C0390a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f25475a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f25476b;

        private C0390a() {
        }

        public c a() {
            if (this.f25475a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f25476b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0390a a(com.shopee.app.a.b bVar) {
            this.f25475a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0390a a(UserComponent userComponent) {
            this.f25476b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25477a;

        b(UserComponent userComponent) {
            this.f25477a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f25477a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f25478a;

        c(UserComponent userComponent) {
            this.f25478a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f25478a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
