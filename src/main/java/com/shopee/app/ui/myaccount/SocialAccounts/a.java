package com.shopee.app.ui.myaccount.SocialAccounts;

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
import com.shopee.app.d.c.an;
import com.shopee.app.d.c.ao;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.bu;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.bh;
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

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f23266a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f23267b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f23268c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f23269d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f23270e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f23271f;

    /* renamed from: g  reason: collision with root package name */
    private b f23272g;
    private Provider<com.shopee.app.ui.common.a> h;
    private d i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;
    private c l;
    private Provider<RegionConfig> m;

    private a(C0364a aVar) {
        a(aVar);
    }

    public static C0364a c() {
        return new C0364a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f23266a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.c.a e() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f23266a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f23266a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n f() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f23266a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i g() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f23266a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private an h() {
        return new an((n) b.a.c.a(this.f23266a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private bt i() {
        return bu.a((n) b.a.c.a(this.f23266a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), (SettingConfigStore) b.a.c.a(this.f23266a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private ao j() {
        return new ao((n) b.a.c.a(this.f23266a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f23266a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.setting.account.a k() {
        return new com.shopee.app.ui.setting.account.a((n) b.a.c.a(this.f23266a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private d l() {
        return new d((n) b.a.c.a(this.f23266a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f23266a.loggedInUser(), "Cannot return null from a non-@Nullable component method"), h(), i(), j(), (e) b.a.c.a(this.f23266a.instagramClient(), "Cannot return null from a non-@Nullable component method"), k());
    }

    private void a(C0364a aVar) {
        this.f23267b = b.a.a.a(o.a(aVar.f23273a));
        this.f23266a = aVar.f23274b;
        this.f23268c = b.a.a.a(com.shopee.app.a.r.a(aVar.f23273a));
        this.f23269d = b.a.a.a(s.a(aVar.f23273a));
        this.f23270e = b.a.a.a(t.a(aVar.f23273a));
        this.f23271f = b.a.a.a(m.a(aVar.f23273a));
        this.f23272g = new b(aVar.f23274b);
        this.h = b.a.a.a(f.a(aVar.f23273a, this.f23272g));
        this.i = new d(aVar.f23274b);
        this.j = b.a.a.a(w.a(aVar.f23273a, this.i));
        this.k = b.a.a.a(com.shopee.app.a.d.a(aVar.f23273a));
        this.l = new c(aVar.f23274b);
        this.m = b.a.a.a(q.a(aVar.f23273a, this.l));
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
        return this.f23267b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f23270e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(c cVar) {
        b(cVar);
    }

    public void a(f fVar) {
        b(fVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f23267b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f23266a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f23268c.get());
        l.a(kVar, d());
        l.a(kVar, this.f23267b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f23266a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f23269d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f23267b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f23266a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f23266a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f23267b.get());
        return aVar;
    }

    private c b(c cVar) {
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (n) b.a.c.a(this.f23266a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (bi) b.a.c.a(this.f23266a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23266a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.f23271f.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23266a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (UserInfo) b.a.c.a(this.f23266a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.h.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.f23267b.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.d.c.f) b.a.c.a(this.f23266a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23266a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, this.j.get());
        com.shopee.app.ui.a.f.a((com.shopee.app.ui.a.e) cVar, (al) b.a.c.a(this.f23266a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActionRequiredCounter) b.a.c.a(this.f23266a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActivityCounter) b.a.c.a(this.f23266a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, e());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, f());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, g());
        return cVar;
    }

    private f b(f fVar) {
        h.a(fVar, this.f23267b.get());
        h.a(fVar, (UserInfo) b.a.c.a(this.f23266a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        h.a(fVar, l());
        h.a(fVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23266a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        h.a(fVar, this.f23268c.get());
        h.a(fVar, this.k.get());
        h.a(fVar, (com.shopee.app.ui.product.twitter.e) b.a.c.a(this.f23266a.twitterClient(), "Cannot return null from a non-@Nullable component method"));
        h.a(fVar, (e) b.a.c.a(this.f23266a.instagramClient(), "Cannot return null from a non-@Nullable component method"));
        h.a(fVar, this.f23271f.get());
        h.a(fVar, new com.shopee.app.h.m());
        h.a(fVar, this.m.get());
        h.a(fVar, (com.shopee.app.util.s) b.a.c.a(this.f23266a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return fVar;
    }

    /* renamed from: com.shopee.app.ui.myaccount.SocialAccounts.a$a  reason: collision with other inner class name */
    public static final class C0364a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f23273a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f23274b;

        private C0364a() {
        }

        public b a() {
            if (this.f23273a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f23274b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0364a a(com.shopee.app.a.b bVar) {
            this.f23273a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0364a a(UserComponent userComponent) {
            this.f23274b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23275a;

        b(UserComponent userComponent) {
            this.f23275a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f23275a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class d implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23277a;

        d(UserComponent userComponent) {
            this.f23277a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f23277a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<RegionConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23276a;

        c(UserComponent userComponent) {
            this.f23276a = userComponent;
        }

        /* renamed from: a */
        public RegionConfigStore get() {
            return (RegionConfigStore) b.a.c.a(this.f23276a.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
