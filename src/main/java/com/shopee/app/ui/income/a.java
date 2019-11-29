package com.shopee.app.ui.income;

import android.app.Activity;
import com.shopee.app.a.f;
import com.shopee.app.a.m;
import com.shopee.app.a.o;
import com.shopee.app.a.s;
import com.shopee.app.a.t;
import com.shopee.app.a.w;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.bu;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.actionbar.l;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.h;
import com.shopee.app.ui.dialog.j;
import com.shopee.app.ui.follow.search.d;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.income.a.c;
import com.shopee.app.ui.product.add.ae;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f23085a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<ak> f23086b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<bc> f23087c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<i> f23088d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.util.m.a> f23089e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<r> f23090f;

    /* renamed from: g  reason: collision with root package name */
    private b f23091g;
    private Provider<com.shopee.app.ui.common.a> h;
    private c i;
    private Provider<com.shopee.app.tracking.trackingv3.b> j;
    private Provider<Activity> k;

    private a(C0360a aVar) {
        a(aVar);
    }

    public static C0360a c() {
        return new C0360a();
    }

    private k.b d() {
        return new k.b((bi) b.a.c.a(this.f23085a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.d.c.e.a e() {
        return com.shopee.app.d.c.e.b.a((n) b.a.c.a(this.f23085a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.a.a(), new com.shopee.app.data.store.c.c(), (al) b.a.c.a(this.f23085a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private bt f() {
        return bu.a((n) b.a.c.a(this.f23085a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), (SettingConfigStore) b.a.c.a(this.f23085a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.income.b.b g() {
        return new com.shopee.app.ui.income.b.b(e(), f(), (UserInfo) b.a.c.a(this.f23085a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private d h() {
        return new d((n) b.a.c.a(this.f23085a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    private ae i() {
        return new ae((n) b.a.c.a(this.f23085a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.f23085a.uiEventBus(), "Cannot return null from a non-@Nullable component method"), (SearchKeywordsStore) b.a.c.a(this.f23085a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method"), h());
    }

    private com.shopee.app.d.c.c.a j() {
        return com.shopee.app.d.c.c.b.a((n) b.a.c.a(this.f23085a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (ChatBadgeStore) b.a.c.a(this.f23085a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.common.n k() {
        return new com.shopee.app.ui.common.n((al) b.a.c.a(this.f23085a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private com.shopee.app.ui.tracklog.i l() {
        return new com.shopee.app.ui.tracklog.i((al) b.a.c.a(this.f23085a.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(C0360a aVar) {
        this.f23086b = b.a.a.a(o.a(aVar.f23092a));
        this.f23085a = aVar.f23093b;
        this.f23087c = b.a.a.a(com.shopee.app.a.r.a(aVar.f23092a));
        this.f23088d = b.a.a.a(s.a(aVar.f23092a));
        this.f23089e = b.a.a.a(t.a(aVar.f23092a));
        this.f23090f = b.a.a.a(m.a(aVar.f23092a));
        this.f23091g = new b(aVar.f23093b);
        this.h = b.a.a.a(f.a(aVar.f23092a, this.f23091g));
        this.i = new c(aVar.f23093b);
        this.j = b.a.a.a(w.a(aVar.f23092a, this.i));
        this.k = b.a.a.a(com.shopee.app.a.d.a(aVar.f23092a));
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
        return this.f23086b.get();
    }

    public com.shopee.app.util.m.a b() {
        return this.f23089e.get();
    }

    public void a(com.shopee.app.ui.home.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.income.b.d dVar) {
        b(dVar);
    }

    public void a(h hVar) {
        b(hVar);
    }

    public void a(d dVar) {
        b(dVar);
    }

    public void a(c cVar) {
        b(cVar);
    }

    public void a(g gVar) {
        b(gVar);
    }

    public void a(com.shopee.app.ui.income.a.a aVar) {
        b(aVar);
    }

    public void a(com.shopee.app.ui.income.a.h hVar) {
        b(hVar);
    }

    private AvatarView b(AvatarView avatarView) {
        com.shopee.app.ui.common.c.a(avatarView, this.f23086b.get());
        return avatarView;
    }

    private k b(k kVar) {
        l.a(kVar, (bi) b.a.c.a(this.f23085a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        l.a(kVar, this.f23087c.get());
        l.a(kVar, d());
        l.a(kVar, this.f23086b.get());
        l.a(kVar, (com.shopee.app.util.s) b.a.c.a(this.f23085a.featureToggleManager(), "Cannot return null from a non-@Nullable component method"));
        return kVar;
    }

    private MaterialTabView b(MaterialTabView materialTabView) {
        com.shopee.app.ui.common.s.a(materialTabView, this.f23088d.get());
        return materialTabView;
    }

    private com.shopee.app.ui.product.a.a b(com.shopee.app.ui.product.a.a aVar) {
        com.shopee.app.ui.product.a.c.a(aVar, this.f23086b.get());
        return aVar;
    }

    private OptionRow b(OptionRow optionRow) {
        com.shopee.app.ui.home.me.v3.m.a(optionRow, (UserInfo) b.a.c.a(this.f23085a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionRow;
    }

    private OptionBox b(OptionBox optionBox) {
        com.shopee.app.ui.home.me.v3.l.a(optionBox, (UserInfo) b.a.c.a(this.f23085a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return optionBox;
    }

    private com.shopee.app.ui.home.a.a b(com.shopee.app.ui.home.a.a aVar) {
        com.shopee.app.ui.home.a.c.a(aVar, this.f23086b.get());
        return aVar;
    }

    private com.shopee.app.ui.income.b.d b(com.shopee.app.ui.income.b.d dVar) {
        com.shopee.app.ui.income.b.f.a(dVar, g());
        com.shopee.app.ui.income.b.f.a(dVar, this.f23087c.get());
        com.shopee.app.ui.income.b.f.a(dVar, this.f23086b.get());
        return dVar;
    }

    private h b(h hVar) {
        j.a(hVar, i());
        j.a(hVar, this.f23087c.get());
        j.a(hVar, (bi) b.a.c.a(this.f23085a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        return hVar;
    }

    private d b(d dVar) {
        f.a(dVar, (UserInfo) b.a.c.a(this.f23085a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return dVar;
    }

    private c b(c cVar) {
        com.shopee.app.ui.a.f.a((e) cVar, (n) b.a.c.a(this.f23085a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (bi) b.a.c.a(this.f23085a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23085a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, this.f23090f.get());
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23085a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (UserInfo) b.a.c.a(this.f23085a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) cVar, this.f23086b.get());
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.d.c.f) b.a.c.a(this.f23085a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23085a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) cVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) cVar, (al) b.a.c.a(this.f23085a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActionRequiredCounter) b.a.c.a(this.f23085a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, (ActivityCounter) b.a.c.a(this.f23085a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, j());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, k());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) cVar, l());
        return cVar;
    }

    private g b(g gVar) {
        com.shopee.app.ui.a.f.a((e) gVar, (n) b.a.c.a(this.f23085a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, (bi) b.a.c.a(this.f23085a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, (com.shopee.app.application.a.b) b.a.c.a(this.f23085a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, this.f23090f.get());
        com.shopee.app.ui.a.f.a((e) gVar, (com.shopee.app.tracking.f) b.a.c.a(this.f23085a.tracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, (UserInfo) b.a.c.a(this.f23085a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, this.h.get());
        com.shopee.app.ui.a.f.a((e) gVar, this.f23086b.get());
        com.shopee.app.ui.a.f.a((e) gVar, (com.shopee.app.d.c.f) b.a.c.a(this.f23085a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, (com.shopee.app.tracking.a) b.a.c.a(this.f23085a.actionTracker(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.f.a((e) gVar, this.j.get());
        com.shopee.app.ui.a.f.a((e) gVar, (al) b.a.c.a(this.f23085a.loginStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActionRequiredCounter) b.a.c.a(this.f23085a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, (ActivityCounter) b.a.c.a(this.f23085a.activityCounter(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, j());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, this.h.get());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, k());
        com.shopee.app.ui.a.c.a((com.shopee.app.ui.a.b) gVar, l());
        return gVar;
    }

    private com.shopee.app.ui.income.a.a b(com.shopee.app.ui.income.a.a aVar) {
        c.a(aVar, this.f23086b.get());
        c.a(aVar, (be) b.a.c.a(this.f23085a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        c.a(aVar, (UserInfo) b.a.c.a(this.f23085a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    private com.shopee.app.ui.income.a.h b(com.shopee.app.ui.income.a.h hVar) {
        com.shopee.app.ui.income.a.j.a(hVar, this.f23086b.get());
        com.shopee.app.ui.income.a.j.a(hVar, this.k.get());
        com.shopee.app.ui.income.a.j.a(hVar, new com.shopee.app.ui.income.a.f());
        com.shopee.app.ui.income.a.j.a(hVar, this.f23087c.get());
        com.shopee.app.ui.income.a.j.a(hVar, (bi) b.a.c.a(this.f23085a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.income.a.j.a(hVar, (be) b.a.c.a(this.f23085a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.ui.income.a.j.a(hVar, (UserInfo) b.a.c.a(this.f23085a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return hVar;
    }

    /* renamed from: com.shopee.app.ui.income.a$a  reason: collision with other inner class name */
    public static final class C0360a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.a.b f23092a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f23093b;

        private C0360a() {
        }

        public b a() {
            if (this.f23092a == null) {
                throw new IllegalStateException(com.shopee.app.a.b.class.getCanonicalName() + " must be set");
            } else if (this.f23093b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0360a a(com.shopee.app.a.b bVar) {
            this.f23092a = (com.shopee.app.a.b) b.a.c.a(bVar);
            return this;
        }

        public C0360a a(UserComponent userComponent) {
            this.f23093b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23102a;

        b(UserComponent userComponent) {
            this.f23102a = userComponent;
        }

        /* renamed from: a */
        public n get() {
            return (n) b.a.c.a(this.f23102a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f23106a;

        c(UserComponent userComponent) {
            this.f23106a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f23106a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
